/*    */ package view.world.ui.panels;
/*    */ 
/*    */ import game.boosting.BOOSTABLES;
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import game.faction.FACTIONS;
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
/*    */ class null
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 31 */     GFORMAT.iofk(text, (int)(BOOSTABLES.CIVICS()).GOV.get((BOOSTABLE_O)FACTIONS.player()), (int)(BOOSTABLES.CIVICS()).GOV.added((BOOSTABLE_O)FACTIONS.player()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\panels\UIAdminPanel$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */