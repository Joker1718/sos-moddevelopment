/*    */ package settlement.stats;
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
/*    */ public interface Addable
/*    */ {
/*    */   default void addH(Induvidual i) {
/* 76 */     if (i.added())
/* 77 */       addPrivate(i); 
/*    */   }
/*    */   default void removeH(Induvidual i) {
/* 80 */     if (i.added())
/* 81 */       removePrivate(i); 
/*    */   }
/*    */   
/*    */   void addPrivate(Induvidual paramInduvidual);
/*    */   
/*    */   void removePrivate(Induvidual paramInduvidual);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\StatsInit$Addable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */