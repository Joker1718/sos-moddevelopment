/*     */ package util.spritecomposer;
/*     */ 
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.SnakeImage;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Tile
/*     */   extends ComposerDests.Dest
/*     */ {
/*     */   final int startY;
/*     */   final int tilesX;
/* 194 */   private int tx = 0;
/* 195 */   private int ty = 0;
/* 196 */   private int lastTile = 0;
/*     */   
/*     */   final int size;
/*     */   final int startX;
/*     */   private final int destWidth;
/* 201 */   private SnakeImage[] diffuses = new SnakeImage[0];
/* 202 */   private SnakeImage[] normals = new SnakeImage[0];
/*     */   
/*     */   Tile(int size, int width) {
/* 205 */     this.startY = 0;
/* 206 */     this.size = size;
/* 207 */     this.startX = 0;
/* 208 */     int s = 1;
/* 209 */     while (s * 2 * size <= width) {
/* 210 */       s *= 2;
/*     */     }
/* 212 */     this.tilesX = s;
/* 213 */     this.destWidth = this.tilesX * this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int y1() {
/* 220 */     return this.startY + this.ty * this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   int x1() {
/* 225 */     return this.tx * this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   int size() {
/* 230 */     return this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   int width() {
/* 235 */     return this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   int height() {
/* 240 */     return this.size;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jump(int i) {
/* 245 */     this.tx += i;
/* 246 */     while (this.tx >= this.tilesX) {
/* 247 */       this.ty++;
/* 248 */       this.tx -= this.tilesX;
/*     */     } 
/* 250 */     while (this.tx < 0) {
/* 251 */       this.tx += this.tilesX;
/* 252 */       this.ty--;
/*     */     } 
/*     */     
/* 255 */     if (this.tx < 0 || this.ty < 0) {
/* 256 */       throw new RuntimeException("" + this.tx + " " + this.tx);
/*     */     }
/*     */   }
/*     */   
/*     */   public void debug() {
/* 261 */     LOG.ln("" + x1() + " " + x1());
/*     */   }
/*     */   
/*     */   public TILE_SHEET saveGame() {
/* 265 */     return save(4);
/*     */   }
/*     */   
/*     */   public TILE_SHEET saveNormal() {
/* 269 */     return save(2);
/*     */   }
/*     */   
/*     */   public TILE_SHEET saveGui() {
/* 273 */     return save(1);
/*     */   }
/*     */   
/*     */   public SpriteData saveSprite(int tilesX) {
/* 277 */     if (tilesX <= 0) {
/* 278 */       throw new RuntimeException();
/*     */     }
/* 280 */     jump(-tilesX);
/* 281 */     int x1 = this.tx * this.size;
/* 282 */     int y1 = this.ty * this.size + this.startY;
/* 283 */     skip(tilesX);
/* 284 */     return SpriteData.save(x1, y1, this.size * tilesX, this.size, this.size);
/*     */   }
/*     */   
/*     */   public TILE_SHEET save(int scale) {
/* 288 */     int end = this.tx + this.ty * this.tilesX;
/* 289 */     int nrOfTiles = end - this.lastTile;
/* 290 */     int startTile = this.lastTile;
/* 291 */     this.lastTile = end;
/* 292 */     return ComposerThings.ITileSheet.save(scale, this.size, startTile, nrOfTiles, this.tilesX);
/*     */   }
/*     */   
/*     */   public final SpriteData saveSprite() {
/* 296 */     return saveSprite(1);
/*     */   }
/*     */   
/*     */   public void skip(int i) {
/* 300 */     jump(i);
/* 301 */     this.lastTile = this.tx + this.ty * this.tilesX;
/*     */   }
/*     */   
/*     */   public void skipNPaint(int i) {
/* 305 */     while (i-- > 0) {
/* 306 */       setNewImage(x1(), y1());
/* 307 */       for (int y = 0; y < this.size; y++) {
/* 308 */         for (int x = 0; x < this.size; x++) {
/* 309 */           diffuseSet(x1() + x, y1() + y, -1);
/*     */         }
/*     */       } 
/* 312 */       jump(1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {
/* 318 */     for (int i = 0; i < this.normals.length; i++) {
/* 319 */       this.normals[i].dispose();
/* 320 */       this.diffuses[i].dispose();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setNewImage(int x, int y) {
/* 325 */     int k = y / this.size * 32;
/*     */     
/* 327 */     if (k >= this.diffuses.length) {
/* 328 */       SnakeImage[] diffs = new SnakeImage[this.diffuses.length + 1];
/* 329 */       SnakeImage[] norms = new SnakeImage[this.normals.length + 1];
/*     */       
/* 331 */       for (int i = 0; i < this.diffuses.length; i++) {
/* 332 */         diffs[i] = this.diffuses[i];
/* 333 */         norms[i] = this.normals[i];
/*     */       } 
/* 335 */       diffs[diffs.length - 1] = new SnakeImage(this.tilesX * this.size, 32 * this.size);
/* 336 */       norms[norms.length - 1] = new SnakeImage(this.tilesX * this.size, 32 * this.size);
/*     */       
/* 338 */       this.diffuses = diffs;
/* 339 */       this.normals = norms;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void diffuseSet(int x, int y, int c) {
/* 346 */     setNewImage(x, y);
/* 347 */     int k = y / this.size * 32;
/* 348 */     y -= k * this.size * 32;
/* 349 */     (this.diffuses[k]).rgb.set(x, y, c);
/*     */   }
/*     */ 
/*     */   
/*     */   public int diffuseGet(int x, int y) {
/* 354 */     setNewImage(x, y);
/* 355 */     int k = y / this.size * 32;
/* 356 */     y -= k * this.size * 32;
/* 357 */     return (this.diffuses[k]).rgb.get(x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public void normalSet(int x, int y, int c) {
/* 362 */     setNewImage(x, y);
/* 363 */     int k = y / this.size * 32;
/* 364 */     y -= k * this.size * 32;
/* 365 */     (this.normals[k]).rgb.set(x, y, c);
/*     */   }
/*     */ 
/*     */   
/*     */   public int normalGet(int x, int y) {
/* 370 */     setNewImage(x, y);
/* 371 */     int k = y / this.size * 32;
/* 372 */     y -= k * this.size * 32;
/* 373 */     return (this.normals[k]).rgb.get(x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int destWidth() {
/* 380 */     return this.destWidth;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerDests$Tile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */