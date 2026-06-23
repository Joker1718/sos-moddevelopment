/*     */ package view.sett.ui.room.priority;
/*     */ 
/*     */ import init.type.WGROUP;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.employment.RoomEmployment;
/*     */ import settlement.room.main.employment.RoomEmploymentSimple;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
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
/*     */ class Card
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   private final Filter.FilterEntry<WGROUP> g;
/*     */   private final WGROUP e;
/*     */   
/*     */   Card(Filter.FilterEntry<WGROUP> g, SPRITE icon) {
/* 372 */     super(icon);
/* 373 */     this.g = g;
/* 374 */     this.e = (WGROUP)g.o;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 379 */     Row.this.dragging = this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 385 */     if (Row.this.dragging != null && Row.this.dragging != this)
/* 386 */       this.isHovered = false; 
/* 387 */     super.renAction();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 392 */     isSelected = (Row.this.dragging == this);
/* 393 */     GMeter.render(r, GMeter.C_ORANGE, ds, (RECTANGLE)this.body);
/* 394 */     super.render(r, ds, isActive, isSelected, isHovered);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 400 */     GBox b = (GBox)text;
/*     */ 
/*     */     
/* 403 */     b.add((SPRITE)(Row.this.emp.blueprint()).icon);
/* 404 */     b.textLL((CharSequence)b.text().add((Row.this.emp.blueprint()).info.names).s().add('-').add('>').s().add(this.g.name));
/* 405 */     b.NL();
/*     */     
/* 407 */     b.textLL(this.e.name);
/* 408 */     b.tab(6);
/* 409 */     b.add((SPRITE)GFORMAT.i(b.text(), Row.this.emp.target.group(this.e)));
/* 410 */     b.NL();
/*     */     
/* 412 */     b.textLL(((STANDINGS.CITIZEN()).fullfillment.info()).name);
/* 413 */     b.tab(6);
/* 414 */     b.add((SPRITE)GFORMAT.perc(b.text(), this.e.race.pref().getWork((RoomEmploymentSimple)Row.this.emp)));
/* 415 */     b.NL();
/*     */     
/* 417 */     if (Row.this.emp.blueprint().bonus() != null) {
/* 418 */       b.textLL(Dic.¤¤Skill);
/* 419 */       b.tab(6);
/* 420 */       b.add((SPRITE)GFORMAT.perc(b.text(), this.e.race.bvalue(Row.this.emp.blueprint().bonus())));
/* 421 */       b.NL();
/*     */     } 
/*     */     
/* 424 */     b.textLL((CharSequence)b.text().add((Row.this.emp.blueprint()).info.name).s().add(Row.¤¤employedTarget));
/* 425 */     b.tab(6);
/* 426 */     b.add((SPRITE)GFORMAT.i(b.text(), Row.this.emp.target.get()));
/* 427 */     b.NL();
/*     */ 
/*     */     
/* 430 */     b.sep();
/*     */ 
/*     */     
/* 433 */     b.add(this.e.icon);
/* 434 */     b.textLL((CharSequence)b.text().add(this.g.name).s().add('(').add(Dic.¤¤Total).add(')'));
/* 435 */     b.NL();
/*     */     
/* 437 */     b.textLL(Row.¤¤workForce);
/* 438 */     b.tab(6);
/* 439 */     b.add((SPRITE)GFORMAT.i(b.text(), STATS.WORK().workforce(this.e)));
/* 440 */     b.NL();
/*     */     
/* 442 */     b.textLL(Row.¤¤employed);
/* 443 */     b.tab(6);
/* 444 */     b.add((SPRITE)GFORMAT.i(b.text(), (SETT.ROOMS()).employment.TARGET.get(this.e)));
/* 445 */     b.NL();
/*     */     
/* 447 */     double f = 0.0D;
/* 448 */     double am = 0.0D;
/* 449 */     for (RoomEmployment p : (SETT.ROOMS()).employment.ALL()) {
/* 450 */       f += this.e.race.pref().getWork((RoomEmploymentSimple)p) * p.target.group(this.e);
/* 451 */       am += p.target.group(this.e);
/*     */     } 
/* 453 */     if (am > 0.0D)
/* 454 */       f /= am; 
/* 455 */     b.textLL(((STANDINGS.CITIZEN()).fullfillment.info()).name);
/* 456 */     b.tab(6);
/* 457 */     b.add((SPRITE)GFORMAT.perc(b.text(), f));
/* 458 */     b.NL();
/*     */     
/* 460 */     f = 0.0D;
/* 461 */     am = 0.0D;
/* 462 */     for (RoomEmployment p : (SETT.ROOMS()).employment.ALL()) {
/* 463 */       if (p.blueprint().bonus() != null) {
/* 464 */         f += this.e.race.bvalue(p.blueprint().bonus()) * p.target.group(this.e);
/*     */       }
/* 466 */       am += p.target.group(this.e);
/*     */     } 
/* 468 */     if (am > 0.0D)
/* 469 */       f /= am; 
/* 470 */     b.textLL(Dic.¤¤Skill);
/* 471 */     b.tab(6);
/* 472 */     b.add((SPRITE)GFORMAT.perc(b.text(), f));
/* 473 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\priority\Row$Card.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */