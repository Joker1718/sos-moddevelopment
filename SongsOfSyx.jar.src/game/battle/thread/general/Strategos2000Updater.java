package game.battle.thread.general;

import snake2d.Renderer;
import snake2d.util.file.SAVABLE;
import util.rendering.RenderData;
import util.rendering.ShadowBatch;

public abstract class Strategos2000Updater implements SAVABLE {
  public abstract boolean update();
  
  public abstract void render(Renderer paramRenderer, RenderData.RenderIterator paramRenderIterator);
  
  public abstract void render(Renderer paramRenderer, ShadowBatch paramShadowBatch, RenderData paramRenderData);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\Strategos2000Updater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */