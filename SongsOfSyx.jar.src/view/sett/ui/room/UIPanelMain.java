/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.WGROUP;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategories;
/*     */ import settlement.room.main.employment.RoomEmployment;
/*     */ import settlement.room.main.employment.RoomEquip;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.gui.table.GStaples;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.statistics.HISTORY_INT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.room.priority.UIWorkPrio;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class UIPanelMain
/*     */   extends ISidePanel
/*     */ {
/*  54 */   final UIWorkPrio work = new UIWorkPrio();
/*  55 */   private final UIPanelWorkTools[] tools = new UIPanelWorkTools[(SETT.ROOMS()).employment.equip.ALL.size()];
/*     */   
/*  57 */   private static CharSequence ¤¤emp = "Employed";
/*  58 */   private static CharSequence ¤¤oddjobbers = "Oddjobbers";
/*  59 */   private static CharSequence ¤¤title = "workforce & rooms";
/*     */   
/*     */   static {
/*  62 */     D.ts(UIPanelMain.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public UIPanelMain(UIRoom[] rooms) {
/*  67 */     this.section.body().setWidth(270.0D);
/*     */     
/*  69 */     titleSet(¤¤title);
/*     */ 
/*     */     
/*  72 */     GuiSection s = new GuiSection();
/*     */     
/*  74 */     final GuiSection pop = new Emp();
/*     */     
/*  76 */     final HOVERABLE ss = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/*  80 */           GFORMAT.iofkInv(text, (SETT.ROOMS()).employment.TARGET.get(null), (SETT.ROOMS()).employment.NEEDED.get());
/*     */         }
/*  82 */       }).hh((SPRITE)(UI.icons()).s.hammer);
/*     */     
/*  84 */     GButt.ButtPanel b = new GButt.ButtPanel((SPRITE)new SPRITE.Imp(200, 24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  88 */             ss.body().moveX1Y1(X1, (Y1 + 4));
/*  89 */             ss.render(r, 0.0F);
/*     */           }
/*     */         })
/*     */       {
/*     */         
/*     */         protected void clickA()
/*     */         {
/*  96 */           (VIEW.inters()).popup.show((RENDEROBJ)pop, (CLICKABLE)this);
/*     */         }
/*     */       };
/*     */     
/* 100 */     s.add((RENDEROBJ)b);
/*     */ 
/*     */     
/* 103 */     s.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel(Dic.¤¤Priority)
/*     */         {
/*     */           protected void clickA() {
/* 106 */             UIPanelMain.this.last().add((ISidePanel)UIPanelMain.this.work, false);
/*     */           }
/* 108 */         }).icon((SPRITE)(SPRITES.icons()).m.arrow_up));
/*     */     
/* 110 */     this.section.addRelBody(0, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 116 */     GuiSection equip = new GuiSection();
/*     */     
/* 118 */     int k = 0;
/*     */     
/* 120 */     for (RoomEquip w : (SETT.ROOMS()).employment.equip.ALL) {
/* 121 */       this.tools[w.index()] = new UIPanelWorkTools(w);
/* 122 */       GButt.ButtPanel buttPanel = (new GButt.ButtPanel((SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 126 */               GFORMAT.i(text, w.currentTotal());
/*     */             }
/*     */           })
/*     */         {
/*     */ 
/*     */           
/*     */           protected void clickA()
/*     */           {
/* 134 */             UIPanelMain.this.last().add(UIPanelMain.this.tools[w.index()], false);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 140 */             GBox b = (GBox)text;
/* 141 */             b.add(w.info);
/* 142 */             b.NL();
/* 143 */             b.textLL(Dic.¤¤Equipped);
/* 144 */             b.tab(6);
/* 145 */             b.add((SPRITE)GFORMAT.iofkInv(b.text(), w.currentTotal(), w.neededTotal()));
/*     */             
/* 147 */             b.NL();
/* 148 */             b.add((SPRITE)b.text().add(Dic.¤¤Consumed).s().add('(').add(DicTime.¤¤Day).add(')'));
/* 149 */             b.tab(6);
/* 150 */             b.add((SPRITE)GFORMAT.f0(b.text(), -w.currentTotal() * w.degradePerDay));
/*     */             
/* 152 */             b.sep();
/* 153 */             w.boosts.hover(text, 1.0D, -1);
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 161 */             super.render(r, ds, isActive, isSelected, isHovered);
/* 162 */             double d = w.currentTotal() / w.neededTotal();
/* 163 */             Rec.TEMP.setDim((this.body.width() - 8), (this.body.height() - 8));
/* 164 */             Rec.TEMP.centerIn((RECTANGLE)this.body);
/*     */             
/* 166 */             if (w.neededTotal() > 0) {
/* 167 */               GMeter.render(r, GMeter.C_GRAY, d, (RECTANGLE)Rec.TEMP);
/*     */             }
/* 169 */             super.render(r, ds, isActive, isSelected, isHovered);
/*     */           }
/* 172 */         }).setDim(124, 32).icon((SPRITE)w.resource.icon());
/*     */       
/* 174 */       equip.add((RENDEROBJ)buttPanel, k % 2 * 140, k / 2 * 32);
/* 175 */       k++;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 180 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)equip);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 187 */     GuiSection filter = new GuiSection();
/*     */ 
/*     */     
/* 190 */     SPRITE oo = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 194 */           GFORMAT.i(text, (SETT.ROOMS()).construction.instances());
/*     */         }
/* 196 */       }).hv((SPRITE)(UI.icons()).s.hammer.createColored((GCOLOR.UI()).GREAT.hovered)).asSprite();
/* 197 */     final ConstructionList li = new ConstructionList();
/* 198 */     filter.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel(oo)
/*     */         {
/*     */           protected void clickA() {
/* 201 */             (VIEW.s()).panels.add(li, false);
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 205 */             selectedSet((VIEW.s()).panels.added(li));
/*     */           }
/* 208 */         }).setDim(48, 64));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 213 */     final GETTER.GETTER_IMP<RoomCategories.RoomCategoryMain> cat = new GETTER.GETTER_IMP((SETT.ROOMS()).CATS.MAIN_INFRA);
/*     */ 
/*     */     
/* 216 */     for (RoomCategories.RoomCategoryMain c : (SETT.ROOMS()).CATS.MAINS) {
/* 217 */       filter.addRightC(0, (RENDEROBJ)new CatButt(c, cat));
/*     */     }
/*     */ 
/*     */     
/* 221 */     final GButt.ButtPanel unused = new GButt.ButtPanel((SPRITE)(UI.icons()).m.questionmark)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 225 */           selectedToggle();
/*     */         }
/*     */       };
/* 228 */     unused.body().setHeight((filter.body().height() - 16));
/* 229 */     filter.addRightC(2, (RENDEROBJ)unused);
/*     */     
/* 231 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)filter);
/*     */     
/* 233 */     ArrayListGrower<RENDEROBJ> rows = new ArrayListGrower();
/* 234 */     final ArrayListGrower<RoomBlueprintIns<?>> rs = new ArrayListGrower();
/*     */     
/* 236 */     for (RoomBlueprintIns<?> roomBlueprintIns : (Iterable<RoomBlueprintIns<?>>)SETT.ROOMS().ins()) {
/* 237 */       if ((rooms[roomBlueprintIns.index()]).clicker != null) {
/* 238 */         rows.add((rooms[roomBlueprintIns.index()]).clicker);
/* 239 */         rs.add(roomBlueprintIns);
/*     */       } 
/*     */     } 
/*     */     
/* 243 */     GScrollRows gScrollRows = new GScrollRows((Iterable)rows, HEIGHT - this.section.body().y2() - 16)
/*     */       {
/*     */         protected boolean passesFilter(int i, RENDEROBJ o) {
/* 246 */           RoomBlueprintIns<?> b = (RoomBlueprintIns)rs.get(i);
/* 247 */           if (b.cat.main() == cat.get() && (
/* 248 */             unused.selectedIs() || b.instancesSize() > 0)) {
/* 249 */             return true;
/*     */           }
/* 251 */           return false;
/*     */         }
/*     */       };
/*     */     
/* 255 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)gScrollRows.view());
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
/*     */   public void open(RoomEquip w) {
/* 267 */     (VIEW.s()).panels.add(this.tools[w.index()], true);
/*     */   }
/*     */   
/*     */   private static class CatButt
/*     */     extends GButt.BSection {
/*     */     int employees;
/*     */     int needed;
/*     */     int rooms;
/*     */     private final GETTER.GETTER_IMP<RoomCategories.RoomCategoryMain> cc;
/*     */     private final RoomCategories.RoomCategoryMain c;
/*     */     
/*     */     CatButt(RoomCategories.RoomCategoryMain c, GETTER.GETTER_IMP<RoomCategories.RoomCategoryMain> cc) {
/* 279 */       this.cc = cc;
/* 280 */       this.c = c;
/*     */       
/* 282 */       add((SPRITE)c.icon, 0, 0);
/*     */       
/* 284 */       addDownC(0, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 288 */               GFORMAT.i(text, UIPanelMain.CatButt.this.employees);
/*     */             }
/* 291 */           }).r(DIR.N));
/*     */ 
/*     */       
/* 294 */       addDownC(0, (SPRITE)new SPRITE.Imp(40, 10)
/*     */           {
/*     */             
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */             {
/* 299 */               if (UIPanelMain.CatButt.this.needed > 0) {
/* 300 */                 GMeter.render(r, GMeter.C_REDGREEN, UIPanelMain.CatButt.this.employees / UIPanelMain.CatButt.this.needed, X1, X2, Y1, Y2);
/*     */               }
/*     */             }
/*     */           });
/* 304 */       pad(6, 8);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 310 */       super.render(r, ds);
/* 311 */       if (this.rooms == 0) {
/* 312 */         OPACITY.O50.bind();
/* 313 */         COLOR.BLACK.render(r, (RECTANGLE)body());
/* 314 */         OPACITY.unbind();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 320 */       this.cc.set(this.c);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 325 */       GBox b = (GBox)text;
/* 326 */       b.title(this.c.name);
/* 327 */       b.textLL(Dic.¤¤Employees);
/* 328 */       b.tab(6);
/* 329 */       b.add((SPRITE)GFORMAT.iofkInv(b.text(), this.employees, this.needed));
/* 330 */       b.NL();
/* 331 */       b.textLL(Dic.¤¤Amount);
/* 332 */       b.tab(6);
/* 333 */       b.add((SPRITE)GFORMAT.i(b.text(), this.rooms));
/* 334 */       b.NL();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 339 */       this.employees = 0;
/* 340 */       this.needed = 0;
/* 341 */       this.rooms = 0;
/*     */       
/* 343 */       for (int ri = 0; ri < this.c.all().size(); ri++) {
/* 344 */         RoomBlueprintImp rb = (RoomBlueprintImp)this.c.all().get(ri);
/*     */         
/* 346 */         if (rb instanceof RoomBlueprintIns) {
/* 347 */           this.rooms++;
/* 348 */           RoomBlueprintIns<?> rr = (RoomBlueprintIns)rb;
/* 349 */           if (rr.employmentExtra() != null) {
/*     */ 
/*     */             
/* 352 */             this.employees += rr.employmentExtra().employed(null);
/* 353 */             this.needed += rr.employment().neededWorkers();
/*     */           } 
/*     */         } 
/*     */       } 
/* 357 */       selectedSet((this.cc.get() == this.c));
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Emp
/*     */     extends GuiSection
/*     */   {
/* 364 */     private final ArrayList<WGROUP> ll = new ArrayList((Iterable)WGROUP.all());
/*     */ 
/*     */     
/*     */     Emp() {
/* 368 */       addRightC(0, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 372 */               GFORMAT.iBig(text, (SETT.ROOMS()).employment.NEEDED.get());
/*     */             }
/* 375 */           }).hh(Dic.¤¤Needed));
/*     */       
/* 377 */       addRightC(100, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 381 */               GFORMAT.iBig(text, (SETT.ROOMS()).employment.TARGET.get(null));
/*     */             }
/* 384 */           }).hh(Dic.¤¤Target));
/*     */ 
/*     */       
/* 387 */       final HISTORY_INT em = (SETT.ROOMS()).employment.hEmployed();
/* 388 */       GStaples chart = new GStaples(em.historyRecords())
/*     */         {
/*     */           
/*     */           protected void hover(GBox box, int stapleI)
/*     */           {
/* 393 */             box.title(((STATS.WORK()).EMPLOYED.stat().info()).name);
/*     */             
/* 395 */             int ii = em.historyRecords() - stapleI - 1;
/* 396 */             GText t = box.text();
/* 397 */             DicTime.setDaysAgo((Str)t, ii);
/* 398 */             t.adjustWidth();
/* 399 */             box.add((SPRITE)t.lablify());
/* 400 */             box.NL();
/* 401 */             box.add((SPRITE)GFORMAT.i(box.text(), em.get(ii)));
/* 402 */             box.NL(8);
/*     */ 
/*     */             
/* 405 */             if (stapleI > 0) {
/* 406 */               for (RoomEmployment e : (SETT.ROOMS()).employment.ALL()) {
/* 407 */                 int now = e.history().get(ii);
/* 408 */                 int delta = now - e.history().get(ii + 1);
/* 409 */                 if (delta != 0) {
/* 410 */                   box.add((e.blueprint().iconBig()).small);
/* 411 */                   box.textLL((e.blueprint()).info.names);
/* 412 */                   box.tab(7);
/* 413 */                   box.add((SPRITE)GFORMAT.iIncr(box.text(), delta));
/* 414 */                   box.NL();
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected double getValue(int stapleI) {
/* 423 */             return em.get(em.historyRecords() - stapleI - 1);
/*     */           }
/*     */         };
/* 426 */       chart.normalize(true);
/*     */       
/* 428 */       chart.body().setWidth(410.0D).setHeight(80.0D);
/*     */       
/* 430 */       addRelBody(8, DIR.S, (RENDEROBJ)chart);
/*     */ 
/*     */ 
/*     */       
/* 434 */       GTableBuilder bb = new GTableBuilder()
/*     */         {
/*     */           public int nrOFEntries()
/*     */           {
/* 438 */             return UIPanelMain.Emp.this.ll.size() + 1;
/*     */           }
/*     */         };
/*     */       
/* 442 */       bb.column("", 48, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier)
/*     */             {
/* 446 */               return (RENDEROBJ)new HOVERABLE.HoverableAbs(32)
/*     */                 {
/*     */                   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */                   {
/* 450 */                     int i = ((Integer)ier.get()).intValue();
/* 451 */                     if (i == (UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.size()) {
/* 452 */                       (UI.icons()).m.arrow_right.renderC(r, this.body.cX(), this.body.cY());
/*     */                     } else {
/* 454 */                       (((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(i)).race.appearance()).icon.renderC(r, this.body.cX(), this.body.cY());
/* 455 */                       ((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(i)).type.CLASS.iconSmall().renderC(r, this.body.cX() + 8, this.body.cY() + 4);
/*     */                     } 
/*     */                   }
/*     */ 
/*     */                   
/*     */                   public void hoverInfoGet(GUI_BOX text) {
/* 461 */                     GBox b = (GBox)text;
/* 462 */                     int i = ((Integer)ier.get()).intValue();
/* 463 */                     if (i == (UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.size()) {
/* 464 */                       b.title(Dic.¤¤Total);
/*     */                     } else {
/* 466 */                       Str.TMP.clear().add(((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(i)).race.info.names);
/* 467 */                       Str.TMP.s().add('(').add(((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(i)).type.CLASS.names).add(')');
/* 468 */                       b.title((CharSequence)Str.TMP);
/*     */                     } 
/*     */                   }
/*     */                 };
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */       
/* 477 */       int s = 120;
/*     */       
/* 479 */       bb.column(Dic.¤¤Workforce, s, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier)
/*     */             {
/* 483 */               return (RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 487 */                     GFORMAT.i(text, STATS.WORK().workforce((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(((Integer)ier.get()).intValue())));
/*     */                   }
/* 490 */                 }).r(DIR.NW);
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */       
/* 496 */       bb.column(((STATS.WORK()).incap.stat.info()).name, s, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier)
/*     */             {
/* 500 */               return (RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 504 */                     int i = ((Integer)ier.get()).intValue();
/* 505 */                     if (i != (UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.size()) {
/* 506 */                       GFORMAT.i(text, -(STATS.WORK()).incap.get(((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(((Integer)ier.get()).intValue())).type, ((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(((Integer)ier.get()).intValue())).race));
/*     */                     } else {
/* 508 */                       GFORMAT.i(text, -(STATS.WORK()).incap.get());
/*     */                     }
/*     */                   
/*     */                   }
/* 512 */                 }).r(DIR.NW);
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */       
/* 518 */       bb.column(UIPanelMain.¤¤emp, s, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier)
/*     */             {
/* 522 */               return (RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 526 */                     int i = ((Integer)ier.get()).intValue();
/* 527 */                     if (i != (UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.size()) {
/* 528 */                       GFORMAT.i(text, (SETT.ROOMS()).employment.TARGET.get((UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(((Integer)ier.get()).intValue())));
/*     */                     } else {
/* 530 */                       GFORMAT.i(text, (SETT.ROOMS()).employment.TARGET.get((UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(0)));
/*     */                     }
/*     */                   
/*     */                   }
/* 534 */                 }).r(DIR.NW);
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */       
/* 540 */       bb.column(Dic.¤¤Rate, s, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier)
/*     */             {
/* 544 */               return (RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 548 */                     double wf = STATS.WORK().workforce((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(((Integer)ier.get()).intValue()));
/* 549 */                     GFORMAT.perc(text, (SETT.ROOMS()).employment.TARGET.get((UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(((Integer)ier.get()).intValue())) / wf);
/*     */                   }
/* 552 */                 }).r(DIR.NW);
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 559 */       bb.column(UIPanelMain.¤¤oddjobbers, s, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier)
/*     */             {
/* 563 */               return (RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 567 */                     int i = ((Integer)ier.get()).intValue();
/* 568 */                     if (i != (UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.size()) {
/* 569 */                       GFORMAT.i(text, (STATS.WORK().workforce((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(((Integer)ier.get()).intValue())) - (SETT.ROOMS()).employment.TARGET.get((UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(((Integer)ier.get()).intValue()))));
/*     */                     } else {
/* 571 */                       GFORMAT.i(text, (STATS.WORK().workforce() - (SETT.ROOMS()).employment.TARGET.get(null)));
/*     */                     }
/*     */                   
/*     */                   }
/* 575 */                 }).r(DIR.NW);
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */       
/* 581 */       addRelBody(8, DIR.S, (RENDEROBJ)bb.create(8, true));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 589 */       this.ll.clearSloppy();
/*     */       
/* 591 */       for (WGROUP g : WGROUP.all()) {
/* 592 */         if ((STATS.POP()).POP.data(g.type.CLASS).get(g.race) > 0) {
/* 593 */           this.ll.add(g);
/*     */         }
/*     */       } 
/* 596 */       super.render(r, ds);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIPanelMain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */