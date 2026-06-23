/*    */ package view.sett.ui.room.construction;
/*    */ 
/*    */ import settlement.main.SETT;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 51 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 54 */     (VIEW.inters()).popup.show((RENDEROBJ)Shared.this.buttonsIndoor, (CLICKABLE)this);
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 58 */     replaceLabel(((TBuilding)(SETT.ROOMS()).placement.placer.structure.get()).iconCombo, DIR.C);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\Shared$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */