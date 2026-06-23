/*     */ package view.sett;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HGROUP;
/*     */ import init.type.HTYPES;
/*     */ import java.util.LinkedList;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.disease.StatsDisease;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.SettUI;
/*     */ import view.ui.top.UIPanelTop;
/*     */ import view.ui.top.UIPanelTopButtL;
/*     */ import view.ui.top.UIPanelTopButtS;
/*     */ 
/*     */ public final class UIPanelTopSett
/*     */ {
/*  47 */   private static LinkedList<RENDEROBJ> extrabutts = new LinkedList<>();
/*     */   public static void addExtraElement(RENDEROBJ o) {
/*  49 */     extrabutts.add(o);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int i;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   UIPanelTopSett(final SettUI ui, SettView w, UIPanelTop panel) {
/*  62 */     GuiSection big = new GuiSection();
/*  63 */     GuiSection small = new GuiSection();
/*     */ 
/*     */     
/*  66 */     addB(big, (RENDEROBJ)new StandingButt(HCLASSES.CITIZEN(), (ISidePanel)ui.standing), "CITIZENS");
/*  67 */     addB(big, (RENDEROBJ)new StandingButt(HCLASSES.SLAVE(), (ISidePanel)ui.slaves), "SLAVES");
/*  68 */     UIPanelTopButtL uIPanelTopButtL = new UIPanelTopButtL((SPRITE)(SPRITES.icons()).s.noble)
/*     */       {
/*     */         protected double valueNext()
/*     */         {
/*  72 */           return value();
/*     */         }
/*     */ 
/*     */         
/*     */         protected double value() {
/*  77 */           return 1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         protected int getNumber() {
/*  82 */           return GAME.NOBLE().active().size();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  87 */           text.title((HCLASSES.NOBLE()).names);
/*  88 */           text.text((HCLASSES.NOBLE()).desc);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean isActive() {
/*  93 */           return (getNumber() > 0);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/*  98 */           selectedSet((ui.nobles != null && (VIEW.s()).panels.added((ISidePanel)ui.nobles)));
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 103 */           if (ui.nobles != null)
/* 104 */             (VIEW.s()).panels.add((ISidePanel)ui.nobles, true); 
/*     */         }
/*     */       };
/* 107 */     addB(big, (RENDEROBJ)uIPanelTopButtL, "NOBLES");
/*     */     
/* 109 */     uIPanelTopButtL = new UIPanelTopButtL((SPRITE)(SPRITES.icons()).s.hammer)
/*     */       {
/*     */         protected double valueNext()
/*     */         {
/* 113 */           return value();
/*     */         }
/*     */ 
/*     */         
/*     */         protected double value() {
/* 118 */           double t = STATS.WORK().workforce();
/* 119 */           double e = (SETT.ROOMS()).employment.NEEDED.get();
/* 120 */           if (t == 0.0D)
/* 121 */             return ((e > 0.0D) ? false : true); 
/* 122 */           return CLAMP.d(t / e, 0.0D, 2.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         protected int getNumber() {
/* 127 */           int t = STATS.WORK().workforce();
/* 128 */           int e = (SETT.ROOMS()).employment.NEEDED.get();
/* 129 */           return t - e;
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 134 */           GBox b = (GBox)text;
/*     */           
/* 136 */           b.title(Dic.¤¤Workforce);
/* 137 */           b.text(Dic.¤¤WorkforceD);
/* 138 */           b.NL();
/*     */           
/* 140 */           int e = STATS.WORK().workforce();
/* 141 */           int t = (SETT.ROOMS()).employment.NEEDED.get();
/*     */           
/* 143 */           b.textLL(Dic.¤¤Needed);
/* 144 */           b.tab(7);
/* 145 */           b.add((SPRITE)GFORMAT.i(b.text(), t));
/* 146 */           b.NL();
/*     */           
/* 148 */           b.textLL(Dic.¤¤Employees);
/* 149 */           b.tab(7);
/* 150 */           b.add((SPRITE)GFORMAT.i(b.text(), e));
/* 151 */           b.NL();
/*     */           
/* 153 */           b.textLL(Dic.¤¤Oddjobbers);
/* 154 */           b.tab(7);
/* 155 */           b.add((SPRITE)GFORMAT.i(b.text(), (e - t)));
/* 156 */           b.NL();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean isActive() {
/* 162 */           return (STATS.WORK().workforce() > 0);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 167 */           selectedSet((ui.rooms.main() != null && (VIEW.s()).panels.added(ui.rooms.main())));
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 172 */           if (ui.rooms.main() != null)
/* 173 */             (VIEW.s()).panels.add(ui.rooms.main(), true); 
/*     */         }
/*     */       };
/* 176 */     addB(big, (RENDEROBJ)uIPanelTopButtL, "ROOMS");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 183 */     Buttt buttt = new Buttt((SPRITE)(SPRITES.icons()).s.human, (ISidePanel)ui.subjects.list)
/*     */       {
/*     */         protected double valueNext()
/*     */         {
/* 187 */           return value();
/*     */         }
/*     */ 
/*     */         
/*     */         protected double value() {
/* 192 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 197 */           (VIEW.s()).ui.subjects.show();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected int getNumber() {
/* 203 */           int p = POP.tot();
/* 204 */           return p;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 211 */           text.title(((STATS.POP()).POP.info()).name);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean isActive() {
/* 216 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, SPRITE label, GStat stat, boolean active) {
/* 222 */           active = true;
/* 223 */           super.render(r, label, stat, active);
/*     */         }
/*     */       };
/* 226 */     add(small, (RENDEROBJ)buttt, "SUBJECTS");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 248 */     buttt = new Buttt((SPRITE)(SPRITES.icons()).s.house, (ISidePanel)ui.home)
/*     */       {
/*     */         protected double valueNext()
/*     */         {
/* 252 */           return value();
/*     */         }
/*     */ 
/*     */         
/*     */         protected double value() {
/* 257 */           double pop = (STATS.POP()).POP.data(null).get(null);
/* 258 */           if (pop == 0.0D)
/* 259 */             return 1.0D; 
/* 260 */           double d = MATH.pow15.pow((pop - (STATS.HOME()).GETTER.hasSearched.data(null).get(null)) / pop);
/* 261 */           if (d >= 1.0D) {
/* 262 */             d += ((SETT.ROOMS()).HOME.total(null) - (SETT.ROOMS()).HOME.used(null)) / (pop + 1.0D);
/*     */           }
/* 264 */           return d;
/*     */         }
/*     */         
/* 267 */         int hi = 0;
/* 268 */         int min = 0;
/* 269 */         int proc = 0;
/*     */ 
/*     */ 
/*     */         
/*     */         protected int getNumber() {
/* 274 */           if (this.hi >= HGROUP.all().size()) {
/* 275 */             this.hi = 0;
/* 276 */             if (this.proc == Integer.MAX_VALUE)
/* 277 */               this.proc = 0; 
/* 278 */             this.min = this.proc;
/* 279 */             this.proc = Integer.MAX_VALUE;
/*     */           } 
/*     */           
/* 282 */           HGROUP t = (HGROUP)HGROUP.all().get(this.hi);
/*     */           
/* 284 */           int i = (SETT.ROOMS()).HOME.total((HGROUP)HGROUP.all().get(this.hi));
/* 285 */           int p = (STATS.POP()).POP.data(t.type).get(t.race);
/* 286 */           if (p > 0) {
/* 287 */             i -= (STATS.POP()).POP.data(t.type).get(t.race);
/* 288 */             this.proc = Math.min(this.proc, i);
/*     */           } 
/*     */ 
/*     */           
/* 292 */           this.hi++;
/*     */           
/* 294 */           return this.min;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 300 */           text.title(Dic.¤¤Housing);
/* 301 */           GBox b = (GBox)text;
/*     */           
/* 303 */           b.tab(2);
/* 304 */           b.textLL(Dic.¤¤HomeLess);
/* 305 */           b.NL();
/*     */           
/* 307 */           STAT s = (STATS.HOME()).GETTER.hasSearched;
/*     */           
/* 309 */           b.NL();
/* 310 */           b.tab(6);
/* 311 */           b.textLL((HCLASSES.CITIZEN()).names);
/* 312 */           b.tab(9);
/* 313 */           b.textLL((HCLASSES.SLAVE()).names);
/* 314 */           b.tab(12);
/* 315 */           b.textLL((HCLASSES.NOBLE()).names);
/* 316 */           b.NL();
/* 317 */           for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 318 */             Race r = (FACTIONS.player()).races.get(ri);
/* 319 */             b.add((SPRITE)(r.appearance()).icon);
/* 320 */             b.textL(r.info.names);
/* 321 */             b.tab(6);
/* 322 */             b.add((SPRITE)GFORMAT.i(b.text(), s.data(HCLASSES.CITIZEN()).get(r)));
/* 323 */             b.tab(9);
/* 324 */             b.add((SPRITE)GFORMAT.i(b.text(), s.data(HCLASSES.SLAVE()).get(r)));
/* 325 */             b.tab(12);
/* 326 */             b.add((SPRITE)GFORMAT.i(b.text(), s.data(HCLASSES.NOBLE()).get(r)));
/* 327 */             b.NL();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean isActive() {
/* 333 */           return true;
/*     */         }
/*     */       };
/* 336 */     add(small, (RENDEROBJ)buttt, "HOUSING");
/*     */ 
/*     */     
/* 339 */     buttt = new Buttt((SPRITE)(SPRITES.icons()).s.law, (ISidePanel)ui.law)
/*     */       {
/*     */         protected double valueNext()
/*     */         {
/* 343 */           return (BOOSTABLES.CIVICS()).LAW.get((BOOSTABLE_O)HCLASS_RACE.clP());
/*     */         }
/*     */ 
/*     */         
/*     */         protected double value() {
/* 348 */           return (BOOSTABLES.CIVICS()).LAW.get((BOOSTABLE_O)HCLASS_RACE.clP());
/*     */         }
/*     */ 
/*     */         
/*     */         protected int getNumber() {
/* 353 */           return STATS.POP().pop(HTYPES.PRISONER());
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 358 */           GBox b = (GBox)text;
/*     */           
/* 360 */           b.title(Dic.¤¤Law);
/*     */           
/* 362 */           b.textLL((HTYPES.PRISONER()).names);
/* 363 */           b.tab(7);
/* 364 */           b.add((SPRITE)GFORMAT.i(b.text(), STATS.POP().pop(HTYPES.PRISONER())));
/* 365 */           b.NL();
/* 366 */           b.text((HTYPES.PRISONER()).desc);
/* 367 */           b.NL(7);
/*     */           
/* 369 */           b.sep();
/*     */           
/* 371 */           (BOOSTABLES.CIVICS()).LAW.hover((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(), false);
/*     */           
/* 373 */           b.sep();
/*     */           
/* 375 */           (BOOSTABLES.BEHAVIOUR()).LAWFULNESS.hover((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(), false);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean isActive() {
/* 381 */           return true;
/*     */         }
/*     */       };
/* 384 */     add(small, (RENDEROBJ)buttt, "LAW");
/*     */     
/* 386 */     buttt = new Buttt((SPRITE)(SPRITES.icons()).s.sword, (ISidePanel)ui.army)
/*     */       {
/*     */         
/*     */         protected double valueNext()
/*     */         {
/* 391 */           return 1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double value() {
/* 396 */           int tot = getNumber();
/* 397 */           if (tot == 0)
/* 398 */             return 1.0D; 
/* 399 */           return (STATS.BATTLE()).DIV.stat().data(null).get(null, 0) / tot;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected int getNumber() {
/* 405 */           return (STATS.BATTLE()).DIV.stat().data(null).get(null, 0) + (STATS.BATTLE()).RECRUIT.stat().data(null).get(null, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 410 */           GBox b = (GBox)text;
/* 411 */           b.title(Dic.¤¤Army);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 416 */           b.textL(Dic.¤¤Soldiers);
/* 417 */           b.tab(7);
/* 418 */           b.add((SPRITE)GFORMAT.i(b.text(), getNumber()));
/* 419 */           b.NL();
/* 420 */           b.textL(Dic.¤¤Recruits);
/* 421 */           b.tab(7);
/* 422 */           b.add((SPRITE)GFORMAT.i(b.text(), (STATS.BATTLE()).RECRUIT.stat().data(null).get(null, 0)));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean isActive() {
/* 429 */           return (getNumber() > 0);
/*     */         }
/*     */       };
/* 432 */     add(small, (RENDEROBJ)buttt, "ARMY");
/*     */     
/* 434 */     buttt = new Buttt((SPRITE)(SPRITES.icons()).s.heart, (ISidePanel)(VIEW.UI()).health)
/*     */       {
/*     */         protected double valueNext()
/*     */         {
/* 438 */           return (STATS.DISEASE()).healthHistory.getD(0);
/*     */         }
/*     */ 
/*     */         
/*     */         protected double value() {
/* 443 */           return (STATS.DISEASE()).healthHistory.getD(1);
/*     */         }
/*     */ 
/*     */         
/*     */         protected int getNumber() {
/* 448 */           return STATS.DISEASE().sick().data().get(null);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 453 */           GBox b = (GBox)text;
/* 454 */           b.title((BOOSTABLES.PHYSICS()).HEALTH.name);
/* 455 */           b.text((BOOSTABLES.PHYSICS()).HEALTH.desc);
/* 456 */           b.sep();
/* 457 */           if ((STATS.DISEASE()).healthHistory.getD(0) < 1.0D) {
/* 458 */             b.error(StatsDisease.¤¤low);
/*     */           } else {
/* 460 */             b.text(StatsDisease.¤¤high);
/*     */           } 
/*     */           
/* 463 */           b.NL();
/* 464 */           b.textLL((STATS.DISEASE().sick().info()).name);
/* 465 */           b.tab(6);
/* 466 */           b.add((SPRITE)GFORMAT.i(b.text(), STATS.DISEASE().sick().data().get(null)));
/* 467 */           b.sep();
/*     */           
/* 469 */           (BOOSTABLES.PHYSICS()).HEALTH.hover(text, (BOOSTABLE_O)HCLASS_RACE.clP(), Dic.¤¤Boosts, true);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean isActive() {
/* 474 */           return true;
/*     */         }
/*     */       };
/*     */     
/* 478 */     add(small, (RENDEROBJ)buttt, "HEALTH");
/*     */ 
/*     */     
/* 481 */     buttt = new Buttt((SPRITE)(SPRITES.icons()).s.plate, (ISidePanel)ui.prod)
/*     */       {
/*     */         
/*     */         protected double valueNext()
/*     */         {
/* 486 */           return (STATS.FOOD()).FOOD_DAYS.data().getD(null);
/*     */         }
/*     */ 
/*     */         
/*     */         protected double value() {
/* 491 */           return (STATS.FOOD()).FOOD_DAYS.data().getPeriodD(null, 8, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         protected int getNumber() {
/* 496 */           return (int)((STATS.FOOD()).FOOD_DAYS.data(null).getD(null, 0) * (STATS.FOOD()).FOOD_DAYS.dataDivider());
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 501 */           text.title(Dic.¤¤Food);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean isActive() {
/* 506 */           return true;
/*     */         }
/*     */       };
/*     */     
/* 510 */     add(small, (RENDEROBJ)buttt, "PRODUCTION");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 519 */     GuiSection s = new GuiSection();
/* 520 */     s.add((RENDEROBJ)big);
/* 521 */     s.addRightC(0, (RENDEROBJ)small);
/*     */ 
/*     */     
/* 524 */     if ((S.get()).developer) {
/* 525 */       CLICKABLE cLICKABLE = (new GButt.Glow((SPRITE)(SPRITES.icons()).s.cog)
/*     */         {
/*     */           protected void clickA() {
/* 528 */             (VIEW.s()).debug.show();
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 532 */             selectedSet((VIEW.s()).debug.isActivated());
/*     */           }
/* 534 */         }).hoverInfoSet("developer tools");
/* 535 */       s.addRelBody(8, DIR.E, (RENDEROBJ)cLICKABLE);
/*     */     } 
/*     */     
/* 538 */     panel.addLeft(s);
/*     */ 
/*     */     
/* 541 */     s = new GuiSection();
/*     */     
/* 543 */     s.addRightC(0, (RENDEROBJ)GAME.EVENT().butt());
/* 544 */     s.addRightC(0, UIPanelTop.junk());
/* 545 */     s.addRightC(0, (RENDEROBJ)UIPanelTop.messages());
/* 546 */     s.addRightC(0, (RENDEROBJ)UIPanelTop.advice());
/* 547 */     s.addRightC(0, UIPanelTop.vToggle());
/* 548 */     s.addRightC(0, UIPanelTop.bToggle());
/*     */     
/* 550 */     panel.addRightRight(s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void add(GuiSection bb, RENDEROBJ o, String key) {
/* 559 */     bb.add(o, this.i / 2 * UIPanelTopButtS.width(), this.i % 2 * 24);
/* 560 */     this.i++;
/* 561 */     UISettMap.add(o, key);
/*     */   }
/*     */   
/*     */   private void addB(GuiSection bb, RENDEROBJ o, String key) {
/* 565 */     bb.addRightC(0, o);
/* 566 */     UISettMap.add(o, key);
/*     */   }
/*     */   
/*     */   private static class StandingButt
/*     */     extends UIPanelTopButtL {
/*     */     private final HCLASS c;
/*     */     private final ISidePanel p;
/*     */     
/*     */     public StandingButt(HCLASS c, ISidePanel p) {
/* 575 */       super((SPRITE)c.iconSmall());
/* 576 */       this.c = c;
/* 577 */       this.p = p;
/*     */     }
/*     */ 
/*     */     
/*     */     protected int getNumber() {
/* 582 */       return POP.tot(this.c, null);
/*     */     }
/*     */ 
/*     */     
/*     */     protected double value() {
/* 587 */       return v(STANDINGS.get(this.c).current());
/*     */     }
/*     */ 
/*     */     
/*     */     protected double valueNext() {
/* 592 */       return v(STANDINGS.get(this.c).target());
/*     */     }
/*     */     
/*     */     private double v(double v) {
/* 596 */       v = (int)(100.0D * v) / 100.0D;
/* 597 */       return v;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 602 */       GBox b = (GBox)text;
/* 603 */       b.title(this.c.names);
/*     */       
/* 605 */       b.textLL(this.c.names);
/* 606 */       b.tab(7);
/* 607 */       b.add((SPRITE)GFORMAT.i(b.text(), (STATS.POP()).POP.data(this.c).get(null)));
/* 608 */       GText t = b.text();
/* 609 */       t.add('(').add('+').add((POP.tot(this.c, null) - (STATS.POP()).POP.data(this.c).get(null))).add(')');
/* 610 */       b.NL();
/* 611 */       b.text(this.c.desc);
/* 612 */       b.NL(7);
/*     */       
/* 614 */       b.textLL((STANDINGS.get(this.c).info()).name);
/* 615 */       b.tab(7);
/* 616 */       b.add((SPRITE)GFORMAT.perc(b.text(), STANDINGS.get(this.c).current()));
/* 617 */       b.add((SPRITE)(SPRITES.icons()).m.arrow_right);
/* 618 */       b.add((SPRITE)GFORMAT.perc(b.text(), STANDINGS.get(this.c).target()));
/* 619 */       b.NL();
/* 620 */       b.text((STANDINGS.get(this.c).info()).desc);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isActive() {
/* 625 */       return ((STATS.POP()).POP.data(this.c).get(null) != 0);
/*     */     }
/*     */     
/*     */     protected void renAction() {
/* 629 */       selectedSet((this.p != null && (VIEW.s()).panels.added(this.p)));
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 634 */       if (this.p != null) {
/* 635 */         (VIEW.s()).panels.add(this.p, true);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static abstract class Buttt
/*     */     extends UIPanelTopButtS
/*     */   {
/*     */     private final ISidePanel p;
/*     */     
/*     */     public Buttt(SPRITE icon, ISidePanel p) {
/* 646 */       super(icon);
/* 647 */       this.p = p;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 652 */       selectedSet((this.p != null && (VIEW.s()).panels.added(this.p)));
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 657 */       if (this.p != null)
/* 658 */         (VIEW.s()).panels.add(this.p, true); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\sett\UIPanelTopSett.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */