/*     */ package world.map.terrain;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WGROUND
/*     */   extends PlacableMulti
/*     */ {
/*     */   protected final double moisture;
/*     */   protected final int code;
/*     */   private final int bg;
/*     */   private final COLOR col;
/*     */   private final COLOR[] cdeva;
/* 319 */   private final ColorImp colImp = new ColorImp();
/*     */   
/*     */   private final TILE_SHEET over;
/*     */   
/*     */   protected WGROUND(LISTE<WGROUND> all, String name, double moisture, int bg, COLOR col, TILE_SHEET sheet, COLOR deva) {
/* 324 */     super(name);
/* 325 */     this.code = all.add(this);
/* 326 */     this.moisture = moisture;
/* 327 */     this.bg = bg;
/* 328 */     this.col = col;
/* 329 */     this.cdeva = new COLOR[8];
/* 330 */     for (int i = 0; i < this.cdeva.length; i++) {
/* 331 */       this.cdeva[i] = (COLOR)(new ColorImp()).interpolate(col, deva, (i + 1.0D) / this.cdeva.length);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 336 */     this.over = sheet;
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
/*     */ 
/*     */   
/*     */   boolean place(int tx, int ty) {
/* 351 */     int res = 0;
/*     */     
/* 353 */     if (this.bg < WorldGround.this.PATCHED_GRASS.code) {
/* 354 */       for (int j = 0; j < DIR.ORTHO.size(); j++) {
/* 355 */         DIR d = (DIR)DIR.ORTHO.get(j);
/* 356 */         if (WORLD.IN_BOUNDS(tx, ty, d)) {
/*     */ 
/*     */           
/* 359 */           WGROUND neigh = (WGROUND)WorldGround.this.getter.get(tx + d.x(), ty + d.y());
/*     */           
/* 361 */           if (neigh.code > this.bg) {
/* 362 */             ((WGROUND)WorldGround.this.all.get(this.bg)).place(tx, ty);
/* 363 */             return true;
/*     */           } 
/*     */         } 
/*     */       } 
/* 367 */     } else if (this.bg > WorldGround.this.PATCHED_GRASS.code) {
/*     */       
/* 369 */       for (int j = 0; j < DIR.ORTHO.size(); j++) {
/* 370 */         DIR d = (DIR)DIR.ORTHO.get(j);
/* 371 */         if (WORLD.IN_BOUNDS(tx, ty, d)) {
/*     */ 
/*     */           
/* 374 */           WGROUND neigh = (WGROUND)WorldGround.this.getter.get(tx + d.x(), ty + d.y());
/*     */           
/* 376 */           if (neigh.code < this.bg) {
/* 377 */             ((WGROUND)WorldGround.this.all.get(this.bg)).place(tx, ty);
/* 378 */             return true;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 384 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 385 */       DIR d = (DIR)DIR.ORTHO.get(i);
/* 386 */       if (!WORLD.IN_BOUNDS(tx, ty, d)) {
/* 387 */         res |= d.mask();
/*     */       } else {
/*     */         
/* 390 */         WGROUND neigh = (WGROUND)WorldGround.this.getter.get(tx + d.x(), ty + d.y());
/*     */         
/* 392 */         if (neigh.bg == this.code || neigh.code == this.code) {
/* 393 */           res |= d.mask();
/*     */         }
/*     */       } 
/*     */     } 
/* 397 */     WorldGround.this.set(tx, ty, this.code, res);
/*     */     
/* 399 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 404 */     if (!WORLD.IN_BOUNDS(tx, ty))
/*     */       return; 
/* 406 */     WGROUND old = (WGROUND)WorldGround.this.getter.get(tx, ty);
/* 407 */     place(tx, ty);
/* 408 */     if (old != WorldGround.this.getter.get(tx, ty)) {
/* 409 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 410 */         DIR d = (DIR)DIR.ORTHO.get(i);
/* 411 */         if (WORLD.IN_BOUNDS(tx, ty, d)) {
/* 412 */           ((WGROUND)WorldGround.this.getter.get(tx + d.x(), ty + d.y())).place(tx + d.x(), ty + d.y(), area, type);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   final void placeRaw(int tx, int ty) {
/* 419 */     WorldGround.this.set(tx, ty, this.code, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 425 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 430 */     return (SPRITE)(SPRITES.icons()).m.cancel;
/*     */   }
/*     */   
/*     */   public boolean is(int tx, int ty) {
/* 434 */     return (WORLD.IN_BOUNDS(tx, ty) && this.code == WorldGround.this.ids.get(tx + ty * WORLD.TWIDTH()));
/*     */   }
/*     */ 
/*     */   
/*     */   public double moisture() {
/* 439 */     return this.moisture;
/*     */   }
/*     */   
/*     */   public WGROUND fallback() {
/* 443 */     return WorldGround.this.PATCHED_GRASS;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldGround$WGROUND.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */