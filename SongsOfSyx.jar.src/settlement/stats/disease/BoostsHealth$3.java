/*    */ package settlement.stats.disease;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import game.boosting.BValue;
/*    */ import settlement.stats.Induvidual;
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
/*    */   extends BValue.BValueInduOnly
/*    */ {
/*    */   public double vGet(Div div) {
/* 59 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double vGet(Induvidual indu) {
/* 64 */     if (indu.hType().parent() != indu.hType()) {
/* 65 */       return 1.0D;
/*    */     }
/* 67 */     return 0.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\BoostsHealth$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */