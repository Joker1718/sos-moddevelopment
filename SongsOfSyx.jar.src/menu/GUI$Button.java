/*     */ package menu;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final SPRITE s;
/*     */   
/*     */   Button(SPRITE s) {
/*  99 */     this.s = s;
/* 100 */     this.body.setWidth(s.width()).setHeight(s.height());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 106 */     if (!isActive) {
/* 107 */       GUI.COLORS.inactive.bind();
/* 108 */     } else if (isHovered && isSelected) {
/* 109 */       GUI.COLORS.hover_selected.bind();
/* 110 */     } else if (isHovered) {
/* 111 */       GUI.COLORS.hover.bind();
/* 112 */     } else if (isSelected) {
/* 113 */       GUI.COLORS.selected.bind();
/*     */     } else {
/* 115 */       GUI.COLORS.normal.bind();
/* 116 */     }  this.s.render(r, (RECTANGLE)this.body);
/* 117 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\GUI$Button.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */