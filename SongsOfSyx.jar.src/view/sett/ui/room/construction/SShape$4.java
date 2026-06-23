/*    */ package view.sett.ui.room.construction;
/*    */ 
/*    */ import snake2d.util.gui.GUI_BOX;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 78 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 82 */     SShape.this.s.placement.placer.showOverlay.toggle();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 87 */     selectedSet(SShape.this.s.placement.placer.showOverlay.is());
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 92 */     text.title(SShape.¤¤Overlay);
/* 93 */     if (SShape.this.s.placement.placer.blueprint().constructor().overlay() != null && (SShape.this.s.placement.placer.blueprint().constructor().overlay()).desc != null)
/* 94 */       text.text((SShape.this.s.placement.placer.blueprint().constructor().overlay()).desc); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SShape$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */