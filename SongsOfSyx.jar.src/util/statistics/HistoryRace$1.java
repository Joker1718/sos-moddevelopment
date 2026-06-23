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
/*    */ class null
/*    */   extends HistoryInt
/*    */ {
/*    */   null(int $anonymous0, TIMECYCLE $anonymous1, boolean $anonymous2) {
/* 24 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   protected void change(int old, int current) {
/* 27 */     HistoryRace.this.total.inc(-old);
/* 28 */     HistoryRace.this.total.inc(current);
/* 29 */     HistoryRace.this.change(r, old, current);
/*    */   }
/*    */   
/*    */   public int max() {
/* 33 */     return HistoryRace.this.max(r);
/*    */   }
/*    */   
/*    */   public int min() {
/* 37 */     return HistoryRace.this.min(r);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\statistics\HistoryRace$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */