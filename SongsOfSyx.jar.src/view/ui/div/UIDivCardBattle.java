/*     */ package view.ui.div;
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.factors.DivFactor;
/*     */ import game.battle.formation.DivFormation;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.thread.trajectory.BattleTrajectories;
/*     */ import game.battle.util.Copyable;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import settlement.stats.equip.EquipRange;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.misc.GTextR;
/*     */ import util.info.GFORMAT;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public final class UIDivCardBattle implements DIMENSION {
/*     */   public final int width;
/*     */   public final int height;
/*     */   private final UIDiv m;
/*  54 */   private final Rec body = new Rec();
/*     */   
/*     */   private final DivFormationImp forDest;
/*  57 */   private static CharSequence ¤¤Standing = "¤Standing";
/*  58 */   private static CharSequence ¤¤Moving = "¤Moving";
/*  59 */   private static CharSequence ¤¤Attacking = "¤Attacking";
/*     */   
/*  61 */   private static CharSequence ¤¤Building = "¤Attacking Structure";
/*  62 */   private static CharSequence ¤¤Charging = "¤Charging";
/*  63 */   private static CharSequence ¤¤NotMuster = "¤Not Mustered";
/*  64 */   private static CharSequence ¤¤NoPosition = "¤Unit has no valid position";
/*     */   
/*  66 */   private static CharSequence ¤¤AReloading = "¤Reloading";
/*  67 */   private static CharSequence ¤¤AAiming = "¤Aiming";
/*  68 */   private static CharSequence ¤¤AFiring = "¤Firing";
/*     */   
/*     */   static {
/*  71 */     D.ts(UIDivCardBattle.class);
/*     */   }
/*     */   
/*  74 */   private final GETTER.GETTER_IMP<Div> h1 = new GETTER.GETTER_IMP();
/*  75 */   private final GETTER.GETTER_IMP<Div> h2 = new GETTER.GETTER_IMP();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final GuiSection hov1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final GuiSection hov2;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int width() {
/*  91 */     return this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/*  96 */     return this.height;
/*     */   }
/*     */   
/*  99 */   private static COLOR cMoraleBad = (COLOR)new ColorImp(40, 5, 5);
/* 100 */   private static COLOR cMoraleWorse = (COLOR)new ColorImp(60, 5, 5);
/* 101 */   private static COLOR cMoraleGood = (COLOR)new ColorImp(5, 15, 40);
/*     */   private final MiniMap mini;
/*     */   private final COLOR[] cPower;
/*     */   
/*     */   public void render(Div div, int x1, int y1, int scale, SPRITE_RENDERER r, boolean isActive, boolean isSelected, boolean isHovered) {
/* 106 */     this.body.set(x1, (x1 + width() * scale), y1, (y1 + height() * scale));
/* 107 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/*     */     
/* 109 */     moralebg(r, scale, div, (RECTANGLE)this.body, 4);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     this.m.renderBasics(r, x1, y1, scale, (DIV_SPEC)div.info);
/* 115 */     this.body.set(x1, (x1 + width() * scale), y1, (y1 + height() * scale));
/* 116 */     int cx = this.body.cX();
/*     */     
/* 118 */     double before = div.info.men() + (GAME.ARMIES()).factors.casulties(div);
/* 119 */     double men = div.info.men();
/* 120 */     double n = div.menNrOf();
/*     */     
/* 122 */     if (men == 0.0D) {
/* 123 */       GMeter.renderDelta(r, 0.0D, 0.0D, this.body.x1() + 7 * scale, this.body.x2() - 7 * scale, this.body.y2() - 22 * scale, this.body.y2() - 12 * scale);
/*     */     } else {
/* 125 */       GMeter.renderDelta(r, before / men, n / men, this.body.x1() + 7 * scale, this.body.x2() - 7 * scale, this.body.y2() - 22 * scale, this.body.y2() - 12 * scale);
/*     */     } 
/* 127 */     if (hasAmmo(div)) {
/* 128 */       EquipRange ra = div.settings().ammo();
/* 129 */       double m = 0.0D;
/* 130 */       if (ra != null) {
/* 131 */         m = ra.ammoD(div);
/*     */       }
/* 133 */       GMeter.render(r, GMeter.C_ORANGE, m, this.body.x1() + 7 * scale, this.body.x2() - 7 * scale, this.body.y2() - 12 * scale, this.body.y2() - 4 * scale);
/*     */     } 
/*     */     
/* 136 */     if (div.menPrevious() > div.men()) {
/*     */       
/* 138 */       double d = (div.menPrevious() - div.men());
/* 139 */       d /= div.menPrevious();
/* 140 */       double speed = ((d > 0.05D) ? 4 : 2);
/*     */       
/* 142 */       double op = speed * VIEW.renderSecond() % 1.0D;
/* 143 */       OpacityImp.TMP.set(op);
/* 144 */       OpacityImp.TMP.bind();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 149 */     (UI.FONT()).S.renderC(r, cx, this.body.y2() - 13 * scale, (CharSequence)Str.TMP.clear().add((int)n), scale);
/* 150 */     OPACITY.unbind();
/*     */     
/* 152 */     GCOLOR.UI().border().renderFrame(r, (RECTANGLE)this.body, 0, 1);
/*     */     
/* 154 */     if (!div.settings().mustering() || div.position().deployed() == 0 || !isActive || div.menNrOf() <= 0) {
/* 155 */       OPACITY.O50.bind();
/* 156 */       COLOR.BLACK.render(r, x1, y1, this.width, this.height, -1);
/* 157 */       OPACITY.unbind();
/* 158 */       if (!div.settings().mustering() || div.position().deployed() == 0) {
/* 159 */         if (!div.settings().mustering()) {
/* 160 */           (GCOLOR.UI()).BAD.hovered.bind();
/*     */         } else {
/* 162 */           (GCOLOR.UI()).SOSO.hovered.bind();
/*     */         } 
/* 164 */         (UI.icons()).s.muster.renderCScaled(r, cx, this.body.y1() + 10, scale);
/* 165 */         COLOR.unbind();
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 171 */       (div.order()).dest.get((Copyable)this.forDest);
/* 172 */       DivFormation forCurrent = div.position();
/*     */       
/* 174 */       COORDINATE dd = this.forDest.centrePixel();
/* 175 */       COORDINATE cc = forCurrent.centrePixel();
/*     */       
/* 177 */       if (dd == null || cc == null) {
/*     */         return;
/*     */       }
/* 180 */       if (forCurrent.deployed() > 0 && this.forDest.deployed() > 0 && !dd.isSameAs(cc)) {
/*     */         
/* 182 */         (GCOLOR.T()).H1.bind();
/* 183 */         OPACITY.O25.bind();
/* 184 */         COLOR.WHITE100.render(r, x1 + 4 * scale, y1 + 4 * scale, 16 * scale, 16 * scale, 0);
/* 185 */         OPACITY.unbind();
/* 186 */         if ((div.settings()).running) {
/* 187 */           (UI.icons()).s.divRun.renderScaled(r, x1 + 4 * scale, y1 + 4 * scale, scale);
/*     */         } else {
/* 189 */           (UI.icons()).s.divWalk.renderScaled(r, x1 + 4 * scale, y1 + 4 * scale, scale);
/*     */         } 
/* 191 */         if (div.status().isFighting()) {
/* 192 */           OPACITY.O25.bind();
/* 193 */           COLOR.WHITE100.render(r, x1 + 18 * scale, y1 + 4 * scale, 16 * scale, 16 * scale, 0);
/* 194 */           OPACITY.unbind();
/* 195 */           (GCOLOR.UI()).BAD.hovered.bind();
/* 196 */           (UI.icons()).s.sword.renderScaled(r, x1 + 18 * scale, y1 + 4 * scale, scale);
/*     */         } 
/* 198 */       } else if (div.status().isFighting()) {
/* 199 */         OPACITY.O25.bind();
/* 200 */         COLOR.WHITE100.render(r, x1 + 18 * scale, y1 + 4 * scale, 16 * scale, 16 * scale, 0);
/* 201 */         OPACITY.unbind();
/* 202 */         (GCOLOR.UI()).BAD.hovered.bind();
/* 203 */         (UI.icons()).s.sword.renderScaled(r, x1 + 18 * scale, y1 + 4 * scale, scale);
/* 204 */       } else if (div.settings().shouldFire()) {
/* 205 */         OPACITY.O25.bind();
/* 206 */         COLOR.WHITE100.render(r, x1 + 18 * scale, y1 + 4 * scale, 16 * scale, 16 * scale, 0);
/* 207 */         OPACITY.unbind();
/* 208 */         (GCOLOR.T()).H1.bind();
/* 209 */         (UI.icons()).s.crossheir.renderScaled(r, x1 + 18 * scale, y1 + 4 * scale, scale);
/*     */       } 
/* 211 */       COLOR.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private GuiSection hoveSection(final GETTER<Div> g) {
/* 218 */     final UIDivStats stat = new UIDivStats();
/* 219 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/* 222 */           stat.get((Div)g.get());
/* 223 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 230 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 234 */             GFORMAT.iofk(text, ((Div)g.get()).menNrOf(), ((Div)g.get()).info.men());
/*     */           }
/* 237 */         }).hh((SPRITE)(UI.icons()).s.sword, Dic.¤¤Deployable, 200), 0, s.body().y2() + 2);
/*     */     
/* 239 */     for (StatsBattle.StatTraining tt : (STATS.BATTLE()).TRAINING_ALL) {
/* 240 */       s.add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             
/*     */             public void update(GText text)
/*     */             {
/* 245 */               int target = (int)(100.0D * ((Div)g.get()).info.training(tt));
/* 246 */               int cu = (int)Math.round(100.0D * tt.stat.div().getD(g.get()));
/*     */               
/* 248 */               text.add(cu).add('/').add(target).add('%');
/* 249 */               if (target > 0) {
/* 250 */                 text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).IBAD, (GCOLOR.T()).IGOOD, cu / target));
/*     */               } else {
/* 252 */                 text.color((GCOLOR.T()).INACTIVE);
/*     */               } 
/*     */             }
/*     */             
/*     */             public void hoverInfoGet(GBox b) {
/* 257 */               b.add((INFO)tt.stat.info());
/* 258 */               b.NL();
/* 259 */               tt.stat.boosters.hover((GUI_BOX)b, (BOOSTABLE_O)g.get());
/*     */             }
/* 262 */           }).hh(tt.room.icon.small, (tt.stat.info()).name, 200), 0, s.body().y2() + 2);
/*     */     } 
/*     */ 
/*     */     
/* 266 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 270 */             GFORMAT.percGood(text, 100.0D * ((Div)g.get()).info.experience() / 100.0D);
/*     */           }
/* 272 */         }).hh((SPRITE)(UI.icons()).s.death, Dic.¤¤Experience, 200), 0, s.body().y2() + 8);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 277 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 281 */             GFORMAT.i(text, (GAME.ARMIES()).factors.kills((Div)g.get()));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 287 */             b.textLL(Dic.¤¤Battle);
/* 288 */             b.tab(6);
/* 289 */             b.add((SPRITE)GFORMAT.i(b.text(), (GAME.ARMIES()).factors.kills((Div)g.get())));
/* 290 */             b.NL();
/* 291 */             b.textLL(Dic.¤¤Soldiers);
/* 292 */             b.tab(6);
/* 293 */             b.add((SPRITE)GFORMAT.i(b.text(), (STATS.BATTLE()).ENEMY_KILLS.div().get(g.get())));
/*     */           }
/* 296 */         }).hh(((STATS.BATTLE()).ENEMY_KILLS.info()).icon, ((STATS.BATTLE()).ENEMY_KILLS.info()).name, 200), 0, s.body().y2() + 2);
/*     */ 
/*     */     
/* 299 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 303 */             GFORMAT.perc(text, (STATS.NEEDS()).INJURIES.COUNT.div().getD(g.get()));
/*     */           }
/* 306 */         }).hh(((STATS.NEEDS()).INJURIES.COUNT.info()).icon, ((STATS.NEEDS()).INJURIES.COUNT.info()).name, 200), 0, s.body().y2() + 2);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 311 */     s.add((SPRITE)new GStat() {
/* 312 */           final BattleOrderTask task = new BattleOrderTask();
/*     */           
/*     */           public void update(GText text) {
/* 315 */             DivFormation forCurrent = ((Div)g.get()).position();
/* 316 */             if (!((Div)g.get()).settings().mustering()) {
/* 317 */               text.errorify().add(UIDivCardBattle.¤¤NotMuster);
/* 318 */             } else if (forCurrent.deployed() == 0) {
/* 319 */               text.warnify().add(UIDivCardBattle.¤¤NoPosition);
/*     */             } else {
/* 321 */               (((Div)g.get()).order()).task.get((Copyable)this.task);
/* 322 */               switch (this.task.task()) {
/*     */                 case ATTACK_MELEE:
/* 324 */                   text.add(UIDivCardBattle.¤¤Attacking);
/*     */                   break;
/*     */                 case MOVE:
/* 327 */                   text.add(UIDivCardBattle.¤¤Moving);
/*     */                   break;
/*     */                 case STOP:
/* 330 */                   if (((Div)g.get()).settings().ammo() != null && ((Div)g.get()).settings().fireAtWill() && BattleTrajectories.trajectories((Div)g.get()) > 0) {
/* 331 */                     range((Div)g.get(), text); break;
/*     */                   } 
/* 333 */                   text.add(UIDivCardBattle.¤¤Standing);
/*     */                   break;
/*     */                 case ATTACK_RANGED:
/* 336 */                   range((Div)g.get(), text);
/*     */                   break;
/*     */                 
/*     */                 case null:
/* 340 */                   text.add(UIDivCardBattle.¤¤Building);
/*     */                   break;
/*     */                 case CHARGE:
/* 343 */                   text.add(UIDivCardBattle.¤¤Charging);
/*     */                   break;
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           private void range(Div div, GText text) {
/* 354 */             EquipRange rr = ((Div)g.get()).settings().ammo();
/* 355 */             if (rr != null && BattleTrajectories.trajectories((Div)g.get()) > 0) {
/* 356 */               double di = rr.drawInter((Div)g.get());
/* 357 */               if (di > 0.75D) {
/* 358 */                 text.add(UIDivCardBattle.¤¤AFiring);
/* 359 */               } else if (di > 0.5D) {
/* 360 */                 text.add(UIDivCardBattle.¤¤AAiming);
/*     */               } else {
/* 362 */                 double tt = rr.projectile.reloadSeconds(rr.ref((Div)g.get())) / 2.0D;
/* 363 */                 di *= 2.0D;
/* 364 */                 di = 1.0D - di;
/* 365 */                 text.add(UIDivCardBattle.¤¤AReloading);
/* 366 */                 text.s().add(tt * di, 1).add('s');
/*     */               } 
/*     */             } else {
/*     */               
/* 370 */               text.add(UIDivCardBattle.¤¤AFiring);
/*     */ 
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 376 */         }0, s.body().y2() + 8);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 381 */     s.addRelBody(8, DIR.W, (RENDEROBJ)new RENDEROBJ.RenderImp(this.width * 2, this.height * 2)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 385 */             UIDivCardBattle.this.render((Div)g.get(), this.body.x1(), this.body.y1(), 2, r, true, false, false);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 390 */     GuiSection EE = new GuiSection();
/* 391 */     for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/* 392 */       SPRITE.Imp imp = new SPRITE.Imp(24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 396 */             if (((Div)g.get()).info.equipI(e) == 0) {
/* 397 */               OPACITY.O50.bind();
/*     */             }
/* 399 */             e.resource.icon().render(r, X1, X2, Y1, Y2);
/* 400 */             OPACITY.unbind();
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 405 */       HOVERABLE hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 409 */             if (((Div)g.get()).info.equipI(e) == 0) {
/* 410 */               text.color(COLOR.WHITE50).add('-');
/*     */             } else {
/* 412 */               GFORMAT.f(text, 10.0D * e.stat().div().getD(g.get()) * e.max() / 10.0D, 1);
/* 413 */               text.add('/').add(((Div)g.get()).info.equipI(e));
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 419 */             e.hover((GUI_BOX)b, (Div)g.get());
/*     */           }
/* 422 */         }).hh((SPRITE)imp);
/*     */       
/* 424 */       if (e instanceof EquipRange) {
/* 425 */         final EquipRange er = (EquipRange)e;
/* 426 */         GuiSection ss = new GuiSection();
/* 427 */         ss.add((RENDEROBJ)hOVERABLE);
/* 428 */         ss.add((SPRITE)new SPRITE.Imp(64, 6)
/*     */             {
/*     */               
/*     */               public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */               {
/* 433 */                 if (er.stat().div().get(g.get()) > 0)
/* 434 */                   GMeter.render(r, GMeter.C_ORANGE, er.ammoD((Div)g.get()), X1, X2, Y1, Y2); 
/*     */               }
/* 436 */             }0, 22);
/* 437 */         ss.body().set((RECTANGLE)hOVERABLE.body());
/* 438 */         EE.addGrid((RENDEROBJ)ss, e.indexMilitary(), 5, 48, 0); continue;
/*     */       } 
/* 440 */       EE.addGrid((RENDEROBJ)hOVERABLE, e.indexMilitary(), 5, 48, 0);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 446 */     s.addRelBody(4, DIR.N, (RENDEROBJ)EE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 455 */     s.body().incrW(48.0D);
/*     */ 
/*     */     
/* 458 */     s.addRelBody(8, DIR.S, (RENDEROBJ)stat.get(GAME.ARMIES().division((short)0)));
/*     */ 
/*     */ 
/*     */     
/* 462 */     int w = 450;
/* 463 */     ArrayListGrower<HOVERABLE> all = new ArrayListGrower();
/* 464 */     for (DivFactor f : (GAME.ARMIES()).factors.all()) {
/*     */       
/* 466 */       GTextR r = new GTextR(new GText((UI.FONT()).S, f.message))
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */           {
/* 470 */             double m = f.midValue;
/* 471 */             double d = CLAMP.d(f.getD((Div)g.get()), 0.0D, 1.0D);
/* 472 */             if (d < m) {
/* 473 */               text().color((COLOR)ColorImp.TMP.interpolate((GCOLOR.UI()).BAD.hovered, (GCOLOR.T()).NORMAL, d / m));
/* 474 */             } else if (d > m) {
/* 475 */               d -= m;
/* 476 */               d /= 1.0D - m;
/* 477 */               text().color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).NORMAL, (GCOLOR.UI()).GOOD.hovered, d));
/*     */             } else {
/* 479 */               text().color((GCOLOR.T()).INACTIVE);
/*     */             } 
/* 481 */             super.render(r, ds, isHovered);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 486 */             f.hover((Div)g.get(), text);
/*     */           }
/*     */         };
/* 489 */       all.add(r);
/*     */     } 
/*     */ 
/*     */     
/* 493 */     GuiSection stats = new GuiSection();
/*     */     
/* 495 */     for (HOVERABLE h : all) {
/*     */       
/* 497 */       if (stats.getLastX2() + 16 + h.body().width() > w) {
/* 498 */         stats.add((RENDEROBJ)h, 0, stats.body().y2() + 2); continue;
/*     */       } 
/* 500 */       stats.addRightC(16, (RENDEROBJ)h);
/*     */     } 
/*     */ 
/*     */     
/* 504 */     s.addRelBody(8, DIR.S, (RENDEROBJ)stats);
/*     */ 
/*     */ 
/*     */     
/* 508 */     return s;
/*     */   }
/*     */   
/*     */   private void moralebg(SPRITE_RENDERER r, int scale, Div div, RECTANGLE body, int mm) {
/* 512 */     double morale = (GAME.ARMIES()).factors.valueCurrent(div);
/*     */     
/* 514 */     COLOR.WHITE10.render(r, body, -mm * scale);
/*     */     
/* 516 */     mm++;
/* 517 */     if (morale < 0.5D) {
/* 518 */       ColorImp colorImp = ColorImp.TMP.interpolate(cMoraleBad, COLOR.WHITE10, morale * 2.0D);
/* 519 */       colorImp.render(r, body, -mm * scale);
/* 520 */       double m = div.morale();
/* 521 */       if (m < 1.0D) {
/*     */         
/* 523 */         double speed = ((m < 0.0D) ? 8 : 3);
/*     */         
/* 525 */         double op = 1.0D - speed * VIEW.renderSecond() % 1.0D;
/* 526 */         OpacityImp.TMP.set(op);
/* 527 */         OpacityImp.TMP.bind();
/* 528 */         cMoraleWorse.render(r, body, -mm * scale);
/* 529 */         OPACITY.unbind();
/*     */       } 
/*     */     } else {
/*     */       
/* 533 */       morale = 2.0D * (morale - 0.5D);
/* 534 */       ColorImp colorImp = ColorImp.TMP.interpolate(COLOR.WHITE10, cMoraleGood, morale);
/* 535 */       colorImp.render(r, body, -mm * scale);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX box, Div div) {
/* 540 */     GBox b = (GBox)box;
/*     */     
/* 542 */     b.title((CharSequence)div.info.name());
/* 543 */     this.h1.set(div);
/* 544 */     b.add((RENDEROBJ)this.hov1);
/*     */   }
/*     */   
/*     */   public GuiSection hovBox(Div div) {
/* 548 */     this.h2.set(div);
/* 549 */     return this.hov2;
/*     */   }
/*     */   
/*     */   public boolean hasAmmo(Div div) {
/* 553 */     for (int k = 0; k < STATS.EQUIP().RANGED().size(); k++) {
/* 554 */       EquipRange a = (EquipRange)STATS.EQUIP().RANGED().get(k);
/* 555 */       if (a.stat().div().get(div) > 0) {
/* 556 */         return true;
/*     */       }
/*     */     } 
/* 559 */     return false;
/*     */   }
/*     */   
/*     */   UIDivCardBattle(UIDiv m)
/*     */   {
/* 564 */     this.mini = new MiniMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 573 */     this
/*     */ 
/*     */       
/* 576 */       .cPower = new COLOR[] { (COLOR)(new ColorImp(114, 84, 33)).shade(0.7D), (COLOR)(new ColorImp(114, 114, 114)).shade(0.7D), (COLOR)(new ColorImp(114, 114, 33)).shade(0.7D) }; this.m = m; m.getClass(); this.width = 58; m.getClass(); this.height = 78 + 8; this.forDest = new DivFormationImp(); this.hov1 = hoveSection((GETTER<Div>)this.h1);
/*     */     this.hov2 = hoveSection((GETTER<Div>)this.h2); } public SPRITE miniDiv(Div div, boolean hovered, boolean selected) { this.mini.hovered = hovered;
/*     */     this.mini.selected = selected;
/*     */     this.mini.miniDiv = div;
/*     */     return this.mini; } private class MiniMap implements SPRITE {
/* 581 */     private final DivFormationImp forDest; private MiniMap() { this.forDest = new DivFormationImp();
/* 582 */       this.body = new Rec(); }
/*     */     
/*     */     private final Rec body;
/*     */     private Div miniDiv;
/*     */     private boolean hovered;
/*     */     private boolean selected;
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 590 */       int scale = (X2 - X1) / width();
/*     */       
/* 592 */       this.body.setDim((width() * scale), (height() * scale));
/* 593 */       this.body.moveX1Y1(X1, Y1);
/*     */       
/* 595 */       GButt.ButtPanel.renderBGMini(r, true, this.selected, this.hovered, (RECTANGLE)this.body);
/* 596 */       UIDivCardBattle.this.moralebg(r, scale, this.miniDiv, (RECTANGLE)this.body, 2);
/*     */       
/* 598 */       (GAME.ARMIES()).banners.get(this.miniDiv.info.bannerI()).renderScaled(r, this.body.x1() + scale, this.body.y1() + scale, scale);
/*     */ 
/*     */       
/* 601 */       double men = this.miniDiv.info.men();
/* 602 */       double n = this.miniDiv.menNrOf();
/*     */       
/* 604 */       if (men == 0.0D) {
/* 605 */         GMeter.renderDelta(r, 0.0D, 0.0D, this.body.x1() + 2 * scale, this.body.x2() - 2 * scale, this.body.y2() - 10 * scale, this.body.y2() - 2 * scale);
/*     */       } else {
/* 607 */         GMeter.renderDelta(r, n / men, n / men, this.body.x1() + 2 * scale, this.body.x2() - 2 * scale, this.body.y2() - 10 * scale, this.body.y2() - 2 * scale);
/*     */       } 
/* 609 */       (this.miniDiv.race().appearance()).icon.small.render(r, this.body.x1() + 2, this.body.y2() - 18);
/*     */       
/* 611 */       double pow = this.miniDiv.settings().getPower();
/* 612 */       pow /= this.miniDiv.men();
/* 613 */       UIDivCardBattle.this.cPower[CLAMP.i((int)(pow / 9.0D), 0, UIDivCardBattle.this.cPower.length - 1)].bind();
/* 614 */       int am = (int)(pow / 3.0D);
/* 615 */       am %= 3;
/* 616 */       am++;
/*     */       
/* 618 */       for (int i = 0; i < am; i++) {
/* 619 */         (UI.icons()).s.chevron(DIR.N).render(r, this.body.x2() - 16, this.body.y1() + i * 8);
/*     */       }
/*     */       
/* 622 */       int sx = this.body.x2() - 16 * scale;
/* 623 */       int sy = this.body.y1();
/* 624 */       if (!this.miniDiv.settings().mustering()) {
/* 625 */         (GCOLOR.UI()).BAD.hovered.bind();
/* 626 */         (UI.icons()).s.muster.renderScaled(r, sx, sy, scale);
/* 627 */       } else if (this.miniDiv.position().deployed() == 0) {
/* 628 */         (GCOLOR.UI()).SOSO.hovered.bind();
/* 629 */         (UI.icons()).s.muster.renderScaled(r, sx, sy, scale);
/* 630 */       } else if (this.miniDiv.status().isFighting()) {
/* 631 */         (GCOLOR.UI()).BAD.hovered.bind();
/* 632 */         (UI.icons()).s.sword.renderScaled(r, sx, sy, scale);
/* 633 */       } else if (this.miniDiv.settings().shouldFire()) {
/* 634 */         (GCOLOR.T()).H1.bind();
/* 635 */         (UI.icons()).s.crossheir.renderScaled(r, sx, sy, scale);
/*     */       } else {
/* 637 */         DivFormation forCurrent = this.miniDiv.position();
/* 638 */         (this.miniDiv.order()).dest.get((Copyable)this.forDest);
/*     */         
/* 640 */         COORDINATE dd = this.forDest.centrePixel();
/* 641 */         COORDINATE cc = forCurrent.centrePixel();
/*     */         
/* 643 */         if (dd != null && cc != null && 
/* 644 */           forCurrent.deployed() > 0 && this.forDest.deployed() > 0 && !cc.isSameAs(dd)) {
/*     */           
/* 646 */           (GCOLOR.T()).H1.bind();
/* 647 */           if ((this.miniDiv.settings()).running) {
/* 648 */             (UI.icons()).s.divRun.renderScaled(r, sx, sy, scale);
/*     */           } else {
/* 650 */             (UI.icons()).s.divWalk.renderScaled(r, sx, sy, scale);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 663 */       COLOR.unbind();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int width() {
/* 673 */       return 40;
/*     */     }
/*     */ 
/*     */     
/*     */     public int height() {
/* 678 */       return 40;
/*     */     }
/*     */     
/*     */     public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivCardBattle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */