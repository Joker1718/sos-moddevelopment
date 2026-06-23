/*    */ package settlement.room.infra.inn;
/*    */ 
/*    */ import init.type.NEED;
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import settlement.room.service.module.RoomService;
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
/*    */   extends RoomService
/*    */ {
/*    */   null(RoomBlueprintImp $anonymous0, RoomInitData $anonymous1, NEED $anonymous2) {
/* 33 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public FSERVICE service(int tx, int ty) {
/* 37 */     if (ROOM_INN.this.bed.init(tx, ty) != null)
/* 38 */       return ROOM_INN.this.bed.service; 
/* 39 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\inn\ROOM_INN$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */