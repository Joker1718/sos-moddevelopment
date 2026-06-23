/*    */ package settlement.entry;
/*    */ 
/*    */ import game.boosting.BSourceInfo;
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import init.race.Race;
/*    */ import world.WORLD;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends Immigration.Bo
/*    */ {
/*    */   null(BSourceInfo $anonymous0, double $anonymous1, double $anonymous2, boolean $anonymous3) {
/* 68 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*    */   }
/*    */   
/*    */   protected double g(Race race) {
/* 72 */     return vNOPInput();
/*    */   }
/*    */ 
/*    */   
/*    */   protected double w(Race race) {
/* 77 */     return WORLD.camps().replenishPerDay((Faction)FACTIONS.player(), race) / 1000.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entry\Immigration$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */