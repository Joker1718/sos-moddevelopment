/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEmploymentIns;
/*     */ import settlement.room.main.employment.RoomEmploymentSimple;
/*     */ import settlement.room.main.employment.RoomEquip;
/*     */ import settlement.room.main.job.ROOM_EMPLOY_AUTO;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.muls.StatsMultipliers;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GChart;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.gui.slider.GTarget;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.statistics.HISTORY;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.main.VIEW;
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
/*     */ class I
/*     */   extends UIRoomModule
/*     */ {
/*     */   private final RoomBlueprintIns<?> blueprint;
/*  95 */   private final GChart chart = new GChart();
/*     */   
/*     */   I(RoomBlueprintIns<?> blue) {
/*  98 */     this.blueprint = blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendManageScr(GGrid grid, GGrid text, GuiSection sExta) {
/* 103 */     grid.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 107 */             GFORMAT.iofkInv(text, 
/* 108 */                 ModuleEmployment.I.this.blueprint.employment().employed(), 
/* 109 */                 ModuleEmployment.I.this.blueprint.employment().neededWorkers());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 114 */             if (ModuleEmployment.I.this.blueprint.employmentExtra() != null) {
/* 115 */               b.title((STATS.WORK()).EMPLOYED.info.name);
/* 116 */               b.text((ModuleEmployment.I.access$0(ModuleEmployment.I.this)).¤¤EMPLOYEES_DESC);
/* 117 */               b.NL(8);
/* 118 */               b.add(ModuleEmployment.I.this.chart.sprite((HISTORY)ModuleEmployment.I.this.blueprint.employmentExtra().history()));
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 123 */         }).hh((SPRITE)(SPRITES.icons()).s.human));
/*     */ 
/*     */ 
/*     */     
/* 127 */     if (this.blueprint.employmentExtra() != null) {
/*     */       
/* 129 */       grid.add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 133 */               GFORMAT.perc(text, ModuleEmployment.I.this.blueprint.employment().efficiency());
/*     */             }
/* 136 */           }).hh((SPRITE)(SPRITES.icons()).s.cog).hoverInfoSet(RoomEmploymentIns.¤¤WorkloadD));
/*     */       
/* 138 */       grid.add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 142 */               GFORMAT.perc(text, ModuleEmployment.I.this.blueprint.employment().proximity());
/*     */             }
/* 145 */           }).hh((SPRITE)(SPRITES.icons()).s.wheel).hoverInfoSet(RoomEmploymentIns.¤¤ProximityD));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 151 */     if (this.blueprint.employment().worksNights()) {
/* 152 */       grid.add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 156 */               GFORMAT.f(text, Double.NaN);
/*     */             }
/* 158 */           }).hh((SPRITE)(SPRITES.icons()).s.clock).hoverInfoSet(ModuleEmployment.this.¤¤SHIFT_NIGHT));
/*     */     } else {
/* 160 */       grid.add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 164 */               GFORMAT.i(text, (int)(ModuleEmployment.I.this.blueprint.employment().getShiftStart() * TIME.hoursPerDay()));
/*     */             }
/* 166 */           }).hh((SPRITE)(SPRITES.icons()).s.clock).hoverInfoSet(ModuleEmployment.this.¤¤SHIFT_START));
/*     */     } 
/*     */     
/* 169 */     if (this.blueprint.employmentExtra() != null) {
/*     */ 
/*     */       
/* 172 */       GTarget t = new GTarget(20, false, true, (INT.INTE)(this.blueprint.employmentExtra()).priority);
/* 173 */       CLICKABLE cLICKABLE = (new CLICKABLE.Pair((RENDEROBJ)new GHeader((SPRITE)(SPRITES.icons()).s.alert), (RENDEROBJ)t, DIR.E, 2)).hoverInfoSet(Dic.¤¤Priority);
/* 174 */       grid.add((RENDEROBJ)cLICKABLE);
/*     */     } 
/*     */     
/* 177 */     grid.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 181 */             double emp = (ModuleEmployment.I.this.blueprint.employment().employed() - 150);
/* 182 */             if (emp <= 0.0D)
/*     */               return; 
/* 184 */             emp = Math.pow(emp, 1.2D);
/* 185 */             GFORMAT.perc(text, emp * (ModuleEmployment.I.this.blueprint.employment()).accidentsPerYear / (BOOSTABLES.CIVICS()).ACCIDENT.get((BOOSTABLE_O)HCLASS_RACE.clP()), 2);
/* 186 */             text.normalify();
/*     */           }
/* 189 */         }).hh((SPRITE)(SPRITES.icons()).s.death).hoverTitleSet(Dic.¤¤AccidentRate).hoverInfoSet(Dic.¤¤AccidentRateD));
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
/*     */   public void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {
/* 201 */     appliers.add(new UIRoomBulkApplier((CharSequence)(new Str(ModuleEmployment.this.¤¤WORKERS_INC)).insert(0, "25"))
/*     */         {
/*     */           protected void apply(RoomInstance t)
/*     */           {
/* 205 */             t.employees().neededSet(t.employees().needed() + 25);
/*     */           }
/*     */         });
/* 208 */     appliers.add(new UIRoomBulkApplier((CharSequence)(new Str(ModuleEmployment.this.¤¤WORKERS_INC)).insert(0, "5"))
/*     */         {
/*     */           protected void apply(RoomInstance t)
/*     */           {
/* 212 */             t.employees().neededSet(t.employees().needed() + 5);
/*     */           }
/*     */         });
/* 215 */     appliers.add(new UIRoomBulkApplier((CharSequence)(new Str(ModuleEmployment.this.¤¤WORKERS_INC)).insert(0, "1"))
/*     */         {
/*     */           protected void apply(RoomInstance t)
/*     */           {
/* 219 */             t.employees().neededSet(t.employees().needed() + 1);
/*     */           }
/*     */         });
/* 222 */     appliers.add(new UIRoomBulkApplier((CharSequence)(new Str(ModuleEmployment.this.¤¤WORKERS_DEC)).insert(0, "1"))
/*     */         {
/*     */           protected void apply(RoomInstance t)
/*     */           {
/* 226 */             t.employees().neededSet(t.employees().needed() - 1);
/*     */           }
/*     */         });
/* 229 */     appliers.add(new UIRoomBulkApplier((CharSequence)(new Str(ModuleEmployment.this.¤¤WORKERS_DEC)).insert(0, "5"))
/*     */         {
/*     */           protected void apply(RoomInstance t)
/*     */           {
/* 233 */             t.employees().neededSet(t.employees().needed() - 5);
/*     */           }
/*     */         });
/* 236 */     appliers.add(new UIRoomBulkApplier((CharSequence)(new Str(ModuleEmployment.this.¤¤WORKERS_DEC)).insert(0, "25"))
/*     */         {
/*     */           protected void apply(RoomInstance t)
/*     */           {
/* 240 */             t.employees().neededSet(t.employees().needed() - 25);
/*     */           }
/*     */         });
/*     */     
/* 244 */     if (this.blueprint instanceof ROOM_EMPLOY_AUTO) {
/* 245 */       appliers.add(new UIRoomBulkApplier((CharSequence)(new Str(ModuleEmployment.this.¤¤AUTO)).s().add(Dic.¤¤on))
/*     */           {
/*     */             
/*     */             protected void apply(RoomInstance t)
/*     */             {
/* 250 */               boolean b = ((ROOM_EMPLOY_AUTO)t.blueprint()).autoEmploy((Room)t);
/* 251 */               if (!b && t.employees().needed() == 0) {
/* 252 */                 t.employees().neededSet(1);
/*     */               }
/* 254 */               ((ROOM_EMPLOY_AUTO)t.blueprint()).autoEmploy((Room)t, true);
/*     */             }
/*     */           });
/* 257 */       appliers.add(new UIRoomBulkApplier((CharSequence)(new Str(ModuleEmployment.this.¤¤AUTO)).s().add(Dic.¤¤off))
/*     */           {
/*     */ 
/*     */             
/*     */             protected void apply(RoomInstance t)
/*     */             {
/* 263 */               ((ROOM_EMPLOY_AUTO)t.blueprint()).autoEmploy((Room)t, false);
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */     
/* 269 */     if ((STATS.MULTIPLIERS()).OVERTIME.canMark((RoomBlueprint)this.blueprint)) {
/* 270 */       appliers.add(new UIRoomBulkApplier((STATS.MULTIPLIERS()).OVERTIME.name)
/*     */           {
/*     */             protected void apply(RoomInstance t)
/*     */             {
/* 274 */               for (Humanoid a : t.employees().employees()) {
/* 275 */                 if ((STATS.MULTIPLIERS()).OVERTIME.canBeMarked(a.indu())) {
/* 276 */                   (STATS.MULTIPLIERS()).OVERTIME.mark(a, true);
/*     */                 }
/*     */               } 
/*     */             }
/*     */           });
/* 281 */       appliers.add(new UIRoomBulkApplier((STATS.MULTIPLIERS()).DAY_OFF.name)
/*     */           {
/*     */             protected void apply(RoomInstance t)
/*     */             {
/* 285 */               for (Humanoid a : t.employees().employees()) {
/* 286 */                 if ((STATS.MULTIPLIERS()).DAY_OFF.canBeMarked(a.indu())) {
/* 287 */                   (STATS.MULTIPLIERS()).DAY_OFF.mark(a, true);
/*     */                 }
/*     */               } 
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 296 */     if (this.blueprint.employmentExtra() != null) {
/* 297 */       sorts.add(new GTableSorter.GTSort<RoomInstance>(RoomEmploymentIns.¤¤Workload)
/*     */           {
/*     */             public int cmp(RoomInstance current, RoomInstance cmp)
/*     */             {
/* 301 */               double e1 = current.employees().efficiency();
/* 302 */               double e2 = cmp.employees().efficiency();
/* 303 */               if (e1 == e2)
/* 304 */                 return 0; 
/* 305 */               if (e1 < e2)
/* 306 */                 return -1; 
/* 307 */               return 1;
/*     */             }
/*     */ 
/*     */             
/*     */             public void format(RoomInstance h, GText text) {
/* 312 */               GFORMAT.perc(text, h.employees().efficiency());
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendButt(GuiSection s, final GETTER<RoomInstance> get) {
/* 324 */     INT.INTE in = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 328 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 333 */           return ((RoomInstance)get.get()).employees().max();
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 338 */           return ((RoomInstance)get.get()).employees().needed();
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 343 */           ((RoomInstance)get.get()).employees().neededSet(t);
/*     */         }
/*     */       };
/*     */     
/* 347 */     RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(20, 18)
/*     */       {
/* 349 */         GStat st = new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 353 */               GFORMAT.i(text, Math.min(((RoomInstance)get.get()).employees().employed(), ((RoomInstance)get.get()).employees().needed()));
/*     */             }
/*     */           };
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, float ds) {
/* 359 */           int e = ((RoomInstance)get.get()).employees().employed();
/* 360 */           int n = ((RoomInstance)get.get()).employees().needed();
/* 361 */           e = Math.min(e, n);
/* 362 */           if (n > 0)
/* 363 */             GMeter.render(r, GMeter.C_REDGREEN, e / n, this.body.x1() - 20, this.body.x2() + 20, this.body.y1(), this.body.y2()); 
/* 364 */           OPACITY.O50.bind();
/* 365 */           COLOR.BLACK.render(r, this.body.cX() - this.st.width() / 2 - 2, this.body.cX() + this.st.width() / 2 + 2, this.body.y1(), this.body.y2());
/* 366 */           OPACITY.unbind();
/* 367 */           this.st.renderC(r, (RECTANGLE)this.body);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 374 */     GTarget ss = new GTarget(52, false, true, (RENDEROBJ)renderImp, in)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 377 */           text.title(Dic.¤¤Employees);
/* 378 */           GBox b = (GBox)text;
/* 379 */           b.add((SPRITE)GFORMAT.iofkInv(b.text(), ((RoomInstance)get.get()).employees().employed(), ((RoomInstance)get.get()).employees().needed()));
/*     */         }
/*     */       };
/*     */     
/* 383 */     s.addRelBody(8, DIR.E, (RENDEROBJ)ss);
/*     */     
/* 385 */     s.addRightC(32, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 389 */             GFORMAT.perc(text, ((RoomInstance)get.get()).employees().efficiency());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 394 */             b.title(RoomEmploymentIns.¤¤Workload);
/* 395 */             b.add((SPRITE)GFORMAT.perc(b.text(), ((RoomInstance)get.get()).employees().efficiency()));
/*     */           }
/* 398 */         }).decrease().r(DIR.NE));
/*     */     
/* 400 */     if (this.blueprint instanceof ROOM_EMPLOY_AUTO) {
/* 401 */       CLICKABLE c = (new GButt.Checkbox()
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 405 */             boolean b = ((ROOM_EMPLOY_AUTO)((RoomInstance)get.get()).blueprint()).autoEmploy((Room)get.get());
/* 406 */             if (!b && ((RoomInstance)get.get()).employees().needed() == 0) {
/* 407 */               ((RoomInstance)get.get()).employees().neededSet(1);
/*     */             }
/* 409 */             ((ROOM_EMPLOY_AUTO)((RoomInstance)get.get()).blueprint()).autoEmploy((Room)get.get(), !b);
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 413 */             selectedSet(((ROOM_EMPLOY_AUTO)((RoomInstance)get.get()).blueprint()).autoEmploy((Room)get.get()));
/*     */           }
/* 416 */         }).hoverTitleSet(ModuleEmployment.this.¤¤AUTO).hoverInfoSet(ModuleEmployment.this.¤¤AUTO_DESC);
/* 417 */       c.body().moveCY(s.getLast().cY());
/* 418 */       c.body().moveX2(s.body().width());
/* 419 */       s.addRightC(8, (RENDEROBJ)c);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox box, Room room, int rx, int ry) {
/* 427 */     RoomInstance i = (RoomInstance)room;
/* 428 */     box.text((i.blueprint().employment()).title);
/* 429 */     box.add((SPRITE)GFORMAT.iofkInv(box.text(), i.employees().employed(), i.employees().needed()));
/* 430 */     box.space();
/* 431 */     box.text();
/* 432 */     if (i.blueprintI().employmentExtra() != null)
/* 433 */       box.text(RoomEmploymentIns.¤¤Workload).add((SPRITE)GFORMAT.perc(box.text(), i.employees().efficiency())); 
/* 434 */     box.NL();
/* 435 */     highlightWorkers(room);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void problem(Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings, Room room, int rx, int ry) {
/* 441 */     RoomInstance i = (RoomInstance)room;
/*     */     
/* 443 */     if (i.blueprintI().employmentExtra() != null) {
/*     */       
/* 445 */       if (i.employees().employed() < i.employees().needed())
/* 446 */         if (i.employees().employed() == 0) {
/* 447 */           errors.add(ModuleEmployment.this.¤¤WORKERS_NONE);
/*     */         } else {
/* 449 */           warnings.add(ModuleEmployment.this.¤¤WORKERS_INSUFFICIENT);
/*     */         }  
/* 451 */       if ((1.0D - i.employees().efficiency()) * (i.employees().employed() - 1) > 1.0D) {
/* 452 */         warnings.add(ModuleEmployment.this.¤¤WORKLOAD_LOW);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 459 */     if (room instanceof JOBMANAGER_HASER) {
/* 460 */       JOBMANAGER_HASER h = (JOBMANAGER_HASER)room;
/* 461 */       boolean m = false;
/* 462 */       for (RESOURCE r : RESOURCES.ALL()) {
/* 463 */         if (!h.getWork().resourceReachable(r)) {
/* 464 */           m = true;
/*     */         }
/*     */       } 
/*     */       
/* 468 */       if (m) {
/* 469 */         Str s = (Str)free.pop();
/* 470 */         s.add(Dic.¤¤Unavailable);
/* 471 */         for (RESOURCE r : RESOURCES.ALL()) {
/* 472 */           if (!h.getWork().resourceReachable(r)) {
/* 473 */             s.s().add(r.name).add(',');
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 478 */         errors.add(s);
/*     */       } 
/*     */     } 
/*     */   } private void highlightWorkers(Room room) {
/*     */     byte b;
/*     */     int i;
/*     */     ENTITY[] arrayOfENTITY;
/* 485 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 486 */       if (e instanceof Humanoid) {
/* 487 */         Humanoid a = (Humanoid)e;
/* 488 */         if ((STATS.WORK()).EMPLOYED.get(a) == room) {
/* 489 */           SETT.OVERLAY().add(e);
/*     */         }
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendPanel(final GuiSection section, final GETTER<RoomInstance> get, int x1, int y1) {
/* 498 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 502 */           ModuleEmployment.I.this.highlightWorkers((Room)get.get());
/* 503 */           super.render(r, ds);
/* 504 */           GCOLOR.UI().border().render(r, section.body().x1() + 8, section.body().x2() - 8, body().y2() - 1, body().y2());
/*     */         }
/*     */       };
/*     */     
/* 508 */     HOVERABLE hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 512 */           GFORMAT.iofkInv(text, ModuleEmployment.I.this.g(get).employees().employed(), ModuleEmployment.I.this.g(get).employees().needed());
/*     */         }
/* 514 */       }).hh((SPRITE)(SPRITES.icons()).s.human).hoverTitleSet((this.blueprint.employment()).title).hoverInfoSet(ModuleEmployment.this.¤¤EMPLOYEES_DESC);
/*     */ 
/*     */     
/* 517 */     s.add((RENDEROBJ)hOVERABLE);
/*     */     
/* 519 */     if (this.blueprint.employmentExtra() != null) {
/* 520 */       hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 524 */             GFORMAT.perc(text, ModuleEmployment.I.this.g(get).employees().efficiency());
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 530 */             b.title(RoomEmploymentIns.¤¤Workload);
/* 531 */             b.text(RoomEmploymentIns.¤¤WorkloadD);
/* 532 */             b.NL();
/* 533 */             b.textL(DicTime.¤¤Today);
/* 534 */             b.add((SPRITE)GFORMAT.perc(b.text(), ModuleEmployment.I.this.g(get).employees().efficiencySoFar()));
/*     */           }
/* 537 */         }).hh((SPRITE)(SPRITES.icons()).s.cog);
/* 538 */       s.addRightC(60, (RENDEROBJ)hOVERABLE);
/* 539 */       hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 543 */             GFORMAT.perc(text, ModuleEmployment.I.this.g(get).employees().proximity());
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 549 */             b.title(RoomEmploymentIns.¤¤Proximity);
/* 550 */             b.text(RoomEmploymentIns.¤¤ProximityD);
/* 551 */             b.NL();
/* 552 */             b.textL(DicTime.¤¤Today);
/* 553 */             b.add((SPRITE)GFORMAT.perc(b.text(), ModuleEmployment.I.this.g(get).employees().proximitySoFar()));
/* 554 */             b.NL();
/* 555 */             if ((S.get()).developer) {
/* 556 */               b.add((SPRITE)b.text().add(ModuleEmployment.I.this.g(get).employees().fetchSecondsPerPerson()));
/*     */ 
/*     */             
/*     */             }
/*     */           }
/* 561 */         }).hh((SPRITE)(SPRITES.icons()).s.wheel);
/* 562 */       s.addRightC(60, (RENDEROBJ)hOVERABLE);
/*     */     } 
/*     */     
/* 565 */     final RoomEmploymentSimple ee = this.blueprint.employment();
/* 566 */     for (RoomEquip w : ee.tools()) {
/* 567 */       hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 571 */             GFORMAT.f(text, ModuleEmployment.I.this.g(get).employees().toolsPerPerson(w));
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 578 */             RoomEmploymentIns e = ModuleEmployment.I.this.g(get).employees();
/*     */             
/* 580 */             b.add(w.info);
/* 581 */             b.NL(8);
/*     */             
/* 583 */             b.textLL((CharSequence)b.text().lablify().add(Dic.¤¤Target).para(Dic.¤¤global));
/* 584 */             b.tab(7);
/* 585 */             b.add((SPRITE)GFORMAT.iofk(b.text(), w.target(ee).get(), w.target(ee).max()));
/* 586 */             b.NL();
/*     */             
/* 588 */             b.textLL(Dic.¤¤Current);
/* 589 */             b.tab(7);
/* 590 */             b.add((SPRITE)GFORMAT.iofk(b.text(), e.tools(w), e.toolsTarget(w)));
/* 591 */             b.NL();
/*     */             
/* 593 */             b.textLL((CharSequence)b.text().lablify().add(Dic.¤¤Degrade).para(DicTime.¤¤Day));
/* 594 */             b.tab(7);
/* 595 */             b.add((SPRITE)GFORMAT.f0(b.text(), e.tools(w) * w.degradePerDay));
/*     */             
/* 597 */             b.sep();
/*     */             
/* 599 */             double v = (w.boost(ModuleEmployment.I.this.blueprint.employment())).booster.getValue(e.toolD(w));
/*     */             
/* 601 */             (w.boost(ModuleEmployment.I.this.blueprint.employment())).booster.hover((GUI_BOX)b, v);
/* 602 */             (w.boost(ModuleEmployment.I.this.blueprint.employment())).booster.hoverSpan((GUI_BOX)b, v);
/* 603 */             b.NL(8);
/*     */             
/* 605 */             if ((S.get()).debug)
/*     */             {
/* 607 */               b.NL();
/* 608 */               b.text("res " + e.toolReserved(w));
/* 609 */               b.NL();
/* 610 */               b.text("need " + e.toolsNeeded(w));
/* 611 */               b.NL();
/* 612 */               b.text("target " + e.toolsTarget(w));
/* 613 */               b.NL();
/* 614 */               b.text("expire " + e.toolsToExpire(w));
/* 615 */               b.NL();
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 623 */         }).hh((w.resource.icon()).small);
/* 624 */       s.addRightC(60, (RENDEROBJ)hOVERABLE);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 632 */     INT.INTE t = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 636 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 641 */           return ModuleEmployment.I.this.g(get).employees().max();
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 646 */           return ModuleEmployment.I.this.g(get).employees().needed();
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 651 */           ModuleEmployment.I.this.g(get).employees().neededSet(t);
/*     */         }
/*     */       };
/*     */     
/* 655 */     GSliderInt m = new GSliderInt(t, 160, true)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 658 */           text.title((ModuleEmployment.I.this.blueprint.employment()).title);
/* 659 */           super.hoverInfoGet(text);
/* 660 */           text.NL(4);
/* 661 */           text.text((ModuleEmployment.I.access$0(ModuleEmployment.I.this)).¤¤EMPLOYEES_DESC);
/*     */         }
/*     */       };
/* 664 */     s.addRelBody(4, DIR.S, (RENDEROBJ)m);
/*     */     
/* 666 */     CLICKABLE cLICKABLE = (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).s.menu)
/*     */       {
/*     */         protected void clickA() {
/* 669 */           (VIEW.s()).ui.subjects.showProfession(ModuleEmployment.I.this.g(get));
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 674 */           activeSet((ModuleEmployment.I.this.g(get).employees().employed() > 0));
/*     */         }
/* 676 */       }).repetativeSet(true).hoverInfoSet(ModuleEmployment.this.¤¤WORKERS_INSPECT);
/* 677 */     s.addRightC(12, (RENDEROBJ)cLICKABLE);
/*     */     
/* 679 */     if ((STATS.MULTIPLIERS()).OVERTIME.canMark((RoomBlueprint)this.blueprint)) {
/*     */       
/* 681 */       s.addRightC(8, (RENDEROBJ)ModuleEmployment.this.cm((StatsMultipliers.StatMultiplierAction)(STATS.MULTIPLIERS()).OVERTIME, get));
/* 682 */       s.addRightC(0, (RENDEROBJ)ModuleEmployment.this.cm((STATS.MULTIPLIERS()).DAY_OFF, get));
/*     */     } 
/*     */ 
/*     */     
/* 686 */     if (this.blueprint instanceof ROOM_EMPLOY_AUTO) {
/* 687 */       CLICKABLE c = (new GButt.ButtPanel((SPRITE)(UI.icons()).s.cog)
/*     */         {
/*     */           protected void clickA() {
/* 690 */             boolean b = ((ROOM_EMPLOY_AUTO)((RoomInstance)get.get()).blueprint()).autoEmploy((Room)get.get());
/* 691 */             if (!b && ((RoomInstance)get.get()).employees().needed() == 0) {
/* 692 */               ((RoomInstance)get.get()).employees().neededSet(1);
/*     */             }
/* 694 */             ((ROOM_EMPLOY_AUTO)((RoomInstance)get.get()).blueprint()).autoEmploy((Room)get.get(), !b);
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 698 */             selectedSet(((ROOM_EMPLOY_AUTO)((RoomInstance)get.get()).blueprint()).autoEmploy((Room)get.get()));
/*     */           }
/* 700 */         }).hoverTitleSet(ModuleEmployment.this.¤¤AUTO).hoverInfoSet(ModuleEmployment.this.¤¤AUTO_DESC);
/* 701 */       s.addRightC(8, (RENDEROBJ)c);
/*     */     } 
/*     */ 
/*     */     
/* 705 */     s.body().incrH(8.0D);
/*     */     
/* 707 */     section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RoomInstance g(GETTER<RoomInstance> g) {
/* 714 */     return (RoomInstance)g.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleEmployment$I.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */