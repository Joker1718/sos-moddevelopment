/*     */ package settlement.room.main.job;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.Serializable;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ public abstract class StorageCrate
/*     */   implements RESOURCE_TILE, TILE_STORAGE
/*     */ {
/*     */   static final int noRes = 0;
/*     */   private int tx;
/*     */   private int ty;
/*     */   private StorageData data;
/*     */   private RoomInstance ins;
/*     */   
/*     */   protected StorageCrate() {
/*  26 */     if (RESOURCES.ALL().size() + 1 > 255) {
/*  27 */       throw new Errors.GameError("Too many resources are declared: " + RESOURCES.ALL().size());
/*     */     }
/*     */   }
/*     */   
/*     */   public StorageData[] make(ROOMA room) {
/*  32 */     int am = 0;
/*  33 */     for (COORDINATE c : room.body()) {
/*  34 */       if (room.is(c) && is(c.x(), c.y())) {
/*  35 */         (SETT.ROOMS()).data.set(room, c, am);
/*  36 */         am++;
/*     */       } 
/*     */     } 
/*  39 */     StorageData[] res = new StorageData[am];
/*  40 */     for (int i = 0; i < res.length; i++) {
/*  41 */       res[i] = new StorageData();
/*     */     }
/*  43 */     return res;
/*     */   }
/*     */   
/*     */   public StorageCrate get(int tx, int ty, RoomInstance ins, StorageData[] data) {
/*  47 */     if (is(tx, ty)) {
/*  48 */       int i = (SETT.ROOMS()).data.get(tx, ty);
/*  49 */       this.tx = tx;
/*  50 */       this.ty = ty;
/*  51 */       this.data = data[i];
/*  52 */       this.ins = ins;
/*  53 */       return this;
/*     */     } 
/*  55 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract boolean is(int paramInt1, int paramInt2);
/*     */   
/*     */   protected abstract int max(RoomInstance paramRoomInstance);
/*     */   
/*     */   public void storageDeposit(int amount) {
/*  64 */     if (amount == 0)
/*     */       return; 
/*  66 */     if (resource() == null || amount() + amount > max(this.ins))
/*  67 */       throw new RuntimeException(String.valueOf(resource()) + " " + String.valueOf(resource()) + " " + amount() + " " + amount); 
/*  68 */     reservedSpaceSet(reservedSpace() - amount);
/*  69 */     amountSet(amount() + amount);
/*     */   }
/*     */ 
/*     */   
/*     */   public int storageReserved() {
/*  74 */     if (resource() == null)
/*  75 */       return 0; 
/*  76 */     return this.data.bReservedSpace;
/*     */   }
/*     */ 
/*     */   
/*     */   public int storageReservable() {
/*  81 */     if (resource() == null)
/*  82 */       return 0; 
/*  83 */     return max(this.ins) - amount() + storageReserved();
/*     */   }
/*     */ 
/*     */   
/*     */   public void storageReserve(int amount) {
/*  88 */     if (storageReservable() < amount) {
/*  89 */       throw new RuntimeException("" + storageReservable() + " " + storageReservable());
/*     */     }
/*  91 */     reservedSpaceSet(reservedSpace() + amount);
/*     */   }
/*     */ 
/*     */   
/*     */   public void storageUnreserve(int amount) {
/*  96 */     if (storageReserved() < amount)
/*  97 */       amount = storageReserved(); 
/*  98 */     reservedSpaceSet(storageReserved() - amount);
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE resource() {
/* 103 */     int i = this.data.res;
/* 104 */     if (i == 0 || i > RESOURCES.ALL().size())
/* 105 */       return null; 
/* 106 */     return (RESOURCE)RESOURCES.ALL().get(i - 1);
/*     */   }
/*     */   
/*     */   public void resourceSet(RESOURCE res) {
/* 110 */     if (resource() != null) {
/* 111 */       throw new RuntimeException();
/*     */     }
/* 113 */     this.data.res = (short)(res.index() + 1);
/* 114 */     add();
/*     */   }
/*     */   
/*     */   public int amount(int tx, int ty, RoomInstance ins, StorageData[] data) {
/* 118 */     if (is(tx, ty)) {
/* 119 */       int i = (SETT.ROOMS()).data.get(tx, ty);
/* 120 */       return (data[i]).bAmount;
/*     */     } 
/* 122 */     return 0;
/*     */   }
/*     */   
/*     */   public RESOURCE res(int tx, int ty, RoomInstance ins, StorageData[] data) {
/* 126 */     if (is(tx, ty)) {
/* 127 */       int i = (SETT.ROOMS()).data.get(tx, ty);
/* 128 */       i = (data[i]).res;
/* 129 */       if (i == 0 || i > RESOURCES.ALL().size())
/* 130 */         return null; 
/* 131 */       return (RESOURCE)RESOURCES.ALL().get(i - 1);
/*     */     } 
/* 133 */     return null;
/*     */   }
/*     */   
/*     */   public void remove() {
/* 137 */     RESOURCE r = resource();
/* 138 */     if (r != null) {
/* 139 */       count(-1);
/* 140 */       if (findableReservedCanBe())
/* 141 */         (SETT.PATH()).finders.resource.reportAbsence(this); 
/* 142 */       if (storageReservable() > 0) {
/* 143 */         (SETT.PATH()).finders.storage.reportAbsence(this);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void add() {
/* 159 */     RESOURCE r = resource();
/* 160 */     if (r != null) {
/* 161 */       count(1);
/* 162 */       if (findableReservedCanBe()) {
/* 163 */         (SETT.PATH()).finders.resource.reportPresence(this);
/*     */       }
/* 165 */       if (storageReservable() > 0) {
/* 166 */         (SETT.PATH()).finders.storage.reportPresence(this);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract void count(int paramInt);
/*     */   
/*     */   public int amount() {
/* 175 */     return this.data.bAmount;
/*     */   }
/*     */   
/*     */   public void amountSet(int am) {
/* 179 */     remove();
/* 180 */     this.data.bAmount = (short)am;
/* 181 */     add();
/*     */   }
/*     */   
/*     */   public int reserved() {
/* 185 */     return this.data.bReserved;
/*     */   }
/*     */   
/*     */   public void reservedSet(int r) {
/* 189 */     remove();
/* 190 */     this.data.bReserved = (short)r;
/* 191 */     add();
/*     */   }
/*     */   
/*     */   public int reservedSpace() {
/* 195 */     return this.data.bReservedSpace;
/*     */   }
/*     */   
/*     */   private void reservedSpaceSet(int r) {
/* 199 */     remove();
/* 200 */     this.data.bReservedSpace = (short)r;
/* 201 */     add();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/* 206 */     return this.ty;
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/* 211 */     return this.tx;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 216 */     return (this.data.bReserved > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/* 221 */     return (this.data.bReserved < this.data.bAmount);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 226 */     if (reserved() > 0) {
/* 227 */       reservedSet(reserved() - 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public void findableReserve() {
/* 232 */     reservedSet(reserved() + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void resourcePickup() {
/* 237 */     findableReserveCancel();
/* 238 */     amountSet(amount() - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int reservable() {
/* 243 */     return amount() - reserved();
/*     */   }
/*     */ 
/*     */   
/*     */   public double spoilRate() {
/* 248 */     return spoilRate(this.ins);
/*     */   }
/*     */   
/*     */   protected abstract double spoilRate(RoomInstance paramRoomInstance);
/*     */   
/*     */   public void clear() {
/* 254 */     if (resource() == null)
/*     */       return; 
/* 256 */     int am = amount();
/* 257 */     remove();
/* 258 */     if (am > 0) {
/* 259 */       for (DIR dd : DIR.ORTHO) {
/* 260 */         if (!(SETT.PATH()).solidity.is((COORDINATE)this, dd)) {
/* 261 */           (SETT.THINGS()).resources.create(x() + dd.x(), y() + dd.y(), resource(), am);
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 266 */     this.data.bAmount = 0;
/* 267 */     this.data.bReserved = 0;
/* 268 */     this.data.bReservedSpace = 0;
/* 269 */     this.data.res = 0;
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 273 */     RESOURCE res = resource();
/* 274 */     if (res == null)
/*     */       return; 
/* 276 */     int am = amount();
/* 277 */     remove();
/*     */     
/* 279 */     for (DIR d : DIR.ORTHO) {
/* 280 */       if (SETT.IN_BOUNDS(this.tx, this.ty, d) && !(SETT.PATH()).solidity.is(this.tx, this.ty, d)) {
/* 281 */         (SETT.THINGS()).resources.create(this.tx + d.x(), this.ty + d.y(), res, am);
/* 282 */         am = 0;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 287 */     if (am > 0)
/* 288 */       (SETT.THINGS()).resources.create(this.tx, this.ty, res, am); 
/* 289 */     this.data.bAmount = 0;
/* 290 */     this.data.bReserved = 0;
/* 291 */     this.data.bReservedSpace = 0;
/* 292 */     this.data.res = 0;
/*     */   }
/*     */   
/*     */   public void disposeSilent() {
/* 296 */     this.data.bAmount = 0;
/* 297 */     this.data.bReserved = 0;
/* 298 */     this.data.bReservedSpace = 0;
/* 299 */     this.data.res = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFindable() {
/* 304 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class StorageData
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     short res;
/*     */     
/*     */     short bAmount;
/*     */     
/*     */     short bReserved;
/*     */     
/*     */     short bReservedSpace;
/*     */ 
/*     */     
/*     */     public void clear() {
/* 323 */       this.res = 0;
/* 324 */       this.bAmount = 0;
/* 325 */       this.bReserved = 0;
/* 326 */       this.bReservedSpace = 0;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\job\StorageCrate.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */