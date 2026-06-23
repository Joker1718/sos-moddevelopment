/*    */ package settlement.room.main.util;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import java.io.IOException;
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import settlement.room.main.category.RoomCategorySub;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class RoomsCreator<T extends RoomBlueprint>
/*    */ {
/*    */   final String type;
/*    */   final RoomCategorySub cat;
/*    */   final RoomInitData data;
/*    */   
/*    */   public RoomsCreator(RoomInitData data, String type, RoomCategorySub cat) throws IOException {
/* 21 */     this.type = type;
/* 22 */     this.cat = cat;
/* 23 */     this.data = data;
/*    */   }
/*    */   
/*    */   public abstract T create(String paramString, RoomInitData paramRoomInitData, RoomCategorySub paramRoomCategorySub, int paramInt) throws IOException;
/*    */   
/*    */   public LIST<T> all() throws IOException {
/* 29 */     this.data.setType(this.type);
/*    */     
/* 31 */     LinkedList<T> tmp = new LinkedList(); byte b; int i; String[] arrayOfString;
/* 32 */     for (i = (arrayOfString = PATHS.INIT().getFolder("room").getFiles()).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 33 */       if (s.startsWith(this.type) && s.length() > this.type.length() && s.charAt(this.type.length()) == '_') {
/* 34 */         tmp.add(create(s, this.data, this.cat, tmp.size()));
/*    */       }
/*    */       b++; }
/*    */     
/* 38 */     return (LIST<T>)new ArrayList((Iterable)tmp);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\mai\\util\RoomsCreator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */