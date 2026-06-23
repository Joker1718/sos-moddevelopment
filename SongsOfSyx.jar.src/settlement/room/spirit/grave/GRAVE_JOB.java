/*    */ package settlement.room.spirit.grave;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.misc.job.SETT_JOB;
/*    */ import settlement.thing.ThingsCorpses;
/*    */ 
/*    */ public interface GRAVE_JOB
/*    */   extends SETT_JOB
/*    */ {
/*    */   default RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 12 */     throw new RuntimeException();
/*    */   }
/*    */   
/*    */   void buryAndPerform(ThingsCorpses.Corpse paramCorpse);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\grave\GRAVE_JOB.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */