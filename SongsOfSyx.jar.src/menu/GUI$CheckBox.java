/*     */ package menu;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GText;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CheckBox
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final SPRITE ss;
/*     */   private final GText name;
/*     */   
/*     */   public CheckBox(CharSequence name) {
/* 251 */     this.name = new GText((UI.FONT()).M, name);
/* 252 */     this.ss = (SPRITE)new SPRITE.Imp(24)
/*     */       {
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 257 */           boolean isActive = GUI.CheckBox.this.activeIs();
/* 258 */           int i = isActive & ((!GUI.CheckBox.this.selectedIs() && !GUI.CheckBox.this.hoveredIs()) ? 0 : 1);
/*     */           
/* 260 */           if (i != 0) {
/* 261 */             COLOR.WHITE100.renderFrame(r, X1, X2, Y1, Y2, 0, 2);
/*     */           } else {
/* 263 */             GUI.COLORS.inactive.renderFrame(r, X1, X2, Y1, Y2, 0, 2);
/* 264 */           }  int cx = X1 + (X2 - X1) / 2;
/* 265 */           int cy = Y1 + (Y2 - Y1) / 2;
/* 266 */           if (GUI.CheckBox.this.selectedIs()) {
/* 267 */             (GCOLOR.UI()).GOOD.hovered.bind();
/* 268 */             (UI.icons()).s.allRight.renderC(r, cx, cy);
/*     */           } else {
/* 270 */             (GCOLOR.UI()).BAD.hovered.bind();
/* 271 */             (UI.icons()).s.cancel.renderC(r, cx, cy);
/*     */           } 
/* 273 */           COLOR.unbind();
/*     */         }
/*     */       };
/*     */     
/* 277 */     this.body.setDim(250.0D, (this.ss.height() + 8));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 283 */     this.ss.renderCY(r, body().x1(), body().cY());
/*     */     
/* 285 */     int i = isActive & ((!isSelected && !isHovered) ? 0 : 1);
/*     */     
/* 287 */     if (i == 0) {
/* 288 */       this.name.color(GUI.COLORS.inactive);
/* 289 */     } else if (isHovered && isSelected) {
/* 290 */       this.name.color(GUI.COLORS.hover_selected);
/* 291 */     } else if (isHovered) {
/* 292 */       this.name.color(GUI.COLORS.hover);
/* 293 */     } else if (isSelected) {
/* 294 */       this.name.color(GUI.COLORS.selected);
/*     */     } else {
/* 296 */       this.name.color(GUI.COLORS.normal);
/*     */     } 
/* 298 */     this.name.renderCY(r, body().x1() + 8 + this.ss.width(), body().cY());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\GUI$CheckBox.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */