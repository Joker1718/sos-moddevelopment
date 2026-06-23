/*     */ package view.sett.ui.law;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CRIMES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.law.PUNISHMENT_SERVICE;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.law.StatCrime;
/*     */ import settlement.stats.law.StatPunishment;
/*     */ import settlement.stats.law.StatsLaw;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.ui.div.UIGuardDivSelector;
/*     */ 
/*     */ class UILawCrimeList extends GuiSection {
/*  48 */   private final GuiSection pop = new GuiSection();
/*     */   private final Selector sel;
/*     */   private StatCrime crimeToSet;
/*  51 */   private double hiLaw = 0.0D;
/*  52 */   private double loyTarget = 0.0D;
/*  53 */   private double loyCurrent = 0.0D;
/*  54 */   private double hapCurrent = 0.0D;
/*  55 */   private double hapTarget = 0.0D;
/*  56 */   private double lawTarget = 0.0D;
/*  57 */   private double lawCurrent = 0.0D;
/*     */   
/*     */   private final HCLASS cl;
/*  60 */   private static CharSequence ¤¤desc = "Punishing a crime yields law, which in turn yields loyalty/submission. But it also affects happiness in the form of tyranny. Each combination is unique for every species.";
/*  61 */   private static CharSequence ¤¤tyranny = "Tyranny";
/*  62 */   private static CharSequence ¤¤selectGood = "This punishment is a good choice under the current circumstances and will increase net {0}!";
/*  63 */   private static CharSequence ¤¤selectBad = "This punishment and crime combination is too harsh, and the net {0} will decrease. Get more guards and other law boost in order to benefit from this combination.";
/*     */ 
/*     */   
/*     */   static {
/*  67 */     D.ts(UILawCrimeList.class);
/*     */   }
/*     */   
/*     */   UILawCrimeList(int height, final HCLASS cl) {
/*  71 */     this.sel = new Selector(height, CRIMES.all(cl));
/*  72 */     this.cl = cl;
/*     */ 
/*     */ 
/*     */     
/*  76 */     int dd = 280;
/*  77 */     int ww = 170;
/*     */     
/*  79 */     GuiSection guiSection2 = new GuiSection();
/*  80 */     guiSection2.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  84 */             GFORMAT.f(text, (BOOSTABLES.BEHAVIOUR()).LAWFULNESS.get((BOOSTABLE_O)HCLASS_RACE.clP(UILawCrimeList.this.sel.getRace(), cl)), 1);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  89 */             b.title((BOOSTABLES.BEHAVIOUR()).LAWFULNESS.name);
/*  90 */             b.text((BOOSTABLES.BEHAVIOUR()).LAWFULNESS.desc);
/*  91 */             b.sep();
/*  92 */             (BOOSTABLES.BEHAVIOUR()).LAWFULNESS.hoverDetailed((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(UILawCrimeList.this.sel.getRace(), cl), null, true);
/*     */           }
/*  95 */         }).increase().hh((BOOSTABLES.BEHAVIOUR()).LAWFULNESS.name, ww));
/*     */     
/*  97 */     guiSection2.addRightCAbs(dd, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 101 */             GFORMAT.f0(text, (BOOSTABLES.CIVICS()).LAW.get((BOOSTABLE_O)HCLASS_RACE.clP(UILawCrimeList.this.sel.getRace(), cl)));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 106 */             b.title((BOOSTABLES.CIVICS()).LAW.name);
/* 107 */             b.text((BOOSTABLES.CIVICS()).LAW.desc);
/* 108 */             b.sep();
/* 109 */             (BOOSTABLES.CIVICS()).LAW.hoverDetailed((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(UILawCrimeList.this.sel.getRace(), cl), null, true);
/*     */           }
/* 113 */         }).increase().hh((BOOSTABLES.CIVICS()).LAW.name, ww));
/*     */ 
/*     */ 
/*     */     
/* 117 */     guiSection2.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 121 */             GFORMAT.percInc(text, (UILawCrimeList.this.sel.getRace() == null) ? STATS.LAW().tyrrany(cl, UILawCrimeList.this.sel.getRace()) : target(), 0);
/* 122 */             text.errorify();
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 127 */             b.title(UILawCrimeList.¤¤tyranny);
/* 128 */             b.text(StatsLaw.¤¤tyrannyD);
/* 129 */             b.NL(8);
/*     */             
/* 131 */             if (UILawCrimeList.this.sel.getRace() == null) {
/*     */               return;
/*     */             }
/* 134 */             b.textLL(Dic.¤¤Current);
/* 135 */             b.tab(6);
/* 136 */             b.add((SPRITE)GFORMAT.percInv(b.text(), STATS.LAW().tyrrany(cl, UILawCrimeList.this.sel.getRace())));
/* 137 */             b.NL();
/* 138 */             b.textLL(Dic.¤¤Target);
/* 139 */             b.tab(6);
/* 140 */             b.add((SPRITE)GFORMAT.percInv(b.text(), target()));
/* 141 */             b.NL();
/*     */           }
/*     */           
/*     */           private double target() {
/* 145 */             double t = 0.0D;
/* 146 */             for (CRIMES.CRIME c : CRIMES.all(cl)) {
/* 147 */               t += c.tyrrany(cl, UILawCrimeList.this.sel.getRace(), (c.stat().punishment(cl, UILawCrimeList.this.sel.getRace())).punish);
/*     */             }
/* 149 */             return t;
/*     */           }
/* 152 */         }).increase().hh(¤¤tyranny, ww), 0, guiSection2.body().y2() + 16);
/*     */     
/* 154 */     SPRITE sp = (new GStat(new GText((UI.FONT()).M, "1000%"))
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 158 */           GFORMAT.perc(text, (STATS.LAW()).guards.data(cl).getD(UILawCrimeList.this.sel.getRace()), 0);
/*     */         }
/* 161 */       }).increase().hh((HTYPES.GUARD()).names, ww).asSprite();
/*     */     
/* 163 */     guiSection2.addRightCAbs(dd, (RENDEROBJ)(new GButt.ButtPanel(sp)
/*     */         {
/* 165 */           private final UIGuardDivSelector pop = new UIGuardDivSelector();
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 169 */             (VIEW.inters()).popup.show((RENDEROBJ)this.pop, (CLICKABLE)this);
/* 170 */             super.clickA();
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 175 */             STATS.LAW().hoverGuards(text, cl, UILawCrimeList.this.sel.getRace());
/*     */           }
/* 178 */         }).pad(8, 2));
/* 179 */     guiSection2.body().incrW(80.0D);
/* 180 */     addRelBody(8, DIR.S, (RENDEROBJ)guiSection2);
/*     */ 
/*     */ 
/*     */     
/* 184 */     GuiSection guiSection1 = new GuiSection();
/* 185 */     guiSection1.add((RENDEROBJ)new CrimeChart(9, cl, this.sel));
/* 186 */     guiSection1.addRelBody(8, DIR.E, (RENDEROBJ)new LawChart(9, cl, this.sel));
/*     */     
/* 188 */     addRelBody(8, DIR.S, (RENDEROBJ)guiSection1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 193 */     GRows rr = new GRows(8);
/* 194 */     for (StatPunishment p : (STATS.LAW()).punishments) {
/* 195 */       if (!p.punish.available(cl))
/*     */         continue; 
/* 197 */       rr.add((RENDEROBJ)new PunButt(p));
/*     */     } 
/* 199 */     for (RENDEROBJ o : rr.rows()) {
/* 200 */       this.pop.addDown(0, o);
/*     */     }
/*     */ 
/*     */     
/* 204 */     ArrayListGrower<RENDEROBJ> rows = new ArrayListGrower();
/* 205 */     for (CRIMES.CRIME c : CRIMES.all(cl)) {
/* 206 */       rows.add(crimeRow(cl, (StatCrime)(STATS.LAW()).crimes.get(c.index())));
/*     */     }
/* 208 */     addRelBody(8, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)rows, ((RENDEROBJ)rows.get(0)).body().height() * 8)).view());
/*     */ 
/*     */ 
/*     */     
/* 212 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 216 */           if (UILawCrimeList.this.sel.getRace() == null)
/*     */             return; 
/* 218 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 223 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 227 */             GFORMAT.percInc(text, UILawCrimeList.this.hapCurrent, 0);
/* 228 */             text.s().add('-').add('>').s();
/* 229 */             GFORMAT.percInc(text, UILawCrimeList.this.hapTarget, 0);
/*     */           }
/* 231 */         }).decrease().hv((STANDINGS.get(cl)).bhappiness.name));
/*     */     
/* 233 */     s.addRightC(128, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 237 */             GFORMAT.percInc(text, UILawCrimeList.this.lawCurrent, 0);
/* 238 */             text.s().add('-').add('>').s();
/* 239 */             GFORMAT.percInc(text, UILawCrimeList.this.lawTarget, 0);
/*     */           }
/* 241 */         }).decrease().hv((BOOSTABLES.CIVICS()).LAW.name));
/*     */     
/* 243 */     s.addRightC(128, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 247 */             GFORMAT.percInc(text, UILawCrimeList.this.loyCurrent, 0);
/* 248 */             text.s().add('-').add('>').s();
/* 249 */             GFORMAT.percInc(text, UILawCrimeList.this.loyTarget, 0);
/*     */           }
/* 251 */         }).decrease().hv((STANDINGS.get(cl)).bloyalty.name));
/*     */     
/* 253 */     addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */ 
/*     */     
/* 257 */     s = new GuiSection();
/* 258 */     for (RoomBlueprintImp room : SETT.ROOMS().imps()) {
/* 259 */       if (room instanceof PUNISHMENT_SERVICE) {
/*     */         
/* 261 */         PUNISHMENT_SERVICE ser = (PUNISHMENT_SERVICE)room;
/* 262 */         s.addRightC(4, service(room, ser));
/*     */       } 
/*     */     } 
/* 265 */     addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */ 
/*     */     
/* 269 */     addRelBody(8, DIR.W, (RENDEROBJ)this.sel);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 275 */     this.hiLaw = 0.0D;
/* 276 */     this.loyTarget = 0.0D;
/* 277 */     this.loyCurrent = 0.0D;
/* 278 */     this.hapTarget = 0.0D;
/* 279 */     this.hapCurrent = 0.0D;
/* 280 */     this.lawTarget = 0.0D;
/* 281 */     this.lawCurrent = 0.0D;
/* 282 */     if (this.sel.getRace() != null) {
/* 283 */       for (CRIMES.CRIME s : CRIMES.all(this.cl)) {
/* 284 */         CRIME_PUNISHMENTS.PUNISHMENT p = (s.stat().punishment(this.cl, this.sel.getRace())).punish;
/* 285 */         double cla = s.law(this.cl, this.sel.getRace()) / s.tyrrany(this.cl, this.sel.getRace());
/* 286 */         this.hiLaw = Math.max(this.hiLaw, cla);
/*     */         
/* 288 */         CRIMES.Response re = s.loyaltyInc(this.cl, this.sel.getRace(), p);
/* 289 */         this.hapTarget += re.newHap - re.oldHappiness;
/* 290 */         this.lawTarget += re.newLaw - re.oldLaw;
/* 291 */         this.loyTarget += re.diff;
/*     */         
/* 293 */         re = s.loyaltyIncCurrent(this.cl, this.sel.getRace());
/* 294 */         this.hapCurrent += re.newHap - re.oldHappiness;
/* 295 */         this.lawCurrent += re.newLaw - re.oldLaw;
/* 296 */         this.loyCurrent += re.diff;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 303 */     super.render(r, ds);
/*     */   }
/*     */   
/*     */   private class PunButt
/*     */     extends GButt.ButtPanel {
/*     */     private final StatPunishment p;
/*     */     
/*     */     PunButt(StatPunishment p) {
/* 311 */       super(p.punish.icon.scaled(2.0D));
/* 312 */       this.p = p;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 317 */       UILawCrimeList.this.crimeToSet.punishmentSet(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace(), this.p.punish);
/* 318 */       super.clickA();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 323 */       selectedSet((UILawCrimeList.this.crimeToSet.punishment(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace()) == this.p));
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 328 */       GBox b = (GBox)text;
/* 329 */       b.title(this.p.punish.action);
/*     */       
/* 331 */       CRIMES.Response rr = UILawCrimeList.this.crimeToSet.crime.loyaltyInc(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace(), this.p.punish);
/*     */       
/* 333 */       GText t = b.text();
/*     */       
/* 335 */       if (rr.diff >= 0.0D) {
/* 336 */         t.normalify2();
/* 337 */         t.add(UILawCrimeList.¤¤selectGood);
/*     */       } else {
/* 339 */         t.errorify();
/* 340 */         t.add(UILawCrimeList.¤¤selectBad);
/*     */       } 
/*     */ 
/*     */       
/* 344 */       t.insert(0, (STANDINGS.get(UILawCrimeList.this.cl)).bloyalty.name);
/* 345 */       b.add((SPRITE)t);
/* 346 */       b.NL(4);
/*     */ 
/*     */       
/* 349 */       b.add((SPRITE)(STANDINGS.get(UILawCrimeList.this.cl)).happiness.bo.icon);
/* 350 */       b.textLL((STANDINGS.get(UILawCrimeList.this.cl)).happiness.bo.name);
/* 351 */       b.tab(6);
/* 352 */       b.add((SPRITE)GFORMAT.percInc(b.text(), rr.newHap - rr.oldHappiness));
/* 353 */       b.NL();
/* 354 */       b.add((SPRITE)(BOOSTABLES.CIVICS()).LAW.icon);
/* 355 */       b.textLL((BOOSTABLES.CIVICS()).LAW.name);
/* 356 */       b.tab(6);
/* 357 */       b.add((SPRITE)GFORMAT.percInc(b.text(), rr.newLaw - rr.oldLaw));
/* 358 */       b.NL();
/* 359 */       b.add((SPRITE)(STANDINGS.get(UILawCrimeList.this.cl)).bloyalty.icon);
/* 360 */       b.textLL((STANDINGS.get(UILawCrimeList.this.cl)).bloyalty.name);
/* 361 */       b.tab(6);
/* 362 */       b.add((SPRITE)GFORMAT.percInc(b.text(), rr.diff));
/*     */       
/* 364 */       b.sep();
/*     */ 
/*     */ 
/*     */       
/* 368 */       b.text(this.p.punish.desc);
/*     */       
/* 370 */       b.NL(4);
/*     */       
/* 372 */       b.text(UILawCrimeList.¤¤desc);
/* 373 */       b.NL(4);
/*     */       
/* 375 */       b.tab(5);
/* 376 */       b.add((SPRITE)(BOOSTABLES.BEHAVIOUR()).HAPPI.icon);
/* 377 */       b.textLL(UILawCrimeList.¤¤tyranny);
/* 378 */       b.tab(9);
/* 379 */       b.add((SPRITE)(BOOSTABLES.CIVICS()).LAW.icon);
/* 380 */       b.textLL((BOOSTABLES.CIVICS()).LAW.name);
/* 381 */       b.NL();
/*     */       
/* 383 */       b.textL(UILawCrimeList.this.crimeToSet.crime.name);
/* 384 */       b.tab(5);
/* 385 */       b.add((SPRITE)GFORMAT.perc(b.text(), -UILawCrimeList.this.crimeToSet.crime.tyrrany(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace()), 1));
/* 386 */       b.tab(9);
/* 387 */       b.add((SPRITE)GFORMAT.percInc(b.text(), UILawCrimeList.this.crimeToSet.crime.law(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace())));
/* 388 */       b.NL();
/*     */       
/* 390 */       b.textL(this.p.punish.name);
/* 391 */       b.tab(5);
/* 392 */       b.add((SPRITE)GFORMAT.mul(b.text(), this.p.punish.tyranny(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace())));
/* 393 */       b.tab(9);
/* 394 */       b.add((SPRITE)GFORMAT.mul(b.text(), this.p.punish.law(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace())));
/* 395 */       b.NL();
/*     */       
/* 397 */       b.textLL(Dic.¤¤Total);
/* 398 */       b.tab(5);
/* 399 */       b.add((SPRITE)GFORMAT.percInc(b.text(), -UILawCrimeList.this.crimeToSet.crime.tyrrany(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace(), this.p.punish), 1));
/* 400 */       b.tab(9);
/* 401 */       b.add((SPRITE)GFORMAT.percInc(b.text(), UILawCrimeList.this.crimeToSet.crime.law(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace(), this.p.punish)));
/* 402 */       b.NL();
/*     */ 
/*     */       
/* 405 */       super.hoverInfoGet(text);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 411 */       super.render(r, ds, isActive, isSelected, isHovered);
/* 412 */       CRIMES.Response rr = UILawCrimeList.this.crimeToSet.crime.loyaltyInc(UILawCrimeList.this.cl, UILawCrimeList.this.sel.getRace(), this.p.punish);
/* 413 */       if (rr.diff < 0.0D) {
/* 414 */         (GCOLOR.UI()).BAD.hovered.bind();
/* 415 */         (UI.icons()).s.alert.renderCX(r, this.body.x2() - 8, this.body.y1() + 8);
/* 416 */         COLOR.unbind();
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private RENDEROBJ service(final RoomBlueprintImp room, final PUNISHMENT_SERVICE ser) {
/* 422 */     return (RENDEROBJ)new CLICKABLE.ClickableAbs(60, 48)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */         {
/* 429 */           if (isHovered) {
/* 430 */             COLOR.WHITE50.render(r, (RECTANGLE)this.body, 2);
/*     */           }
/*     */           
/* 433 */           double d = (ser.punishTotal() > 0) ? (ser.punishUsed() / ser.punishTotal()) : 0.0D;
/*     */           
/* 435 */           GMeter.render(r, GMeter.C_ORANGE, d, (RECTANGLE)this.body);
/*     */           
/* 437 */           room.icon.renderC(r, (RECTANGLE)this.body);
/*     */           
/* 439 */           if (ser.punishUsed() >= ser.punishTotal() * 0.8D) {
/* 440 */             (GCOLOR.UI()).BAD.normal.bind();
/* 441 */             (SPRITES.icons()).s.alert.render(r, body().x2() - 16, body().y1());
/* 442 */             COLOR.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 450 */           GBox b = (GBox)text;
/* 451 */           b.title(room.info.names);
/* 452 */           b.textL(Dic.¤¤Available);
/* 453 */           b.tab(6);
/* 454 */           b.add((SPRITE)GFORMAT.iofkInv(b.text(), (ser.punishTotal() - ser.punishUsed()), ser.punishTotal()));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 461 */           if ((VIEW.s()).ui.rooms.open((RoomBlueprint)room) != null) {
/* 462 */             (VIEW.s()).panels.add((VIEW.s()).ui.rooms.open((RoomBlueprint)room), true);
/*     */           }
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RENDEROBJ crimeRow(final HCLASS cl, final StatCrime crime) {
/* 473 */     GButt.BSection bSection = new GButt.BSection()
/*     */       {
/*     */         protected void hoverInfoSelf(GUI_BOX box)
/*     */         {
/* 477 */           crime.hover(box, cl, UILawCrimeList.this.sel.getRace());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 482 */           UILawCrimeList.this.crimeToSet = crime;
/* 483 */           (VIEW.inters()).popup.show((RENDEROBJ)UILawCrimeList.this.pop, (CLICKABLE)this);
/* 484 */           super.clickA();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 489 */     bSection.addRightC(0, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 493 */             GFORMAT.i(text, crime.criminals(UILawCrimeList.this.sel.getRace()));
/*     */           }
/*     */         });
/*     */     
/* 497 */     bSection.addRightC(48, (SPRITE)new SPRITE.Imp(64, 24)
/*     */         {
/*     */           
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 502 */             double cla = crime.crime.law(cl, UILawCrimeList.this.sel.getRace()) / crime.crime.tyrrany(cl, UILawCrimeList.this.sel.getRace());
/*     */             
/* 504 */             int am = 5;
/* 505 */             int aa = (int)Math.round(am * cla / UILawCrimeList.this.hiLaw);
/* 506 */             (GCOLOR.UI()).SOSO.hovered.bind();
/*     */             
/* 508 */             int x = X1;
/* 509 */             int cy = Y1 + (Y2 - Y1) / 2;
/* 510 */             for (int i = 0; i < aa; i++) {
/* 511 */               (UI.icons()).s.plusBig.renderCY(r, x, cy);
/* 512 */               x += 8;
/*     */             } 
/* 514 */             COLOR.unbind();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 520 */     bSection.addRightC(4, (RENDEROBJ)new GHeader(crime.crime.name));
/*     */     
/* 522 */     bSection.addRightCAbs(200, (SPRITE)new SPRITE.Imp(24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 526 */             StatPunishment p = crime.punishment(cl, UILawCrimeList.this.sel.getRace());
/* 527 */             Icon icon = (p == null) ? (UI.icons()).m.questionmark : p.punish.icon;
/* 528 */             icon.render(r, X1, Y1);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 533 */     bSection.addRightC(16, (SPRITE)new GStat()
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/* 538 */             GFORMAT.percInc(text, (crime.crime.loyaltyIncCurrent(cl, UILawCrimeList.this.sel.getRace())).diff, 0);
/*     */           }
/*     */         });
/*     */     
/* 542 */     bSection.addRightC(64, (SPRITE)(UI.icons()).s.arrow_right);
/*     */     
/* 544 */     bSection.addRightC(16, (SPRITE)new GStat()
/*     */         {
/*     */           
/*     */           public void update(GText text)
/*     */           {
/* 549 */             GFORMAT.percInc(text, (crime.crime.loyaltyInc(cl, UILawCrimeList.this.sel.getRace(), (crime.punishment(cl, UILawCrimeList.this.sel.getRace())).punish)).diff, 0);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 555 */     bSection.body().incrW(64.0D);
/*     */     
/* 557 */     bSection.pad(8, 3);
/*     */     
/* 559 */     return (RENDEROBJ)bSection;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\law\UILawCrimeList.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */