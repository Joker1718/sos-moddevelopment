/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormation;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.formation.DivPlacability;
/*     */ import game.battle.formation.DivPositionImp;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.PathGame;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ToolsWalk
/*     */ {
/*  28 */   private final VectorImp vec = new VectorImp();
/*  29 */   private final VectorImp vec2 = new VectorImp();
/*     */   
/*     */   private final Tools t;
/*     */   
/*     */   public static final int destMoveStart = 90;
/*     */   
/*     */   public static final int destMoveResume = 80;
/*     */   
/*     */   private final PathGame.PathFancy pp;
/*     */ 
/*     */   
/*     */   public boolean setStart(int tilesCheckDest) {
/*  41 */     PathTile c = getStart();
/*     */     
/*  43 */     if (c == null) {
/*  44 */       return false;
/*     */     }
/*  46 */     int sx = (c.x() << 6) + 32;
/*  47 */     int sy = (c.y() << 6) + 32;
/*     */ 
/*     */ 
/*     */     
/*  51 */     if (c.getParent() != null) {
/*  52 */       PathTile p = c.getParent();
/*  53 */       c.parentSet(null);
/*  54 */       c = reverse(c, p);
/*     */     } 
/*     */     
/*  57 */     if (c.getParent() != null) {
/*  58 */       c = c.getParent();
/*     */     }
/*     */ 
/*     */     
/*  62 */     this.pp.clear();
/*  63 */     this.pp.set(c);
/*     */ 
/*     */     
/*  66 */     BattleOrderUpdater.Plan.path.clear();
/*  67 */     COORDINATE dest = this.t.div.getSafeCentrePixel(BattleOrderUpdater.Plan.dest);
/*  68 */     int destX = dest.x() >> 6;
/*  69 */     int destY = dest.y() >> 6;
/*  70 */     BattleOrderUpdater.Plan.path.init(sx, sy, this.pp, destX, destY, this.t.pathCost, BattleOrderUpdater.Plan.a, BattleOrderUpdater.Plan.div.race());
/*  71 */     BattleOrderUpdater.Plan.order.path.set(BattleOrderUpdater.Plan.path);
/*     */     
/*  73 */     if (BattleOrderUpdater.Plan.path.isDest())
/*     */     {
/*  75 */       return false;
/*     */     }
/*  77 */     boolean b = setStartPosition(tilesCheckDest);
/*  78 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   private PathTile reverse(PathTile newParent, PathTile t) {
/*  83 */     if (t.getParent() == null) {
/*  84 */       t.parentSet(newParent);
/*  85 */       return t;
/*     */     } 
/*  87 */     PathTile res = reverse(t, t.getParent());
/*  88 */     t.parentSet(newParent);
/*  89 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private PathTile getStart() {
/*  95 */     if (BattleOrderUpdater.Plan.dest.deployed() <= 0 || BattleOrderUpdater.Plan.dest.centreTile() == null || BattleOrderUpdater.Plan.current.deployed() <= 0) {
/*  96 */       return null;
/*     */     }
/*     */     
/*  99 */     int destX = BattleOrderUpdater.Plan.dest.centreTile().x();
/* 100 */     int destY = BattleOrderUpdater.Plan.dest.centreTile().y();
/*     */     
/* 102 */     if (!SETT.IN_BOUNDS(destX, destY)) {
/* 103 */       return null;
/*     */     }
/* 105 */     COORDINATE pp = this.t.div.getSafeCentrePixel(BattleOrderUpdater.Plan.prev);
/*     */     
/* 107 */     PathUtilOnline.Flooder f = this.t.pather.getFlooder();
/* 108 */     f.init(this);
/*     */     int i;
/* 110 */     for (i = 0; i < BattleOrderUpdater.Plan.current.deployed(); i++) {
/* 111 */       if (BattleOrderUpdater.Plan.div.reporter.reachable(i)) {
/* 112 */         double dist = 0.0D;
/* 113 */         if (pp != null) {
/* 114 */           dist = pp.tileDistanceTo(BattleOrderUpdater.Plan.current.pixel(i));
/* 115 */           dist *= 0.015625D;
/*     */         } 
/* 117 */         f.pushSloppy(BattleOrderUpdater.Plan.current.tile(i), dist);
/* 118 */         f.setValue2(BattleOrderUpdater.Plan.current.tile(i), dist);
/*     */       } 
/*     */     } 
/*     */     
/* 122 */     if (!f.hasMore()) {
/* 123 */       for (i = 0; i < BattleOrderUpdater.Plan.current.deployed(); i++) {
/* 124 */         double dist = 0.0D;
/* 125 */         if (pp != null) {
/* 126 */           dist = pp.tileDistanceTo(BattleOrderUpdater.Plan.current.pixel(i));
/* 127 */           dist *= 0.015625D;
/*     */         } 
/* 129 */         f.pushSloppy(BattleOrderUpdater.Plan.current.tile(i), dist);
/* 130 */         f.setValue2(BattleOrderUpdater.Plan.current.tile(i), dist);
/*     */       } 
/*     */     }
/*     */     
/* 134 */     while (f.hasMore()) {
/* 135 */       PathTile t = f.pollSmallest();
/* 136 */       if (t.isSameAs(destX, destY)) {
/* 137 */         f.done();
/*     */         
/* 139 */         return startReturn(t);
/*     */       } 
/*     */       
/* 142 */       for (int j = 0; j < DIR.ALL.size(); j++) {
/* 143 */         DIR d = (DIR)DIR.ALL.get(j);
/* 144 */         int dx = t.x() + d.x();
/* 145 */         int dy = t.y() + d.y();
/* 146 */         if (SETT.IN_BOUNDS(dx, dy)) {
/* 147 */           double cost = this.t.pathCost.cost(t.x(), t.y(), d);
/* 148 */           if (cost >= 0.0D) {
/*     */             
/* 150 */             cost *= ((DIR)DIR.ALL.get(j)).tileDistance();
/*     */             
/* 152 */             double di = COORDINATE.tileDistance(dx, dy, destX, destY);
/* 153 */             if (f.pushSmaller(dx, dy, t.getValue2() + cost + di, t) != null) {
/* 154 */               f.setValue2(dx, dy, t.getValue2() + cost);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 160 */     f.done();
/*     */     
/* 162 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private PathTile startReturn(PathTile t) {
/* 167 */     if (t.getParent() != null) {
/* 168 */       PathTile p = t.getParent();
/* 169 */       t.parentSet(null);
/* 170 */       t = reverse(t, p);
/*     */     } 
/*     */     
/* 173 */     if (t.getParent() != null)
/* 174 */       t = t.getParent(); 
/* 175 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean setStartPosition(int fDistance) {
/* 180 */     BattleOrderUpdater.Plan.path.dCount = 0;
/* 181 */     if (!setNextPosition(fDistance, 0))
/* 182 */       return false; 
/* 183 */     int bestI = -1;
/* 184 */     double bestDist = 2.147483647E9D;
/*     */     
/* 186 */     for (int i = 0; i < BattleOrderUpdater.Plan.current.deployed(); i++) {
/* 187 */       if (BattleOrderUpdater.Plan.div.reporter.reachable(i)) {
/* 188 */         double dist = BattleOrderUpdater.Plan.current.pixel(i).tileDistanceTo(BattleOrderUpdater.Plan.path.x(), BattleOrderUpdater.Plan.path.y());
/*     */         
/* 190 */         if (dist < bestDist) {
/* 191 */           bestDist = dist;
/* 192 */           bestI = i;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 199 */     if (bestI >= 0) {
/* 200 */       bestDist = 2.147483647E9D;
/* 201 */       int bestPos = -1;
/* 202 */       for (int j = 0; j < BattleOrderUpdater.Plan.prev.deployed() && j < BattleOrderUpdater.Plan.current.deployed(); j++) {
/* 203 */         double dist = BattleOrderUpdater.Plan.prev.pixel(j).tileDistanceTo(BattleOrderUpdater.Plan.current.pixel(bestI));
/* 204 */         if (dist < bestDist) {
/* 205 */           bestDist = dist;
/* 206 */           bestPos = j;
/*     */         } 
/*     */       } 
/*     */       
/* 210 */       if (bestPos >= 0) {
/* 211 */         BattleOrderUpdater.Plan.prev.swap(bestPos, bestI);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 218 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNextPosition(int fDistance, int millis) {
/* 225 */     DivFormationImp pos = getNextPosition(fDistance, millis);
/*     */     
/* 227 */     if (pos == null) {
/* 228 */       return false;
/*     */     }
/*     */     
/* 231 */     BattleOrderUpdater.Plan.nextPos = pos;
/* 232 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private DivFormationImp getNextPosition(int fDistance, int millis) {
/* 238 */     int ii = BattleOrderUpdater.Plan.path.currentI();
/* 239 */     for (int i = 0; i < 7; i++) {
/* 240 */       if ((SETT.PATH()).solidity.is(BattleOrderUpdater.Plan.path.x() >> 6, BattleOrderUpdater.Plan.path.y() >> 6)) {
/* 241 */         BattleOrderUpdater.Plan.path.setCurrentI(ii);
/* 242 */         return null;
/*     */       } 
/* 244 */       if (BattleOrderUpdater.Plan.path.isDest())
/*     */         break; 
/* 246 */       BattleOrderUpdater.Plan.path.currentIInc(1);
/*     */     } 
/* 248 */     BattleOrderUpdater.Plan.path.setCurrentI(ii);
/*     */ 
/*     */     
/* 251 */     int prevX = BattleOrderUpdater.Plan.path.x();
/* 252 */     int prevY = BattleOrderUpdater.Plan.path.y();
/* 253 */     BattleOrderUpdater.Plan.path.currentIInc(1);
/* 254 */     int cx = BattleOrderUpdater.Plan.path.x();
/* 255 */     int cy = BattleOrderUpdater.Plan.path.y();
/*     */     
/* 257 */     double m = this.vec.set(prevX, prevY, cx, cy);
/*     */     
/* 259 */     double old = BattleOrderUpdater.Plan.path.dCount;
/* 260 */     BattleOrderUpdater.Plan.path.dCount += millis;
/* 261 */     double dd = BattleOrderUpdater.Plan.path.dCount - old;
/* 262 */     if (dd > 0.0D && BattleOrderUpdater.Plan.path.dCount >= 0 && BattleOrderUpdater.Plan.path.dCount < m) {
/* 263 */       BattleOrderUpdater.Plan.path.currentIInc(-1);
/*     */       
/* 265 */       int j = (int)(this.vec.nX() * dd);
/* 266 */       int k = (int)(this.vec.nY() * dd);
/*     */       
/* 268 */       if (tryStep(j, k)) {
/* 269 */         BattleOrderUpdater.Plan.order.path.set(BattleOrderUpdater.Plan.path);
/* 270 */         return BattleOrderUpdater.Plan.prev;
/*     */       } 
/*     */     } else {
/* 273 */       BattleOrderUpdater.Plan.path.dCount = 0;
/*     */     } 
/*     */     
/* 276 */     BattleOrderUpdater.Plan.order.path.set(BattleOrderUpdater.Plan.path);
/*     */ 
/*     */     
/* 279 */     int dx = (int)(this.vec.nX() * m);
/* 280 */     int dy = (int)(this.vec.nY() * m);
/* 281 */     this.vec.rotate90();
/*     */     
/* 283 */     if (BattleOrderUpdater.Plan.prev.deployed() == BattleOrderUpdater.Plan.men && this.vec.nX() * BattleOrderUpdater.Plan.prev.dx() > 0.9D && this.vec.nY() * BattleOrderUpdater.Plan.prev.dy() > 0.9D && 
/* 284 */       tryStep(dx, dy)) {
/* 285 */       return BattleOrderUpdater.Plan.prev;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 294 */     int w = getWidth(fDistance);
/*     */     
/* 296 */     double nX = this.vec.nX();
/* 297 */     double nY = this.vec.nY();
/*     */     
/* 299 */     DivFormationImp pos = this.t.deployer.deployCentre((DIV_SPEC)BattleOrderUpdater.Plan.div.info, BattleOrderUpdater.Plan.men, BattleOrderUpdater.Plan.dest.formation(), cx, cy, nX, nY, w, BattleOrderUpdater.Plan.a);
/*     */     
/* 301 */     if (pos == null) {
/* 302 */       return null;
/*     */     }
/* 304 */     BattleOrderUpdater.Plan.prev.copy(this.t.mover.getFromMovedIntoTo((DivPositionImp)BattleOrderUpdater.Plan.prev, pos));
/* 305 */     return BattleOrderUpdater.Plan.prev;
/*     */   }
/*     */   
/*     */   private int getWidth(int fDistance) {
/* 309 */     if (BattleOrderUpdater.Plan.path.tilesToDest() <= fDistance && canMoveAllTheWayToDest()) {
/* 310 */       return BattleOrderUpdater.Plan.dest.width() / BattleOrderUpdater.Plan.dest.formation().size(BattleOrderUpdater.Plan.div);
/*     */     }
/* 312 */     Div o = BattleOrderUpdater.Plan.div.status().enemyClosest();
/* 313 */     if (o != null) {
/* 314 */       DivFormation other = o.position();
/* 315 */       if (other.deployed() > 0 && other.centrePixel() != null && BattleOrderUpdater.Plan.prev.centrePixel() != null && 
/* 316 */         other.centrePixel().tileDistanceTo(BattleOrderUpdater.Plan.prev.centrePixel()) < 1280.0D) {
/* 317 */         return BattleOrderUpdater.Plan.dest.width() / BattleOrderUpdater.Plan.dest.formation().size(BattleOrderUpdater.Plan.div);
/*     */       }
/*     */     } 
/* 320 */     if (BattleOrderUpdater.Plan.prev.deployed() > 0 && this.t.div.inPosition(BattleOrderUpdater.Plan.current, BattleOrderUpdater.Plan.prev, 64.0D) > (BattleOrderUpdater.Plan.men - BattleOrderUpdater.Plan.unreachable) / 2 && 
/* 321 */       Math.abs(BattleOrderUpdater.Plan.dest.width() - BattleOrderUpdater.Plan.prev.width()) < 192) {
/* 322 */       return BattleOrderUpdater.Plan.prev.width() / BattleOrderUpdater.Plan.prev.formation().size(BattleOrderUpdater.Plan.div);
/*     */     }
/*     */ 
/*     */     
/* 326 */     int w = (int)Math.ceil(Math.sqrt(BattleOrderUpdater.Plan.men / 2.0D));
/* 327 */     if (w % 2 == 0)
/* 328 */       w++; 
/* 329 */     return w;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean tryStep(int dx, int dy) {
/* 335 */     for (int i = 0; i < BattleOrderUpdater.Plan.prev.deployed(); i++) {
/* 336 */       int x = BattleOrderUpdater.Plan.prev.pixel(i).x() + dx;
/* 337 */       int y = BattleOrderUpdater.Plan.prev.pixel(i).y() + dy;
/* 338 */       int tx = x >> 6;
/* 339 */       int ty = y >> 6;
/* 340 */       AVAILABILITY av = (SETT.PATH()).availability.get(tx, ty);
/* 341 */       if (av != null && (SETT.PATH()).availability.get(tx, ty).isSolid(BattleOrderUpdater.Plan.a)) {
/* 342 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 346 */     BattleOrderUpdater.Plan.prev.move(dx, dy);
/* 347 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canMoveAllTheWayToDest() {
/* 352 */     if (BattleOrderUpdater.Plan.path.length() == 0) {
/* 353 */       return true;
/*     */     }
/* 355 */     int pi = BattleOrderUpdater.Plan.path.currentI();
/* 356 */     while (!BattleOrderUpdater.Plan.path.isDest()) {
/* 357 */       if (!checkStep(BattleOrderUpdater.Plan.path.x(), BattleOrderUpdater.Plan.path.y())) {
/* 358 */         BattleOrderUpdater.Plan.path.setCurrentI(pi);
/* 359 */         return false;
/*     */       } 
/* 361 */       BattleOrderUpdater.Plan.path.currentIInc(1);
/*     */     } 
/*     */     
/* 364 */     if (BattleOrderUpdater.Plan.path.isComplete()) {
/* 365 */       BattleOrderUpdater.Plan.path.setCurrentI(pi);
/* 366 */       return true;
/*     */     } 
/*     */     
/* 369 */     int sx = BattleOrderUpdater.Plan.path.x();
/* 370 */     int sy = BattleOrderUpdater.Plan.path.y();
/*     */     
/* 372 */     BattleOrderUpdater.Plan.path.setCurrentI(pi);
/* 373 */     return canMoveAllTheWayToDest(sx, sy);
/*     */   }
/*     */   
/*     */   private boolean canMoveAllTheWayToDest(int sx, int sy) {
/* 377 */     int dx = BattleOrderUpdater.Plan.dest.centrePixel().x();
/* 378 */     int dy = BattleOrderUpdater.Plan.dest.centrePixel().y();
/* 379 */     double m = this.vec2.set(sx, sy, dx, dy);
/* 380 */     int steps = (int)Math.ceil(m / 64.0D);
/* 381 */     for (int i = 0; i < steps; i++) {
/* 382 */       int tx = (int)(sx + this.vec2.nX() * i * 64.0D);
/* 383 */       int ty = (int)(sy + this.vec2.nY() * i * 64.0D);
/* 384 */       if (!checkStep(tx, ty))
/* 385 */         return false; 
/*     */     } 
/* 387 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean checkStep(int cx, int cy) {
/* 392 */     int size = BattleOrderUpdater.Plan.dest.formation().size(BattleOrderUpdater.Plan.div);
/* 393 */     double x1 = cx - BattleOrderUpdater.Plan.dest.dx() * BattleOrderUpdater.Plan.dest.width() / 2.0D;
/* 394 */     double y1 = cy - BattleOrderUpdater.Plan.dest.dy() * BattleOrderUpdater.Plan.dest.width() / 2.0D;
/* 395 */     int am = BattleOrderUpdater.Plan.dest.width() / size;
/* 396 */     for (int i = 0; i < am; i++) {
/* 397 */       if (DivPlacability.pixelIsBlocked((int)x1, (int)y1, size, BattleOrderUpdater.Plan.a))
/* 398 */         return false; 
/* 399 */       x1 += BattleOrderUpdater.Plan.dest.dx() * size;
/* 400 */       y1 += BattleOrderUpdater.Plan.dest.dy() * size;
/*     */     } 
/* 402 */     return true;
/*     */   }
/*     */   ToolsWalk(Tools t) {
/* 405 */     this.pp = new PathGame.PathFancy(4096);
/*     */     this.t = t;
/*     */   } public boolean hasReachedPrev() {
/* 408 */     int am = this.t.walk.countPosition();
/* 409 */     int lim = (int)Math.ceil(0.9D * (BattleOrderUpdater.Plan.men - BattleOrderUpdater.Plan.div.reporter.unreachable()));
/* 410 */     if (am == 0)
/* 411 */       return false; 
/* 412 */     if (am < lim)
/* 413 */       return false; 
/* 414 */     return true;
/*     */   }
/*     */   
/*     */   public int countPosition() {
/* 418 */     int dist = (BattleOrderUpdater.Plan.div.settings()).running ? 64 : 32;
/* 419 */     return this.t.div.inPosition(BattleOrderUpdater.Plan.current, BattleOrderUpdater.Plan.prev, dist);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\ToolsWalk.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */