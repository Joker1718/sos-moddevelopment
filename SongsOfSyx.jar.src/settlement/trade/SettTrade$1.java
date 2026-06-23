/*    */ package settlement.trade;
/*    */ 
/*    */ import util.updating.IUpdater;
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
/*    */   extends IUpdater
/*    */ {
/*    */   null(int $anonymous0, double $anonymous1) {
/* 31 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void update(int i, double timeSinceLast) {
/* 35 */     SettTrade.this.buyers[i].deliver();
/* 36 */     SettTrade.this.sellers[i].extract();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\trade\SettTrade$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */