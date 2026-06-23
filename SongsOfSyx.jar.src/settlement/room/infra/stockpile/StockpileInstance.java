/*     */ package settlement.room.infra.stockpile;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
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
/*     */ import settlement.thing.ThingsResources;
/*     */ import snake2d.LOG;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
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
/*     */ public final class StockpileInstance
/*     */   extends RoomInstance
/*     */   implements ROOM_RADIUS.ROOM_RADIUS_INSTANCE, MoveJob.ROOM_MOVE_SOURCE, MoveJob.ROOM_MOVE_DEST, MoveJob.ROOM_MOVEJOBBER, MoveOrderPull.MoveOrderPullInstance
/*     */ {
/*     */   static final int ORDERS = 4;
/*     */   private static final long serialVersionUID = -7063521835843676015L;
/*  43 */   private final RBIT.RBITImp tmp = new RBIT.RBITImp();
/*     */   
/*     */   int[][] tdata;
/*     */   final ArrayCooShort crates;
/*     */   final StorageCrate.StorageData[] sdata;
/*  48 */   int[] resCrates = Alloc.ii(RESOURCES.ALL().size());
/*     */   
/*  50 */   RBIT.RBITImp fetchMask = new RBIT.RBITImp();
/*  51 */   RBIT.RBITImp fetchMaskBig = new RBIT.RBITImp();
/*  52 */   RBIT.RBITImp reservableMask = new RBIT.RBITImp();
/*  53 */   public RBIT.RBITImp crateMask = new RBIT.RBITImp();
/*  54 */   byte coolFetch = -1;
/*  55 */   byte coolOrganize = -1; boolean hasTriedBig = false;
/*     */   private short ox;
/*     */   private short oy;
/*     */   boolean autoE;
/*  59 */   final MoveOrderPull[] orders = new MoveOrderPull[4];
/*     */   private boolean storing;
/*     */   private boolean fetching = true;
/*     */   private boolean prio = false;
/*  63 */   private byte orderI = 0;
/*     */   
/*  65 */   private byte[] limits = Alloc.bb(RESOURCES.ALL().size());
/*  66 */   byte radius = 100; public static final int RADIUS = 140;
/*     */   
/*     */   StockpileInstance(ROOM_STOCKPILE p, TmpArea area, RoomInit init) {
/*  69 */     super(p, area, init);
/*     */     
/*  71 */     this.tdata = Alloc.i2((p.tally()).datas.size(), RESOURCES.ALL().size() + 1);
/*  72 */     this.sdata = p.crate.make((ROOMA)this);
/*     */     
/*  74 */     int crateI = 0;
/*  75 */     for (COORDINATE c : body()) {
/*  76 */       if (!is(c))
/*     */         continue; 
/*  78 */       StorageCrate cr = p.crate.get(c.x(), c.y(), this, this.sdata);
/*  79 */       if (cr != null) {
/*  80 */         crateI++;
/*     */       }
/*     */     } 
/*     */     
/*  84 */     this.crates = new ArrayCooShort(crateI);
/*     */     
/*  86 */     crateI = 0;
/*  87 */     for (COORDINATE c : body()) {
/*  88 */       if (!is(c))
/*     */         continue; 
/*  90 */       if (p.crate.get(c.x(), c.y(), this, this.sdata) != null) {
/*  91 */         this.crates.set(crateI++).set(c.x(), c.y());
/*     */       }
/*     */     } 
/*     */     
/*  95 */     this.crates.shuffle(this.crates.size());
/*     */     
/*  97 */     this.crates.set(0);
/*     */     
/*  99 */     while (this.crates.hasNext()) {
/* 100 */       ThingsResources.ScatteredResource s = (ThingsResources.ScatteredResource)(SETT.THINGS()).resources.tGet.get((COORDINATE)this.crates.get());
/* 101 */       StorageCrate c = p.crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata);
/*     */       
/* 103 */       if (s != null) {
/*     */         
/* 105 */         c.resourceSet(s.resource());
/* 106 */         int am = CLAMP.i(s.amount(), 0, crateSize(s.resource()) - c.amount());
/* 107 */         c.amountSet(c.amount() + am);
/* 108 */         while (am-- > 0) {
/* 109 */           if (!s.findableReservedIs())
/* 110 */             s.findableReserve(); 
/* 111 */           s.resourcePickup();
/*     */         } 
/*     */       } 
/* 114 */       this.crates.next();
/*     */     } 
/* 116 */     this.crates.set(0);
/*     */     
/* 118 */     employees().maxSet(this.crates.size() * 8);
/* 119 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/* 126 */     if (this.limits == null) {
/* 127 */       this.limits = Alloc.bb(RESOURCES.ALL().size());
/*     */     }
/* 129 */     RESOURCES.map().loader().fix(this.limits, (byte)0);
/* 130 */     super.loadFix();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean loadExtra(FileGetter file) throws IOException {
/* 135 */     if (this.resCrates == null || this.resCrates.length != RESOURCES.ALL().size())
/* 136 */       this.resCrates = Alloc.ii(RESOURCES.ALL().size()); 
/* 137 */     return super.loadExtra(file);
/*     */   }
/*     */   
/*     */   void updateMasks() {
/* 141 */     for (RESOURCE r : RESOURCES.ALL()) {
/* 142 */       updateMasks(r);
/*     */     }
/*     */   }
/*     */   
/*     */   void updateMasks(RESOURCE r) {
/* 147 */     this.crateMask.clear(r);
/* 148 */     this.fetchMask.clear(r);
/* 149 */     this.fetchMaskBig.clear(r);
/* 150 */     this.reservableMask.clear(r);
/* 151 */     if ((t()).crates.get(r, this) > 0) {
/* 152 */       this.crateMask.or(r);
/*     */     }
/*     */     
/* 155 */     int am = (t()).space.get(r, this);
/* 156 */     am -= (t()).amount.get(r, this) + (t()).spaceReserved.get(r, this);
/* 157 */     if (am > 0) {
/* 158 */       this.fetchMask.or(r);
/* 159 */       if (am > (t()).space.get(r, this) / 2) {
/* 160 */         this.fetchMaskBig.or(r);
/*     */       }
/*     */     } 
/* 163 */     if ((t()).amount.get(r, this) - (t()).amountReserved.get(r, this) > 0) {
/* 164 */       this.reservableMask.or(r.bit);
/*     */     }
/*     */   }
/*     */   
/*     */   private void reset() {
/* 169 */     this.coolFetch = -1;
/* 170 */     this.coolOrganize = -1;
/* 171 */     this.hasTriedBig = false; byte b; int i; MoveOrderPull[] arrayOfMoveOrderPull;
/* 172 */     for (i = (arrayOfMoveOrderPull = this.orders).length, b = 0; b < i; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/* 173 */       if (o != null)
/* 174 */         o.cooldown = 0; 
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/* 180 */     super.render(r, shadowBatch, it);
/* 181 */     it.lit();
/* 182 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private final StockpileTally t() {
/* 187 */     return blueprintI().tally();
/*     */   }
/*     */   
/*     */   void allocateCrate(RESOURCE res, int amount) {
/* 191 */     setSpecialAmount(res, 0);
/* 192 */     pallocateCrate(res, amount);
/* 193 */     reset();
/*     */   }
/*     */ 
/*     */   
/*     */   private void pallocateCrate(RESOURCE res, int amount) {
/* 198 */     while (amount < (t()).crates.get(res.bIndex(), this)) {
/*     */       
/* 200 */       int best = -1;
/* 201 */       int smallest = Integer.MAX_VALUE;
/* 202 */       for (int i = 0; i < this.crates.size(); i++) {
/* 203 */         StorageCrate storageCrate = (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata);
/* 204 */         int ci = this.crates.getI();
/* 205 */         this.crates.inc();
/* 206 */         if (storageCrate.resource() == res)
/*     */         {
/*     */           
/* 209 */           if (storageCrate.amount() < smallest) {
/* 210 */             best = ci;
/* 211 */             smallest = storageCrate.amount();
/*     */           } 
/*     */         }
/*     */       } 
/* 215 */       if (best == -1) {
/*     */         break;
/*     */       }
/* 218 */       this.crates.set(best);
/* 219 */       StorageCrate crate = (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata);
/* 220 */       crate.clear();
/*     */     } 
/*     */ 
/*     */     
/* 224 */     if (amount > (t()).crates.get(res, this))
/* 225 */       for (int i = 0; i < this.crates.size(); i++) {
/* 226 */         StorageCrate crate = (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata);
/* 227 */         this.crates.inc();
/* 228 */         if (crate.resource() == null) {
/*     */           
/* 230 */           crate.resourceSet(res);
/*     */           
/* 232 */           if ((t()).crates.get(res, this) == amount) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       }  
/* 237 */     reset();
/*     */   }
/*     */   
/*     */   void setSpecialAmount(RESOURCE res, int amount) {
/* 241 */     amount = CLAMP.i(amount, 0, crateSize());
/* 242 */     if (amount == this.limits[res.index()]) {
/*     */       return;
/*     */     }
/* 245 */     amount = CLAMP.i(amount, 0, crateSize());
/*     */     
/* 247 */     if (amount < 0 || amount > crateSize()) {
/* 248 */       throw new RuntimeException(String.valueOf(res) + " " + String.valueOf(res) + " " + amount);
/*     */     }
/* 250 */     pallocateCrate(res, 1);
/* 251 */     if ((t()).crates.get(res, this) != 1) {
/*     */       return;
/*     */     }
/* 254 */     for (int i = 0; i < this.crates.size(); ) {
/* 255 */       StorageCrate crate = (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata);
/* 256 */       this.crates.inc();
/* 257 */       if (crate.resource() != res) {
/*     */         i++; continue;
/* 259 */       }  crate.reservedSet(crate.reservable() + crate.reserved());
/*     */       
/* 261 */       int am = 0;
/* 262 */       int max = (int)((amount == 0) ? (blueprintI().upgrades().boost(upgrade()) - 1.0D) : amount);
/* 263 */       while (crate.reserved() > 0 && am < max) {
/* 264 */         crate.resourcePickup();
/* 265 */         am++;
/*     */       } 
/* 267 */       crate.clear();
/* 268 */       this.limits[res.index()] = (byte)amount;
/* 269 */       crate.resourceSet(res);
/* 270 */       crate.storageReserve(am);
/* 271 */       crate.storageDeposit(am);
/*     */       
/*     */       return;
/*     */     } 
/* 275 */     LOG.ln("weird!");
/*     */   }
/*     */   
/*     */   public int getSpecialAmount(RESOURCE res) {
/* 279 */     return this.limits[res.index()];
/*     */   }
/*     */   
/*     */   public int totalCrates() {
/* 283 */     return this.crates.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void upgradeSet(int upgrade) {
/* 290 */     if (upgrade < upgrade()) {
/* 291 */       int max = (int)(blueprintI().upgrades().boost(upgrade) - 1.0D);
/* 292 */       for (int j = 0; j < this.crates.size(); j++) {
/* 293 */         StorageCrate c = (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata);
/* 294 */         if (c.resource() != null) {
/* 295 */           int tooMuch = c.amount() - max;
/* 296 */           if (c.reserved() > max) {
/* 297 */             c.reservedSet(max);
/*     */           }
/* 299 */           int newAm = Math.min(max, c.amount());
/* 300 */           if (newAm + c.storageReserved() > max) {
/* 301 */             c.storageUnreserve(newAm + c.storageReserved() - max);
/*     */           }
/*     */           
/* 304 */           if (tooMuch > 0) {
/* 305 */             c.amountSet(max);
/* 306 */             (SETT.THINGS()).resources.create((COORDINATE)c, c.resource(), tooMuch);
/*     */           } 
/*     */         } 
/*     */         
/* 310 */         this.crates.inc();
/*     */       } 
/*     */     } 
/*     */     int i;
/* 314 */     for (i = 0; i < this.crates.size(); i++) {
/* 315 */       (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata).remove();
/* 316 */       this.crates.inc();
/*     */     } 
/* 318 */     super.upgradeSet(upgrade);
/* 319 */     for (i = 0; i < this.crates.size(); i++) {
/* 320 */       (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata).add();
/* 321 */       this.crates.inc();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double ds, boolean day) {
/* 329 */     if (!active() || employees().employed() <= 0) {
/*     */       return;
/*     */     }
/* 332 */     this.hasTriedBig = false;
/* 333 */     if (this.coolFetch > 0) {
/* 334 */       this.coolFetch = (byte)(this.coolFetch - 1);
/*     */     }
/* 336 */     if (this.coolOrganize > 0)
/* 337 */       this.coolOrganize = (byte)(this.coolOrganize - 1);  byte b; int i;
/*     */     MoveOrderPull[] arrayOfMoveOrderPull;
/* 339 */     for (i = (arrayOfMoveOrderPull = this.orders).length, b = 0; b < i; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/* 340 */       if (o != null && o.cooldown > 0) {
/* 341 */         o.cooldown = (byte)(o.cooldown - 1);
/*     */       }
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   protected void dispose() {
/* 348 */     for (int i = 0; i < this.crates.size(); i++) {
/* 349 */       StorageCrate crate = (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata);
/* 350 */       crate.dispose();
/* 351 */       this.crates.inc();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_STOCKPILE blueprintI() {
/* 357 */     return (SETT.ROOMS()).STOCKPILE;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/* 362 */     return (RESOURCE_TILE)(blueprintI()).crate.get(tx, ty, this, this.sdata);
/*     */   }
/*     */ 
/*     */   
/*     */   public TILE_STORAGE storage(int tx, int ty) {
/* 367 */     return (TILE_STORAGE)(blueprintI()).crate.get(tx, ty, this, this.sdata);
/*     */   }
/*     */   
/*     */   public StorageCrate crate(int tx, int ty) {
/* 371 */     return (blueprintI()).crate.get(tx, ty, this, this.sdata);
/*     */   }
/*     */   
/*     */   public double getUsedSpace() {
/* 375 */     double d = (t()).amount.get((RESOURCE)null, this);
/* 376 */     double c = (t()).space.get((RESOURCE)null, this);
/* 377 */     if (c == 0.0D)
/* 378 */       return 0.0D; 
/* 379 */     return d / c;
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
/*     */   public boolean searching() {
/* 398 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int crateSize() {
/* 404 */     return (int)(blueprintI().upgrades().boost(upgrade()) - 1.0D);
/*     */   }
/*     */   
/*     */   public int crateSize(RESOURCE res) {
/* 408 */     if (res == null || this.limits[res.index()] == 0)
/* 409 */       return (int)(blueprintI().upgrades().boost(upgrade()) - 1.0D); 
/* 410 */     return this.limits[res.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public double storedD(RESOURCE res) {
/* 415 */     double s = (t()).space.get(res, this);
/* 416 */     if (s == 0.0D)
/* 417 */       return 1.0D; 
/* 418 */     return ((t()).amount.get(res, this) - (t()).amountReserved.get(res, this)) / s;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveCapacity() {
/* 423 */     return (RBIT)this.crateMask;
/*     */   }
/*     */ 
/*     */   
/*     */   public int moveCapacityAm(RESOURCE res) {
/* 428 */     return (t()).space.get(res, this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE sourceCrate(RBIT okMask, int minAm, int ox, int oy, double limit) {
/* 434 */     this.tmp.clearSet(okMask);
/* 435 */     this.tmp.and((RBIT)this.reservableMask);
/*     */     
/* 437 */     if (this.tmp.isClear()) {
/* 438 */       return null;
/*     */     }
/* 440 */     for (RESOURCE r : RESOURCES.ALL()) {
/* 441 */       if (this.tmp.has(r)) {
/* 442 */         double st = (t()).space.get(r, this);
/* 443 */         double am = ((t()).amount.get(r, this) - (t()).amountReserved.get(r, this) - minAm);
/* 444 */         if (am <= 0.0D || limit > am / st) {
/* 445 */           this.tmp.clear(r);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 450 */     if (this.tmp.isClear()) {
/* 451 */       return null;
/*     */     }
/* 453 */     if (is(ox, oy)) {
/* 454 */       StorageCrate storageCrate = (blueprintI()).crate.get(ox, oy, this, this.sdata);
/* 455 */       if (storageCrate != null && storageCrate.resource() != null && this.tmp.has(storageCrate.resource()) && storageCrate.reservable() >= minAm) {
/* 456 */         return (RESOURCE_TILE)storageCrate;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 461 */     for (int i = 0; i < this.crates.size(); i++) {
/* 462 */       this.crates.inc();
/* 463 */       StorageCrate storageCrate = (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata);
/* 464 */       if (storageCrate.resource() != null && this.tmp.has(storageCrate.resource()) && storageCrate.reservable() >= minAm) {
/* 465 */         return (RESOURCE_TILE)storageCrate;
/*     */       }
/*     */     } 
/*     */     
/* 469 */     if (minAm == 1) {
/* 470 */       LOG.ln("Weird indeed");
/*     */     }
/* 472 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TILE_STORAGE fetchToCrate(RESOURCE res, int desiredAm) {
/* 478 */     int ri = res.index();
/*     */     
/* 480 */     if (this.resCrates[ri] >= 0 && this.resCrates[ri] < this.crates.size()) {
/* 481 */       int cx = this.crates.x(this.resCrates[ri]);
/* 482 */       int cy = this.crates.y(this.resCrates[ri]);
/*     */       
/* 484 */       if (is(cx, cy)) {
/* 485 */         StorageCrate storageCrate = (blueprintI()).crate.get(cx, cy, this, this.sdata);
/* 486 */         if (storageCrate != null && storageCrate.resource() == res && storageCrate.storageReservable() > 0) {
/* 487 */           if (storageCrate.storageReservable() < desiredAm)
/* 488 */             this.resCrates[ri] = this.resCrates[ri] + 1; 
/* 489 */           return (TILE_STORAGE)storageCrate;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 494 */     int best = 0;
/* 495 */     int backup = -1;
/*     */     
/* 497 */     for (int i = 0; i < this.crates.size(); i++) {
/*     */       
/* 499 */       this.resCrates[ri] = this.resCrates[ri] + 1;
/* 500 */       if (this.resCrates[ri] >= this.crates.size()) {
/* 501 */         this.resCrates[ri] = 0;
/*     */       }
/*     */       
/* 504 */       StorageCrate storageCrate = (blueprintI()).crate.get(this.crates.x(this.resCrates[ri]), this.crates.y(this.resCrates[ri]), this, this.sdata);
/* 505 */       if (storageCrate.resource() == res && storageCrate.storageReservable() >= 0) {
/* 506 */         if (storageCrate.storageReservable() >= desiredAm)
/* 507 */           return (TILE_STORAGE)storageCrate; 
/* 508 */         if (storageCrate.storageReservable() > best) {
/* 509 */           best = storageCrate.storageReservable();
/* 510 */           backup = this.resCrates[ri];
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 517 */     if (backup == -1) {
/* 518 */       throw new RuntimeException("nay");
/*     */     }
/* 520 */     this.resCrates[ri] = backup;
/* 521 */     return (TILE_STORAGE)(blueprintI()).crate.get(this.crates.x(backup), this.crates.y(backup), this, this.sdata);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TILE_STORAGE destCrate(RBIT okMask, int minAmount, int ox, int oy) {
/* 527 */     this.tmp.clearSet(okMask);
/* 528 */     this.tmp.and((minAmount > 64) ? (RBIT)this.fetchMaskBig : (RBIT)this.fetchMask);
/* 529 */     if (this.tmp.isClear()) {
/* 530 */       return null;
/*     */     }
/* 532 */     if (is(ox, oy)) {
/* 533 */       StorageCrate storageCrate = (blueprintI()).crate.get(ox, oy, this, this.sdata);
/* 534 */       if (storageCrate != null && storageCrate.resource() != null && okMask.has(storageCrate.resource()) && storageCrate.storageReservable() >= minAmount) {
/* 535 */         return (TILE_STORAGE)storageCrate;
/*     */       }
/*     */     } 
/* 538 */     for (int i = 0; i < this.crates.size(); i++) {
/* 539 */       this.crates.inc();
/* 540 */       StorageCrate storageCrate = (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata);
/* 541 */       if (storageCrate.resource() != null && okMask.has(storageCrate.resource()) && storageCrate.storageReservable() >= minAmount) {
/* 542 */         return (TILE_STORAGE)storageCrate;
/*     */       }
/*     */     } 
/*     */     
/* 546 */     if (minAmount > 1) {
/* 547 */       return null;
/*     */     }
/* 549 */     debugFuck();
/* 550 */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   private void debugFuck() {
/* 554 */     int[] st = Alloc.ii(RESOURCES.ALL().size());
/* 555 */     int[] rr = Alloc.ii(RESOURCES.ALL().size());
/* 556 */     for (int i = 0; i < this.crates.size(); i++) {
/* 557 */       this.crates.inc();
/* 558 */       StorageCrate s = (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata);
/* 559 */       if (s.resource() != null) {
/* 560 */         st[s.resource().index()] = st[s.resource().index()] + s.storageReservable();
/* 561 */         rr[s.resource().index()] = rr[s.resource().index()] + s.reservable();
/*     */       } 
/*     */     } 
/*     */     
/* 565 */     for (RESOURCE r : RESOURCES.ALL()) {
/* 566 */       int am = (t()).space.get(r, this);
/* 567 */       am -= (t()).amount.get(r, this) + (t()).spaceReserved.get(r, this);
/* 568 */       LOG.ln(String.valueOf(r) + " " + String.valueOf(r) + " " + this.fetchMask.has(r) + " " + am);
/* 569 */       LOG.ln("" + (t()).amount.get(r, this) - (t()).amountReserved.get(r, this) + " " + (t()).amount.get(r, this) - (t()).amountReserved.get(r, this));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MoveJob moveJob(Humanoid skill) {
/* 577 */     int am = (SETT.ROOMS()).STOCKPILE.carryCap(skill);
/*     */     
/* 579 */     if ((this.fetching || this.prio) && this.coolFetch <= 0) {
/*     */       
/* 581 */       MoveJob j = null;
/*     */       
/* 583 */       if (!this.hasTriedBig)
/* 584 */         j = MoveJob.fetch(this, this, am, radius(), this.ox, this.oy, this.fetching ? (RBIT)this.fetchMaskBig : RBIT.NONE, this.prio ? (RBIT)this.fetchMaskBig : RBIT.NONE); 
/* 585 */       if (j == null) {
/* 586 */         j = MoveJob.fetch(this, this, am, radius(), this.ox, this.oy, this.fetching ? (RBIT)this.fetchMask : RBIT.NONE, this.prio ? (RBIT)this.fetchMask : RBIT.NONE);
/* 587 */         this.hasTriedBig = true;
/*     */       } 
/*     */       
/* 590 */       if (j != null) {
/* 591 */         this.ox = (short)j.source.x();
/* 592 */         this.oy = (short)j.source.y();
/* 593 */         this.coolFetch = -1;
/* 594 */         return j;
/*     */       } 
/* 596 */       this.coolFetch = 2;
/*     */     } 
/*     */     
/* 599 */     for (int ooi = 0; ooi < this.orders.length; ooi++) {
/* 600 */       this.orderI = (byte)(this.orderI + 1);
/* 601 */       if (this.orderI >= this.orders.length)
/* 602 */         this.orderI = 0; 
/* 603 */       MoveOrderPull p = this.orders[this.orderI];
/* 604 */       if (p != null && p.cooldown <= 0) {
/* 605 */         MoveJob j = p.job(this, 1, am);
/*     */         
/* 607 */         if (j != null) {
/* 608 */           p.cooldown = -1;
/* 609 */           return j;
/*     */         } 
/* 611 */         p.cooldown = 4;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 617 */     if (this.coolOrganize <= 0) {
/*     */       
/* 619 */       MoveJob j = (blueprintI()).org.organise(this, am);
/* 620 */       if (j != null) {
/* 621 */         this.coolOrganize = -1;
/* 622 */         return j;
/*     */       } 
/*     */       
/* 625 */       this.coolOrganize = 4;
/*     */     } 
/*     */ 
/*     */     
/* 629 */     return null;
/*     */   }
/*     */   
/*     */   boolean storing() {
/* 633 */     return this.storing;
/*     */   }
/*     */   
/*     */   void storingSet(boolean s) {
/* 637 */     if (s == this.storing)
/*     */       return;  int i;
/* 639 */     for (i = 0; i < this.crates.size(); i++) {
/* 640 */       (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata).remove();
/* 641 */       this.crates.inc();
/*     */     } 
/* 643 */     this.storing = s;
/* 644 */     for (i = 0; i < this.crates.size(); i++) {
/* 645 */       (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata).add();
/* 646 */       this.crates.inc();
/*     */     } 
/*     */   }
/*     */   
/*     */   boolean fetching() {
/* 651 */     return this.fetching;
/*     */   }
/*     */   
/*     */   void fetchingSet(boolean s) {
/* 655 */     if (s == this.fetching)
/*     */       return; 
/* 657 */     this.fetching = s;
/* 658 */     reset();
/*     */   }
/*     */   public void prioritizeToggle() {
/*     */     int i;
/* 662 */     for (i = 0; i < this.crates.size(); i++) {
/* 663 */       (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata).remove();
/* 664 */       this.crates.inc();
/*     */     } 
/* 666 */     this.prio = !this.prio;
/* 667 */     for (i = 0; i < this.crates.size(); i++) {
/* 668 */       (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata).add();
/* 669 */       this.crates.inc();
/*     */     } 
/* 671 */     reset();
/*     */   }
/*     */   
/*     */   public boolean prioritizing() {
/* 675 */     return this.prio;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RBIT destSpaceMask() {
/* 684 */     return (RBIT)this.fetchMask;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT sourceAmountMask() {
/* 689 */     return (RBIT)this.reservableMask;
/*     */   }
/*     */ 
/*     */   
/*     */   public MoveOrderPull[] moveOrdersPull() {
/* 694 */     return this.orders;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveOrderPullAccepted() {
/* 699 */     return (RBIT)this.crateMask;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveOrderPullAvailable() {
/* 704 */     this.tmp.clear();
/* 705 */     for (int i = 0; i < this.crates.size(); i++) {
/* 706 */       this.crates.inc();
/* 707 */       StorageCrate storageCrate = (blueprintI()).crate.get(this.crates.get().x(), this.crates.get().y(), this, this.sdata);
/* 708 */       if (storageCrate.resource() != null && storageCrate.storageReservable() >= moveMinAmount()) {
/* 709 */         this.tmp.or(storageCrate.resource());
/*     */       }
/*     */     } 
/* 712 */     return (RBIT)this.tmp;
/*     */   }
/*     */ 
/*     */   
/*     */   public int moveMinAmount() {
/* 717 */     return 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public int moveMaxRadius() {
/* 722 */     return 280;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int radius() {
/* 729 */     return (this.radius + 5) * 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte radiusRaw() {
/* 734 */     return this.radius;
/*     */   }
/*     */ 
/*     */   
/*     */   public void radiusRawSet(byte r) {
/* 739 */     this.radius = r;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomState makeState(int tx, int ty, boolean broken) {
/* 744 */     return (RoomState)new State(this, broken);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class State
/*     */     extends RoomState.RoomStateInstance
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/* 753 */     private final short[] crates = new short[RESOURCES.ALL().size()];
/*     */     
/* 755 */     private final byte[] limits = Alloc.bb(RESOURCES.ALL().size());
/*     */     
/*     */     private boolean fetching;
/*     */     private boolean storing;
/*     */     private boolean prio;
/*     */     private final boolean broken;
/*     */     private MoveOrderPull[] orders;
/*     */     
/*     */     public State(StockpileInstance ins, boolean broken) {
/* 764 */       super(ins);
/* 765 */       for (RESOURCE r : RESOURCES.ALL()) {
/* 766 */         this.crates[r.index()] = (short)((SETT.ROOMS()).STOCKPILE.tally()).crates.get(r, ins);
/*     */       }
/* 768 */       for (int i = 0; i < this.limits.length; i++) {
/* 769 */         this.limits[i] = ins.limits[i];
/*     */       }
/* 771 */       this.broken = broken;
/* 772 */       this.fetching = ins.fetching;
/* 773 */       this.storing = ins.storing;
/* 774 */       this.prio = ins.prio;
/* 775 */       if (broken) {
/* 776 */         this.orders = ins.orders;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void applyIns(RoomInstance ins) {
/* 784 */       if (ins instanceof StockpileInstance) {
/* 785 */         StockpileInstance s = (StockpileInstance)ins; int ri;
/* 786 */         for (ri = 0; ri < RESOURCES.ALL().size() && ri < this.crates.length; ri++) {
/* 787 */           s.allocateCrate((RESOURCE)RESOURCES.ALL().get(ri), this.crates[ri]);
/*     */         }
/* 789 */         for (ri = 0; ri < RESOURCES.ALL().size() && ri < this.crates.length; ri++) {
/* 790 */           s.setSpecialAmount((RESOURCE)RESOURCES.ALL().get(ri), this.limits[ri]);
/*     */         }
/* 792 */         if (this.broken) {
/* 793 */           for (int i = 0; i < this.orders.length; i++) {
/* 794 */             if (this.orders[i] != null) {
/* 795 */               MoveOrderPull p = new MoveOrderPull(this.orders[i].destCoo(), (RBIT)(this.orders[i]).resbits);
/* 796 */               s.orders[i] = p;
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/* 802 */         s.fetchingSet(this.fetching);
/* 803 */         s.storingSet(this.storing);
/* 804 */         if (this.prio != s.prio) {
/* 805 */           s.prioritizeToggle();
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void copyFrom(MoveOrderPull.MoveOrderPullInstance same) {
/* 815 */     StockpileInstance ins = (StockpileInstance)same;
/* 816 */     for (RESOURCE r : RESOURCES.ALL()) {
/* 817 */       int cr = (int)Math.ceil(this.crates.size() * (blueprintI().tally()).crates.get(r.index(), ins) / ins.crates.size());
/* 818 */       allocateCrate(r, cr);
/* 819 */       if (ins.limits[r.index()] > 0)
/* 820 */         setSpecialAmount(r, ins.limits[r.index()]); 
/*     */     } 
/* 822 */     employees().neededSet(ins.employees().target());
/* 823 */     fetchingSet(ins.fetching());
/* 824 */     this.autoE = ins.autoE;
/* 825 */     if (prioritizing() != ins.prioritizing())
/* 826 */       prioritizeToggle(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\StockpileInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */