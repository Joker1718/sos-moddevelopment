/*    */ package settlement.recipe;
/*    */ 
/*    */ import game.boosting.Boostable;
/*    */ import init.trade.TRADABLE;
/*    */ 
/*    */ 
/*    */ public class RecipeInput
/*    */ {
/*    */   public final TRADABLE res;
/*    */   public final double rate;
/*    */   public final Boostable boost;
/*    */   
/*    */   RecipeInput(TRADABLE res, double rate, Boostable boost) {
/* 14 */     this.res = res;
/* 15 */     this.rate = rate;
/* 16 */     this.boost = boost;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\recipe\RecipeInput.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */