/*    */ package settlement.stats.law;
/*    */ 
/*    */ import init.type.CRIMES;
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
/*    */ class null
/*    */   extends IUpdater
/*    */ {
/*    */   null(int $anonymous0, double $anonymous1) {
/* 49 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void update(int i, double timeSinceLast) {
/* 54 */     HCLASS_RACE cl = (HCLASS_RACE)HCLASS_RACE.ALL().get(i / CRIMES.ALL().size());
/* 55 */     CRIMES.CRIME c = (CRIMES.CRIME)CRIMES.ALL().get(i % CRIMES.ALL().size());
/* 56 */     c.stat().update(cl, timeSinceLast);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\law\CrimesData$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */