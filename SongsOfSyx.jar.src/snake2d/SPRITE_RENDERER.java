/*    */ package snake2d;
/*    */ 
/*    */ import snake2d.util.sprite.TextureCoords;
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
/*    */ public interface SPRITE_RENDERER
/*    */ {
/*    */   default void renderSprite(int x1, int x2, int y1, int y2, TextureCoords texture) {
/* 18 */     renderSprite(x1, x2, y1, y2, texture);
/*    */   }
/*    */ 
/*    */   
/* 22 */   public static final SPRITE_RENDERER DUMMY = new SPRITE_RENDERER() {
/*    */       public void renderSprite(int x1, int x2, int y1, int y2, TextureCoords texture) {}
/*    */     };
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\SPRITE_RENDERER.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */