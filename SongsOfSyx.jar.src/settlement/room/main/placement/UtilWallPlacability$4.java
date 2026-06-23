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
/* 70 */     return (SETT.IN_BOUNDS(tx, ty) && !(SETT.ROOMS()).map.is(tx, ty) && UtilWallPlacability.get(tx, ty).isMassiveWall());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tile) {
/* 75 */     return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\UtilWallPlacability$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */