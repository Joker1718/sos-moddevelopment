/*    */ package util.gui.slider;
/*    */ 
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
/* 69 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 72 */     target.inc(-5);
/* 73 */     if ((KEYS.MAIN()).MOD.isPressed()) {
/* 74 */       target.set(target.min());
/*    */     }
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 79 */     activeSet((GTarget.this.activeIs() && target.get() > target.min()));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 85 */     super.hoverInfoGet(text);
/* 86 */     text.NL();
/* 87 */     GAllocator.hov(text);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\slider\GTarget$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */