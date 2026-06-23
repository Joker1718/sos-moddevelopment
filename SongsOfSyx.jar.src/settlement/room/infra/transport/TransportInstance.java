/*     */ package settlement.room.infra.transport;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.infra.logistics.MoveJob;
/*     */ import settlement.room.infra.logistics.MoveOrderPull;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.job.ROOM_RADIUS;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import snake2d.LOG;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class TransportInstance
/*     */   extends RoomInstance
/*     */   implements JOBMANAGER_HASER, ROOM_RADIUS.ROOM_RADIUS_INSTANCE, MoveJob.ROOM_MOVEJOBBER, MoveJob.ROOM_MOVE_DEST, MoveOrderPull.MoveOrderPullInstance
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   static final int ORDERS = 4;
/*     */   private final Jobs jobs;
/*     */   boolean auto;
/*     */   private boolean fetching = true;
/*     */   boolean prio = false;
/*  49 */   byte coolFetch = 0;
/*     */   
/*     */   final Cart data;
/*     */   
/*  53 */   final MoveOrderPull[] pullOrders = new MoveOrderPull[4];
/*  54 */   private byte orderIP = 0;
/*     */   private short lastSourceX;
/*     */   private short lastSourceY;
/*  57 */   byte radius = 20;
/*     */   
/*     */   private final short sx;
/*     */   private final short sy;
/*     */   float fetchTime;
/*     */   float distance;
/*     */   float stationWorkers;
/*     */   boolean stationProblem = false;
/*     */   
/*     */   TransportInstance(ROOM_TRANSPORT p, TmpArea area, RoomInit init) {
/*  67 */     super(p, area, init);
/*     */     
/*  69 */     this.data = new Cart();
/*  70 */     int sx = -1;
/*  71 */     int sy = -1;
/*  72 */     for (COORDINATE c : body()) {
/*  73 */       if (is(c) && (SETT.ROOMS()).fData.tile.get(c) == p.constructor.an) {
/*  74 */         sx = c.x();
/*  75 */         sy = c.y();
/*     */       } 
/*     */     } 
/*  78 */     if (sx == -1)
/*  79 */       throw new RuntimeException(); 
/*  80 */     this.sx = (short)sx;
/*  81 */     this.sy = (short)sy;
/*  82 */     this.jobs = new Jobs(this);
/*     */     
/*  84 */     employees().maxSet(this.jobs.size());
/*  85 */     employees().neededSet(this.jobs.size());
/*     */     
/*  87 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  93 */     this.data.loadFix();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  98 */     it.lit();
/*  99 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 104 */     this.data.resourceSet(null, this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double ds, boolean day) {
/* 110 */     this.stationProblem = false;
/* 111 */     go();
/*     */     
/* 113 */     if (day) {
/* 114 */       double fetch = employees().fetchBonus();
/* 115 */       employees().fetchBonusConsume((int)fetch);
/* 116 */       fetch *= TIME.secondsPerDayI();
/* 117 */       fetch = CLAMP.d(fetch / employees().employed(), 0.0D, 1.0D);
/* 118 */       if (this.fetchTime == 0.0F) {
/* 119 */         this.fetchTime = (float)fetch;
/*     */       } else {
/* 121 */         this.fetchTime = (float)CLAMP.d(4.0D * this.fetchTime / 5.0D + fetch / 5.0D, 0.0D, 1.0D);
/*     */       } 
/*     */     } 
/*     */     
/* 125 */     if (this.coolFetch > 0) {
/* 126 */       this.coolFetch = (byte)(this.coolFetch - 1);
/*     */     }
/* 128 */     if (day)
/* 129 */       this.lastSourceX = -1;  byte b; int i;
/*     */     MoveOrderPull[] arrayOfMoveOrderPull;
/* 131 */     for (i = (arrayOfMoveOrderPull = this.pullOrders).length, b = 0; b < i; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/* 132 */       if (o != null && o.cooldown > 0)
/* 133 */         o.cooldown = (byte)(o.cooldown - 1); 
/*     */       b++; }
/*     */     
/* 136 */     this.jobs.searchAgain();
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
/*     */   public ROOM_TRANSPORT blueprintI() {
/* 152 */     return (ROOM_TRANSPORT)blueprint();
/*     */   }
/*     */   
/*     */   public void reportMoved(int dist) {
/* 156 */     if (this.distance == 0.0F) {
/* 157 */       this.distance = dist;
/*     */     } else {
/* 159 */       this.distance = (float)((this.distance * 4.0F / 5.0F) + dist / 5.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 165 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */   
/*     */   void go() {
/* 169 */     if (!this.data.canGo()) {
/*     */       return;
/*     */     }
/* 172 */     if (this.stationProblem) {
/*     */       return;
/*     */     }
/*     */     
/* 176 */     COORDINATE c = (SETT.ROOMS()).STATION.reserve(resource());
/*     */     
/* 178 */     if (c == null) {
/* 179 */       this.stationProblem = true;
/*     */       return;
/*     */     } 
/* 182 */     byte ran = (byte)SETT.tileRan(this.sx, this.sy);
/* 183 */     DIR d = (DIR)DIR.ORTHO.get(((FurnisherItem)(SETT.ROOMS()).fData.item.get(this.sx, this.sy)).rotation);
/* 184 */     if ((SETT.HALFENTS()).transports.loader(this.sx + d.x(), this.sy + d.y(), ran, resource(), 400, d, c)) {
/* 185 */       double w = (SETT.ROOMS()).STATION.workersPerload(c.x(), c.y());
/* 186 */       if (this.stationWorkers == 0.0F) {
/* 187 */         this.stationWorkers = (float)w;
/*     */       } else {
/* 189 */         this.stationWorkers = (float)((this.stationWorkers * 4.0F / 5.0F) + w / 5.0D);
/*     */       } 
/* 191 */       this.data.go();
/*     */     }
/*     */     else {
/*     */       
/* 195 */       this.stationProblem = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void finishDeliveryJob(int am) {
/* 202 */     this.data.deliver(am);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean searching() {
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public TILE_STORAGE storage(int tx, int ty) {
/* 212 */     return (blueprintI()).job.storage(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Jobs
/*     */     extends JobPositions<TransportInstance>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     public Jobs(TransportInstance ins) {
/* 223 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 228 */       return ((((TransportInstance)this.ins).blueprintI()).job.job(tx, ty) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 233 */       ((TransportInstance)this.ins).go();
/* 234 */       return (((TransportInstance)this.ins).blueprintI()).job.job(tx, ty);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TILE_STORAGE destCrate(RBIT okMask, int minAm, int ox, int oy) {
/* 242 */     if (!destSpaceMask().has(okMask))
/* 243 */       return null; 
/* 244 */     TILE_STORAGE t = (blueprintI()).job.storage(ox, oy);
/*     */     
/* 246 */     if (t != null && t.storageReservable() == (blueprintI()).job.bamountr.max()) {
/* 247 */       return t;
/*     */     }
/*     */     
/* 250 */     int best = -1;
/*     */     
/* 252 */     for (int i = 0; i < this.jobs.size(); i++) {
/*     */       
/* 254 */       t = (blueprintI()).job.storage(this.jobs.get(i).x(), this.jobs.get(i).y());
/*     */       
/* 256 */       if (t != null && t.storageReservable() > 0) {
/* 257 */         if (t.storageReservable() == (blueprintI()).job.bamountr.max()) {
/* 258 */           return t;
/*     */         }
/* 260 */         best = i;
/*     */       } 
/*     */     } 
/*     */     
/* 264 */     if (best != -1) {
/* 265 */       return (blueprintI()).job.storage(this.jobs.get(best).x(), this.jobs.get(best).y());
/*     */     }
/*     */ 
/*     */     
/* 269 */     LOG.ln("Weirdness!");
/* 270 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RBIT destSpaceMask() {
/* 276 */     if (this.data.resource() == null) {
/* 277 */       return RBIT.NONE;
/*     */     }
/* 279 */     return (this.data.resource()).bit;
/*     */   }
/*     */ 
/*     */   
/*     */   public double storedD(RESOURCE res) {
/* 284 */     if (this.data.resource() == res)
/* 285 */       return this.data.stored() / 400.0D; 
/* 286 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveCapacity() {
/* 291 */     if (this.data.resource() == null)
/* 292 */       return RBIT.NONE; 
/* 293 */     return (this.data.resource()).bit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MoveJob moveJob(Humanoid skill) {
/* 300 */     if (this.coolFetch <= 0 && this.data.unloadedSpots() > 0) {
/* 301 */       int am = (SETT.ROOMS()).STOCKPILE.carryCap(skill);
/*     */       
/* 303 */       if (this.fetching || this.prio) {
/*     */ 
/*     */         
/* 306 */         MoveJob j = MoveJob.fetch(this, this, am, radius(), this.lastSourceX, this.lastSourceY, this.fetching ? destSpaceMask() : RBIT.NONE, this.prio ? destSpaceMask() : RBIT.NONE);
/* 307 */         if (j != null) {
/* 308 */           this.lastSourceX = (short)j.source.x();
/* 309 */           this.lastSourceY = (short)j.source.y();
/* 310 */           this.coolFetch = -1;
/* 311 */           return j;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 316 */       for (int ooi = 0; ooi < this.pullOrders.length; ooi++) {
/* 317 */         this.orderIP = (byte)(this.orderIP + 1);
/* 318 */         if (this.orderIP >= this.pullOrders.length)
/* 319 */           this.orderIP = 0; 
/* 320 */         MoveOrderPull p = this.pullOrders[this.orderIP];
/* 321 */         if (p != null && p.cooldown <= 0) {
/* 322 */           MoveJob j = p.job(this, Math.min(am, 7), am);
/*     */           
/* 324 */           if (j != null) {
/* 325 */             p.cooldown = -1;
/* 326 */             return j;
/*     */           } 
/* 328 */           p.cooldown = 4;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 333 */       this.coolFetch = 4;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 338 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int moveMinAmount() {
/* 343 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public MoveOrderPull[] moveOrdersPull() {
/* 348 */     return this.pullOrders;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveOrderPullAccepted() {
/* 353 */     return moveCapacity();
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveOrderPullAvailable() {
/* 358 */     return (this.data.unloadedSpots() > 0) ? moveCapacity() : RBIT.NONE;
/*     */   }
/*     */   
/*     */   public boolean fetching() {
/* 362 */     return this.fetching;
/*     */   }
/*     */   
/*     */   public void fetchingSet(boolean f) {
/* 366 */     this.fetching = f;
/* 367 */     this.coolFetch = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int moveMaxRadius() {
/* 372 */     return 400;
/*     */   }
/*     */ 
/*     */   
/*     */   public int radius() {
/* 377 */     return (this.radius + 5) * 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte radiusRaw() {
/* 382 */     return this.radius;
/*     */   }
/*     */ 
/*     */   
/*     */   public void radiusRawSet(byte r) {
/* 387 */     this.radius = r;
/*     */   }
/*     */   
/*     */   public RESOURCE resource() {
/* 391 */     return this.data.resource();
/*     */   }
/*     */   
/*     */   public double efficiency() {
/* 395 */     double d = CLAMP.d(employees().employed() / this.jobs.size(), 0.0D, 1.0D);
/* 396 */     d *= d;
/* 397 */     d += 0.02D;
/* 398 */     return d * (1.0D - getDegrade());
/*     */   }
/*     */ 
/*     */   
/*     */   public void copyFrom(MoveOrderPull.MoveOrderPullInstance same) {
/* 403 */     TransportInstance ins = (TransportInstance)same;
/* 404 */     this.data.resourceSet(ins.resource(), this);
/* 405 */     fetchingSet(ins.fetching());
/* 406 */     this.prio = ins.prio;
/* 407 */     this.coolFetch = 0;
/* 408 */     this.radius = ins.radius;
/* 409 */     this.auto = ins.auto;
/* 410 */     employees().neededSet(ins.employees().target());
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomState makeState(int tx, int ty, boolean broken) {
/* 415 */     return (RoomState)new State(this, broken);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class State
/*     */     extends RoomState.RoomStateInstance
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private boolean fetching;
/*     */     
/*     */     private boolean prio;
/*     */     private final boolean broken;
/* 428 */     int ri = -1;
/*     */     
/*     */     private MoveOrderPull[] orders;
/*     */     
/*     */     public State(TransportInstance ins, boolean broken) {
/* 433 */       super(ins);
/* 434 */       this.broken = broken;
/* 435 */       this.fetching = ins.fetching;
/* 436 */       this.prio = ins.prio;
/* 437 */       if (broken) {
/* 438 */         this.orders = ins.pullOrders;
/*     */       }
/*     */       
/* 441 */       this.ri = (ins.resource() == null) ? -1 : ins.resource().index();
/*     */     }
/*     */ 
/*     */     
/*     */     public void applyIns(RoomInstance ins) {
/* 446 */       if (ins instanceof TransportInstance) {
/* 447 */         TransportInstance s = (TransportInstance)ins;
/* 448 */         if (this.ri >= 0) {
/* 449 */           s.data.resourceSet((RESOURCE)RESOURCES.ALL().getC(this.ri), s);
/*     */         }
/* 451 */         if (this.broken) {
/* 452 */           for (int i = 0; i < this.orders.length; i++) {
/* 453 */             if (this.orders[i] != null) {
/* 454 */               MoveOrderPull p = new MoveOrderPull(this.orders[i].destCoo(), (RBIT)(this.orders[i]).resbits);
/* 455 */               s.pullOrders[i] = p;
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/* 461 */         s.fetchingSet(this.fetching);
/* 462 */         if (this.prio != s.prio)
/* 463 */           this.prio = s.prio; 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\transport\TransportInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */