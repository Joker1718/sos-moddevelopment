/*    */ package view.sett.ui.minimap;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import view.subview.GameWindow;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends UIMinimapSett.Butt
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 85 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 88 */     if (w.zoomout() > 0)
/* 89 */       w.setZoomout(w.zoomout() - 1); 
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 93 */     activeSet((w.zoomout() > 0));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\minimap\UIMinimapPanelButts$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */