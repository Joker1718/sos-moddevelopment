/*     */ package settlement.job;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class JobClear
/*     */   extends Job
/*     */ {
/*     */   private final Placer placer;
/*     */   private final CharSequence names;
/*     */   
/*     */   JobClear(String key, CharSequence name, CharSequence desc, CharSequence verb, SPRITE icon) {
/*  35 */     super("CLEAR_" + key, name, icon);
/*  36 */     this.placer = new Placer(this, desc) {
/*  37 */         private final String jobs = "Jobs: ";
/*     */         
/*     */         public void placeInfo(GBox b, int okTiles, AREA a) {
/*  40 */           super.placeInfo(b, okTiles, a);
/*  41 */           if (okTiles > 0) {
/*  42 */             VIEW.hoverBox().add((SPRITE)VIEW.hoverBox().text().add("Jobs: ").add(okTiles));
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/*  48 */           return (LIST<CLICKABLE>)(SETT.JOBS()).clearss.butts;
/*     */         }
/*     */ 
/*     */         
/*     */         public void updateRegardless(GameWindow window, AREA selected) {
/*  53 */           (SETT.JOBS()).clearss.currentOverlay = JobClear.this.overlay();
/*  54 */           if (JobClear.this.overlay() != null && (SETT.JOBS()).clearss.overlay) {
/*  55 */             JobClear.this.overlay().add();
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  62 */     this.names = verb;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Addable overlay() {
/*  71 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int resAmount() {
/*  76 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/*  81 */     return 30.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/*  93 */     Terrain.TerrainTile t = (Terrain.TerrainTile)SETT.TERRAIN().get((COORDINATE)this.coo);
/*  94 */     if (!t.clearing().can()) {
/*  95 */       PlacerDelete.place(this.coo.x(), this.coo.y());
/*  96 */       return null;
/*     */     } 
/*  98 */     RESOURCE res = t.clearing().clear1(this.coo.x(), this.coo.y());
/*  99 */     if (res != null) {
/* 100 */       GAME.player().res().inc(res, FResources.RTYPE.PRODUCED, 1);
/*     */     }
/* 102 */     if (t != SETT.TERRAIN().get((COORDINATE)this.coo) || (SETT.TERRAIN()).NADA.is((COORDINATE)this.coo)) {
/* 103 */       PlacerDelete.place(this.coo.x(), this.coo.y());
/*     */     } else {
/* 105 */       (SETT.JOBS()).state.set(StateManager.State.RESERVABLE, this);
/*     */     } 
/*     */     
/* 108 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 114 */     return this.names;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 119 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 124 */     return ((Terrain.TerrainTile)SETT.TERRAIN().get((COORDINATE)this.coo)).clearing().sound(this.coo.x(), this.coo.y());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i, int state) {}
/*     */ 
/*     */ 
/*     */   
/*     */   void renderAbove(SPRITE_RENDERER r, int x, int y, int mask, int tx, int ty) {
/* 135 */     (SPRITES.cons()).ICO.clear.render(r, x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void init(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */   
/*     */   boolean becomesSolidNext() {
/* 146 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PlacableMulti placer() {
/* 152 */     return this.placer;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE resourceCurrentlyNeeded() {
/* 157 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Terrain.TerrainTile becomes(int tx, int ty) {
/* 162 */     return (SETT.TERRAIN()).NADA;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobClear.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */