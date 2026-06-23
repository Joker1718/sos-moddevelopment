/*     */ package settlement.tilemap;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.CapitolArea;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AvailabilityListener;
/*     */ import settlement.thing.pointlight.LOS;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import settlement.tilemap.floor.Grass;
/*     */ import settlement.tilemap.floor.Snow;
/*     */ import settlement.tilemap.floor.TGrowth;
/*     */ import settlement.tilemap.generator.Generator;
/*     */ import settlement.tilemap.ground.Ground;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TileMap
/*     */   extends SETT.SettResource
/*     */ {
/*     */   public final Ground ground;
/*     */   public final Floors floors;
/*     */   public final Grass grass;
/*     */   public final Terrain topology;
/*     */   public final Snow snow;
/*     */   public final TGrowth growth;
/*     */   public final SettMarks marks;
/*     */   private final TerrainHotspots hotspots;
/*     */   private final SRenderer renderer;
/*     */   public final MinimapColorGetter minimap;
/*     */   
/*     */   public TileMap() throws IOException {
/*  48 */     super("TMAP", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Resource.resources.clear();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.hotspots = new TerrainHotspots();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     this.renderer = new SRenderer(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 154 */     this.minimap = new MinimapColorGetter(); this.ground = new Ground(this); this.grass = new Grass(); this.floors = new Floors(this); this.topology = new Terrain(this); this.growth = new TGrowth(this.topology); this.snow = new Snow(this); this.marks = new SettMarks();
/*     */   }
/*     */   protected void clear() { for (Resource r : Resource.resources) r.clearAll();  }
/* 157 */   protected void generate(CapitolArea area) { this.minimap.clear(); SETT.MINIMAP().setOpen(false); SETT.MINIMAP().setOpen(true); this.minimap.clear(); } protected void load(FileGetter saveFile) throws IOException { for (Resource r : Resource.resources) { saveFile.check(r); SPRITES.loader().print(r.toString()); r.load(saveFile); }  AvailabilityListener.listenAll(false); for (int y = 0; y < SETT.THEIGHT; y++) { for (int x = 0; x < SETT.TWIDTH; x++) (SETT.PATH()).availability.updateAvailability(x, y);  }  AvailabilityListener.listenAll(true); } protected void save(FilePutter saveFile) { for (Resource r : Resource.resources) { saveFile.mark(r); SPRITES.loader().print(r.toString()); r.save(saveFile); }  } protected void update(double ds, Profiler profiler) { for (Resource r : Resource.resources) { profiler.logStart(r); r.update(ds, profiler); profiler.logEnd(r); }  } protected void init(boolean loaded) { this.hotspots.init(); this.minimap.clear(); Generator.paintMinimap(); } public COLOR miniC(int tx, int ty) { return this.minimap.get(tx, ty); }
/*     */   public void renderAboveEnts(Renderer r, ShadowBatch s, float ds, int zoomout, RenderData renData) { this.renderer.renderAboveEnts(r, s, ds, zoomout, renData); }
/*     */   public void renderTheRest(Renderer r, ShadowBatch s, float ds, int zoomout, RenderData renData, RECTANGLE renWindow, int offX, int offY) { this.renderer.renderTheRest(r, s, ds, zoomout, renData, renWindow, offX, offY); }
/*     */   public void renderSemiMap(Renderer r, float ds, RenderData renData) { this.renderer.renderSemiMap(r, ds, renData); }
/* 161 */   public void renderMiniMap(Renderer r, float ds, RenderData renData, int zoomout) { this.renderer.renderMiniMap(r, ds, renData, zoomout); } protected void afterTick() { for (Resource r : Resource.resources) r.afterTick();  this.minimap.update(); } public TerrainHotspots hotspots() { return this.hotspots; } public void updateTileDay(int tx, int ty, int tile) { this.growth.updateTileDay(tx, ty, tile); } public void miniCUpdate(int tx, int ty) { this.minimap.update(tx, ty); }
/*     */ 
/*     */   
/*     */   public static abstract class Resource
/*     */   {
/* 166 */     private static final ArrayList<Resource> resources = new ArrayList(10);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 171 */     private final int index = resources.add(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract void save(FilePutter param1FilePutter);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract void load(FileGetter param1FileGetter) throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void update(double ds, Profiler profiler) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void afterTick() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract void clearAll();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LOS LOS(int tx, int ty) {
/* 211 */     return this.topology.get(tx, ty).los(tx, ty);
/*     */   }
/*     */   
/*     */   public static interface SMinimapGetter {
/*     */     COLOR miniC(int param1Int1, int param1Int2);
/*     */     
/*     */     COLOR miniColorPimped(ColorImp param1ColorImp, int param1Int1, int param1Int2, boolean param1Boolean1, boolean param1Boolean2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\TileMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */