/*    */ package view.battle.editor;
/*    */ 
/*    */ import util.gui.misc.GButt;
/*    */ import view.main.VIEW;
/*    */ import view.tool.PLACABLE;
/*    */ import world.WORLD;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 43 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 46 */     (VIEW.b()).editor.tools.place((PLACABLE)Inter.this.placer);
/* 47 */     if (!(WORLD.GEN()).hasGeneratedTerrain) {
/* 48 */       Inter.this.placer.generate.exe();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 55 */     activeSet((Inter.this.player.divs.size() > 0 && Inter.this.enemy.divs.size() > 0));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\Inter$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */