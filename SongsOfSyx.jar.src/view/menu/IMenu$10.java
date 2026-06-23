/*     */ package view.menu;
/*     */ 
/*     */ import game.GAME;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.Dic;
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
/* 152 */     if (GAME.saver().getTimeSinceLastSave() < 5.0D || !VIEW.canSave()) {
/* 153 */       IMenu.this.exit2Menu();
/*     */     }
/*     */     
/* 156 */     GButt.Glow glow1 = new GButt.Glow(IMenu.this.big.getText(Dic.¤¤Yes));
/* 157 */     glow1.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 160 */             (IMenu.null.access$0(IMenu.null.this)).current = new IMenuSave(IMenu.null.access$0(IMenu.null.this), (IMenu.null.access$0(IMenu.null.this)).big, (IMenu.null.access$0(IMenu.null.this)).small, exit2Menu);
/*     */           }
/*     */         });
/* 163 */     GButt.Glow glow2 = new GButt.Glow(IMenu.this.big.getText(Dic.¤¤No));
/* 164 */     glow2.clickActionSet(exit2Menu);
/*     */     
/* 166 */     (VIEW.inters()).fullScreen.activate(IMenu.¤¤saveFirst, COLOR.WHITE100, null, new GButt[] { (GButt)glow1, (GButt)glow2 });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\IMenu$10.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */