/*    */ package settlement.stats.disease;
/*    */ 
/*    */ import game.boosting.BValue;
/*    */ import game.boosting.Boostable;
/*    */ import game.faction.player.Player;
/*    */ import settlement.stats.STATS;
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
/* 43 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public double vGet(Player f) {
/* 47 */     return CLAMP.d((STATS.POP()).COUNT.newEntries(), 0.0D, 1.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\BoostsHealth$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */