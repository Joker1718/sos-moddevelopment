package world.region.updating;

import init.race.Race;
import init.religion.Religion;
import init.trade.TRADABLE;
import world.map.regions.Region;

public interface RealmBuilder {
  double policy(Race paramRace, Region paramRegion);
  
  double priority(TRADABLE paramTRADABLE, Region paramRegion);
  
  double priority(Religion paramReligion, Region paramRegion);
  
  double military(Region paramRegion);
  
  double size();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\regio\\updating\RealmBuilder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */