/*     */ package settlement.room.law.stocks;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements FSERVICE
/*     */ {
/*     */   public int y() {
/*  81 */     return Tile.this.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/*  86 */     return Tile.this.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedIs() {
/*  91 */     return (Tile.this.available.get((SETT.ROOMS()).data.get(Tile.this.x, Tile.this.y)) < 8);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean findableReservedCanBe() {
/*  96 */     return (Tile.this.available.get((SETT.ROOMS()).data.get(Tile.this.x, Tile.this.y)) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserveCancel() {
/* 101 */     Tile.this.availableSet(Tile.this.available.get((SETT.ROOMS()).data.get(Tile.this.x, Tile.this.y) + 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public void findableReserve() {
/* 106 */     Tile.this.availableSet(Tile.this.available.get((SETT.ROOMS()).data.get(Tile.this.x, Tile.this.y) - 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public void consume() {
/* 111 */     findableReserveCancel();
/*     */   }
/*     */   
/*     */   public void startUsing() {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\stocks\Tile$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */