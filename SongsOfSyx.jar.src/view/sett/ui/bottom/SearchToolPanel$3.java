/*    */ package view.sett.ui.bottom;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements INT.INTE
/*    */ {
/*    */   public int min() {
/* 74 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max() {
/* 79 */     return SearchToolPanel.this.filtered.size() / 20;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get() {
/* 84 */     return SearchToolPanel.this.page;
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(int t) {
/* 89 */     SearchToolPanel.this.page = t;
/* 90 */     SearchToolPanel.this.build();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\bottom\SearchToolPanel$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */