/*     */ package snake2d;
/*     */ 
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.light.AmbientLight;
/*     */ import snake2d.util.light.LIGHT_AMBIENT;
/*     */ import snake2d.util.light.LIGHT_POINT;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ 
/*     */ public abstract class Renderer
/*     */   extends CORE_RESOURCE implements SPRITE_RENDERER {
/*  15 */   protected int zoomout = 0;
/*     */   
/*     */   protected final int pointSize;
/*  18 */   private final byte noShadows = -1;
/*  19 */   private final byte shadows = 0;
/*  20 */   private byte shadowDepth = -1;
/*  21 */   private byte lightDepth = 0;
/*     */   
/*  23 */   private int layer = 0; private int spritesRendered; private int shadowsRendered; private int particlesRendererd; private int lightsRendererd; private int shadowsRenderedO; private int spritesRenderedO; private int particlesRendererdO;
/*     */   private int lightsRendererdO;
/*     */   private final COLOR white;
/*     */   private COLOR current;
/*     */   private final OPACITY OpacityDefault;
/*     */   private OPACITY currentOpacity;
/*     */   private Object debugOld;
/*     */   
/*  31 */   final void flush() { pflush(this.pointSize >> this.zoomout);
/*  32 */     clear(); } public final int pointsize() { return this.pointSize >> this.zoomout; } public final int getSpritesSprocessed() { return this.spritesRenderedO; } public final int getParticlesProcessed() { return this.particlesRendererdO; } public final int getLightsProcessed() { return this.lightsRendererdO; } public final int getShadowsRendered() { return this.shadowsRenderedO; }
/*     */   public final void setColor(COLOR color) { this.current = color; }
/*     */   public final COLOR colorGet() { return this.current; }
/*     */   public final COLOR getBoundColor() { return this.current; }
/*     */   public final void setNormalColor() { this.current = this.white; }
/*  37 */   Renderer(int pointSize) { this.spritesRendered = 0;
/*  38 */     this.shadowsRendered = 0;
/*  39 */     this.particlesRendererd = 0;
/*  40 */     this.lightsRendererd = 0;
/*  41 */     this.shadowsRenderedO = 0;
/*  42 */     this.spritesRenderedO = 0;
/*  43 */     this.particlesRendererdO = 0;
/*  44 */     this.lightsRendererdO = 0;
/*     */     
/*  46 */     this.white = ColorImp.WHITE100;
/*  47 */     this.current = this.white;
/*  48 */     this.OpacityDefault = OpacityImp.O100;
/*  49 */     this.currentOpacity = this.OpacityDefault;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 352 */     this.debugOld = null; this.pointSize = pointSize; this.zoomout = 0; } public final void setOpacity(OPACITY o) { this.currentOpacity = o; } public final void setNormalOpacity() { this.currentOpacity = this.OpacityDefault; } public final boolean isNormalOpacity() { return (this.currentOpacity == this.OpacityDefault); } public final OPACITY opacity() { return this.currentOpacity; } public final void shadeLight(boolean shade) { this.lightDepth = shade ? 0 : -1; } public final void shadowDepthSet(byte depth) { this.shadowDepth = depth; } public final void shadowDepthDefault() { this.shadowDepth = -1; }
/*     */   public final void lightDepthSet(byte depth) { this.lightDepth = depth; }
/* 354 */   public final int newFinalLightWithShadows(int zoomout, Object o) { this.zoomout = zoomout;
/* 355 */     int pz = CLAMP.i(this.pointSize >> zoomout, 1, this.pointSize);
/* 356 */     if (this.debugOld != null && this.debugOld != o)
/* 357 */       throw new RuntimeException(this.debugOld + " " + o); 
/* 358 */     this.debugOld = o;
/* 359 */     this.layer = pnewFinalLightLayer(pz);
/* 360 */     return this.layer; } public final void renderSprite(int x1, int x2, int y1, int y2, TextureCoords t) { renderTextured(x1, x2, y1, y2, t, t); } public final void renderTextured(int x1, int x2, int y1, int y2, TextureCoords texture, TextureCoords stencil) { if (this.zoomout != 0) { x1 >>= this.zoomout; x2 >>= this.zoomout; y1 >>= this.zoomout; y2 >>= this.zoomout; }  if (x2 < 0 || y2 < 0 || x1 > (CORE.getGraphics()).nativeWidth || y1 > (CORE.getGraphics()).nativeHeight) return;  renderSprite(stencil, texture, x1, x2, y1, y2, this.current, this.currentOpacity); this.spritesRendered++; }
/*     */   public final void renderDisplaced(int x1, int x2, int y1, int y2, TextureCoords displacement, TextureCoords texture) { renderDisplace(displacement.x1, displacement.y1, texture.x1, texture.y1, texture.x2 - texture.x1, texture.y2 - texture.y1, 16.0D, x1, x2, y1, y2); }
/*     */   public final void renderDisplaced(int x1, int x2, int y1, int y2, double scale, TextureCoords displacement, TextureCoords texture) { renderDisplace(displacement.x1, displacement.y1, texture.x1, texture.y1, texture.x2 - texture.x1, texture.y2 - texture.y1, scale * 16.0D, x1, x2, y1, y2); }
/*     */   public final void renderDisplace(float tx1, float ty1, float dx1, float dy1, int w, int h, double scale, int x1, int x2, int y1, int y2) { if (this.zoomout != 0) { x1 >>= this.zoomout; x2 >>= this.zoomout; y1 >>= this.zoomout; y2 >>= this.zoomout; }  renderDisplace(tx1, ty1, dx1, dy1, w, h, scale, x1, x2, y1, y2, this.current, this.currentOpacity); this.spritesRendered++; }
/*     */   private final void renderShadow(TextureCoords t, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, byte d) { renderShadow(t, x1, y1, x2, y2, x3, y3, x4, y4, d, this.shadowDepth); this.shadowsRendered++; }
/*     */   public final void renderShadow(int x1, int x2, int y1, int y2, TextureCoords stencil, byte d) { if (this.zoomout != 0) { x1 >>= this.zoomout; x2 >>= this.zoomout; y1 >>= this.zoomout; y2 >>= this.zoomout; }  if (x2 < 0 || y2 < 0 || x1 > (CORE.getGraphics()).nativeWidth || y1 > (CORE.getGraphics()).nativeHeight) return;  renderShadow(stencil, x1, y1, x2, y1, x2, y2, x1, y2, d); }
/*     */   public final void setMaxDepth(int x1, int x2, int y1, int y2, TextureCoords stencil) { setMaxDepth(x1, x2, y1, y2, stencil, this.layer); }
/* 367 */   public void clear() { pclear(this.pointSize >> this.zoomout);
/* 368 */     this.spritesRenderedO = this.spritesRendered;
/* 369 */     this.particlesRendererdO = this.particlesRendererd;
/* 370 */     this.lightsRendererdO = this.lightsRendererd;
/* 371 */     this.shadowsRenderedO = this.shadowsRendered;
/* 372 */     this.shadowsRendered = 0;
/* 373 */     this.spritesRendered = 0;
/* 374 */     this.particlesRendererd = 0;
/* 375 */     this.lightsRendererd = 0;
/* 376 */     this.zoomout = 0;
/* 377 */     this.layer = 0;
/* 378 */     this.debugOld = null; }
/*     */   public final void setMaxDepth(int x1, int x2, int y1, int y2, TextureCoords stencil, int layer) { if (this.zoomout != 0) { x1 >>= this.zoomout; x2 >>= this.zoomout; y1 >>= this.zoomout; y2 >>= this.zoomout; }
/*     */      if (x2 < 0 || y2 < 0 || x1 > (CORE.getGraphics()).nativeWidth || y1 > (CORE.getGraphics()).nativeHeight)
/*     */       return;  psetMaxDepth(x1, x2, y1, y2, stencil, layer); }
/*     */   public int getDepth() { return this.layer; }
/*     */   public final void renderParticle(int x, int y) { renderParticle(x, y, -128, -128, (byte)-1, (byte)-1); }
/* 384 */   public final void renderParticleFlat(int x, int y) { renderParticle(x, y, -128, -128, (byte)-1, (byte)0); } public int getZoomout() { return this.zoomout; }
/*     */   public final void renderParticle(int x, int y, byte nX, byte nY, byte nZ, byte nA) { if (this.zoomout > 2) return;  if (this.zoomout != 0) { x >>= this.zoomout; y >>= this.zoomout; }  if (x < 0 || y < 0 || x > (CORE.getGraphics()).nativeWidth || y > (CORE.getGraphics()).nativeHeight) return;  renderParticle((short)x, (short)y, nX, nY, nZ, nA, this.current, this.currentOpacity); this.particlesRendererd++; }
/*     */   public final void registerLight(LIGHT_POINT light, int x1, int x2, int y1, int y2) { registerLight(light, x1, x2, y1, y2, (byte)-1, (byte)-1, (byte)-1, (byte)-1); }
/*     */   public final void registerLight(LIGHT_POINT light, int x1, int x2, int y1, int y2, byte ne, byte se, byte sw, byte nw) { this.lightsRendererd++; if (this.zoomout != 0) { x1 >>= this.zoomout; x2 >>= this.zoomout; y1 >>= this.zoomout; y2 >>= this.zoomout; registerLight(light, ((int)light.cx() >> this.zoomout), ((int)light.cy() >> this.zoomout), (int)light.cz(), light.getRadius() >> this.zoomout, x1, x2, y1, y2, ne, se, sw, nw, this.lightDepth); return; }  registerLight(light, light.cx(), light.cy(), light.cz(), light.getRadius(), x1, x2, y1, y2, ne, se, sw, nw, this.lightDepth); }
/* 388 */   public final void registerAmbient(LIGHT_AMBIENT light, int x1, int x2, int y1, int y2) { this.lightsRendererd++; if (this.zoomout != 0) { x1 >>= this.zoomout; x2 >>= this.zoomout; y1 >>= this.zoomout; y2 >>= this.zoomout; }  registerAmbient(light, x1, x2, y1, y2, this.lightDepth); } public final int newLayer(boolean keeplight, int zoomout) { this.zoomout = zoomout; int pz = CLAMP.i(this.pointSize >> zoomout, 1, this.pointSize); this.layer = pnewLayer(keeplight, pz); return this.layer; } public void renderTileLight(int x1, int y1, int dim, byte nw, byte ne, byte se, byte sw) { if (this.zoomout != 0) {
/* 389 */       x1 >>= this.zoomout;
/* 390 */       y1 >>= this.zoomout;
/* 391 */       dim >>= this.zoomout;
/*     */     } 
/* 393 */     renderTilelight(x1, y1, dim, nw, ne, se, sw); }
/*     */ 
/*     */   
/*     */   public void setTileLight(AmbientLight l) {
/* 397 */     setTileLight((LIGHT_AMBIENT)l, this.shadowDepth);
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
/*     */   public void renderUniLight(int x, int y, int z, int radius) {
/* 410 */     if (this.zoomout != 0) {
/* 411 */       x >>= this.zoomout;
/* 412 */       y >>= this.zoomout;
/* 413 */       z >>= this.zoomout;
/* 414 */       radius >>= this.zoomout;
/*     */     } 
/* 416 */     renderPointlight(x, y, z, radius);
/*     */   }
/*     */   
/*     */   public void setUniLight(LIGHT_POINT l) {
/* 420 */     setPointLight(l, this.shadowDepth);
/*     */   }
/*     */   
/*     */   public void setZoom(int i) {
/* 424 */     this.zoomout = i;
/*     */   }
/*     */   
/*     */   protected abstract void pflush(int paramInt);
/*     */   
/*     */   protected abstract void renderSprite(TextureCoords paramTextureCoords1, TextureCoords paramTextureCoords2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, COLOR paramCOLOR, OPACITY paramOPACITY);
/*     */   
/*     */   protected abstract void renderDisplace(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2, double paramDouble, int paramInt3, int paramInt4, int paramInt5, int paramInt6, COLOR paramCOLOR, OPACITY paramOPACITY);
/*     */   
/*     */   protected abstract void renderShadow(TextureCoords paramTextureCoords, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, byte paramByte1, byte paramByte2);
/*     */   
/*     */   protected abstract void psetMaxDepth(int paramInt1, int paramInt2, int paramInt3, int paramInt4, TextureCoords paramTextureCoords, int paramInt5);
/*     */   
/*     */   protected abstract void renderParticle(short paramShort1, short paramShort2, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, COLOR paramCOLOR, OPACITY paramOPACITY);
/*     */   
/*     */   protected abstract void registerLight(LIGHT_POINT paramLIGHT_POINT, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5);
/*     */   
/*     */   protected abstract void registerAmbient(LIGHT_AMBIENT paramLIGHT_AMBIENT, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte paramByte);
/*     */   
/*     */   protected abstract int pnewLayer(boolean paramBoolean, int paramInt);
/*     */   
/*     */   protected abstract int pnewFinalLightLayer(int paramInt);
/*     */   
/*     */   protected abstract void pclear(int paramInt);
/*     */   
/*     */   protected abstract void setTileLight(LIGHT_AMBIENT paramLIGHT_AMBIENT, byte paramByte);
/*     */   
/*     */   protected abstract void renderPointlight(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   protected abstract void setPointLight(LIGHT_POINT paramLIGHT_POINT, byte paramByte);
/*     */   
/*     */   protected abstract void renderTilelight(int paramInt1, int paramInt2, int paramInt3, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\Renderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */