/*     */ package settlement.room.military.supply;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.infra.logistics.MoveDic;
/*     */ import settlement.room.infra.logistics.MoveOrderPullUI;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Alloc;
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
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupply;
/*     */ 
/*     */ class Gui
/*     */   extends UIRoomModule.UIRoomModuleImp<SupplyInstance, ROOM_SUPPLY> {
/*  47 */   private static CharSequence ¤¤ready = "¤Wagons ready";
/*     */   
/*  49 */   private static CharSequence ¤¤liveStockD = "¤A {0} is used up for every 10th trip.";
/*     */   
/*  51 */   private static CharSequence ¤¤consumed = "¤Daily Consumption";
/*  52 */   private static CharSequence ¤¤needed = "¤Needed Delivery";
/*  53 */   private static CharSequence ¤¤underway = "¤Deliveries Underway";
/*  54 */   private static CharSequence ¤¤possible = "¤Possible";
/*  55 */   private static CharSequence ¤¤possibleD = "¤Some armies can not currently be supplied. To be supplied they need to be fortified and in own or allied territory.";
/*  56 */   private static CharSequence ¤¤closedD = "¤Your capitol is closed and deliveries can not be undertaken.";
/*  57 */   private static CharSequence ¤¤deliver = "¤There are no armies that needs the selected resources delivered."; private final Crate crate; private int[] ready; private int livestock; private int carts; private int upI; protected void appendPanel(GuiSection section, GGrid grid, final GETTER<SupplyInstance> g, int x1, int y1) { GuiSection s = new GuiSection(); GButt.ButtPanel p = new GButt.ButtPanel((SPRITE)(UI.icons()).m.wheel) { protected void renAction() { selectedSet(((SupplyInstance)g.get()).fetching()); } protected void clickA() { ((SupplyInstance)g.get()).fetchingToggle(); } protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) { super.render(r, ds, isActive, isSelected, isHovered); if (((SupplyInstance)g.get()).fetching() && ((SupplyInstance)g.get()).coolFetch > 0) { (GCOLOR.UI()).SOSO.hovered.bind(); (UI.icons()).s.alert.render(r, this.body.x1() + 6, this.body.y1() + 6); COLOR.unbind(); }  } public void hoverInfoGet(GUI_BOX text) { GBox b = (GBox)text; b.title(MoveDic.¤¤fetch); b.text(MoveDic.¤¤fetchD); b.NL(); if (((SupplyInstance)g.get()).fetching() && ((SupplyInstance)g.get()).coolFetch > 0) b.add((SPRITE)b.text().warnify().add(MoveDic.¤¤fetchProblem));  super.hoverInfoGet(text); } }
/*     */       ; p.body.setDim(48.0D); s.addRightC(0, (RENDEROBJ)p); p = new GButt.ButtPanel((SPRITE)(UI.icons()).m.priority) { protected void renAction() { selectedSet(((SupplyInstance)g.get()).prioritizing()); } protected void clickA() { ((SupplyInstance)g.get()).prioritizeToggle(); } protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) { super.render(r, ds, isActive, isSelected, isHovered); if (((SupplyInstance)g.get()).prioritizing() && ((SupplyInstance)g.get()).coolFetch > 0) { (GCOLOR.UI()).SOSO.hovered.bind(); (UI.icons()).s.alert.render(r, this.body.x1() + 6, this.body.y1() + 6); COLOR.unbind(); }  } public void hoverInfoGet(GUI_BOX text) { GBox b = (GBox)text; b.title(MoveDic.¤¤prio); b.text(MoveDic.¤¤prioD); b.NL(); if (((SupplyInstance)g.get()).prioritizing() && ((SupplyInstance)g.get()).coolFetch > 0) b.add((SPRITE)b.text().warnify().add(MoveDic.¤¤fetchProblem));  } }
/*  59 */       ; p.body.setDim(48.0D); s.addRightC(0, (RENDEROBJ)p); MoveOrderPullUI ui = new MoveOrderPullUI(g, g, null, 2); s.addRightC(8, (RENDEROBJ)ui); section.addRelBody(4, DIR.S, (RENDEROBJ)s); s = new GuiSection(); s.addRightC(4, (RENDEROBJ)(new GStat() { public void update(GText text) { Gui.this.cache((SupplyInstance)g.get()); GFORMAT.iofkInv(text, Gui.this.livestock, Gui.this.carts); } public void hoverInfoGet(GBox b) { b.title(((ROOM_SUPPLY)Gui.this.blueprint).liveStock.name); GText t = b.text(); t.add(Gui.¤¤liveStockD); t.insert(0, ((ROOM_SUPPLY)Gui.this.blueprint).liveStock.name); b.add((SPRITE)t); } }).hh((SPRITE)((ROOM_SUPPLY)this.blueprint).liveStock.icon())); section.addRelBody(4, DIR.S, (RENDEROBJ)s); s = new GuiSection(); int k = 0; final GText text = new GText((UI.FONT()).S, 16); for (RESOURCE res : AD.supplies().resses()) { CLICKABLE.ClickableAbs c = new CLICKABLE.ClickableAbs(64, 64) { protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) { GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body); res.icon().renderC(r, this.body.cX(), this.body.cY() - 8); text.clear(); GFORMAT.i(text, ((ROOM_SUPPLY)Gui.this.blueprint).tally.amount.get((SupplyInstance)g.get(), res)); text.adjustWidth(); text.renderC(r, this.body.cX(), this.body.cY() + 12); GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body); } protected void renAction() { selectedSet(((SupplyInstance)g.get()).allowed().has(res)); } protected void clickA() { ((SupplyInstance)g.get()).allowedToggle(res); ((SupplyInstance)g.get()).reset(); } public void hoverInfoGet(GUI_BOX text) { GBox b = (GBox)text; b.title(res.name); b.textLL(Gui.¤¤underway); b.tab(7); b.add((SPRITE)GFORMAT.i(b.text(), (((ROOM_SUPPLY)Gui.this.blueprint).tally.spaceReserved.get((SupplyInstance)g.get(), res) + ((ROOM_SUPPLY)Gui.this.blueprint).tally.amount.get((SupplyInstance)g.get(), res)))); b.NL(); b.textLL(Gui.¤¤ready); b.tab(7); b.add((SPRITE)GFORMAT.i(b.text(), Gui.this.ready(res, (SupplyInstance)g.get()))); b.sep(); Gui.this.hoverNeeded(b, res); if ((S.get()).developer) { b.add((SPRITE)(UI.icons()).s.storage); b.tab(7); b.add((SPRITE)GFORMAT.i(b.text(), ((ROOM_SUPPLY)Gui.this.blueprint).tally.capacity((SupplyInstance)g.get(), res, ((SupplyInstance)g.get()).allowed()))); b.NL(); b.add((SPRITE)(UI.icons()).s.allRight); b.tab(7); b.add((SPRITE)GFORMAT.i(b.text(), ((ROOM_SUPPLY)Gui.this.blueprint).cache.deliverable(res))); b.NL(); b.NL(8); b.textL(Dic.¤¤Needed); b.add((SPRITE)GFORMAT.i(b.text(), ((ROOM_SUPPLY)Gui.this.blueprint).cache.needed(res))); b.NL(); b.add((SPRITE)(UI.icons()).s.allRight); b.add((SPRITE)GFORMAT.bool(b.text(), ((SupplyInstance)g.get()).moveOrderPullAvailable().has(res))); b.NL(); b.NL(8); for (SupplyTally.TallyData d : ((ROOM_SUPPLY)Gui.this.blueprint).tally.datas) { b.textLL(d.name); b.tab(7); b.add((SPRITE)GFORMAT.i(b.text(), d.get((SupplyInstance)g.get(), res))); b.tab(10); b.add((SPRITE)GFORMAT.i(b.text(), d.total(res))); b.NL(); }  }  } }; s.addGrid((RENDEROBJ)c, k++, 5, 0, 0); }  section.addRelBody(8, DIR.S, (RENDEROBJ)s); } static { D.ts(Gui.class); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Gui(ROOM_SUPPLY s) {
/*  65 */     super(s);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 506 */     this.ready = Alloc.ii(RESOURCES.ALL().size());
/*     */ 
/*     */     
/* 509 */     this.upI = -1; this.crate = new Crate(s); } protected void hover(GBox b, SupplyInstance i) { super.hover(b, i); b.sep(); if (i.fetch) {
/*     */       b.textL(MoveDic.¤¤fetching); b.NL();
/*     */     }  }
/* 512 */   private void cache(SupplyInstance i) { if (this.upI == GAME.updateI())
/*     */       return; 
/* 514 */     this.upI = GAME.updateI();
/* 515 */     Arrays.fill(this.ready, 0);
/* 516 */     this.livestock = 0;
/* 517 */     this.carts = 0;
/*     */     
/* 519 */     for (int ji = 0; ji < i.jobs.size(); ji++)
/* 520 */     { COORDINATE j = i.jobs.get(ji);
/* 521 */       Crate cr = this.crate.get(j.x(), j.y());
/* 522 */       this.carts++;
/* 523 */       if (cr.animalHas())
/* 524 */         this.livestock++; 
/* 525 */       RESOURCE res = this.crate.get(j.x(), j.y()).realResource();
/* 526 */       if (res != null)
/* 527 */         this.ready[res.index()] = this.ready[res.index()] + cr.resAmount() * ((cr.goIsReady() == 0) ? 1 : 0);  }  } private void hoverNeeded(GBox b, RESOURCE res) { b.textLL(Dic.¤¤Armies); b.NL(); int stored = 0; int max = 0; int minimum = 0; double consumed = 0.0D; for (ADSupply s : AD.supplies().get(res)) { max += s.targetAmount((Faction)FACTIONS.player()); stored += s.current().faction((Faction)FACTIONS.player()); minimum += s.minimumAmount((Faction)FACTIONS.player()); consumed += -s.consumedPerDayCurrent((Faction)FACTIONS.player()); }  b.textL(Dic.¤¤Stored); b.tab(6); b.add((SPRITE)GFORMAT.i(b.text(), stored)); b.NL(); b.textL(Dic.¤¤Minimum); b.tab(6); b.add((SPRITE)GFORMAT.i(b.text(), minimum)); b.NL(); b.textL(Dic.¤¤Max); b.tab(6); b.add((SPRITE)GFORMAT.i(b.text(), max)); b.NL(); b.textL(¤¤consumed); b.tab(6); b.add((SPRITE)GFORMAT.f0(b.text(), consumed)); b.NL(); b.textL((SETT.ROOMS()).STOCKPILE.info.names); b.tab(6); b.add((SPRITE)GFORMAT.i(b.text(), ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(res))); b.NL(); b.NL(4); b.textLL(¤¤needed); b.tab(6); b.add((SPRITE)GFORMAT.i(b.text(), ((ROOM_SUPPLY)this.blueprint).cache.needed(res))); b.NL(); int dd = ((ROOM_SUPPLY)this.blueprint).cache.deliverableSecret(res); b.textLL(¤¤possible); b.tab(6); b.add((SPRITE)GFORMAT.i(b.text(), dd)); b.NL(); if (dd < ((ROOM_SUPPLY)this.blueprint).cache.needed(res)) { b.error(¤¤possibleD); b.NL(); }  if (SETT.ENTRY().isClosed()) { b.error(¤¤closedD); b.NL(); }  b.sep(); }
/*     */   protected void appendMain(GGrid icons, GGrid gridtext, GuiSection sExtra) { GuiSection s = new GuiSection(); int k = 0; for (RESOURCE res : AD.supplies().resses()) { CLICKABLE.ClickableAbs c = new CLICKABLE.ClickableAbs(64, 40) { protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) { GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body); double stored = 0.0D; double max = 0.0D; for (ADSupply s : AD.supplies().get(res)) { max += s.targetAmount((Faction)FACTIONS.player()); stored += s.current().faction((Faction)FACTIONS.player()); }  double d = stored / max; stored += (((ROOM_SUPPLY)Gui.this.blueprint).tally.amount.total(res) + ((ROOM_SUPPLY)Gui.this.blueprint).tally.spaceReserved.total(res)); double d2 = stored / max; if (max > 0.0D) GMeter.renderDelta(r, d, d2, this.body.x1() + 5, this.body.x2() - 5, this.body.y1() + 5, this.body.y2() - 5, false, false);  res.icon().renderC(r, this.body.cX(), this.body.cY()); GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body); }
/*     */           private boolean sel() { for (int i = 0; i < ((ROOM_SUPPLY)Gui.this.blueprint).instancesSize(); i++) { if (((SupplyInstance)((ROOM_SUPPLY)Gui.this.blueprint).getInstance(i)).allowed().has(res)) return true;  }  return false; }
/*     */           protected void renAction() { selectedSet(sel()); }
/*     */           protected void clickA() { boolean sel = sel(); for (int i = 0; i < ((ROOM_SUPPLY)Gui.this.blueprint).instancesSize(); i++) { SupplyInstance ins = (SupplyInstance)((ROOM_SUPPLY)Gui.this.blueprint).getInstance(i); if (sel == ins.allowed().has(res)) { ins.allowedToggle(res); ins.reset(); }  }  }
/*     */           public void hoverInfoGet(GUI_BOX text) { GBox b = (GBox)text; b.title(res.name); Gui.this.hoverNeeded(b, res); b.textLL(Gui.¤¤underway); b.tab(7); b.add((SPRITE)GFORMAT.i(b.text(), (((ROOM_SUPPLY)Gui.this.blueprint).tally.amount.total(res) + ((ROOM_SUPPLY)Gui.this.blueprint).tally.spaceReserved.total(res)))); b.NL(); if ((S.get()).developer) { for (SupplyTally.TallyData d : ((ROOM_SUPPLY)Gui.this.blueprint).tally.datas) { b.textLL(d.name); b.tab(7); b.add((SPRITE)GFORMAT.i(b.text(), d.total(res))); b.NL(); }  b.add((SPRITE)(UI.icons()).s.question); b.add((SPRITE)GFORMAT.i(b.text(), ((ROOM_SUPPLY)Gui.this.blueprint).cache.deliverable(res))); }  } }
/*     */         ; s.addGrid((RENDEROBJ)c, k++, 5, 0, 0); }  gridtext.add((RENDEROBJ)s); }
/*     */   protected void problem(SupplyInstance i, Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings) { if (SETT.ENTRY().isClosed()) errors.add(¤¤closedD);  boolean deliver = false; for (RESOURCE r : RESOURCES.ALL()) { if (!i.getWork().resourceReachable(r) && (i.blueprintI()).tally.fetchAmount(r) <= 0) deliver = true;  }  if (deliver) warnings.add(¤¤deliver);  }
/* 535 */   private int ready(RESOURCE res, SupplyInstance i) { cache(i);
/* 536 */     return this.ready[res.index()]; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\supply\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */