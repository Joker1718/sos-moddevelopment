package settlement.misc.job;

import init.resources.RBIT;
import init.resources.RESOURCE;
import snake2d.util.datatypes.COORDINATE;

public interface JOB_MANAGER {
  SETT_JOB getReservableJob(COORDINATE paramCOORDINATE);
  
  SETT_JOB reportResourceMissing(RBIT paramRBIT, int paramInt1, int paramInt2);
  
  void reportResourceFound(RESOURCE paramRESOURCE);
  
  boolean resourceReachable(RESOURCE paramRESOURCE);
  
  boolean resourceShouldSearch(RESOURCE paramRESOURCE);
  
  void resetResourceSearch();
  
  SETT_JOB getJob(COORDINATE paramCOORDINATE);
  
  public static interface JOB_GETTER {
    SETT_JOB init(int param1Int1, int param1Int2);
  }
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\job\JOB_MANAGER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */