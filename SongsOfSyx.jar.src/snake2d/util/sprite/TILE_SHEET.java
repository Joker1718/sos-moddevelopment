/*    */ package snake2d.util.sprite;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ 
/*    */ public interface TILE_SHEET
/*    */ {
/*    */   default void renderC(SPRITE_RENDERER r, int tile, int cx, int cy) {
/*  8 */     render(r, tile, cx - size() / 2, cy - size() / 2);
/*    */   }
/*    */   default void render(SPRITE_RENDERER r, int tile, int x1, int y1) {
/* 11 */     render(r, tile, x1, x1 + size(), y1, y1 + size());
/*    */   }
/*    */ 
/*    */   
/*    */   void render(SPRITE_RENDERER paramSPRITE_RENDERER, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*    */ 
/*    */   
/*    */   void renderTextured(TextureCoords paramTextureCoords, int paramInt1, int paramInt2, int paramInt3);
/*    */   
/*    */   void renderTextured(TextureCoords paramTextureCoords, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*    */   
/*    */   default SPRITE makeSprite(int tile) {
/* 23 */     return new SPRITE.SpriteFromSheet(this, tile);
/*    */   } TextureCoords getTexture(int paramInt); int size();
/*    */   int tiles();
/*    */   default TILE_SHEET slice(int from, int to) {
/* 27 */     if (from == 0 && to == 1)
/* 28 */       return this; 
/* 29 */     return new Slice(this, from, to);
/*    */   }
/*    */   
/* 32 */   public static final TILE_SHEET DUMMY = new TILE_SHEET()
/*    */     {
/*    */       
/*    */       public int tiles()
/*    */       {
/* 37 */         return 16;
/*    */       }
/*    */ 
/*    */ 
/*    */       
/*    */       public int size() {
/* 43 */         return 0;
/*    */       }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       public void renderTextured(TextureCoords texture, int tile, int x1, int x2, int scale) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       public void renderTextured(TextureCoords texture, int tile, int x1, int y1) {}
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       public void render(SPRITE_RENDERER r, int tile, int x1, int x2, int y1, int y2) {}
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       public TextureCoords getTexture(int tile) {
/* 67 */         return null;
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sprite\TILE_SHEET.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */