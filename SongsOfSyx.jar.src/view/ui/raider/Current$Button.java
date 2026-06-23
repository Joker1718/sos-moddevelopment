/*     */ package view.ui.raider;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import init.constant.Config;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Button
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   private final int ii;
/*     */   
/*     */   Button(int ii) {
/* 216 */     this.ii = ii;
/* 217 */     this.body.setDim(Current.dim);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 222 */     if (this.ii >= (Current.this.rr()).army.sdivs.size()) {
/*     */       return;
/*     */     }
/*     */     
/* 226 */     DIV_SPEC d = (DIV_SPEC)(Current.this.rr()).army.sdivs.get(this.ii);
/*     */     
/* 228 */     if (d == null) {
/*     */       return;
/*     */     }
/* 231 */     GButt.ButtPanel.renderBG(r, true, isHovered, false, (RECTANGLE)this.body);
/*     */     
/* 233 */     if ((Current.this.rr()).raids > 0 || UIRaiding.debug) {
/* 234 */       (d.race().appearance()).icon.renderC(r, body().cX(), body().cY() - 6);
/*     */       
/* 236 */       (VIEW.UI()).div.renderPower(this.body.x2() - 16, this.body.y1() + 4, r, (GAME.battle()).power.get(d));
/*     */ 
/*     */       
/* 239 */       int w = (int)((this.body.width() - 8) * CLAMP.d((d.men() + (Config.battle()).MEN_PER_DIVISION / 5) / (Config.battle()).MEN_PER_DIVISION, 0.0D, 1.0D));
/*     */       
/* 241 */       GMeter.GMeterCol col = GMeter.C_REDBLUE;
/*     */ 
/*     */       
/* 244 */       GMeter.render(r, col, 1.0D, this.body.x1() + 4, this.body.x1() + 4 + w, this.body.y2() - 14, this.body.y2() - 6);
/* 245 */       OPACITY.unbind();
/*     */     } else {
/* 247 */       (UI.icons()).s.question.renderC(r, body().cX(), this.body.cY());
/*     */     } 
/*     */ 
/*     */     
/* 251 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 257 */     if (this.ii >= (Current.this.rr()).army.sdivs.size())
/*     */       return; 
/* 259 */     GBox b = (GBox)text;
/* 260 */     if ((Current.this.rr()).raids > 0 || UIRaiding.debug) {
/* 261 */       DIV_SPEC d = (DIV_SPEC)(Current.this.rr()).army.sdivs.get(this.ii);
/* 262 */       (VIEW.UI()).div.normal.hover(d, (GUI_BOX)b);
/*     */     } else {
/*     */       
/* 265 */       b.add((SPRITE)b.text().add('?'));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\raider\Current$Button.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */