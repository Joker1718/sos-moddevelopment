/*     */ package view.ui.profile;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Row
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   private final Boostable bo;
/*     */   private final SPRITE ico;
/*     */   private final GText t;
/*     */   
/*     */   Row(Boostable bo) {
/* 123 */     super(450, 48);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     this.t = new GText((UI.FONT()).S, 16);
/*     */     this.bo = bo;
/*     */     this.ico = bo.icon.resized(32);
/*     */   } protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 132 */     double min = this.bo.min(((BOOSTABLE_O)UIBonus.this.bbb.get()).getClass());
/* 133 */     double max = this.bo.max(((BOOSTABLE_O)UIBonus.this.bbb.get()).getClass());
/* 134 */     if (min == this.bo.baseValue && max == this.bo.baseValue) {
/*     */       return;
/*     */     }
/* 137 */     double d = this.bo.get((BOOSTABLE_O)UIBonus.this.bbb.get());
/*     */     
/* 139 */     GMeter.renderDelta(r, this.bo.baseValue / max, d / max, this.body.x1(), this.body.x2() - 90, this.body.y1(), this.body.y2(), GMeter.C_GRAY);
/*     */     
/* 141 */     this.ico.renderCY(r, this.body.x1() + 16, this.body.cY());
/*     */     
/* 143 */     int w = (UI.FONT()).M.width(this.bo.name);
/* 144 */     OPACITY.O50.bind();
/* 145 */     COLOR.BLACK.render(r, this.body.x1() + 46, this.body.x1() + 50 + w + 8, this.body.y1() + 10, this.body.y2() - 10);
/* 146 */     OPACITY.unbind();
/*     */     
/* 148 */     (UI.FONT()).M.renderCY(r, this.body.x1() + 50, this.body.cY(), this.bo.name);
/*     */     
/* 150 */     this.t.clear();
/* 151 */     if (min == this.bo.baseValue && max == this.bo.baseValue)
/*     */       return; 
/* 153 */     if (this.bo.baseValue == 0.0D) {
/* 154 */       GFORMAT.percInc(this.t, this.bo.get((BOOSTABLE_O)UIBonus.this.bbb.get()));
/*     */     } else {
/* 156 */       GFORMAT.percInc(this.t, this.bo.get((BOOSTABLE_O)UIBonus.this.bbb.get()) / this.bo.baseValue - 1.0D);
/* 157 */     }  this.t.renderCY(r, this.body.x2() - 80, this.body.cY());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 164 */     text.title(this.bo.name);
/* 165 */     text.text(this.bo.desc);
/* 166 */     text.NL(8);
/* 167 */     this.bo.hoverDetailed(text, (BOOSTABLE_O)UIBonus.this.bbb.get(), null, true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\UIBonus$Row.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */