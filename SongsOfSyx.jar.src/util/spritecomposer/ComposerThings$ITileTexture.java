/*     */ package util.spritecomposer;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.util.sprite.TileTexture;
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
/*     */ public abstract class ITileTexture
/*     */ {
/*     */   private final int width;
/*     */   private final int height;
/*     */   
/*     */   protected ITileTexture(int width, int height) {
/* 226 */     this.width = width;
/* 227 */     this.height = height;
/*     */   }
/*     */   
/*     */   protected ITileTexture(int width, int height, Path path, int w, int h) throws IOException {
/* 231 */     Resources.c.setSource(path, w, h);
/* 232 */     this.width = width;
/* 233 */     this.height = height;
/*     */   }
/*     */   
/*     */   public TileTexture get() throws IOException {
/*     */     SpriteData d;
/* 238 */     if (Resources.g == null) {
/* 239 */       d = init(Resources.c, Resources.sources, Resources.dests, Resources.immi);
/*     */     } else {
/* 241 */       d = SpriteData.read(Resources.g);
/*     */     } 
/* 243 */     int dx = 0;
/* 244 */     if (Optimizer.get(24) != null)
/* 245 */       dx += (Optimizer.get(24)).tilesX * 24; 
/* 246 */     return new TileTexture(16, this.width, this.height, d.x1 + dx, d.y1);
/*     */   }
/*     */   
/*     */   protected abstract SpriteData init(ComposerUtil paramComposerUtil, ComposerSources paramComposerSources, ComposerDests paramComposerDests, ComposerTexturer paramComposerTexturer);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerThings$ITileTexture.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */