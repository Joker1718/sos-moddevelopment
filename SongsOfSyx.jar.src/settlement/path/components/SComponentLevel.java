package settlement.path.components;

import snake2d.util.map.MAP_OBJECT;

public abstract class SComponentLevel implements MAP_OBJECT<SComponent> {
  public abstract int componentsMax();
  
  public abstract SComponent getByIndex(int paramInt);
  
  protected abstract void update();
  
  public abstract int level();
  
  public abstract int size();
  
  protected abstract void init();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SComponentLevel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */