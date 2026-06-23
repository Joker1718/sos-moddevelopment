package view.world.ui.region;

import util.gui.misc.GBox;
import view.interrupter.ISidePanel;
import view.interrupter.ISidePanels;
import world.map.regions.Region;

interface RV {
  ISidePanel get(Region paramRegion);
  
  void hover(GBox paramGBox, Region paramRegion);
  
  void hoverGarrison(GBox paramGBox, Region paramRegion);
  
  boolean added(ISidePanels paramISidePanels, Region paramRegion);
}


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\RV.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */