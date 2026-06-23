/*     */ package init.sprite.UI;
/*     */ 
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ 
/*     */ public final class UICons
/*     */ {
/*     */   private final TILE_SHEET sprite;
/*  12 */   private final SPRITE[] sprites = new SPRITE[16];
/*     */   private final UICons tiny;
/*     */   
/*     */   public UICons(TILE_SHEET sprite) {
/*  16 */     if (sprite.tiles() < 16)
/*  17 */       throw new RuntimeException("array must be longer than 15! " + sprite.tiles()); 
/*  18 */     this.sprite = sprite;
/*  19 */     for (int i = 0; i < 16; i++) {
/*  20 */       this.sprites[i] = (SPRITE)new SPRITE.SpriteFromSheet(sprite, i);
/*     */     }
/*  22 */     this.tiny = this;
/*     */   }
/*     */   
/*     */   UICons(TILE_SHEET sprite, UICons tiny) {
/*  26 */     if (sprite.tiles() < 16)
/*  27 */       throw new RuntimeException("array must be longer than 15! " + sprite.tiles()); 
/*  28 */     this.sprite = sprite;
/*  29 */     for (int i = 0; i < 16; i++) {
/*  30 */       this.sprites[i] = (SPRITE)new SPRITE.SpriteFromSheet(sprite, i);
/*     */     }
/*  32 */     this.tiny = tiny;
/*     */   }
/*     */   
/*     */   public SPRITE get(int i) {
/*  36 */     return this.sprites[i];
/*     */   }
/*     */   
/*     */   public SPRITE get(DIR d1, DIR d2, DIR d3, DIR d4) {
/*  40 */     int m = 0;
/*  41 */     if (d1 != null)
/*  42 */       m |= d1.mask(); 
/*  43 */     if (d2 != null)
/*  44 */       m |= d2.mask(); 
/*  45 */     if (d3 != null)
/*  46 */       m |= d3.mask(); 
/*  47 */     if (d4 != null)
/*  48 */       m |= d4.mask(); 
/*  49 */     return get(m);
/*     */   }
/*     */   
/*     */   public SPRITE get(DIR d1, DIR d2, DIR d3) {
/*  53 */     return get(d1, d2, d3, null);
/*     */   }
/*     */   
/*     */   public SPRITE get(DIR d1, DIR d2) {
/*  57 */     return get(d1, d2, null, null);
/*     */   }
/*     */   
/*     */   public SPRITE get(DIR d1) {
/*  61 */     return get(d1, null, null, null);
/*     */   }
/*     */   
/*     */   public static int getIndex(boolean N, boolean E, boolean S, boolean W) {
/*  65 */     int nr = 0;
/*     */     
/*  67 */     if (N) {
/*  68 */       nr |= 0x1;
/*     */     }
/*     */     
/*  71 */     if (E) {
/*  72 */       nr |= 0x2;
/*     */     }
/*     */     
/*  75 */     if (S) {
/*  76 */       nr |= 0x4;
/*     */     }
/*     */     
/*  79 */     if (W) {
/*  80 */       nr |= 0x8;
/*     */     }
/*     */     
/*  83 */     return nr;
/*     */   }
/*     */   
/*     */   public void renderBox(SPRITE_RENDERER r, int x1, int y1, int width, int height) {
/*  87 */     int M = this.sprite.size() / 4;
/*  88 */     int size = this.sprite.size();
/*  89 */     if (width <= size - 2 * M && height <= size - 2 * M) {
/*  90 */       renderCentered(r, 0, x1 + width / 2, y1 + height / 2);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  95 */     int X1 = x1;
/*  96 */     int Y1 = y1;
/*  97 */     int X2 = x1 + width;
/*  98 */     int Y2 = y1 + height;
/*     */     
/* 100 */     int w = (X2 - X1) / size - 1;
/* 101 */     int h = (Y2 - Y1) / size - 1;
/*     */     
/* 103 */     render(r, DIR.S.mask() | DIR.E.mask(), X1 - M, Y1 - M);
/*     */     
/* 105 */     render(r, DIR.S.mask() | DIR.W.mask(), X2 + M - size, Y1 - M);
/* 106 */     render(r, DIR.N.mask() | DIR.E.mask(), X1 - M, Y2 + M - size);
/* 107 */     render(r, DIR.N.mask() | DIR.W.mask(), X2 + M - size, Y2 + M - size); int i;
/* 108 */     for (i = 0; i < w; i++) {
/* 109 */       render(r, DIR.S.mask() | DIR.E.mask() | DIR.W.mask(), X1 - M + size + i * size, Y1 - M);
/* 110 */       render(r, DIR.N.mask() | DIR.E.mask() | DIR.W.mask(), X1 - M + size + i * size, Y2 + M - size);
/*     */     } 
/* 112 */     for (i = 0; i < h; i++) {
/* 113 */       render(r, DIR.E.mask() | DIR.N.mask() | DIR.S.mask(), X1 - M, Y1 - M + size + i * size);
/* 114 */       render(r, DIR.W.mask() | DIR.N.mask() | DIR.S.mask(), X2 + M - size, Y1 - M + size + i * size);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void render(boolean N, boolean E, boolean S, boolean W, SPRITE_RENDERER r, int x, int y) {
/* 119 */     render(r, getIndex(N, E, S, W), x, y);
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int s, int x, int y) {
/* 123 */     if (CORE.renderer().getZoomout() >= 3) {
/* 124 */       this.tiny.sprite.render(r, s, x, y);
/*     */     } else {
/* 126 */       this.sprite.render(r, s, x, y);
/*     */     } 
/*     */   }
/*     */   public void render(SPRITE_RENDERER r, int s, int x1, int x2, int y1, int y2) {
/* 130 */     if (CORE.renderer().getZoomout() >= 3) {
/* 131 */       this.tiny.sprite.render(r, s, x1, x2, y1, y2);
/*     */     } else {
/* 133 */       this.sprite.render(r, s, x1, x2, y1, y2);
/*     */     } 
/*     */   }
/*     */   public void renderCentered(SPRITE_RENDERER r, int s, int x, int y) {
/* 137 */     if (CORE.renderer().getZoomout() >= 3) {
/* 138 */       this.tiny.sprite.render(r, s, x - this.tiny.sprite.size() / 2, y - this.tiny.sprite.size() / 2);
/*     */     } else {
/* 140 */       this.sprite.render(r, s, x - this.sprite.size() / 2, y - this.sprite.size() / 2);
/*     */     } 
/*     */   }
/*     */   public void render(SPRITE_RENDERER r, int s, int corner, int x, int y) {
/* 144 */     render(r, s, x, y);
/* 145 */     if (corner == 0)
/*     */       return; 
/* 147 */     if (CORE.renderer().getZoomout() >= 3) {
/* 148 */       this.tiny.sprite.render(r, 16 + corner, x, y);
/*     */     } else {
/* 150 */       this.sprite.render(r, 16 + corner, x, y);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int dim() {
/* 155 */     return this.sprite.size();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UICons.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */