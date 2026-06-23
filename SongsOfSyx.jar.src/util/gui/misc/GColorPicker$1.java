/*    */ package util.gui.misc;
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
/*    */ class null
/*    */   implements INT.INTE
/*    */ {
/*    */   public int min() {
/* 33 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max() {
/* 38 */     return max;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get() {
/* 43 */     return GColorPicker.this.color().red() & 0xFF;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void set(int t) {
/* 49 */     GColorPicker.this.color().setRed(t);
/* 50 */     GColorPicker.this.change();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GColorPicker$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */