/*    */ package settlement.room.service.module;
/*    */ 
/*    */ import init.type.NEED;
/*    */ import init.type.NEEDS;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ 
/*    */ public abstract class RoomServiceNeed extends RoomServiceAccess {
/*    */   public RoomServiceNeed(RoomBlueprintImp b, RoomInitData data) {
/* 10 */     super(b, data, (NEED)NEEDS.MAP().read(data.data().json("SERVICE")));
/*    */   }
/*    */   
/*    */   public static interface ROOM_SERVICE_NEED_HASER extends RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER {
/*    */     RoomServiceNeed service();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\module\RoomServiceNeed.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */