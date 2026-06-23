/*    */ package game.faction.player;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import util.data.INT_O;
/*    */ import util.statistics.HistoryInt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class VV
/*    */   implements INT_O<Faction>
/*    */ {
/*    */   private final HistoryInt ii;
/*    */   
/*    */   VV(HistoryInt ii) {
/* 78 */     this.ii = ii;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get(Faction t) {
/* 83 */     if (t == FACTIONS.player())
/* 84 */       return this.ii.get(); 
/* 85 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int min(Faction t) {
/* 90 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max(Faction t) {
/* 95 */     return Integer.MAX_VALUE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PCredits$VV.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */