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
/* 58 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   GText format(GText t, HGROUP h) {
/* 62 */     int am = (STATS.HOME()).GETTER.hasSearched.data(h.type).get(h.race);
/* 63 */     GFORMAT.i(t, am);
/* 64 */     if (am > 0)
/* 65 */       t.errorify(); 
/* 66 */     return t;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\home\UIHomesTable$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */