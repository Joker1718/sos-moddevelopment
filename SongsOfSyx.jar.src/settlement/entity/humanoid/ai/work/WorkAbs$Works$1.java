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
/*    */ class null
/*    */   extends SubWork.SubWorkTool
/*    */ {
/*    */   null(String $anonymous0) {
/* 49 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected SETT_JOB getJob(Humanoid a, AIManager d) {
/* 53 */     if (WorkAbs.work(a) == null)
/* 54 */       return null; 
/* 55 */     return ((JOBMANAGER_HASER)WorkAbs.work(a)).getWork().getJob((COORDINATE)d.planTile);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkAbs$Works$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */