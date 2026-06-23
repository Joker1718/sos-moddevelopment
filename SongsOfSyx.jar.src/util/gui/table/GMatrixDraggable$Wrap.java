/*     */ package util.gui.table;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.colors.GCOLOR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Wrap
/*     */   extends CLICKABLE.ClickWrap2
/*     */ {
/*     */   private int i;
/*     */   private RENDEROBJ rr;
/*     */   
/*     */   private void init(int col, int row, int i) {
/* 112 */     this.i = i;
/* 113 */     this.rr = GMatrixDraggable.this.get(i, col);
/*     */   }
/*     */ 
/*     */   
/*     */   protected RENDEROBJ get() {
/* 118 */     return this.rr;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean click() {
/* 123 */     GMatrixDraggable.this.toMove = this;
/* 124 */     return super.click();
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 129 */     boolean hov = hoveredIs();
/*     */     
/* 131 */     super.render(r, ds);
/* 132 */     if (GMatrixDraggable.this.toMove == this) {
/* 133 */       COLOR.WHITE85.render(r, body().x1(), body().x1() + 2, body().y1(), body().y2());
/* 134 */     } else if (GMatrixDraggable.this.toMove != null && hov) {
/* 135 */       (GCOLOR.UI()).GOOD.hovered.render(r, body().x1(), body().x1() + 2, body().y1(), body().y2());
/* 136 */       GMatrixDraggable.this.toMoveTo = this;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\GMatrixDraggable$Wrap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */