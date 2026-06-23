/*     */ package util.spritecomposer;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
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
/*     */ public abstract class ITileSprite
/*     */   implements SPRITE
/*     */ {
/*     */   private final int width;
/*     */   private final int height;
/*     */   private final TILE_SHEET sheet;
/*     */   
/*     */   protected ITileSprite(int width, int height, int scale) throws IOException {
/* 103 */     this.width = width * scale;
/* 104 */     this.height = height * scale;
/* 105 */     this.sheet = get();
/*     */   }
/*     */   
/*     */   protected ITileSprite(int width, int height, int scale, Path path, int w, int h) throws IOException {
/* 109 */     Resources.c.setSource(path, w, h);
/* 110 */     this.width = width * scale;
/* 111 */     this.height = height * scale;
/* 112 */     this.sheet = get();
/*     */   }
/*     */   
/*     */   public TILE_SHEET get() throws IOException {
/* 116 */     if (Resources.g == null) {
/* 117 */       return init(Resources.c, Resources.sources, Resources.dests);
/*     */     }
/* 119 */     return ComposerThings.ITileSheet.read(Resources.g);
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract TILE_SHEET init(ComposerUtil paramComposerUtil, ComposerSources paramComposerSources, ComposerDests paramComposerDests);
/*     */   
/*     */   public int width() {
/* 126 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 131 */     return this.height;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 136 */     int i = 0;
/* 137 */     for (int y = 0; y < this.height; y += this.sheet.size()) {
/* 138 */       for (int x = 0; x < this.width; x += this.sheet.size()) {
/* 139 */         this.sheet.render(r, i, X1 + x, Y1 + y);
/* 140 */         i++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {
/* 147 */     throw new RuntimeException("not supported!");
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerThings$ITileSprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */