package world.battle.spec;

import snake2d.util.datatypes.COORDINATE;
import snake2d.util.sets.LIST;
import world.army.ADSupplies;

public interface WBattleSide {
  COORDINATE coo();
  
  int men();
  
  int losses();
  
  int lossesRetreat();
  
  LIST<WBattleUnit> units();
  
  int artillery(ADSupplies.ADArtillery paramADArtillery);
  
  double powerBalance();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\spec\WBattleSide.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */