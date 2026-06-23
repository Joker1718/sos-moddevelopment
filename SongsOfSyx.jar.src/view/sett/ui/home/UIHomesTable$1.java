/*    */ package view.sett.ui.home;
/*    */ 
/*    */ import init.type.HGROUP;
/*    */ import settlement.stats.STATS;
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
/*    */ class null
/*    */   extends UIHomesTable.Data
/*    */ {
/*    */   null(CharSequence $anonymous0, CharSequence $anonymous1) {
/* 50 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   GText format(GText t, HGROUP h) {
/* 54 */     return GFORMAT.i(t, (STATS.HOME()).GETTER.stat().data(h.type).get(h.race));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\home\UIHomesTable$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */