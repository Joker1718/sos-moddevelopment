/*     */ package view.menu;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
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
/*     */ public class ScreenButton
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final SPRITE s;
/*     */   
/*     */   public ScreenButton(CharSequence name) {
/*  74 */     this((UI.FONT()).H1.getText(name));
/*     */   }
/*     */   
/*     */   public ScreenButton(CharSequence name, Font f) {
/*  78 */     this(f.getText(name));
/*     */   }
/*     */   
/*     */   public ScreenButton(SPRITE s) {
/*  82 */     this.s = s;
/*  83 */     this.body.setWidth(s.width()).setHeight(s.height());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  89 */     if (!isActive) {
/*  90 */       (GCOLOR.T()).INACTIVE.bind();
/*  91 */     } else if (isHovered && isSelected) {
/*  92 */       (GCOLOR.T()).HOVER_SELECTED.bind();
/*  93 */     } else if (isHovered) {
/*  94 */       (GCOLOR.T()).HOVERED.bind();
/*  95 */     } else if (isSelected) {
/*  96 */       (GCOLOR.T()).SELECTED.bind();
/*     */     } else {
/*  98 */       (GCOLOR.T()).CLICKABLE.bind();
/*  99 */     }  this.s.render(r, (RECTANGLE)this.body);
/* 100 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\MenuScreen$ScreenButton.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */