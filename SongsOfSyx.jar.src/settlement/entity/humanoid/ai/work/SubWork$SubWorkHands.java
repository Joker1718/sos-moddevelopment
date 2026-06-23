/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISTATES;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.misc.job.SETT_JOB;
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
/*     */ public abstract class SubWorkHands
/*     */   extends AISUB.Simple
/*     */ {
/*  93 */   private final AISTATES.Animation ani = (AI.STATES()).anima.box;
/*     */   
/*     */   public SubWorkHands(String key) {
/*  96 */     super(key);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/* 101 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation activate(Humanoid a, AIManager d, SETT_JOB j) {
/* 105 */     AISUB.AISubActivation k = activate(a, d, this.ani.resume(a, d, 5.0D));
/* 106 */     int iters = (int)Math.ceil(j.jobPerformTime(a) / 5.0D);
/* 107 */     iters--;
/* 108 */     d.subByte = (byte)iters;
/* 109 */     if (d.subByte < 0)
/* 110 */       throw new RuntimeException("" + d.subByte + " " + d.subByte); 
/* 111 */     return k;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 117 */     d.subByte = (byte)(d.subByte - 1);
/*     */     
/* 119 */     if (d.subByte < 0) {
/* 120 */       return null;
/*     */     }
/* 122 */     SETT_JOB j = getJob(a, d);
/* 123 */     if (j == null)
/* 124 */       return null; 
/* 125 */     if (j.jobSound() != null)
/* 126 */       j.jobSound().rnd(a); 
/* 127 */     if (d.subByte == 0) {
/* 128 */       double t = j.jobPerformTime(a) % 5.0D;
/* 129 */       if (t == 0.0D)
/* 130 */         return this.ani.resume(a, d, 5.0D); 
/* 131 */       return this.ani.resume(a, d, t);
/*     */     } 
/*     */     
/* 134 */     return this.ani.resume(a, d, 5.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CharSequence name(Humanoid a, AIManager d) {
/* 139 */     if (getJob(a, d) == null) {
/* 140 */       return "working";
/*     */     }
/* 142 */     return getJob(a, d).jobName();
/*     */   }
/*     */   
/*     */   protected abstract SETT_JOB getJob(Humanoid paramHumanoid, AIManager paramAIManager);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\SubWork$SubWorkHands.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */