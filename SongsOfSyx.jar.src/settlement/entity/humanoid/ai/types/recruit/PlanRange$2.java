/*    */ package settlement.entity.humanoid.ai.types.recruit;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.misc.job.JOBMANAGER_HASER;
/*    */ import settlement.misc.job.SETT_JOB;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
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
/*    */   extends PlanRange.Res
/*    */ {
/*    */   null(PlanRange paramPlanRange2) {}
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 63 */     JOBMANAGER_HASER w = PlanRange.this.work(a);
/*    */     
/* 65 */     if (w == null) {
/* 66 */       return PlanRange.this.done.set(a, d);
/*    */     }
/* 68 */     SETT_JOB j = w.getWork().getReservableJob(a.tc());
/*    */     
/* 70 */     if (j == null) {
/* 71 */       return PlanRange.this.done.set(a, d);
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
/* 82 */     return PlanRange.this.done.set(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 87 */     if (PlanRange.this.job(a, d) == null)
/* 88 */       return null; 
/* 89 */     DIR dir = PlanRange.this.blue(a).faceCoo(d.planTile.x(), d.planTile.y());
/* 90 */     a.speed.setDirCurrent(dir);
/* 91 */     a.speed.magnitudeTargetSet(0.0D);
/* 92 */     a.speed.magnitudeInit(0.0D);
/* 93 */     return PlanRange.this.work.set(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\recruit\PlanRange$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */