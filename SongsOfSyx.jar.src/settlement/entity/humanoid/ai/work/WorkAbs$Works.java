/*    */ package settlement.entity.humanoid.ai.work;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
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
/*    */ class Works
/*    */ {
/* 49 */   final SubWork.SubWorkTool subTool = new SubWork.SubWorkTool("WORK_TOOL")
/*    */     {
/*    */       protected SETT_JOB getJob(Humanoid a, AIManager d)
/*    */       {
/* 53 */         if (WorkAbs.work(a) == null)
/* 54 */           return null; 
/* 55 */         return ((JOBMANAGER_HASER)WorkAbs.work(a)).getWork().getJob((COORDINATE)d.planTile);
/*    */       }
/*    */     };
/*    */ 
/*    */   
/* 60 */   final SubWork.SubWorkHands subHands = new SubWork.SubWorkHands("WORK_HANDS")
/*    */     {
/*    */       protected SETT_JOB getJob(Humanoid a, AIManager d)
/*    */       {
/* 64 */         if (WorkAbs.work(a) == null)
/* 65 */           return null; 
/* 66 */         return ((JOBMANAGER_HASER)WorkAbs.work(a)).getWork().getJob((COORDINATE)d.planTile);
/*    */       }
/*    */     };
/*    */ 
/*    */   
/* 71 */   final SubWork.SubWorkThink subThink = new SubWork.SubWorkThink("WORK_THINK")
/*    */     {
/*    */       protected SETT_JOB getJob(Humanoid a, AIManager d)
/*    */       {
/* 75 */         if (WorkAbs.work(a) == null)
/* 76 */           return null; 
/* 77 */         return ((JOBMANAGER_HASER)WorkAbs.work(a)).getWork().getJob((COORDINATE)d.planTile);
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkAbs$Works.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */