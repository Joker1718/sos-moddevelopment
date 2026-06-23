/*    */ package menu;
/*    */ 
/*    */ import view.menu.MenuScreen;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends MenuScreen.ScreenButton
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 66 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 69 */     for (String s : ScRandomSettings.this.ADD.keys()) {
/* 70 */       ScRandomSettings.this.ADD.putReplace(s, Double.valueOf(0.0D));
/* 71 */       ScRandomSettings.this.MUL.putReplace(s, Double.valueOf(1.0D));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScRandomSettings$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */