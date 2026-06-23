/*    */ package settlement.room.main.placement;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.map.MAP_BOOLEAN;
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
/*    */   implements MAP_BOOLEAN
/*    */ {
/*    */   public boolean is(int tx, int ty) {
/* 55 */     if (UtilWallPlacability.openingIsReal.is(tx, ty))
/* 56 */       return false; 
/* 57 */     return UtilWallPlacability.openingCanBe.is(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tile) {
/* 62 */     return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\UtilWallPlacability$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */