/*    */ package settlement.room.service.module;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.path.finders.SFinderRoomService;
/*    */ 
/*    */ 
/*    */ public abstract class ROOM_SPECTATOR
/*    */   extends ROOM_ACTIVITY
/*    */ {
/*    */   public abstract RoomServiceAccess service();
/*    */   
/*    */   public SFinderRoomService finder() {
/* 13 */     return (service()).finder;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isOpenNow() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public void doSomeThingExtraWhenAccess(Humanoid a) {}
/*    */   
/*    */   public static interface ROOM_SPECTATOR_HASER extends RoomServiceNeed.ROOM_SERVICE_NEED_HASER {
/*    */     ROOM_SPECTATOR spec();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\module\ROOM_SPECTATOR.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */