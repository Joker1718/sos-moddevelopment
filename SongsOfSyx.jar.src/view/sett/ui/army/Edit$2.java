/*    */ package view.sett.ui.army;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import game.battle.util.DIV_SPEC;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 83 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 89 */     for (Div d : Edit.this.all) {
/* 90 */       Edit.this.editor.copyChanges((DIV_SPEC.DIV_SPECE)d.info);
/*    */     }
/*    */     
/* 93 */     (VIEW.inters()).popup.close();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 98 */     activeSet(Edit.this.editor.hasChanges());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\Edit$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */