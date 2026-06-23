/*     */ package snake2d.util.sprite;
/*     */ 
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface SPRITE
/*     */   extends DIMENSION
/*     */ {
/*     */   void render(SPRITE_RENDERER paramSPRITE_RENDERER, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   default void render(SPRITE_RENDERER r, RECTANGLE rec) {
/*  24 */     render(r, rec.x1(), rec.x2(), rec.y1(), rec.y2());
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
/*     */   default void render(SPRITE_RENDERER r, int X1, int Y1) {
/*  36 */     render(r, X1, X1 + width(), Y1, Y1 + height());
/*     */   }
/*     */   
/*     */   default void renderC(SPRITE_RENDERER r, int cx, int cy) {
/*  40 */     render(r, cx - width() / 2, cx - width() / 2 + width(), cy - height() / 2, cy - height() / 2 + height());
/*     */   }
/*     */   
/*     */   default void renderCScaled(SPRITE_RENDERER r, int cx, int cy, int scale) {
/*  44 */     render(r, cx - width() * scale / 2, cx - width() * scale / 2 + width() * scale, cy - height() * scale / 2, cy - height() * scale / 2 + height() * scale);
/*     */   }
/*     */   
/*     */   default void renderC(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/*  48 */     int cx = X1 + (X2 - X1) / 2;
/*  49 */     int cy = Y1 + (Y2 - Y1) / 2;
/*  50 */     renderC(r, cx, cy);
/*     */   }
/*     */   
/*     */   default void renderCY(SPRITE_RENDERER r, int x1, int cy) {
/*  54 */     render(r, x1, x1 + width(), cy - height() / 2, cy - height() / 2 + height());
/*     */   }
/*     */   
/*     */   default void renderCX(SPRITE_RENDERER r, int cx, int y1) {
/*  58 */     render(r, cx - width() / 2, cx - width() / 2 + width(), y1, y1 + height());
/*     */   }
/*     */   
/*     */   default void renderCX(SPRITE_RENDERER r, int cx, int y1, int scale) {
/*  62 */     render(r, cx - scale * width() / 2, cx - scale * width() / 2 + scale * width(), y1, y1 + scale * height());
/*     */   }
/*     */   
/*     */   default void renderCXY2(SPRITE_RENDERER r, int cx, int y2) {
/*  66 */     render(r, cx - width() / 2, cx - width() / 2 + width(), y2 - height(), y2);
/*     */   }
/*     */   
/*     */   default void renderC(SPRITE_RENDERER r, RECTANGLE c) {
/*  70 */     renderC(r, c.cX(), c.cY());
/*     */   }
/*     */   
/*     */   default void renderC(SPRITE_RENDERER r, COORDINATE c) {
/*  74 */     renderC(r, c.x(), c.y());
/*     */   }
/*     */   
/*     */   default void renderScaled(SPRITE_RENDERER r, int X1, int Y1, int scale) {
/*  78 */     render(r, X1, X1 + width() * scale, Y1, Y1 + height() * scale);
/*     */   }
/*     */   
/*     */   void renderTextured(TextureCoords paramTextureCoords, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   default void renderTextured(TextureCoords texture, RECTANGLE rec) {
/*  84 */     renderTextured(texture, rec.x1(), rec.x2(), rec.y1(), rec.y2());
/*     */   }
/*     */   
/*     */   default void renderTextured(TextureCoords texture, int X1, int Y1) {
/*  88 */     renderTextured(texture, X1, X1 + width(), Y1, Y1 + height());
/*     */   }
/*     */   
/*     */   default TextureCoords texture() {
/*  92 */     return null;
/*     */   }
/*     */   
/*     */   default SPRITE twin(final SPRITE b, final DIR align, final int shadow) {
/*  96 */     SPRITE s = new Imp(width(), height())
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 100 */           SPRITE.this.render(r, X1, X2, Y1, Y2);
/* 101 */           int w = X2 - X1;
/* 102 */           int h = Y2 - Y1;
/*     */           
/* 104 */           double scaleX = w / width();
/* 105 */           double scaleY = h / height();
/*     */           
/* 107 */           int sw = (int)(b.width() * scaleX);
/* 108 */           int sh = (int)(b.height() * scaleY);
/*     */           
/* 110 */           int dx = (w - sw) / 2;
/* 111 */           int dy = (h - sh) / 2;
/*     */           
/* 113 */           int x1 = X1 + dx + align.x() * dx;
/* 114 */           int y1 = Y1 + dy + align.y() * dy;
/*     */           
/* 116 */           if (shadow > 0) {
/* 117 */             OPACITY.O75.bind();
/* 118 */             COLOR.BLACK.bind();
/* 119 */             int sx = (int)(shadow * scaleX);
/* 120 */             int sy = (int)(shadow * scaleY);
/* 121 */             b.render(r, x1 + sx, x1 + sw + sx, y1 + sy, y1 + sh + sy);
/* 122 */             OPACITY.unbind();
/* 123 */             COLOR.unbind();
/*     */           } 
/*     */           
/* 126 */           b.render(r, x1, x1 + sw, y1, y1 + sh);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 132 */     return s;
/*     */   }
/*     */   
/*     */   default SPRITE scaled(double scale) {
/* 136 */     return new Scaled(this, scale);
/*     */   }
/*     */   
/*     */   default SPRITE resized(int size) {
/* 140 */     final SPRITE o = this;
/* 141 */     return new Imp(size)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 145 */           int W = X2 - X1;
/* 146 */           int H = Y2 - Y1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 152 */           int x1 = X1 + (W - W) / 2;
/* 153 */           int y1 = Y1 + (H - H) / 2;
/* 154 */           o.render(r, x1, x1 + W, y1, y1 + H);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   default SPRITE sized(int size) {
/* 160 */     final SPRITE o = this;
/* 161 */     return new Imp(size)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 165 */           o.renderC(r, X1, X2, Y1, Y2);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   default SPRITE createColored(final COLOR color) {
/* 171 */     return new SPRITE()
/*     */       {
/*     */         public int width()
/*     */         {
/* 175 */           return SPRITE.this.width();
/*     */         }
/*     */ 
/*     */         
/*     */         public int height() {
/* 180 */           return SPRITE.this.height();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 191 */           color.bind();
/* 192 */           SPRITE.this.render(r, X1, X2, Y1, Y2);
/* 193 */           COLOR.unbind();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Resized
/*     */     extends Imp
/*     */   {
/*     */     private final SPRITE other;
/*     */     
/*     */     public Resized(SPRITE other, int dim) {
/* 205 */       super(dim);
/* 206 */       this.other = other;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 211 */       this.other.render(r, X1, X2, Y1, Y2);
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class Imp
/*     */     implements SPRITE
/*     */   {
/*     */     protected int width;
/*     */     protected int height;
/*     */     
/*     */     public Imp() {}
/*     */     
/*     */     public Imp(int d) {
/* 224 */       this(d, d);
/*     */     }
/*     */     
/*     */     public Imp(int w, int h) {
/* 228 */       this.width = w;
/* 229 */       this.height = h;
/*     */     }
/*     */     
/*     */     public void setDim(int w, int h) {
/* 233 */       this.width = w;
/* 234 */       this.height = h;
/*     */     }
/*     */ 
/*     */     
/*     */     public int width() {
/* 239 */       return this.width;
/*     */     }
/*     */ 
/*     */     
/*     */     public int height() {
/* 244 */       return this.height;
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Wrap
/*     */     implements SPRITE
/*     */   {
/*     */     protected int width;
/*     */     
/*     */     protected int height;
/*     */     private final DIR align;
/*     */     private final SPRITE other;
/*     */     
/*     */     public Wrap(SPRITE other, int width, int height, DIR align) {
/* 262 */       this.width = width;
/* 263 */       this.height = height;
/* 264 */       this.align = align;
/* 265 */       this.other = other;
/*     */     }
/*     */     
/*     */     public Wrap(SPRITE other, int width, int height) {
/* 269 */       this(other, width, height, DIR.C);
/*     */     }
/*     */ 
/*     */     
/*     */     public int width() {
/* 274 */       return this.width;
/*     */     }
/*     */ 
/*     */     
/*     */     public int height() {
/* 279 */       return this.height;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 284 */       int w = X2 - X1;
/* 285 */       int h = Y2 - Y1;
/* 286 */       int dh = (h - this.other.height()) / 2;
/* 287 */       int dw = (h - this.other.width()) / 2;
/*     */       
/* 289 */       int cx = X1 + w / 2;
/* 290 */       int cy = Y1 + h / 2;
/* 291 */       cx += dw * this.align.x();
/* 292 */       cy += dh * this.align.y();
/* 293 */       this.other.renderC(r, cx, cy);
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Twin
/*     */     implements SPRITE
/*     */   {
/*     */     private final int w;
/*     */     
/*     */     private final int h;
/*     */     private final SPRITE a;
/*     */     private final SPRITE b;
/*     */     
/*     */     public Twin(SPRITE a, SPRITE b) {
/* 311 */       this.a = a;
/* 312 */       this.b = b;
/* 313 */       this.w = a.width();
/* 314 */       this.h = a.height();
/*     */     }
/*     */ 
/*     */     
/*     */     public int width() {
/* 319 */       return this.w;
/*     */     }
/*     */ 
/*     */     
/*     */     public int height() {
/* 324 */       return this.h;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 334 */       this.a.render(r, X1, X2, Y1, Y2);
/* 335 */       int dx = (X2 - X1) / 2;
/* 336 */       int CX = X1 + dx;
/* 337 */       dx = (int)(dx * this.a.width() / this.b.width());
/*     */       
/* 339 */       int dy = (Y2 - Y1) / 2;
/* 340 */       int CY = Y1 + dy;
/* 341 */       dy = (int)(dy * this.a.height() / this.b.height());
/*     */       
/* 343 */       this.b.render(r, CX - dx, CX + dx, CY - dy, CY + dy);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Scaled
/*     */     implements SPRITE {
/*     */     private final int w;
/*     */     private final int h;
/*     */     private final SPRITE a;
/*     */     
/*     */     public Scaled(SPRITE a, double scale) {
/* 354 */       this.a = a;
/* 355 */       this.w = (int)(a.width() * scale);
/* 356 */       this.h = (int)(a.height() * scale);
/*     */     }
/*     */     
/*     */     public Scaled(SPRITE a, int w, int h) {
/* 360 */       this.a = a;
/* 361 */       this.w = w;
/* 362 */       this.h = h;
/*     */     }
/*     */ 
/*     */     
/*     */     public int width() {
/* 367 */       return this.w;
/*     */     }
/*     */ 
/*     */     
/*     */     public int height() {
/* 372 */       return this.h;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 382 */       this.a.render(r, X1, X2, Y1, Y2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class SpriteImp
/*     */     extends TextureCoords
/*     */     implements SPRITE
/*     */   {
/*     */     protected final int gameWidth;
/*     */     protected final int gameHeight;
/*     */     
/*     */     public SpriteImp(int x1, int x2, int y1, int y2, int gameWidth, int gameHeight) {
/* 395 */       this.x1 = (short)x1;
/* 396 */       this.x2 = (short)x2;
/* 397 */       this.y1 = (short)y1;
/* 398 */       this.y2 = (short)y2;
/* 399 */       this.gameWidth = gameWidth;
/* 400 */       this.gameHeight = gameHeight;
/*     */     }
/*     */     
/*     */     public SpriteImp(TextureCoords other, int w, int h) {
/* 404 */       get(other);
/* 405 */       this.gameWidth = w;
/* 406 */       this.gameHeight = h;
/*     */     }
/*     */ 
/*     */     
/*     */     public int width() {
/* 411 */       return this.gameWidth;
/*     */     }
/*     */ 
/*     */     
/*     */     public int height() {
/* 416 */       return this.gameHeight;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 421 */       r.renderSprite(X1, X2, Y1, Y2, 
/* 422 */           this);
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderTextured(TextureCoords other, int X1, int X2, int Y1, int Y2) {
/* 427 */       CORE.renderer().renderTextured(X1, X2, Y1, Y2, 
/* 428 */           other, this);
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureCoords texture() {
/* 433 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class SpriteFromSheet
/*     */     implements SPRITE
/*     */   {
/*     */     private final int tile;
/*     */     private final TILE_SHEET sheet;
/*     */     
/*     */     public SpriteFromSheet(TILE_SHEET sheet, int tile) {
/* 444 */       this.sheet = sheet;
/* 445 */       this.tile = tile;
/*     */     }
/*     */ 
/*     */     
/*     */     public int width() {
/* 450 */       return this.sheet.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public int height() {
/* 455 */       return this.sheet.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 460 */       this.sheet.render(r, this.tile, X1, X2, Y1, Y2);
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderTextured(TextureCoords other, int X1, int X2, int Y1, int Y2) {
/* 465 */       this.sheet.renderTextured(other, this.tile, X1, Y1);
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureCoords texture() {
/* 470 */       return this.sheet.getTexture(this.tile);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sprite\SPRITE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */