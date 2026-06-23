/*    */ package view.sett.ui.minimap;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import util.colors.GCOLOR;
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
/*    */   extends GuiSection
/*    */ {
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 40 */     (GCOLOR.UI()).panBG.render(r, (RECTANGLE)body());
/* 41 */     super.render(r, ds);
/* 42 */     GCOLOR.UI().borderH(r, (RECTANGLE)body(), 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\minimap\UIMinimapPanelButts$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */