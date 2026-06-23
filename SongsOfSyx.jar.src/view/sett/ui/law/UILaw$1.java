/*    */ package view.sett.ui.law;
/*    */ 
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.law.Curfew;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
/*    */ import util.text.Dic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   null(SPRITE $anonymous0) {
/* 56 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 60 */     text.title(Curfew.¤¤name);
/* 61 */     text.text(Curfew.¤¤desc);
/* 62 */     text.NL(8);
/* 63 */     if (STATS.LAW().getCurfew().isSetForADay()) {
/* 64 */       text.text(Dic.¤¤Deactivate);
/*    */     } else {
/* 66 */       text.text(Dic.¤¤Activate);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 72 */     selectedSet(STATS.LAW().getCurfew().isSetForADay());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 77 */     STATS.LAW().getCurfew().setForADay(!STATS.LAW().getCurfew().isSetForADay());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\law\UILaw$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */