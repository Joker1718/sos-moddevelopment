/*     */ package init.sprite.UI;
/*     */ 
/*     */ import game.GAME;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import util.colors.GCOLOR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/* 179 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, int isSelected, boolean isHovered) {
/* 183 */     isSelected = (GAME.SPEED.speedTarget() == speed) ? 1 : 0;
/*     */     
/* 185 */     GAME.SPEED.getClass(); GAME.SPEED.getClass(); boolean sspeed = (speed == 25 && GAME.SPEED.speedTarget() == 250.0D);
/* 186 */     GAME.SPEED.getClass(); GAME.SPEED.getClass(); int j = sspeed | ((speed == 1 && GAME.SPEED.speedTarget() == 0.25D) ? 1 : 0);
/* 187 */     int i = isSelected | j;
/*     */     
/* 189 */     if (isHovered || i != 0) {
/* 190 */       OPACITY.O99.bind();
/* 191 */       UISpecials.this.buttons.render(r, 8, body().x1(), body().y1());
/* 192 */       UISpecials.this.buttons.render(r, 9, body().x1() + UISpecials.this.buttons.size(), body().y1());
/* 193 */       OPACITY.unbind();
/*     */     } 
/*     */     
/* 196 */     if (!isActive) {
/* 197 */       (GCOLOR.T()).INACTIVE.bind();
/* 198 */     } else if (i != 0 && isHovered) {
/* 199 */       (GCOLOR.T()).HOVER_SELECTED.bind();
/* 200 */     } else if (i != 0) {
/* 201 */       (GCOLOR.T()).SELECTED.bind();
/* 202 */     } else if (isHovered) {
/* 203 */       (GCOLOR.T()).HOVERED.bind();
/*     */     } else {
/* 205 */       COLOR.WHITE100.bind();
/* 206 */     }  UISpecials.this.buttons.render(r, i * 2, body().x1(), body().y1());
/* 207 */     UISpecials.this.buttons.render(r, i * 2 + 1, body().x1() + UISpecials.this.buttons.size(), body().y1());
/* 208 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 214 */     GAME.SPEED.getClass(); if (speed == 0)
/* 215 */       GAME.SPEED.togglePause(); 
/* 216 */     GAME.SPEED.getClass(); GAME.SPEED.getClass(); if (speed == 1 && GAME.SPEED.speedTarget() == 1.0D) {
/* 217 */       GAME.SPEED.getClass(); GAME.SPEED.speedSet(0.25D);
/* 218 */     }  GAME.SPEED.getClass(); GAME.SPEED.getClass(); if (speed == 25 && GAME.SPEED.speedTarget() == 25.0D) {
/* 219 */       GAME.SPEED.getClass(); GAME.SPEED.speedSet(250.0D);
/*     */     } else {
/* 221 */       GAME.SPEED.speedSet(speed);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UISpecials$9.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */