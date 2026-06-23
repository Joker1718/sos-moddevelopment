package game.faction;

import java.io.IOException;
import snake2d.util.file.FileGetter;
import snake2d.util.file.FilePutter;

public abstract class FactionResource {
  protected abstract void save(FilePutter paramFilePutter);
  
  protected abstract void load(FileGetter paramFileGetter) throws IOException;
  
  protected abstract void clear();
  
  protected abstract void update(double paramDouble, Faction paramFaction);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\FactionResource.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */