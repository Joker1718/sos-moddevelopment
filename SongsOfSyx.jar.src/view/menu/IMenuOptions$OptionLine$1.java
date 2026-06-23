/*    */ package view.menu;
/*    */ 
/*    */ import init.settings.S;
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
/* 71 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max() {
/* 76 */     return s.max();
/*    */   }
/*    */ 
/*    */   
/*    */   public int get() {
/* 81 */     return s.get();
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(int t) {
/* 86 */     s.set(t);
/* 87 */     S.get().applyRuntimeConfigs();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\IMenuOptions$OptionLine$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */