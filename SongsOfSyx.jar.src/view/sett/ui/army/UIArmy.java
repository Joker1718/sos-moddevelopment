/*    */ package view.sett.ui.army;
/*    */ import game.GAME;
/*    */ import game.battle.Armies;
/*    */ import game.battle.div.Div;
/*    */ import init.constant.Config;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import util.text.Dic;
/*    */ import view.interrupter.ISidePanel;
/*    */ import view.sett.IDebugPanelSett;
/*    */ import view.tool.PLACABLE;
/*    */ 
/*    */ public final class UIArmy extends ISidePanel {
/*    */   public UIArmy(Armies m) {
/* 16 */     titleSet(Dic.¤¤Conscripts);
/*    */     
/* 18 */     ArrayList<Div> selection = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*    */     
/* 20 */     this.section.add((RENDEROBJ)new Info());
/* 21 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)new Actions(selection));
/* 22 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)new DivList(HEIGHT - this.section.body().height() - 16, selection));
/*    */     
/* 24 */     IDebugPanelSett.add((PLACABLE)new FormationDebugPlacer(GAME.ARMIES().player()));
/* 25 */     IDebugPanelSett.add((PLACABLE)new FormationDebugPlacer(GAME.ARMIES().enemy()));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\UIArmy.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */