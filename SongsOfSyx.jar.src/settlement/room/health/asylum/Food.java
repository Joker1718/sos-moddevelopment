/*     */ package settlement.room.health.asylum;
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ final class Food implements SETT_JOB {
/*  16 */   private static final Bits amount = new Bits(15);
/*  17 */   private static final Bit reserved = new Bit(16);
/*  18 */   private Coo coo = new Coo();
/*     */ 
/*     */ 
/*     */   
/*     */   private AsylumInstance ins;
/*     */ 
/*     */   
/*  25 */   private static Food self = new Food();
/*     */ 
/*     */   
/*     */   static Food init(int tx, int ty) {
/*  29 */     self.ins = (AsylumInstance)b().get(tx, ty);
/*  30 */     if (self.ins == null || (SETT.ROOMS()).fData.tileData.get(tx, ty) != 2)
/*  31 */       return null; 
/*  32 */     self.coo.set(tx, ty);
/*     */     
/*  34 */     return self;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static int food(int data) {
/*  40 */     return amount.get(data);
/*     */   }
/*     */   
/*     */   int food() {
/*  44 */     return food((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*     */   }
/*     */   
/*     */   void consume() {
/*  48 */     int d = amount.inc((SETT.ROOMS()).data.get((COORDINATE)this.coo), -1);
/*  49 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/*  54 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/*  59 */     return ((SETT.ROOMS()).PRISON.employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/*  64 */     int d = reserved.set((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*  65 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/*  70 */     return reserved.is((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/*  75 */     int d = reserved.clear((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*  76 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/*  81 */     return !jobReservedIs(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/*  86 */     if (amount.get((SETT.ROOMS()).data.get((COORDINATE)this.coo)) < 1 && this.ins.jobs.resourceShouldSearch(((IndustryResource)(b()).consumtion.ins().get(0)).resource))
/*  87 */       return ((IndustryResource)(b()).consumtion.ins().get(0)).resource.bit; 
/*  88 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/*  93 */     return 25.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ri) {
/* 103 */     if (r == ((IndustryResource)(b()).consumtion.ins().get(0)).resource) {
/* 104 */       int d = amount.inc((SETT.ROOMS()).data.get((COORDINATE)this.coo), ri);
/* 105 */       (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/* 106 */       ((IndustryResource)(b()).consumtion.ins().get(0)).inc((ROOM_IDATA_INSTANCE)b().get(this.coo.x(), this.coo.y()), ri);
/*     */     } 
/* 108 */     jobReserveCancel(null);
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
/*     */   public boolean jobUseHands() {
/* 124 */     return false;
/*     */   }
/*     */   
/*     */   private static final ROOM_ASYLUM b() {
/* 128 */     return (SETT.ROOMS()).ASYLUM;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\asylum\Food.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */