package settlement.room.industry.module;

import game.boosting.Boostable;
import snake2d.util.sets.LIST;

public interface IndustryRate {
  LIST<RoomBoost> boosts();
  
  Boostable bonus();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\IndustryRate.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */