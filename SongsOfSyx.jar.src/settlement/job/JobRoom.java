/*     */ package settlement.job;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.thing.ThingsResources;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class JobRoom
/*     */   extends Job
/*     */ {
/*  32 */   private static CharSequence ¤¤clearTerrain = "Clearing Terrain";
/*  33 */   private static CharSequence ¤¤clearVegetation = "Clearing Terrain";
/*  34 */   private static CharSequence ¤¤getting = "Getting Materials";
/*  35 */   private static CharSequence ¤¤constructing = "Constructing"; private PSTATE state;
/*  36 */   private static CharSequence ¤¤removing = "Removing Obstacle";
/*     */   static {
/*  38 */     D.ts(JobRoom.class);
/*     */   }
/*     */   
/*     */   private ROOM_JOBBER r;
/*     */   private final RESOURCE res;
/*     */   
/*  44 */   private enum PSTATE { CLEAR_TERRAIN((String)JobRoom.¤¤clearTerrain), CLEAR_VEG((String)JobRoom.¤¤clearVegetation), REMOVING((String)JobRoom.¤¤removing), FETCHING(
/*  45 */       (String)JobRoom.¤¤getting), DOING((String)JobRoom.¤¤constructing);
/*     */     
/*     */     final CharSequence name;
/*     */     
/*     */     PSTATE(CharSequence name) {
/*  50 */       this.name = name;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  58 */   private final SoundRace sound = AUDIO.race("BUILD");
/*     */ 
/*     */   
/*     */   JobRoom(RESOURCE res) {
/*  62 */     super("ROOM_" + ((res == null) ? "NONE" : res.key), "work", (SPRITE)(SPRITES.icons()).m.questionmark);
/*  63 */     this.res = res;
/*     */   }
/*     */ 
/*     */   
/*     */   void init(int tx, int ty) {
/*  68 */     (SETT.JOBS()).progress.set(tx + ty * SETT.TWIDTH, 0);
/*  69 */     (SETT.JOBS()).wantsRes.set(tx + ty * SETT.TWIDTH, (getState(tx, ty) == PSTATE.FETCHING));
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean get(int tx, int ty) {
/*  74 */     this.state = getState(tx, ty);
/*  75 */     Room room = (SETT.ROOMS()).map.get(tx, ty);
/*  76 */     if (room == null || !(room instanceof ROOM_JOBBER))
/*  77 */       return false; 
/*  78 */     this.r = (ROOM_JOBBER)room;
/*  79 */     super.get(tx, ty);
/*  80 */     if ((SETT.JOBS()).wantsRes.get(this.tile)) {
/*  81 */       this.state = PSTATE.FETCHING;
/*  82 */     } else if (this.state == PSTATE.FETCHING) {
/*  83 */       this.state = PSTATE.CLEAR_VEG;
/*     */     } 
/*  85 */     return true;
/*     */   }
/*     */   
/*     */   private PSTATE getState(int tx, int ty) {
/*  89 */     if (((ROOM_JOBBER)(SETT.ROOMS()).map.get(tx, ty)).needsTerrainToBeCleared(tx, ty) && terrainNeedsClear(tx, ty))
/*  90 */       return PSTATE.CLEAR_TERRAIN; 
/*  91 */     if (((ROOM_JOBBER)(SETT.ROOMS()).map.get(tx, ty)).needsFertilityToBeCleared(tx, ty) && !(SETT.GRASS()).current.is(tx, ty, 0.0D))
/*  92 */       return PSTATE.CLEAR_VEG; 
/*  93 */     if (this.res != null)
/*  94 */       return PSTATE.FETCHING; 
/*  95 */     if (((ROOM_JOBBER)(SETT.ROOMS()).map.get(tx, ty)).becomesSolid(tx, ty) && (SETT.THINGS()).resources.get(tx, ty) != null) {
/*  96 */       return PSTATE.REMOVING;
/*     */     }
/*  98 */     return PSTATE.DOING;
/*     */   }
/*     */   
/*     */   boolean terrainNeedsClear(int tx, int ty) {
/* 102 */     return (SETT.TERRAIN().get(tx, ty).clearing().needs() && SETT.TERRAIN().get(tx, ty).clearing().can());
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
/*     */   public RESOURCE resourceCurrentlyNeeded() {
/* 114 */     if (this.state == PSTATE.FETCHING)
/* 115 */       return this.res; 
/* 116 */     return null;
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
/* 127 */     switch (this.state) {
/*     */       case null:
/* 129 */         if ((SETT.TERRAIN()).MOUNTAIN.is((COORDINATE)this.coo)) {
/* 130 */           return (SETT.JOBS()).clearss.tunnel.jobPerformTime(skill);
/*     */         }
/* 132 */         t = (Terrain.TerrainTile)SETT.TERRAIN().get((COORDINATE)this.coo);
/* 133 */         if (t.clearing().isEasilyCleared())
/* 134 */           return 2.0D; 
/* 135 */         return 20.0D;
/*     */       case CLEAR_VEG:
/* 137 */         return 2.0D;
/*     */       case REMOVING:
/* 139 */         return 0.0D;
/*     */       case FETCHING:
/* 141 */         return 0.0D;
/*     */       case DOING:
/* 143 */         return 10.0D;
/*     */     } 
/* 145 */     throw new RuntimeException();
/*     */   } public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/*     */     Terrain.TerrainTile t;
/*     */     ThingsResources.ScatteredResource ress;
/*     */     int tx, ty;
/*     */     ROOM_JOBBER j;
/* 151 */     if (!jobReservedIs(r)) {
/* 152 */       throw new RuntimeException("" + (SETT.JOBS()).state.is(this.coo, StateManager.State.RESERVED) + " " + (SETT.JOBS()).state.is(this.coo, StateManager.State.RESERVED) + " " + String.valueOf(r));
/*     */     }
/*     */     
/* 155 */     RESOURCE res = null;
/* 156 */     switch (this.state) {
/*     */       case null:
/* 158 */         if ((SETT.TERRAIN()).MOUNTAIN.is((COORDINATE)this.coo)) {
/* 159 */           res = (SETT.JOBS()).clearss.tunnelPerform((COORDINATE)this.coo); break;
/*     */         } 
/* 161 */         t = SETT.TERRAIN().get(this.tile);
/* 162 */         res = t.clearing().clear1(this.coo.x(), this.coo.y());
/*     */         break;
/*     */ 
/*     */       
/*     */       case CLEAR_VEG:
/* 167 */         (SETT.GRASS()).current.increment(this.coo.x(), this.coo.y(), -4.0D);
/*     */         break;
/*     */       case REMOVING:
/* 170 */         ress = (SETT.THINGS()).resources.get(this.coo.x(), this.coo.y());
/* 171 */         if (ress == null)
/*     */           break; 
/* 173 */         if (ress.findableReservedCanBe()) {
/* 174 */           ress.findableReserve();
/* 175 */           ress.resourcePickup();
/*     */         } else {
/* 177 */           ress.resourcePickup();
/*     */         } 
/* 179 */         res = ress.resource();
/*     */         break;
/*     */       default:
/* 182 */         tx = this.coo.x();
/* 183 */         ty = this.coo.y();
/* 184 */         j = this.r;
/* 185 */         PlacerDelete.place(tx, ty);
/* 186 */         j.jobFinsih(tx, ty, r, ram);
/* 187 */         if (!(SETT.JOBS()).getter.is(tx, ty))
/* 188 */           for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 189 */             DIR d = (DIR)DIR.ORTHO.get(di);
/* 190 */             if ((SETT.JOBS()).getter.is(tx, ty, d)) {
/* 191 */               (SETT.JOBS()).state.set((StateManager.State)(SETT.JOBS()).state.get(tx, ty, d), (Job)(SETT.JOBS()).getter.get(tx, ty, d));
/*     */             }
/*     */           }  
/* 194 */         return null;
/*     */     } 
/*     */     
/* 197 */     (SETT.JOBS()).wantsRes.set(this.tile, (getState(this.coo.x(), this.coo.y()) == PSTATE.FETCHING));
/*     */     
/* 199 */     get(this.coo.x(), this.coo.y());
/* 200 */     jobReserveCancel(r);
/* 201 */     if (res != null)
/* 202 */       GAME.player().res().inc(res, FResources.RTYPE.PRODUCED, 1); 
/* 203 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean becomesSolidNext() {
/* 209 */     return ((ROOM_JOBBER)(SETT.ROOMS()).map.get(this.coo.x(), this.coo.y())).becomesSolid(this.coo.x(), this.coo.y());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean becomesSolid() {
/* 214 */     return ((ROOM_JOBBER)(SETT.ROOMS()).map.get(this.coo.x(), this.coo.y())).becomesSolid(this.coo.x(), this.coo.y());
/*     */   }
/*     */ 
/*     */   
/*     */   public int jobResourcesNeeded(Humanoid skill) {
/* 219 */     return ((ROOM_JOBBER)(SETT.ROOMS()).map.get(this.coo.x(), this.coo.y())).totalResourcesNeeded(this.coo.x(), this.coo.y());
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 224 */     return this.state.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 229 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 236 */     switch (this.state) {
/*     */       case null:
/* 238 */         return ((Terrain.TerrainTile)SETT.TERRAIN().get((COORDINATE)this.coo)).clearing().sound(this.coo.x(), this.coo.y());
/*     */       case CLEAR_VEG:
/* 240 */         return (SETT.GRASS()).clearSound;
/*     */       case REMOVING:
/* 242 */         return null;
/*     */       case FETCHING:
/* 244 */         return null;
/*     */       case DOING:
/* 246 */         return this.sound;
/*     */     } 
/* 248 */     throw new RuntimeException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator i, int state) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public PlacableMulti placer() {
/* 258 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   void renderAbove(SPRITE_RENDERER r, int x, int y, int mask, int tx, int ty) {
/* 263 */     if (Debug.showRoom || getState(tx, ty) == PSTATE.CLEAR_TERRAIN) {
/* 264 */       (SPRITES.cons()).ICO.repair.render(r, x, y);
/*     */     }
/*     */   }
/*     */   
/*     */   public int resAmount() {
/* 269 */     return (this.res != null) ? 1 : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE res() {
/* 274 */     return this.res;
/*     */   }
/*     */ 
/*     */   
/*     */   public Terrain.TerrainTile becomes(int tx, int ty) {
/* 279 */     return (SETT.TERRAIN()).NADA;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobRoom.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */