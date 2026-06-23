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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 59 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max() {
/* 64 */     return max;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get() {
/* 69 */     return GColorPicker.this.color().green() & 0xFF;
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(int t) {
/* 74 */     GColorPicker.this.color().setGreen(t);
/* 75 */     GColorPicker.this.change();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GColorPicker$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */