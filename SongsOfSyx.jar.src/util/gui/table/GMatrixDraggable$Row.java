/*    */ package util.gui.table;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.data.GETTER;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class Row
/*    */   extends GuiSection
/*    */ {
/*    */   private final GETTER<Integer> ier;
/*    */   
/*    */   Row(GETTER<Integer> ier, int height) {
/* 75 */     this.ier = ier;
/* 76 */     body().setHeight(height);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 82 */     int ox = body().x1();
/* 83 */     int oy = body().y1();
/* 84 */     clear();
/*    */     
/* 86 */     int s = ((Integer)this.ier.get()).intValue() * GMatrixDraggable.this.columns;
/* 87 */     int m = GMatrixDraggable.this.nrOFEntries();
/* 88 */     for (int i = 0; i < GMatrixDraggable.this.columns && s < m; i++) {
/* 89 */       while (s >= GMatrixDraggable.this.wraps.size())
/* 90 */         GMatrixDraggable.this.wraps.add(new GMatrixDraggable.Wrap(GMatrixDraggable.this)); 
/* 91 */       GMatrixDraggable.Wrap w = (GMatrixDraggable.Wrap)GMatrixDraggable.this.wraps.get(s);
/* 92 */       w.init(i, ((Integer)this.ier.get()).intValue() * GMatrixDraggable.this.columns, s++);
/* 93 */       addRight(0, (RENDEROBJ)w);
/*    */     } 
/* 95 */     body().moveX1Y1(ox, oy);
/* 96 */     super.render(r, ds);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\GMatrixDraggable$Row.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */