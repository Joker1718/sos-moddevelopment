/*     */ package view.sett.ui.law;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CRIMES;
/*     */ import settlement.stats.law.StatPunishment;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
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
/*     */ class PunButt
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   private final StatPunishment p;
/*     */   
/*     */   PunButt(StatPunishment p) {
/* 311 */     super(p.punish.icon.scaled(2.0D));
/* 312 */     this.p = p;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 317 */     UILawCrimeList.this.crimeToSet.punishmentSet(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace(), this.p.punish);
/* 318 */     super.clickA();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 323 */     selectedSet((UILawCrimeList.this.crimeToSet.punishment(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace()) == this.p));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 328 */     GBox b = (GBox)text;
/* 329 */     b.title(this.p.punish.action);
/*     */     
/* 331 */     CRIMES.Response rr = UILawCrimeList.this.crimeToSet.crime.loyaltyInc(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace(), this.p.punish);
/*     */     
/* 333 */     GText t = b.text();
/*     */     
/* 335 */     if (rr.diff >= 0.0D) {
/* 336 */       t.normalify2();
/* 337 */       t.add(UILawCrimeList.¤¤selectGood);
/*     */     } else {
/* 339 */       t.errorify();
/* 340 */       t.add(UILawCrimeList.¤¤selectBad);
/*     */     } 
/*     */ 
/*     */     
/* 344 */     t.insert(0, (STANDINGS.get(UILawCrimeList.this.cl)).bloyalty.name);
/* 345 */     b.add((SPRITE)t);
/* 346 */     b.NL(4);
/*     */ 
/*     */     
/* 349 */     b.add((SPRITE)(STANDINGS.get(UILawCrimeList.this.cl)).happiness.bo.icon);
/* 350 */     b.textLL((STANDINGS.get(UILawCrimeList.this.cl)).happiness.bo.name);
/* 351 */     b.tab(6);
/* 352 */     b.add((SPRITE)GFORMAT.percInc(b.text(), rr.newHap - rr.oldHappiness));
/* 353 */     b.NL();
/* 354 */     b.add((SPRITE)(BOOSTABLES.CIVICS()).LAW.icon);
/* 355 */     b.textLL((BOOSTABLES.CIVICS()).LAW.name);
/* 356 */     b.tab(6);
/* 357 */     b.add((SPRITE)GFORMAT.percInc(b.text(), rr.newLaw - rr.oldLaw));
/* 358 */     b.NL();
/* 359 */     b.add((SPRITE)(STANDINGS.get(UILawCrimeList.this.cl)).bloyalty.icon);
/* 360 */     b.textLL((STANDINGS.get(UILawCrimeList.this.cl)).bloyalty.name);
/* 361 */     b.tab(6);
/* 362 */     b.add((SPRITE)GFORMAT.percInc(b.text(), rr.diff));
/*     */     
/* 364 */     b.sep();
/*     */ 
/*     */ 
/*     */     
/* 368 */     b.text(this.p.punish.desc);
/*     */     
/* 370 */     b.NL(4);
/*     */     
/* 372 */     b.text(UILawCrimeList.¤¤desc);
/* 373 */     b.NL(4);
/*     */     
/* 375 */     b.tab(5);
/* 376 */     b.add((SPRITE)(BOOSTABLES.BEHAVIOUR()).HAPPI.icon);
/* 377 */     b.textLL(UILawCrimeList.¤¤tyranny);
/* 378 */     b.tab(9);
/* 379 */     b.add((SPRITE)(BOOSTABLES.CIVICS()).LAW.icon);
/* 380 */     b.textLL((BOOSTABLES.CIVICS()).LAW.name);
/* 381 */     b.NL();
/*     */     
/* 383 */     b.textL(UILawCrimeList.this.crimeToSet.crime.name);
/* 384 */     b.tab(5);
/* 385 */     b.add((SPRITE)GFORMAT.perc(b.text(), -UILawCrimeList.this.crimeToSet.crime.tyrrany(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace()), 1));
/* 386 */     b.tab(9);
/* 387 */     b.add((SPRITE)GFORMAT.percInc(b.text(), UILawCrimeList.this.crimeToSet.crime.law(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace())));
/* 388 */     b.NL();
/*     */     
/* 390 */     b.textL(this.p.punish.name);
/* 391 */     b.tab(5);
/* 392 */     b.add((SPRITE)GFORMAT.mul(b.text(), this.p.punish.tyranny(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace())));
/* 393 */     b.tab(9);
/* 394 */     b.add((SPRITE)GFORMAT.mul(b.text(), this.p.punish.law(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace())));
/* 395 */     b.NL();
/*     */     
/* 397 */     b.textLL(Dic.¤¤Total);
/* 398 */     b.tab(5);
/* 399 */     b.add((SPRITE)GFORMAT.percInc(b.text(), -UILawCrimeList.this.crimeToSet.crime.tyrrany(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace(), this.p.punish), 1));
/* 400 */     b.tab(9);
/* 401 */     b.add((SPRITE)GFORMAT.percInc(b.text(), UILawCrimeList.this.crimeToSet.crime.law(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace(), this.p.punish)));
/* 402 */     b.NL();
/*     */ 
/*     */     
/* 405 */     super.hoverInfoGet(text);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 411 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 412 */     CRIMES.Response rr = UILawCrimeList.this.crimeToSet.crime.loyaltyInc(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace(), this.p.punish);
/* 413 */     if (rr.diff < 0.0D) {
/* 414 */       (GCOLOR.UI()).BAD.hovered.bind();
/* 415 */       (UI.icons()).s.alert.renderCX(r, this.body.x2() - 8, this.body.y1() + 8);
/* 416 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\law\UILawCrimeList$PunButt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */