/*     */ package view.ui.wiki;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.race.RacePreferrence;
/*     */ import init.religion.RELIGIONS;
/*     */ import init.religion.Religion;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import init.resources.ResG;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icons;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.BUILDING_PREF;
/*     */ import init.type.BUILDING_PREFS;
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.NEEDS;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.employment.RoomEmploymentSimple;
/*     */ import settlement.room.water.pool.ROOM_POOL;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.misc.Dictionary;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.misc.GTextR;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class WikiRace
/*     */   extends Article
/*     */ {
/*  65 */   private static CharSequence ¤¤liking = "¤Liking";
/*  66 */   private static CharSequence ¤¤likingD = "¤Different species likes/dislikes different aspects of layout and management. Green bars indicate that the species likes the aspect, a red one represents dislike.";
/*     */   
/*  68 */   private static CharSequence ¤¤Likes = "¤This is liked by the race. Higher value = more fulfillment.";
/*  69 */   private static CharSequence ¤¤Dislikes = "¤This is disliked the race. Higher value = less fulfillment.";
/*  70 */   private static CharSequence ¤¤Mixed = "¤Different classes have mixed feelings about this.";
/*  71 */   private static CharSequence ¤¤DontCare = "¤This race doesn't care about this value.";
/*     */   
/*  73 */   private static CharSequence ¤¤ReligionD = "¤Inclination towards different religions.";
/*  74 */   private static CharSequence ¤¤PopulationD = "¤Determines a species population and location on the world map.";
/*  75 */   private static CharSequence ¤¤PopulationNo = "¤This species is not available for immigration.";
/*     */   
/*  77 */   private static CharSequence ¤¤AdultAge = "¤Days as infant: {0}, days as child: {1}.";
/*     */   
/*     */   private final Race race;
/*     */   
/*     */   static {
/*  82 */     D.ts(WikiRace.class);
/*     */   }
/*     */   
/*     */   WikiRace(Race race) {
/*  86 */     super(race.info.names, RACES.name());
/*  87 */     this.race = race;
/*     */   }
/*     */ 
/*     */   
/*     */   GuiSection makeSection(LIST<Article> all, int width) {
/*  92 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/*  94 */     width -= 24; byte b; int j;
/*     */     CharSequence[] arrayOfCharSequence;
/*  96 */     for (j = (arrayOfCharSequence = (UI.FONT()).M.getRows(this.race.info.desc_long, width)).length, b = 0; b < j; ) { CharSequence charSequence = arrayOfCharSequence[b];
/*  97 */       GTextR r = new GTextR((UI.FONT()).M, charSequence);
/*  98 */       r.setColor((GCOLOR.T()).NORMAL);
/*  99 */       rows.add(r);
/*     */ 
/*     */ 
/*     */       
/*     */       b++; }
/*     */ 
/*     */ 
/*     */     
/* 107 */     rows.add(seperator(Dic.¤¤Population, ¤¤PopulationD, width));
/*     */ 
/*     */     
/* 110 */     if (this.race.bvalue((BOOSTABLES.CIVICS()).IMMIGRATION) == 0.0D) {
/* 111 */       rows.add((new GText((UI.FONT()).M, ¤¤PopulationNo)).r(DIR.C));
/*     */     } else {
/* 113 */       LinkedList<RENDEROBJ> linkedList = new LinkedList();
/*     */       
/* 115 */       double d1 = 0.0D;
/* 116 */       for (int rii = 0; rii < RACES.all().size(); rii++) {
/* 117 */         Race r = (Race)RACES.all().get(rii);
/* 118 */         for (TERRAIN c : TERRAINS.ALL()) {
/* 119 */           d1 = Math.max(d1, (r.population()).max * r.population().terrain(c));
/*     */         }
/*     */       } 
/* 122 */       final double maxAm = d1;
/*     */       
/* 124 */       for (TERRAIN c : TERRAINS.ALL()) {
/*     */ 
/*     */         
/* 127 */         RGauge rGauge = new RGauge(c.icon())
/*     */           {
/*     */             double getValue()
/*     */             {
/* 131 */               return (WikiRace.this.race.population()).max * WikiRace.this.race.population().terrain(c) / maxAm;
/*     */             }
/*     */ 
/*     */             
/*     */             SPRITE get(double value) {
/* 136 */               return (SPRITE)(SPRITES.icons()).s.human;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 142 */               GBox b = (GBox)text;
/*     */               
/* 144 */               b.title(c.name);
/* 145 */               b.text(c.desc);
/*     */               
/* 147 */               b.NL(8);
/*     */               
/* 149 */               b.textLL(WikiRace.this.race.info.names);
/* 150 */               b.add((SPRITE)GFORMAT.percBig(b.text(), (WikiRace.this.race.population()).max * WikiRace.this.race.population().terrain(c)));
/*     */             }
/*     */           };
/* 153 */         linkedList.add(rGauge);
/*     */       } 
/*     */       
/* 156 */       RGauge.add((LISTE<RENDEROBJ>)rows, (LIST<RENDEROBJ>)linkedList);
/* 157 */       linkedList = new LinkedList();
/*     */       
/* 159 */       for (CLIMATE c : CLIMATES.ALL()) {
/*     */         
/* 161 */         RGauge rGauge = new RGauge(c.icon)
/*     */           {
/*     */             double getValue()
/*     */             {
/* 165 */               return WikiRace.this.race.population().climate(c);
/*     */             }
/*     */ 
/*     */             
/*     */             SPRITE get(double value) {
/* 170 */               return (SPRITE)(SPRITES.icons()).s.human;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 176 */               GBox b = (GBox)text;
/*     */               
/* 178 */               b.title(c.name);
/* 179 */               b.text(c.desc);
/*     */               
/* 181 */               b.NL(8);
/*     */               
/* 183 */               b.textLL(WikiRace.this.race.info.names);
/* 184 */               b.add((SPRITE)GFORMAT.percBig(b.text(), WikiRace.this.race.population().climate(c)));
/*     */             }
/*     */           };
/* 187 */         linkedList.add(rGauge);
/*     */       } 
/*     */       
/* 190 */       RGauge.add((LISTE<RENDEROBJ>)rows, (LIST<RENDEROBJ>)linkedList);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 198 */     rows.add(seperator(((STATS.ENV()).OTHERS.info()).name, ((STATS.ENV()).OTHERS.info()).desc, width));
/* 199 */     GuiSection guiSection1 = new GuiSection();
/* 200 */     guiSection1.body().setWidth(width);
/* 201 */     guiSection1.body().setHeight(1.0D);
/* 202 */     guiSection1.addRelBody(0, DIR.S, (RENDEROBJ)new RacePreferrence.REN_PREF(this.race, true, width));
/*     */     
/* 204 */     rows.add(guiSection1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 209 */     rows.add(seperator((STATS.RELIGION()).info.name, ¤¤ReligionD, width));
/* 210 */     guiSection1 = new GuiSection();
/* 211 */     guiSection1.body().setWidth(width);
/* 212 */     guiSection1.body().setHeight(1.0D);
/* 213 */     HOVERABLE.HoverableAbs hoverableAbs = new HOVERABLE.HoverableAbs(640, 32)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/* 217 */           double d = 0.0D;
/* 218 */           int rels = 0;
/* 219 */           for (Religion re : RELIGIONS.ALL()) {
/* 220 */             double a = WikiRace.this.race.bvalue(re.conversionCity);
/*     */             
/* 222 */             if (a > 0.0D) {
/* 223 */               rels++;
/* 224 */               d += a;
/*     */             } 
/*     */           } 
/* 227 */           int left = 20;
/* 228 */           int x = this.body.x1();
/* 229 */           for (Religion re : RELIGIONS.ALL()) {
/* 230 */             double a = WikiRace.this.race.bvalue(re.conversionCity);
/* 231 */             if (a > 0.0D) {
/* 232 */               rels--;
/* 233 */               double am = (int)Math.ceil(20.0D * a / d);
/* 234 */               if (left - am < rels) {
/* 235 */                 am = (left - rels);
/*     */               }
/*     */               
/* 238 */               for (int i = 0; i < am; i++) {
/* 239 */                 re.icon.render(r, x, this.body.y1());
/* 240 */                 x += 32;
/* 241 */                 left--;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 252 */           GBox b = (GBox)text;
/* 253 */           for (Religion re : RELIGIONS.ALL()) {
/* 254 */             b.add((SPRITE)re.icon);
/* 255 */             b.add((SPRITE)GFORMAT.f1(b.text(), WikiRace.this.race.bvalue(re.conversionCity)));
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 261 */     guiSection1.addRelBody(0, DIR.S, (RENDEROBJ)hoverableAbs);
/* 262 */     rows.add(guiSection1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 267 */     rows.add(seperator(((STATS.FOOD()).FOOD_PREFFERENCE.info()).name, ((STATS.FOOD()).FOOD_PREFFERENCE.info()).desc, width));
/* 268 */     guiSection1 = new GuiSection();
/* 269 */     for (ResG r : (this.race.pref()).food) {
/* 270 */       guiSection1.addRightC(8, (RENDEROBJ)(new HOVERABLE.Sprite((SPRITE)r.resource.icon())).hoverTitleSet(r.resource.name).hoverInfoSet(r.resource.desc));
/*     */     }
/* 272 */     guiSection1.pad((width - guiSection1.body().width()) / 2, 0);
/* 273 */     rows.add(guiSection1);
/*     */ 
/*     */ 
/*     */     
/* 277 */     rows.add(seperator(((STATS.FOOD()).DRINK_PREFFERENCE.info()).name, ((STATS.FOOD()).DRINK_PREFFERENCE.info()).desc, width));
/* 278 */     guiSection1 = new GuiSection();
/* 279 */     for (ResG r : (this.race.pref()).drink) {
/* 280 */       guiSection1.addRightC(8, (RENDEROBJ)(new HOVERABLE.Sprite((SPRITE)r.resource.icon())).hoverTitleSet(r.resource.name).hoverInfoSet(r.resource.desc));
/*     */     }
/* 282 */     guiSection1.pad((width - guiSection1.body().width()) / 2, 0);
/* 283 */     rows.add(guiSection1);
/*     */ 
/*     */ 
/*     */     
/* 287 */     rows.add(seperator(((STATS.ENV()).BUILDING_PREF.info()).name, ((STATS.ENV()).BUILDING_PREF.info()).desc, width));
/*     */     
/* 289 */     LinkedList<RENDEROBJ> linkedList1 = new LinkedList();
/*     */     
/* 291 */     for (BUILDING_PREF bUILDING_PREF : BUILDING_PREFS.ALL()) {
/* 292 */       linkedList1.add((new RGauge(bUILDING_PREF.icon())
/*     */           {
/*     */             
/*     */             double getValue()
/*     */             {
/* 297 */               return WikiRace.this.race.pref().structure(b);
/*     */             }
/*     */ 
/*     */             
/*     */             SPRITE get(double value) {
/* 302 */               return (SPRITE)(SPRITES.icons()).s.arrowUp;
/*     */             }
/*     */ 
/*     */             
/*     */             COLOR color(double value) {
/* 307 */               return (GCOLOR.UI()).GOOD.normal;
/*     */             }
/* 309 */           }).hoverTitleSet(bUILDING_PREF.name));
/*     */     } 
/*     */     
/* 312 */     RGauge.add((LISTE<RENDEROBJ>)rows, (LIST<RENDEROBJ>)linkedList1);
/*     */ 
/*     */ 
/*     */     
/* 316 */     rows.add(seperator(((STATS.ENV()).POOL_PREF.info()).name, ((STATS.ENV()).POOL_PREF.info()).desc, width));
/*     */     
/* 318 */     linkedList1 = new LinkedList();
/*     */     
/* 320 */     for (ROOM_POOL rOOM_POOL : (SETT.ROOMS()).POOLS) {
/* 321 */       linkedList1.add((new RGauge((SPRITE)rOOM_POOL.icon)
/*     */           {
/*     */             
/*     */             double getValue()
/*     */             {
/* 326 */               return WikiRace.this.race.pref().pool(b);
/*     */             }
/*     */ 
/*     */             
/*     */             SPRITE get(double value) {
/* 331 */               return (SPRITE)(SPRITES.icons()).s.arrowUp;
/*     */             }
/*     */ 
/*     */             
/*     */             COLOR color(double value) {
/* 336 */               return (GCOLOR.UI()).GOOD.normal;
/*     */             }
/* 338 */           }).hoverTitleSet(rOOM_POOL.info.names));
/*     */     } 
/*     */     
/* 341 */     RGauge.add((LISTE<RENDEROBJ>)rows, (LIST<RENDEROBJ>)linkedList1);
/*     */ 
/*     */ 
/*     */     
/* 345 */     rows.add(seperator(((STATS.ENV()).ROAD_PREF.info()).name, ((STATS.ENV()).ROAD_PREF.info()).desc, width));
/*     */     
/* 347 */     linkedList1 = new LinkedList();
/*     */     
/* 349 */     for (Floors.Floor floor : (SETT.FLOOR()).roads) {
/* 350 */       linkedList1.add((new RGauge((SPRITE)floor.getIcon())
/*     */           {
/*     */             double getValue()
/*     */             {
/* 354 */               return b.pref(WikiRace.this.race);
/*     */             }
/*     */ 
/*     */             
/*     */             SPRITE get(double value) {
/* 359 */               return (SPRITE)(SPRITES.icons()).s.arrowUp;
/*     */             }
/*     */ 
/*     */             
/*     */             COLOR color(double value) {
/* 364 */               return (GCOLOR.UI()).GOOD.normal;
/*     */             }
/* 366 */           }).hoverTitleSet(floor.name));
/*     */     } 
/*     */     
/* 369 */     RGauge.add((LISTE<RENDEROBJ>)rows, (LIST<RENDEROBJ>)linkedList1);
/*     */ 
/*     */ 
/*     */     
/* 373 */     rows.add(seperator(((STATS.HOME()).materials.info()).name, ((STATS.HOME()).materials.info()).desc, width));
/*     */     
/* 375 */     for (HCLASS cl : HCLASSES.ALL()) {
/* 376 */       if (!cl.player) {
/*     */         continue;
/*     */       }
/* 379 */       GuiSection r = new GuiSection();
/*     */ 
/*     */       
/* 382 */       for (RES_AMOUNT ra : this.race.home().clas(cl).resources()) {
/* 383 */         r.addRightC(4, (RENDEROBJ)new HOVERABLE.Sprite((SPRITE)ra.resource().icon())
/*     */             {
/*     */               public void hoverInfoGet(GUI_BOX text)
/*     */               {
/* 387 */                 GBox b = (GBox)text;
/* 388 */                 b.title((ra.resource()).name);
/* 389 */                 b.add((SPRITE)GFORMAT.i(b.text(), ra.amount()));
/*     */               }
/*     */             });
/*     */       } 
/*     */       
/* 394 */       r.addRelBody(48, DIR.W, (RENDEROBJ)new HOVERABLE.Sprite((SPRITE)cl.icon())
/*     */           {
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 397 */               text.title(cl.names);
/*     */             }
/*     */           });
/* 400 */       r.body().setWidth(width);
/* 401 */       r.pad(0, 4);
/*     */ 
/*     */       
/* 404 */       rows.add(r);
/*     */       
/* 406 */       r.padX(120, 0);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 411 */     rows.add(seperator(¤¤liking, ¤¤likingD, width));
/* 412 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/* 415 */           super.render(r, ds);
/* 416 */           COLOR.WHITE25.render(r, body().x1(), body().x2(), body().y2() - 1, body().y2());
/*     */         }
/*     */       };
/* 419 */     s.body().setWidth(width);
/* 420 */     int i = 0;
/*     */ 
/*     */ 
/*     */     
/* 424 */     LIST<STAT> lll = STATS.createThoseThatMatters(null);
/* 425 */     STAT[] ll = new STAT[lll.size()]; int k;
/* 426 */     for (k = 0; k < ll.length; k++) {
/* 427 */       ll[k] = (STAT)lll.get(k);
/*     */     }
/* 429 */     Arrays.sort(ll, new Comparator<STAT>()
/*     */         {
/*     */           public int compare(STAT o1, STAT o2)
/*     */           {
/* 433 */             return Dictionary.compare((o1.info()).name, (o2.info()).name);
/*     */           }
/*     */         });
/*     */     
/*     */     STAT[] arrayOfSTAT1;
/*     */     
/* 439 */     for (int m = (arrayOfSTAT1 = ll).length; k < m; ) { final STAT ss = arrayOfSTAT1[k];
/* 440 */       if (ss.key() != null && ss.key().length() != 0) {
/*     */ 
/*     */ 
/*     */         
/* 444 */         SPRITE.Imp imp = new SPRITE.Imp(80, 16)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */             {
/* 448 */               double d = ss.standing().normalized(HCLASSES.CITIZEN(), WikiRace.this.race);
/* 449 */               Icons.S.IconS iconS = (ss.standing().definition(WikiRace.this.race)).inverted ? (SPRITES.icons()).s.arrowDown : (SPRITES.icons()).s.arrowUp;
/* 450 */               COLOR c = (ss.standing().definition(WikiRace.this.race)).inverted ? (GCOLOR.UI()).BAD.normal : (GCOLOR.UI()).GOOD.normal;
/* 451 */               c.bind();
/* 452 */               int am = (int)Math.ceil(6.0D * d);
/* 453 */               for (int i = 0; i < am; i++) {
/* 454 */                 iconS.render(r, X1 + 10 * i, Y1);
/*     */               }
/*     */             }
/*     */           };
/* 458 */         GText hh = new GText((UI.FONT()).S, (ss.info()).name);
/* 459 */         hh.color((GCOLOR.T()).INACTIVE);
/* 460 */         for (HCLASS cl : HCLASSES.ALL()) {
/* 461 */           if (cl.player && 
/* 462 */             (ss.standing().definition(this.race).get(cl)).max > 0.0D) {
/* 463 */             hh.lablifySub();
/*     */           }
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 469 */         GHeader h = (new GHeader.HeaderHorizontal((ss.info()).name, (SPRITE)imp, 180)
/*     */           {
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 472 */               GBox b = (GBox)text;
/* 473 */               b.title((ss.info()).name);
/* 474 */               b.text((ss.info()).desc);
/* 475 */               b.NL(8);
/*     */               
/* 477 */               boolean liked = false;
/* 478 */               boolean dislikes = false;
/* 479 */               for (HCLASS cl : HCLASSES.ALL()) {
/* 480 */                 if (cl.player && 
/* 481 */                   (ss.standing().definition(WikiRace.this.race).get(cl)).max > 0.0D) {
/* 482 */                   if ((ss.standing().definition(WikiRace.this.race)).inverted) {
/* 483 */                     dislikes = true; continue;
/*     */                   } 
/* 485 */                   liked = true;
/*     */                 } 
/*     */               } 
/*     */ 
/*     */               
/* 490 */               if (liked && dislikes) {
/* 491 */                 b.text(WikiRace.¤¤Mixed);
/* 492 */               } else if (liked) {
/* 493 */                 b.text(WikiRace.¤¤Likes);
/* 494 */               } else if (dislikes) {
/* 495 */                 b.text(WikiRace.¤¤Dislikes);
/*     */               } else {
/* 497 */                 b.text(WikiRace.¤¤DontCare);
/*     */               } 
/*     */               
/* 500 */               b.NL(8);
/*     */               
/* 502 */               b.textLL(((STANDINGS.CITIZEN()).fullfillment.info()).name);
/* 503 */               b.NL();
/* 504 */               for (HCLASS cl : HCLASSES.ALL()) {
/* 505 */                 if (cl.player) {
/* 506 */                   b.textLL(cl.names);
/* 507 */                   b.tab(4);
/* 508 */                   b.add((SPRITE)GFORMAT.f0(b.text(), (ss.standing().definition(WikiRace.this.race)).inverted ? -(ss.standing().definition(WikiRace.this.race).get(cl)).max : (ss.standing().definition(WikiRace.this.race).get(cl)).max));
/* 509 */                   b.NL();
/*     */                 } 
/*     */               } 
/*     */             }
/* 513 */           }).subify();
/* 514 */         h.hoverInfoSet((ss.info()).desc);
/*     */ 
/*     */         
/* 517 */         s.add((RENDEROBJ)h, i * 300, 0);
/*     */         
/* 519 */         i++;
/* 520 */         if (i > 1) {
/* 521 */           i = 0;
/* 522 */           s.body().incrH(1.0D);
/* 523 */           rows.add(s);
/* 524 */           s = new GuiSection()
/*     */             {
/*     */               public void render(SPRITE_RENDERER r, float ds) {
/* 527 */                 super.render(r, ds);
/* 528 */                 COLOR.WHITE25.render(r, body().x1(), body().x2(), body().y2() - 1, body().y2());
/*     */               }
/*     */             };
/* 531 */           s.body().setWidth(width);
/*     */         } 
/*     */       }  k++; }
/* 534 */      if (i != 0) {
/* 535 */       s.body().incrH(1.0D);
/* 536 */       rows.add(s);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 543 */     int max = 7;
/*     */     
/* 545 */     LIST<BoostableCat> li = BOOSTABLES.colls().join((Object[])new BoostableCat[] { NEEDS.bCat() });
/*     */     
/* 547 */     for (BoostableCat coll : li) {
/* 548 */       if (coll == BOOSTABLES.ROOMS()) {
/*     */         continue;
/*     */       }
/* 551 */       rows.add(seperator(coll.name, null, width));
/*     */       
/* 553 */       GuiSection guiSection = null;
/* 554 */       int n = 0;
/* 555 */       for (Boostable boostable : coll.all()) {
/* 556 */         if (n == 0) {
/* 557 */           guiSection = new GuiSection();
/* 558 */           rows.add(guiSection);
/*     */         } 
/*     */         
/* 561 */         guiSection.addRightC(64, (RENDEROBJ)(new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 565 */                 double bb = WikiRace.this.race.bvalue(b);
/* 566 */                 GFORMAT.f(text, bb);
/* 567 */                 if (bb > 1.0D) {
/* 568 */                   text.color((GCOLOR.T()).IGREAT);
/* 569 */                 } else if (bb < 1.0D) {
/* 570 */                   text.errorify();
/*     */                 } else {
/* 572 */                   text.normalify();
/*     */                 } 
/*     */               }
/*     */               
/*     */               public void hoverInfoGet(GBox bb) {
/* 577 */                 bb.title(b.name);
/* 578 */                 bb.text(b.desc);
/*     */               }
/* 581 */             }).hh((SPRITE)boostable.icon));
/*     */ 
/*     */         
/* 584 */         n++;
/* 585 */         n %= max;
/* 586 */         if (n == 0) {
/* 587 */           guiSection.body().incrW(48.0D);
/* 588 */           guiSection.pad(4, 2);
/*     */         } 
/*     */       } 
/*     */       
/* 592 */       if (coll == BOOSTABLES.PHYSICS()) {
/*     */         
/* 594 */         final GuiSection ss = new GuiSection();
/*     */         
/* 596 */         ss.addRightC(64, (SPRITE)new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 600 */                 text.add(WikiRace.¤¤AdultAge);
/*     */                 
/* 602 */                 text.insert(0, WikiRace.this.race.physics.babyDays);
/* 603 */                 text.insert(1, WikiRace.this.race.physics.childDays);
/*     */               }
/*     */             });
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 610 */         rows.add(ss);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 619 */     rows.add(seperator(Dic.¤¤Employment, "", width));
/* 620 */     LinkedList<RENDEROBJ> ee = new LinkedList();
/*     */     
/* 622 */     for (RoomEmploymentSimple e : (SETT.ROOMS()).employment.ALLS()) {
/* 623 */       ee.add(new RoomGauge(e.blueprint(), this.race));
/*     */     }
/* 625 */     RGauge.add((LISTE<RENDEROBJ>)rows, (LIST<RENDEROBJ>)ee);
/*     */ 
/*     */ 
/*     */     
/* 629 */     GScrollRows sc = new GScrollRows((Iterable)rows, HEIGHT - 8, width + 24);
/*     */     
/* 631 */     GuiSection section = new GuiSection();
/*     */     
/* 633 */     section.add((RENDEROBJ)sc.view());
/*     */ 
/*     */     
/* 636 */     return section;
/*     */   }
/*     */   
/*     */   RENDEROBJ seperator(CharSequence name, CharSequence desc, int width) {
/* 640 */     GuiSection s = new GuiSection();
/* 641 */     s.hoverInfoSet(desc);
/* 642 */     s.body().setWidth((width - 8));
/* 643 */     s.body().setHeight(16.0D);
/* 644 */     GHeader t = new GHeader(name);
/* 645 */     s.addDownC(0, (RENDEROBJ)t);
/* 646 */     s.pad(4);
/* 647 */     return (RENDEROBJ)s;
/*     */   }
/*     */   
/*     */   private static abstract class RGauge
/*     */     extends HOVERABLE.HoverableAbs {
/* 652 */     private int max = 5;
/*     */     
/*     */     private final SPRITE icon;
/*     */     
/*     */     public RGauge(SPRITE icon) {
/* 657 */       this.icon = icon;
/* 658 */       body().setDim(100.0D, icon.height());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 664 */       double v = getValue();
/* 665 */       this.icon.render(r, body().x1(), body().y1());
/*     */       
/* 667 */       int am = (int)Math.ceil(this.max * v);
/* 668 */       if (v > 1.0D) {
/* 669 */         am = this.max;
/* 670 */         am += CLAMP.i((int)(2.0D * v / 3.0D), 0, 1);
/*     */       } 
/*     */       
/* 673 */       int x1 = body().x1() + 32;
/*     */ 
/*     */       
/* 676 */       color(v).bind();
/* 677 */       for (int i = 0; i < am; i++) {
/* 678 */         get(v).renderCY(r, x1, body().cY());
/* 679 */         x1 += 9;
/*     */       } 
/* 681 */       COLOR.unbind();
/*     */     }
/*     */     abstract double getValue();
/*     */     abstract SPRITE get(double param1Double);
/*     */     
/*     */     COLOR color(double value) {
/* 687 */       return (GCOLOR.UI()).GOOD.normal;
/*     */     }
/*     */ 
/*     */     
/*     */     static void add(LISTE<RENDEROBJ> rows, LIST<RENDEROBJ> all) {
/* 692 */       int ri = 5;
/* 693 */       GuiSection s = null;
/*     */       
/* 695 */       for (RENDEROBJ h : all) {
/* 696 */         ri++;
/* 697 */         if (ri >= 5) {
/* 698 */           ri = 0;
/* 699 */           if (s != null)
/* 700 */             s.pad(2, 8); 
/* 701 */           s = new GuiSection();
/* 702 */           rows.add(s);
/*     */         } 
/* 704 */         s.addRightC(16, h);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class RoomGauge
/*     */     extends HOVERABLE.HoverableAbs
/*     */   {
/*     */     private final RoomBlueprintIns<?> blue;
/*     */     
/*     */     private final Race race;
/*     */     
/*     */     public RoomGauge(RoomBlueprintIns<?> blue, Race race) {
/* 718 */       this.blue = blue;
/* 719 */       body().setDim(100.0D, 32.0D);
/* 720 */       this.race = race;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 726 */       this.blue.iconBig().render(r, body().x1(), body().y1());
/*     */       
/* 728 */       int x1 = body().x1() + 32;
/*     */       
/* 730 */       double ww = this.race.pref().getWork(this.blue.employment());
/* 731 */       GMeter.GMeterCol cc = GMeter.C_REDGREEN;
/* 732 */       if (ww > 1.0D) {
/* 733 */         cc = GMeter.C_BLUE;
/* 734 */       } else if (ww < 0.0D) {
/* 735 */         cc = GMeter.C_RED;
/* 736 */         ww = -ww;
/*     */       } 
/*     */       
/* 739 */       GMeter.render(r, cc, ww, x1, body().x2() - 8, body().y1(), body().y1() + 10);
/*     */ 
/*     */ 
/*     */       
/* 743 */       double b = 1.0D;
/*     */       
/* 745 */       if (this.blue.bonus() != null) {
/* 746 */         b = 1.0D + this.race.bvalue(this.blue.bonus()) - (this.blue.bonus()).baseValue;
/* 747 */         b = CLAMP.d(b, 0.0D, 2.0D);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 752 */       int am = 0;
/* 753 */       COLOR c = (GCOLOR.UI()).NEUTRAL.hovered;
/* 754 */       Icons.S.IconS iconS = (SPRITES.icons()).s.arrowUp;
/* 755 */       if (b < 1.0D) {
/* 756 */         c = (GCOLOR.UI()).BAD.normal;
/* 757 */         am = (int)((1.0D - b) * 7.0D);
/* 758 */         iconS = (SPRITES.icons()).s.arrowDown;
/* 759 */       } else if (b > 1.0D) {
/* 760 */         c = (GCOLOR.UI()).GREAT.normal;
/* 761 */         am = CLAMP.i(1 + (int)((b - 1.0D) * 6.0D), 0, 7);
/*     */       } 
/*     */ 
/*     */       
/* 765 */       int cy = body().cY() + 8;
/*     */       
/* 767 */       COLOR.WHITE15.render(r, x1, x1 + 63 + 2, cy - 8, cy + 8);
/*     */       
/* 769 */       c.bind();
/* 770 */       for (int i = 0; i < am; i++) {
/* 771 */         iconS.renderCY(r, x1, cy);
/* 772 */         x1 += 9;
/*     */       } 
/* 774 */       COLOR.unbind();
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 779 */       GBox b = (GBox)text;
/* 780 */       b.title(this.blue.info.names);
/* 781 */       b.text(this.blue.info.desc);
/* 782 */       b.NL(8);
/*     */       
/* 784 */       b.textL(((STANDINGS.CITIZEN()).fullfillment.info()).name);
/* 785 */       b.tab(5);
/* 786 */       b.add((SPRITE)GFORMAT.perc(b.text(), this.race.pref().getWork(this.blue.employment())));
/* 787 */       b.NL();
/*     */       
/* 789 */       int rr = 0;
/* 790 */       for (Race r : RACES.all()) {
/* 791 */         if (r == this.race)
/*     */           continue; 
/* 793 */         b.add((SPRITE)(r.appearance()).icon);
/* 794 */         b.add((SPRITE)GFORMAT.perc(b.text(), r.pref().getWork(this.blue.employment())));
/* 795 */         b.space();
/* 796 */         rr++;
/* 797 */         if (rr > 6) {
/* 798 */           b.NL();
/* 799 */           rr = 0;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 804 */       b.sep();
/* 805 */       b.textL(Dic.¤¤Skill);
/* 806 */       b.tab(5);
/* 807 */       double add = 1.0D;
/* 808 */       if (this.blue.bonus() != null) {
/* 809 */         add = this.race.bvalue(this.blue.bonus());
/*     */       }
/*     */       
/* 812 */       b.add((SPRITE)GFORMAT.perc(b.text(), add));
/* 813 */       b.NL();
/*     */       
/* 815 */       int i = 0;
/* 816 */       for (Race r : RACES.all()) {
/* 817 */         if (r == this.race)
/*     */           continue; 
/* 819 */         b.add((SPRITE)(r.appearance()).icon);
/* 820 */         double ad = 1.0D;
/* 821 */         if (this.blue.bonus() != null) {
/* 822 */           ad = r.bvalue(this.blue.bonus());
/*     */         }
/*     */         
/* 825 */         b.add((SPRITE)GFORMAT.perc(b.text(), ad));
/* 826 */         b.space();
/* 827 */         i++;
/* 828 */         if (i > 6) {
/* 829 */           b.NL();
/* 830 */           i = 0;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 839 */       super.hoverInfoGet(text);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\wiki\WikiRace.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */