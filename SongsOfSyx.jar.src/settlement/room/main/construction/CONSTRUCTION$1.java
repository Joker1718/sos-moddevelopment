/*    */ package settlement.room.main.construction;
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
/*    */ class null
/*    */   implements MAP_BOOLEAN
/*    */ {
/*    */   public boolean is(int tx, int ty) {
/* 36 */     return ((SETT.ROOMS()).map.blueprint.get(tx, ty) == CONSTRUCTION.this.construction);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tile) {
/* 41 */     return ((SETT.ROOMS()).map.blueprint.get(tile) == CONSTRUCTION.this.construction);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\construction\CONSTRUCTION$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */