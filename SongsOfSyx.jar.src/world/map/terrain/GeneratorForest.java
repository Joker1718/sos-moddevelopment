/*     */ package world.map.terrain;
/*     */ 
/*     */ import init.constant.Config;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.HeightMap;
/*     */ import snake2d.util.rnd.RND;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GeneratorForest
/*     */ {
/*  17 */   private final HeightMap noise = new HeightMap(WORLD.TWIDTH(), WORLD.THEIGHT(), 16, 4);
/*  18 */   private final HeightMap bigNoise = new HeightMap(WORLD.TWIDTH(), WORLD.THEIGHT(), 64, 64);
/*     */   
/*  20 */   private double tres = 1.0D - (Config.world()).FOREST_AMOUNT;
/*     */ 
/*     */   
/*     */   GeneratorForest(float[][] climate) {
/*  24 */     for (int y = 0; y < WORLD.THEIGHT(); y++) {
/*  25 */       for (int x = 0; x < WORLD.TWIDTH(); x++) {
/*  26 */         (WORLD.FOREST()).amount.set(x, y, 0.0D);
/*  27 */         if ((WORLD.FOREST()).placable.is(x, y) && 
/*  28 */           WORLD.MOISTURE().get(x, y) >= 0.15D) {
/*  29 */           place(x, y, climate[y][x]);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void place(int tx, int ty, double c) {
/*  38 */     double n = this.noise.get(tx, ty) * (0.35D + 0.65D * this.bigNoise.get(tx, ty));
/*  39 */     if (n > 0.8D) {
/*  40 */       n = 0.8D;
/*     */     }
/*  42 */     if ((WORLD.WATER()).RIVER.is(tx, ty)) {
/*  43 */       n += n * 0.05D;
/*     */     }
/*  45 */     double f = 0.0D;
/*  46 */     for (int i = 0; i < DIR.ALL.size(); i++) {
/*  47 */       DIR d = (DIR)DIR.ALL.get(i);
/*  48 */       if ((WORLD.WATER()).RIVER.is(tx, ty, d) || (WORLD.WATER()).LAKE.normal.is(tx, ty, d))
/*  49 */         n += 0.01D; 
/*  50 */       f += WORLD.MOISTURE().get(tx + d.x(), ty + d.y());
/*     */     } 
/*  52 */     f /= DIR.ALL.size();
/*  53 */     n += 0.2D * f;
/*     */ 
/*     */     
/*  56 */     n *= 0.5D + c * 1.2D;
/*  57 */     n = Math.pow(n, 1.5D);
/*     */ 
/*     */ 
/*     */     
/*  61 */     if (WORLD.MOUNTAIN().is(tx, ty)) {
/*  62 */       double h = (WORLD.MOUNTAIN()).heighter.get(tx, ty);
/*  63 */       if (h > 3.0D)
/*     */         return; 
/*  65 */       h = 1.0D - h / 3.0D;
/*  66 */       n -= 0.3D * h;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     if (n > this.tres) {
/*  78 */       n -= this.tres;
/*  79 */       n *= 1.0D / (1.0D - this.tres);
/*  80 */       float r = RND.rFloat();
/*  81 */       n += RND.rBoolean() ? (0.1D * r) : (-0.1D * r);
/*  82 */       if (n > 1.0D)
/*  83 */         n = 1.0D; 
/*  84 */       if (WORLD.MOUNTAIN().is(tx, ty)) {
/*  85 */         double h = (WORLD.MOUNTAIN()).heighter.get(tx, ty);
/*  86 */         if (h > 3.0D)
/*     */           return; 
/*  88 */         n *= 1.0D - h / 3.0D;
/*     */       } 
/*     */       
/*  91 */       (WORLD.FOREST()).amount.set(tx, ty, n);
/*     */     } else {
/*     */       
/*  94 */       float r = RND.rFloat();
/*  95 */       r *= r;
/*  96 */       n += RND.rBoolean() ? (0.3D * r) : (-0.3D * r);
/*  97 */       if (n > 0.6D) {
/*  98 */         n -= 0.6D;
/*  99 */         n *= 1.66D;
/* 100 */         n -= 0.75D - WORLD.MOISTURE().get(tx, ty);
/* 101 */         n *= (RND.rFloat() * RND.rFloat());
/*     */         
/* 103 */         (WORLD.FOREST()).amount.set(tx, ty, n);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\GeneratorForest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */