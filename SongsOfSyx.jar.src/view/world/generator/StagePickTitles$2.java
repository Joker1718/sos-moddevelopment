/*    */ package view.world.generator;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import util.gui.misc.GButt;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 57 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 60 */     ACTION no = new ACTION()
/*    */       {
/*    */         public void exe() {}
/*    */       };
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 68 */     ACTION next = new ACTION()
/*    */       {
/*    */         public void exe()
/*    */         {
/* 72 */           stage.hasSelectedTitles = true;
/* 73 */           stage.set();
/*    */         }
/*    */       };
/*    */     
/* 77 */     if ((FACTIONS.player()).titles.selected() < 5 && (FACTIONS.player()).titles.unlocked() > (FACTIONS.player()).titles.selected()) {
/* 78 */       (VIEW.inters()).yesNo.activate(StagePickTitles.¤¤YouSure, next, no, true);
/*    */     } else {
/* 80 */       next.exe();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StagePickTitles$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */