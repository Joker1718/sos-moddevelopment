/*     */ package snake2d.util.file;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.stb.STBImage;
/*     */ import org.lwjgl.stb.STBImageResize;
/*     */ import org.lwjgl.stb.STBImageWrite;
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SnakeImage
/*     */ {
/*     */   private ByteBuffer image;
/*     */   public final int height;
/*     */   public final int width;
/*  25 */   public final ImageGraphics rgb = new ImageGraphics(null);
/*     */   
/*     */   public final String path;
/*     */   
/*     */   public SnakeImage(String path) {
/*  30 */     this.path = path;
/*  31 */     if (!(new File(path)).exists()) {
/*  32 */       throw new Errors.DataError("File doesn't exist", path);
/*     */     }
/*  34 */     Exception exception1 = null, exception2 = null;
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
/*     */   public SnakeImage(Path path) {
/*  59 */     this.path = path.toString();
/*  60 */     if (!Files.exists(path, new java.nio.file.LinkOption[0])) {
/*  61 */       throw new Errors.DataError("File doesn't exist", this.path);
/*     */     }
/*  63 */     Exception exception1 = null, exception2 = null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int height(Path path) {
/*  96 */     return dim(path).y();
/*     */   }
/*     */ 
/*     */   
/*     */   public static COORDINATE dim(Path path) {
/* 101 */     if (!Files.exists(path, new java.nio.file.LinkOption[0])) {
/* 102 */       throw new Errors.DataError("File doesn't exist", path);
/*     */     }
/* 104 */     Exception exception1 = null, exception2 = null;
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
/*     */     try {
/*     */     
/*     */     } finally {
/* 136 */       exception2 = null; if (exception1 == null) { exception1 = exception2; } else if (exception1 != exception2) { exception1.addSuppressed(exception2); }
/*     */     
/*     */     } 
/*     */   } public SnakeImage(String path, int width, int height) throws IOException {
/* 140 */     this.path = path;
/* 141 */     if (!(new File(path)).exists()) {
/* 142 */       throw new Errors.DataError("File doesn't exist", path);
/*     */     }
/* 144 */     Exception exception1 = null, exception2 = null;
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
/*     */   public SnakeImage(Path path, int width, int height) throws IOException {
/* 168 */     this(path);
/* 169 */     if (this.width != width || this.height != height) {
/* 170 */       dispose();
/* 171 */       throw new IOException("Image has wrong dimentions. Resize to: " + width + "x" + height + " " + path);
/*     */     } 
/*     */   }
/*     */   
/*     */   public SnakeImage(int width, int height) {
/* 176 */     this.path = null;
/*     */     try {
/* 178 */       this.image = BufferUtils.createByteBuffer(width * height * 4);
/* 179 */     } catch (OutOfMemoryError e) {
/* 180 */       e.printStackTrace();
/* 181 */       int s = width * height * 4;
/* 182 */       throw new RuntimeException(String.valueOf(s) + " " + Runtime.getRuntime().totalMemory() + " " + Runtime.getRuntime().freeMemory());
/*     */     } 
/*     */ 
/*     */     
/* 186 */     this.width = width;
/* 187 */     this.height = height;
/*     */   }
/*     */   
/*     */   public ByteBuffer data() {
/* 191 */     this.image.rewind();
/* 192 */     return this.image;
/*     */   }
/*     */   
/*     */   public void dispose() {
/* 196 */     if (this.path == null) {
/*     */       return;
/*     */     }
/* 199 */     if (this.image != null) {
/* 200 */       this.image.rewind();
/* 201 */       STBImage.stbi_image_free(this.image);
/* 202 */       this.image = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void save(String path) {
/* 207 */     this.image.rewind();
/* 208 */     STBImageWrite.stbi_write_png(path, this.width, this.height, 4, this.image, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public SnakeImage resized(int nwidth, int nheight) {
/* 213 */     SnakeImage nn = new SnakeImage(nwidth, nheight);
/* 214 */     this.image.rewind();
/* 215 */     nn.image.rewind();
/* 216 */     STBImageResize.stbir_resize_uint8_linear(this.image, this.width, this.height, 0, nn.image, nwidth, nheight, 0, 4);
/* 217 */     return nn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveJpg(String path) {
/* 228 */     this.image.rewind();
/* 229 */     STBImageWrite.stbi_write_jpg(path, this.width, this.height, 4, this.image, 90);
/*     */   }
/*     */ 
/*     */   
/*     */   public final class ImageGraphics
/*     */   {
/*     */     private ImageGraphics() {}
/*     */ 
/*     */     
/*     */     private void boundCheck(int x, int y) {
/* 239 */       if (x < 0 || y < 0 || x >= SnakeImage.this.width || y >= SnakeImage.this.height)
/* 240 */         throw new RuntimeException(String.valueOf(x) + " " + y + "is out of bounds" + " " + SnakeImage.this.width + " " + SnakeImage.this.height + " " + SnakeImage.this.path); 
/*     */     }
/*     */     
/*     */     public void set(int x, int y, int r, int g, int b, int a) {
/* 244 */       boundCheck(x, y);
/* 245 */       int i = 4 * (x + y * SnakeImage.this.width);
/* 246 */       SnakeImage.this.image.position(i);
/* 247 */       SnakeImage.this.image.put((byte)r).put((byte)g).put((byte)b).put((byte)a);
/*     */     }
/*     */     
/*     */     public void set(int x, int y, int c) {
/* 251 */       int r = c >> 24 & 0xFF;
/* 252 */       int g = c >> 16 & 0xFF;
/* 253 */       int b = c >> 8 & 0xFF;
/* 254 */       int a = c & 0xFF;
/* 255 */       set(x, y, r, g, b, a);
/*     */     }
/*     */     
/*     */     public int get(int x, int y) {
/* 259 */       boundCheck(x, y);
/* 260 */       int i = 4 * (x + y * SnakeImage.this.width);
/* 261 */       SnakeImage.this.image.position(i);
/* 262 */       int res = (SnakeImage.this.image.get() & 0xFF) << 24;
/* 263 */       res |= (SnakeImage.this.image.get() & 0xFF) << 16;
/* 264 */       res |= (SnakeImage.this.image.get() & 0xFF) << 8;
/* 265 */       res |= SnakeImage.this.image.get() & 0xFF;
/* 266 */       return res;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\file\SnakeImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */