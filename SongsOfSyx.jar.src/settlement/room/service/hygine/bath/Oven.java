/*     */ package settlement.room.service.hygine.bath;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ public class Oven
/*     */   implements SETT_JOB
/*     */ {
/*     */   static final int BIT = 16384;
/*  19 */   private static final Oven self = new Oven();
/*     */   int data;
/*  21 */   final Coo coo = new Coo();
/*     */   BathInstance ins;
/*     */   
/*     */   static Oven init(int tx, int ty, ROOM_BATH b) {
/*  25 */     if (!b.is(tx, ty))
/*  26 */       return null; 
/*  27 */     int data = (SETT.ROOMS()).data.get(tx, ty);
/*  28 */     if ((data & 0xE000) != 16384)
/*  29 */       return null; 
/*  30 */     self.data = data;
/*  31 */     self.coo.set(tx, ty);
/*  32 */     self.ins = (BathInstance)b.get(tx, ty);
/*  33 */     return self;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   final String name = "bringing fuel to furnace";
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/*  42 */     return false;
/*     */   }
/*     */   
/*     */   private void save() {
/*  46 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, this.coo.x(), this.coo.y(), this.data);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/*  56 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/*  61 */     if ((this.ins.blueprintI()).consumtion.ins().get(0) == null)
/*  62 */       return null; 
/*  63 */     return ((IndustryResource)(this.ins.blueprintI()).consumtion.ins().get(0)).resource.bit;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/*  68 */     return ((this.data & 0x1000) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/*  73 */     this.data &= 0xFFFFEFFF;
/*  74 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/*  79 */     return (this.ins.heat < (this.ins.service().total() * 2) && !jobReservedIs(null));
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/*  84 */     if (jobReservedIs(null))
/*  85 */       throw new RuntimeException(); 
/*  86 */     this.data |= 0x1000;
/*  87 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public int jobResourcesNeeded(Humanoid skill) {
/*  92 */     return (SETT.ROOMS()).STOCKPILE.carryCap(skill);
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/*  97 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ri) {
/* 102 */     this.ins.heat += ri;
/* 103 */     ((IndustryResource)(this.ins.blueprintI()).consumtion.ins().get(0)).inc((ROOM_IDATA_INSTANCE)this.ins, ri);
/* 104 */     jobReserveCancel(r);
/* 105 */     return null;
/*     */   }
/*     */   private Oven() {
/* 108 */     this.name = "bringing fuel to furnace";
/*     */   }
/*     */   
/*     */   public String jobName() {
/* 112 */     return "bringing fuel to furnace";
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 117 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\bath\Oven.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */