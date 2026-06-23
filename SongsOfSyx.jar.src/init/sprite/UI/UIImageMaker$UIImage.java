/*     */ package init.sprite.UI;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class UIImage
/*     */   implements SPRITE
/*     */ {
/*     */   private static final int TILE_SIZE = 64;
/*     */   private final int tilesX;
/*     */   private final int tilesY;
/*     */   private final int width;
/*     */   private final int height;
/*     */   private final TILE_SHEET sheet;
/*     */   
/*     */   UIImage(TILE_SHEET sheet, int tilesX, int tilesY) throws IOException {
/* 113 */     this.sheet = sheet;
/* 114 */     this.tilesX = tilesX;
/* 115 */     this.tilesY = tilesY;
/* 116 */     this.width = tilesX * 64;
/* 117 */     this.height = tilesY * 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int width() {
/* 123 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 128 */     return this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 133 */     int startX = X1;
/* 134 */     int tile = 0;
/* 135 */     for (int ty = 0; ty < this.tilesY; ty++) {
/* 136 */       X1 = startX;
/* 137 */       for (int tx = 0; tx < this.tilesX; tx++) {
/* 138 */         this.sheet.render(r, tile, X1, Y1);
/* 139 */         X1 += 64;
/* 140 */         tile++;
/*     */       } 
/* 142 */       Y1 += 64;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {
/* 149 */     throw new RuntimeException();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UIImageMaker$UIImage.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */