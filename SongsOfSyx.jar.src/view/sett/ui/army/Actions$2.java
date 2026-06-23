/*    */ package view.sett.ui.army;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.battle.div.Div;
/*    */ import game.faction.FACTIONS;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.colls.StatsBattle;
/*    */ import settlement.stats.equip.EquipBattle;
/*    */ import util.gui.misc.GButt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 77 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 82 */     Div n = GAME.ARMIES().player().getNextEmptyOrdered();
/* 83 */     if (n == null)
/*    */       return; 
/* 85 */     n.info.raceSet(FACTIONS.player().race());
/* 86 */     n.info.menSet(50);
/* 87 */     for (EquipBattle e : STATS.EQUIP().BATTLE_ALL())
/* 88 */       e.targetSet(n, 0); 
/* 89 */     for (StatsBattle.StatTraining e : (STATS.BATTLE()).TRAINING_ALL)
/* 90 */       n.info.trainingSet(e, 0.0D); 
/* 91 */     Actions.access$0(Actions.this, null);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 96 */     activeSet(false);
/* 97 */     for (Div d : GAME.ARMIES().player().divisions()) {
/* 98 */       if (d.info.men() == 0) {
/* 99 */         activeSet(true);
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\Actions$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */