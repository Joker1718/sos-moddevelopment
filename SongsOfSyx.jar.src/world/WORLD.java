/*     */ package world;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.debug.Profiler;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Errors;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.file.SuperSaver;
/*     */ import snake2d.util.map.MAP_DOUBLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolManager;
/*     */ import world.army.AD;
/*     */ import world.battle.WBattles;
/*     */ import world.entity.WEntities;
/*     */ import world.entity.haven.WHavens;
/*     */ import world.log.WorldLog;
/*     */ import world.map.buildings.WorldBuildings;
/*     */ import world.map.fow.FOW;
/*     */ import world.map.landmark.WorldLandmarks;
/*     */ import world.map.pathing.WPATHING;
/*     */ import world.map.regions.WREGIONS;
/*     */ import world.map.regions.centre.WCentre;
/*     */ import world.map.road.WorldRoads;
/*     */ import world.map.terrain.WorldClimate;
/*     */ import world.map.terrain.WorldForest;
/*     */ import world.map.terrain.WorldGround;
/*     */ import world.map.terrain.WorldMountain;
/*     */ import world.map.terrain.WorldTerrain;
/*     */ import world.map.terrain.WorldWater;
/*     */ import world.overlay.WorldOverlays;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ public class WORLD
/*     */   extends GAME.GameResource
/*     */ {
/*     */   private static Data w;
/*     */   
/*     */   public static int TWIDTH() {
/*  53 */     return w.tWidth;
/*     */   }
/*     */   
/*     */   public static int THEIGHT() {
/*  57 */     return w.tHeight;
/*     */   }
/*     */   
/*     */   public static RECTANGLE TBOUNDS() {
/*  61 */     return w.tDim;
/*     */   }
/*     */   
/*     */   public static RECTANGLE PIXELS() {
/*  65 */     return w.dim;
/*     */   }
/*     */   
/*     */   public static int PWIDTH() {
/*  69 */     return w.width;
/*     */   }
/*     */   
/*     */   public static int PHEIGHT() {
/*  73 */     return w.height;
/*     */   }
/*     */   
/*     */   public static int TAREA() {
/*  77 */     return w.tHeight * w.tWidth;
/*     */   }
/*     */   
/*     */   public static boolean IN_BOUNDS(int tx, int ty) {
/*  81 */     return w.tDim.holdsPoint(tx, ty);
/*     */   }
/*     */   
/*     */   public static boolean IN_BOUNDS(COORDINATE c, DIR d) {
/*  85 */     return IN_BOUNDS(c.x() + d.x(), c.y() + d.y());
/*     */   }
/*     */   
/*     */   public static boolean IN_BOUNDS(int tx, int ty, DIR d) {
/*  89 */     return IN_BOUNDS(tx + d.x(), ty + d.y());
/*     */   }
/*     */   
/*     */   public static WorldTerrain TERRAIN() {
/*  93 */     return w.terrain;
/*     */   }
/*     */   
/*     */   public static WorldMountain MOUNTAIN() {
/*  97 */     return w.terrain.mountain;
/*     */   }
/*     */   
/*     */   public static WorldWater WATER() {
/* 101 */     return w.terrain.water;
/*     */   }
/*     */   
/*     */   public static WorldGround GROUND() {
/* 105 */     return w.terrain.ground;
/*     */   }
/*     */   
/*     */   public static WorldForest FOREST() {
/* 109 */     return w.terrain.forest;
/*     */   }
/*     */   
/*     */   public static WEntities ENTITIES() {
/* 113 */     return w.ENTITIES;
/*     */   }
/*     */   
/*     */   public static WorldClimate CLIMATE() {
/* 117 */     return w.terrain.climate;
/*     */   }
/*     */   
/*     */   public static MAP_DOUBLE MOISTURE() {
/* 121 */     return w.terrain.ground.moisture;
/*     */   }
/*     */   
/*     */   public static WREGIONS REGIONS() {
/* 125 */     return w.areas;
/*     */   }
/*     */   
/*     */   public static AD ARMIES() {
/* 129 */     return w.armies;
/*     */   }
/*     */   
/*     */   public static WorldBuildings BUILDINGS() {
/* 133 */     return w.buildings;
/*     */   }
/*     */   
/*     */   public static WorldLandmarks LANDMARKS() {
/* 137 */     return w.landmarks;
/*     */   }
/*     */   
/*     */   public static WorldMinimap MINIMAP() {
/* 141 */     return w.minimap;
/*     */   }
/*     */   
/*     */   public static WorldOverlays OVERLAY() {
/* 145 */     return w.overlay;
/*     */   }
/*     */   
/*     */   public static Sprites sprites() {
/* 149 */     return w.sprites;
/*     */   }
/*     */   
/*     */   public static WHavens camps() {
/* 153 */     return w.ENTITIES.havens;
/*     */   }
/*     */   
/*     */   public static WorldGen GEN() {
/* 157 */     return w.stage;
/*     */   }
/*     */   
/*     */   public static WorldRoads ROADS() {
/* 161 */     return w.roads;
/*     */   }
/*     */   
/*     */   public static WPATHING PATH() {
/* 165 */     return w.pathing;
/*     */   }
/*     */   
/*     */   public static WCentre CENTRE() {
/* 169 */     return w.centre;
/*     */   }
/*     */   
/*     */   public static FOW FOW() {
/* 173 */     return w.fow;
/*     */   }
/*     */   
/*     */   public static WorldLog LOG() {
/* 177 */     return w.log;
/*     */   }
/*     */   
/*     */   public static WBattles BATTLES() {
/* 181 */     return w.battles;
/*     */   }
/*     */   
/*     */   public static RD RD() {
/* 185 */     return w.rd;
/*     */   }
/*     */ 
/*     */   
/*     */   public static LIST<WorldResource> RESOURCES() {
/* 190 */     return (LIST<WorldResource>)w.resources;
/*     */   }
/*     */   
/*     */   private final class Data
/*     */   {
/* 195 */     private final ArrayList<WORLD.WorldResource> resources = new ArrayList(100);
/*     */     
/*     */     private final RECTANGLE dim;
/*     */     private final RECTANGLE tDim;
/*     */     private final int tHeight;
/*     */     private final int tWidth;
/*     */     private final int height;
/*     */     private final int width;
/*     */     private final Sprites sprites;
/*     */     private final WorldTerrain terrain;
/*     */     private final WorldLandmarks landmarks;
/*     */     private final WEntities ENTITIES;
/*     */     private final WREGIONS areas;
/*     */     private final AD armies;
/*     */     private final WorldBuildings buildings;
/*     */     private final WorldMinimap minimap;
/*     */     private final WorldOverlays overlay;
/*     */     private final WorldRoads roads;
/*     */     private final WPATHING pathing;
/*     */     private final WorldGen stage;
/*     */     private final WCentre centre;
/*     */     private final Render render;
/*     */     private final FOW fow;
/*     */     private final WorldLog log;
/*     */     private final WBattles battles;
/*     */     private final RD rd;
/*     */     final SuperSaver<WORLD.WorldResource> saver;
/*     */     
/*     */     private Data(int tileSizeX, int tileSizeY) throws IOException {
/* 224 */       WORLD.w = this;
/* 225 */       this.tWidth = tileSizeX;
/* 226 */       this.tHeight = tileSizeY;
/*     */       
/* 228 */       if (this.tWidth > 512 || this.tHeight > 512) {
/* 229 */         throw new Errors.DataError("too big a map!");
/*     */       }
/* 231 */       this.width = this.tWidth * 64;
/* 232 */       this.height = this.tHeight * 64;
/* 233 */       this.tDim = (RECTANGLE)new Rec(0.0D, this.tWidth, 0.0D, this.tHeight);
/* 234 */       this.dim = (RECTANGLE)new Rec(0.0D, this.width, 0.0D, this.height);
/*     */       
/* 236 */       this.sprites = new Sprites();
/* 237 */       this.render = new Render(tileSizeX, tileSizeY);
/*     */       
/* 239 */       this.terrain = new WorldTerrain(WORLD.this);
/* 240 */       this.landmarks = new WorldLandmarks(WORLD.this);
/* 241 */       this.areas = new WREGIONS();
/* 242 */       this.centre = new WCentre();
/* 243 */       this.rd = new RD(null);
/* 244 */       this.armies = new AD(WORLD.this);
/* 245 */       this.buildings = new WorldBuildings();
/* 246 */       this.roads = new WorldRoads(WORLD.this);
/* 247 */       this.pathing = new WPATHING();
/* 248 */       this.ENTITIES = new WEntities(WORLD.this);
/* 249 */       this.fow = new FOW();
/* 250 */       this.minimap = new WorldMinimap(tileSizeX, tileSizeY);
/* 251 */       this.log = new WorldLog();
/* 252 */       this.overlay = new WorldOverlays();
/* 253 */       this.stage = new WorldGen(WORLD.this);
/* 254 */       this.battles = new WBattles();
/* 255 */       this.saver = new SuperSaver<WORLD.WorldResource>(getClass(), (LIST)this.resources)
/*     */         {
/*     */           protected String key(WORLD.WorldResource t)
/*     */           {
/* 259 */             return t.key;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void save(WORLD.WorldResource t, FilePutter f) {
/* 264 */             t.saver().save(f);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void load(WORLD.WorldResource t, FileGetter f) throws IOException {
/* 269 */             t.saver().load(f);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clear(WORLD.WorldResource t) {
/* 274 */             t.saver().clear();
/*     */           }
/*     */         };
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public WORLD(int tileSizeX, int tileSizeY) throws IOException {
/* 286 */     super("WORLD", false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/* 292 */     w.saver.save(saveFile);
/* 293 */     w.stage.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 298 */     w.saver.load(file);
/* 299 */     w.stage.load(file);
/*     */     
/* 301 */     if (SETT.exists()) {
/* 302 */       (SETT.WORLD_AREA()).info.initCity(SETT.WORLD_AREA().tiles().x1(), SETT.WORLD_AREA().tiles().y1());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler prof) {
/* 308 */     prof.logStart(WORLD.class);
/* 309 */     for (WorldResource r : w.resources) {
/* 310 */       r.update(ds, prof);
/*     */     }
/* 312 */     prof.logStart(w.minimap.getClass());
/* 313 */     w.minimap.update();
/* 314 */     prof.logEnd(w.minimap.getClass());
/* 315 */     prof.logEnd(WORLD.class);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void afterTick() {
/* 320 */     for (WorldResource r : w.resources) {
/* 321 */       r.afterTick();
/*     */     }
/* 323 */     w.battles.poll();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void initBeforePlay() {
/* 328 */     for (int i = 0; i < w.resources.size(); i++) {
/* 329 */       WorldResource r = (WorldResource)w.resources.get(i);
/* 330 */       r.initBeforePlay();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Renderer r, float ds, int zoomout, RECTANGLE renWindow, int offX, int offY) {
/* 336 */     w.render.render(r, ds, zoomout, renWindow, offX, offY);
/*     */   }
/*     */   
/*     */   public static abstract class WorldResource
/*     */   {
/*     */     public final CharSequence name;
/*     */     final String key;
/*     */     
/*     */     protected WorldResource(CharSequence name, String key) {
/* 345 */       this.name = name;
/* 346 */       WORLD.w.resources.add(this);
/* 347 */       this.key = key;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract WORLD.WorldResourceManager saver();
/*     */ 
/*     */ 
/*     */     
/*     */     protected void update(double ds, Profiler prof) {}
/*     */ 
/*     */ 
/*     */     
/*     */     protected void afterTick() {}
/*     */ 
/*     */     
/*     */     protected void afterRender() {}
/*     */ 
/*     */     
/*     */     protected void initBeforePlay() {}
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class WorldResourceManager
/*     */     implements SAVABLE
/*     */   {
/*     */     public void generate(ACTION loadPrint) {}
/*     */ 
/*     */     
/*     */     public void validateInit(WORLD.WorldError error) {}
/*     */ 
/*     */     
/*     */     public LIST<PLACABLE> makePlacers(ToolManager tm) {
/* 380 */       return (LIST<PLACABLE>)new ArrayListGrower();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void addDebugView() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void changeTile(int tx, int ty) {
/* 391 */     MINIMAP().update(tx, ty);
/*     */   }
/*     */   
/*     */   public static class WorldError {
/*     */     public WorldError() {
/* 396 */       this.coo = new Coo();
/* 397 */       this.problem = null;
/* 398 */       this.warning = null;
/*     */     }
/*     */     
/*     */     public final Coo coo;
/*     */     public CharSequence problem;
/*     */     public CharSequence warning;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\WORLD.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */