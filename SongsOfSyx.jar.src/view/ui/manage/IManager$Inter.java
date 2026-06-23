/*     */ package view.ui.manage;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.constant.C;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import view.interrupter.Interrupter;
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
/*     */ class Inter
/*     */   extends Interrupter
/*     */ {
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 135 */     IManager.this.current.section.hover(mCoo);
/* 136 */     IManager.this.top.hover(mCoo);
/* 137 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 142 */     if (button == MButt.RIGHT) {
/* 143 */       if (!IManager.this.current.back())
/* 144 */         hide(); 
/* 145 */     } else if (button == MButt.LEFT) {
/* 146 */       IManager.this.current.section.click();
/* 147 */       IManager.this.top.click();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 155 */     IManager.this.current.section.hoverInfoGet((GUI_BOX)text);
/* 156 */     IManager.this.top.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 161 */     GAME.SPEED.tmpPause();
/* 162 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 168 */     GCOLOR.UI().bg().render((SPRITE_RENDERER)r, C.DIM());
/* 169 */     IManager.this.current.section.render((SPRITE_RENDERER)r, ds);
/*     */     
/* 171 */     (UI.PANEL()).butt.render((SPRITE_RENDERER)r, 0, C.WIDTH(), 0, 48, 0, DIR.S.mask());
/* 172 */     IManager.this.top.render((SPRITE_RENDERER)r, ds);
/* 173 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hide() {
/* 179 */     super.hide();
/*     */   }
/*     */   
/*     */   public void activate() {
/* 183 */     show((VIEW.inters()).manager);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\manage\IManager$Inter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */