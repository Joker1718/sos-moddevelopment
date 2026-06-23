/*     */ package settlement.room.home.house;
/*     */ 
/*     */ import init.race.home.RaceHomeClass;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.game.SheetPair;
/*     */ import init.sprite.game.SheetType;
/*     */ import init.sprite.game.Sheets;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
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
/*     */ class null
/*     */   extends RoomSprite.Dummy
/*     */ {
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 334 */     HomeInstance h = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(it.tile());
/* 335 */     if (h != null) {
/* 336 */       s.setSoft();
/* 337 */       s.setDistance2Ground(0.0D).setHeight(0);
/* 338 */       COLOR.BLACK.render((SPRITE_RENDERER)s, it.x(), it.x() + 64, it.y(), it.y() + 64);
/* 339 */       s.setPrev();
/*     */ 
/*     */       
/* 342 */       if (h.occupants() > 0) {
/* 343 */         Sprite sp = h.sprite(it.tx(), it.ty());
/* 344 */         if (sp != null) {
/* 345 */           sp.house = h;
/* 346 */           sp.renderAbove(r, s, data, it, degrade);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch shadowBatch, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 355 */     HomeInstance h = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(it.tile());
/* 356 */     if (h != null) {
/* 357 */       if (h.occupants() > 0) {
/*     */         
/* 359 */         RaceHomeClass stage = h.race().home().clas(h.occupant(0));
/* 360 */         Floors.Floor f = stage.floor(h);
/* 361 */         if (f != (SETT.FLOOR()).getter.get(it.tx(), it.ty())) {
/* 362 */           if (stage.floor(h) == null) {
/* 363 */             (SETT.FLOOR()).clearer.clear(it.tx(), it.ty());
/*     */           } else {
/* 365 */             stage.floor(h).placeFixed(it.tx(), it.ty());
/*     */           } 
/*     */         }
/* 368 */         Sprite s = h.sprite(it.tx(), it.ty());
/* 369 */         if (s != null) {
/* 370 */           s.house = h;
/* 371 */           s.render(r, shadowBatch, data, it, degrade, isCandle);
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 378 */         Sprite s = h.sprite(it.tx(), it.ty());
/* 379 */         if (s != null && s.sData() == 1) {
/* 380 */           s.house = h;
/* 381 */           s.render(r, shadowBatch, data, it, degrade, isCandle);
/*     */         } 
/* 383 */         if ((SETT.FLOOR()).getter.get(it.tx(), it.ty()) != (SETT.ROOMS()).HOME.constructor.flooring) {
/* 384 */           (SETT.ROOMS()).HOME.constructor.flooring.placeFixed(it.tx(), it.ty());
/*     */         }
/*     */       } 
/*     */     }
/* 388 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderBelow(SPRITE_RENDERER r, ShadowBatch shadow, int data, RenderData.RenderIterator it, double degrade) {
/* 394 */     HomeInstance h = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(it.tile());
/* 395 */     if (h != null) {
/* 396 */       if (h.occupants() > 0) {
/*     */         
/* 398 */         Sprite s = h.sprite(it.tx(), it.ty());
/* 399 */         if (s != null) {
/* 400 */           s.house = h;
/* 401 */           s.renderBelow(r, shadow, data, it, degrade);
/*     */         } 
/*     */         
/* 404 */         renderCarpet(r, shadow, data, it, degrade, h);
/*     */       } else {
/* 406 */         Sprite s = h.sprite(it.tx(), it.ty());
/* 407 */         if (s != null && s.sData() == 1) {
/* 408 */           s.house = h;
/* 409 */           s.renderBelow(r, shadow, data, it, degrade);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderCarpet(SPRITE_RENDERER r, ShadowBatch shadow, int data, RenderData.RenderIterator it, double degrade, HomeInstance h) {
/* 417 */     DIR dd = h.dir();
/*     */     
/* 419 */     Room room = (SETT.ROOMS()).map.get(it.tile());
/* 420 */     int rx = it.tx() - room.x1(it.tx(), it.ty());
/* 421 */     int ry = it.ty() - room.y1(it.tx(), it.ty());
/* 422 */     int c = Sprites.this.carpet.get(rx, ry, h.it());
/* 423 */     if (c == 0) {
/*     */       return;
/*     */     }
/* 426 */     Sheets a = (h.race().home().clas(h.occupant(0))).carpet.get(h);
/* 427 */     if (a == null) {
/*     */       return;
/*     */     }
/* 430 */     int ran = it.ran(room.x1(it.tx(), it.ty()) + c, room.y1(it.tx(), it.ty()));
/* 431 */     SheetPair ts = a.get(ran);
/*     */ 
/*     */     
/* 434 */     int t = 0;
/* 435 */     for (DIR d : DIR.ORTHO) {
/* 436 */       if (Sprites.this.carpet.get(rx, ry, d, h.it()) == c) {
/* 437 */         t |= d.mask();
/*     */       }
/*     */     } 
/*     */     
/* 441 */     ran >>= 4;
/* 442 */     t = SheetType.sCombo.tile(ts.s, ts.d, t, ts.d.frame(ran, 1.0D), 0);
/*     */     
/* 444 */     int dx = 16 + (ran & 0x3F) / 2;
/* 445 */     if (dd.x() > 0) {
/* 446 */       dx = 0;
/* 447 */     } else if (dd.x() < 0) {
/* 448 */       dx = 48;
/*     */     } 
/* 450 */     ran >>= 6;
/* 451 */     int dy = 16 + (ran & 0x3F) / 2;
/* 452 */     if (dd.y() > 0) {
/* 453 */       dy = 0;
/* 454 */     } else if (dd.y() < 0) {
/* 455 */       dy = 48;
/*     */     } 
/* 457 */     ts.s.render(ts.d, it.x() - dx, it.y() - dy, it, r, t, ran, 0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 463 */     if (item.get(rx, ry).data() == 2) {
/*     */       return;
/*     */     }
/* 466 */     int m = 0;
/* 467 */     for (DIR d : DIR.ORTHO) {
/* 468 */       if (item.is(rx, ry, d))
/* 469 */         m |= d.mask(); 
/* 470 */     }  (SPRITES.cons()).BIG.outline.render(r, m, x, y);
/*     */   }
/*     */   
/* 473 */   private final Rec tmp = new Rec();
/*     */ 
/*     */   
/*     */   public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 477 */     byte m = 0;
/*     */     
/* 479 */     int w = item.group().item(0, item.rotation).width();
/* 480 */     int h = item.group().item(0, item.rotation).height();
/* 481 */     this.tmp.setDim(w, h);
/*     */     
/* 483 */     this.tmp.moveX1Y1((w * rx / w), (h * ry / h));
/*     */     
/* 485 */     for (DIR d : DIR.ORTHO) {
/* 486 */       if (this.tmp.holdsPoint(rx, ry, d))
/* 487 */         m = (byte)(m | d.mask()); 
/*     */     } 
/* 489 */     return m;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\house\Sprites$11.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */