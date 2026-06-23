/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.boosting.Booster;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import settlement.stats.standing.StandingCitizen;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.DicTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GStaples
/*     */ {
/*     */   null(int $anonymous0) {
/* 343 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 348 */     isHovered = true;
/* 349 */     setHovered(hov.get());
/* 350 */     super.render(r, ds, isHovered);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, int stapleI) {
/* 356 */     box.title((STANDINGS.get(cl)).bhappiness.name);
/* 357 */     int fromZero = 32 - stapleI - 1;
/*     */     
/* 359 */     GText t = box.text();
/* 360 */     DicTime.setDaysAgo((Str)t, fromZero);
/* 361 */     box.add((SPRITE)t);
/*     */     
/* 363 */     box.tab(6);
/* 364 */     box.add((SPRITE)GFORMAT.perc(box.text(), h.happiness.getD((Race)race.get(), fromZero)));
/* 365 */     box.NL();
/*     */ 
/*     */ 
/*     */     
/* 369 */     if (fromZero >= 31) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 374 */     box.sep();
/*     */     
/* 376 */     box.textLL((h.fullfillment.info()).name);
/* 377 */     box.tab(7);
/* 378 */     box.add((SPRITE)GFORMAT.percInc(box.text(), CLAMP.d(h.happiness.getD((Race)race.get(), fromZero) - h.happiness.getD((Race)race.get(), fromZero - 1), 0.0D, 100.0D)));
/* 379 */     box.NL();
/* 380 */     for (Cats.Cat ca : cats.all) {
/* 381 */       int v1 = (int)(100.0D * CatButt.Staples.value(stapleI, ca.cs, cl, race));
/* 382 */       int v2 = v1;
/* 383 */       if (stapleI > 0)
/* 384 */         v2 = (int)(100.0D * CatButt.Staples.value(stapleI - 1, ca.cs, cl, race)); 
/* 385 */       if (v1 != v2) {
/* 386 */         box.tab(1);
/* 387 */         box.textL((ca.cs[0]).info.name);
/* 388 */         box.tab(7);
/* 389 */         double d1 = (v1 - v2) / 100.0D;
/* 390 */         box.add((SPRITE)GFORMAT.f0(box.text(), d1));
/* 391 */         box.NL();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 396 */     double d = h.expectation.getD((Race)race.get(), fromZero);
/* 397 */     double d2 = h.expectation.getD((Race)race.get(), fromZero + 1);
/* 398 */     double v = d / d2;
/* 399 */     if (v != 1.0D) {
/* 400 */       box.tab(1);
/* 401 */       box.textL((h.expectation.info()).name);
/* 402 */       box.tab(7);
/*     */     } 
/*     */     
/* 405 */     if (v < 1.0D) {
/* 406 */       box.add((SPRITE)GFORMAT.percInc(box.text(), 1.0D - v));
/* 407 */     } else if (v > 1.0D) {
/* 408 */       box.add((SPRITE)GFORMAT.percInc(box.text(), -(v - 1.0D)));
/*     */     } 
/*     */ 
/*     */     
/* 412 */     box.sep();
/*     */     
/* 414 */     for (int i = 0; i < h.happiness.bo.all().size(); i++) {
/* 415 */       Booster b = (Booster)h.happiness.bo.all().get(i);
/* 416 */       double n = h.happiness.factor((Race)race.get(), i, fromZero);
/* 417 */       double p = h.happiness.factor((Race)race.get(), i, fromZero + 1);
/* 418 */       box.add(b.info.icon);
/* 419 */       box.textLL(b.info.name);
/* 420 */       box.tab(7);
/*     */       
/* 422 */       if (b.isMul) {
/* 423 */         box.add((SPRITE)GFORMAT.percInc(box.text(), n - p));
/*     */       } else {
/* 425 */         box.add((SPRITE)GFORMAT.f0(box.text(), n - p));
/* 426 */       }  box.NL();
/*     */     } 
/*     */ 
/*     */     
/* 430 */     box.NL();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 436 */     if (super.hover(mCoo)) {
/* 437 */       hov.set(hoverI());
/* 438 */       return true;
/*     */     } 
/* 440 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double getValue(int stapleI) {
/* 445 */     int fromZero = 32 - stapleI - 1;
/* 446 */     return h.happiness.getD((Race)race.get(), fromZero);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setColor(ColorImp c, int stapleI, double value) {
/* 451 */     c.interpolate((GCOLOR.UI()).BAD.hovered, (GCOLOR.UI()).GOOD2.hovered, value);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CitizenMain$12.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */