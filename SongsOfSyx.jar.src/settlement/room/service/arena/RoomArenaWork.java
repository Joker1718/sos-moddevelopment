package settlement.room.service.arena;

import settlement.room.main.RoomInstance;
import snake2d.util.datatypes.COORDINATE;
import snake2d.util.datatypes.RECTANGLE;

public interface RoomArenaWork {
  COORDINATE gladiatorGetSpot(RoomInstance paramRoomInstance);
  
  RECTANGLE gladiatorArea(int paramInt1, int paramInt2);
  
  boolean gladiatorInArena(int paramInt1, int paramInt2);
  
  void gladiatorDrawMakeSheer(COORDINATE paramCOORDINATE);
  
  RoomInstance reserveDeath(COORDINATE paramCOORDINATE);
  
  void unreserveDeath(int paramInt1, int paramInt2);
  
  int executions();
  
  int executionsMax();
  
  int executions(RoomInstance paramRoomInstance);
  
  int executionsMax(RoomInstance paramRoomInstance);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\RoomArenaWork.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */