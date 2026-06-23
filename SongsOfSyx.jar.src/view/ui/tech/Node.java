/*     */ package view.ui.tech;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BUtil;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.player.PTech;
/*     */ import init.sprite.UI.UI;
/*     */ import init.tech.TECH;
/*     */ import init.tech.TECHS;
/*     */ import init.tech.TechCost;
/*     */ import init.tech.TechCurrency;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.value.Lock;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.Tuple;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class Node
/*     */   extends CLICKABLE.ClickableAbs {
/*     */   public static final int WIDTH = 80;
/*     */   public static final int HE2IGHT = 104;
/*  48 */   private static final COLOR Cdormant = (COLOR)COLOR.WHITE100.shade(0.3D);
/*  49 */   private static final COLOR Chovered = (COLOR)COLOR.WHITE100.shade(0.8D);
/*  50 */   private static final COLOR Cfinished = (COLOR)new ColorImp(10, 120, 120);
/*     */   
/*  52 */   private static ColorImp rim = new ColorImp();
/*     */ 
/*     */   
/*  55 */   private static CharSequence ¤¤Relock = "¤Hold {0} and click to disable this technology. The following points will be added to your frozen pool:";
/*  56 */   private static CharSequence ¤¤unlocked = "Unlocked";
/*  57 */   private static CharSequence ¤¤available = "Available to be unlocked";
/*  58 */   private static CharSequence ¤¤locked = "Locked by Requirements";
/*  59 */   private static CharSequence ¤¤afford = "Unable to Afford";
/*  60 */   private static CharSequence ¤¤workValueGood = "This technology will be a profitable investment, increasing production as if you employed {0} workers, ({1} workers per point spent). However... there might be other technologies that are better investments.";
/*  61 */   private static CharSequence ¤¤workValueBad = "Your affected industries are too small for this technology to be a good investment. Currently you get {0} more workers, equivalent to {1} workers per tech point spent. You should increase the size of your industries to make this tech worthwhile";
/*     */   
/*  63 */   static final LIST<COLOR> cols = (LIST<COLOR>)new ArrayList((Object[])new ColorImp[] {
/*  64 */         (new ColorImp(50, 255, 50)).shade(0.5D), (
/*  65 */         new ColorImp(50, 255, 255)).shade(0.5D), (
/*  66 */         new ColorImp(255, 255, 50)).shade(0.5D), (
/*  67 */         new ColorImp(255, 50, 255)).shade(0.5D)
/*     */       });
/*     */   
/*  70 */   static final LIST<DIR> dirs = (LIST<DIR>)new ArrayList((Object[])new DIR[] {
/*  71 */         DIR.SW, 
/*  72 */         DIR.SE, 
/*  73 */         DIR.NW, 
/*  74 */         DIR.NE, 
/*  75 */         DIR.S, 
/*  76 */         DIR.E, 
/*  77 */         DIR.N, 
/*  78 */         DIR.W
/*     */       });
/*     */ 
/*     */   
/*     */   static {
/*  83 */     D.ts(Node.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  88 */   private final ArrayListGrower<Tuple.TupleImp<Edge, Integer>> edges = new ArrayListGrower();
/*  89 */   private final ArrayListGrower<Node> parents = new ArrayListGrower();
/*     */   
/*     */   public int hoverI;
/*     */   
/*     */   public final TECH tech;
/*     */   private final NodeBoosts upgradeBoost;
/*     */   
/*     */   Node(TECH tech, NodeBoosts upgradeBoost) {
/*  97 */     this.tech = tech;
/*  98 */     this.body.setDim(80.0D, HEIGHT());
/*  99 */     this.upgradeBoost = upgradeBoost;
/*     */   }
/*     */   
/*     */   public static int HEIGHT() {
/* 103 */     return 104 + 16 * (TECHS.COSTS().size() - 1) / 2;
/*     */   }
/*     */   
/*     */   public void addEdge(Node parent, Edge e, int mm) {
/* 107 */     this.parents.add(parent);
/* 108 */     for (Tuple.TupleImp<Edge, Integer> ee : this.edges) {
/* 109 */       if (ee.a() == e) {
/* 110 */         ee.b = Integer.valueOf(((Integer)ee.b).intValue() | mm);
/*     */         return;
/*     */       } 
/*     */     } 
/* 114 */     this.edges.add(new Tuple.TupleImp(e, Integer.valueOf(mm)));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover() {
/* 119 */     for (Tuple<Edge, Integer> e : this.edges) {
/* 120 */       ((Edge)e.a()).hover(((Integer)e.b()).intValue());
/*     */     }
/* 122 */     for (Node n : this.parents)
/* 123 */       n.hover(); 
/* 124 */     this.hoverI = VIEW.renI + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 130 */     int j = isSelected | (((FACTIONS.player()).tech.level(this.tech) == this.tech.levelMax) ? 1 : 0);
/*     */ 
/*     */     
/* 133 */     double levels = this.tech.levelMax;
/* 134 */     int level = (FACTIONS.player()).tech.level(this.tech);
/*     */     
/* 136 */     if (level == levels) {
/* 137 */       rim.set(Cfinished);
/*     */     } else {
/* 139 */       rim.set(COLOR.WHITE65);
/*     */     } 
/* 141 */     for (int i = 1; i <= 6; i++) {
/* 142 */       ColorImp.TMP.interpolate(GCOLOR.UI().bg(), (COLOR)rim, 1.0D - i / 6.0D);
/* 143 */       ColorImp.TMP.renderFrame(r, (RECTANGLE)this.body, i, 1);
/*     */     } 
/*     */ 
/*     */     
/* 147 */     double d = level / levels;
/* 148 */     int y1 = (int)(this.body.y2() - this.body.height() * d);
/*     */     
/* 150 */     if (d > 0.0D) {
/* 151 */       for (int m = 6; m >= 1; m--) {
/* 152 */         ColorImp.TMP.interpolate(GCOLOR.UI().bg(), Cfinished, 1.0D - m / 6.0D);
/* 153 */         ColorImp.TMP.render(r, this.body.x1() - m, this.body.x2() + m, y1, this.body.y2() + m);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 161 */     int k = isHovered | ((this.hoverI == VIEW.renI) ? 1 : 0);
/*     */     
/* 163 */     GCOLOR.UI().bg(isActive, false, k).render(r, (RECTANGLE)this.body);
/* 164 */     if (k != 0) {
/* 165 */       COLOR col = col(k, j);
/* 166 */       col.render(r, (RECTANGLE)this.body, -4);
/* 167 */       GCOLOR.UI().bg(isActive, false, k).render(r, (RECTANGLE)this.body, -7);
/*     */     } 
/*     */ 
/*     */     
/* 171 */     this.tech.icon().renderC(r, this.body.cX(), this.body.cY() - 18);
/* 172 */     Str.TMP.clear();
/*     */ 
/*     */ 
/*     */     
/* 176 */     int x = 0;
/* 177 */     int y = 0;
/*     */ 
/*     */     
/* 180 */     for (TechCurrency cu : TECHS.COSTS()) {
/* 181 */       Str.TMP.clear();
/*     */ 
/*     */       
/* 184 */       int wi = (this.body.width() - 16) / 2;
/* 185 */       int cx = this.body.cX() + ((x == 0) ? -1 : 1) * wi / 2;
/* 186 */       int cy = this.body.y2() - 8 - 16 * y - 8;
/*     */       
/* 188 */       boolean has = false;
/* 189 */       for (TechCost c : this.tech.costs) {
/* 190 */         if (c.cu == cu) {
/*     */           
/* 192 */           int l = Math.min((FACTIONS.player()).tech.level(this.tech) + 1, this.tech.levelMax);
/* 193 */           int am = (FACTIONS.player()).tech.costLevel(c.amount, this.tech, l);
/* 194 */           if (am > 0) {
/* 195 */             Str.TMP.add(am);
/* 196 */             has = true;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 203 */       if (has) {
/* 204 */         (has ? OPACITY.O50 : OPACITY.O25).bind();
/* 205 */         ((COLOR)cols.getC(cu.index)).render(r, cx - wi / 2, cx + wi / 2, cy - 8, cy + 8);
/* 206 */         OPACITY.unbind();
/*     */         
/* 208 */         (UI.FONT()).S.renderC(r, cx, cy, (CharSequence)Str.TMP, 1.0D);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 214 */       x++;
/* 215 */       if (x > 1) {
/* 216 */         x = 0;
/* 217 */         y++;
/*     */       } 
/*     */     } 
/*     */     
/* 221 */     OPACITY.unbind();
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
/* 245 */     COLOR.unbind();
/*     */     
/* 247 */     if (j == 0 && 
/* 248 */       !(FACTIONS.player()).tech.canUnlockNext(this.tech)) {
/* 249 */       (((FACTIONS.player()).tech.level(this.tech) > 0) ? OPACITY.O35 : OPACITY.O66).bind();
/* 250 */       COLOR.BLACK.render(r, (RECTANGLE)this.body, 0);
/* 251 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private COLOR col(boolean hovered, boolean selected) {
/* 259 */     if (hovered)
/* 260 */       return Chovered; 
/* 261 */     if (selected)
/* 262 */       return Cfinished; 
/* 263 */     return Cdormant;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 268 */     if (super.hover(mCoo)) {
/* 269 */       hover();
/* 270 */       hoverInfoGet((GUI_BOX)VIEW.hoverBox());
/* 271 */       return true;
/*     */     } 
/* 273 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 280 */     GBox b = (GBox)text;
/* 281 */     text.title(this.tech.name());
/* 282 */     text.text(this.tech.desc());
/* 283 */     b.NL();
/* 284 */     PTech t = FACTIONS.player().tech();
/*     */     
/* 286 */     if (t.level(this.tech) == this.tech.levelMax) {
/* 287 */       b.add((SPRITE)b.text().normalify2().add(¤¤unlocked));
/*     */     }
/* 289 */     else if (!this.tech.requires.passes(FACTIONS.player())) {
/* 290 */       b.add((SPRITE)b.text().errorify().add(¤¤locked));
/* 291 */     } else if (!t.canAffordNext(this.tech)) {
/* 292 */       b.add((SPRITE)b.text().errorify().add(¤¤afford));
/* 293 */     } else if (t.canUnlockNext(this.tech)) {
/* 294 */       b.add((SPRITE)b.text().warnify().add(¤¤available));
/*     */     } else {
/* 296 */       b.add((SPRITE)b.text().errorify().add(Dic.¤¤Access));
/*     */     } 
/* 298 */     b.NL();
/*     */ 
/*     */ 
/*     */     
/* 302 */     b.sep();
/*     */     
/* 304 */     if (this.tech.levelMax != 1) {
/*     */ 
/*     */       
/* 307 */       b.textLL(Dic.¤¤Level);
/* 308 */       b.add((SPRITE)GFORMAT.iofkNoColor(b.text(), t.level(this.tech), this.tech.levelMax));
/* 309 */       b.NL(8);
/*     */     } 
/*     */ 
/*     */     
/* 313 */     b.tab(7);
/* 314 */     b.textLL(Dic.¤¤Cost);
/* 315 */     b.tab(10);
/* 316 */     b.textLL(Dic.¤¤Allocated);
/* 317 */     b.NL();
/*     */     
/* 319 */     for (TechCost c : this.tech.costs) {
/*     */       
/* 321 */       b.add((SPRITE)c.cu.bo.icon);
/* 322 */       b.textL(c.cu.bo.name, 6);
/*     */       
/* 324 */       b.tab(7);
/*     */ 
/*     */       
/* 327 */       int cost = t.costLevelNext(c.amount, this.tech);
/*     */       
/* 329 */       if (t.level(this.tech) >= this.tech.levelMax) {
/* 330 */         b.add((SPRITE)b.text().add('-'));
/*     */       }
/* 332 */       else if (((PTech.TechCurr)t.currs().get(c.cu.index)).available() < cost) {
/* 333 */         b.add((SPRITE)GFORMAT.iBig(b.text(), cost).errorify());
/*     */       } else {
/* 335 */         b.add((SPRITE)GFORMAT.iBig(b.text(), cost));
/*     */       } 
/* 337 */       b.tab(10);
/* 338 */       b.add((SPRITE)GFORMAT.iBig(b.text(), t.costTotal(c, this.tech)));
/*     */       
/* 340 */       b.NL();
/*     */     } 
/* 342 */     b.sep();
/*     */ 
/*     */ 
/*     */     
/* 346 */     LIST<TECH.TechRequirement> rr = this.tech.requires();
/*     */     
/* 348 */     int am = 0;
/* 349 */     for (TECH.TechRequirement r : rr) {
/* 350 */       if (r.level > 0)
/* 351 */         am++; 
/*     */     } 
/* 353 */     this.tech.requires.hover(text, FACTIONS.player());
/*     */     
/* 355 */     if (am > 0) {
/* 356 */       if (this.tech.requires.all().size() == 0)
/* 357 */         b.textLL(Dic.¤¤Requires); 
/* 358 */       b.NL();
/* 359 */       for (TECH.TechRequirement r : rr) {
/* 360 */         if (r.level <= 0)
/*     */           continue; 
/* 362 */         b.add((SPRITE)(UI.icons()).s.vial);
/* 363 */         GText te = b.text();
/* 364 */         te.add(r.tech.tree.name);
/* 365 */         te.add(':').s();
/* 366 */         te.add(r.tech.name());
/* 367 */         if (r.tech.levelMax > 1) {
/* 368 */           te.s().add((CharSequence)GFORMAT.toNumeral(r.level));
/*     */         }
/* 370 */         if (t.level(r.tech) >= r.level && r.tech.requires.passes(FACTIONS.player())) {
/* 371 */           te.normalify2();
/*     */         } else {
/* 373 */           te.errorify();
/* 374 */         }  b.add((SPRITE)te);
/* 375 */         b.NL();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 380 */     b.NL(8);
/*     */ 
/*     */ 
/*     */     
/* 384 */     this.tech.lockers.hover(text);
/*     */ 
/*     */     
/* 387 */     boolean totHas = false;
/* 388 */     double tot = 0.0D;
/* 389 */     for (Lock<?> l : (Iterable<Lock<?>>)this.tech.lockers.all()) {
/* 390 */       if (this.upgradeBoost.upgradeBoost.containsKey(l.lockable.key)) {
/* 391 */         totHas = true;
/* 392 */         NodeBoosts.upEntry upEntry = (NodeBoosts.upEntry)this.upgradeBoost.upgradeBoost.get(l.lockable.key);
/* 393 */         tot += boostValue(upEntry.blue, upEntry.bo, upEntry.value, false);
/*     */       } 
/*     */     } 
/*     */     
/* 397 */     b.NL(8);
/*     */     
/* 399 */     if (this.tech.boosters.all().size() > 0) {
/* 400 */       b.textLL(Dic.¤¤Effects);
/* 401 */       b.tab(7);
/* 402 */       b.textLL(Dic.¤¤Current);
/* 403 */       b.tab(9);
/* 404 */       b.textLL(Dic.¤¤Next);
/* 405 */       b.NL();
/*     */       
/* 407 */       for (BoostSpec bb : this.tech.boosters.all()) {
/* 408 */         b.add(bb.boostable.cat.icon);
/* 409 */         b.add((SPRITE)bb.boostable.icon);
/* 410 */         b.text(bb.boostable.name, 22);
/* 411 */         b.tab(7);
/* 412 */         double v = bb.booster.to();
/* 413 */         if (bb.booster.isMul)
/* 414 */           v--; 
/* 415 */         v *= t.level(this.tech);
/* 416 */         if (bb.booster.isMul)
/* 417 */           v++; 
/* 418 */         b.add((SPRITE)bb.booster.format(b.text(), v));
/*     */         
/* 420 */         if (t.level(this.tech) < this.tech.levelMax) {
/* 421 */           v = bb.booster.to();
/* 422 */           if (bb.booster.isMul)
/* 423 */             v--; 
/* 424 */           v *= (t.level(this.tech) + 1);
/* 425 */           if (bb.booster.isMul) {
/* 426 */             v++;
/*     */           }
/* 428 */           b.tab(9);
/* 429 */           b.add((SPRITE)bb.booster.format(b.text(), v));
/*     */           
/* 431 */           double tt = boostValue(bb);
/* 432 */           if (tt >= 0.0D) {
/* 433 */             tot += tt;
/* 434 */             totHas = true;
/*     */           } 
/*     */         } 
/*     */         
/* 438 */         b.NL();
/*     */       } 
/* 440 */       totHas = true;
/* 441 */       b.NL(4);
/*     */     } 
/*     */     
/* 444 */     if (totHas || tot > 0.0D) {
/* 445 */       b.sep();
/* 446 */       GText tt = b.text();
/* 447 */       tt.add((tot < 1.0D) ? ¤¤workValueBad : ¤¤workValueGood).insert(0, tot, 1);
/* 448 */       if (tot < 1.0D)
/* 449 */         tt.errorify(); 
/* 450 */       int cost = 0;
/* 451 */       for (TechCost c : this.tech.costs)
/* 452 */         cost += t.costLevelNext(c.amount, this.tech); 
/* 453 */       tt.insert(1, tot / cost, 2);
/* 454 */       b.add((SPRITE)tt);
/* 455 */       b.sep();
/*     */     } 
/*     */ 
/*     */     
/* 459 */     b.NL();
/*     */ 
/*     */     
/* 462 */     b.NL();
/*     */     
/* 464 */     if (t.level(this.tech) > 0) {
/* 465 */       GText te = b.text();
/* 466 */       te.add(¤¤Relock);
/* 467 */       te.insert(0, (KEYS.MAIN()).UNDO.repr());
/* 468 */       b.error((CharSequence)te);
/* 469 */       b.NL();
/*     */       
/* 471 */       for (TechCost c : this.tech.costs) {
/*     */         
/* 473 */         b.add((SPRITE)c.cu.bo.icon);
/* 474 */         b.textL(c.cu.bo.name);
/* 475 */         b.tab(7);
/* 476 */         b.add((SPRITE)GFORMAT.iIncr(b.text(), t.costLevel(c.amount, this.tech, t.level(this.tech))));
/* 477 */         b.NL();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private double boostValue(BoostSpec bb) {
/* 485 */     NodeBoosts.tEntry e = (NodeBoosts.tEntry)this.upgradeBoost.tools.get(bb.boostable.key);
/* 486 */     if (e != null) {
/* 487 */       double max = e.value.maxAm;
/* 488 */       double am = ((BoostSpec)e.value.boosts.all().get(0)).booster.to() * bb.booster.to() / max;
/*     */       
/* 490 */       return boostValue(e.blue, e.bo, am, false);
/*     */     } 
/*     */ 
/*     */     
/* 494 */     RoomBlueprintImp r = (SETT.ROOMS()).bonus.get(bb.boostable);
/* 495 */     if (r == null) {
/* 496 */       return -1.0D;
/*     */     }
/* 498 */     if (!(r instanceof INDUSTRY_HASER)) {
/* 499 */       return -1.0D;
/*     */     }
/* 501 */     if (((Industry)((INDUSTRY_HASER)r).industries().get(0)).outs().size() == 0) {
/* 502 */       return -1.0D;
/*     */     }
/* 504 */     double res = boostValue(r, bb.boostable, bb.booster.to(), bb.booster.isMul);
/* 505 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double boostValue(RoomBlueprintImp r, Boostable bo, double increase, boolean isMul) {
/* 516 */     double employees = r.employment().employed();
/* 517 */     double current = bo.get((BOOSTABLE_O)HCLASS_RACE.clP());
/* 518 */     double next = current;
/* 519 */     if (isMul) {
/* 520 */       next = BUtil.value(bo.all(), HCLASS_RACE.clP(), bo.baseValue, increase, bo.minValue);
/*     */     } else {
/* 522 */       next = BUtil.value(bo.all(), HCLASS_RACE.clP(), bo.baseValue + increase, 1.0D, bo.minValue);
/*     */     } 
/*     */     
/* 525 */     double res = employees * (next - current) / current;
/*     */ 
/*     */     
/* 528 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 537 */     if ((KEYS.MAIN()).UNDO.isPressed()) {
/* 538 */       (VIEW.UI()).tech.prompt.forget(this.tech);
/*     */     } else {
/* 540 */       (VIEW.UI()).tech.prompt.unlock(this.tech);
/* 541 */     }  super.clickA();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\Node.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */