/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.paths.PATHS;
/*     */ import init.resources.RESOURCE;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.game.SheetPair;
/*     */ import init.sprite.game.SheetType;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.gui.misc.GBox;
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
/*     */ final class Shallow
/*     */   extends Terrain.TerrainTile
/*     */ {
/*     */   private final LIST<SheetPair> ontop;
/*     */   private TerrainClearing clearing;
/*     */   
/*     */   private Shallow(Terrain t) throws IOException {
/* 433 */     super("WATER_SHALLOW", t, TWater.¤¤name, paramTWater.sprites.icon, t.colors.minimap.water);
/*     */ 
/*     */ 
/*     */     
/* 437 */     this.clearing = new TWater.Clear()
/*     */       {
/*     */         
/*     */         public RESOURCE clear1(int tx, int ty)
/*     */         {
/* 442 */           TWater.Shallow.this.shared.NADA.placeFixed(tx, ty);
/* 443 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean can() {
/* 448 */           return true;
/*     */         }
/*     */       };
/*     */     this.ontop = SPRITES.GAME().sheets((SheetType)SheetType.s1x1, (new Json((PATHS.CONFIG()).init.gets("SETT_MAP_DECORATION"))).json("WATER_SWEET_1X1"));
/*     */   }
/*     */   
/*     */   void unplace(int tx, int ty) {
/* 455 */     if (TWater.this.service.get(tx, ty) != null && ((FINDABLE)TWater.this.service.get(tx, ty)).findableReservedCanBe()) {
/* 456 */       (SETT.PATH()).finders.water.report(tx, ty, -1);
/*     */     }
/*     */   }
/*     */   
/*     */   public TerrainClearing clearing() {
/* 461 */     return this.clearing;
/*     */   }
/*     */ 
/*     */   
/*     */   public COLOR miniColorPimped(ColorImp c, int x, int y, boolean northern, boolean southern) {
/* 466 */     return TWater.this.mini.miniCPimp(c, x, y, northern, southern);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPlacable(int tx, int ty) {
/* 471 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean place(int x, int y) {
/* 478 */     if (SETT.IN_BOUNDS(x, y)) {
/* 479 */       return setCode(x, y);
/*     */     }
/* 481 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean setCode(int x, int y) {
/* 487 */     int old = this.shared.data.get(x, y);
/* 488 */     placeRaw(x, y);
/* 489 */     int c = getCode(x, y);
/* 490 */     c |= getCodeCorner(c, x, y) << 4;
/* 491 */     for (DIR d : DIR.ORTHO) {
/* 492 */       if (TWater.this.DEEP.is(x + d.x(), y + d.y()) || TWater.this.BRIDGE.is(x + d.x(), y + d.y())) {
/*     */         break;
/*     */       }
/*     */     } 
/* 496 */     boolean ret = TWater.this.setRadiusAndData(old, c, x, y);
/* 497 */     if (TWater.this.service.get(x, y) != null && ((FINDABLE)TWater.this.service.get(x, y)).findableReservedCanBe())
/* 498 */       (SETT.PATH()).finders.water.report(x, y, 1); 
/* 499 */     return ret;
/*     */   }
/*     */   
/*     */   private int getCode(int x, int y) {
/* 503 */     int m = 0;
/* 504 */     for (DIR d : DIR.ORTHO) {
/* 505 */       if (TWater.this.is.is(x + d.x(), y + d.y()) || !SETT.IN_BOUNDS(x, y, d))
/* 506 */         m |= d.mask(); 
/*     */     } 
/* 508 */     return m;
/*     */   }
/*     */ 
/*     */   
/*     */   private int getCodeCorner(int m, int x, int y) {
/* 513 */     int c = 0;
/* 514 */     for (DIR d : DIR.NORTHO) {
/* 515 */       if ((m & d.next(-1).mask()) != 0 && (m & d.next(1).mask()) != 0 && !TWater.this.is.is(x + d.x(), y + d.y())) {
/* 516 */         c |= d.mask();
/*     */       }
/*     */     } 
/* 519 */     return c;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 525 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 530 */     TWater.this.sprites.render(data & 0xF, data >> 4 & 0xF, i, (COLOR)TWater.this.sprites.shore, (COLOR)TWater.this.sprites.normal);
/* 531 */     TWater.this.sprites.renderTexture(i);
/* 532 */     COLOR.unbind();
/* 533 */     i.countWater();
/*     */     
/* 535 */     return ((data & 0xF) == 15);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean renderMid(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, int data) {
/* 541 */     TWater.this.sprites.above(data, 0, it);
/* 542 */     if (isIce(it.tile())) {
/* 543 */       int m = 0;
/* 544 */       for (DIR d : DIR.ORTHO) {
/* 545 */         if (isIce(it, d) || !SETT.IN_BOUNDS(it.tx(), it.ty(), d))
/* 546 */           m |= d.mask(); 
/*     */       } 
/* 548 */       TWater.this.sprites.renderIce(m, 0, it);
/* 549 */       return (m == 15);
/* 550 */     }  if ((data & 0xF) == 15 && TWater.this.groundWater.is(it.tile()) && (GUTIL.ran2().get(it.tile()) & 0x7) == 0) {
/*     */       
/* 552 */       if (this.ontop.size() == 0) {
/* 553 */         return false;
/*     */       }
/* 555 */       int ran = it.ran();
/* 556 */       SheetPair sheet = (SheetPair)this.ontop.getC(ran);
/* 557 */       if (sheet == null)
/* 558 */         return false; 
/* 559 */       (SETT.TERRAIN()).colors.tree.get(it.ran()).bind();
/*     */       
/* 561 */       ran >>= 4;
/*     */       
/* 563 */       int frame = sheet.d.frame(it.ran(), 1.0D);
/* 564 */       int tile = SheetType.s1x1.tile(sheet.s, sheet.d, 0, frame, ran & 0x3);
/*     */       
/* 566 */       int x = it.x();
/* 567 */       int y = it.y();
/*     */       
/* 569 */       ran = GUTIL.ran2().get(it.tile());
/* 570 */       double sp = 10.0D / (1 + (ran & 0xF));
/* 571 */       ran >>= 4;
/* 572 */       int f = (ran & 0xF) + (int)(sp * TIME.currentSecond());
/* 573 */       ran >>= 4;
/* 574 */       int df = MATH.distanceC(8, f, 16);
/* 575 */       x += df;
/*     */       
/* 577 */       sp = 10.0D / (1 + (ran & 0xF));
/* 578 */       ran >>= 4;
/* 579 */       f = (ran & 0xF) + (int)(sp * TIME.currentSecond());
/* 580 */       ran >>= 4;
/* 581 */       df = MATH.distanceC(8, f, 16);
/* 582 */       y += df;
/*     */ 
/*     */ 
/*     */       
/* 586 */       sheet.s.render(sheet.d, x, y, it, r, tile, ran, 0.0D);
/* 587 */       COLOR.unbind();
/* 588 */       if (s != null)
/* 589 */         sheet.s.renderShadow(sheet.d, x, y, it, s, tile, ran); 
/* 590 */       return false;
/*     */     } 
/*     */     
/* 593 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isIce(RenderData.RenderIterator i, DIR d) {
/* 597 */     return (is(i.tx(), i.ty(), d) && isIce(i.tx() + d.x(), i.ty() + d.y()));
/*     */   }
/*     */   
/*     */   private boolean isIce(int tx, int ty) {
/* 601 */     return (TWater.this.iceI > (GUTIL.ran1().get(tx + ty * SETT.TWIDTH) & 0xFFFF) && !(SETT.ROOMS()).map.is(tx, ty));
/*     */   }
/*     */   
/*     */   private boolean isIce(int tile) {
/* 605 */     return (TWater.this.iceI > (GUTIL.ran1().get(tile) & 0xFFFF) && !(SETT.ROOMS()).map.is(tile));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AVAILABILITY getAvailability(int x, int y) {
/* 614 */     return AVAILABILITY.PENALTY3;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfo(GBox box, int tx, int ty) {
/* 619 */     super.hoverInfo(box, tx, ty);
/* 620 */     if ((S.get()).developer) {
/* 621 */       box.add((SPRITE)box.text().add(TWater.this.radius.get(tx, ty)));
/*     */     }
/*     */   }
/*     */   
/*     */   public TERRAIN terrain(int tx, int ty) {
/* 626 */     if (TWater.this.groundWaterSalt.is(tx, ty))
/* 627 */       return TERRAINS.OCEAN(); 
/* 628 */     return TERRAINS.WET();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TWater$Shallow.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */