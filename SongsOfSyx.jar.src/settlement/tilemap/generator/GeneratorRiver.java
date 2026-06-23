/*     */ package settlement.tilemap.generator;
/*     */ 
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import settlement.main.SettlementGrid;
/*     */ import settlement.tilemap.TileMap;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathGame;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.HeightMap;
/*     */ import snake2d.util.rnd.Polymap;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
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
/*     */ class GeneratorRiver
/*     */ {
/*     */   private final HeightMap height;
/*     */   private final TileMap m;
/*     */   private final int width;
/*     */   private final GeneratorUtil util;
/*     */   private final Polymap polly;
/*  37 */   private final PathGame.PathFancy p = new PathGame.PathFancy(5000);
/*     */ 
/*     */   
/*     */   GeneratorRiver(CapitolArea area, GeneratorUtil util) {
/*  41 */     util.checker.init();
/*     */     
/*  43 */     this.util = util;
/*  44 */     this.polly = util.polly;
/*  45 */     this.height = util.height;
/*  46 */     this.m = SETT.TILE_MAP();
/*  47 */     this.width = util.json.i("RIVER_WIDTH", 1, 15);
/*  48 */     for (int i = 0; i < SETT.GRID.tiles().size(); i++) {
/*  49 */       SettlementGrid.Tile ut = SETT.GRID.tile(i);
/*  50 */       build((COORDINATE)area.ts().get(i), ut);
/*     */     } 
/*     */     
/*  53 */     GUTIL.flooder().init(this);
/*     */     
/*  55 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*  56 */       if (util.checker.is(c)) {
/*  57 */         GUTIL.flooder().pushSloppy(c, 0.0D);
/*  58 */         double h = 1.0D + util.fer.get(c);
/*  59 */         if (h < 0.0D) {
/*  60 */           h = 0.0D;
/*     */         }
/*     */         
/*  63 */         h = Math.sqrt(h / 4.0D);
/*  64 */         GUTIL.flooder().setValue2(c, h * 20.0D);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  70 */     while (GUTIL.flooder().hasMore()) {
/*  71 */       PathTile t = GUTIL.flooder().pollSmallest();
/*  72 */       (SETT.TERRAIN()).WATER.SHALLOW.placeRaw(t.x(), t.y());
/*     */ 
/*     */       
/*  75 */       double v = t.getValue();
/*     */ 
/*     */       
/*  78 */       if (v >= t.getValue2()) {
/*     */         continue;
/*     */       }
/*     */       
/*  82 */       double h = 1.0D * (1.0D - Math.pow(v / t.getValue2(), 0.25D));
/*     */       
/*  84 */       util.height.increment((COORDINATE)t, h);
/*     */       
/*  86 */       for (int j = 0; j < DIR.ALL.size(); j++) {
/*     */ 
/*     */         
/*  89 */         DIR d = (DIR)DIR.ALL.get(j);
/*  90 */         int x = d.x() + t.x();
/*  91 */         int y = d.y() + t.y();
/*     */         
/*  93 */         if (SETT.IN_BOUNDS(x, y)) {
/*     */ 
/*     */           
/*  96 */           v = d.tileDistance();
/*  97 */           v *= 1.0D + CLAMP.d(Math.pow(this.height.get(x, y), 4.0D), 0.0D, 1.0D) * 1.5D;
/*  98 */           v += t.getValue();
/*     */           
/* 100 */           if (v < t.getValue2())
/*     */           {
/* 102 */             if (GUTIL.flooder().pushSmaller(x, y, (float)v) != null) {
/* 103 */               GUTIL.flooder().setValue2(x, y, t.getValue2());
/*     */             }
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 109 */     GUTIL.flooder().done();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void build(COORDINATE wtt, SettlementGrid.Tile ut) {
/* 117 */     if (!(WORLD.WATER()).isRivery.is(wtt)) {
/*     */       return;
/*     */     }
/* 120 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 121 */       DIR dStart = (DIR)DIR.ORTHO.get(i);
/*     */       
/* 123 */       if (connected(wtt, dStart)) {
/*     */         
/* 125 */         int startX = ut.coo(dStart).x();
/* 126 */         int startY = ut.coo(dStart).y();
/*     */         
/* 128 */         boolean delta = (WORLD.WATER()).isDELTA.is(wtt);
/* 129 */         boolean connected = false; int j;
/* 130 */         for (j = 0; j < i; j++) {
/* 131 */           DIR dEnd = (DIR)DIR.ORTHO.get(j);
/* 132 */           if (connected(wtt, dEnd)) {
/* 133 */             connected = true;
/*     */           }
/*     */         } 
/* 136 */         for (j = i + 1; j < DIR.ORTHO.size(); j++) {
/* 137 */           DIR dEnd = (DIR)DIR.ORTHO.get(j);
/* 138 */           if (connected(wtt, dEnd)) {
/* 139 */             connected = true;
/* 140 */             int endX = ut.coo(dEnd).x();
/* 141 */             int endY = ut.coo(dEnd).y();
/* 142 */             boolean sDelta = (WORLD.WATER()).isDELTA.is(wtt, dStart);
/* 143 */             boolean eDelta = (WORLD.WATER()).isDELTA.is(wtt, dEnd);
/* 144 */             int sx = startX;
/* 145 */             int sy = startY;
/*     */             
/* 147 */             if (sDelta) {
/* 148 */               sx += dStart.x() * SettlementGrid.QUAD_HALF;
/* 149 */               sy += dStart.y() * SettlementGrid.QUAD_HALF;
/*     */             } 
/*     */             
/* 152 */             if (eDelta) {
/* 153 */               endX += dEnd.x() * SettlementGrid.QUAD_HALF;
/* 154 */               endY += dEnd.y() * SettlementGrid.QUAD_HALF;
/*     */             } 
/*     */             
/* 157 */             pave(positions(sx, sy, dStart, sDelta), positions(endX, endY, dEnd, eDelta), ut.bounds, sDelta ? 2.0D : 1.0D, eDelta ? 2.0D : 1.0D);
/*     */           } 
/*     */         } 
/* 160 */         if (!connected) {
/* 161 */           LinkedList<Coo> end = new LinkedList();
/* 162 */           end.add(new Coo(ut.coo(DIR.C).x(), ut.coo(DIR.C).y()));
/* 163 */           pave(
/* 164 */               positions(startX, startY, dStart, delta & (!(WORLD.WATER()).RIVER.is(wtt, dStart))), 
/* 165 */               end, 
/* 166 */               ut.bounds, 1.0D, 0.0D);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean connected(COORDINATE wtt, DIR dStart) {
/* 175 */     if ((WORLD.WATER()).isRivery.is(wtt, dStart))
/* 176 */       return true; 
/* 177 */     if ((WORLD.WATER()).isDELTA.is(wtt) && (WORLD.WATER()).isBig.is(wtt, dStart))
/* 178 */       return true; 
/* 179 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private LinkedList<Coo> positions(int x, int y, DIR d, boolean delta) {
/* 185 */     if (x < 0) {
/* 186 */       x = 0;
/*     */     }
/* 188 */     if (x >= SETT.TWIDTH) {
/* 189 */       x = SETT.TWIDTH - 1;
/*     */     }
/* 191 */     if (y < 0) {
/* 192 */       y = 0;
/*     */     }
/* 194 */     if (y >= SETT.THEIGHT) {
/* 195 */       y = SETT.THEIGHT - 1;
/*     */     }
/*     */     
/* 198 */     int start = delta ? 16 : 0;
/* 199 */     int width = this.width;
/* 200 */     if (delta) {
/* 201 */       width = (int)(width * 1.5D);
/*     */     }
/* 203 */     LinkedList<Coo> res = new LinkedList();
/* 204 */     if (d.x() != 0) {
/* 205 */       for (int i = start; i < SettlementGrid.QUAD_SIZE * 2 && res.size() < width; i++) {
/* 206 */         if (SETT.IN_BOUNDS(x, y + i) && this.polly.isEdge(x, y + i)) {
/* 207 */           res.add(new Coo(x, (y + i)));
/*     */         }
/* 209 */         if (SETT.IN_BOUNDS(x, y - i) && this.polly.isEdge(x, y - i)) {
/* 210 */           res.add(new Coo(x, (y - i)));
/*     */         }
/*     */       } 
/*     */     } else {
/* 214 */       for (int i = start; i < SettlementGrid.QUAD_SIZE * 2 && res.size() < width; i++) {
/* 215 */         if (SETT.IN_BOUNDS(x + i, y) && this.polly.isEdge(x + i, y)) {
/* 216 */           res.add(new Coo((x + i), y));
/*     */         }
/* 218 */         if (SETT.IN_BOUNDS(x - i, y) && this.polly.isEdge(x - i, y)) {
/* 219 */           res.add(new Coo((x - i), y));
/*     */         }
/*     */       } 
/*     */     } 
/* 223 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void pave(LinkedList<Coo> starts, LinkedList<Coo> ends, final RECTANGLE bounds, double startWidth, double endWidth) {
/* 230 */     PathGame.COST cm = new PathGame.COST()
/*     */       {
/*     */         
/*     */         public double getCost(int fromX, int fromY, int toX, int toY)
/*     */         {
/* 235 */           if (!bounds.holdsPoint(toX, toY)) {
/* 236 */             return 50.0D;
/*     */           }
/* 238 */           if (GeneratorRiver.this.m.topology.MOUNTAIN.is(toX, toY)) {
/* 239 */             return 20.0D;
/*     */           }
/* 241 */           if (GeneratorRiver.this.m.topology.ROCK.is(toX, toY)) {
/* 242 */             return 20.0D;
/*     */           }
/* 244 */           if (!GeneratorRiver.this.polly.isEdge(toX, toY)) {
/* 245 */             return 2.0D;
/*     */           }
/* 247 */           if ((SETT.TERRAIN()).WATER.SHALLOW.is(toX, toY)) {
/* 248 */             return 0.5D;
/*     */           }
/* 250 */           double mul = GeneratorRiver.this.util.checker.is(toX, toY) ? 1.0D : 1.0D;
/*     */           
/* 252 */           return mul;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 257 */     LinkedList<Coo> flood = new LinkedList();
/*     */     
/* 259 */     while (!starts.isEmpty()) {
/*     */       
/* 261 */       Coo s = (Coo)starts.removeFirst();
/* 262 */       Coo e = (Coo)ends.removeFirst();
/* 263 */       ends.add(e);
/* 264 */       if (GUTIL.astar().getShortest(this.p, cm, s.x(), s.y(), e.x(), e.y())) {
/*     */         
/*     */         do
/*     */         {
/*     */ 
/*     */           
/* 270 */           if (!this.util.checker.is((COORDINATE)this.p))
/*     */           
/* 272 */           { this.util.checker.set((COORDINATE)this.p, true); }
/* 273 */           else { (SETT.TERRAIN()).WATER.SHALLOW.is((COORDINATE)this.p);
/*     */              }
/*     */ 
/*     */         
/*     */         }
/* 278 */         while (this.p.setNext());
/*     */       } else {
/* 280 */         LOG.ln("nono");
/*     */       } 
/* 282 */       flood.add(s);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 287 */     GUTIL.flooder().init(this);
/*     */     
/* 289 */     while (!flood.isEmpty()) {
/*     */       
/* 291 */       Coo s = (Coo)flood.removeFirst();
/* 292 */       GUTIL.flooder().pushSloppy((COORDINATE)s, 0.0D);
/*     */     } 
/*     */ 
/*     */     
/* 296 */     while (GUTIL.flooder().hasMore()) {
/* 297 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 298 */       (SETT.TERRAIN()).WATER.SHALLOW.placeRaw(t.x(), t.y());
/* 299 */       double v = t.getValue();
/*     */       
/* 301 */       if (v >= t.getValue2()) {
/*     */         continue;
/*     */       }
/*     */       
/* 305 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/*     */ 
/*     */         
/* 308 */         DIR d = (DIR)DIR.ALL.get(i);
/* 309 */         int x = d.x() + t.x();
/* 310 */         int y = d.y() + t.y();
/*     */         
/* 312 */         if (SETT.IN_BOUNDS(x, y))
/*     */         {
/*     */           
/* 315 */           if (this.util.checker.is((COORDINATE)t, d)) {
/* 316 */             GUTIL.flooder().pushSmaller(x, y, 0.0D);
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 322 */     GUTIL.flooder().done();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorRiver.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */