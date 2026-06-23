/*    */ package snake2d;
/*    */ 
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.light.LIGHT_AMBIENT;
/*    */ import snake2d.util.light.LIGHT_POINT;
/*    */ import snake2d.util.sprite.TextureCoords;
/*    */ 
/*    */ 
/*    */ class RendererDebug
/*    */   extends Renderer
/*    */ {
/*    */   private final VboSpriteOpti vbo;
/*    */   private final VboParticles vboParticles;
/*    */   private final _FBODebug fbo;
/*    */   private final boolean debug;
/*    */   
/*    */   public RendererDebug(SETTINGS sett, int pointSize) {
/* 19 */     super(pointSize);
/* 20 */     this.vbo = VboSpriteOpti.getDebug(sett);
/* 21 */     this.fbo = new _FBODebug(sett);
/* 22 */     this.vboParticles = VboParticles.getDebug(sett);
/* 23 */     GlHelper.enableDepthTest(false);
/* 24 */     GlHelper.checkErrors();
/* 25 */     this.debug = sett.debugMode();
/*    */   }
/*    */ 
/*    */   
/*    */   public void dis() {
/* 30 */     GlHelper.checkErrors();
/* 31 */     this.vbo.dis();
/* 32 */     GlHelper.checkErrors();
/* 33 */     this.vboParticles.dis();
/* 34 */     GlHelper.checkErrors();
/* 35 */     ElementArrays.dispose();
/* 36 */     GlHelper.checkErrors();
/*    */   }
/*    */ 
/*    */   
/*    */   public int pnewLayer(boolean keepLights, int pointSize) {
/* 41 */     this.vboParticles.setNew(pointSize);
/* 42 */     return this.vbo.setNew();
/*    */   }
/*    */ 
/*    */   
/*    */   public int pnewFinalLightLayer(int pointSize) {
/* 47 */     this.vboParticles.setNew(pointSize);
/* 48 */     return this.vbo.setNew();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderParticle(short x, short y, byte nx, byte ny, byte nz, byte nA, COLOR color, OPACITY opacity) {
/* 54 */     this.vboParticles.render(x, y, nx, ny, nz, nA, color, opacity);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void pclear(int pSize) {
/* 60 */     this.vbo.clear();
/* 61 */     this.vboParticles.clear(pSize);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderSprite(TextureCoords t, TextureCoords to, int x1, int x2, int y1, int y2, COLOR color, OPACITY opacity) {
/* 68 */     this.vbo.render(t, to, x1, x2, y1, y2, color, opacity);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderShadow(TextureCoords t, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, byte d, byte depth) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void pflush(int pSize) {
/* 81 */     debug();
/* 82 */     this.fbo.bindAndClear();
/* 83 */     debug();
/* 84 */     GlHelper.enableDepthTest(false);
/* 85 */     debug();
/* 86 */     this.vboParticles.flush(pSize);
/* 87 */     debug();
/* 88 */     this.vbo.flush();
/* 89 */     debug();
/*    */ 
/*    */     
/* 92 */     this.fbo.blitTexture();
/* 93 */     debug();
/*    */   }
/*    */   
/*    */   private void debug() {
/* 97 */     if (this.debug)
/* 98 */       GlHelper.checkErrors(); 
/*    */   }
/*    */   
/*    */   public void registerLight(LIGHT_POINT l, float x, float y, float z, int radius, int x1, int x2, int y1, int y2, byte ne, byte se, byte sw, byte nw, byte depth) {}
/*    */   
/*    */   public void registerAmbient(LIGHT_AMBIENT l, int x1, int x2, int y1, int y2, byte depth) {}
/*    */   
/*    */   public void renderTilelight(int x1, int y1, int dim, byte nw, byte ne, byte se, byte sw) {}
/*    */   
/*    */   public void setTileLight(LIGHT_AMBIENT l, byte depth) {}
/*    */   
/*    */   public void renderPointlight(int x, int y, int z, int radius) {}
/*    */   
/*    */   public void setPointLight(LIGHT_POINT l, byte depth) {}
/*    */   
/*    */   public void renderDisplace(float tx1, float ty1, float dx1, float dy1, int w, int h, double scale, int x1, int x2, int y1, int y2, COLOR color, OPACITY opacity) {}
/*    */   
/*    */   public void psetMaxDepth(int x1, int x2, int y1, int y2, TextureCoords stencil, int depth) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\RendererDebug.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */