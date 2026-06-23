/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import init.sprite.game.SheetPair;
/*     */ import init.sprite.game.SheetType;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Medium
/*     */   extends TForest.Tree
/*     */ {
/*     */   private Medium(Terrain shared) {
/* 330 */     super(shared, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean tryPlace(int tx, int ty) {
/* 335 */     if (is(tx, ty)) {
/* 336 */       int i = this.shared.data.get(tx, ty) & 0x3;
/* 337 */       if (tryVar(tx, ty, i) >= 0) {
/* 338 */         return true;
/*     */       }
/*     */     } 
/* 341 */     for (int var = 0; var < 4; var++) {
/* 342 */       int i = tryVar(tx, ty, var);
/* 343 */       if (i >= 0) {
/* 344 */         super.placeRaw(tx, ty);
/* 345 */         this.shared.data.set(tx, ty, i);
/* 346 */         return true;
/*     */       } 
/*     */     } 
/* 349 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private int tryVar(int tx, int ty, int var) {
/* 354 */     int rx = var % 2;
/* 355 */     int ry = var / 2;
/*     */     
/* 357 */     for (int ov = 0; ov < 4; ov++) {
/*     */       
/* 359 */       if (ov != var) {
/*     */ 
/*     */         
/* 362 */         int dx = ov % 2;
/* 363 */         int dy = ov / 2;
/* 364 */         dx -= rx;
/* 365 */         dy -= ry;
/* 366 */         int x = tx + dx;
/* 367 */         int y = ty + dy;
/*     */         
/* 369 */         if (!SETT.IN_BOUNDS(x, y))
/* 370 */           return -1; 
/* 371 */         if (!this.shared.TREES.SMALL.is(x, y) && (!is(x, y) || (this.shared.data.get(x, y) & 0x3) != ov)) {
/* 372 */           return -1;
/*     */         }
/*     */       } 
/*     */     } 
/* 376 */     return var;
/*     */   }
/*     */ 
/*     */   
/*     */   public void placeRaw(int tx, int ty) {
/* 381 */     if (this.shared.NADA.is(tx + 1, ty))
/* 382 */       this.shared.TREES.SMALL.placeRaw(tx + 1, ty); 
/* 383 */     if (this.shared.NADA.is(tx, ty + 1))
/* 384 */       this.shared.TREES.SMALL.placeRaw(tx, ty + 1); 
/* 385 */     if (this.shared.NADA.is(tx + 1, ty + 1))
/* 386 */       this.shared.TREES.SMALL.placeRaw(tx + 1, ty + 1); 
/* 387 */     placeFixed(tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 393 */     data &= 0xFF;
/* 394 */     SheetType.cXxX type = SheetType.s2x2;
/* 395 */     SheetPair sheet = TForest.this.sprites.medium;
/*     */     
/* 397 */     int dx = type.dx(data);
/* 398 */     int dy = type.dy(data);
/* 399 */     int ran = i.ranGet(-dx, -dy);
/*     */     
/* 401 */     int tile = type.tile(sheet, data, ran, 0);
/* 402 */     sheet.s.render(sheet.d, i.x(), i.y(), i, r, tile, ran, 0.0D);
/* 403 */     s.setHeight(2).setDistance2Ground(5.0D);
/* 404 */     sheet.s.renderShadow(sheet.d, i.x(), i.y(), i, s, tile, ran);
/* 405 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 410 */     (SETT.TERRAIN()).BUSH.render(i, r, s, i.x(), i.y(), i.ran());
/* 411 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPlacable(int tx, int ty) {
/* 416 */     return (SETT.IN_BOUNDS(tx, ty) && SETT.IN_BOUNDS(tx + 1, ty + 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR miniColorPimped(ColorImp c, int x, int y, boolean northern, boolean southern) {
/* 421 */     int data = this.shared.data.get(x, y) & 0xFF;
/* 422 */     SheetType.cXxX type = SheetType.s2x2;
/* 423 */     c.shadeSelf(TForest.this.mshades[x - type.dx(data) + y - type.dy(data) & TForest.this.mshades.length - 1]);
/* 424 */     if (type.dy(data) + type.dx(data) == 0)
/* 425 */       c.shadeSelf(1.2D); 
/* 426 */     if (type.dy(data) * type.dx(data) == 1)
/* 427 */       c.shadeSelf(0.8D); 
/* 428 */     return (COLOR)c;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TForest$Medium.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */