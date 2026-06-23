/*    */ package game.faction.player;
/*    */ 
/*    */ import game.faction.FResources;
/*    */ import game.time.TIMECYCLE;
/*    */ import init.trade.TRADABLE;
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
/*    */   extends FResources
/*    */ {
/*    */   null(int $anonymous0, TIMECYCLE $anonymous1) {
/* 43 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public int getAvailable(TRADABLE t) {
/* 47 */     int a = t.ps().playerOwned();
/* 48 */     return (int)Math.ceil(a * 0.9D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\Player$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */