/*     */ package util.gui.misc;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ 
/*     */ public class GMeter
/*     */ {
/*  16 */   public static final GMeterCol C_ORANGE = new GMeterCol(
/*  17 */       (COLOR)new ColorImp(15, 6, 1), 
/*  18 */       (COLOR)new ColorImp(52, 26, 5), 
/*  19 */       (COLOR)new ColorImp(79, 41, 14), 
/*  20 */       (COLOR)new ColorImp(127, 75, 20));
/*     */   
/*  22 */   public static final GMeterCol C_YELLOW = new GMeterCol(
/*  23 */       (COLOR)new ColorImp(15, 6, 1), 
/*  24 */       (COLOR)new ColorImp(45, 33, 10), 
/*  25 */       (COLOR)new ColorImp(64, 46, 13), 
/*  26 */       (COLOR)new ColorImp(127, 93, 28));
/*     */   
/*  28 */   public static final GMeterCol C_BLUE = new GMeterCol(
/*  29 */       (COLOR)new ColorImp(0, 0, 12), 
/*  30 */       (COLOR)new ColorImp(9, 9, 45), 
/*  31 */       (COLOR)new ColorImp(0, 0, 85), 
/*  32 */       (COLOR)new ColorImp(0, 40, 127));
/*     */   
/*  34 */   public static final GMeterCol C_REDGREEN = new GMeterCol(
/*  35 */       (COLOR)new ColorImp(45, 16, 16), 
/*  36 */       (COLOR)(new ColorImp(31, 82, 35)).shade(0.5D), 
/*  37 */       (COLOR)new ColorImp(23, 80, 28));
/*     */   
/*  39 */   public static final GMeterCol C_INACTIVE = new GMeterCol(
/*  40 */       (COLOR)new ColorImp(16, 16, 16), 
/*  41 */       (COLOR)new ColorImp(48, 48, 48), 
/*  42 */       (COLOR)new ColorImp(78, 78, 78));
/*     */   
/*  44 */   public static final GMeterCol C_REDORANGE = new GMeterCol(
/*  45 */       (COLOR)new ColorImp(45, 16, 16), 
/*  46 */       (COLOR)new ColorImp(96, 49, 4), 
/*  47 */       (COLOR)new ColorImp(127, 53, 0));
/*     */   
/*  49 */   public static final GMeterCol C_GREENBLUE = new GMeterCol(
/*  50 */       (COLOR)new ColorImp(16, 45, 16), 
/*  51 */       (COLOR)new ColorImp(0, 20, 85), 
/*  52 */       (COLOR)new ColorImp(0, 53, 127));
/*     */   
/*  54 */   public static final GMeterCol C_REDPURPLE = new GMeterCol(
/*  55 */       (COLOR)new ColorImp(45, 16, 16), 
/*  56 */       (COLOR)(new ColorImp(127, 16, 60)).shade(0.5D), 
/*  57 */       (COLOR)new ColorImp(127, 16, 60));
/*     */   
/*  59 */   public static final GMeterCol C_REDBLUE = new GMeterCol(
/*  60 */       (COLOR)new ColorImp(45, 16, 16), 
/*  61 */       (COLOR)new ColorImp(0, 0, 85), 
/*  62 */       (COLOR)new ColorImp(0, 40, 127));
/*     */   
/*  64 */   public static final GMeterCol C_GREENRED = new GMeterCol(
/*  65 */       (COLOR)new ColorImp(31, 82, 35), 
/*  66 */       (COLOR)new ColorImp(45, 16, 16), 
/*  67 */       (COLOR)new ColorImp(100, 16, 16));
/*     */   
/*  69 */   public static final GMeterCol C_GREENISH = new GMeterCol(
/*  70 */       (COLOR)new ColorImp(0, 0, 12), 
/*  71 */       (COLOR)new ColorImp(9, 30, 30), 
/*  72 */       (COLOR)new ColorImp(0, 60, 60), 
/*  73 */       (COLOR)new ColorImp(0, 80, 80));
/*     */   
/*  75 */   public static final GMeterCol C_RED = new GMeterCol(
/*  76 */       (COLOR)new ColorImp(12, 0, 0), 
/*  77 */       (COLOR)new ColorImp(45, 9, 9), 
/*  78 */       (COLOR)new ColorImp(85, 0, 0), 
/*  79 */       (COLOR)new ColorImp(127, 40, 0));
/*     */   
/*  81 */   public static final GMeterCol C_GRAY = new GMeterCol(
/*  82 */       (COLOR)new ColorImp(15, 15, 15), 
/*  83 */       (COLOR)new ColorImp(30, 30, 30), 
/*  84 */       (COLOR)new ColorImp(100, 100, 100));
/*     */   
/*  86 */   public static final GMeterCol C_GREEN = new GMeterCol(
/*  87 */       (COLOR)new ColorImp(16, 16, 16), 
/*  88 */       (COLOR)new ColorImp(16, 45, 16), 
/*  89 */       (COLOR)new ColorImp(70, 136, 63));
/*     */   
/*  91 */   public static final GMeterCol C_GREEN_GREEN = new GMeterCol(
/*  92 */       (COLOR)new ColorImp(23, 80, 28), 
/*  93 */       (COLOR)(new ColorImp(23, 80, 28)).shade(1.25D), 
/*  94 */       (COLOR)(new ColorImp(23, 80, 28)).shade(1.4D));
/*     */   
/*  96 */   public static final GMeterCol C_GREEN_DARK = new GMeterCol(
/*  97 */       (COLOR)new ColorImp(10, 10, 10), 
/*  98 */       (COLOR)new ColorImp(0, 22, 0), 
/*  99 */       (COLOR)new ColorImp(0, 45, 0));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void render(SPRITE_RENDERER r, GMeterCol color, double d, RECTANGLE body) {
/* 108 */     render(r, color, d, body.x1(), body.x2(), body.y1(), body.y2());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void render(SPRITE_RENDERER r, GMeterCol color, double d, int x1, int x2, int y1, int y2) {
/* 113 */     d = CLAMP.d(d, 0.0D, 1.0D);
/*     */     
/* 115 */     int w = x2 - x1;
/* 116 */     int h = y2 - y1;
/*     */     
/* 118 */     GCOLOR.UI().border().render(r, x1, x2, y1, y2);
/* 119 */     GCOLOR.UI().bg().render(r, x1 + 1, x1 + w - 1, y1 + 1, y2 - 1);
/*     */ 
/*     */     
/* 122 */     if (h <= 4) {
/*     */       
/* 124 */       color.dark.render(r, x1 + 2, x2 - 2, y1 + 1, y2 - 1);
/*     */ 
/*     */       
/* 127 */       w = (int)Math.ceil((x2 - x1 - 4) * d);
/* 128 */       if (w > 0) {
/* 129 */         color.bright.render(r, x1 + 2, x1 + 2 + w, y1 + 1, y2 - 1);
/*     */       }
/*     */     } 
/*     */     
/* 133 */     if (h <= 6) {
/*     */       
/* 135 */       color.dark.render(r, x1 + 2, x2 - 2, y1 + 2, y2 - 2);
/*     */ 
/*     */       
/* 138 */       w = (int)Math.ceil((x2 - x1 - 4) * d);
/* 139 */       if (w > 0) {
/* 140 */         color.bright.render(r, x1 + 2, x1 + 2 + w, y1 + 2, y2 - 2);
/*     */       }
/*     */     } else {
/* 143 */       color.bg.render(r, x1 + 2, x2 - 2, y1 + 2, y2 - 2);
/*     */       
/* 145 */       color.dark.render(r, x1 + 2, x2 - 2, y1 + 3, y2 - 3);
/*     */ 
/*     */       
/* 148 */       w = (int)Math.ceil((x2 - x1 - 4) * d);
/* 149 */       if (w > 0) {
/* 150 */         color.bright.render(r, x1 + 2, x1 + 2 + w, y1 + 3, y2 - 3);
/*     */       }
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
/*     */   public static void renderC(SPRITE_RENDERER r, double from, double to, RECTANGLE body) {
/* 170 */     renderC(r, from, to, body.x1(), body.x2(), body.y1(), body.y2());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderC(SPRITE_RENDERER r, double from, double to, int x1, int x2, int y1, int y2) {
/* 175 */     from = CLAMP.d(from, 0.0D, 1.0D);
/* 176 */     to = CLAMP.d(to, 0.0D, 1.0D);
/* 177 */     int w = x2 - x1;
/* 178 */     int cx = x1 + w / 2;
/* 179 */     GCOLOR.UI().border().render(r, x1, x2, y1, y2);
/* 180 */     GCOLOR.UI().bg().render(r, x1 + 1, x1 + w - 1, y1 + 1, y2 - 1);
/* 181 */     w -= 4;
/*     */ 
/*     */     
/* 184 */     C_RED.bg.render(r, x1 + 2, cx, y1 + 2, y2 - 2);
/* 185 */     C_BLUE.bg.render(r, cx, x2 - 2, y1 + 2, y2 - 2);
/*     */     
/* 187 */     if (from < 0.5D) {
/* 188 */       C_RED.dark.render(r, (int)((x1 + 2) + (w / 2) * from * 2.0D), cx, y1 + 3, y2 - 3);
/*     */     } else {
/* 190 */       C_BLUE.dark.render(r, cx, (int)(cx + (w / 2) * (from - 0.5D) * 2.0D), y1 + 3, y2 - 3);
/*     */     } 
/*     */     
/* 193 */     if (to < 0.5D) {
/* 194 */       C_RED.dark.render(r, (int)((x1 + 2) + (w / 2) * to * 2.0D), cx, y1 + 4, y2 - 4);
/* 195 */       C_RED.bright.render(r, (int)((x1 + 2) + (w / 2) * to * 2.0D), cx, y1 + 4, y2 - 4);
/*     */     } else {
/* 197 */       C_BLUE.dark.render(r, cx, (int)(cx + (w / 2) * (from - 0.5D) * 2.0D), y1 + 4, y2 - 4);
/* 198 */       C_BLUE.bright.render(r, cx, (int)(cx + (w / 2) * (from - 0.5D) * 2.0D), y1 + 4, y2 - 4);
/*     */     } 
/*     */     
/* 201 */     GCOLOR.UI().border().render(r, cx - 1, cx + 1, y1, y2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderH(SPRITE_RENDERER r, GMeterCol color, double d, int x1, int x2, int y1, int y2) {
/* 206 */     int h = y2 - y1;
/* 207 */     GCOLOR.UI().border().render(r, x1, x2, y1, y2);
/* 208 */     color.bg.render(r, x1 + 1, x2 - 1, y1 + 1, y2 - 1);
/*     */     
/* 210 */     int dh = (int)((h - 4) * d);
/*     */     
/* 212 */     if (dh > 0) {
/* 213 */       color.dark.render(r, x1 + 2, x2 - 2, y2 - 2 - dh, y2 - 2);
/*     */     }
/* 215 */     dh = (int)((h - 6) * d);
/* 216 */     if (dh > 0) {
/* 217 */       color.bright.render(r, x1 + 3, x2 - 3, y2 - 3 - dh, y2 - 3);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void renderH(SPRITE_RENDERER r, GMeterCol color, double d, RECTANGLE body) {
/* 222 */     renderH(r, color, d, body.x1(), body.x2(), body.y1(), body.y2());
/*     */   }
/*     */ 
/*     */   
/*     */   public static void render(SPRITE_RENDERER r, GMeterCol color, double d1, double d2, int x1, int x2, int y1, int y2) {
/* 227 */     int w = x2 - x1;
/* 228 */     GCOLOR.UI().border().render(r, x1, x2, y1, y2);
/* 229 */     if (w <= 2) {
/*     */       return;
/*     */     }
/* 232 */     color.bg.render(r, x1 + 1, x2 - 1, y1 + 1, y2 - 1);
/*     */     
/* 234 */     if (w <= 4)
/*     */       return; 
/* 236 */     d1 = CLAMP.d(d1, 0.0D, 1.0D);
/* 237 */     d2 = CLAMP.d(d2, 0.0D, 1.0D);
/* 238 */     double max = Math.max(d1, d2);
/* 239 */     double min = Math.min(d1, d2);
/* 240 */     int dx1 = (int)((w - 4) * min);
/* 241 */     int dx2 = (int)((w - 4) * max);
/*     */     
/* 243 */     color.between.render(r, x1 + 2, x1 + 2 + dx2, y1 + 2, y2 - 2);
/*     */     
/* 245 */     COLOR c = color.bright;
/* 246 */     if (d2 < d1) {
/* 247 */       c = color.dark;
/*     */     }
/*     */     
/* 250 */     if (dx2 - dx1 > 0) {
/* 251 */       OPACITY.O75TO100.bind();
/* 252 */       c.render(r, x1 + dx1 + 2, x1 + dx2 + 2, y1 + 2, y2 - 2);
/* 253 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderDelta(SPRITE_RENDERER r, double now, double next, RECTANGLE body) {
/* 262 */     renderDelta(r, now, next, body.x1(), body.x2(), body.y1(), body.y2());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderDelta(SPRITE_RENDERER r, double now, double next, int x1, int x2, int y1, int y2) {
/* 268 */     renderDelta(r, now, next, x1, x2, y1, y2, C_REDGREEN, C_BLUE, C_ORANGE, true);
/*     */   }
/*     */   
/*     */   public static void renderDelta(SPRITE_RENDERER r, double now, double next, int x1, int x2, int y1, int y2, boolean flash) {
/* 272 */     renderDelta(r, now, next, x1, x2, y1, y2, C_REDGREEN, C_BLUE, C_ORANGE, flash);
/*     */   }
/*     */   
/*     */   public static void renderDelta(SPRITE_RENDERER r, double now, double next, int x1, int x2, int y1, int y2, boolean flash, boolean frame) {
/* 276 */     renderDelta(r, now, next, x1, x2, y1, y2, C_REDGREEN, C_BLUE, C_ORANGE, flash, frame);
/*     */   }
/*     */   
/*     */   public static void renderDelta(SPRITE_RENDERER r, double now, double next, int x1, int x2, int y1, int y2, GMeterCol bg, GMeterCol good, GMeterCol bad, boolean flash) {
/* 280 */     renderDelta(r, now, next, x1, x2, y1, y2, bg, good, bad, flash, true);
/*     */   }
/*     */   
/*     */   public static void renderDelta(SPRITE_RENDERER r, double now, double next, int x1, int x2, int y1, int y2, GMeterCol bg, GMeterCol good, GMeterCol bad, boolean flash, boolean frame) {
/* 284 */     int w = x2 - x1;
/* 285 */     now = CLAMP.d(now, 0.0D, 1.0D);
/* 286 */     next = CLAMP.d(next, 0.0D, 1.0D);
/* 287 */     if (frame) {
/* 288 */       GCOLOR.UI().border().render(r, x1, x2, y1, y2);
/* 289 */       GCOLOR.UI().bg().render(r, x1 + 1, x1 + w - 1, y1 + 1, y2 - 1);
/*     */     } 
/* 291 */     bg.bg.render(r, x1 + 2, x2 - 2, y1 + 2, y2 - 2);
/*     */     
/* 293 */     renderFraction(r, bg.bright, 0.0D, Math.max(now, next), x1, x2, y1, y2);
/*     */     
/* 295 */     if (flash)
/* 296 */       OPACITY.O25TO100.bind(); 
/* 297 */     if (next > now) {
/* 298 */       renderFraction(r, good.bright, now, next, x1, x2, y1, y2);
/*     */     } else {
/* 300 */       renderFraction(r, bad.bright, next, now, x1, x2, y1, y2);
/*     */     } 
/*     */     
/* 303 */     OPACITY.unbind();
/*     */   }
/*     */   
/*     */   public static void renderSuperDelta(SPRITE_RENDERER r, double now, double next, RECTANGLE body, boolean frame) {
/* 307 */     renderSuperDelta(r, now, next, body.x1(), body.x2(), body.y1(), body.y2(), frame);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderSuperDelta(SPRITE_RENDERER r, double now, double next, int x1, int x2, int y1, int y2, boolean frame) {
/* 313 */     GMeterCol bg = C_REDORANGE;
/* 314 */     GMeterCol good = C_GREEN;
/* 315 */     GMeterCol bad = C_RED;
/*     */     
/* 317 */     if (next >= 1.0D) {
/* 318 */       next--;
/* 319 */       now--;
/*     */       
/* 321 */       bg = C_GREEN_GREEN;
/* 322 */       good = C_GREEN_GREEN;
/* 323 */       bad = C_ORANGE;
/*     */     } 
/*     */ 
/*     */     
/* 327 */     renderDelta(r, now, next, x1, x2, y1, y2, bg, good, bad, true, frame);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void renderDelta(SPRITE_RENDERER r, double now, double next, RECTANGLE body, GMeterCol col) {
/* 332 */     renderDelta(r, now, next, body.x1(), body.x2(), body.y1(), body.y2(), col);
/*     */   }
/*     */   
/*     */   public static void renderDelta(SPRITE_RENDERER r, double now, double next, int x1, int x2, int y1, int y2, GMeterCol col) {
/* 336 */     int w = x2 - x1;
/* 337 */     now = CLAMP.d(now, 0.0D, 1.0D);
/* 338 */     next = CLAMP.d(next, 0.0D, 1.0D);
/* 339 */     GCOLOR.UI().border().render(r, x1, x2, y1, y2);
/* 340 */     GCOLOR.UI().bg().render(r, x1 + 1, x1 + w - 1, y1 + 1, y2 - 1);
/* 341 */     col.bg.render(r, x1 + 2, x2 - 2, y1 + 2, y2 - 2);
/*     */     
/* 343 */     renderFraction(r, col.between, 0.0D, Math.max(now, next), x1, x2, y1, y2);
/*     */     
/* 345 */     if (next > now) {
/* 346 */       renderFraction(r, col.bright, now, next, x1, x2, y1, y2);
/*     */     } else {
/* 348 */       renderFraction(r, col.dark, next, now, x1, x2, y1, y2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void renderFraction(SPRITE_RENDERER r, COLOR color, double from, double to, int x1, int x2, int y1, int y2) {
/* 356 */     if (from > to) {
/* 357 */       double f = from;
/* 358 */       from = to;
/* 359 */       to = f;
/*     */     } 
/*     */ 
/*     */     
/* 363 */     int w = x2 - x1 - 4;
/*     */     
/* 365 */     x1 = (int)(x1 + 2.0D + Math.ceil(from * w));
/* 366 */     x2 = (int)(x1 + Math.ceil((to - from) * w));
/*     */ 
/*     */     
/* 369 */     w = x2 - x1;
/* 370 */     if (w > 0) {
/* 371 */       ColorImp.TMP.set(color).shadeSelf(0.5D);
/* 372 */       ColorImp.TMP.render(r, x1, x2, y1 + 2, y2 - 2);
/* 373 */       color.render(r, x1, x2, y1 + 3, y2 - 3);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class GMeterCol
/*     */   {
/*     */     public final COLOR bg;
/*     */     public final COLOR dark;
/*     */     public final COLOR bright;
/*     */     public final COLOR between;
/*     */     
/*     */     private GMeterCol(COLOR bg, COLOR bg1, COLOR bg2) {
/* 385 */       this.bg = bg;
/* 386 */       this.dark = bg1;
/* 387 */       this.bright = bg2;
/* 388 */       this.between = (COLOR)(new ColorImp(this.dark)).shadeSelf(1.5D);
/*     */     }
/*     */     
/*     */     private GMeterCol(COLOR bg, COLOR dark, COLOR normal, COLOR bright) {
/* 392 */       this.bg = bg;
/* 393 */       this.dark = dark;
/* 394 */       this.bright = bright;
/* 395 */       this.between = normal;
/*     */     }
/*     */   }
/*     */   
/*     */   public static SPRITE sprite(GMeterCol c, DOUBLE d, int width, int height) {
/* 400 */     return new GMeterSprite(c, d, width, height);
/*     */   }
/*     */   
/*     */   public static class GMeterSprite implements SPRITE {
/*     */     private final int width;
/*     */     private final int height;
/*     */     private final DOUBLE d;
/*     */     private final GMeter.GMeterCol c;
/*     */     
/*     */     public GMeterSprite(GMeter.GMeterCol c, DOUBLE d, int width, int height) {
/* 410 */       this.c = c;
/* 411 */       this.d = d;
/* 412 */       this.width = width;
/* 413 */       this.height = height;
/*     */     }
/*     */ 
/*     */     
/*     */     public int width() {
/* 418 */       return this.width;
/*     */     }
/*     */ 
/*     */     
/*     */     public int height() {
/* 423 */       return this.height;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 434 */       double dd = this.d.getD();
/* 435 */       GMeter.render(r, (dd < 0.0D) ? GMeter.C_INACTIVE : this.c, dd, X1, X2, Y1, Y2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GMeter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */