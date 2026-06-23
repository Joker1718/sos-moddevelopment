/*    */ package game.faction.npc;
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
/*    */ 
/*    */ class null
/*    */   extends FResources
/*    */ {
/*    */   null(int $anonymous0, TIMECYCLE $anonymous1) {
/* 44 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public int getAvailable(TRADABLE t) {
/* 48 */     return (int)FactionNPC.this.stockpile.res(t).amount();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\npc\FactionNPC$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */