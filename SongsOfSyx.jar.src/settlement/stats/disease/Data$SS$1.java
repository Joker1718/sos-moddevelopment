/*    */ package settlement.stats.disease;
/*    */ 
/*    */ import settlement.stats.Induvidual;
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
/*    */ class null
/*    */   implements INT_O.INT_OE<Induvidual>
/*    */ {
/*    */   public int get(Induvidual t) {
/* 71 */     if (this$0.get(t) != null && this$0.status(t) == status)
/* 72 */       return 1; 
/* 73 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int min(Induvidual t) {
/* 78 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max(Induvidual t) {
/* 83 */     return 1;
/*    */   }
/*    */   
/*    */   public void set(Induvidual t, int i) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\Data$SS$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */