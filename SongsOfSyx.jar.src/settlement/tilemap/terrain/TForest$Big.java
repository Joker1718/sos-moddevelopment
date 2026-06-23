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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Big
/*     */   extends TForest.Tree
/*     */ {
/*     */   private Big(Terrain shared) {
/* 437 */     super(shared, 2);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean tryPlace(int tx, int ty) {
/* 442 */     if (is(tx, ty)) {
/* 443 */       int i = this.shared.data.get(tx, ty) & 0xF;
/* 444 */       if (tryVar(tx, ty, i) >= 0) {
/* 445 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 449 */     for (int var = 0; var < 9; var++) {
/* 450 */       int i = tryVar(tx, ty, var);
/* 451 */       if (i >= 0) {
/* 452 */         super.placeRaw(tx, ty);
/* 453 */         this.shared.data.set(tx, ty, i);
/* 454 */         return true;
/*     */       } 
/*     */     } 
/* 457 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void placeRaw(int tx, int ty) {
/* 463 */     this.shared.TREES.SMALL.placeRaw(tx + 1, ty);
/* 464 */     this.shared.TREES.SMALL.placeRaw(tx + 2, ty);
/* 465 */     this.shared.TREES.SMALL.placeRaw(tx, ty + 1);
/* 466 */     this.shared.TREES.SMALL.placeRaw(tx + 1, ty + 1);
/* 467 */     this.shared.TREES.SMALL.placeRaw(tx + 2, ty + 1);
/* 468 */     this.shared.TREES.SMALL.placeRaw(tx, ty + 2);
/* 469 */     this.shared.TREES.SMALL.placeRaw(tx + 1, ty + 2);
/* 470 */     this.shared.TREES.SMALL.placeRaw(tx + 2, ty + 2);
/* 471 */     placeFixed(tx, ty);
/*     */   }
/*     */   
/*     */   private int tryVar(int tx, int ty, int var) {
/* 475 */     int rx = var % 3;
/* 476 */     int ry = var / 3;
/*     */     
/* 478 */     for (int ov = 0; ov < 9; ov++) {
/*     */       
/* 480 */       if (ov != var) {
/*     */ 
/*     */         
/* 483 */         int dx = ov % 3;
/* 484 */         int dy = ov / 3;
/* 485 */         dx -= rx;
/* 486 */         dy -= ry;
/* 487 */         int x = tx + dx;
/* 488 */         int y = ty + dy;
/*     */         
/* 490 */         if (!SETT.IN_BOUNDS(x, y))
/* 491 */           return -1; 
/* 492 */         if (!this.shared.TREES.SMALL.is(x, y))
/*     */         {
/* 494 */           if (!this.shared.TREES.MEDIUM.is(x, y))
/*     */           {
/* 496 */             if (!is(x, y) || (this.shared.data.get(x, y) & 0xF) != ov)
/*     */             {
/*     */               
/* 499 */               return -1; }  }  } 
/*     */       } 
/*     */     } 
/* 502 */     return var;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPlacable(int tx, int ty) {
/* 507 */     return (SETT.IN_BOUNDS(tx, ty) && SETT.IN_BOUNDS(tx + 2, ty + 2));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 512 */     SheetType.cXxX type = SheetType.s3x3;
/* 513 */     SheetPair sheet = TForest.this.sprites.big;
/* 514 */     data &= 0xFF;
/* 515 */     int dx = type.dx(data);
/* 516 */     int dy = type.dy(data);
/* 517 */     int ran = i.ranGet(-dx, -dy);
/*     */     
/* 519 */     int tile = type.tile(sheet.s, sheet.d, data, ran, 0);
/* 520 */     sheet.s.render(sheet.d, i.x(), i.y(), i, r, tile, ran, 0.0D);
/* 521 */     s.setHeight(8).setDistance2Ground(20.0D);
/* 522 */     sheet.s.renderShadow(sheet.d, i.x(), i.y(), i, s, tile, ran);
/* 523 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 528 */     (SETT.TERRAIN()).BUSH.render(i, r, s, i.x(), i.y(), i.ran());
/* 529 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR miniColorPimped(ColorImp c, int x, int y, boolean northern, boolean southern) {
/* 534 */     int data = this.shared.data.get(x, y) & 0xFF;
/* 535 */     SheetType.cXxX type = SheetType.s3x3;
/* 536 */     c.shadeSelf(TForest.this.mshades[x - type.dx(data) + y - type.dy(data) & TForest.this.mshades.length - 1]);
/* 537 */     double s = 1.0D;
/* 538 */     if (type.dx(data) == 0)
/* 539 */       s = 1.4D; 
/* 540 */     if (type.dy(data) == 2)
/* 541 */       s = 0.8D; 
/* 542 */     if (type.dx(data) == 2)
/* 543 */       s = 0.8D; 
/* 544 */     if (type.dy(data) == 0)
/* 545 */       s = 1.4D; 
/* 546 */     c.shadeSelf(s);
/* 547 */     return (COLOR)c;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TForest$Big.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */