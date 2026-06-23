/*     */ package view.sett.ui.food;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.ResG;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.RoomProduction;
/*     */ import settlement.room.service.food.canteen.ROOM_CANTEEN;
/*     */ import settlement.room.service.food.eatery.ROOM_EATERY;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class RR
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   private final ResG res;
/* 374 */   private final GText t = new GText((UI.FONT()).S, 8);
/*     */   
/*     */   RR(ResG res) {
/* 377 */     super(248, 60);
/* 378 */     this.res = res;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER ren, float ds, boolean isHovered) {
/* 383 */     GButt.ButtPanel.renderBG(ren, true, false, isHovered, (RECTANGLE)this.body);
/* 384 */     this.res.resource.icon().renderScaled(ren, this.body.x1() + 8, this.body.y1() + 6, 2);
/* 385 */     this.t.clear();
/*     */     
/* 387 */     int am = totStored();
/*     */     
/* 389 */     GFORMAT.i(this.t, am);
/* 390 */     this.t.adjustWidth();
/* 391 */     this.t.renderCY(ren, this.body.x1() + 120 - this.t.width(), this.body.cY());
/*     */     
/* 393 */     this.t.clear();
/*     */     
/* 395 */     GFORMAT.f0(this.t, (SETT.ROOMS()).PROD.produced(this.res.resource) - (SETT.ROOMS()).PROD.consumed(this.res.resource));
/* 396 */     this.t.adjustWidth();
/* 397 */     this.t.renderCY(ren, this.body.x2() - 8 - this.t.width(), this.body.cY());
/*     */     
/* 399 */     GButt.ButtPanel.renderFrame(ren, (RECTANGLE)this.body);
/*     */   }
/*     */   
/*     */   private int totStored() {
/* 403 */     int am = 0;
/* 404 */     am += (SETT.ROOMS()).STOCKPILE.tally().amountTotal(this.res.resource);
/*     */     int ri;
/* 406 */     for (ri = 0; ri < (SETT.ROOMS()).EATERIES.size(); ri++) {
/* 407 */       ROOM_EATERY e = (ROOM_EATERY)(SETT.ROOMS()).EATERIES.get(ri);
/* 408 */       am = (int)(am + e.amount(this.res));
/*     */     } 
/*     */     
/* 411 */     for (ri = 0; ri < (SETT.ROOMS()).CANTEENS.size(); ri++) {
/* 412 */       ROOM_CANTEEN e = (ROOM_CANTEEN)(SETT.ROOMS()).CANTEENS.get(ri);
/* 413 */       am = (int)(am + e.amount(this.res));
/*     */     } 
/* 415 */     return am;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 420 */     GBox b = (GBox)text;
/* 421 */     b.title(this.res.resource.names);
/*     */     
/* 423 */     b.textLL(Dic.¤¤Stored);
/* 424 */     b.NL();
/* 425 */     b.add((SETT.ROOMS()).STOCKPILE.icon.small);
/* 426 */     b.textL((SETT.ROOMS()).STOCKPILE.info.names);
/* 427 */     b.tab(7);
/* 428 */     b.add((SPRITE)GFORMAT.i(b.text(), (SETT.ROOMS()).STOCKPILE.tally().amountTotal(this.res.resource)));
/* 429 */     b.NL();
/*     */     int ri;
/* 431 */     for (ri = 0; ri < (SETT.ROOMS()).EATERIES.size(); ri++) {
/* 432 */       ROOM_EATERY e = (ROOM_EATERY)(SETT.ROOMS()).EATERIES.get(ri);
/* 433 */       b.NL();
/* 434 */       b.add(e.icon.small);
/* 435 */       b.textL(e.info.names);
/* 436 */       b.tab(7);
/* 437 */       b.add((SPRITE)GFORMAT.i(b.text(), e.amount(this.res)));
/* 438 */       b.NL();
/*     */     } 
/*     */     
/* 441 */     for (ri = 0; ri < (SETT.ROOMS()).CANTEENS.size(); ri++) {
/* 442 */       ROOM_CANTEEN e = (ROOM_CANTEEN)(SETT.ROOMS()).CANTEENS.get(ri);
/* 443 */       b.NL();
/* 444 */       b.add(e.icon.small);
/* 445 */       b.textL(e.info.names);
/* 446 */       b.tab(7);
/* 447 */       b.add((SPRITE)GFORMAT.i(b.text(), e.amount(this.res)));
/* 448 */       b.NL();
/*     */     } 
/*     */     
/* 451 */     b.NL(4);
/*     */     
/* 453 */     b.textL(Dic.¤¤Total);
/* 454 */     b.tab(7);
/* 455 */     b.add((SPRITE)GFORMAT.i(b.text(), totStored()));
/*     */     
/* 457 */     b.sep();
/*     */     
/* 459 */     b.textLL(((STATS.FOOD()).FOOD_PREFFERENCE.info()).name);
/* 460 */     b.NL();
/*     */     
/* 462 */     for (Race r : RACES.all()) {
/* 463 */       if ((r.pref()).foodMask.has(this.res.resource)) {
/* 464 */         b.add((SPRITE)(r.appearance()).icon);
/* 465 */         b.textL(r.info.names);
/* 466 */         b.NL();
/*     */       } 
/*     */     } 
/*     */     
/* 470 */     b.sep();
/*     */     
/* 472 */     b.textLL(Dic.¤¤Production);
/* 473 */     b.NL();
/*     */     
/* 475 */     for (RoomProduction.Source ii : (SETT.ROOMS()).PROD.producers(this.res.resource)) {
/* 476 */       b.add(ii.icon());
/* 477 */       b.textLL(ii.name());
/* 478 */       if (ii.thereAreMultipleIns() != null) {
/* 479 */         for (IndustryResource iii : ii.thereAreMultipleIns().ins()) {
/* 480 */           b.add((iii.resource.icon()).small);
/*     */         }
/*     */       }
/*     */       
/* 484 */       b.tab(7);
/* 485 */       b.add((SPRITE)GFORMAT.f0(b.text(), ii.am()));
/* 486 */       b.NL();
/*     */     } 
/*     */     
/* 489 */     b.NL(8);
/* 490 */     b.textLL(Dic.¤¤Consumed);
/* 491 */     b.NL();
/*     */     
/* 493 */     for (RoomProduction.Source ii : (SETT.ROOMS()).PROD.consumers(this.res.resource)) {
/* 494 */       b.add(ii.icon());
/* 495 */       b.textLL(ii.name());
/* 496 */       if (ii.thereAreMultipleIns() != null) {
/* 497 */         for (IndustryResource iii : ii.thereAreMultipleIns().ins()) {
/* 498 */           b.add((iii.resource.icon()).small);
/*     */         }
/*     */       }
/*     */       
/* 502 */       b.tab(7);
/* 503 */       b.add((SPRITE)GFORMAT.f0(b.text(), -ii.am()));
/* 504 */       b.NL();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\food\UIFood$RR.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */