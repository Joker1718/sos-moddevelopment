/*     */ package view.menu;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends MenuScreen.ScreenButton
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/* 111 */     super($anonymous0);
/*     */   }
/*     */   protected void renAction() {
/* 114 */     activeSet((MenuScreenLoad.this.selectedSave >= 0 && !(MenuScreenLoad.this.saves[MenuScreenLoad.this.selectedSave].spec()).fubar));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 119 */     if (MenuScreenLoad.this.selectedSave >= 0 && !(MenuScreenLoad.this.saves[MenuScreenLoad.this.selectedSave].spec()).fubar) {
/* 120 */       MenuScreenLoad.this.load(MenuScreenLoad.this.saves[MenuScreenLoad.this.selectedSave]);
/*     */     }
/* 122 */     super.clickA();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\MenuScreenLoad$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */