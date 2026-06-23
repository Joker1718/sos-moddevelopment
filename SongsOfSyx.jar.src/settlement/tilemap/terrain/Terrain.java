/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.type.TERRAIN;
/*     */ import init.type.TERRAINS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.thing.pointlight.LOS;
/*     */ import settlement.tilemap.TileMap;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.map.MAP_INTE;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.gui.misc.GBox;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.MAPSAVE;
/*     */ import util.keymap.RMAP;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Terrain
/*     */   extends TileMap.Resource
/*     */   implements MAP_OBJECT<Terrain.TerrainTile>
/*     */ {
/*  52 */   private final int NOTHING_CODE = 0;
/*  53 */   private final byte[] tiles = Alloc.bb(SETT.TAREA);
/*     */   
/*  55 */   private final short[] datad = new short[SETT.TAREA];
/*  56 */   private final ArrayList<TerrainTile> look = new ArrayList(256);
/*  57 */   public final TIndoors indoors = new TIndoors();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   public final TerrainTile NADA = new TNothing(this);
/*  63 */   public final TColors colors = new TColors();
/*  64 */   public final TDestroyed DESTROYED = new TDestroyed(this);
/*  65 */   public final TWater WATER = new TWater(this);
/*  66 */   public final TMountain MOUNTAIN = TMountain.make(this);
/*  67 */   public final TMountain.Ceiling CAVE = this.MOUNTAIN.CAVE;
/*  68 */   public final TRock ROCK = new TRock(this);
/*  69 */   public final TForest TREES = new TForest(this);
/*  70 */   public final TFlower FLOWER = new TFlower(this);
/*  71 */   public final TBush BUSH = new TBush(this);
/*  72 */   public final TMushroom MUSHROOM = new TMushroom(this);
/*  73 */   public final LIST<TGrowable> GROWABLES = TGrowable.make(this);
/*  74 */   public final RMAP<TFortification> FORTIFICATIONS = TFortification.make(this);
/*  75 */   public final TFortification.Stairs FSTAIRS = TFortification.Stairs.make(this);
/*  76 */   public final TBuilding.TBuildings BUILDINGS = new TBuilding.TBuildings(this);
/*  77 */   public final RMAP<TFence> FENCES = TFence.get(this);
/*  78 */   public final TerrainDiagonal diagonal = new TerrainDiagonal();
/*     */   
/*  80 */   public final TDecor DECOR_BEACH = new TDecor(this, "Beach object", "BEACH_1X1");
/*  81 */   public final TDecor DECOR_MID = new TDecor(this, "", "MID_FERTILITY_1X1");
/*  82 */   public final TDecor DECOR_WOOD = new TDecor(this, "", "WOOD_1X1");
/*  83 */   public final TDecor DECOR_NO = new TDecor(this, "", "INFERTILE_1X1");
/*     */   
/*  85 */   private final int[] counts = Alloc.ii(this.look.size());
/*     */   
/*     */   public final TILE_SHEET wall_merge;
/*     */   
/*  89 */   public final MAP_OBJECT<TerrainClearing> clearing = new MAP_OBJECT<TerrainClearing>()
/*     */     {
/*     */       public TerrainClearing get(int tile)
/*     */       {
/*  93 */         return Terrain.this.get(tile).clearing();
/*     */       }
/*     */ 
/*     */       
/*     */       public TerrainClearing get(int tx, int ty) {
/*  98 */         return get(tx + ty * SETT.TWIDTH);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/* 104 */   final MAP_INTE data = new MAP_INTE()
/*     */     {
/*     */       public MAP_INTE set(int tile, int value)
/*     */       {
/* 108 */         if ((value & 0xFFFF0000) != 0)
/* 109 */           throw new RuntimeException(); 
/* 110 */         Terrain.this.datad[tile] = (short)value;
/*     */         
/* 112 */         return this;
/*     */       }
/*     */ 
/*     */       
/*     */       public int get(int tile) {
/* 117 */         return Terrain.this.datad[tile] & 0xFFFF;
/*     */       }
/*     */ 
/*     */       
/*     */       public int get(int tx, int ty) {
/* 122 */         return get(tx + ty * SETT.TWIDTH);
/*     */       }
/*     */ 
/*     */       
/*     */       public MAP_INTE set(int tx, int ty, int value) {
/* 127 */         return set(tx + ty * SETT.TWIDTH, value);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   public Terrain(TileMap creator) throws IOException {
/* 134 */     PATH path = PATHS.SPRITE_SETTLEMENT().getFolder("map");
/*     */     
/* 136 */     this.wall_merge = (new ComposerThings.ITileSheet(path.get("WallMerge"), 152, 28)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 140 */           ComposerDests.Tile t = d.s16;
/* 141 */           s.full.init(0, 0, 1, 1, 4, 1, t);
/* 142 */           s.full.setSkip(4, 0).paste(true);
/* 143 */           s.full.setSkip(4, 0).pasteRotated(3, true);
/*     */           
/* 145 */           return t.saveGame();
/*     */         }
/* 148 */       }).get();
/*     */     
/* 150 */     KeyMap<TerrainTile> map = new KeyMap();
/* 151 */     for (TerrainTile t : all()) {
/* 152 */       map.put(t.key(), t);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/* 159 */     MAPSAVE.saveMeta(saveFile, (LIST)this.look);
/* 160 */     saveFile.bs(this.tiles);
/* 161 */     saveFile.ss(this.datad);
/* 162 */     saveFile.isE(this.counts);
/* 163 */     this.WATER.groundWater.save(saveFile);
/* 164 */     this.WATER.groundWaterSalt.save(saveFile);
/* 165 */     this.WATER.deepSeaFishSpot.save(saveFile);
/* 166 */     this.WATER.fishAmount.save(saveFile);
/* 167 */     this.indoors.saver.save(saveFile);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {
/* 173 */     int[] order = MAPSAVE.saveWash(saveFile, (LIST)this.look, 0);
/* 174 */     saveFile.bs(this.tiles);
/* 175 */     saveFile.ss(this.datad);
/* 176 */     saveFile.isE(this.counts);
/* 177 */     this.WATER.groundWater.load(saveFile);
/* 178 */     this.WATER.groundWaterSalt.load(saveFile);
/* 179 */     this.WATER.deepSeaFishSpot.load(saveFile);
/* 180 */     this.WATER.fishAmount.load(saveFile);
/* 181 */     this.indoors.saver.load(saveFile);
/*     */ 
/*     */     
/* 184 */     this.colors.init();
/* 185 */     if (order != null) {
/* 186 */       Arrays.fill(this.counts, 0);
/* 187 */       this.counts[0] = SETT.TAREA;
/* 188 */       this.indoors.saver.clear();
/* 189 */       for (int i = 0; i < this.tiles.length; i++) {
/* 190 */         this.tiles[i] = (byte)order[this.tiles[i]];
/* 191 */         this.counts[this.tiles[i]] = this.counts[this.tiles[i]] + 1;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clearAll() {
/* 199 */     for (int i = 0; i < this.tiles.length; i++) {
/* 200 */       this.tiles[i] = 0;
/* 201 */       this.datad[i] = 0;
/*     */     } 
/* 203 */     Arrays.fill(this.counts, 0);
/* 204 */     this.counts[0] = SETT.TAREA;
/* 205 */     this.indoors.saver.clear();
/* 206 */     this.colors.init();
/* 207 */     this.WATER.groundWater.clear();
/* 208 */     this.WATER.groundWaterSalt.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler profiler) {
/* 213 */     profiler.logStart(this.WATER);
/* 214 */     this.WATER.update(ds);
/* 215 */     profiler.logEnd(this.WATER);
/* 216 */     profiler.logStart(this.TREES);
/* 217 */     this.TREES.update(ds);
/* 218 */     profiler.logEnd(this.TREES);
/* 219 */     profiler.logStart(this.colors);
/* 220 */     this.colors.update(ds);
/* 221 */     profiler.logEnd(this.colors);
/* 222 */     profiler.logStart(this.BUSH);
/* 223 */     this.BUSH.update(ds);
/* 224 */     profiler.logEnd(this.BUSH);
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
/*     */   
/*     */   public LIST<TerrainTile> all() {
/* 237 */     return (LIST<TerrainTile>)this.look;
/*     */   }
/*     */ 
/*     */   
/*     */   public TerrainTile get(int tx, int ty) {
/* 242 */     if (SETT.IN_BOUNDS(tx, ty))
/* 243 */       return (TerrainTile)this.look.get(this.tiles[ty * SETT.TWIDTH + tx] & 0xFF); 
/* 244 */     return this.NADA;
/*     */   }
/*     */ 
/*     */   
/*     */   public TerrainTile get(int tile) {
/* 249 */     return (TerrainTile)this.look.get(this.tiles[tile] & 0xFF);
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAbove(Renderer r, ShadowBatch shadowBatch, RenderData data) {
/* 254 */     RenderData.RenderIterator i = data.onScreenTiles(2, 2, 2, 2);
/*     */     
/* 256 */     while (i.has()) {
/*     */ 
/*     */       
/* 259 */       int t = this.tiles[i.tile()];
/* 260 */       int d = this.datad[i.tile()];
/* 261 */       if (((TerrainTile)this.look.get(t)).renderAbove((SPRITE_RENDERER)r, shadowBatch, i, d)) {
/* 262 */         i.hiddenSet();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 269 */       i.next();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderBelow(Renderer r, ShadowBatch shadowBatch, RenderData data) {
/* 276 */     RenderData.RenderIterator i = data.onScreenTiles(1, 0, 1, 0);
/* 277 */     COLOR.unbind();
/* 278 */     OPACITY.unbind();
/* 279 */     while (i.has()) {
/* 280 */       int t = this.tiles[i.tile()];
/* 281 */       int d = this.datad[i.tile()];
/* 282 */       if (((TerrainTile)this.look.get(t)).renderBelow((SPRITE_RENDERER)r, shadowBatch, i, d))
/* 283 */         i.hiddenSet(); 
/* 284 */       i.next();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderMid(Renderer r, ShadowBatch shadowBatch, RenderData data) {
/* 291 */     RenderData.RenderIterator i = data.onScreenTiles(0, 0, 0, 0);
/* 292 */     COLOR.unbind();
/* 293 */     OPACITY.unbind();
/* 294 */     while (i.has()) {
/* 295 */       int t = this.tiles[i.tile()];
/* 296 */       int d = this.datad[i.tile()];
/* 297 */       if (((TerrainTile)this.look.get(t)).renderMid((SPRITE_RENDERER)r, shadowBatch, i, d))
/* 298 */         i.hiddenSet(); 
/* 299 */       i.next();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static abstract class TerrainTile
/*     */     implements GAMETILE, MAP_BOOLEAN, TileMap.SMinimapGetter, MAPPED
/*     */   {
/*     */     public final int code;
/*     */     private final CharSequence name;
/*     */     protected final COLOR miniC;
/*     */     protected final Terrain shared;
/*     */     private final SPRITE icon;
/*     */     private final String key;
/*     */     
/*     */     protected TerrainTile(String key, Terrain shared, CharSequence name, SPRITE icon, COLOR miniC) {
/* 314 */       this.shared = shared;
/* 315 */       this.code = shared.look.add(this);
/* 316 */       this.name = name;
/* 317 */       this.miniC = (miniC != null) ? (COLOR)miniC.shade(0.5D) : null;
/* 318 */       this.icon = icon;
/* 319 */       this.key = key;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract boolean place(int param1Int1, int param1Int2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void placeRaw(int x, int y) {
/* 333 */       if (SETT.IN_BOUNDS(x, y)) {
/* 334 */         this.shared.counts[this.shared.tiles[y * SETT.TWIDTH + x]] = this.shared.counts[this.shared.tiles[y * SETT.TWIDTH + x]] - 1;
/* 335 */         this.shared.tiles[y * SETT.TWIDTH + x] = (byte)this.code;
/* 336 */         this.shared.counts[this.code] = this.shared.counts[this.code] + 1;
/*     */         
/* 338 */         this.shared.data.set(x, y, 0);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public COLOR miniC(int x, int y) {
/* 344 */       return this.miniC;
/*     */     }
/*     */ 
/*     */     
/*     */     public COLOR miniColorPimped(ColorImp c, int x, int y, boolean northern, boolean southern) {
/* 349 */       return this.miniC;
/*     */     }
/*     */ 
/*     */     
/*     */     public SPRITE getIcon() {
/* 354 */       return this.icon;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence name() {
/* 359 */       return this.name;
/*     */     }
/*     */     
/*     */     protected abstract boolean renderAbove(SPRITE_RENDERER param1SPRITE_RENDERER, ShadowBatch param1ShadowBatch, RenderData.RenderIterator param1RenderIterator, int param1Int);
/*     */     
/*     */     protected abstract boolean renderBelow(SPRITE_RENDERER param1SPRITE_RENDERER, ShadowBatch param1ShadowBatch, RenderData.RenderIterator param1RenderIterator, int param1Int);
/*     */     
/*     */     protected boolean renderMid(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 367 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean is(int tile) {
/* 373 */       return (this.shared.get(tile) == this);
/*     */     }
/*     */     
/*     */     boolean wallJoiner() {
/* 377 */       return false;
/*     */     }
/*     */     
/*     */     boolean wallIsWally() {
/* 381 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isMassiveWall() {
/* 385 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean roofIs() {
/* 393 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract AVAILABILITY getAvailability(int param1Int1, int param1Int2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public LOS los(int tx, int ty) {
/* 407 */       return LOS.OPEN;
/*     */     }
/*     */ 
/*     */     
/*     */     void unplace(int tx, int ty) {}
/*     */ 
/*     */     
/*     */     public void hoverInfo(GBox box, int tx, int ty) {
/* 415 */       box.textLL(this.name);
/*     */     }
/*     */     
/*     */     private void placeFixed(int tx, int ty, int it) {
/* 419 */       if (it > 128)
/*     */         return; 
/* 421 */       if (!SETT.IN_BOUNDS(tx, ty)) {
/*     */         return;
/*     */       }
/* 424 */       TerrainTile old = this.shared.get(tx, ty);
/* 425 */       old.unplace(tx, ty);
/*     */       
/* 427 */       boolean res = (SETT.TERRAIN()).indoors.remove(tx, ty);
/* 428 */       if (place(tx, ty) || old != this.shared.get(tx, ty)) {
/* 429 */         (SETT.TERRAIN()).indoors.add(tx, ty, res);
/* 430 */         if (old.miniC(tx, ty) != null || this.shared.get(tx, ty).miniC(tx, ty) != null)
/* 431 */           SETT.TILE_MAP().miniCUpdate(tx, ty); 
/* 432 */         (SETT.PATH()).availability.updateAvailability(tx, ty);
/*     */         
/* 434 */         for (int i = 0; i < DIR.ALL.size(); i++) {
/* 435 */           DIR d = (DIR)DIR.ALL.get(i);
/* 436 */           this.shared.get(tx + d.x(), ty + d.y()).placeFixed(tx + d.x(), ty + d.y(), it + 1);
/*     */         } 
/*     */       } else {
/* 439 */         (SETT.TERRAIN()).indoors.add(tx, ty, res);
/*     */       } 
/*     */       
/* 442 */       SETT.FLOOR().updateStructure(tx, ty);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void placeFixed(int tx, int ty) {
/* 450 */       placeFixed(tx, ty, 0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public TerrainClearing clearing() {
/* 456 */       return TerrainClearing.dummy;
/*     */     }
/*     */     
/*     */     public int miniDepth() {
/* 460 */       return 0;
/*     */     }
/*     */     
/*     */     public TERRAIN terrain(int tx, int ty) {
/* 464 */       return TERRAINS.NONE();
/*     */     }
/*     */     
/*     */     public int heightStart(int tx, int ty) {
/* 468 */       return 0;
/*     */     }
/*     */     public int heightEnd(int tx, int ty) {
/* 471 */       return 0;
/*     */     }
/*     */     
/*     */     public int heightEnt(int tx, int ty) {
/* 475 */       return 0;
/*     */     }
/*     */     
/*     */     public boolean coversCompletely(int tx, int ty) {
/* 479 */       return false;
/*     */     }
/*     */     
/*     */     public int count() {
/* 483 */       return (SETT.TERRAIN()).counts[this.code];
/*     */     }
/*     */ 
/*     */     
/*     */     public final int index() {
/* 488 */       return this.code;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String key() {
/* 493 */       return this.key;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean is(int tx, int ty) {
/* 498 */       return (SETT.IN_BOUNDS(tx, ty) && is(tx + ty * SETT.TWIDTH));
/*     */     }
/*     */     
/*     */     public boolean wantsFloorUnderneath(int tx, int ty) {
/* 502 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\Terrain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */