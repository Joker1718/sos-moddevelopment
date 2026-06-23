/*    */ package settlement.stats.colls;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.resources.RESOURCE;
/*    */ import init.type.HCLASS;
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.StatsInit;
/*    */ import settlement.stats.stat.STATFake;
/*    */ import settlement.stats.stat.StatInfo;
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
/*    */   null(String $anonymous0, StatsInit $anonymous1, StatInfo $anonymous2) {
/* 40 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   protected double getDD(HCLASS s, Race r, int daysBack) {
/* 44 */     if (pdivider(null, null, daysBack) == 0)
/* 45 */       return (((SETT.ROOMS()).STOCKPILE.tally().amountsDay().get(res.bIndex()).get(daysBack) > 0) ? true : false); 
/* 46 */     return (SETT.ROOMS()).STOCKPILE.tally().amountsDay().get(res.bIndex()).get(daysBack) / pdivider(null, null, daysBack);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsStored$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */