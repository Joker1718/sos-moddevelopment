/*     */ package view.sett.ui.standing;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Booster;
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
/*     */ import init.race.Race;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import settlement.stats.standing.StandingCitizen;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.standing.decree.UIDecreeButt;
/*     */ 
/*     */ final class CitizenMain extends GuiSection {
/*  45 */   static int width = 220;
/*  46 */   private final INT.IntImp hov = new INT.IntImp();
/*     */   
/*     */   public CitizenMain(HCLASS cl, GETTER<Race> race, int HEIGHT, Cats cats) {
/*  49 */     add(infoButt(cats, cl, race));
/*  50 */     addRelBody(8, DIR.S, mainHappiness(cats, this.hov, cl, race));
/*     */     
/*  52 */     ArrayList<RENDEROBJ> rens = new ArrayList(STATS.COLLECTIONS().size());
/*     */     
/*  54 */     for (Cats.Cat c : cats.all) {
/*  55 */       rens.add(new CatButt(cats, c, cl, race, (INT.INTE)this.hov));
/*     */     }
/*     */     
/*  58 */     int hh = HEIGHT - body().height() - 8;
/*  59 */     hh /= ((RENDEROBJ)rens.get(0)).body().height();
/*  60 */     hh *= ((RENDEROBJ)rens.get(0)).body().height();
/*     */     
/*  62 */     GScrollRows r = new GScrollRows((Iterable)rens, hh);
/*  63 */     add((RENDEROBJ)r.view(), body().x1(), body().y2() + 16);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  71 */     super.render(r, ds);
/*  72 */     this.hov.set(-1);
/*     */   }
/*     */ 
/*     */   
/*     */   private static RENDEROBJ infoButt(Cats cats, HCLASS cl, final GETTER<Race> race) {
/*  77 */     GuiSection ss = new GuiSection();
/*     */     
/*  79 */     GButt.ButtPanel s = new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.questionmark)
/*     */       {
/*     */         protected void clickA() {
/*  82 */           (VIEW.UI()).wiki.showRace((race.get() == null) ? FACTIONS.player().race() : (Race)race.get());
/*     */         }
/*     */       };
/*  85 */     s.body.incrW(16.0D);
/*  86 */     ss.add((RENDEROBJ)s);
/*     */ 
/*     */     
/*  89 */     final MenuProp pp = new MenuProp(cl, race);
/*  90 */     GButt.ButtPanel sss = new GButt.ButtPanel(Dic.¤¤Properites)
/*     */       {
/*     */         protected void clickA() {
/*  93 */           (VIEW.s()).panels.add(pp, false);
/*     */         }
/*     */         
/*     */         protected void renAction() {
/*  97 */           selectedSet((VIEW.s()).panels.added(pp));
/*     */         }
/*     */       };
/* 100 */     sss.body.incrW(16.0D);
/* 101 */     ss.addRightC(2, (RENDEROBJ)sss);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     GETTER<Race> g = new GETTER<Race>()
/*     */       {
/*     */         public Race get()
/*     */         {
/* 110 */           return (Race)race.get();
/*     */         }
/*     */       };
/*     */     
/* 114 */     UIDecreeButt uIDecreeButt = new UIDecreeButt(cl, g);
/* 115 */     ss.addRightC(2, (RENDEROBJ)uIDecreeButt);
/*     */ 
/*     */     
/* 118 */     ss.addRelBody(8, DIR.N, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 122 */             text.setFont((UI.FONT()).H2);
/* 123 */             text.lablifySub();
/* 124 */             text.add((race.get() == null) ? Dic.¤¤All : ((Race)race.get()).info.names);
/*     */           }
/* 126 */         }).r(DIR.N));
/*     */     
/* 128 */     return (RENDEROBJ)ss;
/*     */   }
/*     */   
/*     */   private static RENDEROBJ mainHappiness(final Cats cats, final INT.IntImp hov, final HCLASS cl, final GETTER<Race> race) {
/* 132 */     GuiSection s = new GuiSection();
/* 133 */     final StandingCitizen h = STANDINGS.get(cl);
/*     */ 
/*     */     
/* 136 */     GuiSection ss = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 139 */           super.hoverInfoGet(text);
/* 140 */           if (!text.emptyIs()) {
/*     */             return;
/*     */           }
/* 143 */           GBox b = (GBox)text;
/* 144 */           b.title((h.loyalty.info()).name);
/* 145 */           b.text((h.loyalty.info()).desc);
/* 146 */           b.NL(8);
/*     */           
/* 148 */           b.textLL(Dic.¤¤Current);
/* 149 */           b.add((SPRITE)GFORMAT.perc(b.text(), h.loyalty.getD((Race)race.get())));
/* 150 */           b.add((SPRITE)(SPRITES.icons()).s.arrow_right);
/*     */           
/* 152 */           b.textLL(Dic.¤¤Target);
/* 153 */           b.tab(6);
/* 154 */           b.add((SPRITE)GFORMAT.perc(b.text(), h.loyaltyTarget.getD((Race)race.get())));
/* 155 */           b.NL(8);
/*     */           
/* 157 */           b.NL(8);
/*     */           
/* 159 */           h.loyaltyTarget.bo.hoverDetailed((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP((Race)race.get(), cl), Dic.¤¤Boosts, (S.get()).developer);
/*     */         }
/*     */       };
/* 162 */     ss.add((RENDEROBJ)new GHeader((h.loyalty.info()).name));
/* 163 */     ss.addRightCAbs(184, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 167 */             GFORMAT.perc(text, h.loyalty.getD((Race)race.get()));
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 172 */     RENDEROBJ.RenderImp renderImp2 = new RENDEROBJ.RenderImp(width, 24)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 176 */           double now = h.loyalty.getD((Race)race.get());
/* 177 */           double t = h.loyaltyTarget.getD((Race)race.get());
/* 178 */           GMeter.renderSuperDelta(r, now, t, (RECTANGLE)this.body, true);
/*     */         }
/*     */       };
/*     */     
/* 182 */     ss.add((RENDEROBJ)renderImp2, 0, ss.body().y2() + 4);
/*     */     
/* 184 */     GStaples st = new GStaples(32)
/*     */       {
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/* 189 */           isHovered = true;
/* 190 */           setHovered(hov.get());
/* 191 */           super.render(r, ds, isHovered);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void hover(GBox box, int stapleI) {
/* 196 */           box.title((h.info()).name);
/* 197 */           int fromZero = 32 - stapleI - 1;
/* 198 */           box.add((SPRITE)box.text().lablify().add(-fromZero).s().add(TIME.days().cycleName()));
/* 199 */           box.NL();
/*     */           
/* 201 */           box.textLL(Dic.¤¤Current);
/* 202 */           box.add((SPRITE)GFORMAT.perc(box.text(), h.loyalty.getD((Race)race.get(), fromZero)));
/* 203 */           box.add((SPRITE)(SPRITES.icons()).s.arrow_right);
/* 204 */           box.textLL(Dic.¤¤Target);
/* 205 */           box.tab(6);
/* 206 */           box.add((SPRITE)GFORMAT.perc(box.text(), h.loyaltyTarget.getD((Race)race.get(), fromZero)));
/* 207 */           box.NL(8);
/*     */           
/* 209 */           box.sep();
/*     */           
/* 211 */           for (int i = 0; i < h.loyaltyTarget.bo.all().size(); i++) {
/* 212 */             Booster b = (Booster)h.loyaltyTarget.bo.all().get(i);
/* 213 */             double n = h.loyaltyTarget.factor((Race)race.get(), i, fromZero);
/* 214 */             double p = h.loyaltyTarget.factor((Race)race.get(), i, fromZero + 1);
/* 215 */             box.add(b.info.icon);
/* 216 */             box.textLL(b.info.name);
/* 217 */             box.tab(7);
/*     */             
/* 219 */             if (b.isMul) {
/* 220 */               box.add((SPRITE)GFORMAT.percInc(box.text(), n - p));
/*     */             } else {
/* 222 */               box.add((SPRITE)GFORMAT.f0(box.text(), n - p));
/* 223 */             }  box.NL();
/*     */           } 
/*     */ 
/*     */           
/* 227 */           box.NL();
/*     */           
/* 229 */           h.loyaltyTarget.bo.hoverDetailed((GUI_BOX)box, (BOOSTABLE_O)HCLASS_RACE.clP((Race)race.get(), cl), Dic.¤¤Boosts, true);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean hover(COORDINATE mCoo) {
/* 235 */           if (super.hover(mCoo)) {
/* 236 */             hov.set(hoverI());
/* 237 */             return true;
/*     */           } 
/* 239 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/* 244 */           int fromZero = 32 - stapleI - 1;
/* 245 */           return h.loyalty.getD((Race)race.get(), fromZero);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void setColor(ColorImp c, int stapleI, double value) {
/* 250 */           c.interpolate((GCOLOR.UI()).BAD.hovered, (GCOLOR.UI()).GOOD2.hovered, value);
/*     */         }
/*     */       };
/* 253 */     st.normalize(false);
/* 254 */     st.body().setWidth(224.0D);
/* 255 */     st.body().setHeight(64.0D);
/* 256 */     st.body().centerY((BODY_HOLDER)ss);
/* 257 */     st.body().moveX1((width + 8));
/* 258 */     ss.add((RENDEROBJ)st);
/*     */     
/* 260 */     s.addDown(2, (RENDEROBJ)ss);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 267 */     ss = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 270 */           super.hoverInfoGet(text);
/* 271 */           if (!text.emptyIs()) {
/*     */             return;
/*     */           }
/* 274 */           GBox b = (GBox)text;
/* 275 */           b.title((h.happiness.info()).name);
/* 276 */           b.text((h.happiness.info()).desc);
/* 277 */           b.NL(8);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 282 */           b.textL((h.fullfillment.info()).name);
/* 283 */           b.tab(7);
/* 284 */           b.add((SPRITE)GFORMAT.perc(b.text(), h.fullfillment.getD((Race)race.get()), 4));
/*     */           
/* 286 */           double c = 0.0D;
/* 287 */           double m = 0.0D;
/* 288 */           for (STAT s : STATS.all()) {
/* 289 */             c += s.standing().get(cl, (Race)race.get());
/* 290 */             m += s.standing().max(cl, (Race)race.get()) - s.standing().getDismiss(cl, (Race)race.get());
/*     */           } 
/* 292 */           GText gText1 = b.text();
/* 293 */           gText1.add('(');
/* 294 */           GFORMAT.dofk(gText1, c, m);
/* 295 */           gText1.add(')');
/* 296 */           b.tab(9);
/* 297 */           b.add((SPRITE)gText1);
/* 298 */           b.NL();
/*     */ 
/*     */ 
/*     */           
/* 302 */           b.textL((h.expectation.info()).name);
/* 303 */           b.tab(7);
/* 304 */           b.add((SPRITE)GFORMAT.perc(b.text(), h.expectation.getD((Race)race.get()), 4));
/* 305 */           b.NL();
/*     */ 
/*     */           
/* 308 */           GText t = b.text();
/* 309 */           t.add('=').s();
/* 310 */           b.tab(7);
/* 311 */           b.add((SPRITE)GFORMAT.perc(t, h.fullfillment.getD((Race)race.get()) / h.expectation.getD((Race)race.get())));
/* 312 */           b.NL();
/*     */           
/* 314 */           double bo = (STANDINGS.get(cl)).bhappiness.get((BOOSTABLE_O)HCLASS_RACE.clP((Race)race.get(), cl));
/*     */           
/* 316 */           if (bo != 1.0D || (S.get()).developer) {
/* 317 */             b.sep();
/* 318 */             (STANDINGS.get(cl)).bhappiness.hoverDetailed((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP((Race)race.get(), cl), Dic.¤¤Boosts, true);
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 323 */     ss.add((RENDEROBJ)new GHeader((h.happiness.info()).name));
/* 324 */     ss.addRightCAbs(184, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 328 */             GFORMAT.perc(text, h.happiness.getD((Race)race.get()));
/*     */           }
/*     */         });
/*     */     
/* 332 */     RENDEROBJ.RenderImp renderImp1 = new RENDEROBJ.RenderImp(width, 24)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 336 */           double now = h.happiness.getD((Race)race.get());
/* 337 */           GMeter.renderSuperDelta(r, now, now, (RECTANGLE)this.body, true);
/*     */         }
/*     */       };
/*     */     
/* 341 */     ss.add((RENDEROBJ)renderImp1, 0, ss.body().y2() + 4);
/*     */     
/* 343 */     st = new GStaples(32)
/*     */       {
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/* 348 */           isHovered = true;
/* 349 */           setHovered(hov.get());
/* 350 */           super.render(r, ds, isHovered);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void hover(GBox box, int stapleI) {
/* 356 */           box.title((STANDINGS.get(cl)).bhappiness.name);
/* 357 */           int fromZero = 32 - stapleI - 1;
/*     */           
/* 359 */           GText t = box.text();
/* 360 */           DicTime.setDaysAgo((Str)t, fromZero);
/* 361 */           box.add((SPRITE)t);
/*     */           
/* 363 */           box.tab(6);
/* 364 */           box.add((SPRITE)GFORMAT.perc(box.text(), h.happiness.getD((Race)race.get(), fromZero)));
/* 365 */           box.NL();
/*     */ 
/*     */ 
/*     */           
/* 369 */           if (fromZero >= 31) {
/*     */             return;
/*     */           }
/*     */ 
/*     */           
/* 374 */           box.sep();
/*     */           
/* 376 */           box.textLL((h.fullfillment.info()).name);
/* 377 */           box.tab(7);
/* 378 */           box.add((SPRITE)GFORMAT.percInc(box.text(), CLAMP.d(h.happiness.getD((Race)race.get(), fromZero) - h.happiness.getD((Race)race.get(), fromZero - 1), 0.0D, 100.0D)));
/* 379 */           box.NL();
/* 380 */           for (Cats.Cat ca : cats.all) {
/* 381 */             int v1 = (int)(100.0D * CatButt.Staples.value(stapleI, ca.cs, cl, race));
/* 382 */             int v2 = v1;
/* 383 */             if (stapleI > 0)
/* 384 */               v2 = (int)(100.0D * CatButt.Staples.value(stapleI - 1, ca.cs, cl, race)); 
/* 385 */             if (v1 != v2) {
/* 386 */               box.tab(1);
/* 387 */               box.textL((ca.cs[0]).info.name);
/* 388 */               box.tab(7);
/* 389 */               double d1 = (v1 - v2) / 100.0D;
/* 390 */               box.add((SPRITE)GFORMAT.f0(box.text(), d1));
/* 391 */               box.NL();
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 396 */           double d = h.expectation.getD((Race)race.get(), fromZero);
/* 397 */           double d2 = h.expectation.getD((Race)race.get(), fromZero + 1);
/* 398 */           double v = d / d2;
/* 399 */           if (v != 1.0D) {
/* 400 */             box.tab(1);
/* 401 */             box.textL((h.expectation.info()).name);
/* 402 */             box.tab(7);
/*     */           } 
/*     */           
/* 405 */           if (v < 1.0D) {
/* 406 */             box.add((SPRITE)GFORMAT.percInc(box.text(), 1.0D - v));
/* 407 */           } else if (v > 1.0D) {
/* 408 */             box.add((SPRITE)GFORMAT.percInc(box.text(), -(v - 1.0D)));
/*     */           } 
/*     */ 
/*     */           
/* 412 */           box.sep();
/*     */           
/* 414 */           for (int i = 0; i < h.happiness.bo.all().size(); i++) {
/* 415 */             Booster b = (Booster)h.happiness.bo.all().get(i);
/* 416 */             double n = h.happiness.factor((Race)race.get(), i, fromZero);
/* 417 */             double p = h.happiness.factor((Race)race.get(), i, fromZero + 1);
/* 418 */             box.add(b.info.icon);
/* 419 */             box.textLL(b.info.name);
/* 420 */             box.tab(7);
/*     */             
/* 422 */             if (b.isMul) {
/* 423 */               box.add((SPRITE)GFORMAT.percInc(box.text(), n - p));
/*     */             } else {
/* 425 */               box.add((SPRITE)GFORMAT.f0(box.text(), n - p));
/* 426 */             }  box.NL();
/*     */           } 
/*     */ 
/*     */           
/* 430 */           box.NL();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean hover(COORDINATE mCoo) {
/* 436 */           if (super.hover(mCoo)) {
/* 437 */             hov.set(hoverI());
/* 438 */             return true;
/*     */           } 
/* 440 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/* 445 */           int fromZero = 32 - stapleI - 1;
/* 446 */           return h.happiness.getD((Race)race.get(), fromZero);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void setColor(ColorImp c, int stapleI, double value) {
/* 451 */           c.interpolate((GCOLOR.UI()).BAD.hovered, (GCOLOR.UI()).GOOD2.hovered, value);
/*     */         }
/*     */       };
/* 454 */     st.normalize(false);
/* 455 */     st.body().setWidth(224.0D);
/* 456 */     st.body().setHeight(64.0D);
/* 457 */     st.body().centerY((BODY_HOLDER)ss);
/* 458 */     st.body().moveX1((width + 8));
/* 459 */     ss.add((RENDEROBJ)st);
/*     */     
/* 461 */     s.addDown(2, (RENDEROBJ)ss);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 467 */     return (RENDEROBJ)s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CitizenMain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */