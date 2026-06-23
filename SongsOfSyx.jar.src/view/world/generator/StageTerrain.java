/*    */ package view.world.generator;
/*    */ 
/*    */ import init.constant.C;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import util.gui.misc.GButt;
/*    */ import util.text.D;
/*    */ import util.text.Dic;
/*    */ import view.main.VIEW;
/*    */ import view.world.generator.tools.UIWorldGenerateTerrain;
/*    */ import world.WORLD;
/*    */ 
/*    */ 
/*    */ class StageTerrain
/*    */ {
/* 18 */   static CharSequence ¤¤title = "Generate Terrain";
/* 19 */   static CharSequence ¤¤warning = "Regenerating terrain will reset your current world. Proceed?";
/*    */   
/*    */   static {
/* 22 */     D.ts(StageTerrain.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public StageTerrain(final WorldViewGenerator stages) {
/* 27 */     stages.reset();
/* 28 */     UIWorldGenerateTerrain uIWorldGenerateTerrain = new UIWorldGenerateTerrain(WORLD.GEN());
/* 29 */     uIWorldGenerateTerrain.body().centerIn(C.DIM());
/*    */     
/* 31 */     GuiSection ss = new GuiSection();
/*    */     
/* 33 */     final ACTION generate = new ACTION()
/*    */       {
/*    */         public void exe()
/*    */         {
/* 37 */           if ((WORLD.GEN()).playerX != -1) {
/* 38 */             StageCapitol.clear();
/*    */           }
/*    */           
/* 41 */           stages.reset();
/*    */ 
/*    */           
/* 44 */           WORLD.TERRAIN().saver().generate(WorldViewGenerator.loadPrint);
/* 45 */           WORLD.LANDMARKS().saver().generate(WorldViewGenerator.loadPrint);
/* 46 */           WorldViewGenerator.loadPrint.exe();
/* 47 */           WORLD.MINIMAP().repaint();
/* 48 */           WorldViewGenerator.loadPrint.exe();
/*    */           
/* 50 */           (WORLD.GEN()).hasGeneratedTerrain = true;
/* 51 */           stages.set();
/*    */         }
/*    */       };
/*    */     
/* 55 */     ss.addRightC(2, (RENDEROBJ)new GButt.ButtPanel(WorldViewGenerator.¤¤generate)
/*    */         {
/*    */           protected void clickA() {
/* 58 */             if ((WORLD.GEN()).playerX != -1) {
/* 59 */               (VIEW.inters()).yesNo.activate(StageTerrain.¤¤warning, generate, ACTION.NOP, true);
/*    */             } else {
/* 61 */               generate.exe();
/*    */             } 
/*    */           }
/*    */         });
/*    */     
/* 66 */     if ((WORLD.GEN()).hasGeneratedTerrain) {
/* 67 */       ss.addRightC(2, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤cancel)
/*    */           {
/*    */             protected void clickA() {
/* 70 */               stages.set();
/*    */             }
/*    */           });
/*    */     }
/*    */ 
/*    */     
/* 76 */     uIWorldGenerateTerrain.addRelBody(8, DIR.S, (RENDEROBJ)ss);
/*    */     
/* 78 */     stages.dummy.add((GuiSection)uIWorldGenerateTerrain, UIWorldGenerateTerrain.¤¤MapType);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StageTerrain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */