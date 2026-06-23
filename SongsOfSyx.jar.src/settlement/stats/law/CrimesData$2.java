/*    */ package settlement.stats.law;
/*    */ 
/*    */ import init.type.CRIME_PUNISHMENTS;
/*    */ import init.type.HCLASS_RACE;
/*    */ import util.updating.IUpdater;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends IUpdater
/*    */ {
/*    */   null(int $anonymous0, double $anonymous1) {
/* 60 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void update(int i, double timeSinceLast) {
/* 65 */     HCLASS_RACE cl = (HCLASS_RACE)HCLASS_RACE.ALL().get(i / CRIME_PUNISHMENTS.ALL().size());
/* 66 */     CRIME_PUNISHMENTS.PUNISHMENT c = (CRIME_PUNISHMENTS.PUNISHMENT)CRIME_PUNISHMENTS.ALL().get(i % CRIME_PUNISHMENTS.ALL().size());
/* 67 */     c.stat().decRate(cl);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\law\CrimesData$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */