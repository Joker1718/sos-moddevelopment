/*    */ package util.text;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
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
/*    */ class null
/*    */   extends Inserter<Humanoid>.II
/*    */ {
/*    */   null(Inserter paramInserter, String $anonymous0) {
/* 21 */     super($anonymous0);
/*    */   }
/*    */   public void set(Humanoid a, Str str) {
/* 24 */     str.add(a.physics.getMass(), 1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertHuman$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */