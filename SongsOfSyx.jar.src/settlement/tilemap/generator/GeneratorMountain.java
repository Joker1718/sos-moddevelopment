/*     */ package settlement.tilemap.generator;
/*     */ 
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import settlement.main.SettlementGrid;
/*     */ import settlement.tilemap.TileMap;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.HeightMap;
/*     */ import snake2d.util.rnd.Polymap;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ import world.map.terrain.WorldMountain;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GeneratorMountain
/*     */ {
/*     */   private final double radius;
/*  31 */   private int PS = 8;
/*  32 */   private final TileMap m = SETT.TILE_MAP();
/*     */   
/*  34 */   private final HeightMap height = new HeightMap(SETT.TWIDTH, SETT.THEIGHT, 16, 1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GeneratorMountain(CapitolArea area, GeneratorUtil util) {
/*  40 */     this.radius = util.json.d("MOUNTAIN_SIZE", 0.1D, 1.0D) * 100.0D;
/*  41 */     WorldMountain.AreaTileMountain wt = (WORLD.MOUNTAIN()).area;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  46 */     util.polly.checkInit();
/*  47 */     int i = 0;
/*  48 */     for (SettlementGrid.Tile t : SETT.GRID.tiles()) {
/*  49 */       COORDINATE c = (COORDINATE)area.ts().get(i++);
/*  50 */       for (DIR d : t.getDirs()) {
/*  51 */         if (wt.is(c.x(), c.y(), d)) {
/*  52 */           mountenize(t.coo(d).x(), t.coo(d).y(), util);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     GUTIL.filler().init(this);
/*  61 */     for (int j = 0; j < SETT.TWIDTH; j++) {
/*  62 */       for (int x = 0; x < SETT.TWIDTH; x++) {
/*     */         
/*  64 */         if (util.polly.checker.is(x / this.PS, j / this.PS)) {
/*  65 */           GUTIL.filler().fill(x, j);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  74 */     util.polly.checkInit();
/*  75 */     while (GUTIL.filler().hasMore()) {
/*     */       
/*  77 */       COORDINATE t = GUTIL.filler().poll();
/*  78 */       util.polly.checker.set(t, true);
/*     */     } 
/*     */     
/*  81 */     GUTIL.filler().done();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     for (int qy = 0; qy < SettlementGrid.TILES; qy++) {
/*     */ 
/*     */       
/*  90 */       COORDINATE c = (COORDINATE)area.ts().get(qy * SettlementGrid.TILES);
/*     */ 
/*     */ 
/*     */       
/*  94 */       int startY = wt.borders(c.x(), c.y(), DIR.NW) ? 0 : SettlementGrid.QUAD_HALF;
/*  95 */       int endY = wt.borders(c.x(), c.y(), DIR.SW) ? SettlementGrid.QUAD_SIZE : SettlementGrid.QUAD_HALF;
/*  96 */       startY += SettlementGrid.QUAD_SIZE * qy;
/*  97 */       endY += SettlementGrid.QUAD_SIZE * qy;
/*     */       int k;
/*  99 */       for (k = startY; k < endY; k++) {
/* 100 */         util.polly.checker.set(0, k / this.PS, true);
/*     */       }
/*     */       
/* 103 */       c = (COORDINATE)area.ts().get(qy * SettlementGrid.TILES + SettlementGrid.TILES - 1);
/*     */       
/* 105 */       startY = wt.borders(c.x(), c.y(), DIR.NE) ? 0 : SettlementGrid.QUAD_HALF;
/* 106 */       endY = wt.borders(c.x(), c.y(), DIR.SE) ? SettlementGrid.QUAD_SIZE : SettlementGrid.QUAD_HALF;
/*     */       
/* 108 */       startY += SettlementGrid.QUAD_SIZE * qy;
/* 109 */       endY += SettlementGrid.QUAD_SIZE * qy;
/*     */       
/* 111 */       for (k = startY; k < endY; k++) {
/* 112 */         util.polly.checker.set(SETT.TWIDTH - 1, k, true);
/*     */       }
/*     */     } 
/*     */     
/* 116 */     for (int qx = 0; qx < SettlementGrid.TILES; qx++) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 123 */       COORDINATE c = (COORDINATE)area.ts().get(qx);
/*     */       
/* 125 */       int startX = wt.borders(c.x(), c.y(), DIR.NW) ? 0 : SettlementGrid.QUAD_HALF;
/* 126 */       int endX = wt.borders(c.x(), c.y(), DIR.NE) ? SettlementGrid.QUAD_SIZE : SettlementGrid.QUAD_HALF;
/*     */       
/* 128 */       startX += SettlementGrid.QUAD_SIZE * qx;
/* 129 */       endX += SettlementGrid.QUAD_SIZE * qx;
/*     */       int x;
/* 131 */       for (x = startX; x < endX; x++) {
/* 132 */         util.polly.checker.set(x, 0, true);
/*     */       }
/*     */       
/* 135 */       c = (COORDINATE)area.ts().get(SettlementGrid.TILES * (SettlementGrid.TILES - 1) + qx);
/* 136 */       startX = wt.borders(c.x(), c.y(), DIR.SW) ? 0 : SettlementGrid.QUAD_HALF;
/* 137 */       endX = wt.borders(c.x(), c.y(), DIR.SE) ? SettlementGrid.QUAD_SIZE : SettlementGrid.QUAD_HALF;
/*     */       
/* 139 */       startX += SettlementGrid.QUAD_SIZE * qx;
/* 140 */       endX += SettlementGrid.QUAD_SIZE * qx;
/*     */       
/* 142 */       for (x = startX; x < endX; x++) {
/* 143 */         util.polly.checker.set(x, SETT.TWIDTH - 1, true);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 150 */     i = 0;
/* 151 */     for (SettlementGrid.Tile t : SETT.GRID.tiles()) {
/* 152 */       if (area.arrivalTile() == i) {
/* 153 */         clear(DIR.N, t.coo(DIR.C).x(), t.coo(DIR.C).y(), util.polly);
/* 154 */         clear(DIR.S, t.coo(DIR.C).x(), t.coo(DIR.C).y(), util.polly);
/* 155 */         clear(DIR.E, t.coo(DIR.C).x(), t.coo(DIR.C).y(), util.polly);
/* 156 */         clear(DIR.W, t.coo(DIR.C).x(), t.coo(DIR.C).y(), util.polly);
/*     */       } 
/*     */       
/* 159 */       COORDINATE c = (COORDINATE)area.ts().get(i++);
/* 160 */       if ((WORLD.WATER()).has.is(c)) {
/* 161 */         for (DIR d : t.getDirs()) {
/* 162 */           if ((WORLD.WATER()).has.is(c, d)) {
/* 163 */             clear(d.perpendicular(), t.coo(d).x(), t.coo(d).y(), util.polly);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 170 */     GUTIL.flooder().init(this);
/*     */     int y;
/* 172 */     for (y = 0; y < SETT.TWIDTH; y++) {
/* 173 */       for (int x = 0; x < SETT.TWIDTH; x++) {
/*     */         
/* 175 */         if (util.polly.checker.is(x, y)) {
/* 176 */           this.m.topology.MOUNTAIN.placeRaw(x, y);
/*     */           
/* 178 */           GUTIL.flooder().pushSloppy(x, y, 0.0D);
/* 179 */           double v2 = 0.0D;
/* 180 */           if (RND.oneIn(5)) {
/* 181 */             v2 = RND.rFloat(30.0D);
/*     */           }
/*     */           
/* 184 */           GUTIL.flooder().setValue2(x, y, v2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 191 */     while (GUTIL.flooder().hasMore()) {
/*     */       
/* 193 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 194 */       if (t.getValue() >= t.getValue2()) {
/*     */         continue;
/*     */       }
/* 197 */       for (DIR d : DIR.ORTHO) {
/*     */         
/* 199 */         int x = t.x() + d.x();
/* 200 */         int k = t.y() + d.y();
/* 201 */         if (!SETT.IN_BOUNDS(x, k) || 
/* 202 */           GUTIL.flooder().hasBeenPushed(x, k)) {
/*     */           continue;
/*     */         }
/* 205 */         double v = t.getValue() + d.tileDistance();
/* 206 */         double dd = v / t.getValue2();
/*     */ 
/*     */         
/* 209 */         if (dd < 0.3D) {
/* 210 */           this.m.topology.MOUNTAIN.placeRaw(x, k);
/*     */         }
/*     */ 
/*     */         
/* 214 */         if (GUTIL.flooder().pushSloppy(x, k, v) != null) {
/* 215 */           GUTIL.flooder().setValue2(x, k, t.getValue2());
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 224 */     GUTIL.flooder().done();
/*     */     
/* 226 */     fertilize(util);
/* 227 */     makeHeight(util);
/*     */ 
/*     */     
/* 230 */     for (y = 0; y < SETT.TWIDTH; y++) {
/* 231 */       for (int x = 0; x < SETT.TWIDTH; x++) {
/* 232 */         if (this.m.topology.MOUNTAIN.is(x, y)) {
/*     */           
/* 234 */           if (isSolo(x, y)) {
/* 235 */             this.m.topology.ROCK.placeAmount(x, y, 0.5D + RND.rFloat() * 0.5D);
/*     */           } else {
/* 237 */             (SETT.GROUND()).types.ROCK.placeFixed(x, y);
/* 238 */             util.height.increment(x, y, 1.0D);
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 243 */           double h = util.height.get(x, y) * (0.3D + 0.7D * this.height.get(x, y));
/* 244 */           h = Math.pow(h, 1.2D);
/* 245 */           h += RND.rFloat0(0.05D);
/* 246 */           if (h > 0.5D) {
/* 247 */             h -= 0.5D;
/* 248 */             h /= 0.5D;
/* 249 */             h = Math.pow(h, 0.8D);
/* 250 */             h *= 1.0D + RND.rSign() * RND.rExpo();
/*     */ 
/*     */             
/* 253 */             double a = h;
/* 254 */             this.m.topology.ROCK.placeAmount(x, y, a);
/* 255 */             util.fer.set(x, y, util.fer.get(x, y) * (0.25D + 0.75D * (1.0D - a)));
/*     */           }
/* 257 */           else if (RND.oneIn(250)) {
/* 258 */             double a = RND.rFloatP(3.0F);
/* 259 */             this.m.topology.ROCK.placeAmount(x, y, a);
/* 260 */             util.fer.target(x, y, 0.5D, a);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 266 */     GUTIL.flooder().init(this);
/* 267 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/* 268 */       if (!(SETT.TERRAIN()).MOUNTAIN.is(c)) {
/* 269 */         GUTIL.flooder().pushSloppy(c, 0.0D);
/*     */       }
/*     */     } 
/*     */     
/* 273 */     while (GUTIL.flooder().hasMore()) {
/* 274 */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       
/* 276 */       if ((SETT.TERRAIN()).MOUNTAIN.is((COORDINATE)t)) {
/* 277 */         (SETT.TERRAIN()).MOUNTAIN.strengthSet(t.x(), t.y(), (1.0F + t.getValue()) / 64.0D);
/*     */       }
/*     */       
/* 280 */       for (DIR d : DIR.ORTHO) {
/* 281 */         if (SETT.IN_BOUNDS((COORDINATE)t, d)) {
/* 282 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/* 286 */     GUTIL.flooder().done();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fertilize(GeneratorUtil util) {
/* 292 */     GUTIL.flooder().init(this);
/*     */     
/* 294 */     HeightMap hh = new HeightMap(SETT.TWIDTH, SETT.THEIGHT, 32, 8);
/*     */     
/* 296 */     for (int y = 0; y < SETT.TWIDTH; y++) {
/* 297 */       for (int x = 0; x < SETT.TWIDTH; x++) {
/* 298 */         if (this.m.topology.MOUNTAIN.is(x, y)) {
/* 299 */           util.fer.set(x, y, hh.get(x, y));
/* 300 */           for (DIR dIR : DIR.ORTHO) {
/* 301 */             if (!this.m.topology.MOUNTAIN.is(x, y, dIR)) {
/* 302 */               GUTIL.flooder().pushSloppy(x, y, 0.0D);
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 310 */     double ma = 5.0D;
/*     */     
/* 312 */     while (GUTIL.flooder().hasMore()) {
/* 313 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 314 */       if (t.getValue() >= ma)
/*     */         continue; 
/* 316 */       double v = t.getValue() / ma;
/* 317 */       util.fer.set(t.x(), t.y(), 0.3D * (1.0D - v) + util.fer.get(t.x(), t.y()) * v);
/* 318 */       for (DIR dIR : DIR.ALL) {
/* 319 */         int j = t.x() + dIR.x();
/* 320 */         int k = t.y() + dIR.y();
/* 321 */         if (SETT.IN_BOUNDS(j, k)) {
/* 322 */           GUTIL.flooder().pushSmaller(j, k, t.getValue() + dIR.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 329 */     GUTIL.flooder().done();
/*     */ 
/*     */     
/* 332 */     double am = 8.0D;
/* 333 */     int dx = -1;
/* 334 */     int dy = -1;
/*     */     
/* 336 */     double d = 0.1D;
/*     */     
/* 338 */     for (int i = 0; i < SETT.TWIDTH; i++) {
/* 339 */       for (int x = 0; x < SETT.TWIDTH; x++) {
/* 340 */         if (this.m.topology.MOUNTAIN.is(x, i)) {
/* 341 */           for (int j = 0; j < am; j++) {
/* 342 */             int tx = x + j * dx;
/* 343 */             int ty = i + j * dy;
/* 344 */             if (!SETT.IN_BOUNDS(tx, ty))
/*     */               break; 
/* 346 */             if (!this.m.topology.MOUNTAIN.is(tx, ty)) {
/* 347 */               double dd = d * (1.0D - j / am);
/* 348 */               util.fer.increment(tx, ty, dd);
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void makeHeight(GeneratorUtil util) {
/* 363 */     GUTIL.flooder().init(this);
/*     */     
/* 365 */     for (int y = 0; y < SETT.TWIDTH; y++) {
/* 366 */       for (int x = 0; x < SETT.TWIDTH; x++) {
/*     */         
/* 368 */         if (this.m.topology.MOUNTAIN.is(x, y)) {
/* 369 */           GUTIL.flooder().pushSloppy(x, y, 0.0D);
/* 370 */           util.height.set(x, y, 1.0D);
/* 371 */           double v2 = 0.0D;
/* 372 */           if (RND.oneIn(5)) {
/* 373 */             v2 = RND.rFloat(30.0D);
/*     */           }
/*     */           
/* 376 */           GUTIL.flooder().setValue2(x, y, v2);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 383 */     while (GUTIL.flooder().hasMore()) {
/*     */       
/* 385 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 386 */       if (t.getValue() >= t.getValue2()) {
/*     */         continue;
/*     */       }
/* 389 */       for (DIR d : DIR.ORTHO) {
/*     */         
/* 391 */         int x = t.x() + d.x();
/* 392 */         int i = t.y() + d.y();
/* 393 */         if (!SETT.IN_BOUNDS(x, i) || 
/* 394 */           GUTIL.flooder().hasBeenPushed(x, i)) {
/*     */           continue;
/*     */         }
/* 397 */         double v = t.getValue() + d.tileDistance();
/* 398 */         double dd = v / t.getValue2();
/*     */ 
/*     */         
/* 401 */         if (t.getValue2() > 20.0F) {
/* 402 */           double h = util.height.get(x, i);
/* 403 */           h = h * dd + 1.0D - dd;
/* 404 */           h *= RND.rFloat1(0.3D);
/* 405 */           util.height.set(x, i, h);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 411 */         if (GUTIL.flooder().pushSloppy(x, i, v) != null) {
/* 412 */           GUTIL.flooder().setValue2(x, i, t.getValue2());
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 421 */     GUTIL.flooder().done();
/*     */   }
/*     */   
/*     */   private boolean isSolo(int tx, int ty) {
/* 425 */     for (int i = 0; i < DIR.NORTHO.size(); i++) {
/* 426 */       DIR d = (DIR)DIR.NORTHO.get(i);
/* 427 */       if (is(tx, ty, d) && is(tx, ty, d.next(1)) && is(tx, ty, d.next(-1)))
/* 428 */         return false; 
/*     */     } 
/* 430 */     return true;
/*     */   }
/*     */   
/*     */   private boolean is(int tx, int ty, DIR d) {
/* 434 */     if (!SETT.IN_BOUNDS(tx, ty, d))
/* 435 */       return true; 
/* 436 */     return (SETT.TERRAIN()).MOUNTAIN.is(tx, ty, d);
/*     */   }
/*     */   
/*     */   private void clear(DIR d, int startX, int startY, Polymap p) {
/* 440 */     for (int i = 0; i < SettlementGrid.QUAD_HALF; i++) {
/* 441 */       p.checker.set(startX, startY, false);
/* 442 */       if (SETT.IN_BOUNDS(startX - 1, startY))
/* 443 */         p.checker.set(startX, startY, false); 
/* 444 */       if (SETT.IN_BOUNDS(startX - 1, startY - 1))
/* 445 */         p.checker.set(startX, startY, false); 
/* 446 */       if (SETT.IN_BOUNDS(startX, startY - 1))
/* 447 */         p.checker.set(startX, startY, false); 
/* 448 */       p.checker.set(startX, startY, false);
/* 449 */       startX += d.x();
/* 450 */       startY += d.y();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void mountenize(int tx, int ty, GeneratorUtil util) {
/* 456 */     double radius = this.radius * RND.rFloat1(0.1D);
/* 457 */     double radius2 = radius * radius;
/* 458 */     tx += RND.rInt0(20);
/* 459 */     ty += RND.rInt0(20);
/*     */     
/* 461 */     for (int y = (int)-radius; y < radius; y++) {
/* 462 */       for (int x = (int)-radius; x < radius; x++) {
/* 463 */         int dx = tx + x;
/* 464 */         int dy = ty + y;
/* 465 */         if (SETT.IN_BOUNDS(dx, dy)) {
/*     */           
/* 467 */           double r = (x * x + y * y);
/* 468 */           if (r <= radius2)
/*     */           {
/* 470 */             util.polly.checker.set(dx / this.PS, dy / this.PS, true);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorMountain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */