/*    */ package view.world;
/*    */ 
/*    */ import view.interrupter.ISidePanels;
/*    */ import view.interrupter.InterManager;
/*    */ import view.tool.ToolManager;
/*    */ import view.world.ui.army.UIArmies;
/*    */ import view.world.ui.battle.UIWBattlePrompt;
/*    */ import view.world.ui.camps.UICampList;
/*    */ import view.world.ui.faction.UIFactions;
/*    */ import view.world.ui.region.UIRegions;
/*    */ 
/*    */ public class WorldUI
/*    */ {
/*    */   public final UIRegions regions;
/* 15 */   public final UIArmies armies = new UIArmies();
/* 16 */   public final UICampList camps = new UICampList();
/* 17 */   public final UIWBattlePrompt battle = new UIWBattlePrompt();
/* 18 */   public final UIFactions factions = new UIFactions();
/*    */   
/*    */   WorldUI(InterManager m, ISidePanels panels, ToolManager tools) {
/* 21 */     this.regions = new UIRegions(panels, tools);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\WorldUI.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */