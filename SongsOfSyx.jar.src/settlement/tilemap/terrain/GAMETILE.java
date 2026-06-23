package settlement.tilemap.terrain;

import snake2d.util.sprite.SPRITE;

interface GAMETILE {
  boolean isPlacable(int paramInt1, int paramInt2);
  
  void placeFixed(int paramInt1, int paramInt2);
  
  SPRITE getIcon();
  
  CharSequence name();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\GAMETILE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */