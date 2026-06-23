/*    */ package view.world.generator;
/*    */ 
/*    */ import snake2d.util.misc.ACTION;
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
/*    */ class null
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 37 */     if ((WORLD.GEN()).playerX != -1) {
/* 38 */       StageCapitol.clear();
/*    */     }
/*    */     
/* 41 */     stages.reset();
/*    */ 
/*    */     
/* 44 */     WORLD.TERRAIN().saver().generate(WorldViewGenerator.loadPrint);
/* 45 */     WORLD.LANDMARKS().saver().generate(WorldViewGenerator.loadPrint);
/* 46 */     WorldViewGenerator.loadPrint.exe();
/* 47 */     WORLD.MINIMAP().repaint();
/* 48 */     WorldViewGenerator.loadPrint.exe();
/*    */     
/* 50 */     (WORLD.GEN()).hasGeneratedTerrain = true;
/* 51 */     stages.set();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StageTerrain$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */