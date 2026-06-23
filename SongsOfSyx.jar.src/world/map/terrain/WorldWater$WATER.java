/*     */ package world.map.terrain;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import util.rendering.RenderData;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class WATER
/*     */   extends PlacableMulti
/*     */   implements MAP_BOOLEAN
/*     */ {
/*     */   protected final int code;
/*     */   
/*     */   protected WATER(String name) {
/* 248 */     super(name);
/* 249 */     this.code = paramWorldWater.all.add(this);
/*     */   }
/*     */   
/*     */   abstract boolean coversCompleatly(int paramInt);
/*     */   
/*     */   void placeRaw(int tx, int ty) {
/* 255 */     if (WORLD.IN_BOUNDS(tx, ty)) {
/* 256 */       WorldWater.this.tiles.set(tx + ty * WORLD.TWIDTH(), this.code);
/*     */     }
/*     */   }
/*     */   
/*     */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 261 */     if (WORLD.IN_BOUNDS(tx, ty)) {
/* 262 */       int old = WorldWater.this.tiles.get(tx + ty * WORLD.TWIDTH());
/* 263 */       pplace(tx, ty);
/* 264 */       if (old != WorldWater.this.tiles.get(tx + ty * WORLD.TWIDTH())) {
/* 265 */         for (int i = 0; i < DIR.ALL.size(); i++) {
/* 266 */           DIR d = (DIR)DIR.ALL.get(i);
/* 267 */           WorldWater.this.get(tx + d.x(), ty + d.y()).pplace(tx + d.x(), ty + d.y());
/* 268 */           WORLD.changeTile(tx, ty);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   abstract void pplace(int paramInt1, int paramInt2);
/*     */ 
/*     */   
/*     */   final void place(int tx, int ty, DIR d) {
/* 279 */     pplace(tx + d.x(), ty + d.y());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(int tile) {
/* 284 */     return (WorldWater.this.all.get(WorldWater.this.tiles.get(tile)) == this);
/*     */   }
/*     */   abstract boolean render(SPRITE_RENDERER paramSPRITE_RENDERER, int paramInt, RenderData.RenderIterator paramRenderIterator);
/*     */   
/*     */   public boolean is(int tx, int ty) {
/* 289 */     if (!WORLD.IN_BOUNDS(tx, ty))
/* 290 */       return false; 
/* 291 */     return is(tx + ty * WORLD.TWIDTH());
/*     */   }
/*     */ 
/*     */   
/*     */   boolean renderShore(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) {
/* 296 */     return false;
/*     */   }
/*     */   boolean rend2erMid(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) {
/* 299 */     return false;
/*     */   }
/*     */   
/*     */   abstract boolean isFertile();
/*     */   
/*     */   public PLACABLE getUndo() {
/* 305 */     return (PLACABLE)WorldWater.this.NOTHING;
/*     */   }
/*     */   
/*     */   protected abstract boolean canTravelTo(int paramInt, DIR paramDIR);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldWater$WATER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */