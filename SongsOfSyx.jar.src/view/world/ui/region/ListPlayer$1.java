/*    */ package view.world.ui.region;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.table.GTableBuilder;
/*    */ import view.interrupter.ISidePanel;
/*    */ import view.interrupter.ISidePanels;
/*    */ import view.main.VIEW;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GTableBuilder
/*    */ {
/*    */   public int nrOFEntries() {
/* 40 */     return FACTIONS.player().realm().regions() - 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfo(int index, GBox box) {
/* 45 */     Region reg = FACTIONS.player().realm().region(index + 1);
/* 46 */     (VIEW.world()).UI.regions.hover(reg, (GUI_BOX)box);
/*    */   }
/*    */ 
/*    */   
/*    */   public void click(int index) {
/* 51 */     Region reg = FACTIONS.player().realm().region(index + 1);
/* 52 */     (VIEW.world()).window.centererTile.set(reg.cx(), reg.cy());
/* 53 */     ISidePanel p = (VIEW.world()).UI.regions.get(reg);
/* 54 */     panels.add(ListPlayer.this, true);
/* 55 */     panels.add(p, false);
/* 56 */     super.click(index);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean selectedIs(int index) {
/* 61 */     Region reg = FACTIONS.player().realm().region(index + 1);
/* 62 */     return (VIEW.world()).UI.regions.active(reg);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\ListPlayer$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */