/*    */ package settlement.room.tests;
/*    */ 
/*    */ import settlement.room.industry.module.Industry;
/*    */ import settlement.room.tests.production.ProductionSpec;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   implements ProductionSpec
/*    */ {
/*    */   public double bonus(Industry t) {
/* 77 */     return UITradeDebug.this.bonusai.get() / 100.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double consumptionBonus(Industry ins) {
/* 82 */     return 1.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double wPerItemUsed() {
/* 87 */     return 0.1D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double addedW() {
/* 92 */     return UITradeDebug.this.gametheory.getD();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\tests\UITradeDebug$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */