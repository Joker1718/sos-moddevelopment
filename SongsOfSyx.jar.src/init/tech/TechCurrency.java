/*    */ package init.tech;
/*    */ 
/*    */ import game.boosting.BOOSTING;
/*    */ import game.boosting.Boostable;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ public final class TechCurrency
/*    */ {
/*    */   public final Boostable bo;
/*    */   public final int index;
/*    */   
/*    */   TechCurrency(Boostable bo, int index) {
/* 15 */     this.bo = bo;
/* 16 */     this.index = index;
/*    */   }
/*    */   
/*    */   static class TechCurrencies
/*    */   {
/* 21 */     public final ArrayListGrower<TechCurrency> all = new ArrayListGrower();
/*    */ 
/*    */     
/*    */     public LIST<TechCost> read(Json json) {
/* 25 */       ArrayListGrower<TechCost> cc = new ArrayListGrower();
/*    */       
/* 27 */       json = json.json("COSTS");
/*    */ 
/*    */ 
/*    */       
/* 31 */       for (String k : json.keys()) {
/* 32 */         Boostable bo = (Boostable)BOOSTING.MAP().tryGet(k);
/* 33 */         if (bo == null) {
/* 34 */           json.error("The boostable: " + k + "does not exist in this context. The boostable in question must be predefined in the game and can not be dynamic.", k);
/*    */         }
/* 36 */         double am = json.d(k, 0.0D, 1.0E7D);
/* 37 */         cc.add(add(bo, am));
/*    */       } 
/* 39 */       return (LIST<TechCost>)cc;
/*    */     }
/*    */     
/*    */     private TechCost add(Boostable bo, double am) {
/* 43 */       for (TechCurrency techCurrency : this.all) {
/* 44 */         if (techCurrency.bo == bo) {
/* 45 */           return new TechCost(techCurrency, am);
/*    */         }
/*    */       } 
/* 48 */       TechCurrency c = new TechCurrency(bo, this.all.size());
/* 49 */       this.all.add(c);
/* 50 */       return new TechCost(c, am);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\tech\TechCurrency.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */