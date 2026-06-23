/*    */ package settlement.tilemap.generator;
/*    */ 
/*    */ import settlement.main.CapitolArea;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class GeneratorFertilityFin
/*    */ {
/*    */   static final double T_ROCK = 0.3D;
/*    */   
/*    */   GeneratorFertilityFin(CapitolArea area, GeneratorUtil util) {
/* 17 */     SETT.GROUND().setColors((area.climate()).colorGroundDry, (area.climate()).colorGroundWet, 0.0D);
/*    */     
/* 19 */     for (int y = 0; y < SETT.THEIGHT; y++) {
/* 20 */       for (int x = 0; x < SETT.TWIDTH; x++) {
/* 21 */         if (SETT.TERRAIN().is(x, y)) {
/* 22 */           SETT.TERRAIN().get(x, y).placeFixed(x, y);
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 27 */     (SETT.ENV()).map.initWater();
/*    */     
/* 29 */     for (COORDINATE c : new Rec(SETT.TILE_BOUNDS)) {
/*    */       
/* 31 */       int x = c.x();
/* 32 */       int i = c.y();
/*    */       
/* 34 */       double v = util.fer.get(c.x(), c.y());
/*    */       
/* 36 */       util.fer.set(c, v);
/* 37 */       v = util.fer.get(c.x(), c.y());
/*    */ 
/*    */ 
/*    */       
/* 41 */       (SETT.GRASS()).current.set(x, i, v);
/*    */       
/* 43 */       SETT.GRASS().grow(c.x(), c.y(), 16);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorFertilityFin.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */