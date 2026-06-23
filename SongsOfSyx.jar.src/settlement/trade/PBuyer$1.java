/*    */ package settlement.trade;
/*    */ 
/*    */ import init.trade.TRADE_TYPE;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements INT_O<TRADE_TYPE>
/*    */ {
/*    */   public int min(TRADE_TYPE t) {
/* 67 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max(TRADE_TYPE t) {
/* 72 */     return Integer.MAX_VALUE;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get(TRADE_TYPE t) {
/* 77 */     return PBuyer.this.toBeAdded.get(t) + PBuyer.this.toBeStored.get(t) + PBuyer.this.attempting(t);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\trade\PBuyer$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */