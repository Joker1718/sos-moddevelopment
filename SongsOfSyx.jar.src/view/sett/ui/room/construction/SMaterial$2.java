/*    */ package view.sett.ui.room.construction;
/*    */ 
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
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 44 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 47 */     SMaterial.this.s.placement.placer.autoWalls.toggle();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 52 */     selectedSet(SMaterial.this.s.placement.placer.autoWalls.is());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SMaterial$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */