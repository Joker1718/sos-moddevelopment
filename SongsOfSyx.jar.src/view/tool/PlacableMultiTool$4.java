/*    */ package view.tool;
/*    */ 
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   null(SPRITE $anonymous0, CharSequence $anonymous1) {
/* 89 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 93 */     replaceLabel((SPRITE)PlacableMultiTool.this.type.icon(), DIR.C);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 98 */     (VIEW.inters()).popup.show((RENDEROBJ)PlacableMultiTool.this.typeButts, (CLICKABLE)this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PlacableMultiTool$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */