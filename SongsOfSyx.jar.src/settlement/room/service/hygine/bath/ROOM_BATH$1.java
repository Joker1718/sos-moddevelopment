/*    */ package settlement.room.service.hygine.bath;
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
/*    */ class null
/*    */   extends RoomServiceNeed
/*    */ {
/*    */   null(RoomBlueprintImp $anonymous0, RoomInitData $anonymous1) {
/* 48 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   public FSERVICE service(int tx, int ty) {
/* 51 */     return Bath.init(tx, ty, ROOM_BATH.this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\bath\ROOM_BATH$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */