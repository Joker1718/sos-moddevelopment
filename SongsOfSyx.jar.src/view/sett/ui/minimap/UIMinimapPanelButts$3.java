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
/*    */ class null
/*    */   extends UIMinimapSett.Butt
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 71 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 74 */     if (w.zoomout() < w.zoomoutmax()) {
/* 75 */       w.setZoomout(w.zoomout() + 1);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 80 */     activeSet((w.zoomout() < w.zoomoutmax()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\minimap\UIMinimapPanelButts$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */