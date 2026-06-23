/*     */ package snake2d;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ import org.lwjgl.opengl.GL30;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
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
/*     */ public class TextureHolder
/*     */   extends CORE_RESOURCE
/*     */ {
/*     */   public final int pixelWidth;
/*     */   public final int pixelHeight;
/*     */   private final Texture texture;
/*     */   private final Texture normalTexture;
/*     */   private final VboParticles pixels;
/*     */   private final int FBO;
/*     */   private TextureHolderChunk chunk;
/*     */   
/*     */   public TextureHolder(SnakeImage diffuse, SnakeImage normal, int x1, int y1, int w, int h) {
/*  45 */     if (!CORE.isGLThread())
/*  46 */       throw new RuntimeException(); 
/*  47 */     GlHelper.checkErrors();
/*  48 */     this.texture = new Texture(diffuse, true);
/*     */     
/*  50 */     if (normal != null) {
/*  51 */       this.normalTexture = Texture.normal(normal, true);
/*     */     } else {
/*  53 */       this.normalTexture = null;
/*     */     } 
/*  55 */     this.pixelWidth = this.texture.width;
/*  56 */     this.pixelHeight = this.texture.height;
/*     */     
/*  58 */     this.texture.bind();
/*  59 */     if (this.normalTexture != null) {
/*  60 */       this.normalTexture.bind();
/*     */     }
/*  62 */     CORE.addDisposable(this);
/*  63 */     ColorImp.setSPRITE(x1, y1, w, h);
/*     */     
/*  65 */     this.pixels = VboParticles.getForTexture(this.pixelWidth, this.pixelHeight);
/*     */     
/*  67 */     this.FBO = GL30.glGenFramebuffers();
/*     */     
/*  69 */     GL30.glBindFramebuffer(36160, this.FBO);
/*  70 */     GL30.glFramebufferTexture2D(36009, 36064, 34037, this.texture.id, 0);
/*     */     
/*  72 */     GL20.glDrawBuffers(36064);
/*     */     
/*  74 */     if (36053 != GL30.glCheckFramebufferStatus(36160)) {
/*  75 */       throw new RuntimeException("Could not create fbo");
/*     */     }
/*  77 */     GL30.glBindFramebuffer(36160, 0);
/*     */     
/*  79 */     GlHelper.checkErrors();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void flush() {
/*  85 */     if (this.pixels.count() > 0) {
/*  86 */       GlHelper.ViewPort.set(this.pixelWidth, this.pixelHeight);
/*  87 */       GL30.glBindFramebuffer(36009, this.FBO);
/*  88 */       GL20.glDrawBuffers(36064);
/*  89 */       GlHelper.Stencil.enable(true);
/*  90 */       this.pixels.flush(1);
/*  91 */       GlHelper.ViewPort.setDefault();
/*     */     } 
/*     */     
/*  94 */     if (this.chunk != null) {
/*  95 */       GlHelper.checkErrors();
/*  96 */       ByteBuffer drawBuff = this.chunk.buff;
/*  97 */       drawBuff.flip();
/*  98 */       this.texture.uploadPixels(this.chunk.x1, this.chunk.w, this.chunk.y1, this.chunk.am / this.chunk.w, drawBuff);
/*  99 */       this.chunk = null;
/* 100 */       GlHelper.checkErrors();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void dis() {
/* 107 */     GlHelper.checkErrors();
/* 108 */     this.texture.dis();
/* 109 */     GlHelper.checkErrors();
/* 110 */     if (this.normalTexture != null)
/* 111 */       this.normalTexture.dis(); 
/* 112 */     GlHelper.checkErrors();
/* 113 */     this.pixels.dis();
/* 114 */     GL30.glDeleteFramebuffers(this.FBO);
/* 115 */     GlHelper.checkErrors();
/*     */   }
/*     */   
/*     */   public void putPixel(int x, int y, byte r, byte g, byte b) {
/* 119 */     this.pixels.render((short)x, (short)(this.pixelHeight - y), r, g, b);
/*     */   }
/*     */   
/*     */   public void putPixelBatch(final int x1, final int y1, final int width, final byte[] pixels) {
/* 123 */     final ByteBuffer drawBuff = BufferUtils.createByteBuffer(pixels.length); byte b; int i;
/*     */     byte[] arrayOfByte;
/* 125 */     for (i = (arrayOfByte = pixels).length, b = 0; b < i; ) { byte b1 = arrayOfByte[b];
/* 126 */       drawBuff.put(b1); b++; }
/*     */     
/* 128 */     drawBuff.flip();
/* 129 */     (new CORE.GlJob()
/*     */       {
/*     */         public void doJob() {
/* 132 */           TextureHolder.this.texture.uploadPixels(x1, width, y1, pixels.length / width * 4, drawBuff);
/*     */         }
/* 134 */       }).perform();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addChunk(int x1, int y1, int width, int am, TextureHolderChunk chunk) {
/* 139 */     chunk.x1 = x1;
/* 140 */     chunk.y1 = y1;
/* 141 */     chunk.w = width;
/* 142 */     chunk.am = am;
/* 143 */     this.chunk = chunk;
/*     */   }
/*     */   
/*     */   public static class TextureHolderChunk
/*     */   {
/*     */     public final int width;
/*     */     public final int height;
/*     */     private final ByteBuffer buff;
/*     */     
/*     */     public TextureHolderChunk(int width, int height) {
/* 153 */       this.width = width;
/* 154 */       this.height = height;
/* 155 */       this.buff = BufferUtils.createByteBuffer(width * height * 4);
/*     */     }
/*     */     private int x1; private int y1; private int w; private int am;
/*     */     public void put(int i, byte r, byte g, byte b, byte a) {
/* 159 */       this.buff.position(i * 4);
/* 160 */       this.buff.put(r).put(g).put(b).put(a);
/*     */     }
/*     */     
/*     */     public void put(int i, COLOR c) {
/* 164 */       this.buff.position(i * 4);
/* 165 */       this.buff.put((byte)(c.red() * 2)).put((byte)(c.green() * 2)).put((byte)(c.blue() * 2)).put((byte)-1);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\TextureHolder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */