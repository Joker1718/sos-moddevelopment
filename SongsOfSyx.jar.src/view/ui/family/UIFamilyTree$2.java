/*    */ package view.ui.family;
/*    */ 
/*    */ import util.data.DOUBLE;
/*    */ import util.data.INT;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   implements INT.INTE
/*    */ {
/*    */   public int min() {
/* 63 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max() {
/* 68 */     return 300;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get() {
/* 73 */     return UIFamilyTree.this.aligner.maxIterations;
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(int t) {
/* 78 */     UIFamilyTree.this.aligner.maxIterations = t;
/* 79 */     UIFamilyTree.this.init(UIFamilyTree.this.currentRef);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\family\UIFamilyTree$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */