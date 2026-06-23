package util.statistics;

import util.data.INT_O;

public interface HISTORY_COLLECTION<T> extends INT_O<T> {
  HISTORY_INT history(T paramT);
  
  HISTORY_INT total();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\statistics\HISTORY_COLLECTION.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */