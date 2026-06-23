/*     */ package settlement.tilemap.generator;
/*     */ 
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import settlement.main.SettlementGrid;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.Polymap;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GeneratorLake
/*     */ {
/*  19 */   private final int PS = 4;
/*     */   
/*     */   private final Polymap polly;
/*     */   
/*     */   private final double radius;
/*     */   
/*     */   GeneratorLake(CapitolArea area, GeneratorUtil util) {
/*  26 */     this.radius = util.json.d("LAKE_SIZE", 0.1D, 1.0D) * 200.0D;
/*     */     
/*  28 */     this.polly = util.polly;
/*  29 */     this.polly.checkInit();
/*     */     
/*  31 */     for (int i = 0; i < SETT.GRID.tiles().size(); i++) {
/*  32 */       SettlementGrid.Tile t = SETT.GRID.tile(i);
/*     */       
/*  34 */       COORDINATE wt = (COORDINATE)area.ts().get(i);
/*     */       
/*  36 */       if ((WORLD.WATER()).LAKE.is.is(wt))
/*     */       {
/*  38 */         for (DIR d : t.getDirs()) {
/*  39 */           if ((WORLD.WATER()).LAKE.is.is(wt, d)) {
/*  40 */             sink(t.cooInner(d));
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  48 */     GUTIL.filler().init(this);
/*  49 */     for (int y = 0; y < SETT.TWIDTH; y++) {
/*  50 */       for (int x = 0; x < SETT.TWIDTH; x++) {
/*     */         
/*  52 */         if (util.polly.checker.is(x / 4, y / 4)) {
/*  53 */           GUTIL.filler().fill(x, y);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  60 */     util.polly.checkInit();
/*  61 */     while (GUTIL.filler().hasMore()) {
/*     */       
/*  63 */       COORDINATE t = GUTIL.filler().poll();
/*  64 */       util.polly.checker.set(t, true);
/*     */ 
/*     */ 
/*     */       
/*  68 */       if (RND.oneIn(500)) {
/*  69 */         int x = (int)(t.x() + (RND.rBoolean() ? (RND.rExpo() * 20.0F) : (-RND.rExpo() * 20.0F)));
/*  70 */         int j = (int)(t.y() + (RND.rBoolean() ? (RND.rExpo() * 20.0F) : (-RND.rExpo() * 20.0F)));
/*  71 */         util.polly.checker.set(x, j, true);
/*     */       } 
/*     */     } 
/*     */     
/*  75 */     GUTIL.filler().done();
/*     */     
/*  77 */     int islands = (int)(util.json.d("LAKE_ISLANDS", 0.0D, 1.0D) * 100.0D);
/*     */ 
/*     */ 
/*     */     
/*  81 */     if (islands != 0)
/*     */     {
/*  83 */       for (int j = RND.rInt(islands); j > 0; j--) {
/*  84 */         int x = RND.rInt(SETT.TWIDTH);
/*  85 */         int k = RND.rInt(SETT.THEIGHT);
/*  86 */         util.polly.checker.set(x, k, false);
/*  87 */         for (int l = RND.rInt(20); l > 0; l--) {
/*  88 */           int x2 = x + RND.rInt0(30);
/*  89 */           int y2 = k + RND.rInt0(30);
/*  90 */           util.polly.checker.set(x2, y2, false);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  96 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*  97 */       if (this.polly.checker.is(c.x(), c.y()) && 
/*  98 */         util.height.get(c) < 0.8D) {
/*  99 */         (SETT.TERRAIN()).WATER.SHALLOW.placeRaw(c.x(), c.y());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sink(int cx, int cy) {
/* 110 */     for (int y1 = (int)-this.radius; y1 < this.radius; y1++) {
/* 111 */       int ty = y1 + cy;
/* 112 */       if (ty >= 0 && ty < SETT.TWIDTH)
/*     */       {
/* 114 */         for (int x1 = (int)-this.radius; x1 < this.radius; x1++) {
/* 115 */           int tx = cx + x1;
/* 116 */           if (tx >= 0 && tx < SETT.TWIDTH) {
/*     */             
/* 118 */             double d = Math.sqrt((x1 * x1 + y1 * y1));
/* 119 */             if (d < this.radius)
/*     */             {
/* 121 */               this.polly.checker.set(tx / 4, ty / 4, true);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sink(COORDINATE c) {
/* 132 */     sink(c.x(), c.y());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorLake.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */