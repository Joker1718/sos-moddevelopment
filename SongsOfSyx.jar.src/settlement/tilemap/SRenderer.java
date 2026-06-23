/*     */ package settlement.tilemap;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.RGB;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SRenderer
/*     */ {
/*     */   private final TileMap m;
/*     */   
/*     */   SRenderer(TileMap m) {
/*  26 */     this.m = m;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAboveEnts(Renderer r, ShadowBatch s, float ds, int zoomout, RenderData renData) {
/*  31 */     r.newLayer(false, zoomout);
/*  32 */     SETT.WEATHER().apply(renData.absBounds());
/*  33 */     this.m.topology.renderAbove(r, s, renData);
/*  34 */     r.newFinalLightWithShadows(zoomout, this);
/*  35 */     SETT.WEATHER().apply(renData.absBounds());
/*  36 */     SETT.ROOMS().renderAbove(r, s, renData, zoomout);
/*  37 */     r.newLayer(true, zoomout);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTheRest(Renderer r, ShadowBatch s, float ds, int zoomout, RenderData renData, RECTANGLE renWindow, int offX, int offY) {
/*  43 */     r.newLayer(false, zoomout);
/*     */     
/*  45 */     SETT.ROOMS().render(r, s, renData, zoomout);
/*  46 */     if (renData.isLit) {
/*  47 */       RenderData.RenderIterator it = renData.onScreenTiles();
/*  48 */       TIME.light().bindRoom();
/*  49 */       while (it.has()) {
/*  50 */         if (it.litIs()) {
/*  51 */           byte nw = (byte)((it.litIs(DIR.NW) && it.litIs(DIR.W) && it.litIs(DIR.N)) ? 255 : 0);
/*  52 */           byte ne = (byte)((it.litIs(DIR.NE) && it.litIs(DIR.E) && it.litIs(DIR.N)) ? 255 : 0);
/*  53 */           byte se = (byte)((it.litIs(DIR.SE) && it.litIs(DIR.E) && it.litIs(DIR.S)) ? 255 : 0);
/*  54 */           byte sw = (byte)((it.litIs(DIR.SW) && it.litIs(DIR.W) && it.litIs(DIR.S)) ? 255 : 0);
/*  55 */           r.renderTileLight(it.x(), it.y(), 64, nw, ne, se, sw);
/*     */         } 
/*  57 */         it.nextAll();
/*     */       } 
/*     */       
/*  60 */       renData.isLit = false;
/*     */     } 
/*     */     
/*  63 */     r.newLayer(false, zoomout);
/*  64 */     SETT.ENTRY().render(r, renData);
/*  65 */     r.newLayer(false, zoomout);
/*  66 */     this.m.topology.renderMid(r, s, renData);
/*  67 */     r.newLayer(false, zoomout);
/*  68 */     SETT.HALFENTS().renderBelow(r, s, ds, renWindow, offX, offY);
/*  69 */     r.newLayer(false, zoomout);
/*  70 */     this.m.topology.renderBelow(r, s, renData);
/*     */     
/*  72 */     if (!SETT.OVERLAY().renderOnGround(r, renData, zoomout)) {
/*  73 */       r.newLayer(false, zoomout);
/*  74 */       this.m.snow.render(r, renData);
/*     */       
/*  76 */       r.newLayer(false, zoomout);
/*  77 */       this.m.floors.render(r, ds, s, renData);
/*  78 */       r.newLayer(false, zoomout);
/*  79 */       this.m.grass.render(ds, r, renData);
/*  80 */       r.newLayer(false, zoomout);
/*  81 */       this.m.ground.render(r, ds, s, renData);
/*     */     } else {
/*  83 */       r.newLayer(false, zoomout);
/*  84 */       this.m.floors.render(r, ds, s, renData);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderSemiMap(Renderer r, float ds, RenderData renData) {
/*  95 */     int zoomout = 3;
/*  96 */     SETT.OVERLAY().renderOnGround(r, renData, zoomout);
/*     */ 
/*     */     
/*  99 */     RenderData.RenderIterator it = renData.onScreenTiles();
/* 100 */     r.newLayer(false, zoomout);
/*     */     
/* 102 */     TIME.light().apply(0, C.WIDTH() << zoomout, 0, C.HEIGHT() << zoomout, RGB.WHITE);
/*     */     
/* 104 */     while (it.has()) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 109 */       if ((SETT.ROOMS()).map.is(it.tile())) {
/* 110 */         Room room = (SETT.ROOMS()).map.get(it.tile());
/* 111 */         int mask = 0;
/* 112 */         for (DIR d : DIR.ORTHO) {
/* 113 */           if (room.isSame(it.tx(), it.ty(), it.tx() + d.x(), it.ty() + d.y()))
/* 114 */             mask |= d.mask(); 
/*     */         } 
/* 116 */         (SPRITES.cons()).TINY.low.render((SPRITE_RENDERER)r, mask, it.x(), it.y());
/*     */       } else {
/* 118 */         Terrain.TerrainTile t = SETT.TERRAIN().get(it.tile());
/* 119 */         int depth = t.miniDepth();
/* 120 */         if (depth == 0) {
/* 121 */           if (this.m.floors.getter.is(it.tile())) {
/* 122 */             int mask = 0;
/* 123 */             for (DIR d : DIR.ORTHO) {
/* 124 */               if (this.m.floors.getter.is(it.tx(), it.ty(), d))
/* 125 */                 mask |= d.mask(); 
/*     */             } 
/* 127 */             (SPRITES.cons()).TINY.flat.render((SPRITE_RENDERER)r, mask, it.x(), it.y());
/*     */           } else {
/* 129 */             (SPRITES.cons()).TINY.low.render((SPRITE_RENDERER)r, 15, it.x(), it.y());
/*     */           } 
/*     */         } else {
/* 132 */           int mask = 0;
/* 133 */           for (DIR d : DIR.ORTHO) {
/* 134 */             if (((Terrain.TerrainTile)SETT.TERRAIN().get(it.tx(), it.ty(), d)).miniDepth() == depth) {
/* 135 */               mask |= d.mask();
/*     */             }
/*     */           } 
/* 138 */           if (depth == 2) {
/* 139 */             (SPRITES.cons()).TINY.high.render((SPRITE_RENDERER)r, mask, it.x(), it.y());
/* 140 */           } else if (depth == 1) {
/* 141 */             (SPRITES.cons()).TINY.low.render((SPRITE_RENDERER)r, mask, it.x(), it.y());
/*     */           } else {
/* 143 */             (SPRITES.cons()).TINY.flat.render((SPRITE_RENDERER)r, mask, it.x(), it.y());
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 149 */       it.next();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 154 */     OPACITY.O99.bind();
/* 155 */     double px1 = renData.gBounds().x1() / 64.0D;
/* 156 */     double py1 = renData.gBounds().y1() / 64.0D;
/*     */     
/* 158 */     SETT.MINIMAP().render((SPRITE_RENDERER)r, px1, py1, renData.absBounds().x1(), renData.absBounds().y1(), renData.absBounds().width(), renData.absBounds().height(), 64.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     OPACITY.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderMiniMap(Renderer r, float ds, RenderData renData, int zoomout) {
/* 170 */     int zoom = 64 >> zoomout;
/*     */ 
/*     */     
/* 173 */     r.newLayer(false, 0);
/*     */     
/* 175 */     TIME.light().apply(0, C.WIDTH() << zoomout, 0, C.HEIGHT() << zoomout, RGB.WHITE);
/*     */     
/* 177 */     SETT.MINIMAP().render((SPRITE_RENDERER)r, 
/* 178 */         renData.gBounds().x1() / 64.0D, renData.gBounds().y1() / 64.0D, 
/* 179 */         renData.absBounds().x1(), renData.absBounds().y1(), 
/* 180 */         renData.absBounds().width(), renData.absBounds().height(), 
/* 181 */         zoom);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\SRenderer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */