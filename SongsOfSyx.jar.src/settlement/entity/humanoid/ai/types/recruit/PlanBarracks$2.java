/*    */ package settlement.entity.humanoid.ai.types.recruit;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.misc.job.JOBMANAGER_HASER;
/*    */ import settlement.misc.job.SETT_JOB;
/*    */ import snake2d.util.datatypes.COORDINATE;
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
/*    */   extends PlanBarracks.Res
/*    */ {
/*    */   null(PlanBarracks paramPlanBarracks2) {}
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 63 */     JOBMANAGER_HASER w = PlanBarracks.this.work(a);
/*    */     
/* 65 */     if (w == null) {
/* 66 */       return PlanBarracks.this.done.set(a, d);
/*    */     }
/* 68 */     SETT_JOB j = w.getWork().getReservableJob(a.tc());
/*    */     
/* 70 */     if (j == null) {
/* 71 */       return PlanBarracks.this.done.set(a, d);
/*    */     }
/* 73 */     d.planTile.set(j.jobCoo());
/* 74 */     AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, j.jobCoo());
/*    */     
/* 76 */     if (s != null) {
/* 77 */       j = w.getWork().getJob((COORDINATE)d.planTile);
/* 78 */       j.jobReserve(null);
/* 79 */       return s;
/*    */     } 
/*    */     
/* 82 */     return PlanBarracks.this.done.set(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 87 */     if (PlanBarracks.this.job(a, d) == null)
/* 88 */       return null; 
/* 89 */     return PlanBarracks.this.walkLast.set(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\recruit\PlanBarracks$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */