/*    */ package settlement.stats.stat;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import game.time.TIMECYCLE;
/*    */ import init.race.Race;
/*    */ import init.type.HCLASS;
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
/*    */   implements HISTORY_INT.HISTORY_INT_OBJECT<Race>
/*    */ {
/*    */   public int min(Race t) {
/* 38 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max(Race t) {
/* 43 */     return STATFake.this.dataDivider() * STATFake.this.pdivider(c, t, 0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public double getD(Race t, int fromZero) {
/* 49 */     return STATFake.this.getDD(c, t, fromZero);
/*    */   }
/*    */ 
/*    */   
/*    */   public TIMECYCLE time() {
/* 54 */     return (TIMECYCLE)TIME.days();
/*    */   }
/*    */ 
/*    */   
/*    */   public int historyRecords() {
/* 59 */     return 32;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get(Race t, int fromZero) {
/* 64 */     double d = (STATFake.this.dataDivider() * STATFake.this.pdivider(c, t, fromZero));
/* 65 */     return (int)(STATFake.this.getDD(c, t, fromZero) * d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\STATFake$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */