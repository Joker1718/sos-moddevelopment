/*    */ package settlement.room.service.arena.grand;
/*    */ 
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import settlement.room.service.module.RoomServiceNeed;
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
/*    */   extends RoomServiceNeed
/*    */ {
/*    */   null(RoomBlueprintImp $anonymous0, RoomInitData $anonymous1) {
/* 49 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public FSERVICE service(int tx, int ty) {
/* 53 */     return ROOM_ARENA.this.ser.get(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isGoodTime() {
/* 58 */     return ROOM_ARENA.this.spec.isOpenNow();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\grand\ROOM_ARENA$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */