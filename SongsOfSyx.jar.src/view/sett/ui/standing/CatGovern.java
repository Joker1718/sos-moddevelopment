/*    */ package view.sett.ui.standing;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.type.HCLASS;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.stat.STAT;
/*    */ import settlement.stats.stat.StatCollection;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GButt;
/*    */ import util.gui.table.GScrollRows;
/*    */ import util.text.D;
/*    */ import view.interrupter.ISidePanel;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ final class CatGovern
/*    */   extends Cats.Cat {
/* 20 */   private static CharSequence ¤¤name = "¤Government";
/* 21 */   private static CharSequence ¤¤manageLaw = "¤Manage Law";
/*    */   static {
/* 23 */     D.ts(CatGovern.class);
/*    */   }
/*    */   
/*    */   CatGovern(HCLASS cl, GETTER<Race> race) {
/* 27 */     super(new StatCollection[] { (StatCollection)STATS.LAW(), (StatCollection)STATS.GOVERN() });
/* 28 */     titleSet(¤¤name);
/*    */     
/* 30 */     LinkedList<RENDEROBJ> rens = new LinkedList();
/*    */     
/* 32 */     rens.add(new StatRow.Title((STATS.GOVERN()).info));
/* 33 */     for (STAT s : STATS.GOVERN().all()) {
/* 34 */       GuiSection ss = new StatRow(s, cl, race);
/* 35 */       rens.add(ss);
/*    */     } 
/*    */     
/* 38 */     rens.add(new StatRow.Title((STATS.LAW()).info));
/*    */     
/* 40 */     for (STAT s : STATS.LAW().all()) {
/* 41 */       GuiSection ss = new StatRow(s, cl, race);
/* 42 */       rens.add(ss);
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 63 */     rens.add(new GButt.ButtPanel(¤¤manageLaw)
/*    */         {
/*    */           protected void clickA() {
/* 66 */             (VIEW.s()).panels.add((ISidePanel)(VIEW.s()).ui.law, true);
/*    */           }
/*    */         });
/*    */ 
/*    */ 
/*    */     
/* 72 */     this.section.addDown(4, (RENDEROBJ)(new GScrollRows((Iterable)rens, HEIGHT, 0)).view());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatGovern.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */