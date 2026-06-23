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
/*    */ class Row
/*    */   extends GuiSection
/*    */ {
/*    */   private final GETTER<Integer> ier;
/*    */   
/*    */   Row(GETTER<Integer> ier, int height) {
/* 59 */     this.ier = ier;
/* 60 */     body().setHeight(height);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 66 */     int ox = body().x1();
/* 67 */     int oy = body().y1();
/* 68 */     clear();
/*    */     
/* 70 */     int s = ((Integer)this.ier.get()).intValue() * GMatrix.this.columns;
/* 71 */     int m = GMatrix.this.nrOFEntries();
/* 72 */     for (int i = 0; i < GMatrix.this.columns && s < m; i++) {
/* 73 */       while (s >= GMatrix.this.wraps.size())
/* 74 */         GMatrix.this.wraps.add(new GMatrix.Wrap(GMatrix.this)); 
/* 75 */       GMatrix.Wrap w = (GMatrix.Wrap)GMatrix.this.wraps.get(s);
/* 76 */       w.init(i, ((Integer)this.ier.get()).intValue() * GMatrix.this.columns, s++);
/* 77 */       addRight(0, (RENDEROBJ)w);
/*    */     } 
/* 79 */     body().moveX1Y1(ox, oy);
/* 80 */     super.render(r, ds);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\GMatrix$Row.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */