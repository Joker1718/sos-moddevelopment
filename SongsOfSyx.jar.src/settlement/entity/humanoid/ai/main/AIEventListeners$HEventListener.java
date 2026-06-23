package settlement.entity.humanoid.ai.main;

import settlement.entity.humanoid.HEvent;
import settlement.entity.humanoid.HPoll;
import settlement.entity.humanoid.Humanoid;

public interface HEventListener {
  boolean event(Humanoid paramHumanoid, AIManager paramAIManager, HEvent.HEventData paramHEventData);
  
  double poll(Humanoid paramHumanoid, AIManager paramAIManager, HPoll.HPollData paramHPollData);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIEventListeners$HEventListener.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */