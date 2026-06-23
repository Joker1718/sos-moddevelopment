/*    */ package settlement.tilemap.generator;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.misc.ACTION;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/*    */     int y;
/* 41 */     for (y = 0; y < SETT.THEIGHT; y++) {
/* 42 */       for (int x = 0; x < SETT.TWIDTH; x++) {
/* 43 */         if ((SETT.TILE_MAP()).growth.current(x, y) != (SETT.TILE_MAP()).growth.nothing) {
/* 44 */           (SETT.TERRAIN()).NADA.placeFixed(x, y);
/* 45 */           (SETT.TILE_MAP()).growth.nothing.set(x, y, 0.0D);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 50 */     for (y = 0; y < SETT.THEIGHT; y++) {
/* 51 */       for (int x = 0; x < SETT.TWIDTH; x++) {
/* 52 */         SETT.TERRAIN().get(x, y).placeFixed(x, y);
/* 53 */         (SETT.PATH()).availability.updateAvailability(x, y);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\generator\GeneratorTests$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */