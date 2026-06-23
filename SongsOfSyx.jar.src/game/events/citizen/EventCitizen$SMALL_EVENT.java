package game.events.citizen;

import init.race.Race;
import snake2d.util.file.SAVABLE;

interface SMALL_EVENT extends SAVABLE {
  boolean event(int paramInt, Race paramRace);
  
  void update(double paramDouble);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\citizen\EventCitizen$SMALL_EVENT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */