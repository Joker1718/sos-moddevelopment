/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.thing.pointlight.LOS;
/*     */ import settlement.tilemap.TileMap;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.keymap.MAPPED;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class TerrainTile
/*     */   implements GAMETILE, MAP_BOOLEAN, TileMap.SMinimapGetter, MAPPED
/*     */ {
/*     */   public final int code;
/*     */   private final CharSequence name;
/*     */   protected final COLOR miniC;
/*     */   protected final Terrain shared;
/*     */   private final SPRITE icon;
/*     */   private final String key;
/*     */   
/*     */   protected TerrainTile(String key, Terrain shared, CharSequence name, SPRITE icon, COLOR miniC) {
/* 314 */     this.shared = shared;
/* 315 */     this.code = shared.look.add(this);
/* 316 */     this.name = name;
/* 317 */     this.miniC = (miniC != null) ? (COLOR)miniC.shade(0.5D) : null;
/* 318 */     this.icon = icon;
/* 319 */     this.key = key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract boolean place(int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void placeRaw(int x, int y) {
/* 333 */     if (SETT.IN_BOUNDS(x, y)) {
/* 334 */       this.shared.counts[this.shared.tiles[y * SETT.TWIDTH + x]] = this.shared.counts[this.shared.tiles[y * SETT.TWIDTH + x]] - 1;
/* 335 */       this.shared.tiles[y * SETT.TWIDTH + x] = (byte)this.code;
/* 336 */       this.shared.counts[this.code] = this.shared.counts[this.code] + 1;
/*     */       
/* 338 */       this.shared.data.set(x, y, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR miniC(int x, int y) {
/* 344 */     return this.miniC;
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR miniColorPimped(ColorImp c, int x, int y, boolean northern, boolean southern) {
/* 349 */     return this.miniC;
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 354 */     return this.icon;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/* 359 */     return this.name;
/*     */   }
/*     */   
/*     */   protected abstract boolean renderAbove(SPRITE_RENDERER paramSPRITE_RENDERER, ShadowBatch paramShadowBatch, RenderData.RenderIterator paramRenderIterator, int paramInt);
/*     */   
/*     */   protected abstract boolean renderBelow(SPRITE_RENDERER paramSPRITE_RENDERER, ShadowBatch paramShadowBatch, RenderData.RenderIterator paramRenderIterator, int paramInt);
/*     */   
/*     */   protected boolean renderMid(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 367 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/* 373 */     return (this.shared.get(tile) == this);
/*     */   }
/*     */   
/*     */   boolean wallJoiner() {
/* 377 */     return false;
/*     */   }
/*     */   
/*     */   boolean wallIsWally() {
/* 381 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isMassiveWall() {
/* 385 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean roofIs() {
/* 393 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract AVAILABILITY getAvailability(int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LOS los(int tx, int ty) {
/* 407 */     return LOS.OPEN;
/*     */   }
/*     */ 
/*     */   
/*     */   void unplace(int tx, int ty) {}
/*     */ 
/*     */   
/*     */   public void hoverInfo(GBox box, int tx, int ty) {
/* 415 */     box.textLL(this.name);
/*     */   }
/*     */   
/*     */   private void placeFixed(int tx, int ty, int it) {
/* 419 */     if (it > 128)
/*     */       return; 
/* 421 */     if (!SETT.IN_BOUNDS(tx, ty)) {
/*     */       return;
/*     */     }
/* 424 */     TerrainTile old = this.shared.get(tx, ty);
/* 425 */     old.unplace(tx, ty);
/*     */     
/* 427 */     boolean res = (SETT.TERRAIN()).indoors.remove(tx, ty);
/* 428 */     if (place(tx, ty) || old != this.shared.get(tx, ty)) {
/* 429 */       (SETT.TERRAIN()).indoors.add(tx, ty, res);
/* 430 */       if (old.miniC(tx, ty) != null || this.shared.get(tx, ty).miniC(tx, ty) != null)
/* 431 */         SETT.TILE_MAP().miniCUpdate(tx, ty); 
/* 432 */       (SETT.PATH()).availability.updateAvailability(tx, ty);
/*     */       
/* 434 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/* 435 */         DIR d = (DIR)DIR.ALL.get(i);
/* 436 */         this.shared.get(tx + d.x(), ty + d.y()).placeFixed(tx + d.x(), ty + d.y(), it + 1);
/*     */       } 
/*     */     } else {
/* 439 */       (SETT.TERRAIN()).indoors.add(tx, ty, res);
/*     */     } 
/*     */     
/* 442 */     SETT.FLOOR().updateStructure(tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void placeFixed(int tx, int ty) {
/* 450 */     placeFixed(tx, ty, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TerrainClearing clearing() {
/* 456 */     return TerrainClearing.dummy;
/*     */   }
/*     */   
/*     */   public int miniDepth() {
/* 460 */     return 0;
/*     */   }
/*     */   
/*     */   public TERRAIN terrain(int tx, int ty) {
/* 464 */     return TERRAINS.NONE();
/*     */   }
/*     */   
/*     */   public int heightStart(int tx, int ty) {
/* 468 */     return 0;
/*     */   }
/*     */   public int heightEnd(int tx, int ty) {
/* 471 */     return 0;
/*     */   }
/*     */   
/*     */   public int heightEnt(int tx, int ty) {
/* 475 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean coversCompletely(int tx, int ty) {
/* 479 */     return false;
/*     */   }
/*     */   
/*     */   public int count() {
/* 483 */     return (SETT.TERRAIN()).counts[this.code];
/*     */   }
/*     */ 
/*     */   
/*     */   public final int index() {
/* 488 */     return this.code;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String key() {
/* 493 */     return this.key;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tx, int ty) {
/* 498 */     return (SETT.IN_BOUNDS(tx, ty) && is(tx + ty * SETT.TWIDTH));
/*     */   }
/*     */   
/*     */   public boolean wantsFloorUnderneath(int tx, int ty) {
/* 502 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\Terrain$TerrainTile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */