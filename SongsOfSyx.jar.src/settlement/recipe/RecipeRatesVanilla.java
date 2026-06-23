/*    */ package settlement.recipe;
/*    */ 
/*    */ import init.trade.TR;
/*    */ import init.trade.TRADABLE;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ 
/*    */ public class RecipeRatesVanilla
/*    */ {
/* 10 */   private final double[] best = new double[TR.ALL().size()];
/* 11 */   private final double[] bestTotal = new double[TR.ALL().size()];
/* 12 */   private final Recipe[] bestR = new Recipe[TR.ALL().size()];
/*    */   
/*    */   private final double[] rateTot;
/*    */   
/*    */   RecipeRatesVanilla(Recipes recp) {
/* 17 */     this.rateTot = new double[recp.all().size()];
/*    */     
/* 19 */     Arrays.fill(this.best, Double.MAX_VALUE);
/* 20 */     Arrays.fill(this.bestTotal, Double.MAX_VALUE);
/*    */     
/* 22 */     for (int iii = 0; iii < recp.all().size(); iii++) {
/* 23 */       Recipe ii = (Recipe)recp.all().get(iii);
/* 24 */       double r = 1.0D / ii.aiRate;
/* 25 */       if (r < this.best[ii.out.index()]) {
/* 26 */         this.best[ii.out.index()] = r;
/*    */       }
/*    */     } 
/* 29 */     for (int i = 0; i < 10; i++) {
/* 30 */       for (int j = 0; j < recp.all().size(); j++) {
/* 31 */         Recipe ii = (Recipe)recp.all().get(j);
/* 32 */         init(ii);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean init(Recipe ii) {
/* 41 */     double mm = 1.0D / ii.aiRate; byte b; int i;
/*    */     RecipeInput[] arrayOfRecipeInput;
/* 43 */     for (i = (arrayOfRecipeInput = ii.ins).length, b = 0; b < i; ) { RecipeInput recipeInput = arrayOfRecipeInput[b];
/* 44 */       if (this.bestTotal[recipeInput.res.index()] == Double.MAX_VALUE)
/* 45 */         return true; 
/* 46 */       mm += recipeInput.rate * this.bestTotal[recipeInput.res.index()] / ii.aiRate;
/*    */       b++; }
/*    */     
/* 49 */     this.rateTot[ii.index] = mm;
/*    */     
/* 51 */     if (mm < this.bestTotal[ii.out.index()]) {
/* 52 */       this.bestTotal[ii.out.index()] = mm;
/* 53 */       this.bestR[ii.out.index()] = ii;
/* 54 */       return true;
/*    */     } 
/* 56 */     return false;
/*    */   }
/*    */   
/*    */   public double vanilla(TRADABLE res) {
/* 60 */     return this.best[res.index()];
/*    */   }
/*    */   
/*    */   public double vanillaRate(TRADABLE res) {
/* 64 */     return this.bestTotal[res.index()];
/*    */   }
/*    */   
/*    */   public Recipe bestRecipe(TRADABLE res) {
/* 68 */     return this.bestR[res.index()];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\recipe\RecipeRatesVanilla.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */