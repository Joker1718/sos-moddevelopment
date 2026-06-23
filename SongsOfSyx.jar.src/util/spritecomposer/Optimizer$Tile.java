/*     */ package util.spritecomposer;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.CORE;
/*     */ import snake2d.LOG;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.file.SnakeImage;
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
/*     */ final class Tile
/*     */   implements SAVABLE
/*     */ {
/*     */   final int startY;
/*     */   final int tilesX;
/*     */   final int size;
/*     */   private final byte[] data;
/*     */   private final byte[] opaques;
/*     */   private static final int offX1 = 0;
/*     */   private static final int widths = 1;
/*     */   private static final int offY1 = 2;
/*     */   private static final int heights = 3;
/*     */   private final int tiles;
/*     */   private final int tScroll;
/*     */   private final int tMask;
/*     */   private final int rows;
/*     */   
/*     */   private Tile(int startY, int width, int size, int rows) {
/*  78 */     this.rows = rows;
/*  79 */     this.startY = startY;
/*     */     
/*  81 */     int s = 1;
/*  82 */     while (s * 2 * size <= width) {
/*  83 */       s *= 2;
/*     */     }
/*  85 */     this.tilesX = s;
/*     */     
/*  87 */     this.size = size;
/*  88 */     s = this.tilesX * rows;
/*  89 */     this.data = Alloc.bb(4 * s);
/*  90 */     this.opaques = Alloc.bb(s);
/*  91 */     this.tiles = s;
/*  92 */     this.tScroll = Integer.numberOfTrailingZeros(this.tilesX);
/*  93 */     this.tMask = this.tilesX - 1;
/*     */   }
/*     */   
/*     */   public final void render(SPRITE_RENDERER r, int tile, int x1, int y1, int scale) {
/*  97 */     if (tile < 0) {
/*     */       return;
/*     */     }
/* 100 */     int dtile = tile * 4;
/* 101 */     byte[] data = this.data;
/* 102 */     int wi = data[1 + dtile];
/* 103 */     int hi = data[3 + dtile];
/*     */     
/* 105 */     if (wi <= 0 || hi <= 0) {
/*     */       return;
/*     */     }
/* 108 */     int tx = tile & this.tMask;
/* 109 */     int ty = tile >> this.tScroll;
/*     */     
/* 111 */     int px = tx * this.size;
/* 112 */     int py = this.startY + ty * this.size;
/*     */     
/* 114 */     int ox = data[0 + dtile];
/* 115 */     int oy = data[2 + dtile];
/*     */     
/* 117 */     px += ox;
/* 118 */     py += oy;
/*     */     
/* 120 */     x1 += ox * scale;
/* 121 */     int x2 = x1 + wi * scale;
/*     */     
/* 123 */     y1 += oy * scale;
/* 124 */     int y2 = y1 + hi * scale;
/*     */     
/* 126 */     r.renderSprite(x1, x2, y1, y2, TextureCoords.Normal.get(px, py, wi, hi));
/*     */   }
/*     */ 
/*     */   
/*     */   public final void renderTextured(TextureCoords t, int tile, int x1, int y1, int scale) {
/* 131 */     if (tile < 0) {
/*     */       return;
/*     */     }
/* 134 */     int dtile = tile * 4;
/* 135 */     int wi = this.data[1 + dtile];
/* 136 */     int hi = this.data[3 + dtile];
/*     */     
/* 138 */     if (wi <= 0 || hi <= 0) {
/*     */       return;
/*     */     }
/* 141 */     int tx = tile & this.tMask;
/* 142 */     int ty = tile >> this.tScroll;
/*     */     
/* 144 */     int px = tx * this.size;
/* 145 */     int py = this.startY + ty * this.size;
/*     */     
/* 147 */     int ox = this.data[0 + dtile];
/* 148 */     int oy = this.data[2 + dtile];
/*     */     
/* 150 */     px += ox;
/* 151 */     py += oy;
/*     */     
/* 153 */     x1 += ox * scale;
/* 154 */     int x2 = x1 + wi * scale;
/*     */     
/* 156 */     y1 += oy * scale;
/* 157 */     int y2 = y1 + hi * scale;
/*     */     
/* 159 */     Optimizer.this.coos.get(t.x1 + ox, t.y1 + oy, wi, hi);
/*     */ 
/*     */     
/* 162 */     CORE.renderer().renderTextured(x1, x2, y1, y2, Optimizer.this.coos, 
/* 163 */         TextureCoords.Normal.get(px, py, wi, hi));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final void optimize(SnakeImage source) {
/* 169 */     int o = 0;
/* 170 */     int cropped = 0;
/*     */     
/* 172 */     for (int t = 0; t < this.tiles; t++) {
/*     */       
/* 174 */       int tile = t * 4;
/*     */       int i;
/* 176 */       label78: for (i = 0; i < this.size; i++) {
/* 177 */         this.data[0 + tile] = (byte)i;
/* 178 */         for (int j = 0; j < this.size; j++) {
/* 179 */           int px = t % this.tilesX * this.size + i;
/* 180 */           int py = t / this.tilesX * this.size + j + this.startY;
/*     */           
/* 182 */           if ((source.rgb.get(px, py) & 0xFF) != 0) {
/*     */             break label78;
/*     */           }
/*     */         } 
/*     */       } 
/* 187 */       label79: for (i = this.size - 1; i >= 0; i--) {
/* 188 */         this.data[1 + tile] = (byte)(i - this.data[0 + tile] + 1);
/* 189 */         for (int j = 0; j < this.size; j++) {
/* 190 */           int px = t % this.tilesX * this.size + i;
/* 191 */           int py = t / this.tilesX * this.size + j + this.startY;
/*     */           
/* 193 */           if ((source.rgb.get(px, py) & 0xFF) != 0) {
/*     */             break label79;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       int y;
/* 199 */       label80: for (y = 0; y < this.size; y++) {
/* 200 */         this.data[2 + tile] = (byte)y;
/* 201 */         for (int j = 0; j < this.size; j++) {
/* 202 */           int px = t % this.tilesX * this.size + j;
/* 203 */           int py = t / this.tilesX * this.size + y + this.startY;
/*     */           
/* 205 */           if ((source.rgb.get(px, py) & 0xFF) != 0) {
/*     */             break label80;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 211 */       label81: for (y = this.size - 1; y >= 0; y--) {
/* 212 */         this.data[3 + tile] = (byte)(y - this.data[2 + tile] + 1);
/* 213 */         for (int j = 0; j < this.size; j++) {
/* 214 */           int px = t % this.tilesX * this.size + j;
/* 215 */           int py = t / this.tilesX * this.size + y + this.startY;
/*     */           
/* 217 */           if ((source.rgb.get(px, py) & 0xFF) != 0) {
/*     */             break label81;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 223 */       this.opaques[t] = 1;
/* 224 */       o++; int x;
/* 225 */       label82: for (x = 0; x < this.data[1 + tile]; x++) {
/* 226 */         for (int j = 0; j < this.data[3 + tile]; j++) {
/* 227 */           int px = t % this.tilesX * this.size + x + this.data[0 + tile];
/* 228 */           int py = t / this.tilesX * this.size + j + this.startY + this.data[2 + tile];
/*     */           
/* 230 */           if ((source.rgb.get(px, py) & 0xFF) != 255) {
/* 231 */             this.opaques[t] = 0;
/* 232 */             o--;
/*     */             
/*     */             break label82;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 239 */       if (this.data[0 + tile] != 0 || this.data[1 + tile] != this.size || this.data[2 + tile] != 0 || this.data[3 + tile] != this.size) {
/* 240 */         cropped++;
/*     */       }
/*     */     } 
/* 243 */     LOG.ln("tile " + this.size + ": " + this.tiles + " cropped: " + cropped + " opaque: " + o + ", ");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 249 */     file.bs(this.data);
/* 250 */     file.bs(this.opaques);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 256 */     file.bs(this.data);
/* 257 */     file.bs(this.opaques);
/*     */   }
/*     */   
/*     */   public void clear() {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\Optimizer$Tile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */