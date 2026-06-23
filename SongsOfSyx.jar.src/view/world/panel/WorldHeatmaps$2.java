/*    */ package view.world.panel;
/*    */ 
/*    */ import util.gui.misc.GButt;
/*    */ import world.overlay.WorldOverlays;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   null(CharSequence $anonymous0) {
/* 43 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 47 */     if (WorldHeatmaps.this.selected == o) {
/* 48 */       WorldHeatmaps.this.selected = null;
/*    */     } else {
/* 50 */       WorldHeatmaps.this.selected = o;
/*    */     } 
/*    */   }
/*    */   
/*    */   protected void renAction() {
/* 55 */     selectedSet((WorldHeatmaps.this.selected == o));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\panel\WorldHeatmaps$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */