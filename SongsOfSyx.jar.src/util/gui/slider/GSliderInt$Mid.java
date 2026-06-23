/*     */ package util.gui.slider;
/*     */ 
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.colors.GCOLOR;
/*     */ import view.keyboard.KEYS;
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
/*     */ class Mid
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   Mid(int width, int height) {
/* 205 */     super(width, height - 4);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 210 */     GSliderInt.this.clicked = true;
/* 211 */     double x = (VIEW.mouse().x() - body().x1()) / body().width();
/* 212 */     GSliderInt.this.in.setD(CLAMP.d(x, 0.0D, 1.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 217 */     GSliderInt.this.clicked &= (MButt.LEFT.isDown() && Math.abs(GSliderInt.this.RI - VIEW.RI()) <= 1) ? 1 : 0;
/* 218 */     GSliderInt.this.RI = VIEW.RI();
/* 219 */     if (GSliderInt.this.clicked) {
/* 220 */       double x = (VIEW.mouse().x() - body().x1()) / body().width();
/* 221 */       GSliderInt.this.in.setD(CLAMP.d(x, 0.0D, 1.0D));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 226 */     GCOLOR.UI().border().render(r, (RECTANGLE)this.body, 2);
/* 227 */     GCOLOR.UI().bg(isActive, isSelected, isHovered).render(r, (RECTANGLE)this.body, 1);
/*     */ 
/*     */     
/* 230 */     int x2 = body().x1() + (int)(GSliderInt.this.in.getD() * body().width());
/*     */     
/* 232 */     int my = (isHovered || GSliderInt.this.clicked) ? 0 : 2;
/* 233 */     GSliderInt.this.renderMidColor(r, body().x1(), x2 - body().x1(), body().width(), body().y1() + my, body().y2() - my);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 238 */     int cx = (int)((this.body.x1() + 4) + (body().width() - 8) * GSliderInt.this.in.getD());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 245 */     GCOLOR.UI().border().render(r, cx - 4, cx + 4, body().y1(), body().y2());
/* 246 */     COLOR c = (isHovered || GSliderInt.this.clicked) ? (GCOLOR.T()).H1 : (GCOLOR.T()).H2;
/* 247 */     c.render(r, cx - 4 + 1, cx + 4 - 1, body().y1() + 1, body().y2() - 1);
/* 248 */     COLOR.BLACK.render(r, cx - 1, cx + 2, body().y1() + 2, body().y2() - 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 255 */     if (super.hover(mCoo)) {
/* 256 */       if ((KEYS.MAIN()).MOD.isPressed() || (KEYS.MAIN()).UNDO.isPressed()) {
/* 257 */         double d = MButt.clearWheelSpin();
/* 258 */         if (d < 0.0D) {
/* 259 */           GSliderInt.this.in.inc(-1);
/* 260 */         } else if (d > 0.0D) {
/* 261 */           GSliderInt.this.in.inc(1);
/*     */         } 
/*     */       } 
/* 264 */       return true;
/*     */     } 
/* 266 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\slider\GSliderInt$Mid.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */