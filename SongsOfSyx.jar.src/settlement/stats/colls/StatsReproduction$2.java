/*    */ package settlement.stats.colls;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.type.HCLASS;
/*    */ import init.type.HCLASS_RACE;
/*    */ import settlement.stats.StatsInit;
/*    */ import settlement.stats.stat.STATFakeData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends STATFakeData
/*    */ {
/*    */   null(String $anonymous0, StatsInit $anonymous1) {
/* 78 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected double getDD(HCLASS cl, Race r) {
/* 82 */     if (StatsReproduction.this.forcedSetting.get((HCLASS_RACE.clP(r, cl)).index))
/* 83 */       return 0.0D; 
/* 84 */     return 1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsReproduction$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */