/*    */ package settlement.stats.disease;
/*    */ 
/*    */ import game.boosting.BValue;
/*    */ import game.boosting.Boostable;
/*    */ import game.faction.player.Player;
/*    */ import settlement.stats.POP;
/*    */ import snake2d.util.misc.CLAMP;
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
/*    */   extends BValue.BValueFaction
/*    */ {
/*    */   null(Boostable $anonymous0) {
/* 29 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public double vGet(Player f) {
/* 33 */     double d = 1.0D - 5.0D / (1 + POP.tot(null, null));
/* 34 */     d = CLAMP.d(d, 0.0D, 1.0D);
/* 35 */     return d;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\BoostsHealth$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */