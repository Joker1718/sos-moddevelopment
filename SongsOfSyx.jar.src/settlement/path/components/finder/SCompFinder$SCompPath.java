package settlement.path.components.finder;

import settlement.path.components.SComponent;
import snake2d.util.map.MAP_BOOLEAN;
import snake2d.util.sets.LIST;

public interface SCompPath extends MAP_BOOLEAN {
  LIST<SComponent> path();
  
  double distance();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\finder\SCompFinder$SCompPath.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */