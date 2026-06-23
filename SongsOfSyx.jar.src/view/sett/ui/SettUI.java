/*    */ package view.sett.ui;
/*    */ 
/*    */ import game.GAME;
/*    */ import init.type.HCLASSES;
/*    */ import view.interrupter.InterManager;
/*    */ import view.sett.ui.army.UIArmy;
/*    */ import view.sett.ui.bottom.UIBuildPanel;
/*    */ import view.sett.ui.food.UIFood;
/*    */ import view.sett.ui.home.UIHomes;
/*    */ import view.sett.ui.law.UILaw;
/*    */ import view.sett.ui.noble.UINobles;
/*    */ import view.sett.ui.room.UIRooms;
/*    */ import view.sett.ui.room.construction.UIRoomPlacer;
/*    */ import view.sett.ui.room.copy.UICopier;
/*    */ import view.sett.ui.room.prints.UISavedPrints;
/*    */ import view.sett.ui.standing.UICitizens;
/*    */ import view.sett.ui.subject.UISubjects;
/*    */ 
/*    */ public final class SettUI
/*    */ {
/* 21 */   public final UIRooms rooms = new UIRooms();
/* 22 */   public final UISubjects subjects = new UISubjects();
/* 23 */   public final UIArmy army = new UIArmy(GAME.ARMIES());
/* 24 */   public final UICitizens standing = new UICitizens(HCLASSES.CITIZEN());
/* 25 */   public final UICitizens slaves = new UICitizens(HCLASSES.SLAVE());
/* 26 */   public final UINobles nobles = new UINobles();
/* 27 */   public final UILaw law = new UILaw();
/* 28 */   public final UIHomes home = new UIHomes();
/* 29 */   public final UIFood prod = new UIFood();
/* 30 */   public final UIRoomPlacer placer = new UIRoomPlacer();
/* 31 */   public final UISavedPrints prints = new UISavedPrints();
/* 32 */   public final UICopier copier = new UICopier();
/*    */   
/*    */   public final UIBuildPanel bottom;
/*    */   
/*    */   public SettUI(InterManager m) {
/* 37 */     this.bottom = new UIBuildPanel(this.placer, m);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\SettUI.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */