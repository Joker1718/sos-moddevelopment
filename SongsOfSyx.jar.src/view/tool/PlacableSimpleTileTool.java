/*    */ package view.tool;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.sets.LIST;
/*    */ import view.main.VIEW;
/*    */ import view.subview.GameWindow;
/*    */ 
/*    */ 
/*    */ final class PlacableSimpleTileTool
/*    */   extends ToolPlacer.placeFunc
/*    */ {
/*    */   private PlacableSimpleTile placable;
/*    */   
/*    */   void updateHovered(float ds, GameWindow window, boolean pressed) {
/* 17 */     this.placable.renderOverlay(window);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void update(float ds, GameWindow window, boolean pressed) {
/* 24 */     this.placable.renderOverlay(window);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void render(SPRITE_RENDERER r, float ds, GameWindow window) {
/* 30 */     int tx = window.tile().x();
/* 31 */     int ty = window.tile().y();
/*    */ 
/*    */     
/* 34 */     CharSequence problem = this.placable.isPlacable(tx, ty);
/*    */     
/* 36 */     if (problem == null) {
/* 37 */       this.placable.renderPlaceHolder(r, tx, ty, window.tile().rel().x() + 32, window.tile().rel().y() + 32, false);
/* 38 */       this.placable.hoverInfo(tx, ty, VIEW.hoverBox());
/*    */     } else {
/* 40 */       this.placable.renderPlaceHolder(r, tx, ty, window.tile().rel().x() + 32, window.tile().rel().y() + 32, true);
/* 41 */       VIEW.hoverBox().error(problem);
/*    */     } 
/* 43 */     COLOR.unbind();
/* 44 */     this.placable.renderExtra(r);
/*    */   }
/*    */ 
/*    */   
/*    */   void click(GameWindow window) {
/* 49 */     int tx = window.tile().x();
/* 50 */     int ty = window.tile().y();
/*    */     
/* 52 */     CharSequence problem = this.placable.isPlacable(tx, ty);
/* 53 */     if (problem != null) {
/*    */       return;
/*    */     }
/* 56 */     this.placable.place(tx, ty);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void activate(PLACABLE placer, GameWindow window) {
/* 62 */     this.placable = (PlacableSimpleTile)placer;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void clickRelease(GameWindow window) {}
/*    */ 
/*    */ 
/*    */   
/*    */   LIST<CLICKABLE> gui() {
/* 72 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PlacableSimpleTileTool.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */