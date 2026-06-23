/*     */ package snake2d;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL13;
/*     */ import org.lwjgl.opengl.GL20;
/*     */ import org.lwjgl.opengl.GL30;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ class _FBODeffered
/*     */   extends CORE_RESOURCE
/*     */ {
/*     */   private int width;
/*     */   private int height;
/*     */   private _FBOBlitter blitter;
/*     */   private final int fbID;
/*     */   private int iddiffuse;
/*     */   private int idNormal;
/*     */   private int idLight;
/*     */   private final int stencilID;
/*     */   private final IntBuffer diffuseNormalBuffer;
/*     */   
/*     */   _FBODeffered(SETTINGS sett) {
/*  56 */     this.width = sett.getNativeWidth();
/*  57 */     this.height = sett.getNativeHeight();
/*  58 */     this.blitter = new _FBOBlitter(sett);
/*  59 */     this.diffuseNormalBuffer = BufferUtils.createIntBuffer(2);
/*  60 */     for (int i = 0; i < 2; i++)
/*  61 */       this.diffuseNormalBuffer.put(36065 + i); 
/*  62 */     this.diffuseNormalBuffer.flip();
/*     */     
/*  64 */     this.fbID = GL30.glGenFramebuffers();
/*  65 */     this.stencilID = GL30.glGenRenderbuffers();
/*  66 */     generateTextures();
/*     */   }
/*     */ 
/*     */   
/*     */   void applySettings(SETTINGS sett) {
/*  71 */     if (this.width != sett.getNativeWidth() || this.height != sett.getNativeHeight()) {
/*  72 */       this.width = sett.getNativeWidth();
/*  73 */       this.height = sett.getNativeHeight();
/*  74 */       deleteTextures();
/*  75 */       generateTextures();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generateTextures() {
/*  83 */     GlHelper.checkErrors();
/*  84 */     GL30.glBindFramebuffer(36160, this.fbID);
/*     */     
/*  86 */     this.iddiffuse = GlHelper.getFBTexture(this.width, this.height);
/*  87 */     this.idNormal = GlHelper.getFBTexture(this.width, this.height);
/*  88 */     this.idLight = GlHelper.getFBTexture(this.width, this.height);
/*     */     
/*  90 */     GL30.glFramebufferTexture2D(36009, 36065, 3553, this.iddiffuse, 0);
/*  91 */     GL30.glFramebufferTexture2D(36009, 36066, 3553, this.idNormal, 0);
/*  92 */     GL30.glFramebufferTexture2D(36009, 36064, 3553, this.idLight, 0);
/*     */     
/*  94 */     GL30.glBindRenderbuffer(36161, this.stencilID);
/*  95 */     GL30.glRenderbufferStorage(36161, 35056, this.width, this.height);
/*  96 */     GL30.glFramebufferRenderbuffer(36160, 33306, 36161, this.stencilID);
/*     */     
/*  98 */     GL20.glDrawBuffers(this.diffuseNormalBuffer);
/*  99 */     GlHelper.checkErrors();
/*     */     
/* 101 */     if (36053 != GL30.glCheckFramebufferStatus(36160)) {
/* 102 */       throw new RuntimeException("Could not create fbo " + GL30.glCheckFramebufferStatus(36160));
/*     */     }
/* 104 */     GL30.glBindFramebuffer(36160, 0);
/*     */     
/* 106 */     GL13.glActiveTexture(33986);
/* 107 */     GL11.glBindTexture(3553, this.iddiffuse);
/*     */     
/* 109 */     GL13.glActiveTexture(33987);
/* 110 */     GL11.glBindTexture(3553, this.idNormal);
/*     */     
/* 112 */     GlHelper.checkErrors();
/*     */   }
/*     */   
/*     */   private void deleteTextures() {
/* 116 */     GL11.glDeleteTextures(this.iddiffuse);
/* 117 */     GL11.glDeleteTextures(this.idNormal);
/* 118 */     GL11.glDeleteTextures(this.idLight);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dis() {
/* 123 */     GlHelper.checkErrors();
/* 124 */     GL30.glBindFramebuffer(36160, 0);
/* 125 */     deleteTextures();
/* 126 */     GL30.glDeleteRenderbuffers(this.stencilID);
/* 127 */     GL30.glDeleteFramebuffers(this.fbID);
/* 128 */     this.blitter.dis();
/* 129 */     GlHelper.checkErrors();
/*     */   }
/*     */   
/*     */   public void bindDiffAndNorForTarget() {
/* 133 */     GL30.glBindFramebuffer(36009, this.fbID);
/* 134 */     GL20.glDrawBuffers(this.diffuseNormalBuffer);
/* 135 */     GlHelper.ViewPort.set(this.width, this.height);
/* 136 */     GL11.glClear(17664);
/*     */   }
/*     */   
/*     */   public void bindLightTextureForTarget() {
/* 140 */     GL20.glDrawBuffers(36064);
/* 141 */     GlHelper.ViewPort.set(this.width, this.height);
/* 142 */     GL11.glClear(16384);
/*     */   }
/*     */   
/*     */   public void blitTexture() {
/* 146 */     this.blitter.blit(this.fbID);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\_FBODeffered.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */