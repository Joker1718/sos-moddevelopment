/*    */ package world.army;
/*    */ 
/*    */ import snake2d.util.sets.ArrayListGrower;
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
/*    */   implements ADInit.Register
/*    */ {
/*    */   public void register(ADDiv div, int d) {
/* 92 */     if (div.army() != null) {
/* 93 */       for (int si = 0; si < all.size(); si++) {
/* 94 */         ((ADSupply)all.get(si)).setChanged(div.army());
/*    */       }
/*    */     }
/* 97 */     (AD.supplies()).creditsNeeded.inc(div.army(), d * div.costPerMan() * div.men());
/* 98 */     (AD.supplies()).creditsTarget.inc(div.army(), d * div.costPerMan() * div.menTarget());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADSupplies$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */