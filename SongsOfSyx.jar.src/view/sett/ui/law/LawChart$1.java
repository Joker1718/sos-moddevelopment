/*    */ package view.sett.ui.law;
/*    */ 
/*    */ import init.type.CRIMES;
/*    */ import init.type.HCLASS;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.law.StatPunishment;
/*    */ import util.gui.misc.GButt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends GButt.Glow
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 36 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 39 */     STATS.LAW().punish((CRIMES.CRIME)CRIMES.all(cl).rnd(), cl, race.getRace(), t.punish);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\law\LawChart$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */