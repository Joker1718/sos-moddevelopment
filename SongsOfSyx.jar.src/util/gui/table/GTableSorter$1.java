/*    */ package util.gui.table;
/*    */ 
/*    */ import snake2d.util.sets.Tree;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends Tree<T>
/*    */ {
/*    */   null(int $anonymous0) {
/* 21 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected boolean isGreaterThan(T current, T cmp) {
/* 25 */     if (GTableSorter.this.sort == null)
/*    */     {
/* 27 */       return true;
/*    */     }
/* 29 */     int c = GTableSorter.this.sort.cmp(current, cmp);
/* 30 */     return (c <= 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\GTableSorter$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */