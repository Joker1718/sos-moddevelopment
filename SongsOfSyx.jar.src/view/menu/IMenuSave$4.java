/*     */ package view.menu;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.save.SaveFile;
/*     */ import init.paths.PATHS;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import view.main.VIEW;
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
/*     */   implements ACTION
/*     */ {
/*     */   public void exe() {
/* 136 */     PATHS.local().save().delete((IMenuSave.this.saves[IMenuSave.this.selectedSave]).fullName);
/* 137 */     if (GAME.saver().save(SaveFile.stamp((IMenuSave.this.saves[IMenuSave.this.selectedSave]).name)) == null) {
/* 138 */       (VIEW.inters()).fullScreen.activate((IMenuSave.this.saves[IMenuSave.this.selectedSave]).name + " " + (IMenuSave.this.saves[IMenuSave.this.selectedSave]).name, COLOR.RED100, null, new util.gui.misc.GButt[0]);
/*     */     } else {
/* 140 */       (VIEW.inters()).fullScreen.activate((IMenuSave.this.saves[IMenuSave.this.selectedSave]).name + " " + (IMenuSave.this.saves[IMenuSave.this.selectedSave]).name, COLOR.RED100, null, new util.gui.misc.GButt[0]);
/*     */     } 
/* 142 */     (VIEW.inters()).fullScreen.activate((IMenuSave.this.saves[IMenuSave.this.selectedSave]).name + " " + (IMenuSave.this.saves[IMenuSave.this.selectedSave]).name, COLOR.WHITE100, successfullAction, new util.gui.misc.GButt[0]);
/* 143 */     m.setMain();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\IMenuSave$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */