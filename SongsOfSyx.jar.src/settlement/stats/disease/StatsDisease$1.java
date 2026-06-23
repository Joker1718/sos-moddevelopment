/*    */ package settlement.stats.disease;
/*    */ 
/*    */ import game.boosting.BOOSTABLES;
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import game.time.TIMECYCLE;
/*    */ import init.type.HCLASS_RACE;
/*    */ import util.statistics.HistoryInt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends HistoryInt
/*    */ {
/*    */   null(int $anonymous0, TIMECYCLE $anonymous1, boolean $anonymous2) {
/* 29 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public double getD(int fromZero) {
/* 33 */     return get(fromZero) / 1024.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get(int fromZero) {
/* 38 */     if (fromZero == 0)
/* 39 */       return (int)((BOOSTABLES.PHYSICS()).HEALTH.get((BOOSTABLE_O)HCLASS_RACE.clP()) * 1024.0D); 
/* 40 */     return super.get(fromZero);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\StatsDisease$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */