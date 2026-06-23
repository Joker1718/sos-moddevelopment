/*    */ package view.ui.wiki;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GuiSection;
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
/* 20 */     Colors.border.render(r, (RECTANGLE)body(), -5);
/* 21 */     COLOR.WHITE05.render(r, (RECTANGLE)body(), -6);
/* 22 */     super.render(r, ds);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\wiki\Article$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */