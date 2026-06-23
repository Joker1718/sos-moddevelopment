/*     */ package settlement.room.infra.station;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEmploymentIns;
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
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
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
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.room.UIRoomBulkApplier;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ class Gui
/*     */   extends UIRoomModule.UIRoomModuleImp<StationInstance, ROOM_STATION> {
/*  54 */   private static CharSequence ¤¤prepped = "Prepared Deliveries";
/*  55 */   private static CharSequence ¤¤preppedD = "How many transports this station is ready to receive.";
/*  56 */   private static CharSequence ¤¤efficiency = "Efficiency";
/*  57 */   private static CharSequence ¤¤efficiencyD = "Efficiency is based on the number of workers. Each individual becomes more effective when they work together. Carry capacity also affects efficiency.";
/*  58 */   private static CharSequence ¤¤efficiencyD2 = "Current efficiency enables us to accept {0} transport-loads of {1} items each per day, per worker. ({2} items / day per worker)";
/*     */   
/*  60 */   private static CharSequence ¤¤accepting = "There is enough space to accept a transport of this resource.";
/*  61 */   private static CharSequence ¤¤acceptingNot = "There is not enough space or preparations to accept a transport of this resource.";
/*     */   
/*  63 */   private static CharSequence ¤¤has = "There are transports transporting this resource.";
/*  64 */   private static CharSequence ¤¤hasNot = "There are no active transports currently transporting this resource.";
/*     */   
/*  66 */   private static CharSequence ¤¤prob1 = "No resources have been selected.";
/*  67 */   private static CharSequence ¤¤prob2 = "Some selected resources do not have active transports.";
/*     */   
/*  69 */   private static CharSequence ¤¤reserved = "Reserved";
/*  70 */   private static CharSequence ¤¤incoming = "Incoming";
/*     */   
/*  72 */   private static CharSequence ¤¤prob3 = "Max preparations have been performed. There are not enough deliveries to arrive."; double bonusCache; int bonusI;
/*     */   static {
/*  74 */     D.ts(Gui.class);
/*     */   }
/*     */   
/*     */   Gui(ROOM_STATION s)
/*     */   {
/*  79 */     super(s);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 166 */     this.bonusCache = 1.0D;
/* 167 */     this.bonusI = -10;
/*     */   }
/*     */   
/* 170 */   private double bonus(StationInstance i) { if (GAME.updateI() != this.bonusI) {
/* 171 */       this.bonusI = GAME.updateI();
/* 172 */       double b = 0.0D;
/* 173 */       int am = 0;
/* 174 */       for (Humanoid a : RoomEmploymentIns.employees(i)) {
/* 175 */         am++;
/* 176 */         b += (SETT.ROOMS()).STOCKPILE.bonus().get((BOOSTABLE_O)a.indu());
/*     */       } 
/* 178 */       if (am > 0) {
/* 179 */         this.bonusCache = b / am;
/* 180 */         this.bonusCache /= ((SETT.ROOMS()).STOCKPILE.bonus()).baseValue;
/*     */       } else {
/* 182 */         this.bonusCache = 1.0D;
/*     */       } 
/*     */     } 
/* 185 */     return this.bonusCache; }
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, StationInstance i)
/*     */   {
/* 190 */     super.hover(box, i);
/* 191 */     box.sep();
/*     */     
/* 193 */     int m = 0;
/* 194 */     box.NL(8);
/*     */     
/* 196 */     for (RESOURCE r : RESOURCES.ALL()) {
/*     */       
/* 198 */       if (i.tally(r).crates() > 0) {
/*     */         
/* 200 */         box.tab(m % 3 * 5);
/*     */         
/* 202 */         box.add((SPRITE)r.icon());
/* 203 */         box.add((SPRITE)GFORMAT.i(box.text(), i.tally(r).stored()));
/*     */         
/* 205 */         if (m % 3 == 2) {
/* 206 */           box.NL();
/*     */         }
/* 208 */         m++;
/*     */       } 
/*     */     } 
/*     */     
/* 212 */     box.NL();
/*     */     
/* 214 */     box.textLL(¤¤prepped);
/* 215 */     box.tab(6);
/* 216 */     box.add((SPRITE)GFORMAT.f(box.text(), i.prepared * TIME.secondsPerDayI(), 2));
/* 217 */     box.NL();
/* 218 */     box.textLL(¤¤efficiency);
/* 219 */     box.tab(6);
/* 220 */     box.add((SPRITE)GFORMAT.perc(box.text(), i.efficiency()));
/* 221 */     box.NL();
/*     */     
/* 223 */     box.NL(8);
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
/*     */   protected void problem(StationInstance i, Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings) {
/* 235 */     int ress = 0;
/* 236 */     int err = 0;
/* 237 */     for (RESOURCE res : RESOURCES.ALL()) {
/* 238 */       if (i.tally(res).crates() > 0) {
/* 239 */         ress++;
/* 240 */         if (!(SETT.ROOMS()).TRANSPORT.hasActive(res)) {
/* 241 */           err++;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 246 */     if (ress == 0) {
/* 247 */       errors.add(¤¤prob1);
/*     */     }
/* 249 */     if (err > 0 && err == ress) {
/* 250 */       errors.add(¤¤prob2);
/* 251 */     } else if (err > 0) {
/* 252 */       warnings.add(¤¤prob2);
/*     */     } 
/* 254 */     if (i.prepared >= i.maxPrep()) {
/* 255 */       warnings.add(¤¤prob3);
/*     */     }
/* 257 */     super.problem(i, free, errors, warnings);
/*     */   } protected void appendPanel(GuiSection section, GGrid grid, final GETTER<StationInstance> g, int x1, int y1) { GuiSection s = new GuiSection(); s.addDownC(0, (RENDEROBJ)(new GStat() { public void update(GText text) { GFORMAT.f(text, ((StationInstance)g.get()).prepared * TIME.secondsPerDayI(), 2); text.s(); text.add('/'); text.add((int)(((StationInstance)g.get()).maxPrep() * TIME.secondsPerDayI())); } public void hoverInfoGet(GBox b) { b.title(Gui.¤¤prepped); b.text(Gui.¤¤preppedD); } }
/*     */         ).hh(¤¤prepped)); s.addDownC(0, (RENDEROBJ)(new GStat() { public void update(GText text) { GFORMAT.perc(text, ((StationInstance)g.get()).efficiency() * Gui.this.bonus((StationInstance)g.get())); } public void hoverInfoGet(GBox b) { b.title(Gui.¤¤efficiency); b.text(Gui.¤¤efficiencyD); b.NL(); b.add((SPRITE)((SETT.ROOMS()).STOCKPILE.bonus()).icon); b.textLL(((SETT.ROOMS()).STOCKPILE.bonus()).name); b.tab(6); GText t = b.text(); t.add('x').s(); GFORMAT.f1(t, Gui.this.bonus((StationInstance)g.get())); b.add((SPRITE)t); b.NL(8); t = b.text(); t.add(Gui.¤¤efficiencyD2); t.insert(0, ((StationInstance)g.get()).efficiency() * Gui.this.bonus((StationInstance)g.get()), 2); t.insert(1, 400); t.insert(2, (int)(((StationInstance)g.get()).efficiency() * Gui.this.bonus((StationInstance)g.get()) * 400.0D)); b.add((SPRITE)t); } }
/*     */         ).hh(¤¤efficiency)); if ((S.get()).developer) { s.addDownC(2, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Accept) {
/*     */             protected void clickA() { int ri = RND.rInt(); for (int i = 0; i < RESOURCES.ALL().size(); i++) { RESOURCE res = (RESOURCE)RESOURCES.ALL().getC(i + ri); if (((StationInstance)g.get()).tally(res).crates() > 0) { ((StationInstance)g.get()).deliver(res, (int)(400.0F * RND.rFloat())); return; }  }  }
/*     */           }); s.addDownC(2, (RENDEROBJ)new GButt.ButtPanel("prep") {
/*     */             protected void clickA() { ((StationInstance)g.get()).setPrepared(((StationInstance)g.get()).maxPrep()); }
/* 264 */           }); }  section.addRelBody(8, DIR.S, (RENDEROBJ)s); section.addRelBody(8, DIR.S, (RENDEROBJ)new Ress(g)); } protected void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) { super.appendTableFilters(filters, sorts, appliers); }
/*     */ 
/*     */   
/*     */   private static class Ress
/*     */     extends GuiSection
/*     */   {
/* 270 */     private ArrayList<RESOURCE> current = new ArrayList(RESOURCES.ALL().size());
/*     */     private final GETTER<StationInstance> g;
/*     */     private final Gui.RessPop pop;
/*     */     
/*     */     Ress(GETTER<StationInstance> g) {
/* 275 */       this.g = g;
/* 276 */       this.pop = new Gui.RessPop(g);
/* 277 */       ArrayList<RENDEROBJ> rows = new ArrayList(RESOURCES.ALL().size());
/*     */       
/* 279 */       for (int ri = 0; ri < RESOURCES.ALL().size(); ri++) {
/* 280 */         rows.add(new Gui.ResLine(ri, g, this.current));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 285 */       add((RENDEROBJ)(new GScrollRows((Iterable)rows, 350)
/*     */           {
/*     */             protected boolean passesFilter(int i, RENDEROBJ o)
/*     */             {
/* 289 */               return (i < Gui.Ress.this.current.size());
/*     */             }
/* 292 */           }).view());
/*     */ 
/*     */ 
/*     */       
/* 296 */       addRelBody(8, DIR.N, (RENDEROBJ)new GHeader(Dic.¤¤Resources));
/* 297 */       pad(8, 8);
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 302 */       this.current.clearSloppy();
/* 303 */       for (RESOURCE res : RESOURCES.ALL()) {
/* 304 */         if (((StationInstance)this.g.get()).tally(res).crates() > 0)
/* 305 */           this.current.add(res); 
/*     */       } 
/* 307 */       boolean hov = hoveredIs();
/* 308 */       GButt.ButtPanel.renderBG(r, true, false, hov, (RECTANGLE)body());
/* 309 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */ 
/*     */       
/* 312 */       super.render(r, ds);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean click() {
/* 317 */       (VIEW.inters()).popup.show((RENDEROBJ)this.pop, (CLICKABLE)this);
/* 318 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ResLine
/*     */     extends HOVERABLE.HoverableAbs
/*     */   {
/*     */     private ArrayList<RESOURCE> current;
/*     */     private final GETTER<StationInstance> g;
/*     */     private final int k;
/*     */     
/*     */     ResLine(int k, GETTER<StationInstance> g, ArrayList<RESOURCE> current) {
/* 330 */       super(300, 32);
/* 331 */       this.g = g;
/* 332 */       this.current = current;
/* 333 */       this.k = k;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 339 */       if (this.k >= this.current.size())
/*     */         return; 
/* 341 */       RESOURCE res = (RESOURCE)this.current.get(this.k);
/*     */       
/* 343 */       res.icon().renderCY(r, this.body.x1(), this.body.cY());
/* 344 */       StationInstance ins = (StationInstance)this.g.get();
/* 345 */       StationTally t = ins.tally(res);
/*     */       
/* 347 */       int x2 = this.body.x2() - 48;
/* 348 */       GMeter.render(r, GMeter.C_REDGREEN, t.stored() / t.space(), this.body.x1() + 30, x2, this.body.y1() + 4, this.body.y2() - 4);
/*     */       
/* 350 */       Str.TMP.clear().add(t.stored());
/* 351 */       int w = (UI.FONT()).S.width((CharSequence)Str.TMP);
/* 352 */       OPACITY.O50.bind();
/* 353 */       COLOR.BLACK.render(r, x2 - w - 8, x2, this.body.y1() + 5, this.body.y2() - 5);
/* 354 */       OPACITY.unbind();
/*     */       
/* 356 */       (UI.FONT()).S.renderCY(r, x2 - w - 4, this.body.cY(), (CharSequence)Str.TMP);
/*     */ 
/*     */       
/* 359 */       if (ins.accepting(res)) {
/* 360 */         (GCOLOR.T()).IGOOD.bind();
/*     */       } else {
/* 362 */         (GCOLOR.T()).IBAD.bind();
/*     */       } 
/* 364 */       (UI.icons()).s.storage.renderCY(r, x2 + 8, this.body.cY());
/*     */       
/* 366 */       if ((SETT.ROOMS()).TRANSPORT.hasActive(res)) {
/* 367 */         (GCOLOR.T()).IGOOD.bind();
/*     */       } else {
/* 369 */         (GCOLOR.T()).IBAD.bind();
/*     */       } 
/* 371 */       (UI.icons()).s.chevron(DIR.E).renderCY(r, x2 + 24, this.body.cY());
/* 372 */       COLOR.unbind();
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 377 */       if (this.k >= this.current.size())
/*     */         return; 
/* 379 */       RESOURCE res = (RESOURCE)this.current.get(this.k);
/* 380 */       StationInstance ins = (StationInstance)this.g.get();
/* 381 */       StationTally t = ins.tally(res);
/* 382 */       GBox b = (GBox)text;
/*     */       
/* 384 */       b.title(res.name);
/*     */       
/* 386 */       b.textLL(Dic.¤¤Stored);
/* 387 */       b.tab(6);
/* 388 */       b.add((SPRITE)GFORMAT.i(b.text(), t.stored()));
/* 389 */       b.NL();
/*     */       
/* 391 */       b.textLL(Dic.¤¤Capacity);
/* 392 */       b.tab(6);
/* 393 */       b.add((SPRITE)GFORMAT.i(b.text(), t.space()));
/* 394 */       b.NL();
/*     */       
/* 396 */       b.textLL(Gui.¤¤reserved);
/* 397 */       b.tab(6);
/* 398 */       b.add((SPRITE)GFORMAT.i(b.text(), t.reserved()));
/* 399 */       b.NL();
/*     */       
/* 401 */       b.textLL(Gui.¤¤incoming);
/* 402 */       b.tab(6);
/* 403 */       b.add((SPRITE)GFORMAT.i(b.text(), ins.incoming(res)));
/* 404 */       b.NL();
/*     */       
/* 406 */       if (ins.accepting(res)) {
/* 407 */         b.add((SPRITE)b.text().normalify2().add(Gui.¤¤accepting));
/*     */       } else {
/* 409 */         b.error(Gui.¤¤acceptingNot);
/*     */       } 
/* 411 */       if ((S.get()).developer)
/* 412 */         b.add((SPRITE)b.text().add(ins.blueprintI().tally(res).accepting())); 
/* 413 */       b.NL();
/*     */       
/* 415 */       if ((SETT.ROOMS()).TRANSPORT.hasActive(res)) {
/* 416 */         b.add((SPRITE)b.text().normalify2().add(Gui.¤¤has));
/*     */       } else {
/* 418 */         b.error(Gui.¤¤hasNot);
/*     */       } 
/* 420 */       b.NL();
/*     */       
/* 422 */       super.hoverInfoGet(text);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class RessPop
/*     */     extends GuiSection
/*     */   {
/*     */     RessPop(final GETTER<StationInstance> g) {
/* 431 */       GRows rr = new GRows(2);
/*     */       
/* 433 */       for (int ri = 0; ri < RESOURCES.ALL().size(); ri++) {
/* 434 */         final int k = ri;
/* 435 */         GuiSection row = new GuiSection();
/* 436 */         row.hoverInfoSet(((RESOURCE)RESOURCES.ALL().get(k)).name);
/* 437 */         row.add((SPRITE)((RESOURCE)RESOURCES.ALL().get(k)).icon(), 0, 0);
/* 438 */         INT.INTE in = new INT.INTE()
/*     */           {
/*     */             public int min()
/*     */             {
/* 442 */               return 0;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public int max() {
/* 448 */               return ((StationInstance)g.get()).crates.size();
/*     */             }
/*     */ 
/*     */             
/*     */             public int get() {
/* 453 */               return ((StationInstance)g.get()).tally((RESOURCE)RESOURCES.ALL().get(k)).crates();
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 458 */               ((StationInstance)g.get()).allocate((RESOURCE)RESOURCES.ALL().get(k), t);
/*     */             }
/*     */           };
/*     */         
/* 462 */         GSliderInt sl = new GSliderInt(in, 100, true);
/* 463 */         row.addRightC(8, (RENDEROBJ)sl);
/* 464 */         row.pad(4, 2);
/* 465 */         rr.add((RENDEROBJ)row);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 470 */       add((RENDEROBJ)(new GScrollRows((Iterable)rr.rows(), 650)).view());
/* 471 */       addRelBody(8, DIR.N, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 475 */               int am = 0;
/* 476 */               for (RESOURCE r : RESOURCES.ALL())
/* 477 */                 am += ((StationInstance)g.get()).tally(r).crates(); 
/* 478 */               GFORMAT.iofk(text, am, ((StationInstance)g.get()).crates.size());
/*     */             }
/*     */           });
/*     */       
/* 482 */       addRelBody(8, DIR.N, (RENDEROBJ)new GHeader(Dic.¤¤Resources));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\station\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */