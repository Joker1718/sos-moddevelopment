/*    */ package util.gui.slider;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.INT;
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
/*    */ class null
/*    */   extends GButt.Glow
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 34 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 38 */     activeSet((target.get() > target.min()));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 43 */     if (target.get() > target.min())
/* 44 */       target.inc(-1); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\slider\GSliderVer$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */