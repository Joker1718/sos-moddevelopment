/*    */ package view.world.ui.panels;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import util.data.GETTER;
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
/*    */   extends GuiSection
/*    */ {
/*    */   protected void clickA() {
/* 54 */     Region r = FACTIONS.player().realm().region(((Integer)ier.get()).intValue() + 1);
/* 55 */     if (r != null) {
/* 56 */       ISidePanel pp = (VIEW.world()).UI.regions.get(r);
/* 57 */       panels.clear();
/* 58 */       panels.add(UIAdminPanel.null.access$0(UIAdminPanel.null.this), true);
/* 59 */       panels.add(pp, false);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 64 */     Region r = FACTIONS.player().realm().region(((Integer)ier.get()).intValue() + 1);
/* 65 */     if (r != null)
/* 66 */       (VIEW.world()).UI.regions.hover(r, text); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\panels\UIAdminPanel$3$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */