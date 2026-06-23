/*    */ package settlement.room.tests.production;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.room.industry.module.Industry;
/*    */ import settlement.room.industry.module.IndustryResource;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ public class TestRecipe
/*    */ {
/* 11 */   ArrayListGrower<Input> inputs = new ArrayListGrower();
/*    */   public final Industry ins;
/*    */   public final RESOURCE res;
/*    */   public final double rate;
/*    */   public final double wPerItem;
/*    */   public final int index;
/*    */   
/*    */   TestRecipe(int index, Industry ins, IndustryResource out) {
/* 19 */     this.ins = ins;
/* 20 */     this.res = out.resource;
/* 21 */     this.rate = out.rate;
/* 22 */     this.wPerItem = 1.0D / out.rate;
/* 23 */     this.index = index;
/*    */   }
/*    */   
/*    */   TestRecipe(int index, TestRecipe r) {
/* 27 */     this.ins = r.ins;
/* 28 */     this.res = r.res;
/* 29 */     this.wPerItem = r.wPerItem;
/* 30 */     this.rate = r.rate;
/* 31 */     this.index = index;
/*    */   }
/*    */   
/*    */   public LIST<Input> inputs() {
/* 35 */     return (LIST<Input>)this.inputs;
/*    */   }
/*    */   
/*    */   public double wPerItem(ProductionSpec ibonuses) {
/* 39 */     return (this.wPerItem + ibonuses.wPerItemUsed()) / ibonuses.bonus(this.ins);
/*    */   }
/*    */   
/*    */   public double wTotPerItem(ProductionSpec ibonuses) {
/* 43 */     double w = wPerItem(ibonuses);
/* 44 */     for (int i = 0; i < this.inputs.size(); i++) {
/* 45 */       Input ii = (Input)this.inputs.get(i);
/* 46 */       w += ii.amount * ii.producer.wTotPerItem(ibonuses) / this.rate * ibonuses.consumptionBonus(this.ins);
/*    */     } 
/* 48 */     return w;
/*    */   }
/*    */   
/*    */   public double amountPerW(ProductionSpec ibonuses) {
/* 52 */     return 1.0D / wPerItem(ibonuses);
/*    */   }
/*    */   
/*    */   public double amountPerWTot(ProductionSpec ibonuses) {
/* 56 */     return 1.0D / wTotPerItem(ibonuses);
/*    */   }
/*    */   
/*    */   public double pricePerItem(ProductionSpec ibonuses) {
/* 60 */     double p = wPerItem(ibonuses);
/* 61 */     for (int i = 0; i < this.inputs.size(); i++) {
/* 62 */       Input ii = (Input)this.inputs.get(i);
/* 63 */       p += ii.producer.pricePerItem(ibonuses) * ii.amount / this.rate * ibonuses.consumptionBonus(this.ins);
/*    */     } 
/* 65 */     return p + ibonuses.addedW();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\tests\production\TestRecipe.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */