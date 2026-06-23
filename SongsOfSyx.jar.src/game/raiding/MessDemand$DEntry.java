package game.raiding;

abstract class DEntry {
  int value;
  
  int current;
  
  abstract void add(MessDemand.Demand paramDemand, int paramInt);
  
  abstract int max();
  
  abstract double value();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\MessDemand$DEntry.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */