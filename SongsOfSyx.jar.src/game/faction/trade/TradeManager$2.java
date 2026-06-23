/*     */ package game.faction.trade;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import util.updating.TileUpdater;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends TileUpdater
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1, double $anonymous2) {
/* 107 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */   }
/*     */   
/*     */   protected void update(int iteration, int factionI, int vv, double timeSinceLast) {
/* 111 */     if (factionI == FACTIONS.MAX() / 2 || factionI == 0) {
/*     */       
/* 113 */       if (iteration == 0) {
/* 114 */         TradeManager.this.sellPlayer();
/*     */       }
/* 116 */       if (TradeManager.this.shipper.partners() > 0) {
/* 117 */         TradeShipper.Partner p = TradeManager.this.shipper.popNextPartner();
/* 118 */         Faction b = p.faction();
/* 119 */         TradeManager.this.ship(b, (Faction)FACTIONS.player(), p, true);
/*     */       } 
/*     */       return;
/*     */     } 
/* 123 */     if (factionI == FACTIONS.MAX() / 2 + 1 || factionI == 1) {
/* 124 */       pbuy((Faction)FACTIONS.player(), iteration);
/*     */       
/*     */       return;
/*     */     } 
/* 128 */     if (factionI < FACTIONS.MAX() / 2) {
/* 129 */       factionI--;
/*     */     } else {
/* 131 */       factionI -= 3;
/*     */     } 
/* 133 */     if (factionI >= FACTIONS.MAX()) {
/*     */       return;
/*     */     }
/* 136 */     Faction buyer = FACTIONS.getByIndex(factionI);
/* 137 */     pbuy(buyer, iteration);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void pbuy(Faction buyer, int iteration) {
/* 143 */     if (buyer.isActive() && buyer.capitolRegion() != null) {
/* 144 */       if (iteration == 0) {
/* 145 */         TradeManager.this.buy(buyer);
/*     */       }
/*     */       
/* 148 */       if (TradeManager.this.shipper.partners() > 0) {
/* 149 */         TradeShipper.Partner p = TradeManager.this.shipper.popNextPartner();
/* 150 */         Faction b = p.faction();
/* 151 */         TradeManager.this.ship(buyer, b, p, true);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\trade\TradeManager$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */