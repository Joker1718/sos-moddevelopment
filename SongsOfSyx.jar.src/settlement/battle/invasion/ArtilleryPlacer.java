/*     */ package settlement.battle.invasion;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DivGeneration;
/*     */ import game.faction.FACTIONS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import settlement.room.military.artillery.ROOM_ARTILLERY;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ArtilleryPlacer
/*     */ {
/*     */   static boolean placeArt(LIST<DivGeneration> divs, SpotMaker.InvasionSpot spot, int amount) {
/*  33 */     mark();
/*  34 */     PathTile t = find(spot);
/*  35 */     if (t == null)
/*  36 */       return false; 
/*  37 */     PathTile target = rewind(t, 2);
/*  38 */     if (target == null)
/*  39 */       return false; 
/*  40 */     PathTile safe = rewind(t, 1);
/*  41 */     if (safe == null)
/*  42 */       return false; 
/*  43 */     PathTile dest = findPos(spot, safe);
/*  44 */     if (dest == null)
/*  45 */       return false; 
/*  46 */     Race r = getRace(divs);
/*  47 */     return deploy(r, spot, (COORDINATE)dest, DIR.get((COORDINATE)dest, (COORDINATE)target), amount);
/*     */   }
/*     */ 
/*     */   
/*     */   private static Race getRace(LIST<DivGeneration> divs) {
/*  52 */     int[] amount = Alloc.ii(RACES.all().size());
/*  53 */     for (DivGeneration d : divs) {
/*  54 */       amount[(d.race()).index] = amount[(d.race()).index] + d.indus.length;
/*     */     }
/*  56 */     if (divs.size() == 0)
/*  57 */       return FACTIONS.player().race(); 
/*  58 */     Race best = ((DivGeneration)divs.get(0)).race();
/*  59 */     int bestV = 0;
/*  60 */     for (Race r : RACES.playable()) {
/*  61 */       if (amount[r.index] > bestV) {
/*  62 */         best = r;
/*  63 */         bestV = amount[r.index];
/*     */       } 
/*     */     } 
/*     */     
/*  67 */     return best;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void mark() {
/*  72 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*  73 */     f.init(ArtilleryPlacer.class);
/*     */     
/*  75 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*  76 */       f.setValue2(c, 0.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  81 */     for (ROOM_ARTILLERY b : (SETT.ROOMS()).ARTILLERY) {
/*  82 */       for (int i = 0; i < b.instancesSize(); i++) {
/*  83 */         ArtilleryInstance ins = (ArtilleryInstance)b.getInstance(i);
/*  84 */         if (ins.army() == GAME.ARMIES().enemy()) {
/*  85 */           f.pushGreater(ins.body().cX(), ins.body().cY(), (ins.rangeMax() - 32));
/*  86 */           f.setValue2(ins.body().cX(), ins.body().cY(), 2.0D);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  91 */     f.pushGreater(THRONE.coo().x(), THRONE.coo().y(), 48.0D);
/*  92 */     f.setValue2(THRONE.coo().x(), THRONE.coo().y(), 2.0D);
/*     */     
/*  94 */     for (Div d : GAME.ARMIES().player().divisions()) {
/*  95 */       if (d.active()) {
/*  96 */         for (int i = 0; i < d.current().deployed(); i++) {
/*  97 */           int tx = d.current().tile(i).x();
/*  98 */           int ty = d.current().tile(i).y();
/*  99 */           if (SETT.IN_BOUNDS(tx, ty)) {
/* 100 */             f.pushGreater(tx, ty, 128.0D);
/* 101 */             f.setValue2(tx, ty, 2.0D);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 109 */     while (f.hasMore()) {
/*     */       
/* 111 */       PathTile t = GUTIL.flooder().pollGreatest();
/* 112 */       if (t.getValue() <= 0.0F) {
/*     */         break;
/*     */       }
/* 115 */       for (DIR d : DIR.ALL) {
/* 116 */         int dx = t.x() + d.x();
/* 117 */         int dy = t.y() + d.y();
/* 118 */         if (SETT.IN_BOUNDS(dx, dy)) {
/*     */           
/* 120 */           f.pushGreater(dx, dy, t.getValue() - d.tileDistance());
/* 121 */           f.setValue2(dx, dy, 1.0D);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 127 */     f.done();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static PathTile find(SpotMaker.InvasionSpot spot) {
/* 135 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 136 */     f.init(ArtilleryPlacer.class);
/*     */     
/* 138 */     for (COORDINATE c : spot.body) {
/* 139 */       f.pushSloppy(c, 0.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 144 */     while (f.hasMore()) {
/*     */       
/* 146 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 147 */       if (THRONE.coo().isSameAs((COORDINATE)t)) {
/* 148 */         f.done();
/* 149 */         return t;
/*     */       } 
/*     */ 
/*     */       
/* 153 */       for (DIR d : DIR.ALL) {
/* 154 */         int dx = t.x() + d.x();
/* 155 */         int dy = t.y() + d.y();
/* 156 */         if (SETT.IN_BOUNDS(dx, dy)) {
/* 157 */           f.pushSmaller(dx, dy, t.getValue() + d.tileDistance() * (1.0D + ((SETT.PATH()).availability.get(dx, dy)).movementSpeedI) * (11.0D - 10.0D * (SETT.ENV()).map.SPACE.get(dx, dy)), t);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 163 */     f.done();
/* 164 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static PathTile rewind(PathTile t, int va) {
/* 171 */     PathTile safe = t;
/*     */     
/* 173 */     while (t.getParent() != null) {
/* 174 */       if (t.getValue2() >= va)
/*     */       {
/* 176 */         safe = t.getParent();
/*     */       }
/* 178 */       t = t.getParent();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 184 */     if (GUTIL.flooder().getValue2(safe.x(), safe.y()) >= va)
/* 185 */       return null; 
/* 186 */     return safe;
/*     */   }
/*     */ 
/*     */   
/*     */   private static PathTile findPos(SpotMaker.InvasionSpot spot, PathTile t) {
/* 191 */     SComponent sup = (SComponent)(SETT.PATH()).comps.superComp.get(spot.body.cX(), spot.body.cY());
/* 192 */     PathTile pos = t;
/*     */     
/* 194 */     while (pos != null && ((SETT.ENV()).map.SPACE.get((COORDINATE)pos) < 0.5D || (SETT.PATH()).comps.superComp.get((COORDINATE)pos) != sup || (SETT.PATH()).availability.get(pos.x(), pos.y()).isSolid(GAME.ARMIES().enemy()))) {
/* 195 */       pos = pos.getParent();
/*     */     }
/*     */     
/* 198 */     if (pos == t) {
/* 199 */       if (pos.getParent() == null)
/* 200 */         return null; 
/* 201 */       return pos.getParent();
/*     */     } 
/*     */     
/* 204 */     return pos;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean deploy(Race r, SpotMaker.InvasionSpot spot, COORDINATE c, DIR dir, int amount) {
/* 210 */     int am = 0;
/*     */     
/* 212 */     SComponent sup = (SComponent)(SETT.PATH()).comps.superComp.get(spot.body.cX(), spot.body.cY());
/*     */     
/* 214 */     for (int d = 0; d < 32; d += 8) {
/*     */       
/* 216 */       int dx = c.x() + dir.perpendicular().x() * d;
/* 217 */       int dy = c.y() + dir.perpendicular().y() * d;
/*     */       
/* 219 */       for (int w = 0; w < 64; w += 4) {
/*     */         
/* 221 */         for (int i = -1; i <= 1; i += 2) {
/* 222 */           int x = dx + dir.next(2).x() * i * w;
/* 223 */           int y = dy + dir.next(2).y() * i * w;
/* 224 */           ROOM_ARTILLERY a = (ROOM_ARTILLERY)(SETT.ROOMS()).ARTILLERY.rnd();
/* 225 */           if (deploy(sup, x, y, dir, a)) {
/* 226 */             amount--;
/* 227 */             a.getClass(); am += 6;
/* 228 */             if (amount <= 0) {
/* 229 */               createDudes(sup, r, spot, am);
/* 230 */               return true;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 239 */     if (am > 0) {
/* 240 */       createDudes(sup, r, spot, am);
/*     */     }
/* 242 */     return (am > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void createDudes(SComponent comp, Race r, SpotMaker.InvasionSpot spot, int am) {
/* 247 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 248 */     f.init(ArtilleryPlacer.class);
/*     */     
/* 250 */     for (COORDINATE c : spot.body) {
/* 251 */       f.pushSloppy(c, RND.rFloat());
/*     */     }
/*     */     
/* 254 */     while (am > 0 && f.hasMore()) {
/*     */       
/* 256 */       PathTile t = f.pollSmallest();
/* 257 */       if (!comp.is((COORDINATE)t))
/*     */         continue; 
/* 259 */       Humanoid h = new Humanoid(t.x() * 64 + 32, t.y() * 64 + 32, r, HTYPES.ENEMY(), CAUSE_ARRIVES.SOLDIER_RETURN());
/* 260 */       if (!h.isRemoved())
/* 261 */         am--; 
/* 262 */       for (DIR d : DIR.ALL) {
/* 263 */         int dx = t.x() + d.x();
/* 264 */         int dy = t.y() + d.y();
/* 265 */         if (SETT.IN_BOUNDS(dx, dy)) {
/*     */           
/* 267 */           f.pushSmaller(dx, dy, t.getValue() + d.tileDistance());
/* 268 */           f.setValue2(dx, dy, 1.0D);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 273 */     f.done();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean deploy(SComponent sup, int sx, int sy, DIR d, ROOM_ARTILLERY art) {
/* 280 */     if ((SETT.PATH()).comps.superComp.get(sx, sy) != sup) {
/* 281 */       return false;
/*     */     }
/* 283 */     if (!d.isOrtho()) {
/* 284 */       d = d.next((int)RND.rSign());
/*     */     }
/*     */ 
/*     */     
/* 288 */     int index = -1;
/* 289 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 290 */       if (DIR.ORTHO.get(i) == d) {
/* 291 */         index = i;
/*     */       }
/*     */     } 
/*     */     
/* 295 */     art.eplacer.rotSet(index);
/*     */     int y;
/* 297 */     for (y = 0; y < art.eplacer.height(); y++) {
/* 298 */       for (int x = 0; x < art.eplacer.width(); x++) {
/* 299 */         if (art.eplacer.placable(sx + x, sy + y, x, y) != null) {
/* 300 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/* 304 */     if (art.eplacer.placableWhole(sx, sy) != null) {
/* 305 */       return false;
/*     */     }
/* 307 */     for (y = 0; y < art.eplacer.height(); y++) {
/* 308 */       for (int x = 0; x < art.eplacer.width(); x++) {
/* 309 */         art.eplacer.place(sx + x, sy + y, x, y);
/*     */       }
/*     */     } 
/* 312 */     art.eplacer.afterPlaced(sx, sy);
/*     */     
/* 314 */     ArtilleryInstance r = (ArtilleryInstance)art.getter.get(sx, sy);
/*     */     
/* 316 */     if (r == null) {
/* 317 */       return false;
/*     */     }
/* 319 */     r.setEnemy();
/*     */     
/* 321 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\battle\invasion\ArtilleryPlacer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */