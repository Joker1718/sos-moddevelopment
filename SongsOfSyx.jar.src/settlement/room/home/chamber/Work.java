/*     */ package settlement.room.home.chamber;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.race.RACES;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsHome;
/*     */ import settlement.stats.equip.WearableResource;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ final class Work
/*     */   implements SETT_JOB
/*     */ {
/*     */   private static final int NEEDS = 0;
/*     */   private static final int RESERVED = 1;
/*     */   private int data;
/*  27 */   private final Coo coo = new Coo();
/*     */   
/*     */   private ChamberInstance ins;
/*     */   
/*     */   private final ROOM_CHAMBER blue;
/*     */   int i;
/*     */   private final RBIT.RBITImp bit;
/*     */   
/*     */   Work get(int tx, int ty) {
/*  36 */     if (this.blue.is(tx, ty)) {
/*  37 */       int data = (SETT.ROOMS()).data.get(tx, ty);
/*  38 */       if ((SETT.PATH()).availability.get(tx, ty) == AVAILABILITY.ROOM) {
/*  39 */         this.data = data;
/*  40 */         this.coo.set(tx, ty);
/*  41 */         this.ins = (ChamberInstance)this.blue.get(tx, ty);
/*     */         
/*  43 */         return this;
/*     */       } 
/*     */     } 
/*  46 */     return null;
/*     */   }
/*     */   
/*     */   void clear() {
/*  50 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private void save() {
/*  55 */     int old = (SETT.ROOMS()).data.get((COORDINATE)this.coo);
/*     */     
/*  57 */     if (old != this.data) {
/*  58 */       (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*     */     }
/*     */   }
/*     */   
/*     */   private int state() {
/*  63 */     return this.data & 0xF;
/*     */   }
/*     */   
/*     */   private void stateSet(int state) {
/*  67 */     this.data &= 0xFFFFFFF0;
/*  68 */     this.data |= state;
/*  69 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/*  74 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/*  84 */     return this.ins.blueprintI().employment().sound();
/*     */   }
/*     */   Work(ROOM_CHAMBER blue) {
/*  87 */     this.i = 0;
/*     */     
/*  89 */     this.bit = new RBIT.RBITImp();
/*     */     this.blue = blue;
/*     */   }
/*     */   public RBIT jobResourceBitToFetch() {
/*  93 */     this.i++;
/*  94 */     if ((this.i & 0x1) == 0 && !this.ins.fetching && this.ins.occupant() != null) {
/*  95 */       this.bit.clear();
/*  96 */       Induvidual in = this.ins.occupant().indu();
/*  97 */       for (StatsHome.StatFurniture f : STATS.HOME().getTmp(in)) {
/*  98 */         if (f.needed(this.ins.occupant().indu()) > 0 && this.ins.jobs.resourceReachable(f.resource(in))) {
/*  99 */           this.bit.or(f.resource(in));
/*     */         }
/*     */       } 
/* 102 */       return this.bit.isClear() ? null : (RBIT)this.bit;
/*     */     } 
/* 104 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/* 110 */     return (state() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/* 115 */     if (jobReservedIs(r)) {
/* 116 */       if (r != null)
/* 117 */         this.ins.fetching = false; 
/* 118 */       stateSet(0);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/* 124 */     return !(state() != 0 && state() != 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/* 129 */     if (!jobReserveCanBe())
/* 130 */       throw new RuntimeException(); 
/* 131 */     stateSet(1);
/* 132 */     if (r != null) {
/* 133 */       this.ins.fetching = true;
/*     */     }
/*     */   }
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/* 138 */     return 30.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE res, int ram) {
/* 143 */     if (!jobReservedIs(res))
/* 144 */       throw new RuntimeException(); 
/* 145 */     stateSet(0);
/*     */     
/* 147 */     if (res != null) {
/* 148 */       if (this.ins.occupant() != null) {
/* 149 */         Induvidual in = this.ins.occupant().indu();
/* 150 */         for (WearableResource rr : RACES.res().get(this.ins.occupant().indu().popCL(), res)) {
/* 151 */           int nn = rr.needed(in);
/* 152 */           int aa = CLAMP.i(ram, 0, nn);
/* 153 */           rr.inc(in, aa);
/* 154 */           ram -= aa;
/* 155 */           if (ram <= 0) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } 
/* 160 */       this.ins.fetching = false;
/*     */     } 
/*     */     
/* 163 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 168 */     return (this.ins.blueprintI().employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 173 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\chamber\Work.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */