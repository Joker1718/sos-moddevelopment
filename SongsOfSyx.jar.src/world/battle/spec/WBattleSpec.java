package world.battle.spec;

public abstract class WBattleSpec {
  public WBattleSide player;
  
  public WBattleSide enemy;
  
  public boolean victory;
  
  public abstract void retreat();
  
  public abstract void auto();
  
  public abstract void engage();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\spec\WBattleSpec.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */