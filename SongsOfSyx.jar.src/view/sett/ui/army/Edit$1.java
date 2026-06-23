/*    */ package view.sett.ui.army;
/*    */ 
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import game.faction.FACTIONS;
/*    */ import settlement.room.military.training.ROOM_M_TRAINER;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.colls.StatsBattle;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 59 */     GFORMAT.i(text, (long)ti());
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 64 */     b.text(Edit.¤¤Time);
/*    */   }
/*    */ 
/*    */   
/*    */   double ti() {
/* 69 */     double am = ROOM_M_TRAINER.basicTrainingTimedays();
/*    */     
/* 71 */     for (StatsBattle.StatTraining t : (STATS.BATTLE()).TRAINING_ALL) {
/* 72 */       am += t.room.TRAINING_DAYS * Edit.this.editor.div().training(t) / t.room.bonus().get((BOOSTABLE_O)FACTIONS.player());
/*    */     }
/*    */     
/* 75 */     return am;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\Edit$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */