/*    */ package util.gui.table;
/*    */ 
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ 
/*    */ public class GRows
/*    */ {
/* 10 */   private GuiSection s = null;
/* 11 */   private final LinkedList<RENDEROBJ> rows = new LinkedList();
/* 12 */   private int ii = 0;
/*    */   private final int max;
/* 14 */   private int pad = 0;
/* 15 */   private int minDist = 0;
/*    */   
/*    */   public GRows(int rowSize) {
/* 18 */     this.max = rowSize;
/*    */   }
/*    */   
/*    */   public GRows setPad(int pad) {
/* 22 */     this.pad = pad;
/* 23 */     return this;
/*    */   }
/*    */   
/*    */   public GRows setMin(int min) {
/* 27 */     this.minDist = min;
/* 28 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public void add(RENDEROBJ obj) {
/* 33 */     if (this.ii % this.max == 0) {
/* 34 */       this.s = new GuiSection();
/* 35 */       this.rows.add(this.s);
/* 36 */       this.ii = 0;
/*    */     } 
/* 38 */     int p = this.minDist - obj.body().width();
/* 39 */     if (this.pad > p)
/* 40 */       p = this.pad; 
/* 41 */     this.s.addRight(p, obj);
/*    */     
/* 43 */     this.ii++;
/*    */   }
/*    */   
/*    */   public void nl() {
/* 47 */     if (this.s == null || this.s.elements().size() == 0)
/*    */       return; 
/* 49 */     this.s = new GuiSection();
/* 50 */     this.rows.add(this.s);
/* 51 */     this.ii = 0;
/*    */   }
/*    */   
/*    */   public int height() {
/* 55 */     int h = 0;
/* 56 */     for (RENDEROBJ o : this.rows)
/* 57 */       h += o.body().height(); 
/* 58 */     return h;
/*    */   }
/*    */   
/*    */   public LIST<RENDEROBJ> rows() {
/* 62 */     for (RENDEROBJ rr : this.rows) {
/* 63 */       GuiSection s = (GuiSection)rr;
/* 64 */       if (s.getLast().width() < this.minDist) {
/* 65 */         s.body().incrW((this.minDist - s.getLast().width()));
/*    */       }
/*    */     } 
/* 68 */     return (LIST<RENDEROBJ>)this.rows;
/*    */   }
/*    */   
/*    */   public LIST<RENDEROBJ> rowsCentered(int width) {
/* 72 */     for (RENDEROBJ rr : rows()) {
/* 73 */       GuiSection s = (GuiSection)rr;
/* 74 */       if (s.body().width() < width)
/* 75 */         s.pad((width - s.body().width()) / 2, 0); 
/*    */     } 
/* 77 */     return (LIST<RENDEROBJ>)this.rows;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\GRows.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */