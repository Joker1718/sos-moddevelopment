/*    */ package settlement.room.service.pleasure;
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
/*    */ class null
/*    */   extends RoomServiceNeed
/*    */ {
/*    */   null(RoomBlueprintImp $anonymous0, RoomInitData $anonymous1) {
/* 31 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public FSERVICE service(int tx, int ty) {
/* 35 */     if (ROOM_PLEASURE.this.bed.init(tx, ty) != null)
/* 36 */       return ROOM_PLEASURE.this.bed.service; 
/* 37 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\pleasure\ROOM_PLEASURE$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */