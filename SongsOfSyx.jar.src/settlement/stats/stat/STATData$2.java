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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 59 */     return data.get(t);
/*    */   }
/*    */ 
/*    */   
/*    */   public int min(Induvidual t) {
/* 64 */     return data.min(t);
/*    */   }
/*    */ 
/*    */   
/*    */   public int max(Induvidual t) {
/* 69 */     return data.max(t);
/*    */   }
/*    */ 
/*    */   
/*    */   public double getD(Induvidual t) {
/* 74 */     return data.getD(t);
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(Induvidual t, int i) {
/* 79 */     STATData.this.removeH(t);
/* 80 */     data.set(t, i);
/* 81 */     STATData.this.addH(t);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\STATData$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */