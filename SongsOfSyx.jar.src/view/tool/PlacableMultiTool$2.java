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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 57 */     super($anonymous0);
/* 58 */     hoverInfoSet(String.valueOf((KEYS.MAIN()).MOD.repr()) + String.valueOf((KEYS.MAIN()).MOD.repr()));
/*    */   }
/*    */   protected void renAction() {
/* 61 */     activeSet((PlacableMultiTool.this.type.usesSize && PlacableMultiTool.this.size > 0));
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 65 */     PlacableMultiTool.this.radius(-1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PlacableMultiTool$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */