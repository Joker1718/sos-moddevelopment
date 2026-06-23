/*    */ package settlement.room.main.copy;
/*    */ 
/*    */ import settlement.main.SETT;
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
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 62 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 66 */     (SETT.ROOMS()).placement.placer.showFoundation.toggle();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 71 */     selectedSet((SETT.ROOMS()).placement.placer.showFoundation.is());
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 76 */     text.title((SETT.OVERLAY()).FOUNDATION.name);
/* 77 */     text.text((SETT.OVERLAY()).FOUNDATION.desc);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\copy\SavedPrintsPlacer$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */