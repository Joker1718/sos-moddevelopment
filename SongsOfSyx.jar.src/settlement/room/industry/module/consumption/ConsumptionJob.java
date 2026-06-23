/*     */ package settlement.room.industry.module.consumption;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import util.data.BOOLEANCoo;
/*     */ 
/*     */ public abstract class ConsumptionJob
/*     */   implements SETT_JOB {
/*  23 */   protected final Coo coo = new Coo();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  31 */   private final RoomBits reserved = new RoomBits((COORDINATE)this.coo, new Bits(1610612736));
/*  32 */   private final RoomBits used = new RoomBits((COORDINATE)this.coo, new Bits(536870912));
/*     */   
/*     */   protected RoomInstance ins;
/*     */   
/*     */   protected ROOM_IDATA_INSTANCE insc;
/*     */   
/*     */   protected final int time;
/*     */   
/*     */   protected final RoomBlueprintIns<?> blue;
/*     */   
/*     */   protected final RoomConsumption bluec;
/*     */   
/*     */   private final BOOLEANCoo is;
/*     */   
/*     */   private final RBIT.RBITImp resBit;
/*     */ 
/*     */   
/*     */   public SETT_JOB get(int tx, int ty) {
/*  50 */     this.ins = this.blue.get(tx, ty);
/*  51 */     if (this.ins == null)
/*  52 */       return null; 
/*  53 */     if (this.is.is(tx, ty)) {
/*  54 */       this.coo.set(tx, ty);
/*  55 */       this.insc = (ROOM_IDATA_INSTANCE)this.ins;
/*  56 */       return this;
/*     */     } 
/*     */     
/*  59 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean used(int tx, int ty) {
/*  68 */     return (this.used.get((SETT.ROOMS()).data.get(tx, ty)) == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/*  77 */     if (this.reserved.get() == 1) {
/*  78 */       throw new RuntimeException();
/*     */     }
/*  80 */     this.reserved.set((ROOMA)this.ins, 1);
/*     */     
/*  82 */     if (r != null) {
/*  83 */       IndustryResource rr = this.bluec.in(r);
/*  84 */       if (rr == null)
/*  85 */         throw new RuntimeException(); 
/*  86 */       this.reserved.set((ROOMA)this.ins, 1);
/*  87 */       this.bluec.reseved(rr).inc(this.insc, 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/*  94 */     return (this.reserved.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/*  99 */     this.reserved.set((ROOMA)this.ins, 0);
/* 100 */     this.used.set((ROOMA)this.ins, 0);
/*     */     
/* 102 */     if (r == null)
/*     */       return; 
/* 104 */     IndustryResource rr = this.bluec.in(r);
/* 105 */     if (rr == null)
/*     */       return; 
/* 107 */     this.bluec.reseved(rr).inc(this.insc, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/* 112 */     if (jobReservedIs(null)) {
/* 113 */       return false;
/*     */     }
/*     */     
/* 116 */     return true;
/*     */   }
/*     */   
/*     */   public ConsumptionJob(RoomBlueprintIns<?> b, RoomConsumption cons, int time, BOOLEANCoo is) {
/* 120 */     this.resBit = new RBIT.RBITImp(); this.blue = b;
/*     */     this.bluec = cons;
/*     */     this.time = time;
/* 123 */     this.is = is; } public RBIT jobResourceBitToFetch() { this.resBit.clear();
/* 124 */     for (IndustryResource in : this.bluec.ins()) {
/* 125 */       if (this.bluec.shouldFecth(in, this.insc, this.ins)) {
/* 126 */         this.resBit.or(in.resource.bit);
/*     */       }
/*     */     } 
/*     */     
/* 130 */     return this.resBit.isClear() ? null : (RBIT)this.resBit; }
/*     */ 
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/* 135 */     return this.time;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {
/* 140 */     this.used.set((ROOMA)this.ins, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/* 146 */     jobReserveCancel(r);
/*     */     
/* 148 */     if (r != null) {
/* 149 */       IndustryResource rr = this.bluec.in(r);
/* 150 */       if (rr == null)
/* 151 */         return null; 
/* 152 */       if (this.bluec.enabled(rr, this.insc)) {
/* 153 */         ram = (SETT.ROOMS()).resourceUnderflow.deposit(r, ram);
/* 154 */         this.bluec.stored(rr).inc(this.insc, ram);
/*     */       } else {
/* 156 */         (SETT.THINGS()).resources.create(skill.tc(), r, ram);
/* 157 */       }  return null;
/*     */     } 
/*     */ 
/*     */     
/* 161 */     int t = this.ins.employees().fetchBonus(this.time);
/* 162 */     double d = IndustryUtil.calcProductionRate(1.0D, skill, this.bluec, this.ins);
/*     */     
/* 164 */     for (IndustryResource in : this.bluec.ins()) {
/*     */       
/* 166 */       if (this.bluec.stored(in).get(this.insc) > 0) {
/* 167 */         int a = in.work(skill, this.insc, t);
/* 168 */         if (a > 0) {
/* 169 */           a = (SETT.ROOMS()).resourceUnderflow.withdraw(in.resource, a, this.bluec.stored(in).get(this.insc));
/* 170 */           this.bluec.stored(in).inc(this.insc, -a);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 176 */     perform(t, d);
/* 177 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 184 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 189 */     return (this.blue.employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 194 */     return this.blue.employment().sound();
/*     */   }
/*     */   
/*     */   protected abstract void perform(double paramDouble1, double paramDouble2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\consumption\ConsumptionJob.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */