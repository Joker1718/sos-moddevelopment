/*     */ package settlement.tilemap.floor;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import game.faction.player.PlayerColors;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.game.SheetType;
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lockable;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.tilemap.TileMap;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.CORE;
/*     */ import snake2d.Errors;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.map.MAP_CLEARER;
/*     */ import snake2d.util.map.MAP_DOUBLEE;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.MAPSAVE;
/*     */ import util.keymap.RMAP;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Floors
/*     */   extends TileMap.Resource
/*     */ {
/*  83 */   private static CharSequence ¤¤dName = "Country road"; private final ArrayList<Floor> all; private final RFloorExtra extra; public final LIST<Floor> roads; public final RMAP<Floor> roadMap;
/*     */   
/*     */   static {
/*  86 */     D.ts(Floors.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  93 */   private final byte[] tiles = Alloc.bb(SETT.TAREA);
/*  94 */   private final Bits bDegradeO = new Bits(240);
/*  95 */   public final Bitmap2D floorundernot = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*     */   
/*  97 */   private final int NOTHING = 0;
/*  98 */   private final Bitsmap1D types = new Bitsmap1D(-1, 6, SETT.TAREA)
/*     */     {
/*     */       private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void set(int index, int value) {
/* 107 */         Floors.Floor f = (Floors.Floor)Floors.this.getter.get(index);
/* 108 */         if (f != null)
/* 109 */           f.amount--; 
/* 110 */         super.set(index, value);
/* 111 */         f = (Floors.Floor)Floors.this.getter.get(index);
/* 112 */         if (f != null) {
/* 113 */           f.amount++;
/*     */         }
/*     */       }
/*     */     };
/* 117 */   public final Bitmap2D square = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/*     */   
/*     */   public final RMAP<Floor> map;
/*     */   
/*     */   public final Floor defaultRoad;
/*     */   public final Floor mainStartRoad;
/* 123 */   private final ColorImp miniRoad = new ColorImp(180, 180, 180);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final TileMap.SMinimapGetter minimap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_OBJECT<Floor> getter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_DOUBLEE degrade;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final MAP_CLEARER clearer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setFloorMatch(int tx, int ty) {
/* 230 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/*     */     
/* 232 */     if (r == null) {
/*     */ 
/*     */       
/* 235 */       Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/* 236 */       if (t.wantsFloorUnderneath(tx, ty)) {
/* 237 */         setFloorMatch(tx, ty, (Floor)this.getter.get(tx, ty));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFloorMatch(int tx, int ty, Floor res) {
/* 246 */     if ((SETT.JOBS()).getter.is(tx, ty)) {
/*     */       return;
/*     */     }
/* 249 */     if (!this.floorundernot.is(tx, ty)) {
/* 250 */       int am = 0;
/* 251 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 252 */         DIR d = (DIR)DIR.ORTHO.get(di);
/* 253 */         if (!(SETT.ROOMS()).map.is(tx, ty, d))
/*     */         {
/* 255 */           if (!(SETT.TERRAIN().get(tx, ty, d) instanceof TBuilding.BuildingComponent)) {
/*     */             
/* 257 */             Floor floor = (Floor)this.getter.get(tx, ty, d);
/* 258 */             if (floor != null && floor != res) {
/* 259 */               int a = testFloor(tx, ty, floor);
/* 260 */               if (a > 1 && a > am) {
/* 261 */                 am = a;
/* 262 */                 res = floor;
/*     */               } 
/*     */             } 
/*     */           }  } 
/*     */       } 
/*     */     } 
/* 268 */     Floor f = (Floor)this.getter.get(tx, ty);
/*     */     
/* 270 */     if (res == null) {
/* 271 */       if (f != null)
/* 272 */         this.clearer.clear(tx, ty); 
/* 273 */     } else if (f != res) {
/* 274 */       res.placeFixed(tx, ty);
/*     */     } 
/*     */   }
/*     */   
/*     */   private int testFloor(int tx, int ty, Floor f) {
/* 279 */     int am = 0;
/* 280 */     for (int di = 0; di < DIR.ALL.size(); di++) {
/* 281 */       DIR d = (DIR)DIR.ALL.get(di);
/* 282 */       if (!(SETT.ROOMS()).map.is(tx, ty, d))
/*     */       {
/* 284 */         if (!(SETT.TERRAIN().get(tx, ty, d) instanceof TBuilding.BuildingComponent)) {
/*     */           
/* 286 */           Floor f2 = (Floor)this.getter.get(tx, ty, d);
/* 287 */           if (f2 == f)
/* 288 */             am++; 
/*     */         }  } 
/*     */     } 
/* 291 */     return am;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clearAll() {
/* 296 */     this.types.clear();
/* 297 */     this.square.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter saveFile) {
/* 302 */     MAPSAVE.saveMeta(saveFile, (LIST)this.all);
/* 303 */     saveFile.bs(this.tiles);
/* 304 */     this.types.save(saveFile);
/* 305 */     this.square.save(saveFile);
/* 306 */     this.floorundernot.save(saveFile);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter saveFile) throws IOException {
/* 311 */     int[] order = MAPSAVE.saveWash(saveFile, (LIST)this.all, this.defaultRoad.index());
/* 312 */     saveFile.bs(this.tiles);
/* 313 */     this.types.load(saveFile);
/* 314 */     this.square.load(saveFile);
/* 315 */     if (order != null) {
/* 316 */       for (int j = 0; j < this.tiles.length; j++) {
/* 317 */         int bi = this.types.get(j) - 1;
/* 318 */         if (bi >= 0) {
/* 319 */           int oi = order[bi];
/* 320 */           this.types.set(j, oi + 1);
/*     */         } 
/*     */       } 
/*     */     }
/* 324 */     for (Floor f : this.all) {
/* 325 */       f.amount = 0;
/*     */     }
/* 327 */     for (int i = 0; i < this.tiles.length; i++) {
/* 328 */       Floor f = (Floor)this.getter.get(i);
/* 329 */       if (f != null)
/* 330 */         f.amount++; 
/*     */     } 
/* 332 */     this.floorundernot.load(saveFile);
/*     */   }
/*     */   
/*     */   public Floors(TileMap tileMap) throws IOException {
/* 336 */     this.minimap = new TileMap.SMinimapGetter()
/*     */       {
/*     */         public COLOR miniColorPimped(ColorImp col, int x, int y, boolean n, boolean s)
/*     */         {
/* 340 */           if (n == s)
/* 341 */             return (COLOR)col; 
/* 342 */           if (n) {
/* 343 */             col.shadeSelf(1.2D);
/*     */           } else {
/* 345 */             col.shadeSelf(0.8D);
/* 346 */           }  return (COLOR)col;
/*     */         }
/*     */ 
/*     */         
/*     */         public COLOR miniC(int tx, int ty) {
/* 351 */           return (Floors.this.getter.is(tx, ty) && (Floors.this.getter.get(tx, ty) == Floors.this.mainStartRoad || ((Floors.Floor)Floors.this.getter.get(tx, ty)).isRoad)) ? (COLOR)Floors.this.miniRoad : null;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 764 */     this.getter = new MAP_OBJECT<Floor>()
/*     */       {
/*     */         public Floors.Floor get(int tx, int ty)
/*     */         {
/* 768 */           if (SETT.IN_BOUNDS(tx, ty))
/* 769 */             return get(tx + ty * SETT.TWIDTH); 
/* 770 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public Floors.Floor get(int tile) {
/* 775 */           if (tile >= 0 && tile < SETT.TAREA) {
/* 776 */             int c = Floors.this.types.get(tile);
/* 777 */             if (c > 0) {
/* 778 */               return (Floors.Floor)Floors.this.all.get(c - 1);
/*     */             }
/*     */           } 
/*     */           
/* 782 */           return null;
/*     */         }
/*     */       };
/*     */     
/* 786 */     this.degrade = new MAP_DOUBLEE()
/*     */       {
/* 788 */         private final double i = 0.14285714285714285D;
/*     */ 
/*     */         
/*     */         public double get(int tx, int ty) {
/* 792 */           return get(tx + ty * SETT.TWIDTH);
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(int tile) {
/* 797 */           return (Floors.this.bDegradeO.get(Floors.this.tiles[tile]) >> 1) * 0.14285714285714285D;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 802 */           set(tx + ty * SETT.TWIDTH, value);
/* 803 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public MAP_DOUBLEE set(int tile, double value) {
/* 808 */           double o = get(tile);
/* 809 */           value = CLAMP.d(value, 0.0D, 1.0D);
/* 810 */           int v = (int)(value * 7.0D) * 2 << 1;
/* 811 */           v = CLAMP.i(v, 0, 15);
/*     */           
/* 813 */           Floors.this.tiles[tile] = (byte)Floors.this.bDegradeO.set(Floors.this.tiles[tile], v);
/*     */           
/* 815 */           if ((o != 0.0D && v == 0) || (o == 0.0D && v > 0)) {
/* 816 */             (SETT.PATH()).availability.updateAvailability(tile % SETT.TWIDTH, tile / SETT.THEIGHT);
/*     */           }
/* 818 */           return this;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 849 */     this.clearer = new MAP_CLEARER()
/*     */       {
/*     */         public MAP_CLEARER clear(int tx, int ty)
/*     */         {
/* 853 */           if (SETT.IN_BOUNDS(tx, ty))
/* 854 */             clear(tx + ty * SETT.TWIDTH); 
/* 855 */           return this;
/*     */         }
/*     */         
/*     */         public MAP_CLEARER clear(int tile)
/*     */         {
/* 860 */           if (Floors.this.getter.is(tile)) {
/* 861 */             Floors.this.types.set(tile, 0);
/* 862 */             SETT.TILE_MAP().miniCUpdate(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/* 863 */             int tx = tile % SETT.TWIDTH;
/* 864 */             int ty = tile / SETT.TWIDTH;
/* 865 */             for (int di = 0; di < DIR.ALL.size(); di++) {
/* 866 */               DIR d = (DIR)DIR.ALL.get(di);
/* 867 */               Floors.Floor f = (Floors.Floor)Floors.this.getter.get(tx, ty, d);
/* 868 */               if (f != null) {
/* 869 */                 f.place(tx + d.x(), ty + d.y());
/*     */               }
/*     */             } 
/* 872 */             (SETT.PATH()).availability.updateAvailability(tx, ty);
/*     */           } 
/*     */           
/* 875 */           return this; } }; PATHS.ResFolder gg = PATHS.SETT().folder("floor"); String[] keys = gg.init.getFiles(); String[] kk = new String[keys.length]; for (int i = 0; i < keys.length; i++) kk[i] = keys[i];  kk[kk.length - 1] = "_GRASS"; LinkedList<Floor> all = new LinkedList(); byte b; int j; String[] arrayOfString1; for (j = (arrayOfString1 = gg.init.getFiles()).length, b = 0; b < j; ) { String k = arrayOfString1[b]; Json data = new Json(gg.init.gets(k)); Json text = data.has("ROAD") ? new Json(gg.text.gets(k)) : null; b++; }  this.mainStartRoad = new Floor((LISTE<Floor>)all, "_MAIN_TOAD", new Json(gg.init.gets("_MAIN_ROAD")), null); this.mainStartRoad.name = ¤¤dName; this.all = new ArrayList((Iterable)all); this.map = new RMAP("FLOOR", (LIST)this.all); if (this.all.size() > 63) throw new Errors.GameError("Too many floors have been declared. Maximum is 63");  int r = 0; for (Floor fl : this.all) { if (fl != null && fl.isRoad) r++;  }  ArrayList<Floor> roads = new ArrayList(r); r = 0; for (Floor fl : this.all) { if (fl != null && fl.isRoad) { fl.indexroad = r++; roads.add(fl); }  }  this.roads = (LIST<Floor>)roads; this.roadMap = new RMAP("ROAD", (LIST)roads); this.extra = new RFloorExtra(gg.sprite); for (Floor f : this.all) { if (f == null) continue;  IDebugPanelSett.add(this.map.key, (PLACABLE)new PlacableMulti(f.key() + f.key(), f.desc, null) { public void place(int tx, int ty, AREA a, PLACER_TYPE t) { f.placeFixed(tx, ty); } public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) { return f.isPlacable(tx, ty) ? null : ""; } }
/*     */         ); }  IDebugPanelSett.add(this.map.key, (PLACABLE)new PlacableMulti("clear roads and floor") { public void place(int tx, int ty, AREA a, PLACER_TYPE t) { Floors.this.clearer.clear(tx, ty); } public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) { return (SETT.IN_BOUNDS(tx, ty) && Floors.this.getter.is(tx, ty)) ? null : ""; } }
/*     */       ); IDebugPanelSett.add(this.map.key, (PLACABLE)new PlacableMulti("floor degrade") { public void place(int tx, int ty, AREA a, PLACER_TYPE t) { Floors.this.degradeInc(tx + ty * SETT.TWIDTH, 1); } public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) { return (SETT.IN_BOUNDS(tx, ty) && Floors.this.getter.is(tx, ty)) ? null : ""; } }
/*     */       ); this.defaultRoad = (Floor)this.map.read("FILE", new Json(gg.init.gets("_DEFAULT_ROAD")));
/*     */   } public void render(Renderer r, float ds, ShadowBatch shadowBatch, RenderData data) { RenderData.RenderIterator i = data.onScreenTiles(); while (i.has()) { Floor f = (Floor)this.getter.get(i.tile()); if (f != null) renderDetailed(i, f, this.tiles[i.tile()]);  SETT.ROOMS().renderAfterGround(r, shadowBatch, i); if ((VIEW.RI() + i.tx() & 0xFF) == 0) setFloorMatch(i.tx(), i.ty());  i.next(); }  } public int rotMask(RenderData.RenderIterator i) { return this.tiles[i.tile()] & 0xF; } public void renderSimple(SPRITE_RENDERER ren, RenderData.RenderIterator i, Floor f) { f.sheet.render(ren, i.ran() & 0xF, i.x(), i.y()); } public TextureCoords texture(RenderData.RenderIterator i, Floor f) { return f.sheet.getTexture(i.ran() & 0xF); } private int edge(RenderData.RenderIterator i, int mask) { if (this.square.is(i.tile())) return 15;  if (CORE.renderer().getZoomout() > 1) return 15;  if ((SETT.ROOMS()).map.get(i.tile()) != null) return 15;  int edge = 0; for (DIR d : DIR.NORTHO) { int m1 = d.next(-1).mask(); int m2 = d.next(1).mask(); Room r = (Room)(SETT.ROOMS()).map.get(i.tx(), i.ty(), d); if ((mask & m1) != 0 && (mask & m2) != 0 && (this.getter.get(i.tile() + d.x() + d.y() * SETT.TWIDTH) != null || (r != null && r.constructor() != null && r.constructor().joinsWithFloor()))) edge |= d.mask();  }  return edge; } private void renderDetailed(RenderData.RenderIterator i, Floor f, int t) { TILE_SHEET texture = f.sheet; int mask = this.square.is(i.tile()) ? 15 : (t & 0xF); int textureTile = i.ran() % texture.tiles(); int de = degrade(i.tx(), i.ty(), f); int broken = de >> 2; int filth = CLAMP.i(de, 0, 8) - 1; int ran = i.ran(); int edge = edge(i, mask); int stencil = broken * 96; if (mask == 0) { stencil += 64 + (ran & 0xF); ran >>= 4; } else if (mask == 15) { stencil += 80 + (ran & 0xF); ran >>= 4; } else { stencil += mask + (ran & 0x3) * 16; ran >>= 2; }  f.tint().bind(); if (edge == 15) { if (mask == 15 && broken == 0) i.hiddenSet();  this.extra.stencil.renderTextured(texture.getTexture(textureTile), stencil, i.x(), i.y()); int mm = 0; for (DIR d : DIR.ORTHO) { Floor fl = (Floor)this.getter.get(i.tx(), i.ty(), d); if (fl == f) mm |= d.mask();  }  if (mm != 15) this.extra.stencil.renderTextured(this.extra.normalEdge.getTexture(mm), stencil, i.x(), i.y());  COLOR.unbind(); if (filth > 0) { OPACITY.O99.bind(); filth *= 8; filth += ran & 0x7; ran >>= 3; this.extra.stencil.renderTextured(this.extra.filth.getTexture(filth), stencil, i.x(), i.y()); OPACITY.unbind(); }  } else { if (edge == 15 && mask == 15 && broken == 0) i.hiddenSet();  this.extra.stencilDetail.renderTextured(texture.getTexture(textureTile), stencil, i.x(), i.y()); this.extra.edge.render((SPRITE_RENDERER)CORE.renderer(), stencil, i.x(), i.y()); if (edge != 0 && broken == 0) this.extra.stencilDetail.renderTextured(texture.getTexture(textureTile), 384 + edge, i.x(), i.y());  int mm = 0; for (DIR d : DIR.ORTHO) { Floor fl = (Floor)this.getter.get(i.tx(), i.ty(), d); if (fl == f) mm |= d.mask();  }  if (mm != 15) this.extra.stencilDetail.renderTextured(this.extra.normalEdge.getTexture(mm), stencil, i.x(), i.y());  COLOR.unbind(); if (filth > 0) { OPACITY.O99.bind(); filth *= 8; filth += ran & 0x7; ran >>= 3; this.extra.stencilDetail.renderTextured(this.extra.filth.getTexture(filth), stencil, i.x(), i.y()); OPACITY.unbind(); }  }  }
/* 880 */   public LIST<Floor> all() { return (LIST<Floor>)this.all; }
/*     */   public void renderOntop(RenderData.RenderIterator i, Floor f, int mask) { i.hiddenSet(); Renderer r = CORE.renderer(); TILE_SHEET sheet = f.sheet; int tile = i.ran() % sheet.tiles(); int de = degrade(i.tx(), i.ty(), f) >> 1 & 0x7; f.tint().bind(); sheet.render((SPRITE_RENDERER)r, tile, i.x(), i.y()); COLOR.unbind(); if (de > 0) { OPACITY.O50.bind(); this.extra.filth.render((SPRITE_RENDERER)r, (de - 1) * 8 + (i.ran() & 0x7), i.x(), i.y()); OPACITY.unbind(); }  if (mask != 255) this.extra.normalEdge.render((SPRITE_RENDERER)r, mask, i.x(), i.y());  }
/*     */   public class Floor implements MAPPED {
/*     */     private int amount;
/*     */     public final PlayerColors.PlayerColor tint;
/*     */     public CharSequence name;
/*     */     public final CharSequence desc;
/*     */     public final boolean isRoad;
/*     */     private final double[] envValues = new double[(SETT.ENV()).map.all().size()];
/*     */     public final AVAILABILITY speed;
/*     */     public final double durability;
/*     */     public final TILE_SHEET sheet;
/*     */     public final RESOURCE resource;
/*     */     public final int resAmount;
/*     */     protected final int code;
/*     */     private final Icon icon;
/*     */     private int indexroad;
/*     */     public final String key;
/*     */     public final boolean isGrass;
/*     */     public final Lockable<Faction> reqs; private double[] preference = new double[RACES.all().size()]; protected Floor(LISTE<Floor> all, String key, Json data, Json text) throws IOException { this.code = all.add(this); this.sheet = SPRITES.GAME().raw((SheetType)SheetType.sTex, data); this.key = key; this.isRoad = data.has("ROAD"); this.isGrass = data.bool("IS_GRASS", false); this.icon = new Icon((SPRITE)new SPRITE.Imp(32) {
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) { int w = (X2 - X1) / 2; int h = (Y2 - Y1) / 2; int scale = (X2 - X1) / width(); for (int y = 0; y < 2; y++) { for (int x = 0; x < 2; x++) { int i = y * 2 + x; (Floors.Floor.access$0(Floors.Floor.this)).extra.icon.render(r, i, X1 + x * w, X1 + x * w + w, Y1 + y * h, Y1 + y * h + h); Floors.Floor.this.tint().bind(); (Floors.Floor.access$0(Floors.Floor.this)).extra.icon.renderTextured(Floors.Floor.this.sheet.getTexture(i), i + 4, X1 + x * w, Y1 + y * h, scale); COLOR.unbind(); }  }  }
/*     */           }); if (this.isRoad) { Json road = data.json("ROAD"); this.name = text.text("NAME"); this.desc = text.text("DESC"); (SETT.ENV()).map.rmap.readFill(this.envValues, road, 1.0D); this.speed = AVAILABILITY.ROADS[road.i("SPEED", 0, AVAILABILITY.ROADS.length - 1)]; this.durability = road.d("DURABILITY", 0.0D, 1.0D); this.resource = (RESOURCE)RESOURCES.map().readTry(road); if (road.has("RESOURCE")) { this.resAmount = road.i("RESOURCE_AMOUNT"); } else { this.resAmount = 0; }  this.reqs = GVALUES.FACTION.LOCK.push("FLOOR_" + key, this.name, this.desc, (SPRITE)this.icon); RACES.map().readFill("PREFERENCE", this.preference, road, 0.0D, 1.0D); } else { this.name = String.valueOf(Dic.¤¤floor) + "#" + String.valueOf(Dic.¤¤floor); this.desc = ""; this.durability = 1.0D; this.resource = null; this.resAmount = 0; this.speed = AVAILABILITY.ROAD0; this.reqs = GVALUES.FACTION.LOCK.empty; }  this.tint = new PlayerColors.PlayerColor(new ColorImp(data, "COLOR_MASK"), "FLOOR_" + key, Dic.¤¤floor, this.name); } public int indexRoad() { return this.indexroad; } public void placeFixed(int tx, int ty) { place(tx, ty); for (int i = 0; i < DIR.ORTHO.size(); i++) { DIR d = (DIR)DIR.ORTHO.get(i); if (Floors.this.getter.is(tx, ty, d)) ((Floor)Floors.this.getter.get(tx, ty, d)).place(tx + d.x(), ty + d.y());  }  } private void place(int tx, int ty) { Floor old = (Floor)Floors.this.getter.get(tx, ty); if (!SETT.IN_BOUNDS(tx, ty)) return;  if (old == null) Floors.this.square.set(tx, ty, false);  int d = 0; if (SETT.TERRAIN().get(tx, ty).roofIs() || (SETT.ROOMS()).map.is(tx, ty)) { d = 15; } else { for (int i = 0; i < DIR.ORTHO.size(); i++) { DIR dir = (DIR)DIR.ORTHO.get(i); Terrain.TerrainTile t = (Terrain.TerrainTile)SETT.TERRAIN().get(tx, ty, dir); if (t instanceof TBuilding.Wall) { TBuilding.Wall w = (TBuilding.Wall)t; if (w.getDia(tx + dir.x(), ty + dir.y())) d |= ((DIR)DIR.ORTHO.get(i)).mask();  }  if (!SETT.IN_BOUNDS(tx, ty, dir) || Floors.this.getter.is(tx, ty, dir) || SETT.TERRAIN().get(tx, ty, dir) instanceof settlement.tilemap.terrain.TFortification.Tile || (SETT.ROOMS()).map.is(tx, ty, dir)) d |= ((DIR)DIR.ORTHO.get(i)).mask();  }  }  if (old == this) { int deg = Floors.this.tiles[ty * SETT.TWIDTH + tx] & 0xF0; d |= deg; }  Floors.this.tiles[ty * SETT.TWIDTH + tx] = (byte)d; Floors.this.types.set(ty * SETT.TWIDTH + tx, this.code + 1); if (old != this) SETT.TILE_MAP().miniCUpdate(tx, ty);  (SETT.GRASS()).currentI.set(tx, ty, 0); (SETT.PATH()).availability.updateAvailability(tx, ty); SETT.MAINTENANCE().setChanged(tx, ty); } public CharSequence name() { return this.name; } public boolean isPlacable(int x, int y) { return true; } public Icon getIcon() { return this.icon; } public int index() { return this.code; } public double envValue(SettEnvMap.SettEnv e, int tile) { return (Floors.this.degrade.get(tile) < 1.0D) ? this.envValues[e.index()] : 0.0D; } public double envValue(SettEnvMap.SettEnv e) { return this.envValues[e.index()]; } public COLOR tint() { if (this.isGrass) return SETT.GRASS().color(0);  return (COLOR)this.tint.color; } public String key() { return this.key; } public double pref(Race race) { return this.preference[race.index()]; } public void prefSet(Race race, double pref) { this.preference[race.index] = pref; } public int amountPlaced() { return this.amount; }
/*     */   } public AVAILABILITY getAvailability(int tx, int ty) { return (this.getter.is(tx, ty) && this.degrade.get(tx, ty) != 1.0D) ? ((Floor)this.getter.get(tx, ty)).speed : null; } public void updateStructure(int tx, int ty) { Floor f = (Floor)this.getter.get(tx, ty); if (f != null) f.place(tx, ty);  for (int i = 0; i < DIR.ORTHO.size(); i++) { f = (Floor)this.getter.get(tx, ty, (DIR)DIR.ORTHO.get(i)); if (f != null) f.place(tx + ((DIR)DIR.ORTHO.get(i)).x(), ty + ((DIR)DIR.ORTHO.get(i)).y());  }  } public int degrade(int tx, int ty) { Floor f = (Floor)this.getter.get(tx, ty); if (f == this.mainStartRoad) return 15;  Room r = (SETT.ROOMS()).map.get(tx, ty); if (r != null) return (int)(15.0D * r.getDegrade(tx, ty));  return this.bDegradeO.get(this.tiles[tx + ty * SETT.TWIDTH]); } private int degrade(int tx, int ty, Floor f) { if (f == this.mainStartRoad) return 15;  Room r = (SETT.ROOMS()).map.get(tx, ty); if (r != null) return (int)(15.0D * r.getDegrade(tx, ty));  return this.bDegradeO.get(this.tiles[tx + ty * SETT.TWIDTH]); } public void degradeInc(int tile, int am) { this.tiles[tile] = (byte)this.bDegradeO.inc(this.tiles[tile], am); } private static final class RFloorExtra {
/* 903 */     public static final int eSingles = 64; public static final int eFulls = 80; public static final int eSet = 96; public static final int eCorner = 384; public final TILE_SHEET stencil; RFloorExtra(PATH g) throws IOException { this.stencil = (new ComposerThings.ITileSheet(g.get("_FloorExtra"), 1152, 50)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 907 */             return Floors.RFloorExtra.this.stencil(c, s, d, 0);
/*     */           }
/* 909 */         }).get();
/* 910 */       this.stencilDetail = (new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 914 */             return Floors.RFloorExtra.this.stencil(c, s, d, 128);
/*     */           }
/* 916 */         }).get();
/* 917 */       this.edge = (new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 921 */             return Floors.RFloorExtra.this.stencil(c, s, d, 256);
/*     */           }
/* 923 */         }).get();
/*     */       
/* 925 */       this.normalEdge = (new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 929 */             s.house.init(0, 384, 1, 1, (ComposerDests.Dest)d.s16);
/* 930 */             s.house.paste(true);
/* 931 */             return d.s16.saveGame();
/*     */           }
/* 933 */         }).get();
/* 934 */       this.filth = (new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 938 */             s.full.init(s.house.body().x2(), s.house.body().y1(), 1, 1, 8, 8, d.s16);
/* 939 */             s.full.paste(true);
/* 940 */             return d.s16.saveGame();
/*     */           }
/* 942 */         }).get();
/* 943 */       this.icon = (new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 947 */             s.full.init(s.full.body().x2(), s.full.body().y1(), 2, 1, 2, 2, d.s16);
/* 948 */             s.full.paste(true);
/* 949 */             s.full.setVar(1).paste(true);
/* 950 */             return d.s16.saveGui();
/*     */           }
/* 952 */         }).get(); }
/*     */     
/*     */     public final TILE_SHEET stencilDetail; public final TILE_SHEET edge; public final TILE_SHEET filth; public final TILE_SHEET normalEdge; public final TILE_SHEET icon;
/*     */     private TILE_SHEET stencil(ComposerUtil c, ComposerSources s, ComposerDests d, int y2) {
/* 956 */       int x1 = 0;
/* 957 */       for (int x = 0; x < 4; x++) {
/* 958 */         int y1 = y2;
/* 959 */         for (int y = 0; y < 1; y++) {
/* 960 */           s.house.init(x1, y1, 2, 1, (ComposerDests.Dest)d.s16);
/* 961 */           s.house.setVar(0).paste(1, true);
/* 962 */           s.house.setVar(1).paste(1, true);
/*     */           
/* 964 */           s.full.init(x1, s.house.body().y2(), 1, 1, 8, 1, d.s16);
/* 965 */           s.full.paste(1, true);
/* 966 */           s.full.init(x1, s.full.body().y2(), 1, 1, 8, 1, d.s16);
/* 967 */           s.full.paste(1, true);
/* 968 */           y1 = s.full.body().y2();
/*     */         } 
/*     */         
/* 971 */         x1 = s.house.body().x2();
/*     */       } 
/*     */       
/* 974 */       s.house.init(0, y2, 1, 1, (ComposerDests.Dest)d.s16);
/* 975 */       s.house.setVar(0).pasteEdges(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 982 */       return d.s16.saveGame();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\floor\Floors.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */