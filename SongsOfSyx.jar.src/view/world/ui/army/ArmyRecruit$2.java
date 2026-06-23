/*    */ package view.world.ui.army;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.colls.StatsBattle;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import world.army.WDivRegional;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 67 */     GFORMAT.i(text, (long)ti());
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 72 */     b.text(ArmyRecruit.¤¤Time);
/*    */   }
/*    */ 
/*    */   
/*    */   double ti() {
/* 77 */     int am = WDivRegional.DAYS_TO_TRAIN;
/*    */     
/* 79 */     for (StatsBattle.StatTraining t : (STATS.BATTLE()).TRAINING_ALL) {
/* 80 */       am += WDivRegional.trainingDays(t, ArmyRecruit.this.editor.div().training(t), (Faction)FACTIONS.player());
/*    */     }
/*    */     
/* 83 */     return am;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\ArmyRecruit$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */