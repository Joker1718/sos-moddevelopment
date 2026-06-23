/*     */ package settlement.room.main.copy;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.construction.ConstructionInit;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.placement.PLACEMENT;
/*     */ import settlement.room.main.placement.UtilWallPlacability;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.colors.GCOLOR;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PlacableFixedImp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends PlacableFixedImp
/*     */ {
/*     */   private final Coo cTmp;
/*     */   
/*     */   null(CharSequence $anonymous0, int $anonymous1, int $anonymous2) {
/* 253 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */     
/* 255 */     this.cTmp = new Coo();
/*     */   }
/*     */   private boolean update() {
/* 258 */     Room r = (SETT.ROOMS()).map.get(Copier.this.room.mX(), Copier.this.room.mY());
/*     */     
/* 260 */     if (r == null)
/* 261 */       return false; 
/* 262 */     if (r.constructor() == null)
/* 263 */       return false; 
/* 264 */     if (Copier.this.structure == null) {
/* 265 */       if (r.constructor().mustBeIndoors()) {
/* 266 */         Copier.this.structure = ConstructionInit.findStructure(Copier.this.room.mX(), Copier.this.room.mY());
/*     */       } else {
/* 268 */         Copier.this.structure = null;
/*     */       } 
/*     */     }
/* 271 */     Copier.wrap.done();
/* 272 */     Copier.this.room = Copier.wrap.init(r, Copier.this.room.mX(), Copier.this.room.mY());
/*     */     
/* 274 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, int rx, int ry) {
/* 282 */     if (rx != 0 || ry != 0) {
/*     */       return;
/*     */     }
/*     */     
/* 286 */     update();
/*     */     
/* 288 */     Furnisher furnisher = Copier.this.swap.current().constructor();
/*     */     
/* 290 */     if (furnisher.mustBeIndoors() && Copier.this.w)
/*     */     {
/* 292 */       for (int dy = 0; dy < height(); dy++) {
/* 293 */         for (int dx = 0; dx < width(); dx++) {
/* 294 */           COORDINATE c = getSourceTile(dx, dy);
/* 295 */           if (Copier.this.room.is(c)) {
/* 296 */             for (int i = 0; i < DIR.ALL.size(); i++) {
/* 297 */               DIR d = (DIR)DIR.ALL.get(i);
/* 298 */               c = getSourceTile(dx + d.x(), dy + d.y());
/* 299 */               if (!Copier.this.room.is(c)) {
/*     */                 
/* 301 */                 int x = tx + dx + d.x();
/* 302 */                 int j = ty + dy + d.y();
/*     */                 
/* 304 */                 if (UtilWallPlacability.wallisReal.is(c)) {
/* 305 */                   if (UtilWallPlacability.wallShouldBuild.is(x, j)) {
/* 306 */                     UtilWallPlacability.wallBuild(x, j, Copier.this.structure);
/*     */                   }
/* 308 */                 } else if (UtilWallPlacability.openingIsReal.is(c) && 
/* 309 */                   UtilWallPlacability.openingShouldBuild.is(x, j)) {
/* 310 */                   UtilWallPlacability.openingBuild(x, j, Copier.this.structure);
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 348 */     TmpArea tmp = SETT.ROOMS().tmpArea(this);
/*     */ 
/*     */     
/* 351 */     int w = width();
/* 352 */     int h = height(); int y;
/* 353 */     for (y = 0; y < h; y++) {
/* 354 */       for (int x = 0; x < w; x++) {
/* 355 */         COORDINATE c = getSourceTile(x, y);
/* 356 */         if (Copier.this.room.is(c))
/*     */         {
/* 358 */           tmp.set(tx + x, ty + y);
/*     */         }
/*     */       } 
/*     */     } 
/* 362 */     for (y = 0; y < h; y++) {
/* 363 */       for (int x = 0; x < w; x++) {
/*     */         
/* 365 */         COORDINATE c = getSourceTile(x, y);
/* 366 */         int sx = c.x();
/* 367 */         int sy = c.y();
/* 368 */         if (Copier.this.room.is(sx, sy)) {
/*     */           
/* 370 */           FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(sx, sy);
/* 371 */           if ((SETT.ROOMS()).fData.isMaster.is(sx, sy)) {
/*     */ 
/*     */             
/* 374 */             c = getOrigionalDelta(sx, sy);
/* 375 */             int x1 = c.x() + tx;
/* 376 */             int y1 = c.y() + ty;
/*     */             
/* 378 */             c = getSourceItemOff(it, it.firstX(), it.firstY());
/* 379 */             x1 -= c.x();
/* 380 */             y1 -= c.y();
/*     */             
/* 382 */             int rot = it.rotation + rot() % it.group.rotations();
/* 383 */             rot %= it.group.rotations();
/* 384 */             it = it.group.item(it.variation(), rot);
/*     */             
/* 386 */             (SETT.ROOMS()).fData.itemSet(x1, y1, it, tmp.room());
/*     */           } 
/*     */         } 
/*     */       } 
/* 390 */     }  Room r = (SETT.ROOMS()).map.get(Copier.this.room.mX(), Copier.this.room.mY());
/* 391 */     ConstructionInit init = new ConstructionInit(r.upgrade(Copier.this.room.mX(), Copier.this.room.mY()), furnisher, Copier.this.structure, 0, r.makeState(Copier.this.room.mX(), Copier.this.room.mY(), false));
/*     */     
/* 393 */     (SETT.ROOMS()).construction.createClean(tmp, init);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence placable(int tx, int ty, int rx, int ry) {
/* 401 */     if (!update()) {
/* 402 */       (VIEW.s()).tools.place(null);
/* 403 */       return E;
/*     */     } 
/*     */     
/* 406 */     COORDINATE c = getSourceTile(rx, ry);
/* 407 */     if (!Copier.this.room.is(c)) {
/* 408 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 413 */     Furnisher furnisher = Copier.this.swap.current().constructor();
/* 414 */     CharSequence s = PLACEMENT.placable(tx, ty, furnisher.blue(), true);
/* 415 */     if (s != null) {
/* 416 */       return s;
/*     */     }
/*     */     
/* 419 */     return furnisher.placable(tx, ty, (FurnisherItem)(SETT.ROOMS()).fData.item.get(c), (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(c));
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateRegardless(GameWindow window) {
/* 424 */     if (Copier.this.swap.current().constructor().overlay() != null && (SETT.ROOMS()).placement.placer.showOverlay.is()) {
/* 425 */       Copier.this.swap.current().constructor().overlay().add();
/*     */     }
/* 427 */     if (Copier.this.swap.current().constructor().isHeavy() && (SETT.ROOMS()).placement.placer.showFoundation.is()) {
/* 428 */       (SETT.OVERLAY()).FOUNDATION.add();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int width() {
/* 434 */     int wi = ((rot() & 0x1) == 1) ? Copier.this.room.body().height() : Copier.this.room.body().width();
/* 435 */     return wi;
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 440 */     int h = ((rot() & 0x1) == 0) ? Copier.this.room.body().height() : Copier.this.room.body().width();
/* 441 */     return h;
/*     */   }
/*     */   
/*     */   private COORDINATE getSourceTile(int rx, int ry) {
/* 445 */     switch (rot()) {
/*     */       case 0:
/* 447 */         this.cTmp.set((Copier.this.room.body().x1() + rx), (Copier.this.room.body().y1() + ry));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 464 */         return (COORDINATE)this.cTmp;case 1: this.cTmp.ySet((Copier.this.room.body().y2() - rx - 1)); this.cTmp.xSet((Copier.this.room.body().x1() + ry)); return (COORDINATE)this.cTmp;case 2: this.cTmp.ySet((Copier.this.room.body().y2() - ry - 1)); this.cTmp.xSet((Copier.this.room.body().x2() - rx - 1)); return (COORDINATE)this.cTmp;case 3: this.cTmp.ySet((Copier.this.room.body().y1() + rx)); this.cTmp.xSet((Copier.this.room.body().x2() - ry - 1)); return (COORDINATE)this.cTmp;
/*     */     } 
/*     */     throw new RuntimeException();
/*     */   } private COORDINATE getOrigionalDelta(int rx, int ry) {
/* 468 */     int dx = rx - Copier.this.room.body().x1();
/* 469 */     int dy = ry - Copier.this.room.body().y1();
/* 470 */     switch (rot()) {
/*     */       case 0:
/* 472 */         this.cTmp.set(dx, dy);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 489 */         return (COORDINATE)this.cTmp;case 1: this.cTmp.ySet(dx); this.cTmp.xSet((Copier.this.room.body().height() - dy - 1)); return (COORDINATE)this.cTmp;case 2: this.cTmp.ySet((Copier.this.room.body().height() - dy - 1)); this.cTmp.xSet((Copier.this.room.body().width() - dx - 1)); return (COORDINATE)this.cTmp;case 3: this.cTmp.ySet((Copier.this.room.body().width() - dx - 1)); this.cTmp.xSet(dy); return (COORDINATE)this.cTmp;
/*     */     } 
/*     */     throw new RuntimeException();
/*     */   }
/*     */   
/*     */   private COORDINATE getSourceItemOff(FurnisherItem i, int rx, int ry) {
/* 495 */     switch (rot()) {
/*     */       case 0:
/* 497 */         this.cTmp.set(rx, ry);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 514 */         return (COORDINATE)this.cTmp;case 1: this.cTmp.ySet(rx); this.cTmp.xSet((i.height() - ry - 1)); return (COORDINATE)this.cTmp;case 2: this.cTmp.ySet((i.height() - ry - 1)); this.cTmp.xSet((i.width() - rx - 1)); return (COORDINATE)this.cTmp;case 3: this.cTmp.ySet((i.width() - rx - 1)); this.cTmp.xSet(ry); return (COORDINATE)this.cTmp;
/*     */     } 
/*     */     throw new RuntimeException();
/*     */   }
/*     */   public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, int rx, int ry, boolean isPlacable, boolean areaIsPlacable) {
/* 519 */     COORDINATE c = getSourceTile(rx, ry);
/* 520 */     if (!Copier.this.room.is(c)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 526 */     if (isPlacable && areaIsPlacable) {
/* 527 */       if (!(SETT.JOBS()).planMode.is()) {
/* 528 */         (GCOLOR.MAP()).JOB_ACTIVE.bind();
/*     */       } else {
/* 530 */         (GCOLOR.MAP()).JOB_DORMANT.bind();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 537 */     FurnisherItemTile tile = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(c);
/*     */     
/* 539 */     if (tile == null || tile.sprite() == null || !tile.isBlocker()) {
/* 540 */       (SPRITES.cons()).BIG.dashed.render(r, mask, x, y);
/*     */     } else {
/* 542 */       (SPRITES.cons()).BIG.filled.render(r, mask, x, y);
/*     */     } 
/*     */     
/* 545 */     Furnisher furnisher = Copier.this.swap.current().constructor();
/* 546 */     if (furnisher.mustBeIndoors() && Copier.this.w) {
/* 547 */       for (int i = 0; i < DIR.NORTHO.size(); i++) {
/* 548 */         DIR d = (DIR)DIR.NORTHO.get(i);
/* 549 */         c = getSourceTile(rx + d.x(), ry + d.y());
/* 550 */         if (!Copier.this.room.is(c)) {
/* 551 */           if (UtilWallPlacability.wallisReal.is(c) && UtilWallPlacability.wallShouldBuild.is(tx + d.x(), ty + d.y())) {
/* 552 */             (SPRITES.cons()).BIG.filled.render(r, 0, x + d.x() * 64, y + d.y() * 64);
/* 553 */           } else if (UtilWallPlacability.openingIsReal.is(c) && UtilWallPlacability.openingShouldBuild.is(tx + d.x(), ty + d.y())) {
/* 554 */             (SPRITES.cons()).BIG.dashed_hollow.render(r, 0, x + d.x() * 64, y + d.y() * 64);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/* 559 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/* 564 */     Furnisher furnisher = Copier.this.swap.current().constructor();
/* 565 */     Copier.this.butts.clearSloppy();
/* 566 */     if (furnisher.mustBeIndoors()) {
/* 567 */       Copier.this.butts.add((Iterable)Copier.this.walls);
/*     */     }
/* 569 */     if (furnisher.overlay() != null)
/* 570 */       Copier.this.butts.add(Copier.this.bOverlay); 
/* 571 */     if (furnisher.isHeavy())
/* 572 */       Copier.this.butts.add(Copier.this.bFoundation); 
/* 573 */     return Copier.this.swap.wrap((LIST<CLICKABLE>)Copier.this.butts);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/* 578 */     Furnisher furnisher = Copier.this.swap.current().constructor();
/* 579 */     return (furnisher.blue()).info.name;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\copy\Copier$7.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */