/*    */ package settlement.stats.colls;
/*    */ 
/*    */ import init.race.Race;
/*    */ import settlement.stats.StatsInit;
/*    */ import settlement.stats.stat.STATFakeRace;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 65 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected double getDD(Race r) {
/* 69 */     double am = 0.0D;
/* 70 */     for (StatsBurial.StatGrave g : graves)
/* 71 */       am += (g.grave()).disturbance.getD(); 
/* 72 */     return am;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsBurial$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */