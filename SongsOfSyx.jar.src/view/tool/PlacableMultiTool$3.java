/*    */ package view.tool;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 72 */     super($anonymous0);
/* 73 */     hoverInfoSet(paramPLACER_TYPE.name);
/*    */   }
/*    */   protected void renAction() {
/* 76 */     selectedSet((PlacableMultiTool.this.type == t));
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 80 */     PlacableMultiTool.this.type = t;
/* 81 */     PlacableMultiTool.this.placable.previous = t;
/* 82 */     PlacableMultiTool.this.clear();
/* 83 */     (VIEW.inters()).popup.close();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PlacableMultiTool$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */