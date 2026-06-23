/*    */ package view.sett.ui.room;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
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
/*    */ class Entry
/*    */   extends CLICKABLE.ClickableAbs
/*    */ {
/*    */   private final int col;
/*    */   private GETTER<Integer> ier;
/*    */   
/*    */   Entry(GETTER<Integer> ier, int col) {
/* 55 */     this.ier = ier;
/* 56 */     this.col = col;
/* 57 */     this.body.setDim(ConstructionList.WIDTH, 48.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 62 */     int i = ((Integer)this.ier.get()).intValue() * ConstructionList.XX + this.col;
/* 63 */     if (i >= (SETT.ROOMS()).construction.instances()) {
/*    */       return;
/*    */     }
/* 66 */     (SETT.ROOMS()).construction.clickButt(i);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 71 */     int i = ((Integer)this.ier.get()).intValue() * ConstructionList.XX + this.col;
/* 72 */     if (i >= (SETT.ROOMS()).construction.instances()) {
/*    */       return;
/*    */     }
/* 75 */     (SETT.ROOMS()).construction.hoverButt((GBox)text, i);
/*    */     
/* 77 */     super.hoverInfoGet(text);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 82 */     int i = ((Integer)this.ier.get()).intValue() * ConstructionList.XX + this.col;
/* 83 */     if (i >= (SETT.ROOMS()).construction.instances()) {
/*    */       return;
/*    */     }
/* 86 */     GButt.ButtPanel.renderBG(r, true, false, isHovered, (RECTANGLE)this.body);
/* 87 */     (SETT.ROOMS()).construction.renderButt(r, this.body.x1() + 8, this.body.cY(), i);
/* 88 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ConstructionList$Entry.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */