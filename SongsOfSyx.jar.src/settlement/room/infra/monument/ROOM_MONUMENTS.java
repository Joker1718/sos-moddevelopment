/*    */ package settlement.room.infra.monument;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import settlement.room.main.category.RoomCategories;
/*    */ import settlement.room.main.category.RoomCategorySub;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import settlement.room.main.util.RoomsCreator;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ROOM_MONUMENTS
/*    */ {
/*    */   public final LIST<ROOM_MONUMENT> all;
/*    */   
/*    */   public ROOM_MONUMENTS(final RoomInitData init, RoomCategories CATS) throws IOException {
/* 19 */     this.all = (new RoomsCreator<ROOM_MONUMENT>(init, "MONUMENT", 
/* 20 */         CATS.DECOR)
/*    */       {
/*    */         
/*    */         public ROOM_MONUMENT create(String key, RoomInitData data, RoomCategorySub cat, int index) throws IOException
/*    */         {
/* 25 */           init.init(key);
/* 26 */           if (data.data().has("TYPE"))
/*    */           {
/* 28 */             if (data.data().value("TYPE").equals("TORCH")) {
/* 29 */               return new Torch(data, index, key, cat);
/*    */             }
/*    */           }
/* 32 */           return new Imp(data, index, key, cat);
/*    */         }
/* 34 */       }).all();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\monument\ROOM_MONUMENTS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */