package snake2d;

import snake2d.util.sets.LIST;

public abstract class CORE_STATE {
  protected abstract void update(float paramFloat, double paramDouble);
  
  protected abstract void keyPush(LIST<KeyBoard.KeyEvent> paramLIST, boolean paramBoolean);
  
  protected abstract void mouseClick(MButt paramMButt);
  
  protected abstract void render(Renderer paramRenderer, float paramFloat);
  
  public static interface Constructor {
    CORE_STATE getState();
    
    default void doAfterSet() {}
  }
  
  protected void exit() {}
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\CORE_STATE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */