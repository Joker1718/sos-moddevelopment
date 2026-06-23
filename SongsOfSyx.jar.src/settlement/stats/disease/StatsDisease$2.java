/*    */ package settlement.stats.disease;
/*    */ 
/*    */ import game.boosting.BOOSTABLES;
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import init.type.HCLASS_RACE;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   implements StatsInit.StatUpdatable
/*    */ {
/*    */   public void update(double ds) {
/* 65 */     StatsDisease.this.healthHistory.set((int)((BOOSTABLES.PHYSICS()).HEALTH.get((BOOSTABLE_O)HCLASS_RACE.clP()) * 1024.0D));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\StatsDisease$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */