package settlement.maintenance;

import init.resources.RESOURCE;

abstract class MType {
  public abstract boolean validate(int paramInt1, int paramInt2);
  
  public abstract boolean degrade(int paramInt1, int paramInt2, int paramInt3, double paramDouble);
  
  public abstract void maintain(int paramInt1, int paramInt2);
  
  public abstract void vandalize(int paramInt1, int paramInt2);
  
  public abstract boolean shouldPlace(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract int shouldPlaceResource(int paramInt1, int paramInt2);
  
  public abstract RESOURCE res(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract double resRate(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract double degrade(int paramInt1, int paramInt2);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\maintenance\MType.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */