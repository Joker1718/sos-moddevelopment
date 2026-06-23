package settlement.path.finders;

import game.battle.Army;
import settlement.entity.humanoid.Humanoid;
import settlement.misc.util.FINDABLE;
import snake2d.util.datatypes.DIR;

public interface FINDABLE_MANNING extends FINDABLE {
  DIR faceDIR();
  
  void work(double paramDouble, Humanoid paramHumanoid);
  
  boolean needsWork();
  
  Army army();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderSoldierManning$FINDABLE_MANNING.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */