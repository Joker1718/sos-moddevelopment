/*     */ package view.sett.ui.room.priority;
/*     */ import init.race.RACES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.WGROUP;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.employment.RoomEmployment;
/*     */ import settlement.room.main.employment.RoomEmploymentSimple;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GGaugeMutable;
/*     */ import util.gui.slider.GTarget;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ class Row extends GuiSection {
/*  41 */   private static CharSequence ¤¤left = "increase priority of all filtered work-groups in the row";
/*  42 */   private static CharSequence ¤¤right = "decrease priority of all filtered work-groups in the row";
/*  43 */   private static CharSequence ¤¤MasterPrio = "¤Master Priority";
/*  44 */   private static CharSequence ¤¤priority = "Priority:";
/*  45 */   private static CharSequence ¤¤highest = "(highest)";
/*  46 */   private static CharSequence ¤¤lowest = "(lowest)";
/*  47 */   private static CharSequence ¤¤ban = "Banned";
/*  48 */   private static CharSequence ¤¤banD = "This subject group is banned from working here. Employing all your workplaces might become impossible, even if you have enough workforce.";
/*     */   
/*  50 */   private static CharSequence ¤¤workForce = "Workforce";
/*  51 */   private static CharSequence ¤¤employed = "Employed";
/*  52 */   private static CharSequence ¤¤employedTarget = "Target";
/*     */   
/*     */   static {
/*  55 */     D.ts(Row.class);
/*     */   }
/*     */   
/*  58 */   public static int EW = 160;
/*  59 */   private static int HH = 80;
/*  60 */   private static int MM = 8;
/*     */   
/*     */   private final RoomEmployment emp;
/*     */   
/*     */   private Card dragging;
/*     */   private Chunk draggingTo;
/*     */   public final Filter<WGROUP> groupFilter;
/*  67 */   private final ArrayListGrower<Card> cardsSmall = new ArrayListGrower();
/*  68 */   private final ArrayListGrower<Card> cardsLarge = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private LIST<Card> cards;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int ri;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Row(Filter<WGROUP> fe, final RoomEmployment emp) {
/* 156 */     this.ri = -1; this.groupFilter = fe; this.emp = emp; for (Filter.FilterEntry<WGROUP> e : fe.all) { this.cardsSmall.add(new Card(e, e.icon)); SPRITE.Imp imp = new SPRITE.Imp(e.icon.width() + 20, e.icon.height()) { public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) { double d = CLAMP.d(emp.target.group((WGROUP)e.o) / emp.target.get(), 0.0D, 1.0D); GMeter.render(r, GMeter.C_ORANGE, d, X1, X2, Y1, Y2); d = ((WGROUP)e.o).race.pref().getWork((RoomEmploymentSimple)emp); GGaugeMutable.bad2Good(ColorImp.TMP, d); ColorImp.TMP.bind(); int am = (int)Math.round(d * 4.0D); am = CLAMP.i(am, 0, 4); int i; for (i = 0; i < am; i++) (SPRITES.icons()).s.plus.render(r, X1 + 20 + i * 16 / 2, Y1);  COLOR.unbind(); d = RACES.boosts().getNorSkill(((WGROUP)e.o).race, (RoomEmploymentSimple)emp); GGaugeMutable.bad2Good(ColorImp.TMP, d); ColorImp.TMP.bind(); am = (int)Math.round(d * 4.0D); am = CLAMP.i(am, 0, 4); for (i = 0; i < am; i++) (SPRITES.icons()).s.minus.render(r, X1 + 20 + i * 16 / 2, Y1 + 14);  COLOR.unbind(); e.icon.render(r, X1, Y1); } }
/*     */         ; this.cardsLarge.add(new Card(e, (SPRITE)imp)); }  add((RENDEROBJ)new Header(emp), 0, 0); for (int i = 0; i <= emp.priorities.max(null); i++) addRelBody(0, DIR.E, (RENDEROBJ)new Chunk(emp.priorities.max(null) - i));  CLICKABLE c = (new GButt.ButtPanel((SPRITE)(UI.icons()).s.arrow_left) { protected void clickA() { for (Row.Card c : Row.this.cardsSmall) { if (Row.this.groupFilter.active(c.g))
/*     */               emp.priorities.inc(c.e, 1);  }  super.clickA(); } }
/*     */       ).hoverInfoSet(¤¤left); c.body().moveX1(body().x2()); c.body().moveY2(body().cY()); add((RENDEROBJ)c); addDown(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).s.arrow_right) { protected void clickA() { for (Row.Card c : Row.this.cardsSmall) { if (Row.this.groupFilter.active(c.g))
/*     */                 emp.priorities.inc(c.e, -1);  }  super.clickA(); } }).hoverInfoSet(¤¤right)); body().pad(4, 0);
/* 161 */   } public void render(SPRITE_RENDERER r, float ds) { int am = 0;
/* 162 */     for (Card c : this.cardsSmall) {
/* 163 */       if (this.groupFilter.active(c.g)) {
/* 164 */         am++;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 169 */     this.cards = (am <= 6) ? (LIST<Card>)this.cardsLarge : (LIST<Card>)this.cardsSmall;
/*     */ 
/*     */     
/* 172 */     if (Math.abs(this.ri - VIEW.renI) > 1) {
/* 173 */       this.dragging = null;
/* 174 */       this.draggingTo = null;
/*     */     } 
/*     */     
/* 177 */     this.ri = VIEW.RI();
/*     */     
/* 179 */     if (this.dragging != null && 
/* 180 */       !MButt.LEFT.isDown()) {
/* 181 */       if (this.draggingTo != null) {
/* 182 */         this.emp.priorities.set(this.dragging.e, this.draggingTo.prio);
/* 183 */         (SETT.ROOMS()).employment.setTargets();
/*     */       } 
/* 185 */       this.dragging = null;
/* 186 */       this.draggingTo = null;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 193 */     boolean hov = hoveredIs();
/* 194 */     super.render(r, ds);
/*     */     
/* 196 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */     
/* 198 */     if (this.dragging != null && hov) {
/* 199 */       this.dragging.g.icon.renderC(r, (COORDINATE)VIEW.mouse());
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hoverInfoSelf(GUI_BOX text) {
/* 206 */     GBox b = (GBox)text;
/* 207 */     b.title((this.emp.blueprint()).info.names);
/*     */     
/* 209 */     b.textLL(¤¤MasterPrio);
/* 210 */     b.tab(4);
/* 211 */     b.add((SPRITE)GFORMAT.i(b.text(), this.emp.priority.get()));
/* 212 */     b.NL();
/*     */     
/* 214 */     b.textLL(Dic.¤¤Employees);
/* 215 */     b.tab(4);
/* 216 */     b.add((SPRITE)GFORMAT.iofkInv(b.text(), this.emp.target.get(), this.emp.neededWorkers()));
/* 217 */     b.NL(4);
/*     */ 
/*     */     
/* 220 */     b.tab(0).textL(¤¤priority);
/* 221 */     b.tab(3).textL(Dic.¤¤Employees);
/* 222 */     b.tab(7).textL(((STATS.WORK()).WORK_FULFILLMENT.info()).name);
/* 223 */     b.tab(10).textL(Dic.¤¤Skill);
/* 224 */     b.NL();
/*     */     
/* 226 */     for (WGROUP g : WGROUP.all()) {
/*     */       
/* 228 */       int tt = this.emp.target.group(g);
/* 229 */       if (tt > 0) {
/* 230 */         b.add(g.icon);
/*     */         
/* 232 */         b.tab(1);
/* 233 */         double wf = STATS.WORK().workforce(g);
/* 234 */         b.add((SPRITE)GFORMAT.i(b.text(), this.emp.priorities.get(g)));
/* 235 */         b.tab(3);
/* 236 */         b.add((SPRITE)GFORMAT.i(b.text(), tt));
/* 237 */         b.tab(5);
/* 238 */         b.add((SPRITE)GFORMAT.perc(b.text(), (wf == 0.0D) ? 0.0D : (tt / wf)));
/* 239 */         b.tab(7);
/* 240 */         b.add((SPRITE)GFORMAT.percInc(b.text(), g.race.pref().getWork((RoomEmploymentSimple)this.emp)));
/* 241 */         b.tab(10);
/* 242 */         b.add((SPRITE)GFORMAT.perc(b.text(), RACES.boosts().skill(g.race, (RoomEmploymentSimple)this.emp)));
/* 243 */         b.NL(2);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 250 */     super.hoverInfoSelf(text);
/*     */   }
/*     */   
/*     */   private class Chunk
/*     */     extends GuiSection
/*     */   {
/*     */     public final int prio;
/*     */     
/*     */     public Chunk(int prio) {
/* 259 */       this.prio = prio;
/* 260 */       body().setDim(Row.EW, Row.HH);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 266 */       if (hoveredIs() && Row.this.dragging != null) {
/* 267 */         Row.this.draggingTo = this;
/*     */       }
/* 269 */       int x1 = body().x1();
/* 270 */       int y1 = body().y1();
/*     */       
/* 272 */       clear();
/* 273 */       body().setDim(Row.EW, Row.HH);
/* 274 */       body().moveX1Y1(x1, y1);
/* 275 */       arrange();
/*     */ 
/*     */       
/* 278 */       GButt.ButtPanel.renderBG(r, true, false, (Row.this.draggingTo == this), (RECTANGLE)body());
/* 279 */       if (this.prio == 0) {
/* 280 */         OPACITY.O50.bind();
/* 281 */         COLOR.RED100.render(r, (RECTANGLE)body(), -4);
/* 282 */         OPACITY.unbind();
/*     */       } 
/* 284 */       GCOLOR.UI().border().render(r, body().x1(), body().x1() + 1, body().y1() + 6, body().y2() - 6);
/*     */       
/* 286 */       Row.Card hov = null;
/* 287 */       for (Row.Card c : Row.this.cards) {
/* 288 */         if (is(c) && c.hoveredIs())
/* 289 */           hov = c; 
/*     */       } 
/* 291 */       super.render(r, ds);
/*     */       
/* 293 */       if (hov != null) {
/* 294 */         hov.render(r, ds, true, false, true);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void arrange() {
/* 301 */       int am = 0;
/* 302 */       for (Row.Card c : Row.this.cards) {
/* 303 */         if (is(c)) {
/* 304 */           am++;
/*     */         }
/*     */       } 
/* 307 */       if (am == 0) {
/*     */         return;
/*     */       }
/* 310 */       double ww = (Row.EW - 2 * Row.MM - ((Row.Card)Row.this.cards.get(0)).body.width());
/*     */ 
/*     */       
/* 313 */       double dx = ww;
/* 314 */       am = (int)Math.ceil(am / 2.0D);
/* 315 */       if (am > 0)
/* 316 */         dx /= am; 
/* 317 */       if (dx > ((Row.Card)Row.this.cards.get(0)).body.width())
/* 318 */         dx = ((Row.Card)Row.this.cards.get(0)).body.width(); 
/* 319 */       double x1 = (body().x1() + Row.MM);
/* 320 */       int y1 = body().y1() + (body().height() - ((Row.Card)Row.this.cards.get(0)).body.height() * 2) / 2;
/*     */ 
/*     */       
/* 323 */       for (Row.Card c : Row.this.cards) {
/* 324 */         if (is(c)) {
/* 325 */           add((RENDEROBJ)c, (int)x1, y1);
/* 326 */           x1 += dx;
/* 327 */           if (x1 > (body().x2() - ((Row.Card)Row.this.cards.get(0)).body.width() - Row.MM)) {
/* 328 */             y1 += ((Row.Card)Row.this.cards.get(0)).body.height();
/* 329 */             x1 = (body().x1() + Row.MM);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean is(Row.Card c) {
/* 338 */       if (!Row.this.groupFilter.active(c.g))
/* 339 */         return false; 
/* 340 */       int p = CLAMP.i(Row.this.emp.priorities.get(c.e), 0, Row.this.emp.priorities.max(c.e));
/* 341 */       return (p == this.prio);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 346 */       super.hoverInfoGet(text);
/* 347 */       GBox b = (GBox)text;
/* 348 */       if (text.emptyIs()) {
/* 349 */         b.textLL(Row.¤¤priority);
/* 350 */         b.add((SPRITE)b.text().add(this.prio));
/* 351 */         if (this.prio == Row.this.emp.priorities.max(null)) {
/* 352 */           b.text(Row.¤¤highest);
/* 353 */         } else if (this.prio == 1) {
/* 354 */           b.text(Row.¤¤lowest);
/* 355 */         } else if (this.prio == 0) {
/* 356 */           b.title(Row.¤¤ban);
/* 357 */           b.NL();
/* 358 */           b.text(Row.¤¤banD);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class Card
/*     */     extends GButt.ButtPanel
/*     */   {
/*     */     private final Filter.FilterEntry<WGROUP> g;
/*     */     private final WGROUP e;
/*     */     
/*     */     Card(Filter.FilterEntry<WGROUP> g, SPRITE icon) {
/* 372 */       super(icon);
/* 373 */       this.g = g;
/* 374 */       this.e = (WGROUP)g.o;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 379 */       Row.this.dragging = this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 385 */       if (Row.this.dragging != null && Row.this.dragging != this)
/* 386 */         this.isHovered = false; 
/* 387 */       super.renAction();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 392 */       isSelected = (Row.this.dragging == this);
/* 393 */       GMeter.render(r, GMeter.C_ORANGE, ds, (RECTANGLE)this.body);
/* 394 */       super.render(r, ds, isActive, isSelected, isHovered);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 400 */       GBox b = (GBox)text;
/*     */ 
/*     */       
/* 403 */       b.add((SPRITE)(Row.this.emp.blueprint()).icon);
/* 404 */       b.textLL((CharSequence)b.text().add((Row.this.emp.blueprint()).info.names).s().add('-').add('>').s().add(this.g.name));
/* 405 */       b.NL();
/*     */       
/* 407 */       b.textLL(this.e.name);
/* 408 */       b.tab(6);
/* 409 */       b.add((SPRITE)GFORMAT.i(b.text(), Row.this.emp.target.group(this.e)));
/* 410 */       b.NL();
/*     */       
/* 412 */       b.textLL(((STANDINGS.CITIZEN()).fullfillment.info()).name);
/* 413 */       b.tab(6);
/* 414 */       b.add((SPRITE)GFORMAT.perc(b.text(), this.e.race.pref().getWork((RoomEmploymentSimple)Row.this.emp)));
/* 415 */       b.NL();
/*     */       
/* 417 */       if (Row.this.emp.blueprint().bonus() != null) {
/* 418 */         b.textLL(Dic.¤¤Skill);
/* 419 */         b.tab(6);
/* 420 */         b.add((SPRITE)GFORMAT.perc(b.text(), this.e.race.bvalue(Row.this.emp.blueprint().bonus())));
/* 421 */         b.NL();
/*     */       } 
/*     */       
/* 424 */       b.textLL((CharSequence)b.text().add((Row.this.emp.blueprint()).info.name).s().add(Row.¤¤employedTarget));
/* 425 */       b.tab(6);
/* 426 */       b.add((SPRITE)GFORMAT.i(b.text(), Row.this.emp.target.get()));
/* 427 */       b.NL();
/*     */ 
/*     */       
/* 430 */       b.sep();
/*     */ 
/*     */       
/* 433 */       b.add(this.e.icon);
/* 434 */       b.textLL((CharSequence)b.text().add(this.g.name).s().add('(').add(Dic.¤¤Total).add(')'));
/* 435 */       b.NL();
/*     */       
/* 437 */       b.textLL(Row.¤¤workForce);
/* 438 */       b.tab(6);
/* 439 */       b.add((SPRITE)GFORMAT.i(b.text(), STATS.WORK().workforce(this.e)));
/* 440 */       b.NL();
/*     */       
/* 442 */       b.textLL(Row.¤¤employed);
/* 443 */       b.tab(6);
/* 444 */       b.add((SPRITE)GFORMAT.i(b.text(), (SETT.ROOMS()).employment.TARGET.get(this.e)));
/* 445 */       b.NL();
/*     */       
/* 447 */       double f = 0.0D;
/* 448 */       double am = 0.0D;
/* 449 */       for (RoomEmployment p : (SETT.ROOMS()).employment.ALL()) {
/* 450 */         f += this.e.race.pref().getWork((RoomEmploymentSimple)p) * p.target.group(this.e);
/* 451 */         am += p.target.group(this.e);
/*     */       } 
/* 453 */       if (am > 0.0D)
/* 454 */         f /= am; 
/* 455 */       b.textLL(((STANDINGS.CITIZEN()).fullfillment.info()).name);
/* 456 */       b.tab(6);
/* 457 */       b.add((SPRITE)GFORMAT.perc(b.text(), f));
/* 458 */       b.NL();
/*     */       
/* 460 */       f = 0.0D;
/* 461 */       am = 0.0D;
/* 462 */       for (RoomEmployment p : (SETT.ROOMS()).employment.ALL()) {
/* 463 */         if (p.blueprint().bonus() != null) {
/* 464 */           f += this.e.race.bvalue(p.blueprint().bonus()) * p.target.group(this.e);
/*     */         }
/* 466 */         am += p.target.group(this.e);
/*     */       } 
/* 468 */       if (am > 0.0D)
/* 469 */         f /= am; 
/* 470 */       b.textLL(Dic.¤¤Skill);
/* 471 */       b.tab(6);
/* 472 */       b.add((SPRITE)GFORMAT.perc(b.text(), f));
/* 473 */       b.NL();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class Header
/*     */     extends GuiSection
/*     */   {
/*     */     Header(final RoomEmployment e) {
/* 486 */       add((SPRITE)e.blueprint().iconBig(), 0, 0);
/*     */       
/* 488 */       addDownC(0, (RENDEROBJ)new GTarget(20, false, true, (INT.INTE)e.priority));
/*     */ 
/*     */       
/* 491 */       SPRITE.Imp imp = new SPRITE.Imp(60, 14)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 495 */             double dd = 1.0D;
/* 496 */             double n = e.neededWorkers();
/* 497 */             GMeter.GMeterCol cc = GMeter.C_GREEN;
/* 498 */             if (n > 0.0D) {
/* 499 */               dd = e.target.get() / n;
/* 500 */               if (dd < 1.0D) {
/* 501 */                 cc = GMeter.C_RED;
/*     */               }
/*     */             } 
/* 504 */             GMeter.render(r, cc, dd, X1, X2, Y1, Y2);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 509 */       addRelBody(-4, DIR.N, (SPRITE)imp);
/* 510 */       addOnTopC((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 514 */               GFORMAT.i(text, (Row.Header.access$0(Row.Header.this)).emp.target.get());
/*     */             }
/* 516 */           }).bg().r(DIR.N));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\priority\Row.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */