/*    */ package view.sett.ui.standing;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.type.HCLASS;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.colls.StatsEducation;
/*    */ import util.data.GETTER;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends GButt.CheckboxSelect
/*    */ {
/*    */   protected void clickA() {
/* 85 */     STATS.EDUCATION().policySet(cl, (Race)race.get(), e);
/* 86 */     super.clickA();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 91 */     selectedSet((STATS.EDUCATION().policy(cl, (Race)race.get()) == e));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatOccupation$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */