/*    */ package view.sett.ui.room.construction;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.tilemap.terrain.TBuilding;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
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
/*    */ class null
/*    */   extends GButt.Panel
/*    */ {
/*    */   null(SPRITE $anonymous0, CharSequence $anonymous1) {
/* 25 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 28 */     GBox b = (GBox)text;
/* 29 */     b.title(t.structure.name);
/* 30 */     Shared.this.buttonIndoor.hoverInfoGet(text);
/* 31 */     b.NL();
/* 32 */     b.text(t.structure.desc);
/* 33 */     b.setResource(t.structure.resource, t.structure.resAmount);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 38 */     (SETT.ROOMS()).placement.placer.structure.set(t);
/* 39 */     (VIEW.inters()).popup.close();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 44 */     selectedSet(((SETT.ROOMS()).placement.placer.structure.get() == t));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\Shared$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */