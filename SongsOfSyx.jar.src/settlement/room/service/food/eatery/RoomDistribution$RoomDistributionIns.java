package settlement.room.service.food.eatery;

import settlement.misc.job.JOBMANAGER_HASER;
import settlement.room.service.module.ROOM_SERVICER;

public interface RoomDistributionIns extends JOBMANAGER_HASER, ROOM_SERVICER {
  RoomDistribution.InstanceData distributionData();
  
  RoomDistribution distributionNlueData();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\eatery\RoomDistribution$RoomDistributionIns.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */