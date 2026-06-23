package view.subview;

import snake2d.util.datatypes.Coo;

abstract class SubMouse extends Coo implements GameWindow.SUB_MOUSE {
  private static final long serialVersionUID = 4936922844334905532L;
  
  protected abstract void update();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\subview\GameWindow$SubMouse.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */