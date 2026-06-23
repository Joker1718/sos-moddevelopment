/*     */ package snake2d;
/*     */ 
/*     */ import org.lwjgl.opengl.GL11;
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
/*     */ final class _FBOBlitter
/*     */ {
/*     */   private final boolean mul;
/*     */   private int ID;
/*     */   private int textureID;
/*     */   private int blitFilter;
/*     */   private boolean scaling;
/*     */   private int width;
/*     */   private int height;
/*     */   private boolean debug;
/*     */   private int blitI;
/*     */   
/*     */   public _FBOBlitter(SETTINGS sett) {
/*  65 */     this.blitI = 0; this.mul = ((sett.getNativeWidth() != (sett.display()).width || sett.getNativeHeight() != (sett.display()).height) && GL11.glGetInteger(32937) > 1); this.width = sett.getNativeWidth(); this.height = sett.getNativeHeight(); if (this.mul) {
/*     */       Printer.ln("This machine has forced multiple sampling enabled. Some performance penalties will ensue. Disable overriding sampling (MSAA, antialiasing) for better performance."); this.ID = GL30.glGenFramebuffers(); GL30.glBindFramebuffer(36160, this.ID); this.textureID = GlHelper.getFBTexture((sett.display()).width, (sett.display()).height); GL30.glFramebufferTexture2D(36009, 36064, 3553, this.textureID, 0); if (36053 != GL30.glCheckFramebufferStatus(36160))
/*     */         throw new RuntimeException("Could not create fbo"); 
/*     */       GL30.glBindFramebuffer(36160, 0);
/*     */     } 
/*     */     this.blitFilter = sett.getLinearFiltering() ? 9729 : 9728;
/*     */     this.scaling = sett.getFitToScreen();
/*     */     GlHelper.checkErrors();
/*  73 */     this.debug = sett.debugMode(); } public void blit(int fbID) { int blitX, blitY, blitW, blitH, dw = (CORE.getGraphics()).blitArea.x();
/*  74 */     int dy = (CORE.getGraphics()).blitArea.y();
/*     */     
/*  76 */     GlHelper.ViewPort.set(dw, dy);
/*     */     
/*  78 */     if (this.scaling) {
/*  79 */       blitX = 0;
/*  80 */       blitY = 0;
/*  81 */       blitW = dw;
/*  82 */       blitH = dy;
/*     */     } else {
/*  84 */       double d = dw / this.width;
/*  85 */       if (this.height * d > dy)
/*  86 */         d = 1.0D; 
/*  87 */       blitW = (int)(this.width * d);
/*  88 */       blitH = (int)(this.height * d);
/*  89 */       if (blitW > dw)
/*  90 */         blitW = dw; 
/*  91 */       if (blitH > dy)
/*  92 */         blitH = dy; 
/*  93 */       blitX = (dw - blitW) / 2;
/*  94 */       blitY = (dy - blitH) / 2;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  99 */     if (this.debug && this.blitI-- < 0) {
/* 100 */       this.blitI = 1000;
/*     */     }
/*     */ 
/*     */     
/* 104 */     GL30.glBindFramebuffer(36008, fbID);
/* 105 */     if (this.mul) {
/*     */       
/* 107 */       GL30.glBindFramebuffer(36009, this.ID);
/* 108 */       GL30.glBlitFramebuffer(0, 0, this.width, this.height, blitX, blitY, blitX + blitW, blitY + blitH, 16384, this.blitFilter);
/*     */       
/* 110 */       GL30.glBindFramebuffer(36008, this.ID);
/* 111 */       GL30.glBindFramebuffer(36009, 0);
/*     */       
/* 113 */       GL30.glBlitFramebuffer(0, 0, dw, dy, 0, 0, dw, dy, 16384, 9728);
/*     */     }
/*     */     else {
/*     */       
/* 117 */       GL30.glBindFramebuffer(36009, 0);
/* 118 */       GL30.glBlitFramebuffer(0, 0, this.width, this.height, blitX, blitY, blitX + blitW, blitY + blitH, 16384, this.blitFilter);
/*     */     } 
/* 120 */     GlHelper.ViewPort.setDefault(); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void dis() {
/* 126 */     GL30.glBindFramebuffer(36160, 0);
/* 127 */     GL30.glBindFramebuffer(36008, 0);
/* 128 */     GL11.glDeleteTextures(this.textureID);
/* 129 */     GlHelper.checkErrors();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\_FBOBlitter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */