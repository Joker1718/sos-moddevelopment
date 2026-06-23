/*    */ package view.world.generator;
/*    */ 
/*    */ import snake2d.util.misc.ACTION;
/*    */ import util.gui.misc.GButt;
/*    */ import view.main.VIEW;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 55 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 58 */     if ((WORLD.GEN()).playerX != -1) {
/* 59 */       (VIEW.inters()).yesNo.activate(StageTerrain.¤¤warning, generate, ACTION.NOP, true);
/*    */     } else {
/* 61 */       generate.exe();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StageTerrain$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */