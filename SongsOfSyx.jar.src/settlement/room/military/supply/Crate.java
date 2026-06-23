/*     */ package settlement.room.military.supply;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import world.army.AD;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Crate
/*     */ {
/*     */   private static final int noRes = 0;
/*  27 */   private final Coo coo = new Coo();
/*  28 */   private final RoomBits bRes = new BB(new Bits(255));
/*  29 */   private final RoomBits bAmount = new BB(new Bits(65280));
/*  30 */   private final RoomBits bReservedSpace = new BB(new Bits(16711680));
/*  31 */   private final RoomBits bTot = new BB(new Bits(16777215));
/*  32 */   private final RoomBits bAnimals = new RoomBits((COORDINATE)this.coo, new Bits(117440512));
/*  33 */   private final RoomBits bAnimalsRes = new RoomBits((COORDINATE)this.coo, new Bits(134217728));
/*  34 */   private final RoomBits bAway = new BB(new Bits(268435456));
/*     */   
/*  36 */   private final RoomBits bState = new RoomBits((COORDINATE)this.coo, new Bits(-1073741824));
/*     */   
/*     */   private final ROOM_SUPPLY b;
/*     */   
/*     */   private SupplyInstance ins;
/*     */   
/*     */   public final TILE_STORAGE crate;
/*     */   public final SETT_JOB job;
/*     */   
/*     */   public Crate get(int tx, int ty) {
/*  46 */     if (this.b.is(tx, ty) && (SETT.ROOMS()).fData.tileData.get(tx, ty) == 1) {
/*  47 */       this.coo.set(tx, ty);
/*  48 */       this.ins = (SupplyInstance)this.b.getter.get(tx, ty);
/*  49 */       return this;
/*     */     } 
/*  51 */     return null;
/*     */   }
/*     */   
/*     */   public TILE_STORAGE storage(int tx, int ty) {
/*  55 */     if (get(tx, ty) != null)
/*  56 */       return storage(); 
/*  57 */     return null;
/*     */   }
/*     */   
/*     */   public TILE_STORAGE storage() {
/*  61 */     if (this.bAway.get() == 0) {
/*  62 */       return this.crate;
/*     */     }
/*  64 */     return null;
/*     */   }
/*     */   
/*     */   public SETT_JOB job() {
/*  68 */     return this.job;
/*     */   }
/*     */   
/*     */   public boolean away() {
/*  72 */     return (this.bAway.get() == 1);
/*     */   }
/*     */   
/*     */   public boolean animalHas() {
/*  76 */     return (this.bAnimals.get() != 0);
/*     */   }
/*     */   
/*     */   public int resAmount() {
/*  80 */     return this.bAmount.get();
/*     */   }
/*     */   
/*     */   public int goIsReady() {
/*  84 */     if (SETT.ENTRY().isClosed())
/*  85 */       return 1; 
/*  86 */     if (this.bRes.get() == 0)
/*  87 */       return 2; 
/*  88 */     if (this.bAnimals.get() <= 0)
/*  89 */       return 3; 
/*  90 */     if (this.bAway.get() == 1)
/*  91 */       return 4; 
/*  92 */     if (this.b.cache.deliverable(this.crate.resource()) <= 0)
/*  93 */       return 6; 
/*  94 */     if (this.bAmount.get() == 0)
/*  95 */       return 7; 
/*  96 */     if (this.bReservedSpace.get() != 0) {
/*  97 */       return 8;
/*     */     }
/*     */     
/* 100 */     return 0;
/*     */   }
/*     */   
/*     */   public void deliver() {
/* 104 */     if (goIsReady() != 0) {
/*     */       return;
/*     */     }
/*     */     
/* 108 */     if (this.bAmount.get() >= 80 || this.bState.get() >= this.bState.max())
/*     */     {
/*     */ 
/*     */       
/* 112 */       this.bState.set((ROOMA)this.ins, 0);
/*     */     }
/* 114 */     RESOURCE res = this.crate.resource();
/* 115 */     int am = this.bAmount.get();
/* 116 */     int n = this.b.cache.needed(res);
/* 117 */     if (am > n) {
/* 118 */       vacate(am - n);
/* 119 */       am = n;
/*     */     } 
/* 121 */     if (am <= 0) {
/*     */       return;
/*     */     }
/* 124 */     am = this.b.cache.deliver(res, am);
/* 125 */     FACTIONS.player().res().inc(res, FResources.RTYPE.ARMY_SUPPLY, -am);
/* 126 */     this.bAmount.inc((ROOMA)this.ins, -am);
/* 127 */     if (am <= 0)
/*     */       return; 
/* 129 */     this.bAway.set((ROOMA)this.ins, 1);
/*     */     
/* 131 */     this.ins.liveCount = (byte)(this.ins.liveCount + 1); if (this.ins.liveCount > 10) {
/* 132 */       this.ins.liveCount = 0;
/* 133 */       this.bAnimals.inc((ROOMA)this.ins, -1);
/*     */     } 
/*     */     
/* 136 */     DIR dir = (DIR)DIR.ORTHO.get(((FurnisherItem)(SETT.ROOMS()).fData.item.get((COORDINATE)this.coo)).rotation);
/* 137 */     byte ran = (byte)SETT.tileRan(this.coo.x(), this.coo.y());
/* 138 */     int tx = this.coo.x();
/* 139 */     int ty = this.coo.y();
/* 140 */     (SETT.HALFENTS()).transports.military(this.coo.x() + dir.x() * 2, this.coo.y() + dir.y() * 2, ran, res, am, dir);
/* 141 */     get(tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void resourceSet(RESOURCE res) {
/* 147 */     this.b.tally.report(this, this.ins, -1);
/* 148 */     this.bTot.set(this.coo.x(), this.coo.y(), (ROOMA)this.ins, 0);
/* 149 */     this.bRes.set(this.coo.x(), this.coo.y(), (ROOMA)this.ins, (res == null) ? 0 : (res.index() + 1));
/* 150 */     this.b.tally.report(this, this.ins, 1);
/*     */   }
/*     */   
/*     */   public RESOURCE realResource() {
/* 154 */     RESOURCE res = this.crate.resource();
/* 155 */     int i = this.bRes.get();
/* 156 */     if (i == 0)
/* 157 */       return null; 
/* 158 */     if (this.bReservedSpace.get() != 0)
/* 159 */       return res; 
/* 160 */     if (this.bAmount.get() != 0)
/* 161 */       return res; 
/* 162 */     return null;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 166 */     if (this.crate.resource() == null) {
/*     */       return;
/*     */     }
/*     */     
/* 170 */     int am = resAmount();
/* 171 */     vacate(am);
/* 172 */     resourceSet(null);
/*     */   }
/*     */   
/*     */   private void vacate(int am) {
/* 176 */     if (am > 0) {
/* 177 */       for (DIR dd : DIR.ORTHO) {
/* 178 */         if (!(SETT.PATH()).solidity.is((COORDINATE)this.coo, dd)) {
/* 179 */           (SETT.THINGS()).resources.create(this.coo.x() + dd.x(), this.coo.y() + dd.y(), this.crate.resource(), am);
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 187 */     RESOURCE res = this.crate.resource();
/* 188 */     if (res == null)
/*     */       return; 
/* 190 */     int am = resAmount();
/*     */     
/* 192 */     if (am > 0)
/* 193 */       (SETT.THINGS()).resources.create((COORDINATE)this.coo, res, am); 
/* 194 */     this.b.tally.report(this, this.ins, -1);
/*     */   }
/*     */   protected Crate(ROOM_SUPPLY b) {
/* 197 */     this.crate = new TILE_STORAGE()
/*     */       {
/*     */         
/*     */         public int y()
/*     */         {
/* 202 */           return Crate.this.coo.y();
/*     */         }
/*     */ 
/*     */         
/*     */         public int x() {
/* 207 */           return Crate.this.coo.x();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean storageIsFindable() {
/* 212 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void storageDeposit(int amount) {
/* 220 */           if (Crate.this.resAmount() + amount > 80) {
/* 221 */             throw new RuntimeException(String.valueOf(resource()) + " " + String.valueOf(resource()) + " " + Crate.this.resAmount() + " 80");
/*     */           }
/* 223 */           Crate.this.bReservedSpace.inc((ROOMA)Crate.this.ins, -amount);
/* 224 */           Crate.this.bAmount.inc((ROOMA)Crate.this.ins, amount);
/* 225 */           if (Crate.this.bAmount.get() >= 80)
/* 226 */             Crate.this.deliver(); 
/* 227 */           Crate.this.ins.jobs.searchAgain();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public int storageReserved() {
/* 233 */           return Crate.this.bReservedSpace.get();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public int storageReservable() {
/* 239 */           int am = 80 - Crate.this.resAmount() - storageReserved();
/* 240 */           if (resource() == null)
/* 241 */             return am; 
/* 242 */           int m = Crate.this.b.tally.fetchAmount(resource());
/* 243 */           return Math.min(am, m);
/*     */         }
/*     */ 
/*     */         
/*     */         public void storageReserve(int amount) {
/* 248 */           if (storageReservable() < amount) {
/* 249 */             throw new RuntimeException();
/*     */           }
/* 251 */           Crate.this.bReservedSpace.inc((ROOMA)Crate.this.ins, amount);
/*     */         }
/*     */ 
/*     */         
/*     */         public void storageUnreserve(int amount) {
/* 256 */           Crate.this.bReservedSpace.inc((ROOMA)Crate.this.ins, -amount);
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE resource() {
/* 261 */           int i = Crate.this.bRes.get();
/* 262 */           if (i == 0)
/* 263 */             return null; 
/* 264 */           i--;
/* 265 */           if (i >= RESOURCES.ALL().size() || AD.supplies().get((RESOURCE)RESOURCES.ALL().get(i)).size() == 0) {
/* 266 */             return null;
/*     */           }
/* 268 */           return (RESOURCE)RESOURCES.ALL().get(i);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 277 */     this.job = new SETT_JOB()
/*     */       {
/*     */         public boolean jobUseTool()
/*     */         {
/* 281 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 291 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 296 */           return (Crate.this.bAnimals.get() == 0) ? Crate.this.b.liveStock.bit : null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 301 */           return (Crate.this.bAnimalsRes.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 306 */           Crate.this.bAnimalsRes.set((ROOMA)Crate.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 311 */           if (jobReservedIs(null))
/* 312 */             return false; 
/* 313 */           return !(Crate.this.bAnimals.get() != 0 && Crate.this.goIsReady() != 0 && Crate.this.bAway.get() != 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/* 318 */           Crate.this.bAnimalsRes.set((ROOMA)Crate.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid a) {
/* 323 */           return 16.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 328 */           jobReserveCancel(null);
/* 329 */           if (r != null) {
/* 330 */             Crate.this.bAnimals.inc((ROOMA)Crate.this.ins, rAm);
/* 331 */             FACTIONS.player().res().inc(r, FResources.RTYPE.PRODUCED, -rAm);
/*     */           } else {
/* 333 */             Crate.this.bAway.set((ROOMA)Crate.this.ins, 0);
/* 334 */             Crate.this.deliver();
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 339 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean longFetch() {
/* 344 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public int jobResourcesNeeded(Humanoid skill) {
/* 349 */           return 8;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 354 */           return (Crate.this.b.employment()).verb;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 359 */           return (COORDINATE)Crate.this.coo;
/*     */         }
/*     */       };
/*     */     this.b = b;
/*     */   }
/*     */   
/*     */   private class BB extends RoomBits { public BB(Bits bits) {
/* 366 */       super((COORDINATE)Crate.this.coo, bits);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void remove() {
/* 372 */       Crate.this.b.tally.report(Crate.this, Crate.this.ins, -1);
/* 373 */       super.remove();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void add() {
/* 378 */       Crate.this.b.tally.report(Crate.this, Crate.this.ins, 1);
/* 379 */       super.add();
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\supply\Crate.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */