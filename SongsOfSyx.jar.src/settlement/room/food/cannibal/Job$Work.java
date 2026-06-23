/*     */ package settlement.room.food.cannibal;
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
/*     */ final class Work
/*     */   implements SETT_JOB
/*     */ {
/*     */   private static final int BITRESERVED = 1;
/*  54 */   private final Coo coo = new Coo();
/*     */ 
/*     */   
/*     */   CannibalInstance ins;
/*     */ 
/*     */   
/*     */   int data;
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/*  64 */     return !jobReservedIs(null);
/*     */   }
/*     */   
/*     */   Work init(int tx, int ty, CannibalInstance ins) {
/*  68 */     this.data = (SETT.ROOMS()).data.get(tx, ty);
/*  69 */     this.coo.set(tx, ty);
/*  70 */     this.ins = ins;
/*  71 */     return this;
/*     */   }
/*     */   
/*     */   void save() {
/*  75 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/*  80 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/*  85 */     return (Job.this.print.employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/*  90 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/*  95 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/* 100 */     return 45.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/* 105 */     if (jobReservedIs(null))
/* 106 */       throw new RuntimeException(); 
/* 107 */     this.data |= 0x1;
/* 108 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/* 113 */     return ((this.data & 0x1) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/* 118 */     this.data &= 0xFFFFFFFE;
/* 119 */     save();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 129 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE res, int ram) {
/* 134 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\cannibal\Job$Work.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */