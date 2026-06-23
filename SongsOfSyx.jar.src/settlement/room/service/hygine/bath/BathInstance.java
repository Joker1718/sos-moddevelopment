/*     */ package settlement.room.service.hygine.bath;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ public final class BathInstance
/*     */   extends RoomInstance implements JOBMANAGER_HASER, ROOM_SERVICER, ROOM_PRODUCER_INSTANCE {
/*     */   private static final long serialVersionUID = 1L;
/*     */   final Jobs jobs;
/*  33 */   double heat = 0.0D;
/*     */   
/*     */   final RoomServiceInstance service;
/*     */   
/*     */   private final ArrayCooShort benches;
/*     */   
/*     */   private int benchI;
/*     */   private long[] pData;
/*     */   boolean auto = true;
/*     */   float water;
/*  43 */   private short waterTiles = 0;
/*  44 */   private short waterCount = 0;
/*     */   
/*     */   protected BathInstance(ROOM_BATH blue, TmpArea area, RoomInit init) {
/*  47 */     super(blue, area, init);
/*  48 */     int s = 0;
/*  49 */     int b = 0;
/*     */     
/*  51 */     for (COORDINATE c : body()) {
/*  52 */       if (!is(c))
/*     */         continue; 
/*  54 */       if ((SETT.ROOMS()).fData.tile.is(c)) {
/*  55 */         int d = ((FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(c)).data();
/*  56 */         (SETT.ROOMS()).data.set((ROOMA)this, c, d);
/*  57 */         if ((d & 0xE000) == 8192)
/*  58 */           b++; 
/*     */       } 
/*  60 */       if ((SETT.ENV()).map.WATER_SWEET.get(c) > 0.0D) {
/*  61 */         this.water++;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  66 */     this.water = (float)(this.water * 1.5D);
/*  67 */     this.water /= area();
/*  68 */     this.water = (float)CLAMP.d(this.water, 0.0D, 1.0D);
/*     */     
/*  70 */     this.jobs = new Jobs(this);
/*     */ 
/*     */     
/*  73 */     this.benches = new ArrayCooShort(b);
/*     */     
/*  75 */     for (COORDINATE c : body()) {
/*  76 */       if (!is(c))
/*     */         continue; 
/*  78 */       int d = (SETT.ROOMS()).data.get(c);
/*  79 */       if ((d & 0xE000) == 49152)
/*  80 */         s += Bath.initService(c.x(), c.y(), this); 
/*  81 */       if ((d & 0xE000) == 8192) {
/*  82 */         this.benches.set(--b).set(c);
/*     */       }
/*     */     } 
/*  85 */     this.service = new RoomServiceInstance(s, (RoomService)(blueprintI()).data);
/*     */ 
/*     */     
/*  88 */     employees().maxSet(this.jobs.size());
/*  89 */     employees().neededSet((int)Math.ceil(this.jobs.size() / 1.5D));
/*  90 */     this.pData = blue.consumtion.makeData();
/*  91 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  96 */     this.pData = industry().makeDataFix(this.pData);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 101 */     it.lit();
/* 102 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/* 107 */     if (day)
/* 108 */       this.service.updateDay(); 
/* 109 */     (blueprintI()).consumtion.updateRoom((ROOM_IDATA_INSTANCE)this);
/* 110 */     this.heat -= updateInterval * coalPerDay() * TIME.secondsPerDayI();
/* 111 */     if (this.heat < 0.0D) {
/* 112 */       this.heat = 0.0D;
/*     */     }
/* 114 */     this.jobs.searchAgain();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {
/* 119 */     this.waterCount = (short)(this.waterCount + 1);
/* 120 */     this.waterTiles = (short)(this.waterTiles + (((SETT.ENV()).map.WATER_SWEET.get(tx, ty) > 0.0D) ? 1 : 0));
/*     */     
/* 122 */     if (this.waterCount >= area()) {
/* 123 */       this.water = (float)CLAMP.d(1.5D * this.waterTiles / area(), 0.0D, 1.0D);
/* 124 */       this.waterCount = 0;
/* 125 */       this.waterTiles = 0;
/*     */     } 
/*     */     
/* 128 */     super.updateTileDay(tx, ty);
/*     */   }
/*     */   
/*     */   private double coalPerDay() {
/* 132 */     return this.service.total() * ((IndustryResource)((Industry)blueprintI().industries().get(0)).ins().get(0)).rate;
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 137 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */   
/*     */   public COORDINATE getBench() {
/* 141 */     if (this.benchI == this.benches.size())
/* 142 */       return null; 
/* 143 */     return (COORDINATE)this.benches.set(this.benchI++);
/*     */   }
/*     */   
/*     */   public void returnBench(int tx, int ty) {
/* 147 */     if (!is(tx, ty))
/*     */       return; 
/* 149 */     int data = (SETT.ROOMS()).data.get(tx, ty);
/* 150 */     if ((data & 0xE000) != 8192)
/*     */       return; 
/* 152 */     if (this.benchI == 0)
/*     */       return; 
/* 154 */     this.benchI--;
/* 155 */     this.benches.set(this.benchI).set(tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 161 */     for (COORDINATE c : body()) {
/* 162 */       Bath b = blueprintI().bath(c.x(), c.y());
/* 163 */       if (b != null)
/* 164 */         b.dispose(); 
/*     */     } 
/* 166 */     this.service.dispose((RoomService)(blueprintI()).data);
/*     */   }
/*     */   
/*     */   public double getHeat() {
/* 170 */     double d = this.heat / this.service.total();
/* 171 */     if (d > 1.0D)
/* 172 */       d = 1.0D; 
/* 173 */     return d;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_BATH blueprintI() {
/* 178 */     return (ROOM_BATH)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/* 183 */     return this.service;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void activateAction() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double quality() {
/* 202 */     double h = 0.5D + 0.5D * getHeat();
/* 203 */     double w = 1.0D;
/* 204 */     double b = 0.5D + 0.5D * (blueprintI()).constructor.relaxation.get(this);
/* 205 */     return ROOM_SERVICER.defQuality(this, b * h * w);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/* 211 */     return this.pData;
/*     */   }
/*     */ 
/*     */   
/*     */   public Industry industry() {
/* 216 */     return (Industry)blueprintI().industries().get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 222 */     return 0;
/*     */   }
/*     */   
/*     */   static class Jobs
/*     */     extends JobPositions<BathInstance> {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public Jobs(BathInstance ins) {
/* 230 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 235 */       SETT_JOB j = Crank.init(tx, ty, ((BathInstance)this.ins).blueprintI());
/* 236 */       if (j == null)
/* 237 */         return Oven.init(tx, ty, ((BathInstance)this.ins).blueprintI()); 
/* 238 */       return j;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 243 */       return !(Crank.init(tx, ty, ((BathInstance)this.ins).blueprintI()) == null && Oven.init(tx, ty, ((BathInstance)this.ins).blueprintI()) == null);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\bath\BathInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */