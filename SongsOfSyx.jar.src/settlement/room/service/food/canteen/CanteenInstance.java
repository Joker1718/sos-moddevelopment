/*     */ package settlement.room.service.food.canteen;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
/*     */ import init.resources.ResGEat;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobIterator;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import settlement.room.service.module.ROOM_SERVICER;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.service.module.RoomServiceInstance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ final class CanteenInstance extends RoomInstance implements JOBMANAGER_HASER, ROOM_PRODUCER_INSTANCE, ROOM_SERVICER {
/*     */   private static final long serialVersionUID = -7063521835843676015L;
/*     */   boolean autoE = true;
/*     */   private long[] pdata;
/*  35 */   private int[] amounts = Alloc.ii(RESOURCES.EDI().all().size());
/*  36 */   private int[] amountIncoming = Alloc.ii(RESOURCES.EDI().all().size());
/*  37 */   private int amountTotal = 0;
/*     */   final int maxAmount;
/*  39 */   private int serviceReserved = 0;
/*     */   
/*     */   private final JobIterator jobs;
/*     */   
/*  43 */   private final RBIT.RBITImp fetchMask = (new RBIT.RBITImp()).or((RESOURCES.EDI()).mask);
/*  44 */   private final RBIT.RBITImp useMask = new RBIT.RBITImp();
/*     */   final RoomServiceInstance service;
/*  46 */   short tableX = -1;
/*  47 */   short tableY = -1;
/*     */   
/*     */   CanteenInstance(ROOM_CANTEEN p, TmpArea area, RoomInit init) {
/*  50 */     super(p, area, init);
/*     */ 
/*     */     
/*  53 */     this.jobs = new JobIterator(this)
/*     */       {
/*     */         private static final long serialVersionUID = 1L;
/*     */         
/*     */         protected SETT_JOB init(int tx, int ty) {
/*  58 */           return (CanteenInstance.this.blueprintI()).job.get(tx, ty);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  63 */     int m = 0;
/*  64 */     for (COORDINATE c : body()) {
/*  65 */       if (!is(c))
/*     */         continue; 
/*  67 */       if (this.tableX == -1 && is(c)) {
/*  68 */         this.tableX = (short)c.x();
/*  69 */         this.tableY = (short)c.y();
/*     */       } 
/*  71 */       if (is(c) && p.food.get(c.x(), c.y()) != null)
/*  72 */         m++; 
/*     */     } 
/*  74 */     this.pdata = (blueprintI()).industryFuel.makeData();
/*  75 */     this.service = new RoomServiceInstance(m * 3, (RoomService)(blueprintI()).service);
/*  76 */     this.maxAmount = 2 * m;
/*     */     
/*  78 */     employees().maxSet((int)Math.ceil((blueprintI()).constructor.workers.get(this) * 2.0D));
/*  79 */     employees().neededSet((int)Math.ceil((blueprintI()).constructor.workers.get(this)));
/*  80 */     activate();
/*     */     
/*  82 */     for (ResGEat e : RESOURCES.EDI().all()) {
/*  83 */       if (e.serve) {
/*  84 */         this.useMask.or(e.resource);
/*     */       }
/*     */     } 
/*     */     
/*  88 */     this.fetchMask.and((RBIT)this.useMask);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  93 */     this.pdata = industry().makeDataFix(this.pdata);
/*  94 */     if (this.amounts.length != RESOURCES.EDI().all().size()) {
/*  95 */       int[] ams = Alloc.ii(RESOURCES.EDI().all().size());
/*  96 */       int[] amsI = Alloc.ii(RESOURCES.EDI().all().size());
/*  97 */       this.amountTotal = 0;
/*  98 */       this.fetchMask.clear();
/*  99 */       this.fetchMask.or((RESOURCES.EDI()).mask);
/* 100 */       this.useMask.clear();
/* 101 */       for (int i = 0; i < ams.length; i++) {
/* 102 */         ams[i] = this.amounts[i % this.amounts.length];
/* 103 */         amsI[i] = this.amountIncoming[i % this.amounts.length];
/* 104 */         this.amountTotal += ams[i];
/*     */       } 
/* 106 */       this.amounts = ams;
/* 107 */       this.amountIncoming = amsI;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 113 */     super.render(r, shadowBatch, it);
/* 114 */     it.lit();
/* 115 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double ds, boolean day) {
/* 121 */     if (day)
/* 122 */       this.service.updateDay(); 
/* 123 */     (blueprintI()).industryFuel.updateRoom((ROOM_IDATA_INSTANCE)this);
/* 124 */     this.jobs.searchAgain();
/* 125 */     if (this.tableX == -1) {
/* 126 */       this.tableX = (short)body().x1();
/* 127 */       this.tableY = (short)body().y1();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int amount(ResG e) {
/* 134 */     return this.amounts[e.index()];
/*     */   }
/*     */   
/*     */   public int amountReserved(ResG e) {
/* 138 */     return this.amountIncoming[e.index()];
/*     */   }
/*     */   
/*     */   public int amountTotal() {
/* 142 */     return this.amountTotal;
/*     */   }
/*     */   
/*     */   public int serviceReserved() {
/* 146 */     return this.serviceReserved;
/*     */   }
/*     */   
/*     */   public RBIT fetchMask() {
/* 150 */     return (RBIT)this.fetchMask;
/*     */   }
/*     */   
/*     */   public boolean uses(ResG e) {
/* 154 */     return this.useMask.has(e.resource.bit);
/*     */   }
/*     */   
/*     */   public void usesToggle(ResG e) {
/* 158 */     this.useMask.toggle(e.resource);
/* 159 */     setMask(e);
/*     */   }
/*     */   
/*     */   void tally(ResG e, int dAmount, int amountReserved) {
/* 163 */     this.amounts[e.index()] = this.amounts[e.index()] + dAmount;
/* 164 */     this.amountIncoming[e.index()] = this.amountIncoming[e.index()] + amountReserved;
/* 165 */     this.amountTotal += dAmount;
/* 166 */     (blueprintI()).total += dAmount;
/* 167 */     (blueprintI()).amounts[e.index()] = (blueprintI()).amounts[e.index()] + dAmount;
/* 168 */     setMask(e);
/*     */   }
/*     */   
/*     */   void serviceTally(int dReserved) {
/* 172 */     this.serviceReserved += dReserved;
/*     */   }
/*     */   
/*     */   void consume(ResG e, int amount, int tx, int ty) {
/* 176 */     tally(e, -amount, 0);
/* 177 */     (blueprintI()).food.get(tx, ty).check();
/*     */   }
/*     */   
/*     */   private void setMask(ResG e) {
/* 181 */     if (this.amounts[e.index()] + this.amountIncoming[e.index()] < this.maxAmount) {
/* 182 */       this.fetchMask.or(e.resource);
/*     */     } else {
/*     */       
/* 185 */       this.fetchMask.clear(e.resource);
/*     */     } 
/*     */     
/* 188 */     this.fetchMask.and((RBIT)this.useMask);
/* 189 */     if (this.fetchMask.isClear()) {
/* 190 */       this.jobs.dontSearch();
/*     */     } else {
/* 192 */       this.jobs.searchAgainWithoutResources();
/*     */     } 
/* 194 */     this.jobs.resetResourceSearch();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 200 */     int amI = 0;
/* 201 */     for (COORDINATE c : body()) {
/* 202 */       if (is(c)) {
/* 203 */         int a = this.amounts[amI];
/* 204 */         if (a > 0)
/* 205 */           (SETT.THINGS()).resources.create(c, ((ResGEat)RESOURCES.EDI().all().get(amI)).resource, a); 
/* 206 */         amI++;
/* 207 */         if (amI == this.amounts.length) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */     } 
/* 212 */     for (ResG e : RESOURCES.EDI().all()) {
/* 213 */       tally(e, -this.amounts[amI], -this.amountIncoming[amI]);
/*     */     }
/* 215 */     for (COORDINATE c : body()) {
/* 216 */       if (is(c)) {
/* 217 */         (blueprintI()).food.dispose(c.x(), c.y());
/* 218 */         (blueprintI()).job.dispose(c.x(), c.y());
/*     */       } 
/*     */     } 
/* 221 */     this.service.dispose((RoomService)(blueprintI()).service);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ROOM_CANTEEN blueprintI() {
/* 227 */     return (ROOM_CANTEEN)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/* 232 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public TILE_STORAGE storage(int tx, int ty) {
/* 237 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void activateAction() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 254 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] productionData() {
/* 259 */     return this.pdata;
/*     */   }
/*     */ 
/*     */   
/*     */   public Industry industry() {
/* 264 */     return (Industry)blueprintI().industries().get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceInstance service() {
/* 269 */     return this.service;
/*     */   }
/*     */ 
/*     */   
/*     */   public double quality() {
/* 274 */     return ROOM_SERVICER.defQuality(this, 0.2D + 0.8D * (blueprintI()).constructor.tables.get(this));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int industryI() {
/* 280 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomState makeState(int rx, int ry, boolean broken) {
/* 285 */     return (RoomState)new State(this);
/*     */   }
/*     */   
/*     */   private static final class State
/*     */     extends RoomState.RoomStateInstance {
/* 290 */     private final RBIT.RBITImp useMask = new RBIT.RBITImp();
/*     */ 
/*     */     
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */     
/*     */     public State(CanteenInstance ins) {
/* 298 */       super(ins);
/* 299 */       this.useMask.clear((RBIT)ins.useMask);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void applyIns(RoomInstance ins) {
/* 304 */       if (ins instanceof CanteenInstance) {
/* 305 */         CanteenInstance i = (CanteenInstance)ins;
/* 306 */         i.useMask.clear((RBIT)this.useMask);
/* 307 */         for (ResG g : RESOURCES.EDI().all()) {
/* 308 */           i.setMask(g);
/*     */         }
/*     */       } 
/* 311 */       super.applyIns(ins);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\canteen\CanteenInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */