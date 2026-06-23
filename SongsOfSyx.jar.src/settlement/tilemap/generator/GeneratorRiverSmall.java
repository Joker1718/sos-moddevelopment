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
/*     */ 
/*     */ class GeneratorRiverSmall
/*     */ {
/*     */   private final HeightMap height;
/*     */   private final TileMap m;
/*     */   private final int width;
/*     */   private final GeneratorUtil util;
/*     */   private final Polymap polly;
/*  37 */   private final PathGame.PathFancy p = new PathGame.PathFancy(5000);
/*     */ 
/*     */   
/*     */   GeneratorRiverSmall(CapitolArea area, GeneratorUtil util) {
/*  41 */     util.checker.init();
/*     */     
/*  43 */     this.util = util;
/*  44 */     this.polly = util.polly;
/*  45 */     this.height = util.height;
/*  46 */     this.m = SETT.TILE_MAP();
/*  47 */     this.width = 1;
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
/*  63 */         h = Math.sqrt(h / this.width);
/*  64 */         GUTIL.flooder().setValue2(c, h * 4.0D);
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
/*  82 */       for (int j = 0; j < DIR.ALL.size(); j++) {
/*     */ 
/*     */         
/*  85 */         DIR d = (DIR)DIR.ALL.get(j);
/*  86 */         int x = d.x() + t.x();
/*  87 */         int y = d.y() + t.y();
/*     */         
/*  89 */         if (SETT.IN_BOUNDS(x, y)) {
/*     */ 
/*     */           
/*  92 */           v = d.tileDistance();
/*  93 */           v *= 1.0D + Math.pow(this.height.get(x, y), 4.0D) * 1.5D;
/*  94 */           v += t.getValue();
/*  95 */           if ((SETT.TERRAIN()).MOUNTAIN.is(x, y))
/*  96 */             v += 2.0D; 
/*  97 */           if (v < t.getValue2())
/*     */           {
/*  99 */             if (GUTIL.flooder().pushSmaller(x, y, (float)v) != null) {
/* 100 */               GUTIL.flooder().setValue2(x, y, t.getValue2());
/*     */             }
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 106 */     GUTIL.flooder().done();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void build(COORDINATE wtt, SettlementGrid.Tile ut) {
/* 114 */     if (!(WORLD.WATER()).RIVER_SMALL.is(wtt)) {
/*     */       return;
/*     */     }
/* 117 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 118 */       DIR dStart = (DIR)DIR.ORTHO.get(i);
/* 119 */       if ((WORLD.WATER()).has.is(wtt, dStart)) {
/* 120 */         int startX = ut.coo(dStart).x();
/* 121 */         int startY = ut.coo(dStart).y();
/*     */         
/* 123 */         for (int j = i + 1; j < DIR.ORTHO.size(); j++) {
/* 124 */           DIR dEnd = (DIR)DIR.ORTHO.get(j);
/* 125 */           if ((WORLD.WATER()).has.is(wtt, dEnd)) {
/* 126 */             int endX = ut.coo(dEnd).x();
/* 127 */             int endY = ut.coo(dEnd).y();
/* 128 */             pave(positions(startX, startY, dStart, false), positions(endX, endY, dEnd, false), ut.bounds, 1.0D, 1.0D);
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
/*     */   private LinkedList<Coo> positions(int x, int y, DIR d, boolean delta) {
/* 140 */     if (x < 0) {
/* 141 */       x = 0;
/*     */     }
/* 143 */     if (x >= SETT.TWIDTH) {
/* 144 */       x = SETT.TWIDTH - 1;
/*     */     }
/* 146 */     if (y < 0) {
/* 147 */       y = 0;
/*     */     }
/* 149 */     if (y >= SETT.THEIGHT) {
/* 150 */       y = SETT.THEIGHT - 1;
/*     */     }
/*     */     
/* 153 */     int start = delta ? SettlementGrid.QUAD_QUATER : 0;
/* 154 */     int width = this.width;
/* 155 */     if (delta) {
/* 156 */       width *= 2;
/*     */     }
/* 158 */     LinkedList<Coo> res = new LinkedList();
/* 159 */     if (d.x() != 0) {
/* 160 */       for (int i = start; i < SettlementGrid.QUAD_SIZE * 2 && res.size() < width; i++) {
/* 161 */         if (SETT.IN_BOUNDS(x, y + i) && this.polly.isEdge(x, y + i)) {
/* 162 */           res.add(new Coo(x, (y + i)));
/*     */         }
/* 164 */         if (SETT.IN_BOUNDS(x, y - i) && this.polly.isEdge(x, y - i)) {
/* 165 */           res.add(new Coo(x, (y - i)));
/*     */         }
/*     */       } 
/*     */     } else {
/* 169 */       for (int i = start; i < SettlementGrid.QUAD_SIZE * 2 && res.size() < width; i++) {
/* 170 */         if (SETT.IN_BOUNDS(x + i, y) && this.polly.isEdge(x + i, y)) {
/* 171 */           res.add(new Coo((x + i), y));
/*     */         }
/* 173 */         if (SETT.IN_BOUNDS(x - i, y) && this.polly.isEdge(x - i, y)) {
/* 174 */           res.add(new Coo((x - i), y));
/*     */         }
/*     */       } 
/*     */     } 
/* 178 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void pave(LinkedList<Coo> starts, LinkedList<Coo> ends, final RECTANGLE bounds, double startWidth, double endWidth) {
/* 185 */     PathGame.COST cm = new PathGame.COST()
/*     */       {
/*     */         
/*     */         public double getCost(int fromX, int fromY, int toX, int toY)
/*     */         {
/* 190 */           if (!bounds.holdsPoint(toX, toY)) {
/* 191 */             return 50.0D;
/*     */           }
/* 193 */           if (GeneratorRiverSmall.this.m.topology.MOUNTAIN.is(toX, toY)) {
/* 194 */             return 20.0D;
/*     */           }
/* 196 */           if (GeneratorRiverSmall.this.m.topology.ROCK.is(toX, toY)) {
/* 197 */             return 20.0D;
/*     */           }
/* 199 */           if (!GeneratorRiverSmall.this.polly.isEdge(toX, toY)) {
/* 200 */             return 2.0D;
/*     */           }
/* 202 */           if ((SETT.TERRAIN()).WATER.SHALLOW.is(toX, toY)) {
/* 203 */             return 0.5D;
/*     */           }
/* 205 */           double mul = GeneratorRiverSmall.this.util.checker.is(toX, toY) ? 1.0D : 1.0D;
/*     */           
/* 207 */           return mul;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 212 */     LinkedList<Coo> flood = new LinkedList();
/*     */     
/* 214 */     while (!starts.isEmpty()) {
/*     */       
/* 216 */       Coo s = (Coo)starts.removeFirst();
/* 217 */       Coo e = (Coo)ends.removeFirst();
/* 218 */       ends.add(e);
/* 219 */       if (GUTIL.astar().getShortest(this.p, cm, s.x(), s.y(), e.x(), e.y())) {
/*     */         
/*     */         do
/*     */         {
/*     */ 
/*     */           
/* 225 */           if (!this.util.checker.is((COORDINATE)this.p))
/*     */           
/* 227 */           { this.util.checker.set((COORDINATE)this.p, true); }
/* 228 */           else { (SETT.TERRAIN()).WATER.SHALLOW.is((COORDINATE)this.p);
/*     */              }
/*     */ 
/*     */         
/*     */         }
/* 233 */         while (this.p.setNext());
/*     */       } else {
/* 235 */         LOG.ln("nono");
/*     */       } 
/* 237 */       flood.add(s);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 242 */     GUTIL.flooder().init(this);
/*     */     
/* 244 */     while (!flood.isEmpty()) {
/*     */       
/* 246 */       Coo s = (Coo)flood.removeFirst();
/* 247 */       GUTIL.flooder().pushSloppy((COORDINATE)s, 0.0D);
/*     */     } 
/*     */ 
/*     */     
/* 251 */     while (GUTIL.flooder().hasMore()) {
/* 252 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 253 */       (SETT.TERRAIN()).WATER.SHALLOW.placeRaw(t.x(), t.y());
/* 254 */       double v = t.getValue();
/*     */       
/* 256 */       if (v >= t.getValue2()) {
/*     */         continue;
/*     */       }
/*     */       
/* 260 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/*     */ 
/*     */         
/* 263 */         DIR d = (DIR)DIR.ALL.get(i);
/* 264 */         int x = d.x() + t.x();
/* 265 */         int y = d.y() + t.y();
/*     */         
/* 267 */         if (SETT.IN_BOUNDS(x, y))
/*     */         {
/*     */           
/* 270 */           if (this.util.checker.is((COORDINATE)t, d)) {
/* 271 */             GUTIL.flooder().pushSmaller(x, y, 0.0D);
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 277 */     GUTIL.flooder().done();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorRiverSmall.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */