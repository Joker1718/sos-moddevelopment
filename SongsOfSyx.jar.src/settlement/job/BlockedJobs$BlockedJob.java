/*     */ package settlement.job;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import util.text.Dic;
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
/*     */ public final class BlockedJob
/*     */   implements SETT_JOB
/*     */ {
/* 206 */   private final Coo coo = new Coo();
/* 207 */   private final Coo blocked = new Coo();
/*     */   public final int ID;
/*     */   
/*     */   private BlockedJob(int id) {
/* 211 */     this.ID = id;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/* 216 */     Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 217 */     if (j != null) {
/* 218 */       j.jobReserve(r);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/* 223 */     Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 224 */     if (j != null)
/* 225 */       return j.jobReservedIs(r); 
/* 226 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/* 231 */     Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 232 */     if (j != null) {
/* 233 */       j.jobReserveCancel(r);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean jobReserveCanBe() {
/* 238 */     Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 239 */     if (j != null)
/* 240 */       return j.jobReserveCanBe(); 
/* 241 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/* 246 */     Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 247 */     if (j != null) {
/* 248 */       return j.jobResourceBitToFetch();
/*     */     }
/* 250 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int jobResourcesNeeded(Humanoid skill) {
/* 255 */     Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 256 */     if (j != null) {
/* 257 */       return j.jobResourcesNeeded(skill);
/*     */     }
/* 259 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid a) {
/* 264 */     Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 265 */     if (j != null) {
/* 266 */       return j.jobPerformTime(a);
/*     */     }
/* 268 */     return 1.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 278 */     Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 279 */     if (j != null) {
/* 280 */       return j.jobPerform(skill, r, rAm);
/*     */     }
/* 282 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 287 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 292 */     Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 293 */     if (j != null)
/* 294 */       return j.jobName(); 
/* 295 */     return Dic.empty;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 300 */     Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 301 */     if (j != null)
/* 302 */       return j.jobUseTool(); 
/* 303 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 308 */     Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)this.blocked);
/* 309 */     if (j != null)
/* 310 */       return j.jobSound(); 
/* 311 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\BlockedJobs$BlockedJob.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */