package settlement.room.infra.logistics;

import init.resources.RBIT;

public interface MoveOrderPushInstance {
  MoveOrderPush[] moveOrdersPush();
  
  RBIT moveOrderPushCapacity();
  
  RBIT moveOrderPushAvailable();
  
  int moveMinAmount();
  
  int moveMaxRadius();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPush$MoveOrderPushInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */