/*     */ package util.spritecomposer;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ 
/*     */ class TIleSheetPow2
/*     */   implements TILE_SHEET
/*     */ {
/*     */   private final int startTile;
/*     */   private final int mask;
/*     */   private final int scrollY;
/*     */   private final int quadSize;
/*     */   private final int tiles;
/*     */   private final Optimizer.Tile t;
/*     */   private final int scale;
/*  18 */   private static final TextureCoords[] texs = new TextureCoords[] {
/*  19 */       new TextureCoords(), 
/*  20 */       new TextureCoords()
/*     */     };
/*  22 */   private static int tI = 0;
/*     */ 
/*     */   
/*     */   TIleSheetPow2(int scale, int tileSize, int startTile, int tilesX, int tiles) {
/*  26 */     this.t = Optimizer.get(tileSize);
/*  27 */     this.scale = scale;
/*     */     
/*  29 */     this.startTile = startTile;
/*     */     
/*  31 */     int m = 1;
/*  32 */     int scroll = 1;
/*  33 */     if (tilesX % 2 != 0)
/*  34 */       throw new RuntimeException(); 
/*  35 */     while ((tilesX /= 2) > 1) {
/*  36 */       m <<= 1;
/*  37 */       m |= 0x1;
/*  38 */       scroll++;
/*     */     } 
/*  40 */     this.mask = m;
/*  41 */     this.scrollY = scroll;
/*     */     
/*  43 */     this.quadSize = tileSize * scale;
/*  44 */     this.tiles = tiles;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int tile, int x1, int y1) {
/*  49 */     this.t.render(r, tile + this.startTile, x1, y1, this.scale);
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureCoords getTexture(int tile) {
/*  54 */     tile += this.startTile;
/*  55 */     int tx = tile & this.mask;
/*  56 */     int ty = tile >> this.scrollY;
/*  57 */     tI++;
/*  58 */     return texs[tI & 0x1].get(
/*  59 */         tx * this.quadSize / this.scale, 
/*  60 */         this.t.startY + ty * this.t.size, 
/*  61 */         this.t.size, 
/*  62 */         this.t.size);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTextured(TextureCoords t, int tile, int x1, int y1) {
/*  68 */     if (tile < 0) {
/*     */       return;
/*     */     }
/*  71 */     this.t.renderTextured(t, tile + this.startTile, x1, y1, this.scale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTextured(TextureCoords t, int tile, int x1, int y1, int scale) {
/*  90 */     this.t.renderTextured(t, tile + this.startTile, x1, y1, scale);
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  95 */     return this.quadSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public int tiles() {
/* 100 */     return this.tiles;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int tile, int x1, int x2, int y1, int y2) {
/* 105 */     if (tile < 0) {
/*     */       return;
/*     */     }
/* 108 */     tile += this.startTile;
/* 109 */     int tx = tile & this.mask;
/* 110 */     int ty = tile >> this.scrollY;
/*     */     
/* 112 */     int px = tx * this.t.size;
/* 113 */     int py = this.t.startY + ty * this.t.size;
/*     */     
/* 115 */     r.renderSprite(x1, x2, y1, y2, TextureCoords.Normal.get(px, py, this.t.size, this.t.size));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\TIleSheetPow2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */