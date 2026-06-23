/*    */ package view.tool;
/*    */ 
/*    */ import snake2d.MButt;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.sets.LIST;
/*    */ import view.main.VIEW;
/*    */ import view.subview.GameWindow;
/*    */ 
/*    */ final class PlacableSimpleTool
/*    */   extends ToolPlacer.placeFunc {
/*    */   private PlacableSimple placable;
/*    */   private boolean clicked = false;
/*    */   int cx;
/*    */   int cy;
/*    */   
/*    */   void updateHovered(float ds, GameWindow window, boolean pressed) {
/* 19 */     this.clicked = MButt.LEFT.isDown();
/* 20 */     if (this.clicked && !window.pixel().isSameAs(this.cx, this.cy)) {
/* 21 */       this.cx = window.pixel().x();
/* 22 */       this.cy = window.pixel().y();
/* 23 */       if (this.placable.isPlacable(this.cx, this.cy) == null) {
/* 24 */         this.placable.place(this.cx, this.cy);
/*    */       }
/*    */     } else {
/*    */       
/* 28 */       this.placable.placeInfo(VIEW.hoverBox(), window.pixel().x(), window.pixel().y());
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void update(float ds, GameWindow window, boolean pressed) {
/* 36 */     super.update(ds, window, pressed);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void render(SPRITE_RENDERER r, float ds, GameWindow window) {
/* 42 */     int tx = window.pixel().x();
/* 43 */     int ty = window.pixel().y();
/*    */     
/* 45 */     this.placable.renderOverlay(tx, ty, r, ds, window);
/* 46 */     CharSequence problem = this.placable.isPlacable(tx, ty);
/*    */     
/* 48 */     if (problem == null) {
/* 49 */       this.placable.renderPlaceHolder(r, window.pixel().rel().x(), window.pixel().rel().y(), false);
/*    */     } else {
/* 51 */       this.placable.renderPlaceHolder(r, window.pixel().rel().x(), window.pixel().rel().y(), true);
/* 52 */       VIEW.hoverBox().error(problem);
/*    */     } 
/* 54 */     this.placable.renderAction(tx, ty);
/* 55 */     COLOR.unbind();
/*    */   }
/*    */ 
/*    */   
/*    */   void click(GameWindow window) {
/* 60 */     int tx = window.pixel().x();
/* 61 */     int ty = window.pixel().y();
/*    */     
/* 63 */     CharSequence problem = this.placable.isPlacable(tx, ty);
/* 64 */     if (problem != null) {
/*    */       return;
/*    */     }
/* 67 */     this.placable.place(tx, ty);
/* 68 */     this.clicked = true;
/* 69 */     this.cx = tx;
/* 70 */     this.cy = ty;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void activate(PLACABLE placer, GameWindow window) {
/* 76 */     this.placable = (PlacableSimple)placer;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void clickRelease(GameWindow window) {}
/*    */ 
/*    */ 
/*    */   
/*    */   LIST<CLICKABLE> gui() {
/* 86 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PlacableSimpleTool.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */