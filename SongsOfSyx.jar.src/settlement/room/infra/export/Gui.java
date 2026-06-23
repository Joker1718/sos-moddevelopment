/*     */ package settlement.room.infra.export;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.infra.logistics.MoveDic;
/*     */ import settlement.room.infra.logistics.MoveOrderPullUI;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.Dictionary;
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
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.room.UIRoomBulkApplier;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ import view.ui.goods.UIGoodsExport;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Gui
/*     */   extends UIRoomModule.UIRoomModuleImp<ExportInstance, ROOM_EXPORT>
/*     */ {
/*  55 */   private static CharSequence ¤¤NoResource = "¤No resource has been selected for export.";
/*  56 */   private static CharSequence ¤¤prioProb = "¤Globally, there is not enough stored goods to fetch from the un-prioritized storage rooms in the vicinity. Increase the global priority fetch limit.";
/*  57 */   private static CharSequence ¤¤prio = "¤Workers will only fetch as long as the condition for the fetch limit below is met.";
/*     */   
/*     */   static {
/*  60 */     D.ts(Gui.class);
/*     */   }
/*     */   
/*     */   Gui(ROOM_EXPORT s) {
/*  64 */     super(s);
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
/*     */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<ExportInstance> g, int x1, int y1) {
/*  77 */     final UIPickerRes pop = new UIPickerRes(true)
/*     */       {
/*     */         protected void select(RESOURCE r, int li)
/*     */         {
/*  81 */           ((ExportInstance)g.get()).resourceSet(r);
/*  82 */           (VIEW.inters()).popup.close();
/*     */         }
/*     */ 
/*     */         
/*     */         protected RESOURCE getResource() {
/*  87 */           return ((ExportInstance)g.get()).resource();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void hoverResource(RESOURCE res, GBox b) {
/*  93 */           FACTIONS.player().seller((TRADABLE)TR.get(res)).hover((GUI_BOX)b);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  99 */     GuiSection guiSection1 = new GuiSection();
/*     */     
/* 101 */     SPRITE.Imp imp = new SPRITE.Imp(24)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 105 */           if (((ExportInstance)g.get()).resource() != null) {
/* 106 */             ((ExportInstance)g.get()).resource().icon().render(r, X1, X2, Y1, Y2);
/*     */           } else {
/* 108 */             (SPRITES.icons()).m.questionmark.render(r, X1, X2, Y1, Y2);
/*     */           } 
/*     */         }
/*     */       };
/* 112 */     GButt.ButtPanel b = new GButt.ButtPanel((SPRITE)imp)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 116 */           (VIEW.inters()).popup.show((RENDEROBJ)pop, (CLICKABLE)this, true);
/*     */         }
/*     */       };
/*     */     
/* 120 */     b.body.setDim(48.0D);
/*     */     
/* 122 */     guiSection1.add((RENDEROBJ)new GHeader(Dic.¤¤Exporting));
/* 123 */     guiSection1.addRelBody(6, DIR.E, (RENDEROBJ)b);
/*     */     
/* 125 */     RENDEROBJ r = null;
/* 126 */     HOVERABLE hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 130 */           GFORMAT.iofk(text, ((ExportInstance)g.get()).amount, (((ExportInstance)g.get()).crates * 500));
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/* 135 */           b.textLL(Dic.¤¤Inbound);
/* 136 */           b.add((SPRITE)GFORMAT.i(b.text(), ((ExportInstance)g.get()).spaceReserved));
/* 137 */           b.NL();
/* 138 */           b.textLL(Dic.¤¤Outbound);
/* 139 */           b.add((SPRITE)GFORMAT.i(b.text(), ((ExportInstance)g.get()).amountReserved));
/*     */           
/* 141 */           b.sep();
/* 142 */           if (((ExportInstance)g.get()).resource() != null)
/*     */           {
/* 144 */             b.textLL(Dic.¤¤Total);
/* 145 */             b.NL(8);
/*     */             
/* 147 */             b.textLL(Dic.¤¤Stored);
/* 148 */             b.tab(6);
/* 149 */             b.add((SPRITE)GFORMAT.i(b.text(), ((ROOM_EXPORT)Gui.this.blueprint).tally.amount.get(((ExportInstance)g.get()).resource())));
/* 150 */             b.NL();
/* 151 */             b.textLL(Dic.¤¤Capacity);
/* 152 */             b.tab(6);
/* 153 */             b.add((SPRITE)GFORMAT.i(b.text(), ((ROOM_EXPORT)Gui.this.blueprint).tally.capacity.get(((ExportInstance)g.get()).resource())));
/* 154 */             b.NL();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           }
/*     */         
/*     */         }
/* 166 */       }).hv(Dic.¤¤Stored);
/* 167 */     guiSection1.addRightC(32, (RENDEROBJ)hOVERABLE);
/*     */     
/* 169 */     hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 173 */           GFORMAT.i(text, ((ExportInstance)g.get()).amountReserved);
/*     */         }
/* 176 */       }).hv(Dic.¤¤Sold);
/* 177 */     guiSection1.addRightC(64, (RENDEROBJ)hOVERABLE);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 182 */     section.addRelBody(2, DIR.S, (RENDEROBJ)guiSection1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     GuiSection s = new GuiSection();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 196 */     GButt.ButtPanel p = new GButt.ButtPanel((SPRITE)(UI.icons()).m.wheel)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/* 200 */           selectedSet(((ExportInstance)g.get()).fetching());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 205 */           ((ExportInstance)g.get()).fetchingSet(!((ExportInstance)g.get()).fetching());
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 212 */           super.render(r, ds, isActive, isSelected, isHovered);
/* 213 */           if (((ExportInstance)g.get()).fetching() && ((ExportInstance)g.get()).coolFetch > -1) {
/* 214 */             (GCOLOR.UI()).SOSO.hovered.bind();
/* 215 */             (UI.icons()).s.alert.render(r, this.body.x1() + 6, this.body.y1() + 6);
/* 216 */             COLOR.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 222 */           GBox b = (GBox)text;
/* 223 */           b.title(MoveDic.¤¤fetch);
/* 224 */           b.text(MoveDic.¤¤fetchD);
/* 225 */           b.NL();
/* 226 */           if (((ExportInstance)g.get()).fetching() && ((ExportInstance)g.get()).coolFetch > -1) {
/* 227 */             b.add((SPRITE)b.text().warnify().add(MoveDic.¤¤fetchProblem));
/*     */           }
/* 229 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 234 */     p.body.setDim(48.0D);
/* 235 */     s.addRightC(0, (RENDEROBJ)p);
/*     */     
/* 237 */     p = new GButt.ButtPanel((SPRITE)(UI.icons()).m.priority)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/* 241 */           selectedSet(((ExportInstance)g.get()).prio());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 246 */           ((ExportInstance)g.get()).prioSet();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 253 */           super.render(r, ds, isActive, isSelected, isHovered);
/* 254 */           if (((ExportInstance)g.get()).resource() == null || ((ROOM_EXPORT)Gui.this.blueprint).prioFetchAvailable(((ExportInstance)g.get()).resource()) < 0 || (((ExportInstance)g.get()).prio() && ((ExportInstance)g.get()).coolFetch > -1)) {
/* 255 */             (GCOLOR.UI()).SOSO.hovered.bind();
/* 256 */             (UI.icons()).s.alert.render(r, this.body.x1() + 6, this.body.y1() + 6);
/* 257 */             COLOR.unbind();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 263 */           GBox b = (GBox)text;
/* 264 */           b.title(MoveDic.¤¤prio);
/* 265 */           b.text(MoveDic.¤¤prioD);
/* 266 */           b.NL();
/* 267 */           b.text(Gui.¤¤prio);
/* 268 */           b.NL();
/*     */           
/* 270 */           if (((ExportInstance)g.get()).resource() == null) {
/* 271 */             b.add((SPRITE)b.text().warnify().add(Gui.¤¤NoResource));
/* 272 */           } else if (((ROOM_EXPORT)Gui.this.blueprint).prioFetchAvailable(((ExportInstance)g.get()).resource()) < 0) {
/* 273 */             b.add((SPRITE)b.text().warnify().add(Gui.¤¤prioProb));
/* 274 */           } else if (((ExportInstance)g.get()).prio() && ((ExportInstance)g.get()).coolFetch > -1) {
/* 275 */             b.add((SPRITE)b.text().warnify().add(MoveDic.¤¤fetchProblem));
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 282 */     p.body.setDim(48.0D);
/* 283 */     s.addRightC(0, (RENDEROBJ)p);
/*     */ 
/*     */ 
/*     */     
/* 287 */     s.addRightC(8, (RENDEROBJ)new MoveOrderPullUI(g, g, null, 4));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 293 */     section.addRelBody(2, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 300 */     final UIGoodsExport ex = new UIGoodsExport(false);
/* 301 */     CLICKABLE.ClickWrap clickWrap = new CLICKABLE.ClickWrap((RENDEROBJ)ex)
/*     */       {
/*     */         protected RENDEROBJ pget()
/*     */         {
/* 305 */           if (((ExportInstance)g.get()).resource() == null)
/* 306 */             return null; 
/* 307 */           ex.res.set(((ExportInstance)g.get()).resource().tr());
/* 308 */           return (RENDEROBJ)ex;
/*     */         }
/*     */       };
/* 311 */     section.addRelBody(2, DIR.S, (RENDEROBJ)clickWrap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendTableButt(GuiSection s, final GETTER<RoomInstance> ins) {
/* 320 */     s.add((SPRITE)new SPRITE.Imp(16)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 324 */             RESOURCE ro = ((ExportInstance)ins.get()).resource();
/* 325 */             SPRITE s = (ro == null) ? (SPRITE)(SPRITES.icons()).s.cancel : (ro.icon()).small;
/* 326 */             s.render(r, X1, Y1);
/*     */           }
/* 328 */         }0, s.body().y2());
/*     */     
/* 330 */     s.addRightC(8, (SPRITE)new SPRITE.Imp(s.body().width() - 8 - s.getLastX2(), 12)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 334 */             ExportInstance in = (ExportInstance)ins.get();
/*     */             
/* 336 */             double t = (in.crates * 500);
/* 337 */             double n = in.amount;
/* 338 */             double i = in.amountReserved;
/* 339 */             GMeter.renderDelta(r, (n - i) / t, n / 2.0D, X1, X2, Y1, Y2);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void problem(ExportInstance i, Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings) {
/* 347 */     if (i.resource() == null) {
/* 348 */       errors.add(¤¤NoResource);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, ExportInstance i) {
/* 356 */     if (i.resource() != null) {
/* 357 */       box.setResource(i.resource(), i.amount, i.crates * 500);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendMain(GGrid grid, GGrid text, GuiSection sExtra) {
/* 363 */     RENDEROBJ r = null;
/*     */     
/* 365 */     HOVERABLE hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 369 */           double am = 0.0D;
/* 370 */           double cap = 0.0D;
/*     */           
/* 372 */           for (RESOURCE r : RESOURCES.ALL()) {
/* 373 */             am += ((ROOM_EXPORT)Gui.this.blueprint).tally.amount.get(r);
/* 374 */             cap += ((ROOM_EXPORT)Gui.this.blueprint).tally.capacity.get(r);
/*     */           } 
/* 376 */           GFORMAT.percInv(text, am / cap);
/*     */         }
/* 379 */       }).hh(Dic.¤¤Capacity);
/* 380 */     text.add((RENDEROBJ)hOVERABLE);
/* 381 */     hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 385 */           int am = 0;
/* 386 */           for (RESOURCE r : RESOURCES.ALL()) {
/* 387 */             am += ((ROOM_EXPORT)Gui.this.blueprint).tally.amount.get(r);
/*     */           }
/* 389 */           GFORMAT.i(text, am);
/*     */         }
/* 392 */       }).hh(Dic.¤¤Stored);
/* 393 */     text.add((RENDEROBJ)hOVERABLE);
/* 394 */     hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 398 */           int am = 0;
/* 399 */           for (RESOURCE r : RESOURCES.ALL()) {
/* 400 */             am += (SETT.HALFENTS()).caravans.withdrawals(r, null);
/*     */           }
/* 402 */           GFORMAT.i(text, am);
/*     */         }
/* 405 */       }).hh(Dic.¤¤Outbound);
/*     */     
/* 407 */     text.add((RENDEROBJ)hOVERABLE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {
/* 414 */     final CharSequence none = "--";
/* 415 */     GTableSorter.GTSort<RoomInstance> s = new GTableSorter.GTSort<RoomInstance>(Dic.¤¤Resource)
/*     */       {
/*     */         public int cmp(RoomInstance current, RoomInstance cmp)
/*     */         {
/* 419 */           return Dictionary.compare(name(current), name(cmp));
/*     */         }
/*     */ 
/*     */         
/*     */         public void format(RoomInstance h, GText text) {
/* 424 */           text.add(name(h));
/*     */         }
/*     */         
/*     */         private CharSequence name(RoomInstance ins) {
/* 428 */           if (ins != null && ins instanceof ExportInstance) {
/* 429 */             ExportInstance i = (ExportInstance)ins;
/* 430 */             if (i.resource() == null)
/* 431 */               return none; 
/* 432 */             return (i.resource()).name;
/*     */           } 
/* 434 */           return none;
/*     */         }
/*     */       };
/*     */     
/* 438 */     sorts.add(s);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\export\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */