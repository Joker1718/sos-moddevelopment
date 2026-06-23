/*    */ package settlement.room.spirit.shrine;
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
/*    */ class null
/*    */   extends RoomService
/*    */ {
/*    */   null(RoomBlueprintImp $anonymous0, RoomInitData $anonymous1, NEED $anonymous2) {
/* 32 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public FSERVICE service(int tx, int ty) {
/* 36 */     return ROOM_SHRINE.this.bed.get(tx, ty);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\shrine\ROOM_SHRINE$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */