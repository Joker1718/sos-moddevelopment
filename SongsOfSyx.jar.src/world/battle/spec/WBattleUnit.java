package world.battle.spec;

import snake2d.util.gui.GUI_BOX;
import snake2d.util.sprite.SPRITE;

public interface WBattleUnit {
  CharSequence name();
  
  int men();
  
  int losses();
  
  int lossesRetreat();
  
  SPRITE icon();
  
  void hover(GUI_BOX paramGUI_BOX);
  
  double defences();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\spec\WBattleUnit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */