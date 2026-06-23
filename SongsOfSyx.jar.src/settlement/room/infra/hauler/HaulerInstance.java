/*     */ package settlement.room.infra.hauler;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.infra.logistics.MoveJob;
/*     */ import settlement.room.infra.logistics.MoveOrderPull;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.ROOM_RADIUS;
/*     */ import settlement.room.main.job.StorageCrate;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class HaulerInstance
/*     */   extends RoomInstance
/*     */   implements ROOM_RADIUS.ROOM_RADIUS_INSTANCE, MoveJob.ROOM_MOVE_SOURCE, MoveJob.ROOM_MOVE_DEST, MoveJob.ROOM_MOVEJOBBER, MoveOrderPull.MoveOrderPullInstance
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final int ORDERS = 2;
/*     */   private boolean hasSpace;
/*  35 */   private byte resourceI = -1;
/*  36 */   byte coolFetch = 0;
/*  37 */   byte coolOrganize = 0; private short ox;
/*     */   private short oy;
/*  39 */   final MoveOrderPull[] orders = new MoveOrderPull[2];
/*     */   private boolean storing;
/*     */   private boolean prio;
/*     */   private boolean fetching = true;
/*     */   boolean auto = true;
/*     */   final StorageCrate.StorageData[] sdata;
/*     */   int[] tdata;
/*  46 */   private byte orderI = 0;
/*  47 */   byte radius = 100; public static final int RADIUS = 80;
/*     */   
/*     */   HaulerInstance(ROOM_HAULER blueprint, TmpArea area, RoomInit init) {
/*  50 */     super(blueprint, area, init);
/*  51 */     (SETT.ROOMS()).data.set((ROOMA)this, mX(), mY(), 0);
/*  52 */     this.sdata = blueprint.crate.make((ROOMA)this);
/*     */     
/*  54 */     employees().maxSet(Math.max(body().width(), body().height()) * 5);
/*  55 */     employees().neededSet(1);
/*  56 */     activate();
/*  57 */     blueprint.tally.init(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  62 */     if (this.resourceI >= 0) {
/*  63 */       RESOURCE nr = (RESOURCE)RESOURCES.map().loader().get(this.resourceI);
/*  64 */       if (nr == null) {
/*  65 */         this.resourceI = -1;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void updateMasks() {
/*  72 */     this.hasSpace = ((t()).space.get(this) - (t()).spaceReserved.get(this) - (t()).amount.get(this) > 0);
/*     */   }
/*     */   
/*     */   private void reset() {
/*  76 */     this.coolFetch = 0;
/*  77 */     this.coolOrganize = 0; byte b; int i; MoveOrderPull[] arrayOfMoveOrderPull;
/*  78 */     for (i = (arrayOfMoveOrderPull = this.orders).length, b = 0; b < i; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/*  79 */       if (o != null)
/*  80 */         o.cooldown = 0; 
/*     */       b++; }
/*     */   
/*     */   }
/*     */   private final HaulerTally t() {
/*  85 */     return (blueprintI()).tally;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setResource(RESOURCE res) {
/*  90 */     if (resource() != null) {
/*  91 */       for (COORDINATE c : body()) {
/*  92 */         if (is(c) && (blueprintI()).crate.get(c.x(), c.y(), this, this.sdata) != null) {
/*  93 */           (blueprintI()).crate.clear();
/*     */         }
/*     */       } 
/*     */     }
/*  97 */     this.resourceI = (res == null) ? -1 : res.bIndex();
/*  98 */     if (res != null)
/*  99 */       for (COORDINATE c : body()) {
/* 100 */         if (is(c) && (blueprintI()).crate.get(c.x(), c.y(), this, this.sdata) != null)
/* 101 */           (blueprintI()).crate.resourceSet(res); 
/*     */       }  
/*     */     byte b;
/*     */     int i;
/*     */     MoveOrderPull[] arrayOfMoveOrderPull;
/* 106 */     for (i = (arrayOfMoveOrderPull = this.orders).length, b = 0; b < i; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/* 107 */       if (o != null)
/* 108 */         o.resbits.clearSet((resource() == null) ? RBIT.NONE : (resource()).bit);  b++; }
/*     */     
/* 110 */     reset();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double ds, boolean day) {
/* 116 */     if (!active() || employees().employed() <= 0) {
/*     */       return;
/*     */     }
/* 119 */     if (this.coolFetch > 0) {
/* 120 */       this.coolFetch = (byte)(this.coolFetch - 1);
/*     */     }
/* 122 */     if (this.coolOrganize > 0)
/* 123 */       this.coolOrganize = (byte)(this.coolOrganize - 1);  byte b;
/*     */     int i;
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
/* 135 */       if (is(c) && (blueprintI()).crate.get(c.x(), c.y(), this, this.sdata) != null) {
/* 136 */         (blueprintI()).crate.dispose();
/*     */       }
/*     */     } 
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
/*     */   public double getUsedSpace() {
/* 154 */     if (resource() == null)
/* 155 */       return 0.0D; 
/* 156 */     double d = (t()).amount.get(this);
/* 157 */     double c = (t()).space.get(this);
/* 158 */     if (c == 0.0D)
/* 159 */       return 0.0D; 
/* 160 */     return d / c;
/*     */   }
/*     */   
/*     */   public RESOURCE resource() {
/* 164 */     if (this.resourceI == -1)
/* 165 */       return null; 
/* 166 */     return (RESOURCE)RESOURCES.ALL().get(this.resourceI);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean searching() {
/* 171 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public double storedD(RESOURCE res) {
/* 176 */     if (res != resource())
/* 177 */       return 0.0D; 
/* 178 */     double s = (t()).space.get(this);
/* 179 */     if (s == 0.0D)
/* 180 */       return 1.0D; 
/* 181 */     return ((t()).amount.get(this) - (t()).amountReserved.get(this)) / s;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveCapacity() {
/* 186 */     if (resource() == null)
/* 187 */       return RBIT.NONE; 
/* 188 */     return (resource()).bit;
/*     */   }
/*     */ 
/*     */   
/*     */   public int moveCapacityAm(RESOURCE res) {
/* 193 */     if (resource() == null)
/* 194 */       return 0; 
/* 195 */     return (t()).space.get(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_HAULER blueprintI() {
/* 200 */     return (SETT.ROOMS()).HAULER;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean destroyTileCan(int tx, int ty) {
/* 205 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_DEGRADER degrader(int tx, int ty) {
/* 210 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT destSpaceMask() {
/* 215 */     if (resource() == null || !this.hasSpace) {
/* 216 */       return RBIT.NONE;
/*     */     }
/* 218 */     return (resource()).bit;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT sourceAmountMask() {
/* 223 */     if (resource() == null)
/* 224 */       return RBIT.NONE; 
/* 225 */     return (resource()).bit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE sourceCrate(RBIT okMask, int minAmount, int ox, int oy, double limit) {
/* 233 */     if (resource() == null || sourceAmountMask().isClear()) {
/* 234 */       return null;
/*     */     }
/* 236 */     if (!okMask.has(resource())) {
/* 237 */       return null;
/*     */     }
/* 239 */     double st = (t()).space.get(this);
/* 240 */     double am = ((t()).amount.get(this) - (t()).amountReserved.get(this) - minAmount);
/* 241 */     if (am <= 0.0D || limit > am / st) {
/* 242 */       return null;
/*     */     }
/*     */     
/* 245 */     if (is(ox, oy)) {
/* 246 */       StorageCrate storageCrate = (blueprintI()).crate.get(ox, oy, this, this.sdata);
/* 247 */       if (storageCrate != null && storageCrate.reservable() >= minAmount)
/* 248 */         return (RESOURCE_TILE)storageCrate; 
/*     */     } 
/* 250 */     for (COORDINATE c : body()) {
/* 251 */       StorageCrate s = (blueprintI()).crate.get(c.x(), c.y(), this, this.sdata);
/* 252 */       if (s != null && s.reservable() >= minAmount) {
/* 253 */         return (RESOURCE_TILE)s;
/*     */       }
/*     */     } 
/* 256 */     if (minAmount == 1) {
/* 257 */       LOG.ln("Weird indeed");
/*     */     }
/*     */     
/* 260 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TILE_STORAGE destCrate(RBIT okMask, int minAmount, int ox, int oy) {
/* 266 */     if (resource() == null || destSpaceMask().isClear()) {
/* 267 */       return null;
/*     */     }
/* 269 */     if (!okMask.has(resource())) {
/* 270 */       return null;
/*     */     }
/* 272 */     if (is(ox, oy)) {
/* 273 */       StorageCrate storageCrate = (blueprintI()).crate.get(ox, oy, this, this.sdata);
/* 274 */       if (storageCrate != null && storageCrate.resource() != null && okMask.has(storageCrate.resource()) && storageCrate.storageReservable() >= minAmount) {
/* 275 */         return (TILE_STORAGE)storageCrate;
/*     */       }
/*     */     } 
/* 278 */     int bestX = -1;
/* 279 */     int bestY = -1;
/* 280 */     int bestV = 0;
/*     */     
/* 282 */     for (COORDINATE c : body()) {
/* 283 */       StorageCrate s = (blueprintI()).crate.get(c.x(), c.y(), this, this.sdata);
/* 284 */       if (s == null)
/*     */         continue; 
/* 286 */       int v = 0;
/* 287 */       if (s.storageReservable() >= minAmount)
/* 288 */         v = 10000 - s.storageReservable(); 
/* 289 */       if (v > bestV) {
/* 290 */         bestX = s.x();
/* 291 */         bestY = s.y();
/* 292 */         bestV = v;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 297 */     if (bestX == -1 && minAmount == 1) {
/* 298 */       LOG.ln("Weird");
/* 299 */       return null;
/*     */     } 
/*     */     
/* 302 */     return (TILE_STORAGE)(blueprintI()).crate.get(bestX, bestY, this, this.sdata);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MoveJob moveJob(Humanoid skill) {
/* 308 */     if (resource() == null) {
/* 309 */       return null;
/*     */     }
/* 311 */     int am = (SETT.ROOMS()).STOCKPILE.carryCap(skill);
/*     */     
/* 313 */     if ((this.fetching || this.prio) && this.coolFetch <= 0) {
/*     */       
/* 315 */       RBIT bb = (resource()).bit;
/*     */       
/* 317 */       MoveJob j = MoveJob.fetch(this, this, am, radius(), this.ox, this.oy, this.fetching ? bb : RBIT.NONE, this.prio ? bb : RBIT.NONE);
/*     */       
/* 319 */       if (j != null) {
/* 320 */         this.ox = (short)j.source.x();
/* 321 */         this.oy = (short)j.source.y();
/* 322 */         return j;
/*     */       } 
/*     */       
/* 325 */       this.coolFetch = 2;
/*     */     } 
/*     */     
/* 328 */     for (int ooi = 0; ooi < this.orders.length; ooi++) {
/* 329 */       this.orderI = (byte)(this.orderI + 1);
/* 330 */       if (this.orderI >= this.orders.length)
/* 331 */         this.orderI = 0; 
/* 332 */       MoveOrderPull p = this.orders[this.orderI];
/* 333 */       if (p != null && p.cooldown <= 0) {
/* 334 */         MoveJob j = p.job(this, 1, am);
/*     */         
/* 336 */         if (j != null) {
/* 337 */           p.cooldown = -1;
/* 338 */           return j;
/*     */         } 
/* 340 */         p.cooldown = 2;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 346 */     if (this.coolOrganize <= 0) {
/*     */       
/* 348 */       int sx = -1;
/* 349 */       int sy = -1;
/* 350 */       int amm = 0;
/* 351 */       int maxS = 0;
/*     */       
/* 353 */       for (COORDINATE c : body()) {
/* 354 */         StorageCrate s = (blueprintI()).crate.get(c.x(), c.y(), this, this.sdata);
/*     */         
/* 356 */         if (s != null && s.storageReservable() > 0 && s.amount() > amm) {
/* 357 */           sx = s.x();
/* 358 */           sy = s.y();
/* 359 */           maxS = s.storageReservable();
/* 360 */           amm = s.amount();
/*     */         } 
/*     */       } 
/*     */       
/* 364 */       if (sx != -1) {
/* 365 */         for (COORDINATE c : body()) {
/* 366 */           StorageCrate storageCrate = (blueprintI()).crate.get(c.x(), c.y(), this, this.sdata);
/* 367 */           if (storageCrate == null || storageCrate.reservable() <= 0 || storageCrate.amount() >= amm || (
/* 368 */             storageCrate.x() == sx && storageCrate.y() == sy))
/*     */             continue; 
/* 370 */           MoveJob j = MoveJob.TMP;
/* 371 */           am = Math.min(am, storageCrate.reservable());
/* 372 */           am = Math.min(am, maxS);
/* 373 */           j.maxAm = am;
/* 374 */           j.res = storageCrate.resource();
/* 375 */           j.stored = true;
/* 376 */           j.prio = this.prio;
/* 377 */           j.source.set((COORDINATE)storageCrate);
/* 378 */           j.dest.set(sx, sy);
/* 379 */           return j;
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 386 */       this.coolOrganize = 4;
/*     */     } 
/*     */ 
/*     */     
/* 390 */     return null;
/*     */   }
/*     */   
/*     */   boolean storing() {
/* 394 */     return this.storing;
/*     */   }
/*     */   
/*     */   void storingSet(boolean s) {
/* 398 */     if (s == this.storing)
/*     */       return; 
/* 400 */     for (COORDINATE c : body()) {
/* 401 */       if (is(c) && (blueprintI()).crate.get(c.x(), c.y(), this, this.sdata) != null) {
/* 402 */         (blueprintI()).crate.remove();
/*     */       }
/*     */     } 
/* 405 */     this.storing = s;
/* 406 */     for (COORDINATE c : body()) {
/* 407 */       if (is(c) && (blueprintI()).crate.get(c.x(), c.y(), this, this.sdata) != null) {
/* 408 */         (blueprintI()).crate.add();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   boolean prio() {
/* 414 */     return this.prio;
/*     */   }
/*     */   
/*     */   void prioSet() {
/* 418 */     for (COORDINATE c : body()) {
/* 419 */       if (is(c) && (blueprintI()).crate.get(c.x(), c.y(), this, this.sdata) != null) {
/* 420 */         (blueprintI()).crate.remove();
/*     */       }
/*     */     } 
/* 423 */     this.prio = !this.prio;
/* 424 */     for (COORDINATE c : body()) {
/* 425 */       if (is(c) && (blueprintI()).crate.get(c.x(), c.y(), this, this.sdata) != null) {
/* 426 */         (blueprintI()).crate.add();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   boolean fetching() {
/* 432 */     return this.fetching;
/*     */   }
/*     */   
/*     */   void fetchingSet(boolean s) {
/* 436 */     if (s == this.fetching)
/*     */       return; 
/* 438 */     this.fetching = s;
/* 439 */     reset();
/*     */   }
/*     */ 
/*     */   
/*     */   public StorageCrate storage(int tx, int ty) {
/* 444 */     return (blueprintI()).crate.get(tx, ty, this, this.sdata);
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/* 449 */     return (RESOURCE_TILE)(blueprintI()).crate.get(tx, ty, this, this.sdata);
/*     */   }
/*     */ 
/*     */   
/*     */   public MoveOrderPull[] moveOrdersPull() {
/* 454 */     return this.orders;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveOrderPullAccepted() {
/* 459 */     if (resource() == null) {
/* 460 */       return RBIT.NONE;
/*     */     }
/* 462 */     return (resource()).bit;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveOrderPullAvailable() {
/* 467 */     if (resource() == null)
/* 468 */       return RBIT.NONE; 
/* 469 */     return (destCrate(destSpaceMask(), moveMinAmount(), -1, -1) != null) ? destSpaceMask() : RBIT.NONE;
/*     */   }
/*     */ 
/*     */   
/*     */   public int moveMinAmount() {
/* 474 */     return 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public int moveMaxRadius() {
/* 479 */     return 240;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int radius() {
/* 488 */     return (this.radius + 5) * 8;
/*     */   }
/*     */   
/*     */   public byte radiusRaw() {
/* 492 */     return this.radius;
/*     */   }
/*     */ 
/*     */   
/*     */   public void radiusRawSet(byte r) {
/* 497 */     this.radius = r;
/*     */   }
/*     */   
/*     */   public RoomState makeState(int rx, int ry, boolean broken) {
/* 501 */     return (RoomState)new State(this, broken);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class State
/*     */     extends RoomState.RoomStateInstance
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private final short ri;
/*     */     private final boolean broken;
/*     */     private MoveOrderPull[] orders;
/*     */     private boolean fetching;
/*     */     private boolean storing;
/*     */     
/*     */     public State(HaulerInstance ins, boolean broken) {
/* 517 */       super(ins);
/* 518 */       this.ri = ins.resourceI;
/*     */       
/* 520 */       this.broken = broken;
/* 521 */       if (broken) {
/* 522 */         this.orders = broken ? ins.orders : null;
/* 523 */         this.fetching = ins.fetching;
/* 524 */         this.storing = ins.storing;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void applyIns(RoomInstance ins) {
/* 531 */       if (ins instanceof HaulerInstance) {
/*     */         
/* 533 */         HaulerInstance s = (HaulerInstance)ins;
/* 534 */         if (this.ri != -1)
/* 535 */           s.setResource((RESOURCE)RESOURCES.ALL().getC(this.ri)); 
/* 536 */         s.fetchingSet(this.fetching);
/* 537 */         s.storingSet(this.storing);
/* 538 */         if (this.broken && 
/* 539 */           this.orders != null) {
/* 540 */           for (int i = 0; i < this.orders.length; i++) {
/* 541 */             if (this.orders[i] != null) {
/* 542 */               MoveOrderPull p = new MoveOrderPull(this.orders[i].destCoo(), (RBIT)(this.orders[i]).resbits);
/* 543 */               s.orders[i] = p;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void copyFrom(MoveOrderPull.MoveOrderPullInstance same) {
/* 559 */     HaulerInstance ins = (HaulerInstance)same;
/* 560 */     setResource(ins.resource());
/* 561 */     fetchingSet(ins.fetching());
/* 562 */     if (this.prio != ins.prio)
/* 563 */       prioSet(); 
/* 564 */     this.auto = ins.auto;
/* 565 */     employees().neededSet(ins.employees().target());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\hauler\HaulerInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */