/*    */ package settlement.thing.projectiles;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PlacableSimple;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends PlacableSimple
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 63 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void place(int x, int y) {
/* 67 */     if (Test.Single.this.t.calcLow(0, Test.Single.this.sx, Test.Single.this.sy, x, y, 75.0D, 2560.0D)) {
/* 68 */       SETT.PROJS().launch(Test.Single.this.sx, Test.Single.this.sy, 0, Test.Single.this.t, (Projectile)Projectile.ALL.getLast(), 0.0D, 0.0D, null);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int x, int y) {
/* 75 */     return Test.Single.this.t.calcLow(0, Test.Single.this.sx, Test.Single.this.sy, x, y, 75.0D, 2560.0D) ? null : E;
/*    */   }
/*    */ 
/*    */   
/*    */   public PLACABLE getUndo() {
/* 80 */     return (PLACABLE)Test.Single.this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\Test$Single$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */