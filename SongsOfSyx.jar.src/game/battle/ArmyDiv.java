package game.battle;

import java.io.IOException;
import snake2d.util.file.FileGetter;
import snake2d.util.file.FilePutter;

public abstract class ArmyDiv {
  protected abstract void save(FilePutter paramFilePutter);
  
  protected abstract void load(FileGetter paramFileGetter) throws IOException;
  
  protected abstract void clear();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\ArmyDiv.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */