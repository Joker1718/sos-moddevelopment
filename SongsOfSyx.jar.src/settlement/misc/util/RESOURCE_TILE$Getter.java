/*     */ package settlement.misc.util;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.thing.THINGS;
/*     */ import settlement.thing.ThingsResources;
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
/*     */ public final class Getter
/*     */ {
/*  44 */   private final RBIT.RBITImp tmp = new RBIT.RBITImp();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int reserve(boolean stored, boolean fetch, RESOURCE r, int tx, int ty, int amount) {
/*  51 */     int am = 0;
/*  52 */     while (am < amount) {
/*  53 */       RESOURCE_TILE t = reservable(r, stored, fetch, tx, ty);
/*  54 */       if (t == null)
/*  55 */         return am; 
/*  56 */       while (am < amount && t.findableReservedCanBe()) {
/*  57 */         t.findableReserve();
/*  58 */         am++;
/*     */       } 
/*     */     } 
/*  61 */     return am;
/*     */   }
/*     */   
/*     */   public final void unreserve(RESOURCE r, int tx, int ty, int amount) {
/*  65 */     while (amount > 0) {
/*  66 */       RESOURCE_TILE t = RESOURCE_TILE.GETTER.reserved(r, tx, ty);
/*  67 */       if (t == null)
/*     */         return; 
/*  69 */       while (amount > 0 && t.findableReservedIs()) {
/*  70 */         t.findableReserveCancel();
/*  71 */         amount--;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public final int pickup(RESOURCE r, int tx, int ty, int amount) {
/*  77 */     int am = 0;
/*  78 */     while (am < amount) {
/*  79 */       RESOURCE_TILE t = reserved(r, tx, ty);
/*  80 */       if (t == null)
/*  81 */         return am; 
/*  82 */       while (am < amount && t.findableReservedIs()) {
/*  83 */         t.resourcePickup();
/*  84 */         am++;
/*     */       } 
/*     */     } 
/*  87 */     return am;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE reservable(RBIT scattered, RBIT stored, RBIT fetch, int tx, int ty) {
/*  92 */     this.tmp.clear();
/*  93 */     this.tmp.or(scattered).or(stored).or(fetch);
/*     */     
/*  95 */     ThingsResources.ScatteredResource sc = (SETT.THINGS()).resources.getReservable(tx, ty, (RBIT)this.tmp);
/*  96 */     if (sc != null && sc.findableReservedCanBe()) {
/*  97 */       return (RESOURCE_TILE)sc;
/*     */     }
/*     */     
/* 100 */     Room room = (SETT.ROOMS()).map.get(tx, ty);
/* 101 */     if (room == null)
/* 102 */       return null; 
/* 103 */     RESOURCE_TILE res = room.resourceTile(tx, ty);
/* 104 */     if (res == null)
/* 105 */       return null; 
/* 106 */     RESOURCE r = res.resource();
/* 107 */     if (r == null)
/* 108 */       return null; 
/* 109 */     if (!res.findableReservedCanBe())
/* 110 */       return null; 
/* 111 */     if (res.isPrio()) {
/* 112 */       if (fetch.has(r))
/* 113 */         return res; 
/* 114 */       return null;
/*     */     } 
/* 116 */     if (res.isStorage()) {
/* 117 */       if (stored.has(r))
/* 118 */         return res; 
/* 119 */       return null;
/*     */     } 
/* 121 */     if (scattered.has(r))
/* 122 */       return res; 
/* 123 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE_TILE reservable(RESOURCE r, boolean stored, boolean fetch, int tx, int ty) {
/* 129 */     ThingsResources.ScatteredResource sc = (SETT.THINGS()).resources.getReservable(tx, ty, r.bit);
/* 130 */     if (sc != null) {
/* 131 */       return (RESOURCE_TILE)sc;
/*     */     }
/*     */     
/* 134 */     Room room = (SETT.ROOMS()).map.get(tx, ty);
/* 135 */     if (room == null)
/* 136 */       return null; 
/* 137 */     RESOURCE_TILE res = room.resourceTile(tx, ty);
/* 138 */     if (res == null)
/* 139 */       return null; 
/* 140 */     if (r != res.resource())
/* 141 */       return null; 
/* 142 */     if (!res.findableReservedCanBe())
/* 143 */       return null; 
/* 144 */     if (res.isPrio() && !fetch)
/* 145 */       return null; 
/* 146 */     if (res.isStorage() && !stored) {
/* 147 */       return null;
/*     */     }
/* 149 */     return res;
/*     */   }
/*     */   
/*     */   public RESOURCE_TILE reserved(RESOURCE resource, int tx, int ty) {
/* 153 */     Room room = (SETT.ROOMS()).map.get(tx, ty);
/* 154 */     if (room != null) {
/* 155 */       RESOURCE_TILE res = room.resourceTile(tx, ty);
/* 156 */       if (res != null && res.resource() == resource && res.findableReservedIs()) {
/* 157 */         return res;
/*     */       }
/*     */     } 
/* 160 */     for (THINGS.Thing t : SETT.THINGS().get(tx, ty)) {
/* 161 */       if (t instanceof ThingsResources.ScatteredResource) {
/* 162 */         ThingsResources.ScatteredResource sc = (ThingsResources.ScatteredResource)t;
/* 163 */         if (sc.findableReservedIs() && sc.resource() == resource) {
/* 164 */           return (RESOURCE_TILE)sc;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 169 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\mis\\util\RESOURCE_TILE$Getter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */