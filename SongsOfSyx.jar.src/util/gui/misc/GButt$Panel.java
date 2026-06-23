/*     */ package util.gui.misc;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */ public class Panel
/*     */   extends GButt
/*     */ {
/*     */   public Panel(CharSequence label) {
/* 111 */     this((UI.FONT()).M.getText(label));
/*     */   }
/*     */   
/*     */   public Panel(SPRITE label) {
/* 115 */     super(label);
/* 116 */     this.body.setDim((label.width() + 6), (label.height() + 6));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Panel(SPRITE label, CharSequence hovInfo) {
/* 122 */     this(label);
/*     */     
/* 124 */     hoverInfoSet(hovInfo);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 130 */     renAction();
/*     */     
/* 132 */     if (isSelected || isHovered) {
/*     */       
/* 134 */       if (isSelected) {
/* 135 */         OPACITY.O25To50.bind();
/* 136 */         COLOR.WHITE100.render(r, (RECTANGLE)this.body);
/* 137 */       } else if (isHovered) {
/* 138 */         OPACITY.O25.bind();
/* 139 */         COLOR.WHITE100.render(r, (RECTANGLE)this.body);
/*     */       } 
/* 141 */       OPACITY.unbind();
/*     */     } 
/*     */     
/* 144 */     if (!isActive) {
/* 145 */       (GCOLOR.T()).INACTIVE.bind();
/* 146 */     } else if (isSelected && isHovered) {
/* 147 */       (GCOLOR.T()).HOVER_SELECTED.bind();
/* 148 */     } else if (isSelected) {
/* 149 */       (GCOLOR.T()).SELECTED.bind();
/* 150 */     } else if (isHovered) {
/* 151 */       (GCOLOR.T()).HOVERED.bind();
/*     */     } else {
/* 153 */       COLOR.WHITE100.bind();
/* 154 */     }  this.label.renderC(r, (RECTANGLE)body());
/* 155 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GButt$Panel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */