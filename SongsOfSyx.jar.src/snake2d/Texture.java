/*     */ package snake2d;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL13;
/*     */ import snake2d.util.file.SnakeImage;
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
/*     */ class Texture
/*     */ {
/*     */   final int id;
/*     */   final int width;
/*     */   final int height;
/*     */   private boolean disposed = false;
/*  37 */   private static int MAX_SIZE = 16384;
/*     */   private final int ACTIVE_TEXTURE;
/*     */   
/*     */   public static Texture normal(SnakeImage i, boolean pixelated) {
/*  41 */     return new Texture(i, pixelated, 33985);
/*     */   }
/*     */   
/*     */   Texture(SnakeImage i, boolean pixelated) {
/*  45 */     this(i, pixelated, 33984);
/*     */   }
/*     */ 
/*     */   
/*     */   Texture(SnakeImage i, boolean pixelated, int ACTIVE_TEXTURE) {
/*  50 */     GlHelper.checkErrors();
/*  51 */     this.ACTIVE_TEXTURE = ACTIVE_TEXTURE;
/*  52 */     this.width = i.width;
/*  53 */     this.height = i.height;
/*     */     
/*  55 */     if (this.width > MAX_SIZE || this.height > MAX_SIZE) {
/*  56 */       throw new RuntimeException();
/*     */     }
/*  58 */     this.id = GL11.glGenTextures();
/*     */     
/*  60 */     GL13.glActiveTexture(ACTIVE_TEXTURE);
/*  61 */     GL11.glBindTexture(34037, this.id);
/*     */ 
/*     */     
/*  64 */     GL11.glTexParameteri(34037, 10241, 9728);
/*  65 */     GL11.glTexParameteri(34037, 10240, pixelated ? 9728 : 9729);
/*  66 */     GL11.glTexImage2D(34037, 0, 32856, this.width, this.height, 0, 6408, 5121, i.data());
/*     */     
/*  68 */     int e = GL11.glGetError();
/*  69 */     if (e != 0) {
/*  70 */       GlHelper.diagnozeMem();
/*  71 */       throw new RuntimeException("Texture Error " + this.width + " " + this.height + " " + e);
/*     */     } 
/*     */     
/*  74 */     i.dispose();
/*  75 */     GlHelper.checkErrors();
/*     */   }
/*     */ 
/*     */   
/*     */   void bind() {
/*  80 */     if (this.disposed) {
/*  81 */       throw new IllegalStateException("trying to bind a texture that was disposed");
/*     */     }
/*  83 */     GL13.glActiveTexture(this.ACTIVE_TEXTURE);
/*  84 */     GL11.glBindTexture(34037, this.id);
/*     */   }
/*     */   
/*     */   void dis() {
/*  88 */     GlHelper.checkErrors();
/*  89 */     GL13.glActiveTexture(this.ACTIVE_TEXTURE);
/*  90 */     GL11.glDeleteTextures(this.id);
/*  91 */     GlHelper.checkErrors();
/*  92 */     this.disposed = true;
/*     */   }
/*     */   
/*     */   public void uploadPixels(int px, int width, int py, int height, ByteBuffer pixels) {
/*  96 */     GL13.glActiveTexture(this.ACTIVE_TEXTURE);
/*  97 */     GL11.glTexSubImage2D(34037, 0, px, py, width, height, 6408, 5121, pixels);
/*     */   }
/*     */   
/*     */   public void uploadPixel(int px, int py, ByteBuffer pixel) {
/* 101 */     GL13.glActiveTexture(this.ACTIVE_TEXTURE);
/* 102 */     GL11.glTexSubImage2D(34037, 0, px, py, 1, 1, 6408, 5121, pixel);
/*     */   }
/*     */   
/* 105 */   public int getWidth() { return this.width; } public int getHeight() {
/* 106 */     return this.height;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\Texture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */