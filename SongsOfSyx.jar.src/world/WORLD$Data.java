/*     */ package world;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SuperSaver;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import world.army.AD;
/*     */ import world.battle.WBattles;
/*     */ import world.entity.WEntities;
/*     */ import world.log.WorldLog;
/*     */ import world.map.buildings.WorldBuildings;
/*     */ import world.map.fow.FOW;
/*     */ import world.map.landmark.WorldLandmarks;
/*     */ import world.map.pathing.WPATHING;
/*     */ import world.map.regions.WREGIONS;
/*     */ import world.map.regions.centre.WCentre;
/*     */ import world.map.road.WorldRoads;
/*     */ import world.map.terrain.WorldTerrain;
/*     */ import world.overlay.WorldOverlays;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Data
/*     */ {
/* 195 */   private final ArrayList<WORLD.WorldResource> resources = new ArrayList(100);
/*     */   
/*     */   private final RECTANGLE dim;
/*     */   private final RECTANGLE tDim;
/*     */   private final int tHeight;
/*     */   private final int tWidth;
/*     */   private final int height;
/*     */   private final int width;
/*     */   private final Sprites sprites;
/*     */   private final WorldTerrain terrain;
/*     */   private final WorldLandmarks landmarks;
/*     */   private final WEntities ENTITIES;
/*     */   private final WREGIONS areas;
/*     */   private final AD armies;
/*     */   private final WorldBuildings buildings;
/*     */   private final WorldMinimap minimap;
/*     */   private final WorldOverlays overlay;
/*     */   private final WorldRoads roads;
/*     */   private final WPATHING pathing;
/*     */   private final WorldGen stage;
/*     */   private final WCentre centre;
/*     */   private final Render render;
/*     */   private final FOW fow;
/*     */   private final WorldLog log;
/*     */   private final WBattles battles;
/*     */   private final RD rd;
/*     */   final SuperSaver<WORLD.WorldResource> saver;
/*     */   
/*     */   private Data(int tileSizeX, int tileSizeY) throws IOException {
/* 224 */     WORLD.w = this;
/* 225 */     this.tWidth = tileSizeX;
/* 226 */     this.tHeight = tileSizeY;
/*     */     
/* 228 */     if (this.tWidth > 512 || this.tHeight > 512) {
/* 229 */       throw new Errors.DataError("too big a map!");
/*     */     }
/* 231 */     this.width = this.tWidth * 64;
/* 232 */     this.height = this.tHeight * 64;
/* 233 */     this.tDim = (RECTANGLE)new Rec(0.0D, this.tWidth, 0.0D, this.tHeight);
/* 234 */     this.dim = (RECTANGLE)new Rec(0.0D, this.width, 0.0D, this.height);
/*     */     
/* 236 */     this.sprites = new Sprites();
/* 237 */     this.render = new Render(tileSizeX, tileSizeY);
/*     */     
/* 239 */     this.terrain = new WorldTerrain(paramWORLD);
/* 240 */     this.landmarks = new WorldLandmarks(paramWORLD);
/* 241 */     this.areas = new WREGIONS();
/* 242 */     this.centre = new WCentre();
/* 243 */     this.rd = new RD(null);
/* 244 */     this.armies = new AD(paramWORLD);
/* 245 */     this.buildings = new WorldBuildings();
/* 246 */     this.roads = new WorldRoads(paramWORLD);
/* 247 */     this.pathing = new WPATHING();
/* 248 */     this.ENTITIES = new WEntities(paramWORLD);
/* 249 */     this.fow = new FOW();
/* 250 */     this.minimap = new WorldMinimap(tileSizeX, tileSizeY);
/* 251 */     this.log = new WorldLog();
/* 252 */     this.overlay = new WorldOverlays();
/* 253 */     this.stage = new WorldGen(paramWORLD);
/* 254 */     this.battles = new WBattles();
/* 255 */     this.saver = new SuperSaver<WORLD.WorldResource>(getClass(), (LIST)this.resources)
/*     */       {
/*     */         protected String key(WORLD.WorldResource t)
/*     */         {
/* 259 */           return t.key;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void save(WORLD.WorldResource t, FilePutter f) {
/* 264 */           t.saver().save(f);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void load(WORLD.WorldResource t, FileGetter f) throws IOException {
/* 269 */           t.saver().load(f);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clear(WORLD.WorldResource t) {
/* 274 */           t.saver().clear();
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\WORLD$Data.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */