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
/*    */ class null
/*    */   extends STATFakeRace
/*    */ {
/*    */   null(String $anonymous0, StatsInit $anonymous1) {
/* 38 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected double getDD(Race r) {
/* 42 */     double res = 0.0D;
/* 43 */     double tot = 0.0D;
/* 44 */     for (Race other : RACES.all()) {
/* 45 */       tot += TOURISM.race(other);
/* 46 */       res += TOURISM.race(other) * r.pref().race(other);
/*    */     } 
/* 48 */     if (tot == 0.0D) {
/* 49 */       return 0.0D;
/*    */     }
/* 51 */     return res / tot;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsGovern$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */