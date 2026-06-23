/*    */ package settlement.room.industry.module;
/*    */ 
/*    */ import settlement.room.main.RoomInstance;
/*    */ import util.info.INFO;
/*    */ 
/*    */ public interface RoomBoost {
/*    */   INFO info();
/*    */   
/*    */   default double min() {
/* 10 */     return 0.0D;
/*    */   } double get(RoomInstance paramRoomInstance);
/*    */   default double max() {
/* 13 */     return 1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\RoomBoost.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */