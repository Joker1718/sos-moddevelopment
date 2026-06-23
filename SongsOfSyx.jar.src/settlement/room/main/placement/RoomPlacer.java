/*     */ package settlement.room.main.placement;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.construction.ConstructionData;
/*     */ import settlement.room.main.construction.ConstructionInit;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemGroup;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.BOOLEAN;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableFixed;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RoomPlacer
/*     */ {
/*     */   final PlacerArea placerArea;
/*     */   final PlacerItemArea placerAreaItem;
/*     */   final PlacerItemSingle placerItemSingle;
/*     */   final Instance instance;
/*  45 */   final UtilStats resources = new UtilStats(this);
/*  46 */   final UtilHistory history = new UtilHistory(this);
/*  47 */   final UtilExtraCost cost = new UtilExtraCost(this);
/*  48 */   final UtilPlacability placability = new UtilPlacability(this);
/*     */   public final PlacerDoor door;
/*     */   public final PlacableMulti placerDoor;
/*  51 */   public final UtilStructure structure = new UtilStructure(this);
/*     */   
/*  53 */   public final BOOLEAN.BOOLEANImp buildOnWalls = new BOOLEAN.BOOLEANImp(true);
/*  54 */   public final BOOLEAN.BOOLEANImp showOverlay = new BOOLEAN.BOOLEANImp(true)
/*     */     {
/*     */       
/*     */       public BOOLEAN.BOOLEAN_MUTABLE set(boolean b)
/*     */       {
/*  59 */         if (b)
/*  60 */           RoomPlacer.this.showFoundation.set(false); 
/*  61 */         return super.set(b);
/*     */       }
/*     */     };
/*  64 */   public final BOOLEAN.BOOLEANImp showFoundation = new BOOLEAN.BOOLEANImp(false)
/*     */     {
/*     */       public BOOLEAN.BOOLEAN_MUTABLE set(boolean b)
/*     */       {
/*  68 */         if (b)
/*  69 */           RoomPlacer.this.showOverlay.set(false); 
/*  70 */         return super.set(b);
/*     */       }
/*     */     };
/*  73 */   public final AutoWalls autoWalls = new AutoWalls();
/*     */   
/*     */   final PLACEMENT p;
/*     */   
/*     */   private RoomState state;
/*  78 */   private int oldDegrade = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean renderExpense;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Coo rCoo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomPlacer(PLACEMENT p, Instance ins) {
/* 114 */     this.rCoo = new Coo(); this.p = p; this.instance = ins; this.placerArea = new PlacerArea(this); this.placerAreaItem = new PlacerItemArea(this); this.placerItemSingle = new PlacerItemSingle(this); this.door = new PlacerDoor(this); this.placerDoor = this.door.placer; (new ON_TOP_RENDERABLE() { public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) { if (RoomPlacer.this.blueprint() == null || RoomPlacer.this.blueprint().constructor() == null)
/*     */             return;  RenderData.RenderIterator it = data.onScreenTiles(); while (it.has()) { Room room = (SETT.ROOMS()).map.get(it.tx(), it.ty()); if (room == RoomPlacer.this.instance)
/*     */               RoomPlacer.this.renderPlaceholder(r, shadowBatch, it);  it.next(); }  } }).add();
/* 117 */   } private void renderPlaceholder(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i) { FurnisherItemTile it = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(i.tile());
/*     */     
/* 119 */     if (blueprint().constructor().usesArea() && blueprint().constructor().mustBeIndoors()) {
/* 120 */       if (ConstructionData.dExpensive.is(i.tile(), 1)) {
/* 121 */         (GCOLOR.MAP()).SOSO.bind();
/* 122 */       } else if (this.renderExpense) {
/* 123 */         double d = this.cost.get(i.tx(), i.ty());
/* 124 */         ColorImp.TMP.interpolate((GCOLOR.MAP()).OK, (GCOLOR.MAP()).BETTER, d);
/* 125 */         ColorImp.TMP.bind();
/*     */       } else {
/* 127 */         (GCOLOR.MAP()).OK.bind();
/*     */       } 
/*     */     } else {
/* 130 */       (GCOLOR.MAP()).OK.bind();
/*     */     } 
/*     */ 
/*     */     
/* 134 */     if (it != null && it.sprite() != null) {
/* 135 */       if (ConstructionData.dConstructed.is(i.tile(), 0) && ConstructionData.dBroken.is(i.tile(), 0)) {
/* 136 */         FurnisherItem item = (FurnisherItem)(SETT.ROOMS()).fData.item.get(i.tile());
/* 137 */         COORDINATE cc = (SETT.ROOMS()).fData.itemX1Y1(i.tx(), i.ty(), this.rCoo);
/* 138 */         int rx = i.tx() - cc.x();
/* 139 */         int ry = i.ty() - cc.y();
/* 140 */         if (it.mustBeReachable) {
/* 141 */           (SPRITES.cons()).BIG.filled.render((SPRITE_RENDERER)r, 0, i.x(), i.y());
/* 142 */           COLOR c = CORE.renderer().colorGet();
/* 143 */           COLOR.unbind();
/* 144 */           int d = (SETT.ROOMS()).fData.spriteData.get(i.tile());
/*     */           
/* 146 */           int ri = it.sprite.rotation(d, item) - 1;
/* 147 */           if (ri < 0) {
/* 148 */             (SPRITES.cons()).ICO.arrows_inward.render((SPRITE_RENDERER)r, i.x(), i.y());
/*     */           } else {
/* 150 */             ((SPRITE)(SPRITES.cons()).ICO.arrows_inwards.get(ri)).render((SPRITE_RENDERER)r, i.x(), i.y());
/* 151 */           }  c.bind();
/*     */         }
/* 153 */         else if (item.get(rx, ry) == it) {
/* 154 */           it.sprite.renderPlaceholder((SPRITE_RENDERER)r, i.x(), i.y(), (SETT.ROOMS()).fData.spriteData.get(i.tile()), i.tx(), i.ty(), rx, ry, item);
/*     */         } else {
/* 156 */           throw new RuntimeException(String.valueOf(item.group.blueprint.blue()) + " " + String.valueOf(item.group.blueprint.blue()) + " " + item.width());
/*     */         }
/*     */       
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 163 */       int m = 0;
/* 164 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 165 */         DIR d = (DIR)DIR.ORTHO.get(di);
/* 166 */         if (this.instance.is(i.tx(), i.ty(), d))
/* 167 */           m |= d.mask(); 
/*     */       } 
/* 169 */       blueprint().constructor().renderEmbryo((SPRITE_RENDERER)r, m, i, ConstructionData.dFloored.is(i.tile(), 1), (AREA)this.instance, true);
/*     */     } 
/* 171 */     COLOR.unbind();
/*     */     
/* 173 */     if (this.autoWalls.is())
/* 174 */       this.door.renderWall((SPRITE_RENDERER)r, i);  }
/*     */ 
/*     */   
/*     */   public class AutoWalls implements BOOLEAN.BOOLEAN_MUTABLE {
/*     */     boolean on;
/*     */     
/*     */     public AutoWalls() {
/* 181 */       this.on = true;
/*     */     }
/*     */     
/*     */     public boolean is() {
/* 185 */       return (this.on && RoomPlacer.this.blueprint() != null && RoomPlacer.this.blueprint().constructor().mustBeIndoors());
/*     */     }
/*     */     
/*     */     public boolean getBool() {
/* 189 */       return this.on;
/*     */     }
/*     */ 
/*     */     
/*     */     public BOOLEAN.BOOLEAN_MUTABLE set(boolean bool) {
/* 194 */       this.on = bool;
/* 195 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   public RoomBlueprintImp blueprint() {
/* 200 */     return this.instance.blue;
/*     */   }
/*     */   
/*     */   public void setUpgrade(int upgrade) {
/* 204 */     this.instance.upgradeSet(upgrade);
/* 205 */     this.resources.updatee();
/*     */   }
/*     */ 
/*     */   
/*     */   public void init(RoomBlueprintImp b, int upgrade) {
/* 210 */     if (b == null && this.instance.blueprint() == null) {
/*     */       return;
/*     */     }
/* 213 */     for (COORDINATE c : this.instance.body()) {
/* 214 */       if (this.instance.is(c)) {
/* 215 */         this.placerArea.clear(c.x(), c.y());
/*     */       }
/*     */     } 
/* 218 */     this.instance.clearRegardless();
/* 219 */     this.instance.upgradeSet(upgrade);
/*     */     
/* 221 */     this.instance.init(b);
/* 222 */     this.resources.clear();
/* 223 */     this.history.clear();
/* 224 */     this.oldDegrade = 0;
/* 225 */     setState(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load() {
/* 230 */     for (COORDINATE c : SETT.TILE_BOUNDS) {
/* 231 */       if (this.instance.is(c)) {
/* 232 */         this.placerArea.clear(c.x(), c.y());
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 237 */     for (int y = this.instance.body().y1(); y < this.instance.body().y2(); y++) {
/* 238 */       for (int x = this.instance.body().x1(); x < this.instance.body().x2(); x++) {
/* 239 */         if (this.instance.is(x, y))
/* 240 */           this.placerArea.clear(x, y); 
/*     */       } 
/*     */     } 
/* 243 */     this.instance.clearRegardless();
/*     */     
/* 245 */     init(null, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp reconstruct(TmpArea area, int upgrade, int degrade, RoomState state, RoomBlueprintImp ret) {
/* 253 */     init(ret, upgrade);
/* 254 */     setState(state);
/* 255 */     this.oldDegrade = degrade;
/* 256 */     TBuilding b = null;
/*     */     
/* 258 */     for (COORDINATE c : area.body()) {
/*     */       
/* 260 */       if (!area.is(c)) {
/*     */         continue;
/*     */       }
/* 263 */       if (SETT.TERRAIN().get(c) instanceof TBuilding.BuildingComponent) {
/* 264 */         b = ((TBuilding.BuildingComponent)SETT.TERRAIN().get(c)).building();
/*     */       }
/*     */       
/* 267 */       blueprint().constructor().doBeforePlanning(c.x(), c.y());
/* 268 */       SETT.LIGHTS().remove(c.x(), c.y());
/*     */     } 
/*     */     
/* 271 */     if (ret.constructor().mustBeIndoors() && b != null) {
/* 272 */       this.structure.set(b);
/*     */     }
/* 274 */     this.instance.set(area, ret);
/* 275 */     this.instance.upgradeSet(upgrade);
/* 276 */     for (COORDINATE c : this.instance.body()) {
/*     */       
/* 278 */       if (!this.instance.is(c)) {
/*     */         continue;
/*     */       }
/* 281 */       if (blueprint().constructor().usesArea() && blueprint().constructor().mustBeIndoors()) {
/* 282 */         this.door.init(c.x(), c.y());
/*     */       }
/*     */     } 
/* 285 */     if (b != null) {
/* 286 */       this.structure.set(b);
/*     */     }
/* 288 */     return ret;
/*     */   }
/*     */   
/*     */   private void setState(RoomState state) {
/* 292 */     this.state = state;
/*     */   }
/*     */   
/*     */   public void renderExpense() {
/* 296 */     this.renderExpense = true;
/*     */   }
/*     */   
/*     */   public PLACABLE area() {
/* 300 */     return (PLACABLE)this.placerArea;
/*     */   }
/*     */   
/*     */   public int size() {
/* 304 */     return this.instance.area();
/*     */   }
/*     */   
/*     */   public PlacableFixed item(int itemGroup) {
/* 308 */     if (!blueprint().constructor().usesArea()) {
/* 309 */       this.placerItemSingle.set(blueprint(), itemGroup, this.instance.upgrade());
/* 310 */       return this.placerItemSingle;
/*     */     } 
/* 312 */     this.placerAreaItem.set(blueprint(), itemGroup, this.instance.upgrade());
/* 313 */     return this.placerAreaItem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PLACABLE itemPlacerCurrent() {
/* 319 */     if (blueprint() == null)
/* 320 */       return null; 
/* 321 */     if (!blueprint().constructor().usesArea()) {
/* 322 */       return (PLACABLE)this.placerItemSingle;
/*     */     }
/* 324 */     return (PLACABLE)this.placerAreaItem;
/*     */   }
/*     */   
/*     */   public COORDINATE create() {
/* 328 */     if (createProblem() != null) {
/* 329 */       throw new RuntimeException(String.valueOf(createProblem()));
/*     */     }
/* 331 */     TBuilding structure = null;
/* 332 */     if (blueprint().constructor().mustBeIndoors()) {
/* 333 */       structure = (TBuilding)this.structure.get();
/*     */     }
/*     */     
/* 336 */     if (blueprint().constructor().mustBeIndoors() && 
/* 337 */       this.autoWalls.is()) {
/* 338 */       this.door.build(structure);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 344 */     ConstructionInit init = new ConstructionInit(this.instance.upgrade(), this.instance.constructor(), structure, this.oldDegrade, this.state);
/* 345 */     Coo.TMP.set(this.instance.mX(), this.instance.mY());
/* 346 */     TmpArea tmp = SETT.ROOMS().tmpArea(this);
/* 347 */     tmp.set((Room)this.instance, this.instance.mX(), this.instance.mY());
/* 348 */     (SETT.ROOMS()).construction.createWithConstructionData(tmp, init);
/* 349 */     this.instance.clearRegardless();
/* 350 */     return (COORDINATE)Coo.TMP;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence createProblem() {
/* 357 */     if (this.instance.blue == null)
/* 358 */       return PLACABLE.E; 
/* 359 */     return this.placability.createProblem((AREA)this.instance);
/*     */   }
/*     */   
/*     */   public CharSequence createWarning() {
/* 363 */     if (this.instance.blue == null)
/* 364 */       return null; 
/* 365 */     return this.instance.blue.constructor().warning((AREA)this.instance);
/*     */   }
/*     */   
/*     */   public FurnisherItemGroup createProblemItem() {
/* 369 */     return this.placability.createProblemGroup();
/*     */   }
/*     */   
/*     */   public boolean createProblemWalls() {
/* 373 */     if (this.autoWalls.is())
/* 374 */       return (this.door.createProblem() != null); 
/* 375 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int resNeeded(int rI) {
/* 380 */     if (this.instance.blue == null)
/* 381 */       return 0; 
/* 382 */     double am = (this.resources.needed(rI) - this.resources.allocated(rI));
/* 383 */     am *= 1.0D + this.cost.total();
/* 384 */     if (am < 0.0D)
/* 385 */       return 0; 
/* 386 */     return (int)Math.ceil(am);
/*     */   }
/*     */   
/*     */   public int resNeededNoCost(int rI) {
/* 390 */     if (this.instance.blue == null)
/* 391 */       return 0; 
/* 392 */     double am = (this.resources.needed(rI) - this.resources.allocated(rI));
/* 393 */     return (int)Math.ceil(am);
/*     */   }
/*     */   
/*     */   public int resNeededOnlyCost(int rI) {
/* 397 */     return resNeeded(rI) - resNeededNoCost(rI);
/*     */   }
/*     */   
/*     */   public int unroofed() {
/* 401 */     if (this.instance.blue == null)
/* 402 */       return 0; 
/* 403 */     return this.instance.unroofed;
/*     */   }
/*     */   
/*     */   public int walls() {
/* 407 */     if (this.instance.blue == null)
/* 408 */       return 0; 
/* 409 */     if (this.autoWalls.is())
/* 410 */       return this.resources.walls; 
/* 411 */     return 0;
/*     */   }
/*     */   
/*     */   public double itemStats(int si) {
/* 415 */     if (this.instance.blue == null)
/* 416 */       return 0.0D; 
/* 417 */     return this.resources.stat(si);
/*     */   }
/*     */   
/*     */   public PlacableFixed createItemPlacer(RoomBlueprintImp b, int group) {
/* 421 */     PlacerItemSingle it = new PlacerItemSingle(this);
/* 422 */     it.set(b, 0, group);
/* 423 */     return it;
/*     */   }
/*     */   
/*     */   public boolean hasHistory() {
/* 427 */     if (this.instance.blue == null)
/* 428 */       return false; 
/* 429 */     if (this.history.hasHistory())
/* 430 */       return true; 
/* 431 */     return false;
/*     */   }
/*     */   
/*     */   public boolean popHistory() {
/* 435 */     if (this.instance.blue == null)
/* 436 */       return false; 
/* 437 */     if (this.history.hasHistory()) {
/* 438 */       this.history.popHistory();
/* 439 */       return true;
/*     */     } 
/* 441 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeAllItems() {
/* 446 */     if (this.instance.blue == null)
/* 447 */       return false; 
/* 448 */     if (this.resources.items > 0) {
/* 449 */       for (COORDINATE c : this.instance.body()) {
/* 450 */         if (this.instance.is(c)) {
/* 451 */           this.placerAreaItem.removeItem(c.x(), c.y());
/*     */         }
/*     */       } 
/* 454 */       return true;
/*     */     } 
/* 456 */     return false;
/*     */   }
/*     */   
/*     */   public boolean removeArea() {
/* 460 */     if (this.instance.blue == null)
/* 461 */       return false; 
/* 462 */     if (this.instance.area() > 0) {
/* 463 */       RoomBlueprintImp b = blueprint();
/* 464 */       this.instance.clear(blueprint());
/* 465 */       this.resources.clear();
/* 466 */       this.history.clear();
/* 467 */       init(b, this.instance.upgrade());
/* 468 */       return true;
/*     */     } 
/* 470 */     return false;
/*     */   }
/*     */   
/*     */   public double isolation() {
/* 474 */     if (this.instance.blue == null)
/* 475 */       return 0.0D; 
/* 476 */     if (!blueprint().constructor().usesArea()) {
/* 477 */       AREA a = this.placerItemSingle.itemAreaCurrent;
/* 478 */       if (a == null)
/* 479 */         return 0.0D; 
/* 480 */       return this.door.isolation((RoomBlueprint)this.instance.blue, a, this.autoWalls.is());
/*     */     } 
/* 482 */     return this.door.isolation((RoomBlueprint)this.instance.blue, (AREA)this.instance, this.autoWalls.is());
/*     */   }
/*     */ 
/*     */   
/*     */   public UtilExtraCost cost() {
/* 487 */     return this.cost;
/*     */   }
/*     */ 
/*     */   
/*     */   void update(double ds) {
/* 492 */     this.renderExpense = false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\placement\RoomPlacer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */