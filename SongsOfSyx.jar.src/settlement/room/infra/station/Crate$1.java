/*     */ package settlement.room.infra.station;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.room.main.ROOMA;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements RESOURCE_TILE
/*     */ {
/*     */   public int y() {
/*  85 */     return Crate.this.coo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/*  90 */     return Crate.this.coo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/*  95 */     return (resource() != null && Crate.this.reserved.get() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/* 100 */     return (resource() != null && Crate.this.reserved.get() < Crate.this.stored.get());
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 105 */     if (resource() == null)
/*     */       return; 
/* 107 */     Crate.this.remove();
/* 108 */     Crate.this.reserved.inc((ROOMA)Crate.this.ins, -1);
/* 109 */     Crate.this.add();
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/* 114 */     if (resource() == null)
/*     */       return; 
/* 116 */     Crate.this.remove();
/* 117 */     Crate.this.reserved.inc((ROOMA)Crate.this.ins, 1);
/* 118 */     Crate.this.add();
/*     */   }
/*     */ 
/*     */   
/*     */   public void resourcePickup() {
/* 123 */     if (resource() == null)
/*     */       return; 
/* 125 */     Crate.this.remove();
/* 126 */     Crate.this.reserved.inc((ROOMA)Crate.this.ins, -1);
/* 127 */     Crate.this.stored.inc((ROOMA)Crate.this.ins, -1);
/* 128 */     Crate.this.add();
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE resource() {
/* 133 */     return Crate.this.resource();
/*     */   }
/*     */ 
/*     */   
/*     */   public int reservable() {
/* 138 */     return Crate.this.stored.get() - Crate.this.reserved.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public int amount() {
/* 143 */     return Crate.this.stored.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStorage() {
/* 148 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPrio() {
/* 153 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\station\Crate$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */