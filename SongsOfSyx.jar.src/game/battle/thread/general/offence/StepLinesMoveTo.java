/*     */ package game.battle.thread.general.offence;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DIV_FORMATION;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.thread.general.StrategosUtil;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.util.Copyable;
/*     */ import init.constant.Config;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class StepLinesMoveTo
/*     */ {
/*     */   private final Bitmap1D deployed;
/*     */   private final int[] dists;
/*     */   private final int[] distsToBlob;
/*     */   private final StrategosUtil util;
/*  36 */   private final int maxRange = 1000;
/*     */   private final Context c;
/*     */   private final ContextLines lines;
/*     */   private final Bitmap2D blob;
/*     */   private final Bitmap2D penalty;
/*     */   private final UtilDivMap map;
/*  42 */   private final DivDeploment[] dall = new DivDeploment[(Config.battle()).DIVISIONS_PER_ARMY];
/*  43 */   private final ArrayList<DivDeploment> toDeploy = new ArrayList(this.dall.length);
/*  44 */   private final VectorImp vec = new VectorImp();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final BattleOrderTask task;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {
/*  61 */     for (int i = 0; i < this.lines.lines(); i++) {
/*  62 */       ContextLines.Line l = this.lines.get(i);
/*  63 */       l.back = 0;
/*     */     } 
/*  65 */     this.map.clear();
/*     */     
/*  67 */     this.penalty.clear();
/*  68 */     PathUtilOnline.Flooder f = this.util.flooder.getFlooder();
/*  69 */     f.init(this);
/*  70 */     for (int ty = 0; ty < SETT.THEIGHT; ty++) {
/*  71 */       for (int tx = 0; tx < SETT.TWIDTH; tx++) {
/*  72 */         if (this.blob.is(tx, ty)) {
/*  73 */           f.pushSloppy(tx, ty, 0.0D);
/*     */         }
/*     */       } 
/*     */     } 
/*  77 */     while (f.hasMore()) {
/*  78 */       PathTile t = f.pollSmallest();
/*  79 */       if (t.getValue() >= 24.0F) {
/*     */         break;
/*     */       }
/*  82 */       this.penalty.set((COORDINATE)t, true);
/*     */       
/*  84 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/*  85 */         DIR d = (DIR)DIR.ALL.get(di);
/*  86 */         int dx = t.x() + d.x();
/*  87 */         int dy = t.y() + d.y();
/*  88 */         if (SETT.IN_BOUNDS(dx, dy))
/*     */         {
/*  90 */           f.pushSmaller(dx, dy, d.tileDistance() + t.getValue(), t);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     f.done();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean deployDivsToLine() {
/* 100 */     fillLines(false);
/* 101 */     return deploy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean deployDivsToLineRanged() {
/* 107 */     fillLines(true);
/* 108 */     return deploy();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean setSpeedAndFormation() {
/* 113 */     double dist = 0.0D;
/* 114 */     int am = 0;
/* 115 */     int fighters = 0;
/* 116 */     double tot = 0.0D; int i;
/* 117 */     for (i = 0; i < (Config.battle()).DIVISIONS_PER_ARMY; i++) {
/* 118 */       if (this.deployed.get(i)) {
/*     */         
/* 120 */         dist += this.dists[i];
/* 121 */         am++;
/*     */       } 
/* 123 */       Div d = (Div)this.util.getArmy().divisions().get(i);
/* 124 */       int m = d.menNrOf();
/* 125 */       if (d.status().engagements() > 1)
/* 126 */         fighters += m; 
/* 127 */       tot += m;
/*     */     } 
/*     */     
/* 130 */     if (am == 0) {
/* 131 */       return false;
/*     */     }
/* 133 */     dist /= am;
/*     */     
/* 135 */     dist += 16.0D;
/*     */     
/* 137 */     dist -= dist * fighters / tot;
/*     */     
/* 139 */     for (i = 0; i < (Config.battle()).DIVISIONS_PER_ARMY; i++) {
/* 140 */       if (this.deployed.get(i)) {
/* 141 */         Div d = (Div)this.util.getArmy().divisions().get(i);
/* 142 */         (d.settings()).running = (this.dists[i] > dist);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 148 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean deploy() {
/* 153 */     if (this.toDeploy.size() == 0) {
/* 154 */       return false;
/*     */     }
/* 156 */     for (DivDeploment d : this.toDeploy) {
/*     */       
/* 158 */       if (d.dir == null) {
/* 159 */         if (d.l.deploy(this.util, d.div) != null) {
/* 160 */           this.deployed.set(d.div.indexArmy(), true);
/*     */           continue;
/*     */         } 
/* 163 */         d.l.back = -1;
/*     */         continue;
/*     */       } 
/* 166 */       this.deployed.set(d.div.indexArmy(), true);
/* 167 */       DivFormationImp f = this.util.divDeployer.deployTile(d.div, d.cx, d.cy, d.dir);
/* 168 */       if (f != null) {
/* 169 */         for (int i = 0; i < f.deployed(); i++) {
/* 170 */           for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 171 */             DIR dir = (DIR)DIR.ORTHO.get(di);
/* 172 */             this.penalty.set(f.tile(i).x() + 8 * dir.x(), f.tile(i).y() + 8 * dir.y(), true);
/*     */           } 
/* 174 */           this.penalty.set(f.tile(i), true);
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 182 */     return true;
/*     */   }
/*     */   
/*     */   private void fillLines(boolean ranged) {
/* 186 */     PathUtilOnline.Flooder f = this.util.flooder.getFlooder();
/*     */     
/* 188 */     int ll = 0;
/*     */ 
/*     */ 
/*     */     
/* 192 */     f.init(this);
/* 193 */     for (int i = 0; i < this.lines.lines(); i++) {
/* 194 */       ContextLines.Line l = this.lines.get(i);
/* 195 */       if (l.back >= 0) {
/* 196 */         l.mark = 0;
/* 197 */         int cx = l.cx();
/* 198 */         int cy = l.cy();
/*     */         
/* 200 */         this.vec.set(l.dx, l.dy);
/* 201 */         this.vec.rotate90();
/*     */         
/* 203 */         cx = (int)(cx + this.vec.nX() * l.back);
/* 204 */         cy = (int)(cy + this.vec.nY() * l.back);
/* 205 */         cx /= 64;
/* 206 */         cy /= 64;
/* 207 */         int pe = penalty(l, ranged);
/*     */         
/* 209 */         if (SETT.IN_BOUNDS(cx, cy)) {
/* 210 */           f.pushSloppy(cx, cy, pe);
/* 211 */           f.setValue2(cx, cy, i);
/* 212 */           ll++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 218 */     if (ll == 0) {
/* 219 */       f.done();
/*     */       
/*     */       return;
/*     */     } 
/* 223 */     this.toDeploy.clearSloppy();
/* 224 */     this.map.clear();
/*     */     
/* 226 */     int am = 0;
/*     */     
/* 228 */     for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/* 229 */       Div d = (Div)this.util.getArmy().divisions().get(di);
/* 230 */       if (valid(d, ranged)) {
/* 231 */         this.map.add(d);
/* 232 */         am++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 237 */     if (am == 0) {
/* 238 */       f.done();
/*     */       
/*     */       return;
/*     */     } 
/* 242 */     while (f.hasMore()) {
/*     */       
/* 244 */       PathTile t = f.pollSmallest();
/* 245 */       if (t.getValue() > 1000.0F) {
/*     */         break;
/*     */       }
/* 248 */       ContextLines.Line l = this.lines.get((int)t.getValue2());
/* 249 */       if (l.mark != 0) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 254 */       LIST<Div> ddd = this.map.get(t.x(), t.y());
/* 255 */       if (ddd.size() > 0)
/*     */       {
/* 257 */         for (Div m : ddd) {
/* 258 */           l.mark = 1;
/* 259 */           DivDeploment dd = this.dall[this.toDeploy.size()];
/* 260 */           init(m, l, t, dd, ranged);
/* 261 */           this.toDeploy.add(dd);
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 266 */       for (int j = 0; j < DIR.ALL.size(); j++) {
/* 267 */         DIR dir = (DIR)DIR.ALL.get(j);
/* 268 */         int dx = t.x() + dir.x();
/* 269 */         int dy = t.y() + dir.y();
/* 270 */         if (SETT.IN_BOUNDS(dx, dy)) {
/* 271 */           double cost = cost(dx, dy);
/* 272 */           if (cost > 0.0D && 
/* 273 */             f.pushSmaller(dx, dy, t.getValue() + dir.tileDistance() * cost, t) != null) {
/* 274 */             f.setValue2(dx, dy, t.getValue2());
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 283 */     f.done();
/*     */   }
/*     */   
/*     */   private int penalty(ContextLines.Line l, boolean ranged) {
/* 287 */     return (int)(l.back * 0.015625D * (1.0D + (ranged ? (1.0D * this.c.flanking) : (2.0D * this.c.flanking))));
/*     */   }
/*     */ 
/*     */   
/*     */   private void init(Div div, ContextLines.Line line, PathTile t, DivDeploment dd, boolean ranged) {
/* 292 */     dd.dir = null;
/* 293 */     dd.div = div;
/* 294 */     dd.l = line;
/*     */ 
/*     */     
/* 297 */     double dist = (t.getValue() - penalty(line, ranged));
/*     */ 
/*     */     
/* 300 */     PathTile p = t;
/* 301 */     while (p.getParent() != null) {
/* 302 */       if (this.penalty.is((COORDINATE)p))
/* 303 */         dist -= 10.0D * DIR.get((COORDINATE)p, (COORDINATE)p.getParent()).tileDistance(); 
/* 304 */       p = p.getParent();
/*     */     } 
/* 306 */     this.dists[div.indexArmy()] = (int)dist;
/* 307 */     this.distsToBlob[div.indexArmy()] = (int)(line.blobID * 0.015625D);
/* 308 */     DIV_FORMATION f = DIV_FORMATION.LOOSE;
/*     */     
/* 310 */     PathTile start = t;
/* 311 */     t = setDest(t);
/*     */     
/* 313 */     if (t.getParent() == null) {
/*     */       
/* 315 */       t = avoidWalkingThroughBlobDest(div, start);
/* 316 */       if (t != null && t.getParent() != null) {
/* 317 */         dd.cx = t.x();
/* 318 */         dd.cy = t.y();
/* 319 */         dd.dir = DIR.get((COORDINATE)t, (COORDINATE)t.getParent());
/* 320 */       } else if (this.dists[div.indexArmy()] + line.blobID * 0.015625D < 32.0D) {
/* 321 */         f = DIV_FORMATION.TIGHT;
/*     */       } 
/*     */     } else {
/*     */       
/* 325 */       dd.cx = t.x();
/* 326 */       dd.cy = t.y();
/* 327 */       dd.dir = DIR.get((COORDINATE)t, (COORDINATE)t.getParent());
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 332 */     (div.settings()).formation = f;
/*     */   }
/*     */ 
/*     */   
/*     */   public StepLinesMoveTo(StrategosUtil context, Context c) {
/* 337 */     this.task = new BattleOrderTask(); this.c = c; this.util = context; this.lines = c.lines; this.map = c.map; this.blob = c.blob; for (int i = 0; i < this.dall.length; i++)
/*     */       this.dall[i] = new DivDeploment();  this.deployed = c.deployedToLine; this.dists = c.distsToLine;
/*     */     this.distsToBlob = c.distsFromLineToBlob;
/* 340 */     this.penalty = c.block; } private boolean valid(Div d, boolean ranged) { if (!d.active())
/* 341 */       return false; 
/* 342 */     if (this.deployed.get(d.indexArmy()))
/* 343 */       return false; 
/* 344 */     if (ranged && d.settings().ammo() == null)
/* 345 */       return false; 
/* 346 */     if (!ranged && d.settings().ammo() != null) {
/* 347 */       return false;
/*     */     }
/* 349 */     (d.order()).task.get((Copyable)this.task);
/*     */     
/* 351 */     if (this.task.task() != BattleOrderTask.DIVTASK.MOVE && this.task.task() != BattleOrderTask.DIVTASK.STOP) {
/* 352 */       return false;
/*     */     }
/* 354 */     return true; }
/*     */ 
/*     */ 
/*     */   
/*     */   private PathTile avoidWalkingThroughBlobDest(Div d, PathTile start) {
/* 359 */     int rewind = 1;
/* 360 */     PathTile t = start;
/*     */ 
/*     */     
/* 363 */     label25: while (t != null) {
/*     */       
/* 365 */       if (rewind++ % 14 == 0) {
/* 366 */         double l = this.vec.set((COORDINATE)t, (COORDINATE)start);
/*     */         
/* 368 */         for (int i = 0; i < l; i++) {
/* 369 */           int tx = (int)(t.x() + this.vec.nX() * i);
/* 370 */           int ty = (int)(t.y() + this.vec.nY() * i);
/* 371 */           if (this.blob.is(tx, ty)) {
/*     */             break label25;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 377 */       t = t.getParent();
/*     */     } 
/*     */     
/* 380 */     if (t == null) {
/* 381 */       return null;
/*     */     }
/* 383 */     t = start;
/*     */     
/* 385 */     rewind -= 14;
/*     */     
/* 387 */     while (t != null) {
/*     */       
/* 389 */       if (rewind-- <= 0) {
/* 390 */         return t;
/*     */       }
/*     */       
/* 393 */       t = t.getParent();
/*     */     } 
/*     */     
/* 396 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   private double cost(int dx, int dy) {
/* 401 */     if (this.blob.is(dx, dy))
/* 402 */       return -1.0D; 
/* 403 */     if (this.penalty.is(dx, dy)) {
/* 404 */       return 10.0D;
/*     */     }
/* 406 */     AVAILABILITY a = (SETT.PATH()).availability.get(dx, dy);
/* 407 */     if (a.isSolid(this.util.getArmy())) {
/* 408 */       return 1.0D + (GAME.ARMIES()).map.strength.get(dx, dy) / 640.0D;
/*     */     }
/*     */     
/* 411 */     double res = a.movementSpeedI;
/* 412 */     double s = (SETT.ENV()).map.SPACE.get(dx, dy);
/* 413 */     if (s < 0.5D)
/* 414 */       return res *= 2.0D; 
/* 415 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PathTile setDest(PathTile start) {
/* 425 */     if (start.getParent() == null) {
/* 426 */       return start;
/*     */     }
/*     */     
/* 429 */     while (start.getParent() != null) {
/*     */ 
/*     */       
/* 432 */       if (((AVAILABILITY)(SETT.PATH()).availability.get((COORDINATE)start)).isSolid(this.util.getArmy())) {
/* 433 */         return start;
/*     */       }
/* 435 */       start = start.getParent();
/*     */     } 
/* 437 */     return start;
/*     */   }
/*     */   
/*     */   private static class DivDeploment {
/*     */     Div div;
/*     */     ContextLines.Line l;
/*     */     DIR dir;
/*     */     int cx;
/*     */     int cy;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\StepLinesMoveTo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */