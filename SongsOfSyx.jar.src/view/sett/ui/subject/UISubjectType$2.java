/*    */ package view.sett.ui.subject;
/*    */ 
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
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
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 54 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 58 */     (STATS.APPEARANCE()).favo.set(a.a.indu(), (STATS.APPEARANCE()).favo.get(a.a.indu()) + 1 & 0x1);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 63 */     selectedSet(((STATS.APPEARANCE()).favo.get(a.a.indu()) == 1));
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 68 */     text.text(UISubjectType.¤¤favourite);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectType$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */