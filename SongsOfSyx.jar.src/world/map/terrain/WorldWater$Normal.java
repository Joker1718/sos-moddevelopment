/*     */ package world.map.terrain;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import util.rendering.RenderData;
/*     */ import view.tool.PLACER_TYPE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Normal
/*     */   extends WorldWater.WATER
/*     */ {
/*     */   private final WorldWater.OpenSet set;
/*     */   private final boolean fertile;
/*     */   
/*     */   private Normal(String name, WorldWater.OpenSet set, boolean fertile) {
/* 447 */     super(name);
/* 448 */     this.set = set;
/* 449 */     this.fertile = fertile;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean coversCompleatly(int tile) {
/* 455 */     return (WorldWater.this.dataGet(tile) == 15);
/*     */   }
/*     */ 
/*     */   
/*     */   void pplace(int tx, int ty) {
/* 460 */     placeRaw(tx, ty);
/* 461 */     int res = 0;
/* 462 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 463 */       DIR d = (DIR)DIR.ORTHO.get(i);
/* 464 */       if (joins(tx, ty, d)) {
/* 465 */         res |= d.mask();
/*     */       }
/*     */     } 
/* 468 */     int edge = 0;
/* 469 */     for (int j = 0; j < DIR.NORTHO.size(); j++) {
/* 470 */       DIR d = (DIR)DIR.NORTHO.get(j);
/* 471 */       if (!joins(tx, ty, d) && joins(tx, ty, d.next(-1)) && joins(tx, ty, d.next(1))) {
/* 472 */         edge |= d.mask();
/*     */       }
/*     */     } 
/* 475 */     if (res == 15) {
/* 476 */       WORLD.MOUNTAIN().pClear(tx, ty);
/* 477 */       (WORLD.FOREST()).amount.set(tx, ty, 0.0D);
/*     */     } 
/* 479 */     res |= edge << 4;
/* 480 */     WorldWater.this.dataSet(tx, ty, res);
/*     */   }
/*     */   
/*     */   private boolean joins(int tx, int ty, DIR d) {
/* 484 */     return !(WORLD.IN_BOUNDS(tx, ty, d) && !is(tx, ty, d) && !this.set.deep.is(tx, ty, d) && !this.set.delta.is(tx, ty, d));
/*     */   }
/*     */ 
/*     */   
/*     */   boolean render(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) {
/* 489 */     int d = data & 0xF;
/* 490 */     int c = data >> 4 & 0xF;
/* 491 */     this.set.col.bind();
/* 492 */     WorldWater.this.sprites.render(r, it, d, c);
/* 493 */     return (data == 15);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean renderShore(SPRITE_RENDERER r, int data, RenderData.RenderIterator it) {
/* 498 */     this.set.cShore.bind();
/* 499 */     int d = data & 0xF;
/* 500 */     int c = data >> 4 & 0xF;
/* 501 */     WorldWater.this.sprites.renderBackground(r, it, d, c);
/* 502 */     return (data == 15);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 507 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean isFertile() {
/* 512 */     return this.fertile;
/*     */   }
/*     */   
/*     */   public void renderIcon(SPRITE_RENDERER r, int x, int y, int dim) {
/* 516 */     this.set.cShore.bind();
/* 517 */     WorldWater.this.sprites.bgSingles.render(r, 0, x, x + dim, y, y + dim);
/* 518 */     WorldWater.this.sprites.bgSingles.render(r, 0, x, x + dim, y, y + dim);
/* 519 */     this.set.cWater.bind();
/* 520 */     WorldWater.this.sprites.sheetSingles.render(r, 0, x, x + dim, y, y + dim);
/* 521 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean canTravelTo(int data, DIR to) {
/* 527 */     if (to.isOrtho())
/* 528 */       return ((data & to.mask()) != 0); 
/* 529 */     data >>>= 4;
/* 530 */     return ((data & to.mask()) == 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldWater$Normal.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */