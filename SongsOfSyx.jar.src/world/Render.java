/*     */ package world;
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import init.settings.S;
/*     */ import init.type.CLIMATE;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.RGB;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.light.LIGHT_POINT;
/*     */ import snake2d.util.light.PointLight;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ class Render {
/*  19 */   private final ShadowBatch.Real shadowBatch = new ShadowBatch.Real();
/*  20 */   private final ShadowBatch shadowDummy = (ShadowBatch)new ShadowBatch.Dummy();
/*  21 */   private final PointLight light = new PointLight();
/*     */   
/*     */   final WRenContext rContext;
/*     */ 
/*     */   
/*     */   Render(int width, int height) {
/*  27 */     this.rContext = new WRenContext(width, height);
/*  28 */     this.light.setGreen(1.0D).setRed(2.0D).setBlue(0.5D);
/*  29 */     this.light.setFalloff(1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Renderer r, float ds, int zoomout, RECTANGLE renWindow, int offX, int offY) {
/*     */     ShadowBatch.Real real;
/*  35 */     ds = (float)(ds * GAME.SPEED.speedTarget());
/*     */     
/*  37 */     ShadowBatch s = this.shadowDummy;
/*  38 */     if ((S.get()).shadows.get() > 0) {
/*  39 */       this.shadowBatch.init(zoomout, (TIME.light()).shadow.sx(), (TIME.light()).shadow.sy());
/*  40 */       real = this.shadowBatch;
/*     */     } 
/*  42 */     this.rContext.init((SPRITE_RENDERER)r, (ShadowBatch)real, renWindow, offX, offY, ds);
/*  43 */     double seasonValue = 0.0D;
/*     */     
/*  45 */     double am = 0.0D;
/*  46 */     RenderData.RenderIterator it = this.rContext.data.onScreenTiles();
/*  47 */     while (it.has()) {
/*  48 */       am++;
/*  49 */       seasonValue += ((CLIMATE)(WORLD.CLIMATE()).getter.get(it.tile())).seasonChange;
/*  50 */       it.next();
/*     */     } 
/*  52 */     seasonValue /= am;
/*     */ 
/*     */     
/*  55 */     am = 0.0D;
/*  56 */     it = this.rContext.data.onScreenTiles();
/*  57 */     while (it.has()) {
/*  58 */       am++;
/*  59 */       seasonValue += ((CLIMATE)(WORLD.CLIMATE()).getter.get(it.tile())).seasonChange;
/*  60 */       it.next();
/*     */     } 
/*  62 */     seasonValue /= am;
/*     */ 
/*     */     
/*  65 */     r.newLayer(false, zoomout);
/*  66 */     TIME.light().applyGuiLight(ds, offX, offX + renWindow.width(), offY, 
/*  67 */         offY + renWindow.height());
/*  68 */     WORLD.OVERLAY().render(r, (ShadowBatch)real, this.rContext.data, zoomout);
/*     */     
/*  70 */     r.newFinalLightWithShadows(zoomout, this);
/*  71 */     TIME.light().apply(offX, offX + renWindow.width(), offY, 
/*  72 */         offY + renWindow.height(), RGB.WHITE);
/*  73 */     CORE.renderer().setUniLight((LIGHT_POINT)this.light);
/*     */     
/*  75 */     WORLD.FOW().render(this.rContext);
/*  76 */     r.newLayer(false, zoomout);
/*     */     
/*  78 */     tileRenderAboveTerrain(this.rContext);
/*  79 */     WORLD.ENTITIES().renderAboveTerrain(r, (ShadowBatch)real, ds, renWindow, offX, offY);
/*  80 */     r.newLayer(false, zoomout);
/*     */     
/*  82 */     WORLD.WATER().render(r, this.rContext.data, seasonValue);
/*  83 */     r.newLayer(false, zoomout);
/*     */     
/*  85 */     WORLD.FOREST().render((SPRITE_RENDERER)r, (ShadowBatch)real, this.rContext.data);
/*  86 */     r.newLayer(false, zoomout);
/*     */     
/*  88 */     COLOR.unbind();
/*  89 */     OPACITY.unbind();
/*  90 */     WORLD.MOUNTAIN().render((SPRITE_RENDERER)r, (ShadowBatch)real, this.rContext.data);
/*  91 */     r.newLayer(false, zoomout);
/*     */     
/*  93 */     WORLD.ENTITIES().renderBelowTerrain(r, (ShadowBatch)real, ds, renWindow, offX, offY);
/*  94 */     r.newLayer(false, zoomout);
/*     */     
/*  96 */     tileRenderAbove(this.rContext);
/*  97 */     r.newLayer(false, zoomout);
/*     */     
/*  99 */     if (!WORLD.OVERLAY().renderBelow(r, (ShadowBatch)real, this.rContext.data, zoomout)) {
/* 100 */       tileRenderAboveGround(this.rContext, seasonValue);
/*     */     }
/* 102 */     r.newLayer(false, zoomout);
/*     */ 
/*     */ 
/*     */     
/* 106 */     CORE.getSoundCore().set(renWindow.cX() + offX, renWindow.cY() + offY);
/*     */     
/* 108 */     for (WORLD.WorldResource res : WORLD.RESOURCES()) {
/* 109 */       res.afterRender();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void tileRenderAboveGround(WRenContext data, double season) {
/* 116 */     RenderData.RenderIterator it = data.data.onScreenTiles();
/* 117 */     WORLD.GROUND().renderInit(season);
/*     */     
/* 119 */     while (it.has()) {
/*     */       
/* 121 */       WORLD.GROUND().render(CORE.renderer(), it);
/* 122 */       WORLD.BUILDINGS().renderAboveGround(data, it);
/*     */       
/* 124 */       WORLD.ROADS().render(data, it);
/* 125 */       WORLD.WATER().renderShorelines(CORE.renderer(), it);
/* 126 */       WORLD.REGIONS().renderBorders(CORE.renderer(), it);
/* 127 */       it.next();
/*     */     } 
/* 129 */     (WORLD.CENTRE()).sprite.renderGround(data);
/* 130 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void tileRenderAbove(WRenContext data) {
/* 137 */     (WORLD.CENTRE()).sprite.renderAbove(data);
/* 138 */     RenderData.RenderIterator it = data.data.onScreenTiles(0, 1, 0, 1);
/*     */     
/* 140 */     while (it.has()) {
/*     */       
/* 142 */       WORLD.BUILDINGS().renderAbove(data, it);
/* 143 */       it.next();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void tileRenderAboveTerrain(WRenContext data) {
/* 152 */     (WORLD.CENTRE()).sprite.renderAboveTerrain(data);
/* 153 */     RenderData.RenderIterator it = data.data.onScreenTiles(0, 0, 0, 0);
/*     */ 
/*     */ 
/*     */     
/* 157 */     while (it.has()) {
/* 158 */       WORLD.ROADS().renderBridge(data, it);
/* 159 */       WORLD.BUILDINGS().renderAboveTerrain(data, it);
/* 160 */       it.next();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\Render.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */