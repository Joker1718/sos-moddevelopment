/*     */ package settlement.room.water;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ class PumpJob
/*     */   implements SETT_JOB {
/*     */   private final ROOM_PUMP print;
/*  16 */   private final Coo coo = new Coo();
/*     */   
/*     */   private PumpInstance ins;
/*  19 */   private final RoomBits bReserved = new RoomBits((COORDINATE)this.coo, 1);
/*  20 */   private final RoomBits bWorked = new RoomBits((COORDINATE)this.coo, 2);
/*     */ 
/*     */   
/*     */   private final double wv = 45.0D;
/*     */ 
/*     */ 
/*     */   
/*     */   SETT_JOB init(int tx, int ty, PumpInstance ins) {
/*  28 */     if (!ins.is(tx, ty))
/*  29 */       return null; 
/*  30 */     if (!this.print.constructor.isJob(tx, ty))
/*  31 */       return null; 
/*  32 */     this.ins = ins;
/*  33 */     this.coo.set(tx, ty);
/*  34 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/*  41 */     if (jobReservedIs(null))
/*  42 */       return false; 
/*  43 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/*  48 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/*  53 */     return (this.print.employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/*  58 */     return false;
/*     */   }
/*     */   
/*     */   boolean working(int data) {
/*  62 */     return (this.bWorked.get(data) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/*  67 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/*  72 */     return 45.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/*  77 */     if (jobReservedIs(null))
/*  78 */       throw new RuntimeException(); 
/*  79 */     this.bReserved.set((ROOMA)this.ins, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/*  84 */     return (this.bReserved.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/*  89 */     this.bReserved.set((ROOMA)this.ins, 0);
/*  90 */     this.bWorked.set((ROOMA)this.ins, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {
/*  95 */     this.bWorked.set((ROOMA)this.ins, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 100 */     return this.ins.blueprintI().employment().sound();
/*     */   }
/*     */   PumpJob(ROOM_PUMP print) {
/* 103 */     this.wv = 45.0D;
/*     */     this.print = print;
/*     */   }
/*     */   public RESOURCE jobPerform(Humanoid s, RESOURCE res, int ram) {
/* 107 */     jobReserveCancel(res);
/* 108 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\PumpJob.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */