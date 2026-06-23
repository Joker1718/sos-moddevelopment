package settlement.misc.util;

import snake2d.util.datatypes.COORDINATE;

public interface FINDABLE extends COORDINATE {
  boolean findableReservedCanBe();
  
  void findableReserve();
  
  boolean findableReservedIs();
  
  void findableReserveCancel();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\mis\\util\FINDABLE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */