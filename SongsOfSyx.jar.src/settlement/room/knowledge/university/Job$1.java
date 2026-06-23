/*     */ package settlement.room.knowledge.university;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.bit.Bit;
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
/*     */ class null
/*     */   implements SETT_JOB
/*     */ {
/*  39 */   private final Bit reserved = new Bit(1);
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/*  43 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/*  53 */     return Job.this.b.employment().sound();
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/*  58 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/*  63 */     return this.reserved.is(Job.this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/*  68 */     Job.this.data = this.reserved.clear(Job.this.data);
/*  69 */     (SETT.ROOMS()).data.set((ROOMA)Job.this.ins, (COORDINATE)Job.this.coo, Job.this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/*  74 */     return !this.reserved.is(Job.this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/*  79 */     Job.this.data = this.reserved.set(Job.this.data);
/*  80 */     (SETT.ROOMS()).data.set((ROOMA)Job.this.ins, (COORDINATE)Job.this.coo, Job.this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/*  85 */     return 45.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/*  90 */     jobReserveCancel(r);
/*  91 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/*  96 */     return (Job.this.b.employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 101 */     return (COORDINATE)Job.this.coo;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledg\\university\Job$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */