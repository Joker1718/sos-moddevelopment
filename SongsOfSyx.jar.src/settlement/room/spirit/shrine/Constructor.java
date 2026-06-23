/*     */ package settlement.room.spirit.shrine;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteBoxN;
/*     */ import settlement.room.sprite.RoomSpriteImp;
/*     */ import settlement.room.sprite.RoomSpriteTex;
/*     */ import settlement.room.sprite.RoomSpriteXxX;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ final class Constructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_SHRINE blue;
/*  31 */   final FurnisherStat services = (FurnisherStat)new FurnisherStat.FurnisherStatI(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final int codeService = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final int codeFire = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Constructor(ROOM_SHRINE blue, RoomInitData init) throws IOException {
/* 307 */     super(init, 1, 1);
/* 308 */     this.blue = blue;
/*     */     
/* 310 */     Json sp = init.data().json("SPRITES");
/*     */     
/* 312 */     RoomSprite.Dummy dummy = RoomSprite.DUMMY;
/*     */     
/* 314 */     final RoomSpriteTex sScribble = new RoomSpriteTex(sp, "ALTAR_FLOOR_TEXTURE", sp)
/*     */       {
/*     */         RoomSprite sc1;
/*     */         
/*     */         RoomSprite sc2;
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 322 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 330 */           it.ranOffset(1, 0);
/* 331 */           super.render(r, s, data, it, degrade, this.rotates);
/* 332 */           it.ranOffset(2, 0);
/* 333 */           this.sc1.render(r, s, 0, it, degrade, false);
/* 334 */           it.ranOffset(3, 0);
/* 335 */           this.sc2.render(r, s, 0, it, degrade, false);
/*     */         }
/*     */       };
/*     */     
/* 339 */     final SStairs sStairs1 = new SStairs(1, sp);
/*     */     
/* 341 */     final RoomSpriteImp sAltarNormal = (new RoomSpriteBoxN(sp, "ALTAR_BOX")
/*     */       {
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item)
/*     */         {
/* 346 */           return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 99);
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 351 */           sStairs1.renderBelow(r, s, 15, it, degrade);
/* 352 */           sScribble.renderBelow(r, s, 0, it, degrade);
/*     */         }
/* 354 */       }).sData(99);
/*     */     
/* 356 */     FurnisherItemTile aa = new FurnisherItemTile(
/* 357 */         this, 
/* 358 */         (RoomSprite)roomSpriteImp1, 
/* 359 */         AVAILABILITY.SOLID, 
/* 360 */         false);
/*     */     
/* 362 */     FurnisherItemTile __ = new FurnisherItemTile(
/* 363 */         this, 
/* 364 */         (RoomSprite)dummy, 
/* 365 */         AVAILABILITY.ROOM, 
/* 366 */         false);
/*     */     
/* 368 */     FurnisherItemTile _x = new FurnisherItemTile(
/* 369 */         this, 
/* 370 */         (RoomSprite)roomSpriteTex, 
/* 371 */         AVAILABILITY.ROOM, 
/* 372 */         false);
/*     */     
/* 374 */     FurnisherItemTile oo = new FurnisherItemTile(
/* 375 */         this, 
/* 376 */         (RoomSprite)sStairs, 
/* 377 */         AVAILABILITY.ROOM, 
/* 378 */         false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 385 */     RoomSpriteImp roomSpriteImp3 = (new SStairs(1, sp, sp)
/*     */       {
/*     */         final RoomSprite1x1 torch;
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 391 */           return this.torch.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 397 */           this.torch.render(r, s, getData2(it), it, degrade, false);
/* 398 */           return false;
/*     */         }
/* 400 */       }).sData(1);
/*     */     
/* 402 */     SScribbleAltar sScribbleAltar = new SScribbleAltar(2, sp, (RoomSprite)sStairs);
/*     */     
/* 404 */     RoomSprite1x1 sAltarReliefSmall = new RoomSprite1x1(sp, "EMBLEM_1X1")
/*     */       {
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 407 */           return (d.orthoID() == item.rotation);
/*     */         }
/*     */       };
/*     */     
/* 411 */     RoomSpriteImp roomSpriteImp5 = (new ASmall((RoomSprite)new SScribbleAltar(1, sp, (RoomSprite)roomSpriteImp1), (RoomSprite)roomSpriteImp1, sAltarReliefSmall, -2)).sData(99);
/* 412 */     RoomSpriteImp roomSpriteImp6 = (new ASmall((RoomSprite)new SScribbleAltar(1, sp, (RoomSprite)roomSpriteImp1), (RoomSprite)roomSpriteImp1, sAltarReliefSmall, 2)).sData(99);
/*     */     
/* 414 */     FurnisherItemTile furnisherItemTile1 = (new FurnisherItemTile(
/* 415 */         this, 
/* 416 */         (RoomSprite)roomSpriteImp3, 
/* 417 */         AVAILABILITY.SOLID, 
/* 418 */         false)).setData(2);
/*     */     
/* 420 */     FurnisherItemTile furnisherItemTile2 = new FurnisherItemTile(
/* 421 */         this, 
/* 422 */         (RoomSprite)sScribbleAltar, 
/* 423 */         AVAILABILITY.ROOM, 
/* 424 */         false);
/*     */     
/* 426 */     FurnisherItemTile c1 = new FurnisherItemTile(
/* 427 */         this, 
/* 428 */         (RoomSprite)roomSpriteImp5, 
/* 429 */         AVAILABILITY.SOLID, 
/* 430 */         false);
/*     */     
/* 432 */     FurnisherItemTile c2 = new FurnisherItemTile(
/* 433 */         this, 
/* 434 */         (RoomSprite)roomSpriteImp6, 
/* 435 */         AVAILABILITY.SOLID, 
/* 436 */         false);
/*     */     
/* 438 */     make(new FurnisherItemTile[][] {
/*     */           {
/* 440 */             _x, _x, __, __, _x, _x
/* 441 */           }, { oo, oo, oo, oo, oo, oo
/* 442 */           }, { oo, furnisherItemTile2, aa, aa, furnisherItemTile2, oo
/* 443 */           }, { oo, furnisherItemTile1, c1, c2, furnisherItemTile1, oo
/* 444 */           }, { oo, furnisherItemTile2, aa, aa, furnisherItemTile2, oo
/* 445 */           }, { oo, oo, oo, oo, oo, oo }
/*     */         });
/*     */ 
/*     */     
/* 449 */     make(new FurnisherItemTile[][] {
/*     */           {
/* 451 */             _x, _x, __, __, _x, _x
/* 452 */           }, { oo, oo, oo, oo, oo, oo
/* 453 */           }, { oo, furnisherItemTile2, aa, aa, furnisherItemTile2, oo
/* 454 */           }, { oo, furnisherItemTile1, c1, c2, furnisherItemTile1, oo
/* 455 */           }, { oo, furnisherItemTile2, aa, aa, furnisherItemTile2, oo
/* 456 */           }, { oo, oo, oo, oo, oo, oo
/* 457 */           }, { _x, _x, __, __, _x, _x }
/*     */         });
/*     */ 
/*     */     
/* 461 */     make(new FurnisherItemTile[][] {
/*     */           {
/* 463 */             _x, _x, __, __, __, __, _x, _x
/* 464 */           }, { _x, oo, oo, oo, oo, oo, oo, _x
/* 465 */           }, { __, oo, furnisherItemTile2, aa, aa, furnisherItemTile2, oo, __
/* 466 */           }, { __, furnisherItemTile1, furnisherItemTile2, c1, c2, furnisherItemTile2, furnisherItemTile1, __
/* 467 */           }, { __, oo, furnisherItemTile2, aa, aa, furnisherItemTile2, oo, __
/* 468 */           }, { _x, oo, oo, oo, oo, oo, oo, _x
/* 469 */           }, { _x, _x, __, __, __, __, _x, _x }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 477 */     RoomSpriteImp roomSpriteImp2 = (new SStairs(1, sp, sp)
/*     */       {
/*     */         final RoomSprite1x1 torch;
/*     */ 
/*     */         
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 483 */           return this.torch.getData(tx, ty, rx, ry, item, itemRan);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 489 */           this.torch.render(r, s, getData2(it), it, degrade, false);
/* 490 */           return false;
/*     */         }
/* 492 */       }).sData(1);
/*     */ 
/*     */     
/* 495 */     RoomSpriteImp roomSpriteImp4 = (new RoomSpriteXxX(sp, "EMBLEM_2X2", 2)
/*     */       {
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle)
/*     */         {
/* 499 */           sAltarNormal.render(r, s, 15, it, degrade, isCandle);
/* 500 */           super.render(r, s, data, it, degrade, isCandle);
/* 501 */           return false;
/*     */         }
/* 504 */       }).sData(99);
/*     */     
/* 506 */     FurnisherItemTile tt = (new FurnisherItemTile(
/* 507 */         this, 
/* 508 */         (RoomSprite)roomSpriteImp2, 
/* 509 */         AVAILABILITY.SOLID, 
/* 510 */         false)).setData(2);
/*     */     
/* 512 */     FurnisherItemTile o2 = new FurnisherItemTile(
/* 513 */         this, 
/* 514 */         (RoomSprite)new SStairs(2, sp), 
/* 515 */         AVAILABILITY.ROOM, 
/* 516 */         false);
/*     */     
/* 518 */     FurnisherItemTile xx = new FurnisherItemTile(
/* 519 */         this, 
/* 520 */         (RoomSprite)new SScribbleAltar(2, sp, (RoomSprite)sStairs), 
/* 521 */         AVAILABILITY.ROOM, 
/* 522 */         false);
/* 523 */     FurnisherItemTile cc = new FurnisherItemTile(
/* 524 */         this, 
/* 525 */         (RoomSprite)roomSpriteImp4, 
/* 526 */         AVAILABILITY.SOLID, 
/* 527 */         false);
/* 528 */     make(new FurnisherItemTile[][] {
/*     */           {
/* 530 */             _x, _x, _x, __, __, __, __, _x, _x, _x
/* 531 */           }, { _x, oo, oo, oo, oo, oo, oo, oo, oo, _x
/* 532 */           }, { _x, oo, xx, aa, aa, aa, aa, xx, oo, _x
/* 533 */           }, { __, oo, xx, aa, cc, cc, aa, xx, oo, __
/* 534 */           }, { __, oo, xx, aa, cc, cc, aa, xx, oo, __
/* 535 */           }, { _x, oo, xx, aa, aa, aa, aa, xx, oo, _x
/* 536 */           }, { _x, tt, oo, oo, oo, oo, oo, oo, tt, _x
/* 537 */           }, { _x, _x, _x, __, __, __, __, _x, _x, _x }
/*     */         });
/*     */     
/* 540 */     make(new FurnisherItemTile[][] { { 
/* 541 */             _x, _x, _x, _x, __, __, __, __, _x, _x, _x, _x }, { 
/* 542 */             _x, oo, oo, oo, oo, oo, oo, oo, oo, oo, oo, _x }, { 
/* 543 */             _x, oo, o2, o2, o2, o2, o2, o2, o2, o2, oo, _x }, { 
/* 544 */             _x, oo, o2, xx, aa, aa, aa, aa, xx, o2, oo, _x }, { 
/* 545 */             __, oo, o2, xx, aa, cc, cc, aa, xx, o2, oo, __ }, { 
/* 546 */             __, oo, o2, xx, aa, cc, cc, aa, xx, o2, oo, __ }, { 
/* 547 */             _x, oo, o2, xx, aa, aa, aa, aa, xx, o2, oo, _x }, { 
/* 548 */             _x, oo, o2, o2, o2, o2, o2, o2, o2, o2, oo, _x }, { 
/* 549 */             _x, tt, oo, oo, oo, oo, oo, oo, oo, oo, tt, _x }, { 
/* 550 */             _x, _x, _x, _x, __, __, __, __, _x, _x, _x, _x } });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 556 */     flush(1, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void make(FurnisherItemTile[][] ttt) {
/* 562 */     int am = 0; byte b; int i; FurnisherItemTile[][] arrayOfFurnisherItemTile;
/* 563 */     for (i = (arrayOfFurnisherItemTile = ttt).length, b = 0; b < i; ) { FurnisherItemTile[] tt = arrayOfFurnisherItemTile[b]; byte b1; int j; FurnisherItemTile[] arrayOfFurnisherItemTile1;
/* 564 */       for (j = (arrayOfFurnisherItemTile1 = tt).length, b1 = 0; b1 < j; ) { FurnisherItemTile t = arrayOfFurnisherItemTile1[b1];
/* 565 */         if (t.availability.player > 0.0D)
/* 566 */           am++;  b1++; }  b++; }
/* 567 */      double cost = am * 0.75D;
/*     */   }
/*     */   
/*     */   private static class ASmall
/*     */     extends RoomSpriteBoxN {
/*     */     private final RoomSprite1x1 sAltarReliefSmall;
/*     */     private final RoomSprite s2;
/*     */     private int off;
/*     */     
/*     */     public ASmall(RoomSprite s2, RoomSprite saltar, RoomSprite1x1 sAltarReliefSmall, int off) throws IOException {
/* 577 */       super(saltar);
/* 578 */       this.sAltarReliefSmall = sAltarReliefSmall;
/* 579 */       this.s2 = s2;
/* 580 */       this.off = off;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 585 */       return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() == 99);
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 590 */       this.s2.renderBelow(r, s, 15, it, degrade);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 595 */       super.render(r, s, data, it, degrade, isCandle);
/* 596 */       DIR dd = this.sAltarReliefSmall.rot(getData2(it)).next(-this.off);
/* 597 */       it.setOff(dd.x() * 32, dd.y() * 32);
/* 598 */       this.sAltarReliefSmall.render(r, s, getData2(it), it, degrade, false);
/* 599 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 604 */       return this.sAltarReliefSmall.getData(tx, ty, rx, ry, item, itemRan);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class SStairs
/*     */     extends RoomSpriteBoxN
/*     */   {
/*     */     public SStairs(int level, Json sp) throws IOException {
/* 612 */       super(sp, "INNER_BOX");
/* 613 */       sData(level);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 618 */       return (item.sprite(rx, ry) != null && item.sprite(rx, ry).sData() >= sData());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 624 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 629 */       if (sData() > 1)
/* 630 */         super.render(r, s, 15, it, degrade, false); 
/* 631 */       super.render(r, s, data, it, degrade, false);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class SScribbleAltar
/*     */     extends RoomSpriteTex
/*     */   {
/*     */     RoomSprite sc1;
/*     */     RoomSprite sc2;
/*     */     final RoomSprite sAltarNormal;
/*     */     
/*     */     public SScribbleAltar(int level, Json sp, RoomSprite sAltarNormal) throws IOException {
/* 643 */       super(sp, "ALTAR_FLOOR_TEXTURE");
/* 644 */       sData(level);
/* 645 */       this.sc1 = (RoomSprite)new RoomSpriteTex(sp, "ALTAR_FLOOR_SCRIBBLE1_TEXTURE");
/* 646 */       this.sc2 = (RoomSprite)new RoomSpriteTex(sp, "ALTAR_FLOOR_SCRIBBLE2_TEXTURE");
/* 647 */       this.sAltarNormal = sAltarNormal;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 655 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 663 */       this.sAltarNormal.renderBelow(r, s, 15, it, degrade);
/* 664 */       it.ranOffset(1, 0);
/* 665 */       super.render(r, s, data, it, degrade, false);
/* 666 */       it.ranOffset(2, 0);
/* 667 */       this.sc1.render(r, s, 0, it, degrade, false);
/* 668 */       it.ranOffset(3, 0);
/* 669 */       this.sc2.render(r, s, 0, it, degrade, false);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 676 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 681 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 686 */     return (Room)new ShrineInstance(this.blue, area, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 691 */     return (RoomBlueprintImp)this.blue;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\shrine\Constructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */