/*     */ package settlement.thing.projectiles;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import view.main.VIEW;
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
/*     */ class MASS
/*     */   extends PlacableSimple
/*     */ {
/*     */   int sx;
/* 111 */   final VectorImp vec = new VectorImp();
/*     */   int sy;
/* 113 */   final Trajectory t = new Trajectory();
/* 114 */   private final PlacableSimple next = new PlacableSimple(name())
/*     */     {
/*     */       public void place(int x, int y)
/*     */       {
/* 118 */         if (Test.MASS.this.t.calcLow(0, Test.MASS.this.sx, Test.MASS.this.sy, x, y, 75.0D, 2560.0D)) {
/* 119 */           Test.MASS.this.vec.set(Test.MASS.this.sx, Test.MASS.this.sy, x, y);
/* 120 */           Test.MASS.this.vec.rotate90();
/* 121 */           for (int i = -8; i <= 8; i++) {
/* 122 */             int xx = (int)(Test.MASS.this.sx + Test.MASS.this.vec.nX() * i * 32.0D);
/* 123 */             int yy = (int)(Test.MASS.this.sy + Test.MASS.this.vec.nY() * i * 32.0D);
/* 124 */             SETT.PROJS().launch(xx, yy, 0, Test.MASS.this.t, (Projectile)Projectile.ALL.getLast(), 0.05D, 0.0D, null);
/*     */           } 
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public CharSequence isPlacable(int x, int y) {
/* 134 */         return Test.MASS.this.t.calcLow(0, Test.MASS.this.sx, Test.MASS.this.sy, x, y, 75.0D, 2560.0D) ? null : E;
/*     */       }
/*     */ 
/*     */       
/*     */       public PLACABLE getUndo() {
/* 139 */         return (PLACABLE)Test.MASS.this;
/*     */       }
/*     */     };
/*     */   
/*     */   public MASS() {
/* 144 */     super("projectile mass");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int x, int y) {
/* 149 */     return SETT.PIXEL_IN_BOUNDS(x, y) ? null : E;
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int x, int y) {
/* 154 */     this.sx = x;
/* 155 */     this.sy = y;
/* 156 */     (VIEW.s()).tools.place((PLACABLE)this.next);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\Test$MASS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */