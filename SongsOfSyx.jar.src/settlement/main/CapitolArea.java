/*     */ package settlement.main;
/*     */ 
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.datatypes.ShortCoo;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import world.WORLD;
/*     */ import world.map.road.WTRAV;
/*     */ import world.map.terrain.WorldGround;
/*     */ import world.map.terrain.WorldTerrainInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CapitolArea
/*     */ {
/*  24 */   private static int TILES = 3;
/*     */   
/*  26 */   private final ArrayList<COORDINATE> tiles = new ArrayList(TILES * TILES);
/*  27 */   private int arrivalTile = -1;
/*     */   
/*  29 */   private final Rec worldPixels = new Rec((TILES * 64));
/*  30 */   private final Rec worldTiles = new Rec(TILES);
/*     */   
/*     */   private CLIMATE climate;
/*  33 */   public final WorldTerrainInfo info = new WorldTerrainInfo();
/*     */   
/*     */   public boolean isBattle;
/*     */   
/*  37 */   public final SAVABLE saver = new SAVABLE()
/*     */     {
/*     */       public void save(FilePutter file)
/*     */       {
/*  41 */         CapitolArea.this.tiles.save(file);
/*  42 */         file.i(CapitolArea.this.arrivalTile);
/*  43 */         CapitolArea.this.worldPixels.save(file);
/*  44 */         CapitolArea.this.worldTiles.save(file);
/*  45 */         file.i(CapitolArea.this.climate.index());
/*  46 */         file.bool(CapitolArea.this.isBattle);
/*     */       }
/*     */ 
/*     */       
/*     */       public void load(FileGetter file) throws IOException {
/*  51 */         CapitolArea.this.tiles.load(file);
/*  52 */         CapitolArea.this.arrivalTile = file.i();
/*  53 */         CapitolArea.this.worldPixels.load(file);
/*  54 */         CapitolArea.this.worldTiles.load(file);
/*  55 */         CapitolArea.this.climate = (CLIMATE)CLIMATES.ALL().get(file.i());
/*  56 */         CapitolArea.this.isBattle = file.bool();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void clear() {}
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   void init(int worldtileX1, int worldtileY1, boolean isBattle) {
/*  68 */     this.isBattle = isBattle;
/*  69 */     this.worldTiles.moveX1Y1(worldtileX1, worldtileY1);
/*  70 */     this.worldPixels.moveX1Y1((worldtileX1 * 64), (worldtileY1 * 64));
/*     */     
/*  72 */     this.tiles.clear();
/*  73 */     this.info.initCity(worldtileX1, worldtileY1);
/*     */     
/*  75 */     for (int y = 0; y < TILES; y++) {
/*  76 */       for (int x = 0; x < TILES; x++) {
/*  77 */         int tx = x + worldtileX1;
/*  78 */         int ty = y + worldtileY1;
/*  79 */         int i = this.tiles.add(new ShortCoo((worldtileX1 + x), (worldtileY1 + y)));
/*     */ 
/*     */         
/*  82 */         if (this.arrivalTile == -1 && WTRAV.isGoodLandTile(tx, ty) && (
/*  83 */           x == 0 || y == 0 || x == TILES - 1 || y == TILES - 1)) {
/*  84 */           this.arrivalTile = i;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  90 */     if (this.arrivalTile == -1)
/*     */     {
/*  92 */       this.arrivalTile = TILES * TILES / 2;
/*     */     }
/*     */     
/*  95 */     this.climate = (CLIMATE)(WORLD.CLIMATE()).getter.get(this.worldTiles.cX(), this.worldTiles.cY());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getWatertabe() {
/* 104 */     double table = 0.0D;
/* 105 */     for (COORDINATE c : this.tiles) {
/* 106 */       table += ((WorldGround.WGROUND)(WORLD.GROUND()).getter.get(c)).moisture();
/*     */     }
/*     */     
/* 109 */     table /= (TILES * TILES);
/*     */     
/* 111 */     table = 0.05D + table * 0.1D;
/* 112 */     return (float)table;
/*     */   }
/*     */   
/*     */   public final int arrivalTile() {
/* 116 */     return this.arrivalTile;
/*     */   }
/*     */   
/*     */   public final CLIMATE climate() {
/* 120 */     return this.climate;
/*     */   }
/*     */   
/*     */   public final RECTANGLE tiles() {
/* 124 */     return (RECTANGLE)this.worldTiles;
/*     */   }
/*     */   
/*     */   public final LIST<COORDINATE> ts() {
/* 128 */     return (LIST<COORDINATE>)this.tiles;
/*     */   }
/*     */   
/*     */   public final RECTANGLE pixels() {
/* 132 */     return (RECTANGLE)this.worldPixels;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\main\CapitolArea.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */