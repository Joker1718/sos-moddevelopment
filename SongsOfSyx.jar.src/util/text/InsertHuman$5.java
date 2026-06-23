/*    */ package util.text;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.stats.Induvidual;
/*    */ import util.data.GETTER_TRANS;
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
/*    */   implements GETTER_TRANS<Humanoid, Induvidual>
/*    */ {
/*    */   public Induvidual get(Humanoid f) {
/* 49 */     if (f == null)
/* 50 */       return null; 
/* 51 */     return f.indu();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertHuman$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */