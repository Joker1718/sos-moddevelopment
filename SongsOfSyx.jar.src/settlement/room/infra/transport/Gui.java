/*     */ package settlement.room.infra.transport;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.infra.logistics.MoveDic;
/*     */ import settlement.room.infra.logistics.MoveOrderPull;
/*     */ import settlement.room.infra.logistics.MoveOrderPullUI;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEmploymentIns;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.common.UIPickerRes;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.room.UIRoomBulkApplier;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Gui
/*     */   extends UIRoomModule.UIRoomModuleImp<TransportInstance, ROOM_TRANSPORT>
/*     */ {
/*  51 */   private static CharSequence ¤¤delivering = "Delivering";
/*  52 */   private static CharSequence ¤¤stored = "Loaded";
/*  53 */   private static CharSequence ¤¤loaded = "To be loaded";
/*  54 */   private static CharSequence ¤¤preparations = "Preparations:";
/*     */   
/*  56 */   static CharSequence ¤¤organise = "¤Loading Cart";
/*  57 */   static CharSequence ¤¤preparing = "¤Preparing Cart";
/*     */   
/*  59 */   private static CharSequence ¤¤prepared = "The cart is being prepared";
/*  60 */   private static CharSequence ¤¤loadedD = "The cart is being loaded";
/*     */   
/*  62 */   private static CharSequence ¤¤pNoDest = "There are currently no stations that can accept the selected resource!";
/*  63 */   private static CharSequence ¤¤pNoResource = "No resource has been set!";
/*     */   
/*  65 */   private static CharSequence ¤¤efficiency = "Efficiency Estimate";
/*  66 */   private static CharSequence ¤¤efficiencyD = "A station network can be highly efficient compared to warehouses and haulers. But, for that to be true, the volume, employees and distance must be enough.";
/*     */   
/*  68 */   private static CharSequence ¤¤bonusD = "Current carry capacity boost affecting all logistics workers.";
/*  69 */   private static CharSequence ¤¤workloadD = "The portion of employees that are active.";
/*  70 */   private static CharSequence ¤¤Fetching = "Fetching";
/*  71 */   private static CharSequence ¤¤FetchingD = "The percentage of employees fetching resources vs preparing the cart. These are as efficient as regular warehouse workers.";
/*  72 */   private static CharSequence ¤¤EmployeeEff = "Loading Efficiency";
/*  73 */   private static CharSequence ¤¤EmployeeEffD = "Exponential efficiency gained from the amount of employees, where {0} is optimal.";
/*  74 */   private static CharSequence ¤¤Distance = "Unloading Staions";
/*  75 */   private static CharSequence ¤¤DistanceD = "{0} tiles is the average distance to each targeted unloading station (longer distances are more effective, and each station uses roughly {1} workers to unload a delivery.).";
/*  76 */   private static CharSequence ¤¤totMoved = "Total Hauling";
/*  77 */   private static CharSequence ¤¤totMovedD = "Total amount of resources hauled 100 tiles per day of this loader. ({0} from fetching, {1} from the cart.)";
/*  78 */   private static CharSequence ¤¤Load = "Hauled Per Employee";
/*  79 */   private static CharSequence ¤¤LoadD = "How many resources are hauled 100 tiles on average per employee (including unloader, and fetching).";
/*  80 */   private static CharSequence ¤¤Result = "Total Efficiency";
/*  81 */   private static CharSequence ¤¤ResultD = "Efficiency compared to an average warehouse worker ({0} resources 100 tiles). Less than 100% indicates you're better off with a warehouse.";
/*     */   double bonusCache; int bonusI; private final String dCrate = "crates to fetch to";
/*     */   
/*  84 */   static { D.ts(Gui.class); } protected void appendPanel(GuiSection section, GGrid grid, final GETTER<TransportInstance> g, int x1, int y1) { GuiSection s = new GuiSection(); GButt.ButtPanel p = new GButt.ButtPanel((SPRITE)(UI.icons()).m.wheel) { protected void renAction() { selectedSet(((TransportInstance)g.get()).fetching()); } protected void clickA() { ((TransportInstance)g.get()).fetchingSet(!((TransportInstance)g.get()).fetching()); } protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) { super.render(r, ds, isActive, isSelected, isHovered); if (((TransportInstance)g.get()).fetching() && ((TransportInstance)g.get()).coolFetch > -1) { (GCOLOR.UI()).SOSO.hovered.bind(); (UI.icons()).s.alert.render(r, this.body.x1() + 6, this.body.y1() + 6); COLOR.unbind(); }  } public void hoverInfoGet(GUI_BOX text) { GBox b = (GBox)text; b.title(MoveDic.¤¤fetch); b.text(MoveDic.¤¤fetchD); b.NL(); if (((TransportInstance)g.get()).fetching() && ((TransportInstance)g.get()).coolFetch > -1) b.add((SPRITE)b.text().warnify().add(MoveDic.¤¤fetchProblem));  super.hoverInfoGet(text); } }
/*     */       ; p.body.setDim(48.0D); s.addRightC(0, (RENDEROBJ)p); p = new GButt.ButtPanel((SPRITE)(UI.icons()).m.priority) { protected void renAction() { selectedSet(((TransportInstance)g.get()).prio); } protected void clickA() { ((TransportInstance)g.get()).prio = !((TransportInstance)g.get()).prio; } protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) { super.render(r, ds, isActive, isSelected, isHovered); if (((TransportInstance)g.get()).prio && ((TransportInstance)g.get()).coolFetch > -1) { (GCOLOR.UI()).SOSO.hovered.bind(); (UI.icons()).s.alert.render(r, this.body.x1() + 6, this.body.y1() + 6); COLOR.unbind(); }  } public void hoverInfoGet(GUI_BOX text) { GBox b = (GBox)text; b.title(MoveDic.¤¤prio); b.text(MoveDic.¤¤prioD); b.NL(); if (((TransportInstance)g.get()).prio && ((TransportInstance)g.get()).coolFetch > -1) b.add((SPRITE)b.text().warnify().add(MoveDic.¤¤fetchProblem));  } }
/*     */       ; p.body.setDim(48.0D); s.addRightC(0, (RENDEROBJ)p); s.addRelBody(8, DIR.E, (RENDEROBJ)new MoveOrderPullUI(g, g, null, 4)); final UIPickerRes pop = new UIPickerRes(true) { protected void select(RESOURCE r, int li) { ((TransportInstance)g.get()).data.resourceSet(r, (TransportInstance)g.get()); } protected RESOURCE getResource() { return ((TransportInstance)g.get()).data.resource(); } }
/*     */       ; SPRITE.Imp imp = new SPRITE.Imp(24) { public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) { RESOURCE res = ((TransportInstance)g.get()).data.resource(); if (res == null) { (UI.icons()).m.cancel.render(r, X1, X2, Y1, Y2); } else { res.icon().render(r, X1, X2, Y1, Y2); }  } }
/*     */       ; s.addRelBody(8, DIR.S, (RENDEROBJ)new GHeader(Dic.¤¤Resource)); GButt.ButtPanel b = new GButt.ButtPanel((SPRITE)imp) { protected void clickA() { (VIEW.inters()).popup.show((RENDEROBJ)pop, (CLICKABLE)this, true); } }
/*  89 */       ; b.body.setDim(48.0D); s.addRelBody(2, DIR.S, (RENDEROBJ)b); section.addRelBody(8, DIR.S, (RENDEROBJ)s); s = new GuiSection(); double dd = 100.0D; s.addDown(0, (RENDEROBJ)(new GStat() { public void update(GText text) { TransportInstance i = (TransportInstance)g.get(); double bonus = Gui.this.bonus(i); double workload = i.employees().efficiency(); double eff = i.efficiency(); double workersPerLoad = 1.0D / bonus * workload * eff; workersPerLoad += i.stationWorkers; double fetching = 1.0D - i.fetchTime; double warhousefetch = bonus * 800.0D * ((SETT.ROOMS()).STOCKPILE.bonus()).baseValue / 100.0D; double moved = i.distance * fetching * 400.0D / workersPerLoad * 100.0D + (1.0D - fetching) * warhousefetch; GFORMAT.perc(text, moved / warhousefetch); } public void hoverInfoGet(GBox b) { b.title(Gui.¤¤efficiency); b.text(Gui.¤¤efficiencyD); b.sep(); TransportInstance i = (TransportInstance)g.get(); int tab = 7; double bonus = Gui.this.bonus(i); double warhousefetch = 800.0D * bonus * ((SETT.ROOMS()).STOCKPILE.bonus()).baseValue / 100.0D; b.textLL(((SETT.ROOMS()).STOCKPILE.bonus()).name); b.tab(tab); b.add((SPRITE)GFORMAT.perc(b.text(), bonus - 1.0D)); b.NL(); b.text(Gui.¤¤bonusD); b.NL(2); double workload = i.employees().efficiency(); b.textLL(RoomEmploymentIns.¤¤Workload); b.tab(tab); b.add((SPRITE)GFORMAT.perc(b.text(), workload)); b.NL(); b.text(Gui.¤¤workloadD); b.NL(2); double fetching = 1.0D - i.fetchTime; b.textLL(Gui.¤¤Fetching); b.tab(tab); b.add((SPRITE)GFORMAT.perc(b.text(), i.fetchTime)); b.NL(); b.text(Gui.¤¤FetchingD); b.NL(2); double eff = i.efficiency(); b.textLL(Gui.¤¤EmployeeEff); b.tab(tab); b.add((SPRITE)GFORMAT.perc(b.text(), eff)); b.NL(); GText t = b.text(); t.add(Gui.¤¤EmployeeEffD).insert(0, 16); b.add((SPRITE)t); b.NL(2); double dist = i.distance; double stationWorkers = i.stationWorkers; b.textLL(Gui.¤¤Distance); b.tab(tab); b.add((SPRITE)GFORMAT.perc(b.text(), dist / 100.0D * i.stationWorkers)); b.NL(); GText gText1 = b.text(); gText1.add(Gui.¤¤DistanceD).insert(0, (int)dist); gText1.insert(1, i.stationWorkers, 1); b.text((CharSequence)gText1); b.NL(2); double perDayFetch = workload * warhousefetch * (1.0D - fetching); double perDayCart = workload * bonus * 400.0D * eff * fetching * dist / 100.0D; b.textLL(Gui.¤¤totMoved); b.tab(tab); b.add((SPRITE)GFORMAT.i(b.text(), ((int)(perDayFetch + perDayCart) * i.employees().employed()))); b.NL(); GText gText2 = b.text(); gText2.add(Gui.¤¤totMovedD); gText2.insert(0, (int)perDayFetch * i.employees().employed()); gText2.insert(1, (int)perDayCart * i.employees().employed()); b.add((SPRITE)gText2); b.NL(2); double workersPerLoad = 1.0D / bonus * workload * eff; workersPerLoad += stationWorkers; double moved = dist * fetching * 400.0D / workersPerLoad * 100.0D + (1.0D - fetching) * warhousefetch; b.textLL(Gui.¤¤Load); b.tab(tab); b.add((SPRITE)GFORMAT.i(b.text(), (int)moved)); b.NL(); b.text(Gui.¤¤LoadD); b.NL(2); b.sep(); b.textLL(Gui.¤¤Result); b.tab(tab); double d = moved / warhousefetch; b.add((SPRITE)GFORMAT.perc(b.text(), d)); b.NL(); GText gText3 = b.text(); gText3.add(Gui.¤¤ResultD).insert(0, warhousefetch, 1); b.add((SPRITE)gText3); b.NL(6); } }).increase().hh(Dic.¤¤Efficiency, 200)); s.addDown(16, (RENDEROBJ)(new GStat() { public void update(GText text) { GFORMAT.perc(text, ((TransportInstance)g.get()).data.prepD()); } }).hh(¤¤preparations, 200)); s.addDown(2, (RENDEROBJ)(new GStat() { public void update(GText text) { GFORMAT.i(text, ((TransportInstance)g.get()).data.unloaded()); } }).hh(¤¤loaded, 200)); s.addDown(2, (RENDEROBJ)(new GStat() { public void update(GText text) { GFORMAT.iofkInv(text, ((TransportInstance)g.get()).data.stored(), 400L); } }).hh(¤¤stored, 200)); s.addDown(2, (RENDEROBJ)(new GStat() { public void update(GText text) { GFORMAT.i(text, ((TransportInstance)g.get()).data.delivering()); } }).hh(¤¤delivering, 200)); if ((S.get()).developer) s.addDown(8, (RENDEROBJ)(new GStat() { public void update(GText text) { GFORMAT.i(text, ((TransportInstance)g.get()).data.unloadedSpots()); } }).hh("crates to fetch to", 200));  s.addDown(16, (SPRITE)new GStat() { public void update(GText text) { if (((TransportInstance)g.get()).data.prepD() >= 1.0D) { text.add(Gui.¤¤prepared); } else { text.add(Gui.¤¤loadedD); }  text.setMaxWidth(300); text.setMultipleLines(true); } }); section.addRelBody(8, DIR.S, (RENDEROBJ)s); } Gui(ROOM_TRANSPORT s) { super(s);
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
/* 436 */     this.bonusCache = 1.0D;
/* 437 */     this.bonusI = -10;
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
/* 468 */     this.dCrate = "crates to fetch to"; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void problem(TransportInstance i, Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings) {
/* 474 */     if (i.employees().target() == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 479 */     boolean ok = false;
/* 480 */     boolean has = false; byte b; int j; MoveOrderPull[] arrayOfMoveOrderPull;
/* 481 */     for (j = (arrayOfMoveOrderPull = i.moveOrdersPull()).length, b = 0; b < j; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/* 482 */       if (o != null) {
/* 483 */         has = true;
/* 484 */         CharSequence p = o.problem(i);
/* 485 */         if (p != null) {
/* 486 */           errors.add(p); break;
/*     */         } 
/* 488 */         if (o.cooldown >= -1)
/* 489 */           ok = true; 
/*     */       } 
/*     */       b++; }
/*     */     
/* 493 */     if (i.fetching() && i.coolFetch > -1 && has && !ok) {
/* 494 */       errors.add(MoveDic.¤¤pullProblem);
/*     */     }
/*     */ 
/*     */     
/* 498 */     if (i.resource() == null) {
/* 499 */       errors.add(¤¤pNoResource);
/* 500 */     } else if (i.stationProblem) {
/* 501 */       warnings.add(¤¤pNoDest);
/*     */     } 
/*     */     
/* 504 */     super.problem(i, free, errors, warnings); } private double bonus(TransportInstance i) { if (GAME.updateI() != this.bonusI) { this.bonusI = GAME.updateI(); double b = 0.0D; int am = 0; for (Humanoid a : RoomEmploymentIns.employees(i)) { am++; b += (SETT.ROOMS()).STOCKPILE.bonus().get((BOOSTABLE_O)a.indu()); }
/*     */        if (am > 0) { this.bonusCache = b / am; this.bonusCache /= ((SETT.ROOMS()).STOCKPILE.bonus()).baseValue; }
/*     */       else { this.bonusCache = 1.0D; }
/*     */        }
/*     */      return this.bonusCache; }
/*     */   protected void hover(GBox box, TransportInstance i) { super.hover(box, i); box.sep(); if (i.resource() != null) { box.add((SPRITE)i.resource().icon()); box.add((SPRITE)GFORMAT.iofkInv(box.text(), i.data.stored(), 400L)); }
/*     */      }
/* 511 */   protected void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) { super.appendTableFilters(filters, sorts, appliers);
/*     */     
/* 513 */     for (RESOURCE res : RESOURCES.ALL()) {
/* 514 */       filters.add(new GTableSorter.GTFilter<RoomInstance>(res.names)
/*     */           {
/*     */             public boolean passes(RoomInstance h)
/*     */             {
/* 518 */               TransportInstance i = (TransportInstance)h;
/* 519 */               if (i.data.resource() == res)
/* 520 */                 return true; 
/* 521 */               return false;
/*     */             }
/*     */           });
/*     */     }  }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\transport\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */