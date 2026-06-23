/*    */ package util.gui.panel;
/*    */ 
/*    */ import snake2d.util.datatypes.RECTANGLEE;
/*    */ import snake2d.util.datatypes.RecFacade;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends RecFacade
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public int width() {
/* 37 */     return GPanel.this.body.width() + 16 + ((GPanel.access$2(GPanel.this) != null) ? 8 : 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public int height() {
/* 42 */     return GPanel.this.body.height() + 16 + GPanel.this.titleHeight() / 2 + ((GPanel.access$2(GPanel.this) != null) ? 8 : 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public int y1() {
/* 47 */     return GPanel.this.body.y1() - 8 - GPanel.this.titleHeight() / 2 - ((GPanel.access$2(GPanel.this) != null) ? 8 : 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public int x1() {
/* 52 */     return GPanel.this.body.x1() - 8;
/*    */   }
/*    */ 
/*    */   
/*    */   public RECTANGLEE moveY1(double Y1) {
/* 57 */     GPanel.this.body.moveY1(Y1 + 8.0D + (GPanel.this.titleHeight() / 2));
/* 58 */     return (RECTANGLEE)this;
/*    */   }
/*    */ 
/*    */   
/*    */   public RECTANGLEE moveX1(double X1) {
/* 63 */     GPanel.this.body.moveX1(X1 + 8.0D);
/* 64 */     return (RECTANGLEE)this;
/*    */   }
/*    */ 
/*    */   
/*    */   public RecFacade setWidth(double width) {
/* 69 */     GPanel.this.body.setWidth(width - 16.0D + ((GPanel.access$2(GPanel.this) != null) ? 8 : false));
/* 70 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public RecFacade setHeight(double height) {
/* 75 */     GPanel.this.body.setHeight(height - 16.0D - (GPanel.this.titleHeight() / 2) + ((GPanel.access$2(GPanel.this) != null) ? 8 : false));
/* 76 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\panel\GPanel$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */