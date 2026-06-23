/*     */ package util.rendering;
/*     */ 
/*     */ import game.GAME;
/*     */ import java.io.IOException;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Minimap
/*     */ {
/*     */   private static final double grit = 0.075D;
/*     */   private boolean open = true;
/*  23 */   private final int TILESIZE = 32;
/*     */ 
/*     */ 
/*     */   
/*     */   private final int DIM_PIXEL;
/*     */ 
/*     */ 
/*     */   
/*     */   private final int DIM_TILES;
/*     */ 
/*     */ 
/*     */   
/*     */   private final TILE_SHEET sheet;
/*     */ 
/*     */   
/*     */   private final TextureCoords texture;
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOpen(boolean o) {
/*  43 */     this.open = o;
/*     */   }
/*     */   
/*     */   public void putPixel(int x, int y, COLOR col) {
/*  47 */     if (this.open) {
/*  48 */       int tile = x / 32 + y / 32 * this.DIM_TILES;
/*  49 */       int dx = x % 32;
/*  50 */       int dy = y % 32;
/*  51 */       TextureCoords c = this.sheet.getTexture(tile);
/*  52 */       GAME.texture().putPixel(c.x1 + dx, c.y1 + dy, getC(col.red()), getC(col.green()), getC(col.blue()));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void putPixels(byte[] pixels) {
/*  59 */     int s = 1024;
/*  60 */     byte[] tmp = Alloc.bb(s * 4);
/*     */     
/*  62 */     for (int py = 0; py < this.DIM_PIXEL; py += 32) {
/*  63 */       for (int px = 0; px < this.DIM_PIXEL; px += 32) {
/*  64 */         int tile = px / 32 + py / 32 * this.DIM_TILES;
/*  65 */         TextureCoords c = this.sheet.getTexture(tile);
/*  66 */         for (int y = 0; y < 32; y++) {
/*  67 */           for (int x = 0; x < 32; x++) {
/*  68 */             int to = (x + y * 32) * 4;
/*  69 */             int from = ((py + y) * this.DIM_PIXEL + px + x) * 4;
/*  70 */             for (int j = 0; j < 3; j++) {
/*  71 */               tmp[to + j] = getC(pixels[from + j]);
/*     */             }
/*  73 */             tmp[to + 3] = pixels[from + 3];
/*     */           } 
/*     */         } 
/*  76 */         GAME.texture().putPixelBatch(c.x1, c.y1, 32, tmp);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte getC(byte c) {
/*  83 */     int res = Byte.toUnsignedInt((byte)(c * 2));
/*  84 */     int gmax = (int)(res * 0.075D);
/*  85 */     int g = (int)(-gmax + RND.rFloat() * 2.0F * gmax);
/*  86 */     res += g;
/*  87 */     if (res > 255)
/*  88 */       res = 255; 
/*  89 */     return (byte)res;
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() {}
/*     */   
/*     */   public Minimap(int dim) throws IOException {
/*  96 */     this.texture = new TextureCoords();
/*     */     this.DIM_PIXEL = dim;
/*     */     this.DIM_TILES = this.DIM_PIXEL / 32;
/*     */     this.sheet = (new ComposerThings.ITileSheet() {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) { d.s32.skipNPaint(Minimap.this.DIM_TILES * Minimap.this.DIM_TILES);
/*     */           return d.s32.save(1); }
/*     */       }).get(); } public void render(SPRITE_RENDERER r, double px1d, double py1d, int sx1, int sy1, int swidth, int sheight, double scale) {
/* 103 */     if (px1d < 0.0D) {
/* 104 */       double d = px1d * scale;
/* 105 */       px1d = 0.0D;
/* 106 */       sx1 = (int)(sx1 - d);
/* 107 */       swidth = (int)(swidth + d);
/*     */     } 
/*     */     
/* 110 */     if (py1d < 0.0D) {
/* 111 */       double d = py1d * scale;
/* 112 */       py1d = 0.0D;
/* 113 */       sy1 = (int)(sy1 - d);
/* 114 */       sheight = (int)(sheight + d);
/*     */     } 
/*     */ 
/*     */     
/* 118 */     int px1 = (int)px1d;
/* 119 */     int py1 = (int)py1d;
/*     */     
/* 121 */     int dx = (int)Math.ceil((px1d - px1) * scale);
/* 122 */     int dy = (int)Math.ceil((py1d - py1) * scale);
/* 123 */     sx1 -= dx;
/* 124 */     sy1 -= dy;
/* 125 */     swidth += dx;
/* 126 */     sheight += dy;
/*     */ 
/*     */     
/* 129 */     while (sheight > 0) {
/*     */       
/* 131 */       int ph = 32;
/* 132 */       ph -= py1 % 32;
/* 133 */       if (py1 + ph > this.DIM_PIXEL) {
/* 134 */         ph = this.DIM_PIXEL - py1;
/* 135 */         if (ph <= 0) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */       
/* 140 */       int th = (int)(ph * scale);
/*     */ 
/*     */       
/* 143 */       if (th > sheight) {
/* 144 */         ph = (int)Math.ceil(sheight / scale);
/* 145 */         th = (int)(ph * scale);
/*     */       } 
/*     */       
/* 148 */       int px = px1;
/* 149 */       int x = sx1;
/* 150 */       int w = swidth;
/* 151 */       while (w > 0) {
/* 152 */         int pw = 32;
/* 153 */         pw -= px % 32;
/*     */         
/* 155 */         if (px + pw > this.DIM_PIXEL) {
/* 156 */           pw = this.DIM_PIXEL - px;
/* 157 */           if (pw <= 0) {
/*     */             break;
/*     */           }
/*     */         } 
/* 161 */         int tw = (int)(pw * scale);
/*     */ 
/*     */         
/* 164 */         if (tw > w) {
/* 165 */           pw = (int)Math.ceil(w / scale);
/* 166 */           tw = (int)(pw * scale);
/*     */         } 
/*     */         
/* 169 */         TextureCoords c = get(px, py1, pw, ph);
/* 170 */         r.renderSprite(x, x + tw, sy1, sy1 + th, c);
/* 171 */         w -= tw;
/* 172 */         x += tw;
/* 173 */         px += pw;
/*     */       } 
/*     */       
/* 176 */       sheight -= th;
/* 177 */       sy1 += th;
/* 178 */       py1 += ph;
/*     */     } 
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
/*     */ 
/*     */ 
/*     */   
/*     */   private TextureCoords get(int px1, int py1, int w, int h) {
/* 201 */     int tile = px1 / 32 + py1 / 32 * this.DIM_TILES;
/* 202 */     int dx = px1 % 32;
/* 203 */     int dy = py1 % 32;
/* 204 */     TextureCoords c = this.sheet.getTexture(tile);
/*     */ 
/*     */     
/* 207 */     this.texture.get(c.x1 + dx, c.y1 + dy, w, h);
/*     */     
/* 209 */     return this.texture;
/*     */   }
/*     */   
/*     */   public TextureCoords texture(int tx, int ty, int w, int h) {
/* 213 */     int tile = tx / 32 + ty / 32 * this.DIM_TILES;
/* 214 */     int dx = tx % 32;
/* 215 */     int dy = ty % 32;
/* 216 */     TextureCoords c = this.sheet.getTexture(tile);
/* 217 */     this.texture.get(c.x1 + dx, c.y1 + dy, w, h);
/*     */     
/* 219 */     return this.texture;
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int x1, int y1, RECTANGLE quad) {
/* 223 */     COLOR.WHITE10.render(r, x1, x1 + quad.width(), y1, y1 + quad.height());
/* 224 */     render(r, quad.x1(), quad.y1(), x1, y1, quad.width(), quad.height(), 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int x1, int y1) {
/* 229 */     COLOR.WHITE10.render(r, x1, x1 + width(), y1, y1 + height());
/* 230 */     render(r, 0.0D, 0.0D, x1, y1, width(), height(), 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public int width() {
/* 235 */     return this.DIM_PIXEL;
/*     */   }
/*     */   
/*     */   public int height() {
/* 239 */     return this.DIM_PIXEL;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\rendering\Minimap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */