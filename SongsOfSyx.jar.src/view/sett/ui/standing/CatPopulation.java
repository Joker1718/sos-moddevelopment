/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CAUSE_ARRIVE;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsPopulation;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.army.AD;
/*     */ 
/*     */ 
/*     */ final class CatPopulation
/*     */   extends Cats.Cat
/*     */ {
/*  47 */   private static CharSequence ¤¤age = "¤Age {0} to {1} : {2} Subjects";
/*  48 */   private static CharSequence ¤¤ageAverage = "¤Average Age:";
/*     */   
/*  50 */   private static CharSequence ¤¤others = "¤Others";
/*  51 */   private static CharSequence ¤¤othersD = "¤Other population that count towards expectations, but not for fulfillment.";
/*     */   
/*  53 */   private static CharSequence ¤¤Soldiers = "¤Soldiers out campaigning";
/*     */   
/*     */   private final GETTER<Race> race;
/*     */   
/*     */   CatPopulation(final HCLASS cl, final GETTER<Race> race) {
/*  58 */     super(new StatCollection[] { (StatCollection)STATS.POP() });
/*  59 */     this.race = race;
/*  60 */     StatsPopulation statsPopulation = STATS.POP();
/*     */     
/*  62 */     D.ts(CatPopulation.class);
/*  63 */     titleSet(((StatCollection)statsPopulation).info.name);
/*     */     
/*  65 */     this.section.add((RENDEROBJ)pop(cl));
/*     */     
/*  67 */     this.section.addDown(4, popChart(cl, this.section.body().width()));
/*  68 */     this.section.addDown(4, (RENDEROBJ)new CatPopulationGrowth(cl, race)
/*     */         {
/*     */           public HCLASS_RACE pop()
/*     */           {
/*  72 */             return HCLASS_RACE.clP((Race)race.get(), cl);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  79 */     LinkedList<RENDEROBJ> rens = new LinkedList();
/*     */     
/*  81 */     for (STAT s : statsPopulation.all()) {
/*  82 */       if (s.key() == null)
/*     */         continue; 
/*  84 */       if (s == (STATS.POP()).age.AGE_DAYS) {
/*     */         continue;
/*     */       }
/*  87 */       rens.add(new StatRow(s, cl, race));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  95 */     this.section.addDown(16, (RENDEROBJ)(new GScrollRows((Iterable)rens, HEIGHT - this.section.getLastY2() - 32, 0)).view());
/*     */   }
/*     */ 
/*     */   
/*     */   private GuiSection pop(final HCLASS cl) {
/* 100 */     GuiSection s = new GuiSection();
/*     */ 
/*     */     
/* 103 */     int ww = 160;
/*     */     
/* 105 */     for (HTYPE t : HTYPES.ALL()) {
/* 106 */       if (t.CLASS != cl || t == HTYPES.SOLDIER())
/*     */         continue; 
/* 108 */       s.addDown(4, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 112 */               GFORMAT.i(text, STATS.POP().pop((Race)CatPopulation.this.race.get(), t));
/* 113 */               text.lablifySub();
/*     */             }
/* 115 */           }).decrease().hh(t.icon, t.names, ww).hoverInfoSet(t.desc));
/*     */     } 
/*     */     
/* 118 */     s.addDown(2, GCOLOR.UI().border().makeSprite(150, 1));
/*     */     
/* 120 */     s.addDown(2, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 124 */             GFORMAT.i(text, (STATS.POP()).POP.data(cl).get(CatPopulation.this.race.get()));
/*     */           }
/* 126 */         }).decrease().hh(cl.names, ww).hoverInfoSet(((STATS.POP()).POP.info()).desc));
/*     */     
/* 128 */     s.addDown(2, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 132 */             GFORMAT.iIncr(text, (POP.tot(cl, (Race)CatPopulation.this.race.get()) - (STATS.POP()).POP.data(cl).get(CatPopulation.this.race.get()) + POP.incoming(cl, (Race)CatPopulation.this.race.get())));
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 139 */             b.title(CatPopulation.¤¤others);
/* 140 */             b.text(CatPopulation.¤¤othersD);
/* 141 */             b.sep();
/*     */             
/* 143 */             b.add((SPRITE)(UI.icons()).s.arrow_right);
/* 144 */             b.textLL(Dic.¤¤Next);
/* 145 */             b.tab(6);
/* 146 */             b.add((SPRITE)GFORMAT.i(b.text(), POP.incoming(cl, (Race)CatPopulation.this.race.get())));
/* 147 */             b.NL();
/* 148 */             b.text(CatPopulation.this.desc);
/* 149 */             b.NL(4);
/*     */             
/* 151 */             for (HTYPE t : HTYPES.ALL()) {
/* 152 */               if ((t.parent()).CLASS != t.CLASS && t.parentClass() == cl) {
/* 153 */                 add(t, b);
/*     */               }
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 159 */             if (cl == HCLASSES.CITIZEN()) {
/*     */               
/* 161 */               add(AD.cityDivs().total((Race)CatPopulation.this.race.get()), HTYPES.SOLDIER(), CatPopulation.¤¤Soldiers, b);
/* 162 */               add(STATS.LAW().criminals(HCLASSES.CITIZEN(), (Race)CatPopulation.this.race.get()), HTYPES.PRISONER(), (HTYPES.PRISONER()).desc, b);
/* 163 */               add(HTYPES.RIOTER(), b);
/* 164 */               add(HTYPES.DERANGED(), b);
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           private void add(HTYPE t, GBox b) {
/* 171 */             add(STATS.POP().pop((Race)CatPopulation.this.race.get(), t), t, t.desc, b);
/*     */           }
/*     */           
/*     */           private void add(int am, HTYPE t, CharSequence desc, GBox b) {
/* 175 */             b.add(t.icon);
/* 176 */             b.textLL(t.names);
/* 177 */             b.tab(6);
/* 178 */             b.add((SPRITE)GFORMAT.i(b.text(), am));
/* 179 */             b.NL();
/* 180 */             b.text(desc);
/* 181 */             b.NL(4);
/*     */           }
/* 184 */         }).decrease().hh(¤¤others, ww));
/*     */     
/* 186 */     s.addRelBody(48, DIR.E, demo(cl));
/*     */ 
/*     */     
/* 189 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private RENDEROBJ demo(final HCLASS cl) {
/* 195 */     GuiSection s = new GuiSection();
/*     */ 
/*     */     
/* 198 */     if (cl == HCLASSES.CITIZEN()) {
/* 199 */       GStaples staples = new GStaples(STATS.POP().demography().historyRecords()) {
/*     */           double demoMax;
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 203 */             this.demoMax = 0.0D;
/* 204 */             for (int i = 0; i < STATS.POP().demography().historyRecords(); i++) {
/* 205 */               if (STATS.POP().demography().getD(CatPopulation.this.race.get(), i) > this.demoMax)
/* 206 */                 this.demoMax = STATS.POP().demography().getD(CatPopulation.this.race.get(), i); 
/* 207 */             }  super.render(r, ds, isHovered);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void hover(GBox text, int stapleI) {
/* 212 */             int k = stapleI;
/* 213 */             text.title((STATS.POP().demography().info()).name);
/* 214 */             if (CatPopulation.this.race.get() != null) {
/* 215 */               GText gText = text.text();
/* 216 */               gText.add(CatPopulation.¤¤age);
/* 217 */               double da = ((Race)CatPopulation.this.race.get()).bvalue((BOOSTABLES.PHYSICS()).DEATH_AGE);
/*     */ 
/*     */               
/* 220 */               int from = (int)(k * da / (STATS.POP().demography().historyRecords() - 1));
/* 221 */               gText.insert(0, from);
/*     */               
/* 223 */               if (k == STATS.POP().demography().historyRecords() - 1) {
/* 224 */                 gText.insert(1, '+');
/*     */               } else {
/* 226 */                 int to = (int)((k + 1) * da) / (STATS.POP().demography().historyRecords() - 1);
/* 227 */                 gText.insert(1, to);
/*     */               } 
/*     */               
/* 230 */               gText.insert(2, (int)STATS.POP().demography().getD(CatPopulation.this.race.get(), k));
/* 231 */               text.add((SPRITE)gText);
/*     */               
/* 233 */               text.NL(8);
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected double getValue(int stapleI) {
/* 245 */             int k = stapleI;
/* 246 */             double am = STATS.POP().demography().getD(CatPopulation.this.race.get(), k);
/* 247 */             if (this.demoMax > 0.0D) {
/* 248 */               am /= this.demoMax;
/*     */             }
/* 250 */             return am;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void setColor(ColorImp c, int stapleI, double value) {
/* 255 */             c.set((GCOLOR.UI()).SOSO.hovered);
/*     */           }
/*     */         };
/*     */       
/* 259 */       staples.body().setWidth((10 * STATS.POP().demography().historyRecords()));
/* 260 */       staples.body().setHeight(100.0D);
/* 261 */       s.add((RENDEROBJ)staples);
/*     */     } 
/*     */     
/* 264 */     s.addRelBody(2, DIR.N, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 268 */             double d = (STATS.POP()).age.AGE_DAYS.data(cl).getD(CatPopulation.this.race.get()) / TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */             
/* 270 */             GFORMAT.f(text, d);
/*     */           }
/* 272 */         }).hh(¤¤ageAverage));
/*     */     
/* 274 */     return (RENDEROBJ)s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RENDEROBJ popChart(final HCLASS cl, int width) {
/* 281 */     GuiSection ss = new GuiSection();
/*     */     
/* 283 */     GStaples s = new GStaples(32)
/*     */       {
/*     */         
/*     */         protected void hover(GBox box, int stapleI)
/*     */         {
/* 288 */           box.title(Dic.¤¤Population);
/* 289 */           int i = 32 - stapleI - 1;
/* 290 */           box.add((SPRITE)box.text().add(-i).s().add(TIME.days().cycleName()));
/* 291 */           box.NL(8);
/*     */           
/* 293 */           box.textLL(Dic.¤¤Population);
/* 294 */           box.tab(7);
/* 295 */           box.add((SPRITE)GFORMAT.iBig(box.text(), (int)getValue(stapleI)));
/* 296 */           box.NL(8);
/*     */           
/*     */           int ci;
/*     */           
/* 300 */           for (ci = 0; ci < CAUSE_ARRIVES.ALL().size(); ci++) {
/* 301 */             CAUSE_ARRIVE a = (CAUSE_ARRIVE)CAUSE_ARRIVES.ALL().get(ci);
/* 302 */             int am = ((StatsPopulation.StatsDeath.PopData)(STATS.POP()).COUNT.enters().get(a.index())).statistics(cl).history(CatPopulation.this.race.get()).get(i);
/*     */             
/* 304 */             if (am > 0) {
/* 305 */               box.textL(a.name);
/* 306 */               box.tab(7);
/* 307 */               box.add((SPRITE)GFORMAT.iIncr(box.text(), am));
/* 308 */               box.NL();
/*     */             } 
/*     */           } 
/*     */           
/* 312 */           box.NL(4);
/*     */           
/* 314 */           for (ci = 0; ci < CAUSE_LEAVES.ALL().size(); ci++) {
/* 315 */             CAUSE_LEAVE a = (CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(ci);
/* 316 */             int am = ((StatsPopulation.StatsDeath.PopData)(STATS.POP()).COUNT.leaves().get(a.index())).statistics(cl).history(CatPopulation.this.race.get()).get(i);
/*     */             
/* 318 */             if (am > 0) {
/* 319 */               box.textL(a.names);
/* 320 */               if (a.defaultStanding() > 0.0D)
/* 321 */                 box.tab(6).add((SPRITE)(UI.icons()).s.angry, (GCOLOR.UI()).BAD.hovered); 
/* 322 */               box.tab(7);
/* 323 */               box.add((SPRITE)GFORMAT.iIncr(box.text(), -am));
/* 324 */               box.NL();
/*     */             } 
/*     */           } 
/*     */           
/* 328 */           box.NL(4);
/* 329 */           box.textLL(Dic.¤¤Total);
/* 330 */           box.tab(7);
/* 331 */           box.add((SPRITE)GFORMAT.iIncr(box.text(), (int)(getValue(stapleI) - getValue(stapleI - 1))));
/* 332 */           box.NL(4);
/*     */           
/* 334 */           if (cl == HCLASSES.CITIZEN()) {
/* 335 */             box.sep();
/* 336 */             box.textLL(Dic.¤¤Type);
/* 337 */             box.NL();
/* 338 */             for (STAT t : (STATS.POP()).TYPE.all()) {
/* 339 */               box.textL((t.info()).name);
/* 340 */               box.tab(7);
/* 341 */               box.add((SPRITE)GFORMAT.i(box.text(), t.data(cl).get(CatPopulation.this.race.get(), i)));
/* 342 */               box.NL();
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/* 352 */           int i = 32 - stapleI - 1;
/* 353 */           if (i >= 32)
/* 354 */             i = 31; 
/* 355 */           if (i < 0)
/* 356 */             i = 0; 
/* 357 */           int am = (STATS.POP()).POP.data(cl).get(CatPopulation.this.race.get(), i);
/*     */           
/* 359 */           return am;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void setColor(ColorImp c, int stapleI, double value) {
/* 364 */           int i = 32 - stapleI - 1;
/* 365 */           for (int ci = 0; ci < CAUSE_LEAVES.ALL().size(); ci++) {
/* 366 */             CAUSE_LEAVE a = (CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(ci);
/* 367 */             if (!a.natural) {
/* 368 */               int am = ((StatsPopulation.StatsDeath.PopData)(STATS.POP()).COUNT.leaves().get(a.index())).statistics(cl).history(CatPopulation.this.race.get()).get(i);
/*     */               
/* 370 */               if (am > 0) {
/* 371 */                 c.set((GCOLOR.UI()).BAD.normal);
/*     */ 
/*     */                 
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/* 379 */           super.setColor(c, stapleI, value);
/*     */         }
/*     */       };
/* 382 */     s.normalizePlus(true);
/*     */     
/* 384 */     s.body().setWidth(width);
/* 385 */     s.body().setHeight(80.0D);
/* 386 */     ss.add((RENDEROBJ)s);
/*     */ 
/*     */     
/* 389 */     final SPRITE[] cols = new SPRITE[(STATS.POP()).COUNT.leaves().size()];
/* 390 */     for (int i = 0; i < cols.length; i++) {
/* 391 */       final int k = i;
/* 392 */       cols[i] = (SPRITE)new SPRITE.Imp(24, 24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 396 */             ((COLOR)COLOR.UNIQUE.getC(k)).bind();
/* 397 */             (SPRITES.icons()).m.circle_inner.render(r, X1, Y1);
/* 398 */             COLOR.unbind();
/*     */           }
/*     */         };
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 405 */     GStaples sss = new GStaples(32)
/*     */       {
/*     */         protected void hover(GBox box, int stapleI)
/*     */         {
/* 409 */           box.title(((STATS.POP()).WRONGFUL.info()).names);
/* 410 */           int i = 32 - stapleI - 1;
/* 411 */           box.add((SPRITE)box.text().add(-i).s().add(TIME.days().cycleName()));
/* 412 */           box.NL(8);
/* 413 */           int di = 0;
/* 414 */           for (StatsPopulation.StatsDeath.PopData s : (STATS.POP()).COUNT.leaves()) {
/* 415 */             if (((CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(di)).defaultStanding() <= 0.0D) {
/* 416 */               di++;
/*     */               continue;
/*     */             } 
/* 419 */             box.add(cols[di]);
/* 420 */             box.textL((s.info()).name);
/* 421 */             box.tab(7);
/* 422 */             box.add((SPRITE)GFORMAT.iIncr(box.text(), s.statistics(cl).history(CatPopulation.this.race.get()).get(i)));
/* 423 */             box.NL();
/* 424 */             di++;
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/* 430 */           double am = 0.0D;
/* 431 */           int i = 32 - stapleI - 1;
/* 432 */           int di = 0;
/* 433 */           for (StatsPopulation.StatsDeath.PopData s : (STATS.POP()).COUNT.leaves()) {
/* 434 */             if (((CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(di++)).defaultStanding() <= 0.0D)
/*     */               continue; 
/* 436 */             am += s.statistics(cl).history(CatPopulation.this.race.get()).get(i);
/*     */           } 
/* 438 */           return am;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void renderExtra(SPRITE_RENDERER r, COLOR color, int stapleI, boolean hovered, double value, int x1, int x2, int y1, int y2) {
/* 445 */           double am = 0.0D;
/* 446 */           int i = 32 - stapleI - 1;
/* 447 */           for (StatsPopulation.StatsDeath.PopData s : (STATS.POP()).COUNT.leaves()) {
/* 448 */             am += s.statistics(cl).history(CatPopulation.this.race.get()).get(i);
/*     */           }
/*     */           
/* 451 */           int h = y2 - y1;
/* 452 */           if (h <= 0)
/* 453 */             h = 1; 
/* 454 */           if (am == 0.0D) {
/*     */             return;
/*     */           }
/* 457 */           int ci = 0;
/* 458 */           for (StatsPopulation.StatsDeath.PopData s : (STATS.POP()).COUNT.leaves()) {
/*     */             
/* 460 */             double d = s.statistics(cl).history(CatPopulation.this.race.get()).get(i);
/* 461 */             d /= am;
/* 462 */             int hh = (int)Math.ceil(h * d);
/*     */             
/* 464 */             if (hh > 0) {
/* 465 */               ColorImp c = ColorImp.TMP;
/* 466 */               c.set((COLOR)COLOR.UNIQUE.getC(ci));
/* 467 */               c.shadeSelf(hovered ? 0.75D : 0.55D);
/* 468 */               c.render(r, x1, x2, y2 - hh, y2);
/* 469 */               c.set((COLOR)COLOR.UNIQUE.getC(ci));
/* 470 */               c.shadeSelf(hovered ? 1.0D : 0.8D);
/* 471 */               c.render(r, x1 + 1, x2 - 1, y2 - hh + 1, y2 - 1);
/* 472 */               y2 -= hh;
/*     */             } 
/* 474 */             ci++;
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 482 */     s.body().setWidth(width);
/* 483 */     s.body().setHeight(80.0D);
/* 484 */     ss.addDown(6, (RENDEROBJ)sss);
/*     */     
/* 486 */     return (RENDEROBJ)ss;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatPopulation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */