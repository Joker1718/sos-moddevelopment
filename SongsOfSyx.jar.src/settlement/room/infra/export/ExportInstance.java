/*     */ package settlement.room.infra.export;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.infra.logistics.MoveJob;
/*     */ import settlement.room.infra.logistics.MoveOrderPull;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.ROOM_RADIUS;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ExportInstance
/*     */   extends RoomInstance
/*     */   implements ROOM_RADIUS.ROOM_RADIUS_INSTANCE, MoveJob.ROOM_MOVE_DEST, MoveJob.ROOM_MOVEJOBBER, MoveOrderPull.MoveOrderPullInstance
/*     */ {
/*     */   private byte resourceI;
/*     */   private static final long serialVersionUID = 1L;
/*     */   static final int crateMax = 500;
/*     */   final short crates;
/*  43 */   int amount = 0;
/*  44 */   int amountReserved = 0;
/*  45 */   int spaceReserved = 0;
/*     */   
/*     */   boolean auto = true;
/*     */   public static final int ORDERS = 4;
/*  49 */   private final MoveOrderPull[] orders = new MoveOrderPull[4];
/*  50 */   byte coolFetch = -1; private short lastCX;
/*     */   private short lastCY;
/*     */   private short ox;
/*     */   private short oy;
/*     */   private byte orderI;
/*     */   private boolean fetching = true;
/*     */   private boolean prio = true;
/*     */   byte radius;
/*     */   
/*     */   ExportInstance(ROOM_EXPORT b, TmpArea area, RoomInit init) {
/*  60 */     super(b, area, init);
/*     */     
/*  62 */     int cc = 0;
/*  63 */     for (COORDINATE c : body()) {
/*  64 */       if (is(c)) {
/*  65 */         Crate crate = b.crate(c.x(), c.y());
/*  66 */         if (crate != null) {
/*  67 */           cc++;
/*     */         }
/*     */       } 
/*     */     } 
/*  71 */     this.crates = (short)cc;
/*     */     
/*  73 */     employees().maxSet(this.crates);
/*  74 */     employees().neededSet((int)Math.ceil(this.crates / 20.0D));
/*  75 */     activate();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  80 */     if (this.resourceI > 0 && RESOURCES.map().loader().get(this.resourceI - 1) == null) {
/*  81 */       this.amount = 0;
/*  82 */       this.amountReserved = 0;
/*  83 */       this.resourceI = 0;
/*  84 */       this.spaceReserved = 0;
/*  85 */       for (COORDINATE c : body()) {
/*  86 */         if (is(c)) {
/*  87 */           (SETT.ROOMS()).data.set((ROOMA)this, c, 0);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  95 */     it.lit();
/*  96 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void dispose() {
/* 101 */     resourceSet((RESOURCE)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void updateAction(double ds, boolean day) {
/* 107 */     if (this.coolFetch > 0)
/* 108 */       this.coolFetch = (byte)(this.coolFetch - 1);  byte b;
/*     */     int i;
/*     */     MoveOrderPull[] arrayOfMoveOrderPull;
/* 111 */     for (i = (arrayOfMoveOrderPull = this.orders).length, b = 0; b < i; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/* 112 */       if (o != null && o.cooldown > 0)
/* 113 */         o.cooldown = (byte)(o.cooldown - 1); 
/*     */       b++; }
/*     */     
/* 116 */     if (!active() || employees().employed() <= 0) {
/*     */       return;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE resource() {
/* 123 */     if (this.resourceI == 0)
/* 124 */       return null; 
/* 125 */     return (RESOURCE)RESOURCES.ALL().get(this.resourceI - 1);
/*     */   }
/*     */   
/*     */   void resourceSet(RESOURCE r) {
/* 129 */     if (r == resource()) {
/*     */       return;
/*     */     }
/* 132 */     if (resource() != null) {
/* 133 */       for (COORDINATE c : body()) {
/* 134 */         if (!is(c))
/*     */           continue; 
/* 136 */         Crate crate = blueprintI().crate(c.x(), c.y());
/* 137 */         if (crate == null)
/*     */           continue; 
/* 139 */         int am = crate.amount();
/* 140 */         crate.clear();
/* 141 */         if (am > 0) {
/* 142 */           for (DIR dd : DIR.ORTHO) {
/* 143 */             if (!(SETT.PATH()).solidity.is(c, dd)) {
/* 144 */               (blueprintI()).FETCHER.vacate(c.x() + dd.x(), c.y() + dd.y(), resource(), am);
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/* 150 */       (blueprintI()).tally.inc(resource(), 0, -500 * this.crates);
/*     */     } 
/* 152 */     if (this.amount != 0) {
/* 153 */       GAME.Notify(String.valueOf((resource()).name) + " " + String.valueOf((resource()).name));
/* 154 */       this.amount = 0;
/*     */     } 
/*     */     
/* 157 */     this.resourceI = (byte)((r == null) ? 0 : (r.index() + 1));
/* 158 */     if (resource() != null) {
/* 159 */       (blueprintI()).tally.inc(resource(), 0, 500 * this.crates);
/*     */     }
/* 161 */     this.coolFetch = 0; byte b;
/*     */     int i;
/*     */     MoveOrderPull[] arrayOfMoveOrderPull;
/* 164 */     for (i = (arrayOfMoveOrderPull = this.orders).length, b = 0; b < i; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/* 165 */       if (o != null) {
/* 166 */         o.resbits.clear();
/* 167 */         if (r != null)
/* 168 */           o.resbits.or(r); 
/*     */       } 
/* 170 */       if (o != null && o.cooldown > 0) {
/* 171 */         o.cooldown = 0;
/*     */       }
/*     */       b++; }
/*     */   
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
/*     */   public ROOM_EXPORT blueprintI() {
/* 188 */     return (SETT.ROOMS()).EXPORT;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomState makeState(int tx, int ty, boolean broken) {
/* 193 */     return (RoomState)new State(this, broken);
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
/*     */     private final int ri;
/*     */     
/*     */     public State(ExportInstance ins, boolean broken) {
/* 210 */       super(ins);
/* 211 */       this.broken = broken;
/* 212 */       this.fetching = ins.fetching;
/* 213 */       this.prio = ins.prio;
/* 214 */       this.ri = ins.resourceI;
/* 215 */       if (broken) {
/* 216 */         this.orders = ins.orders;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void applyIns(RoomInstance ins) {
/* 223 */       if (ins instanceof ExportInstance) {
/* 224 */         if (this.ri != 0) {
/* 225 */           ((ExportInstance)ins).resourceSet((RESOURCE)RESOURCES.ALL().get(this.ri - 1));
/*     */         }
/* 227 */         ExportInstance s = (ExportInstance)ins;
/* 228 */         if (this.broken) {
/* 229 */           for (int i = 0; i < this.orders.length; i++) {
/* 230 */             if (this.orders[i] != null) {
/* 231 */               MoveOrderPull p = new MoveOrderPull(this.orders[i].destCoo(), (RBIT)(this.orders[i]).resbits);
/* 232 */               s.orders[i] = p;
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/* 238 */         if (this.fetching != s.fetching())
/* 239 */           s.fetchingSet(this.fetching); 
/* 240 */         if (this.prio != s.prio()) {
/* 241 */           s.prioSet();
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
/*     */   public boolean searching() {
/* 253 */     if (employees().employed() > 0) {
/* 254 */       if (this.coolFetch < 0)
/* 255 */         return true;  byte b; int i; MoveOrderPull[] arrayOfMoveOrderPull;
/* 256 */       for (i = (arrayOfMoveOrderPull = this.orders).length, b = 0; b < i; ) { MoveOrderPull p = arrayOfMoveOrderPull[b];
/* 257 */         if (p != null && p.cooldown < 0)
/* 258 */           return true;  b++; }
/*     */     
/*     */     } 
/* 261 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public MoveOrderPull[] moveOrdersPull() {
/* 266 */     return this.orders;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveOrderPullAccepted() {
/* 271 */     return (resource() == null) ? RBIT.NONE : (resource()).bit;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveOrderPullAvailable() {
/* 276 */     return (destCrate(moveOrderPullAccepted(), 7, this.lastCX, this.lastCY) == null) ? RBIT.NONE : (resource()).bit;
/*     */   }
/*     */ 
/*     */   
/*     */   public int moveMinAmount() {
/* 281 */     return 7;
/*     */   }
/*     */ 
/*     */   
/*     */   public int moveMaxRadius() {
/* 286 */     return 200;
/*     */   }
/*     */ 
/*     */   
/*     */   public MoveJob moveJob(Humanoid skill) {
/* 291 */     if (resource() == null) {
/* 292 */       return null;
/*     */     }
/* 294 */     int am = (SETT.ROOMS()).STOCKPILE.carryCap(skill);
/*     */     
/* 296 */     boolean pr = this.prio;
/* 297 */     if (blueprintI().prioFetchAvailable(resource()) <= 0) {
/* 298 */       pr = false;
/*     */     }
/* 300 */     if (this.fetching && pr && this.coolFetch <= 0) {
/*     */       
/* 302 */       RBIT bb = (resource()).bit;
/*     */       
/* 304 */       MoveJob j = MoveJob.fetch(this, this, am, radius(), this.ox, this.oy, this.fetching ? bb : RBIT.NONE, pr ? bb : RBIT.NONE);
/*     */       
/* 306 */       if (j != null) {
/* 307 */         this.ox = (short)j.source.x();
/* 308 */         this.oy = (short)j.source.y();
/* 309 */         this.coolFetch = -1;
/* 310 */         return j;
/*     */       } 
/*     */       
/* 313 */       this.coolFetch = 4;
/*     */     } 
/*     */     
/* 316 */     for (int ooi = 0; ooi < this.orders.length; ooi++) {
/* 317 */       this.orderI = (byte)(this.orderI + 1);
/* 318 */       if (this.orderI >= this.orders.length)
/* 319 */         this.orderI = 0; 
/* 320 */       MoveOrderPull p = this.orders[this.orderI];
/* 321 */       if (p != null && p.cooldown <= 0) {
/* 322 */         MoveJob j = p.job(this, Math.min(am, 1), am);
/*     */         
/* 324 */         if (j != null) {
/* 325 */           p.cooldown = -1;
/* 326 */           return j;
/*     */         } 
/* 328 */         p.cooldown = 4;
/*     */       } 
/*     */     } 
/* 331 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public TILE_STORAGE destCrate(RBIT okMask, int minAm, int ox, int oy) {
/* 336 */     if (!okMask.has(destSpaceMask())) {
/* 337 */       return null;
/*     */     }
/* 339 */     if (is(this.lastCX, this.lastCY)) {
/* 340 */       Crate c = blueprintI().crate(this.lastCX, this.lastCY);
/* 341 */       if (c != null && c.storageReservable() >= minAm) {
/* 342 */         return c;
/*     */       }
/*     */     } 
/*     */     
/* 346 */     for (COORDINATE c : body()) {
/* 347 */       if (!is(c))
/*     */         continue; 
/* 349 */       Crate crate = blueprintI().crate(c.x(), c.y());
/* 350 */       if (crate != null && crate.storageReservable() >= minAm) {
/* 351 */         this.lastCX = (short)c.x();
/* 352 */         this.lastCY = (short)c.y();
/* 353 */         return crate;
/*     */       } 
/*     */     } 
/* 356 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public TILE_STORAGE storage(int tx, int ty) {
/* 361 */     return blueprintI().crate(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT destSpaceMask() {
/* 366 */     if (resource() == null)
/* 367 */       return RBIT.NONE; 
/* 368 */     if (this.crates * 500 - this.amount - this.spaceReserved <= 0)
/* 369 */       return RBIT.NONE; 
/* 370 */     return (resource()).bit;
/*     */   }
/*     */ 
/*     */   
/*     */   public double storedD(RESOURCE res) {
/* 375 */     return (this.crates * 500 - this.amount - this.spaceReserved) / (this.crates * 500);
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveCapacity() {
/* 380 */     return (resource() == null) ? RBIT.NONE : (resource()).bit;
/*     */   }
/*     */   
/*     */   public boolean fetching() {
/* 384 */     return this.fetching;
/*     */   }
/*     */   
/*     */   public void fetchingSet(boolean f) {
/* 388 */     this.fetching = f;
/* 389 */     this.coolFetch = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int radius() {
/* 394 */     return (this.radius + 10) * 8;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte radiusRaw() {
/* 399 */     return this.radius;
/*     */   }
/*     */ 
/*     */   
/*     */   public void radiusRawSet(byte r) {
/* 404 */     this.radius = r;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateTileDay(int tx, int ty) {
/* 409 */     if (resource() == null)
/*     */       return; 
/* 411 */     Crate c = blueprintI().crate(tx, ty);
/* 412 */     if (c == null)
/*     */       return; 
/* 414 */     int am = c.amount() - c.reserved();
/* 415 */     if (am <= 0)
/*     */       return; 
/* 417 */     if (am < 0) {
/*     */       return;
/*     */     }
/* 420 */     double d = am * resource().degradeSpeed() / TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 421 */     int i = (int)d;
/* 422 */     if (d - i > RND.rFloat())
/* 423 */       i++; 
/* 424 */     i = Math.min(am, i);
/* 425 */     if (i > 0) {
/* 426 */       c.amountSet(c.amount() - i);
/* 427 */       FACTIONS.player().res().inc(resource(), FResources.RTYPE.SPOILAGE, -i);
/*     */     } 
/*     */ 
/*     */     
/* 431 */     super.updateTileDay(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public void copyFrom(MoveOrderPull.MoveOrderPullInstance same) {
/* 436 */     ExportInstance ins = (ExportInstance)same;
/* 437 */     resourceSet(ins.resource());
/* 438 */     fetchingSet(ins.fetching());
/* 439 */     this.auto = ins.auto;
/* 440 */     this.prio = ins.prio;
/* 441 */     this.radius = ins.radius;
/* 442 */     employees().neededSet(ins.employees().target());
/*     */   }
/*     */   
/*     */   boolean prio() {
/* 446 */     return this.prio;
/*     */   }
/*     */   
/*     */   void prioSet() {
/* 450 */     this.prio = !this.prio;
/* 451 */     this.coolFetch = -1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\export\ExportInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */