/*    */ package util.gui.slider;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
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
/*    */ 
/*    */ class null
/*    */   extends GButt.Glow
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 57 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 61 */     activeSet((GSliderHor.this.target().get() < GSliderHor.this.target().max()));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 66 */     if (GSliderHor.this.target().get() < GSliderHor.this.target().max())
/* 67 */       GSliderHor.this.target().inc(1); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\slider\GSliderHor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */