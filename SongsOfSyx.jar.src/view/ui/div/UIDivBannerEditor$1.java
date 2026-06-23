/*    */ package view.ui.div;
/*    */ 
/*    */ import game.GAME;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.common.BitmapSpriteEditor;
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
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 34 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 38 */     UIDivBannerEditor.this.bannerISet(k);
/* 39 */     ee.spriteSet(((GAME.ARMIES()).banners.get(k)).sprite);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 44 */     selectedSet((UIDivBannerEditor.this.bannerI == k));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivBannerEditor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */