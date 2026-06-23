/*    */ package view.sett.ui.home;
/*    */ 
/*    */ import init.type.HGROUP;
/*    */ import settlement.main.SETT;
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
/*    */ 
/*    */ 
/*    */ 
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
/* 70 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   GText format(GText t, HGROUP h) {
/* 75 */     int am = (SETT.ROOMS()).HOME.total(h) - (SETT.ROOMS()).HOME.used(h);
/*    */ 
/*    */     
/* 78 */     return GFORMAT.i(t, am);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\home\UIHomesTable$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */