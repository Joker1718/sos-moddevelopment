package settlement.room.main;

import java.io.IOException;
import snake2d.util.file.FileGetter;
import snake2d.util.file.FilePutter;

public abstract class RoomResource {
  protected abstract void save(FilePutter paramFilePutter);
  
  protected abstract void load(FileGetter paramFileGetter) throws IOException;
  
  protected abstract void clear();
  
  protected abstract void update(double paramDouble);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\ROOMS$RoomResource.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */