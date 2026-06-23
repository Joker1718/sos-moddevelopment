/*    */ package settlement.misc.job;
/*    */ 
/*    */ import game.audio.SoundRace;
/*    */ import init.resources.RBIT;
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.work.AIModule_Work;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ 
/*    */ public interface SETT_JOB {
/*    */   void jobReserve(RESOURCE paramRESOURCE);
/*    */   
/*    */   boolean jobReservedIs(RESOURCE paramRESOURCE);
/*    */   
/*    */   void jobReserveCancel(RESOURCE paramRESOURCE);
/*    */   
/*    */   boolean jobReserveCanBe();
/*    */   
/*    */   RBIT jobResourceBitToFetch();
/*    */   
/*    */   double jobPerformTime(Humanoid paramHumanoid);
/*    */   
/*    */   void jobStartPerforming();
/*    */   
/*    */   default int jobResourcesNeeded(Humanoid skill) {
/* 27 */     return AIModule_Work.MAX_FETCH_AMOUNT;
/*    */   }
/*    */   RESOURCE jobPerform(Humanoid paramHumanoid, RESOURCE paramRESOURCE, int paramInt);
/*    */   
/*    */   COORDINATE jobCoo();
/*    */   
/*    */   CharSequence jobName();
/*    */   
/*    */   default DIR jobStandDir() {
/* 36 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   boolean jobUseTool();
/*    */   
/*    */   default boolean jobUseHands() {
/* 43 */     return true;
/*    */   }
/*    */   SoundRace jobSound();
/*    */   
/*    */   default boolean longFetch() {
/* 48 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\job\SETT_JOB.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */