package settlement.tilemap;

import settlement.job.Job;
import settlement.tilemap.terrain.Terrain;

public interface TILE_FIXABLE {
  Job fixJob(int paramInt1, int paramInt2);
  
  Terrain.TerrainTile getTerrain(int paramInt1, int paramInt2);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\TILE_FIXABLE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */