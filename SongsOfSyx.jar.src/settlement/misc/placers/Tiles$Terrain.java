/*    */ package settlement.misc.placers;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class Terrain
/*    */   implements Tile
/*    */ {
/*    */   final settlement.tilemap.terrain.Terrain.TerrainTile t;
/*    */   
/*    */   Terrain(settlement.tilemap.terrain.Terrain.TerrainTile t) {
/* 74 */     this.t = t;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 79 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void place(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 84 */     this.t.placeFixed(tx, ty);
/* 85 */     if (this.t.clearing().isStructure()) {
/* 86 */       (SETT.GRASS()).current.set(tx, ty, 0.0D);
/*    */     }
/*    */   }
/*    */   
/*    */   public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/* 91 */     return (SPRITES.cons()).BIG.dashedThick.get(0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\placers\Tiles$Terrain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */