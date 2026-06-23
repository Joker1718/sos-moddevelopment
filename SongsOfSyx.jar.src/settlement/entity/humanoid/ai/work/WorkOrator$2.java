/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 122 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 126 */     SETT_JOB j = ((JOBMANAGER_HASER)WorkOrator.work(a)).getWork().getJob((COORDINATE)d.planTile);
/* 127 */     j.jobStartPerforming();
/* 128 */     return res(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 134 */     if ((STATS.WORK()).WORK_TIME.indu().getD(a.indu()) == 1.0D || !(AI.modules()).work.moduleCanContinue(a, d)) {
/* 135 */       SETT_JOB j = ((JOBMANAGER_HASER)WorkOrator.work(a)).getWork().getJob((COORDINATE)d.planTile);
/* 136 */       j.jobPerform(a, null, 0);
/* 137 */       return null;
/*     */     } 
/*     */     
/* 140 */     if (RND.oneIn(4)) {
/* 141 */       a.speed.setDirCurrent(a.speed.dir().next(-1 + RND.rInt(3)));
/*     */     }
/*     */     
/* 144 */     if (RND.oneIn(2)) {
/* 145 */       return (AI.SUBS()).single.activate(a, d, WorkOrator.this.anima[RND.rInt(WorkOrator.this.anima.length)], (2 + RND.rInt(3)));
/*     */     }
/* 147 */     return (AI.SUBS()).STAND.activateTime(a, d, 3 + RND.rInt(4));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 153 */     return true;
/*     */   }
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkOrator$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */