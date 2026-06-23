/*    */ package settlement.recipe;
/*    */ 
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import game.boosting.Boostable;
/*    */ import init.trade.TRADABLE;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.sets.INDEXED;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ public class Recipe
/*    */   implements INDEXED {
/*    */   public final TRADABLE out;
/*    */   public final Boostable bo;
/*    */   public final double rate;
/*    */   public final double aiRate;
/*    */   public final double aiRecovery;
/*    */   public final CharSequence name;
/*    */   public final SPRITE icon;
/*    */   public final int index;
/*    */   public final int industryIndex;
/*    */   public final RecipeInput[] ins;
/*    */   
/*    */   Recipe(int index, int industryIndex, TRADABLE out, double rate, double aiRate, double aiRecovery, Boostable bo, Boostable consumption, CharSequence name, SPRITE icon, LIST<RecipeInput> inss) {
/* 25 */     this.index = index;
/* 26 */     this.industryIndex = industryIndex;
/* 27 */     this.bo = bo;
/* 28 */     this.out = out;
/* 29 */     this.rate = rate;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 39 */     this.aiRate = aiRate;
/* 40 */     this.aiRecovery = aiRecovery;
/* 41 */     this.name = name;
/* 42 */     this.icon = icon;
/* 43 */     this.ins = new RecipeInput[inss.size()];
/* 44 */     for (int i = 0; i < inss.size(); i++) {
/* 45 */       this.ins[i] = (RecipeInput)inss.get(i);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int index() {
/* 52 */     return this.index;
/*    */   }
/*    */   
/*    */   public double manpower() {
/* 56 */     return 1.0D / this.aiRate;
/*    */   }
/*    */   
/*    */   public double manpowerTotal() {
/* 60 */     return (SETT.RECIPES()).ratesV.vanillaRate(this.out);
/*    */   }
/*    */   
/*    */   public double manpower(BOOSTABLE_O b) {
/* 64 */     return 1.0D / this.aiRate * this.bo.get(b);
/*    */   }
/*    */   
/*    */   public double manpowerTotal(BOOSTABLE_O b) {
/* 68 */     return (SETT.RECIPES()).rates.rateTotal(b, this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\recipe\Recipe.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */