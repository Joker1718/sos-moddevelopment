package game.faction.trade;

import game.faction.Faction;
import init.trade.TRADE_TYPE;

public interface FSELLER {
  int removePrice(int paramInt);
  
  int removeMax();
  
  void remove(int paramInt1, TRADE_TYPE paramTRADE_TYPE, int paramInt2, Faction paramFaction);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\trade\FSELLER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */