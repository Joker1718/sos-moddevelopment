package settlement.room.main.job;

import settlement.room.main.Room;

public interface ROOM_RADIUS {
  public static interface ROOM_RADIUSE extends ROOM_RADIUS {
    ROOM_RADIUS.ROOM_RADIUS_INSTANCE radiusInstance(Room param1Room);
  }
  
  public static interface ROOM_RADIUS_INSTANCE {
    int radius();
    
    boolean searching();
    
    byte radiusRaw();
    
    void radiusRawSet(byte param1Byte);
  }
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\job\ROOM_RADIUS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */