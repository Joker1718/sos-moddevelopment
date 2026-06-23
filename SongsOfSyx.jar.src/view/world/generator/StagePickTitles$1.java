/*    */ package view.world.generator;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import snake2d.util.sprite.text.Font;
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
/*    */ class null
/*    */   extends GStat
/*    */ {
/*    */   null(Font $anonymous0) {
/* 40 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void update(GText text) {
/* 44 */     GFORMAT.iofkInv(text, (FACTIONS.player()).titles.selected(), 5L);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StagePickTitles$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */