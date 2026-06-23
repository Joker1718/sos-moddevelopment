/*    */ package settlement.stats.colls;
/*    */ 
/*    */ import game.tourism.TOURISM;
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import settlement.stats.StatsInit;
/*    */ import settlement.stats.stat.STATFakeRace;
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
/*    */   extends STATFakeRace
/*    */ {
/*    */   null(String $anonymous0, StatsInit $anonymous1) {
/* 56 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   protected double getDD(Race r) {
/* 61 */     double res = 0.0D;
/* 62 */     double tot = 0.0D;
/* 63 */     for (Race other : RACES.all()) {
/* 64 */       tot += TOURISM.race(other);
/* 65 */       res += TOURISM.race(other) * (1.0D - r.pref().race(other));
/*    */     } 
/* 67 */     if (tot == 0.0D) {
/* 68 */       return 0.0D;
/*    */     }
/* 70 */     return (int)(res / tot);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsGovern$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */