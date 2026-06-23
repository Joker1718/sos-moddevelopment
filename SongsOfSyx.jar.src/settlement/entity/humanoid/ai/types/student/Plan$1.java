/*     */ package settlement.entity.humanoid.ai.types.student;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import snake2d.util.datatypes.COORDINATE;
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
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*     */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/*  70 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  75 */     JOBMANAGER_HASER jobs = Plan.this.jobs(a);
/*  76 */     if (jobs == null) {
/*  77 */       return null;
/*     */     }
/*  79 */     SETT_JOB j = jobs.getWork().getReservableJob(a.tc());
/*     */     
/*  81 */     if (j == null)
/*  82 */       return null; 
/*  83 */     j.jobReserve(null);
/*  84 */     d.planTile.set(j.jobCoo());
/*  85 */     AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)d.planTile);
/*  86 */     if (s == null) {
/*  87 */       Plan.this.cancel(a, d);
/*     */     }
/*  89 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  94 */     if (!Plan.this.conn(a, d)) {
/*  95 */       Plan.this.cancel(a, d);
/*  96 */       return null;
/*     */     } 
/*  98 */     if (!Plan.this.uni(a).isLecturer((COORDINATE)d.planTile))
/*  99 */       return Plan.this.walkLast.set(a, d); 
/* 100 */     return Plan.this.lecture.set(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 105 */     return true;
/*     */   }
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\student\Plan$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */