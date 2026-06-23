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
/*    */ class null
/*    */   extends DataRaces
/*    */ {
/*    */   null(String $anonymous0, StatsInit $anonymous1, boolean $anonymous2) {
/* 32 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public double getD(Race t, int fromZero) {
/* 36 */     double d = STATFakeRace.this.dataDivider();
/* 37 */     if (d == 0.0D)
/* 38 */       return 0.0D; 
/* 39 */     return get(t, fromZero) / d;
/*    */   }
/*    */ 
/*    */   
/*    */   public int min(Race t) {
/* 44 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max(Race t) {
/* 49 */     return Integer.MAX_VALUE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\STATFakeRace$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */