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
/*    */ class null
/*    */   implements Tile
/*    */ {
/*    */   public void place(int tx, int ty, TileGrid grid, int rx, int ry) {}
/*    */   
/*    */   public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 20 */     return !(SETT.PATH()).solidity.is(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/* 25 */     return (SPRITES.cons()).BIG.dashed.get(0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\placers\Tiles$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */