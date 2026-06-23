/*     */ package settlement.recipe;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ public class RecipeRates
/*     */ {
/*     */   public static final double logisticsW = 0.1D;
/*  13 */   private final double[] best = new double[TR.ALL().size()];
/*  14 */   private final double[] bestTotal = new double[TR.ALL().size()];
/*  15 */   private final Recipe[] bestR = new Recipe[TR.ALL().size()];
/*     */   
/*     */   private final double[] rateTot;
/*     */   
/*  19 */   private int rateI = -1;
/*  20 */   private BOOSTABLE_O rateII = null;
/*     */   
/*     */   private final Recipes recp;
/*     */   
/*     */   RecipeRates(Recipes recp) {
/*  25 */     this.rateTot = new double[recp.all().size()];
/*  26 */     this.recp = recp;
/*     */   }
/*     */ 
/*     */   
/*     */   public double rateTotal(BOOSTABLE_O cl, TRADABLE res) {
/*  31 */     calc(cl);
/*  32 */     return this.bestTotal[res.index()];
/*     */   }
/*     */   
/*     */   public double rate(BOOSTABLE_O cl, TRADABLE res) {
/*  36 */     calc(cl);
/*  37 */     return this.best[res.index()];
/*     */   }
/*     */   
/*     */   double rateTotal(BOOSTABLE_O cl, Recipe res) {
/*  41 */     calc(cl);
/*  42 */     return this.rateTot[res.index()];
/*     */   }
/*     */   
/*     */   public Recipe bestRecipe(BOOSTABLE_O bo, TRADABLE res) {
/*  46 */     calc(bo);
/*  47 */     return this.bestR[res.index()];
/*     */   }
/*     */   
/*     */   private void calc(BOOSTABLE_O cl) {
/*  51 */     if (this.rateI == GAME.updateI() && this.rateII == cl)
/*     */       return; 
/*  53 */     this.rateI = GAME.updateI();
/*  54 */     this.rateII = cl;
/*     */     
/*  56 */     Arrays.fill(this.best, Double.MAX_VALUE);
/*  57 */     Arrays.fill(this.bestTotal, Double.MAX_VALUE);
/*     */     
/*  59 */     for (int iii = 0; iii < this.recp.all().size(); iii++) {
/*  60 */       Recipe ii = (Recipe)this.recp.all().get(iii);
/*  61 */       double r = 1.0D / rate(ii.aiRate) * ii.bo.get(cl);
/*  62 */       if (r < this.best[ii.out.index()]) {
/*  63 */         this.best[ii.out.index()] = r;
/*     */       }
/*     */     } 
/*  66 */     for (int i = 0; i < 10; i++) {
/*  67 */       for (int j = 0; j < this.recp.all().size(); j++) {
/*  68 */         Recipe ii = (Recipe)this.recp.all().get(j);
/*  69 */         set2(cl, ii);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private double rate(double rate) {
/*  76 */     rate = 1.0D / rate;
/*  77 */     rate += 0.1D;
/*  78 */     rate = 1.0D / rate;
/*  79 */     return rate;
/*     */   }
/*     */ 
/*     */   
/*     */   private void set2(BOOSTABLE_O cl, Recipe ii) {
/*  84 */     double mm = 1.0D / rate(ii.aiRate) * ii.bo.get(cl);
/*     */     
/*  86 */     if (this.bestR[ii.out.index()] == null)
/*  87 */       this.bestR[ii.out.index()] = ii;  byte b; int i;
/*     */     RecipeInput[] arrayOfRecipeInput;
/*  89 */     for (i = (arrayOfRecipeInput = ii.ins).length, b = 0; b < i; ) { RecipeInput recipeInput = arrayOfRecipeInput[b];
/*  90 */       if (this.bestTotal[recipeInput.res.index()] == Double.MAX_VALUE)
/*     */         return; 
/*  92 */       mm += recipeInput.rate * this.bestTotal[recipeInput.res.index()] / ii.aiRate * recipeInput.boost.get(cl);
/*     */       b++; }
/*     */     
/*  95 */     this.rateTot[ii.index] = mm;
/*     */ 
/*     */ 
/*     */     
/*  99 */     if (mm < this.bestTotal[ii.out.index()]) {
/* 100 */       this.bestTotal[ii.out.index()] = mm;
/* 101 */       this.bestR[ii.out.index()] = ii;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\recipe\RecipeRates.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */