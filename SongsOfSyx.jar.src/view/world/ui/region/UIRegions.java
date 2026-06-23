/*    */ package view.world.ui.region;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import util.gui.misc.GBox;
/*    */ import view.interrupter.ISidePanel;
/*    */ import view.interrupter.ISidePanels;
/*    */ import view.tool.ToolManager;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ 
/*    */ public final class UIRegions
/*    */ {
/*    */   private final Other other;
/*    */   final Play player;
/*    */   final PlayCapitol cap;
/*    */   public final ISidePanel playerList;
/*    */   public final ISidePanel allList;
/*    */   private final ISidePanels panels;
/*    */   
/*    */   public UIRegions(ISidePanels panels, ToolManager tools) {
/* 22 */     this.playerList = new ListPlayer(panels);
/* 23 */     this.allList = new ListAll();
/* 24 */     this.player = new Play(tools, panels);
/* 25 */     this.other = new Other(tools, panels);
/* 26 */     this.cap = new PlayCapitol(tools, panels);
/* 27 */     this.panels = panels;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void open(Region reg) {
/* 33 */     this.panels.add(get(reg), true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ISidePanel get(Region reg) {
/* 40 */     if (reg.faction() == FACTIONS.player()) {
/* 41 */       if (reg.capitol())
/* 42 */         return this.cap.get(reg); 
/* 43 */       return this.player.get(reg);
/*    */     } 
/* 45 */     return this.other.get(reg);
/*    */   }
/*    */ 
/*    */   
/*    */   private RV getp(Region reg) {
/* 50 */     if (reg.faction() == FACTIONS.player()) {
/* 51 */       if (reg.capitol())
/* 52 */         return this.cap; 
/* 53 */       return this.player;
/*    */     } 
/* 55 */     return this.other;
/*    */   }
/*    */ 
/*    */   
/*    */   public void hover(Region reg, GUI_BOX b) {
/* 60 */     getp(reg).hover((GBox)b, reg);
/*    */   }
/*    */   
/*    */   public void hoverGarrison(Region reg, GUI_BOX b) {
/* 64 */     getp(reg).hoverGarrison((GBox)b, reg);
/*    */   }
/*    */ 
/*    */   
/*    */   public void open(Region reg, boolean disturb) {
/* 69 */     this.panels.add(get(reg), disturb);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void openPlayerList() {
/* 75 */     this.panels.add(this.playerList, true);
/*    */   }
/*    */   
/*    */   public void openOtherList() {
/* 79 */     this.panels.add(this.allList, true);
/*    */   }
/*    */   
/*    */   boolean active(Region reg) {
/* 83 */     return !(!this.cap.added(this.panels, reg) && !this.player.added(this.panels, reg) && !this.other.added(this.panels, reg));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\UIRegions.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */