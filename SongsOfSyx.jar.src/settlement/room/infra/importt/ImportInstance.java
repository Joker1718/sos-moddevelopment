/*     */ package settlement.room.infra.importt;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.infra.logistics.MoveJob;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.job.StorageCrate;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import snake2d.LOG;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ public final class ImportInstance
/*     */   extends RoomInstance
/*     */   implements MoveJob.ROOM_MOVE_SOURCE
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   static final int crateMax = 600;
/*     */   private int amount;
/*     */   private int spaceReserved;
/*     */   private int amountReserved;
/*  33 */   private byte resource = -1;
/*     */   
/*     */   final StorageCrate.StorageData[] sdata;
/*     */   
/*     */   ImportInstance(ROOM_IMPORT p, TmpArea area, RoomInit init) {
/*  38 */     super(p, area, init);
/*  39 */     this.sdata = p.crate.make((ROOMA)this);
/*  40 */     activate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFix() {
/*  47 */     if (this.resource != -1 && RESOURCES.map().loader().get(this.resource) == null) {
/*  48 */       for (COORDINATE c : body()) {
/*  49 */         if (is(c) && (blueprintI()).crate.get(c.x(), c.y(), this, this.sdata) != null) {
/*  50 */           (blueprintI()).crate.disposeSilent();
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  60 */     it.lit();
/*  61 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */   
/*     */   public int amount() {
/*  65 */     return this.amount;
/*     */   }
/*     */   
/*     */   public int amoutReserved() {
/*  69 */     return this.amountReserved;
/*     */   }
/*     */   
/*     */   public int spaceReserved() {
/*  73 */     return this.spaceReserved;
/*     */   }
/*     */   
/*     */   public int capacity() {
/*  77 */     return this.sdata.length * 600;
/*     */   }
/*     */ 
/*     */   
/*     */   void count(Crate c, int delta) {
/*  82 */     this.amount += delta * c.amount();
/*  83 */     this.amountReserved += delta * c.reserved();
/*  84 */     this.spaceReserved += delta * c.reservedSpace();
/*  85 */     (blueprintI()).tally.count(c.resource(), delta * c.amount(), delta * c.max(this));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  93 */     for (COORDINATE c : body()) {
/*  94 */       if (is(c) && (blueprintI()).crate.get(c.x(), c.y(), this, this.sdata) != null) {
/*  95 */         (blueprintI()).crate.dispose();
/*     */       }
/*     */     } 
/*  98 */     this.amount = 0;
/*  99 */     this.spaceReserved = 0;
/* 100 */     this.amountReserved = 0;
/* 101 */     this.resource = -1;
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
/*     */   public ROOM_IMPORT blueprintI() {
/* 117 */     return (SETT.ROOMS()).IMPORT;
/*     */   }
/*     */ 
/*     */   
/*     */   void allocate(RESOURCE res) {
/* 122 */     if (res == resource())
/*     */       return; 
/* 124 */     dispose();
/*     */     
/* 126 */     this.resource = (res == null) ? -1 : res.bIndex();
/* 127 */     if (res != null) {
/* 128 */       for (COORDINATE c : body()) {
/* 129 */         if ((blueprintI()).crate.get(c.x(), c.y(), this, this.sdata) != null) {
/* 130 */           (blueprintI()).crate.resourceSet(res);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE resourceTile(int tx, int ty) {
/* 139 */     return (RESOURCE_TILE)(blueprintI()).crate.get(tx, ty, this, this.sdata);
/*     */   }
/*     */ 
/*     */   
/*     */   public TILE_STORAGE storage(int tx, int ty) {
/* 144 */     return (TILE_STORAGE)(blueprintI()).crate.get(tx, ty, this, this.sdata);
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE resource() {
/* 149 */     if (this.resource < 0 || this.resource >= RESOURCES.ALL().size())
/* 150 */       return null; 
/* 151 */     return (RESOURCE)RESOURCES.ALL().get(this.resource);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomState makeState(int tx, int ty, boolean broken) {
/* 156 */     return (RoomState)new State(this);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class State
/*     */     extends RoomState.RoomStateInstance
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private final int ri;
/*     */     
/*     */     public State(ImportInstance ins) {
/* 168 */       super(ins);
/* 169 */       this.ri = ins.resource;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void applyIns(RoomInstance ins) {
/* 174 */       super.applyIns(ins);
/* 175 */       if (this.ri != -1) {
/* 176 */         ((ImportInstance)ins).allocate((RESOURCE)RESOURCES.ALL().get(this.ri));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE sourceCrate(RBIT okMask, int minAmount, int ox, int oy, double lim) {
/* 185 */     if (resource() == null || sourceAmountMask().isClear()) {
/* 186 */       return null;
/*     */     }
/* 188 */     if (!okMask.has(resource())) {
/* 189 */       return null;
/*     */     }
/* 191 */     if (lim > storedD(resource())) {
/* 192 */       return null;
/*     */     }
/* 194 */     double am = (amount() - amoutReserved() - minAmount);
/* 195 */     if (am <= 0.0D) {
/* 196 */       return null;
/*     */     }
/*     */     
/* 199 */     if (is(ox, oy)) {
/* 200 */       StorageCrate storageCrate = (blueprintI()).crate.get(ox, oy, this, this.sdata);
/* 201 */       if (storageCrate != null && storageCrate.reservable() >= minAmount)
/* 202 */         return (RESOURCE_TILE)storageCrate; 
/*     */     } 
/* 204 */     for (COORDINATE c : body()) {
/* 205 */       StorageCrate s = (blueprintI()).crate.get(c.x(), c.y(), this, this.sdata);
/* 206 */       if (s != null && s.reservable() >= minAmount) {
/* 207 */         return (RESOURCE_TILE)s;
/*     */       }
/*     */     } 
/* 210 */     if (minAmount == 1) {
/* 211 */       LOG.ln("Weird indeed");
/*     */     }
/*     */     
/* 214 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT sourceAmountMask() {
/* 219 */     if (amount() - amoutReserved() > 0)
/* 220 */       return moveCapacity(); 
/* 221 */     return RBIT.NONE;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT moveCapacity() {
/* 226 */     return (resource() == null) ? RBIT.NONE : (resource()).bit;
/*     */   }
/*     */ 
/*     */   
/*     */   public int moveCapacityAm(RESOURCE res) {
/* 231 */     if (resource() == res) {
/* 232 */       return capacity();
/*     */     }
/* 234 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public double storedD(RESOURCE res) {
/* 239 */     if (res == resource())
/* 240 */       return (amount() - amoutReserved()) / capacity(); 
/* 241 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\importt\ImportInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */