/*     */ package settlement.job;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.TGrowable;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMessages;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends JobClear
/*     */ {
/*     */   public final PlacableMulti op;
/*     */   public final PlacableMulti foodPlacer;
/*     */   
/*     */   null(String $anonymous0, CharSequence $anonymous1, CharSequence $anonymous2, CharSequence $anonymous3, SPRITE $anonymous4) {
/* 273 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 377 */     this.op = super.placer();
/*     */ 
/*     */     
/* 380 */     this.foodPlacer = new PlacableMulti(this.op.name(), this.op.desc, this.op.getIcon())
/*     */       {
/*     */         int gi;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private final LinkedList<CLICKABLE> bb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private boolean overlay;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private final PlacableMulti undo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 471 */           TGrowable b = (TGrowable)SETT.TERRAIN().get(tx, ty);
/* 472 */           if (b.resource.get(tx, ty) <= 0) {
/* 473 */             b.job.set(tx, ty, true);
/*     */           } else {
/* 475 */             JobClears.null.this.op.place(tx, ty, area, type);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 481 */           CharSequence s = JobClears.null.this.op.isPlacable(tx, ty, area, type);
/* 482 */           if (s != null) {
/* 483 */             return s;
/*     */           }
/* 485 */           Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/* 486 */           if (t instanceof TGrowable) {
/* 487 */             TGrowable b = (TGrowable)t;
/* 488 */             if (this.gi < 0)
/* 489 */               return null; 
/* 490 */             return ((SETT.TERRAIN()).GROWABLES.get(this.gi) == b) ? null : E;
/*     */           } 
/* 492 */           return E;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void updateRegardless(GameWindow window, AREA selected) {
/* 498 */           if (this.overlay) {
/* 499 */             (SETT.OVERLAY()).EDIBLES.add();
/*     */           }
/*     */         }
/*     */         
/*     */         public CharSequence isPlacable(AREA area, PLACER_TYPE type) {
/* 504 */           return super.isPlacable(area, type);
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/* 509 */           return (LIST<CLICKABLE>)this.bb;
/*     */         }
/*     */         
/*     */         public PLACABLE getUndo() {
/* 513 */           return (PLACABLE)this.undo;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected CharSequence problem(int tx, int ty, boolean overwrite) {
/*     */     if (super.problem(tx, ty, overwrite) != null)
/*     */       return super.problem(tx, ty, overwrite); 
/*     */     if ((SETT.FLOOR()).getter.get(tx, ty) != null)
/*     */       return PlacableMessages.¤¤ROAD_ALREADY; 
/*     */     Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/*     */     if (t instanceof TGrowable) {
/*     */       TGrowable g = (TGrowable)t;
/*     */       if (g.job.is(tx, ty))
/*     */         return PLACABLE.E; 
/*     */       return null;
/*     */     } 
/*     */     return PlacableMessages.¤¤NOT_EDIBLE;
/*     */   }
/*     */   
/*     */   public void doSomethingExtraRender() {}
/*     */   
/*     */   public void hover(GBox box) {
/*     */     super.hover(box);
/*     */     if (!(SETT.WEATHER()).growthRipe.cropsAreRipe()) {
/*     */       box.NL();
/*     */       box.error(PlacableMessages.¤¤NOT_RIPE);
/*     */     } 
/*     */     Terrain.TerrainTile t = (Terrain.TerrainTile)SETT.TERRAIN().get((COORDINATE)this.coo);
/*     */     if (t instanceof TGrowable) {
/*     */       TGrowable g = (TGrowable)t;
/*     */       RESOURCE r = g.growable.resource;
/*     */       box.NL();
/*     */       box.add((SPRITE)r.icon());
/*     */       box.add((SPRITE)GFORMAT.iofk(box.text(), g.resource.get((COORDINATE)this.coo), g.size.get((COORDINATE)this.coo)));
/*     */     } 
/*     */   }
/*     */   
/*     */   void cancel(int tx, int ty) {
/*     */     Terrain.TerrainTile t = (Terrain.TerrainTile)SETT.TERRAIN().get((COORDINATE)this.coo);
/*     */     if (t instanceof TGrowable)
/*     */       ((TGrowable)t).job.set(tx, ty, false); 
/*     */   }
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ri) {
/*     */     Terrain.TerrainTile t = (Terrain.TerrainTile)SETT.TERRAIN().get((COORDINATE)this.coo);
/*     */     if (t instanceof TGrowable) {
/*     */       TGrowable g = (TGrowable)t;
/*     */       boolean has = (g.resource.get((COORDINATE)this.coo) > 0);
/*     */       g.resource.increment((COORDINATE)this.coo, -1);
/*     */       if (g.resource.get((COORDINATE)this.coo) == 0) {
/*     */         PlacerDelete.place(this.coo.x(), this.coo.y());
/*     */         t = (Terrain.TerrainTile)SETT.TERRAIN().get((COORDINATE)this.coo);
/*     */         if (t instanceof TGrowable) {
/*     */           TGrowable b = (TGrowable)t;
/*     */           b.job.set(this.coo.x(), this.coo.y(), true);
/*     */         } 
/*     */       } else {
/*     */         (SETT.JOBS()).state.set(StateManager.State.RESERVABLE, this);
/*     */       } 
/*     */       if (has) {
/*     */         GAME.player().res().inc(g.growable.resource, FResources.RTYPE.PRODUCED, 1);
/*     */         return g.growable.resource;
/*     */       } 
/*     */       return null;
/*     */     } 
/*     */     PlacerDelete.place(this.coo.x(), this.coo.y());
/*     */     return null;
/*     */   }
/*     */   
/*     */   void renderAbove(SPRITE_RENDERER r, int x, int y, int mask, int tx, int ty) {
/*     */     (SPRITES.cons()).ICO.scratch.render(r, x, y);
/*     */   }
/*     */   
/*     */   public boolean needsRipe() {
/*     */     return true;
/*     */   }
/*     */   
/*     */   public PlacableMulti placer() {
/*     */     return this.foodPlacer;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobClears$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */