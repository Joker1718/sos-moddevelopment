/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */ public abstract class Tile
/*     */   extends Terrain.TerrainTile
/*     */   implements TerrainDiagonal.Diagonalizer
/*     */ {
/*     */   public final TFortification fort;
/*     */   
/*     */   Tile(String key, Terrain shared, CharSequence name, SPRITE icon, COLOR miniC, TFortification tFortification) {
/* 259 */     super(key, shared, name, icon, miniC);
/* 260 */     this.fort = tFortification;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean place(int tx, int ty) {
/* 266 */     boolean dia = (is(tx, ty) && (this.shared.data.get(tx, ty) & 0x1000) != 0);
/* 267 */     if (this.shared.get(tx, ty) == this.fort.tile || this.shared.get(tx, ty) == this.fort.broken) {
/* 268 */       dia |= getDia(tx, ty);
/*     */     }
/* 270 */     boolean full = (is(tx, ty) && (this.shared.data.get(tx, ty) & 0xF) == 15);
/*     */     
/* 272 */     placeRaw(tx, ty);
/* 273 */     int res = 0;
/* 274 */     for (DIR d : DIR.ORTHO) {
/* 275 */       if (j(tx, ty, d)) {
/* 276 */         res |= d.mask();
/*     */       }
/*     */     } 
/* 279 */     int cor = 0;
/* 280 */     for (DIR d : DIR.NORTHO) {
/* 281 */       if (!j(tx, ty, d) && j(tx, ty, d.next(1)) && j(tx, ty, d.next(-1))) {
/* 282 */         cor |= d.mask();
/*     */       }
/*     */     } 
/* 285 */     res |= cor << 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 293 */     if (res != 0 && SETT.IN_BOUNDS(tx, ty, DIR.N)) {
/* 294 */       Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(tx, ty, DIR.N);
/* 295 */       if (!(t instanceof Tile) && t.wallIsWally() && (res & DIR.N.mask()) != 0) {
/* 296 */         res |= 0x100;
/*     */       }
/*     */     } 
/* 299 */     if (res != 0 && SETT.IN_BOUNDS(tx, ty, DIR.W)) {
/* 300 */       Terrain.TerrainTile t = (Terrain.TerrainTile)this.shared.get(tx, ty, DIR.W);
/* 301 */       if (!(t instanceof Tile) && t.wallIsWally() && (res & DIR.W.mask()) != 0) {
/* 302 */         res |= 0x200;
/*     */       }
/*     */     } 
/*     */     
/* 306 */     this.shared.data.set(tx, ty, res);
/* 307 */     setDia(tx, ty, dia);
/* 308 */     return full ^ (((this.shared.data.get(tx, ty) & 0xF) == 15));
/*     */   }
/*     */ 
/*     */   
/*     */   boolean j(int tx, int ty, DIR d) {
/* 313 */     return !(!this.fort.tile.is(tx, ty, d) && !this.fort.broken.is(tx, ty, d) && !(SETT.TERRAIN()).FSTAIRS.is(tx, ty, d));
/*     */   }
/*     */ 
/*     */   
/*     */   boolean wallJoiner() {
/* 318 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean wallIsWally() {
/* 323 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMassiveWall() {
/* 328 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 334 */     return false;
/*     */   }
/*     */   
/*     */   void renderEdges(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 338 */     int cor = data >> 4 & 0xF;
/* 339 */     if ((data & 0x100) != 0) {
/* 340 */       if ((data & DIR.W.mask()) == 0 || (cor & DIR.NW.mask()) != 0) {
/* 341 */         (SETT.TERRAIN()).wall_merge.render(r, 0, i.x(), i.y() - 4);
/*     */       } else {
/* 343 */         (SETT.TERRAIN()).wall_merge.render(r, 2, i.x(), i.y() - 4);
/* 344 */       }  if ((data & DIR.E.mask()) == 0 || (cor & DIR.NE.mask()) != 0) {
/* 345 */         (SETT.TERRAIN()).wall_merge.render(r, 1, i.x(), i.y() - 4);
/*     */       } else {
/* 347 */         (SETT.TERRAIN()).wall_merge.render(r, 3, i.x(), i.y() - 4);
/*     */       } 
/* 349 */     }  if ((data & 0x200) != 0) {
/* 350 */       if ((data & DIR.N.mask()) == 0 || (cor & DIR.NW.mask()) != 0) {
/* 351 */         (SETT.TERRAIN()).wall_merge.render(r, 5, i.x() - 4, i.y());
/*     */       } else {
/* 353 */         (SETT.TERRAIN()).wall_merge.render(r, 7, i.x() - 4, i.y());
/* 354 */       }  if ((data & DIR.S.mask()) == 0 || (cor & DIR.SW.mask()) != 0) {
/* 355 */         (SETT.TERRAIN()).wall_merge.render(r, 4, i.x() - 4, i.y());
/*     */       } else {
/* 357 */         (SETT.TERRAIN()).wall_merge.render(r, 6, i.x() - 4, i.y());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setDia(int x, int y, boolean dia) {
/* 363 */     if (!is(x, y))
/*     */       return; 
/* 365 */     int data = this.shared.data.get(x, y);
/* 366 */     if (dia) {
/* 367 */       data |= 0x1000;
/*     */     } else {
/* 369 */       data &= 0xFFFFEFFF;
/* 370 */     }  this.shared.data.set(x, y, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getDia(int tx, int ty) {
/* 375 */     if (!is(tx, ty))
/* 376 */       return false; 
/* 377 */     return ((this.shared.data.get(tx, ty) & 0x1000) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPlacable(int tx, int ty) {
/* 382 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int miniDepth() {
/* 387 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean wantsFloorUnderneath(int tx, int ty) {
/* 392 */     return ((this.shared.data.get(tx, ty) & 0xF) != 15);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TFortification$Tile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */