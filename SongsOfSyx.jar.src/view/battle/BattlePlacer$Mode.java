package view.battle;

import snake2d.Renderer;
import util.gui.misc.GBox;
import util.rendering.RenderData;
import util.rendering.ShadowBatch;

abstract class Mode {
  abstract void update(boolean paramBoolean);
  
  abstract void hoverTimer(GBox paramGBox);
  
  abstract void render(Renderer paramRenderer, ShadowBatch paramShadowBatch, RenderData paramRenderData, double paramDouble);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattlePlacer$Mode.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */