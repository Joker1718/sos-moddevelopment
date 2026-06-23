/*    */ package settlement.room.tests.production;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ 
/*    */ public class Input
/*    */ {
/*    */   public final RESOURCE res;
/*    */   public final double amount;
/*    */   public final TestRecipe producer;
/*    */   
/*    */   Input(double amount, TestRecipe producer) {
/* 12 */     this.res = producer.res;
/* 13 */     this.amount = amount;
/* 14 */     this.producer = producer;
/*    */   }
/*    */   
/*    */   double wTot(ProductionSpec ibonuses) {
/* 18 */     return this.amount * this.producer.wTotPerItem(ibonuses);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\tests\production\Input.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */