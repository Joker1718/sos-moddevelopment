/*     */ package settlement.room.infra.station;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Crate
/*     */ {
/*  18 */   public final int MAX_AM = 400;
/*  19 */   Coo coo = new Coo();
/*     */   StationInstance ins;
/*  21 */   public final RoomBits resource = new RoomBits((COORDINATE)this.coo, new Bits(4080));
/*  22 */   public final RoomBits reserved = new RoomBits((COORDINATE)this.coo, new Bits(4190208));
/*  23 */   public final RoomBits stored = new RoomBits((COORDINATE)this.coo, new Bits(-4194304));
/*     */ 
/*     */   
/*     */   private final ROOM_STATION b;
/*     */ 
/*     */   
/*     */   private final RESOURCE_TILE tile;
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE get(int tx, int ty) {
/*  34 */     this.ins = (StationInstance)this.b.get(tx, ty);
/*  35 */     if (this.ins == null)
/*  36 */       return null; 
/*  37 */     if (((SETT.ROOMS()).fData.tileData.get(tx, ty) & 0x2) != 0) {
/*  38 */       this.coo.set(tx, ty);
/*  39 */       return this.tile;
/*     */     } 
/*  41 */     return null;
/*     */   }
/*     */   
/*     */   public void deliver(int am) {
/*  45 */     remove();
/*  46 */     this.stored.inc((ROOMA)this.ins, am);
/*  47 */     add();
/*     */   }
/*     */ 
/*     */   
/*     */   public void resourceSet(RESOURCE res) {
/*  52 */     RESOURCE old = resource();
/*     */     
/*  54 */     if (old != null) {
/*  55 */       int am = this.stored.get();
/*  56 */       if (am > 0) {
/*  57 */         for (DIR dd : DIR.ORTHO) {
/*  58 */           if (!(SETT.PATH()).solidity.is((COORDINATE)this.coo, dd)) {
/*  59 */             (SETT.THINGS()).resources.create(this.coo.x() + dd.x(), this.coo.y() + dd.y(), this.tile.resource(), am);
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*  66 */     remove();
/*  67 */     this.stored.set((ROOMA)this.ins, 0);
/*  68 */     this.reserved.set((ROOMA)this.ins, 0);
/*  69 */     this.resource.set((ROOMA)this.ins, 0);
/*  70 */     if (old != null) {
/*  71 */       this.b.tally(old).add(this.ins.tally(old), this.ins);
/*     */     }
/*  73 */     if (res != null) {
/*  74 */       this.b.tally(res).remove(this.ins.tally(res), this.ins);
/*  75 */       int ri = (res == null) ? 0 : (res.index() + 1);
/*  76 */       this.resource.set((ROOMA)this.ins, ri);
/*  77 */       add();
/*     */     } 
/*     */   }
/*     */   
/*  81 */   Crate(ROOM_STATION b) { this.tile = new RESOURCE_TILE()
/*     */       {
/*     */         public int y()
/*     */         {
/*  85 */           return Crate.this.coo.y();
/*     */         }
/*     */ 
/*     */         
/*     */         public int x() {
/*  90 */           return Crate.this.coo.x();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedIs() {
/*  95 */           return (resource() != null && Crate.this.reserved.get() > 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedCanBe() {
/* 100 */           return (resource() != null && Crate.this.reserved.get() < Crate.this.stored.get());
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserveCancel() {
/* 105 */           if (resource() == null)
/*     */             return; 
/* 107 */           Crate.this.remove();
/* 108 */           Crate.this.reserved.inc((ROOMA)Crate.this.ins, -1);
/* 109 */           Crate.this.add();
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserve() {
/* 114 */           if (resource() == null)
/*     */             return; 
/* 116 */           Crate.this.remove();
/* 117 */           Crate.this.reserved.inc((ROOMA)Crate.this.ins, 1);
/* 118 */           Crate.this.add();
/*     */         }
/*     */ 
/*     */         
/*     */         public void resourcePickup() {
/* 123 */           if (resource() == null)
/*     */             return; 
/* 125 */           Crate.this.remove();
/* 126 */           Crate.this.reserved.inc((ROOMA)Crate.this.ins, -1);
/* 127 */           Crate.this.stored.inc((ROOMA)Crate.this.ins, -1);
/* 128 */           Crate.this.add();
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE resource() {
/* 133 */           return Crate.this.resource();
/*     */         }
/*     */ 
/*     */         
/*     */         public int reservable() {
/* 138 */           return Crate.this.stored.get() - Crate.this.reserved.get();
/*     */         }
/*     */ 
/*     */         
/*     */         public int amount() {
/* 143 */           return Crate.this.stored.get();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isStorage() {
/* 148 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isPrio() {
/* 153 */           return false; }
/*     */       };
/*     */     this.b = b;
/*     */     if (400 > this.stored.max())
/*     */       throw new RuntimeException();  } public RESOURCE resource() {
/* 158 */     int ri = this.resource.get();
/* 159 */     if (ri <= 0)
/* 160 */       return null; 
/* 161 */     ri--;
/* 162 */     if (ri >= RESOURCES.ALL().size())
/* 163 */       return null; 
/* 164 */     return (RESOURCE)RESOURCES.ALL().get(ri);
/*     */   }
/*     */   
/*     */   private void remove() {
/* 168 */     RESOURCE res = this.tile.resource();
/* 169 */     if (res == null)
/*     */       return; 
/* 171 */     this.ins.tally(res).remove(res, this, this.ins);
/* 172 */     if (this.tile.findableReservedCanBe())
/* 173 */       (SETT.PATH()).finders.resource.reportAbsence(this.tile); 
/*     */   }
/*     */   
/*     */   private void add() {
/* 177 */     RESOURCE res = this.tile.resource();
/* 178 */     if (res == null)
/*     */       return; 
/* 180 */     this.ins.tally(res).add(res, this, this.ins);
/* 181 */     if (this.tile.findableReservedCanBe())
/* 182 */       (SETT.PATH()).finders.resource.reportPresence(this.tile); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\station\Crate.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */