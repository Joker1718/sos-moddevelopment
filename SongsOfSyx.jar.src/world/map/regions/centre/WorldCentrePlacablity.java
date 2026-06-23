/*     */ package world.map.regions.centre;
/*     */ 
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import view.tool.PlacableMessages;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.map.road.WTRAV;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class WorldCentrePlacablity
/*     */ {
/*     */   private static final int TILE_DIM = 3;
/*  24 */   private static final RECTANGLEE TILES = (RECTANGLEE)new Rec(3.0D, 3.0D);
/*     */   
/*     */   public static CharSequence terrainC(int tx, int ty) {
/*  27 */     return terrain(tx - 1, ty - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CharSequence terrain(int tileX1, int tileY1) {
/*  32 */     if (tileX1 < 1 || tileY1 < 1 || tileX1 + 3 >= WORLD.TWIDTH() || tileY1 + 3 >= WORLD.THEIGHT()) {
/*  33 */       return PlacableMessages.¤¤IN_MAP;
/*     */     }
/*  35 */     int cx = tileX1 + 1;
/*  36 */     int cy = tileY1 + 1;
/*     */     
/*  38 */     if (can(cx, cy) != null) {
/*  39 */       return can(cx, cy);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  44 */     boolean oneClear = false;
/*  45 */     for (int di = 0; di < DIR.ORTHO.size() && !oneClear; di++) {
/*  46 */       if (WTRAV.isGoodLandTile(cx + ((DIR)DIR.ORTHO.get(di)).x(), cy + ((DIR)DIR.ORTHO.get(di)).y()) && WTRAV.canLand(cx, cy, (DIR)DIR.ORTHO.get(di), false)) {
/*  47 */         oneClear = true;
/*     */       }
/*     */     } 
/*  50 */     if (!oneClear) {
/*  51 */       return PlacableMessages.¤¤ONE_CLEAR_TILE;
/*     */     }
/*     */     
/*  54 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static CharSequence can(int tx, int ty) {
/*  60 */     if (!WTRAV.isGoodLandTile(tx, ty) && (
/*  61 */       !(WORLD.WATER()).RIVER.is(tx, ty) || WORLD.MOUNTAIN().is(tx, ty))) {
/*  62 */       return PlacableMessages.¤¤TERRAIN_BLOCK;
/*     */     }
/*  64 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static CharSequence regionC(int tx, int ty) {
/*  69 */     return region(tx - 1, ty - 1);
/*     */   }
/*     */   
/*     */   public static CharSequence regionMiniC(int tx, int ty) {
/*  73 */     return regionMini(tx - 1, ty - 1);
/*     */   }
/*     */   
/*     */   public static CharSequence regionMini(int tileX1, int tileY1) {
/*  77 */     CharSequence t = terrain(tileX1, tileY1);
/*  78 */     if (t != null)
/*  79 */       return t; 
/*  80 */     Region r = (Region)(WORLD.REGIONS()).map.get(tileX1, tileY1);
/*  81 */     if (r == null) {
/*  82 */       return PlacableMessages.¤¤REGION;
/*     */     }
/*  84 */     for (int y = tileY1; y < tileY1 + 3; y++) {
/*  85 */       for (int x = tileX1; x < tileX1 + 3; x++) {
/*  86 */         if (r != (WORLD.REGIONS()).map.get(x, y)) {
/*  87 */           return PlacableMessages.¤¤SAME_REGION;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  92 */     return null;
/*     */   }
/*     */   
/*     */   public static CharSequence region(int tileX1, int tileY1) {
/*  96 */     CharSequence t = regionMini(tileX1, tileY1);
/*  97 */     if (t != null)
/*  98 */       return t; 
/*  99 */     Region r = (Region)(WORLD.REGIONS()).map.get(tileX1, tileY1);
/* 100 */     if (r == null) {
/* 101 */       return PlacableMessages.¤¤REGION;
/*     */     }
/* 103 */     for (int y = tileY1 - 1; y < tileY1 + 3 + 1; y++) {
/* 104 */       for (int x = tileX1 - 1; x < tileX1 + 3 + 1; x++) {
/* 105 */         if (r != (WORLD.REGIONS()).map.get(x, y) && (WORLD.REGIONS()).map.get(x, y) != null) {
/* 106 */           return PlacableMessages.¤¤SAME_REGION;
/*     */         }
/*     */       } 
/*     */     } 
/* 110 */     return null;
/*     */   }
/*     */   
/*     */   public static RECTANGLE tilesC(int cx, int cy) {
/* 114 */     TILES.moveX1Y1((cx - 1), (cy - 1));
/* 115 */     return (RECTANGLE)TILES;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\centre\WorldCentrePlacablity.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */