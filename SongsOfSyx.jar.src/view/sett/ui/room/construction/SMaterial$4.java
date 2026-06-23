/*    */ package view.sett.ui.room.construction;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
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
/*    */   null(SPRITE $anonymous0) {
/* 82 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 85 */     if (SMaterial.this.s.placement.placer.autoWalls.is()) {
/* 86 */       (VIEW.s()).tools.place(SMaterial.this.s.placement.placer.placerDoor.getUndo(), SMaterial.this.s.config);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 92 */     activeSet(SMaterial.this.s.placement.placer.autoWalls.is());
/* 93 */     selectedSet(((VIEW.s()).tools.placer.getCurrent() == SMaterial.this.s.placement.placer.placerDoor.getUndo()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SMaterial$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */