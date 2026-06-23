/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.util.RESOURCE_TILE;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*     */ import settlement.room.industry.module.consumption.RoomConsumptionAbs;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEmploymentIns;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GChart;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.statistics.HISTORY;
/*     */ import util.statistics.HISTORY_INT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public final class ModuleIndustry
/*     */   implements Modules.ModuleMaker {
/*  61 */   private final GChart chart = new GChart();
/*  62 */   private final boolean[] rCheck = new boolean[RESOURCES.ALL().size()];
/*  63 */   private final boolean[] rHas = new boolean[RESOURCES.ALL().size()];
/*  64 */   private static CharSequence ¤¤Production = "¤Production";
/*  65 */   private static CharSequence ¤¤ProductionDesc = "¤The amount that is estimated to be produced each day. The actual production can vary greatly depending on a number of factors.";
/*  66 */   private static CharSequence ¤¤Consumption = "¤Consumption";
/*  67 */   private static CharSequence ¤¤ConsumptionD = "¤Estimation of how many resources are consumed each day.";
/*  68 */   private static CharSequence ¤¤Recipes = "¤Change Recipe";
/*  69 */   private static CharSequence ¤¤RecipesWarning = "¤Note that changing recipe will reset the room.";
/*     */   
/*  71 */   private static CharSequence ¤¤ProducedDay = "¤Produced today";
/*  72 */   private static CharSequence ¤¤ProducedYesterDay = "¤Produced yesterday";
/*  73 */   private static CharSequence ¤¤ProducedNow = "¤Produced This Year";
/*  74 */   private static CharSequence ¤¤ProducedEstimate = "¤Estimated this year";
/*  75 */   private static CharSequence ¤¤ProducedPrevious = "¤Produced last year";
/*     */   
/*  77 */   private static CharSequence ¤¤ConsumedDay = "¤Consumed today";
/*  78 */   private static CharSequence ¤¤ConsumedNow = "¤Consumed This Year";
/*  79 */   private static CharSequence ¤¤ConsumedYEsterday = "¤Consumed Yesterday";
/*  80 */   private static CharSequence ¤¤ConsumedPrevious = "¤Consumed last year";
/*     */   
/*  82 */   private static CharSequence ¤¤FetchWarning = "¤Proximity to raw materials is poor.";
/*     */   
/*  84 */   private static CharSequence ¤¤NoStore = "¤Internal storage is full and production is stalled. Have a warehouse fetch the produce.";
/*     */   
/*     */   public ModuleIndustry(Init init) {
/*  87 */     D.t(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void make(RoomBlueprint p, LISTE<UIRoomModule> l) {
/*  93 */     if (p instanceof INDUSTRY_HASER) {
/*  94 */       INDUSTRY_HASER blue = (INDUSTRY_HASER)p;
/*  95 */       if (!blue.industryIgnoreUI())
/*  96 */         l.add(new I((RoomBlueprintIns)p, blue.industries())); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private final class I
/*     */     extends UIRoomModule
/*     */   {
/*     */     private final LIST<Industry> ins;
/*     */     private final INDUSTRY_HASER indu;
/* 105 */     private final RBIT.RBITImp m = new RBIT.RBITImp();
/*     */     I(RoomBlueprintIns<?> blue, LIST<Industry> ins) {
/* 107 */       this.ins = ins;
/* 108 */       this.indu = (INDUSTRY_HASER)blue;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void appendManageScr(GGrid grid, GGrid r, GuiSection sExta) {
/* 115 */       int y1 = r.section.body().y2() + 32;
/*     */       
/* 117 */       LinkedList<RESOURCE> ress = new LinkedList();
/* 118 */       this.m.clear();
/* 119 */       for (Industry i : this.ins) {
/* 120 */         for (IndustryResource res : i.outs()) {
/* 121 */           if (!this.m.has(res.resource)) {
/* 122 */             ress.add(res.resource);
/* 123 */             this.m.or(res.resource);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 129 */       if (ress.size() > 0) {
/*     */         
/* 131 */         r.section.add((RENDEROBJ)new GHeader(ModuleIndustry.¤¤Production), r.section.body().x1(), y1);
/* 132 */         GuiSection ins = new GuiSection();
/*     */         
/* 134 */         int ri = 0;
/* 135 */         for (RESOURCE res : ress) {
/* 136 */           final IndustryResource[] os = resourcesOut(res);
/* 137 */           if (os == null)
/*     */             continue; 
/* 139 */           GStat s = new GStat()
/*     */             {
/*     */               public void update(GText text) {
/* 142 */                 int am = 0; byte b; int i; IndustryResource[] arrayOfIndustryResource;
/* 143 */                 for (i = (arrayOfIndustryResource = os).length, b = 0; b < i; ) { IndustryResource r = arrayOfIndustryResource[b];
/* 144 */                   am += r.history().getPeriodSum(-((int)TIME.years().bitConversion((TIMECYCLE)TIME.days())), 0); b++; }
/* 145 */                  GFORMAT.iIncr(text, am);
/*     */               }
/*     */             };
/* 148 */           final HISTORY_INT hi = new HISTORY_INT()
/*     */             {
/*     */               public TIMECYCLE time()
/*     */               {
/* 152 */                 return os[0].history().time();
/*     */               }
/*     */ 
/*     */               
/*     */               public int historyRecords() {
/* 157 */                 return os[0].history().historyRecords();
/*     */               }
/*     */ 
/*     */               
/*     */               public double getD(int fromZero) {
/* 162 */                 return get(fromZero) / max();
/*     */               }
/*     */ 
/*     */               
/*     */               public int min() {
/* 167 */                 return os[0].history().min();
/*     */               }
/*     */ 
/*     */               
/*     */               public int max() {
/* 172 */                 return os[0].history().max();
/*     */               }
/*     */ 
/*     */               
/*     */               public int get(int fromZero) {
/* 177 */                 int am = 0; byte b; int i; IndustryResource[] arrayOfIndustryResource;
/* 178 */                 for (i = (arrayOfIndustryResource = os).length, b = 0; b < i; ) { IndustryResource industryResource = arrayOfIndustryResource[b];
/* 179 */                   am += industryResource.history().get(fromZero); b++; }
/* 180 */                  return am;
/*     */               }
/*     */             };
/*     */           
/* 184 */           ins.add((RENDEROBJ)new GHeader.HeaderHorizontal((SPRITE)res.icon(), (SPRITE)s)
/*     */               {
/*     */                 public void hoverInfoGet(GUI_BOX text) {
/* 187 */                   GBox b = (GBox)text;
/*     */                   
/* 189 */                   b.title(res.name);
/* 190 */                   b.add((SPRITE)text.text().add(ModuleIndustry.¤¤Production).s().add('(').add(Dic.¤¤Total).add(')'));
/* 191 */                   b.NL(4);
/*     */                   
/* 193 */                   b.textLL(ModuleIndustry.¤¤ProducedDay);
/* 194 */                   b.tab(7);
/* 195 */                   b.add((SPRITE)GFORMAT.i(b.text(), hi.get(0)));
/* 196 */                   b.NL();
/*     */                   
/* 198 */                   b.textLL(ModuleIndustry.¤¤ProducedYesterDay);
/* 199 */                   b.tab(7);
/* 200 */                   b.add((SPRITE)GFORMAT.i(b.text(), hi.get(1)));
/* 201 */                   b.NL();
/*     */                   
/* 203 */                   int yearStart = (int)(-TIME.days().bitOfYear() * TIME.years().bitConversion((TIMECYCLE)TIME.years()));
/*     */                   
/* 205 */                   b.textLL(ModuleIndustry.¤¤ProducedNow);
/* 206 */                   b.tab(7);
/* 207 */                   b.add((SPRITE)GFORMAT.i(b.text(), hi.getPeriodSum(yearStart, 0)));
/* 208 */                   b.NL();
/*     */                   
/* 210 */                   b.textLL(ModuleIndustry.¤¤ProducedPrevious);
/* 211 */                   b.tab(7);
/* 212 */                   b.add((SPRITE)GFORMAT.i(b.text(), hi.getPeriodSum(-yearStart - (int)TIME.years().bitConversion((TIMECYCLE)TIME.days()), -yearStart)));
/* 213 */                   b.NL();
/*     */                   
/* 215 */                   b.NL(8);
/* 216 */                   b.textLL(DicTime.¤¤Days);
/* 217 */                   (ModuleIndustry.I.access$0(ModuleIndustry.I.this)).chart.clear();
/* 218 */                   (ModuleIndustry.I.access$0(ModuleIndustry.I.this)).chart.add((HISTORY)hi);
/* 219 */                   text.NL();
/* 220 */                   text.add((ModuleIndustry.I.access$0(ModuleIndustry.I.this)).chart.sprite);
/*     */                 }
/* 222 */               }ri % 3 * 96, ri / 3 * 26);
/* 223 */           ri++;
/*     */         } 
/*     */         
/* 226 */         r.section.addDown(2, (RENDEROBJ)ins);
/* 227 */         y1 = r.section.body().y2() + 4;
/*     */       } 
/*     */       
/* 230 */       ress = new LinkedList();
/* 231 */       this.m.clear();
/* 232 */       for (Industry i : this.ins) {
/* 233 */         for (IndustryResource res : i.ins()) {
/* 234 */           if (!this.m.has(res.resource)) {
/* 235 */             ress.add(res.resource);
/* 236 */             this.m.or(res.resource);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 243 */       if (ress.size() > 0) {
/*     */ 
/*     */         
/* 246 */         GuiSection ins = new GuiSection();
/*     */         
/* 248 */         int ri = 0;
/* 249 */         for (RESOURCE res : ress) {
/* 250 */           final IndustryResource[] os = resourcesIn(res);
/* 251 */           if (os == null) {
/*     */             continue;
/*     */           }
/* 254 */           final HISTORY_INT hi = new HISTORY_INT()
/*     */             {
/*     */               public TIMECYCLE time()
/*     */               {
/* 258 */                 return os[0].history().time();
/*     */               }
/*     */ 
/*     */               
/*     */               public int historyRecords() {
/* 263 */                 return os[0].history().historyRecords();
/*     */               }
/*     */ 
/*     */               
/*     */               public double getD(int fromZero) {
/* 268 */                 return get(fromZero) / max();
/*     */               }
/*     */ 
/*     */               
/*     */               public int min() {
/* 273 */                 return os[0].history().min();
/*     */               }
/*     */ 
/*     */               
/*     */               public int max() {
/* 278 */                 return os[0].history().max();
/*     */               }
/*     */ 
/*     */               
/*     */               public int get(int fromZero) {
/* 283 */                 int am = 0; byte b; int i; IndustryResource[] arrayOfIndustryResource;
/* 284 */                 for (i = (arrayOfIndustryResource = os).length, b = 0; b < i; ) { IndustryResource industryResource = arrayOfIndustryResource[b];
/* 285 */                   am += industryResource.history().get(fromZero); b++; }
/* 286 */                  return am;
/*     */               }
/*     */             };
/*     */           
/* 290 */           GStat s = new GStat()
/*     */             {
/*     */               public void update(GText text) {
/* 293 */                 int am = hi.getPeriodSum(-((int)TIME.years().bitConversion((TIMECYCLE)TIME.days())), 0);
/* 294 */                 GFORMAT.iIncr(text, -am);
/*     */               }
/*     */             };
/*     */           
/* 298 */           ins.add((RENDEROBJ)new GHeader.HeaderHorizontal((SPRITE)res.icon(), (SPRITE)s)
/*     */               {
/*     */                 public void hoverInfoGet(GUI_BOX text)
/*     */                 {
/* 302 */                   GBox b = (GBox)text;
/*     */                   
/* 304 */                   b.title(res.name);
/* 305 */                   b.add((SPRITE)text.text().add(ModuleIndustry.¤¤Consumption).s().add('(').add(Dic.¤¤Total).add(')'));
/* 306 */                   b.NL(4);
/*     */                   
/* 308 */                   b.textLL(ModuleIndustry.¤¤ConsumedDay);
/* 309 */                   b.tab(7);
/* 310 */                   b.add((SPRITE)GFORMAT.i(b.text(), hi.get(0)));
/* 311 */                   b.NL();
/*     */                   
/* 313 */                   b.textLL(ModuleIndustry.¤¤ConsumedYEsterday);
/* 314 */                   b.tab(7);
/* 315 */                   b.add((SPRITE)GFORMAT.i(b.text(), hi.get(1)));
/* 316 */                   b.NL();
/*     */                   
/* 318 */                   int yearStart = (int)(-TIME.days().bitOfYear() * TIME.years().bitConversion((TIMECYCLE)TIME.years()));
/*     */                   
/* 320 */                   b.textLL(ModuleIndustry.¤¤ConsumedNow);
/* 321 */                   b.tab(7);
/* 322 */                   b.add((SPRITE)GFORMAT.i(b.text(), hi.getPeriodSum(-yearStart, 0)));
/* 323 */                   b.NL();
/*     */ 
/*     */ 
/*     */                   
/* 327 */                   b.textLL(ModuleIndustry.¤¤ConsumedPrevious);
/* 328 */                   b.tab(7);
/* 329 */                   b.add((SPRITE)GFORMAT.i(b.text(), hi.getPeriodSum(-((int)TIME.years().bitConversion((TIMECYCLE)TIME.days())) - yearStart, -yearStart)));
/* 330 */                   b.NL();
/*     */                   
/* 332 */                   b.NL(8);
/* 333 */                   b.textLL(DicTime.¤¤Days);
/* 334 */                   (ModuleIndustry.I.access$0(ModuleIndustry.I.this)).chart.clear();
/* 335 */                   (ModuleIndustry.I.access$0(ModuleIndustry.I.this)).chart.add((HISTORY)hi);
/* 336 */                   text.NL();
/* 337 */                   text.add((ModuleIndustry.I.access$0(ModuleIndustry.I.this)).chart.sprite);
/*     */                 }
/* 340 */               }ri % 3 * 90, ri / 3 * 26);
/* 341 */           ri++;
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 346 */         if (ress.size() == 1) {
/* 347 */           GuiSection fuckifuck = new GuiSection();
/* 348 */           fuckifuck.add((RENDEROBJ)new GHeader(ModuleIndustry.¤¤Consumption));
/* 349 */           fuckifuck.addRightC(8, (RENDEROBJ)ins);
/* 350 */           r.section.add((RENDEROBJ)fuckifuck, r.section.body().x1(), y1);
/*     */         } else {
/* 352 */           r.section.add((RENDEROBJ)new GHeader(ModuleIndustry.¤¤Consumption), r.section.body().x1(), y1);
/* 353 */           r.section.addDown(2, (RENDEROBJ)ins);
/*     */         } 
/*     */         
/* 356 */         y1 = r.section.body().y2() + 4;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private IndustryResource[] resourcesOut(RESOURCE res) {
/* 362 */       int am = 0;
/* 363 */       for (Industry i : this.ins) {
/* 364 */         for (IndustryResource r : i.outs()) {
/* 365 */           if (r.resource == res)
/* 366 */             am++; 
/*     */         } 
/*     */       } 
/* 369 */       if (am == 0)
/* 370 */         return null; 
/* 371 */       IndustryResource[] o = new IndustryResource[am];
/* 372 */       am = 0;
/* 373 */       for (Industry i : this.ins) {
/* 374 */         for (IndustryResource r : i.outs()) {
/* 375 */           if (r.resource == res)
/* 376 */             o[am++] = r; 
/*     */         } 
/*     */       } 
/* 379 */       return o;
/*     */     }
/*     */     
/*     */     private IndustryResource[] resourcesIn(RESOURCE res) {
/* 383 */       int am = 0;
/* 384 */       for (Industry i : this.ins) {
/* 385 */         for (IndustryResource r : i.ins()) {
/* 386 */           if (r.resource == res)
/* 387 */             am++; 
/*     */         } 
/*     */       } 
/* 390 */       if (am == 0)
/* 391 */         return null; 
/* 392 */       IndustryResource[] o = new IndustryResource[am];
/* 393 */       am = 0;
/* 394 */       for (Industry i : this.ins) {
/* 395 */         for (IndustryResource r : i.ins()) {
/* 396 */           if (r.resource == res)
/* 397 */             o[am++] = r; 
/*     */         } 
/*     */       } 
/* 400 */       return o;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void hover(GBox box, Room room, int rx, int ry) {
/* 411 */       ROOM_PRODUCER_INSTANCE p = (ROOM_PRODUCER_INSTANCE)room;
/* 412 */       box.NL();
/* 413 */       int t = 0;
/* 414 */       for (IndustryResource i : p.industry().outs()) {
/*     */         
/* 416 */         box.tab(t * 3);
/* 417 */         box.add((i.resource.icon()).small);
/* 418 */         GText te = box.text();
/* 419 */         this.indu.industryFormatProductionRate(te, i, (RoomInstance)room);
/* 420 */         box.add((SPRITE)te);
/* 421 */         t++;
/* 422 */         if (t == 3) {
/* 423 */           t = 0;
/* 424 */           box.NL();
/*     */         } 
/*     */       } 
/*     */       
/* 428 */       box.NL(8);
/*     */       
/* 430 */       for (IndustryResource i : p.industry().ins()) {
/*     */         
/* 432 */         box.tab(t * 3);
/* 433 */         box.add((i.resource.icon()).small);
/* 434 */         GText te = box.text();
/* 435 */         this.indu.industryFormatConsumptionRate(te, i, (RoomInstance)room);
/* 436 */         box.add((SPRITE)te);
/* 437 */         t++;
/* 438 */         if (t == 3) {
/* 439 */           t = 0;
/* 440 */           box.NL();
/*     */         } 
/*     */       } 
/*     */       
/* 444 */       box.NL(8);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void problem(Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings, Room rr, int rx, int ry) {
/* 450 */       ROOM_PRODUCER_INSTANCE p = (ROOM_PRODUCER_INSTANCE)rr;
/* 451 */       if (p.industry().outs().size() == 0) {
/*     */         return;
/*     */       }
/* 454 */       RoomInstance room = (RoomInstance)rr;
/*     */       
/* 456 */       Arrays.fill(ModuleIndustry.this.rCheck, false);
/* 457 */       Arrays.fill(ModuleIndustry.this.rHas, false);
/* 458 */       for (COORDINATE c : room.body()) {
/* 459 */         if (room.is(c)) {
/* 460 */           RESOURCE_TILE t = room.resourceTile(c.x(), c.y());
/* 461 */           if (t != null && t.resource() != null) {
/* 462 */             ModuleIndustry.this.rCheck[t.resource().index()] = true;
/* 463 */             if (t.hasRoom()) {
/* 464 */               ModuleIndustry.this.rHas[t.resource().index()] = true;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 469 */       boolean title = false;
/*     */ 
/*     */       
/* 472 */       for (RESOURCE r : RESOURCES.ALL()) {
/* 473 */         if (ModuleIndustry.this.rCheck[r.index()] && !ModuleIndustry.this.rHas[r.index()]) {
/* 474 */           if (!title) {
/* 475 */             title = true;
/* 476 */             errors.add(ModuleIndustry.¤¤NoStore);
/*     */           } 
/* 478 */           errors.add(((Str)free.pop()).s(4).add(r.name));
/*     */         } 
/*     */       } 
/*     */       
/* 482 */       if (rr.blueprint().employment().countInput() && 
/* 483 */         room.employees().fetchProximity() < 0.8D) {
/* 484 */         warnings.add(ModuleIndustry.¤¤FetchWarning);
/*     */       }
/*     */     }
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
/*     */     public void appendPanel(GuiSection section, final GETTER<RoomInstance> get, int x1, int y1) {
/* 530 */       int resOut = 0;
/*     */       
/* 532 */       for (Industry i : this.ins) {
/* 533 */         resOut = Math.max(resOut, i.outs().size());
/*     */       }
/* 535 */       if (resOut > 0) {
/*     */         
/* 537 */         GuiSection all = new GuiSection();
/*     */         
/* 539 */         for (int rii = 0; rii < resOut; rii++) {
/* 540 */           RENDEROBJ s = ModuleIndustry.resOut(rii, get, this.indu);
/* 541 */           s.body().moveX1Y1((rii % 3 * 90), (rii / 3 * s.body().height()));
/* 542 */           all.add(s);
/*     */         } 
/*     */ 
/*     */         
/* 546 */         all.addRelBody(2, DIR.N, (RENDEROBJ)new GHeader(ModuleIndustry.¤¤Production));
/*     */         
/* 548 */         section.addRelBody(32, DIR.S, (RENDEROBJ)all);
/*     */       } 
/*     */ 
/*     */       
/* 552 */       int resIn = 0;
/*     */       
/* 554 */       for (Industry i : this.ins) {
/* 555 */         resIn = Math.max(resIn, i.ins().size());
/*     */       }
/* 557 */       if (resIn > 0) {
/* 558 */         boolean ccc = (resOut > 0);
/* 559 */         GuiSection all = new GuiSection();
/*     */         
/* 561 */         for (int rii = 0; rii < resIn; rii++) {
/* 562 */           RENDEROBJ rENDEROBJ = ModuleIndustry.resIn(rii, get, this.indu, ccc);
/* 563 */           rENDEROBJ.body().moveX1Y1((rii % 3 * 90), (rii / 3 * rENDEROBJ.body().height()));
/* 564 */           all.add(rENDEROBJ);
/*     */         } 
/*     */         
/* 567 */         RENDEROBJ in = ModuleIndustry.makeFetch(get);
/* 568 */         GuiSection s = new GuiSection();
/* 569 */         s.add((RENDEROBJ)new GHeader(ModuleIndustry.¤¤Consumption));
/* 570 */         if (((RoomBlueprint)this.indu).employment().countInput()) {
/* 571 */           s.addRightC(8, in);
/*     */         }
/* 573 */         all.addRelBody(2, DIR.N, (RENDEROBJ)s);
/*     */         
/* 575 */         section.addRelBody(4, DIR.S, (RENDEROBJ)all);
/*     */       } 
/*     */       
/* 578 */       if (this.ins.size() <= 1) {
/*     */         return;
/*     */       }
/*     */       
/* 582 */       LinkedList<RENDEROBJ> rows = new LinkedList();
/* 583 */       for (int ii = 0; ii < this.ins.size(); ii++) {
/*     */         
/* 585 */         final int k = ii;
/* 586 */         final Industry i = (Industry)this.ins.get(k);
/* 587 */         GButt.BSection b = new GButt.BSection()
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 591 */               if (i.lockable().passes(FACTIONS.player())) {
/* 592 */                 ROOM_PRODUCER_INSTANCE p = ModuleIndustry.I.this.g(get);
/* 593 */                 p.setIndustry(k);
/* 594 */                 (VIEW.inters()).popup.close();
/* 595 */                 if (ModuleIndustry.I.this.g(get) instanceof JOBMANAGER_HASER) {
/* 596 */                   JOBMANAGER_HASER j = (JOBMANAGER_HASER)ModuleIndustry.I.this.g(get);
/* 597 */                   j.getWork().resetResourceSearch();
/*     */                 } 
/*     */               } 
/* 600 */               super.clickA();
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 605 */               GBox b = (GBox)text;
/*     */               
/* 607 */               if (activeIs()) {
/* 608 */                 b.error(ModuleIndustry.¤¤RecipesWarning);
/* 609 */                 b.NL(8);
/*     */               } 
/*     */               
/* 612 */               b.textL(ModuleIndustry.¤¤Consumption);
/* 613 */               b.NL();
/* 614 */               for (IndustryResource r : i.ins())
/* 615 */                 b.text(r.resource.name); 
/* 616 */               b.NL(8);
/* 617 */               b.textL(ModuleIndustry.¤¤Production);
/* 618 */               b.NL();
/* 619 */               for (IndustryResource r : i.outs())
/* 620 */                 b.text(r.resource.name); 
/* 621 */               b.NL(8);
/*     */               
/* 623 */               i.lockable().hover(text, FACTIONS.player());
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void renAction() {
/* 629 */               activeSet(i.lockable().passes(FACTIONS.player()));
/*     */             }
/*     */           };
/*     */ 
/*     */         
/* 634 */         for (IndustryResource r : i.ins()) {
/* 635 */           b.addRightC(48, (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 639 */                   GFORMAT.f0(text, -r.rate);
/*     */                 }
/* 642 */               }).hh((SPRITE)r.resource.icon()));
/*     */         } 
/*     */         
/* 645 */         b.addRightC(48, (SPRITE)(SPRITES.icons()).m.arrow_right);
/*     */         
/* 647 */         for (IndustryResource r : i.outs()) {
/* 648 */           b.addRightC(48, (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 652 */                   GFORMAT.f0(text, r.rate);
/*     */                 }
/* 655 */               }).hh((SPRITE)r.resource.icon()));
/*     */         } 
/*     */         
/* 658 */         b.body().incrW(48.0D);
/* 659 */         b.pad(4);
/* 660 */         b.body().setWidth(450.0D);
/*     */         
/* 662 */         rows.add(b);
/*     */       } 
/*     */ 
/*     */       
/* 666 */       final CLICKABLE rr = (new GScrollRows((Iterable)rows, 400)).view();
/* 667 */       GButt.ButtPanel buttPanel = (new GButt.ButtPanel(ModuleIndustry.¤¤Recipes)
/*     */         {
/*     */           protected void clickA() {
/* 670 */             (VIEW.inters()).popup.show((RENDEROBJ)rr, (CLICKABLE)this);
/*     */           }
/* 672 */         }).pad(6, 3);
/*     */       
/* 674 */       section.addRelBody(8, DIR.S, (RENDEROBJ)buttPanel);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private ROOM_PRODUCER_INSTANCE g(GETTER<RoomInstance> g) {
/* 681 */       return (ROOM_PRODUCER_INSTANCE)g.get();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static ROOM_PRODUCER_INSTANCE g(GETTER<RoomInstance> g) {
/* 687 */     return (ROOM_PRODUCER_INSTANCE)g.get();
/*     */   }
/*     */   
/*     */   private static RENDEROBJ resIn(final int ri, final GETTER<RoomInstance> get, final INDUSTRY_HASER indu, final boolean outs) {
/* 691 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 694 */           ROOM_PRODUCER_INSTANCE p = ModuleIndustry.g(get);
/* 695 */           if (ri >= p.industry().ins().size()) {
/*     */             return;
/*     */           }
/* 698 */           IndustryResource i = (IndustryResource)p.industry().ins().get(ri);
/*     */           
/* 700 */           GBox b = (GBox)text;
/* 701 */           b.title(i.resource.name);
/*     */ 
/*     */ 
/*     */           
/* 705 */           if (outs) {
/* 706 */             b.text(ModuleIndustry.¤¤ConsumptionD);
/* 707 */             b.NL(8);
/* 708 */             IndustryUtil.hoverConsumptionRate(text, i.rate, (RoomInstance)get.get(), (RoomConsumptionAbs)p.industry());
/*     */           } 
/* 710 */           b.NL(8);
/*     */           
/* 712 */           b.textLL(ModuleIndustry.¤¤ConsumedDay);
/* 713 */           b.tab(7);
/* 714 */           b.add((SPRITE)GFORMAT.i(b.text(), (int)i.day.getD(p)));
/* 715 */           b.NL();
/*     */           
/* 717 */           b.textLL(ModuleIndustry.¤¤ConsumedYEsterday);
/* 718 */           b.tab(7);
/* 719 */           b.add((SPRITE)GFORMAT.i(b.text(), i.dayPrev.get(p)));
/* 720 */           b.NL();
/*     */           
/* 722 */           b.textLL(ModuleIndustry.¤¤ConsumedNow);
/* 723 */           b.tab(7);
/* 724 */           b.add((SPRITE)GFORMAT.i(b.text(), i.year.get(p)));
/* 725 */           b.NL();
/*     */           
/* 727 */           b.textLL(ModuleIndustry.¤¤ConsumedPrevious);
/* 728 */           b.tab(7);
/* 729 */           b.add((SPRITE)GFORMAT.i(b.text(), i.yearPrev.get(p)));
/*     */           
/* 731 */           b.NL(8);
/*     */         }
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/* 736 */           ROOM_PRODUCER_INSTANCE p = ModuleIndustry.g(get);
/* 737 */           visableSet((p.industry().ins().size() > ri));
/* 738 */           if (visableIs())
/* 739 */             super.render(r, ds); 
/*     */         }
/*     */       };
/* 742 */     s.add((RENDEROBJ)new RENDEROBJ.RenderImp(24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 746 */             ROOM_PRODUCER_INSTANCE p = ModuleIndustry.g(get);
/* 747 */             IndustryResource i = (IndustryResource)p.industry().ins().get(ri);
/* 748 */             i.resource.icon().render(r, (RECTANGLE)this.body);
/*     */           }
/*     */         });
/*     */     
/* 752 */     HOVERABLE h = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 756 */           IndustryResource i = (IndustryResource)ModuleIndustry.g(get).industry().ins().get(ri);
/* 757 */           RoomInstance ins = (RoomInstance)get.get();
/* 758 */           indu.industryFormatConsumptionRate(text, i, ins);
/*     */         }
/* 760 */       }).r();
/*     */     
/* 762 */     s.addRightC(6, (RENDEROBJ)h);
/* 763 */     s.body().incrW(48.0D);
/* 764 */     s.pad(4);
/* 765 */     return (RENDEROBJ)s;
/*     */   }
/*     */ 
/*     */   
/*     */   private static RENDEROBJ resOut(final int ri, final GETTER<RoomInstance> get, final INDUSTRY_HASER indu) {
/* 770 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 774 */           ROOM_PRODUCER_INSTANCE p = ModuleIndustry.g(get);
/* 775 */           visableSet((p.industry().outs().size() > ri));
/* 776 */           if (visableIs()) {
/* 777 */             super.render(r, ds);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 783 */           ROOM_PRODUCER_INSTANCE p = ModuleIndustry.g(get);
/* 784 */           if (ri >= p.industry().outs().size()) {
/*     */             return;
/*     */           }
/* 787 */           RoomInstance ins = (RoomInstance)get.get();
/*     */           
/* 789 */           IndustryResource i = (IndustryResource)p.industry().outs().get(ri);
/*     */           
/* 791 */           GBox b = (GBox)text;
/* 792 */           b.title(i.resource.name);
/*     */           
/* 794 */           b.text(ModuleIndustry.¤¤ProductionDesc);
/* 795 */           b.NL(8);
/*     */           
/* 797 */           indu.industryHoverProductionRate(b, i, ins);
/*     */           
/* 799 */           b.NL(8);
/*     */           
/* 801 */           b.textLL(ModuleIndustry.¤¤ProducedDay);
/* 802 */           b.tab(7);
/* 803 */           b.add((SPRITE)GFORMAT.i(b.text(), (int)i.day.getD(p)));
/* 804 */           b.NL();
/*     */           
/* 806 */           b.textLL(ModuleIndustry.¤¤ProducedYesterDay);
/* 807 */           b.tab(7);
/* 808 */           b.add((SPRITE)GFORMAT.i(b.text(), i.dayPrev.get(p)));
/* 809 */           b.NL();
/*     */ 
/*     */           
/* 812 */           b.textLL(ModuleIndustry.¤¤ProducedNow);
/* 813 */           b.tab(7);
/* 814 */           b.add((SPRITE)GFORMAT.i(b.text(), i.year.get(p)));
/* 815 */           b.NL();
/*     */           
/* 817 */           b.textLL(ModuleIndustry.¤¤ProducedPrevious);
/* 818 */           b.tab(7);
/* 819 */           b.add((SPRITE)GFORMAT.i(b.text(), i.yearPrev.get(p)));
/* 820 */           b.NL();
/*     */ 
/*     */           
/* 823 */           double e = indu.industryFormatProductionRate(b.text(), i, ins);
/*     */           
/* 825 */           double pa = TIME.years().bitPartOf();
/*     */           
/* 827 */           int eyear = (int)(i.year.get(p) + e * (1.0D - pa) * TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/* 828 */           b.textLL(ModuleIndustry.¤¤ProducedEstimate);
/* 829 */           b.tab(7);
/* 830 */           b.add((SPRITE)GFORMAT.i(b.text(), eyear));
/* 831 */           b.NL();
/*     */           
/* 833 */           b.NL(8);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 838 */     s.add((RENDEROBJ)new RENDEROBJ.RenderImp(24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 842 */             ROOM_PRODUCER_INSTANCE p = ModuleIndustry.g(get);
/* 843 */             IndustryResource i = (IndustryResource)p.industry().outs().get(ri);
/* 844 */             i.resource.icon().render(r, (RECTANGLE)this.body);
/*     */           }
/*     */         });
/*     */     
/* 848 */     HOVERABLE h = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 852 */           IndustryResource i = (IndustryResource)ModuleIndustry.g(get).industry().outs().get(ri);
/* 853 */           RoomInstance ins = (RoomInstance)get.get();
/* 854 */           indu.industryFormatProductionRate(text, i, ins);
/*     */         }
/* 856 */       }).r();
/*     */     
/* 858 */     s.addRightC(6, (RENDEROBJ)h);
/*     */     
/* 860 */     h = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 864 */           IndustryResource i = (IndustryResource)ModuleIndustry.g(get).industry().outs().get(ri);
/* 865 */           RoomInstance ins = (RoomInstance)get.get();
/* 866 */           indu.industryFormatProductionRateEmpl(text, i, ins);
/*     */         }
/* 868 */       }).r();
/*     */     
/* 870 */     s.add((RENDEROBJ)h, s.getLast().x1(), s.getLastY2() + 1);
/*     */     
/* 872 */     s.body().incrW(48.0D);
/* 873 */     s.pad(4);
/* 874 */     return (RENDEROBJ)s;
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
/*     */   public static RENDEROBJ makeFetch(final GETTER<? extends RoomInstance> get) {
/* 897 */     return (RENDEROBJ)(new GStat() { public void update(GText text) { GFORMAT.perc(text, ((RoomInstance)get.get()).employees().fetchProximity()); } public void hoverInfoGet(GBox b) { SETT.OVERLAY().addFetch((RoomInstance)get.get()); b.title(RoomEmploymentIns.¤¤ProximityInput); b.text(RoomEmploymentIns.¤¤¤¤ProximityInputD); b.NL(); b.textL(DicTime.¤¤Today); b.add((SPRITE)GFORMAT.perc(b.text(), ((RoomInstance)get.get()).employees().fetchProximitySoFar())); } }).hh((SPRITE)(UI.icons()).s.clock);
/*     */   }
/*     */   
/*     */   public void problem(Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings, Room r, int rx, int ry) {
/* 901 */     fetchProblem(free, errors, warnings, (RoomInstance)r);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void fetchProblem(Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings, RoomInstance room) {
/* 906 */     if (room.blueprint().employment().countInput() && 
/* 907 */       room.employees().fetchProximity() < 0.8D)
/* 908 */       warnings.add(¤¤FetchWarning); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleIndustry.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */