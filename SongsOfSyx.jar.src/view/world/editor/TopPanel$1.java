/*    */ package view.world.editor;
/*    */ 
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.gui.misc.GButt;
/*    */ import util.text.Dic;
/*    */ import view.main.VIEW;
/*    */ import view.world.generator.WorldViewGenerator;
/*    */ import view.world.generator.tools.UIWorldGenerateTerrain;
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
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends TopPanel.G
/*    */ {
/*    */   null(TopPanel paramTopPanel2, WORLD.WorldResource $anonymous0) {
/* 62 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 66 */     UIWorldGenerateTerrain uIWorldGenerateTerrain = new UIWorldGenerateTerrain(WORLD.GEN());
/* 67 */     uIWorldGenerateTerrain.addRelBody(8, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Generate)
/*    */         {
/*    */           protected void clickA() {
/* 70 */             WORLD.TERRAIN().saver().generate(WorldViewGenerator.loadPrint);
/*    */           }
/*    */         });
/* 73 */     (VIEW.inters()).popup.show((RENDEROBJ)uIWorldGenerateTerrain, (CLICKABLE)this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\editor\TopPanel$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */