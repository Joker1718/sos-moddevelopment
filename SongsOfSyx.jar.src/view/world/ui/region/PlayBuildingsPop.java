/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BHoverer;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import init.constant.C;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.Icons;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.LinkedList;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.building.RDBuildPoints;
/*     */ import world.region.building.RDBuilding;
/*     */ import world.region.building.RDBuildingCat;
/*     */ import world.region.building.RDBuildingLevel;
/*     */ 
/*     */ class PlayBuildingsPop {
/*  53 */   private final COLOR[] buCols = (COLOR[])COLOR.interpolate((COLOR)new ColorImp(100, 100, 100), (COLOR)new ColorImp(127, 110, 10), 16);
/*  54 */   private final GText num = new GText((UI.FONT()).S, 8);
/*  55 */   public static int width = 80;
/*     */   public static final int height = 88;
/*     */   private final GETTER.GETTER_IMP<Region> g;
/*     */   private Region current;
/*  59 */   private Levs levs = new Levs();
/*     */   
/*  61 */   private static CharSequence ¤¤RemoveAll = "Remove all constructed buildings?";
/*  62 */   private static CharSequence ¤¤Constructed = "This building has been constructed.";
/*  63 */   private static CharSequence ¤¤ConstructedUp = "This building can be upgrades.";
/*  64 */   private static CharSequence ¤¤Available = "This building can be constructed.";
/*     */   
/*     */   static {
/*  67 */     D.ts(PlayBuildingsPop.class);
/*     */   }
/*     */   
/*  70 */   private final GuiSection s = new GuiSection()
/*     */     {
/*     */       public void render(SPRITE_RENDERER r, float ds)
/*     */       {
/*  74 */         if (PlayBuildingsPop.this.g.get() != PlayBuildingsPop.this.current || VIEW.current() != VIEW.world())
/*  75 */           (VIEW.inters()).section.close(); 
/*  76 */         GAME.SPEED.tmpPause();
/*  77 */         RD.BUILDINGS().tmp(false, (Region)PlayBuildingsPop.this.g.get());
/*  78 */         super.render(r, ds);
/*     */       }
/*     */ 
/*     */       
/*     */       public void hoverInfoGet(GUI_BOX text) {
/*  83 */         RD.BUILDINGS().tmp(false, (Region)PlayBuildingsPop.this.g.get());
/*  84 */         super.hoverInfoGet(text);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   public PlayBuildingsPop(PlayBuildings buildings, GETTER.GETTER_IMP<Region> g) {
/*  91 */     this.g = g;
/*     */     
/*  93 */     this.s.add((RENDEROBJ)new Info());
/*     */ 
/*     */     
/*  96 */     LinkedList<RENDEROBJ> rows = new LinkedList<>();
/*  97 */     int wam = 6;
/*  98 */     int hi = 0;
/*     */     
/* 100 */     for (RDBuildingCat cat : (RD.BUILDINGS()).cats) {
/* 101 */       int i = 0;
/* 102 */       GuiSection row = new GuiSection();
/* 103 */       rows.add(row);
/* 104 */       for (RDBuilding b : cat.all()) {
/* 105 */         if (i >= wam) {
/* 106 */           row = new GuiSection();
/* 107 */           rows.add(row);
/* 108 */           i = 0;
/*     */         } 
/* 110 */         Butt bb = new Butt(b);
/* 111 */         hi = bb.body.height() + 12;
/* 112 */         row.addRightC(0, (RENDEROBJ)bb);
/* 113 */         i++;
/*     */       } 
/* 115 */       rows.add(new RENDEROBJ.RenderDummy(1, 12));
/*     */     } 
/*     */     
/* 118 */     int hh = C.HEIGHT() - 200 - this.s.body().height();
/* 119 */     hh = (int)Math.ceil(hh / hi);
/* 120 */     hh *= hi;
/*     */     
/* 122 */     GScrollRows sc = new GScrollRows(rows, hh);
/* 123 */     this.s.addRelBody(8, DIR.N, (RENDEROBJ)sc.view());
/*     */     
/* 125 */     GPanel p = new GPanel();
/* 126 */     p.setBig();
/* 127 */     p.inner().set((BODY_HOLDER)this.s);
/* 128 */     p.setCloseAction(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 132 */             (VIEW.inters()).section.close();
/*     */           }
/*     */         });
/*     */     
/* 136 */     this.s.add((RENDEROBJ)p);
/* 137 */     this.s.moveLastToBack();
/* 138 */     this.s.body().centerIn(C.DIM());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void pop(RECTANGLE body) {
/* 144 */     if ((VIEW.inters()).section.current() == this.s)
/*     */       return; 
/* 146 */     this.current = (Region)this.g.get();
/* 147 */     RD.BUILDINGS().tmp(true, (Region)this.g.get());
/* 148 */     if (body.x1() <= this.s.body().width()) {
/* 149 */       this.s.body().moveX1(body.x2());
/*     */     } else {
/*     */       
/* 152 */       this.s.body().moveX2(body.x1());
/* 153 */       if (this.s.body().x2() > C.DIM().width())
/* 154 */         this.s.body().moveX2(C.DIM().width()); 
/*     */     } 
/* 156 */     (VIEW.inters()).section.activate(this.s);
/*     */   }
/*     */   
/*     */   private class LevelButt
/*     */     extends CLICKABLE.ClickableAbs {
/*     */     private final RDBuilding bu;
/*     */     private final int level;
/*     */     
/*     */     LevelButt(RDBuilding b, int level) {
/* 165 */       this.body.setDim(128.0D, 40.0D);
/* 166 */       this.bu = b;
/* 167 */       this.level = level;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 172 */       GCOLOR.UI().border().render(r, (RECTANGLE)this.body, -1);
/*     */       
/* 174 */       if (RD.BUILDINGS().tmp().level(this.bu, (Region)PlayBuildingsPop.this.g.get()) == this.level) {
/* 175 */         COLOR.WHITE100.render(r, (RECTANGLE)this.body, -2);
/* 176 */         GCOLOR.UI().bg(isActive, isSelected, isHovered).render(r, (RECTANGLE)this.body, -4);
/*     */       } else {
/* 178 */         GCOLOR.UI().bg(isActive, isSelected, isHovered).render(r, (RECTANGLE)this.body, -2);
/*     */       } 
/*     */       
/* 181 */       ((RDBuildingLevel)this.bu.levels().get(this.level)).icon.big.renderCY(r, body().x1() + 8, body().cY());
/* 182 */       PlayBuildingsPop.this.num.clear();
/* 183 */       PlayBuildingsPop.this.num.color(COLOR.WHITE100);
/* 184 */       GFORMAT.toNumeral(PlayBuildingsPop.this.num, this.level);
/* 185 */       PlayBuildingsPop.this.num.renderCY(r, body().x1() + 48, this.body.cY());
/*     */       
/* 187 */       if (this.level > RD.BUILDINGS().tmp().level(this.bu, (Region)PlayBuildingsPop.this.g.get()) && 
/* 188 */         RD.BUILDINGS().tmp().canAfford(this.bu, (Region)PlayBuildingsPop.this.g.get(), this.level) != null) {
/* 189 */         OPACITY.O50.bind();
/* 190 */         COLOR.BLACK.render(r, (RECTANGLE)this.body, -1);
/* 191 */         OPACITY.unbind();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 200 */       Region reg = (Region)PlayBuildingsPop.this.g.get();
/* 201 */       GBox b = (GBox)text;
/* 202 */       b.title(((RDBuildingLevel)this.bu.levels().get(this.level)).name);
/* 203 */       if (this.level == 0) {
/*     */         return;
/*     */       }
/* 206 */       CharSequence prob = this.bu.canAfford(reg, RD.BUILDINGS().tmp().level(this.bu, (Region)PlayBuildingsPop.this.g.get()), this.level);
/* 207 */       if (prob != null)
/* 208 */         b.error(prob); 
/* 209 */       b.NL();
/*     */       
/* 211 */       b.text(this.bu.info.desc);
/*     */       
/* 213 */       b.sep();
/* 214 */       for (int i = this.level; i > 0; i--) {
/* 215 */         if (((RDBuildingLevel)this.bu.levels().get(i)).reqs.hover(text, reg)) {
/* 216 */           b.sep();
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       
/* 222 */       PlayBuildingsPop.hoverCosts(reg, this.bu, RD.BUILDINGS().tmp().level(this.bu, (Region)PlayBuildingsPop.this.g.get()), this.level, text);
/* 223 */       PlayBuildingsPop.this.hoverNonCosts(reg, this.bu, RD.BUILDINGS().tmp().level(this.bu, (Region)PlayBuildingsPop.this.g.get()), this.level, text);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 231 */       if ((S.get()).developer || RD.BUILDINGS().tmp().canAfford(this.bu, (Region)PlayBuildingsPop.this.g.get(), this.level) == null) {
/*     */         
/* 233 */         RD.BUILDINGS().tmp().levelSet(this.bu, this.level);
/*     */ 
/*     */ 
/*     */         
/* 237 */         (VIEW.inters()).popup.close();
/*     */       } 
/*     */     }
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
/*     */   private void renderEfficiency(RDBuilding bu, RECTANGLE body, SPRITE_RENDERER r) {
/* 255 */     double d = bu.baseEfficiency((Region)this.g.get()) - 1.0D;
/* 256 */     d *= 2.0D;
/* 257 */     int am = 0;
/* 258 */     if (d < 0.0D) {
/* 259 */       am = (int)(-d * 7.0D);
/*     */     } else {
/* 261 */       am = (int)(d * 7.0D);
/*     */     } 
/* 263 */     am = CLAMP.i(am, -7, 7);
/*     */     
/* 265 */     if (am != 0) {
/* 266 */       am = Math.abs(am);
/* 267 */       Icons.S.IconS iconS = (UI.icons()).s.chevron(DIR.N);
/* 268 */       if (d < 0.0D) {
/* 269 */         COLOR.RED100.bind();
/* 270 */         iconS = (UI.icons()).s.chevron(DIR.S);
/*     */       } else {
/* 272 */         COLOR.GREEN100.bind();
/*     */       } 
/* 274 */       for (int i = 0; i < am; i++) {
/* 275 */         iconS.render(r, body.x2() - 18, body.y1() + i * 8);
/*     */       }
/*     */     } 
/*     */     
/* 279 */     COLOR.unbind();
/*     */   }
/*     */   
/* 282 */   private static ArrayListResize<BoostSpec> tmp = new ArrayListResize(16);
/*     */   
/*     */   private void hoverNonCosts(Region reg, RDBuilding bu, int fromL, int toL, GUI_BOX text) {
/* 285 */     GBox b = (GBox)text;
/*     */     
/* 287 */     b.add((SPRITE)b.text().lablify().add(Dic.¤¤Effects));
/* 288 */     b.NL();
/*     */     
/* 290 */     tmp.clearSoft();
/* 291 */     for (BoostSpec s : ((RDBuildingLevel)bu.levels.get(fromL)).local.all()) {
/* 292 */       if ((RD.BUILDINGS()).costs.get(s.boostable, s.booster) != null) {
/*     */         continue;
/*     */       }
/* 295 */       tmp.add(s);
/*     */     } 
/*     */     
/* 298 */     for (BoostSpec s : ((RDBuildingLevel)bu.levels.get(toL)).local.all()) {
/* 299 */       if ((RD.BUILDINGS()).costs.get(s.boostable, s.booster) != null) {
/*     */         continue;
/*     */       }
/* 302 */       boolean has = false;
/* 303 */       for (BoostSpec s2 : tmp) {
/* 304 */         if (s.isSameAs(s2) && Str.isSame(s.tName, s2.tName)) {
/* 305 */           has = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 310 */       if (!has) {
/* 311 */         tmp.add(s);
/*     */       }
/*     */     } 
/*     */     
/* 315 */     for (BoostSpec s : tmp) {
/* 316 */       if ((RD.BUILDINGS()).costs.get(s.boostable, s.booster) != null) {
/*     */         continue;
/*     */       }
/* 319 */       bu.boosters().hover(b, s, getB(bu, fromL, toL, s, true), 0);
/* 320 */       b.NL();
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void hoverCosts(Region reg, RDBuilding bu, int fromL, int toL, GUI_BOX text) {
/* 325 */     GBox b = (GBox)text;
/*     */     
/* 327 */     b.NL(8);
/* 328 */     b.textLL(Dic.¤¤Cost);
/* 329 */     b.NL();
/*     */     
/* 331 */     int cr = credits(bu, fromL, toL);
/* 332 */     if (cr > 0) {
/* 333 */       hoverCost(text, (SPRITE)(UI.icons()).s.money, Dic.¤¤Curr, -cr, (int)FACTIONS.player().credits().getD());
/* 334 */       b.NL();
/*     */     } 
/*     */     
/* 337 */     for (BoostSpec s : bu.boosters().all()) {
/* 338 */       if ((RD.BUILDINGS()).costs.get(s.boostable, s.booster) != null) {
/*     */         
/* 340 */         double value = getB(bu, fromL, toL, s, true);
/*     */         
/* 342 */         hoverCost(text, (SPRITE)s.boostable.icon, s.boostable.name, value, s.boostable.get((BOOSTABLE_O)reg));
/* 343 */         b.NL();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static double getB(RDBuilding bu, int fromL, int toL, BoostSpec spec, boolean local) {
/* 349 */     double am = 0.0D;
/* 350 */     RDBuildingLevel l = (RDBuildingLevel)bu.levels.get(toL);
/* 351 */     boolean mm = spec.booster.isMul;
/* 352 */     for (BoostSpec boo : l.local.all()) {
/* 353 */       if (spec.isSameAs(boo) && Str.isSame(spec.tName, boo.tName)) {
/* 354 */         am += boo.booster.to();
/* 355 */         if (mm)
/* 356 */           am--; 
/*     */       } 
/*     */     } 
/* 359 */     l = (RDBuildingLevel)bu.levels.get(fromL);
/* 360 */     for (BoostSpec boo : l.local.all()) {
/*     */       
/* 362 */       if (spec.isSameAs(boo) && Str.isSame(spec.tName, boo.tName)) {
/* 363 */         am -= boo.booster.to();
/* 364 */         if (mm)
/* 365 */           am++; 
/*     */       } 
/*     */     } 
/* 368 */     if (mm)
/* 369 */       am++; 
/* 370 */     return am;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void hoverCost(GUI_BOX text, SPRITE icon, CharSequence name, double value, double current) {
/* 375 */     if (value == 0.0D)
/*     */       return; 
/* 377 */     GBox b = (GBox)text;
/*     */     
/* 379 */     b.add(icon);
/* 380 */     GText nn = b.text();
/* 381 */     GText vv = b.text();
/* 382 */     nn.normalify2();
/* 383 */     vv.normalify2();
/* 384 */     nn.add(name);
/* 385 */     GFORMAT.iOrF(vv, value);
/* 386 */     if (value > 0.0D) {
/* 387 */       nn.normalify();
/* 388 */       vv.normalify();
/* 389 */     } else if (current < -value) {
/* 390 */       nn.errorify();
/* 391 */       vv.errorify();
/*     */     } else {
/* 393 */       nn.normalify2();
/* 394 */       vv.normalify2();
/*     */     } 
/*     */     
/* 397 */     b.add((SPRITE)nn);
/* 398 */     b.tab(7);
/* 399 */     b.add((SPRITE)vv);
/* 400 */     b.tab(9);
/* 401 */     GText cc = b.text();
/* 402 */     cc.add('(');
/* 403 */     GFORMAT.iOrF(cc, current).add(')');
/* 404 */     b.add((SPRITE)cc);
/* 405 */     b.NL();
/*     */   }
/*     */   
/*     */   private static class Levs extends RENDEROBJ.RenderImp {
/*     */     RDBuilding bu;
/*     */     int current;
/* 411 */     private final GText num = new GText((UI.FONT()).S, 8);
/*     */     
/*     */     Levs() {
/* 414 */       super(36);
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 419 */       for (int i = 1; i < this.bu.levels.size(); i++) {
/* 420 */         int x1 = this.body.x1() + (i - 1) * 36;
/* 421 */         ((RDBuildingLevel)this.bu.levels.get(i)).icon.big.render(r, x1, this.body.y1());
/*     */         
/* 423 */         this.num.clear();
/* 424 */         GFORMAT.toNumeral(this.num, i);
/* 425 */         this.num.adjustWidth();
/*     */         
/* 427 */         OPACITY.O75.bind();
/* 428 */         this.num.color(COLOR.BLACK);
/* 429 */         this.num.render(r, x1 + 1, this.body.y1() + 1);
/* 430 */         this.num.color((GCOLOR.T()).H1);
/* 431 */         OPACITY.unbind();
/* 432 */         this.num.render(r, x1, this.body.y1());
/*     */ 
/*     */         
/* 435 */         if (this.current != i) {
/* 436 */           OPACITY.O50.bind();
/* 437 */           COLOR.BLACK.render(r, x1, x1 + 32, this.body.y1(), this.body.y1() + 32);
/* 438 */           OPACITY.unbind();
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     RENDEROBJ get(RDBuilding bu, int level) {
/* 445 */       this.bu = bu;
/* 446 */       this.current = level;
/* 447 */       this.body.setWidth((bu.levels.size() * 32));
/* 448 */       return (RENDEROBJ)this;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int credits(RDBuilding bu, int fromL, int toL) {
/* 456 */     int cost = ((RDBuildingLevel)bu.levels.get(toL)).cost - ((RDBuildingLevel)bu.levels.get(fromL)).cost;
/* 457 */     return cost;
/*     */   }
/*     */ 
/*     */   
/*     */   public class Butt
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/* 464 */     private final GuiSection lPop = new GuiSection()
/*     */       {
/*     */         public final void render(SPRITE_RENDERER r, float ds) {
/* 467 */           if ((VIEW.inters()).section.current() != (PlayBuildingsPop.Butt.access$0(PlayBuildingsPop.Butt.this)).s)
/* 468 */             (VIEW.inters()).popup2.close(); 
/* 469 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*     */     Butt(RDBuilding b) {
/* 475 */       this.body.setDim(PlayBuildingsPop.width, 88.0D);
/* 476 */       this.bu = b;
/* 477 */       for (int i = b.levels().size() - 1; i >= 0; i--) {
/* 478 */         this.lPop.addDown(0, (RENDEROBJ)new PlayBuildingsPop.LevelButt(b, i));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     protected final RDBuilding bu;
/*     */     
/*     */     protected void clickA() {
/* 486 */       if (RD.BUILDINGS().tmp().level(this.bu, (Region)PlayBuildingsPop.this.g.get()) == 0) {
/* 487 */         if ((S.get()).developer || RD.BUILDINGS().tmp().canAfford(this.bu, (Region)PlayBuildingsPop.this.g.get(), 1) == null) {
/* 488 */           RD.BUILDINGS().tmp().levelSet(this.bu, 1);
/*     */         }
/*     */       } else {
/* 491 */         (VIEW.inters()).popup2.show((RENDEROBJ)this.lPop, (CLICKABLE)this);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 499 */       isSelected = (RD.BUILDINGS().tmp().level(this.bu, (Region)PlayBuildingsPop.this.g.get()) > 0);
/* 500 */       PlayBuildingsPop.this.render(this.bu, (Region)PlayBuildingsPop.this.g.get(), (RECTANGLE)this.body, r, isActive, isSelected, isHovered);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 506 */       PlayBuildingsPop.this.hover(this.bu, (Region)PlayBuildingsPop.this.g.get(), text);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(RDBuilding bu, Region reg, RECTANGLE body, SPRITE_RENDERER r, boolean isActive, boolean isSelected, boolean isHovered) {
/* 513 */     ColorImp cc = ColorImp.TMP;
/* 514 */     cc.set(bu.cat.color);
/* 515 */     cc.render(r, body);
/* 516 */     cc.shadeSelf(0.5D);
/* 517 */     cc.renderFrame(r, body, 0, 1);
/* 518 */     cc.renderFrame(r, body, -3, 1);
/*     */     
/* 520 */     int tl = RD.BUILDINGS().tmp().level(bu, (Region)this.g.get());
/*     */     
/* 522 */     Rec.TEMP.setDim((body.width() - 4), (body.height() - 4));
/* 523 */     Rec.TEMP.moveC(body.cX(), body.cY());
/* 524 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)Rec.TEMP);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 529 */     ((RDBuildingLevel)bu.levels().get(Math.max(tl, 1))).icon.huge.renderC(r, body.cX(), body.cY() + 2);
/* 530 */     renderEfficiency(bu, body, r);
/*     */ 
/*     */ 
/*     */     
/* 534 */     if (tl > 0) {
/*     */       
/* 536 */       this.num.clear();
/* 537 */       GFORMAT.toNumeral(this.num, tl);
/* 538 */       this.num.adjustWidth();
/*     */       
/* 540 */       OPACITY.O75.bind();
/* 541 */       this.num.color(COLOR.BLACK);
/* 542 */       this.num.renderC(r, body.cX() + 1, body.y1() + 14 + 1);
/* 543 */       COLOR col = this.buCols[(int)((this.buCols.length - 1) * RD.BUILDINGS().tmp().level(bu, (Region)this.g.get()) / (bu.levels().size() - 1))];
/* 544 */       this.num.color(col);
/* 545 */       OPACITY.unbind();
/* 546 */       this.num.renderC(r, body.cX(), body.y1() + 14);
/*     */       
/* 548 */       if (tl < bu.level.max(reg) && RD.BUILDINGS().tmp().canAfford(bu, (Region)this.g.get(), tl + 1) == null) {
/* 549 */         COLOR.YELLOW100.bind();
/* 550 */         (UI.icons()).s.chevron(DIR.N).renderC(r, body.cX() - 8, body.y1() + 4);
/* 551 */         (UI.icons()).s.chevron(DIR.N).renderC(r, body.cX(), body.y1() + 4);
/* 552 */         (UI.icons()).s.chevron(DIR.N).renderC(r, body.cX() + 8, body.y1() + 4);
/* 553 */         COLOR.unbind();
/*     */       }
/*     */     
/*     */     }
/* 557 */     else if (RD.BUILDINGS().tmp().canAfford(bu, (Region)this.g.get(), tl + 1) != null) {
/* 558 */       OPACITY.O66.bind();
/* 559 */       COLOR.BLACK.render(r, body, -4);
/* 560 */       OPACITY.unbind();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 568 */     GButt.ButtPanel.renderFrame(r, isActive, isSelected, isHovered, body);
/*     */   }
/*     */   
/*     */   public void hover(RDBuilding bu, Region reg, GUI_BOX text) {
/* 572 */     int lev = RD.BUILDINGS().tmp().level(bu, reg);
/* 573 */     GBox b = (GBox)text;
/* 574 */     if (lev == 0) {
/*     */       
/* 576 */       b.title(bu.info.name);
/* 577 */       CharSequence prob = RD.BUILDINGS().tmp().canAfford(bu, reg, lev + 1);
/* 578 */       if (prob == null) {
/* 579 */         b.add((SPRITE)b.text().normalify2().add(¤¤Available));
/*     */       } else {
/* 581 */         b.add((SPRITE)b.text().errorify().add(prob));
/* 582 */       }  b.NL(4);
/* 583 */       b.text(bu.info.desc);
/* 584 */       b.NL();
/* 585 */       b.add(this.levs.get(bu, 1));
/* 586 */       b.sep();
/*     */       
/* 588 */       BHoverer.hover((GUI_BOX)b, (LIST)bu.baseFactors, reg, Dic.¤¤Efficiency, 1.0D, false);
/* 589 */       b.sep();
/*     */ 
/*     */ 
/*     */       
/* 593 */       ((RDBuildingLevel)bu.levels().get(1)).reqs.hover(text, reg);
/*     */       
/* 595 */       b.NL(8);
/* 596 */       hoverCosts(reg, bu, 0, 1, text);
/*     */       
/* 598 */       b.NL(8);
/* 599 */       hoverNonCosts(reg, bu, 0, 1, text);
/*     */     } else {
/*     */       
/* 602 */       RDBuildingLevel l = (RDBuildingLevel)bu.levels().get(RD.BUILDINGS().tmp().level(bu, (Region)this.g.get()));
/* 603 */       b.title(l.name);
/* 604 */       CharSequence prob = RD.BUILDINGS().tmp().canAfford(bu, reg, lev + 1);
/* 605 */       if (prob == null) {
/* 606 */         b.add((SPRITE)b.text().normalify2().add(¤¤ConstructedUp));
/*     */       } else {
/* 608 */         b.add((SPRITE)b.text().normalify2().add(¤¤Constructed));
/* 609 */       }  b.NL(4);
/*     */       
/* 611 */       b.text(bu.info.desc);
/* 612 */       b.NL(2);
/* 613 */       b.add(this.levs.get(bu, lev));
/* 614 */       b.sep();
/*     */       
/* 616 */       if (bu.efficiency.all().size() > 0) {
/*     */         
/* 618 */         bu.efficiency.hover((GUI_BOX)b, (BOOSTABLE_O)reg, Dic.¤¤Efficiency, true);
/* 619 */         b.sep();
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 624 */       bu.boosters().hover(text, (BOOSTABLE_O)reg);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class Info
/*     */     extends GuiSection
/*     */   {
/*     */     Info() {
/* 635 */       GButt.ButtPanel buttPanel = new GButt.ButtPanel(Dic.¤¤Accept)
/*     */         {
/*     */           protected void clickA() {
/* 638 */             if (((Region)(PlayBuildingsPop.Info.access$0(PlayBuildingsPop.Info.this)).g.get()).faction() == FACTIONS.player())
/* 639 */               FACTIONS.player().credits().inc(-RD.BUILDINGS().tmp().cost(), FCredits.CTYPE.CONSTRUCTION); 
/* 640 */             RD.BUILDINGS().tmp().accept();
/* 641 */             (VIEW.inters()).section.close();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 646 */             if (!RD.BUILDINGS().tmp().hasChange()) {
/* 647 */               activeSet(false);
/*     */               
/*     */               return;
/*     */             } 
/* 651 */             if (RD.BUILDINGS().tmp().canAfford()) {
/* 652 */               activeSet(true);
/*     */               
/*     */               return;
/*     */             } 
/* 656 */             for (RDBuilding b : (RD.BUILDINGS()).all) {
/* 657 */               if (RD.BUILDINGS().tmp().level(b, (Region)(PlayBuildingsPop.Info.access$0(PlayBuildingsPop.Info.this)).g.get()) > b.level.get((PlayBuildingsPop.Info.access$0(PlayBuildingsPop.Info.this)).current)) {
/* 658 */                 activeSet(false);
/*     */                 
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */             
/* 664 */             activeSet(true);
/*     */           }
/*     */         };
/* 667 */       addRightC(0, (RENDEROBJ)buttPanel);
/*     */ 
/*     */       
/* 670 */       CLICKABLE cLICKABLE = (new GButt.ButtPanel((SPRITE)(UI.icons()).s.arrow_left)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 674 */             RD.BUILDINGS().tmp(true, (Region)(PlayBuildingsPop.Info.access$0(PlayBuildingsPop.Info.this)).g.get());
/* 675 */             super.clickA();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 680 */             activeSet(RD.BUILDINGS().tmp().hasChange());
/*     */           }
/* 684 */         }).pad(4, 4).hoverInfoSet(Dic.¤¤cancel);
/* 685 */       addRightC(0, (RENDEROBJ)cLICKABLE);
/*     */       
/* 687 */       cLICKABLE = (new GButt.ButtPanel((SPRITE)(UI.icons()).s.cancel)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 691 */             for (RDBuilding b : (RD.BUILDINGS()).all) {
/* 692 */               RD.BUILDINGS().tmp().levelSet(b, 0);
/*     */             }
/* 694 */             super.clickA();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 699 */             boolean a = false;
/* 700 */             for (RDBuilding b : (RD.BUILDINGS()).all) {
/* 701 */               if (RD.BUILDINGS().tmp().level(b, (Region)(PlayBuildingsPop.Info.access$0(PlayBuildingsPop.Info.this)).g.get()) > 0) {
/* 702 */                 a = true; break;
/*     */               } 
/*     */             } 
/* 705 */             activeSet(a);
/*     */           }
/* 708 */         }).pad(4, 4).hoverInfoSet(PlayBuildingsPop.¤¤RemoveAll);
/* 709 */       addRightC(0, (RENDEROBJ)cLICKABLE);
/*     */       
/* 711 */       GuiSection butts = new GuiSection();
/*     */       
/* 713 */       butts.addRightC(16, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 717 */               int am = RD.BUILDINGS().tmp().cost();
/* 718 */               GFORMAT.i(text, -am);
/* 719 */               if (am > FACTIONS.player().credits().getD()) {
/* 720 */                 text.errorify();
/* 721 */               } else if (am == 0) {
/* 722 */                 text.color(COLOR.WHITE50);
/*     */               } else {
/* 724 */                 text.normalify2();
/*     */               }  }
/* 726 */           }).hh((SPRITE)(UI.icons()).s.money));
/*     */       
/* 728 */       for (RDBuildPoints.RDBuildPoint c : (RD.BUILDINGS()).costs.ALL) {
/* 729 */         butts.addRightC(64, boost(c.bo, c.icon));
/*     */       }
/*     */       
/* 732 */       butts.body().incrW(64.0D);
/*     */       
/* 734 */       addRelBody(4, DIR.N, (RENDEROBJ)butts);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private RENDEROBJ boost(final Boostable bo, SPRITE icon) {
/* 742 */       return (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 746 */             bo.get((BOOSTABLE_O)(PlayBuildingsPop.Info.access$0(PlayBuildingsPop.Info.this)).g.get());
/* 747 */             GFORMAT.iIncr(text, (int)bo.get((BOOSTABLE_O)(PlayBuildingsPop.Info.access$0(PlayBuildingsPop.Info.this)).g.get()));
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 754 */             b.title(bo.name);
/* 755 */             b.text(bo.desc);
/* 756 */             b.sep();
/* 757 */             bo.hover((GUI_BOX)b, (BOOSTABLE_O)(PlayBuildingsPop.Info.access$0(PlayBuildingsPop.Info.this)).g.get(), null, true);
/*     */           }
/* 760 */         }).hh(icon);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayBuildingsPop.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */