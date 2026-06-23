/*    */ package settlement.misc.placers;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.tilemap.terrain.Terrain;
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
/*    */ class null
/*    */   extends Tiles.Terrain
/*    */ {
/*    */   null(Terrain.TerrainTile $anonymous0) {
/* 47 */     super($anonymous0);
/*    */   }
/*    */   public void place(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 50 */     if ((SETT.TERRAIN()).CAVE.is(tx, ty))
/*    */       return; 
/* 52 */     super.place(tx, ty, grid, rx, ry);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\placers\PlacerLanding$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */