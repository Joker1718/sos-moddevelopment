/*     */ package snake2d.util.color;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ 
/*     */ public class ColorImp
/*     */   implements COLOR, Serializable, SAVABLE
/*     */ {
/*  24 */   public static final ColorImp TMP = new ColorImp();
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*  27 */   private static final TextureCoords texture = new TextureCoords();
/*     */   
/*     */   private static short width;
/*     */   
/*     */   private static short height;
/*     */   
/*     */   private byte red;
/*     */   private byte green;
/*     */   private byte blue;
/*     */   private static final double ii = 0.00392156862745098D;
/*     */   
/*     */   public static void setSPRITE(int wX1, int wY1, int w, int h) {
/*  39 */     texture.get(wX1, wY1, w, h);
/*  40 */     width = (short)w;
/*  41 */     height = (short)h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ColorImp() {
/*  50 */     this(127, 127, 127);
/*     */   }
/*     */ 
/*     */   
/*     */   public ColorImp(int red, int green, int blue) {
/*  55 */     setRed(red);
/*  56 */     setGreen(green);
/*  57 */     setBlue(blue);
/*     */   }
/*     */ 
/*     */   
/*     */   public ColorImp(Json json) {
/*  62 */     this(json, "COLOR");
/*     */   }
/*     */   
/*     */   public static LIST<ColorImp> cols(Json json) {
/*  66 */     return cols(json, "COLOR");
/*     */   }
/*     */   
/*     */   public static LIST<ColorImp> cols(Json json, String key) {
/*  70 */     if (!json.has(key))
/*  71 */       throw new RuntimeException(); 
/*  72 */     if (json.jsonIs(key)) {
/*  73 */       json = json.json(key);
/*  74 */       if (json.has("R") && json.has("B") && json.has("G")) {
/*  75 */         return (LIST<ColorImp>)new ArrayList(new ColorImp(json, key));
/*     */       }
/*  77 */       COLOR from = new ColorImp(json, "FROM");
/*  78 */       COLOR to = new ColorImp(json, "TO");
/*  79 */       return (LIST<ColorImp>)new ArrayList((Object[])COLOR.interpolate(from, to, json.i("GENERATE", 0, 1024)));
/*     */     } 
/*  81 */     if (json.jsonsIs(key)) {
/*  82 */       LinkedList<ColorImp> cols = new LinkedList(); byte b; int i; Json[] arrayOfJson;
/*  83 */       for (i = (arrayOfJson = json.jsons(key)).length, b = 0; b < i; ) { Json j = arrayOfJson[b];
/*  84 */         cols.add(new ColorImp(j)); b++; }
/*  85 */        return (LIST<ColorImp>)new ArrayList((Iterable)cols);
/*     */     } 
/*  87 */     if (json.arrayIs(key)) {
/*  88 */       String[] ss = json.values(key);
/*  89 */       ArrayList<ColorImp> res = new ArrayList(ss.length);
/*  90 */       for (int i = 0; i < ss.length; i++) {
/*  91 */         ColorImp col = new ColorImp();
/*  92 */         col.set(ss[i], json);
/*  93 */         res.add(col);
/*     */       } 
/*  95 */       return (LIST<ColorImp>)res;
/*     */     } 
/*  97 */     String s = json.value(key);
/*  98 */     return (LIST<ColorImp>)new ArrayList((new ColorImp()).set(s, json));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ColorImp(Json json, String key) {
/* 105 */     if (json.has(key) && json.jsonIs(key)) {
/* 106 */       json = json.json(key);
/*     */     }
/*     */     
/* 109 */     if (json.has("R") && json.has("G") && json.has("B")) {
/* 110 */       set(json.i("R", 0, 511) / 2, json.i("G", 0, 511) / 2, json.i("B", 0, 511) / 2);
/*     */     } else {
/* 112 */       String v = json.value(key);
/* 113 */       set(v, json);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ColorImp set(String v, Json error) {
/* 122 */     if (v.indexOf("_") < 0)
/* 123 */       error.error("Wrong format of color. Should be RED_GREEN_BLUE", v); 
/* 124 */     String[] vv = v.split("_");
/* 125 */     if (vv.length != 3)
/* 126 */       error.error("Wrong format of color. Should be RED_GREEN_BLUE, where RED, GREEN and BLUE is an integer 0-255. eg 129_12_0", v); 
/* 127 */     int[] cols = Alloc.ii(3);
/* 128 */     for (int i = 0; i < cols.length; i++) {
/*     */       try {
/* 130 */         cols[i] = Integer.parseInt(vv[i]);
/* 131 */       } catch (Exception e) {
/* 132 */         error.error("Wrong format of color. Should be RED_GREEN_BLUE, where RED, GREEN and BLUE is an integer 0-255. eg 129_12_0", v);
/*     */       } 
/*     */     } 
/*     */     
/* 136 */     set(cols[0] / 2, cols[1] / 2, cols[2] / 2);
/* 137 */     return this;
/*     */   }
/*     */   
/*     */   public ColorImp(COLOR c) {
/* 141 */     set(c);
/*     */   }
/*     */   
/*     */   public ColorImp set(COLOR c) {
/* 145 */     if (c instanceof ColorShifting) {
/* 146 */       c.bind();
/* 147 */       COLOR.unbind();
/*     */     } 
/* 149 */     this.red = c.red();
/* 150 */     this.blue = c.blue();
/* 151 */     this.green = c.green();
/* 152 */     return this;
/*     */   }
/*     */   
/*     */   public static void unBind() {
/* 156 */     CORE.renderer().setNormalColor();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte red() {
/* 161 */     return this.red;
/*     */   }
/*     */   
/*     */   public ColorImp set(int r, int g, int b) {
/* 165 */     setRed(r);
/* 166 */     setGreen(g);
/* 167 */     setBlue(b);
/* 168 */     return this;
/*     */   }
/*     */   
/*     */   public ColorImp setAll(int i) {
/* 172 */     setRed(i);
/* 173 */     setGreen(i);
/* 174 */     setBlue(i);
/* 175 */     return this;
/*     */   }
/*     */   
/*     */   public ColorImp setRed(int red) {
/* 179 */     this.red = (byte)red;
/* 180 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte green() {
/* 185 */     return this.green;
/*     */   }
/*     */   
/*     */   public ColorImp setGreen(int green) {
/* 189 */     this.green = (byte)green;
/* 190 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte blue() {
/* 195 */     return this.blue;
/*     */   }
/*     */   
/*     */   public ColorImp setBlue(int blue) {
/* 199 */     this.blue = (byte)blue;
/* 200 */     return this;
/*     */   }
/*     */   
/*     */   public ColorImp setComp(int comp, int c) {
/* 204 */     switch (comp) { case 0:
/* 205 */         setRed(c);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 210 */         return this;case 1: setGreen(c); return this;case 2: setBlue(c); return this; }
/*     */     
/*     */     throw new RuntimeException(comp);
/*     */   }
/*     */ 
/*     */   
/*     */   public ColorImp setAmount(double amount, double max) {
/* 217 */     this.blue = 0;
/* 218 */     double ratio = amount / max;
/*     */     
/* 220 */     if (ratio < 0.5D) {
/* 221 */       this.green = (byte)(int)(128.0D * ratio * 2.0D);
/* 222 */       this.red = Byte.MIN_VALUE;
/* 223 */     } else if (ratio <= 1.0D) {
/* 224 */       if (ratio > 1.0D) {
/* 225 */         ratio = 1.0D;
/*     */       }
/* 227 */       this.green = Byte.MIN_VALUE;
/* 228 */       this.red = (byte)(int)(128.0D - (ratio - 0.5D) * 2.0D * 128.0D);
/*     */     } else {
/* 230 */       if (ratio > 2.0D) {
/* 231 */         ratio = 2.0D;
/*     */       }
/* 233 */       this.red = 0;
/* 234 */       this.green = Byte.MIN_VALUE;
/* 235 */       this.blue = (byte)(int)((ratio - 1.0D) * 128.0D);
/*     */     } 
/* 237 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int width() {
/* 242 */     return width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 247 */     return height;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 252 */     bind();
/* 253 */     r.renderSprite(X1, X2, Y1, Y2, texture);
/*     */     
/* 255 */     unBind();
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int Y1) {
/* 260 */     bind();
/* 261 */     r.renderSprite(X1, X1 + width, Y1, Y1 + width, texture);
/* 262 */     unBind();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 267 */     return String.valueOf(Byte.toUnsignedInt(this.red)) + "_" + Byte.toUnsignedInt(this.green) + "_" + Byte.toUnsignedInt(this.blue);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString2() {
/* 272 */     return String.valueOf(Byte.toUnsignedInt(this.red) * 2) + "_" + (Byte.toUnsignedInt(this.green) * 2) + "_" + (Byte.toUnsignedInt(this.blue) * 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, RECTANGLE rec) {
/* 277 */     render(r, rec.x1(), rec.x2(), rec.y1(), rec.y2());
/*     */   }
/*     */ 
/*     */   
/*     */   public ColorImp interpolate(COLOR c1, COLOR c2, double part) {
/* 282 */     part = CLAMP.d(part, 0.0D, 1.0D);
/*     */     
/* 284 */     if (Double.isNaN(part)) {
/* 285 */       part = 0.0D;
/*     */     }
/* 287 */     int r = (int)Math.round((c1.red() & 0xFF) * (1.0D - part) + (c2.red() & 0xFF) * part);
/* 288 */     int g = (int)Math.round((c1.green() & 0xFF) * (1.0D - part) + (c2.green() & 0xFF) * part);
/* 289 */     int b = (int)Math.round((c1.blue() & 0xFF) * (1.0D - part) + (c2.blue() & 0xFF) * part);
/*     */     
/* 291 */     setRed(r);
/* 292 */     setGreen(g);
/* 293 */     setBlue(b);
/* 294 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ColorImp interpolate(LIST<? extends COLOR> cols, double part) {
/* 299 */     if (cols.size() <= 0) {
/* 300 */       return this;
/*     */     }
/* 302 */     double dc = part * (cols.size() - 1);
/* 303 */     int di = (int)dc;
/* 304 */     dc -= di;
/* 305 */     int dn = Math.min(di + 1, cols.size() - 1);
/* 306 */     interpolate((COLOR)cols.getC(di), (COLOR)cols.getC(dn), dc);
/* 307 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void multiply(COLOR other) {
/* 313 */     double m = 127.0D;
/* 314 */     double i = 1.0D / m;
/*     */     
/* 316 */     double r = (red() & 0xFF) * i;
/* 317 */     double g = (green() & 0xFF) * i;
/* 318 */     double b = (blue() & 0xFF) * i;
/*     */     
/* 320 */     double r1 = (other.red() & 0xFF) * i;
/* 321 */     double g1 = (other.green() & 0xFF) * i;
/* 322 */     double b1 = (other.blue() & 0xFF) * i;
/*     */     
/* 324 */     setRed(CLAMP.i((int)(r * r1 * m), 0, 255));
/* 325 */     setGreen(CLAMP.i((int)(g * g1 * m), 0, 255));
/* 326 */     setBlue(CLAMP.i((int)(b * b1 * m), 0, 255));
/*     */   }
/*     */ 
/*     */   
/*     */   public ColorImp shadeSelf(double shade) {
/* 331 */     set((int)((red() & 0xFF) * shade), (int)((green() & 0xFF) * shade), (int)((blue() & 0xFF) * shade));
/* 332 */     return this;
/*     */   }
/*     */   
/*     */   public ColorImp setBrightnessSelf(double shade) {
/* 336 */     int hi = red() & 0xFF;
/* 337 */     hi = Math.max(hi, green() & 0xFF);
/* 338 */     hi = Math.max(hi, blue() & 0xFF);
/*     */     
/* 340 */     int sh = (int)(shade * 127.0D);
/* 341 */     sh = CLAMP.i(sh, 0, 255);
/*     */     
/* 343 */     double d = 1.0D + (sh - hi) / 255.0D;
/*     */     
/* 345 */     setRed(CLAMP.i((int)((red() & 0xFF) * d), 0, 255));
/* 346 */     setGreen(CLAMP.i((int)((green() & 0xFF) * d), 0, 255));
/* 347 */     setBlue(CLAMP.i((int)((blue() & 0xFF) * d), 0, 255));
/* 348 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ColorImp setMinBrightnessSelf(double shade) {
/* 353 */     setBrightnessSelf(shade);
/*     */     
/* 355 */     int r = this.red % 255;
/* 356 */     int g = this.green & 0xFF;
/* 357 */     int b = this.blue & 0xFF;
/*     */     
/* 359 */     double tot = (r + g + b);
/* 360 */     tot /= 381.0D;
/*     */     
/* 362 */     if (tot >= shade) {
/* 363 */       return this;
/*     */     }
/* 365 */     shade -= tot;
/* 366 */     shade *= 381.0D;
/*     */     
/* 368 */     if (r < 127) {
/* 369 */       int i = (int)(shade / 3.0D);
/* 370 */       i = (int)CLAMP.d(i, 0.0D, (127 - r));
/* 371 */       r += i;
/* 372 */       shade -= i;
/*     */     } 
/*     */     
/* 375 */     if (g < 127) {
/* 376 */       int i = (int)(shade / 2.0D);
/* 377 */       i = (int)CLAMP.d(i, 0.0D, (127 - g));
/* 378 */       g += i;
/* 379 */       shade -= i;
/*     */     } 
/*     */     
/* 382 */     int am = (int)shade;
/* 383 */     am = (int)CLAMP.d(am, 0.0D, (127 - b));
/* 384 */     b += am;
/*     */     
/* 386 */     set(r, g, b);
/*     */     
/* 388 */     setRed(CLAMP.i(r, 0, 255));
/* 389 */     setGreen(CLAMP.i(g, 0, 255));
/* 390 */     setBlue(CLAMP.i(b, 0, 255));
/* 391 */     return this;
/*     */   }
/*     */   
/*     */   public ColorImp add(int am) {
/* 395 */     set((red() & 0xFF) + am, (green() & 0xFF) + am, (blue() & 0xFF) + am);
/* 396 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public ColorImp saturateSelf(double amount) {
/* 401 */     double r = (red() & 0xFF);
/* 402 */     double g = (green() & 0xFF);
/* 403 */     double b = (blue() & 0xFF);
/*     */ 
/*     */     
/* 406 */     double min = 255.0D;
/* 407 */     double max = 0.0D;
/*     */     
/* 409 */     if (r < min)
/* 410 */       min = r; 
/* 411 */     if (r > max)
/* 412 */       max = r; 
/* 413 */     if (g < min)
/* 414 */       min = g; 
/* 415 */     if (g > max)
/* 416 */       max = g; 
/* 417 */     if (b < min)
/* 418 */       min = b; 
/* 419 */     if (b > max) {
/* 420 */       max = b;
/*     */     }
/* 422 */     double lum = (min + max) / 2.0D;
/*     */ 
/*     */     
/* 425 */     int red = (int)(lum + (r - lum) * amount);
/* 426 */     int green = (int)(lum + (g - lum) * amount);
/* 427 */     int blue = (int)(lum + (b - lum) * amount);
/* 428 */     set(red, green, blue);
/* 429 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {
/* 435 */     CORE.renderer().renderTextured(X1, X2, Y1, Y2, 
/* 436 */         texture, ColorImp.texture);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 442 */     file.i(this.red & 0xFF | this.green << 8 & 0xFF00 | this.blue << 16 & 0xFF0000);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 447 */     int i = file.i();
/* 448 */     this.red = (byte)(i & 0xFF);
/* 449 */     this.green = (byte)(i >> 8 & 0xFF);
/* 450 */     this.blue = (byte)(i >> 16 & 0xFF);
/*     */   }
/*     */ 
/*     */   
/*     */   public TextureCoords texture() {
/* 455 */     return texture;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void randomize(double d) {
/* 465 */     this.red = (byte)CLAMP.i((int)(this.red + RND.rFloat() * d * 255.0D), 0, 255);
/* 466 */     this.green = (byte)CLAMP.i((int)(this.green + RND.rFloat() * d * 255.0D), 0, 255);
/* 467 */     this.blue = (byte)CLAMP.i((int)(this.blue + RND.rFloat() * d * 255.0D), 0, 255);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double r() {
/* 474 */     return (this.red & 0xFF) * 0.00392156862745098D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double g() {
/* 479 */     return (this.green & 0xFF) * 0.00392156862745098D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double b() {
/* 484 */     return (this.blue & 0xFF) * 0.00392156862745098D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\color\ColorImp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */