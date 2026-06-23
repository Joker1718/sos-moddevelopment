/*     */ package settlement.room.infra.export;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.bit.Bits;
/*     */ 
/*     */ final class Crate
/*     */   implements TILE_STORAGE {
/*  11 */   private final Bits bAmount = new Bits(1023);
/*  12 */   private final Bits bReserved = new Bits(1047552);
/*  13 */   private final Bits bReservedSpace = new Bits(1072693248);
/*     */   
/*     */   protected final ROOM_EXPORT b;
/*     */   int tx;
/*     */   
/*     */   Crate(ROOM_EXPORT b) {
/*  19 */     this.b = b;
/*     */   }
/*     */   int ty; ExportInstance ins;
/*     */   Crate get(int tx, int ty) {
/*  23 */     if (this.b.is(tx, ty)) {
/*  24 */       this.ins = (ExportInstance)this.b.getter.get(tx, ty);
/*  25 */       if (this.b.constructor.isCrate(tx, ty)) {
/*  26 */         this.tx = tx;
/*  27 */         this.ty = ty;
/*  28 */         return this;
/*     */       } 
/*     */     } 
/*  31 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE resource() {
/*  36 */     return this.ins.resource();
/*     */   }
/*     */   
/*     */   public int amount(int data) {
/*  40 */     return this.bAmount.get(data);
/*     */   }
/*     */   
/*     */   private void remove() {
/*  44 */     RESOURCE r = resource();
/*  45 */     if (r != null) {
/*  46 */       this.b.tally.inc(r, -this.ins.amount, -500 * this.ins.crates);
/*  47 */       this.ins.amount -= amount();
/*  48 */       this.ins.amountReserved -= reserved();
/*  49 */       this.ins.spaceReserved -= storageReserved();
/*  50 */       this.b.tally.inc(r, this.ins.amount, 500 * this.ins.crates);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void add() {
/*  55 */     RESOURCE r = resource();
/*  56 */     if (r != null) {
/*  57 */       this.b.tally.inc(r, -this.ins.amount, -500 * this.ins.crates);
/*  58 */       this.ins.amount += amount();
/*  59 */       this.ins.amountReserved += reserved();
/*  60 */       this.ins.spaceReserved += storageReserved();
/*  61 */       this.b.tally.inc(r, this.ins.amount, 500 * this.ins.crates);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int amount() {
/*  66 */     return this.bAmount.get(data());
/*     */   }
/*     */   
/*     */   public void amountSet(int am) {
/*  70 */     remove();
/*  71 */     int d = this.bAmount.set(data(), am);
/*  72 */     save(d);
/*  73 */     add();
/*     */   }
/*     */   
/*     */   public int reserved() {
/*  77 */     return this.bReserved.get(data());
/*     */   }
/*     */   
/*     */   public void reservedSet(int r) {
/*  81 */     remove();
/*  82 */     int d = this.bReserved.set(data(), r);
/*  83 */     save(d);
/*  84 */     add();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int data() {
/*  90 */     return (SETT.ROOMS()).data.get(this.tx, this.ty);
/*     */   }
/*     */   
/*     */   private void save(int d) {
/*  94 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, this.tx, this.ty, d);
/*     */   }
/*     */   
/*     */   void clear() {
/*  98 */     if (resource() == null)
/*     */       return; 
/* 100 */     remove();
/* 101 */     save(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int x() {
/* 107 */     return this.tx;
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/* 112 */     return this.ty;
/*     */   }
/*     */ 
/*     */   
/*     */   public void storageDeposit(int amount) {
/* 117 */     remove();
/* 118 */     int d = this.bReservedSpace.inc(data(), -amount);
/* 119 */     d = this.bAmount.inc(d, amount);
/* 120 */     save(d);
/* 121 */     add();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int storageReservable() {
/* 127 */     return 500 - this.bAmount.get(data()) - this.bReservedSpace.get(data());
/*     */   }
/*     */ 
/*     */   
/*     */   public int storageReserved() {
/* 132 */     return this.bReservedSpace.get(data());
/*     */   }
/*     */ 
/*     */   
/*     */   public void storageReserve(int amount) {
/* 137 */     remove();
/* 138 */     int d = this.bReservedSpace.inc(data(), amount);
/* 139 */     save(d);
/* 140 */     add();
/*     */   }
/*     */ 
/*     */   
/*     */   public void storageUnreserve(int amount) {
/* 145 */     remove();
/* 146 */     int d = this.bReservedSpace.inc(data(), -amount);
/* 147 */     save(d);
/* 148 */     add();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean storageIsFindable() {
/* 153 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\export\Crate.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */