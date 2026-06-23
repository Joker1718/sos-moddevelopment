/*     */ package view.sett.ui.room;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Booster;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEquip;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.Dictionary;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GDropDown;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GAllocator;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class UIRoomTable extends ISidePanel {
/*  50 */   private static final TableSorter tableSort = new TableSorter();
/*     */   private final RoomBlueprintIns<?> blueprint;
/*     */   private GTableSorter.GTFilter<RoomInstance> filterCurrent;
/*     */   private GTableSorter.GTSort<RoomInstance> sortCurrent;
/*     */   private RoomInstance hovered;
/*     */   private boolean wasHovering = false;
/*  56 */   private Coo oldC = new Coo();
/*     */   
/*  58 */   private static CharSequence ¤¤NrOfRooms = "Number of Rooms";
/*  59 */   private static CharSequence ¤¤Bulk = "¤Bulk";
/*  60 */   private static CharSequence ¤¤Showing = "¤Showing";
/*  61 */   private static CharSequence ¤¤level = "Current Available Max Level:";
/*     */ 
/*     */   
/*     */   static {
/*  65 */     D.ts(UIRoomTable.class);
/*     */   }
/*     */   
/*     */   ISidePanel get() {
/*  69 */     this.wasHovering = false;
/*  70 */     tableSort.set(this.blueprint, this.filterCurrent, this.sortCurrent);
/*  71 */     return this;
/*     */   }
/*     */   
/*     */   UIRoomTable(final RoomBlueprintIns<?> b, UIRoom gui, UIRoomModule... appliers) {
/*  75 */     this.blueprint = b;
/*     */     
/*  77 */     titleSet(this.blueprint.info.names);
/*     */     
/*  79 */     this.section = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/*  82 */           UIRoomTable.tableSort.sort();
/*  83 */           super.render(r, ds);
/*  84 */           if (UIRoomTable.this.hovered != null) {
/*  85 */             SETT.OVERLAY().add(UIRoomTable.this.hovered.mX(), UIRoomTable.this.hovered.mY());
/*  86 */             VIEW.s().getWindow().centerAtTile(UIRoomTable.this.hovered.body().cX(), UIRoomTable.this.hovered.body().cY());
/*  87 */             UIRoomTable.this.wasHovering = true;
/*  88 */             UIRoomTable.this.hovered = null;
/*     */           } else {
/*  90 */             if (UIRoomTable.this.wasHovering)
/*  91 */               VIEW.s().getWindow().centerAt((COORDINATE)UIRoomTable.this.oldC); 
/*  92 */             UIRoomTable.this.wasHovering = false;
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/*  97 */     int width = 200;
/*  98 */     GuiSection guiSection1 = makeRow(gui, (GETTER<Integer>)new GETTER.GETTER_IMP(), appliers);
/*  99 */     if (guiSection1.body().width() > width) {
/* 100 */       width = guiSection1.body().width();
/*     */     }
/* 102 */     this.section.body().setWidth(width).setHeight(1.0D);
/*     */     
/* 104 */     GuiSection sExtra = new GuiSection();
/*     */     
/* 106 */     int y1 = 0;
/*     */ 
/*     */ 
/*     */     
/* 110 */     GuiSection guiSection2 = new GuiSection();
/*     */     
/* 112 */     GGrid grid = (new GGrid(guiSection2, this.section.body().width(), 1, 0, 0)).setAlignment(DIR.W);
/* 113 */     GGrid text = (new GGrid(new GuiSection(), 1, 1, 0, 0)).setAlignment(DIR.C);
/* 114 */     grid.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 118 */             GFORMAT.i(text, UIRoomTable.this.blueprint.instancesSize());
/*     */           }
/* 120 */         }).hh((SPRITE)(SPRITES.icons()).s.house).hoverInfoSet(¤¤NrOfRooms));
/*     */     byte b1;
/*     */     int i;
/*     */     UIRoomModule[] arrayOfUIRoomModule;
/* 124 */     for (i = (arrayOfUIRoomModule = appliers).length, b1 = 0; b1 < i; ) { UIRoomModule m = arrayOfUIRoomModule[b1];
/* 125 */       m.appendManageScr(grid, text, sExtra);
/*     */       b1++; }
/*     */     
/* 128 */     int k = 0;
/* 129 */     for (RENDEROBJ r : guiSection2.elements()) {
/* 130 */       r.body().moveX1Y1((8 + k % 2 * this.section.body().width() / 2), (y1 + k / 2 * 24));
/* 131 */       this.section.add(r);
/* 132 */       k++;
/*     */     } 
/*     */     
/* 135 */     for (RENDEROBJ r : text.section.elements()) {
/* 136 */       this.section.addRelBody(4, DIR.S, r);
/*     */     }
/* 138 */     y1 = this.section.body().y2();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 144 */     ArrayListGrower<GTableSorter.GTFilter<RoomInstance>> filters = new ArrayListGrower();
/* 145 */     filters.add(new GTableSorter.GTFilter<RoomInstance>(Dic.¤¤None)
/*     */         {
/*     */           public boolean passes(RoomInstance h)
/*     */           {
/* 149 */             return true;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 154 */     ArrayListGrower<GTableSorter.GTSort<RoomInstance>> sorts = new ArrayListGrower();
/* 155 */     sorts.add(new GTableSorter.GTSort<RoomInstance>(Dic.¤¤name)
/*     */         {
/*     */           public int cmp(RoomInstance current, RoomInstance cmp)
/*     */           {
/* 159 */             return Dictionary.compare((CharSequence)current.name(), (CharSequence)cmp.name());
/*     */           }
/*     */ 
/*     */           
/*     */           public void format(RoomInstance h, GText text) {
/* 164 */             text.add((CharSequence)h.name());
/* 165 */             text.normalify();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 170 */     ArrayListGrower<UIRoomBulkApplier> apps = new ArrayListGrower();
/*     */     
/* 172 */     for (i = (arrayOfUIRoomModule = appliers).length, b1 = 0; b1 < i; ) { UIRoomModule m = arrayOfUIRoomModule[b1];
/* 173 */       m.appendTableFilters((LISTE<GTableSorter.GTFilter<RoomInstance>>)filters, (LISTE<GTableSorter.GTSort<RoomInstance>>)sorts, (LISTE<UIRoomBulkApplier>)apps);
/*     */       b1++; }
/*     */     
/* 176 */     GuiSection filter = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 180 */           (UI.PANEL()).butt.render(r, (RECTANGLE)body(), 0);
/* 181 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 186 */     GDropDown<CLICKABLE> d = new GDropDown(Dic.¤¤Sort, 100);
/* 187 */     for (GTableSorter.GTSort<RoomInstance> gTSort : sorts) {
/* 188 */       Text text1 = (new Text((UI.FONT()).S, gTSort.name)).setMaxWidth(120).setMultipleLines(false);
/* 189 */       CLICKABLE c = (new GButt.Glow((SPRITE)text1)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected void clickA()
/*     */           {
/* 199 */             UIRoomTable.this.sortCurrent = s;
/* 200 */             UIRoomTable.tableSort.setSort(s);
/*     */           }
/* 202 */         }).hoverInfoSet(gTSort.name);
/* 203 */       d.add(c);
/*     */     } 
/* 205 */     d.init();
/* 206 */     d.body.moveY1((filter.body().y1() + 4));
/* 207 */     d.body.moveX1((filter.body().x1() + 26));
/* 208 */     filter.add((RENDEROBJ)d);
/*     */     
/* 210 */     d = new GDropDown(Dic.¤¤Filter, 100);
/* 211 */     for (GTableSorter.GTFilter<RoomInstance> f : filters) {
/* 212 */       Text text1 = (new Text((UI.FONT()).S, f.name)).setMaxWidth(120).setMultipleLines(false);
/* 213 */       CLICKABLE c = (new GButt.Glow((SPRITE)text1)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected void clickA()
/*     */           {
/* 221 */             UIRoomTable.tableSort.setFilter(f);
/* 222 */             UIRoomTable.this.filterCurrent = f;
/*     */           }
/* 225 */         }).hoverInfoSet(f.name);
/* 226 */       d.add(c);
/*     */     } 
/* 228 */     d.init();
/* 229 */     filter.addDown(2, (RENDEROBJ)d);
/*     */     
/* 231 */     if (apps.size() > 0) {
/* 232 */       final GDropDown<CLICKABLE> bulk = new GDropDown(¤¤Bulk, 100);
/* 233 */       for (UIRoomBulkApplier a : apps) {
/* 234 */         Text text1 = (new Text((UI.FONT()).S, a.name)).setMaxWidth(120).setMultipleLines(false);
/* 235 */         CLICKABLE c = (new GButt.Glow((SPRITE)text1)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 239 */               for (int i = 0; i < UIRoomTable.tableSort.size(); i++) {
/* 240 */                 RoomInstance t = (RoomInstance)UIRoomTable.tableSort.get(i);
/* 241 */                 if (t != null) {
/* 242 */                   a.apply(t);
/*     */                 }
/*     */               } 
/*     */               
/* 246 */               bulk.setSelected(null);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 252 */               a.hover((GBox)text);
/*     */             }
/* 254 */           }).hoverInfoSet(a.name);
/* 255 */         bulk.add(c);
/*     */       } 
/* 257 */       bulk.setSelected(null);
/* 258 */       d = bulk;
/* 259 */       d.init();
/* 260 */       d.body.moveX1(24.0D);
/* 261 */       d.body.moveY2((filter.body().y2() - 4));
/*     */       
/* 263 */       filter.addDown(2, (RENDEROBJ)d);
/*     */     } 
/*     */     
/* 266 */     HOVERABLE hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 270 */           GFORMAT.iofk(text, UIRoomTable.tableSort.size(), UIRoomTable.this.blueprint.all().size());
/* 271 */           text.normalify();
/*     */         }
/* 273 */       }).hh(¤¤Showing);
/* 274 */     hOVERABLE.body().moveX1(100.0D);
/* 275 */     hOVERABLE.body().moveY1((filter.body().y2() + 5));
/* 276 */     filter.addRelBody(6, DIR.S, (RENDEROBJ)hOVERABLE);
/*     */     
/* 278 */     filter.body().centerX((BODY_HOLDER)this.section);
/* 279 */     filter.body().moveY1((y1 + 8));
/* 280 */     this.section.add((RENDEROBJ)filter);
/* 281 */     y1 = filter.body().y2();
/*     */ 
/*     */ 
/*     */     
/* 285 */     GuiSection s = table(y1, gui, appliers);
/* 286 */     s.body().moveX1Y1(0.0D, (y1 + 10));
/* 287 */     this.section.addRelBody(10, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */     
/* 290 */     if (sExtra.body().width() > 0) {
/* 291 */       this.section.addRelBody(8, DIR.E, (RENDEROBJ)sExtra);
/*     */     }
/* 293 */     if (b.employment() != null) {
/* 294 */       GuiSection equip = new GuiSection();
/* 295 */       int j = 0;
/* 296 */       for (RoomEquip e : (SETT.ROOMS()).employment.equip.ALL) {
/* 297 */         if (e.has(b.employment())) {
/*     */           
/* 299 */           GButt.BSection bSection = new GButt.BSection()
/*     */             {
/*     */               protected void hoverInfoSelf(GUI_BOX box)
/*     */               {
/* 303 */                 GBox bo = (GBox)box;
/*     */                 
/* 305 */                 bo.add(e.info);
/* 306 */                 bo.NL(8);
/*     */                 
/* 308 */                 bo.textL(UIRoomTable.¤¤level);
/* 309 */                 bo.add((SPRITE)GFORMAT.i(bo.text(), e.target(b.employment()).availableMax()));
/* 310 */                 bo.NL();
/* 311 */                 if (e.target(b.employment()).boost() != null) {
/* 312 */                   e.target(b.employment()).boost().hoverDetailed((GUI_BOX)bo, (BOOSTABLE_O)HCLASS_RACE.clP(), null, true);
/*     */                 }
/* 314 */                 bo.sep();
/*     */                 
/* 316 */                 bo.textLL(Dic.¤¤Target);
/* 317 */                 bo.tab(7);
/* 318 */                 bo.add((SPRITE)GFORMAT.iofk(bo.text(), e.target(b.employment()).get(), e.target(b.employment()).max()));
/* 319 */                 bo.NL();
/*     */                 
/* 321 */                 bo.textLL(Dic.¤¤Target);
/* 322 */                 bo.add((SPRITE)bo.text().para(Dic.¤¤Total));
/* 323 */                 bo.tab(7);
/* 324 */                 bo.add((SPRITE)GFORMAT.i(bo.text(), e.targetI(b.employment())));
/* 325 */                 bo.NL();
/*     */                 
/* 327 */                 bo.textLL(Dic.¤¤Current);
/* 328 */                 bo.tab(7);
/* 329 */                 bo.add((SPRITE)GFORMAT.i(bo.text(), e.current(b.employment())));
/* 330 */                 bo.NL();
/*     */                 
/* 332 */                 bo.textLL(Dic.¤¤Degrade);
/* 333 */                 bo.add((SPRITE)bo.text().para(Dic.¤¤Total));
/* 334 */                 bo.add((SPRITE)bo.text().para(DicTime.¤¤Day));
/* 335 */                 bo.tab(7);
/* 336 */                 bo.add((SPRITE)GFORMAT.f0(bo.text(), -e.targetI(b.employment()) * e.degradePerDay));
/*     */                 
/* 338 */                 bo.sep();
/* 339 */                 Booster bbb = (e.boost(UIRoomTable.this.blueprint.employment())).booster;
/* 340 */                 bbb.hover((GUI_BOX)bo, bbb.getValue(e.value(b.employment())));
/* 341 */                 bbb.hoverSpan((GUI_BOX)bo, bbb.getValue(e.value(b.employment())));
/* 342 */                 bo.NL();
/*     */               }
/*     */             };
/*     */ 
/*     */           
/* 347 */           bSection.add((SPRITE)e.resource.icon(), 0, 0);
/*     */           
/* 349 */           bSection.addRelBody(8, DIR.E, (RENDEROBJ)new GAllocator((COLOR)COLOR.ORANGE100.makeSaturated(0.7D), (INT.INTE)e.target(b.employment()), 6, 16));
/* 350 */           bSection.pad(8, 4);
/* 351 */           equip.addGrid((RENDEROBJ)bSection, j++, 3, 0, 0);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 357 */       if (equip.elements().size() > 0) {
/* 358 */         this.section.addRelBody(4, DIR.N, (RENDEROBJ)equip);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private GuiSection table(int y1, final UIRoom gui, UIRoomModule... appliers) {
/* 365 */     GTableBuilder builder = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/* 369 */           return UIRoomTable.tableSort.size();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void hover(int index) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public void click(int index) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean selectedIs(int index) {
/* 384 */           RoomInstance t = (RoomInstance)UIRoomTable.tableSort.get(index);
/* 385 */           return (gui.detailIns() == t && (VIEW.s()).panels.added(gui.detail(t)));
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 392 */     GuiSection guiSection = makeRow(gui, (GETTER<Integer>)new GETTER.GETTER_IMP(), appliers);
/*     */     
/* 394 */     builder.column(guiSection.body().width(), new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier) {
/* 397 */             return (RENDEROBJ)UIRoomTable.this.makeRow(gui, ier, appliers);
/*     */           }
/* 399 */         }DIR.NW);
/*     */     
/* 401 */     return builder.createHeight(HEIGHT - y1 - 16, false);
/*     */   }
/*     */ 
/*     */   
/*     */   private GuiSection makeRow(final UIRoom gui, final GETTER<Integer> ier, UIRoomModule... appliers) {
/* 406 */     final GButt.BSection s = new GButt.BSection(100, 0)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 409 */           if (!isHoveringAHoverElement()) {
/* 410 */             RoomInstance t = (RoomInstance)UIRoomTable.tableSort.get(((Integer)ier.get()).intValue());
/* 411 */             gui.hover(VIEW.hoverBox(), (Room)t, t.mX(), t.mY());
/*     */           } else {
/* 413 */             super.hoverInfoGet(text);
/*     */           } 
/*     */         }
/*     */         
/*     */         public boolean click() {
/* 418 */           if (super.click())
/* 419 */             return true; 
/* 420 */           RoomInstance t = (RoomInstance)UIRoomTable.tableSort.get(((Integer)ier.get()).intValue());
/* 421 */           ISidePanel d = gui.detail(t);
/* 422 */           (VIEW.s()).panels.add(d, false);
/* 423 */           (VIEW.s().getWindow()).centererTile.set(t.body().cX(), t.body().cY());
/* 424 */           UIRoomTable.this.oldC.set(VIEW.s().getWindow().pixels().cX(), VIEW.s().getWindow().pixels().cY());
/* 425 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/* 430 */           selectOnlythis(((VIEW.s()).panels.added(((VIEW.s()).ui.rooms.rooms[UIRoomTable.this.blueprint.index()]).detail) && (VIEW.s()).ui.rooms.rooms[UIRoomTable.this.blueprint.index()].detailIns() == UIRoomTable.tableSort.get(((Integer)ier.get()).intValue())));
/* 431 */           super.render(r, ds);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 438 */     int mW = (UI.FONT()).S.height() * 12;
/*     */     
/* 440 */     if (this.blueprint.upgrades().max() > 0) {
/* 441 */       SPRITE.Imp imp = new SPRITE.Imp(32, 16)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 445 */             RoomInstance ins = UIRoomTable.this.get(ier);
/* 446 */             int up = ins.upgrade();
/* 447 */             ColorImp.TMP.interpolate((GCOLOR.T()).H2, (GCOLOR.T()).H1, up / UIRoomTable.this.blueprint.upgrades().max());
/* 448 */             ColorImp.TMP.bind();
/* 449 */             for (int i = 0; i <= up; i++) {
/* 450 */               int x = i / 2;
/* 451 */               int y = i % 2;
/* 452 */               (SPRITES.icons()).s.plus.render(r, X1 + x * 16 / 2, Y1 + y * 16 / 2);
/*     */             } 
/* 454 */             COLOR.unbind();
/*     */           }
/*     */         };
/* 457 */       bSection.add((SPRITE)imp, 0, 0);
/* 458 */       bSection.addRightC(4, (SPRITE)(new GStat()
/*     */           {
/*     */             public void update(GText text) {
/* 461 */               if (UIRoomTable.tableSort.currentSort() != null)
/* 462 */                 UIRoomTable.tableSort.currentSort().format(UIRoomTable.this.get(ier), text); 
/* 463 */               text.setMaxWidth(s.body().width() - 24);
/* 464 */               text.setMultipleLines(false);
/* 465 */               text.lablify();
/*     */             }
/* 467 */           }).decrease());
/*     */     } else {
/* 469 */       bSection.add((SPRITE)(new GStat()
/*     */           {
/*     */             public void update(GText text) {
/* 472 */               if (UIRoomTable.tableSort.currentSort() != null)
/* 473 */                 UIRoomTable.tableSort.currentSort().format(UIRoomTable.this.get(ier), text); 
/* 474 */               text.setMaxWidth(s.body().width() - 24);
/* 475 */               text.setMultipleLines(false);
/* 476 */               text.lablify();
/*     */             }
/* 478 */           }).decrease(), 0, 0);
/*     */     } 
/*     */     
/* 481 */     bSection.body().incrW(mW);
/*     */ 
/*     */ 
/*     */     
/* 485 */     GuiSection pButts = new GuiSection();
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
/* 552 */     GuiSection butts = new GuiSection();
/*     */     
/* 554 */     GETTER<RoomInstance> getter = new GETTER<RoomInstance>()
/*     */       {
/*     */         public RoomInstance get()
/*     */         {
/* 558 */           return UIRoomTable.this.get(ier); }
/*     */       };
/*     */     byte b;
/*     */     int i;
/*     */     UIRoomModule[] arrayOfUIRoomModule;
/* 563 */     for (i = (arrayOfUIRoomModule = appliers).length, b = 0; b < i; ) { UIRoomModule m = arrayOfUIRoomModule[b];
/* 564 */       m.appendButt(butts, getter); b++; }
/*     */     
/* 566 */     butts.body().moveX1(0.0D);
/* 567 */     pButts.body().moveY1(butts.body().y1());
/* 568 */     if (butts.body().width() + pButts.body().width() > bSection.body().width()) {
/* 569 */       pButts.body().moveX1((butts.body().x2() + 16));
/*     */     } else {
/* 571 */       pButts.body().moveX2(bSection.body().width());
/*     */     } 
/* 573 */     for (RENDEROBJ o : pButts.elements()) {
/* 574 */       butts.add(o);
/*     */     }
/* 576 */     butts.body().centerY((BODY_HOLDER)bSection);
/* 577 */     butts.body().moveY1((bSection.body().y2() + 2));
/*     */     
/* 579 */     for (RENDEROBJ o : butts.elements()) {
/* 580 */       bSection.add(o);
/*     */     }
/* 582 */     bSection.pad(8, 8);
/*     */     
/* 584 */     return (GuiSection)bSection;
/*     */   }
/*     */ 
/*     */   
/*     */   protected RoomInstance get(GETTER<Integer> ier) {
/* 589 */     return (RoomInstance)tableSort.get(((Integer)ier.get()).intValue());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIRoomTable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */