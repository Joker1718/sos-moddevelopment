/*    */ package settlement.room.water;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import snake2d.util.map.MAP_OBJECT;
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
/*    */   implements MAP_OBJECT<RoomPumpable>
/*    */ {
/*    */   public RoomPumpable get(int tile) {
/* 53 */     return get(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*    */   }
/*    */ 
/*    */   
/*    */   public RoomPumpable get(int tx, int ty) {
/* 58 */     RoomBlueprint p = (RoomBlueprint)(SETT.ROOMS()).map.blueprint.get(tx, ty);
/* 59 */     if (p != null && p instanceof RoomPumpable.ROOM_PUMPABLE)
/* 60 */       return ((RoomPumpable.ROOM_PUMPABLE)p).pumpable(tx, ty); 
/* 61 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\ROOM_WATER$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */