/*     */ package snake2d.util.sprite.text;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ 
/*     */ public class Font
/*     */ {
/*  20 */   public static final short[] map = new short[65535];
/*     */   private static int renderableChars;
/*     */   public static CharSequence set;
/*     */   private static final int space = 32;
/*     */   public static final char nl = '\n';
/*     */   public static final char tab = '\t';
/*  26 */   private static final Str tmp = new Str(128); private final String name; private final FontGlyph[] glyphs; private final int height;
/*     */   
/*     */   static {
/*  29 */     setCharset(" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~");
/*     */   }
/*     */   
/*     */   public static int glyps() {
/*  33 */     return renderableChars;
/*     */   }
/*     */   
/*     */   public static CharSequence charset() {
/*  37 */     return set;
/*     */   }
/*     */   
/*     */   public static void setCharset(CharSequence charset) {
/*  41 */     renderableChars = charset.length();
/*  42 */     set = charset; int i;
/*  43 */     for (i = 0; i < map.length; i++) {
/*  44 */       map[i] = -1;
/*     */     }
/*     */     
/*  47 */     for (i = 0; i < charset.length(); i++) {
/*  48 */       map[charset.charAt(i)] = (short)i;
/*     */     }
/*     */     
/*  51 */     map[32] = -1;
/*  52 */     map[10] = -1;
/*  53 */     map[9] = -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean hasMapping(char charAt) {
/*  58 */     return (map[charAt] != -1);
/*     */   }
/*     */   
/*     */   private static int map(char c) {
/*  62 */     int i = map[c];
/*  63 */     if (i == -1) {
/*  64 */       i = map[63];
/*     */     }
/*  66 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  73 */   private double scale = 1.0D;
/*  74 */   private final Texture texture = new Texture(null);
/*     */   public final int maxCWidth;
/*     */   private final int DY;
/*     */   private final Coo dim;
/*     */   
/*     */   public Font(Font m, double scale, int trail) {
/*  80 */     this(m.glyphs, m.height, m.scale * scale, trail);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 105 */     return this.name;
/*     */   }
/*     */   
/*     */   public int height() {
/* 109 */     return (int)Math.ceil(this.height * this.scale);
/*     */   }
/*     */   
/*     */   public int height(double scale) {
/* 113 */     return (int)Math.ceil(this.height * this.scale * scale);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderFromRow(CharSequence c, int x, int y, int width, int topRow, int maxHeight) {
/* 118 */     int start = 0;
/* 119 */     int end = 0;
/*     */     
/* 121 */     while (end < c.length()) {
/* 122 */       end = getEndIndex(c, start, width / 1);
/* 123 */       if (topRow <= 0) {
/* 124 */         render((SPRITE_RENDERER)CORE.renderer(), c, x, y, start, end, 1.0D);
/* 125 */         y += height() * 1;
/* 126 */         maxHeight -= height() * 1;
/*     */         
/* 128 */         if (maxHeight <= 0) {
/*     */           return;
/*     */         }
/*     */       } 
/* 132 */       start = getStartIndex(c, end);
/* 133 */       topRow--;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getHeight(CharSequence c, int width) {
/* 138 */     return getDim(c, width).y();
/*     */   }
/*     */   
/*     */   public int getRowAmount(CharSequence s, int width) {
/* 142 */     int fromI = 0;
/* 143 */     int toI = s.length();
/* 144 */     int am = 0;
/* 145 */     while (fromI < toI) {
/* 146 */       int e = getEndIndex(s, fromI, toI, width, 1.0D);
/* 147 */       fromI = getStartIndex(s, e);
/* 148 */       am++;
/*     */     } 
/*     */     
/* 151 */     return am;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence[] getRows(CharSequence c, int width) {
/* 156 */     int am = getRowAmount(c, width);
/* 157 */     CharSequence[] rows = new CharSequence[am];
/*     */     
/* 159 */     int start = 0;
/* 160 */     int end = 0;
/* 161 */     int h = 0;
/*     */     
/* 163 */     while (end < c.length()) {
/* 164 */       end = getEndIndex(c, start, width);
/* 165 */       if (h < rows.length)
/* 166 */         rows[h] = c.subSequence(start, end); 
/* 167 */       h++;
/* 168 */       start = getStartIndex(c, end);
/*     */     } 
/*     */     
/* 171 */     return rows;
/*     */   }
/*     */   
/* 174 */   public Font(FontGlyph[] glyphs, int height, double scale, int trail) { this.dim = new Coo(); if (glyphs.length < renderableChars)
/*     */       throw new RuntimeException(String.valueOf(glyphs.length) + " " + renderableChars);  this.name = "generated"; this.height = height; this.scale = scale; this.glyphs = glyphs; int m = 0; int dmi = Integer.MAX_VALUE; byte b; int i; FontGlyph[] arrayOfFontGlyph; for (i = (arrayOfFontGlyph = glyphs).length, b = 0; b < i; ) { FontGlyph g = arrayOfFontGlyph[b]; m = Math.max(m, g.width + g.trail); dmi = Math.min(dmi, g.descent); b++; }
/*     */      this.DY = -dmi / 2; this.maxCWidth = m; for (i = (arrayOfFontGlyph = glyphs).length, b = 0; b < i; ) { FontGlyph g = arrayOfFontGlyph[b]; g.trail = (short)(g.trail + trail); b++; }
/* 177 */      } public COORDINATE getDim(CharSequence s) { return getDim(s, 0, s.length(), 2147483647, 1.0D); }
/*     */ 
/*     */   
/*     */   public COORDINATE getDim(CharSequence s, int maxWidth) {
/* 181 */     return getDim(s, 0, s.length(), maxWidth, 1.0D);
/*     */   }
/*     */   
/*     */   public COORDINATE getDim(CharSequence s, int maxWidth, double scale) {
/* 185 */     return getDim(s, 0, s.length(), maxWidth, scale);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public COORDINATE getDim(CharSequence s, int fromI, int toI, int maxwidth, double scale) {
/* 191 */     int height = height(scale);
/* 192 */     this.dim.set(0.0D, 0.0D);
/*     */     
/* 194 */     while (fromI < toI) {
/*     */ 
/*     */       
/* 197 */       int e = getEndIndex(s, fromI, toI, maxwidth, scale);
/* 198 */       int w = width(s, fromI, e, scale);
/*     */       
/* 200 */       if (w > this.dim.x())
/* 201 */         this.dim.xSet(w); 
/* 202 */       this.dim.yIncrement(height);
/* 203 */       fromI = getStartIndex(s, e);
/*     */     } 
/*     */     
/* 206 */     return (COORDINATE)this.dim;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public COORDINATE getStartPosition(CharSequence s, int fromIndex, int toI, int wordLength, int maxwidth, double scale) {
/* 212 */     int height = height(scale);
/* 213 */     this.dim.set(0.0D, 0.0D);
/*     */     
/* 215 */     int fromI = fromIndex;
/* 216 */     while (fromI < toI + wordLength) {
/* 217 */       int e = getEndIndex(s, fromI, toI + wordLength, maxwidth, scale);
/* 218 */       int w = width(s, fromI, e, scale);
/* 219 */       this.dim.xSet(w);
/*     */ 
/*     */       
/* 222 */       if (e > toI || (e == toI && wordLength == 0)) {
/* 223 */         if (e > 0 && s.charAt(e - 1) == '\n') {
/* 224 */           this.dim.xSet(0.0D);
/* 225 */           this.dim.yIncrement(height);
/*     */         } 
/*     */         
/* 228 */         this.dim.xIncrement(-width(s, toI, e, scale));
/* 229 */         return (COORDINATE)this.dim;
/*     */       } 
/* 231 */       fromI = getStartIndex(s, e);
/*     */ 
/*     */       
/* 234 */       this.dim.yIncrement(height);
/*     */     } 
/*     */     
/* 237 */     if (toI > 0 && s.charAt(toI - 1) == '\n') {
/* 238 */       this.dim.xSet(0.0D);
/* 239 */       this.dim.yIncrement(height);
/*     */     } 
/*     */     
/* 242 */     return (COORDINATE)this.dim;
/*     */   }
/*     */   
/*     */   public int renderC(SPRITE_RENDERER r, int cx, int cy, CharSequence s) {
/* 246 */     COORDINATE c = getDim(s);
/* 247 */     int w = c.x();
/* 248 */     int h = c.y();
/* 249 */     cx -= w / 2;
/* 250 */     cy -= h / 2;
/* 251 */     return cy + render(r, cx, cy, DIR.C, s, 0, s.length(), w, h, 1.0D);
/*     */   }
/*     */   
/*     */   public int renderC(SPRITE_RENDERER r, int cx, int cy, CharSequence s, double scale) {
/* 255 */     COORDINATE c = getDim(s);
/* 256 */     int w = (int)(c.x() * scale);
/* 257 */     int h = (int)(c.y() * scale);
/* 258 */     cx -= w / 2;
/* 259 */     cy -= h / 2;
/* 260 */     return cy + render(r, cx, cy, DIR.C, s, 0, s.length(), w, h, scale);
/*     */   }
/*     */   
/*     */   public int renderCX(SPRITE_RENDERER r, int cx, int y1, CharSequence s) {
/* 264 */     return renderCX(r, cx, y1, s, 1.0D);
/*     */   }
/*     */   
/*     */   public void renderCY(SPRITE_RENDERER r, int x1, int cy, CharSequence s) {
/* 268 */     render(r, s, x1, cy - height() / 2, 1.0D);
/*     */   }
/*     */   
/*     */   public int renderCX(SPRITE_RENDERER r, int cx, int y1, CharSequence s, double scale) {
/* 272 */     return renderCX(r, cx, y1, s, scale, 2147483647);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int renderCX(SPRITE_RENDERER r, int cx, int y1, CharSequence s, double scale, int maxWidth) {
/* 278 */     int startI = 0;
/*     */     
/* 280 */     while (startI < s.length()) {
/* 281 */       int end = getEndIndex(s, startI, maxWidth);
/* 282 */       COORDINATE c = getDim(s, startI, end, maxWidth, scale);
/* 283 */       int w = c.x();
/* 284 */       int h = c.y();
/* 285 */       int x = cx - w / 2;
/*     */       
/* 287 */       render(r, x, y1, DIR.C, s, startI, end, w, h, scale);
/* 288 */       startI = end;
/* 289 */       y1 += height(scale);
/*     */     } 
/* 291 */     return y1;
/*     */   }
/*     */   
/*     */   public int renderIn(SPRITE_RENDERER r, RECTANGLE body, DIR align, CharSequence s) {
/* 295 */     return renderIn(r, body.x1(), body.y1(), align, s, body.width(), body.height(), 1.0D);
/*     */   }
/*     */   
/*     */   public int renderIn(SPRITE_RENDERER r, RECTANGLE body, DIR align, CharSequence s, double scale) {
/* 299 */     return renderIn(r, body.x1(), body.y1(), align, s, body.width(), body.height(), scale);
/*     */   }
/*     */   
/*     */   public int renderIn(SPRITE_RENDERER r, int x1, int y1, DIR align, CharSequence s, int maxWidth, int maxHeight, double scale) {
/* 303 */     COORDINATE c = getDim(s, 0, s.length(), maxWidth, scale);
/* 304 */     int w = c.x();
/*     */     
/* 306 */     int h = Math.min(c.y(), maxHeight);
/* 307 */     x1 += (align.x() + 1) * (maxWidth - w) / 2;
/* 308 */     y1 += (align.y() + 1) * (maxHeight - h) / 2;
/* 309 */     return y1 + render(r, x1, y1, align, s, 0, s.length(), w, h, scale);
/*     */   }
/*     */   
/*     */   public void renderCropped(SPRITE_RENDERER r, CharSequence c, int x, int y, int width) {
/* 313 */     renderCropped(r, c, x, y, width, 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderCropped(SPRITE_RENDERER r, CharSequence chars, int x, int y, int width, double scale) {
/* 319 */     int w = 0;
/* 320 */     int e = 0;
/* 321 */     while (e < chars.length()) {
/* 322 */       char c = chars.charAt(e);
/* 323 */       if (c == '\n')
/*     */         break; 
/* 325 */       w += width(chars.charAt(e), scale);
/* 326 */       e++;
/* 327 */       if (e < chars.length()) {
/* 328 */         w -= getBack(chars.charAt(e - 1), chars.charAt(e), scale);
/*     */       }
/* 330 */       if (w >= width) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 335 */     if (e < chars.length()) {
/* 336 */       tmp.clear().add(chars, 0, CLAMP.i(e - 3, 0, e));
/* 337 */       tmp.add('.').add('.').add('.');
/*     */     } else {
/* 339 */       tmp.clear().add(chars);
/*     */     } 
/* 341 */     render(r, x, y, DIR.W, tmp, 0, e, 2147483647, height(), scale);
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, CharSequence c, int x, int y) {
/* 345 */     render(r, c, x, y, 0, c.length(), 1.0D);
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, CharSequence c, int x, int y, double scale) {
/* 349 */     render(r, c, x, y, 0, c.length(), scale);
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, CharSequence c, int x1, int y, int startX, int endX, double scalee) {
/* 353 */     render(r, x1, y, DIR.NW, c, startX, endX, 2147483647, 2147483647, scalee);
/*     */   }
/*     */   
/*     */   public int render(SPRITE_RENDERER r, CharSequence c, int x, int y, int width, double scale) {
/* 357 */     return render(r, x, y, DIR.NW, c, 0, c.length(), width, 2147483647, scale);
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
/*     */   public int render(SPRITE_RENDERER r, int x1, int y1, DIR align, CharSequence s, int fromI, int toI, int maxWidth, int maxHeight, double scale) {
/* 378 */     int h = 0;
/* 379 */     int height = height(scale);
/*     */     
/* 381 */     while (fromI < toI && h < maxHeight) {
/* 382 */       int e = getEndIndex(s, fromI, toI, maxWidth, scale);
/* 383 */       int w = width(s, fromI, e, scale);
/*     */       
/* 385 */       int x = x1 + (align.x() + 1) * (maxWidth - w) / 2;
/* 386 */       while (fromI < e) {
/* 387 */         char c = s.charAt(fromI);
/* 388 */         renderChar(r, c, x, y1 + h, scale);
/*     */         
/* 390 */         x += width(c, scale);
/* 391 */         fromI++;
/* 392 */         if (fromI < e) {
/* 393 */           x -= getBack(c, s.charAt(fromI), scale);
/*     */         }
/*     */       } 
/*     */       
/* 397 */       h += height;
/* 398 */       fromI = getStartIndex(s, fromI);
/*     */     } 
/* 400 */     return h;
/*     */   }
/*     */   
/*     */   public int getStartIndex(CharSequence s, int index) {
/* 404 */     if (index >= s.length())
/* 405 */       return index; 
/* 406 */     if (s.charAt(index) == ' ')
/* 407 */       return index + 1; 
/* 408 */     return index;
/*     */   }
/*     */   
/*     */   public int getEndIndex(CharSequence c, int startX, int maxWidth) {
/* 412 */     return getEndIndex(c, startX, c.length(), maxWidth, 1.0D);
/*     */   }
/*     */   
/*     */   public int getEndIndex(CharSequence chars, int startX, int endIndex, int maxWidth, double scale) {
/* 416 */     int w = 0;
/* 417 */     if (endIndex > chars.length())
/* 418 */       endIndex = chars.length(); 
/* 419 */     int start = startX;
/* 420 */     while (startX < endIndex) {
/* 421 */       char c = chars.charAt(startX);
/* 422 */       if (c == '\n') {
/* 423 */         return startX + 1;
/*     */       }
/* 425 */       int we = wordEnd(chars, startX, endIndex);
/* 426 */       int ww = width(chars, startX, we, scale);
/* 427 */       if (w + ww > maxWidth) {
/* 428 */         if (start == startX) {
/* 429 */           w = width(chars.charAt(start), scale);
/* 430 */           while (w < maxWidth && start < endIndex) {
/* 431 */             start++;
/* 432 */             w += width(chars.charAt(start), scale);
/* 433 */             if (start < endIndex) {
/* 434 */               w -= getBack(chars.charAt(start - 1), chars.charAt(start), scale);
/*     */             }
/*     */           } 
/* 437 */           return start;
/*     */         } 
/* 439 */         return startX;
/*     */       } 
/* 441 */       w += ww;
/* 442 */       startX = we;
/*     */     } 
/* 444 */     return startX;
/*     */   }
/*     */ 
/*     */   
/*     */   public int wordEnd(CharSequence s, int fromI, int toI) {
/* 449 */     if (toI > s.length())
/* 450 */       toI = s.length(); 
/* 451 */     fromI++;
/* 452 */     while (fromI < toI) {
/* 453 */       char c = s.charAt(fromI);
/* 454 */       if (c == '\t')
/* 455 */         return fromI; 
/* 456 */       if (c == ' ')
/* 457 */         return fromI; 
/* 458 */       if (c == '\n')
/* 459 */         return fromI; 
/* 460 */       fromI++;
/*     */     } 
/* 462 */     return fromI;
/*     */   }
/*     */   
/*     */   public int width(CharSequence s, int start, int end, double scale) {
/* 466 */     int w = 0;
/* 467 */     while (start < end) {
/* 468 */       w += width(s.charAt(start), scale);
/* 469 */       start++;
/* 470 */       if (start < end)
/* 471 */         w -= getBack(s.charAt(start - 1), s.charAt(start), scale); 
/*     */     } 
/* 473 */     return w;
/*     */   }
/*     */   
/*     */   public int width(CharSequence s) {
/* 477 */     return width(s, 0, s.length(), 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int width(char c, double scale) {
/* 487 */     if (c == '\t')
/* 488 */       return size((height() * 4), scale); 
/* 489 */     if (c == ' ')
/* 490 */       return size(height() * 0.3D, scale); 
/* 491 */     if (c == '\n')
/* 492 */       return 0; 
/* 493 */     int i = map(c);
/*     */     
/* 495 */     return size(((this.glyphs[i]).width + (this.glyphs[i]).trail), scale);
/*     */   }
/*     */   
/*     */   public int getBack(char prev, char next, double scale) {
/* 499 */     int pi = map(prev);
/* 500 */     if (pi < 0)
/* 501 */       return 0; 
/* 502 */     int ni = map(next);
/* 503 */     if (ni < 0) {
/* 504 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 508 */     int t = (this.glyphs[pi]).ne + (this.glyphs[ni]).nw;
/* 509 */     int b = (this.glyphs[pi]).se + (this.glyphs[ni]).sw;
/* 510 */     return (int)(Math.min(t, b) * scale);
/*     */   }
/*     */   
/*     */   private int size(double w, double scale) {
/* 514 */     return (int)Math.ceil(w * this.scale * scale);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderChar(SPRITE_RENDERER r, char ch, int x, int y, double scalee) {
/* 519 */     if (ch == '\t')
/*     */       return; 
/* 521 */     if (ch == ' ')
/*     */       return; 
/* 523 */     if (ch == '\n') {
/*     */       return;
/*     */     }
/* 526 */     int i = map(ch);
/*     */     
/* 528 */     int x2 = x + size((this.glyphs[i]).width, scalee);
/* 529 */     int y2 = y + height(scalee);
/*     */ 
/*     */     
/* 532 */     int dy = size(((this.glyphs[i]).descent + this.DY), scalee);
/* 533 */     r.renderSprite(x, x2, y + dy, y2 + dy, this.texture.set(i));
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE getText(CharSequence s) {
/* 538 */     return new Text(this, s);
/*     */   }
/*     */   
/*     */   public Text getText(Object s) {
/* 542 */     return new Text(this, s.toString());
/*     */   }
/*     */   
/*     */   public Text getText(int width) {
/* 546 */     return new Text(this, width);
/*     */   }
/*     */   
/*     */   private final class Texture extends TextureCoords { private Texture() {}
/*     */     
/*     */     private Texture set(int ascii) {
/* 552 */       this.x1 = (Font.this.glyphs[ascii]).tx1;
/* 553 */       this.x2 = (short)(this.x1 + (Font.this.glyphs[ascii]).width);
/* 554 */       this.y1 = (Font.this.glyphs[ascii]).ty1;
/* 555 */       this.y2 = (short)(this.y1 + Font.this.height);
/* 556 */       return this;
/*     */     } }
/*     */ 
/*     */   
/*     */   public static class FontGlyph implements SAVABLE {
/*     */     public short tx1;
/*     */     public short ty1;
/*     */     public short width;
/*     */     public short trail;
/*     */     public short descent;
/*     */     public byte nw;
/*     */     public byte sw;
/*     */     public byte ne;
/*     */     public byte se;
/*     */     
/*     */     public void save(FilePutter file) {
/* 572 */       file.s(this.tx1);
/* 573 */       file.s(this.ty1);
/* 574 */       file.s(this.width);
/* 575 */       file.s(this.trail);
/* 576 */       file.s(this.descent);
/* 577 */       file.b(this.nw);
/* 578 */       file.b(this.sw);
/* 579 */       file.b(this.ne);
/* 580 */       file.b(this.se);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 585 */       this.tx1 = file.s();
/* 586 */       this.ty1 = file.s();
/* 587 */       this.width = file.s();
/* 588 */       this.trail = file.s();
/* 589 */       this.descent = file.s();
/* 590 */       this.nw = file.b();
/* 591 */       this.sw = file.b();
/* 592 */       this.ne = file.b();
/* 593 */       this.se = file.b();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void clear() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 603 */       return String.valueOf(this.nw) + " " + this.ne + " " + this.sw + " " + this.se + " " + this.descent + " " + this.trail;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sprite\text\Font.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */