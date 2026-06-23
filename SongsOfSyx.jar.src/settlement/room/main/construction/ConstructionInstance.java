/*      */ package settlement.room.main.construction;
/*      */ 
/*      */ import game.GAME;
/*      */ import game.faction.FACTIONS;
/*      */ import game.faction.FResources;
/*      */ import init.resources.RESOURCE;
/*      */ import java.io.IOException;
/*      */ import settlement.job.ROOM_JOBBER;
/*      */ import settlement.main.SETT;
/*      */ import settlement.maintenance.ROOM_DEGRADER;
/*      */ import settlement.path.AVAILABILITY;
/*      */ import settlement.room.main.MapDataF;
/*      */ import settlement.room.main.ROOMA;
/*      */ import settlement.room.main.Room;
/*      */ import settlement.room.main.RoomBlueprint;
/*      */ import settlement.room.main.RoomBlueprintImp;
/*      */ import settlement.room.main.TmpArea;
/*      */ import settlement.room.main.furnisher.Furnisher;
/*      */ import settlement.room.main.furnisher.FurnisherItem;
/*      */ import settlement.room.main.furnisher.FurnisherItemTile;
/*      */ import settlement.room.main.furnisher.FurnisherStat;
/*      */ import settlement.room.main.placement.UtilExtraCost;
/*      */ import settlement.room.main.util.RoomInit;
/*      */ import settlement.room.main.util.RoomState;
/*      */ import settlement.room.sprite.RoomSprite;
/*      */ import settlement.tilemap.terrain.TBuilding;
/*      */ import snake2d.LOG;
/*      */ import snake2d.Renderer;
/*      */ import snake2d.SPRITE_RENDERER;
/*      */ import snake2d.util.color.COLOR;
/*      */ import snake2d.util.datatypes.AREA;
/*      */ import snake2d.util.datatypes.COORDINATE;
/*      */ import snake2d.util.datatypes.COORDINATEE;
/*      */ import snake2d.util.datatypes.Coo;
/*      */ import snake2d.util.datatypes.DIR;
/*      */ import snake2d.util.datatypes.RECTANGLE;
/*      */ import snake2d.util.datatypes.Rec;
/*      */ import snake2d.util.file.Alloc;
/*      */ import snake2d.util.file.FileGetter;
/*      */ import snake2d.util.file.FilePutter;
/*      */ import snake2d.util.misc.CLAMP;
/*      */ import snake2d.util.rnd.RND;
/*      */ import snake2d.util.sprite.SPRITE;
/*      */ import snake2d.util.sprite.text.Str;
/*      */ import util.GUTIL;
/*      */ import util.colors.GCOLOR;
/*      */ import util.gui.misc.GBox;
/*      */ import util.keymap.MAPPED;
/*      */ import util.rendering.RenderData;
/*      */ import util.rendering.ShadowBatch;
/*      */ import util.text.D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ class ConstructionInstance
/*      */   extends Room.RoomInstanceImp
/*      */   implements ROOM_JOBBER
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*      */   transient Furnisher blueprint;
/*      */   private final Rec tiles;
/*      */   private final int size;
/*      */   boolean active;
/*      */   private final short fx;
/*      */   private final short fy;
/*      */   private int resourcedNeeded;
/*      */   private int resTot;
/*      */   int builtNeeded;
/*      */   int builtTotal;
/*      */   private int structuresNeeded;
/*      */   private int clearingNeeded;
/*      */   private int floorsNeeded;
/*      */   boolean broken;
/*      */   final int structureI;
/*      */   boolean constructing;
/*      */   private final double resMul;
/*      */   private int degrade;
/*      */   RoomState state;
/*      */   private final int upgrade;
/*      */   
/*      */   ConstructionInstance(RoomBlueprint daddy, TmpArea a, ConstructionInit init) {
/*   96 */     super(SETT.ROOMS(), daddy, false); int j, k; this.active = true; this.constructing = false;
/*   97 */     this.resMul = 1.0D + UtilExtraCost.psupport((ROOMA)a, init.b.blue()) + UtilExtraCost.pfoundation((ROOMA)a, init.b.blue());
/*      */     
/*   99 */     this.tiles = new Rec(a.body());
/*  100 */     this.size = a.area();
/*  101 */     a.replaceAndClear((Room)this);
/*  102 */     this.blueprint = init.b;
/*      */     
/*  104 */     int up = 0;
/*  105 */     if (this.blueprint == (SETT.ROOMS()).HOME.constructor()) {
/*  106 */       up = 0;
/*      */     } else {
/*  108 */       up = Math.min(init.upgrade, this.blueprint.blue().upgrades().max());
/*      */     } 
/*  110 */     while (up > 0 && this.blueprint.blue().upgrades().requires(up) != null && !this.blueprint.blue().upgrades().requires(up).passes(FACTIONS.player())) {
/*  111 */       up--;
/*      */     }
/*      */     
/*  114 */     this.upgrade = up;
/*      */     
/*  116 */     this.state = init.state;
/*  117 */     this.degrade = init.degrade;
/*  118 */     int fx = -1, fy = -1;
/*  119 */     boolean b = false;
/*  120 */     boolean m = false;
/*  121 */     for (COORDINATE c : this.tiles) {
/*  122 */       if (is(c)) {
/*  123 */         (SETT.JOBS()).clearer.set(c);
/*  124 */         (da()).candle.set(c, false);
/*  125 */         j = b | ((ConstructionData.dBroken.get(c) == 1) ? 1 : 0);
/*  126 */         k = m | ((SETT.MAINTENANCE()).disabled.is(c) ? 0 : 1);
/*  127 */         if (fx == -1) {
/*  128 */           fx = c.x();
/*  129 */           fy = c.y();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  134 */     this.broken = j;
/*      */ 
/*      */ 
/*      */     
/*  138 */     if (fx == -1) {
/*  139 */       throw new RuntimeException(String.valueOf(daddy) + " " + String.valueOf(daddy));
/*      */     }
/*      */     
/*  142 */     this.fx = (short)fx;
/*  143 */     this.fy = (short)fy;
/*      */     
/*  145 */     this.active = ((!this.broken || k != 0) && !(SETT.JOBS()).planMode.is());
/*  146 */     TBuilding structure = init.structure;
/*  147 */     if (!this.blueprint.mustBeIndoors())
/*  148 */       structure = null; 
/*  149 */     this.structureI = (structure == null) ? -1 : structure.structure.index();
/*      */     
/*  151 */     GUTIL.coos().set(0);
/*      */     
/*  153 */     for (COORDINATE c : this.tiles) {
/*  154 */       if (is(c)) {
/*  155 */         FurnisherItemTile t = (FurnisherItemTile)(da()).tile.get(c);
/*  156 */         if (t != null && t.canGoCandle) {
/*  157 */           GUTIL.coos().get().set(c);
/*  158 */           GUTIL.coos().inc();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  163 */     int cm = GUTIL.coos().getI();
/*  164 */     GUTIL.coos().shuffle(cm);
/*  165 */     for (int i = 0; i < cm; i++) {
/*  166 */       COORDINATEE cOORDINATEE = GUTIL.coos().set(i);
/*  167 */       candle(cOORDINATEE.x(), cOORDINATEE.y());
/*      */     } 
/*      */     
/*  170 */     init();
/*      */     
/*  172 */     if (is(fx, fy)) {
/*  173 */       (SETT.ROOMS()).map.init((AREA)this);
/*  174 */       if (this.broken)
/*  175 */         (SETT.ROOMS()).stats.broken().add(mX(), mY()); 
/*      */     } else {
/*  177 */       (SETT.ROOMS()).stats.finished().remove(fx, fy);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void candle(int tx, int ty) {
/*  186 */     int radius = 4;
/*      */     
/*  188 */     int i = 0;
/*  189 */     while (GUTIL.circle().radius(i) <= radius) {
/*      */       
/*  191 */       COORDINATE c = GUTIL.circle().get(i);
/*  192 */       i++;
/*  193 */       int x = c.x() + tx;
/*  194 */       int y = c.y() + ty;
/*  195 */       if (!is(x, y))
/*      */         continue; 
/*  197 */       if ((da()).candle.is(x, y)) {
/*      */         return;
/*      */       }
/*      */     } 
/*      */     
/*  202 */     (da()).candle.set(tx, ty, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void init() {
/*  208 */     this.builtNeeded = 0;
/*  209 */     this.builtTotal = 0;
/*  210 */     this.resourcedNeeded = 0;
/*  211 */     this.floorsNeeded = 0;
/*  212 */     this.structuresNeeded = 0;
/*      */     
/*  214 */     double[] resNeededD = new double[this.blueprint.resources()];
/*      */     
/*  216 */     int availableResourceTiles = 0;
/*      */ 
/*      */ 
/*      */     
/*  220 */     int floored = 0;
/*      */     
/*  222 */     for (COORDINATE c : body()) {
/*  223 */       if (is(c)) {
/*  224 */         jobClear(c.x(), c.y());
/*  225 */         (SETT.ROOMS()).data.set((ROOMA)this, c, ConstructionData.dData.get(c));
/*  226 */         if (ConstructionData.dFloored.is(c, 1)) {
/*  227 */           this.blueprint.putFloor(c.x(), c.y(), this.upgrade, (AREA)this);
/*  228 */           floored++;
/*  229 */           constructor().putFloor(c.x(), c.y(), this.upgrade, (AREA)this);
/*      */         } 
/*      */         
/*  232 */         FurnisherItem it = (FurnisherItem)(da()).item.get(c);
/*      */         
/*  234 */         if (it != null && (da()).isMaster.is(c))
/*      */         {
/*  236 */           if (ConstructionData.dConstructed.is(c, 0) || ConstructionData.dBroken.is(c, 1)) {
/*      */             
/*  238 */             for (int y = 0; y < it.height(); y++) {
/*  239 */               for (int x = 0; x < it.width(); x++) {
/*  240 */                 if (it.get(x, y) != null) {
/*      */                   
/*  242 */                   if (ConstructionData.dConstructed.is(c, 0)) {
/*  243 */                     ConstructionData.dConstructed.set((ROOMA)this, x + c.x() - it.firstX(), y + c.y() - it.firstY(), 0);
/*      */                   } else {
/*  245 */                     ConstructionData.dBroken.set((ROOMA)this, c, 1);
/*  246 */                   }  this.builtTotal++;
/*      */                 } 
/*      */               } 
/*  249 */             }  for (int k = 0; k < this.blueprint.resources(); k++) {
/*  250 */               resNeededD[k] = resNeededD[k] + it.cost2(k, this.upgrade);
/*      */             }
/*      */           } else {
/*  253 */             for (int k = 0; k < this.blueprint.resources(); k++) {
/*  254 */               resNeededD[k] = resNeededD[k] + it.cost2(k, this.upgrade) * getDegrade();
/*      */             }
/*      */           } 
/*      */         }
/*      */ 
/*      */         
/*  260 */         if (ConstructionData.dFloored.is(c, 0) || ((da()).item.is(c) && (ConstructionData.dConstructed.is(c, 0) || ConstructionData.dBroken.is(c, 1))))
/*  261 */           availableResourceTiles++; 
/*      */       } 
/*      */     } 
/*      */     int i;
/*  265 */     for (i = 0; i < this.blueprint.resources(); i++) {
/*  266 */       resNeededD[i] = resNeededD[i] + Math.ceil(this.blueprint.areaCost(i, this.upgrade) * (area() - floored * (1.0D - getDegrade())));
/*  267 */       resNeededD[i] = (int)Math.ceil(resNeededD[i] * this.resMul);
/*  268 */       this.resourcedNeeded = (int)(this.resourcedNeeded + resNeededD[i]);
/*      */     } 
/*      */     
/*  271 */     this.floorsNeeded = area() - floored;
/*  272 */     this.builtNeeded = this.builtTotal;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  278 */     if (this.resourcedNeeded == 0) {
/*  279 */       setClear();
/*      */       
/*      */       return;
/*      */     } 
/*  283 */     int[] resNeeded = Alloc.ii(resNeededD.length);
/*  284 */     for (i = 0; i < resNeeded.length; i++) {
/*  285 */       resNeeded[i] = (int)Math.ceil(resNeededD[i]);
/*      */     }
/*      */     
/*  288 */     int[] pileAmount = Alloc.ii(this.blueprint.resources());
/*  289 */     double[] pileDistance = new double[this.blueprint.resources()];
/*  290 */     double[] pileD = new double[this.blueprint.resources()];
/*  291 */     boolean[] placedD = new boolean[this.blueprint.resources()]; int j;
/*  292 */     for (j = 0; j < this.blueprint.resources(); j++) {
/*  293 */       int max = 4;
/*  294 */       int am = resNeeded[j];
/*  295 */       int piles = am / max;
/*  296 */       piles += (am % max > 0) ? 1 : 0;
/*      */       
/*  298 */       if (piles > availableResourceTiles) {
/*  299 */         max = (ConstructionData.dResourceNeeded[0]).max;
/*  300 */         piles = am / max;
/*  301 */         piles += (am % max > 0) ? 1 : 0;
/*      */       } 
/*      */ 
/*      */       
/*  305 */       pileAmount[j] = max;
/*  306 */       if (piles != 0) {
/*      */         
/*  308 */         pileDistance[j] = (availableResourceTiles - 1) / piles;
/*  309 */         if (pileDistance[j] < 1.0D)
/*  310 */           pileDistance[j] = 1.0D; 
/*  311 */         pileD[j] = (availableResourceTiles - pileDistance[j] * piles) / 2.0D;
/*      */       } 
/*  313 */     }  for (COORDINATE c : body()) {
/*  314 */       if (is(c) && (
/*  315 */         ConstructionData.dFloored.is(c, 0) || ((da()).item.is(c) && (ConstructionData.dConstructed.is(c, 0) || ConstructionData.dBroken.is(c, 1))))) {
/*  316 */         for (int k = 0; k < this.blueprint.resources(); k++) {
/*  317 */           if (resNeeded[k] > 0) {
/*      */ 
/*      */             
/*  320 */             if (!placedD[k] && RND.oneIn(pileD[k])) {
/*  321 */               int am = pileAmount[k];
/*  322 */               am = CLAMP.i(am, 0, resNeeded[k]);
/*  323 */               resNeeded[k] = resNeeded[k] - am;
/*  324 */               ConstructionData.dResourceNeeded[k].set((ROOMA)this, c, am);
/*  325 */               placedD[k] = true;
/*      */             } 
/*  327 */             if (pileD[k] <= 0.0D) {
/*  328 */               pileD[k] = pileD[k] + pileDistance[k];
/*  329 */               placedD[k] = false;
/*      */             } 
/*      */           } 
/*      */           
/*  333 */           pileD[k] = pileD[k] - 1.0D;
/*      */         } 
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  339 */     for (COORDINATE c : body()) {
/*  340 */       if (is(c) && 
/*  341 */         !(da()).item.is(c)) {
/*  342 */         for (int k = 0; k < this.blueprint.resources(); k++) {
/*  343 */           if (resNeeded[k] > 0) {
/*      */ 
/*      */             
/*  346 */             if (!placedD[k] && RND.oneIn(pileD[k])) {
/*  347 */               int am = pileAmount[k];
/*  348 */               am = CLAMP.i(am, 0, resNeeded[k]);
/*  349 */               resNeeded[k] = resNeeded[k] - am;
/*  350 */               ConstructionData.dResourceNeeded[k].set((ROOMA)this, c, am);
/*  351 */               placedD[k] = true;
/*      */             } 
/*  353 */             if (pileD[k] <= 0.0D) {
/*  354 */               pileD[k] = pileD[k] + pileDistance[k];
/*  355 */               placedD[k] = false;
/*      */             } 
/*      */           } 
/*      */           
/*  359 */           pileD[k] = pileD[k] - 1.0D;
/*      */         } 
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  367 */     this.resTot = this.resourcedNeeded;
/*  368 */     for (j = 0; j < this.blueprint.resources(); j++) {
/*  369 */       if (resNeeded[j] > 0) {
/*  370 */         GAME.Notify(String.valueOf((this.blueprint.resource(j)).name) + " " + String.valueOf((this.blueprint.resource(j)).name));
/*  371 */         this.resourcedNeeded -= resNeeded[j];
/*      */       } 
/*      */     } 
/*      */     
/*  375 */     setClear();
/*      */   }
/*      */ 
/*      */   
/*      */   private void setClear() {
/*  380 */     for (COORDINATE c : body()) {
/*  381 */       if (needsClear(c)) {
/*  382 */         this.clearingNeeded++;
/*  383 */         jobSet(c.x(), c.y(), this.active, null);
/*      */       } 
/*      */     } 
/*  386 */     if (this.clearingNeeded == 0)
/*  387 */       setBuildRoof(); 
/*      */   }
/*      */   
/*      */   boolean needsClear(COORDINATE c) {
/*  391 */     if (is(c) && (ConstructionData.dFloored.is(c, 0) || ConstructionData.dConstructed.is(c, 0) || ConstructionData.dBroken.is(c, 1))) {
/*  392 */       if (this.blueprint.removeFertility() && (SETT.GRASS()).current.get(c) > 0.0D) {
/*  393 */         return true;
/*      */       }
/*  395 */       return needsTerrainToBeCleared(c.x(), c.y());
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  402 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void setBuildRoof() {
/*  407 */     if (this.structureI == -1) {
/*  408 */       setFetch();
/*      */       
/*      */       return;
/*      */     } 
/*  412 */     TBuilding st = (TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(this.structureI);
/*      */     
/*  414 */     for (COORDINATE c : body()) {
/*  415 */       if (!is(c) || 
/*  416 */         (SETT.TERRAIN()).CAVE.is(c))
/*      */         continue; 
/*  418 */       if (!st.roof.is(c) && (getAvailability(c.x() + c.y() * SETT.TWIDTH)).player > 0.0D) {
/*  419 */         jobSet(c.x(), c.y(), this.active, st.structure.resource);
/*  420 */         this.structuresNeeded++;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  425 */     if (this.structuresNeeded == 0) {
/*  426 */       setFetch();
/*      */       return;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void setFetch() {
/*  434 */     if (this.resourcedNeeded == 0) {
/*  435 */       setBuildFloor();
/*      */       
/*      */       return;
/*      */     } 
/*  439 */     for (COORDINATE c : body()) {
/*  440 */       if (is(c)) {
/*  441 */         for (int i = 0; i < this.blueprint.resources(); i++) {
/*  442 */           if (ConstructionData.dResourceNeeded[i].get(c) > 0) {
/*  443 */             jobSet(c.x(), c.y(), this.active, this.blueprint.resource(i));
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void setBuildFloor() {
/*  452 */     if (this.floorsNeeded == 0) {
/*  453 */       setFurnish();
/*      */       
/*      */       return;
/*      */     } 
/*  457 */     for (COORDINATE c : body()) {
/*  458 */       if (is(c) && 
/*  459 */         ConstructionData.dFloored.is(c, 0)) {
/*  460 */         jobSet(c.x(), c.y(), this.active, null);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void setFurnish() {
/*  467 */     if (this.builtNeeded == 0) {
/*  468 */       finish();
/*      */       
/*      */       return;
/*      */     } 
/*  472 */     for (COORDINATE c : body()) {
/*  473 */       if (is(c)) {
/*  474 */         FurnisherItem it = (FurnisherItem)(da()).item.get(c);
/*  475 */         if (it != null && (da()).isMaster.is(c) && (ConstructionData.dConstructed.is(c, 0) || ConstructionData.dBroken.is(c, 1))) {
/*  476 */           int x1 = c.x() - it.firstX();
/*  477 */           int y1 = c.y() - it.firstY();
/*  478 */           for (int y = 0; y < it.height(); y++) {
/*  479 */             for (int x = 0; x < it.width(); x++) {
/*  480 */               if (it.is(x, y)) {
/*      */                 
/*  482 */                 if (!is(x1 + x, y1 + y)) {
/*  483 */                   LOG.ln(String.valueOf((this.blueprint.blue()).info.name) + " " + String.valueOf((this.blueprint.blue()).info.name) + " " + String.valueOf(it.group.name) + " " + it.rotation + " " + it.width());
/*      */                 }
/*  485 */                 jobSet(x1 + x, y1 + y, this.active, null);
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   void finish() {
/*  495 */     RoomInit init = new RoomInit(this.blueprint.blue(), 0);
/*      */     
/*  497 */     this.constructing = true;
/*      */     
/*  499 */     double[] resources = new double[this.blueprint.resources()];
/*      */     
/*  501 */     for (COORDINATE c : body()) {
/*  502 */       if (!is(c))
/*      */         continue; 
/*  504 */       this.blueprint.putFloor(c.x(), c.y(), this.upgrade, (AREA)this);
/*  505 */       (SETT.ROOMS()).data.set((ROOMA)this, c, 0);
/*  506 */       if ((da()).candle.is(c)) {
/*  507 */         SETT.LIGHTS().candle(c.x(), c.y(), 0);
/*      */       }
/*  509 */       FurnisherItem it = (FurnisherItem)(da()).item.get(c);
/*  510 */       if (it != null && (da()).isMaster.is(c)) {
/*  511 */         for (FurnisherStat s : this.blueprint.stats())
/*  512 */           init.stats[s.index()] = init.stats[s.index()] + it.stat(s); 
/*  513 */         for (int j = 0; j < this.blueprint.resources(); j++) {
/*  514 */           resources[j] = resources[j] + it.costFlat(j);
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  520 */     for (FurnisherStat s : this.blueprint.stats()) {
/*  521 */       init.stats[s.index()] = s.get((AREA)this, init.stats);
/*      */     }
/*  523 */     for (int i = 0; i < this.blueprint.resources(); i++) {
/*  524 */       init.res[i] = Math.ceil((resources[i] + this.blueprint.areaCostFlat(i) * area()) * this.resMul);
/*      */     }
/*      */     
/*  527 */     init.resMul = this.resMul;
/*  528 */     ((ConstructionBlueprint)blueprint()).remove(this);
/*  529 */     TmpArea a = delete(mX(), mY(), this);
/*  530 */     CONSTRUCTION.ppCreate(a, init, this.blueprint, this.upgrade, this.state);
/*  531 */     if (this.broken && this.state != null) {
/*  532 */       Room r = (SETT.ROOMS()).map.get(mX(), mY());
/*  533 */       if (r != null && r.blueprint() == this.blueprint.blue()) {
/*  534 */         this.state.apply(r, this.builtTotal, this.builtNeeded);
/*      */       }
/*      */     } 
/*      */     
/*  538 */     if (this.blueprint.blue() instanceof settlement.room.main.RoomBlueprintIns) {
/*  539 */       (GAME.count()).ROOMS_BUILT.inc(1);
/*  540 */       (SETT.ROOMS()).stats.finished().add(this.fx, this.fy);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void jobFinsih(int tx, int ty, RESOURCE r, int ram) {
/*  549 */     if (this.clearingNeeded > 0) {
/*  550 */       this.clearingNeeded--;
/*  551 */       if (this.clearingNeeded == 0) {
/*  552 */         setBuildRoof();
/*      */       }
/*      */       return;
/*      */     } 
/*  556 */     if (this.structuresNeeded > 0) {
/*      */       
/*  558 */       int am = ConstructionData.dWorkAmount.get(tx, ty);
/*  559 */       TBuilding t = (TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(this.structureI);
/*  560 */       if (am == t.structure.resAmount) {
/*  561 */         t.roof.placeFixed(tx, ty);
/*  562 */         if (t.structure.resource != null)
/*  563 */           GAME.player().res().inc(t.structure.resource, FResources.RTYPE.CONSTRUCTION, -t.structure.resAmount); 
/*  564 */         ConstructionData.dWorkAmount.set((ROOMA)this, tx, ty, 0);
/*  565 */         this.structuresNeeded--;
/*  566 */         if (this.structuresNeeded == 0)
/*  567 */           setFetch(); 
/*      */       } else {
/*  569 */         am++;
/*  570 */         ConstructionData.dWorkAmount.set((ROOMA)this, tx, ty, am);
/*  571 */         if (am == t.structure.resAmount) {
/*  572 */           jobSet(tx, ty, this.active, null);
/*      */         } else {
/*  574 */           jobSet(tx, ty, this.active, t.structure.resource);
/*      */         } 
/*      */       } 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  581 */     if (this.resourcedNeeded > 0) {
/*  582 */       if (r == null) {
/*  583 */         throw new RuntimeException();
/*      */       }
/*  585 */       GAME.player().res().inc(r, FResources.RTYPE.CONSTRUCTION, -ram);
/*  586 */       int needed = 0;
/*  587 */       for (int i = 0; i < this.blueprint.resources(); i++) {
/*  588 */         needed += ConstructionData.dResourceNeeded[i].get(tx, ty);
/*      */       }
/*      */       
/*  591 */       ram = CLAMP.i(ram, 0, needed - ConstructionData.dResAllocated.get(tx, ty));
/*      */       
/*  593 */       ConstructionData.dResAllocated.inc((ROOMA)this, tx, ty, ram);
/*      */       
/*  595 */       this.resourcedNeeded -= ram;
/*  596 */       if (this.resourcedNeeded == 0) {
/*  597 */         setBuildFloor();
/*      */         
/*      */         return;
/*      */       } 
/*  601 */       if (ConstructionData.dResAllocated.get(tx, ty) < needed) {
/*  602 */         int am = ConstructionData.dResAllocated.get(tx, ty);
/*  603 */         for (int j = 0; j < this.blueprint.resources(); j++) {
/*  604 */           am -= ConstructionData.dResourceNeeded[j].get(tx, ty);
/*  605 */           if (am < 0) {
/*  606 */             jobSet(tx, ty, this.active, this.blueprint.resource(j));
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/*      */       return;
/*      */     } 
/*  615 */     if (r != null) {
/*  616 */       throw new RuntimeException();
/*      */     }
/*  618 */     if (this.floorsNeeded > 0) {
/*  619 */       this.blueprint.putFloor(tx, ty, this.upgrade, (AREA)this);
/*  620 */       ConstructionData.dFloored.set((ROOMA)this, tx, ty, 1);
/*  621 */       this.floorsNeeded--;
/*  622 */       if (this.floorsNeeded == 0) {
/*  623 */         setFurnish();
/*      */       }
/*      */       return;
/*      */     } 
/*  627 */     this.builtNeeded--;
/*  628 */     ConstructionData.dConstructed.set((ROOMA)this, tx, ty, 1);
/*  629 */     ConstructionData.dBroken.set((ROOMA)this, tx, ty, 0);
/*  630 */     (SETT.PATH()).availability.updateAvailability(tx, ty);
/*      */ 
/*      */ 
/*      */     
/*  634 */     if (this.builtNeeded == 0) {
/*  635 */       finish();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void saveExtra(FilePutter file) {
/*  642 */     (SETT.ROOMS()).collection.saver().save((MAPPED)this.blueprint.blue(), file);
/*  643 */     super.saveExtra(file);
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean loadExtra(FileGetter file) throws IOException {
/*  648 */     RoomBlueprint p = (RoomBlueprint)(SETT.ROOMS()).collection.loader().load(file);
/*  649 */     if (p == null)
/*  650 */       return false; 
/*  651 */     RoomBlueprintImp b = (RoomBlueprintImp)p;
/*  652 */     this.blueprint = b.constructor();
/*  653 */     return super.loadExtra(file);
/*      */   }
/*      */   
/*  656 */   private static final Coo tmp = new Coo();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  662 */     FurnisherItemTile tile = (FurnisherItemTile)(da()).tile.get(it.tile());
/*      */     
/*  664 */     if (tile == null || tile.sprite() == null) {
/*  665 */       int m = 0;
/*  666 */       for (DIR d : DIR.ORTHO) {
/*  667 */         if (is(it.tx(), it.ty(), d))
/*  668 */           m |= d.mask(); 
/*      */       } 
/*  670 */       if (this.active) {
/*  671 */         (GCOLOR.MAP()).JOB_ACTIVE.bind();
/*      */       } else {
/*  673 */         (GCOLOR.MAP()).JOB_DORMANT.bind();
/*      */       } 
/*  675 */       this.blueprint.renderEmbryo((SPRITE_RENDERER)r, m, it, ConstructionData.dFloored.is(it.tile(), 1), (AREA)this, this.active);
/*      */ 
/*      */     
/*      */     }
/*  679 */     else if (ConstructionData.dConstructed.is(it.tile(), 0)) {
/*  680 */       if (this.active) {
/*  681 */         (GCOLOR.MAP()).JOB_ACTIVE.bind();
/*      */       } else {
/*  683 */         (GCOLOR.MAP()).JOB_DORMANT.bind();
/*      */       } 
/*  685 */       FurnisherItem itt = (FurnisherItem)(da()).item.get(it.tile());
/*  686 */       da().itemX1Y1(it.tx(), it.ty(), tmp);
/*  687 */       int rx = it.tx() - tmp.x();
/*  688 */       int ry = it.ty() - tmp.y();
/*  689 */       if (itt.get(rx, ry) == null) {
/*  690 */         throw new RuntimeException(String.valueOf(itt.group.blueprint.blue()) + " " + String.valueOf(itt.group.blueprint.blue()) + " " + rx + " " + ry + " " + String.valueOf(tmp) + " " + it.tx());
/*      */       }
/*  692 */       tile.sprite().renderPlaceholder((SPRITE_RENDERER)r, it.x(), it.y(), (da()).spriteData.get(it.tile()), it.tx(), it.ty(), rx, ry, itt);
/*      */     }
/*  694 */     else if (ConstructionData.dBroken.is(it.tile(), 1)) {
/*  695 */       tile.sprite().renderBroken((SPRITE_RENDERER)r, shadowBatch, it.x(), it.y(), it, (FurnisherItem)(da()).item.get(it.tile()));
/*      */     } else {
/*  697 */       return tile.sprite().render((SPRITE_RENDERER)r, shadowBatch, (da()).spriteData.get(it.tile()), it, deg(), false);
/*      */     } 
/*      */     
/*  700 */     COLOR.unbind();
/*  701 */     if (this.structuresNeeded > 0) {
/*  702 */       int am = ConstructionData.dWorkAmount.get(it.tile());
/*  703 */       if (am > 0)
/*  704 */         ((TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(this.structureI)).structure.resource.renderLaying((SPRITE_RENDERER)r, it.x(), it.y(), it.ran(), am); 
/*  705 */     } else if (ConstructionData.dResourceNeededAll.get(it.tile()) != 0) {
/*  706 */       int am = ConstructionData.dResAllocated.get(it.tile());
/*  707 */       int tot = area() + this.builtTotal;
/*  708 */       double d = (tot - this.floorsNeeded + this.builtNeeded);
/*  709 */       d /= tot;
/*      */       
/*  711 */       if ((it.ran() & 0xFFFF) >= 65535.0D * d)
/*      */       {
/*  713 */         for (int i = 0; i < this.blueprint.resources() && am > 0; i++) {
/*  714 */           int a = CLAMP.i(ConstructionData.dResourceNeeded[i].get(it.tile()), 0, am);
/*  715 */           if (a > 0) {
/*  716 */             this.blueprint.resource(i).renderLaying((SPRITE_RENDERER)r, it.x(), it.y(), it.ran(), a);
/*      */           }
/*  718 */           am -= a;
/*      */         } 
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  725 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean renderAbove(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  731 */     if (ConstructionData.dConstructed.is(it.tile(), 1) && ConstructionData.dBroken.is(it.tile(), 0)) {
/*  732 */       RoomSprite sp = (RoomSprite)(da()).sprite.get(it.tile());
/*  733 */       if (sp != null)
/*  734 */         sp.renderAbove((SPRITE_RENDERER)r, shadowBatch, (da()).spriteData.get(it.tile()), it, deg()); 
/*      */     } 
/*  736 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  741 */     if (ConstructionData.dConstructed.is(it.tile(), 1) && ConstructionData.dBroken.is(it.tile(), 0)) {
/*  742 */       RoomSprite sp = (RoomSprite)(da()).sprite.get(it.tile());
/*  743 */       if (sp != null)
/*  744 */         sp.renderBelow((SPRITE_RENDERER)r, shadowBatch, (da()).spriteData.get(it.tile()), it, deg()); 
/*      */     } 
/*  746 */     this.blueprint.renderTileBelow((SPRITE_RENDERER)r, shadowBatch, it, ConstructionData.dFloored.is(it.tile(), 1));
/*  747 */     return false;
/*      */   }
/*      */   
/*      */   private double deg() {
/*  751 */     return getDegrade() * CLAMP.d(1.0D - (this.resTot - this.resourcedNeeded) / this.resTot, 0.0D, 1.0D);
/*      */   }
/*      */ 
/*      */   
/*      */   protected AVAILABILITY getAvailability(int tile) {
/*  756 */     FurnisherItemTile t = (FurnisherItemTile)(da()).tile.get(tile);
/*      */     
/*  758 */     if (t != null) {
/*  759 */       if (ConstructionData.dConstructed.is(tile, 1) && ConstructionData.dBroken.is(tile, 0))
/*  760 */         return t.availability; 
/*  761 */       if (t.isBlocker()) {
/*  762 */         return AVAILABILITY.PENALTY4;
/*      */       }
/*      */     } 
/*  765 */     return AVAILABILITY.ROOM;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*  770 */   private static Str name = new Str(32);
/*  771 */   private static CharSequence ¤¤Construction = "¤Construction";
/*  772 */   private static CharSequence ¤¤Broken = "¤Broken"; private static ConstructionInstance degI;
/*      */   
/*      */   static {
/*  775 */     D.ts(ConstructionInstance.class);
/*      */   }
/*      */ 
/*      */   
/*      */   public CharSequence name(int tx, int ty) {
/*  780 */     name.clear();
/*  781 */     if (this.broken) {
/*  782 */       name.add(¤¤Broken).add(' ').add((this.blueprint.blue()).info.name);
/*      */     } else {
/*  784 */       name.add((this.blueprint.blue()).info.name).add(' ').add(¤¤Construction);
/*  785 */     }  return (CharSequence)name;
/*      */   }
/*      */ 
/*      */   
/*      */   public void destroyTile(int tx, int ty) {
/*  790 */     FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/*  791 */     COORDINATE ff = (SETT.ROOMS()).fData.itemX1Y1(tx, ty, Coo.TMP);
/*  792 */     int x1 = ff.x();
/*  793 */     int y1 = ff.y();
/*  794 */     for (int y = 0; y < it.height(); y++) {
/*  795 */       for (int x = 0; x < it.width(); x++) {
/*  796 */         if (it.is(x, y)) {
/*  797 */           ConstructionData.dBroken.set((ROOMA)this, x1 + x, y1 + y, 1);
/*  798 */           (SETT.PATH()).availability.updateAvailability(x1 + x, y1 + y);
/*      */         } 
/*      */       } 
/*      */     } 
/*  802 */     if (!this.broken)
/*  803 */       (SETT.ROOMS()).stats.broken().add(mX(), mY()); 
/*  804 */     this.broken = true;
/*  805 */     this.active = false;
/*  806 */     this.broken = true;
/*  807 */     (SETT.PATH()).availability.updateAvailability(tx, ty);
/*  808 */     init();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean destroyTileCan(int tx, int ty) {
/*  813 */     return ((getAvailability(tx + ty * SETT.TWIDTH)).player < 0.0D && (SETT.ROOMS()).fData.item.get(tx, ty) != null);
/*      */   }
/*      */ 
/*      */   
/*      */   public int area() {
/*  818 */     return this.size;
/*      */   }
/*      */ 
/*      */   
/*      */   public RECTANGLE body() {
/*  823 */     return (RECTANGLE)this.tiles;
/*      */   }
/*      */ 
/*      */   
/*      */   public int mX() {
/*  828 */     return this.fx;
/*      */   }
/*      */ 
/*      */   
/*      */   public int mY() {
/*  833 */     return this.fy;
/*      */   }
/*      */   
/*      */   public TBuilding structure() {
/*  837 */     if (this.structureI >= 0)
/*  838 */       return (TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(this.structureI); 
/*  839 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void releaseResources(boolean all) {
/*  846 */     if (this.structuresNeeded > 0 || this.resourcedNeeded > 0) {
/*  847 */       for (COORDINATE c : body()) {
/*  848 */         if (!is(c))
/*      */           continue; 
/*  850 */         if (this.structuresNeeded > 0) {
/*  851 */           int am = ConstructionData.dWorkAmount.get(c);
/*  852 */           if (am > 0) {
/*  853 */             GAME.player().res().inc(((TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(this.structureI)).structure.resource, FResources.RTYPE.CONSTRUCTION, am);
/*  854 */             (SETT.THINGS()).resources.create(c, ((TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(this.structureI)).structure.resource, am);
/*      */           } 
/*  856 */           ConstructionData.dWorkAmount.set((ROOMA)this, c, 0); continue;
/*  857 */         }  if (this.resourcedNeeded > 0) {
/*  858 */           int am = ConstructionData.dResAllocated.get(c);
/*  859 */           if (am == 0)
/*      */             continue; 
/*  861 */           for (int j = 0; j < this.blueprint.resources() && am > 0; j++) {
/*  862 */             int a = CLAMP.i(am, 0, ConstructionData.dResourceNeeded[j].get(c));
/*  863 */             if (a > 0) {
/*  864 */               (SETT.THINGS()).resources.create(c, this.blueprint.resource(j), a);
/*  865 */               GAME.player().res().inc(this.blueprint.resource(j), FResources.RTYPE.CONSTRUCTION, a);
/*      */             } 
/*  867 */             am -= a;
/*      */           } 
/*      */           
/*  870 */           ConstructionData.dResourceNeededAll.set((ROOMA)this, c, 0);
/*  871 */           ConstructionData.dResAllocated.set((ROOMA)this, c, 0);
/*      */         }
/*      */       
/*      */       } 
/*      */     } else {
/*      */       
/*  877 */       int j = 0;
/*  878 */       for (COORDINATE c : body()) {
/*  879 */         if (!is(c))
/*      */           continue; 
/*  881 */         releaseItem(c.x(), c.y(), all);
/*  882 */         if (ConstructionData.dFloored.get(c) == 0) {
/*  883 */           j++;
/*      */         }
/*      */       } 
/*      */       
/*  887 */       for (int k = 0; k < this.blueprint.resources(); k++) {
/*  888 */         int am = (int)Math.ceil(this.blueprint.areaCost(k, this.upgrade) * j);
/*  889 */         if (am > 0) {
/*  890 */           (SETT.THINGS()).resources.create(mX(), mY(), this.blueprint.resource(k), am);
/*      */         }
/*      */       } 
/*      */     } 
/*  894 */     if (!all) {
/*      */       return;
/*      */     }
/*  897 */     int ff = 0;
/*      */     
/*  899 */     for (COORDINATE c : body()) {
/*  900 */       if (!is(c)) {
/*      */         continue;
/*      */       }
/*  903 */       if (ConstructionData.dFloored.get(c) == 1) {
/*  904 */         ff++;
/*      */       }
/*      */     } 
/*      */     
/*  908 */     for (int i = 0; i < this.blueprint.resources(); i++) {
/*  909 */       int am = (int)(this.blueprint.areaCost(i, this.upgrade) * ff * (1.0D - getDegrade()));
/*  910 */       if (am > 0) {
/*  911 */         (SETT.THINGS()).resources.create(mX(), mY(), this.blueprint.resource(i), am);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private void releaseItem(int tx, int ty, boolean all) {
/*  917 */     FurnisherItem it = (FurnisherItem)(da()).item.get(tx, ty);
/*  918 */     if (it == null || !(da()).isMaster.is(tx, ty)) {
/*      */       return;
/*      */     }
/*      */     
/*  922 */     boolean constructed = true;
/*      */     
/*  924 */     int x1 = tx - it.firstX();
/*  925 */     int y1 = ty - it.firstY();
/*      */     int y;
/*  927 */     for (y = 0; y < it.height() && constructed; y++) {
/*  928 */       for (int x = 0; x < it.width(); x++) {
/*  929 */         if (it.is(x, y)) {
/*      */           
/*  931 */           if (!is(x1 + x, y1 + y)) {
/*  932 */             LOG.ln(String.valueOf((this.blueprint.blue()).info.name) + " " + String.valueOf((this.blueprint.blue()).info.name) + " " + String.valueOf(it.group.name) + " " + it.rotation + " " + it.width());
/*      */           }
/*  934 */           if (ConstructionData.dConstructed.get(x1 + x, y1 + y) == 0) {
/*  935 */             constructed = false;
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  941 */     if (all || !constructed) {
/*  942 */       for (y = 0; y < it.height(); y++) {
/*  943 */         for (int x = 0; x < it.width(); x++) {
/*  944 */           if (it.is(x, y))
/*      */           {
/*  946 */             ConstructionData.dConstructed.set((ROOMA)this, x1 + x, y1 + y, 0);
/*      */           }
/*      */         } 
/*      */       } 
/*  950 */       for (int i = 0; i < this.blueprint.resources(); i++) {
/*  951 */         double a = this.resMul * it.cost2(i, this.upgrade) * (1.0D - getDegrade());
/*  952 */         int am = (int)a;
/*  953 */         if (RND.rFloat() < a - am)
/*  954 */           am++; 
/*  955 */         if (am > 0) {
/*  956 */           (SETT.THINGS()).resources.create(tx, ty, this.blueprint.resource(i), am);
/*  957 */           GAME.player().res().inc(this.blueprint.resource(i), FResources.RTYPE.CONSTRUCTION, am);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TmpArea remove(int tx, int ty, boolean scatter, Object iser, boolean force) {
/*  969 */     (SETT.ROOMS()).stats.broken().remove(mX(), mY());
/*  970 */     releaseResources(true);
/*  971 */     for (COORDINATE c : body()) {
/*  972 */       if (!is(c))
/*      */         continue; 
/*  974 */       jobClear(c.x(), c.y());
/*      */     } 
/*      */     
/*  977 */     TmpArea a = delete(tx, ty, iser);
/*      */     
/*  979 */     for (COORDINATE c : a.body()) {
/*  980 */       if (a.is(c)) {
/*  981 */         int d = ConstructionData.dData.get(c);
/*  982 */         (SETT.ROOMS()).data.set((ROOMA)a, c, d);
/*      */       } 
/*      */     } 
/*  985 */     ((ConstructionBlueprint)blueprint()).remove(this);
/*  986 */     return a;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public double getDegrade() {
/*  992 */     degI = this;
/*  993 */     return deg.get();
/*      */   }
/*      */ 
/*      */   
/*      */   public void jobToggle(boolean toggle) {
/*  998 */     this.active = toggle;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean jobToggleIs() {
/* 1003 */     return this.active;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ROOM_DEGRADER degrader(int tx, int ty) {
/* 1010 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean needsFertilityToBeCleared(int tx, int ty) {
/* 1015 */     if (ConstructionData.dFloored.get(tx, ty) == 1) {
/* 1016 */       return false;
/*      */     }
/* 1018 */     return this.blueprint.removeFertility();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean needsTerrainToBeCleared(int tx, int ty) {
/* 1023 */     if ((SETT.TERRAIN()).CAVE.is(tx, ty))
/* 1024 */       return false; 
/* 1025 */     if (SETT.TERRAIN().get(tx, ty).roofIs()) {
/* 1026 */       if (this.blueprint.mustBeOutdoors())
/* 1027 */         return true; 
/* 1028 */       return false;
/*      */     } 
/*      */     
/* 1031 */     if (this.structureI != -1 && ((TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(this.structureI)).roof.is(tx, ty))
/* 1032 */       return false; 
/* 1033 */     if ((SETT.TERRAIN()).NADA.is(tx, ty))
/* 1034 */       return false; 
/* 1035 */     return this.blueprint.removeTerrain(tx, ty);
/*      */   }
/*      */ 
/*      */   
/*      */   public Furnisher constructor() {
/* 1040 */     return this.blueprint;
/*      */   }
/*      */   
/*      */   private static MapDataF da() {
/* 1044 */     return (SETT.ROOMS()).fData;
/*      */   }
/*      */   
/*      */   void debug(GBox box) {
/* 1048 */     box.add((SPRITE)box.text().add("nRes: ").add(this.resourcedNeeded));
/* 1049 */     box.add((SPRITE)box.text().add("nBuild: ").add(this.builtNeeded).add('/').add(this.builtTotal));
/* 1050 */     box.add((SPRITE)box.text().add("nStruc: ").add(this.structuresNeeded));
/* 1051 */     box.add((SPRITE)box.text().add("nClear: ").add(this.clearingNeeded));
/* 1052 */     box.add((SPRITE)box.text().add("nFloors: ").add(this.floorsNeeded));
/*      */   }
/*      */ 
/*      */   
/*      */   public SPRITE icon() {
/* 1057 */     return (SPRITE)this.blueprint.blue().iconBig();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean becomesSolid(int tx, int ty) {
/* 1062 */     if (this.clearingNeeded == 0 && this.structuresNeeded == 0 && this.resourcedNeeded == 0 && this.floorsNeeded == 0) {
/* 1063 */       FurnisherItemTile t = (FurnisherItemTile)(da()).tile.get(tx, ty);
/* 1064 */       if (t != null && t.availability.player < 0.0D)
/* 1065 */         return true; 
/*      */     } 
/* 1067 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public int totalResourcesNeeded(int tx, int ty) {
/* 1072 */     if (this.clearingNeeded != 0) {
/* 1073 */       return 1;
/*      */     }
/*      */     
/* 1076 */     if (this.structuresNeeded > 0) {
/* 1077 */       TBuilding t = (TBuilding)(SETT.TERRAIN()).BUILDINGS.all().get(this.structureI);
/* 1078 */       return t.structure.resAmount - ConstructionData.dWorkAmount.get(tx, ty);
/*      */     } 
/*      */     
/* 1081 */     if (this.resourcedNeeded > 0) {
/* 1082 */       int am = ConstructionData.dResAllocated.get(tx, ty);
/* 1083 */       for (int i = 0; i < this.blueprint.resources(); i++) {
/* 1084 */         am -= ConstructionData.dResourceNeeded[i].get(tx, ty);
/* 1085 */         if (am < 0) {
/* 1086 */           return -am;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1091 */     return 1;
/*      */   }
/*      */   
/*      */   public RoomState getState() {
/* 1095 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1101 */   private static ROOM_DEGRADER deg = new ROOM_DEGRADER()
/*      */     {
/*      */       protected void setData(int v, boolean realChange)
/*      */       {
/* 1105 */         ConstructionInstance.degI.degrade = v;
/*      */       }
/*      */ 
/*      */       
/*      */       public int resSize() {
/* 1110 */         return ConstructionInstance.degI.blueprint.resources();
/*      */       }
/*      */ 
/*      */       
/*      */       public int resAmount(int i) {
/* 1115 */         return 1;
/*      */       }
/*      */ 
/*      */       
/*      */       public RESOURCE res(int i) {
/* 1120 */         return ConstructionInstance.degI.blueprint.resource(i);
/*      */       }
/*      */ 
/*      */       
/*      */       public int getData() {
/* 1125 */         return ConstructionInstance.degI.degrade;
/*      */       }
/*      */ 
/*      */       
/*      */       public double degRate() {
/* 1130 */         return 0.0D;
/*      */       }
/*      */ 
/*      */       
/*      */       public int roomArea() {
/* 1135 */         return ConstructionInstance.degI.area();
/*      */       }
/*      */ 
/*      */       
/*      */       public double base() {
/* 1140 */         return 0.0D;
/*      */       }
/*      */ 
/*      */       
/*      */       public double expenseRate() {
/* 1145 */         return 0.0D;
/*      */       }
/*      */ 
/*      */       
/*      */       public double rate(double bonus) {
/* 1150 */         return 0.0D;
/*      */       }
/*      */ 
/*      */       
/*      */       public int jobs() {
/* 1155 */         return 0;
/*      */       }
/*      */     };
/*      */ 
/*      */   
/*      */   public int resAmount(int ri, int upgrade) {
/* 1161 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean is(int tile) {
/* 1166 */     return ((SETT.ROOMS()).map.indexGetter.get(tile) == this.roomI);
/*      */   }
/*      */ 
/*      */   
/*      */   public int upgrade() {
/* 1171 */     return this.upgrade;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isJobActive() {
/* 1176 */     return this.active;
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\construction\ConstructionInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */