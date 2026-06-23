package util.data;

public interface LONG_O<T> {
  long get(T paramT);
  
  public static interface LONG_OE<T> extends LONG_O<T> {
    void set(T param1T, long param1Long);
  }
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\LONG_O.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */