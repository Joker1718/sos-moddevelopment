/*     */ package util.spritecomposer;
/*     */ 
/*     */ import java.nio.file.Path;
/*     */ import snake2d.CORE;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FilePutter;
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
/*     */ public final class ComposerDests
/*     */ {
/*     */   public final Tile s16;
/*     */   public final Tile s8;
/*     */   public final Tile s32;
/*     */   public final Tile s24;
/*     */   final DestChunk chunk;
/*     */   private volatile boolean saved;
/*     */   
/*     */   ComposerDests(int WIDTH) {
/*  38 */     this.saved = false; this.s16 = new Tile(16, WIDTH); this.s8 = new Tile(8, WIDTH); this.s32 = new Tile(32, WIDTH); this.s24 = new Tile(24, WIDTH); this.chunk = new DestChunk(WIDTH - this.s24.tilesX * this.s24.size, 512); for (int y = 0; y < 16; y++) {
/*     */       for (int x = 0; x < 16; x++) {
/*     */         this.s16.diffuseSet(x, y, 255, 255, 255, 255); this.s16.normalSet(x, y, 128, 128, 255, 255);
/*     */       } 
/*  42 */     }  this.s16.skip(1); } void save(final Path deff, final Path nor, FilePutter p, int extraHeight) { int HEIGHT = height(extraHeight);
/*     */     
/*  44 */     final SnakeImage diffuse = new SnakeImage(this.s16.width() * this.s16.tilesX, HEIGHT);
/*  45 */     final SnakeImage normal = new SnakeImage(diffuse.width, HEIGHT);
/*     */     
/*  47 */     for (COORDINATE c : new Rec(diffuse.width, HEIGHT)) {
/*  48 */       normal.rgb.set(c.x(), c.y(), 127, 127, 255, 255);
/*     */     }
/*  50 */     Tile[] tiles = {
/*  51 */         this.s8, this.s16, this.s32, this.s24
/*     */       };
/*     */     
/*  54 */     int ly = 0;
/*  55 */     int y1 = 0; byte b; int i; Tile[] arrayOfTile1;
/*  56 */     for (i = (arrayOfTile1 = tiles).length, b = 0; b < i; ) { Tile tile = arrayOfTile1[b];
/*  57 */       int h = (int)Math.ceil(tile.lastTile / tile.tilesX);
/*  58 */       p.i(h);
/*  59 */       h *= tile.size;
/*  60 */       for (int j = 0; j < h; j++) {
/*  61 */         for (int x = 0; x < tile.destWidth(); x++) {
/*  62 */           diffuse.rgb.set(x, y1 + j, tile.diffuseGet(x, j));
/*  63 */           normal.rgb.set(x, y1 + j, tile.normalGet(x, j));
/*     */         } 
/*     */       } 
/*  66 */       y1 += h;
/*  67 */       ly = y1 - h;
/*     */       
/*  69 */       tile.dispose();
/*     */       b++; }
/*     */     
/*  72 */     for (int y = 0; y < this.chunk.diffuse.height; y++) {
/*  73 */       for (int x = 0; x < this.chunk.normal.width; x++) {
/*  74 */         int py = ly + y;
/*  75 */         diffuse.rgb.set(x + this.s24.tilesX * 24, py, this.chunk.diffuseGet(x, y));
/*  76 */         normal.rgb.set(x + this.s24.tilesX * 24, py, this.chunk.normalGet(x, y));
/*     */       } 
/*     */     } 
/*     */     
/*  80 */     this.chunk.dispose();
/*     */ 
/*     */     
/*  83 */     this.saved = false;
/*     */     
/*  85 */     Thread t = new Thread(new Runnable()
/*     */         {
/*     */           public void run()
/*     */           {
/*  89 */             diffuse.save(String.valueOf(deff.toAbsolutePath()));
/*  90 */             normal.save(String.valueOf(nor.toAbsolutePath()));
/*  91 */             ComposerDests.this.saved = true;
/*     */           }
/*     */         });
/*  94 */     t.setName("composer saver");
/*  95 */     t.start();
/*     */     
/*  97 */     while (!this.saved) {
/*  98 */       CORE.checkIn();
/*     */       try {
/* 100 */         Thread.sleep(16L);
/* 101 */       } catch (InterruptedException e) {
/* 102 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 108 */     diffuse.dispose();
/* 109 */     normal.dispose(); }
/*     */ 
/*     */ 
/*     */   
/*     */   int height(int extra) {
/* 114 */     Tile[] tiles = {
/* 115 */         this.s8, this.s16, this.s32, this.s24
/*     */       };
/*     */     
/* 118 */     int h = 0; byte b; int i; Tile[] arrayOfTile1;
/* 119 */     for (i = (arrayOfTile1 = tiles).length, b = 0; b < i; ) { Tile t = arrayOfTile1[b];
/* 120 */       h += (int)Math.ceil(t.lastTile / t.tilesX) * t.size;
/*     */       b++; }
/*     */     
/* 123 */     if ((int)Math.ceil(this.s24.lastTile / this.s24.tilesX) * this.s24.size < this.chunk.diffuse.height + extra) {
/* 124 */       h -= (int)Math.ceil(this.s24.lastTile / this.s24.tilesX) * this.s24.size;
/* 125 */       h += this.chunk.diffuse.height + extra;
/*     */     } 
/*     */ 
/*     */     
/* 129 */     int hh = h / 256;
/* 130 */     if (h % 256 > 0)
/* 131 */       hh++; 
/* 132 */     return hh * 256;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void dispose() {
/* 139 */     this.s16.dispose();
/* 140 */     this.s8.dispose();
/* 141 */     this.s32.dispose();
/* 142 */     this.s24.dispose();
/* 143 */     this.chunk.dispose();
/*     */   }
/*     */   static abstract class Dest { abstract int x1();
/*     */     
/*     */     abstract int y1();
/*     */     
/*     */     abstract int width();
/*     */     
/*     */     abstract int height();
/*     */     
/*     */     public abstract void jump(int param1Int);
/*     */     
/*     */     public void diffuseSet(int x, int y, int r, int g, int b, int a) {
/* 156 */       int res = r;
/* 157 */       res <<= 8;
/* 158 */       res |= g;
/* 159 */       res <<= 8;
/* 160 */       res |= b;
/* 161 */       res <<= 8;
/* 162 */       res |= a;
/* 163 */       diffuseSet(x, y, res);
/*     */     }
/*     */     
/*     */     public void normalSet(int x, int y, int r, int g, int b, int a) {
/* 167 */       int res = r;
/* 168 */       res <<= 8;
/* 169 */       res |= g;
/* 170 */       res <<= 8;
/* 171 */       res |= b;
/* 172 */       res <<= 8;
/* 173 */       res |= a;
/* 174 */       normalSet(x, y, res);
/*     */     }
/*     */     
/*     */     public abstract void diffuseSet(int param1Int1, int param1Int2, int param1Int3);
/*     */     
/*     */     public abstract int diffuseGet(int param1Int1, int param1Int2);
/*     */     
/*     */     public abstract void normalSet(int param1Int1, int param1Int2, int param1Int3);
/*     */     
/*     */     public abstract int normalGet(int param1Int1, int param1Int2);
/*     */     
/*     */     public abstract int destWidth();
/*     */     
/*     */     public abstract void dispose();
/*     */     
/*     */     abstract int size(); }
/*     */   
/*     */   public final class Tile extends Dest {
/*     */     final int startY;
/*     */     final int tilesX;
/* 194 */     private int tx = 0;
/* 195 */     private int ty = 0;
/* 196 */     private int lastTile = 0;
/*     */     
/*     */     final int size;
/*     */     final int startX;
/*     */     private final int destWidth;
/* 201 */     private SnakeImage[] diffuses = new SnakeImage[0];
/* 202 */     private SnakeImage[] normals = new SnakeImage[0];
/*     */     
/*     */     Tile(int size, int width) {
/* 205 */       this.startY = 0;
/* 206 */       this.size = size;
/* 207 */       this.startX = 0;
/* 208 */       int s = 1;
/* 209 */       while (s * 2 * size <= width) {
/* 210 */         s *= 2;
/*     */       }
/* 212 */       this.tilesX = s;
/* 213 */       this.destWidth = this.tilesX * this.size;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int y1() {
/* 220 */       return this.startY + this.ty * this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     int x1() {
/* 225 */       return this.tx * this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     int size() {
/* 230 */       return this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     int width() {
/* 235 */       return this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     int height() {
/* 240 */       return this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     public void jump(int i) {
/* 245 */       this.tx += i;
/* 246 */       while (this.tx >= this.tilesX) {
/* 247 */         this.ty++;
/* 248 */         this.tx -= this.tilesX;
/*     */       } 
/* 250 */       while (this.tx < 0) {
/* 251 */         this.tx += this.tilesX;
/* 252 */         this.ty--;
/*     */       } 
/*     */       
/* 255 */       if (this.tx < 0 || this.ty < 0) {
/* 256 */         throw new RuntimeException("" + this.tx + " " + this.tx);
/*     */       }
/*     */     }
/*     */     
/*     */     public void debug() {
/* 261 */       LOG.ln("" + x1() + " " + x1());
/*     */     }
/*     */     
/*     */     public TILE_SHEET saveGame() {
/* 265 */       return save(4);
/*     */     }
/*     */     
/*     */     public TILE_SHEET saveNormal() {
/* 269 */       return save(2);
/*     */     }
/*     */     
/*     */     public TILE_SHEET saveGui() {
/* 273 */       return save(1);
/*     */     }
/*     */     
/*     */     public SpriteData saveSprite(int tilesX) {
/* 277 */       if (tilesX <= 0) {
/* 278 */         throw new RuntimeException();
/*     */       }
/* 280 */       jump(-tilesX);
/* 281 */       int x1 = this.tx * this.size;
/* 282 */       int y1 = this.ty * this.size + this.startY;
/* 283 */       skip(tilesX);
/* 284 */       return SpriteData.save(x1, y1, this.size * tilesX, this.size, this.size);
/*     */     }
/*     */     
/*     */     public TILE_SHEET save(int scale) {
/* 288 */       int end = this.tx + this.ty * this.tilesX;
/* 289 */       int nrOfTiles = end - this.lastTile;
/* 290 */       int startTile = this.lastTile;
/* 291 */       this.lastTile = end;
/* 292 */       return ComposerThings.ITileSheet.save(scale, this.size, startTile, nrOfTiles, this.tilesX);
/*     */     }
/*     */     
/*     */     public final SpriteData saveSprite() {
/* 296 */       return saveSprite(1);
/*     */     }
/*     */     
/*     */     public void skip(int i) {
/* 300 */       jump(i);
/* 301 */       this.lastTile = this.tx + this.ty * this.tilesX;
/*     */     }
/*     */     
/*     */     public void skipNPaint(int i) {
/* 305 */       while (i-- > 0) {
/* 306 */         setNewImage(x1(), y1());
/* 307 */         for (int y = 0; y < this.size; y++) {
/* 308 */           for (int x = 0; x < this.size; x++) {
/* 309 */             diffuseSet(x1() + x, y1() + y, -1);
/*     */           }
/*     */         } 
/* 312 */         jump(1);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void dispose() {
/* 318 */       for (int i = 0; i < this.normals.length; i++) {
/* 319 */         this.normals[i].dispose();
/* 320 */         this.diffuses[i].dispose();
/*     */       } 
/*     */     }
/*     */     
/*     */     private void setNewImage(int x, int y) {
/* 325 */       int k = y / this.size * 32;
/*     */       
/* 327 */       if (k >= this.diffuses.length) {
/* 328 */         SnakeImage[] diffs = new SnakeImage[this.diffuses.length + 1];
/* 329 */         SnakeImage[] norms = new SnakeImage[this.normals.length + 1];
/*     */         
/* 331 */         for (int i = 0; i < this.diffuses.length; i++) {
/* 332 */           diffs[i] = this.diffuses[i];
/* 333 */           norms[i] = this.normals[i];
/*     */         } 
/* 335 */         diffs[diffs.length - 1] = new SnakeImage(this.tilesX * this.size, 32 * this.size);
/* 336 */         norms[norms.length - 1] = new SnakeImage(this.tilesX * this.size, 32 * this.size);
/*     */         
/* 338 */         this.diffuses = diffs;
/* 339 */         this.normals = norms;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void diffuseSet(int x, int y, int c) {
/* 346 */       setNewImage(x, y);
/* 347 */       int k = y / this.size * 32;
/* 348 */       y -= k * this.size * 32;
/* 349 */       (this.diffuses[k]).rgb.set(x, y, c);
/*     */     }
/*     */ 
/*     */     
/*     */     public int diffuseGet(int x, int y) {
/* 354 */       setNewImage(x, y);
/* 355 */       int k = y / this.size * 32;
/* 356 */       y -= k * this.size * 32;
/* 357 */       return (this.diffuses[k]).rgb.get(x, y);
/*     */     }
/*     */ 
/*     */     
/*     */     public void normalSet(int x, int y, int c) {
/* 362 */       setNewImage(x, y);
/* 363 */       int k = y / this.size * 32;
/* 364 */       y -= k * this.size * 32;
/* 365 */       (this.normals[k]).rgb.set(x, y, c);
/*     */     }
/*     */ 
/*     */     
/*     */     public int normalGet(int x, int y) {
/* 370 */       setNewImage(x, y);
/* 371 */       int k = y / this.size * 32;
/* 372 */       y -= k * this.size * 32;
/* 373 */       return (this.normals[k]).rgb.get(x, y);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int destWidth() {
/* 380 */       return this.destWidth;
/*     */     }
/*     */   }
/*     */   
/*     */   static final class DestChunk
/*     */     extends Dest
/*     */   {
/* 387 */     final Rec rec = new Rec();
/*     */     private SnakeImage diffuse;
/*     */     private SnakeImage normal;
/*     */     public final int width;
/*     */     
/*     */     private DestChunk(int width, int height) {
/* 393 */       this.diffuse = new SnakeImage(width, height);
/* 394 */       this.normal = new SnakeImage(width, height);
/* 395 */       this.width = width;
/*     */     }
/*     */ 
/*     */     
/*     */     int x1() {
/* 400 */       return this.rec.x1();
/*     */     }
/*     */ 
/*     */     
/*     */     int y1() {
/* 405 */       return this.rec.y1();
/*     */     }
/*     */ 
/*     */     
/*     */     int width() {
/* 410 */       return this.rec.width();
/*     */     }
/*     */ 
/*     */     
/*     */     int height() {
/* 415 */       return this.rec.height();
/*     */     }
/*     */ 
/*     */     
/*     */     public int destWidth() {
/* 420 */       return this.width;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void jump(int i) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void dispose() {
/* 430 */       this.normal.dispose();
/* 431 */       this.diffuse.dispose();
/*     */     }
/*     */ 
/*     */     
/*     */     int size() {
/* 436 */       return this.rec.width();
/*     */     }
/*     */ 
/*     */     
/*     */     public void diffuseSet(int x, int y, int c) {
/* 441 */       this.diffuse.rgb.set(x, y, c);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int diffuseGet(int x, int y) {
/* 447 */       return this.diffuse.rgb.get(x, y);
/*     */     }
/*     */ 
/*     */     
/*     */     public void normalSet(int x, int y, int c) {
/* 452 */       this.normal.rgb.set(x, y, c);
/*     */     }
/*     */ 
/*     */     
/*     */     public int normalGet(int x, int y) {
/* 457 */       return this.normal.rgb.get(x, y);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerDests.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */