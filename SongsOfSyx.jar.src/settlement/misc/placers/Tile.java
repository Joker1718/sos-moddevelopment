package settlement.misc.placers;

import snake2d.util.sprite.SPRITE;

interface Tile {
  boolean placable(int paramInt1, int paramInt2, TileGrid paramTileGrid, int paramInt3, int paramInt4);
  
  void place(int paramInt1, int paramInt2, TileGrid paramTileGrid, int paramInt3, int paramInt4);
  
  SPRITE sprite(TileGrid paramTileGrid, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\placers\Tile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */