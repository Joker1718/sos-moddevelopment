/*    */ package settlement.stats.stat;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import game.time.TIMECYCLE;
/*    */ import init.race.Race;
/*    */ import util.statistics.HISTORY_INT;
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
/*    */   implements HISTORY_INT.HISTORY_INT_OBJECT<Race>
/*    */ {
/*    */   public int min(Race t) {
/* 23 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max(Race t) {
/* 28 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public double getD(Race t, int fromZero) {
/* 33 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public TIMECYCLE time() {
/* 38 */     return (TIMECYCLE)TIME.days();
/*    */   }
/*    */ 
/*    */   
/*    */   public int historyRecords() {
/* 43 */     return 32;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get(Race t, int fromZero) {
/* 48 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\STATInduOnly$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */