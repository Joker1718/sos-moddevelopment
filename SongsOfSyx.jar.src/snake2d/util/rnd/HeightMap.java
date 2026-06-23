/*     */ package snake2d.util.rnd;
/*     */ 
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.map.MAP_DOUBLEE;
/*     */ 
/*     */ public class HeightMap
/*     */   implements MAP_DOUBLEE
/*     */ {
/*     */   private final float[][] spheric;
/*     */   
/*     */   public HeightMap(int width, int height, int startSize, int endSize) {
/*  12 */     OpenSimplexNoise noise = new OpenSimplexNoise(RND.rLong());
/*  13 */     double FEATURE_SIZE = startSize;
/*  14 */     this.spheric = new float[height][width];
/*     */     
/*  16 */     double max = 0.0D;
/*  17 */     double min = 1.0D;
/*     */     
/*  19 */     for (int y = 0; y < height; y++) {
/*  20 */       for (int x = 0; x < width; x++) {
/*  21 */         double v = 0.0D;
/*  22 */         double size = FEATURE_SIZE;
/*  23 */         int j = 1;
/*  24 */         while (size >= endSize) {
/*  25 */           v += noise.eval(x / size, y / size) / j;
/*  26 */           size /= 2.0D;
/*  27 */           j++;
/*     */         } 
/*  29 */         this.spheric[y][x] = (float)v;
/*  30 */         if (v > max)
/*  31 */           max = v; 
/*  32 */         if (v < min) {
/*  33 */           min = v;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  39 */     double range = max - min;
/*  40 */     double d = 1.0D / range;
/*     */     
/*  42 */     for (int i = 0; i < height; i++) {
/*  43 */       for (int x = 0; x < width; x++) {
/*  44 */         double v = this.spheric[i][x];
/*  45 */         v -= min;
/*  46 */         v *= d;
/*  47 */         this.spheric[i][x] = (float)v;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double get(int tx, int ty) {
/*  57 */     return this.spheric[ty][tx];
/*     */   }
/*     */ 
/*     */   
/*     */   public HeightMap set(int tx, int ty, double value) {
/*  62 */     if (tx >= 0 && tx < (this.spheric[0]).length && ty >= 0 && ty < this.spheric.length)
/*  63 */       this.spheric[ty][tx] = (float)value; 
/*  64 */     return this;
/*     */   }
/*     */   
/*     */   public void sink(int cx, int cy, int radius, double leaveBelow, double leaveAbove) {
/*  68 */     double ri = 1.0D / radius;
/*     */     
/*  70 */     for (int y1 = -radius; y1 < radius; y1++) {
/*  71 */       int ty = y1 + cy;
/*  72 */       if (ty >= 0 && ty < this.spheric.length)
/*     */       {
/*  74 */         for (int x1 = -radius; x1 < radius; x1++) {
/*  75 */           int tx = cx + x1;
/*  76 */           if (tx >= 0 && tx < (this.spheric[0]).length) {
/*     */             
/*  78 */             double v = this.spheric[ty][tx];
/*  79 */             if (v >= leaveBelow)
/*     */             {
/*  81 */               if (v <= leaveAbove) {
/*     */ 
/*     */                 
/*  84 */                 double d = Math.sqrt((x1 * x1 + y1 * y1));
/*     */                 
/*  86 */                 if (d < radius)
/*  87 */                   this.spheric[ty][tx] = (float)(this.spheric[ty][tx] * ri * d); 
/*     */               }  } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void sink(COORDINATE c, int radius, double leaveBelow, double leaveAbove) {
/*  96 */     sink(c.x(), c.y(), radius, leaveBelow, leaveAbove);
/*     */   }
/*     */ 
/*     */   
/*     */   public void rise(int x, int y, double r, double bonus) {
/* 101 */     double ri = 1.0D / r;
/*     */     
/* 103 */     for (int y1 = (int)-r; y1 < r; y1++) {
/* 104 */       int ty = y1 + y;
/* 105 */       if (ty >= 0 && ty < this.spheric.length)
/*     */       {
/* 107 */         for (int x1 = (int)-r; x1 < r; x1++) {
/* 108 */           int tx = x + x1;
/* 109 */           if (tx >= 0 && tx < (this.spheric[0]).length) {
/*     */             
/* 111 */             double d = Math.sqrt((x1 * x1 + y1 * y1));
/*     */             
/* 113 */             if (d < r) {
/* 114 */               this.spheric[ty][tx] = (float)(this.spheric[ty][tx] + (1.0D - this.spheric[ty][tx]) * (1.0D - ri * d) + bonus * (1.0D - ri * d));
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double get(int tile) {
/* 125 */     return get(tile % this.spheric.length, tile / this.spheric.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public MAP_DOUBLEE set(int tile, double value) {
/* 130 */     throw new RuntimeException();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\rnd\HeightMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */