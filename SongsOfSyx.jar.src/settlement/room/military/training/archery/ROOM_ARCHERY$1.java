/*    */ package settlement.room.military.training.archery;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.main.TmpArea;
/*    */ import settlement.room.main.util.RoomInit;
/*    */ import settlement.room.main.util.RoomInitData;
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
/*    */   extends Constructor
/*    */ {
/*    */   null(ROOM_ARCHERY $anonymous0, RoomInitData $anonymous1) throws IOException {
/* 28 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public Room create(TmpArea area, RoomInit init) {
/* 32 */     return (Room)new ArcheryInstance(ROOM_ARCHERY.this, area, init);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isHeavy() {
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\training\archery\ROOM_ARCHERY$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */