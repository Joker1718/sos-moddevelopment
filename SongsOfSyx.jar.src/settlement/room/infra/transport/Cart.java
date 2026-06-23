/*     */ package settlement.room.infra.transport;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.Serializable;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.infra.logistics.MoveOrderPull;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Cart
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  20 */   public static final int PREPARATION_TIME = (int)TIME.workSeconds();
/*     */   
/*     */   private short delivering;
/*     */   
/*  24 */   private short resource = -1;
/*     */   
/*     */   private short loaded;
/*     */   
/*     */   private short unloaded;
/*     */   
/*     */   private short unloadedSpots;
/*     */   
/*     */   private double preparation;
/*     */   
/*     */   public int stored() {
/*  35 */     return this.loaded;
/*     */   }
/*     */   
/*     */   public void store(int am) {
/*  39 */     this.loaded = (short)(this.loaded + am);
/*     */   }
/*     */   
/*     */   void unloadedInc(int am) {
/*  43 */     this.unloaded = (short)(this.unloaded + am);
/*     */   }
/*     */   
/*     */   public boolean needsPrep() {
/*  47 */     return (this.preparation < PREPARATION_TIME);
/*     */   }
/*     */   
/*     */   public double prepD() {
/*  51 */     return this.preparation / PREPARATION_TIME;
/*     */   }
/*     */   
/*     */   public void prep(double time) {
/*  55 */     this.preparation += time;
/*     */   }
/*     */   
/*     */   public int unloaded() {
/*  59 */     return this.unloaded;
/*     */   }
/*     */   void unloadedSpotsInc(int am) {
/*  62 */     this.unloadedSpots = (short)(this.unloadedSpots + am);
/*     */   }
/*     */   
/*     */   int unloadedSpots() {
/*  66 */     return this.unloadedSpots;
/*     */   }
/*     */   
/*     */   public RESOURCE resource() {
/*  70 */     if (this.resource == -1)
/*  71 */       return null; 
/*  72 */     return (RESOURCE)RESOURCES.ALL().get(this.resource);
/*     */   }
/*     */   
/*     */   protected void loadFix() {
/*  76 */     this.resource = (byte)RESOURCES.map().loader().fix(this.resource, -1);
/*     */   }
/*     */   
/*     */   void empty() {
/*  80 */     this.loaded = 0;
/*     */   }
/*     */   
/*     */   void clear() {
/*  84 */     empty();
/*     */   }
/*     */   
/*     */   void coco() {
/*  88 */     this.preparation -= PREPARATION_TIME;
/*  89 */     if (this.preparation < 0.0D)
/*  90 */       this.preparation = 0.0D; 
/*     */   }
/*     */   
/*     */   void go() {
/*  94 */     this.delivering = (short)(this.delivering + this.loaded);
/*  95 */     clear();
/*  96 */     coco();
/*     */   }
/*     */ 
/*     */   
/*     */   void deliver(int am) {
/* 101 */     this.delivering = (short)(this.delivering - am);
/*     */   }
/*     */   
/*     */   public int delivering() {
/* 105 */     return this.delivering;
/*     */   }
/*     */   
/*     */   public void deliverIncrease(int am) {
/* 109 */     this.delivering = (short)(this.delivering + am);
/*     */   }
/*     */ 
/*     */   
/*     */   public void resourceSet(RESOURCE res, TransportInstance ins) {
/* 114 */     RESOURCE old = resource();
/* 115 */     if (old == res) {
/*     */       return;
/*     */     }
/* 118 */     int am = stored();
/*     */     
/* 120 */     empty();
/* 121 */     this.preparation = 0.0D;
/* 122 */     (ins.blueprintI()).job.remove(ins);
/* 123 */     this.resource = (res == null) ? -1 : (short)res.index();
/* 124 */     (ins.blueprintI()).job.add(ins); byte b; int i; MoveOrderPull[] arrayOfMoveOrderPull;
/* 125 */     for (i = (arrayOfMoveOrderPull = ins.pullOrders).length, b = 0; b < i; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/* 126 */       if (o != null)
/* 127 */         o.resbits.clearSet(ins.moveCapacity()); 
/*     */       b++; }
/*     */     
/* 130 */     if (old != null && am > 0) {
/* 131 */       for (COORDINATE c : ins.body()) {
/* 132 */         if (ins.is(c) && (SETT.PATH()).availability.get(c) == AVAILABILITY.ROOM) {
/* 133 */           (SETT.THINGS()).resources.create(c, old, am);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canGo() {
/* 142 */     if (resource() == null)
/* 143 */       return false; 
/* 144 */     if (this.preparation < PREPARATION_TIME)
/* 145 */       return false; 
/* 146 */     if (this.loaded >= 400)
/* 147 */       return true; 
/* 148 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean cartVisible() {
/* 153 */     return !(this.preparation < PREPARATION_TIME && this.loaded <= 0);
/*     */   }
/*     */   
/*     */   public boolean oxVisible() {
/* 157 */     return (this.preparation >= PREPARATION_TIME);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\transport\Cart.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */