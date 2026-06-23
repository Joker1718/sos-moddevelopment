/*    */ package settlement.room.infra.stockpile;
/*    */ 
/*    */ import init.resources.RESOURCE;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements INT_O<RESOURCE>
/*    */ {
/*    */   public int get(RESOURCE res) {
/* 74 */     return StockpileTally.this.amount.total(res) - StockpileTally.this.amountReserved.total(res);
/*    */   }
/*    */ 
/*    */   
/*    */   public int min(RESOURCE t) {
/* 79 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max(RESOURCE t) {
/* 84 */     return Integer.MAX_VALUE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\StockpileTally$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */