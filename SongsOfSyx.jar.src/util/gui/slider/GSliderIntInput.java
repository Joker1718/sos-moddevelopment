/*    */ package util.gui.slider;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.data.INT;
/*    */ import util.gui.misc.GInputInt;
/*    */ 
/*    */ public class GSliderIntInput
/*    */   extends GuiSection {
/*    */   public GSliderIntInput(INT.INTE in) {
/* 12 */     addRightC(2, (RENDEROBJ)new GSliderInt(in, 80, true, false));
/* 13 */     addRightC(8, (RENDEROBJ)new GInputInt(in));
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 18 */     super.render(r, ds);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\slider\GSliderIntInput.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */