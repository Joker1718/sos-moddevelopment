/*    */ package view.interrupter;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.StringInputSprite;
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
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 56 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 59 */     ITextInput.this.hide();
/* 60 */     ITextInput.this.client.acceptString((CharSequence)input.text());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\ITextInput$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */