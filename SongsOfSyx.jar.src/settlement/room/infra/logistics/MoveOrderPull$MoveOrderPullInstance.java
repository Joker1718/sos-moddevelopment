package settlement.room.infra.logistics;

import init.resources.RBIT;

public interface MoveOrderPullInstance {
  MoveOrderPull[] moveOrdersPull();
  
  RBIT moveOrderPullAccepted();
  
  RBIT moveOrderPullAvailable();
  
  int moveMinAmount();
  
  int moveMaxRadius();
  
  void copyFrom(MoveOrderPullInstance paramMoveOrderPullInstance);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPull$MoveOrderPullInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */