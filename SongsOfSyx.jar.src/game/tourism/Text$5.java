/*    */ package game.tourism;
/*    */ 
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.text.Inserter;
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
/*    */   extends Inserter<Text.InsertData>.II
/*    */ {
/*    */   null(Inserter paramInserter, String $anonymous0) {
/* 67 */     super(paramInserter, $anonymous0);
/*    */   }
/*    */   
/*    */   public void set(Text.InsertData t, Str str) {
/* 71 */     RoomBlueprintIns<?> roomBlueprintIns = TOURISM.attraction(t.i);
/* 72 */     str.add(((RoomBlueprintImp)roomBlueprintIns).info.names);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\tourism\Text$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */