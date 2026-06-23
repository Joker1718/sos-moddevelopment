/*     */ package settlement.tilemap.floor;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import game.debug.Profiler;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.TileMap;
/*     */ import settlement.tilemap.ground.GroundType;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_DOUBLEE;
/*     */ import snake2d.util.map.MAP_INTE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import util.rendering.RenderData;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Grass
/*     */   extends TileMap.Resource
/*     */ {
/*  39 */   private final Bitsmap1D data = new Bitsmap1D(0, 4, SETT.TAREA);
/*     */   
/*  41 */   public final SoundRace clearSound = AUDIO.race("CLEAR_GRASS");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int TYPES = 15;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final double TYPESI = 0.06666666666666667D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final GrassRenderer renderer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final double[] treepenalty;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final OPACITY[] op;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_DOUBLEE current;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_INTE currentI;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void grow(int tx, int ty) {
/*  91 */     grow(tx, ty, 1 + RND.rInt(2));
/*     */   }
/*     */   public Grass() throws IOException {
/*  94 */     this
/*  95 */       .treepenalty = new double[] { 0.1D, 0.2D, 0.2D, 0.1D };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 148 */     this.op = new OPACITY[15];
/*     */     
/* 150 */     for (int i = 0; i < 15; i++) {
/* 151 */       int p = (int)(127.0D * (i + 1.0D) / 15.0D);
/* 152 */       this.op[i] = (OPACITY)new OpacityImp(p);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 190 */     this.current = (MAP_DOUBLEE)new MAP_DOUBLEE.DoubleMapImp(SETT.TWIDTH, SETT.THEIGHT)
/*     */       {
/*     */         public double get(int tile)
/*     */         {
/* 194 */           return Grass.this.data.get(tile) * 0.06666666666666667D;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tile, double value) {
/* 199 */           Grass.this.currentI.set(tile, (int)(value * 15.0D));
/* 200 */           return (MAP_DOUBLEE)this;
/*     */         }
/*     */       };
/*     */     
/* 204 */     this.currentI = (MAP_INTE)new MAP_INTE.INT_MAPEImp(SETT.TWIDTH, SETT.THEIGHT)
/*     */       {
/*     */         public int get(int tile)
/*     */         {
/* 208 */           return Grass.this.data.get(tile);
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_INTE set(int tile, int value) {
/* 213 */           value = CLAMP.i(value, 0, 15);
/* 214 */           Grass.this.data.set(tile, value);
/* 215 */           return (MAP_INTE)this;
/*     */         }
/*     */       };
/*     */     this.renderer = new GrassRenderer(this);
/*     */     final PlacableMulti ppu = new PlacableMulti("Remove") {
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/*     */           Grass.this.data.set(tx + ty * SETT.TWIDTH, CLAMP.i(Grass.this.data.get(tx + ty * SETT.TWIDTH) - 1, 0, 15));
/*     */         }
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*     */           return null;
/*     */         }
/*     */       };
/*     */     PlacableMulti pp = new PlacableMulti("Grass") {
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/*     */           Grass.this.data.set(tx + ty * SETT.TWIDTH, CLAMP.i(Grass.this.data.get(tx + ty * SETT.TWIDTH) + 1, 0, 15));
/*     */         }
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*     */           return null;
/*     */         }
/*     */         
/*     */         public PLACABLE getUndo() {
/*     */           return (PLACABLE)ppu;
/*     */         }
/*     */       };
/*     */     IDebugPanelSett.add((PLACABLE)pp);
/*     */   }
/*     */   
/*     */   public void grow(int tx, int ty, int amount) {
/*     */     int tile = tx + ty * SETT.TWIDTH;
/*     */     int b = growthMax(tx, ty);
/*     */     int c = this.data.get(tile);
/*     */     if (c < b) {
/*     */       c += amount;
/*     */       if (c > b)
/*     */         c = b; 
/*     */     } else if (c > b) {
/*     */       c -= amount;
/*     */       if (c < b)
/*     */         c = b; 
/*     */     } 
/*     */     this.data.set(tile, c);
/*     */   }
/*     */   
/*     */   public int growthMax(int tx, int ty) {
/*     */     GroundType t = (GroundType)(SETT.GROUND()).MAP.get(tx, ty);
/*     */     double v = (SETT.GROUND()).MOISTURE_CURRENT.get(tx, ty);
/*     */     v *= t.vegitation;
/*     */     if (t == (SETT.GROUND()).types.FOREST) {
/*     */       v *= 0.6D;
/*     */     } else if (t == (SETT.GROUND()).types.PASTURE) {
/*     */       v *= 0.8D;
/*     */     } 
/*     */     if (v > 0.4D)
/*     */       for (int i = 0; i < this.treepenalty.length; i++) {
/*     */         if ((SETT.TERRAIN()).TREES.isTree(tx, ty + i))
/*     */           v = CLAMP.d(v - this.treepenalty[i], 0.4D, v); 
/*     */       }  
/*     */     int b = CLAMP.i((int)(15.0D * v), 0, 15);
/*     */     return b;
/*     */   }
/*     */   
/*     */   protected void update(double ds, Profiler profiler) {
/*     */     this.renderer.update(ds);
/*     */   }
/*     */   
/*     */   public void render(double ds, Renderer r, RenderData data) {
/*     */     this.renderer.render(ds, r, data);
/*     */   }
/*     */   
/*     */   public void render(RenderData.RenderIterator it) {
/*     */     this.renderer.render(it, CORE.renderer());
/*     */   }
/*     */   
/*     */   public COLOR color(int ran) {
/*     */     return this.renderer.color(ran);
/*     */   }
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/*     */     this.data.save(saveFile);
/*     */   }
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {
/*     */     this.data.load(saveFile);
/*     */   }
/*     */   
/*     */   protected void clearAll() {
/*     */     this.data.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\floor\Grass.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */