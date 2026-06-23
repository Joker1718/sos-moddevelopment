/*    */ package launcher;
/*    */ 
/*    */ import init.paths.PATHS;
/*    */ import snake2d.CORE;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Text;
/*    */ import util.text.D;
/*    */ 
/*    */ final class ScreenModWarning extends GuiSection {
/* 16 */   private static CharSequence ¤¤warn = "You are about to launch the game with code mods enabled. These mods contain code that could harm your PC, and you play at your own risk. Make sure you trust the author and the source of the mod.";
/* 17 */   private static CharSequence ¤¤warnEasy = "You are about to launch the game with mods enabled. Be prepared that vanilla features might not work such as the tutorial.";
/* 18 */   private static CharSequence ¤¤launch = "Launch";
/* 19 */   private static CharSequence ¤¤cancel = "Cancel";
/*    */   
/*    */   static {
/* 22 */     D.ts(ScreenModWarning.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ScreenModWarning(final Launcher l) {
/* 28 */     CharSequence w = PATHS.SCRIPT().hasExternal(l.s.mods.get()) ? ¤¤warn : ¤¤warnEasy;
/*    */     
/* 30 */     Text t = (new Text(l.res.font, w)).setScale(1.0D);
/* 31 */     t.setMaxWidth(600);
/* 32 */     add((SPRITE)t, 0, 0);
/*    */     
/* 34 */     GuiSection bb = new GuiSection();
/*    */     
/* 36 */     bb.add((RENDEROBJ)new GUI.BText(l.res, ¤¤launch, 200)
/*    */         {
/*    */           
/*    */           protected void clickA()
/*    */           {
/* 41 */             l.s.save();
/* 42 */             Launcher.startGame = true;
/* 43 */             CORE.annihilate();
/*    */           }
/*    */         });
/*    */     
/* 47 */     bb.addRightC(0, (RENDEROBJ)new GUI.BText(l.res, ¤¤cancel, 200)
/*    */         {
/*    */           protected void clickA()
/*    */           {
/* 51 */             l.setMods();
/*    */           }
/*    */         });
/*    */ 
/*    */     
/* 56 */     addRelBody(8, DIR.S, (RENDEROBJ)bb);
/*    */     
/* 58 */     body().moveC(448.0D, 224.0D);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 64 */     OPACITY.O75.bind();
/* 65 */     COLOR.BLACK.render(r, 0, 896, 0, 448);
/* 66 */     OPACITY.unbind();
/* 67 */     super.render(r, ds);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\ScreenModWarning.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */