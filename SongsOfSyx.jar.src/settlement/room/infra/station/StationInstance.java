/*     */ package settlement.room.infra.station;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.infra.logistics.MoveJob;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import snake2d.LOG;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class StationInstance
/*     */   extends RoomInstance
/*     */   implements JOBMANAGER_HASER, MoveJob.ROOM_MOVE_SOURCE
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private final Jobs jobs;
/*     */   boolean auto;
/*     */   final ArrayCooShort crates;
/*  42 */   transient StationTally[] tally = new StationTally[RESOURCES.ALL().size()];
/*  43 */   private int[] incoming = Alloc.ii(RESOURCES.ALL().size());
/*     */   
/*     */   double prepared;
/*  46 */   RBIT.RBITImp bamount = new RBIT.RBITImp();
/*  47 */   RBIT.RBITImp bcapacity = new RBIT.RBITImp();
/*     */   
/*     */   StationInstance(ROOM_STATION p, TmpArea area, RoomInit init) {
/*  50 */     super(p, area, init);
/*     */     
/*  52 */     this.tally = new StationTally[RESOURCES.ALL().size()];
/*     */     
/*  54 */     for (RESOURCE res : RESOURCES.ALL()) {
/*  55 */       this.tally[res.index()] = new StationTally();
/*     */     }
/*  57 */     int cr = 0;
/*  58 */     for (COORDINATE c : body()) {
/*  59 */       if (is(c) && ((SETT.ROOMS()).fData.tileData.get(c) & 0x2) != 0) {
/*  60 */         cr++;
/*     */       }
/*     */     } 
/*  63 */     this.crates = new ArrayCooShort(cr);
/*  64 */     for (COORDINATE c : body()) {
/*  65 */       if (is(c) && ((SETT.ROOMS()).fData.tileData.get(c) & 0x2) != 0) {
/*  66 */         this.crates.get().set(c);
/*  67 */         this.crates.inc();
/*     */       } 
/*     */     } 
/*     */     
/*  71 */     this.jobs = new Jobs(this);
/*     */     
/*  73 */     employees().maxSet(15);
/*  74 */     employees().neededSet(15);
/*     */     
/*  76 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  82 */     this.incoming = RESOURCES.map().loader().fix(this.incoming, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  87 */     it.lit();
/*  88 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  93 */     for (int i = 0; i < this.crates.size(); i++) {
/*  94 */       (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y());
/*  95 */       (blueprintI()).crate.resourceSet(null);
/*     */     }  int ri;
/*  97 */     for (ri = 0; ri < RESOURCES.ALL().size(); ri++) {
/*  98 */       RESOURCE r = (RESOURCE)RESOURCES.ALL().get(ri);
/*  99 */       blueprintI().tally(r).remove(tally(r), this);
/* 100 */       this.incoming[ri] = 0;
/*     */     } 
/* 102 */     this.prepared = 0.0D;
/* 103 */     for (ri = 0; ri < RESOURCES.ALL().size(); ri++) {
/* 104 */       RESOURCE r = (RESOURCE)RESOURCES.ALL().get(ri);
/* 105 */       blueprintI().tally(r).add(tally(r), this);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double ds, boolean day) {
/* 112 */     this.jobs.searchAgain();
/*     */   }
/*     */ 
/*     */   
/*     */   public void allocate(RESOURCE res, int am) {
/* 117 */     am -= tally(res).crates();
/*     */     
/* 119 */     if (am == 0) {
/*     */       return;
/*     */     }
/* 122 */     if (am > 0) {
/* 123 */       for (int i = 0; i < this.crates.size(); i++) {
/* 124 */         if ((blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y()).resource() == null) {
/* 125 */           (blueprintI()).crate.resourceSet(res);
/* 126 */           am--;
/* 127 */           if (am <= 0)
/*     */             return; 
/*     */         } 
/* 130 */         this.crates.inc();
/*     */       } 
/* 132 */       am--;
/*     */     } 
/* 134 */     if (am < 0) {
/* 135 */       for (int i = 0; i < this.crates.size(); i++) {
/* 136 */         if ((blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y()).resource() == res) {
/* 137 */           (blueprintI()).crate.resourceSet(null);
/* 138 */           am++;
/* 139 */           if (am >= 0) {
/*     */             return;
/*     */           }
/*     */         } 
/* 143 */         this.crates.inc();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void deliver(RESOURCE res, int am) {
/* 150 */     unreserve(res);
/*     */     
/* 152 */     for (int i = 0; i < this.crates.size(); i++) {
/* 153 */       (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y());
/* 154 */       if ((blueprintI()).crate.resource() == res) {
/* 155 */         (blueprintI()).crate.getClass(); int a = 400 - (blueprintI()).crate.stored.get();
/* 156 */         a = CLAMP.i(a, 0, am);
/* 157 */         (blueprintI()).crate.deliver(a);
/* 158 */         am -= a;
/* 159 */         if (am <= 0)
/*     */           return; 
/*     */       } 
/* 162 */       this.crates.inc();
/*     */     } 
/*     */     
/* 165 */     for (COORDINATE c : body()) {
/* 166 */       if (!(SETT.PATH()).solidity.is(c)) {
/* 167 */         (SETT.THINGS()).resources.create(c, res, am);
/*     */         return;
/*     */       } 
/*     */     } 
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
/*     */   public ROOM_STATION blueprintI() {
/* 189 */     return (ROOM_STATION)blueprint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JOB_MANAGER getWork() {
/* 196 */     return (JOB_MANAGER)this.jobs;
/*     */   }
/*     */ 
/*     */   
/*     */   public TILE_STORAGE storage(int tx, int ty) {
/* 201 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Jobs
/*     */     extends JobPositions<StationInstance>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */     
/*     */     public Jobs(StationInstance ins) {
/* 212 */       super(ins);
/* 213 */       randomize();
/* 214 */       setAlwaysNew();
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isAndInit(int tx, int ty) {
/* 219 */       return ((((StationInstance)this.ins).blueprintI()).job.get(tx, ty) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SETT_JOB get(int tx, int ty) {
/* 224 */       return (((StationInstance)this.ins).blueprintI()).job.get(tx, ty);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/* 230 */     RESOURCE_TILE c = (blueprintI()).crate.get(tx, ty);
/* 231 */     if (c != null && c.resource() != null)
/* 232 */       return c; 
/* 233 */     return null;
/*     */   }
/*     */   
/*     */   public StationTally tally(RESOURCE res) {
/* 237 */     return this.tally[res.index()];
/*     */   }
/*     */   
/*     */   public int maxPrep() {
/* 241 */     return TIME.secondsPerDay() * this.crates.size() / 2;
/*     */   }
/*     */   
/*     */   public double prepD() {
/* 245 */     return this.prepared / maxPrep();
/*     */   }
/*     */   
/*     */   public double efficiency() {
/* 249 */     double d = employees().employed() / employees().max();
/* 250 */     d *= d;
/* 251 */     d *= 1.25D;
/* 252 */     d += 0.02D;
/* 253 */     return d * (1.0D - getDegrade());
/*     */   }
/*     */   
/*     */   public boolean accepting(RESOURCE res) {
/* 257 */     (blueprintI()).crate.getClass(); return (tally(res).spaceAvailable() - this.incoming[res.index()] >= 400 && prepared() >= 1.0D);
/*     */   }
/*     */   
/*     */   public double prepared() {
/* 261 */     return this.prepared * TIME.secondsPerDayI();
/*     */   }
/*     */   
/*     */   public int incoming(RESOURCE res) {
/* 265 */     return this.incoming[res.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   void setPrepared(double prepared) {
/* 270 */     int old = (int)prepared();
/* 271 */     prepared = CLAMP.d(prepared, 0.0D, maxPrep());
/* 272 */     int nn = (int)(prepared * TIME.secondsPerDayI());
/* 273 */     if (old != nn && old * nn == 0) {
/* 274 */       int ri; for (ri = 0; ri < RESOURCES.ALL().size(); ri++) {
/* 275 */         RESOURCE r = (RESOURCE)RESOURCES.ALL().get(ri);
/* 276 */         blueprintI().tally(r).remove(tally(r), this);
/*     */       } 
/* 278 */       this.prepared = prepared;
/* 279 */       for (ri = 0; ri < RESOURCES.ALL().size(); ri++) {
/* 280 */         RESOURCE r = (RESOURCE)RESOURCES.ALL().get(ri);
/* 281 */         blueprintI().tally(r).add(tally(r), this);
/*     */       } 
/*     */     } else {
/*     */       
/* 285 */       this.prepared = prepared;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reserve(RESOURCE res) {
/* 293 */     setPrepared(this.prepared - TIME.secondsPerDay());
/* 294 */     blueprintI().tally(res).remove(tally(res), this);
/* 295 */     (blueprintI()).crate.getClass(); this.incoming[res.index()] = this.incoming[res.index()] + 400;
/* 296 */     this.incoming[res.index()] = CLAMP.i(this.incoming[res.index()], 0, 2147483647);
/* 297 */     blueprintI().tally(res).add(tally(res), this);
/*     */   }
/*     */   
/*     */   public void unreserve(RESOURCE res) {
/* 301 */     blueprintI().tally(res).remove(tally(res), this);
/* 302 */     (blueprintI()).crate.getClass(); this.incoming[res.index()] = this.incoming[res.index()] - 400;
/* 303 */     this.incoming[res.index()] = CLAMP.i(this.incoming[res.index()], 0, 2147483647);
/* 304 */     blueprintI().tally(res).add(tally(res), this);
/*     */   }
/*     */   
/* 307 */   private static final RBIT.RBITImp tmp = new RBIT.RBITImp();
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE sourceCrate(RBIT okMask, int minAm, int ox, int oy, double limit) {
/* 312 */     tmp.clearSet(okMask);
/* 313 */     tmp.and((RBIT)this.bamount);
/*     */     
/* 315 */     if (tmp.isClear()) {
/* 316 */       return null;
/*     */     }
/* 318 */     for (RESOURCE r : RESOURCES.ALL()) {
/* 319 */       if (tmp.has(r)) {
/* 320 */         StationTally t = tally(r);
/* 321 */         double st = t.space();
/* 322 */         double am = (t.stored() - t.reserved() - minAm);
/* 323 */         if (am <= 0.0D || limit > am / st) {
/* 324 */           tmp.clear(r);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 329 */     if (tmp.isClear()) {
/* 330 */       return null;
/*     */     }
/* 332 */     if (is(ox, oy)) {
/* 333 */       RESOURCE_TILE s = (blueprintI()).crate.get(ox, oy);
/* 334 */       if (s != null && s.resource() != null && tmp.has(s.resource()) && s.reservable() >= minAm) {
/* 335 */         return s;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 340 */     for (int i = 0; i < this.crates.size(); i++) {
/* 341 */       this.crates.inc();
/* 342 */       RESOURCE_TILE s = (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y());
/* 343 */       if (s.resource() != null && tmp.has(s.resource()) && s.reservable() >= minAm) {
/* 344 */         return s;
/*     */       }
/*     */     } 
/*     */     
/* 348 */     if (minAm == 1) {
/* 349 */       LOG.ln("Weird indeed");
/*     */     }
/* 351 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RBIT sourceAmountMask() {
/* 357 */     return (RBIT)this.bamount;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveCapacity() {
/* 362 */     return (RBIT)this.bcapacity;
/*     */   }
/*     */ 
/*     */   
/*     */   public int moveCapacityAm(RESOURCE res) {
/* 367 */     return tally(res).stored() - tally(res).reserved();
/*     */   }
/*     */ 
/*     */   
/*     */   public double storedD(RESOURCE res) {
/* 372 */     double sp = tally(res).space();
/* 373 */     if (sp == 0.0D)
/* 374 */       return 1.0D; 
/* 375 */     return tally(res).stored() / sp;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomState makeState(int tx, int ty, boolean broken) {
/* 380 */     return (RoomState)new State(this, broken);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class State
/*     */     extends RoomState.RoomStateInstance
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/* 389 */     private final short[] crates = new short[RESOURCES.ALL().size()];
/*     */ 
/*     */     
/*     */     public State(StationInstance ins, boolean broken) {
/* 393 */       super(ins);
/* 394 */       for (RESOURCE r : RESOURCES.ALL()) {
/* 395 */         this.crates[r.index()] = (short)ins.tally[r.index()].crates();
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void applyIns(RoomInstance ins) {
/* 402 */       if (ins instanceof StationInstance) {
/* 403 */         StationInstance s = (StationInstance)ins;
/* 404 */         for (int ri = 0; ri < RESOURCES.ALL().size() && ri < RESOURCES.ALL().size(); ri++)
/* 405 */           s.allocate((RESOURCE)RESOURCES.ALL().get(ri), this.crates[ri]); 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\station\StationInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */