/*     */ package util.gui.misc;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BStat2
/*     */   extends GButt
/*     */ {
/*     */   private final GStat stat;
/* 362 */   private COLOR color = COLOR.WHITE25;
/*     */   
/*     */   public BStat2(SPRITE icon, GStat stat) {
/* 365 */     super(icon);
/* 366 */     this.stat = stat;
/* 367 */     this.body.setWidth((icon.width() + stat.height() * 4));
/* 368 */     this.body.setHeight((icon.height() + 8));
/*     */   }
/*     */   
/*     */   public BStat2(CharSequence title, GStat stat) {
/* 372 */     super((SPRITE)(new GText((UI.FONT()).S, title)).lablify());
/* 373 */     this.stat = stat;
/* 374 */     this.body.setWidth((this.label.width() + 8 + stat.height() * 4));
/* 375 */     this.body.setHeight((this.label.height() + stat.height() + 8));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 381 */     renAction();
/* 382 */     GCOLOR.UI().border().render(r, (RECTANGLE)body());
/* 383 */     GCOLOR.UI().bg().render(r, (RECTANGLE)body(), -3);
/*     */     
/* 385 */     if (isSelected) {
/* 386 */       COLOR.WHITE85.render(r, (RECTANGLE)this.body, -2);
/* 387 */     } else if (isHovered) {
/* 388 */       COLOR.WHITE50.render(r, (RECTANGLE)this.body, -2);
/*     */     } 
/* 390 */     if (isHovered) {
/* 391 */       OPACITY.O100.bind();
/* 392 */     } else if (isActive) {
/* 393 */       OPACITY.O50.bind();
/*     */     } else {
/* 395 */       OPACITY.O012.bind();
/*     */     } 
/*     */     
/* 398 */     if (isHovered || isSelected) {
/* 399 */       OPACITY.O100.bind();
/* 400 */     } else if (isActive) {
/* 401 */       OPACITY.O50.bind();
/*     */     } else {
/* 403 */       OPACITY.O012.bind();
/*     */     } 
/* 405 */     this.color.render(r, (RECTANGLE)body(), -4);
/* 406 */     OPACITY.unbind();
/* 407 */     this.stat.adjust();
/* 408 */     this.label.renderCY(r, body().x1() + 4, this.body.cY());
/* 409 */     if (this.label instanceof GText) {
/*     */       
/* 411 */       this.stat.renderCY(r, body().x1() + 4 + this.label.width() + 2, body().cY());
/*     */     } else {
/* 413 */       this.stat.renderCY(r, body().x1() + 4 + this.label.width() + 2, body().cY());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 421 */     this.stat.hoverInfoGet((GBox)text);
/* 422 */     super.hoverInfoGet(text);
/*     */   }
/*     */   
/*     */   public BStat2 bg(COLOR c) {
/* 426 */     this.color = c;
/* 427 */     return this;
/*     */   }
/*     */   
/*     */   public void bgClear() {
/* 431 */     this.color = COLOR.WHITE25;
/*     */   }
/*     */   
/*     */   public BStat2 setWidth(int width) {
/* 435 */     this.body.setWidth(width);
/* 436 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GButt$BStat2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */