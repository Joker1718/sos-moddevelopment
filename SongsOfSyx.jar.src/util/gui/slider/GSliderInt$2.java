/*    */ package util.gui.slider;
/*    */ 
/*    */ import snake2d.MButt;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.INT;
/*    */ import util.gui.misc.GButt;
/*    */ import view.keyboard.KEYS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 61 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 65 */     in.inc(-1);
/* 66 */     if ((KEYS.MAIN()).MOD.isPressed()) {
/* 67 */       in.set(in.min());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 73 */     if (isHovered && MButt.LEFT.isDown()) {
/* 74 */       GSliderInt.this.clickSpeed1 += ds;
/* 75 */       if (GSliderInt.this.clickSpeed1 > 10.0D)
/* 76 */         GSliderInt.this.clickSpeed1 = 10.0D; 
/* 77 */       in.inc(-((int)GSliderInt.this.clickSpeed1));
/*    */     } else {
/*    */       
/* 80 */       GSliderInt.this.clickSpeed1 = 0.0D;
/*    */     } 
/* 82 */     super.render(r, ds, isActive, isSelected, isHovered);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 88 */     GAllocator.hov(text);
/* 89 */     super.hoverInfoGet(text);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\slider\GSliderInt$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */