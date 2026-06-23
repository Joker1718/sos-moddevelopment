/*    */ package view.battle.editor;
/*    */ 
/*    */ import game.battle.util.DIV_SPEC;
/*    */ import util.gui.misc.GButt;
/*    */ import view.ui.div.UIDivEditor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 74 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 78 */     ((ArmySide)Army.this.current.get()).divs.add((new DIV_SPEC.DIV_SPECImp()).copyFrom((DIV_SPEC)editor.div()));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 83 */     activeSet(((ArmySide)Army.this.current.get()).divs.hasRoom());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\Army$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */