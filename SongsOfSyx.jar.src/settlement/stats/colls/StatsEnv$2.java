/*    */ package settlement.stats.colls;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.type.HCLASS;
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.StatsInit;
/*    */ import settlement.stats.stat.STATFake;
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
/*    */   extends STATFake
/*    */ {
/*    */   null(String $anonymous0, StatsInit $anonymous1) {
/* 69 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected double getDD(HCLASS s, Race r, int daysBack) {
/* 73 */     if (r == null) {
/* 74 */       double m = 0.0D;
/* 75 */       for (Race rr : RACES.all()) {
/* 76 */         m += rr.population().climate(SETT.ENV().climate()) * (STATS.POP()).POP.data(s).get(rr, daysBack);
/*    */       }
/* 78 */       double p = (STATS.POP()).POP.data(s).get(null, daysBack);
/* 79 */       if (p == 0.0D)
/* 80 */         return ((m > 0.0D) ? true : false); 
/* 81 */       return m / p;
/*    */     } 
/* 83 */     return r.population().climate(SETT.ENV().climate());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsEnv$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */