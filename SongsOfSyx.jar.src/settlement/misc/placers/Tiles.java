/*     */ package settlement.misc.placers;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ final class Tiles
/*     */ {
/*  11 */   static final Tile __ = new Tile()
/*     */     {
/*     */       public void place(int tx, int ty, TileGrid grid, int rx, int ry) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/*  20 */         return !(SETT.PATH()).solidity.is(tx, ty);
/*     */       }
/*     */ 
/*     */       
/*     */       public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/*  25 */         return (SPRITES.cons()).BIG.dashed.get(0);
/*     */       }
/*     */     };
/*     */   
/*  29 */   static final Tile xx = new Tile()
/*     */     {
/*     */       public void place(int tx, int ty, TileGrid grid, int rx, int ry)
/*     */       {
/*  33 */         (SETT.TERRAIN()).NADA.placeFixed(tx, ty);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/*  38 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/*  43 */         return (SPRITES.cons()).BIG.dashed.get(0);
/*     */       }
/*     */     };
/*     */   
/*  47 */   static final Tile na = new Tile()
/*     */     {
/*     */       public void place(int tx, int ty, TileGrid grid, int rx, int ry) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/*  56 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/*  61 */         return (SPRITES.cons()).BIG.dashed.get(0);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   static class Terrain
/*     */     implements Tile
/*     */   {
/*     */     final settlement.tilemap.terrain.Terrain.TerrainTile t;
/*     */ 
/*     */     
/*     */     Terrain(settlement.tilemap.terrain.Terrain.TerrainTile t) {
/*  74 */       this.t = t;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/*  79 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void place(int tx, int ty, TileGrid grid, int rx, int ry) {
/*  84 */       this.t.placeFixed(tx, ty);
/*  85 */       if (this.t.clearing().isStructure()) {
/*  86 */         (SETT.GRASS()).current.set(tx, ty, 0.0D);
/*     */       }
/*     */     }
/*     */     
/*     */     public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/*  91 */       return (SPRITES.cons()).BIG.dashedThick.get(0);
/*     */     }
/*     */   }
/*     */   
/*     */   static class Floor
/*     */     implements Tile
/*     */   {
/*     */     final Floors.Floor f;
/*     */     final double degrade;
/*     */     
/*     */     Floor(Floors.Floor f) {
/* 102 */       this(f, 1.0D);
/*     */     }
/*     */     
/*     */     Floor(Floors.Floor f, double degrade) {
/* 106 */       this.f = f;
/* 107 */       this.degrade = degrade;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 112 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void place(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 117 */       this.f.placeFixed(tx, ty);
/* 118 */       if (SETT.TERRAIN().get(tx, ty).clearing().isEasilyCleared()) {
/* 119 */         (SETT.TERRAIN()).NADA.placeFixed(tx, ty);
/*     */       }
/*     */     }
/*     */     
/*     */     public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/* 124 */       return (SPRITES.cons()).BIG.dashed.get(0);
/*     */     }
/*     */   }
/*     */   
/*     */   static class Resource
/*     */     implements Tile
/*     */   {
/*     */     final RESOURCE r;
/*     */     final int amount;
/*     */     
/*     */     Resource(RESOURCE r, int amount) {
/* 135 */       this.r = r;
/* 136 */       this.amount = amount;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 142 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void place(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 147 */       (SETT.THINGS()).resources.createPrecise(tx, ty, this.r, this.amount);
/*     */     }
/*     */ 
/*     */     
/*     */     public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/* 152 */       return (SPRITES.cons()).ICO.clear;
/*     */     }
/*     */   }
/*     */   
/*     */   static class Conpound
/*     */     implements Tile
/*     */   {
/*     */     final Tile[] tiles;
/*     */     
/*     */     Conpound(Tile... tiles) {
/* 162 */       this.tiles = tiles;
/*     */     } public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/*     */       byte b;
/*     */       int i;
/*     */       Tile[] arrayOfTile;
/* 167 */       for (i = (arrayOfTile = this.tiles).length, b = 0; b < i; ) { Tile t = arrayOfTile[b];
/* 168 */         if (!t.placable(tx, ty, grid, rx, ry))
/* 169 */           return false;  b++; }
/* 170 */        return true;
/*     */     } public void place(int tx, int ty, TileGrid grid, int rx, int ry) {
/*     */       byte b;
/*     */       int i;
/*     */       Tile[] arrayOfTile;
/* 175 */       for (i = (arrayOfTile = this.tiles).length, b = 0; b < i; ) { Tile t = arrayOfTile[b];
/* 176 */         t.place(tx, ty, grid, rx, ry);
/*     */         b++; }
/*     */     
/*     */     }
/*     */     public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/* 181 */       return (SPRITES.cons()).ICO.clear;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\placers\Tiles.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */