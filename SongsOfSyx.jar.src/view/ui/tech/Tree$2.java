/*    */ package view.ui.tech;
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
/* 70 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max() {
/* 75 */     return Tree.this.dh;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get() {
/* 80 */     return Tree.this.body().y1() - Tree.this.content.body().y1();
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(int t) {
/* 85 */     Tree.this.content.body().moveY1((Tree.this.body().y1() - t));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\Tree$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */