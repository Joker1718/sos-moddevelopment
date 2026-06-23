/*    */ package settlement.room.main.copy;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
/*    */ import util.text.Dic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 40 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 44 */     (SETT.ROOMS()).placement.placer.showOverlay.toggle();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 49 */     selectedSet((SETT.ROOMS()).placement.placer.showOverlay.is());
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 54 */     text.title(Dic.¤¤Overlay);
/* 55 */     (SETT.ROOMS()).placement.placer.structure.get();
/* 56 */     if (SavedPrintsPlacer.this.swap.current().constructor().overlay() != null && (SavedPrintsPlacer.this.swap.current().constructor().overlay()).desc != null)
/* 57 */       text.text((SavedPrintsPlacer.this.swap.current().constructor().overlay()).desc); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\copy\SavedPrintsPlacer$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */