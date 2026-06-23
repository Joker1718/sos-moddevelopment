/*    */ package view.world.panel;
/*    */ 
/*    */ import util.gui.misc.GButt;
/*    */ import world.WORLD;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends GButt.Checkbox
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 25 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 29 */     (WORLD.OVERLAY()).regNames.active.toggle();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 34 */     selectedSet((WORLD.OVERLAY()).regNames.active.is());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\panel\WorldHeatmaps$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */