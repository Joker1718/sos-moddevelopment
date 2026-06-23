/*    */ package settlement.misc.placers;
/*    */ 
/*    */ import snake2d.util.datatypes.DIMENSION;
/*    */ import snake2d.util.map.MAP_BOOLEAN;
/*    */ import snake2d.util.map.MAP_OBJECT;
/*    */ 
/*    */ final class TileGrid implements MAP_OBJECT<Tile>, DIMENSION {
/*    */   private final Tile[][] tiles;
/*    */   
/* 10 */   final MAP_BOOLEAN isIn = new MAP_BOOLEAN()
/*    */     {
/*    */       public boolean is(int tx, int ty)
/*    */       {
/* 14 */         if (tx < 0 || tx >= (TileGrid.this.tiles[0]).length)
/* 15 */           return false; 
/* 16 */         if (ty < 0 || ty >= TileGrid.this.tiles.length)
/* 17 */           return false; 
/* 18 */         return true;
/*    */       }
/*    */ 
/*    */       
/*    */       public boolean is(int tile) {
/* 23 */         throw new RuntimeException();
/*    */       }
/*    */     };
/*    */   
/*    */   public TileGrid(Tile[][] tiles) {
/* 28 */     this.tiles = tiles;
/*    */   }
/*    */ 
/*    */   
/*    */   public Tile get(int tile) {
/* 33 */     throw new RuntimeException();
/*    */   }
/*    */ 
/*    */   
/*    */   public Tile get(int tx, int ty) {
/* 38 */     if (tx < 0 || tx >= (this.tiles[0]).length)
/* 39 */       return null; 
/* 40 */     if (ty < 0 || ty >= this.tiles.length)
/* 41 */       return null; 
/* 42 */     return this.tiles[ty][tx];
/*    */   }
/*    */ 
/*    */   
/*    */   public int width() {
/* 47 */     return (this.tiles[0]).length;
/*    */   }
/*    */ 
/*    */   
/*    */   public int height() {
/* 52 */     return this.tiles.length;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\placers\TileGrid.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */