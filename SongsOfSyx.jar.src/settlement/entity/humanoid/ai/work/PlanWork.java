/*    */ package settlement.entity.humanoid.ai.work;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.misc.job.JOBMANAGER_HASER;
/*    */ import settlement.misc.job.SETT_JOB;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ 
/*    */ abstract class PlanWork
/*    */   extends AIPLAN.PLANRES {
/*    */   public PlanWork(String key) {
/* 16 */     super(key);
/*    */   }
/*    */   
/*    */   static RoomInstance work(Humanoid a) {
/* 20 */     return (RoomInstance)(STATS.WORK()).EMPLOYED.get(a);
/*    */   }
/*    */   
/*    */   boolean shouldWork(Humanoid a, AIManager d) {
/* 24 */     return (work(a) != null);
/*    */   }
/*    */   
/*    */   boolean hasEmployment(Humanoid a, AIManager d) {
/* 28 */     return (work(a) != null && work(a).active() && !work(a).employees().isOverstaffed());
/*    */   }
/*    */   
/*    */   SETT_JOB jobGet(Humanoid a, AIManager d) {
/* 32 */     if (shouldWork(a, d)) {
/* 33 */       SETT_JOB j = ((JOBMANAGER_HASER)work(a)).getWork().getJob((COORDINATE)d.planTile);
/* 34 */       return j;
/*    */     } 
/* 36 */     return null;
/*    */   }
/*    */   
/*    */   boolean jobIsReservedAndReserve(Humanoid a, AIManager d, RESOURCE r) {
/* 40 */     if (shouldWork(a, d)) {
/* 41 */       SETT_JOB j = ((JOBMANAGER_HASER)work(a)).getWork().getJob((COORDINATE)d.planTile);
/* 42 */       if (j != null) {
/* 43 */         if (j.jobReservedIs(r))
/* 44 */           return true; 
/* 45 */         if (j.jobReserveCanBe()) {
/* 46 */           if (j.jobResourceBitToFetch() == null) {
/* 47 */             j.jobReserve(null);
/* 48 */             return (jobGet(a, d) != null);
/* 49 */           }  if (r != null && r.bit.has(j.jobResourceBitToFetch())) {
/* 50 */             j.jobReserve(r);
/* 51 */             return (jobGet(a, d) != null);
/*    */           } 
/* 53 */           return false;
/*    */         } 
/*    */       } 
/*    */     } 
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   void jobCancel(Humanoid a, AIManager d, RESOURCE r) {
/* 61 */     if (shouldWork(a, d)) {
/* 62 */       RoomInstance roomInstance = work(a);
/* 63 */       if (roomInstance == null)
/*    */         return; 
/* 65 */       if (roomInstance != null && roomInstance instanceof JOBMANAGER_HASER) {
/* 66 */         SETT_JOB j = ((JOBMANAGER_HASER)roomInstance).getWork().getJob((COORDINATE)d.planTile);
/* 67 */         if (j != null && j.jobReservedIs(r)) {
/* 68 */           j.jobReserveCancel(r);
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected String debug(Humanoid a, AIManager d) {
/* 77 */     return super.debug(a, d) + " w: " + super.debug(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\PlanWork.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */