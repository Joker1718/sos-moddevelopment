/*    */ package util.gui.misc;
/*    */ 
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.INT;
/*    */ import util.gui.slider.GAllocator;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 63 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 67 */     in.inc(-Math.max(1, (in.max() - in.min()) / 5));
/* 68 */     if ((KEYS.MAIN()).MOD.isPressed()) {
/* 69 */       in.set(in.min());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 75 */     activeSet((in.get() > in.min()));
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 80 */     GAllocator.hov(text);
/* 81 */     super.hoverInfoGet(text);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GInputInt$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */