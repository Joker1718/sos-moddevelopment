/*     */ package view.sett.ui.subject;
/*     */ import game.GAME;
/*     */ import game.boosting.BHoverer;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HTYPE;
/*     */ import init.type.NEED;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.colls.StatsEducation;
/*     */ import settlement.stats.colls.StatsNeeds;
/*     */ import settlement.stats.colls.StatsReligion;
/*     */ import settlement.stats.service.StatService;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.colors.GCOLOR_UI;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ final class UISubjectProperties extends GuiSection {
/*     */   private final AInfo a;
/*  53 */   private static CharSequence ¤¤percPerDay = "¤Increase per day: {0}% / day";
/*  54 */   private static CharSequence ¤¤services = "¤Related Services";
/*  55 */   private static CharSequence ¤¤need = "¤Current Need";
/*  56 */   private static CharSequence ¤¤Tasks = "¤Tasks";
/*  57 */   private static CharSequence ¤¤Status = "¤Status";
/*  58 */   private static CharSequence ¤¤noModule = "¤This type of subject does not engage in this activities";
/*  59 */   private static CharSequence ¤¤serviceDesc = "¤When a subject has spare time, they want to consume services. This is how frequently they'll generally visit services that cater to this need per year.";
/*     */   
/*  61 */   private final int hi = 32; private int upI; private double cc;
/*     */   
/*     */   static {
/*  64 */     D.ts(UISubjectProperties.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final RENDEROBJ h(CharSequence name) {
/*  88 */     return (RENDEROBJ)new RENDEROBJ.RenderImp(10, 32, name) {
/*     */         GText t;
/*     */         
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/*  92 */           this.t.renderCY(r, body().x1() + 16, this.body.cY());
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private void makeModules(LinkedList<RENDEROBJ> rows, HTYPE type) {
/*  98 */     final GText text = new GText((UI.FONT()).S, 6);
/*  99 */     int w = 166;
/* 100 */     int cols = 3;
/*     */     
/* 102 */     GuiSection s = null;
/*     */     
/* 104 */     for (AIModule m : AI.modules().ALL()) {
/* 105 */       if (m == null) {
/*     */         continue;
/*     */       }
/* 108 */       if (!m.has(type)) {
/*     */         continue;
/*     */       }
/* 111 */       CLICKABLE.ClickableAbs clickableAbs = new CLICKABLE.ClickableAbs(w, 32)
/*     */         {
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */           {
/* 116 */             isSelected = m.is(UISubjectProperties.this.a.a, (AIManager)UISubjectProperties.this.a.a.ai());
/* 117 */             GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 118 */             GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */             
/* 120 */             int x1 = body().x1() + 8;
/*     */             
/* 122 */             m.icon().renderCY(r, x1, body().cY());
/*     */             
/* 124 */             x1 += 20;
/*     */ 
/*     */             
/* 127 */             text.clear();
/* 128 */             text.add(m.name);
/* 129 */             text.setMultipleLines(false);
/* 130 */             text.setMaxWidth(80);
/* 131 */             text.lablify();
/* 132 */             text.renderCY(r, x1, body().cY());
/* 133 */             x1 += 100;
/*     */ 
/*     */ 
/*     */             
/* 137 */             int p = m.has(UISubjectProperties.this.a.a.indu().hType()) ? m.getPriority(UISubjectProperties.this.a.a, (AIManager)UISubjectProperties.this.a.a.ai()) : 0;
/*     */             
/* 139 */             text.clear();
/* 140 */             GFORMAT.iIncr(text, p);
/* 141 */             text.renderCY(r, x1, body().cY());
/*     */ 
/*     */             
/* 144 */             if (!m.has(UISubjectProperties.this.a.a.indu().hType())) {
/* 145 */               OPACITY op = OPACITY.O50;
/* 146 */               op.bind();
/*     */               
/* 148 */               COLOR.BLACK.render(r, (RECTANGLE)this.body, -3);
/* 149 */               OPACITY.unbind();
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 157 */             GBox b = (GBox)text;
/* 158 */             b.title(m.name);
/* 159 */             if (m.desc != null)
/* 160 */               b.text(m.desc); 
/* 161 */             if (!m.has(UISubjectProperties.this.a.a.indu().hType())) {
/* 162 */               b.add((SPRITE)b.text().warnify().add(UISubjectProperties.¤¤noModule));
/*     */             }
/*     */             
/* 165 */             super.hoverInfoGet(text);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 170 */       if (s == null || s.elements().size() >= cols) {
/* 171 */         s = new GuiSection();
/* 172 */         rows.add(s);
/*     */       } 
/* 174 */       s.addRight(2, (RENDEROBJ)clickableAbs);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   UISubjectProperties(AInfo a, int height, HTYPE t) {
/* 180 */     this.upI = -1;
/* 181 */     this.cc = 0.0D; this.a = a; LinkedList<RENDEROBJ> rows = new LinkedList(); rows.add(h(¤¤Tasks)); makeModules(rows, t); rows.add(h((NEEDS.bCatE()).name)); rows.add(work()); makeStats((LISTE<RENDEROBJ>)rows);
/*     */     makeTraining(rows);
/*     */     makeProperties(rows);
/*     */     GScrollRows sc = new GScrollRows((Iterable)rows, height - 4, 0);
/* 185 */     add((RENDEROBJ)sc.view()); } private double ni() { if (this.upI != GAME.updateI()) {
/* 186 */       this.upI = GAME.updateI();
/* 187 */       this.cc = 0.0D;
/* 188 */       for (NEED n : NEEDS.ALLSIMPLE()) {
/* 189 */         this.cc += n.rate.get((BOOSTABLE_O)this.a.a.indu());
/*     */       }
/*     */       
/* 192 */       this.cc = 0.5D * TIME.servicePerDay() / this.cc;
/*     */     } 
/*     */     
/* 195 */     return this.cc; }
/*     */ 
/*     */ 
/*     */   
/*     */   private void makeTraining(LinkedList<RENDEROBJ> rows) {
/* 200 */     rows.add(h(¤¤Status));
/*     */     
/* 202 */     rows.add(trainingStat((STATS.BATTLE()).ENEMY_KILLS));
/* 203 */     for (StatsBattle.StatTraining t : (STATS.BATTLE()).TRAINING_ALL) {
/* 204 */       rows.add(trainingStat((STAT)t.stat));
/*     */     }
/* 206 */     for (StatsEducation.StatEducation t : (STATS.EDUCATION()).all)
/* 207 */       rows.add(trainingStat(t.total)); 
/*     */   }
/*     */   
/*     */   private RENDEROBJ trainingStat(final STAT st) {
/* 211 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 215 */           st.hover(text, UISubjectProperties.this.a.a.indu());
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 220 */     if ((st.info()).icon != null) {
/* 221 */       s.add((st.info()).icon, 0, 0);
/*     */     }
/* 223 */     s.addRightC(4, (SPRITE)(new GText((UI.FONT()).S, (st.info()).name)).lablify());
/*     */     
/* 225 */     s.addRightCAbs(300, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 229 */             if (st.info().isInt()) {
/* 230 */               GFORMAT.i(text, st.indu().get(UISubjectProperties.this.a.a.indu()));
/*     */             } else {
/* 232 */               GFORMAT.perc(text, st.indu().getD(UISubjectProperties.this.a.a.indu()));
/*     */             } 
/*     */           }
/*     */         });
/* 236 */     return (RENDEROBJ)s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void makeProperties(LinkedList<RENDEROBJ> rows) {
/* 249 */     final GText text = new GText((UI.FONT()).S, 6);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 255 */     int w = 125;
/* 256 */     int cols = 4;
/*     */     
/* 258 */     rows.add(h((NEEDS.bCat()).name));
/* 259 */     GuiSection s = null;
/* 260 */     for (NEED n : NEEDS.ALLSIMPLE()) {
/*     */       
/* 262 */       HOVERABLE.HoverableAbs hoverableAbs = new HOVERABLE.HoverableAbs(w, 32)
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*     */             SPRITE sPRITE;
/* 266 */             GCOLOR.UI().border().render(r, (RECTANGLE)this.body, -1);
/* 267 */             GCOLOR.UI().bg(true, false, isHovered).render(r, (RECTANGLE)this.body, -2);
/* 268 */             double curr = TIME.years().bitConversion((TIMECYCLE)TIME.days()) * UISubjectProperties.this.ni() * n.rate.get((BOOSTABLE_O)UISubjectProperties.this.a.a.indu());
/* 269 */             double m = TIME.years().bitConversion((TIMECYCLE)TIME.days()) * UISubjectProperties.this.ni() * n.rate.baseValue;
/*     */             
/* 271 */             if (m > 0.0D) {
/* 272 */               COLOR col = GCOLOR_UI.color((GCOLOR.UI()).NEUTRAL.inactive, true, false, isHovered);
/* 273 */               double d = curr / m - 0.5D;
/* 274 */               d = CLAMP.d(d, 0.0D, 1.0D);
/* 275 */               int w = (int)(d * (body().width() - 6));
/* 276 */               col.render(r, body().x1() + 3, body().x1() + 3 + w, body().y1() + 3, body().y2() - 3);
/*     */             } 
/*     */ 
/*     */             
/* 280 */             Icon icon = n.rate.icon;
/* 281 */             if (n == (NEEDS.TYPES()).SHRINE) {
/* 282 */               sPRITE = ((StatsReligion.StatReligion)(STATS.RELIGION()).getter.get(UISubjectProperties.this.a.a.indu())).religion.icon.small;
/* 283 */             } else if (n == (NEEDS.TYPES()).TEMPLE) {
/* 284 */               sPRITE = ((StatsReligion.StatReligion)(STATS.RELIGION()).getter.get(UISubjectProperties.this.a.a.indu())).religion.icon.small;
/*     */             } 
/* 286 */             sPRITE.renderCY(r, body().x1() + 3, body().cY());
/*     */             
/* 288 */             text.clear();
/* 289 */             GFORMAT.fRel(text, curr, m);
/* 290 */             text.renderCY(r, body().x1() + 23, body().cY());
/*     */             
/* 292 */             int x1 = body().x1() + 75;
/*     */             
/* 294 */             for (StatService s : STATS.SERVICE().perNeed(n)) {
/* 295 */               icon(r, s.access(UISubjectProperties.this.a.a), x1);
/* 296 */               x1 += 12;
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 303 */             GBox b = (GBox)text;
/* 304 */             b.title(n.rate.name);
/* 305 */             b.text(UISubjectProperties.¤¤serviceDesc);
/* 306 */             text.NL(4);
/* 307 */             GFORMAT.f(b.text(), UISubjectProperties.this.ni() * n.rate.get((BOOSTABLE_O)UISubjectProperties.this.a.a.indu()));
/* 308 */             b.NL(8);
/*     */ 
/*     */             
/* 311 */             b.textLL(UISubjectProperties.¤¤services);
/* 312 */             b.NL();
/*     */             
/* 314 */             for (StatService s : STATS.SERVICE().perNeed(n)) {
/* 315 */               hh(b, s.icon(UISubjectProperties.this.a.a.indu()), s.name, s.access(UISubjectProperties.this.a.a));
/*     */             }
/* 317 */             b.NL();
/* 318 */             b.sep();
/* 319 */             BHoverer.hover((GUI_BOX)b, n.rate.all(), UISubjectProperties.this.a.a.indu(), Dic.¤¤Rate, n.rate.baseValue, true);
/*     */           }
/*     */ 
/*     */           
/*     */           private void icon(SPRITE_RENDERER r, boolean access, int x1) {
/* 324 */             if (access) {
/* 325 */               (GCOLOR.UI()).GOOD.hovered.bind();
/* 326 */               (UI.icons()).s.allRight.renderCY(r, x1, this.body.cY());
/*     */             } else {
/* 328 */               (GCOLOR.UI()).BAD.hovered.bind();
/* 329 */               (UI.icons()).s.cancel.renderCY(r, x1, this.body.cY());
/*     */             } 
/*     */           }
/*     */           
/*     */           private void hh(GBox b, SPRITE icon, CharSequence name, boolean access) {
/* 334 */             b.add(icon);
/* 335 */             b.textLL(name);
/* 336 */             b.tab(7);
/* 337 */             if (access) {
/* 338 */               b.add((SPRITE)(UI.icons()).s.allRight, (GCOLOR.UI()).GOOD.hovered);
/*     */             } else {
/* 340 */               b.add((SPRITE)(UI.icons()).s.cancel, (GCOLOR.UI()).BAD.hovered);
/*     */             } 
/* 342 */             b.NL();
/*     */           }
/*     */         };
/*     */       
/* 346 */       if (s == null || s.elements().size() >= cols) {
/* 347 */         s = new GuiSection();
/* 348 */         rows.add(s);
/*     */       } 
/* 350 */       s.addRight(2, (RENDEROBJ)hoverableAbs);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 355 */     for (BoostableCat cat : BOOSTABLES.colls()) {
/*     */       
/* 357 */       s = null;
/*     */ 
/*     */       
/* 360 */       rows.add(h(cat.name));
/*     */       
/* 362 */       for (Boostable b : cat.all()) {
/*     */         
/* 364 */         Boo boo = new Boo(b);
/* 365 */         if (s == null || s.elements().size() >= 5) {
/* 366 */           s = new GuiSection();
/* 367 */           rows.add(s);
/*     */         } 
/* 369 */         s.addRight(2, (RENDEROBJ)boo);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private class Boo
/*     */     extends HOVERABLE.HoverableAbs
/*     */   {
/*     */     private final Boostable boo;
/* 378 */     private final GText text = new GText((UI.FONT()).S, 6);
/*     */     
/*     */     Boo(Boostable b) {
/* 381 */       super(100, 32);
/* 382 */       this.boo = b;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 387 */       GCOLOR.UI().border().render(r, (RECTANGLE)this.body, -1);
/* 388 */       GCOLOR.UI().bg(true, false, isHovered).render(r, (RECTANGLE)this.body, -2);
/* 389 */       double curr = this.boo.get((BOOSTABLE_O)UISubjectProperties.this.a.a.indu());
/* 390 */       double m = this.boo.max(Induvidual.class);
/*     */       
/* 392 */       if (m > 0.0D) {
/* 393 */         COLOR col = GCOLOR_UI.color((GCOLOR.UI()).NEUTRAL.inactive, true, false, isHovered);
/* 394 */         int w = (int)(curr / m * (body().width() - 6));
/* 395 */         col.render(r, body().x1() + 3, body().x1() + 3 + w, body().y1() + 3, body().y2() - 3);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 400 */       this.boo.icon.renderCY(r, body().x1() + 3, body().cY());
/*     */       
/* 402 */       this.text.clear();
/* 403 */       GFORMAT.fRel(this.text, curr, UISubjectProperties.this.a.a.race().bvalue(this.boo));
/* 404 */       this.text.renderCY(r, body().x1() + 23, body().cY());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 410 */       UISubjectProperties.this.hoverBoost(this.boo, text);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void makeStats(LISTE<RENDEROBJ> rows) {
/* 418 */     GText work = new GText((UI.FONT()).S, 32);
/*     */     
/* 420 */     for (StatsNeeds.StatNeedNormal s : (STATS.NEEDS()).SNEEDS) {
/* 421 */       CLICKABLE c = makeNeed((SPRITE)s.need.rate.icon, s, s.stat(), work);
/* 422 */       rows.add(c);
/*     */     } 
/* 424 */     rows.add(makeNeed((SETT.ROOMS()).HOSPITAL.icon.small, (StatsNeeds.StatNeedNormal)null, (STATS.NEEDS()).INJURIES.COUNT, work));
/* 425 */     rows.add(makeNeed((SPRITE)(UI.icons()).s.heat, (StatsNeeds.StatNeedNormal)null, (STATS.NEEDS()).EXPOSURE.COUNT, work));
/* 426 */     rows.add(makeNeed((SPRITE)(UI.icons()).s.clock, (StatsNeeds.StatNeedNormal)null, (STATS.NEEDS()).EXHASTION, work));
/*     */   }
/*     */   
/*     */   CLICKABLE work() {
/* 430 */     return (CLICKABLE)new CLICKABLE.ClickableAbs(500, 32) {
/* 431 */         GText work = new GText((UI.FONT()).S, 32);
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 436 */           GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 437 */           GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */           
/* 439 */           int x1 = body().x1() + 8;
/*     */           
/* 441 */           RoomInstance w = (RoomInstance)(STATS.WORK()).EMPLOYED.get(UISubjectProperties.this.a.a);
/* 442 */           SPRITE ico = (w != null) ? (w.blueprintI()).icon.small : (SPRITE)(UI.icons()).s.hammer;
/* 443 */           ico.renderCY(r, x1, body().cY());
/*     */           
/* 445 */           x1 += 20;
/*     */           
/* 447 */           this.work.setFont((UI.FONT()).S);
/* 448 */           this.work.clear();
/* 449 */           this.work.add(Dic.¤¤WorkVerb);
/* 450 */           this.work.setMultipleLines(false);
/* 451 */           this.work.setMaxWidth(200);
/* 452 */           this.work.lablify();
/* 453 */           this.work.renderCY(r, x1, body().cY());
/* 454 */           x1 += 230;
/*     */           
/* 456 */           int i = (STATS.WORK()).WORK_TIME.indu().max(UISubjectProperties.this.a.a.indu()) - (STATS.WORK()).WORK_TIME.indu().get(UISubjectProperties.this.a.a.indu());
/* 457 */           double m = (STATS.WORK()).WORK_TIME.indu().max(UISubjectProperties.this.a.a.indu());
/* 458 */           double d = i / m;
/*     */           
/* 460 */           GMeter.GMeterCol c = GMeter.C_GREEN;
/* 461 */           GMeter.render(r, c, 
/* 462 */               d, 
/* 463 */               x1, x1 + 75, body().y1() + 8, body().y2() - 8);
/*     */ 
/*     */           
/* 466 */           x1 += 90;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 473 */           text.title(Dic.¤¤WorkVerb);
/* 474 */           text.NL(4);
/* 475 */           GBox b = (GBox)text;
/* 476 */           b.textL(UISubjectProperties.this.a.a.title());
/*     */ 
/*     */           
/* 479 */           b.NL(8);
/* 480 */           b.textLL(Dic.¤¤WorkShift);
/* 481 */           b.tab(6);
/*     */           
/* 483 */           GText t = b.text();
/* 484 */           int end = (UISubjectProperties.this.a.a.getNewDayHour() + TIME.workHours()) % 24;
/* 485 */           t.add(UISubjectProperties.this.a.a.getNewDayHour()).add(':').add('0').add('0').s().add('-').s().add(end).add(':').add('0').add('0');
/* 486 */           b.add((SPRITE)t);
/*     */           
/* 488 */           b.NL();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 496 */           DebugInput.activate((DOUBLE_O.DOUBLE_OE<Induvidual>)(STATS.WORK()).WORK_TIME.indu(), UISubjectProperties.this.a.a);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   CLICKABLE makeNeed(final SPRITE icon, final StatsNeeds.StatNeedNormal n, final STAT s, final GText work) {
/* 502 */     return (CLICKABLE)new CLICKABLE.ClickableAbs(500, 32)
/*     */       {
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */         {
/* 508 */           GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 509 */           GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */           
/* 511 */           int x1 = body().x1() + 8;
/*     */           
/* 513 */           if (n != null) {
/*     */             
/* 515 */             n.need.rate.icon.renderCY(r, x1, body().cY());
/*     */           } else {
/* 517 */             icon.renderCY(r, x1, body().cY());
/*     */           } 
/* 519 */           x1 += 20;
/*     */           
/* 521 */           work.setFont((UI.FONT()).S);
/* 522 */           work.clear();
/* 523 */           work.add((s.info()).name);
/* 524 */           work.setMultipleLines(false);
/* 525 */           work.setMaxWidth(200);
/* 526 */           work.lablify();
/* 527 */           work.renderCY(r, x1, body().cY());
/* 528 */           x1 += 230;
/*     */           
/* 530 */           int i = s.indu().get(UISubjectProperties.this.a.a.indu());
/* 531 */           double m = s.indu().max(UISubjectProperties.this.a.a.indu());
/* 532 */           double d = i / m;
/*     */           
/* 534 */           GMeter.GMeterCol c = GMeter.C_GREEN;
/* 535 */           if (n == null || i > n.breakpoint()) {
/* 536 */             c = GMeter.C_RED;
/*     */           }
/* 538 */           GMeter.render(r, c, 
/* 539 */               d, 
/* 540 */               x1, x1 + 75, body().y1() + 8, body().y2() - 8);
/*     */ 
/*     */ 
/*     */           
/* 544 */           if (n != null) {
/* 545 */             int x = (int)(x1 + 75.0D * n.breakpoint() / m);
/* 546 */             GCOLOR.UI().border().render(r, x, x + 1, body().y1() + 8, body().y2() - 8);
/*     */           } 
/*     */           
/* 549 */           x1 += 90;
/*     */           
/* 551 */           work.clear();
/*     */           
/* 553 */           if (n != null) {
/*     */             
/* 555 */             GFORMAT.percInc(work, n.need.rate.get((BOOSTABLE_O)UISubjectProperties.this.a.a.indu()), 0);
/* 556 */             work.renderCY(r, x1, body().cY());
/* 557 */             x1 += 45;
/*     */             
/* 559 */             for (StatService s : STATS.SERVICE().perNeed((NEED)n.need)) {
/* 560 */               boolean ok = UISubjectProperties.this.access(s, (NEED)n.need);
/*     */               
/* 562 */               if (ok) {
/* 563 */                 (GCOLOR.UI()).GOOD.hovered.bind();
/* 564 */                 (UI.icons()).s.allRight.renderCY(r, x1, body().cY());
/*     */               } else {
/* 566 */                 (GCOLOR.UI()).BAD.hovered.bind();
/* 567 */                 (UI.icons()).s.cancel.renderCY(r, x1, body().cY());
/*     */               } 
/* 569 */               x1 += 12;
/*     */             } 
/* 571 */             COLOR.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 582 */           text.title((s.info()).name);
/* 583 */           text.text((s.info()).desc);
/* 584 */           text.NL(4);
/* 585 */           GBox b = (GBox)text;
/* 586 */           b.textLL(UISubjectProperties.¤¤need);
/* 587 */           b.tab(6);
/* 588 */           if (n != null) {
/* 589 */             double d = s.indu().get(UISubjectProperties.this.a.a.indu()) / n.breakpoint();
/* 590 */             b.add((SPRITE)GFORMAT.perc(b.text(), d));
/* 591 */             b.NL();
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 597 */           if (n != null) {
/*     */ 
/*     */ 
/*     */             
/* 601 */             b.textLL(UISubjectProperties.¤¤services);
/* 602 */             b.NL();
/*     */             
/* 604 */             for (StatService s : STATS.SERVICE().perNeed((NEED)n.need)) {
/* 605 */               b.add(s.icon(UISubjectProperties.this.a.a.indu()));
/* 606 */               b.textLL(s.name(UISubjectProperties.this.a.a.indu()));
/* 607 */               b.tab(6);
/* 608 */               if (UISubjectProperties.this.access(s, (NEED)n.need)) {
/* 609 */                 b.add((SPRITE)(UI.icons()).s.allRight, (GCOLOR.UI()).GOOD.hovered);
/*     */               } else {
/* 611 */                 b.add((SPRITE)(UI.icons()).s.cancel, (GCOLOR.UI()).BAD.hovered);
/*     */               } 
/* 613 */               b.NL();
/*     */             } 
/* 615 */             b.NL();
/* 616 */             b.sep();
/* 617 */             GText t = b.text();
/* 618 */             t.add(UISubjectProperties.¤¤percPerDay).insert(0, (int)(100.0D * n.need.rate.get((BOOSTABLE_O)UISubjectProperties.this.a.a.indu())));
/* 619 */             n.need.rate.hover((GUI_BOX)b, (BOOSTABLE_O)UISubjectProperties.this.a.a.indu(), (CharSequence)t, true);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 625 */           DebugInput.activate((DOUBLE_O.DOUBLE_OE<Induvidual>)s.indu(), UISubjectProperties.this.a.a);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private boolean access(StatService s, NEED n) {
/* 631 */     return s.access(this.a.a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void hoverBoost(Boostable boo, GUI_BOX text) {
/* 637 */     text.title(boo.name);
/* 638 */     text.text(boo.desc);
/* 639 */     text.NL(8);
/* 640 */     boo.hover(text, (BOOSTABLE_O)this.a.a.indu(), true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectProperties.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */