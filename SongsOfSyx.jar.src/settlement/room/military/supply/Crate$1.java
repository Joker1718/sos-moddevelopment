/*     */ package settlement.room.military.supply;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import world.army.AD;
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
/*     */   implements TILE_STORAGE
/*     */ {
/*     */   public int y() {
/* 202 */     return Crate.this.coo.y();
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/* 207 */     return Crate.this.coo.x();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean storageIsFindable() {
/* 212 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void storageDeposit(int amount) {
/* 220 */     if (Crate.this.resAmount() + amount > 80) {
/* 221 */       throw new RuntimeException(String.valueOf(resource()) + " " + String.valueOf(resource()) + " " + Crate.this.resAmount() + " 80");
/*     */     }
/* 223 */     Crate.this.bReservedSpace.inc((ROOMA)Crate.this.ins, -amount);
/* 224 */     Crate.this.bAmount.inc((ROOMA)Crate.this.ins, amount);
/* 225 */     if (Crate.this.bAmount.get() >= 80)
/* 226 */       Crate.this.deliver(); 
/* 227 */     Crate.this.ins.jobs.searchAgain();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int storageReserved() {
/* 233 */     return Crate.this.bReservedSpace.get();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int storageReservable() {
/* 239 */     int am = 80 - Crate.this.resAmount() - storageReserved();
/* 240 */     if (resource() == null)
/* 241 */       return am; 
/* 242 */     int m = Crate.this.b.tally.fetchAmount(resource());
/* 243 */     return Math.min(am, m);
/*     */   }
/*     */ 
/*     */   
/*     */   public void storageReserve(int amount) {
/* 248 */     if (storageReservable() < amount) {
/* 249 */       throw new RuntimeException();
/*     */     }
/* 251 */     Crate.this.bReservedSpace.inc((ROOMA)Crate.this.ins, amount);
/*     */   }
/*     */ 
/*     */   
/*     */   public void storageUnreserve(int amount) {
/* 256 */     Crate.this.bReservedSpace.inc((ROOMA)Crate.this.ins, -amount);
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE resource() {
/* 261 */     int i = Crate.this.bRes.get();
/* 262 */     if (i == 0)
/* 263 */       return null; 
/* 264 */     i--;
/* 265 */     if (i >= RESOURCES.ALL().size() || AD.supplies().get((RESOURCE)RESOURCES.ALL().get(i)).size() == 0) {
/* 266 */       return null;
/*     */     }
/* 268 */     return (RESOURCE)RESOURCES.ALL().get(i);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\supply\Crate$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */