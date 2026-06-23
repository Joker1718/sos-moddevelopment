/*     */ package settlement.room.food.hunter;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ 
/*     */ class Job
/*     */ {
/*     */   private final ROOM_HUNTER print;
/*  18 */   final Work WORK = new Work();
/*  19 */   static final Bits gore = new Bits(112);
/*     */   
/*     */   Job(ROOM_HUNTER print) {
/*  22 */     this.print = print;
/*     */   }
/*     */   
/*     */   void reset(HunterInstance ins, COORDINATE c) {
/*  26 */     int d = (SETT.ROOMS()).data.get(c);
/*  27 */     (SETT.ROOMS()).data.set((ROOMA)ins, c, gore.set(d, 0));
/*     */   }
/*     */   
/*     */   void gore(HunterInstance ins, COORDINATE c) {
/*  31 */     int d = (SETT.ROOMS()).data.get(c);
/*  32 */     (SETT.ROOMS()).data.set((ROOMA)ins, c, gore.inc(d, 1));
/*     */   }
/*     */ 
/*     */   
/*     */   SETT_JOB init(int tx, int ty, HunterInstance ins) {
/*  37 */     if (!ins.is(tx, ty))
/*  38 */       return null; 
/*  39 */     if ((SETT.ROOMS()).fData.tile.is(tx, ty, (ins.blueprintI()).constructor.ww))
/*  40 */       return this.WORK.init(tx, ty, ins); 
/*  41 */     return null;
/*     */   }
/*     */   
/*     */   final class Work
/*     */     implements SETT_JOB
/*     */   {
/*     */     private static final int BITRESERVED = 1;
/*  48 */     private final Coo coo = new Coo();
/*     */ 
/*     */     
/*     */     HunterInstance ins;
/*     */ 
/*     */     
/*     */     int data;
/*     */ 
/*     */     
/*     */     public boolean jobReserveCanBe() {
/*  58 */       return !jobReservedIs(null);
/*     */     }
/*     */     
/*     */     Work init(int tx, int ty, HunterInstance ins) {
/*  62 */       this.data = (SETT.ROOMS()).data.get(tx, ty);
/*  63 */       this.coo.set(tx, ty);
/*  64 */       this.ins = ins;
/*  65 */       return this;
/*     */     }
/*     */     
/*     */     void save() {
/*  69 */       (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*     */     }
/*     */ 
/*     */     
/*     */     public COORDINATE jobCoo() {
/*  74 */       return (COORDINATE)this.coo;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence jobName() {
/*  79 */       return (Job.this.print.employment()).verb;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobUseTool() {
/*  84 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public RBIT jobResourceBitToFetch() {
/*  89 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public double jobPerformTime(Humanoid skill) {
/*  94 */       return 45.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserve(RESOURCE r) {
/*  99 */       if (jobReservedIs(null))
/* 100 */         throw new RuntimeException(); 
/* 101 */       this.data |= 0x1;
/* 102 */       save();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobReservedIs(RESOURCE r) {
/* 107 */       return ((this.data & 0x1) == 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserveCancel(RESOURCE r) {
/* 112 */       this.data &= 0xFFFFFFFE;
/* 113 */       save();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public SoundRace jobSound() {
/* 123 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public RESOURCE jobPerform(Humanoid skill, RESOURCE res, int ram) {
/* 129 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\hunter\Job.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */