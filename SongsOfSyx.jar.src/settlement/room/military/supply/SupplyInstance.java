/*     */ package settlement.room.military.supply;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.infra.logistics.MoveJob;
/*     */ import settlement.room.infra.logistics.MoveOrderPull;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.job.ROOM_RADIUS;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import world.army.AD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SupplyInstance
/*     */   extends RoomInstance
/*     */   implements JOBMANAGER_HASER, ROOM_RADIUS.ROOM_RADIUS_INSTANCE, MoveJob.ROOM_MOVE_DEST, MoveJob.ROOM_MOVEJOBBER, MoveOrderPull.MoveOrderPullInstance
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final int ORDERS = 2;
/*  38 */   byte coolFetch = 0;
/*  39 */   final MoveOrderPull[] orders = new MoveOrderPull[2]; boolean fetch = true;
/*     */   boolean auto = true;
/*     */   short[] tdata;
/*     */   private short ox;
/*     */   private short oy;
/*  44 */   private byte orderI = 0;
/*  45 */   private final RBIT.RBITImp allowed = new RBIT.RBITImp();
/*     */   final JobPositions<SupplyInstance> jobs;
/*     */   byte liveCount;
/*     */   byte goCount;
/*     */   private boolean prio = true;
/*     */   
/*     */   SupplyInstance(ROOM_SUPPLY blueprint, TmpArea area, RoomInit init) {
/*  52 */     super(blueprint, area, init);
/*  53 */     this.jobs = new Jobs(this);
/*  54 */     int w = (int)blueprint.constructor.workers.get(this);
/*  55 */     employees().maxSet(w * 4);
/*  56 */     employees().neededSet(w);
/*  57 */     blueprint.tally.init(this);
/*  58 */     this.allowed.setAll();
/*  59 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void reset() {
/*  65 */     this.coolFetch = 0; byte b; int i; MoveOrderPull[] arrayOfMoveOrderPull;
/*  66 */     for (i = (arrayOfMoveOrderPull = this.orders).length, b = 0; b < i; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/*  67 */       if (o != null)
/*  68 */         o.cooldown = 0;  b++; }
/*     */     
/*  70 */     verifyCrates();
/*     */   }
/*     */   
/*     */   private void verifyCrates() {
/*  74 */     for (int i = 0; i < this.jobs.size(); i++) {
/*  75 */       int ox = this.jobs.get(i).x();
/*  76 */       int oy = this.jobs.get(i).y();
/*  77 */       Crate cr = (blueprintI()).crate.get(ox, oy);
/*  78 */       if (cr.storage() != null && cr.realResource() != null && !this.allowed.has(cr.storage().resource())) {
/*  79 */         cr.clear();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void activateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   void allowedToggle(RESOURCE res) {
/*     */     byte b;
/*     */     int i;
/*     */     MoveOrderPull[] arrayOfMoveOrderPull;
/*  98 */     for (i = (arrayOfMoveOrderPull = this.orders).length, b = 0; b < i; ) { MoveOrderPull p = arrayOfMoveOrderPull[b];
/*  99 */       if (p != null)
/* 100 */         p.resbits.set(res, !this.allowed.has(res));  b++; }
/*     */     
/* 102 */     this.allowed.toggle(res);
/*     */   }
/*     */   
/*     */   public RBIT allowed() {
/* 106 */     return (RBIT)this.allowed;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/* 112 */     if (!active() || employees().employed() <= 0) {
/* 113 */       for (int j = 0; j < this.jobs.size(); j++) {
/* 114 */         int ox = this.jobs.get(j).x();
/* 115 */         int oy = this.jobs.get(j).y();
/* 116 */         Crate cr = (blueprintI()).crate.get(ox, oy);
/* 117 */         if (cr.storage() != null && cr.realResource() != null) {
/* 118 */           cr.clear();
/*     */         }
/*     */       } 
/*     */     }
/* 122 */     this.jobs.searchAgain();
/* 123 */     if (this.coolFetch > 0)
/* 124 */       this.coolFetch = (byte)(this.coolFetch - 1);  byte b; int i;
/*     */     MoveOrderPull[] arrayOfMoveOrderPull;
/* 126 */     for (i = (arrayOfMoveOrderPull = this.orders).length, b = 0; b < i; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/* 127 */       if (o != null && o.cooldown > 0)
/* 128 */         o.cooldown = (byte)(o.cooldown - 1); 
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   protected void dispose() {
/* 134 */     for (COORDINATE c : body()) {
/* 135 */       if (is(c) && (blueprintI()).crate.get(c.x(), c.y()) != null) {
/* 136 */         (blueprintI()).crate.dispose();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_SUPPLY blueprintI() {
/* 143 */     return (SETT.ROOMS()).SUPPLY;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean destroyTileCan(int tx, int ty) {
/* 148 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_DEGRADER degrader(int tx, int ty) {
/* 153 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public MoveOrderPull[] moveOrdersPull() {
/* 158 */     return this.orders;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveCapacity() {
/* 163 */     return (RBIT)this.allowed;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveOrderPullAvailable() {
/* 168 */     return (blueprintI()).tally.fetchBit(this, (RBIT)this.allowed);
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveOrderPullAccepted() {
/* 173 */     return moveCapacity();
/*     */   }
/*     */ 
/*     */   
/*     */   public int moveMinAmount() {
/* 178 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int moveMaxRadius() {
/* 183 */     return 300;
/*     */   }
/*     */   
/*     */   public void prioritizeToggle() {
/* 187 */     this.prio = !this.prio;
/* 188 */     reset();
/*     */   }
/*     */   
/*     */   public boolean prioritizing() {
/* 192 */     return this.prio;
/*     */   }
/*     */   
/*     */   public void fetchingToggle() {
/* 196 */     this.fetch = !this.fetch;
/* 197 */     reset();
/*     */   }
/*     */   
/*     */   public boolean fetching() {
/* 201 */     return this.fetch;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MoveJob moveJob(Humanoid skill) {
/* 207 */     RBIT bb = (blueprintI()).tally.fetchBit(this, (RBIT)this.allowed);
/* 208 */     if (bb.isClear()) {
/* 209 */       return null;
/*     */     }
/* 211 */     int am = (SETT.ROOMS()).STOCKPILE.carryCap(skill);
/*     */     
/* 213 */     if ((this.fetch || this.prio) && this.coolFetch <= 0) {
/*     */       
/* 215 */       MoveJob j = MoveJob.fetch(this, this, am, radius(), this.ox, this.oy, this.fetch ? bb : RBIT.NONE, this.prio ? bb : RBIT.NONE);
/*     */       
/* 217 */       if (j != null) {
/* 218 */         this.ox = (short)j.source.x();
/* 219 */         this.oy = (short)j.source.y();
/* 220 */         return j;
/*     */       } 
/*     */       
/* 223 */       this.coolFetch = 4;
/*     */     } 
/*     */     
/* 226 */     for (int ooi = 0; ooi < this.orders.length; ooi++) {
/* 227 */       this.orderI = (byte)(this.orderI + 1);
/* 228 */       if (this.orderI >= this.orders.length)
/* 229 */         this.orderI = 0; 
/* 230 */       MoveOrderPull p = this.orders[this.orderI];
/* 231 */       if (p != null && p.cooldown <= 0) {
/* 232 */         MoveJob j = p.job(this, Math.min(am, 1), am);
/*     */         
/* 234 */         if (j != null) {
/* 235 */           p.cooldown = -1;
/* 236 */           return j;
/*     */         } 
/* 238 */         p.cooldown = 4;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 243 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TILE_STORAGE destCrate(RBIT okMask, int minAm, int ox, int oy) {
/* 249 */     RBIT bb = (blueprintI()).tally.fetchBit(this, (RBIT)this.allowed);
/* 250 */     if (bb.isClear()) {
/* 251 */       return null;
/*     */     }
/* 253 */     if (is(ox, oy)) {
/* 254 */       Crate crate = (blueprintI()).crate.get(ox, oy);
/* 255 */       TILE_STORAGE s = crate.get(ox, oy).storage();
/* 256 */       if (s != null && crate.realResource() != null && okMask.has(s.resource()) && s.storageReservable() >= minAm) {
/* 257 */         return s;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 263 */     int eX = -1;
/* 264 */     int eY = -1;
/*     */     
/* 266 */     for (int i = 0; i < this.jobs.size(); i++) {
/* 267 */       ox = this.jobs.get(i).x();
/* 268 */       oy = this.jobs.get(i).y();
/* 269 */       Crate crate = (blueprintI()).crate.get(ox, oy);
/* 270 */       TILE_STORAGE s = crate.get(ox, oy).storage();
/* 271 */       if (s != null) {
/* 272 */         if (crate.realResource() == null) {
/* 273 */           if (eX == -1) {
/* 274 */             eX = ox;
/* 275 */             eY = oy;
/*     */           }
/*     */         
/* 278 */         } else if (okMask.has(s.resource()) && s.storageReservable() >= minAm) {
/* 279 */           return s;
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 285 */     if (eX == -1) {
/* 286 */       LOG.ln("Weird " + mX() + " " + mY());
/* 287 */       okMask.debug();
/* 288 */       reset();
/* 289 */       return null;
/*     */     } 
/*     */     
/* 292 */     Crate cr = (blueprintI()).crate.get(eX, eY);
/* 293 */     cr.clear();
/* 294 */     cr.resourceSet((blueprintI()).tally.getNewCrate(GAME.updateI(), okMask));
/* 295 */     cr = (blueprintI()).crate.get(eX, eY);
/* 296 */     return cr.storage();
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT destSpaceMask() {
/* 301 */     return moveOrderPullAvailable();
/*     */   }
/*     */ 
/*     */   
/*     */   public double storedD(RESOURCE res) {
/* 306 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int radius() {
/* 313 */     return 200;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte radiusRaw() {
/* 318 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void radiusRawSet(byte r) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean searching() {
/* 328 */     if (employees().employed() > 0) {
/* 329 */       if (this.coolFetch <= 0)
/* 330 */         return true;  byte b; int i; MoveOrderPull[] arrayOfMoveOrderPull;
/* 331 */       for (i = (arrayOfMoveOrderPull = this.orders).length, b = 0; b < i; ) { MoveOrderPull p = arrayOfMoveOrderPull[b];
/* 332 */         if (p != null && p.cooldown <= 0)
/* 333 */           return true;  b++; }
/*     */     
/*     */     } 
/* 336 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TILE_STORAGE storage(int tx, int ty) {
/* 342 */     return (blueprintI()).crate.storage(tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Jobs
/*     */     extends JobPositions<SupplyInstance>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     public Jobs(SupplyInstance ins) {
/* 354 */       super(ins);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 359 */       return ((((SupplyInstance)this.ins).blueprintI()).crate.get(tx, ty) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 364 */       Crate c = (((SupplyInstance)this.ins).blueprintI()).crate.get(tx, ty);
/* 365 */       if (c != null)
/* 366 */         return c.job; 
/* 367 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 373 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void copyFrom(MoveOrderPull.MoveOrderPullInstance same) {
/* 380 */     SupplyInstance ins = (SupplyInstance)same;
/* 381 */     for (RESOURCE res : AD.supplies().resses()) {
/* 382 */       if (allowed().has(res) != ins.allowed().has(res)) {
/* 383 */         allowedToggle(res);
/* 384 */         reset();
/*     */       } 
/*     */     } 
/* 387 */     this.fetch = ins.fetch;
/* 388 */     this.coolFetch = 0;
/* 389 */     this.auto = ins.auto;
/* 390 */     employees().neededSet(ins.employees().target());
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomState makeState(int tx, int ty, boolean broken) {
/* 395 */     return (RoomState)new State(this, broken);
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
/*     */     private MoveOrderPull[] orders;
/* 409 */     private final RBIT.RBITImp useMask = new RBIT.RBITImp();
/*     */     
/*     */     public State(SupplyInstance ins, boolean broken) {
/* 412 */       super(ins);
/* 413 */       this.broken = broken;
/* 414 */       this.fetching = ins.fetch;
/* 415 */       this.prio = ins.prio;
/* 416 */       this.useMask.clearSet((RBIT)ins.allowed);
/* 417 */       if (broken) {
/* 418 */         this.orders = ins.orders;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void applyIns(RoomInstance ins) {
/* 425 */       if (ins instanceof SupplyInstance) {
/* 426 */         SupplyInstance s = (SupplyInstance)ins;
/* 427 */         if (this.broken) {
/* 428 */           for (int i = 0; i < this.orders.length; i++) {
/* 429 */             if (this.orders[i] != null) {
/* 430 */               MoveOrderPull p = new MoveOrderPull(this.orders[i].destCoo(), (RBIT)(this.orders[i]).resbits);
/* 431 */               s.orders[i] = p;
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/* 437 */         if (this.fetching != s.fetching())
/* 438 */           s.fetchingToggle(); 
/* 439 */         if (this.prio != s.prioritizing()) {
/* 440 */           s.prioritizeToggle();
/*     */         }
/* 442 */         for (RESOURCE res : RESOURCES.ALL()) {
/* 443 */           if (s.allowed().has(res.bit) != this.useMask.has(res.bit))
/* 444 */             s.allowedToggle(res); 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\supply\SupplyInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */