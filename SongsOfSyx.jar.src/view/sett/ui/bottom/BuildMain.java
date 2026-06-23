/*     */ package view.sett.ui.bottom;
/*     */ import game.faction.FACTIONS;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.job.Job;
/*     */ import settlement.job.JobBuildFence;
/*     */ import settlement.job.JobBuildRoad;
/*     */ import settlement.job.JobBuildStructure;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.category.RoomCategories;
/*     */ import settlement.room.main.category.RoomCategorySub;
/*     */ import snake2d.LOG;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.keyboard.KEYS;
/*     */ import view.keyboard.KeyButt;
/*     */ import view.keyboard.KeyPage;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.room.construction.UIRoomPlacer;
/*     */ import view.tool.PLACABLE;
/*     */ 
/*     */ final class BuildMain {
/*     */   private final Inter inter;
/*     */   private static final int BUTTH = 44;
/*     */   private static final int BUTTM = 8;
/*     */   private static final int HEIGHT = 352;
/*     */   private final UIRoomPlacer placer;
/*  46 */   private final KeyMap<BParenter> map = new KeyMap();
/*  47 */   private KeyMap<Boolean> himap = new KeyMap();
/*     */ 
/*     */   
/*  50 */   private static CharSequence ¤¤Build = "¤Build:";
/*  51 */   private static CharSequence ¤¤Fences = "¤Fences";
/*  52 */   private static CharSequence ¤¤Roads = "¤Roads";
/*  53 */   private static CharSequence ¤¤move = "¤Move";
/*  54 */   private static CharSequence ¤¤Construct = "¤Construct";
/*  55 */   private static CharSequence ¤¤jobs = "Jobs";
/*  56 */   private static CharSequence ¤¤jblue = "and click to place one of your saved blueprint.";
/*     */   static {
/*  58 */     D.ts(BuildMain.class);
/*     */   }
/*     */ 
/*     */   
/*     */   BuildMain(Inter inter, UIRoomPlacer placer) {
/*  63 */     this.inter = inter;
/*  64 */     this.placer = placer;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hilight(String key) {
/*  69 */     if (this.map.get(key) != null) {
/*  70 */       ((BParenter)this.map.get(key)).higlight();
/*     */     } else {
/*  72 */       if (this.himap.containsKey(key))
/*     */         return; 
/*  74 */       this.himap.put(key, Boolean.TRUE);
/*  75 */       LOG.ln("no: " + key);
/*  76 */       LOG.ln(this.map.keysString());
/*     */     } 
/*     */   }
/*     */   
/*     */   public GuiSection create() {
/*  81 */     GuiSection s = new GuiSection();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  86 */     RoomCategories.RoomCategoryMain[] cats = {
/*  87 */         (SETT.ROOMS()).CATS.MAIN_AGRIULTURE
/*     */       };
/*  89 */     BPanel bPanel1 = create(s, (SPRITE)(UI.icons()).l.agri, (SETT.ROOMS()).CATS.MAIN_AGRIULTURE.name);
/*  90 */     append(bPanel1, cats, new RoomCategorySub[0]);
/*     */ 
/*     */     
/*  93 */     cats = new RoomCategories.RoomCategoryMain[] {
/*  94 */         (SETT.ROOMS()).CATS.MAIN_INDUSTRY
/*     */       };
/*  96 */     bPanel1 = create(s, (SPRITE)(UI.icons()).l.work, (SETT.ROOMS()).CATS.MAIN_INDUSTRY.name);
/*  97 */     append(bPanel1, cats, new RoomCategorySub[0]);
/*     */ 
/*     */     
/* 100 */     cats = new RoomCategories.RoomCategoryMain[] {
/* 101 */         (SETT.ROOMS()).CATS.MAIN_SERVICE
/*     */       };
/* 103 */     bPanel1 = create(s, (SPRITE)(UI.icons()).l.service, (SETT.ROOMS()).CATS.MAIN_SERVICE.name);
/* 104 */     append(bPanel1, cats, new RoomCategorySub[0]);
/*     */ 
/*     */     
/* 107 */     cats = new RoomCategories.RoomCategoryMain[] {
/* 108 */         (SETT.ROOMS()).CATS.MAIN_INFRA
/*     */       };
/* 110 */     bPanel1 = create(s, (SPRITE)(SETT.ROOMS()).CATS.MAIN_INFRA.icon, (SETT.ROOMS()).CATS.MAIN_INFRA.name);
/* 111 */     append(bPanel1, cats, new RoomCategorySub[] { (SETT.ROOMS()).CATS.MAIN_INFRA.misc, (SETT.ROOMS()).CATS.DECOR });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     BPanel p = create(s, (SPRITE)(UI.icons()).l.infra, ¤¤Construct);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 123 */     ACTION aCTION1 = new ACTION()
/*     */       {
/*     */         public void exe() {
/* 126 */           (VIEW.inters()).popup.close();
/* 127 */           (VIEW.s()).uiManager.disturb();
/* 128 */           (VIEW.s()).tools.place((SETT.ROOMS()).THRONE.placer);
/*     */         }
/*     */       };
/* 131 */     String name = String.valueOf(¤¤move) + " " + String.valueOf(¤¤move);
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
/* 143 */     for (RoomBlueprintImp r : (SETT.ROOMS()).CATS.MAIN_INFRA.misc.rooms());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 150 */     INFO i = new INFO(¤¤Fences, String.valueOf(¤¤Build) + " " + String.valueOf(¤¤Build));
/* 151 */     ACTION aCTION2 = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 155 */           Job j = JobBuildFence.getPlacable();
/* 156 */           if (j != null) {
/* 157 */             (VIEW.inters()).popup.close();
/* 158 */             (VIEW.s()).uiManager.disturb();
/* 159 */             (VIEW.s()).tools.place((PLACABLE)j.placer(), j.config());
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 165 */     i = new INFO(¤¤Roads, String.valueOf(¤¤Build) + " " + String.valueOf(¤¤Build));
/* 166 */     aCTION2 = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 170 */           Job j = JobBuildRoad.getPlacable();
/* 171 */           if (j != null) {
/* 172 */             (VIEW.inters()).popup.close();
/* 173 */             (VIEW.s()).uiManager.disturb();
/* 174 */             (VIEW.s()).tools.place((PLACABLE)j.placer(), j.config());
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 180 */     i = new INFO(Dic.¤¤Structures, String.valueOf(¤¤Build) + " " + String.valueOf(¤¤Build));
/* 181 */     aCTION2 = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 185 */           Job j = JobBuildStructure.getPlacable();
/* 186 */           if (j != null) {
/* 187 */             (VIEW.inters()).popup.close();
/* 188 */             (VIEW.s()).uiManager.disturb();
/* 189 */             (VIEW.s()).tools.place((PLACABLE)j.placer(), j.config());
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 195 */     final RoomCategorySub cat = (SETT.ROOMS()).CATS.DECOR;
/* 196 */     ACTION ac = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 200 */           for (RoomBlueprintImp b : cat.rooms()) {
/* 201 */             if (b.reqs.passes(FACTIONS.player())) {
/* 202 */               (VIEW.inters()).popup.close();
/* 203 */               (VIEW.s()).uiManager.disturb();
/* 204 */               BuildMain.this.placer.init(b, cat);
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/* 211 */     for (RoomBlueprintImp roomBlueprintImp : cat.rooms()) {
/*     */       
/* 213 */       B b1 = new B(this, null, (SPRITE)roomBlueprintImp.iconBig(), roomBlueprintImp.info.name)
/*     */         {
/*     */           protected void clickA() {
/* 216 */             (VIEW.inters()).popup.close();
/* 217 */             (VIEW.s()).uiManager.disturb();
/* 218 */             if ((KEYS.MAIN()).MOD.isPressed() && (VIEW.s()).ui.prints.has((RoomBlueprint)b)) {
/* 219 */               (VIEW.s()).ui.prints.open((RoomBlueprint)b);
/*     */             } else {
/*     */               
/* 222 */               BuildMain.this.placer.init(b, cat);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 228 */             activeSet(b.reqs.passes(FACTIONS.player()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 233 */             UIRoomBuild.hoverRoomBuild(b, text);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 238 */       SearchToolPanel.add((CLICKABLE)b1, roomBlueprintImp.info.name, roomBlueprintImp.info.desc);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 243 */     LinkedList<Job> li = new LinkedList();
/* 244 */     li.add((SETT.JOBS()).build_fort.build_stairs);
/* 245 */     li.add((Iterable)(SETT.JOBS()).build_fort.all);
/* 246 */     i = new INFO(Dic.¤¤Fortifications, String.valueOf(¤¤Build) + " " + String.valueOf(¤¤Build));
/* 247 */     aCTION2 = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 251 */           Job j = (SETT.JOBS()).build_fort.getPlacable();
/* 252 */           if (j != null) {
/* 253 */             (VIEW.inters()).popup.close();
/* 254 */             (VIEW.s()).uiManager.disturb();
/*     */ 
/*     */             
/* 257 */             (VIEW.s()).tools.place((PLACABLE)j.placer(), j.config());
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 265 */     RoomCategories.RoomCategoryMain[] arrayOfRoomCategoryMain2 = new RoomCategories.RoomCategoryMain[0];
/*     */ 
/*     */     
/* 268 */     append(p, arrayOfRoomCategoryMain2, new RoomCategorySub[0]);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 277 */     p = create(s, (SPRITE)(UI.icons()).l.jobs, ¤¤jobs);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 282 */     ACTION a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 286 */           (VIEW.inters()).popup.close();
/* 287 */           (VIEW.s()).tools.place((PLACABLE)(SETT.JOBS()).clearss.food.placer());
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 294 */     a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 298 */           (VIEW.inters()).popup.close();
/* 299 */           (VIEW.s()).tools.place((PLACABLE)(SETT.JOBS()).clearss.hunt);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 307 */     int id = 0; byte b;
/*     */     int j;
/*     */     PLACABLE[] arrayOfPLACABLE;
/* 310 */     for (j = (arrayOfPLACABLE = (SETT.JOBS()).clearss.placers).length, b = 0; b < j; ) { PLACABLE pp = arrayOfPLACABLE[b];
/* 311 */       if (pp != (SETT.JOBS()).clearss.returnwater.placer() && pp != (SETT.JOBS()).clearss.caveFill.placer())
/*     */       {
/*     */         
/* 314 */         id++;
/*     */       }
/*     */       b++; }
/*     */     
/* 318 */     RoomCategories.RoomCategoryMain[] arrayOfRoomCategoryMain1 = new RoomCategories.RoomCategoryMain[0];
/*     */ 
/*     */     
/* 321 */     append(p, arrayOfRoomCategoryMain1, new RoomCategorySub[0]);
/*     */ 
/*     */     
/* 324 */     ArrayListGrower<Job> jobs = new ArrayListGrower();
/* 325 */     jobs.add((Iterable)(SETT.JOBS()).fences);
/* 326 */     for (JobBuildStructure st : (SETT.JOBS()).build_structure) {
/* 327 */       jobs.add(st.wall);
/*     */     }
/* 329 */     for (JobBuildRoad r : (SETT.JOBS()).roads.all)
/* 330 */       jobs.add(r); 
/* 331 */     jobs.add((Iterable)(SETT.JOBS()).build_fort.all);
/* 332 */     jobs.add((SETT.JOBS()).build_fort.build_stairs);
/*     */     
/* 334 */     for (Job job : jobs) {
/* 335 */       BButt bButt = new BButt(job.placer().getIcon(), job.placer().name())
/*     */         {
/*     */           protected void clickA() {
/* 338 */             (VIEW.inters()).popup.close();
/* 339 */             (VIEW.s()).uiManager.disturb();
/* 340 */             (VIEW.s()).tools.place((PLACABLE)j.placer(), j.config());
/*     */           }
/*     */         };
/* 343 */       SearchToolPanel.add((CLICKABLE)bButt, job.placer().name(), job.placer().desc());
/*     */     } 
/*     */ 
/*     */     
/* 347 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   private BPanel create(GuiSection mainS, SPRITE icon, CharSequence label) {
/* 352 */     BPanel panel = new BPanel();
/* 353 */     BMain main = new BMain(panel, icon, label);
/* 354 */     panel.daddy = main;
/* 355 */     mainS.addRightC(0, (RENDEROBJ)main);
/* 356 */     return panel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void append(BPanel panel, RoomCategories.RoomCategoryMain[] cats, RoomCategorySub... ignore) {
/* 362 */     LinkedList<RoomBlueprintImp> misc = new LinkedList(); byte b;
/*     */     int i;
/*     */     RoomCategories.RoomCategoryMain[] arrayOfRoomCategoryMain;
/* 365 */     label56: for (i = (arrayOfRoomCategoryMain = cats).length, b = 0; b < i; ) { RoomCategories.RoomCategoryMain m = arrayOfRoomCategoryMain[b];
/*     */       
/* 367 */       for (RoomCategorySub ss : m.subs) {
/* 368 */         byte b2; int k; RoomCategorySub[] arrayOfRoomCategorySub1; for (k = (arrayOfRoomCategorySub1 = ignore).length, b2 = 0; b2 < k; ) { RoomCategorySub so = arrayOfRoomCategorySub1[b2];
/* 369 */           if (so == ss)
/*     */             break;  b2++; }
/*     */       
/* 372 */       }  byte b1; int j; RoomCategorySub[] arrayOfRoomCategorySub; for (j = (arrayOfRoomCategorySub = ignore).length, b1 = 0; b1 < j; ) { RoomCategorySub so = arrayOfRoomCategorySub[b1];
/* 373 */         if (so == m.misc)
/*     */           break label56; 
/*     */         b1++; }
/*     */       
/* 377 */       for (RoomBlueprintImp roomBlueprintImp : m.misc.rooms()) {
/* 378 */         misc.add(roomBlueprintImp);
/*     */       }
/*     */       b++; }
/*     */     
/* 382 */     if (misc.size() > 0) {
/* 383 */       for (RoomBlueprintImp roomBlueprintImp : misc);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 388 */     for (i = (arrayOfRoomCategoryMain = cats).length, b = 0; b < i; ) { RoomCategories.RoomCategoryMain m = arrayOfRoomCategoryMain[b];
/*     */       
/* 390 */       for (RoomCategorySub ss : m.subs) {
/* 391 */         RoomCategorySub[] arrayOfRoomCategorySub; int j = (arrayOfRoomCategorySub = ignore).length; byte b1 = 0; while (true) { if (b1 >= j) {
/*     */ 
/*     */ 
/*     */             
/* 395 */             append(panel, ss); break;
/*     */           } 
/*     */           RoomCategorySub so = arrayOfRoomCategorySub[b1];
/*     */           if (so == ss)
/*     */             break; 
/*     */           b1++; }
/*     */       
/*     */       } 
/*     */       b++; }
/* 404 */      } private BPanel append(BPanel panel, RoomCategorySub ss) { BPanel exp = new BPanel();
/* 405 */     exp.daddy = new BExp(panel, (SPRITE)ss.icon(), ss.name(), exp);
/*     */     
/* 407 */     for (RoomBlueprintImp b : ss.rooms());
/*     */ 
/*     */     
/* 410 */     return exp; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class BPanel
/*     */     implements BParenter
/*     */   {
/*     */     private BuildMain.BParenter daddy;
/*     */ 
/*     */     
/*     */     private GuiSection section;
/*     */ 
/*     */     
/* 424 */     final ArrayListGrower<BuildMain.B> butts = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CLICKABLE cl() {
/* 430 */       if (this.section == null) {
/* 431 */         GuiSection guiSection; this.section = new SPanel();
/* 432 */         this.section.body().setHeight(352.0D);
/* 433 */         this.section.body().setWidth(1.0D);
/*     */ 
/*     */         
/* 436 */         if (this.butts.size() > 8) {
/* 437 */           LinkedList<CLICKABLE> rows = new LinkedList();
/* 438 */           for (BuildMain.B b : this.butts)
/* 439 */             rows.add(b.cl()); 
/* 440 */           CLICKABLE bbs = (new GScrollRows((Iterable)rows, 352)).view();
/*     */         } else {
/* 442 */           GuiSection bb = new GuiSection();
/* 443 */           for (BuildMain.B b : this.butts) {
/* 444 */             bb.addDown(0, (RENDEROBJ)b.cl());
/*     */           }
/* 446 */           guiSection = bb;
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 451 */         int dy = 352;
/* 452 */         if (this.daddy instanceof BuildMain.BExp) {
/* 453 */           BPanel pp = ((BuildMain.B)this.daddy).daddy;
/* 454 */           dy = this.daddy.cl().body().y1() - pp.section.body().y1();
/*     */         } 
/*     */         
/* 457 */         guiSection.body().moveCY(dy);
/*     */         
/* 459 */         if (guiSection.body().y2() > this.section.body().y2()) {
/* 460 */           guiSection.body().moveY2(this.section.body().y2());
/*     */         }
/* 462 */         if (guiSection.body().y1() < this.section.body().y1()) {
/* 463 */           guiSection.body().moveY1(this.section.body().y1());
/*     */         }
/* 465 */         this.section.add((RENDEROBJ)guiSection);
/* 466 */         this.section.pad(3, 8);
/*     */       } 
/*     */ 
/*     */       
/* 470 */       return (CLICKABLE)this.section;
/*     */     }
/*     */ 
/*     */     
/*     */     public BuildMain.BParenter parent() {
/* 475 */       return this.daddy;
/*     */     }
/*     */ 
/*     */     
/*     */     public void higlight() {
/* 480 */       this.daddy.higlight();
/*     */     }
/*     */   }
/*     */   
/*     */   private class B
/*     */     extends BButt implements BParenter {
/*     */     private final BuildMain.BPanel daddy;
/*     */     private boolean con;
/*     */     
/*     */     public B(BuildMain.BPanel panel, SPRITE icon, CharSequence label) {
/* 490 */       super(icon, label);
/* 491 */       if (panel != null) {
/* 492 */         this.daddy = panel;
/* 493 */         this.daddy.butts.add(this);
/*     */       } else {
/* 495 */         this.daddy = null;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public BuildMain.BParenter parent() {
/* 502 */       return this.daddy;
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE cl() {
/* 507 */       return (CLICKABLE)this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 512 */       super.render(r, ds, isActive, isSelected, isHovered);
/* 513 */       if (this.con) {
/* 514 */         COLOR.RED2RED.renderFrame(r, (RECTANGLE)this.body, 0, 3);
/* 515 */         this.con = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void higlight() {
/* 521 */       this.con = true;
/* 522 */       this.daddy.higlight();
/*     */     }
/*     */   }
/*     */   
/*     */   private class BMain
/*     */     extends GButt.ButtPanel
/*     */     implements BParenter
/*     */   {
/*     */     private final BuildMain.BPanel pop;
/*     */     private boolean con;
/*     */     
/*     */     public BMain(BuildMain.BPanel panel, SPRITE icon, CharSequence label) {
/* 534 */       super(icon);
/* 535 */       hoverTitleSet(label);
/* 536 */       this.pop = panel;
/* 537 */       pad(6, 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public BuildMain.BParenter parent() {
/* 542 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE cl() {
/* 547 */       return (CLICKABLE)this;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 552 */       BuildMain.this.inter.set((CLICKABLE)this, this.pop.cl());
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 557 */       super.render(r, ds, isActive, isSelected, isHovered);
/* 558 */       if (this.con) {
/* 559 */         COLOR.RED2RED.renderFrame(r, (RECTANGLE)this.body, 0, 3);
/* 560 */         this.con = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void higlight() {
/* 566 */       this.con = true;
/*     */     }
/*     */   }
/*     */   
/*     */   private final class BExp
/*     */     extends B
/*     */     implements BParenter {
/*     */     private final BuildMain.BPanel exp;
/*     */     
/*     */     public BExp(BuildMain.BPanel panel, SPRITE icon, CharSequence label, BuildMain.BPanel exp) {
/* 576 */       super(panel, icon, label);
/* 577 */       this.exp = exp;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 582 */       int i = isHovered | ((BuildMain.this.inter.exp == this.exp.cl()) ? 1 : 0);
/* 583 */       super.render(r, ds, isActive, isSelected, i);
/* 584 */       (UI.icons()).m.arrow_right.renderCY(r, body().x2() - 32, this.body.cY());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 589 */       if (super.hover(mCoo)) {
/* 590 */         BuildMain.this.inter.exp((CLICKABLE)this, this.exp.cl());
/*     */       }
/* 592 */       return super.hover(mCoo);
/*     */     }
/*     */   }
/*     */   
/*     */   private class BRoom
/*     */     extends B
/*     */   {
/*     */     private final RoomBlueprintImp room;
/*     */     private final CLICKABLE wrap;
/*     */     
/*     */     public BRoom(BuildMain.BPanel panel, final RoomBlueprintImp room) {
/* 603 */       super(panel, (SPRITE)room.icon, room.info.name);
/* 604 */       this.room = room;
/* 605 */       ACTION a = new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 609 */             if (!room.reqs.passes(FACTIONS.player())) {
/*     */               return;
/*     */             }
/* 612 */             (BuildMain.BRoom.access$0(BuildMain.BRoom.this)).inter.hide();
/* 613 */             if ((KEYS.MAIN()).MOD.isPressed() && (VIEW.s()).ui.prints.has((RoomBlueprint)room)) {
/* 614 */               (VIEW.s()).ui.prints.open((RoomBlueprint)room);
/*     */             } else {
/*     */               
/* 617 */               (BuildMain.BRoom.access$0(BuildMain.BRoom.this)).placer.init(room, -1, -1);
/*     */             } 
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */       
/* 624 */       String key = "BUILD_" + room.key;
/* 625 */       this.wrap = KeyButt.wrap(a, (CLICKABLE)this, (KeyPage)KEYS.SETT(), key, room.info.name, String.valueOf(BuildMain.¤¤Build) + " " + String.valueOf(BuildMain.¤¤Build));
/* 626 */       BuildMain.this.map.put(key, this);
/* 627 */       clickActionSet(a);
/* 628 */       SearchToolPanel.add(this.wrap, room.info.name, room.info.desc);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 633 */       UIRoomBuild.hoverRoomBuild(this.room, text);
/* 634 */       if ((VIEW.s()).ui.prints.has((RoomBlueprint)this.room)) {
/* 635 */         GBox b = (GBox)text;
/*     */         
/* 637 */         b.text((KEYS.MAIN()).MOD.repr());
/* 638 */         b.text(BuildMain.¤¤jblue);
/* 639 */         b.sep();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 645 */       activeSet(this.room.reqs.passes(FACTIONS.player()));
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE cl() {
/* 650 */       return this.wrap;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {}
/*     */   }
/*     */ 
/*     */   
/*     */   private class BAction
/*     */     extends B
/*     */   {
/*     */     private final CLICKABLE wrap;
/*     */ 
/*     */     
/*     */     public BAction(BuildMain.BPanel panel, String key, SPRITE icon, CharSequence name, CharSequence desc, ACTION action) {
/* 665 */       super(panel, icon, name);
/* 666 */       key = "ACTION_" + key;
/* 667 */       this.wrap = KeyButt.wrap(action, (CLICKABLE)this, (KeyPage)KEYS.SETT(), key, name, desc);
/* 668 */       BuildMain.this.map.put(key, this);
/* 669 */       clickActionSet(action);
/* 670 */       SearchToolPanel.add(this.wrap, name, desc);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public BAction(BuildMain.BPanel panel, String key, final PLACABLE place, CharSequence desc) {
/* 679 */       super(panel, place.getIcon(), place.name());
/* 680 */       key = "ACTION_" + key;
/* 681 */       ACTION a = new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 685 */             (VIEW.inters()).popup.close();
/* 686 */             (VIEW.s()).uiManager.disturb();
/* 687 */             (VIEW.s()).tools.place(place);
/*     */           }
/*     */         };
/* 690 */       this.wrap = KeyButt.wrap(a, (CLICKABLE)this, (KeyPage)KEYS.SETT(), key, place.name(), desc);
/* 691 */       BuildMain.this.map.put(key, this);
/* 692 */       clickActionSet(a);
/* 693 */       SearchToolPanel.add(this.wrap, place.name(), desc);
/*     */     }
/*     */ 
/*     */     
/*     */     public CLICKABLE cl() {
/* 698 */       return this.wrap;
/*     */     }
/*     */     
/*     */     protected void clickA() {}
/*     */   }
/*     */   
/*     */   static interface BParenter {
/*     */     BParenter parent();
/*     */     
/*     */     CLICKABLE cl();
/*     */     
/*     */     void higlight();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\bottom\BuildMain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */