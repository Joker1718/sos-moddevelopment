/*     */ package settlement.room.service.food.canteen;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ class SWork implements SETT_JOB {
/*     */   public static final int I = 1;
/*     */   private CanteenInstance ins;
/*  23 */   private final Coo coo = new Coo();
/*     */   private final ROOM_CANTEEN b;
/*  25 */   private final int wt = 60;
/*     */   
/*  27 */   private final RoomBits bReserved = new RoomBits((COORDINATE)this.coo, new Bits(1));
/*  28 */   private final RoomBits bFreeFetc = new RoomBits((COORDINATE)this.coo, new Bits(2));
/*  29 */   private final RoomBits bResource = new RoomBits((COORDINATE)this.coo, new Bits(4080));
/*  30 */   private final RoomBits bResAmoun = new RoomBits((COORDINATE)this.coo, new Bits(61440));
/*  31 */   private final RoomBits bCoalAmou = new RoomBits((COORDINATE)this.coo, new Bits(983040));
/*     */   
/*     */   SWork(ROOM_CANTEEN b) {
/*  34 */     this.b = b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SWork get(int tx, int ty) {
/*  41 */     if (this.b.is(tx, ty) && (SETT.ROOMS()).fData.tileData.get(tx, ty) == 1) {
/*  42 */       this.ins = (CanteenInstance)this.b.getter.get(tx, ty);
/*  43 */       this.coo.set(tx, ty);
/*  44 */       return this;
/*     */     } 
/*  46 */     return null;
/*     */   }
/*     */   
/*     */   public void dispose(int x, int y) {
/*  50 */     if (get(x, y) != null) {
/*  51 */       if (res() != null)
/*  52 */         (SETT.THINGS()).resources.create((COORDINATE)this.coo, (res()).resource, this.bResAmoun.get()); 
/*  53 */       if (this.bCoalAmou.get() > 0)
/*  54 */         (SETT.THINGS()).resources.create((COORDINATE)this.coo, ((IndustryResource)this.b.industryFuel.ins().get(0)).resource, this.bCoalAmou.get()); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public ResG res() {
/*  59 */     if (this.bResAmoun.get() > 0)
/*  60 */       return (ResG)RESOURCES.EDI().all().getC(this.bResource.get()); 
/*  61 */     return null;
/*     */   }
/*     */   
/*     */   public int resAm() {
/*  65 */     return this.bResAmoun.get();
/*     */   }
/*     */   
/*     */   public boolean hasCoal() {
/*  69 */     return (this.bCoalAmou.get() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/*  74 */     this.bReserved.set((ROOMA)this.ins, 1);
/*  75 */     if (r != null) {
/*  76 */       ResG g = RESOURCES.EDI().get(r);
/*  77 */       if (g != null) {
/*  78 */         this.ins.tally(g, 0, jobResourcesNeeded(null));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/*  85 */     return (this.bReserved.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/*  90 */     this.bReserved.set((ROOMA)this.ins, 0);
/*  91 */     if (r != null) {
/*  92 */       ResG g = RESOURCES.EDI().get(r);
/*  93 */       if (g != null) {
/*  94 */         this.ins.tally(g, 0, -jobResourcesNeeded(null));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/* 101 */     if (this.bReserved.get() == 1)
/* 102 */       return false; 
/* 103 */     if (this.bCoalAmou.get() == 0)
/* 104 */       return true; 
/* 105 */     if (res() == null)
/* 106 */       return !this.ins.fetchMask().isClear(); 
/* 107 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/* 113 */     if (this.bCoalAmou.get() == 0)
/* 114 */       return ((IndustryResource)this.b.industryFuel.ins().get(0)).resource.bit; 
/* 115 */     if (res() == null)
/* 116 */       return this.ins.fetchMask(); 
/* 117 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int jobResourcesNeeded(Humanoid skill) {
/* 122 */     return 7;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/* 128 */     if (this.bFreeFetc.get() == 1)
/* 129 */       return 0.0D; 
/* 130 */     return 60.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/* 141 */     jobReserveCancel(r);
/* 142 */     if (r == ((IndustryResource)this.b.industryFuel.ins().get(0)).resource) {
/* 143 */       ram = (SETT.ROOMS()).resourceUnderflow.deposit(r, ram);
/* 144 */       this.bCoalAmou.inc((ROOMA)this.ins, ram);
/*     */ 
/*     */     
/*     */     }
/* 148 */     else if (r != null) {
/* 149 */       ResG g = RESOURCES.EDI().get(r);
/* 150 */       if (g == null)
/* 151 */         return null; 
/* 152 */       this.bResource.set((ROOMA)this.ins, g.index());
/* 153 */       ram = (SETT.ROOMS()).resourceUnderflow.deposit(r, ram);
/* 154 */       this.bResAmoun.inc((ROOMA)this.ins, ram);
/* 155 */       this.ins.tally(g, 0, this.bResAmoun.get());
/*     */     } else {
/*     */       
/* 158 */       ResG g = res();
/* 159 */       if (g == null)
/* 160 */         return null; 
/* 161 */       this.ins.tally(g, 1, -this.bResAmoun.get());
/* 162 */       this.bResAmoun.inc((ROOMA)this.ins, -1);
/* 163 */       this.ins.tally(g, 0, this.bResAmoun.get());
/* 164 */       this.bFreeFetc.set((ROOMA)this.ins, 0);
/*     */       
/* 166 */       int am = ((IndustryResource)this.ins.industry().ins().get(0)).work(skill, (ROOM_IDATA_INSTANCE)this.ins, 60.0D);
/* 167 */       am = (SETT.ROOMS()).resourceUnderflow.withdraw(((IndustryResource)this.ins.industry().ins().get(0)).resource, am, this.bCoalAmou.get());
/* 168 */       this.bCoalAmou.inc((ROOMA)this.ins, -am);
/*     */       
/* 170 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 171 */         DIR d = (DIR)DIR.ORTHO.get(di);
/* 172 */         if (this.b.food.get(this.coo.x() + d.x(), this.coo.y() + d.y()) != null) {
/* 173 */           this.b.food.check();
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 178 */     if (this.bFreeFetc.get() == 0 && this.ins.employees().fetchBonus() >= 60) {
/* 179 */       this.bFreeFetc.set((ROOMA)this.ins, 1);
/* 180 */       this.ins.employees().fetchBonusConsume(60);
/*     */     } 
/*     */     
/* 183 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 188 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 193 */     return (this.b.employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 198 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 203 */     return this.b.employment().sound();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\canteen\SWork.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */