/*    */ package settlement.room.service.module;
/*    */ 
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ 
/*    */ public interface ROOM_SERVICER
/*    */ {
/*    */   RoomServiceInstance service();
/*    */   
/*    */   double quality();
/*    */   
/*    */   static double defQuality(RoomInstance ins, double base) {
/* 13 */     base *= 1.0D - 0.9D * ins.getDegrade();
/*    */     
/* 15 */     return CLAMP.d(base, 0.0D, 1.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\module\ROOM_SERVICER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */