/*    */ package settlement.room.health.hospital;
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
/* 45 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public FSERVICE service(int tx, int ty) {
/* 49 */     return Bed.service(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   public double totalMultiplier() {
/* 54 */     return 1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\hospital\ROOM_HOSPITAL$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */