/*     */ package game.faction.trade;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.util.file.Alloc;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Partner
/*     */ {
/*     */   private final short faction;
/*     */   private double distance;
/*  94 */   private final int[] traded = Alloc.ii(TR.ALL().size());
/*     */   
/*     */   Partner(Faction faction) {
/*  97 */     this.faction = (short)faction.index();
/*     */   }
/*     */   
/*     */   public Faction faction() {
/* 101 */     return FACTIONS.getByIndex(this.faction);
/*     */   }
/*     */   
/*     */   public double distance() {
/* 105 */     return this.distance;
/*     */   }
/*     */   
/*     */   public int traded(TRADABLE res) {
/* 109 */     return this.traded[res.index()];
/*     */   }
/*     */   
/*     */   public void trade(TRADABLE res, int amount) {
/* 113 */     this.traded[res.index()] = this.traded[res.index()] + amount;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\trade\TradeShipper$Partner.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */