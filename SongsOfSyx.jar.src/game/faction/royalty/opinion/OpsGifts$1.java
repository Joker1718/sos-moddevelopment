/*    */ package game.faction.royalty.opinion;
/*    */ 
/*    */ import game.boosting.BOOSTABLES;
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import game.boosting.superb.SuperBoostableObj;
/*    */ import game.faction.royalty.Royalty;
/*    */ import snake2d.util.sprite.SPRITE;
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
/*    */   extends ROpper.ROpperDown
/*    */ {
/*    */   null(String $anonymous0, CharSequence $anonymous1, CharSequence $anonymous2, SPRITE $anonymous3, double $anonymous4, boolean $anonymous5, double $anonymous6) {
/* 26 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5, $anonymous6);
/*    */   }
/*    */   public double getModifier(Royalty roy) {
/* 29 */     return 0.25D + 0.75D * (BOOSTABLES.NOBLE()).PRIDE.get((BOOSTABLE_O)roy.induvidual);
/*    */   }
/*    */ 
/*    */   
/*    */   public double increase(Royalty roy) {
/* 34 */     return (1.0D + 99.0D * this.value.getD(roy)) * super.increase(roy);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\OpsGifts$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */