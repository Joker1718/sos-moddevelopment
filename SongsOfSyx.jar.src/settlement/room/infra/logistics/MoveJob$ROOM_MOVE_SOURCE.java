package settlement.room.infra.logistics;

import init.resources.RBIT;
import init.resources.RESOURCE;
import settlement.misc.util.RESOURCE_TILE;

public interface ROOM_MOVE_SOURCE {
  RESOURCE_TILE sourceCrate(RBIT paramRBIT, int paramInt1, int paramInt2, int paramInt3, double paramDouble);
  
  RBIT sourceAmountMask();
  
  RBIT moveCapacity();
  
  int moveCapacityAm(RESOURCE paramRESOURCE);
  
  double storedD(RESOURCE paramRESOURCE);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveJob$ROOM_MOVE_SOURCE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */