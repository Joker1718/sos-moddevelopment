/*    */ package util.statistics;
/*    */ 
/*    */ import game.time.TIMECYCLE;
/*    */ import init.race.Race;
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
/*    */   extends HistoryInt
/*    */ {
/*    */   null(int $anonymous0, TIMECYCLE $anonymous1, boolean $anonymous2) {
/* 50 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   protected void change(int old, int current) {
/* 53 */     HistoryRace.this.total.inc(-old);
/* 54 */     HistoryRace.this.total.inc(current);
/* 55 */     HistoryRace.this.change(r, old, current);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\statistics\HistoryRace$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */