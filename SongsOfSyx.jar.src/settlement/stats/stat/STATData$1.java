/*    */ package settlement.stats.stat;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.type.HCLASS;
/*    */ import settlement.stats.StatsInit;
/*    */ import util.info.INFO;
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
/*    */   extends SETT_STATISTICS.SettStatistics
/*    */ {
/*    */   null(String $anonymous0, StatsInit $anonymous1, INFO $anonymous2) {
/* 42 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   protected int popDivider(HCLASS c, Race r, int daysback) {
/* 46 */     return STATData.this.pdivider(c, r, daysback);
/*    */   }
/*    */ 
/*    */   
/*    */   public int dataDivider() {
/* 51 */     return STATData.this.dataDivider();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\STATData$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */