package game.battle.formation;

import snake2d.util.datatypes.COORDINATE;

public interface DivPosition {
  COORDINATE tile(int paramInt);
  
  COORDINATE pixel(int paramInt);
  
  int px(int paramInt);
  
  int py(int paramInt);
  
  int tx(int paramInt);
  
  int ty(int paramInt);
  
  int deployed();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\formation\DivPosition.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */