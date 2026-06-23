/*      */ package settlement.job;
/*      */ 
/*      */ import game.GAME;
/*      */ import game.audio.SoundRace;
/*      */ import game.faction.FResources;
/*      */ import init.race.RACES;
/*      */ import init.race.Race;
/*      */ import init.resources.Growable;
/*      */ import init.resources.RESOURCE;
/*      */ import init.resources.RESOURCES;
/*      */ import init.sprite.SPRITES;
/*      */ import init.sprite.UI.UI;
/*      */ import java.util.Arrays;
/*      */ import settlement.entity.ENTITY;
/*      */ import settlement.entity.animal.Animal;
/*      */ import settlement.entity.animal.AnimalSpecies;
/*      */ import settlement.entity.humanoid.Humanoid;
/*      */ import settlement.main.SETT;
/*      */ import settlement.overlay.Addable;
/*      */ import settlement.room.industry.mine.ROOM_MINE;
/*      */ import settlement.room.industry.module.Industry;
/*      */ import settlement.tilemap.terrain.TGrowable;
/*      */ import settlement.tilemap.terrain.TRock;
/*      */ import settlement.tilemap.terrain.Terrain;
/*      */ import snake2d.Renderer;
/*      */ import snake2d.SPRITE_RENDERER;
/*      */ import snake2d.util.color.COLOR;
/*      */ import snake2d.util.datatypes.AREA;
/*      */ import snake2d.util.datatypes.COORDINATE;
/*      */ import snake2d.util.datatypes.DIR;
/*      */ import snake2d.util.file.Alloc;
/*      */ import snake2d.util.gui.GUI_BOX;
/*      */ import snake2d.util.gui.clickable.CLICKABLE;
/*      */ import snake2d.util.rnd.RND;
/*      */ import snake2d.util.sets.ArrayListGrower;
/*      */ import snake2d.util.sets.LIST;
/*      */ import snake2d.util.sets.LinkedList;
/*      */ import snake2d.util.sprite.SPRITE;
/*      */ import util.colors.GCOLOR;
/*      */ import util.gui.misc.GBox;
/*      */ import util.gui.misc.GButt;
/*      */ import util.info.GFORMAT;
/*      */ import util.rendering.RenderData;
/*      */ import util.text.D;
/*      */ import util.text.Dic;
/*      */ import view.main.VIEW;
/*      */ import view.subview.GameWindow;
/*      */ import view.tool.PLACABLE;
/*      */ import view.tool.PLACER_TYPE;
/*      */ import view.tool.PlacableMessages;
/*      */ import view.tool.PlacableMulti;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class JobClears
/*      */ {
/*      */   JobClears() {
/*   76 */     D.t(this);
/*      */ 
/*      */     
/*   79 */     this.stone = new JobClear("STONE", 
/*   80 */         D.g("Stone", "Clear Rock"), 
/*   81 */         D.g("StoneD", "Removes rocks on the map. Yields the resource stone."), 
/*   82 */         D.g("StoneV", "Clearing rocks"), 
/*   83 */         (SETT.TERRAIN()).ROCK.getIcon())
/*      */       {
/*      */         
/*   86 */         final Addable a = new Addable(null, null, null, null, true, false)
/*      */           {
/*      */             
/*      */             public void renderBelow(Renderer r, RenderData.RenderIterator it)
/*      */             {
/*   91 */               double v = 0.0D;
/*   92 */               if ((SETT.JOBS()).getter.get(it.tile()) == null) {
/*   93 */                 Terrain.TerrainTile t = SETT.TERRAIN().get(it.tile());
/*   94 */                 if (t instanceof TRock) {
/*   95 */                   TRock b = (TRock)t;
/*   96 */                   b.getClass(); v = Math.max(v, 0.5D + 0.5D * b.amountGet(it.tx(), it.ty()) / 15.0D);
/*      */                 } 
/*      */               } 
/*      */               
/*  100 */               renderUnder(v, r, it, false);
/*      */             }
/*      */           };
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected CharSequence problem(int tx, int ty, boolean overwrite) {
/*  108 */           if (super.problem(tx, ty, overwrite) != null)
/*  109 */             return super.problem(tx, ty, overwrite); 
/*  110 */           if (!(SETT.TERRAIN()).ROCK.is(tx, ty)) {
/*  111 */             return PlacableMessages.¤¤ROCK_MUST;
/*      */           }
/*  113 */           return null;
/*      */         }
/*      */ 
/*      */         
/*      */         public double jobPerformTime(Humanoid skill) {
/*  118 */           return 5.0D;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         Addable overlay() {
/*  124 */           return this.a;
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */     
/*  130 */     this.wood = new JobClear("TREE", 
/*  131 */         D.g("Tree", "Fell Tree"), 
/*  132 */         D.g("TreeD", "Removes trees and yields wood. Trees will slowly grow back in time."), 
/*  133 */         D.g("TreeV", "Chopping lumber"), 
/*  134 */         (SETT.TERRAIN()).TREES.icon)
/*      */       {
/*      */         
/*  137 */         final Addable a = new Addable(null, null, null, null, true, false)
/*      */           {
/*      */             
/*      */             public void renderBelow(Renderer r, RenderData.RenderIterator it)
/*      */             {
/*  142 */               double v = 0.0D;
/*  143 */               if ((SETT.JOBS()).getter.get(it.tile()) == null) {
/*  144 */                 Terrain.TerrainTile t = SETT.TERRAIN().get(it.tile());
/*  145 */                 if (t instanceof settlement.tilemap.terrain.TForest.Tree) {
/*  146 */                   v = Math.max(v, 0.5D + 0.5D * (SETT.TERRAIN()).TREES.amount.get(it.tile()) / 4.0D);
/*      */                 }
/*      */               } 
/*      */               
/*  150 */               renderUnder(v, r, it, false);
/*      */             }
/*      */           };
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         protected CharSequence problem(int tx, int ty, boolean overwrite) {
/*  158 */           if (super.problem(tx, ty, overwrite) != null)
/*  159 */             return super.problem(tx, ty, overwrite); 
/*  160 */           if (!(SETT.TERRAIN()).TREES.isTree(tx, ty)) {
/*  161 */             return PlacableMessages.¤¤TREE_MUST;
/*      */           }
/*  163 */           return null;
/*      */         }
/*      */ 
/*      */         
/*      */         Addable overlay() {
/*  168 */           return this.a;
/*      */         }
/*      */       };
/*      */ 
/*      */     
/*  173 */     this.woodAndRock = (PLACABLE)new PlacableMulti(
/*  174 */         D.g("Clear", "Clear All"), 
/*  175 */         D.g("ClearD", "Clears stone and wood."), (SPRITE)(SPRITES.icons()).l.clear_all)
/*      */       {
/*  177 */         final Addable a = new Addable(null, null, null, null, true, false)
/*      */           {
/*      */             
/*      */             public void renderBelow(Renderer r, RenderData.RenderIterator it)
/*      */             {
/*  182 */               double v = 0.0D;
/*  183 */               if ((SETT.JOBS()).getter.get(it.tile()) == null) {
/*  184 */                 Terrain.TerrainTile t = SETT.TERRAIN().get(it.tile());
/*  185 */                 if (t instanceof TRock) {
/*  186 */                   TRock b = (TRock)t;
/*  187 */                   b.getClass(); v = Math.max(v, 0.5D + 0.5D * b.amountGet(it.tx(), it.ty()) / 15.0D);
/*      */                 } 
/*  189 */                 if (t instanceof settlement.tilemap.terrain.TForest.Tree) {
/*  190 */                   v = Math.max(v, 0.5D + 0.5D * (SETT.TERRAIN()).TREES.amount.get(it.tile()) / 4.0D);
/*      */                 }
/*      */               } 
/*      */ 
/*      */               
/*  195 */               renderUnder(v, r, it, false);
/*      */             }
/*      */           };
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/*  203 */           if (JobClears.this.wood.problem(tx, ty, false) == null) {
/*  204 */             Placer.place(tx, ty, JobClears.this.wood);
/*  205 */           } else if (JobClears.this.stone.problem(tx, ty, false) == null) {
/*  206 */             Placer.place(tx, ty, JobClears.this.stone);
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/*  213 */           if (JobClears.this.wood.placer().isPlacable(tx, ty, a, t) == null) {
/*  214 */             return null;
/*      */           }
/*  216 */           if (JobClears.this.stone.placer().isPlacable(tx, ty, a, t) == null) {
/*  217 */             return null;
/*      */           }
/*  219 */           if (JobClears.this.wood.placer().isPlacable(tx, ty, a, t) != null) {
/*  220 */             return JobClears.this.wood.placer().isPlacable(tx, ty, a, t);
/*      */           }
/*  222 */           if (JobClears.this.stone.placer().isPlacable(tx, ty, a, t) != null) {
/*  223 */             return JobClears.this.stone.placer().isPlacable(tx, ty, a, t);
/*      */           }
/*  225 */           return null;
/*      */         }
/*      */ 
/*      */         
/*      */         public PLACABLE getUndo() {
/*  230 */           return (PLACABLE)(SETT.JOBS()).tool_clear;
/*      */         }
/*      */ 
/*      */         
/*      */         public LIST<CLICKABLE> getAdditionalButt() {
/*  235 */           return (LIST<CLICKABLE>)JobClears.this.butts;
/*      */         }
/*      */ 
/*      */         
/*      */         public void updateRegardless(GameWindow window, AREA selected) {
/*  240 */           JobClears.this.currentOverlay = this.a;
/*  241 */           if (JobClears.this.overlay) {
/*  242 */             this.a.add();
/*      */           }
/*      */         }
/*      */       };
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
/*  273 */     this.food = new JobClear(
/*  274 */         "FORAGE", 
/*  275 */         D.g("Food", "Forage"), 
/*  276 */         D.g("FoodD", "Forage Wild Growing crops. These re-grow with each year."), 
/*  277 */         D.g("FoodV", "Gathering"), 
/*  278 */         (SPRITE)((Growable)RESOURCES.growable().all().get(0)).resource.icon())
/*      */       {
/*      */ 
/*      */         
/*      */         protected CharSequence problem(int tx, int ty, boolean overwrite)
/*      */         {
/*  284 */           if (super.problem(tx, ty, overwrite) != null)
/*  285 */             return super.problem(tx, ty, overwrite); 
/*  286 */           if ((SETT.FLOOR()).getter.get(tx, ty) != null) {
/*  287 */             return PlacableMessages.¤¤ROAD_ALREADY;
/*      */           }
/*  289 */           Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/*  290 */           if (t instanceof TGrowable) {
/*  291 */             TGrowable g = (TGrowable)t;
/*  292 */             if (g.job.is(tx, ty)) {
/*  293 */               return PLACABLE.E;
/*      */             }
/*  295 */             return null;
/*      */           } 
/*      */           
/*  298 */           return PlacableMessages.¤¤NOT_EDIBLE;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public void doSomethingExtraRender() {}
/*      */ 
/*      */ 
/*      */         
/*      */         public void hover(GBox box) {
/*  308 */           super.hover(box);
/*      */           
/*  310 */           if (!(SETT.WEATHER()).growthRipe.cropsAreRipe()) {
/*  311 */             box.NL();
/*  312 */             box.error(PlacableMessages.¤¤NOT_RIPE);
/*      */           } 
/*      */           
/*  315 */           Terrain.TerrainTile t = (Terrain.TerrainTile)SETT.TERRAIN().get((COORDINATE)this.coo);
/*  316 */           if (t instanceof TGrowable) {
/*  317 */             TGrowable g = (TGrowable)t;
/*  318 */             RESOURCE r = g.growable.resource;
/*  319 */             box.NL();
/*  320 */             box.add((SPRITE)r.icon());
/*  321 */             box.add((SPRITE)GFORMAT.iofk(box.text(), g.resource.get((COORDINATE)this.coo), g.size.get((COORDINATE)this.coo)));
/*      */           } 
/*      */         }
/*      */ 
/*      */         
/*      */         void cancel(int tx, int ty) {
/*  327 */           Terrain.TerrainTile t = (Terrain.TerrainTile)SETT.TERRAIN().get((COORDINATE)this.coo);
/*  328 */           if (t instanceof TGrowable) {
/*  329 */             ((TGrowable)t).job.set(tx, ty, false);
/*      */           }
/*      */         }
/*      */ 
/*      */         
/*      */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ri) {
/*  335 */           Terrain.TerrainTile t = (Terrain.TerrainTile)SETT.TERRAIN().get((COORDINATE)this.coo);
/*  336 */           if (t instanceof TGrowable) {
/*  337 */             TGrowable g = (TGrowable)t;
/*  338 */             boolean has = (g.resource.get((COORDINATE)this.coo) > 0);
/*  339 */             g.resource.increment((COORDINATE)this.coo, -1);
/*      */             
/*  341 */             if (g.resource.get((COORDINATE)this.coo) == 0) {
/*      */               
/*  343 */               PlacerDelete.place(this.coo.x(), this.coo.y());
/*  344 */               t = (Terrain.TerrainTile)SETT.TERRAIN().get((COORDINATE)this.coo);
/*  345 */               if (t instanceof TGrowable) {
/*  346 */                 TGrowable b = (TGrowable)t;
/*  347 */                 b.job.set(this.coo.x(), this.coo.y(), true);
/*      */               } 
/*      */             } else {
/*      */               
/*  351 */               (SETT.JOBS()).state.set(StateManager.State.RESERVABLE, this);
/*  352 */             }  if (has) {
/*  353 */               GAME.player().res().inc(g.growable.resource, FResources.RTYPE.PRODUCED, 1);
/*  354 */               return g.growable.resource;
/*      */             } 
/*  356 */             return null;
/*      */           } 
/*  358 */           PlacerDelete.place(this.coo.x(), this.coo.y());
/*  359 */           return null;
/*      */         }
/*      */ 
/*      */         
/*      */         void renderAbove(SPRITE_RENDERER r, int x, int y, int mask, int tx, int ty) {
/*  364 */           (SPRITES.cons()).ICO.scratch.render(r, x, y);
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean needsRipe() {
/*  369 */           return true;
/*      */         }
/*      */ 
/*      */         
/*      */         public PlacableMulti placer() {
/*  374 */           return this.foodPlacer;
/*      */         }
/*      */         
/*  377 */         public final PlacableMulti op = super.placer();
/*      */ 
/*      */         
/*  380 */         public final PlacableMulti foodPlacer = new PlacableMulti(this.op.name(), this.op.desc, this.op.getIcon())
/*      */           {
/*      */             int gi;
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
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final LinkedList<CLICKABLE> bb;
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
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private boolean overlay;
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
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             private final PlacableMulti undo;
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
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*      */             public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  471 */               TGrowable b = (TGrowable)SETT.TERRAIN().get(tx, ty);
/*  472 */               if (b.resource.get(tx, ty) <= 0) {
/*  473 */                 b.job.set(tx, ty, true);
/*      */               } else {
/*  475 */                 JobClears.null.this.op.place(tx, ty, area, type);
/*      */               } 
/*      */             }
/*      */ 
/*      */             
/*      */             public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  481 */               CharSequence s = JobClears.null.this.op.isPlacable(tx, ty, area, type);
/*  482 */               if (s != null) {
/*  483 */                 return s;
/*      */               }
/*  485 */               Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/*  486 */               if (t instanceof TGrowable) {
/*  487 */                 TGrowable b = (TGrowable)t;
/*  488 */                 if (this.gi < 0)
/*  489 */                   return null; 
/*  490 */                 return ((SETT.TERRAIN()).GROWABLES.get(this.gi) == b) ? null : E;
/*      */               } 
/*  492 */               return E;
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*      */             public void updateRegardless(GameWindow window, AREA selected) {
/*  498 */               if (this.overlay) {
/*  499 */                 (SETT.OVERLAY()).EDIBLES.add();
/*      */               }
/*      */             }
/*      */             
/*      */             public CharSequence isPlacable(AREA area, PLACER_TYPE type) {
/*  504 */               return super.isPlacable(area, type);
/*      */             }
/*      */ 
/*      */             
/*      */             public LIST<CLICKABLE> getAdditionalButt() {
/*  509 */               return (LIST<CLICKABLE>)this.bb;
/*      */             }
/*      */             
/*      */             public PLACABLE getUndo() {
/*  513 */               return (PLACABLE)this.undo;
/*      */             }
/*      */           };
/*      */       };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  521 */     this.water = new JobClear(
/*  522 */         "WATER", 
/*  523 */         D.g("Water", "Remove Water"), 
/*  524 */         D.g("WaterD", "Removes natural occurring water. Deep water can not be removed completely, but a passage-way can be created."), 
/*  525 */         D.g("WaterV", "Removing water"), 
/*  526 */         (SETT.TERRAIN()).WATER.SHALLOW.getIcon().twin((SPRITE)(UI.icons()).m.anti, DIR.C, 2))
/*      */       {
/*      */         protected CharSequence problem(int tx, int ty, boolean overwrite)
/*      */         {
/*  530 */           if (super.problem(tx, ty, overwrite) != null) {
/*  531 */             return super.problem(tx, ty, overwrite);
/*      */           }
/*  533 */           if (!(SETT.TERRAIN()).WATER.isW.is(tx, ty)) {
/*  534 */             return PlacableMessages.¤¤WATER_MUST;
/*      */           }
/*  536 */           return null;
/*      */         }
/*      */       };
/*      */ 
/*      */     
/*  541 */     this.returnwater = new JobBuild("WATER_RET", null, 1, false, 
/*      */         
/*  543 */         D.g("Canal", "Return water"), 
/*  544 */         D.g("CanalD", "Return water to where there is ground water."), 
/*  545 */         (SETT.TERRAIN()).WATER.SHALLOW.getIcon())
/*      */       {
/*      */         void renderAbove(SPRITE_RENDERER r, int x, int y, int mask, int tx, int ty)
/*      */         {
/*  549 */           (SPRITES.cons()).ICO.unclear.render(r, x, y);
/*      */         }
/*      */ 
/*      */         
/*      */         protected double constructionTime(Humanoid skill) {
/*  554 */           return 45.0D;
/*      */         }
/*      */ 
/*      */         
/*      */         protected SoundRace constructSound() {
/*  559 */           return (SETT.TERRAIN()).WATER.SHALLOW.clearing().sound(this.coo.x(), this.coo.y());
/*      */         }
/*      */ 
/*      */         
/*      */         protected boolean construct(int tx, int ty) {
/*  564 */           if ((SETT.TERRAIN()).WATER.BRIDGE.is(tx, ty)) {
/*  565 */             (SETT.TERRAIN()).WATER.DEEP.placeFixed(this.coo.x(), this.coo.y());
/*      */           } else {
/*  567 */             (SETT.TERRAIN()).WATER.SHALLOW.placeFixed(this.coo.x(), this.coo.y());
/*  568 */           }  (SETT.FLOOR()).clearer.clear(tx, ty);
/*      */           
/*  570 */           return false;
/*      */         }
/*      */ 
/*      */         
/*      */         protected CharSequence problem(int tx, int ty, boolean overwrite) {
/*  575 */           if ((SETT.TERRAIN()).WATER.BRIDGE.is(tx, ty))
/*  576 */             return null; 
/*  577 */           if (super.problem(tx, ty, overwrite) != null) {
/*  578 */             return super.problem(tx, ty, overwrite);
/*      */           }
/*  580 */           if (!(SETT.TERRAIN()).WATER.groundWater.is(tx, ty) && !(SETT.TERRAIN()).WATER.groundWaterSalt.is(tx, ty))
/*  581 */             return PlacableMessages.¤¤WATER_RETURN; 
/*  582 */           if ((SETT.TERRAIN()).WATER.is.is(tx, ty))
/*  583 */             return PlacableMessages.¤¤TERRAIN_BLOCK; 
/*  584 */           return null;
/*      */         }
/*      */         
/*  587 */         final Addable a = new Addable(null, null, null, null, true, false)
/*      */           {
/*      */             
/*      */             public void renderBelow(Renderer r, RenderData.RenderIterator it)
/*      */             {
/*  592 */               COLOR c = COLOR.WHITE05;
/*  593 */               if ((SETT.JOBS()).getter.get(it.tile()) == null) {
/*  594 */                 if ((SETT.TERRAIN()).WATER.groundWater.is(it.tile())) {
/*  595 */                   c = (GCOLOR.MAP()).OVERLAY_GOOD;
/*  596 */                 } else if ((SETT.TERRAIN()).WATER.groundWaterSalt.is(it.tile())) {
/*  597 */                   c = COLOR.YELLOW100;
/*      */                 } 
/*      */               }
/*      */               
/*  601 */               renderUnder(c, r, it);
/*      */             }
/*      */           };
/*      */ 
/*      */         
/*  606 */         private final Placer p = new Placer(this, this.placer.desc)
/*      */           {
/*      */             public LIST<CLICKABLE> getAdditionalButt()
/*      */             {
/*  610 */               return (LIST<CLICKABLE>)(JobClears.null.access$0(JobClears.null.this)).butts;
/*      */             }
/*      */ 
/*      */             
/*      */             public void updateRegardless(GameWindow window, AREA selected) {
/*  615 */               (SETT.JOBS()).clearss.currentOverlay = JobClears.null.this.a;
/*  616 */               if ((JobClears.null.access$0(JobClears.null.this)).overlay) {
/*  617 */                 JobClears.null.this.a.add();
/*      */               }
/*      */             }
/*      */           };
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public PlacableMulti placer() {
/*  626 */           return this.p;
/*      */         }
/*      */ 
/*      */         
/*      */         public Terrain.TerrainTile becomes(int tx, int ty) {
/*  631 */           return (SETT.TERRAIN()).WATER.SHALLOW;
/*      */         }
/*      */       };
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  656 */     this.tunnel = new JobClear(
/*  657 */         "MOUNTAIN", 
/*  658 */         D.g("Tunnel", "Dig Into Mountain"), 
/*  659 */         D.g("TunnelD", "Digs a tunnel into the mountain."), 
/*  660 */         D.g("TunnelV", "Tunnels into the mountain"), 
/*  661 */         (SETT.TERRAIN()).MOUNTAIN.getIcon().twin((SPRITE)(UI.icons()).m.anti, DIR.C, 1))
/*      */       {
/*      */         
/*  664 */         double tunnelD = 0.0D;
/*      */         
/*  666 */         public final Addable MOUNTAIN = new Addable(null, null, null, null, false, true)
/*      */           {
/*      */             public boolean render(Renderer r, RenderData.RenderIterator it)
/*      */             {
/*  670 */               if ((SETT.TERRAIN()).MOUNTAIN.is(it.tile()) && !(SETT.JOBS()).getter.is(it.tile()))
/*      */               {
/*  672 */                 renderUnder(0.25D + 0.5D * (SETT.TERRAIN()).MOUNTAIN.strength(it.tile()), r, it, false);
/*      */               }
/*      */ 
/*      */               
/*  676 */               return false;
/*      */             }
/*      */           };
/*      */ 
/*      */         
/*      */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ri) {
/*  682 */           this.tunnelD++;
/*      */           
/*  684 */           if (this.tunnelD >= 1.0D) {
/*  685 */             this.tunnelD--;
/*  686 */             RESOURCE res = JobClears.this.tunnelPerform((COORDINATE)this.coo);
/*  687 */             if (res != null) {
/*  688 */               GAME.player().res().inc(res, FResources.RTYPE.PRODUCED, 1);
/*      */             }
/*  690 */             if (!(SETT.TERRAIN()).MOUNTAIN.is((COORDINATE)this.coo)) {
/*  691 */               PlacerDelete.place(this.coo.x(), this.coo.y());
/*      */               
/*  693 */               return res;
/*      */             } 
/*      */             
/*  696 */             (SETT.JOBS()).state.set(StateManager.State.RESERVABLE, this);
/*  697 */             return res;
/*      */           } 
/*      */           
/*  700 */           (SETT.JOBS()).state.set(StateManager.State.RESERVABLE, this);
/*  701 */           return null;
/*      */         }
/*      */ 
/*      */         
/*      */         protected CharSequence problem(int tx, int ty, boolean overwrite) {
/*  706 */           if (super.problem(tx, ty, overwrite) != null)
/*  707 */             return super.problem(tx, ty, overwrite); 
/*  708 */           if (!(SETT.TERRAIN()).MOUNTAIN.is(tx, ty)) {
/*  709 */             return PlacableMessages.¤¤MOUNTAIN_MUST;
/*      */           }
/*  711 */           return null;
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean isConstruction() {
/*  716 */           return true;
/*      */         }
/*      */ 
/*      */         
/*      */         public double jobPerformTime(Humanoid skill) {
/*  721 */           return JobClears.this.raceSpeeds[(skill.race()).index];
/*      */         }
/*      */ 
/*      */         
/*      */         Addable overlay() {
/*  726 */           return this.MOUNTAIN;
/*      */         }
/*      */       };
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
/*      */     
/*  747 */     this.caveFill = new JobBuildFillCave();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  752 */     this.structure = new JobClear(
/*  753 */         "BUILDING", 
/*  754 */         D.g("Structure", "Dismantle Structure"), 
/*  755 */         D.g("StructureD", "Removes structures (fortifications, walls, roofs and roads.)"), 
/*  756 */         D.g("StructureV", "Demolishing structure"), 
/*  757 */         (SPRITE)(SPRITES.icons()).m.clear_structure)
/*      */       {
/*      */         double demAmount;
/*      */         
/*      */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ri) {
/*  762 */           if (problem(this.coo.x(), this.coo.y(), true) != null) {
/*  763 */             PlacerDelete.place(this.coo.x(), this.coo.y());
/*  764 */             return null;
/*      */           } 
/*      */ 
/*      */           
/*  768 */           Terrain.TerrainTile t = SETT.TERRAIN().get(this.coo.x(), this.coo.y());
/*  769 */           RESOURCE res = t.clearing().clear1(this.coo.x(), this.coo.y());
/*  770 */           if ((SETT.FLOOR()).getter.is(this.coo.x(), this.coo.y())) {
/*  771 */             (SETT.FLOOR()).clearer.clear(this.coo.x(), this.coo.y());
/*      */           }
/*  773 */           this.demAmount += RND.rFloat();
/*      */ 
/*      */           
/*  776 */           if (res != null && this.demAmount > 1.0D) {
/*  777 */             GAME.player().res().inc(res, FResources.RTYPE.CONSTRUCTION, (int)this.demAmount);
/*  778 */             this.demAmount--;
/*  779 */             if (this.demAmount > 1.0D) {
/*  780 */               (SETT.THINGS()).resources.create((COORDINATE)this.coo, res, (int)this.demAmount);
/*  781 */               this.demAmount -= (int)this.demAmount;
/*      */             } 
/*      */           } else {
/*  784 */             res = null;
/*      */           } 
/*      */           
/*  787 */           if (problem(this.coo.x(), this.coo.y(), true) == null) {
/*  788 */             (SETT.JOBS()).state.set(StateManager.State.RESERVABLE, this);
/*      */           } else {
/*  790 */             PlacerDelete.place(this.coo.x(), this.coo.y());
/*      */           } 
/*  792 */           return res;
/*      */         }
/*      */ 
/*      */         
/*      */         protected CharSequence problem(int tx, int ty, boolean override) {
/*  797 */           if (super.problem(tx, ty, override) != null)
/*  798 */             return super.problem(tx, ty, override); 
/*  799 */           if (SETT.TERRAIN().get(tx, ty).clearing().isStructure() && !(SETT.TERRAIN()).MOUNTAIN.isMountain(tx, ty))
/*  800 */             return null; 
/*  801 */           if ((SETT.FLOOR()).getter.is(tx, ty))
/*  802 */             return null; 
/*  803 */           if ((SETT.TERRAIN()).MOUNTAIN.isMountain(tx, ty))
/*  804 */             return PlacableMessages.¤¤BLOCKED; 
/*  805 */           if (!SETT.TERRAIN().get(tx, ty).clearing().isStructure() && !(SETT.FLOOR()).getter.is(tx, ty))
/*  806 */             return PlacableMessages.¤¤STRUCTURE_CLEAR; 
/*  807 */           return null;
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */     
/*  813 */     this.road = new JobClear(
/*  814 */         "ROAD", 
/*  815 */         D.g("Road", "Remove Road"), 
/*  816 */         D.g("RoadD", "Removes Roads"), 
/*  817 */         D.g("RoadV", "Demolishing road"), 
/*  818 */         (SPRITE)(SPRITES.icons()).l.demolishRoad)
/*      */       {
/*      */         
/*      */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ri)
/*      */         {
/*  823 */           if (problem(this.coo.x(), this.coo.y(), true) != null) {
/*  824 */             PlacerDelete.place(this.coo.x(), this.coo.y());
/*  825 */             return null;
/*      */           } 
/*      */           
/*  828 */           if ((SETT.FLOOR()).getter.is(this.coo.x(), this.coo.y())) {
/*  829 */             (SETT.FLOOR()).clearer.clear(this.coo.x(), this.coo.y());
/*      */           }
/*      */           
/*  832 */           if (problem(this.coo.x(), this.coo.y(), true) == null) {
/*  833 */             (SETT.JOBS()).state.set(StateManager.State.RESERVABLE, this);
/*      */           } else {
/*  835 */             PlacerDelete.place(this.coo.x(), this.coo.y());
/*      */           } 
/*  837 */           return null;
/*      */         }
/*      */ 
/*      */         
/*      */         protected CharSequence problem(int tx, int ty, boolean override) {
/*  842 */           if (super.problem(tx, ty, override) != null)
/*  843 */             return super.problem(tx, ty, override); 
/*  844 */           if (!(SETT.FLOOR()).getter.is(tx, ty))
/*  845 */             return Dic.empty; 
/*  846 */           Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/*  847 */           if (t.wantsFloorUnderneath(tx, ty)) {
/*  848 */             return Dic.empty;
/*      */           }
/*  850 */           return null;
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */     
/*  856 */     this.huntundo = new PlacableMulti(¤¤huntCancel)
/*      */       {
/*      */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*      */         {
/*  860 */           for (ENTITY e : SETT.ENTITIES().getAtTile(tx, ty)) {
/*  861 */             if (e instanceof Animal) {
/*  862 */               Animal a = (Animal)e;
/*  863 */               a.huntMark(false);
/*      */             } 
/*      */           } 
/*      */         }
/*      */ 
/*      */         
/*      */         public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, AREA area, PLACER_TYPE type, boolean isPlacable, boolean areaIsPlacable) {
/*  870 */           (SPRITES.cons()).BIG.outline.render(r, mask, x, y);
/*  871 */           int dx = tx * 64;
/*  872 */           int dy = ty * 64;
/*  873 */           (GCOLOR.MAP()).JOB_ACTIVE.bind();
/*  874 */           for (ENTITY e : SETT.ENTITIES().getAtTile(tx, ty)) {
/*  875 */             if (e instanceof Animal) {
/*  876 */               Animal a = (Animal)e;
/*  877 */               if (a.huntMarkedIs()) {
/*  878 */                 int ddx = a.body().cX() - dx;
/*  879 */                 int ddy = a.body().cY() - dy;
/*  880 */                 (SPRITES.cons()).ICO.crosshair.renderC(r, x + ddx, y + ddy);
/*      */               } 
/*      */             } 
/*      */           } 
/*  884 */           COLOR.unbind();
/*      */         }
/*      */ 
/*      */         
/*      */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  889 */           return null;
/*      */         }
/*      */       };
/*      */     
/*  893 */     this.hunt = new PlacableMulti(¤¤hunt, ¤¤huntD, (SPRITE)((AnimalSpecies)(SETT.ANIMALS()).species.get(0)).icon)
/*      */       {
/*      */ 
/*      */         
/*      */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*      */         {
/*  899 */           for (ENTITY e : SETT.ENTITIES().getAtTile(tx, ty)) {
/*  900 */             if (e instanceof Animal) {
/*  901 */               Animal a = (Animal)e;
/*  902 */               a.huntMark(true);
/*      */             } 
/*      */           } 
/*      */         }
/*      */         
/*  907 */         private final int[] ams = Alloc.ii(RESOURCES.ALL().size());
/*      */ 
/*      */ 
/*      */         
/*      */         public void placeInfo(GBox b, int oktiles, AREA area) {
/*  912 */           Arrays.fill(this.ams, 0);
/*      */           
/*  914 */           for (COORDINATE c : area.body()) {
/*  915 */             if (area.is(c)) {
/*  916 */               for (ENTITY e : SETT.ENTITIES().getAtTile(c.x(), c.y())) {
/*  917 */                 if (e instanceof Animal) {
/*  918 */                   Animal a = (Animal)e;
/*  919 */                   if (a.huntMarkedCan()) {
/*  920 */                     for (int i = 0; i < a.species().resources().size(); i++) {
/*  921 */                       this.ams[((RESOURCE)a.species().resources().get(i)).index()] = this.ams[((RESOURCE)a.species().resources().get(i)).index()] + a.species().resAmount(i, a.physics.getMass());
/*      */                     }
/*      */                   }
/*      */                 } 
/*      */               } 
/*      */             }
/*      */           } 
/*      */ 
/*      */           
/*  930 */           for (RESOURCE r : RESOURCES.ALL()) {
/*  931 */             if (this.ams[r.index()] > 0) {
/*  932 */               b.add((SPRITE)r.icon());
/*  933 */               b.add((SPRITE)GFORMAT.i(b.text(), this.ams[r.index()]));
/*  934 */               b.NL();
/*      */             } 
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, AREA area, PLACER_TYPE type, boolean isPlacable, boolean areaIsPlacable) {
/*  942 */           (SPRITES.cons()).BIG.outline.render(r, mask, x, y);
/*  943 */           int dx = tx * 64;
/*  944 */           int dy = ty * 64;
/*  945 */           (GCOLOR.MAP()).JOB_ACTIVE.bind();
/*  946 */           for (ENTITY e : SETT.ENTITIES().getAtTile(tx, ty)) {
/*  947 */             if (e instanceof Animal) {
/*  948 */               Animal a = (Animal)e;
/*  949 */               if (a.huntMarkedCan()) {
/*  950 */                 int ddx = a.body().cX() - dx;
/*  951 */                 int ddy = a.body().cY() - dy;
/*  952 */                 (SPRITES.cons()).ICO.crosshair.renderC(r, x + ddx, y + ddy);
/*      */               } 
/*      */             } 
/*      */           } 
/*      */           
/*  957 */           COLOR.unbind();
/*      */         }
/*      */ 
/*      */         
/*      */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*  962 */           return null;
/*      */         }
/*      */ 
/*      */         
/*      */         public PLACABLE getUndo() {
/*  967 */           return (PLACABLE)JobClears.this.huntundo;
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  974 */     this
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  981 */       .placers = new PLACABLE[] { (PLACABLE)this.wood.placer(), (PLACABLE)this.stone.placer(), this.woodAndRock, (PLACABLE)this.water.placer(), (PLACABLE)this.returnwater.placer(), (PLACABLE)this.tunnel.placer(), (PLACABLE)this.caveFill.placer() };
/*      */ 
/*      */     
/*  984 */     this.butts = new ArrayListGrower();
/*      */     
/*  986 */     this.lastActivated = this.woodAndRock;
/*  987 */     this.overlay = true;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1012 */     this.butts.add(new GButt.ButtPanel((SPRITE)new SPRITE.Wrap((SPRITE)(UI.icons()).s.eye, 24, 24))
/*      */         {
/*      */           public void hoverInfoGet(GUI_BOX text)
/*      */           {
/* 1016 */             text.title(Dic.¤¤Overlay);
/*      */           }
/*      */ 
/*      */           
/*      */           protected void clickA() {
/* 1021 */             JobClears.this.overlay = !JobClears.this.overlay;
/* 1022 */             super.clickA();
/*      */           }
/*      */ 
/*      */           
/*      */           protected void renAction() {
/* 1027 */             activeSet((JobClears.this.currentOverlay != null));
/* 1028 */             selectedSet(JobClears.this.overlay); }
/*      */         });
/*      */     byte b;
/*      */     int i;
/*      */     PLACABLE[] arrayOfPLACABLE;
/* 1033 */     for (i = (arrayOfPLACABLE = this.placers).length, b = 0; b < i; ) { final PLACABLE p = arrayOfPLACABLE[b];
/* 1034 */       GButt.ButtPanel buttPanel = new GButt.ButtPanel((SPRITE)new SPRITE.Wrap(p.getIcon(), 32, 32))
/*      */         {
/*      */           public void hoverInfoGet(GUI_BOX text)
/*      */           {
/* 1038 */             GBox b = (GBox)text;
/* 1039 */             b.title(p.name());
/* 1040 */             p.hoverDesc(b);
/*      */           }
/*      */ 
/*      */           
/*      */           protected void clickA() {
/* 1045 */             (VIEW.inters()).popup.close();
/* 1046 */             (VIEW.s()).tools.place(p);
/* 1047 */             JobClears.this.lastActivated = p;
/* 1048 */             super.clickA();
/*      */           }
/*      */ 
/*      */           
/*      */           protected void renAction() {
/* 1053 */             selectedSet(((VIEW.s()).tools.placer.getCurrent() == p));
/*      */           }
/*      */         };
/*      */       
/* 1057 */       this.butts.add(buttPanel);
/*      */       b++; }
/*      */   
/*      */   }
/*      */   private static CharSequence ¤¤harvestDesc = "This job is dormant since there currently isn't enough growth to harvest anything. The job will become active once growth occurs.";
/*      */   private static CharSequence ¤¤hunt = "Hunt";
/*      */   private static CharSequence ¤¤huntD = "Manually hunt the wild animals on the map for resources. Note that hunting can be dangerous. A hunter might get mauled from time to time.";
/*      */   private static CharSequence ¤¤huntCancel = "Cancel Hunt";
/*      */   public final Job stone;
/*      */   public final Job wood;
/*      */   public final PLACABLE woodAndRock;
/*      */   public final Job food;
/*      */   public final Job water;
/*      */   public final Job returnwater;
/*      */   private int[] raceSpeeds;
/*      */   public final Job tunnel;
/*      */   public final Job caveFill;
/*      */   public final Job structure;
/*      */   public final Job road;
/*      */   public final PlacableMulti huntundo;
/*      */   public final PlacableMulti hunt;
/*      */   public final PLACABLE[] placers;
/*      */   final ArrayListGrower<CLICKABLE> butts;
/*      */   public PLACABLE lastActivated;
/*      */   boolean overlay;
/*      */   Addable currentOverlay;
/*      */   
/*      */   void HoverEdible(GBox box, int tx, int ty) {
/*      */     Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/*      */     if (t instanceof TGrowable) {
/*      */       box.title(this.food.name);
/*      */       TGrowable g = (TGrowable)t;
/*      */       RESOURCE r = ((TGrowable)t).growable.resource;
/*      */       box.NL();
/*      */       box.add((SPRITE)r.icon());
/*      */       int am = g.resource.get(tx, ty);
/*      */       box.add((SPRITE)GFORMAT.iofk(box.text(), g.resource.get(tx, ty), g.size.get(tx, ty)));
/*      */       if (am == 0) {
/*      */         box.NL();
/*      */         box.error(¤¤harvestDesc);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   void initSpeeds() {
/*      */     this.raceSpeeds = Alloc.ii(RACES.all().size());
/*      */     for (Race r : RACES.all()) {
/*      */       double min = 0.0D;
/*      */       for (ROOM_MINE m : (SETT.ROOMS()).MINES)
/*      */         min = Math.max(min, r.bvalue(((Industry)m.industries().get(0)).bonus())); 
/*      */       this.raceSpeeds[r.index()] = (int)(60.0D / (1.0D + min));
/*      */     } 
/*      */   }
/*      */   
/*      */   public RESOURCE tunnelPerform(COORDINATE coo) {
/*      */     RESOURCE res = SETT.TERRAIN().get(coo.x(), coo.y()).clearing().clear1(coo.x(), coo.y());
/*      */     if (!(SETT.TERRAIN()).MOUNTAIN.is(coo))
/*      */       for (DIR d : DIR.ALLC) {
/*      */         if ((SETT.TERRAIN()).CAVE.canFix(coo.x() + d.x(), coo.y() + d.y()))
/*      */           (SETT.TERRAIN()).CAVE.fix(coo.x() + d.x(), coo.y() + d.y()); 
/*      */         (GAME.count()).TUNNELS.inc(1);
/*      */       }  
/*      */     return res;
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobClears.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */