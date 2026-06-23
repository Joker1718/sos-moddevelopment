/*     */ package settlement.room.infra.stockpile;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.infra.logistics.MoveDic;
/*     */ import settlement.room.infra.logistics.MoveOrderPull;
/*     */ import settlement.room.infra.logistics.MoveOrderPullUI;
/*     */ import settlement.room.infra.logistics.MoveOrderPullersUI;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.room.UIRoomBulkApplier;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Gui
/*     */   extends UIRoomModule.UIRoomModuleImp<StockpileInstance, ROOM_STOCKPILE>
/*     */ {
/*  65 */   private static CharSequence ¤¤special = "This setting locks usage to a single crate and lets you precisely dictate the maximum amount of items to be stored.";
/*     */   
/*     */   static {
/*  68 */     D.ts(Gui.class);
/*     */   }
/*     */   
/*     */   Gui(ROOM_STOCKPILE s) {
/*  72 */     super(s);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendPanel(final GuiSection section, GGrid grid, final GETTER<StockpileInstance> g, int x1, int y1) {
/*  78 */     RENDEROBJ r = null;
/*     */     
/*  80 */     HOVERABLE hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/*  84 */           GFORMAT.percInv(text, ((StockpileInstance)g.get()).getUsedSpace());
/*     */         }
/*  87 */       }).hh(Dic.¤¤Capacity).hoverInfoSet(MoveDic.¤¤capacityD);
/*  88 */     grid.add((RENDEROBJ)hOVERABLE);
/*     */ 
/*     */     
/*  91 */     hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/*  95 */           GFORMAT.iofk(text, (((ROOM_STOCKPILE)Gui.this.blueprint).tally()).crates.get((RESOURCE)null, (StockpileInstance)g.get()), ((StockpileInstance)g.get()).totalCrates());
/*     */         }
/*  98 */       }).hh((((ROOM_STOCKPILE)this.blueprint).tally()).crates.name).hoverInfoSet(MoveDic.¤¤allocatedCrates);
/*  99 */     grid.add((RENDEROBJ)hOVERABLE);
/*     */ 
/*     */     
/* 102 */     GuiSection s = new GuiSection();
/*     */ 
/*     */     
/* 105 */     GButt.ButtPanel p = new GButt.ButtPanel((SPRITE)(UI.icons()).m.wheel)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/* 109 */           selectedSet(((StockpileInstance)g.get()).fetching());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 114 */           ((StockpileInstance)g.get()).fetchingSet(!((StockpileInstance)g.get()).fetching());
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 121 */           super.render(r, ds, isActive, isSelected, isHovered);
/* 122 */           if (((StockpileInstance)g.get()).fetching() && ((StockpileInstance)g.get()).coolFetch > -1) {
/* 123 */             (GCOLOR.UI()).SOSO.hovered.bind();
/* 124 */             (UI.icons()).s.alert.render(r, this.body.x1() + 6, this.body.y1() + 6);
/* 125 */             COLOR.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 131 */           GBox b = (GBox)text;
/* 132 */           b.title(MoveDic.¤¤fetch);
/* 133 */           b.text(MoveDic.¤¤fetchD);
/* 134 */           b.NL();
/* 135 */           if (((StockpileInstance)g.get()).fetching() && ((StockpileInstance)g.get()).coolFetch > -1) {
/* 136 */             b.add((SPRITE)b.text().warnify().add(MoveDic.¤¤fetchProblem));
/*     */           }
/* 138 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */     
/* 142 */     p.body.setDim(48.0D);
/* 143 */     s.addRightC(0, (RENDEROBJ)p);
/*     */     
/* 145 */     p = new GButt.ButtPanel((SPRITE)(UI.icons()).m.priority)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/* 149 */           selectedSet(((StockpileInstance)g.get()).prioritizing());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 154 */           ((StockpileInstance)g.get()).prioritizeToggle();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 161 */           super.render(r, ds, isActive, isSelected, isHovered);
/* 162 */           if (((StockpileInstance)g.get()).prioritizing() && ((StockpileInstance)g.get()).coolFetch > -1) {
/* 163 */             (GCOLOR.UI()).SOSO.hovered.bind();
/* 164 */             (UI.icons()).s.alert.render(r, this.body.x1() + 6, this.body.y1() + 6);
/* 165 */             COLOR.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 171 */           GBox b = (GBox)text;
/* 172 */           b.title(MoveDic.¤¤prio);
/* 173 */           b.text(MoveDic.¤¤prioD);
/* 174 */           b.NL();
/* 175 */           if (((StockpileInstance)g.get()).prioritizing() && ((StockpileInstance)g.get()).coolFetch > -1) {
/* 176 */             b.add((SPRITE)b.text().warnify().add(MoveDic.¤¤fetchProblem));
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 183 */     p.body.setDim(48.0D);
/* 184 */     s.addRightC(0, (RENDEROBJ)p);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     MoveOrderPullUI ui = new MoveOrderPullUI(g, g, RESOURCES.ALL(), 4);
/* 190 */     s.addRightC(8, (RENDEROBJ)ui);
/* 191 */     s.addRightC(0, (RENDEROBJ)new MoveOrderPullersUI(g));
/*     */ 
/*     */     
/* 194 */     GButt.ButtPanel buttPanel1 = new GButt.ButtPanel((SPRITE)(UI.icons()).m.lock)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/* 198 */           selectedSet(((StockpileInstance)g.get()).storing());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 203 */           ((StockpileInstance)g.get()).storingSet(!((StockpileInstance)g.get()).storing());
/*     */         }
/*     */       };
/*     */     
/* 207 */     buttPanel1.hoverTitleSet(MoveDic.¤¤storing);
/* 208 */     buttPanel1.hoverInfoSet(MoveDic.¤¤storingD);
/* 209 */     buttPanel1.body.setDim(48.0D);
/* 210 */     s.addRightC(8, (RENDEROBJ)buttPanel1);
/*     */ 
/*     */ 
/*     */     
/* 214 */     section.addRelBody(4, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */ 
/*     */     
/* 218 */     section.addRelBody(4, DIR.S, (RENDEROBJ)new RENDEROBJ.RenderImp(1, 8)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 222 */             GCOLOR.UI().border().render(r, section.body().x1() + 8, section.body().x2() - 8, this.body.y1() + 4, this.body.y1() + 5);
/*     */           }
/*     */         });
/*     */     
/* 226 */     section.addRelBody(8, DIR.S, (RENDEROBJ)new ResArea2(g, section.getLastY2() + 8));
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
/*     */   protected void appendTableButt(GuiSection s, final GETTER<RoomInstance> ins) {
/* 238 */     s.add((SPRITE)new SPRITE.Imp(s.body().width(), 24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 242 */             StockpileInstance in = (StockpileInstance)ins.get();
/*     */             
/* 244 */             double t = in.getUsedSpace();
/* 245 */             GMeter.render(r, GMeter.C_BLUE, t, X1, X2, Y1, Y2);
/*     */             
/* 247 */             int x = X1 + 2;
/*     */             
/* 249 */             for (RESOURCE res : RESOURCES.ALL()) {
/* 250 */               if ((((ROOM_STOCKPILE)Gui.this.blueprint).tally()).crates.get(res, in) > 0) {
/* 251 */                 (res.icon()).small.render(r, x, Y1 + 4);
/* 252 */                 x += (res.icon()).small.width();
/* 253 */                 if (x >= X2 - (res.icon()).small.width()) {
/*     */                   break;
/*     */                 }
/*     */               }
/*     */             
/*     */             } 
/*     */           }
/* 260 */         }0, s.body().y2());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void problem(StockpileInstance i, Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings) {
/* 268 */     if (i.employees().target() == 0)
/*     */       return; 
/* 270 */     boolean ok = false;
/* 271 */     boolean has = false; byte b; int j; MoveOrderPull[] arrayOfMoveOrderPull;
/* 272 */     for (j = (arrayOfMoveOrderPull = i.moveOrdersPull()).length, b = 0; b < j; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/* 273 */       if (o != null) {
/* 274 */         has = true;
/* 275 */         CharSequence p = o.problem(i);
/* 276 */         if (p != null) {
/* 277 */           errors.add(p); break;
/*     */         } 
/* 279 */         if (o.cooldown >= -1)
/* 280 */           ok = true; 
/*     */       } 
/*     */       b++; }
/*     */     
/* 284 */     if (i.fetching() && i.coolFetch > -1 && i.coolOrganize > -1 && has && !ok) {
/* 285 */       errors.add(MoveDic.¤¤pullProblem);
/*     */     }
/*     */     
/* 288 */     super.problem(i, free, errors, warnings);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, StockpileInstance i) {
/* 293 */     super.hover(box, i);
/* 294 */     box.sep();
/* 295 */     if (i.fetching() && i.employees().target() > 0) {
/* 296 */       box.textL(MoveDic.¤¤fetching);
/* 297 */       box.NL();
/* 298 */       if (i.coolFetch > -1) {
/* 299 */         box.add((SPRITE)box.text().warnify().add(MoveDic.¤¤fetchProblem));
/* 300 */         box.NL();
/*     */       }  byte b; int j; MoveOrderPull[] arrayOfMoveOrderPull;
/* 302 */       for (j = (arrayOfMoveOrderPull = i.moveOrdersPull()).length, b = 0; b < j; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/* 303 */         if (o != null) {
/* 304 */           CharSequence p = o.warning(i);
/* 305 */           if (p != null) {
/* 306 */             box.add((SPRITE)box.text().warnify().add(p));
/* 307 */             box.NL();
/*     */           } 
/*     */         }  b++; }
/*     */     
/*     */     } 
/* 312 */     if (i.storing()) {
/* 313 */       box.add((SPRITE)box.text().warnify().add(MoveDic.¤¤storing));
/*     */     }
/* 315 */     int m = 0;
/* 316 */     box.NL(8);
/*     */     
/* 318 */     for (RESOURCE r : RESOURCES.ALL()) {
/*     */       
/* 320 */       if ((((ROOM_STOCKPILE)this.blueprint).tally()).crates.get(r, i) > 0) {
/*     */         
/* 322 */         box.tab(m % 3 * 5);
/*     */         
/* 324 */         box.add((SPRITE)r.icon());
/* 325 */         box.add((SPRITE)GFORMAT.iofkInv(box.text(), (((ROOM_STOCKPILE)this.blueprint).tally()).amount.get(r, i), (((ROOM_STOCKPILE)this.blueprint).tally()).space.get(r, i)));
/*     */         
/* 327 */         if (m % 3 == 2) {
/* 328 */           box.NL();
/*     */         }
/* 330 */         m++;
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
/*     */   protected void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {
/* 344 */     sorts.add(new GTableSorter.GTSort<RoomInstance>(Dic.¤¤Resource)
/*     */         {
/*     */           public void format(RoomInstance h, GText text)
/*     */           {
/* 348 */             text.add((CharSequence)h.name());
/*     */           }
/*     */ 
/*     */           
/*     */           public int cmp(RoomInstance current, RoomInstance cmp) {
/* 353 */             return oo(current) - oo(cmp);
/*     */           }
/*     */           
/*     */           private int oo(RoomInstance ins) {
/* 357 */             StockpileInstance i = (StockpileInstance)ins;
/* 358 */             for (int ri = 0; ri < RESOURCES.ALL().size(); ri++) {
/* 359 */               if (((SETT.ROOMS()).STOCKPILE.tally()).crates.get(ri, i) > 0)
/* 360 */                 return ri; 
/* 361 */             }  return 0;
/*     */           }
/*     */         });
/* 364 */     for (RESOURCE res : RESOURCES.ALL()) {
/* 365 */       filters.add(new GTableSorter.GTFilter<RoomInstance>(res.names)
/*     */           {
/*     */             public boolean passes(RoomInstance h)
/*     */             {
/* 369 */               StockpileInstance i = (StockpileInstance)h;
/* 370 */               if ((((ROOM_STOCKPILE)Gui.this.blueprint).tally()).crates.get(res, i) > 0)
/* 371 */                 return true; 
/* 372 */               return false;
/*     */             }
/*     */           });
/*     */     } 
/*     */     
/* 377 */     super.appendTableFilters(filters, sorts, appliers);
/*     */   }
/*     */   
/*     */   private static class ResArea2
/*     */     extends GuiSection {
/* 382 */     private ArrayList<RESOURCE> current = new ArrayList(RESOURCES.ALL().size());
/*     */     private final GETTER<StockpileInstance> g;
/*     */     private StockpileInstance lastOpen;
/* 385 */     private double renView = 0.0D;
/*     */     private final GuiSection pop;
/*     */     
/*     */     ResArea2(GETTER<StockpileInstance> g, int y1) {
/* 389 */       this.g = g;
/* 390 */       ACTION change = new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 394 */             Gui.ResArea2.this.lastOpen = null;
/*     */           }
/*     */         };
/* 397 */       this.pop = makeTable(g, change);
/* 398 */       add((RENDEROBJ)new GHeader(Dic.¤¤Resources));
/* 399 */       addRightC(16, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Settings)
/*     */           {
/*     */             protected void clickA() {
/* 402 */               (VIEW.inters()).popup.show((RENDEROBJ)Gui.ResArea2.this.pop, (CLICKABLE)this);
/* 403 */               super.clickA();
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 408 */       GRows rows = new GRows(2);
/* 409 */       for (int ri = 0; ri < RESOURCES.ALL().size(); ri++) {
/* 410 */         final int rr = ri;
/* 411 */         GETTER<RESOURCE> gg = new GETTER<RESOURCE>()
/*     */           {
/*     */             public RESOURCE get()
/*     */             {
/* 415 */               return (RESOURCE)Gui.ResArea2.this.current.get(rr);
/*     */             }
/*     */           };
/*     */ 
/*     */         
/* 420 */         rows.add((RENDEROBJ)new ResLineDetailed(gg, g, ACTION.NOP));
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 425 */       addRelBody(8, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)rows.rows(), ISidePanel.HEIGHT - y1 - 64)
/*     */           {
/*     */             protected boolean passesFilter(int i, RENDEROBJ o)
/*     */             {
/* 429 */               return (i < Math.ceil(Gui.ResArea2.this.current.size() / 2.0D));
/*     */             }
/* 432 */           }).view());
/*     */       
/* 434 */       pad(8, 8);
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 439 */       if (this.lastOpen == null || this.g.get() != this.lastOpen || Math.abs(this.renView - VIEW.renderSecond()) > 5.0D) {
/* 440 */         this.current.clearSloppy();
/* 441 */         for (RESOURCE res : RESOURCES.ALL()) {
/* 442 */           if (((SETT.ROOMS()).STOCKPILE.tally()).space.get(res, (StockpileInstance)this.g.get()) > 0)
/* 443 */             this.current.add(res); 
/*     */         } 
/* 445 */         this.lastOpen = (StockpileInstance)this.g.get();
/*     */       } 
/* 447 */       this.renView = VIEW.renderSecond();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 453 */       super.render(r, ds);
/*     */     }
/*     */     
/*     */     private static GuiSection makeTable(final GETTER<StockpileInstance> g, ACTION change) {
/* 457 */       GuiSection section = new GuiSection();
/* 458 */       LinkedList<RENDEROBJ> rows = new LinkedList();
/* 459 */       int rr = 2;
/* 460 */       int r = 0;
/*     */       
/* 462 */       GuiSection ss = null;
/* 463 */       int ci = -1;
/* 464 */       for (RESOURCE res : RESOURCES.ALL()) {
/* 465 */         if (res.category != ci) {
/* 466 */           final LinkedList<RESOURCE> ress = new LinkedList();
/* 467 */           for (int ri = 0; ri < RESOURCES.ALL().size(); ri++) {
/* 468 */             if (((RESOURCE)RESOURCES.ALL().get(ri)).category == res.category) {
/* 469 */               ress.add(RESOURCES.ALL().get(ri));
/*     */             }
/*     */           } 
/*     */           
/* 473 */           GuiSection s = new GuiSection();
/* 474 */           s.add((RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).s.minifier)
/*     */               {
/*     */                 protected void clickA() {
/* 477 */                   for (RESOURCE r : ress) {
/* 478 */                     ((StockpileInstance)g.get()).allocateCrate(r, ((SETT.ROOMS()).STOCKPILE.tally()).crates.get(r, (StockpileInstance)g.get()) - 1);
/*     */                   }
/*     */                 }
/*     */               });
/* 482 */           s.addRightC(0, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).s.magnifier)
/*     */               {
/*     */                 protected void clickA() {
/* 485 */                   for (RESOURCE r : ress) {
/* 486 */                     ((StockpileInstance)g.get()).allocateCrate(r, ((SETT.ROOMS()).STOCKPILE.tally()).crates.get(r, (StockpileInstance)g.get()) + 1);
/*     */                   }
/*     */                 }
/*     */               });
/*     */ 
/*     */           
/* 492 */           rows.add(s);
/* 493 */           ci = res.category;
/* 494 */           r = 0;
/* 495 */           ss = new GuiSection();
/* 496 */           rows.add(ss);
/*     */         } 
/*     */         
/* 499 */         if (r >= rr) {
/* 500 */           r = 0;
/* 501 */           ss = new GuiSection();
/* 502 */           rows.add(ss);
/*     */         } 
/*     */         
/* 505 */         ss.addRightC(0, (RENDEROBJ)new ResLineDetailed((GETTER<RESOURCE>)new GETTER.GETTER_IMP(res), g, change));
/* 506 */         r++;
/*     */       } 
/*     */       
/* 509 */       section.addRelBody(6, DIR.S, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 513 */               GFORMAT.iofk(text, (((StockpileInstance)g.get()).blueprintI().tally()).crates.get((RESOURCE)null, (StockpileInstance)g.get()), ((StockpileInstance)g.get()).totalCrates());
/*     */             }
/* 516 */           }).hh(((SETT.ROOMS()).STOCKPILE.tally()).crates.name).hoverInfoSet(MoveDic.¤¤allocatedCrates));
/*     */       
/* 518 */       section.addRelBody(6, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)rows, ISidePanel.HEIGHT - 8)).view());
/* 519 */       return section;
/*     */     }
/*     */     
/*     */     private static class ResLineDetailed
/*     */       extends GuiSection {
/*     */       private final GETTER<RESOURCE> res;
/* 525 */       RESOURCE prev = null;
/*     */       
/*     */       private final GSliderInt gg;
/*     */       private final INT.INTE crates;
/*     */       private final GETTER<StockpileInstance> g;
/*     */       
/*     */       ResLineDetailed(final GETTER<RESOURCE> res, final GETTER<StockpileInstance> g, final ACTION change) {
/* 532 */         add((SPRITE)new SPRITE.Imp(24)
/*     */             {
/*     */               public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */               {
/* 536 */                 ((RESOURCE)res.get()).icon().render(r, X1, X2, Y1, Y2);
/*     */               }
/* 539 */             }0, 0);
/* 540 */         this.g = g;
/*     */         
/* 542 */         this.crates = new INT.INTE()
/*     */           {
/*     */             public int get()
/*     */             {
/* 546 */               return (((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()) == 0) ? ((SETT.ROOMS()).STOCKPILE.tally()).crates.get((RESOURCE)res.get(), (StockpileInstance)g.get()) : ((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get());
/*     */             }
/*     */ 
/*     */             
/*     */             public int min() {
/* 551 */               return (((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()) == 0) ? 0 : 1;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max() {
/* 556 */               if (((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()) == 0)
/* 557 */                 return ((StockpileInstance)g.get()).totalCrates(); 
/* 558 */               return Math.min(100, ((StockpileInstance)g.get()).crateSize());
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 563 */               if (((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()) == 0) {
/* 564 */                 int m = 0;
/* 565 */                 for (int i = 0; i < RESOURCES.ALL().size(); i++) {
/* 566 */                   if (i != ((RESOURCE)res.get()).index())
/*     */                   {
/* 568 */                     m += ((SETT.ROOMS()).STOCKPILE.tally()).crates.get(i, (StockpileInstance)g.get());
/*     */                   }
/*     */                 } 
/* 571 */                 if (m + t > ((StockpileInstance)g.get()).totalCrates()) {
/* 572 */                   t = ((StockpileInstance)g.get()).totalCrates() - m;
/*     */                 }
/* 574 */                 ((StockpileInstance)g.get()).allocateCrate((RESOURCE)res.get(), t);
/*     */               } else {
/* 576 */                 ((StockpileInstance)g.get()).setSpecialAmount((RESOURCE)res.get(), t);
/*     */               } 
/* 578 */               change.exe();
/*     */             }
/*     */           };
/*     */         
/* 582 */         this.gg = new GSliderInt(this.crates, 160, 24, true)
/*     */           {
/*     */             protected void renderMidColor(SPRITE_RENDERER r, int x1, int width, int widthFull, int y1, int y2)
/*     */             {
/* 586 */               double a = ((SETT.ROOMS()).STOCKPILE.tally()).amount.get((RESOURCE)res.get(), (StockpileInstance)g.get());
/* 587 */               double c = ((((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()) == 0) ? (Gui.ResArea2.ResLineDetailed.this.crates.get() * ((StockpileInstance)g.get()).crateSize((RESOURCE)res.get())) : ((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()));
/* 588 */               double d = 0.0D;
/* 589 */               if (c > 0.0D)
/* 590 */                 d = a / c; 
/* 591 */               GMeter.GMeterCol col = GMeter.C_INACTIVE;
/* 592 */               if (d > 0.9D) {
/* 593 */                 col = GMeter.C_REDPURPLE;
/* 594 */               } else if (c > 0.0D) {
/* 595 */                 col = GMeter.C_REDGREEN;
/*     */               } else {
/* 597 */                 GMeter.render(r, GMeter.C_INACTIVE, d, (RECTANGLE)body());
/*     */               } 
/* 599 */               col.bg.render(r, x1, x1 + width, y1, y2);
/*     */               
/* 601 */               col.dark.render(r, x1, (int)(x1 + width * d), y1, y2);
/* 602 */               col.bright.render(r, x1, (int)(x1 + width * d), y1 + 1, y2 - 1);
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {}
/*     */           };
/* 612 */         addRightC(4, (RENDEROBJ)this.gg);
/*     */         
/* 614 */         GStat s = new GStat()
/*     */           {
/*     */             public void update(GText text) {
/* 617 */               GFORMAT.i(text, ((SETT.ROOMS()).STOCKPILE.tally()).amount.get((RESOURCE)res.get(), (StockpileInstance)g.get()));
/*     */               
/* 619 */               double max = ((((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()) == 0) ? (Gui.ResArea2.ResLineDetailed.this.crates.get() * ((StockpileInstance)g.get()).crateSize((RESOURCE)res.get())) : ((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()));
/* 620 */               if (max == 0.0D) {
/* 621 */                 text.color((GCOLOR.T()).NORMAL);
/*     */               } else {
/* 623 */                 double am = ((SETT.ROOMS()).STOCKPILE.tally()).amount.get((RESOURCE)res.get(), (StockpileInstance)g.get());
/* 624 */                 double d = am / max;
/* 625 */                 if (d < 0.5D) {
/* 626 */                   ColorImp.TMP.interpolate((GCOLOR.T()).IBAD, (GCOLOR.T()).WARNING, d * 2.0D);
/*     */                 } else {
/* 628 */                   ColorImp.TMP.interpolate((GCOLOR.T()).WARNING, (GCOLOR.T()).IGREAT, (d - 0.5D) * 2.0D);
/*     */                 } 
/* 630 */                 text.color((COLOR)ColorImp.TMP);
/*     */               } 
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 637 */               if (Gui.ResArea2.ResLineDetailed.this.hoveredIs() || Gui.ResArea2.ResLineDetailed.this.crates.get() == 0)
/*     */                 return; 
/* 639 */               OPACITY.O50.bind();
/* 640 */               COLOR.BLACK.render(r, X1 - 2, X2 + 2, Y1 - 1, Y2 + 2);
/* 641 */               OPACITY.unbind();
/* 642 */               super.render(r, X1, X2, Y1, Y2);
/*     */             }
/*     */           };
/*     */         
/* 646 */         addCentredY((RENDEROBJ)s.r(DIR.E), getLastX2() - 38 - 36);
/*     */         
/* 648 */         addCentredY((RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).s.arrowDown)
/*     */             {
/*     */               protected void clickA()
/*     */               {
/* 652 */                 ((StockpileInstance)g.get()).setSpecialAmount((RESOURCE)res.get(), (((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()) == 0) ? Math.min(100, ((StockpileInstance)g.get()).crateSize()) : 0);
/*     */               }
/*     */ 
/*     */               
/*     */               protected void renAction() {
/* 657 */                 activeSet(!(((SETT.ROOMS()).STOCKPILE.tally()).crates.get((RESOURCE)res.get(), (StockpileInstance)g.get()) <= 0 && ((StockpileInstance)g.get()).totalCrates() - ((SETT.ROOMS()).STOCKPILE.tally()).crates.get((RESOURCE)null, (StockpileInstance)g.get()) <= 0));
/* 658 */                 selectedSet((((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()) > 0));
/*     */               }
/* 661 */             }).hoverInfoSet(Gui.¤¤special), body().x2() + 2);
/*     */ 
/*     */         
/* 664 */         pad(6, 2);
/*     */         
/* 666 */         this.res = res;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void render(SPRITE_RENDERER r, float ds) {
/* 672 */         if (this.res.get() != this.prev)
/* 673 */           this.gg.reset(); 
/* 674 */         this.prev = (RESOURCE)this.res.get();
/* 675 */         if (this.res.get() == null)
/*     */           return; 
/* 677 */         GCOLOR.UI().border().render(r, (RECTANGLE)body(), -2);
/* 678 */         boolean hov = hoveredIs();
/* 679 */         super.render(r, ds);
/* 680 */         if (this.crates.get() == 0 && !hov) {
/* 681 */           OPACITY.O25.bind();
/* 682 */           COLOR.BLACK.render(r, (RECTANGLE)body());
/* 683 */           OPACITY.unbind();
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public void hoverInfoGet(GUI_BOX text) {
/* 689 */         if (this.res.get() != this.prev)
/* 690 */           this.gg.reset(); 
/* 691 */         this.prev = (RESOURCE)this.res.get();
/* 692 */         if (this.res.get() == null)
/*     */           return; 
/* 694 */         super.hoverInfoGet(text);
/* 695 */         if (text.emptyIs()) {
/* 696 */           Gui.hover(text, (StockpileInstance)this.g.get(), (RESOURCE)this.res.get());
/*     */         }
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean click() {
/* 702 */         if (this.res.get() != this.prev)
/* 703 */           this.gg.reset(); 
/* 704 */         this.prev = (RESOURCE)this.res.get();
/* 705 */         if (this.res.get() == null)
/* 706 */           return false; 
/* 707 */         return super.click();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void hover(GUI_BOX text, StockpileInstance ins, RESOURCE res) {
/* 716 */     text.title(res.name);
/* 717 */     text.text(res.desc);
/* 718 */     GBox b = (GBox)text;
/* 719 */     b.sep();
/*     */ 
/*     */     
/* 722 */     for (StockpileTally.TallyData d : ((SETT.ROOMS()).STOCKPILE.tally()).datas) {
/* 723 */       b.textLL(d.name);
/* 724 */       b.tab(7);
/* 725 */       b.add((SPRITE)GFORMAT.i(b.text(), d.get(res, ins)));
/* 726 */       b.NL();
/*     */     } 
/*     */     
/* 729 */     b.sep();
/* 730 */     b.textLL(Dic.¤¤Total);
/* 731 */     b.NL();
/* 732 */     for (StockpileTally.TallyData d : ((SETT.ROOMS()).STOCKPILE.tally()).datas) {
/* 733 */       b.textLL(d.name);
/* 734 */       b.tab(7);
/* 735 */       b.add((SPRITE)GFORMAT.i(b.text(), d.total(res)));
/* 736 */       b.NL();
/*     */     } 
/*     */ 
/*     */     
/* 740 */     if ((S.get()).developer) {
/* 741 */       GText t = b.text();
/* 742 */       t.add(ins.fetchMask.has(res)).s().add(ins.fetchMaskBig.has(res)).s().add(ins.reservableMask.has(res));
/* 743 */       b.add((SPRITE)t);
/* 744 */       b.NL();
/* 745 */       t = b.text();
/* 746 */       t.add(ins.hasTriedBig);
/* 747 */       b.add((SPRITE)t);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */