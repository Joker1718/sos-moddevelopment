/*    */ package view.world.generator;
/*    */ 
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sprite.SPRITE;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 46 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 49 */     (WORLD.GEN()).seed = RND.rInt(2147483647);
/* 50 */     WORLD.TERRAIN().saver().generate(WorldViewGenerator.loadPrint);
/* 51 */     WORLD.LANDMARKS().saver().generate(WorldViewGenerator.loadPrint);
/* 52 */     WorldViewGenerator.loadPrint.exe();
/* 53 */     WORLD.MINIMAP().repaint();
/* 54 */     WorldViewGenerator.loadPrint.exe();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 59 */     (WORLD.OVERLAY()).landmarks.add();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StageCapitol$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */