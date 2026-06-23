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
/*    */ class null
/*    */   extends GButt.Panel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 46 */     super($anonymous0);
/* 47 */     hoverInfoSet(String.valueOf((KEYS.MAIN()).MOD.repr()) + String.valueOf((KEYS.MAIN()).MOD.repr()));
/*    */   }
/*    */   protected void renAction() {
/* 50 */     activeSet((PlacableMultiTool.this.type.usesSize && PlacableMultiTool.this.size < 15));
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 54 */     PlacableMultiTool.this.radius(1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PlacableMultiTool$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */