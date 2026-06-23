/*    */ package settlement.stats.stat;
/*    */ 
/*    */ import init.race.Race;
/*    */ import settlement.stats.StatsInit;
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
/*    */   extends DataRaces
/*    */ {
/*    */   null(String $anonymous0, StatsInit $anonymous1, boolean $anonymous2) {
/* 79 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public double getD(Race t, int fromZero) {
/* 83 */     double d = (SETT_STATISTICS.SettStatisticsClRace.this.popDivider(null, t, fromZero) * SETT_STATISTICS.SettStatisticsClRace.this.dataDivider());
/* 84 */     if (d == 0.0D)
/* 85 */       return 0.0D; 
/* 86 */     return get(t, fromZero) / d;
/*    */   }
/*    */ 
/*    */   
/*    */   public int min(Race t) {
/* 91 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max(Race t) {
/* 96 */     return SETT_STATISTICS.SettStatisticsClRace.this.popDivider(null, t, 0) * SETT_STATISTICS.SettStatisticsClRace.this.dataDivider();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\SETT_STATISTICS$SettStatisticsClRace$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */