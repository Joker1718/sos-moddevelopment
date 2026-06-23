/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoosterAbs;
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.religion.RELIGIONS;
/*     */ import init.religion.Religion;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.NEEDS;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBurial;
/*     */ import settlement.stats.colls.StatsReligion;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ final class CatReligion
/*     */   extends Cats.Cat
/*     */ {
/*  48 */   private static CharSequence ¤¤Burrial = "¤Burial";
/*  49 */   private static CharSequence ¤¤AllowRace = "¤Allow/deny access for Species";
/*  50 */   private static CharSequence ¤¤Allow = "¤Allow/deny access for whole class";
/*  51 */   private static CharSequence ¤¤TempleBoost = "¤Temple Boosts";
/*  52 */   private static CharSequence ¤¤Conversion = "¤Conversion";
/*     */   static {
/*  54 */     D.ts(CatReligion.class);
/*     */   }
/*     */ 
/*     */   
/*     */   CatReligion(final HCLASS cl, final GETTER<Race> race) {
/*  59 */     super(new StatCollection[] { (StatCollection)STATS.RELIGION(), (StatCollection)STATS.BURIAL() });
/*  60 */     titleSet((this.cs[0]).info.name);
/*     */     
/*  62 */     this.section.add(dvision(cl, race));
/*     */     
/*  64 */     LinkedList<RENDEROBJ> rens = new LinkedList();
/*     */ 
/*     */ 
/*     */     
/*  68 */     for (StatsReligion.StatReligion r : (STATS.RELIGION()).ALL) {
/*  69 */       rens.add(temple(r, cl, race));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     rens.add(access((STATS.RELIGION()).SHRINE, cl, race));
/*  76 */     rens.add(access((STATS.RELIGION()).TEMPLE, cl, race));
/*     */ 
/*     */     
/*  79 */     rens.add(new GHeader(¤¤TempleBoost));
/*  80 */     GRows rows = new GRows(6);
/*  81 */     final GText t = new GText((UI.FONT()).S, 8);
/*  82 */     for (BoostSpec ss : (STATS.RELIGION()).TEMPLE.TOTAL.boosters.all()) {
/*  83 */       rows.add((RENDEROBJ)new HOVERABLE.HoverableAbs(85, 32)
/*     */           {
/*     */             protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */             {
/*  87 */               GButt.ButtPanel.renderBG(r, true, false, isHovered, (RECTANGLE)this.body);
/*  88 */               ss.boostable.icon.renderCY(r, body().x1() + 8, body().cY());
/*  89 */               t.clear();
/*  90 */               GFORMAT.f0(t, ss.inc((BOOSTABLE_O)HCLASS_RACE.clP((Race)race.get(), cl)));
/*  91 */               t.renderCY(r, body().x1() + 28, body().cY());
/*  92 */               GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */             }
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX box) {
/*  96 */               GBox bb = (GBox)box;
/*     */ 
/*     */               
/*  99 */               bb.title(ss.tName);
/* 100 */               double d = 0.0D;
/* 101 */               for (Religion rr : RELIGIONS.ALL()) {
/* 102 */                 for (BoostSpec sb : rr.boosts.all()) {
/* 103 */                   if (sb.boostable == ss.boostable) {
/* 104 */                     sb.booster.hover(box, sb.booster.get(HCLASS_RACE.clP((Race)race.get(), cl)));
/* 105 */                     BoosterAbs.hoverSpan((GUI_BOX)bb, sb.booster.from(), sb.booster.to());
/* 106 */                     bb.NL();
/*     */                   } 
/*     */                 } 
/*     */               } 
/* 110 */               bb.NL(8);
/*     */               
/* 112 */               bb.textLL(Dic.¤¤Boosts);
/* 113 */               bb.tab(7);
/* 114 */               bb.add((SPRITE)GFORMAT.f0(bb.text(), d));
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 121 */     rens.add((Iterable)rows.rows());
/*     */ 
/*     */ 
/*     */     
/* 125 */     STAT sTAT = (STATS.RELIGION()).OPPOSITION;
/* 126 */     rens.add(new StatRow(sTAT, cl, race));
/*     */ 
/*     */ 
/*     */     
/* 130 */     StatsBurial s = STATS.BURIAL();
/*     */     
/* 132 */     for (STAT ss : s.others()) {
/* 133 */       rens.add(new StatRow(ss, cl, race));
/*     */     }
/*     */ 
/*     */     
/* 137 */     this.section.add((RENDEROBJ)(new GScrollRows((Iterable)rens, HEIGHT - this.section.body().height() - 8, 0)).view(), 0, this.section.body().y2() + 4);
/*     */   }
/*     */ 
/*     */   
/*     */   private static RENDEROBJ access(StatsReligion.ReligionTot tot, HCLASS cl, GETTER<Race> race) {
/* 142 */     return (RENDEROBJ)new StatRow(tot.TOTAL, cl, race);
/*     */   }
/*     */   
/*     */   private static RENDEROBJ dvision(final HCLASS cl, final GETTER<Race> race) {
/* 146 */     GStaples s = new GStaples(32)
/*     */       {
/*     */         protected void hover(GBox box, int stapleI)
/*     */         {
/* 150 */           box.title((((StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(0)).followers.info()).name);
/* 151 */           int i = 32 - stapleI - 1;
/* 152 */           box.add((SPRITE)box.text().add(-i).s().add(TIME.days().cycleName()));
/* 153 */           box.NL(8);
/*     */           
/* 155 */           for (StatsReligion.StatReligion s : (STATS.RELIGION()).ALL) {
/* 156 */             box.add((SPRITE)s.religion.icon);
/* 157 */             box.textLL(s.religion.info.name);
/* 158 */             box.tab(6);
/* 159 */             box.add((SPRITE)GFORMAT.i(box.text(), s.followers.data(cl).get(race.get(), i)));
/* 160 */             box.tab(8);
/* 161 */             if (i < 31)
/* 162 */               box.add((SPRITE)GFORMAT.iIncr(box.text(), (s.followers.data(cl).get(race.get(), i) - s.followers.data(cl).get(race.get(), i + 1)))); 
/* 163 */             box.NL();
/*     */           } 
/*     */           
/* 166 */           box.add((SPRITE)(NEEDS.TYPES()).SHRINE.rate.icon);
/* 167 */           box.textLL(((STATS.RELIGION()).SHRINE.TOTAL.info()).name);
/* 168 */           box.tab(6);
/* 169 */           box.add((SPRITE)GFORMAT.perc(box.text(), (STATS.RELIGION()).SHRINE.TOTAL.data(cl).getD(race.get()), i));
/* 170 */           if (i < 31)
/* 171 */             box.add((SPRITE)GFORMAT.percInc(box.text(), (STATS.RELIGION()).SHRINE.TOTAL.data(cl).getD(race.get(), i) - (STATS.RELIGION()).SHRINE.TOTAL.data(cl).getD(race.get(), i + 1))); 
/* 172 */           box.NL();
/*     */           
/* 174 */           box.add((SPRITE)(NEEDS.TYPES()).TEMPLE.rate.icon);
/* 175 */           box.textLL(((STATS.RELIGION()).TEMPLE.TOTAL.info()).name);
/* 176 */           box.tab(6);
/* 177 */           box.add((SPRITE)GFORMAT.perc(box.text(), (STATS.RELIGION()).TEMPLE.TOTAL.data(cl).getD(race.get()), i));
/* 178 */           if (i < 31)
/* 179 */             box.add((SPRITE)GFORMAT.percInc(box.text(), (STATS.RELIGION()).TEMPLE.TOTAL.data(cl).getD(race.get(), i) - (STATS.RELIGION()).TEMPLE.TOTAL.data(cl).getD(race.get(), i + 1))); 
/* 180 */           box.NL();
/*     */         }
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/* 185 */           int i = 32 - stapleI - 1;
/* 186 */           return (STATS.POP()).POP.data(cl).get(race.get(), i);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void renderExtra(SPRITE_RENDERER r, COLOR color, int stapleI, boolean hovered, double value, int x1, int x2, int y1, int y2) {
/* 194 */           int i = 32 - stapleI - 1;
/*     */           
/* 196 */           int h = y2 - y1;
/* 197 */           if (h <= 0) {
/* 198 */             h = 1;
/*     */           }
/* 200 */           for (StatsReligion.StatReligion s : (STATS.RELIGION()).ALL) {
/* 201 */             int hh = (int)Math.ceil(h * s.followers.data(cl).getD(race.get(), i));
/* 202 */             if (hh > 0) {
/* 203 */               ColorImp c = ColorImp.TMP;
/* 204 */               c.set(s.religion.color);
/* 205 */               c.shadeSelf(hovered ? 0.75D : 0.55D);
/* 206 */               c.render(r, x1, x2, y2 - hh, y2);
/* 207 */               c.set(s.religion.color);
/* 208 */               c.shadeSelf(hovered ? 1.0D : 0.8D);
/* 209 */               c.render(r, x1 + 1, x2 - 1, y2 - hh + 1, y2 - 1);
/* 210 */               y2 -= hh;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 216 */     s.body().setWidth(532.0D);
/* 217 */     s.body().setHeight(80.0D);
/* 218 */     return (RENDEROBJ)s;
/*     */   }
/*     */   
/*     */   private static RENDEROBJ temple(final StatsReligion.StatReligion ss, final HCLASS cl, final GETTER<Race> race) {
/* 222 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 225 */           if (!isHoveringAHoverElement()) {
/*     */             
/* 227 */             GBox b = (GBox)text;
/* 228 */             b.title(ss.info.name);
/* 229 */             b.text(ss.info.desc);
/* 230 */             b.NL(8);
/*     */             
/* 232 */             b.textL((ss.followers.info()).name);
/* 233 */             b.tab(8);
/* 234 */             b.add((SPRITE)GFORMAT.i(b.text(), ss.followers.data(cl).get(race.get())));
/* 235 */             b.NL();
/*     */             
/* 237 */             b.textLL((STATS.RELIGION()).TEMPLE.name);
/* 238 */             b.tab(6);
/* 239 */             b.add((SPRITE)GFORMAT.perc(b.text(), (STATS.RELIGION()).TEMPLE.access(ss.religion).data(cl).getD(race.get())));
/* 240 */             b.add((SPRITE)GFORMAT.perc(b.text(), (STATS.RELIGION()).TEMPLE.quality(ss.religion).data(cl).getD(race.get())));
/* 241 */             b.NL();
/*     */             
/* 243 */             b.textLL((STATS.RELIGION()).SHRINE.name);
/* 244 */             b.tab(6);
/* 245 */             b.add((SPRITE)GFORMAT.perc(b.text(), (STATS.RELIGION()).SHRINE.access(ss.religion).data(cl).getD(race.get())));
/* 246 */             b.add((SPRITE)GFORMAT.perc(b.text(), (STATS.RELIGION()).SHRINE.quality(ss.religion).data(cl).getD(race.get())));
/* 247 */             b.NL();
/*     */             
/* 249 */             b.textLL(CatReligion.¤¤Conversion);
/* 250 */             b.tab(6);
/* 251 */             b.add((SPRITE)GFORMAT.f0(b.text(), ss.religion.conversionCity.get((BOOSTABLE_O)cl.get((Race)race.get()))));
/*     */             
/* 253 */             b.NL(8);
/*     */ 
/*     */             
/* 256 */             ss.religion.boosts.hover(text, (BOOSTABLE_O)HCLASS_RACE.clP((Race)race.get(), cl), 4);
/*     */           } 
/*     */ 
/*     */           
/* 260 */           super.hoverInfoGet(text);
/*     */         }
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/* 265 */           GCOLOR.UI().border().render(r, (RECTANGLE)body());
/* 266 */           GCOLOR.UI().bg().render(r, (RECTANGLE)body(), -1);
/* 267 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */     
/* 271 */     s.addRightC(4, (RENDEROBJ)new RENDEROBJ.RenderImp(16, 16)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 275 */             ColorImp.TMP.set(ss.religion.color);
/* 276 */             ColorImp.TMP.shadeSelf(0.75D);
/* 277 */             ColorImp.TMP.render(r, (RECTANGLE)this.body);
/* 278 */             ColorImp.TMP.set(ss.religion.color);
/* 279 */             ColorImp.TMP.render(r, (RECTANGLE)this.body, -2);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 285 */     s.addRightC(16, (SPRITE)ss.religion.icon);
/*     */     
/* 287 */     s.addRightC(16, (SPRITE)(UI.icons()).s.human);
/* 288 */     s.addRightC(4, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 292 */             GFORMAT.i(text, ss.followers.data(cl).get(race.get()));
/*     */           }
/*     */         });
/*     */     
/* 296 */     s.addRightC(64, (SPRITE)(NEEDS.TYPES()).SHRINE.rate.icon);
/* 297 */     s.addRightC(16, (RENDEROBJ)new GButt.Checkbox()
/*     */         {
/*     */           protected void clickA() {
/* 300 */             ss.permissionShrine.toggle(cl, (Race)race.get());
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 305 */             selectedSet(is());
/*     */           }
/*     */           
/*     */           private boolean is() {
/* 309 */             return ss.permissionShrine.get(cl, (Race)race.get());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 314 */             if (race.get() != null) {
/* 315 */               text.text(CatReligion.¤¤AllowRace);
/*     */             } else {
/* 317 */               text.text(CatReligion.¤¤Allow);
/*     */             }  }
/*     */         });
/* 320 */     s.addRightC(4, (RENDEROBJ)new RENDEROBJ.RenderImp(100, 16)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 324 */             double v = (STATS.RELIGION()).SHRINE.access(ss.religion).data(cl).getD(race.get()) * (STATS.RELIGION()).SHRINE.quality(ss.religion).data(cl).getD(race.get());
/* 325 */             GMeter.render(r, GMeter.C_BLUE, v, (RECTANGLE)body());
/*     */           }
/*     */         });
/*     */     
/* 329 */     s.addRightC(16, (SPRITE)(NEEDS.TYPES()).TEMPLE.rate.icon);
/* 330 */     s.addRightC(16, (RENDEROBJ)new GButt.Checkbox()
/*     */         {
/*     */           protected void clickA() {
/* 333 */             ss.permissionTemple.toggle(cl, (Race)race.get());
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 338 */             selectedSet(is());
/*     */           }
/*     */           
/*     */           private boolean is() {
/* 342 */             return ss.permissionTemple.get(cl, (Race)race.get());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 347 */             if (race.get() != null) {
/* 348 */               text.text(CatReligion.¤¤AllowRace);
/*     */             } else {
/* 350 */               text.text(CatReligion.¤¤Allow);
/*     */             }  }
/*     */         });
/* 353 */     s.addRightC(4, (RENDEROBJ)new RENDEROBJ.RenderImp(100, 16)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 357 */             double v = (STATS.RELIGION()).TEMPLE.access(ss.religion).data(cl).getD(race.get()) * (STATS.RELIGION()).TEMPLE.quality(ss.religion).data(cl).getD(race.get());
/* 358 */             GMeter.render(r, GMeter.C_BLUE, v, (RECTANGLE)body());
/*     */           }
/*     */         });
/*     */     
/* 362 */     s.pad(10, 6);
/* 363 */     s.body().setWidth(520.0D);
/* 364 */     return (RENDEROBJ)s;
/*     */   }
/*     */   
/*     */   static final class StatRowGrave
/*     */   {
/*     */     private final HCLASS cl;
/*     */     private final GETTER<Race> race;
/*     */     
/*     */     StatRowGrave(final HCLASS cl, final GETTER<Race> race, LinkedList<RENDEROBJ> rens) {
/* 373 */       this.race = race;
/* 374 */       this.cl = cl;
/*     */       
/* 376 */       boolean has = false;
/* 377 */       for (StatsBurial.StatGrave ss : STATS.BURIAL().graves()) {
/* 378 */         for (Race r : RACES.all()) {
/* 379 */           if ((ss.standing().definition(r).get(cl)).max > 0.0D) {
/* 380 */             has = true;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 385 */       if (!has) {
/*     */         return;
/*     */       }
/* 388 */       GuiSection s = new GuiSection();
/*     */       
/* 390 */       s.add((SPRITE)(new GText((UI.FONT()).H2, CatReligion.¤¤Burrial)).lablify(), 0, 0);
/* 391 */       s.addRightCAbs(268, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 395 */               double d = 0.0D;
/* 396 */               for (StatsBurial.StatGrave ss : STATS.BURIAL().graves()) {
/* 397 */                 d = Math.max(d, ss.data(cl).getD(race.get()));
/*     */               }
/* 399 */               GFORMAT.perc(text, d);
/*     */             }
/*     */           });
/*     */       
/* 403 */       s.addCentredY((RENDEROBJ)new RENDEROBJ.RenderImp(200, 20)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, float ds)
/*     */             {
/* 407 */               double max = 0.0D;
/* 408 */               double now = 0.0D;
/* 409 */               double nor = 0.0D;
/* 410 */               double prev = 0.0D;
/* 411 */               for (StatsBurial.StatGrave s : STATS.BURIAL().graves()) {
/* 412 */                 max = Math.max(max, s.standing().max(cl, (Race)race.get()));
/* 413 */                 now = Math.max(now, s.standing().get(cl, (Race)race.get()));
/* 414 */                 prev = Math.max(prev, s.standing().getPrev(cl, (Race)race.get(), 8));
/* 415 */                 nor = Math.max(nor, s.standing().normalized(cl, (Race)race.get()));
/*     */               } 
/*     */               
/* 418 */               GMeter.renderDelta(r, prev / max, now / max, this.body.x1(), (int)(body().x1() + body().width() * nor), body().y1(), body().y2());
/*     */             }
/* 420 */           }328);
/* 421 */       s.pad(4, 0);
/* 422 */       rens.add(s);
/*     */       
/* 424 */       for (StatsBurial.StatGrave ss : STATS.BURIAL().graves()) {
/* 425 */         for (Race r : RACES.all()) {
/* 426 */           if ((ss.standing().definition(r).get(cl)).max > 0.0D) {
/*     */             
/* 428 */             rens.add(service(ss));
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private RENDEROBJ service(final StatsBurial.StatGrave ss) {
/* 439 */       GuiSection s = new GuiSection()
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 442 */             if (!isHoveringAHoverElement()) {
/* 443 */               ss.hover(text, CatReligion.StatRowGrave.this.cl, (Race)CatReligion.StatRowGrave.this.race.get());
/*     */             }
/* 445 */             super.hoverInfoGet(text);
/*     */           }
/*     */         };
/* 448 */       s.add((RENDEROBJ)new StatRow.Arrow((STAT)ss, this.cl, this.race));
/* 449 */       s.addRightC(4, (RENDEROBJ)new GButt.Checkbox()
/*     */           {
/*     */             protected void clickA() {
/* 452 */               ss.grave().permission().toggle(CatReligion.StatRowGrave.this.cl, (Race)CatReligion.StatRowGrave.this.race.get());
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 457 */               selectedSet(is());
/*     */             }
/*     */             
/*     */             private boolean is() {
/* 461 */               return ss.grave().permission().get(CatReligion.StatRowGrave.this.cl, (Race)CatReligion.StatRowGrave.this.race.get());
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 466 */               if (CatReligion.StatRowGrave.this.race.get() != null) {
/* 467 */                 text.text(CatReligion.¤¤AllowRace);
/*     */               } else {
/* 469 */                 text.text(CatReligion.¤¤Allow);
/*     */               }  }
/*     */           });
/* 472 */       s.addRightC(4, (SPRITE)ss.grave().blueprint().iconBig());
/* 473 */       s.addRightC(4, (SPRITE)(new GText((UI.FONT()).S, (ss.grave().blueprint()).info.names)).lablifySub());
/* 474 */       s.addCentredY((SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 478 */               text.setFont((UI.FONT()).S);
/*     */               
/* 480 */               StatRow.format(text, (STAT)ss, ss.data(CatReligion.StatRowGrave.this.cl).getD(CatReligion.StatRowGrave.this.race.get()), CatReligion.StatRowGrave.this.cl, (Race)CatReligion.StatRowGrave.this.race.get());
/*     */             }
/* 482 */           }268);
/*     */       
/* 484 */       s.addCentredY((RENDEROBJ)new RENDEROBJ.RenderImp(200, 12)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, float ds)
/*     */             {
/* 488 */               double max = ss.standing().max(CatReligion.StatRowGrave.this.cl, (Race)CatReligion.StatRowGrave.this.race.get());
/* 489 */               double now = ss.standing().get(CatReligion.StatRowGrave.this.cl, (Race)CatReligion.StatRowGrave.this.race.get());
/* 490 */               double nor = ss.standing().normalized(CatReligion.StatRowGrave.this.cl, (Race)CatReligion.StatRowGrave.this.race.get());
/* 491 */               GMeter.render(r, GMeter.C_BLUE, now / max, this.body.x1(), (int)(body().x1() + body().width() * nor), body().y1(), body().y2());
/*     */             }
/* 493 */           }328);
/*     */ 
/*     */       
/* 496 */       return (RENDEROBJ)s;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatReligion.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */