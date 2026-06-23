package view.ui.util;

import snake2d.util.datatypes.RECTANGLE;
import view.subview.GameWindow;

abstract class Mode {
  public abstract GameWindow window();
  
  public abstract void render(RECTANGLE paramRECTANGLE);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\u\\util\VideoMaker$Mode.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */