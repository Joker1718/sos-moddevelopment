package settlement.room.tests.production;

import settlement.room.industry.module.Industry;

public interface ProductionSpec {
  double bonus(Industry paramIndustry);
  
  double consumptionBonus(Industry paramIndustry);
  
  double wPerItemUsed();
  
  double addedW();
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\tests\production\ProductionSpec.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */