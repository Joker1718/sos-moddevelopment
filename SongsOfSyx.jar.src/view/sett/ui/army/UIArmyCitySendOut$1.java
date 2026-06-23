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
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GTableBuilder
/*    */ {
/*    */   public int nrOFEntries() {
/* 46 */     int am = CLAMP.i(UIArmyCitySendOut.this.current.size() + 1, 0, (Config.battle()).DIVISIONS_PER_ARMY);
/* 47 */     return (int)Math.ceil(am / UIArmyCitySendOut.xs);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\UIArmyCitySendOut$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */