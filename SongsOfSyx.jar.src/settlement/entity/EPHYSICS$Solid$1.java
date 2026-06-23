/*    */ package settlement.entity;
/*    */ 
/*    */ import snake2d.util.datatypes.RECTANGLEE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends Rec
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public Rec moveX1(double X1) {
/* 86 */     super.moveX1(X1);
/* 87 */     EPHYSICS.Solid.this.currentTile.set((cX() >> 6), EPHYSICS.Solid.this.currentTile.y());
/* 88 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public Rec moveY1(double Y1) {
/* 93 */     super.moveY1(Y1);
/* 94 */     EPHYSICS.Solid.this.currentTile.set(EPHYSICS.Solid.this.currentTile.x(), (cY() >> 6));
/* 95 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\EPHYSICS$Solid$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */