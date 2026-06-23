/*    */ package view.sett.ui.room.construction;
/*    */ 
/*    */ import settlement.tilemap.terrain.TBuilding;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
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
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 33 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 36 */     (VIEW.inters()).popup.show((RENDEROBJ)SMaterial.this.buttonsIndoor, (CLICKABLE)this);
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 40 */     replaceLabel(((TBuilding)SMaterial.this.s.placement.placer.structure.get()).iconCombo, DIR.C);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SMaterial$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */