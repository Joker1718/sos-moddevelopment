/*    */ package settlement.tilemap.generator;
/*    */ 
/*    */ import settlement.main.CapitolArea;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.PathTile;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.rnd.RND;
/*    */ import util.GUTIL;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class GeneratorWaterFin
/*    */ {
/*    */   GeneratorWaterFin(CapitolArea area, GeneratorUtil util) {
/* 21 */     addDepth(area, util);
/*    */   }
/*    */ 
/*    */   
/*    */   private void addDepth(CapitolArea area, GeneratorUtil util) {
/* 26 */     GUTIL.flooder().init(this);
/*    */     
/* 28 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/* 29 */       if (!(SETT.TERRAIN()).WATER.SHALLOW.is(c)) {
/* 30 */         GUTIL.flooder().pushSloppy(c, 0.0D);
/* 31 */         GUTIL.flooder().setValue2(c, (1.0F + RND.rExpo() * 50.0F));
/*    */       } 
/*    */     } 
/*    */     
/* 35 */     while (GUTIL.flooder().hasMore()) {
/*    */       
/* 37 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 38 */       double v2 = t.getValue();
/*    */       
/* 40 */       if ((SETT.TERRAIN()).WATER.SHALLOW.is((COORDINATE)t)) {
/* 41 */         if (v2 < 4.0D) {
/* 42 */           (SETT.TERRAIN()).NADA.placeRaw(t.x(), t.y());
/*    */         } else {
/* 44 */           double v = v2 * Math.pow(CLAMP.d(util.height.get((COORDINATE)t), 0.0D, 1.0D), 1.7D);
/* 45 */           if (v > 4.0D) {
/* 46 */             (SETT.TERRAIN()).WATER.DEEP.placeRaw(t.x(), t.y());
/*    */           }
/*    */         } 
/*    */       }
/*    */       
/* 51 */       for (DIR d : DIR.ALL) {
/*    */         
/* 53 */         int x = t.x() + d.x();
/* 54 */         int y = t.y() + d.y();
/* 55 */         if (SETT.IN_BOUNDS(x, y)) {
/* 56 */           double v = v2;
/* 57 */           if (v2 >= 4.0D) {
/* 58 */             v += d.tileDistance();
/*    */           } else {
/* 60 */             v += d.tileDistance() * t.getValue2();
/*    */           } 
/* 62 */           if (v > 0.0D && 
/* 63 */             GUTIL.flooder().pushSmaller(x, y, v) != null) {
/* 64 */             GUTIL.flooder().setValue2(x, y, t.getValue2());
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 75 */     GUTIL.flooder().done();
/*    */ 
/*    */ 
/*    */     
/* 79 */     (SETT.TERRAIN()).WATER.groundWater.clear();
/* 80 */     GUTIL.flooder().init(this);
/* 81 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/* 82 */       if ((SETT.TERRAIN()).WATER.SHALLOW.is(c)) {
/* 83 */         GUTIL.flooder().pushSloppy(c, 0.0D);
/*    */       }
/*    */     } 
/* 86 */     while (GUTIL.flooder().hasMore()) {
/* 87 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 88 */       if (t.getValue() > 8.0F)
/*    */         break; 
/* 90 */       (SETT.TERRAIN()).WATER.groundWater.set((COORDINATE)t, true);
/* 91 */       for (DIR d : DIR.ALL) {
/* 92 */         if (SETT.IN_BOUNDS((COORDINATE)t, d)) {
/* 93 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance());
/*    */         }
/*    */       } 
/*    */     } 
/* 97 */     GUTIL.flooder().done();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorWaterFin.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */