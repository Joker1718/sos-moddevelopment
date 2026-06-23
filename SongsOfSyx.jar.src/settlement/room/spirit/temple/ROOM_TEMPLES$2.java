/*    */ package settlement.room.spirit.temple;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import settlement.room.main.category.RoomCategorySub;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import settlement.room.main.util.RoomsCreator;
/*    */ import settlement.room.spirit.shrine.ROOM_SHRINE;
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
/*    */   extends RoomsCreator<ROOM_SHRINE>
/*    */ {
/*    */   null(RoomInitData $anonymous0, String $anonymous1, RoomCategorySub $anonymous2) throws IOException {
/* 35 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */ 
/*    */   
/*    */   public ROOM_SHRINE create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException {
/* 40 */     return new ROOM_SHRINE(key, index, init, cat);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\ROOM_TEMPLES$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */