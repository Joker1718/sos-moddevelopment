package view.tool;

import snake2d.SPRITE_RENDERER;
import snake2d.util.gui.clickable.CLICKABLE;
import snake2d.util.sets.LIST;
import view.subview.GameWindow;

abstract class placeFunc {
  abstract void updateHovered(float paramFloat, GameWindow paramGameWindow, boolean paramBoolean);
  
  void update(float ds, GameWindow window, boolean pressed) {}
  
  abstract void render(SPRITE_RENDERER paramSPRITE_RENDERER, float paramFloat, GameWindow paramGameWindow);
  
  abstract void click(GameWindow paramGameWindow);
  
  abstract void clickRelease(GameWindow paramGameWindow);
  
  abstract void activate(PLACABLE paramPLACABLE, GameWindow paramGameWindow);
  
  abstract LIST<CLICKABLE> gui();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\ToolPlacer$placeFunc.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */