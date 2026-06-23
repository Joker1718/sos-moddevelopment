/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FWorth;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icons;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.tilemap.ground.Ground;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.Tree;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.RDReligions;
/*     */ import world.region.building.RDBuilding;
/*     */ import world.region.building.RDBuildingLevel;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ class MiscBasics extends GuiSection {
/*  48 */   private static CharSequence ¤¤fertilityD = "Moisture can increase production of buildings and determines how many subjects the region can support.";
/*  49 */   private static CharSequence ¤¤areaD = "The size of the region along with the fertility determines how many subjects it can support.";
/*  50 */   private static CharSequence ¤¤worth = "Worth";
/*  51 */   private static CharSequence ¤¤worthD = "How much the other factions think this region is worth. This counts towards your rivalry.";
/*     */   
/*     */   static {
/*  54 */     D.ts(MiscBasics.class);
/*     */   }
/*     */   
/*     */   public static GuiSection info(final GETTER<Region> g) {
/*  58 */     GuiSection sec = new GuiSection();
/*     */ 
/*     */ 
/*     */     
/*  62 */     int w = 140;
/*  63 */     sec.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  67 */             GFORMAT.i(text, ((Region)g.get()).info.area());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  72 */             b.text(MiscBasics.¤¤areaD);
/*     */           }
/*  75 */         }).hh((SPRITE)(new GText((UI.FONT()).H2, Dic.¤¤Area)).lablify(), w));
/*     */     
/*  77 */     sec.addRightC(80, (RENDEROBJ)new HOVERABLE.HoverableAbs(w, 16)
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */           {
/*  81 */             double d = (RD.DEVASTATION()).current.getD(g.get());
/*  82 */             int am = (int)(d * (body().width() / 16));
/*  83 */             int x = body().x1();
/*  84 */             (GCOLOR.UI()).BAD.hovered.bind();
/*  85 */             for (int i = 0; i < am; i++) {
/*  86 */               (UI.icons()).s.degrade.render(r, x, body().y1());
/*  87 */               x += 16;
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  93 */             GBox b = (GBox)text;
/*  94 */             b.add((RD.DEVASTATION()).current.info());
/*  95 */             b.NL();
/*  96 */             b.add((SPRITE)GFORMAT.percInv(b.text(), (RD.DEVASTATION()).current.getD(g.get())));
/*     */           }
/*     */         });
/*     */     
/* 100 */     sec.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 104 */             GFORMAT.i(text, (int)FWorth.region((Region)g.get()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 109 */             b.text(MiscBasics.¤¤worthD);
/*     */           }
/* 112 */         }).hh((SPRITE)(new GText((UI.FONT()).H2, ¤¤worth)).lablify(), w), 0, sec.getLastY2() + 2);
/*     */     
/* 114 */     final int DIM = 24;
/* 115 */     final int AM = 10;
/*     */ 
/*     */     
/* 118 */     SPRITE.Imp imp = new SPRITE.Imp(AM * DIM, DIM)
/*     */       {
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 123 */           COLOR.WHITE25.render(r, X1, X2, Y1, Y2);
/* 124 */           int ff = (int)Math.ceil(((Region)g.get()).info.moisture() * (AM - 1));
/* 125 */           for (int i = 0; i < AM; i++) {
/* 126 */             OPACITY.unbind();
/* 127 */             if (i >= ff) {
/* 128 */               OPACITY.O25.bind();
/*     */             }
/* 130 */             (SPRITES.icons()).m.agriculture.render(r, X1, Y1);
/* 131 */             X1 += DIM;
/*     */           } 
/* 133 */           OPACITY.unbind();
/*     */         }
/*     */       };
/*     */     
/* 137 */     sec.add((RENDEROBJ)new GHeader.HeaderHorizontal(Ground.¤¤moisture, (SPRITE)imp, w)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 141 */             GBox b = (GBox)text;
/* 142 */             b.title(Ground.¤¤moisture);
/* 143 */             b.text(MiscBasics.¤¤fertilityD);
/* 144 */             b.NL();
/* 145 */             b.textL(Dic.¤¤Current);
/* 146 */             b.tab(6);
/* 147 */             b.add((SPRITE)GFORMAT.perc(b.text(), ((Region)g.get()).info.moisture()));
/*     */           }
/* 150 */         }0, sec.getLastY2() + 2);
/*     */     
/* 152 */     imp = new SPRITE.Imp(AM * DIM, DIM)
/*     */       {
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 157 */           COLOR.WHITE25.render(r, X1, X2, Y1, Y2);
/* 158 */           int x = X1; int i;
/* 159 */           for (i = 0; i < AM / 2; i++) {
/* 160 */             ColorImp.TMP.interpolate((CLIMATES.COLD()).color, (CLIMATES.TEMP()).color, i / 5.0D);
/* 161 */             ColorImp.TMP.render(r, x, x + DIM, Y1 + 2, Y2 - 2);
/* 162 */             x += DIM;
/*     */           } 
/* 164 */           for (i = 0; i < AM / 2; i++) {
/* 165 */             ColorImp.TMP.interpolate((CLIMATES.TEMP()).color, (CLIMATES.HOT()).color, i / 5.0D);
/* 166 */             ColorImp.TMP.render(r, x, x + DIM, Y1 + 2, Y2 - 2);
/* 167 */             x += DIM;
/*     */           } 
/*     */ 
/*     */           
/* 171 */           double d = 0.0D;
/* 172 */           for (CLIMATE c : CLIMATES.ALL()) {
/* 173 */             d += ((Region)g.get()).info.climate(c) * c.index();
/*     */           }
/* 175 */           d /= (CLIMATES.ALL().size() - 1);
/* 176 */           x = (int)(X1 + d * (X2 - X1));
/* 177 */           x -= 12;
/* 178 */           COLOR.BLACK.bind();
/* 179 */           (SPRITES.icons()).m.crossair.render(r, x + 2, Y1 + 2);
/* 180 */           COLOR.unbind();
/* 181 */           (SPRITES.icons()).m.crossair.render(r, x, Y1);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 186 */     sec.addDown(2, (RENDEROBJ)new GHeader.HeaderHorizontal((CLIMATES.INFO()).name, (SPRITE)imp, w)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 190 */             GBox b = (GBox)text;
/* 191 */             for (CLIMATE c : CLIMATES.ALL()) {
/* 192 */               b.text(c.name);
/* 193 */               b.tab(6);
/* 194 */               b.add((SPRITE)GFORMAT.perc(b.text(), ((Region)g.get()).info.climate(c)));
/* 195 */               b.NL();
/*     */             } 
/* 197 */             CLIMATES.BONUS().hover(text, (BOOSTABLE_O)g.get(), Dic.¤¤Effects, 2);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 202 */     imp = new SPRITE.Imp(AM * DIM, DIM)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 206 */           COLOR.WHITE25.render(r, X1, X2, Y1, Y2);
/* 207 */           int aa = AM;
/* 208 */           for (TERRAIN c : TERRAINS.ALL()) {
/* 209 */             if (c == TERRAINS.NONE())
/*     */               continue; 
/* 211 */             int am = (int)(aa * ((Region)g.get()).info.terrain(c));
/* 212 */             for (int i = 0; i < am; i++) {
/* 213 */               c.icon().render(r, X1, X1 + DIM, Y1, Y2);
/* 214 */               X1 += DIM;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/* 219 */     sec.addDown(2, (RENDEROBJ)new GHeader.HeaderHorizontal(Dic.¤¤Terrain, (SPRITE)imp, w)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 223 */             GBox b = (GBox)text;
/* 224 */             for (TERRAIN t : TERRAINS.ALL()) {
/* 225 */               b.text(t.name);
/* 226 */               b.tab(6);
/* 227 */               b.add((SPRITE)GFORMAT.perc(b.text(), ((Region)g.get()).info.terrain(t)));
/* 228 */               b.NL();
/*     */             } 
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 238 */     GuiSection hh = new GuiSection();
/* 239 */     hh.add((SPRITE)(new GText((UI.FONT()).H2, Dic.¤¤Neighbours)).lablify(), 0, 0);
/*     */     
/* 241 */     HOVERABLE.HoverableAbs hoverableAbs = new HOVERABLE.HoverableAbs(AM * DIM, DIM)
/*     */       {
/* 243 */         WRegFinder wr = new WRegFinder();
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 246 */           COLOR.WHITE25.render(r, (RECTANGLE)this.body);
/* 247 */           LIST<WRegFinder.RegDist> dists = this.wr.all((Region)g.get(), WRegFinder.Treaty.REG_NEIGHS, WRegSel.DUMMY((Region)g.get()));
/*     */           
/* 249 */           if (dists.size() > 0) {
/* 250 */             int dd = AM * DIM / dists.size();
/* 251 */             dd = CLAMP.i(dd, 1, 16);
/* 252 */             int x1 = this.body.x1();
/* 253 */             for (WRegFinder.RegDist d : dists) {
/* 254 */               COLOR c = (d.reg.faction() == null) ? COLOR.WHITE50 : (COLOR)d.reg.faction().banner().colorBG();
/* 255 */               c.bind();
/* 256 */               (UI.icons()).s.capitol.renderCY(r, x1, this.body.cY());
/* 257 */               x1 += dd;
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 265 */           GBox b = (GBox)text;
/* 266 */           b.text(Dic.¤¤Distance);
/* 267 */           b.NL();
/* 268 */           for (WRegFinder.RegDist r : this.wr.all((Region)g.get(), WRegFinder.Treaty.REG_NEIGHS, WRegSel.DUMMY((Region)g.get()))) {
/* 269 */             GText n = b.text();
/* 270 */             COLOR c = (r.reg.faction() == null) ? COLOR.WHITE50 : (COLOR)r.reg.faction().banner().colorBG();
/* 271 */             n.color(c);
/* 272 */             n.add((CharSequence)r.reg.info.name());
/*     */             
/* 274 */             b.add((SPRITE)n);
/* 275 */             b.tab(6);
/* 276 */             b.add((SPRITE)(SPRITES.icons()).s.arrow_right);
/* 277 */             b.add((SPRITE)GFORMAT.i(b.text(), r.distance));
/* 278 */             if (r.water) {
/* 279 */               b.tab(8);
/* 280 */               b.add((SPRITE)(SPRITES.icons()).s.ship);
/*     */             } 
/* 282 */             b.NL();
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 287 */     hh.addRightCAbs(w, (RENDEROBJ)hoverableAbs);
/*     */     
/* 289 */     sec.addDown(2, (RENDEROBJ)hh);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 295 */     sec.addRelBody(2, DIR.S, race(g, sec.body().width()));
/*     */ 
/*     */ 
/*     */     
/* 299 */     return sec;
/*     */   }
/*     */   
/*     */   private static RENDEROBJ race(final GETTER<Region> g, int width) {
/* 303 */     final int YS = 3;
/* 304 */     final int wi = 16 * (width - 8) / 16;
/*     */     
/* 306 */     return (RENDEROBJ)new HOVERABLE.HoverableAbs(wi + 8, 24 * YS + 8)
/*     */       {
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/* 311 */           COLOR.WHITE25.render(r, (RECTANGLE)this.body);
/* 312 */           double maxPop = 3.0D * RD.RACES().maxPop((Region)g.get());
/* 313 */           int maxAm = wi / 8 * YS;
/* 314 */           int m = (this.body.width() - wi) / 2;
/* 315 */           int x1 = this.body.x1() + m;
/* 316 */           int y1 = this.body.y1() + 4;
/*     */ 
/*     */ 
/*     */           
/* 320 */           double d = maxPop / (3 * (RD.RACES()).population.get((Region)g.get()));
/* 321 */           d = CLAMP.d(d, 0.0D, 1.0D);
/*     */           
/* 323 */           int dx = (int)(24.0D * d);
/* 324 */           dx = CLAMP.i(dx, 1, 24);
/*     */           
/* 326 */           int i = 0;
/*     */           
/* 328 */           int lineMax = (int)Math.ceil((wi - 20) / dx);
/*     */           
/* 330 */           for (RDRace ra : (RD.RACES()).all) {
/* 331 */             int am = (int)Math.ceil((maxAm * ra.pop.get((Region)g.get())) / maxPop);
/*     */             
/* 333 */             while (am > 0) {
/* 334 */               am--;
/*     */               
/* 336 */               int x = dx * i % lineMax;
/* 337 */               int y = i / lineMax;
/* 338 */               i++;
/* 339 */               if (y >= YS) {
/*     */                 break;
/*     */               }
/* 342 */               (ra.race.appearance()).icon.render(r, x1 + x, y1 + y * 24);
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 351 */           GBox b = (GBox)text;
/* 352 */           b.title(Dic.¤¤Population);
/*     */           
/* 354 */           b.tab(6);
/* 355 */           b.textL(Dic.¤¤Population);
/* 356 */           b.tab(9);
/* 357 */           b.textL(Dic.¤¤Biome);
/* 358 */           b.NL();
/*     */           
/* 360 */           for (RDRace ra : (RD.RACES()).all) {
/*     */             
/* 362 */             double v = ra.pop.base((Region)g.get());
/* 363 */             b.add((SPRITE)(ra.race.appearance()).iconBig);
/* 364 */             b.text(ra.race.info.names);
/* 365 */             b.tab(6);
/*     */             
/* 367 */             b.add((SPRITE)GFORMAT.i(b.text(), ra.pop.get((Region)g.get())));
/* 368 */             b.tab(9);
/* 369 */             b.add((SPRITE)GFORMAT.perc(b.text(), v));
/* 370 */             b.NL();
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 376 */           b.textLL(Dic.¤¤Total);
/* 377 */           b.tab(6);
/* 378 */           b.add((SPRITE)GFORMAT.iBig(b.text(), (RD.RACES()).population.get((Region)g.get())));
/* 379 */           b.add((SPRITE)(UI.icons()).s.arrow_right);
/* 380 */           b.add((SPRITE)GFORMAT.iBig(b.text(), (int)(RD.RACES()).popTarget.getD(g.get())));
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public static RENDEROBJ rel(final GETTER<Region> g) {
/* 387 */     final int AM = 24;
/* 388 */     return (RENDEROBJ)new HOVERABLE.HoverableAbs(16 * AM, 20)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/* 392 */           COLOR.WHITE25.render(r, (RECTANGLE)this.body);
/*     */           
/* 394 */           int a = AM;
/* 395 */           int X1 = this.body.x1();
/* 396 */           double tot = 1.0D;
/* 397 */           for (RDReligions.RDReligion ra : RD.RELIGION().all()) {
/*     */             
/* 399 */             double v = ra.current.getD(g.get());
/* 400 */             int aa = (int)Math.round(a * ra.current.getD(g.get()) / tot);
/*     */             
/* 402 */             tot -= v;
/* 403 */             a -= aa;
/*     */             
/* 405 */             while (aa > 0) {
/* 406 */               ra.religion.icon.small.renderCY(r, X1, body().cY());
/* 407 */               X1 += 16;
/* 408 */               aa--;
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 416 */           GBox b = (GBox)text;
/*     */           
/* 418 */           b.title((STATS.RELIGION()).info.name);
/*     */           
/* 420 */           for (RDReligions.RDReligion ra : RD.RELIGION().all()) {
/*     */             
/* 422 */             b.add((SPRITE)ra.religion.icon);
/* 423 */             b.text(ra.religion.info.name);
/* 424 */             b.tab(7);
/* 425 */             b.add((SPRITE)GFORMAT.perc(b.text(), ra.current.getD(g.get())));
/* 426 */             b.NL();
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static RENDEROBJ prospect(final GETTER<Region> g) {
/* 436 */     final int AM = 12;
/* 437 */     final ArrayList<BuildSort> all = new ArrayList((RD.BUILDINGS()).all.size());
/*     */     
/* 439 */     for (RDBuilding b : (RD.BUILDINGS()).all) {
/* 440 */       all.add(new BuildSort(b));
/*     */     }
/*     */     
/* 443 */     final Tree<BuildSort> sort = new Tree<BuildSort>((RD.BUILDINGS()).all.size())
/*     */       {
/*     */         protected boolean isGreaterThan(MiscBasics.BuildSort current, MiscBasics.BuildSort cmp)
/*     */         {
/* 447 */           return (current.value > cmp.value);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 452 */     return (RENDEROBJ)new HOVERABLE.HoverableAbs(32 * AM, 40)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/* 456 */           COLOR.WHITE25.render(r, (RECTANGLE)this.body);
/* 457 */           sort.clear();
/* 458 */           for (MiscBasics.BuildSort b : all) {
/* 459 */             if (b.b.baseFactors.size() > 0) {
/* 460 */               b.init((Region)g.get());
/* 461 */               sort.add(b);
/*     */             } 
/*     */           } 
/*     */           
/* 465 */           int max = AM;
/* 466 */           int X1 = this.body.x1();
/* 467 */           while (sort.hasMore() && max > 0) {
/* 468 */             MiscBasics.BuildSort b = (MiscBasics.BuildSort)sort.pollGreatest();
/* 469 */             max--;
/* 470 */             if (b.value == 1.0D)
/*     */               continue; 
/* 472 */             int Y1 = this.body.y1();
/* 473 */             ((RDBuildingLevel)b.b.levels.get(1)).icon.renderCY(r, X1, body().cY());
/*     */             
/* 475 */             COLOR col = COLOR.GREEN100;
/* 476 */             Icons.S.IconS iconS = (UI.icons()).s.plus;
/* 477 */             int am = (int)Math.ceil(Math.abs(b.value - 1.0D) * 4.0D);
/* 478 */             am = CLAMP.i(am, 0, 4);
/* 479 */             if (b.value < 1.0D) {
/* 480 */               col = COLOR.REDISH;
/* 481 */               iconS = (UI.icons()).s.minus;
/*     */             } 
/* 483 */             col.bind();
/* 484 */             for (int i = 0; i < am; i++) {
/* 485 */               iconS.render(r, X1 + 16, Y1 + 10 * i);
/*     */             }
/* 487 */             COLOR.unbind();
/* 488 */             X1 += 32;
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 495 */           GBox b = (GBox)text;
/* 496 */           b.title(Dic.¤¤Prospect);
/* 497 */           sort.clear();
/* 498 */           for (MiscBasics.BuildSort bu : all) {
/* 499 */             if (bu.b.baseFactors.size() > 0) {
/* 500 */               bu.init((Region)g.get());
/* 501 */               sort.add(bu);
/*     */             } 
/*     */           } 
/*     */           
/* 505 */           while (sort.hasMore()) {
/* 506 */             MiscBasics.BuildSort bu = (MiscBasics.BuildSort)sort.pollGreatest();
/* 507 */             b.add((SPRITE)((RDBuildingLevel)bu.b.levels.get(1)).icon);
/* 508 */             b.text(bu.b.info.name);
/* 509 */             b.tab(7);
/* 510 */             b.add((SPRITE)GFORMAT.f1(b.text(), bu.value));
/* 511 */             b.NL();
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private static class BuildSort
/*     */   {
/*     */     public final RDBuilding b;
/* 520 */     public double value = 0.0D;
/*     */     
/*     */     public BuildSort(RDBuilding b) {
/* 523 */       this.b = b;
/*     */     }
/*     */     
/*     */     void init(Region reg) {
/* 527 */       this.value = this.b.baseEfficiency(reg);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\MiscBasics.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */