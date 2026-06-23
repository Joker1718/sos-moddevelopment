/*    */ package settlement.room.infra.hauler;
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
/*    */ 
/*    */ class null
/*    */   implements INT_O<RESOURCE>
/*    */ {
/*    */   public int get(RESOURCE res) {
/* 75 */     return HaulerTally.this.amount.total(res) - HaulerTally.this.amountReserved.total(res);
/*    */   }
/*    */ 
/*    */   
/*    */   public int min(RESOURCE t) {
/* 80 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max(RESOURCE t) {
/* 85 */     return Integer.MAX_VALUE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\hauler\HaulerTally$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */