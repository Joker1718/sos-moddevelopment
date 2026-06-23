/*    */ package settlement.misc.placers;
/*    */ 
/*    */ import init.sprite.SPRITES;
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
/*    */ class null
/*    */   implements Tile
/*    */ {
/*    */   public void place(int tx, int ty, TileGrid grid, int rx, int ry) {}
/*    */   
/*    */   public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 56 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/* 61 */     return (SPRITES.cons()).BIG.dashed.get(0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\placers\Tiles$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */