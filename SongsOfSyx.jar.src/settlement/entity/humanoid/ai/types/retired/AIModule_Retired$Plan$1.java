/*     */ package settlement.entity.humanoid.ai.types.retired;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   null(AIPLAN.PLANRES paramPLANRES) {
/* 121 */     super(paramPLANRES);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 126 */     JOBMANAGER_HASER jobs = AIModule_Retired.Plan.this.jobs(a);
/* 127 */     if (jobs == null) {
/* 128 */       return null;
/*     */     }
/* 130 */     SETT_JOB j = jobs.getWork().getReservableJob(a.tc());
/* 131 */     if (j == null) {
/* 132 */       return null;
/*     */     }
/* 134 */     j.jobReserve(null);
/* 135 */     d.planTile.set(j.jobCoo());
/* 136 */     AISUB.AISubActivation s = null;
/* 137 */     if ((SETT.PATH()).solidity.is((COORDINATE)d.planTile)) {
/* 138 */       s = (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)d.planTile);
/*     */     } else {
/* 140 */       s = (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)d.planTile);
/* 141 */     }  if (s == null) {
/* 142 */       AIModule_Retired.Plan.this.cancel(a, d);
/*     */     }
/* 144 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 149 */     if (!AIModule_Retired.Plan.this.conn(a, d)) {
/* 150 */       AIModule_Retired.Plan.this.cancel(a, d);
/* 151 */       return null;
/*     */     } 
/* 153 */     return AIModule_Retired.Plan.this.work.set(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 158 */     return true;
/*     */   }
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\retired\AIModule_Retired$Plan$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */