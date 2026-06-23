/*     */ package snake2d;
/*     */ 
/*     */ import org.lwjgl.opengl.GL11;
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
/*     */ class _FBODebug
/*     */   extends CORE_RESOURCE
/*     */ {
/*     */   private int width;
/*     */   private int height;
/*     */   private _FBOBlitter blitter;
/*     */   private final int ID;
/*     */   private int textureID;
/*     */   private final int stencilID;
/*     */   
/*     */   _FBODebug(SETTINGS sett) {
/*  40 */     this.blitter = new _FBOBlitter(sett);
/*  41 */     this.width = sett.getNativeWidth();
/*  42 */     this.height = sett.getNativeHeight();
/*     */     
/*  44 */     this.ID = GL30.glGenFramebuffers();
/*  45 */     this.stencilID = GL30.glGenRenderbuffers();
/*  46 */     generateTextures();
/*     */   }
/*     */ 
/*     */   
/*     */   private void generateTextures() {
/*  51 */     GlHelper.checkErrors();
/*  52 */     GL30.glBindFramebuffer(36160, this.ID);
/*     */     
/*  54 */     this.textureID = GlHelper.getFBTexture(this.width, this.height);
/*  55 */     GL30.glFramebufferTexture2D(36009, 36064, 3553, this.textureID, 0);
/*     */     
/*  57 */     GL30.glBindRenderbuffer(36161, this.stencilID);
/*  58 */     GL30.glRenderbufferStorage(36161, 35056, this.width, this.height);
/*     */     
/*  60 */     GL30.glFramebufferRenderbuffer(36160, 33306, 36161, this.stencilID);
/*     */     
/*  62 */     GL20.glDrawBuffers(36064);
/*     */     
/*  64 */     if (36053 != GL30.glCheckFramebufferStatus(36160)) {
/*  65 */       throw new RuntimeException("Could not create fbo");
/*     */     }
/*  67 */     GL30.glBindFramebuffer(36160, 0);
/*     */     
/*  69 */     GlHelper.checkErrors();
/*     */   }
/*     */   
/*     */   private void deleteTextures() {
/*  73 */     GL11.glDeleteTextures(this.textureID);
/*  74 */     GL30.glDeleteRenderbuffers(this.stencilID);
/*     */   }
/*     */ 
/*     */   
/*     */   public void dis() {
/*  79 */     GlHelper.checkErrors();
/*  80 */     GL30.glBindFramebuffer(36160, 0);
/*  81 */     deleteTextures();
/*  82 */     GL30.glDeleteFramebuffers(this.ID);
/*  83 */     this.blitter.dis();
/*  84 */     GlHelper.checkErrors();
/*     */   }
/*     */   
/*     */   public void applySettings(SETTINGS sett) {
/*  88 */     if (this.width != sett.getNativeWidth() || this.height != sett.getNativeHeight()) {
/*  89 */       this.width = sett.getNativeWidth();
/*  90 */       this.height = sett.getNativeHeight();
/*  91 */       deleteTextures();
/*  92 */       generateTextures();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void bindAndClear() {
/*  97 */     GL30.glBindFramebuffer(36009, this.ID);
/*  98 */     GL20.glDrawBuffers(36064);
/*  99 */     GlHelper.ViewPort.set(this.width, this.height);
/* 100 */     GL11.glClear(17664);
/*     */   }
/*     */ 
/*     */   
/*     */   public void blitTexture() {
/* 105 */     this.blitter.blit(this.ID);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\_FBODebug.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */