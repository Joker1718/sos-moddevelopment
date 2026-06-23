/*    */ package snake2d.util.sprite;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ 
/*    */ final class Slice
/*    */   implements TILE_SHEET
/*    */ {
/*    */   final TILE_SHEET combo;
/*    */   final int start;
/*    */   final int size;
/*    */   
/*    */   Slice(TILE_SHEET combo, int start, int end) {
/* 13 */     this.combo = combo;
/* 14 */     this.start = start;
/* 15 */     this.size = end - this.start;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int tile, int x1, int x2, int y1, int y2) {
/* 20 */     this.combo.render(r, tile + this.start, x1, x2, y1, y2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderTextured(TextureCoords texture, int tile, int x1, int y1) {
/* 26 */     this.combo.renderTextured(texture, tile + this.start, x1, y1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderTextured(TextureCoords texture, int tile, int x1, int x2, int scale) {
/* 32 */     this.combo.renderTextured(texture, tile + this.start, x1, x2, scale);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public TextureCoords getTexture(int tile) {
/* 38 */     return this.combo.getTexture(tile + this.start);
/*    */   }
/*    */ 
/*    */   
/*    */   public int size() {
/* 43 */     return this.combo.size();
/*    */   }
/*    */ 
/*    */   
/*    */   public int tiles() {
/* 48 */     return this.size;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sprite\Slice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */