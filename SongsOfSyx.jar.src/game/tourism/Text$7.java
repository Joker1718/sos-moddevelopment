/*    */ package game.tourism;
/*    */ 
/*    */ import settlement.stats.service.StatService;
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
/* 85 */     super(paramInserter, $anonymous0);
/*    */   }
/*    */   
/*    */   public void set(Text.InsertData t, Str str) {
/* 89 */     StatService s = TOURISM.service(t.i);
/* 90 */     str.add(s.name);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\tourism\Text$7.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */