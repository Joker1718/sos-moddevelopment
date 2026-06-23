/*    */ package game.faction.diplomacy.deal;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import init.trade.TRADABLE;
/*    */ import util.data.INT_O;
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
/*    */ class null
/*    */   implements INT_O.INT_OE<TRADABLE>
/*    */ {
/*    */   public int get(TRADABLE t) {
/* 61 */     return DealParty.this.res[t.index()];
/*    */   }
/*    */ 
/*    */   
/*    */   public int min(TRADABLE t) {
/* 66 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max(TRADABLE t) {
/* 71 */     if (DealParty.this.f == FACTIONS.player())
/* 72 */       return DealParty.this.resMax[t.index()]; 
/* 73 */     return Math.max(DealParty.this.f.res().getAvailable(t) - 1, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(TRADABLE t, int i) {
/* 78 */     DealParty.this.res[t.index()] = i;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealParty$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */