/*     */ package world.map.terrain;
/*     */ 
/*     */ import init.type.CLIMATES;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GeneratorSeasoner
/*     */ {
/*  24 */   private double heightMul = 0.5D;
/*  25 */   private double climateMul = 0.2D;
/*     */   
/*     */   GeneratorSeasoner(WORLD m, double value, float[][] climate) {
/*  28 */     HeightMap height = new HeightMap(WORLD.TWIDTH(), WORLD.THEIGHT(), WORLD.TWIDTH() / 8, 4);
/*  29 */     double equator = WORLD.THEIGHT() * value;
/*  30 */     double dSouth = WORLD.THEIGHT() - equator;
/*     */     
/*  32 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*  33 */       double d = 0.0D;
/*  34 */       if (c.y() <= equator) {
/*  35 */         d = c.y() / equator;
/*  36 */         d = d * (1.0D - this.heightMul) + this.heightMul * (1.0D - height.get(c));
/*     */         
/*  38 */         double cl = c.y() / equator;
/*  39 */         cl = cl * (1.0D - this.climateMul) + this.climateMul * (1.0D - height.get(c));
/*     */         
/*  41 */         cl *= RND.rFloat1(0.3D);
/*     */         
/*  43 */         if (cl < 0.4D) {
/*  44 */           (WORLD.CLIMATE()).setter.set(c, CLIMATES.COLD());
/*     */         } else {
/*  46 */           (WORLD.CLIMATE()).setter.set(c, CLIMATES.TEMP());
/*     */         } 
/*     */       } else {
/*     */         
/*  50 */         d = 1.0D - (c.y() - equator) / dSouth;
/*  51 */         d = d * (1.0D - this.heightMul) + this.heightMul * (1.0D - height.get(c));
/*     */         
/*  53 */         double cl = 1.0D - (c.y() - equator) / dSouth;
/*  54 */         cl = cl * (1.0D - this.climateMul) + this.climateMul * (1.0D - height.get(c));
/*  55 */         cl *= RND.rFloat1(0.3D);
/*  56 */         if (cl < 0.3D) {
/*  57 */           (WORLD.CLIMATE()).setter.set(c, CLIMATES.HOT());
/*     */         } else {
/*  59 */           (WORLD.CLIMATE()).setter.set(c, CLIMATES.TEMP());
/*     */         } 
/*     */       } 
/*  62 */       climate[c.y()][c.x()] = (float)d + RND.rFloat0(0.05D);
/*     */     } 
/*     */     
/*  65 */     GUTIL.flooder().init(this);
/*     */     
/*  67 */     double waterBonus = 1.0D;
/*  68 */     double waterSpread = 8.0D;
/*     */     
/*  70 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/*  71 */       if ((WORLD.WATER()).has.is(c.x(), c.y())) {
/*  72 */         if ((WORLD.WATER()).fertile.is(c.x(), c.y())) {
/*  73 */           GUTIL.flooder().pushSloppy(c, waterBonus * waterSpread); continue;
/*     */         } 
/*  75 */         GUTIL.flooder().pushSloppy(c, waterBonus * waterSpread * 0.85D);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  80 */     while (GUTIL.flooder().hasMore()) {
/*  81 */       PathTile t = GUTIL.flooder().pollGreatest();
/*  82 */       double bonus = t.getValue() / waterSpread;
/*  83 */       climate[t.y()][t.x()] = (float)(climate[t.y()][t.x()] + 0.7D * this.heightMul * bonus * bonus);
/*     */ 
/*     */       
/*  86 */       for (DIR d : DIR.ALL) {
/*  87 */         double v = t.getValue() - d.tileDistance();
/*  88 */         if (v > 0.0D && WORLD.IN_BOUNDS(t.x(), t.y(), d)) {
/*  89 */           GUTIL.flooder().pushGreater((COORDINATE)t, d, v);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  95 */     GUTIL.flooder().done();
/*     */     
/*  97 */     double mValue = 0.6D;
/*  98 */     for (int y = 0; y < WORLD.THEIGHT(); y++) {
/*  99 */       double mountain = 0.0D; int x;
/* 100 */       for (x = 0; x < WORLD.TWIDTH(); x++) {
/* 101 */         if (WORLD.MOUNTAIN().is(x, y)) {
/* 102 */           mountain = CLAMP.d(mountain + 2.0D, 0.0D, 10.0D);
/*     */         }
/* 104 */         if (mountain > 0.0D) {
/*     */           
/* 106 */           double d = Math.pow(mountain / 10.0D, 1.5D);
/* 107 */           climate[y][x] = (float)(climate[y][x] - mValue * d);
/* 108 */           mountain = CLAMP.d(mountain - 1.0D, 0.0D, 10.0D);
/*     */         } 
/*     */       } 
/*     */       
/* 112 */       mountain = 0.0D;
/* 113 */       for (x = WORLD.TWIDTH() - 1; x >= 0; x--) {
/* 114 */         if (WORLD.MOUNTAIN().is(x, y)) {
/* 115 */           mountain = CLAMP.d(mountain + 2.0D, 0.0D, 10.0D);
/*     */         }
/* 117 */         if (mountain > 0.0D) {
/*     */           
/* 119 */           double d = Math.pow(mountain / 10.0D, 1.5D);
/* 120 */           climate[y][x] = (float)(climate[y][x] + mValue * d);
/* 121 */           mountain = CLAMP.d(mountain - 1.0D, 0.0D, 10.0D);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 127 */     double highest = 0.0D;
/*     */ 
/*     */ 
/*     */     
/* 131 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 132 */       double d = climate[c.y()][c.x()];
/* 133 */       if (d > highest) {
/* 134 */         highest = d;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 139 */     for (COORDINATE c : WORLD.TBOUNDS()) {
/* 140 */       double d = climate[c.y()][c.x()] / highest;
/* 141 */       d *= 1.25D;
/* 142 */       d = CLAMP.d(d, 0.0D, 1.0D);
/*     */       
/* 144 */       d -= 0.2D;
/* 145 */       d /= 0.8D;
/* 146 */       d *= 2.5D;
/*     */       
/* 148 */       int j = (int)Math.round((WORLD.GROUND().all().size() - 1) * (1.0D - d));
/* 149 */       j = CLAMP.i(j, 0, WORLD.GROUND().all().size() - 1);
/* 150 */       ((WorldGround.WGROUND)WORLD.GROUND().all().get(j)).placeRaw(c.x(), c.y());
/*     */     } 
/*     */     
/*     */     int i;
/* 154 */     for (i = 0; i < WORLD.THEIGHT(); i++) {
/* 155 */       for (int x = 0; x < WORLD.TWIDTH(); x++) {
/* 156 */         ((WorldGround.WGROUND)(WORLD.GROUND()).getter.get(x, i)).place(x, i, null, null);
/*     */       }
/*     */     } 
/*     */     
/* 160 */     for (i = 0; i < WORLD.THEIGHT(); i++) {
/* 161 */       for (int x = 0; x < WORLD.TWIDTH(); x++) {
/* 162 */         ((WorldGround.WGROUND)(WORLD.GROUND()).getter.get(x, i)).place(x, i, null, null);
/*     */       }
/*     */     } 
/*     */     
/* 166 */     for (i = 0; i < WORLD.THEIGHT(); i++) {
/* 167 */       for (int x = 0; x < WORLD.TWIDTH(); x++) {
/* 168 */         ((WorldGround.WGROUND)(WORLD.GROUND()).getter.get(x, i)).place(x, i, null, null);
/*     */       }
/*     */     } 
/*     */     
/* 172 */     for (i = 0; i < WORLD.THEIGHT(); i++) {
/* 173 */       for (int x = 0; x < WORLD.TWIDTH(); x++)
/* 174 */         ((WorldGround.WGROUND)(WORLD.GROUND()).getter.get(x, i)).place(x, i, null, null); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\GeneratorSeasoner.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */