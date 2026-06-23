/*     */ package world.map.terrain;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolManager;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldTerrain
/*     */   extends WORLD.WorldResource
/*     */ {
/*  20 */   private static final ArrayListGrower<WorldTerrainResource> resources = new ArrayListGrower();
/*     */   public final WorldClimate climate;
/*     */   public final WorldForest forest;
/*     */   public final WorldGround ground;
/*     */   public final WorldMountain mountain;
/*     */   public final WorldWater water;
/*     */   private final WORLD.WorldResourceManager saver;
/*     */   
/*     */   public WorldTerrain(WORLD world) throws IOException {
/*  29 */     super("terrain", "TERRAIN");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  38 */     this.saver = new WORLD.WorldResourceManager()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  42 */           for (WorldTerrain.WorldTerrainResource r : WorldTerrain.resources) {
/*  43 */             r.save(file);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  49 */           for (WorldTerrain.WorldTerrainResource r : WorldTerrain.resources) {
/*  50 */             r.load(file);
/*     */           }
/*     */         }
/*     */         
/*     */         public void clear() {
/*  55 */           for (WorldTerrain.WorldTerrainResource r : WorldTerrain.resources)
/*  56 */             r.clear(); 
/*  57 */           WORLD.MINIMAP().repaint();
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<PLACABLE> makePlacers(ToolManager tm) {
/*  62 */           ArrayListGrower<PLACABLE> res = new ArrayListGrower();
/*  63 */           for (WorldTerrain.WorldTerrainResource r : WorldTerrain.resources)
/*  64 */             res.add((Iterable)r.placers(tm)); 
/*  65 */           return (LIST<PLACABLE>)res;
/*     */         }
/*     */         
/*     */         public void validateInit(WORLD.WorldError error) {}
/*     */         
/*     */         public void generate(ACTION loadPrint) {}
/*     */       };
/*     */     resources.clear();
/*     */     this.climate = new WorldClimate();
/*     */     this.ground = new WorldGround();
/*     */     this.mountain = new WorldMountain();
/*     */     this.water = new WorldWater();
/*     */     this.forest = new WorldForest(world);
/*     */   }
/*     */   
/*     */   public WORLD.WorldResourceManager saver() {
/*  81 */     return this.saver;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void secretFixWays() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler prof) {
/*  91 */     for (WorldTerrainResource r : resources) {
/*  92 */       r.update(ds, prof);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static abstract class WorldTerrainResource
/*     */   {
/*     */     protected WorldTerrainResource() {
/* 100 */       WorldTerrain.resources.add(this);
/*     */     }
/*     */     
/*     */     protected abstract void save(FilePutter param1FilePutter);
/*     */     
/*     */     protected abstract void load(FileGetter param1FileGetter) throws IOException;
/*     */     
/*     */     protected void clear() {}
/*     */     
/*     */     protected void update(double ds, Profiler prof) {}
/*     */     
/*     */     public abstract LIST<PLACABLE> placers(ToolManager param1ToolManager);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\terrain\WorldTerrain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */