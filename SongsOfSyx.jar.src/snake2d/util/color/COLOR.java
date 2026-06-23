/*     */ package snake2d.util.color;
/*     */ 
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ public interface COLOR
/*     */   extends SPRITE, RGB
/*     */ {
/*  15 */   public static final COLOR WHITE100 = new ColorImp(127, 127, 127);
/*  16 */   public static final COLOR WHITE120 = new ColorImp(150, 150, 150);
/*  17 */   public static final COLOR WHITE150 = new ColorImp(190, 190, 190);
/*  18 */   public static final COLOR WHITE200 = new ColorImp(255, 255, 255);
/*  19 */   public static final COLOR WHITE85 = new ColorImp(109, 109, 109);
/*  20 */   public static final COLOR WHITE65 = new ColorImp(80, 80, 80);
/*  21 */   public static final COLOR WHITE50 = new ColorImp(64, 64, 64);
/*  22 */   public static final COLOR WHITE35 = new ColorImp(45, 45, 45);
/*  23 */   public static final COLOR WHITE30 = new ColorImp(38, 38, 38);
/*  24 */   public static final COLOR WHITE25 = new ColorImp(31, 31, 31);
/*  25 */   public static final COLOR WHITE20 = new ColorImp(26, 26, 26);
/*  26 */   public static final COLOR WHITE15 = new ColorImp(19, 19, 19);
/*  27 */   public static final COLOR WHITE10 = new ColorImp(13, 13, 13);
/*  28 */   public static final COLOR WHITE05 = new ColorImp(7, 7, 7);
/*     */ 
/*     */   
/*  31 */   public static final COLOR BROWN = new ColorImp(72, 58, 33);
/*  32 */   public static final COLOR BLACK = new ColorImp(0, 0, 0);
/*  33 */   public static final COLOR RED50 = new ColorImp(64, 0, 0);
/*  34 */   public static final COLOR RED100 = new ColorImp(127, 0, 0);
/*  35 */   public static final COLOR REDISH = new ColorImp(127, 40, 40);
/*  36 */   public static final COLOR RED200 = new ColorImp(255, 0, 0);
/*  37 */   public static final COLOR RED2RED = new ColorShifting(RED50, RED100);
/*  38 */   public static final COLOR GREEN40 = new ColorImp(0, 51, 0);
/*  39 */   public static final COLOR GREEN80 = new ColorImp(0, 102, 0);
/*  40 */   public static final COLOR GREEN90 = new ColorImp(0, 115, 0);
/*  41 */   public static final COLOR GREEN100 = new ColorImp(0, 128, 0);
/*  42 */   public static final COLOR GREEN200 = new ColorImp(0, 255, 0);
/*  43 */   public static final COLOR GREENISH80 = new ColorImp(90, 120, 90);
/*  44 */   public static final COLOR GREENISH200 = new ColorImp(200, 255, 200);
/*  45 */   public static final COLOR ORANGE100 = new ColorImp(127, 53, 0);
/*  46 */   public static final COLOR ORANGE150 = new ColorImp(127, 72, 72);
/*  47 */   public static final COLOR YELLOW100 = new ColorImp(127, 127, 0);
/*  48 */   public static final COLOR BLUE50 = new ColorImp(0, 0, 64);
/*  49 */   public static final COLOR BLUEDARK = new ColorImp(10, 10, 24);
/*  50 */   public static final COLOR BLUE100 = new ColorImp(0, 0, 127);
/*  51 */   public static final COLOR NYAN100 = new ColorImp(0, 127, 127);
/*  52 */   public static final COLOR BLUEISH = new ColorImp(48, 48, 127);
/*  53 */   public static final COLOR PURPLE = new ColorImp(127, 0, 127);
/*  54 */   public static final COLOR PURPLISH = new ColorImp(127, 70, 127);
/*     */   
/*  56 */   public static final COLOR GREEN2RED = new ColorShifting(ColorImp.RED100, ColorImp.RED100);
/*  57 */   public static final COLOR GREEN2GREEN = new ColorShifting(ColorImp.GREEN40, ColorImp.GREEN100);
/*  58 */   public static final COLOR GREENISH = new ColorShifting(GREENISH80, GREENISH200);
/*  59 */   public static final COLOR WHITE2WHITE = new ColorShifting(WHITE50, WHITE200);
/*  60 */   public static final COLOR WHITE702WHITE100 = new ColorShifting(WHITE65, WHITE100);
/*  61 */   public static final COLOR WHITE202WHITE100 = (new ColorShifting(WHITE20, WHITE100)).setSpeed(2.5D);
/*  62 */   public static final COLOR WHITE15WHITE50 = new ColorShifting(WHITE15, WHITE50);
/*  63 */   public static final COLOR WHITE120_2_WHITE150 = new ColorShifting(WHITE120, WHITE150);
/*  64 */   public static final COLOR BLACK2WHITE = new ColorShifting(BLACK, WHITE100);
/*  65 */   public static final COLOR BLUE2BLUE = new ColorShifting(BLUE50, BLUE100);
/*     */   
/*  67 */   public static final COLOR DARK_GREEN = new ColorImp(7, 36, 2);
/*  68 */   public static final COLOR MEDIUM_GREEN = new ColorImp(7, 36, 2);
/*  69 */   public static final COLOR MEDIUM_BROWN = new ColorImp(26, 46, 2);
/*  70 */   public static final COLOR DARK_BROWN = new ColorImp(26, 30, 2);
/*     */   
/*  72 */   public static final LIST<COLOR> UNIQUE = (LIST<COLOR>)new ArrayList((Object[])new ColorImp[] { 
/*  73 */         (new ColorImp(255, 179, 0)).shade(0.5D), (
/*  74 */         new ColorImp(128, 62, 117)).shade(0.5D), (
/*  75 */         new ColorImp(255, 104, 0)).shade(0.5D), (
/*  76 */         new ColorImp(166, 189, 215)).shade(0.5D), (
/*  77 */         new ColorImp(193, 0, 32)).shade(0.5D), (
/*  78 */         new ColorImp(206, 162, 98)).shade(0.5D), (
/*  79 */         new ColorImp(129, 112, 102)).shade(0.5D), (
/*  80 */         new ColorImp(0, 125, 52)).shade(0.5D), (
/*  81 */         new ColorImp(246, 118, 142)).shade(0.5D), (
/*  82 */         new ColorImp(0, 83, 138)).shade(0.5D), 
/*  83 */         (new ColorImp(255, 122, 92)).shade(0.5D), (
/*  84 */         new ColorImp(83, 55, 122)).shade(0.5D), (
/*  85 */         new ColorImp(255, 142, 0)).shade(0.5D), (
/*  86 */         new ColorImp(179, 40, 81)).shade(0.5D), (
/*  87 */         new ColorImp(244, 200, 0)).shade(0.5D), (
/*  88 */         new ColorImp(127, 24, 13)).shade(0.5D), (
/*  89 */         new ColorImp(147, 170, 0)).shade(0.5D), (
/*  90 */         new ColorImp(89, 51, 21)).shade(0.5D), (
/*  91 */         new ColorImp(241, 58, 19)).shade(0.5D), (
/*  92 */         new ColorImp(35, 44, 22)).shade(0.5D) });
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default void bind() {
/*  98 */     CORE.renderer().setColor(this);
/*     */   }
/*     */   
/*     */   static void unbind() {
/* 102 */     CORE.renderer().setNormalColor();
/*     */   }
/*     */ 
/*     */   
/*     */   byte red();
/*     */ 
/*     */   
/*     */   default int getComp(int comp) {
/* 110 */     switch (comp) { case 0:
/* 111 */         return red() & 0xFF;
/* 112 */       case 1: return green() & 0xFF;
/* 113 */       case 2: return blue() & 0xFF; }
/* 114 */      throw new RuntimeException(comp);
/*     */   }
/*     */   byte green();
/*     */   byte blue();
/*     */   default ColorImp shade(double s) {
/* 119 */     int r = red() & 0xFF;
/* 120 */     int g = green() & 0xFF;
/* 121 */     int b = blue() & 0xFF;
/* 122 */     return new ColorImp((int)(r * s), (int)(g * s), (int)(b * s));
/*     */   }
/*     */   
/*     */   default ColorImp makeSaturated(double amount) {
/* 126 */     return (new ColorImp()).set(this).saturateSelf(amount);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static ColorImp[] interpolate(COLOR c, COLOR c2, int amount) {
/* 132 */     double r = Byte.toUnsignedInt(c.red());
/* 133 */     double g = Byte.toUnsignedInt(c.green());
/* 134 */     double b = Byte.toUnsignedInt(c.blue());
/*     */     
/* 136 */     double dr = (Byte.toUnsignedInt(c2.red()) - r) / (amount - 1);
/* 137 */     double dg = (Byte.toUnsignedInt(c2.green()) - g) / (amount - 1);
/* 138 */     double db = (Byte.toUnsignedInt(c2.blue()) - b) / (amount - 1);
/*     */     
/* 140 */     ColorImp[] res = new ColorImp[amount];
/*     */     
/* 142 */     for (int i = 0; i < amount; i++) {
/* 143 */       res[i] = new ColorImp((byte)(int)r, (byte)(int)g, (byte)(int)b);
/* 144 */       r += dr;
/* 145 */       g += dg;
/* 146 */       b += db;
/*     */     } 
/*     */     
/* 149 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   default void render(SPRITE_RENDERER r, RECTANGLE rec, int margin) {
/* 154 */     render(r, rec.x1() - margin, rec.x2() + margin, rec.y1() - margin, rec.y2() + margin);
/*     */   }
/*     */   
/*     */   default void render(SPRITE_RENDERER r, int x, int y, int w, int h, int margin) {
/* 158 */     render(r, x - margin, x + w + margin, y - margin, y + h + margin);
/*     */   }
/*     */   
/*     */   default void render(SPRITE_RENDERER r, int x, int y, int w, int h, int marginX, int marginY) {
/* 162 */     render(r, x - marginX, x + w + marginX, y - marginY, y + h + marginY);
/*     */   }
/*     */   
/*     */   default void renderFrame(SPRITE_RENDERER r, int x1, int x2, int y1, int y2, int m, int thickness) {
/* 166 */     x1 -= m;
/* 167 */     x2 += m;
/* 168 */     y1 -= m;
/* 169 */     y2 += m;
/* 170 */     render(r, x1, x1 + thickness, y1, y2);
/* 171 */     render(r, x2 - thickness, x2, y1, y2);
/* 172 */     render(r, x1 + thickness, x2 - thickness, y1, y1 + thickness);
/* 173 */     render(r, x1 + thickness, x2 - thickness, y2 - thickness, y2);
/*     */   }
/*     */   
/*     */   default void renderFrame(SPRITE_RENDERER r, RECTANGLE body, int m, int thickness) {
/* 177 */     renderFrame(r, body.x1(), body.x2(), body.y1(), body.y2(), m, thickness);
/*     */   }
/*     */   
/*     */   default SPRITE makeSprite(final int width, final int height) {
/* 181 */     return new SPRITE()
/*     */       {
/*     */         public int width()
/*     */         {
/* 185 */           return width;
/*     */         }
/*     */ 
/*     */         
/*     */         public int height() {
/* 190 */           return height;
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
/* 201 */           COLOR.this.render(r, X1, X2, Y1, Y2);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   default SPRITE makeFrame(final int width, final int height, final int w) {
/* 207 */     return new SPRITE()
/*     */       {
/*     */         public int width()
/*     */         {
/* 211 */           return width;
/*     */         }
/*     */ 
/*     */         
/*     */         public int height() {
/* 216 */           return height;
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
/* 227 */           COLOR.this.renderFrame(r, X1, X2, Y1, Y2, 0, w);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   static COLOR[] generateUnique(int min, int amount, boolean ran) {
/* 234 */     COLOR[] cols = new COLOR[amount];
/* 235 */     int rM = (int)Math.pow(amount, 0.3333333333333333D);
/* 236 */     int gM = rM;
/* 237 */     int bM = (int)Math.ceil(amount / (rM * gM));
/*     */     
/* 239 */     double delta = (127 - min);
/*     */     
/* 241 */     double rD = delta / rM;
/* 242 */     double gD = delta / gM;
/* 243 */     double bD = delta / bM;
/*     */     
/* 245 */     int in = 0;
/*     */     int r;
/* 247 */     label26: for (r = 0; r < rM; r++) {
/* 248 */       for (int g = 0; g < gM; g++) {
/* 249 */         for (int b = 0; b < bM; b++) {
/* 250 */           if (in >= cols.length)
/*     */             break label26; 
/* 252 */           ColorImp colorImp = new ColorImp();
/* 253 */           colorImp.setRed(min + (int)(rD / 2.0D + r * rD));
/* 254 */           colorImp.setGreen(min + (int)(gD / 2.0D + g * gD));
/* 255 */           colorImp.setBlue(min + (int)(bD / 2.0D + b * bD));
/* 256 */           cols[in++] = colorImp;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 261 */     for (int i = 0; i < cols.length; i++) {
/* 262 */       int k = RND.rInt(cols.length);
/* 263 */       COLOR n = cols[i];
/* 264 */       cols[i] = cols[k];
/* 265 */       cols[k] = n;
/*     */     } 
/*     */ 
/*     */     
/* 269 */     return cols;
/*     */   }
/*     */   
/*     */   static boolean equals(COLOR a, COLOR c) {
/* 273 */     if (a == null || c == null)
/* 274 */       return false; 
/* 275 */     return (c.red() == a.red() && c.green() == a.green() && c.blue() == a.blue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static COLOR[] generateUnique2(int min, int amount, boolean ran) {
/* 283 */     int MAX = amount;
/*     */     
/* 285 */     COLOR[] cols = new COLOR[MAX];
/*     */     
/* 287 */     int am = 0;
/* 288 */     int div = 2;
/* 289 */     double delta = (127 - min);
/*     */     
/* 291 */     while (am < MAX) {
/* 292 */       for (int dr = 0; dr < div; dr++) {
/* 293 */         for (int dg = 0; dg < div; dg++) {
/* 294 */           for (int db = 0; db < div; db++) {
/* 295 */             if (dr != dg || dr != db) {
/*     */ 
/*     */               
/* 298 */               int r = (int)(min + dr * delta / (div - 1));
/* 299 */               int g = (int)(min + dg * delta / (div - 1));
/* 300 */               int b = (int)(min + db * delta / (div - 1));
/* 301 */               if (am < MAX) {
/* 302 */                 cols[am] = new ColorImp(r, g, b);
/*     */               }
/* 304 */               am++;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 312 */       div++;
/*     */     } 
/*     */ 
/*     */     
/* 316 */     if (ran) {
/* 317 */       for (int i = 0; i < cols.length; i++) {
/* 318 */         int k = RND.rInt(cols.length);
/* 319 */         COLOR n = cols[i];
/* 320 */         cols[i] = cols[k];
/* 321 */         cols[k] = n;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 328 */     return cols;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\color\COLOR.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */