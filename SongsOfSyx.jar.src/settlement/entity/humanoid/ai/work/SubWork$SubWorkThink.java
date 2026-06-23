/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ public abstract class SubWorkThink
/*     */   extends AISUB.Simple
/*     */ {
/*     */   public SubWorkThink(String key) {
/* 152 */     super(key);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/* 157 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation activate(Humanoid a, AIManager d, SETT_JOB j) {
/* 161 */     AISUB.AISubActivation k = activate(a, d, resume(a, d, 5.0D));
/* 162 */     int iters = (int)Math.ceil(j.jobPerformTime(a) / 5.0D);
/* 163 */     iters--;
/* 164 */     d.subByte = (byte)iters;
/* 165 */     if (d.subByte < 0)
/* 166 */       throw new RuntimeException("" + d.subByte); 
/* 167 */     return k;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISTATE resume(Humanoid a, AIManager d) {
/* 173 */     d.subByte = (byte)(d.subByte - 1);
/*     */     
/* 175 */     if (d.subByte < 0) {
/* 176 */       return null;
/*     */     }
/* 178 */     SETT_JOB j = getJob(a, d);
/* 179 */     if (j == null)
/* 180 */       return null; 
/* 181 */     if (j.jobSound() != null)
/* 182 */       j.jobSound().rnd(a); 
/* 183 */     if (d.subByte == 0) {
/* 184 */       double t = j.jobPerformTime(a) % 5.0D;
/* 185 */       if (t == 0.0D)
/* 186 */         return resume(a, d, 5.0D); 
/* 187 */       return resume(a, d, t);
/*     */     } 
/*     */     
/* 190 */     return resume(a, d, 5.0D);
/*     */   }
/*     */   
/*     */   private AISTATE resume(Humanoid a, AIManager d, double time) {
/* 194 */     if (RND.oneIn(8)) {
/* 195 */       a.speed.setDirCurrent(a.speed.dir().next(-1 + RND.rInt(3)));
/* 196 */       return (AI.STATES()).anima.stand.activate(a, d, time);
/*     */     } 
/* 198 */     a.speed.setDirCurrent(DIR.get(a.tc(), getJob(a, d).jobCoo()));
/* 199 */     if (RND.rBoolean()) {
/* 200 */       return (AI.STATES()).anima.fistRight.resume(a, d, time);
/*     */     }
/* 202 */     return (AI.STATES()).anima.stand.activate(a, d, time);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CharSequence name(Humanoid a, AIManager d) {
/* 207 */     if (getJob(a, d) == null) {
/* 208 */       return "working";
/*     */     }
/* 210 */     return getJob(a, d).jobName();
/*     */   }
/*     */   
/*     */   protected abstract SETT_JOB getJob(Humanoid paramHumanoid, AIManager paramAIManager);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\SubWork$SubWorkThink.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */