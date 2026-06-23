/*    */ package settlement.stats.stat;
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
/*    */ class null
/*    */   implements INT_O.INT_OE<Induvidual>
/*    */ {
/*    */   public int get(Induvidual t) {
/* 43 */     return (int)(STATFakeData.this.indu(t) * 16.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public int min(Induvidual t) {
/* 48 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max(Induvidual t) {
/* 53 */     return STATFakeData.this.dataDivider() * 16;
/*    */   }
/*    */   
/*    */   public void set(Induvidual t, int i) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\STATFakeData$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */