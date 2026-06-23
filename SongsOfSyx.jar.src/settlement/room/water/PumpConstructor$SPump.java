/*     */ package settlement.room.water;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SPump
/*     */ {
/*     */   private final TILE_SHEET sheet;
/*     */   private final TILE_SHEET rim;
/*     */   private final TILE_SHEET stencil;
/*     */   private final TILE_SHEET outlet;
/*     */   private static final int animations = 5;
/*     */   private static final int shadow = 40;
/*     */   public final RoomSprite pool;
/*     */   public final RoomSprite sp;
/*     */   
/*     */   SPump(RoomInitData init) throws IOException {
/* 442 */     this.pool = new RoomSprite()
/*     */       {
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 453 */           int m = 0;
/* 454 */           for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 455 */             DIR d = (DIR)DIR.ORTHO.get(di);
/* 456 */             if (item.sprite(rx + d.x(), ry + d.y()) == this) {
/* 457 */               m |= d.mask();
/*     */             }
/*     */           } 
/* 460 */           (SPRITES.cons()).BIG.outline.render(r, m, x, y);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 466 */           s.setHeight(16);
/* 467 */           s.setDistance2Ground(0.0D);
/* 468 */           PumpConstructor.SPump.this.rim.render((SPRITE_RENDERER)s, data, it.x(), it.y());
/* 469 */           int op = 10;
/* 470 */           PumpInstance p = (PumpInstance)(SETT.ROOMS()).WATER.pump.get(it.tx(), it.ty());
/* 471 */           if (p != null) {
/* 472 */             op = (int)(op + (60 * p.value) / p.valueMax);
/*     */           }
/* 474 */           (SETT.ROOMS()).WATER.sprite.renderWater(r, it, PumpConstructor.SPump.this.stencil, data, op);
/* 475 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 480 */           int h = 4;
/* 481 */           PumpInstance p = (PumpInstance)(SETT.ROOMS()).WATER.pump.get(it.tx(), it.ty());
/* 482 */           if (p != null) {
/* 483 */             h = (int)(8.0D - (7 * p.value) / p.valueMax);
/* 484 */             h = Math.max(h, 0);
/*     */           } 
/* 486 */           s.setHeight(h);
/* 487 */           s.setDistance2Ground(0.0D);
/* 488 */           PumpConstructor.SPump.this.rim.render(r, data, it.x(), it.y());
/* 489 */           PumpConstructor.SPump.this.rim.render((SPRITE_RENDERER)s, data, it.x(), it.y());
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 494 */           int x = 0;
/* 495 */           int y = 0;
/* 496 */           if (item.sprite(rx + 1, ry) != this) {
/* 497 */             x = 2;
/* 498 */           } else if (item.sprite(rx - 1, ry) == this) {
/* 499 */             x = 1;
/* 500 */           }  if (item.sprite(rx, ry + 1) != this) {
/* 501 */             y = 2;
/* 502 */           } else if (item.sprite(rx, ry - 1) == this) {
/* 503 */             y = 1;
/* 504 */           }  return (byte)(y * 3 + x);
/*     */         }
/*     */ 
/*     */         
/*     */         public int sData() {
/* 509 */           return 0;
/*     */         }
/*     */       };
/*     */     
/* 513 */     this.sp = new RoomSprite()
/*     */       {
/*     */         public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade)
/*     */         {
/* 517 */           (SETT.ROOMS()).WATER.sprite.renderBelow(r, s, it, ((DIR)DIR.ORTHO.get(data)).perpendicular().mask(), false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/* 523 */           DIR dir = (DIR)DIR.ORTHO.get(data);
/* 524 */           ((SPRITE)(SPRITES.cons()).ICO.arrows.get(dir.orthoID())).render(r, x, y);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 530 */           int flow = (PumpConstructor.SPump.access$0(PumpConstructor.SPump.this)).blue.is(it.tile()) ? ((DIR)DIR.ORTHO.get(data)).mask() : 0;
/* 531 */           (SETT.ROOMS()).WATER.sprite.render(r, s, it, ((DIR)DIR.ORTHO.get(data)).perpendicular().mask(), flow, false);
/* 532 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 537 */           PumpConstructor.SPump.this.outlet.render(r, data, it.x(), it.y());
/*     */         }
/*     */ 
/*     */         
/*     */         public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 542 */           return (byte)item.rotation;
/*     */         }
/*     */ 
/*     */         
/*     */         public int sData() {
/* 547 */           return 0;
/*     */         }
/*     */       };
/*     */     this.sheet = (new ComposerThings.ITileSheet(init.gSprite.get("PUMP"), 220, 76) {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*     */           s.full2.init(0, 0, 5, 2, 1, 2, d.s16);
/*     */           for (int r = 0; r < 2; r++) {
/*     */             int i;
/*     */             for (i = 0; i < 5; i++) {
/*     */               s.full2.setVar(i + 5 * r).setSkip(1, 0);
/*     */               s.full2.paste(3, true);
/*     */             } 
/*     */             for (i = 0; i < 5; i++) {
/*     */               s.full2.setVar(i + 5 * r).setSkip(1, 1);
/*     */               s.full2.paste(3, true);
/*     */             } 
/*     */           } 
/*     */           return d.s16.saveGame();
/*     */         }
/*     */       }).get();
/*     */     this.rim = (new ComposerThings.ITileSheet() {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*     */           s.full.init(0, s.full2.body().y2(), 1, 1, 3, 3, d.s16);
/*     */           s.full.paste(true);
/*     */           return d.s16.saveGame();
/*     */         }
/*     */       }).get();
/*     */     this.stencil = (new ComposerThings.ITileSheet() {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*     */           s.full.init(0, s.full.body().y2(), 1, 1, 3, 3, d.s16);
/*     */           s.full.paste(true);
/*     */           return d.s16.saveGame();
/*     */         }
/*     */       }).get();
/*     */     this.outlet = (new ComposerThings.ITileSheet() {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d) {
/*     */           s.full2.init(s.full.body().x2(), s.full.body().y1(), 1, 1, 1, 1, d.s16);
/*     */           s.full2.paste(3, true);
/*     */           return d.s16.saveGame();
/*     */         }
/*     */       }).get();
/*     */   }
/*     */   
/*     */   public RoomSprite sprite(final int ii, Json js) throws IOException {
/*     */     return (RoomSprite)new RoomSpriteCombo(js, "FRAME_COMBO") {
/*     */         public byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*     */           return (byte)(item.rotation - 1 & 0x3);
/*     */         }
/*     */         
/*     */         public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*     */           int rot = getData2(it);
/*     */           DIR d = (DIR)DIR.ORTHO.get(rot);
/*     */           int aniI = GUTIL.ran2().get(it.tx() - d.x() + d.x() * ii, it.ty() - d.y() + d.y() * ii);
/*     */           int frames = 8;
/*     */           int ani = (aniI + (int)(TIME.currentSecond() * 6.0D)) % frames;
/*     */           if (ani >= 5)
/*     */             ani = frames - ani; 
/*     */           int tile = 0;
/*     */           if (ii == 0) {
/*     */             tile = rot + ani * 4;
/*     */           } else if (ii == 1) {
/*     */             tile = rot + 20 + ani * 4;
/*     */           } else {
/*     */             rot = (rot + 2) % 4;
/*     */             ani = 5 - ani - 1;
/*     */             tile = rot + ani * 4;
/*     */           } 
/*     */           PumpConstructor.SPump.this.sheet.render(r, tile, it.x(), it.y());
/*     */           s.setHeight(14).setDistance2Ground(0.0D);
/*     */           PumpConstructor.SPump.this.sheet.render((SPRITE_RENDERER)s, tile + 40, it.x(), it.y());
/*     */         }
/*     */         
/*     */         protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/*     */           return !(!super.joins(tx, ty, rx, ry, d, item) && item.sprite(rx + d.x(), ry + d.y()) != PumpConstructor.SPump.this.pool);
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\PumpConstructor$SPump.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */