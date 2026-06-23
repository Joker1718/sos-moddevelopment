/*     */ package settlement.entity.humanoid.ai.subject;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends Activity.R
/*     */ {
/*     */   private final int[] order;
/*     */   
/*     */   null(Activity paramActivity2) {
/*  71 */     this.order = new int[] { 0, 1, 2 };
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  76 */     if (!shouldMove(a, a.tc().x(), a.tc().y())) {
/*  77 */       return Activity.this.stand.set(a, d);
/*     */     }
/*     */     
/*  80 */     DIR dd = DIR.get(a.body().cX(), a.body().cY(), Activity.this.s.lookAt(d.planTile.x(), d.planTile.y())); byte b;
/*     */     int i, arrayOfInt[];
/*  82 */     for (i = (arrayOfInt = this.order).length, b = 0; b < i; ) { int j = arrayOfInt[b];
/*  83 */       dd = dd.next(j);
/*  84 */       int dx = a.tc().x() + dd.x();
/*  85 */       int dy = a.tc().y() + dd.y();
/*  86 */       if (Activity.this.isSpot(dx, dy) && 
/*  87 */         !shouldMove(a, dx, dy)) {
/*  88 */         return (AI.SUBS()).walkTo.cooFull(a, d, dx, dy);
/*     */       }
/*     */       
/*     */       b++; }
/*     */     
/*  93 */     return Activity.this.stand.set(a, d);
/*     */   }
/*     */   
/*     */   private boolean shouldMove(Humanoid a, int cx, int cy) {
/*  97 */     for (ENTITY e : SETT.ENTITIES().getAtTile(cx, cy)) {
/*  98 */       if (e != a && e instanceof Humanoid && e.speed.magnitude() == 0.0D)
/*  99 */         return true; 
/*     */     } 
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 106 */     return Activity.this.stand.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subject\Activity$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */