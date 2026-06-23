/*     */ package settlement.thing.projectiles;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimple;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends PlacableSimple
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/* 114 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public void place(int x, int y) {
/* 118 */     if (Test.MASS.this.t.calcLow(0, Test.MASS.this.sx, Test.MASS.this.sy, x, y, 75.0D, 2560.0D)) {
/* 119 */       Test.MASS.this.vec.set(Test.MASS.this.sx, Test.MASS.this.sy, x, y);
/* 120 */       Test.MASS.this.vec.rotate90();
/* 121 */       for (int i = -8; i <= 8; i++) {
/* 122 */         int xx = (int)(Test.MASS.this.sx + Test.MASS.this.vec.nX() * i * 32.0D);
/* 123 */         int yy = (int)(Test.MASS.this.sy + Test.MASS.this.vec.nY() * i * 32.0D);
/* 124 */         SETT.PROJS().launch(xx, yy, 0, Test.MASS.this.t, (Projectile)Projectile.ALL.getLast(), 0.05D, 0.0D, null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int x, int y) {
/* 134 */     return Test.MASS.this.t.calcLow(0, Test.MASS.this.sx, Test.MASS.this.sy, x, y, 75.0D, 2560.0D) ? null : E;
/*     */   }
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/* 139 */     return (PLACABLE)Test.MASS.this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\Test$MASS$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */