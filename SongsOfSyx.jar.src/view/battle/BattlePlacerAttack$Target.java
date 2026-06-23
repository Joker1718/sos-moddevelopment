package view.battle;

import snake2d.Renderer;
import util.gui.misc.GBox;
import util.rendering.RenderData;
import util.rendering.ShadowBatch;

abstract class Target {
  abstract boolean set();
  
  abstract CharSequence name();
  
  abstract void problem(GBox paramGBox);
  
  abstract void click();
  
  abstract void render(Renderer paramRenderer, ShadowBatch paramShadowBatch, RenderData paramRenderData);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattlePlacerAttack$Target.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */