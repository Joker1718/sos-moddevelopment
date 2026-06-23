/*     */ package settlement.room.main.copy;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.structure.STRUCTURES;
/*     */ import init.structure.Structure;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.construction.ConstructionInit;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.placement.PLACEMENT;
/*     */ import settlement.room.main.placement.UtilWallPlacability;
/*     */ import settlement.room.main.util.Deleter;
/*     */ import settlement.room.main.util.RoomAreaWrapper;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableFixed;
/*     */ import view.tool.PlacableFixedImp;
/*     */ import view.tool.PlacableSingle;
/*     */ import view.tool.ToolConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ class Copier
/*     */   extends PlacableSingle
/*     */ {
/*  53 */   private static CharSequence ¤¤name = "¤Room Copier";
/*  54 */   private static CharSequence ¤¤IncludeWalls = "¤Include Walls";
/*  55 */   private static CharSequence ¤¤desc = "¤Copies already planned rooms.";
/*  56 */   private static CharSequence ¤¤indoor = "¤This room requires to be built indoors and you must pick a structure type.";
/*     */   
/*     */   static {
/*  59 */     D.ts(Copier.class);
/*     */   }
/*  61 */   private static RoomAreaWrapper wrap = new RoomAreaWrapper();
/*     */   
/*     */   private ROOMA room;
/*     */   
/*     */   private TBuilding structure;
/*     */   private boolean w = true;
/*     */   private final BSwap swap;
/*  68 */   private final GuiSection buttonsIndoor = new GuiSection();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final LIST<CLICKABLE> walls;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final CLICKABLE bOverlay;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final CLICKABLE bFoundation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ArrayList<CLICKABLE> butts;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RoomBlueprintImp pppp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ToolConfig config;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final PlacableFixed nextStep;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Copier(BSwap s) {
/* 181 */     super(¤¤name, ¤¤desc);
/*     */     D.gInit(this);
/*     */     for (Structure t : STRUCTURES.all()) {
/*     */       GButt.Panel panel = new GButt.Panel((t.terrain()).iconCombo, t.desc) { public void hoverInfoGet(GUI_BOX text) {
/*     */             GBox b = (GBox)text;
/*     */             b.title(t.name);
/*     */             b.text(t.desc);
/*     */             b.NL();
/*     */             b.setResource(t.resource, t.resAmount);
/*     */           } protected void clickA() {
/*     */             Copier.this.structure = t.terrain();
/*     */             (VIEW.inters()).popup.close();
/*     */           } protected void renAction() {
/*     */             selectedSet((Copier.this.structure == t.terrain()));
/*     */           } }
/*     */         ;
/*     */       this.buttonsIndoor.addDownC(0, (RENDEROBJ)panel);
/*     */     } 
/*     */     this.walls = (LIST<CLICKABLE>)new ArrayList((Object[])new GButt.Panel[] { new GButt.Panel((SPRITE)(SPRITES.icons()).m.wall) { protected void clickA() {
/*     */               Copier.this.w = !Copier.this.w;
/*     */             } protected void renAction() {
/*     */               selectedSet(Copier.this.w);
/*     */             } public void hoverInfoGet(GUI_BOX text) {
/*     */               text.text(Copier.¤¤IncludeWalls);
/*     */             } }
/*     */           , new GButt.Panel((SPRITE)(SPRITES.icons()).m.cancel) { protected void clickA() {
/*     */               (VIEW.inters()).popup.show((RENDEROBJ)Copier.this.buttonsIndoor, (CLICKABLE)this);
/*     */             } protected void renAction() {
/*     */               replaceLabel((Copier.this.structure == null) ? ((TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(0)).iconCombo : Copier.this.structure.iconCombo, DIR.C);
/*     */             } public void hoverInfoGet(GUI_BOX text) {
/*     */               text.text(Copier.¤¤indoor);
/*     */             } }
/*     */            });
/*     */     this.bOverlay = (CLICKABLE)new GButt.ButtPanel((UI.icons()).s.eye.sized(24)) { protected void clickA() {
/*     */           (SETT.ROOMS()).placement.placer.showOverlay.toggle();
/*     */         }
/*     */         protected void renAction() {
/*     */           selectedSet((SETT.ROOMS()).placement.placer.showOverlay.is());
/*     */         }
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*     */           text.title(Dic.¤¤Overlay);
/*     */           if (Copier.this.swap.current().constructor().overlay() != null && (Copier.this.swap.current().constructor().overlay()).desc != null)
/*     */             text.text((Copier.this.swap.current().constructor().overlay()).desc); 
/*     */         } }
/*     */       ;
/*     */     this.bFoundation = (CLICKABLE)new GButt.ButtPanel((SPRITE)(UI.icons()).m.foundation) { protected void clickA() {
/*     */           (SETT.ROOMS()).placement.placer.showFoundation.toggle();
/*     */         }
/*     */         protected void renAction() {
/*     */           selectedSet((SETT.ROOMS()).placement.placer.showFoundation.is());
/*     */         }
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*     */           text.title((SETT.OVERLAY()).FOUNDATION.name);
/*     */           text.text((SETT.OVERLAY()).FOUNDATION.desc);
/*     */         } }
/*     */       ;
/*     */     this.butts = new ArrayList(this.walls.size() + 1);
/* 238 */     this.config = new ToolConfig()
/*     */       {
/*     */         public boolean back()
/*     */         {
/* 242 */           (VIEW.s()).tools.place((PLACABLE)Copier.this);
/* 243 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void addUI(LISTE<RENDEROBJ> uis) {
/* 248 */           (VIEW.s()).tools.placer.addStandardButtons(uis, true);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 253 */     this.nextStep = (PlacableFixed)new PlacableFixedImp(name(), 4, 1)
/*     */       {
/* 255 */         private final Coo cTmp = new Coo();
/*     */         
/*     */         private boolean update() {
/* 258 */           Room r = (SETT.ROOMS()).map.get(Copier.this.room.mX(), Copier.this.room.mY());
/*     */           
/* 260 */           if (r == null)
/* 261 */             return false; 
/* 262 */           if (r.constructor() == null)
/* 263 */             return false; 
/* 264 */           if (Copier.this.structure == null) {
/* 265 */             if (r.constructor().mustBeIndoors()) {
/* 266 */               Copier.this.structure = ConstructionInit.findStructure(Copier.this.room.mX(), Copier.this.room.mY());
/*     */             } else {
/* 268 */               Copier.this.structure = null;
/*     */             } 
/*     */           }
/* 271 */           Copier.wrap.done();
/* 272 */           Copier.this.room = Copier.wrap.init(r, Copier.this.room.mX(), Copier.this.room.mY());
/*     */           
/* 274 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, int rx, int ry) {
/* 282 */           if (rx != 0 || ry != 0) {
/*     */             return;
/*     */           }
/*     */           
/* 286 */           update();
/*     */           
/* 288 */           Furnisher furnisher = Copier.this.swap.current().constructor();
/*     */           
/* 290 */           if (furnisher.mustBeIndoors() && Copier.this.w)
/*     */           {
/* 292 */             for (int dy = 0; dy < height(); dy++) {
/* 293 */               for (int dx = 0; dx < width(); dx++) {
/* 294 */                 COORDINATE c = getSourceTile(dx, dy);
/* 295 */                 if (Copier.this.room.is(c)) {
/* 296 */                   for (int i = 0; i < DIR.ALL.size(); i++) {
/* 297 */                     DIR d = (DIR)DIR.ALL.get(i);
/* 298 */                     c = getSourceTile(dx + d.x(), dy + d.y());
/* 299 */                     if (!Copier.this.room.is(c)) {
/*     */                       
/* 301 */                       int x = tx + dx + d.x();
/* 302 */                       int j = ty + dy + d.y();
/*     */                       
/* 304 */                       if (UtilWallPlacability.wallisReal.is(c)) {
/* 305 */                         if (UtilWallPlacability.wallShouldBuild.is(x, j)) {
/* 306 */                           UtilWallPlacability.wallBuild(x, j, Copier.this.structure);
/*     */                         }
/* 308 */                       } else if (UtilWallPlacability.openingIsReal.is(c) && 
/* 309 */                         UtilWallPlacability.openingShouldBuild.is(x, j)) {
/* 310 */                         UtilWallPlacability.openingBuild(x, j, Copier.this.structure);
/*     */                       } 
/*     */                     } 
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 348 */           TmpArea tmp = SETT.ROOMS().tmpArea(this);
/*     */ 
/*     */           
/* 351 */           int w = width();
/* 352 */           int h = height(); int y;
/* 353 */           for (y = 0; y < h; y++) {
/* 354 */             for (int x = 0; x < w; x++) {
/* 355 */               COORDINATE c = getSourceTile(x, y);
/* 356 */               if (Copier.this.room.is(c))
/*     */               {
/* 358 */                 tmp.set(tx + x, ty + y);
/*     */               }
/*     */             } 
/*     */           } 
/* 362 */           for (y = 0; y < h; y++) {
/* 363 */             for (int x = 0; x < w; x++) {
/*     */               
/* 365 */               COORDINATE c = getSourceTile(x, y);
/* 366 */               int sx = c.x();
/* 367 */               int sy = c.y();
/* 368 */               if (Copier.this.room.is(sx, sy)) {
/*     */                 
/* 370 */                 FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(sx, sy);
/* 371 */                 if ((SETT.ROOMS()).fData.isMaster.is(sx, sy)) {
/*     */ 
/*     */                   
/* 374 */                   c = getOrigionalDelta(sx, sy);
/* 375 */                   int x1 = c.x() + tx;
/* 376 */                   int y1 = c.y() + ty;
/*     */                   
/* 378 */                   c = getSourceItemOff(it, it.firstX(), it.firstY());
/* 379 */                   x1 -= c.x();
/* 380 */                   y1 -= c.y();
/*     */                   
/* 382 */                   int rot = it.rotation + rot() % it.group.rotations();
/* 383 */                   rot %= it.group.rotations();
/* 384 */                   it = it.group.item(it.variation(), rot);
/*     */                   
/* 386 */                   (SETT.ROOMS()).fData.itemSet(x1, y1, it, tmp.room());
/*     */                 } 
/*     */               } 
/*     */             } 
/* 390 */           }  Room r = (SETT.ROOMS()).map.get(Copier.this.room.mX(), Copier.this.room.mY());
/* 391 */           ConstructionInit init = new ConstructionInit(r.upgrade(Copier.this.room.mX(), Copier.this.room.mY()), furnisher, Copier.this.structure, 0, r.makeState(Copier.this.room.mX(), Copier.this.room.mY(), false));
/*     */           
/* 393 */           (SETT.ROOMS()).construction.createClean(tmp, init);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public CharSequence placable(int tx, int ty, int rx, int ry) {
/* 401 */           if (!update()) {
/* 402 */             (VIEW.s()).tools.place(null);
/* 403 */             return E;
/*     */           } 
/*     */           
/* 406 */           COORDINATE c = getSourceTile(rx, ry);
/* 407 */           if (!Copier.this.room.is(c)) {
/* 408 */             return null;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 413 */           Furnisher furnisher = Copier.this.swap.current().constructor();
/* 414 */           CharSequence s = PLACEMENT.placable(tx, ty, furnisher.blue(), true);
/* 415 */           if (s != null) {
/* 416 */             return s;
/*     */           }
/*     */           
/* 419 */           return furnisher.placable(tx, ty, (FurnisherItem)(SETT.ROOMS()).fData.item.get(c), (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(c));
/*     */         }
/*     */ 
/*     */         
/*     */         public void updateRegardless(GameWindow window) {
/* 424 */           if (Copier.this.swap.current().constructor().overlay() != null && (SETT.ROOMS()).placement.placer.showOverlay.is()) {
/* 425 */             Copier.this.swap.current().constructor().overlay().add();
/*     */           }
/* 427 */           if (Copier.this.swap.current().constructor().isHeavy() && (SETT.ROOMS()).placement.placer.showFoundation.is()) {
/* 428 */             (SETT.OVERLAY()).FOUNDATION.add();
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public int width() {
/* 434 */           int wi = ((rot() & 0x1) == 1) ? Copier.this.room.body().height() : Copier.this.room.body().width();
/* 435 */           return wi;
/*     */         }
/*     */ 
/*     */         
/*     */         public int height() {
/* 440 */           int h = ((rot() & 0x1) == 0) ? Copier.this.room.body().height() : Copier.this.room.body().width();
/* 441 */           return h;
/*     */         }
/*     */         
/*     */         private COORDINATE getSourceTile(int rx, int ry) {
/* 445 */           switch (rot()) {
/*     */             case 0:
/* 447 */               this.cTmp.set((Copier.this.room.body().x1() + rx), (Copier.this.room.body().y1() + ry));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 464 */               return (COORDINATE)this.cTmp;case 1: this.cTmp.ySet((Copier.this.room.body().y2() - rx - 1)); this.cTmp.xSet((Copier.this.room.body().x1() + ry)); return (COORDINATE)this.cTmp;case 2: this.cTmp.ySet((Copier.this.room.body().y2() - ry - 1)); this.cTmp.xSet((Copier.this.room.body().x2() - rx - 1)); return (COORDINATE)this.cTmp;case 3: this.cTmp.ySet((Copier.this.room.body().y1() + rx)); this.cTmp.xSet((Copier.this.room.body().x2() - ry - 1)); return (COORDINATE)this.cTmp;
/*     */           } 
/*     */           throw new RuntimeException();
/*     */         } private COORDINATE getOrigionalDelta(int rx, int ry) {
/* 468 */           int dx = rx - Copier.this.room.body().x1();
/* 469 */           int dy = ry - Copier.this.room.body().y1();
/* 470 */           switch (rot()) {
/*     */             case 0:
/* 472 */               this.cTmp.set(dx, dy);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 489 */               return (COORDINATE)this.cTmp;case 1: this.cTmp.ySet(dx); this.cTmp.xSet((Copier.this.room.body().height() - dy - 1)); return (COORDINATE)this.cTmp;case 2: this.cTmp.ySet((Copier.this.room.body().height() - dy - 1)); this.cTmp.xSet((Copier.this.room.body().width() - dx - 1)); return (COORDINATE)this.cTmp;case 3: this.cTmp.ySet((Copier.this.room.body().width() - dx - 1)); this.cTmp.xSet(dy); return (COORDINATE)this.cTmp;
/*     */           } 
/*     */           throw new RuntimeException();
/*     */         }
/*     */         
/*     */         private COORDINATE getSourceItemOff(FurnisherItem i, int rx, int ry) {
/* 495 */           switch (rot()) {
/*     */             case 0:
/* 497 */               this.cTmp.set(rx, ry);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 514 */               return (COORDINATE)this.cTmp;case 1: this.cTmp.ySet(rx); this.cTmp.xSet((i.height() - ry - 1)); return (COORDINATE)this.cTmp;case 2: this.cTmp.ySet((i.height() - ry - 1)); this.cTmp.xSet((i.width() - rx - 1)); return (COORDINATE)this.cTmp;case 3: this.cTmp.ySet((i.width() - rx - 1)); this.cTmp.xSet(ry); return (COORDINATE)this.cTmp;
/*     */           } 
/*     */           throw new RuntimeException();
/*     */         }
/*     */         public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, int rx, int ry, boolean isPlacable, boolean areaIsPlacable) {
/* 519 */           COORDINATE c = getSourceTile(rx, ry);
/* 520 */           if (!Copier.this.room.is(c)) {
/*     */             return;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 526 */           if (isPlacable && areaIsPlacable) {
/* 527 */             if (!(SETT.JOBS()).planMode.is()) {
/* 528 */               (GCOLOR.MAP()).JOB_ACTIVE.bind();
/*     */             } else {
/* 530 */               (GCOLOR.MAP()).JOB_DORMANT.bind();
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 537 */           FurnisherItemTile tile = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(c);
/*     */           
/* 539 */           if (tile == null || tile.sprite() == null || !tile.isBlocker()) {
/* 540 */             (SPRITES.cons()).BIG.dashed.render(r, mask, x, y);
/*     */           } else {
/* 542 */             (SPRITES.cons()).BIG.filled.render(r, mask, x, y);
/*     */           } 
/*     */           
/* 545 */           Furnisher furnisher = Copier.this.swap.current().constructor();
/* 546 */           if (furnisher.mustBeIndoors() && Copier.this.w) {
/* 547 */             for (int i = 0; i < DIR.NORTHO.size(); i++) {
/* 548 */               DIR d = (DIR)DIR.NORTHO.get(i);
/* 549 */               c = getSourceTile(rx + d.x(), ry + d.y());
/* 550 */               if (!Copier.this.room.is(c)) {
/* 551 */                 if (UtilWallPlacability.wallisReal.is(c) && UtilWallPlacability.wallShouldBuild.is(tx + d.x(), ty + d.y())) {
/* 552 */                   (SPRITES.cons()).BIG.filled.render(r, 0, x + d.x() * 64, y + d.y() * 64);
/* 553 */                 } else if (UtilWallPlacability.openingIsReal.is(c) && UtilWallPlacability.openingShouldBuild.is(tx + d.x(), ty + d.y())) {
/* 554 */                   (SPRITES.cons()).BIG.dashed_hollow.render(r, 0, x + d.x() * 64, y + d.y() * 64);
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           }
/* 559 */           COLOR.unbind();
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/* 564 */           Furnisher furnisher = Copier.this.swap.current().constructor();
/* 565 */           Copier.this.butts.clearSloppy();
/* 566 */           if (furnisher.mustBeIndoors()) {
/* 567 */             Copier.this.butts.add((Iterable)Copier.this.walls);
/*     */           }
/* 569 */           if (furnisher.overlay() != null)
/* 570 */             Copier.this.butts.add(Copier.this.bOverlay); 
/* 571 */           if (furnisher.isHeavy())
/* 572 */             Copier.this.butts.add(Copier.this.bFoundation); 
/* 573 */           return Copier.this.swap.wrap((LIST<CLICKABLE>)Copier.this.butts);
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence name() {
/* 578 */           Furnisher furnisher = Copier.this.swap.current().constructor();
/* 579 */           return (furnisher.blue()).info.name;
/*     */         }
/*     */       };
/*     */     this.swap = s;
/*     */   }
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty) {
/*     */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/*     */     if (r != null && r.constructor() != null && r.constructor().canBeCopied()) {
/*     */       this.pppp = r.constructor().blue();
/*     */       if (!this.pppp.reqs.passes(FACTIONS.player()))
/*     */         return Dic.¤¤Locked; 
/*     */       if (!Deleter.canRemove(tx, ty))
/*     */         return E; 
/*     */       return null;
/*     */     } 
/*     */     return E;
/*     */   }
/*     */   
/*     */   public void placeInfo(GBox b, int tiles) {
/*     */     if (this.pppp != null)
/*     */       b.text(this.pppp.info.name); 
/*     */     super.placeInfo(b, tiles);
/*     */     this.pppp = null;
/*     */   }
/*     */   
/*     */   public void placeFirst(int tx, int ty) {
/*     */     Room room = (SETT.ROOMS()).map.get(tx, ty);
/*     */     wrap.done();
/*     */     this.room = wrap.init(room, tx, ty);
/*     */     this.structure = (SETT.ROOMS()).construction.structure(tx, ty);
/*     */     this.nextStep.rotSet(0);
/*     */     this.swap.init((SETT.ROOMS()).map.get(tx, ty).constructor().blue());
/*     */     (VIEW.s()).tools.place((PLACABLE)this.nextStep, this.config);
/*     */     wrap.done();
/*     */   }
/*     */   
/*     */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/*     */     return ((SETT.ROOMS()).map.get(fromX, fromY) != null && (SETT.ROOMS()).map.get(fromX, fromY).isSame(fromX, fromY, toX, toY));
/*     */   }
/*     */   
/*     */   public SPRITE getIcon() {
/*     */     return (SPRITE)(SPRITES.icons()).l.copyRoom;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\copy\Copier.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */