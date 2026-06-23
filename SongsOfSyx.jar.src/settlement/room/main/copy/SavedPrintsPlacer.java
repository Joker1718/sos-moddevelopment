/*     */ package settlement.room.main.copy;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.construction.ConstructionInit;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.placement.PLACEMENT;
/*     */ import settlement.room.main.placement.UtilWallPlacability;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableFixed;
/*     */ import view.tool.PlacableFixedImp;
/*     */ 
/*     */ public final class SavedPrintsPlacer {
/*     */   private SavedPrints.SavedPrint print;
/*     */   private final BSwap swap;
/*  37 */   private GuiSection sSelect = new GuiSection();
/*     */   private boolean w = true;
/*     */   
/*  40 */   private final CLICKABLE bOverlay = (CLICKABLE)new GButt.ButtPanel((UI.icons()).s.eye.sized(24))
/*     */     {
/*     */       protected void clickA()
/*     */       {
/*  44 */         (SETT.ROOMS()).placement.placer.showOverlay.toggle();
/*     */       }
/*     */ 
/*     */       
/*     */       protected void renAction() {
/*  49 */         selectedSet((SETT.ROOMS()).placement.placer.showOverlay.is());
/*     */       }
/*     */ 
/*     */       
/*     */       public void hoverInfoGet(GUI_BOX text) {
/*  54 */         text.title(Dic.¤¤Overlay);
/*  55 */         (SETT.ROOMS()).placement.placer.structure.get();
/*  56 */         if (SavedPrintsPlacer.this.swap.current().constructor().overlay() != null && (SavedPrintsPlacer.this.swap.current().constructor().overlay()).desc != null) {
/*  57 */           text.text((SavedPrintsPlacer.this.swap.current().constructor().overlay()).desc);
/*     */         }
/*     */       }
/*     */     };
/*     */   
/*  62 */   private final CLICKABLE bFoundation = (CLICKABLE)new GButt.ButtPanel((SPRITE)(UI.icons()).m.foundation)
/*     */     {
/*     */       protected void clickA()
/*     */       {
/*  66 */         (SETT.ROOMS()).placement.placer.showFoundation.toggle();
/*     */       }
/*     */ 
/*     */       
/*     */       protected void renAction() {
/*  71 */         selectedSet((SETT.ROOMS()).placement.placer.showFoundation.is());
/*     */       }
/*     */ 
/*     */       
/*     */       public void hoverInfoGet(GUI_BOX text) {
/*  76 */         text.title((SETT.OVERLAY()).FOUNDATION.name);
/*  77 */         text.text((SETT.OVERLAY()).FOUNDATION.desc);
/*     */       }
/*     */     };
/*     */   
/*  81 */   private final ArrayList<CLICKABLE> walls = new ArrayList((Object[])new GButt.ButtPanel[] {
/*  82 */         (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.wall)
/*     */         {
/*  84 */           private String s = "Include walls";
/*     */           
/*     */           protected void clickA() {
/*  87 */             SavedPrintsPlacer.this.w = !SavedPrintsPlacer.this.w;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  92 */             selectedSet(SavedPrintsPlacer.this.w);
/*     */           }
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  96 */             text.text(this.s);
/*     */           }
/*  98 */         }).setDim(36), (
/*  99 */         new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.wall)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 103 */             (VIEW.inters()).popup.show((RENDEROBJ)SavedPrintsPlacer.this.sSelect, (CLICKABLE)this);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 108 */             activeSet(SavedPrintsPlacer.this.w);
/* 109 */             if (SavedPrintsPlacer.this.structure() != null)
/* 110 */               replaceLabel((SavedPrintsPlacer.this.structure()).iconCombo, DIR.C); 
/*     */           }
/* 112 */         }).setDim(36)
/*     */       });
/*     */   
/* 115 */   private final ArrayList<CLICKABLE> butts = new ArrayList(this.walls.size() + 1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final PlacableFixed placer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TBuilding structure() {
/* 139 */     TBuilding structure = (TBuilding)(SETT.ROOMS()).placement.placer.structure.get();
/* 140 */     if (structure == null) {
/* 141 */       (SETT.ROOMS()).placement.placer.structure.set((SETT.TERRAIN()).BUILDINGS.MUD);
/* 142 */       structure = (SETT.TERRAIN()).BUILDINGS.MUD;
/*     */     } 
/* 144 */     return structure;
/*     */   }
/*     */   
/*     */   public void place(SavedPrints.SavedPrint print) {
/* 148 */     this.print = print;
/* 149 */     this.swap.init(print.blue);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 155 */     (VIEW.s()).tools.place((PLACABLE)this.placer);
/*     */   }
/*     */   
/*     */   public void place(SavedPrints.SavedPrint print, RoomBlueprint blue) {
/* 159 */     if (blue.getClass() != print.blue.getClass())
/* 160 */       throw new RuntimeException(); 
/* 161 */     this.print = print;
/* 162 */     this.swap.init((RoomBlueprintImp)blue);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 167 */     (VIEW.s()).tools.place((PLACABLE)this.placer);
/*     */   }
/*     */ 
/*     */   
/*     */   SavedPrintsPlacer(BSwap swap) {
/* 172 */     this.placer = (PlacableFixed)new PlacableFixedImp(null, 4, 1)
/*     */       {
/* 174 */         private final Coo cTmp = new Coo();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, int rrx, int rry) {
/* 181 */           TmpArea tmp = SETT.ROOMS().tmpArea(this);
/*     */           
/* 183 */           COORDINATE r = getSourceTile(rrx, rry);
/*     */           
/* 185 */           int rx = r.x();
/* 186 */           int ry = r.y();
/*     */           
/* 188 */           Furnisher furnisher = SavedPrintsPlacer.this.swap.current().constructor();
/*     */           
/* 190 */           if (SavedPrintsPlacer.this.w && furnisher.mustBeIndoors() && SavedPrintsPlacer.this.structure() != null && !SavedPrintsPlacer.this.print.isRoom(rx, ry)) {
/* 191 */             if (SavedPrintsPlacer.this.print.isWall(rx, ry) && UtilWallPlacability.wallShouldBuild.is(tx, ty)) {
/* 192 */               UtilWallPlacability.wallBuild(tx, ty, SavedPrintsPlacer.this.structure());
/* 193 */             } else if (SavedPrintsPlacer.this.print.isRoof(rx, ry) && UtilWallPlacability.openingShouldBuild.is(tx, ty)) {
/* 194 */               UtilWallPlacability.openingBuild(tx, ty, SavedPrintsPlacer.this.structure());
/*     */             } 
/*     */           }
/*     */           
/* 198 */           if (rrx != 0 || rry != 0) {
/* 199 */             tmp.clear();
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/* 204 */           int w = width();
/* 205 */           int h = height(); int y;
/* 206 */           for (y = 0; y < h; y++) {
/* 207 */             for (int x = 0; x < w; x++) {
/* 208 */               COORDINATE c = getSourceTile(x, y);
/* 209 */               rx = c.x();
/* 210 */               ry = c.y();
/* 211 */               if (SavedPrintsPlacer.this.print.isRoom(rx, ry))
/*     */               {
/* 213 */                 tmp.set(tx + x, ty + y);
/*     */               }
/*     */             } 
/*     */           } 
/* 217 */           for (y = 0; y < h; y++) {
/* 218 */             for (int x = 0; x < w; x++) {
/* 219 */               COORDINATE c = getSourceTile(x, y);
/* 220 */               rx = c.x();
/* 221 */               ry = c.y();
/* 222 */               if (SavedPrintsPlacer.this.print.isRoom(rx, ry)) {
/*     */                 
/* 224 */                 FurnisherItem it = SavedPrintsPlacer.this.print.item(rx, ry, furnisher.blue());
/* 225 */                 if (it != null) {
/*     */                   
/* 227 */                   c = rotate(-it.firstX(), -it.firstY());
/* 228 */                   int dx = c.x();
/* 229 */                   int dy = c.y();
/*     */                   
/* 231 */                   FurnisherItem it2 = it.group.item(it.variation(), (it.rotation + rot()) % it.group.rotations());
/* 232 */                   r = getSourceItemOff(it2, x + tx + dx, y + ty + dy);
/* 233 */                   int x1 = r.x();
/* 234 */                   int y1 = r.y();
/*     */ 
/*     */                   
/* 237 */                   (SETT.ROOMS()).fData.itemSet(x1, y1, it2, tmp.room());
/*     */                 } 
/*     */               } 
/*     */             } 
/* 241 */           }  ConstructionInit init = new ConstructionInit(0, furnisher, SavedPrintsPlacer.this.structure(), 0, RoomState.DUMMY);
/* 242 */           (SETT.ROOMS()).construction.createClean(tmp, init);
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence placable(int tx, int ty, int rx, int ry) {
/* 247 */           COORDINATE c = getSourceTile(rx, ry);
/* 248 */           if (!SavedPrintsPlacer.this.print.isRoom(c.x(), c.y()))
/* 249 */             return null; 
/* 250 */           Furnisher furnisher = SavedPrintsPlacer.this.swap.current().constructor();
/* 251 */           CharSequence s = PLACEMENT.placable(tx, ty, furnisher.blue(), true);
/* 252 */           if (s != null)
/* 253 */             return s; 
/* 254 */           return furnisher.placable(tx, ty, (FurnisherItem)(SETT.ROOMS()).fData.item.get(c), (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(c));
/*     */         }
/*     */ 
/*     */         
/*     */         public int width() {
/* 259 */           int wi = ((rot() & 0x1) == 1) ? SavedPrintsPlacer.this.print.height : SavedPrintsPlacer.this.print.width;
/* 260 */           return wi;
/*     */         }
/*     */ 
/*     */         
/*     */         public int height() {
/* 265 */           int h = ((rot() & 0x1) == 0) ? SavedPrintsPlacer.this.print.height : SavedPrintsPlacer.this.print.width;
/* 266 */           return h;
/*     */         }
/*     */         
/*     */         private COORDINATE getSourceTile(int rx, int ry) {
/* 270 */           switch (rot()) {
/*     */             case 0:
/* 272 */               this.cTmp.set(rx, ry);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 289 */               return (COORDINATE)this.cTmp;case 1: this.cTmp.ySet((SavedPrintsPlacer.this.print.height - rx - 1)); this.cTmp.xSet(ry); return (COORDINATE)this.cTmp;case 2: this.cTmp.ySet((SavedPrintsPlacer.this.print.height - ry - 1)); this.cTmp.xSet((SavedPrintsPlacer.this.print.width - rx - 1)); return (COORDINATE)this.cTmp;case 3: this.cTmp.ySet(rx); this.cTmp.xSet((SavedPrintsPlacer.this.print.width - ry - 1)); return (COORDINATE)this.cTmp;
/*     */           } 
/*     */           throw new RuntimeException();
/*     */         }
/*     */         private COORDINATE getSourceItemOff(FurnisherItem i, int rx, int ry) {
/* 294 */           switch (rot()) {
/*     */             case 0:
/* 296 */               this.cTmp.set(rx, ry);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 313 */               return (COORDINATE)this.cTmp;case 1: this.cTmp.ySet(ry); this.cTmp.xSet((rx - i.width() + 1)); return (COORDINATE)this.cTmp;case 2: this.cTmp.ySet((ry - i.height() + 1)); this.cTmp.xSet((rx - i.width() + 1)); return (COORDINATE)this.cTmp;case 3: this.cTmp.ySet((ry - i.height() + 1)); this.cTmp.xSet(rx); return (COORDINATE)this.cTmp;
/*     */           } 
/*     */           throw new RuntimeException();
/*     */         } private COORDINATE rotate(int rx, int ry) {
/* 317 */           for (int i = 0; i < rot(); i++) {
/* 318 */             int newX = -ry;
/* 319 */             int newY = rx;
/* 320 */             rx = newX;
/* 321 */             ry = newY;
/*     */           } 
/* 323 */           this.cTmp.set(rx, ry);
/* 324 */           return (COORDINATE)this.cTmp;
/*     */         }
/*     */ 
/*     */         
/*     */         public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, int rx, int ry, boolean isPlacable, boolean areaIsPlacable) {
/* 329 */           COORDINATE cr = getSourceTile(rx, ry);
/* 330 */           rx = cr.x();
/* 331 */           ry = cr.y();
/* 332 */           Furnisher furnisher = SavedPrintsPlacer.this.swap.current().constructor();
/* 333 */           if (SavedPrintsPlacer.this.print.isRoom(rx, ry)) {
/*     */             
/* 335 */             if (SavedPrintsPlacer.this.print.isSoldid(rx, ry))
/* 336 */             { (SPRITES.cons()).BIG.filled.render(r, mask, x, y); }
/*     */             else
/* 338 */             { (SPRITES.cons()).BIG.dashed.render(r, mask, x, y); } 
/* 339 */           } else if (SavedPrintsPlacer.this.w && furnisher.mustBeIndoors() && SavedPrintsPlacer.this.structure() != null) {
/* 340 */             if (SavedPrintsPlacer.this.print.isWall(rx, ry) && UtilWallPlacability.wallShouldBuild.is(tx, ty)) {
/* 341 */               (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/* 342 */             } else if (SavedPrintsPlacer.this.print.isRoof(rx, ry) && UtilWallPlacability.openingShouldBuild.is(tx, ty)) {
/* 343 */               (SPRITES.cons()).BIG.dashed_hollow.render(r, 0, x, y);
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void updateRegardless(GameWindow window) {
/* 350 */           if (SavedPrintsPlacer.this.swap.current().constructor().overlay() != null && (SETT.ROOMS()).placement.placer.showOverlay.is()) {
/* 351 */             SavedPrintsPlacer.this.swap.current().constructor().overlay().add();
/*     */           }
/* 353 */           if (SavedPrintsPlacer.this.swap.current().constructor().isHeavy() && (SETT.ROOMS()).placement.placer.showFoundation.is()) {
/* 354 */             (SETT.OVERLAY()).FOUNDATION.add();
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/* 361 */           Furnisher furnisher = SavedPrintsPlacer.this.swap.current().constructor();
/* 362 */           SavedPrintsPlacer.this.butts.clearSloppy();
/* 363 */           if (furnisher.mustBeIndoors()) {
/* 364 */             SavedPrintsPlacer.this.butts.add((Iterable)SavedPrintsPlacer.this.walls);
/*     */           }
/* 366 */           if (furnisher.overlay() != null)
/* 367 */             SavedPrintsPlacer.this.butts.add(SavedPrintsPlacer.this.bOverlay); 
/* 368 */           if (furnisher.isHeavy())
/* 369 */             SavedPrintsPlacer.this.butts.add(SavedPrintsPlacer.this.bFoundation); 
/* 370 */           return SavedPrintsPlacer.this.swap.wrap((LIST<CLICKABLE>)SavedPrintsPlacer.this.butts);
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence name() {
/* 375 */           Furnisher furnisher = SavedPrintsPlacer.this.swap.current().constructor();
/* 376 */           return (furnisher.blue()).info.name;
/*     */         }
/*     */       };
/*     */     this.swap = swap;
/*     */     for (TBuilding b : (SETT.TERRAIN()).BUILDINGS.all()) {
/*     */       this.sSelect.addDown(0, (RENDEROBJ)(new GButt.ButtPanel(b.iconCombo) {
/*     */             protected void clickA() {
/*     */               (SETT.ROOMS()).placement.placer.structure.set(b);
/*     */               (VIEW.inters()).popup.close();
/*     */             }
/*     */             
/*     */             protected void renAction() {
/*     */               selectedSet((SavedPrintsPlacer.this.structure() == b));
/*     */             }
/*     */           }).hoverTitleSet(b.structure.name));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\copy\SavedPrintsPlacer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */