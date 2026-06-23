/*     */ package settlement.tilemap.generator;
/*     */ 
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.Polymap;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class GeneratorLakeExtra
/*     */ {
/*     */   private final Polymap polly;
/*     */   
/*     */   GeneratorLakeExtra(CapitolArea area, GeneratorUtil util) {
/*  20 */     this.polly = util.polly;
/*  21 */     this.polly.checkInit();
/*     */ 
/*     */     
/*  24 */     extraLake(area, util);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void extraLake(CapitolArea area, GeneratorUtil util) {
/*  32 */     if (area.isBattle)
/*     */       return; 
/*  34 */     int am = 0;
/*  35 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*  36 */       if ((SETT.TERRAIN()).WATER.is.is(c) && (SETT.TERRAIN()).WATER.groundWater.is(c.x(), c.y())) {
/*  37 */         am++;
/*     */       }
/*     */     } 
/*  40 */     if (am > 100) {
/*     */       return;
/*     */     }
/*  43 */     util.polly.checkInit();
/*     */     
/*  45 */     GUTIL.flooder().init(this);
/*     */     
/*  47 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*  48 */       if (SETT.TILE_BOUNDS.isOnEdge(c.x(), c.y()) || (SETT.TERRAIN()).MOUNTAIN.is(c) || (SETT.TERRAIN()).WATER.is.is(c)) {
/*  49 */         GUTIL.flooder().pushSloppy(c, 0.0D);
/*  50 */         GUTIL.flooder().setValue2(c, 1.0D);
/*     */       } 
/*     */     } 
/*     */     
/*  54 */     while (GUTIL.flooder().hasMore()) {
/*  55 */       PathTile t = GUTIL.flooder().pollSmallest();
/*  56 */       if (t.getValue() > 48.0F)
/*     */         break; 
/*  58 */       for (DIR d : DIR.ALL) {
/*  59 */         if (SETT.IN_BOUNDS((COORDINATE)t, d)) {
/*  60 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  68 */     double b = 0.0D;
/*  69 */     int tx = SETT.TWIDTH / 2;
/*  70 */     int ty = SETT.THEIGHT / 2;
/*  71 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/*  72 */       if (!GUTIL.flooder().hasBeenPushed(c.x(), c.y())) {
/*  73 */         double d = RND.rFloat();
/*  74 */         if (d >= b) {
/*  75 */           b = d;
/*  76 */           tx = c.x();
/*  77 */           ty = c.y();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  82 */     GUTIL.flooder().done();
/*     */     
/*  84 */     int radius = 12;
/*  85 */     for (int y1 = -radius; y1 < radius; y1++) {
/*  86 */       int y = y1 + ty;
/*  87 */       if (y >= 0 && y < SETT.TWIDTH)
/*     */       {
/*  89 */         for (int x1 = -radius; x1 < radius; x1++) {
/*  90 */           int x = tx + x1;
/*  91 */           if (x >= 0 && x < SETT.TWIDTH) {
/*     */             
/*  93 */             double d = Math.sqrt((x1 * x1 + y1 * y1));
/*  94 */             if (d < radius)
/*     */             {
/*  96 */               this.polly.checker.set(x, y, true);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     GUTIL.flooder().init(this);
/*     */     
/* 109 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/* 110 */       if (this.polly.checker.is(c.x(), c.y()) && 
/* 111 */         util.height.get(c) < 0.8D) {
/* 112 */         (SETT.TERRAIN()).WATER.SHALLOW.placeRaw(c.x(), c.y());
/*     */         
/* 114 */         GUTIL.flooder().pushSloppy(c, 0.0D);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 119 */     while (GUTIL.flooder().hasMore()) {
/* 120 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 121 */       if (t.getValue() > 8.0F)
/*     */         break; 
/* 123 */       (SETT.TERRAIN()).WATER.groundWater.set((COORDINATE)t, true);
/* 124 */       for (DIR d : DIR.ALL) {
/* 125 */         if (SETT.IN_BOUNDS((COORDINATE)t, d)) {
/* 126 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance());
/*     */         }
/*     */       } 
/*     */     } 
/* 130 */     GUTIL.flooder().done();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorLakeExtra.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */