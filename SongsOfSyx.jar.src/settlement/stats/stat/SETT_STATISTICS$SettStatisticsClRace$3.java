/*    */ package settlement.stats.stat;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.type.HCLASS;
/*    */ import init.type.HCLASSES;
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
/*    */ class null
/*    */   extends DataRaces
/*    */ {
/*    */   null(String $anonymous0, StatsInit $anonymous1, boolean $anonymous2) {
/* 54 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public double getD(Race t, int fromZero) {
/* 58 */     double d = (SETT_STATISTICS.SettStatisticsClRace.this.popDivider((HCLASS)HCLASSES.ALL().get(k), t, fromZero) * SETT_STATISTICS.SettStatisticsClRace.this.dataDivider());
/* 59 */     if (d == 0.0D)
/* 60 */       return 0.0D; 
/* 61 */     return get(t, fromZero) / d;
/*    */   }
/*    */ 
/*    */   
/*    */   public int min(Race t) {
/* 66 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max(Race t) {
/* 71 */     return SETT_STATISTICS.SettStatisticsClRace.this.popDivider((HCLASS)HCLASSES.ALL().get(k), t, 0) * SETT_STATISTICS.SettStatisticsClRace.this.dataDivider();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\SETT_STATISTICS$SettStatisticsClRace$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */