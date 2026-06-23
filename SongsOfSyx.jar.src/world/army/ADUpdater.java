/*    */ package world.army;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.time.TIME;
/*    */ import util.updating.IUpdater;
/*    */ import world.entity.army.WArmy;
/*    */ 
/*    */ final class ADUpdater
/*    */   extends IUpdater
/*    */ {
/*    */   public ADUpdater(ADInit init) {
/* 13 */     super(FACTIONS.MAX(), TIME.secondsPerDay() * 0.25D);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void update(int i, double timeSinceLast) {
/* 19 */     Faction f = (i == 0) ? null : FACTIONS.getByIndex(i - 1);
/*    */     
/* 21 */     for (ADInit.Updater u : (AD.iinit()).updaters) {
/* 22 */       u.update(f, timeSinceLast);
/*    */     }
/* 24 */     ADArmies as = AD.army(f);
/*    */     
/* 26 */     for (int ai = 0; ai < as.all().size(); ai++) {
/* 27 */       WArmy a = (WArmy)as.all().get(ai);
/* 28 */       for (ADInit.Updater u : (AD.iinit()).updaters)
/* 29 */         u.update(a, timeSinceLast); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADUpdater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */