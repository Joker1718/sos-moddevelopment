/*     */ package world.map.terrain;
/*     */ 
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.HeightMap;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GeneratorOcean
/*     */ {
/*  17 */   private double limit = 0.3D;
/*  18 */   private final boolean[][] check = new boolean[WORLD.THEIGHT()][WORLD.TWIDTH()];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   GeneratorOcean(HeightMap height) {
/*  25 */     for (int y = 0; y < WORLD.THEIGHT(); y++) {
/*  26 */       for (int x = 0; x < WORLD.TWIDTH(); x++) {
/*  27 */         double v = height.get(x, y);
/*  28 */         if (v < this.limit && !WORLD.MOUNTAIN().coversTile(x, y))
/*  29 */         { if (v < this.limit * 0.75D) {
/*  30 */             (WORLD.WATER()).LAKE.deep.placeRaw(x, y);
/*     */           } else {
/*  32 */             (WORLD.WATER()).LAKE.normal.placeRaw(x, y);
/*     */           }  }
/*  34 */         else { (WORLD.WATER()).NOTHING.placeRaw(x, y); }
/*     */       
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  41 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*  42 */       if (((WORLD.WATER()).LAKE.is.is(c) & (this.check[c.y()][c.x()] ? 0 : 1)) != 0) {
/*  43 */         int size = check(c.x(), c.y());
/*  44 */         if (size > 150) {
/*  45 */           size -= 150;
/*  46 */           double ch = size / 2500.0D;
/*  47 */           if (RND.rFloat() < ch) {
/*  48 */             makeOcean(c.x(), c.y());
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int check(int tx, int ty) {
/*  58 */     GUTIL.filler().init(this);
/*  59 */     GUTIL.filler().fill(tx, ty);
/*  60 */     int size = 0;
/*  61 */     while (GUTIL.filler().hasMore()) {
/*  62 */       COORDINATE c = GUTIL.filler().poll();
/*  63 */       if ((WORLD.WATER()).LAKE.is.is(c)) {
/*  64 */         this.check[c.y()][c.x()] = true;
/*  65 */         size++;
/*     */ 
/*     */ 
/*     */         
/*  69 */         for (DIR d : DIR.ORTHO) {
/*  70 */           if (WORLD.IN_BOUNDS(c, d))
/*  71 */             GUTIL.filler().fill(c, d); 
/*     */         } 
/*     */       } 
/*  74 */     }  GUTIL.filler().done();
/*  75 */     return size;
/*     */   }
/*     */ 
/*     */   
/*     */   private int makeOcean(int tx, int ty) {
/*  80 */     GUTIL.filler().init(this);
/*  81 */     GUTIL.filler().fill(tx, ty);
/*  82 */     int size = 0;
/*  83 */     while (GUTIL.filler().hasMore()) {
/*  84 */       COORDINATE c = GUTIL.filler().poll();
/*  85 */       if ((WORLD.WATER()).LAKE.is.is(c)) {
/*  86 */         if ((WORLD.WATER()).LAKE.deep.is(c)) {
/*  87 */           (WORLD.WATER()).OCEAN.deep.placeRaw(c.x(), c.y());
/*     */         } else {
/*  89 */           (WORLD.WATER()).OCEAN.normal.placeRaw(c.x(), c.y());
/*  90 */         }  size++;
/*     */ 
/*     */ 
/*     */         
/*  94 */         for (DIR d : DIR.ORTHO) {
/*  95 */           if (WORLD.IN_BOUNDS(c, d))
/*  96 */             GUTIL.filler().fill(c, d); 
/*     */         } 
/*     */       } 
/*  99 */     }  GUTIL.filler().done();
/* 100 */     return size;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\GeneratorOcean.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */