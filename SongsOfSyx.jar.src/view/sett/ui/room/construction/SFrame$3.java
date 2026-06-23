/*    */ package view.sett.ui.room.construction;
/*    */ 
/*    */ import settlement.main.SETT;
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
/*    */ 
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
/*    */   extends GButt.Panel
/*    */ {
/*    */   null(SPRITE $anonymous0, CharSequence $anonymous1) {
/* 63 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 67 */     (SETT.ROOMS()).placement.placer.popHistory();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 72 */     activeSet((SETT.ROOMS()).placement.placer.hasHistory());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SFrame$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */