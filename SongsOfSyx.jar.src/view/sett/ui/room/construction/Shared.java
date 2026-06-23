/*    */ package view.sett.ui.room.construction;
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.SETT;
/*    */ import settlement.tilemap.terrain.TBuilding;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GButt;
/*    */ import util.text.D;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ public class Shared {
/* 17 */   private final GuiSection buttonsIndoor = new GuiSection(); private final CLICKABLE buttonIndoor;
/*    */   
/*    */   Shared() {
/* 20 */     D.gInit(this);
/*    */     
/* 22 */     for (TBuilding t : (SETT.TERRAIN()).BUILDINGS.all()) {
/*    */ 
/*    */       
/* 25 */       GButt.Panel panel = new GButt.Panel(t.iconCombo, t.structure.desc)
/*    */         {
/*    */           public void hoverInfoGet(GUI_BOX text) {
/* 28 */             GBox b = (GBox)text;
/* 29 */             b.title(t.structure.name);
/* 30 */             Shared.this.buttonIndoor.hoverInfoGet(text);
/* 31 */             b.NL();
/* 32 */             b.text(t.structure.desc);
/* 33 */             b.setResource(t.structure.resource, t.structure.resAmount);
/*    */           }
/*    */ 
/*    */           
/*    */           protected void clickA() {
/* 38 */             (SETT.ROOMS()).placement.placer.structure.set(t);
/* 39 */             (VIEW.inters()).popup.close();
/*    */           }
/*    */ 
/*    */           
/*    */           protected void renAction() {
/* 44 */             selectedSet(((SETT.ROOMS()).placement.placer.structure.get() == t));
/*    */           }
/*    */         };
/* 47 */       this.buttonsIndoor.addDownC(0, (RENDEROBJ)panel);
/*    */     } 
/*    */ 
/*    */     
/* 51 */     this
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 60 */       .buttonIndoor = (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.cancel) { protected void clickA() { (VIEW.inters()).popup.show((RENDEROBJ)Shared.this.buttonsIndoor, (CLICKABLE)this); } protected void renAction() { replaceLabel(((TBuilding)(SETT.ROOMS()).placement.placer.structure.get()).iconCombo, DIR.C); } }).hoverInfoSet(D.g("indoor", "This room requires to be built indoors and you must pick a structure type."));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\Shared.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */