/*     */ package settlement.thing.projectiles;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.slider.GTarget;
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
/*     */ class Single
/*     */   extends PlacableSimple
/*     */ {
/*     */   int sx;
/*     */   int sy;
/*  33 */   final Trajectory t = new Trajectory();
/*  34 */   private final INT.INTE type = new INT.INTE()
/*     */     {
/*  36 */       int i = 0;
/*     */ 
/*     */       
/*     */       public int min() {
/*  40 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public int max() {
/*  45 */         return STATS.EQUIP().RANGED().size() - 1;
/*     */       }
/*     */ 
/*     */       
/*     */       public int get() {
/*  50 */         return this.i;
/*     */       }
/*     */ 
/*     */       
/*     */       public void set(int t) {
/*  55 */         this.i = t;
/*     */       }
/*     */     };
/*  58 */   private final ArrayList<CLICKABLE> extra = new ArrayList(
/*  59 */       new GTarget(80, false, true, this.type));
/*     */ 
/*     */ 
/*     */   
/*  63 */   private final PlacableSimple next = new PlacableSimple(name())
/*     */     {
/*     */       public void place(int x, int y)
/*     */       {
/*  67 */         if (Test.Single.this.t.calcLow(0, Test.Single.this.sx, Test.Single.this.sy, x, y, 75.0D, 2560.0D)) {
/*  68 */           SETT.PROJS().launch(Test.Single.this.sx, Test.Single.this.sy, 0, Test.Single.this.t, (Projectile)Projectile.ALL.getLast(), 0.0D, 0.0D, null);
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public CharSequence isPlacable(int x, int y) {
/*  75 */         return Test.Single.this.t.calcLow(0, Test.Single.this.sx, Test.Single.this.sy, x, y, 75.0D, 2560.0D) ? null : E;
/*     */       }
/*     */ 
/*     */       
/*     */       public PLACABLE getUndo() {
/*  80 */         return (PLACABLE)Test.Single.this;
/*     */       }
/*     */     };
/*     */   
/*     */   public Single() {
/*  85 */     super("projectile");
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int x, int y) {
/*  90 */     return SETT.PIXEL_IN_BOUNDS(x, y) ? null : E;
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int x, int y) {
/*  95 */     this.sx = x;
/*  96 */     this.sy = y;
/*  97 */     (VIEW.s()).tools.place((PLACABLE)this.next);
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/* 102 */     return (LIST<CLICKABLE>)this.extra;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\Test$Single.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */