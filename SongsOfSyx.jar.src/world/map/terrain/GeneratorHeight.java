/*     */ package world.map.terrain;
/*     */ 
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.map.MAP_BOOLEANE;
/*     */ import snake2d.util.rnd.HeightMap;
/*     */ import snake2d.util.rnd.Polymap;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ import world.WorldGen;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GeneratorHeight
/*     */ {
/*  22 */   private final Polymap polly = new Polymap(WORLD.TWIDTH(), WORLD.THEIGHT(), (int)(60.0D * WORLD.TWIDTH() / 256.0D), 1.0D);
/*     */   private final MAP_BOOLEANE checker;
/*     */   private final HeightMap height;
/*     */   
/*     */   GeneratorHeight(HeightMap height, WorldGen spec) {
/*  27 */     this.height = height;
/*  28 */     this.polly.checkInit();
/*  29 */     this.checker = this.polly.checker;
/*  30 */     rise();
/*     */     
/*  32 */     sink(height);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void sink(HeightMap height) {
/*  38 */     int max = WORLD.TAREA() / 2;
/*     */     
/*  40 */     while (max > 0) {
/*  41 */       max -= sink(height, 1000, (16.0F + RND.rFloat(32.0D)));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void rise() {
/*  49 */     int max = WORLD.TAREA() / 4;
/*     */     
/*  51 */     while (max > 0) {
/*  52 */       max -= rise(this.height, RND.rInt(1000), RND.rInt(16));
/*     */     }
/*     */   }
/*     */   
/*     */   private int sink(HeightMap height, int maxLength, double radius) {
/*  57 */     double sx = RND.rInt(WORLD.TWIDTH());
/*  58 */     double sy = RND.rInt(WORLD.THEIGHT());
/*     */     
/*  60 */     VectorImp dir = new VectorImp();
/*  61 */     dir.setAngle((RND.rFloat() * 10.0F));
/*     */     
/*  63 */     GUTIL.flooder().init(this);
/*  64 */     GUTIL.flooder().pushSloppy((int)sx, (int)sy, 0.0D);
/*     */     
/*  66 */     for (int i = 0; i < maxLength; i++) {
/*     */       
/*  68 */       sx += dir.nX();
/*  69 */       sy += dir.nY();
/*  70 */       dir.rotate(RND.rInt0(20));
/*  71 */       if (!WORLD.IN_BOUNDS((int)sx, (int)sy)) {
/*     */         break;
/*     */       }
/*  74 */       GUTIL.flooder().pushSloppy((int)sx, (int)sy, 0.0D);
/*     */     } 
/*     */     
/*  77 */     int am = 0;
/*     */     
/*  79 */     while (GUTIL.flooder().hasMore()) {
/*     */       
/*  81 */       PathTile t = GUTIL.flooder().pollSmallest();
/*  82 */       double v = t.getValue() / radius;
/*  83 */       if (v >= 1.0D)
/*     */         continue; 
/*  85 */       v *= v;
/*  86 */       am++;
/*     */ 
/*     */       
/*  89 */       height.set((COORDINATE)t, height.get((COORDINATE)t) * (0.4D + 0.6D * v));
/*  90 */       for (DIR d : DIR.ALL) {
/*  91 */         if (WORLD.IN_BOUNDS((COORDINATE)t, d)) {
/*  92 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  97 */     GUTIL.flooder().done();
/*  98 */     return am;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int rise(HeightMap height, int maxLength, double radius) {
/* 104 */     this.polly.checkInit();
/*     */     
/* 106 */     double sx = RND.rInt(WORLD.TWIDTH());
/* 107 */     double sy = RND.rInt(WORLD.THEIGHT());
/*     */     
/* 109 */     VectorImp dir = new VectorImp();
/* 110 */     dir.setAngle((RND.rFloat() * 10.0F));
/*     */     
/* 112 */     GUTIL.flooder().init(this);
/* 113 */     GUTIL.flooder().pushSloppy((int)sx, (int)sy, 0.0D);
/*     */     
/* 115 */     int l2 = maxLength / 2;
/*     */     
/* 117 */     for (int i = 0; i < maxLength; i++) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 122 */       sx += dir.nX();
/* 123 */       sy += dir.nY();
/* 124 */       dir.rotate(RND.rInt0(15));
/* 125 */       if (!WORLD.IN_BOUNDS((int)sx, (int)sy)) {
/*     */         break;
/*     */       }
/* 128 */       GUTIL.flooder().pushSloppy((int)sx, (int)sy, 0.0D);
/* 129 */       this.polly.checker.set((int)sx, (int)sy, true);
/*     */       
/* 131 */       int ra = (int)(radius * (l2 - MATH.distanceC(l2, i, maxLength)) / l2);
/* 132 */       if (ra > 0) {
/* 133 */         for (int k = 0; k < 4; k++) {
/* 134 */           int x = (int)sx + RND.rInt0(ra);
/* 135 */           int y = (int)sy + RND.rInt0(ra);
/* 136 */           if (WORLD.IN_BOUNDS(x, y)) {
/* 137 */             GUTIL.flooder().pushSloppy(x, y, 0.0D);
/* 138 */             this.checker.set(x, y, true);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 146 */     int am = 0;
/*     */     
/* 148 */     while (GUTIL.flooder().hasMore()) {
/*     */ 
/*     */ 
/*     */       
/* 152 */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       
/* 154 */       double v = 0.0D;
/*     */       
/* 156 */       if (this.checker.is((COORDINATE)t)) {
/* 157 */         height.set((COORDINATE)t, height.get((COORDINATE)t) * 20.0D);
/* 158 */         am++;
/* 159 */       } else if (t.getValue() < 3.0F) {
/*     */         
/* 161 */         height.set((COORDINATE)t, height.get((COORDINATE)t) * (2.0D - (t.getValue() / 3.0F)));
/*     */         
/* 163 */         v = 1.0D;
/*     */       } else {
/*     */         continue;
/*     */       } 
/* 167 */       am++;
/*     */       
/* 169 */       for (DIR d : DIR.ALL) {
/* 170 */         if (WORLD.IN_BOUNDS((COORDINATE)t, d)) {
/* 171 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + v * d.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 176 */     GUTIL.flooder().done();
/* 177 */     return am;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\GeneratorHeight.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */