/*     */ package settlement.room.law.prison;
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.service.lavatory.ROOM_LAVATORY;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ final class Latrine implements SETT_JOB, FSERVICE {
/*  16 */   private static final Bit latrine_reserved = new Bit(1);
/*  17 */   private static final Bit latrine_used = new Bit(2);
/*  18 */   private static final Bit latrine_jobreserved = new Bit(4);
/*  19 */   private Coo coo = new Coo();
/*     */ 
/*     */ 
/*     */   
/*     */   private PrisonInstance ins;
/*     */ 
/*     */   
/*  26 */   static final Latrine self = new Latrine();
/*     */   
/*     */   static Latrine init(int tx, int ty) {
/*  29 */     self.ins = (PrisonInstance)(SETT.ROOMS()).PRISON.get(tx, ty);
/*  30 */     if (self.ins == null || (SETT.ROOMS()).fData.tileData.get(tx, ty) != 2)
/*  31 */       return null; 
/*  32 */     self.coo.set(tx, ty);
/*  33 */     return self;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean latrineUsed(int data) {
/*  39 */     return latrine_used.is(data);
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/*  44 */     if ((SETT.ROOMS()).LAVATORIES.size() > 0)
/*  45 */       return ((ROOM_LAVATORY)(SETT.ROOMS()).LAVATORIES.get(0)).employment().sound(); 
/*  46 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/*  51 */     return ((SETT.ROOMS()).PRISON.employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/*  56 */     int d = latrine_jobreserved.set((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*  57 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/*  62 */     return latrine_jobreserved.is((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/*  67 */     int d = latrine_jobreserved.clear((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*  68 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/*  73 */     return !jobReservedIs(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/*  78 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/*  83 */     return 45.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/*  93 */     jobReserveCancel(null);
/*  94 */     int d = latrine_used.clear((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*  95 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/*  96 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 101 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/* 111 */     return !latrine_reserved.is((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/* 116 */     int d = latrine_reserved.set((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/* 117 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 122 */     return latrine_reserved.is((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 127 */     int d = latrine_reserved.clear((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/* 128 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/* 133 */     return this.coo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/* 138 */     return this.coo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public void consume() {
/* 143 */     int d = latrine_used.set((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/* 144 */     d = latrine_reserved.clear(d);
/* 145 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\prison\Latrine.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */