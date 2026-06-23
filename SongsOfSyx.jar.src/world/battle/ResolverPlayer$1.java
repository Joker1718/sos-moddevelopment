/*    */ package world.battle;
/*    */ 
/*    */ import world.battle.spec.BATTLE_RESULT;
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
/*    */   extends ResolverPlayer.Res
/*    */ {
/*    */   null(ResolverSide $anonymous0, ResolverSide $anonymous1, BATTLE_RESULT $anonymous2, ResolverSide.RCount $anonymous3, double $anonymous4) {
/* 54 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
/*    */   }
/*    */   
/*    */   public void accept(int[] enslave, int[] resources) {
/* 58 */     BattleListener.notify(pp, looser);
/* 59 */     shipRetreat(enslave, resources);
/* 60 */     looser.extract(losses);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\ResolverPlayer$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */