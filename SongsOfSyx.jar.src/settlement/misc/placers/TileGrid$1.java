/*    */ package settlement.misc.placers;
/*    */ 
/*    */ import snake2d.util.map.MAP_BOOLEAN;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements MAP_BOOLEAN
/*    */ {
/*    */   public boolean is(int tx, int ty) {
/* 14 */     if (tx < 0 || tx >= (TileGrid.this.tiles[0]).length)
/* 15 */       return false; 
/* 16 */     if (ty < 0 || ty >= TileGrid.this.tiles.length)
/* 17 */       return false; 
/* 18 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(int tile) {
/* 23 */     throw new RuntimeException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\placers\TileGrid$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */