/*    */ package view.sett.ui.noble;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import init.type.HCLASS_RACE;
/*    */ import snake2d.util.gui.GUI_BOX;
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
/*    */ class null
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 53 */     GFORMAT.iofkInv(text, GAME.NOBLE().ranksAllocated(), (int)(GAME.NOBLE()).MAX_RANKS.get((BOOSTABLE_O)HCLASS_RACE.clP()));
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 58 */     b.text((GAME.NOBLE()).MAX_RANKS.desc);
/* 59 */     b.NL();
/* 60 */     (GAME.NOBLE()).MAX_RANKS.hoverDetailed((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(), null, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\noble\UINobles$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */