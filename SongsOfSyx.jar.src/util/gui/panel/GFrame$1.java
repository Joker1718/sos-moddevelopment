/*    */ package util.gui.panel;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.TextureCoords;
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
/*    */   implements SPRITE
/*    */ {
/*    */   public int width() {
/* 62 */     return width;
/*    */   }
/*    */ 
/*    */   
/*    */   public int height() {
/* 67 */     return 16;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 78 */     GCOLOR.UI().borderH(r, X1, X2, Y1 + height() / 2 - 1, Y1 + height() / 2 + 2);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\panel\GFrame$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */