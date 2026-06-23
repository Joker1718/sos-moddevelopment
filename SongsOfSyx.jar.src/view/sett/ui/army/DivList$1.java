/*    */ package view.sett.ui.army;
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
/*    */ class null
/*    */   extends GTableBuilder
/*    */ {
/*    */   public int nrOFEntries() {
/* 43 */     int am = CLAMP.i(DivList.this.current.size(), 0, (Config.battle()).DIVISIONS_PER_ARMY);
/* 44 */     return (int)Math.ceil(am / DivList.xs);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\DivList$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */