/*    */ package view.tool;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
/*    */ import view.keyboard.KEYS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   null(SPRITE $anonymous0) {
/* 39 */     super($anonymous0);
/* 40 */     hoverInfoSet(String.valueOf((KEYS.MAIN()).MOD.repr()) + String.valueOf((KEYS.MAIN()).MOD.repr()));
/*    */   }
/*    */   protected void renAction() {
/* 43 */     activeSet((PlacableFixedTool.this.placable.size() > 0));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 48 */     if (PlacableFixedTool.this.placable.size() > 0)
/* 49 */       PlacableFixedTool.this.placable.sizeSet(PlacableFixedTool.this.placable.size() - 1); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PlacableFixedTool$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */