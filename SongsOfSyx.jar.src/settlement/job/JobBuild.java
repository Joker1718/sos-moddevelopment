/*     */ package settlement.job;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.thing.THINGS;
/*     */ import settlement.thing.ThingsResources;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import view.tool.PlacableMessages;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class JobBuild
/*     */   extends Job
/*     */ {
/*  28 */   private static CharSequence ¤¤clearTerrain = "Clearing Terrain";
/*  29 */   private static CharSequence ¤¤clearVegetation = "Clearing Terrain";
/*  30 */   private static CharSequence ¤¤getting = "Getting Materials";
/*  31 */   private static CharSequence ¤¤constructing = "Constructing"; private PSTATE state;
/*  32 */   private static CharSequence ¤¤removing = "Removing Obstacle";
/*     */   static {
/*  34 */     D.ts(JobBuild.class);
/*     */   }
/*     */   
/*     */   private final boolean solid;
/*     */   Placer placer;
/*     */   
/*  40 */   private enum PSTATE { CLEAR_TERRAIN((String)JobBuild.¤¤clearTerrain),
/*  41 */     CLEAR_VEG((String)JobBuild.¤¤clearVegetation),
/*  42 */     REMOVING((String)JobBuild.¤¤removing),
/*  43 */     FETCHING((String)JobBuild.¤¤getting),
/*  44 */     CONSTRUCTING((String)JobBuild.¤¤constructing);
/*     */     
/*     */     final CharSequence name;
/*     */     
/*     */     PSTATE(CharSequence name) {
/*  49 */       this.name = name;
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean needsFerClear = true;
/*     */ 
/*     */   
/*     */   protected final RESOURCE res;
/*     */   
/*     */   protected final int resAmount;
/*     */ 
/*     */   
/*     */   JobBuild(String key, RESOURCE res, int resAmount, boolean solid, CharSequence name, CharSequence desc, SPRITE icon) {
/*  63 */     super(key, name, icon);
/*  64 */     this.res = res;
/*  65 */     if (res == null)
/*  66 */       resAmount = 0; 
/*  67 */     this.resAmount = resAmount;
/*  68 */     this.solid = solid;
/*  69 */     this.placer = new Placer(this, res, resAmount, desc);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void init(int tx, int ty) {
/*  75 */     (SETT.JOBS()).progress.set(tx + ty * SETT.TWIDTH, 0);
/*  76 */     (SETT.JOBS()).wantsRes.set(tx + ty * SETT.TWIDTH, false);
/*  77 */     if (this.res != null) {
/*  78 */       for (THINGS.Thing t : SETT.THINGS().get(tx, ty)) {
/*  79 */         if (t instanceof ThingsResources.ScatteredResource) {
/*  80 */           ThingsResources.ScatteredResource tt = (ThingsResources.ScatteredResource)t;
/*  81 */           if (tt.resource() == this.res) {
/*  82 */             int a = tt.amount() - tt.amountReserved();
/*  83 */             if (a >= this.resAmount) {
/*  84 */               tt.removeUnreserved(this.resAmount);
/*  85 */               (SETT.JOBS()).progress.set(tx + ty * SETT.TWIDTH, this.resAmount); break;
/*     */             } 
/*  87 */             if (a > 0) {
/*  88 */               (SETT.JOBS()).progress.set(tx + ty * SETT.TWIDTH, a);
/*  89 */               tt.removeUnreserved(a);
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*  97 */     (SETT.JOBS()).wantsRes.set(tx + ty * SETT.TWIDTH, (getStateP(tx, ty) == PSTATE.FETCHING));
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE res() {
/* 102 */     return this.res;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE resourceCurrentlyNeeded() {
/* 107 */     if (this.state == PSTATE.FETCHING)
/* 108 */       return this.res; 
/* 109 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected CharSequence problem(int tx, int ty, boolean overwrite) {
/* 115 */     if (super.problem(tx, ty, overwrite) != null)
/* 116 */       return super.problem(tx, ty, overwrite); 
/* 117 */     if (SETT.TERRAIN().get(tx, ty).clearing().isStructure())
/* 118 */       return PlacableMessages.¤¤STRUCTURE_BLOCK; 
/* 119 */     if ((SETT.PATH()).solidity.is(tx, ty))
/* 120 */       return PlacableMessages.¤¤SOLID_BLOCK; 
/* 121 */     Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/*     */     
/* 123 */     if (t.clearing().needs() && !t.clearing().can()) {
/* 124 */       return PlacableMessages.¤¤MISC;
/*     */     }
/* 126 */     if (becomesSolid() && !(SETT.TERRAIN()).MOUNTAIN.isMountain(tx, ty))
/* 127 */       return null; 
/* 128 */     if (t.clearing().isStructure()) {
/* 129 */       return PlacableMessages.¤¤STRUCTURE_BLOCK;
/*     */     }
/* 131 */     return null;
/*     */   }
/*     */   
/*     */   private PSTATE getState(int tx, int ty) {
/* 135 */     PSTATE s = getStateP(tx, ty);
/* 136 */     if (s == PSTATE.FETCHING) {
/* 137 */       (SETT.JOBS()).wantsRes.set(tx + ty * SETT.TWIDTH, true);
/*     */     }
/* 139 */     if (resNeeds(tx, ty) && (SETT.JOBS()).wantsRes.get(tx + ty * SETT.TWIDTH)) {
/* 140 */       s = PSTATE.FETCHING;
/*     */     }
/* 142 */     return s;
/*     */   }
/*     */   
/*     */   private PSTATE getStateP(int tx, int ty) {
/* 146 */     if (this.needsFerClear && terrainNeedsClear(tx, ty))
/* 147 */       return PSTATE.CLEAR_TERRAIN; 
/* 148 */     if (this.needsFerClear && (SETT.GRASS()).current.get(tx, ty) > 0.0D)
/* 149 */       return PSTATE.CLEAR_VEG; 
/* 150 */     if (resNeeds(tx, ty))
/* 151 */       return PSTATE.FETCHING; 
/* 152 */     if (this.solid && (SETT.THINGS()).resources.has(tx, ty, RBIT.ALL)) {
/* 153 */       return PSTATE.REMOVING;
/*     */     }
/* 155 */     return PSTATE.CONSTRUCTING;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean get(int tx, int ty) {
/* 160 */     this.state = getState(tx, ty);
/* 161 */     return super.get(tx, ty);
/*     */   }
/*     */   
/*     */   boolean terrainNeedsClear(int tx, int ty) {
/* 165 */     return (SETT.TERRAIN().get(tx, ty).clearing().needs() && !SETT.TERRAIN().get(tx, ty).clearing().isStructure() && SETT.TERRAIN().get(tx, ty).clearing().can());
/*     */   }
/*     */   
/*     */   boolean resNeeds(int tx, int ty) {
/* 169 */     return (this.res != null && (SETT.JOBS()).progress.get(tx + ty * SETT.TWIDTH) < this.resAmount);
/*     */   }
/*     */ 
/*     */   
/*     */   public int jobResourcesNeeded(Humanoid skill) {
/* 174 */     if (this.res != null)
/* 175 */       return this.resAmount - (SETT.JOBS()).progress.get(this.tile); 
/* 176 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/*     */     Terrain.TerrainTile t;
/* 187 */     switch (this.state) {
/*     */       case null:
/* 189 */         t = (Terrain.TerrainTile)SETT.TERRAIN().get((COORDINATE)this.coo);
/* 190 */         if (t.clearing().isEasilyCleared())
/* 191 */           return 7.0D; 
/* 192 */         return 15.0D;
/*     */       case CLEAR_VEG:
/* 194 */         return 2.0D;
/*     */       case REMOVING:
/* 196 */         return 0.0D;
/*     */       case FETCHING:
/* 198 */         return 0.0D;
/*     */       case CONSTRUCTING:
/* 200 */         return constructionTime(skill);
/*     */     } 
/* 202 */     throw new RuntimeException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/*     */     Terrain.TerrainTile t;
/*     */     ThingsResources.ScatteredResource ress;
/* 210 */     if (!jobReservedIs(r)) {
/* 211 */       throw new RuntimeException();
/*     */     }
/* 213 */     RESOURCE res = null;
/* 214 */     switch (this.state) {
/*     */       case null:
/* 216 */         t = SETT.TERRAIN().get(this.tile);
/* 217 */         res = t.clearing().clear1(this.coo.x(), this.coo.y());
/*     */         break;
/*     */       case CLEAR_VEG:
/* 220 */         (SETT.GRASS()).currentI.increment(this.coo.x(), this.coo.y(), -4);
/*     */         break;
/*     */       case REMOVING:
/* 223 */         ress = (SETT.THINGS()).resources.get(this.coo.x(), this.coo.y());
/* 224 */         if (ress == null)
/*     */           break; 
/* 226 */         if (ress.findableReservedCanBe()) {
/* 227 */           ress.findableReserve();
/* 228 */           ress.resourcePickup();
/*     */         } else {
/* 230 */           ress.resourcePickup();
/*     */         } 
/* 232 */         res = ress.resource();
/*     */         break;
/*     */       case FETCHING:
/* 235 */         (SETT.JOBS()).progress.set(this.coo.x() + this.coo.y() * SETT.TWIDTH, (SETT.JOBS()).progress.get(this.coo.x() + this.coo.y() * SETT.TWIDTH) + rAm);
/*     */         break;
/*     */       case CONSTRUCTING:
/* 238 */         if (!construct(this.coo.x(), this.coo.y())) {
/* 239 */           PlacerDelete.place(this.coo.x(), this.coo.y());
/* 240 */           return res;
/*     */         } 
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 247 */     get(this.coo.x(), this.coo.y());
/* 248 */     jobReserveCancel(r);
/* 249 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean becomesSolidNext() {
/* 257 */     return (this.solid && this.state == PSTATE.CONSTRUCTING);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean becomesSolid() {
/* 262 */     return this.solid;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 269 */     return this.state.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 274 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 279 */     switch (this.state) {
/*     */       case null:
/* 281 */         return ((Terrain.TerrainTile)SETT.TERRAIN().get((COORDINATE)this.coo)).clearing().sound(this.coo.x(), this.coo.y());
/*     */       case CLEAR_VEG:
/* 283 */         return (SETT.GRASS()).clearSound;
/*     */       case REMOVING:
/* 285 */         return null;
/*     */       case FETCHING:
/* 287 */         return null;
/*     */       case CONSTRUCTING:
/* 289 */         return constructSound();
/*     */     } 
/* 291 */     throw new RuntimeException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i, int state) {
/* 299 */     if (state > 0 && this.res != null) {
/* 300 */       this.res.renderLaying((SPRITE_RENDERER)r, i.x(), i.y(), i.ran(), state);
/* 301 */       shadowBatch.setHeight(1).setDistance2Ground(0.0D);
/* 302 */       this.res.renderLaying((SPRITE_RENDERER)shadowBatch, i.x(), i.y(), i.ran(), state);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void cancel(int tx, int ty) {
/* 308 */     if ((SETT.JOBS()).progress.get(tx + ty * SETT.TWIDTH) > 0) {
/* 309 */       (SETT.THINGS()).resources.create(tx, ty, this.res, (SETT.JOBS()).progress.get(tx + ty * SETT.TWIDTH));
/*     */     }
/*     */   }
/*     */   
/*     */   public PlacableMulti placer() {
/* 314 */     return this.placer;
/*     */   }
/*     */ 
/*     */   
/*     */   public int resAmount() {
/* 319 */     return this.resAmount;
/*     */   }
/*     */   
/*     */   protected abstract double constructionTime(Humanoid paramHumanoid);
/*     */   
/*     */   protected abstract boolean construct(int paramInt1, int paramInt2);
/*     */   
/*     */   protected abstract SoundRace constructSound();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuild.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */