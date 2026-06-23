/*     */ package settlement.room.infra.elderly;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements SETT_JOB
/*     */ {
/*     */   public boolean jobUseTool() {
/*  57 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {
/*  62 */     Job.this.data = Job.this.using.set(Job.this.data);
/*  63 */     (SETT.ROOMS()).data.set((ROOMA)Job.this.ins, (COORDINATE)Job.this.coo, Job.this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/*  68 */     return Job.this.b.employment().sound();
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/*  73 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/*  78 */     return Job.this.reserved.is(Job.this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/*  83 */     Job.this.data = Job.this.reserved.clear(Job.this.data);
/*  84 */     Job.this.data = Job.this.using.clear(Job.this.data);
/*  85 */     (SETT.ROOMS()).data.set((ROOMA)Job.this.ins, (COORDINATE)Job.this.coo, Job.this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/*  90 */     return !Job.this.reserved.is(Job.this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/*  95 */     Job.this.data = Job.this.reserved.set(Job.this.data);
/*  96 */     Job.this.data = Job.this.using.clear(Job.this.data);
/*  97 */     (SETT.ROOMS()).data.set((ROOMA)Job.this.ins, (COORDINATE)Job.this.coo, Job.this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/* 102 */     return 45.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/* 107 */     jobReserveCancel(r);
/* 108 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 113 */     return (Job.this.b.employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 118 */     return (COORDINATE)Job.this.coo;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\elderly\Job$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */