/*    */ package settlement.room.main.copy;
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
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   private String s;
/*    */   
/*    */   null(SPRITE $anonymous0) {
/* 82 */     super($anonymous0);
/*    */     
/* 84 */     this.s = "Include walls";
/*    */   }
/*    */   protected void clickA() {
/* 87 */     SavedPrintsPlacer.this.w = !SavedPrintsPlacer.this.w;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 92 */     selectedSet(SavedPrintsPlacer.this.w);
/*    */   }
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 96 */     text.text(this.s);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\copy\SavedPrintsPlacer$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */