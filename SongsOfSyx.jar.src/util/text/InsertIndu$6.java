/*    */ package util.text;
/*    */ 
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.sprite.text.Str;
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
/*    */   extends Inserter<Induvidual>.II
/*    */ {
/*    */   null(Inserter paramInserter, String $anonymous0) {
/* 82 */     super($anonymous0);
/*    */   }
/*    */   public void set(Induvidual t, Str str) {
/* 85 */     if ((STATS.WORK()).EMPLOYED.get(t) != null)
/* 86 */       str.add((CharSequence)((RoomInstance)(STATS.WORK()).EMPLOYED.get(t)).name()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertIndu$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */