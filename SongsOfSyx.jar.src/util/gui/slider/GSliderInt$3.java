/*     */ package util.gui.slider;
/*     */ 
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GButt;
/*     */ import view.keyboard.KEYS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/*  99 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void clickA() {
/* 103 */     in.inc(1);
/* 104 */     if ((KEYS.MAIN()).MOD.isPressed()) {
/* 105 */       in.set(in.max());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 111 */     if (isHovered && MButt.LEFT.isDown()) {
/* 112 */       GSliderInt.this.clickSpeed2 += (ds * 2.0F);
/* 113 */       if (GSliderInt.this.clickSpeed2 > 10.0D)
/* 114 */         GSliderInt.this.clickSpeed2 = 10.0D; 
/* 115 */       in.inc((int)GSliderInt.this.clickSpeed2);
/*     */     } else {
/*     */       
/* 118 */       GSliderInt.this.clickSpeed2 = 0.0D;
/*     */     } 
/* 120 */     super.render(r, ds, isActive, isSelected, isHovered);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 126 */     GAllocator.hov(text);
/* 127 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\slider\GSliderInt$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */