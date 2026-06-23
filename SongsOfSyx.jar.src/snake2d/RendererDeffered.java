/*     */ package snake2d;
/*     */ 
/*     */ import org.lwjgl.opengl.GL20;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.light.LIGHT_AMBIENT;
/*     */ import snake2d.util.light.LIGHT_POINT;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class RendererDeffered
/*     */   extends Renderer
/*     */ {
/*     */   private final VboSpriteOpti vboTextured;
/*     */   private final VboShadowPoints vboShadows;
/*     */   private final VboLightAmbient vboLightAmbient;
/*     */   private final VboTileLight vboTileLight;
/*     */   private final VboLightPoint vboLightPoint;
/*     */   private final VboParticles vboParticles;
/*     */   private final _FBODeffered fbo;
/*     */   
/*     */   public RendererDeffered(SETTINGS sett, int pointSize) {
/*  28 */     super(pointSize);
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
/* 166 */     this.di = 0; GlHelper.checkErrors(); Printer.ln("SHADERS: "); this.vboTextured = VboSpriteOpti.getDeffered(sett); this.vboShadows = new VboShadowPoints(sett); this.vboLightAmbient = new VboLightAmbient(sett); this.vboLightPoint = new VboLightPoint(sett); this.vboParticles = VboParticles.getDeffered(sett); this.vboTileLight = new VboTileLight(sett); this.vboDisplace2 = VboSpriteDisplace.getDeffered(sett); this.vboLightPointUni = new VboLightPointUni(sett); this.depth = new VboStencilMaxSetter(sett); this.fbo = new _FBODeffered(sett); this.debug = sett.debugMode(); GlHelper.Stencil.enable(true); GlHelper.checkErrors(); Printer.fin();
/*     */   }
/*     */   private final VboSpriteDisplace vboDisplace2;
/*     */   private final VboLightPointUni vboLightPointUni;
/*     */   private final VboStencilMaxSetter depth; private final boolean debug; private int di; void dis() { GlHelper.checkErrors(); this.vboTextured.dis(); GlHelper.checkErrors(); this.vboShadows.dis(); GlHelper.checkErrors(); this.fbo.dis(); GlHelper.checkErrors(); this.vboLightAmbient.dis(); GlHelper.checkErrors(); this.vboLightPoint.dis(); GlHelper.checkErrors(); this.vboParticles.dis(); GlHelper.checkErrors(); this.vboTileLight.dis(); GlHelper.checkErrors(); this.vboDisplace2.dis(); GlHelper.checkErrors(); this.vboLightPointUni.dis(); GlHelper.checkErrors(); this.depth.dis(); GlHelper.checkErrors(); ElementArrays.dispose(); GlHelper.checkErrors(); } protected int pnewLayer(boolean keepLights, int pointSize) { if (keepLights) { this.vboLightAmbient.setNewButKeepLight(); this.vboLightPoint.setNewButKeepLight(); this.vboTileLight.setNewButKeepLight(); this.vboLightPointUni.setNewButKeepLight(); } else { this.vboLightAmbient.setNew(); this.vboLightPoint.setNew(); this.vboTileLight.setNew(); this.vboLightPointUni.setNew(); }
/* 171 */      this.vboParticles.setNew(pointSize); int i = this.vboTextured.setNew(); this.vboDisplace2.setNew(); this.vboShadows.setNewFinalOverride(i); this.depth.setNewFinalOverride(i); return i; } protected int pnewFinalLightLayer(int pointSize) { this.vboLightAmbient.setNewFinal(); this.vboLightPoint.setNewFinal(); this.vboTileLight.setNewFinal(); this.vboLightPointUni.setNewFinal(); this.vboParticles.setNew(pointSize); int i = this.vboTextured.setNew(); this.vboDisplace2.setNew(); this.vboShadows.setNewFinalOverride(i); this.depth.setNewFinalOverride(i); return i; } protected void pclear(int pointSize) { this.vboTextured.clear(); this.vboShadows.clear(); this.vboLightAmbient.clear(); this.vboLightPoint.clear(); this.vboTileLight.clear(); this.vboParticles.clear(pointSize); this.vboDisplace2.clear(); this.vboLightPointUni.clear(); this.depth.clear(); } public void pflush(int pointSize) { debug();
/* 172 */     this.fbo.bindDiffAndNorForTarget();
/* 173 */     debug();
/*     */     
/* 175 */     debug();
/* 176 */     this.vboParticles.flush(pointSize);
/* 177 */     debug();
/*     */ 
/*     */     
/* 180 */     debug();
/* 181 */     this.vboTextured.flush();
/* 182 */     debug();
/* 183 */     this.vboDisplace2.flush();
/* 184 */     debug();
/* 185 */     this.depth.flush();
/* 186 */     this.vboShadows.flush();
/*     */ 
/*     */     
/* 189 */     debug();
/*     */     
/* 191 */     debug();
/* 192 */     this.fbo.bindLightTextureForTarget();
/* 193 */     debug();
/* 194 */     this.vboLightAmbient.flush();
/* 195 */     debug();
/* 196 */     this.vboLightPoint.flush();
/* 197 */     debug();
/* 198 */     this.vboLightPointUni.flush();
/* 199 */     debug();
/* 200 */     this.vboTileLight.flush();
/* 201 */     debug();
/*     */     
/* 203 */     this.fbo.blitTexture();
/* 204 */     debug();
/* 205 */     GL20.glUseProgram(0); } public final void renderShadow(TextureCoords t, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, byte d, byte depth) { this.vboShadows.render(t, x1, y1, x2, y2, x3, y3, x4, y4, d, depth); }
/*     */   public final void renderSprite(TextureCoords t, TextureCoords to, int x1, int x2, int y1, int y2, COLOR color, OPACITY opacity) { this.vboTextured.render(t, to, x1, x2, y1, y2, color, opacity); }
/*     */   public final void registerLight(LIGHT_POINT l, float x, float y, float z, int radius, int x1, int x2, int y1, int y2, byte ne, byte se, byte sw, byte nw, byte depth) { this.vboLightPoint.render(l, x, y, z, radius, x1, x2, y1, y2, ne, se, sw, nw, depth); }
/*     */   public final void registerAmbient(LIGHT_AMBIENT l, int x1, int x2, int y1, int y2, byte depth) { this.vboLightAmbient.render(l, x1, x2, y1, y2, depth); }
/*     */   public final void renderParticle(short x, short y, byte nx, byte ny, byte nz, byte nA, COLOR color, OPACITY opacity) { this.vboParticles.render(x, y, nx, ny, nz, nA, color, opacity); }
/*     */   private void debug() {
/* 211 */     if (this.debug && this.di++ >= 1000) {
/* 212 */       this.di = 0;
/* 213 */       GlHelper.checkErrors();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderTilelight(int x1, int y1, int dim, byte nw, byte ne, byte se, byte sw) {
/* 219 */     this.vboTileLight.render(x1, y1, dim, nw, ne, se, sw);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTileLight(LIGHT_AMBIENT l, byte depth) {
/* 224 */     this.vboTileLight.setLight((float)l.r(), (float)l.g(), (float)l.b(), l.x(), l.y(), l.z(), depth);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderPointlight(int x, int y, int z, int radius) {
/* 229 */     this.vboLightPointUni.render((short)x, (short)y, (short)z, (short)radius);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPointLight(LIGHT_POINT l, byte depth) {
/* 235 */     this.vboLightPointUni.setLight(l.getRadius(), l.getRed(), l.getGreen(), l.getBlue(), l.getFalloff(), depth);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderDisplace(float tx1, float ty1, float dx1, float dy1, int w, int h, double scale, int x1, int x2, int y1, int y2, COLOR color, OPACITY opacity) {
/* 241 */     this.vboDisplace2.render(tx1, ty1, dx1, dy1, w, h, scale, x1, x2, y1, y2, color, opacity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void psetMaxDepth(int x1, int x2, int y1, int y2, TextureCoords stencil, int depth) {
/* 248 */     this.depth.render(stencil, x1, y1, x2, y2, depth);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\RendererDeffered.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */