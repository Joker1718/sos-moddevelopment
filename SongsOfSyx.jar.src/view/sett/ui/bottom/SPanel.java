/*    */ package view.sett.ui.bottom;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import util.colors.GCOLOR;
/*    */ 
/*    */ class SPanel
/*    */   extends GuiSection {
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 12 */     COLOR.WHITE20.render(r, (RECTANGLE)body());
/* 13 */     GCOLOR.UI().borderH(r, (RECTANGLE)body(), 0);
/* 14 */     super.render(r, ds);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\bottom\SPanel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */