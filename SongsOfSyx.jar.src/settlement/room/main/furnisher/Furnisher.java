/*     */ package settlement.room.main.furnisher;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import settlement.environment.SettEnvMap;
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.main.util.RoomState;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import settlement.tilemap.terrain.TerrainDiagonal;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.INFO;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Furnisher
/*     */ {
/*     */   public static final int MAX_RESOURCES = 4;
/*  42 */   final ArrayList<FurnisherItemTile> tiles = new ArrayList(255);
/*  43 */   final ArrayList<FurnisherItem> allItems = new ArrayList(255);
/*  44 */   final ArrayListGrower<FurnisherItemGroup> pgroups = new ArrayListGrower();
/*  45 */   final ArrayListGrower<FurnisherItemGroup> ggroups = new ArrayListGrower();
/*     */   
/*     */   final ArrayList<FurnisherStat> stats;
/*     */   
/*     */   private final LIST<RESOURCE> resources;
/*     */   
/*     */   private final double[] areaCost;
/*     */   protected final LIST<Floors.Floor> floors;
/*     */   public final COLOR miniColor;
/*     */   private final FurnisherMinimapColor colorPimp;
/*     */   protected static Json[] jsonGroupText;
/*     */   protected static Json[] jsonGroupData;
/*     */   protected static Json[] jsonStat;
/*  58 */   protected final double[] envValue = new double[(SETT.ENV()).map.all().size()];
/*  59 */   protected final double[] envRadius = new double[(SETT.ENV()).map.all().size()];
/*     */ 
/*     */ 
/*     */   
/*     */   protected Furnisher(RoomInitData init, int items, int stats) throws IOException {
/*  64 */     this.tiles.add(null);
/*  65 */     this.allItems.add(null);
/*  66 */     if (FurnisherItem.itemsTmp.size() != 0) {
/*  67 */       throw new RuntimeException("someone forgot to flush...");
/*     */     }
/*  69 */     Json data = init.data();
/*  70 */     Json text = init.text();
/*     */     
/*  72 */     this.resources = RESOURCES.map().readMany(data);
/*  73 */     if (this.resources.size() > 4)
/*  74 */       data.error("Too many resources declared. Max is 4", "RESOURCES"); 
/*  75 */     this.areaCost = data.ds("AREA_COSTS", this.resources.size());
/*  76 */     if (data.has((SETT.FLOOR()).map.key)) {
/*  77 */       if (data.arrayIs((SETT.FLOOR()).map.key)) {
/*  78 */         this.floors = (SETT.FLOOR()).map.readManyWarn((SETT.FLOOR()).map.key, data);
/*     */       } else {
/*  80 */         Floors.Floor f = (Floors.Floor)(SETT.FLOOR()).map.readTry(data);
/*  81 */         if (f == null)
/*  82 */           data.error("no floor named: ", (SETT.FLOOR()).map.key); 
/*  83 */         this.floors = (LIST<Floors.Floor>)new ArrayList(f);
/*     */       } 
/*     */     } else {
/*     */       
/*  87 */       this.floors = null;
/*     */     } 
/*     */     
/*  90 */     jsonStat = null;
/*  91 */     if (stats > 0) {
/*  92 */       jsonStat = text.jsons("STATS", stats);
/*  93 */       if (stats != jsonStat.length)
/*  94 */         text.error("Invalid amount of stats declared. Should be " + stats + " not " + jsonStat.length, "STATS"); 
/*     */     } 
/*  96 */     this.stats = new ArrayList(stats);
/*     */     
/*  98 */     jsonGroupText = null;
/*  99 */     jsonGroupData = null;
/* 100 */     if (items > 0) {
/* 101 */       jsonGroupData = data.jsons("ITEMS", items);
/* 102 */       jsonGroupText = text.jsons("ITEMS", items);
/* 103 */       if (items != jsonGroupData.length)
/* 104 */         data.error("Invalid amount of items declared. Should be " + items + " not " + jsonGroupData.length, "ITEMS"); 
/*     */     } 
/* 106 */     if (items == 0) {
/* 107 */       items = 1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 113 */     this.miniColor = (COLOR)new ColorImp(data, "MINI_COLOR");
/* 114 */     this.colorPimp = new FurnisherMinimapColor(data);
/*     */     
/* 116 */     if (data.has("ENVIRONMENT_EMIT")) {
/* 117 */       Json j = data.json("ENVIRONMENT_EMIT");
/* 118 */       for (String k : j.keys()) {
/* 119 */         SettEnvMap.SettEnv e = (SettEnvMap.SettEnv)(SETT.ENV()).map.rmap.getWarn(k, j);
/* 120 */         if (e != null) {
/* 121 */           Json jj = j.json(k);
/* 122 */           this.envValue[e.index()] = jj.d("VALUE", 0.0D, 1.0D);
/* 123 */           this.envRadius[e.index()] = jj.d("RADIUS", 0.0D, 1.0D);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected Furnisher(RoomInitData init, int items, int stats, int nopA, int nopB) throws IOException {
/* 131 */     this(init, items, stats);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean envValue(SettEnvMap.SettEnv e, SettEnvMap.SettEnvValue v, int tx, int ty) {
/* 136 */     if (this.envRadius[e.index()] != 0.0D) {
/* 137 */       v.radius = this.envRadius[e.index()];
/* 138 */       v.value = this.envValue[e.index()];
/* 139 */       return true;
/*     */     } 
/* 141 */     return false;
/*     */   }
/*     */   
/*     */   public boolean envValue(SettEnvMap.SettEnv e) {
/* 145 */     if (this.envRadius[e.index()] != 0.0D) {
/* 146 */       return true;
/*     */     }
/* 148 */     return false;
/*     */   }
/*     */   
/*     */   public final int resources() {
/* 152 */     return this.resources.size();
/*     */   }
/*     */   
/*     */   public final RESOURCE resource(int index) {
/* 156 */     return (RESOURCE)this.resources.get(index);
/*     */   }
/*     */   
/*     */   public final boolean resourceHas(int index, int upgrade) {
/* 160 */     return (blue().upgrades().resMask(upgrade, index) > 0.0D);
/*     */   }
/*     */   
/*     */   public final double areaCost(int index, int upgrade) {
/* 164 */     return this.areaCost[index] * blue().upgrades().resMask(upgrade, index);
/*     */   }
/*     */   
/*     */   public final double areaCostFlat(int index) {
/* 168 */     return this.areaCost[index];
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract boolean usesArea();
/*     */   
/*     */   public CharSequence placable(int tx, int ty, FurnisherItem item, FurnisherItemTile tile) {
/* 175 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final FurnisherItemGroup flush(int min, int max, int rots) {
/* 180 */     if (rots != 0 && rots != 1 && rots != 3) {
/* 181 */       throw new RuntimeException("" + rots);
/*     */     }
/* 183 */     FurnisherItemGroup f = new FurnisherItemGroup(
/* 184 */         this, rots, 
/* 185 */         jsonGroupText[this.ggroups.size()].text("NAME"), 
/* 186 */         jsonGroupText[this.ggroups.size()].text("DESC"), 
/* 187 */         min, 
/* 188 */         max, 
/* 189 */         jsonGroupData[this.ggroups.size()].ds("COSTS", this.resources.size()), 
/* 190 */         jsonGroupData[this.ggroups.size()].ds("STATS", this.stats.size()));
/*     */     
/* 192 */     this.ggroups.add(f);
/* 193 */     return f;
/*     */   }
/*     */   
/*     */   protected final void flushSingle(INFO info) {
/* 197 */     if (jsonGroupText != null) {
/* 198 */       throw new RuntimeException("" + jsonGroupText.length);
/*     */     }
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
/*     */   public final FurnisherItemGroup flush(int rots) {
/* 211 */     return flush(0, 2147483647, rots);
/*     */   }
/*     */   
/*     */   protected final FurnisherItemGroup flush(int min, int rots) {
/* 215 */     return flush(min, 2147483647, rots);
/*     */   }
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 219 */     Floors.Floor floor = floor(upgrade);
/* 220 */     if (floor != null) {
/* 221 */       floor.placeFixed(tx, ty);
/*     */     }
/*     */   }
/*     */   
/*     */   public Floors.Floor floor(int upgrade) {
/* 226 */     if (this.floors == null || this.floors.size() == 0)
/* 227 */       return null; 
/* 228 */     upgrade = CLAMP.i(upgrade, 0, this.floors.size() - 1);
/* 229 */     return (FACTIONS.player().race().appearance()).floors.get((RoomBlueprint)blue(), upgrade, (Floors.Floor)this.floors.get(upgrade));
/*     */   }
/*     */   
/*     */   public final LIST<FurnisherItemGroup> pgroups() {
/* 233 */     return (LIST<FurnisherItemGroup>)this.pgroups;
/*     */   }
/*     */   
/*     */   public final LIST<FurnisherItemGroup> groups() {
/* 237 */     return (LIST<FurnisherItemGroup>)this.ggroups;
/*     */   }
/*     */   
/*     */   public final FurnisherItem item(int index) {
/* 241 */     return (FurnisherItem)this.allItems.get(index);
/*     */   }
/*     */   
/*     */   public final FurnisherItemTile tile(int index) {
/* 245 */     return (FurnisherItemTile)this.tiles.get(index);
/*     */   }
/*     */   
/*     */   public final LIST<FurnisherStat> stats() {
/* 249 */     return (LIST<FurnisherStat>)this.stats;
/*     */   }
/*     */   
/*     */   public void renderEmbryo(SPRITE_RENDERER r, int mask, RenderData.RenderIterator it, boolean isFloored, AREA area, boolean active) {
/* 253 */     (SPRITES.cons()).BIG.dashed.render(r, mask, it.x(), it.y());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTileBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, boolean floored) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderExtra(SPRITE_RENDERER r, int x, int y, int tx, int ty, int rx, int ry, FurnisherItem item) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void doBeforePlanning(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeFertility() {
/* 277 */     return true;
/*     */   }
/*     */   
/*     */   public boolean removeTerrain(int tx, int ty) {
/* 281 */     return !(SETT.TERRAIN()).NADA.is(tx, ty);
/*     */   }
/*     */   
/*     */   public final COLOR miniColor(int tx, int ty) {
/* 285 */     if (this.colorPimp != null)
/* 286 */       return this.colorPimp.get(tx, ty); 
/* 287 */     return this.miniColor;
/*     */   }
/*     */   
/*     */   public final COLOR miniColorPimped(ColorImp origional, int tx, int ty, boolean northern, boolean southern) {
/* 291 */     for (DIR d : DIR.ORTHO) {
/* 292 */       Room r2 = (Room)(SETT.ROOMS()).map.get(tx, ty, d);
/* 293 */       if (r2 == null || !r2.isSame(tx + d.x(), ty + d.y(), tx, ty))
/* 294 */         return (COLOR)origional.shadeSelf(0.8D); 
/*     */     } 
/* 296 */     return (COLOR)origional;
/*     */   }
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 300 */     return true;
/*     */   }
/*     */   
/*     */   public Addable overlay() {
/* 304 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isHeavy() {
/* 308 */     return false;
/*     */   }
/*     */   
/*     */   public boolean needsIsolation() {
/* 312 */     return (mustBeIndoors() && blue().degradeRate() > 0.0D);
/*     */   }
/*     */   
/*     */   public boolean needFlooring() {
/* 316 */     return true;
/*     */   }
/*     */   
/*     */   public boolean mustBeOutdoors() {
/* 320 */     return false;
/*     */   }
/*     */   
/*     */   public abstract Room create(TmpArea paramTmpArea, RoomInit paramRoomInit);
/*     */   
/*     */   public abstract RoomBlueprintImp blue();
/*     */   
/*     */   public boolean canBeCopied() {
/* 328 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void doAfterConstructionInited() {}
/*     */ 
/*     */   
/*     */   public FurnisherItem secretReplacementItem(int rot, FurnisherItem origional) {
/* 336 */     return null;
/*     */   }
/*     */   
/*     */   public CharSequence warning(AREA area) {
/* 340 */     return null;
/*     */   }
/*     */   
/*     */   public CharSequence constructionProblem(AREA area) {
/* 344 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void placeInfo(GBox box, FurnisherItem item, int x1, int y1) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean joinsWithFloor() {
/* 354 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isSpecialAreaPlacable() {
/* 358 */     return false;
/*     */   }
/*     */   
/*     */   public boolean growsGrass(int tx, int ty) {
/* 362 */     return false;
/*     */   }
/*     */   
/*     */   public TerrainDiagonal.Diagonalizer dia(int tx, int ty) {
/* 366 */     return null;
/*     */   }
/*     */   
/*     */   public RoomState getConstructionState() {
/* 370 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\furnisher\Furnisher.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */