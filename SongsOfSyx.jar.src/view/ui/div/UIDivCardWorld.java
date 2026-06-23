/*     */ package view.ui.div;
/*     */ 
/*     */ import game.battle.util.DIV_SIMPLE;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.faction.Faction;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResSupply;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.colors.GCOLOR_UI;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.army.AD;
/*     */ import world.army.WDIV;
/*     */ import world.army.WDivRegional;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ public final class UIDivCardWorld
/*     */   implements DIMENSION {
/*  46 */   private static CharSequence ¤¤supHealth = "Supplies Health";
/*  47 */   private static CharSequence ¤¤supHealthD = "Supplies that are needed for general health. Initial supplies for 8 days of use must be available in warehouses, and will be sent to the army automatically.";
/*  48 */   private static CharSequence ¤¤supMorale = "Supplies Morale";
/*  49 */   private static CharSequence ¤¤supMoraleD = "Supplies that boosts morale. Will be sent if available automatically, but are not mandatory.";
/*  50 */   private static CharSequence ¤¤supWarning = "Warning: you currently do not have any operational army supply depots for the needed resources! Once the supplies are gone, the unit might rout and be lost.";
/*  51 */   private static CharSequence ¤¤LowSupplies = "¤Not enough supplies to send out. Fill up your warehouses of essential army supplies.";
/*     */ 
/*     */ 
/*     */   
/*  55 */   private static CharSequence ¤¤NewConscripts = "¤Conscripts are training and will be ready in {0} days.";
/*  56 */   private static CharSequence ¤¤NewConscriptsProblem = "¤There are no conscripts to train for this division.";
/*  57 */   private static CharSequence ¤¤Training = "¤This division is currently training to reach the desired training level. Days left: {0}.";
/*  58 */   private static CharSequence ¤¤NotMustering = "¤This army is currently not mustering, and will not train conscripts.";
/*     */   
/*     */   static {
/*  61 */     D.ts(UIDivCardWorld.class);
/*     */   }
/*     */   
/*  64 */   private final GText tmp = new GText((UI.FONT()).S, 5);
/*     */   
/*  66 */   private final Rec body = new Rec();
/*     */   
/*     */   private final int WIDTH;
/*     */   private final int HEIGHT;
/*     */   private final UIDiv m;
/*  71 */   private GuiSection sec = new GuiSection();
/*  72 */   private final UIDivStats stat = new UIDivStats();
/*     */   private WDIV current;
/*     */   private WDIV sd;
/*     */   
/*  76 */   private final DIV_SPEC stats = new DIV_SPEC()
/*     */     {
/*     */       public double training(StatsBattle.StatTraining tr)
/*     */       {
/*  80 */         return UIDivCardWorld.this.sd.target().training(tr);
/*     */       }
/*     */ 
/*     */       
/*     */       public double equip(EquipBattle e) {
/*  85 */         return UIDivCardWorld.this.sd.target().equip(e);
/*     */       }
/*     */ 
/*     */       
/*     */       public Race race() {
/*  90 */         return UIDivCardWorld.this.sd.race();
/*     */       }
/*     */ 
/*     */       
/*     */       public CharSequence name() {
/*  95 */         return UIDivCardWorld.this.sd.name();
/*     */       }
/*     */ 
/*     */       
/*     */       public int men() {
/* 100 */         return UIDivCardWorld.this.sd.menTarget();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public Faction faction() {
/* 106 */         return null;
/*     */       }
/*     */ 
/*     */       
/*     */       public double experience() {
/* 111 */         return UIDivCardWorld.this.sd.experience();
/*     */       }
/*     */ 
/*     */       
/*     */       public int bannerI() {
/* 116 */         return UIDivCardWorld.this.sd.bannerI();
/*     */       }
/*     */     };
/*     */   
/*     */   UIDivCardWorld(UIDiv m) {
/* 121 */     this.m = m;
/* 122 */     m.getClass(); this.WIDTH = 58;
/* 123 */     m.getClass(); this.HEIGHT = 78 + 14;
/*     */ 
/*     */ 
/*     */     
/* 127 */     GuiSection s = new GuiSection();
/*     */     
/* 129 */     for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/* 130 */       SPRITE.Imp imp = new SPRITE.Imp(24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 134 */             if (UIDivCardWorld.this.current.target().equip(e) == 0.0D) {
/* 135 */               OPACITY.O50.bind();
/*     */             }
/* 137 */             e.resource.icon().render(r, X1, X2, Y1, Y2);
/* 138 */             OPACITY.unbind();
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 143 */       HOVERABLE hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 147 */             if (UIDivCardWorld.this.current.target().equip(e) == 0.0D) {
/* 148 */               text.color(COLOR.WHITE50).add('-');
/*     */             } else {
/* 150 */               double ee = (e.max() * 10) * UIDivCardWorld.this.current.equip(e) / 10.0D;
/* 151 */               int tar = UIDivCardWorld.this.current.target().equipI(e);
/* 152 */               if (ee == tar) {
/* 153 */                 GFORMAT.i(text, tar);
/*     */               } else {
/* 155 */                 GFORMAT.f(text, (e.max() * 10) * UIDivCardWorld.this.current.equip(e) / 10.0D, 1);
/* 156 */                 text.add('/').add(UIDivCardWorld.this.current.target().equipI(e));
/*     */               }
/*     */             
/*     */             } 
/*     */           }
/* 161 */         }).hh((SPRITE)imp);
/* 162 */       s.addGrid((RENDEROBJ)hOVERABLE, e.indexMilitary(), 4, 48, 0);
/*     */     } 
/*     */ 
/*     */     
/* 166 */     (GCOLOR.T()).H1.bind();
/* 167 */     s.add((SPRITE)(UI.icons()).s.death, 0, s.body().y2() + 2);
/*     */     
/* 169 */     s.addRightC(4, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 173 */             GFORMAT.percGood(text, 100.0D * UIDivCardWorld.this.current.experience() / 100.0D);
/*     */           }
/* 175 */         }).hh(Dic.¤¤Experience, 220));
/*     */     
/* 177 */     for (StatsBattle.StatTraining tt : (STATS.BATTLE()).TRAINING_ALL) {
/* 178 */       s.add(tt.room.icon.small, 0, s.body().y2() + 2);
/* 179 */       s.addRightC(4, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             
/*     */             public void update(GText text)
/*     */             {
/* 184 */               int target = (int)Math.round(100.0D * UIDivCardWorld.this.current.target().training(tt));
/* 185 */               int cu = (int)Math.round(100.0D * UIDivCardWorld.this.current.training(tt));
/*     */               
/* 187 */               text.add(cu).add('/').add(target).add('%');
/* 188 */               if (target > 0) {
/* 189 */                 text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).IBAD, (GCOLOR.T()).IGOOD, cu / target));
/*     */               } else {
/* 191 */                 text.color((GCOLOR.T()).INACTIVE);
/*     */               }  }
/* 193 */           }).hh((tt.stat.info()).name, 200));
/*     */     } 
/*     */ 
/*     */     
/* 197 */     s.add((SPRITE)(UI.icons()).s.sword, 0, s.body().y2() + 8);
/* 198 */     s.addRightC(4, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 202 */             GFORMAT.iofk(text, UIDivCardWorld.this.current.men(), UIDivCardWorld.this.current.menTarget());
/*     */           }
/* 205 */         }).hh(Dic.¤¤Deployable, 200));
/*     */ 
/*     */     
/* 208 */     this.sec.add((RENDEROBJ)s);
/*     */     
/* 210 */     this.sec.addRelBody(8, DIR.W, (RENDEROBJ)new RENDEROBJ.RenderImp(this.WIDTH * 2, this.HEIGHT * 2)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 214 */             UIDivCardWorld.this.render(r, this.body.x1(), this.body.y1(), 2, UIDivCardWorld.this.current, true, false, false);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int width() {
/* 222 */     return this.WIDTH;
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/* 227 */     return this.HEIGHT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int x1, int y1, int scale, WDIV d, boolean isActive, boolean isSelected, boolean isHovered) {
/* 233 */     this.body.set(x1, (x1 + width() * scale), y1, (y1 + height() * scale));
/*     */     
/* 235 */     GCOLOR_UI.color(d.color(), isActive, isSelected, isHovered).render(r, (RECTANGLE)this.body, -1);
/* 236 */     GCOLOR.UI().bg(isActive, isSelected, isHovered).render(r, (RECTANGLE)this.body, -3);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 241 */     this.sd = d;
/* 242 */     this.m.renderBasics(r, x1, y1, scale, this.stats);
/*     */     
/* 244 */     WArmy a = d.army();
/* 245 */     if (d.needConscripts() && 
/* 246 */       d.army() != null && d.army().recruiting() && d.men() < d.menTarget() && 
/* 247 */       d.men() < d.menTarget()) {
/* 248 */       (SPRITES.icons()).s.time.renderC(r, this.body.x2() - 6, this.body.y1() + 8);
/* 249 */       this.tmp.clear();
/* 250 */       if ((a != null && !a.recruiting()) || d.menTarget() == 0) {
/* 251 */         this.tmp.errorify().add('-');
/*     */       } else {
/* 253 */         this.tmp.normalify().add(d.daysUntilMenArrives());
/* 254 */       }  this.tmp.adjustWidth();
/* 255 */       this.tmp.render(r, this.body.x2() - 2 - this.tmp.width(), this.body.y1() + 16);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 261 */     int cx = this.body.cX();
/*     */     
/* 263 */     double men = d.menTarget();
/* 264 */     double n = d.men();
/*     */     
/* 266 */     double nn = ((d.army() != null && d.army().recruiting() && d.daysUntilMenArrives() >= 0) ? d.menTarget() : d.men());
/* 267 */     if (men == 0.0D) {
/* 268 */       GMeter.renderDelta(r, 0.0D, 0.0D, (RECTANGLE)this.body);
/*     */     } else {
/* 270 */       GMeter.renderDelta(r, n / men, nn / men, this.body.x1() + 4 * scale, this.body.x2() - 4 * scale, this.body.y2() - 22 * scale, this.body.y2() - 6 * scale);
/*     */     } 
/*     */     
/* 273 */     (UI.FONT()).S.renderC(r, cx, this.body.y2() - 14 * scale, (CharSequence)Str.TMP.clear().add(d.men()), scale);
/*     */ 
/*     */     
/* 276 */     GCOLOR.UI().border().renderFrame(r, (RECTANGLE)this.body, 0, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(WDIV d, GUI_BOX box) {
/* 285 */     GBox b = (GBox)box;
/* 286 */     b.title(d.name());
/*     */     
/* 288 */     this.current = d;
/* 289 */     b.add((RENDEROBJ)this.sec);
/* 290 */     b.NL();
/*     */     
/* 292 */     b.add((RENDEROBJ)this.stat.get((DIV_SPEC)d));
/*     */     
/* 294 */     b.NL(8);
/* 295 */     b.sep();
/*     */     
/* 297 */     if (d.costPerMan() > 0) {
/* 298 */       b.textL(Dic.¤¤InitialCost);
/* 299 */       b.tab(3);
/* 300 */       b.add((SPRITE)GFORMAT.i(b.text(), (4 * d.costPerMan() * d.menTarget())));
/* 301 */       b.NL();
/*     */       
/* 303 */       b.textL(Dic.¤¤Upkeep);
/* 304 */       b.tab(3);
/* 305 */       b.add((SPRITE)GFORMAT.i(b.text(), (d.costPerMan() * d.menTarget())));
/* 306 */       b.NL();
/*     */     } 
/*     */     
/* 309 */     if (d.needConscripts()) {
/* 310 */       if (d.army().recruiting()) {
/* 311 */         if (d.men() < d.menTarget()) {
/* 312 */           if (!AD.conscripts().canTrain(d.race(), d.faction())) {
/* 313 */             b.error(¤¤NewConscriptsProblem);
/*     */           } else {
/* 315 */             GText te = b.text();
/* 316 */             te.add(¤¤NewConscripts);
/* 317 */             te.insert(0, d.daysUntilMenArrives());
/* 318 */             te.normalify2();
/* 319 */             b.add((SPRITE)te);
/*     */           } 
/*     */         } else {
/* 322 */           int tt = trainingTime(d);
/* 323 */           if (tt > 0) {
/* 324 */             GText te = b.text();
/* 325 */             te.add(¤¤Training);
/* 326 */             te.insert(0, tt);
/* 327 */             te.normalify2();
/* 328 */             b.add((SPRITE)te);
/*     */           }
/*     */         
/*     */         }
/*     */       
/* 333 */       } else if (d.men() < d.menTarget() || trainingTime(d) > 0) {
/* 334 */         b.error(¤¤NotMustering);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static int trainingTime(WDIV div) {
/* 340 */     int m = 0;
/* 341 */     for (StatsBattle.StatTraining tr : (STATS.BATTLE()).TRAINING_ALL) {
/* 342 */       m += WDivRegional.trainingDays(tr, div.target().training(tr) - div.training(tr), div.faction());
/*     */     }
/* 344 */     return m;
/*     */   }
/*     */ 
/*     */   
/*     */   public static CharSequence supplyError(DIV_SIMPLE div) {
/* 349 */     for (ResSupply s : (RESOURCES.SUP()).ALL) {
/* 350 */       if (s.health > 0.0D && s.amount(div.race(), div.men()) > ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(s.resource))
/* 351 */         return ¤¤LowSupplies; 
/*     */     } 
/* 353 */     return null;
/*     */   }
/*     */   
/*     */   public static void hoverSendOut(LIST<? extends DIV_SIMPLE> divs, GUI_BOX box) {
/* 357 */     GBox b = (GBox)box;
/*     */ 
/*     */     
/* 360 */     boolean sup = true;
/*     */     
/* 362 */     b.textLL(¤¤supHealth);
/* 363 */     b.NL();
/* 364 */     b.text(¤¤supHealthD);
/* 365 */     b.NL();
/* 366 */     for (ResSupply s : (RESOURCES.SUP()).ALL) {
/* 367 */       if (s.health <= 0.0D)
/*     */         continue; 
/* 369 */       int need = 0;
/* 370 */       for (DIV_SIMPLE div : divs) {
/* 371 */         need += s.amount(div.race(), div.men());
/*     */       }
/*     */       
/* 374 */       int available = ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(s.resource);
/*     */       
/* 376 */       b.add((SPRITE)s.resource.icon());
/* 377 */       GText t = b.text();
/* 378 */       GFORMAT.i(t, -need);
/* 379 */       if (need <= available) {
/* 380 */         t.normalify2();
/*     */       } else {
/* 382 */         t.errorify();
/* 383 */       }  b.add((SPRITE)t);
/*     */ 
/*     */       
/* 386 */       b.tab(3);
/* 387 */       b.add((SETT.ROOMS()).STOCKPILE.icon.small);
/* 388 */       b.add((SPRITE)GFORMAT.i(b.text(), available));
/*     */       
/* 390 */       b.tab(6);
/*     */       
/* 392 */       if ((SETT.ROOMS()).SUPPLY.has(s.resource)) {
/* 393 */         b.add((SETT.ROOMS()).SUPPLY.icon.small);
/*     */       } else {
/* 395 */         b.add((SPRITE)(UI.icons()).s.cancel, (GCOLOR.UI()).BAD.hovered);
/*     */       } 
/* 397 */       b.NL();
/* 398 */       if (need > 0 && !(SETT.ROOMS()).SUPPLY.has(s.resource)) {
/* 399 */         sup = false;
/*     */       }
/*     */     } 
/*     */     
/* 403 */     b.textLL(¤¤supMorale);
/* 404 */     b.NL();
/* 405 */     b.text(¤¤supMoraleD);
/* 406 */     b.NL();
/* 407 */     for (ResSupply s : (RESOURCES.SUP()).ALL) {
/* 408 */       if (s.morale <= 0.0D)
/*     */         continue; 
/* 410 */       int need = 0;
/* 411 */       for (DIV_SIMPLE div : divs) {
/* 412 */         need += s.amount(div.race(), div.men());
/*     */       }
/*     */       
/* 415 */       int available = ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(s.resource);
/*     */       
/* 417 */       b.add((SPRITE)s.resource.icon());
/* 418 */       GText t = b.text();
/* 419 */       GFORMAT.i(t, -need);
/* 420 */       if (need <= available) {
/* 421 */         t.normalify2();
/*     */       } else {
/* 423 */         t.warnify();
/* 424 */       }  b.add((SPRITE)t);
/*     */       
/* 426 */       b.tab(3);
/* 427 */       b.add((SETT.ROOMS()).STOCKPILE.icon.small);
/* 428 */       b.add((SPRITE)GFORMAT.i(b.text(), available));
/*     */       
/* 430 */       b.tab(6);
/*     */       
/* 432 */       if ((SETT.ROOMS()).SUPPLY.has(s.resource)) {
/* 433 */         b.add((SETT.ROOMS()).SUPPLY.icon.small);
/*     */       } else {
/* 435 */         b.add((SPRITE)(UI.icons()).s.cancel, (GCOLOR.UI()).BAD.hovered);
/*     */       } 
/* 437 */       b.NL();
/* 438 */       if (need > 0 && !(SETT.ROOMS()).SUPPLY.has(s.resource)) {
/* 439 */         sup = false;
/*     */       }
/*     */     } 
/*     */     
/* 443 */     if (!sup) {
/* 444 */       b.add((SPRITE)(SETT.ROOMS()).SUPPLY.icon);
/* 445 */       b.warn(¤¤supWarning);
/* 446 */       b.NL();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivCardWorld.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */