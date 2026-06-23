/*    */ package settlement.room.infra.monument;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import settlement.room.main.category.RoomCategorySub;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import settlement.room.main.util.RoomsCreator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends RoomsCreator<ROOM_MONUMENT>
/*    */ {
/*    */   null(RoomInitData $anonymous0, String $anonymous1, RoomCategorySub $anonymous2) throws IOException {
/* 19 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ROOM_MONUMENT create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException {
/* 25 */     init.init(key);
/* 26 */     if (data.data().has("TYPE"))
/*    */     {
/* 28 */       if (data.data().value("TYPE").equals("TORCH")) {
/* 29 */         return new Torch(data, index, key, cat);
/*    */       }
/*    */     }
/* 32 */     return new Imp(data, index, key, cat);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\monument\ROOM_MONUMENTS$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */