/*    */ package view.battle;
/*    */ 
/*    */ import init.constant.Config;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import util.gui.table.GTableBuilder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends GTableBuilder
/*    */ {
/*    */   public int nrOFEntries() {
/* 59 */     int am = CLAMP.i(UIPanelUnitCards.this.current.size(), 0, (Config.battle()).DIVISIONS_PER_ARMY);
/* 60 */     return (int)Math.ceil(am / UIPanelUnitCards.xs);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\UIPanelUnitCards$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */