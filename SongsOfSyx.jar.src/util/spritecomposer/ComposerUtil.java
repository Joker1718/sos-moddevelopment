/*     */ package util.spritecomposer;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.SnakeImage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ComposerUtil
/*     */ {
/*     */   private Path sourcePath;
/*     */   private SnakeImage TexSource;
/*     */   private int sourceHalf;
/*  23 */   private final int[][] buffer = Alloc.i2(1024, 1024);
/*  24 */   private final int[][] buffern = Alloc.i2(1024, 1024);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void drawNormal(ComposerDests.Dest dest, int x, int y, int width, int height) {
/*  31 */     for (int y1 = 0; y1 < height; y1++) {
/*  32 */       for (int x1 = 0; x1 < width; x1++) {
/*  33 */         dest.normalSet(x + x1, y + y1, 128, 128, 255, 255);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   void setSource(Path path, int width, int minHeight) throws IOException {
/*  39 */     setSource(path);
/*  40 */     if (Resources.p != null) {
/*     */       
/*  42 */       if (this.TexSource.width != width)
/*  43 */         throw new Errors.DataError("Image has the wrong width of " + this.TexSource.width + "\nresize the image's width to " + 
/*  44 */             width, String.valueOf(path)); 
/*  45 */       if (this.TexSource.height < minHeight) {
/*  46 */         throw new Errors.DataError("Image has the wrong height of " + this.TexSource.height + "\nresize the image's hight to at least " + 
/*  47 */             minHeight, String.valueOf(path));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   void setSource(Path path) throws IOException {
/*  53 */     if (Resources.p != null) {
/*  54 */       this.sourcePath = path;
/*  55 */       if (this.TexSource != null) {
/*  56 */         this.TexSource.dispose();
/*  57 */         this.TexSource = null;
/*     */       } 
/*  59 */       CORE.checkIn();
/*  60 */       this.TexSource = new SnakeImage(path);
/*  61 */       if (this.TexSource.width % 2 != 0)
/*  62 */         throw new RuntimeException(String.valueOf(path) + "  has the wrong dimension. Width must be divisible by 2"); 
/*  63 */       this.sourceHalf = this.TexSource.width / 2;
/*  64 */       saveFile(path);
/*     */     } else {
/*  66 */       validateFile(path);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void saveFile(Path path) {
/*  72 */     Resources.p.chars(PATHS.getSavePath(path));
/*     */     try {
/*  74 */       Resources.p.l(Files.getLastModifiedTime(path, new java.nio.file.LinkOption[0]).toMillis());
/*  75 */     } catch (IOException e) {
/*  76 */       e.printStackTrace();
/*  77 */       throw new RuntimeException();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void validateFile(Path path) throws IOException {
/*  83 */     String path2 = Resources.g.chars();
/*  84 */     if (!PATHS.getSavePath(path).equals(path2))
/*  85 */       throw new IOException(PATHS.getSavePath(path) + " " + PATHS.getSavePath(path)); 
/*  86 */     long l = Files.getLastModifiedTime(path, new java.nio.file.LinkOption[0]).toMillis();
/*  87 */     long l2 = Resources.g.l();
/*  88 */     if (l != l2)
/*  89 */       throw new IOException(String.valueOf(path) + " " + String.valueOf(path) + " " + l); 
/*     */   }
/*     */   
/*     */   Path getSourcePath() {
/*  93 */     return this.sourcePath;
/*     */   }
/*     */ 
/*     */   
/*     */   void copy(ComposerSources.Source source) {
/*  98 */     int sx = source.x1();
/*  99 */     int sy = source.y1();
/*     */     
/* 101 */     for (int y = 0; y < source.height(); y++) {
/* 102 */       for (int x = 0; x < source.width(); x++) {
/* 103 */         this.buffer[y][x] = this.TexSource.rgb.get(sx + x, sy + y);
/* 104 */         if (sx + x + this.sourceHalf >= this.TexSource.width) {
/* 105 */           System.err.println("" + sx + " " + sx + " " + x);
/* 106 */           System.err.println("" + source.width() + " " + source.width());
/*     */         } 
/* 108 */         this.buffern[y][x] = this.TexSource.rgb.get(sx + x + this.sourceHalf, sy + y);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void blendWithBackground(ComposerDests.Dest background, ComposerSources.Source stencil, ComposerSources.Source foreground) {
/* 115 */     int sx = stencil.x1();
/* 116 */     int sy = stencil.y1();
/* 117 */     int bx = background.x1();
/* 118 */     int by = background.y1();
/* 119 */     int fx = foreground.x1();
/* 120 */     int fy = foreground.y1();
/*     */     
/* 122 */     for (int y = 0; y < stencil.height(); y++) {
/* 123 */       for (int x = 0; x < stencil.width(); x++) {
/*     */         
/* 125 */         int sc = this.TexSource.rgb.get(sx + x, sy + y);
/* 126 */         int bc = background.diffuseGet(bx + x, by + y);
/*     */         
/* 128 */         if ((sc & 0xFF00) == 0) {
/* 129 */           this.buffer[y][x] = bc;
/* 130 */           this.buffern[y][x] = background.normalGet(bx + x, by + y);
/*     */         }
/*     */         else {
/*     */           
/* 134 */           this.buffer[y][x] = merge(
/* 135 */               sc, 
/* 136 */               this.TexSource.rgb.get(fx + x, fy + y), 
/* 137 */               bc);
/*     */ 
/*     */           
/* 140 */           this.buffern[y][x] = mergeNormal(sc, this.TexSource.rgb.get(fx + x + this.sourceHalf, fy + y), background.normalGet(bx + x, by + y));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int merge(int m, int c1, int c2) {
/* 148 */     m &= 0xFF00;
/* 149 */     m >>= 8;
/* 150 */     double value = m / 255.0D;
/*     */     
/* 152 */     int c1a = c1 >> 8 & 0xFF;
/* 153 */     int c1b = c1 >> 16 & 0xFF;
/* 154 */     int c1c = c1 >> 24 & 0xFF;
/*     */     
/* 156 */     int c2a = c2 >> 8 & 0xFF;
/* 157 */     int c2b = c2 >> 16 & 0xFF;
/* 158 */     int c2c = c2 >> 24 & 0xFF;
/*     */ 
/*     */     
/* 161 */     int res = 255;
/*     */     
/* 163 */     int t = (int)(c1c * value + c2c * (1.0D - value));
/* 164 */     res |= t << 24;
/*     */     
/* 166 */     t = (int)(c1b * value + c2b * (1.0D - value));
/* 167 */     res |= t << 16;
/*     */     
/* 169 */     t = (int)(c1a * value + c2a * (1.0D - value));
/* 170 */     res |= t << 8;
/*     */     
/* 172 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   private int mergeV(double value, int c1, int c2) {
/* 177 */     int c1a = c1 >> 8 & 0xFF;
/* 178 */     int c1b = c1 >> 16 & 0xFF;
/* 179 */     int c1c = c1 >> 24 & 0xFF;
/*     */     
/* 181 */     int c2a = c2 >> 8 & 0xFF;
/* 182 */     int c2b = c2 >> 16 & 0xFF;
/* 183 */     int c2c = c2 >> 24 & 0xFF;
/*     */ 
/*     */     
/* 186 */     int res = 255;
/*     */     
/* 188 */     int t = (int)(c1c * value + c2c * (1.0D - value));
/* 189 */     res |= t << 24;
/*     */     
/* 191 */     t = (int)(c1b * value + c2b * (1.0D - value));
/* 192 */     res |= t << 16;
/*     */     
/* 194 */     t = (int)(c1a * value + c2a * (1.0D - value));
/* 195 */     res |= t << 8;
/*     */     
/* 197 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   private int mergeNormal(int m, int c1, int c2) {
/* 202 */     m &= 0xFF00;
/* 203 */     m >>= 8;
/* 204 */     double value = m / 255.0D;
/*     */     
/* 206 */     int c1a = c1 >> 8 & 0xFF;
/* 207 */     int c1b = c1 >> 16 & 0xFF;
/* 208 */     int c1c = c1 >> 24 & 0xFF;
/*     */     
/* 210 */     int c2a = c2 >> 8 & 0xFF;
/* 211 */     int c2b = c2 >> 16 & 0xFF;
/* 212 */     int c2c = c2 >> 24 & 0xFF;
/*     */     
/* 214 */     double r = c1c * value + c2c * (1.0D - value);
/* 215 */     double g = c1b * value + c2b * (1.0D - value);
/* 216 */     double b = c1a * value + c2a * (1.0D - value);
/*     */     
/* 218 */     double l = 1.0D / Math.sqrt(r * r + g * g + b * b);
/* 219 */     r *= l;
/* 220 */     g *= l;
/* 221 */     b *= l;
/*     */ 
/*     */     
/* 224 */     int res = 255;
/*     */     
/* 226 */     int t = (int)(c1c * value + c2c * (1.0D - value));
/* 227 */     res |= t << 24;
/*     */     
/* 229 */     t = (int)(c1b * value + c2b * (1.0D - value));
/* 230 */     res |= t << 16;
/*     */     
/* 232 */     t = (int)(c1a * value + c2a * (1.0D - value));
/* 233 */     res |= t << 8;
/*     */     
/* 235 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   void paste(ComposerDests.Dest dest) {
/* 240 */     for (int y = 0; y < dest.height(); y++) {
/* 241 */       for (int x = 0; x < dest.width(); x++) {
/* 242 */         int dx = x;
/* 243 */         int dy = y;
/*     */         
/* 245 */         int c = this.buffer[y][x];
/* 246 */         if ((c & 0xFF) != 0) {
/*     */           
/* 248 */           dest.diffuseSet(dest.x1() + dx, dest.y1() + dy, c);
/*     */           
/* 250 */           int nc = this.buffern[y][x];
/* 251 */           if ((nc & 0xFF) != 0)
/*     */           {
/* 253 */             dest.normalSet(dest.x1() + dx, dest.y1() + dy, nc);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void paste(ComposerDests.Dest dest, double bgBlend) {
/* 262 */     for (int y = 0; y < dest.height(); y++) {
/* 263 */       for (int x = 0; x < dest.width(); x++) {
/* 264 */         int dx = x;
/* 265 */         int dy = y;
/*     */         
/* 267 */         int c = this.buffer[y][x];
/* 268 */         if ((c & 0xFF) != 0) {
/*     */ 
/*     */           
/* 271 */           c = mergeV(bgBlend, dest.diffuseGet(dest.x1() + dx, dest.y1() + dy), c);
/*     */           
/* 273 */           dest.diffuseSet(dest.x1() + dx, dest.y1() + dy, c);
/*     */           
/* 275 */           int nc = this.buffern[y][x];
/* 276 */           if ((nc & 0xFF) != 0)
/*     */           {
/* 278 */             dest.normalSet(dest.x1() + dx, dest.y1() + dy, nc);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void pasteNormalOnly(ComposerDests.Dest dest, int rotation) {
/* 287 */     for (int y = 0; y < dest.size(); y++) {
/* 288 */       for (int x = 0; x < dest.size(); x++) {
/* 289 */         int dx = x;
/* 290 */         int dy = y;
/* 291 */         int r = rotation;
/*     */         
/* 293 */         int nc = this.buffern[y][x];
/* 294 */         if ((nc & 0xFF) != 0) {
/*     */ 
/*     */           
/* 297 */           while (r > 0) {
/* 298 */             int odx = dx;
/* 299 */             dx = dest.size() - dy - 1;
/* 300 */             dy = odx;
/* 301 */             r--;
/*     */             
/* 303 */             int re = 256 - (nc >> 16) & 0xFF;
/* 304 */             int gr = nc >> 24 & 0xFF;
/*     */             
/* 306 */             nc &= 0xFFFF;
/* 307 */             nc |= gr << 16;
/* 308 */             nc |= re << 25;
/*     */           } 
/*     */           
/* 311 */           dest.normalSet(dest.x1() + dx, dest.y1() + dy, nc);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void pasteRotated(ComposerDests.Dest dest, int rotation) {
/* 320 */     assert rotation >= 0 && rotation < 4;
/*     */     
/* 322 */     for (int y = 0; y < dest.size(); y++) {
/* 323 */       for (int x = 0; x < dest.size(); x++) {
/* 324 */         int dx = x;
/* 325 */         int dy = y;
/* 326 */         int r = rotation;
/*     */         
/* 328 */         int c = this.buffer[y][x];
/* 329 */         if ((c & 0xFF) != 0) {
/*     */ 
/*     */           
/* 332 */           int nc = this.buffern[y][x];
/*     */           
/* 334 */           while (r > 0) {
/* 335 */             int odx = dx;
/* 336 */             dx = dest.size() - dy - 1;
/* 337 */             dy = odx;
/* 338 */             r--;
/*     */             
/* 340 */             int re = 256 - (nc >> 16) & 0xFF;
/* 341 */             int gr = nc >> 24 & 0xFF;
/*     */             
/* 343 */             nc &= 0xFFFF;
/* 344 */             nc |= gr << 16;
/* 345 */             nc |= re << 24;
/*     */           } 
/*     */ 
/*     */           
/* 349 */           dest.diffuseSet(dest.x1() + dx, dest.y1() + dy, c);
/* 350 */           if ((nc & 0xFF000000) != 0) {
/* 351 */             dest.normalSet(dest.x1() + dx, dest.y1() + dy, nc);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public SnakeImage getSource() {
/* 359 */     return this.TexSource;
/*     */   }
/*     */   
/*     */   int sampleSource(int x1, int y1) {
/* 363 */     return this.TexSource.rgb.get(x1, y1);
/*     */   }
/*     */   
/*     */   void dispose() {
/* 367 */     if (this.TexSource != null) {
/* 368 */       this.TexSource.dispose();
/* 369 */       this.TexSource = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerUtil.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */