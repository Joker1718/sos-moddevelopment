/*     */ package settlement.room.law.stocks;
/*     */ 
/*     */ import settlement.room.service.module.ROOM_SPECTATOR;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends ROOM_SPECTATOR
/*     */ {
/*     */   public boolean shouldBoo(int sx, int sy) {
/* 125 */     Tile t = ROOM_STOCKS.this.tile.get(sx, sy);
/* 126 */     if (t != null && t.state() == Tile.STATE.used)
/* 127 */       return true; 
/* 128 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isActive(int sx, int sy) {
/* 133 */     Tile t = ROOM_STOCKS.this.tile.get(sx, sy);
/* 134 */     if (t != null && t.state() == Tile.STATE.used)
/* 135 */       return true; 
/* 136 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldCheer(int sx, int sy) {
/* 141 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomServiceAccess service() {
/* 146 */     return (RoomServiceAccess)ROOM_STOCKS.this.data;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\stocks\ROOM_STOCKS$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */