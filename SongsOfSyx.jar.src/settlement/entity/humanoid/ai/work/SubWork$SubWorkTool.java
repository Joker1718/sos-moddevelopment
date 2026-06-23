/*    */ package settlement.entity.humanoid.ai.work;
/*    */ 
/*    */ import game.GAME;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AISTATE;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.misc.job.SETT_JOB;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class SubWorkTool
/*    */   extends AISUB.Simple
/*    */ {
/*    */   public SubWorkTool(String key) {
/* 22 */     super(key);
/*    */   }
/*    */ 
/*    */   
/*    */   public AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/* 27 */     throw new RuntimeException();
/*    */   }
/*    */   
/*    */   public AISUB.AISubActivation activate(Humanoid a, AIManager d, SETT_JOB j) {
/* 31 */     AISUB.AISubActivation k = activate(a, d, (AI.STATES()).anima.toolSlam.activate(a, d));
/* 32 */     int iters = (int)(j.jobPerformTime(a) / ((AI.STATES()).anima.toolSlam.time + (AI.STATES()).anima.toolBack.time));
/* 33 */     if (j.jobPerformTime(a) - iters > 0.0D)
/* 34 */       iters++; 
/* 35 */     iters *= 2;
/* 36 */     iters &= 0xFFFFFFFE;
/* 37 */     if (iters > 255)
/*    */     {
/* 39 */       iters = 255;
/*    */     }
/* 41 */     if (iters <= 0) {
/* 42 */       GAME.Notify("bah " + iters + " " + j.jobPerformTime(a) + " " + String.valueOf(j.jobCoo()));
/* 43 */       d.subByte = 2;
/*    */     } 
/*    */     
/* 46 */     d.subByte = (byte)iters;
/*    */     
/* 48 */     return k;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 55 */     d.subByte = (byte)(d.subByte - 1);
/*    */     
/* 57 */     int s = d.subByte & 0xFF;
/* 58 */     if (s == 0)
/* 59 */       return null; 
/* 60 */     if ((s & 0x1) == 1) {
/* 61 */       SETT_JOB j = getJob(a, d);
/* 62 */       if (j == null)
/* 63 */         return null; 
/* 64 */       if (j.jobSound() != null) {
/* 65 */         if (a == null) {
/* 66 */           System.err.println("a");
/* 67 */         } else if (a.physics == null) {
/* 68 */           System.err.println("phy");
/* 69 */         } else if (a.physics.body() == null) {
/* 70 */           System.err.println("2");
/* 71 */         }  j.jobSound().rnd(a);
/*    */       } 
/* 73 */       return (AI.STATES()).anima.toolBack.activate(a, d);
/*    */     } 
/* 75 */     return (AI.STATES()).anima.toolSlam.activate(a, d);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected CharSequence name(Humanoid a, AIManager d) {
/* 81 */     if (getJob(a, d) == null) {
/* 82 */       return "working";
/*    */     }
/* 84 */     return getJob(a, d).jobName();
/*    */   }
/*    */   
/*    */   protected abstract SETT_JOB getJob(Humanoid paramHumanoid, AIManager paramAIManager);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\SubWork$SubWorkTool.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */