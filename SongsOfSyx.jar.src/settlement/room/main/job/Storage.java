/*     */ package settlement.room.main.job;
/*     */ 
/*     */ import game.boosting.Boostable;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.Serializable;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.path.path.SPath;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ public abstract class Storage
/*     */   implements RESOURCE_TILE, TILE_STORAGE
/*     */ {
/*     */   static final int noRes = 0;
/*     */   private int tx;
/*     */   private int ty;
/*     */   private final int max;
/*     */   private StorageData data;
/*     */   
/*     */   protected Storage(int max) {
/*  27 */     this.max = max;
/*  28 */     if (RESOURCES.ALL().size() + 1 > 255) {
/*  29 */       throw new Errors.GameError("Too many resources are declared: " + RESOURCES.ALL().size());
/*     */     }
/*     */   }
/*     */   
/*     */   public StorageData[] make(ROOMA room) {
/*  34 */     int am = 0;
/*  35 */     for (COORDINATE c : room.body()) {
/*  36 */       if (room.is(c) && is(c.x(), c.y())) {
/*  37 */         (SETT.ROOMS()).data.set(room, c, am);
/*  38 */         am++;
/*     */       } 
/*     */     } 
/*  41 */     StorageData[] res = new StorageData[am];
/*  42 */     for (int i = 0; i < res.length; i++) {
/*  43 */       res[i] = new StorageData();
/*     */     }
/*  45 */     return res;
/*     */   }
/*     */   
/*     */   public Storage get(int tx, int ty, StorageData[] data) {
/*  49 */     if (is(tx, ty)) {
/*  50 */       int i = (SETT.ROOMS()).data.get(tx, ty);
/*  51 */       this.tx = tx;
/*  52 */       this.ty = ty;
/*  53 */       this.data = data[i];
/*  54 */       return this;
/*     */     } 
/*  56 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract boolean is(int paramInt1, int paramInt2);
/*     */   
/*     */   protected abstract int max();
/*     */   
/*     */   public void storageDeposit(int amount) {
/*  65 */     if (resource() == null || amount() + amount > this.max)
/*  66 */       throw new RuntimeException(String.valueOf(resource()) + " " + String.valueOf(resource()) + " " + amount() + " " + amount); 
/*  67 */     reservedSpaceSet(reservedSpace() - amount);
/*  68 */     amountSet(amount() + amount);
/*     */   }
/*     */ 
/*     */   
/*     */   public int storageReserved() {
/*  73 */     if (resource() == null)
/*  74 */       return 0; 
/*  75 */     return this.data.bReservedSpace;
/*     */   }
/*     */ 
/*     */   
/*     */   public int storageReservable() {
/*  80 */     if (resource() == null)
/*  81 */       return 0; 
/*  82 */     return this.max - amount() + storageReserved();
/*     */   }
/*     */ 
/*     */   
/*     */   public void storageReserve(int amount) {
/*  87 */     if (storageReservable() < amount) {
/*  88 */       throw new RuntimeException("" + storageReservable() + " " + storageReservable());
/*     */     }
/*  90 */     reservedSpaceSet(reservedSpace() + amount);
/*     */   }
/*     */ 
/*     */   
/*     */   public void storageUnreserve(int amount) {
/*  95 */     if (storageReserved() < amount)
/*  96 */       amount = storageReserved(); 
/*  97 */     reservedSpaceSet(storageReserved() - amount);
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE resource() {
/* 102 */     int i = this.data.res;
/* 103 */     if (i == 0)
/* 104 */       return null; 
/* 105 */     return (RESOURCE)RESOURCES.ALL().get(i - 1);
/*     */   }
/*     */   
/*     */   public void resourceSet(RESOURCE res) {
/* 109 */     if (resource() != null) {
/* 110 */       throw new RuntimeException();
/*     */     }
/* 112 */     this.data.res = (short)(res.index() + 1);
/* 113 */     add();
/*     */   }
/*     */   
/*     */   public void remove() {
/* 117 */     RESOURCE r = resource();
/* 118 */     if (r != null) {
/* 119 */       count(r.bIndex(), -1, -this.data.bAmount, -(this.data.bAmount - this.data.bReserved), -this.data.bReservedSpace);
/* 120 */       if (findableReservedCanBe())
/* 121 */         (SETT.PATH()).finders.resource.reportAbsence(this); 
/* 122 */       if (storageReservable() > 0)
/* 123 */         (SETT.PATH()).finders.storage.reportAbsence(this); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void add() {
/* 128 */     RESOURCE r = resource();
/* 129 */     if (r != null) {
/* 130 */       count(r.bIndex(), 1, this.data.bAmount, this.data.bAmount - this.data.bReserved, this.data.bReservedSpace);
/* 131 */       if (findableReservedCanBe()) {
/* 132 */         (SETT.PATH()).finders.resource.reportPresence(this);
/*     */       }
/* 134 */       if (storageReservable() > 0) {
/* 135 */         (SETT.PATH()).finders.storage.reportPresence(this);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract void count(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*     */   
/*     */   public int amount() {
/* 144 */     return this.data.bAmount;
/*     */   }
/*     */   
/*     */   public void amountSet(int am) {
/* 148 */     remove();
/* 149 */     this.data.bAmount = (short)am;
/* 150 */     add();
/*     */   }
/*     */   
/*     */   public int reserved() {
/* 154 */     return this.data.bReserved;
/*     */   }
/*     */   
/*     */   public void reservedSet(int r) {
/* 158 */     remove();
/* 159 */     this.data.bReserved = (short)r;
/* 160 */     add();
/*     */   }
/*     */   
/*     */   public int reservedSpace() {
/* 164 */     return this.data.bReservedSpace;
/*     */   }
/*     */   
/*     */   private void reservedSpaceSet(int r) {
/* 168 */     remove();
/* 169 */     this.data.bReservedSpace = (short)r;
/* 170 */     add();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/* 175 */     return this.ty;
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/* 180 */     return this.tx;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/* 185 */     return (this.data.bReserved > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/* 190 */     return (this.data.bReserved < this.data.bAmount);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 195 */     if (reserved() > 0) {
/* 196 */       reservedSet(reserved() - 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public void findableReserve() {
/* 201 */     reservedSet(reserved() + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void resourcePickup() {
/* 206 */     findableReserveCancel();
/* 207 */     amountSet(amount() - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int reservable() {
/* 212 */     return amount() - reserved();
/*     */   }
/*     */   
/*     */   public void clear() {
/* 216 */     if (resource() == null)
/*     */       return; 
/* 218 */     int am = amount();
/* 219 */     remove();
/* 220 */     if (am > 0) {
/* 221 */       for (DIR dd : DIR.ORTHO) {
/* 222 */         if (!(SETT.PATH()).solidity.is((COORDINATE)this, dd)) {
/* 223 */           (SETT.THINGS()).resources.create(x() + dd.x(), y() + dd.y(), resource(), am);
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 228 */     this.data.res = 0;
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 232 */     RESOURCE res = resource();
/* 233 */     if (res == null)
/*     */       return; 
/* 235 */     int am = amount();
/* 236 */     remove();
/* 237 */     if (am > 0) {
/* 238 */       (SETT.THINGS()).resources.create(this.tx, this.ty, res, am);
/*     */     }
/* 240 */     this.data.res = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFindable() {
/* 245 */     return true;
/*     */   }
/*     */   
/*     */   public static interface STORAGE_CRATE_HASSER {
/*     */     TILE_STORAGE job(COORDINATE param1COORDINATE, SPath param1SPath);
/*     */     
/*     */     TILE_STORAGE job(int param1Int1, int param1Int2);
/*     */     
/*     */     boolean getsMaximum(RESOURCE param1RESOURCE);
/*     */     
/*     */     default boolean fetchesFromEveryone(RESOURCE res) {
/* 256 */       return false;
/*     */     }
/*     */     
/*     */     Boostable carryBonus();
/*     */   }
/*     */   
/*     */   public class StorageData implements Serializable {
/*     */     private static final long serialVersionUID = 1L;
/*     */     short res;
/*     */     short bAmount;
/*     */     short bReserved;
/*     */     short bReservedSpace;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\job\Storage.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */