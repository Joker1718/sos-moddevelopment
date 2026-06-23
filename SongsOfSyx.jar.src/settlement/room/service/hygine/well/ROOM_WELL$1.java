/*    */ package settlement.room.service.hygine.well;
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
/*    */ class null
/*    */   extends RoomServiceNeed
/*    */ {
/*    */   null(RoomBlueprintImp $anonymous0, RoomInitData $anonymous1) {
/* 26 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public FSERVICE service(int tx, int ty) {
/* 30 */     return ROOM_WELL.this.bed.get(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   public double totalMultiplier() {
/* 35 */     return super.totalMultiplier();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\well\ROOM_WELL$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */