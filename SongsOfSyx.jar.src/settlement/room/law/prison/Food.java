/*     */ package settlement.room.law.prison;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResGEat;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ final class Food implements SETT_JOB, FSERVICE {
/*  20 */   private static final Bits food_amount = new Bits(255);
/*  21 */   private static final Bit food_reserved = new Bit(256);
/*  22 */   private static final Bit job_reserved = new Bit(512);
/*  23 */   private Coo coo = new Coo();
/*     */ 
/*     */ 
/*     */   
/*     */   private PrisonInstance ins;
/*     */ 
/*     */   
/*  30 */   private static Food self = new Food();
/*     */ 
/*     */   
/*     */   static Food init(int tx, int ty) {
/*  34 */     self.ins = (PrisonInstance)(SETT.ROOMS()).PRISON.get(tx, ty);
/*  35 */     if (self.ins == null || (SETT.ROOMS()).fData.tileData.get(tx, ty) != 3) {
/*  36 */       return null;
/*     */     }
/*  38 */     self.coo.set(tx, ty);
/*  39 */     return self;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static int foodAmount(int data) {
/*  45 */     return food_amount.get(data);
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/*  50 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/*  55 */     return ((SETT.ROOMS()).PRISON.employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/*  60 */     int d = job_reserved.set((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*  61 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/*  66 */     return job_reserved.is((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/*  71 */     int d = job_reserved.clear((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*  72 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/*  77 */     return (!jobReservedIs(null) && food_amount.get((SETT.ROOMS()).data.get((COORDINATE)this.coo)) < 8);
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/*  82 */     return (RBIT)this.ins.fetch;
/*     */   }
/*     */ 
/*     */   
/*     */   public int jobResourcesNeeded(Humanoid skill) {
/*  87 */     return food_amount.mask - food_amount.get((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/*  92 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ri) {
/* 102 */     int d = food_amount.inc((SETT.ROOMS()).data.get((COORDINATE)this.coo), ri);
/* 103 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/* 104 */     if (RESOURCES.EDI().get(r) != null) {
/* 105 */       ((IndustryResource)(this.ins.blueprintI()).indu.ins().get(((ResGEat)RESOURCES.EDI().get(r)).index())).inc((ROOM_IDATA_INSTANCE)this.ins, ri);
/*     */     } else {
/* 107 */       FACTIONS.player().res().inc(r, FResources.RTYPE.CONSUMED, -ri);
/* 108 */     }  jobReserveCancel(null);
/* 109 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 114 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 119 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/* 124 */     return (food_amount.get((SETT.ROOMS()).data.get((COORDINATE)this.coo)) > 0 && !food_reserved.is((SETT.ROOMS()).data.get((COORDINATE)this.coo)));
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/* 129 */     int d = food_reserved.set((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/* 130 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 135 */     return food_reserved.is((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 140 */     int d = food_reserved.clear((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/* 141 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/* 146 */     return this.coo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/* 151 */     return this.coo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public void consume() {
/* 156 */     int d = food_amount.inc((SETT.ROOMS()).data.get((COORDINATE)this.coo), -1);
/* 157 */     d = food_reserved.clear(d);
/* 158 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\prison\Food.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */