/*     */ package settlement.room.food.fish;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Work
/*     */   implements SETT_JOB
/*     */ {
/*     */   private final boolean tools;
/*  80 */   private final Coo coo = new Coo();
/*     */   FishInstance ins;
/*     */   int data;
/*     */   static final String name = "working";
/*  84 */   private final double wv = 60.0D;
/*     */   
/*     */   Work(boolean tools) {
/*  87 */     this.tools = tools;
/*     */   }
/*     */ 
/*     */   
/*     */   long now;
/*     */   
/*     */   public boolean jobReserveCanBe() {
/*  94 */     if (jobReservedIs(null))
/*  95 */       return false; 
/*  96 */     if (!this.ins.hasStorage)
/*  97 */       return false; 
/*  98 */     return true;
/*     */   }
/*     */   
/*     */   Work init(int tx, int ty, FishInstance ins) {
/* 102 */     this.data = (SETT.ROOMS()).data.get(tx, ty);
/* 103 */     this.coo.set(tx, ty);
/* 104 */     this.ins = ins;
/* 105 */     return this;
/*     */   }
/*     */   
/*     */   void save() {
/* 109 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 114 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public String jobName() {
/* 119 */     return "working";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 124 */     return this.tools;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/* 129 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/* 134 */     return 60.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/* 139 */     if (jobReservedIs(null))
/* 140 */       throw new RuntimeException(); 
/* 141 */     this.data = Job.reserved.set(this.data);
/* 142 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/* 147 */     return Job.reserved.is(this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/* 152 */     this.data = Job.reserved.clear(this.data);
/* 153 */     this.data = Job.used.clear(this.data);
/* 154 */     save();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {
/* 161 */     this.now = System.currentTimeMillis();
/* 162 */     this.data = Job.used.set(this.data);
/* 163 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 168 */     return this.ins.blueprintI().employment().sound();
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid s, RESOURCE res, int ram) {
/* 173 */     Job.this.secretPerform(s, 60.0D);
/* 174 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\fish\Job$Work.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */