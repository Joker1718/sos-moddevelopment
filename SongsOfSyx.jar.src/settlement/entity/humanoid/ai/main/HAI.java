package settlement.entity.humanoid.ai.main;

import init.resources.RESOURCE;
import settlement.entity.humanoid.Humanoid;
import snake2d.util.datatypes.COORDINATE;
import snake2d.util.sprite.text.Str;
import util.gui.misc.GBox;

public interface HAI {
  RESOURCE resourceCarried();
  
  int resourceA();
  
  void getOccupation(Humanoid paramHumanoid, Str paramStr);
  
  COORDINATE getDestination();
  
  void hoverInfoSet(Humanoid paramHumanoid, GBox paramGBox);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\HAI.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */