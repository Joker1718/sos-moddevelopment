/*    */ package view.ui.div;
/*    */ 
/*    */ import game.GAME;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import util.gui.misc.GColorPicker;
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
/*    */   extends GColorPicker
/*    */ {
/*    */   null(boolean $anonymous0) {
/* 56 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public ColorImp color() {
/* 60 */     return ((GAME.ARMIES()).banners.get(UIDivBannerEditor.this.bannerI)).col;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivBannerEditor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */