/*    */ package view.sett.ui.room;
/*    */ 
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ 
/*    */ final class Modules
/*    */ {
/*    */   private final ModuleMaker[] makers;
/*    */   
/*    */   Modules(Init init) {
/* 13 */     this.makers = new ModuleMaker[] {
/*    */         
/* 15 */         new ModuleInstance(init), 
/* 16 */         new ModuleEmployment(init), 
/* 17 */         new ModuleRadius(init), 
/* 18 */         new ModuleDegrade(init), 
/* 19 */         new ModuleUpgradable(init), 
/* 20 */         new ModulePumpable(init), 
/* 21 */         new ModuleIrrigated(init), 
/*    */         
/* 23 */         new ModuleService(init), 
/* 24 */         new ModuleIndustry(init), 
/* 25 */         new ModuleGrave(init), 
/* 26 */         new ModuleConstructor(init), 
/* 27 */         new ModulePunish(init)
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   UIRoomModule[] get(RoomBlueprint p) {
/* 33 */     ArrayList<UIRoomModule> apps = new ArrayList(32); byte b; int j;
/*    */     ModuleMaker[] arrayOfModuleMaker;
/* 35 */     for (j = (arrayOfModuleMaker = this.makers).length, b = 0; b < j; ) { ModuleMaker m = arrayOfModuleMaker[b];
/* 36 */       m.make(p, (LISTE<UIRoomModule>)apps);
/*    */       b++; }
/*    */     
/* 39 */     p.appendView((LISTE)apps);
/* 40 */     UIRoomModule[] as = new UIRoomModule[apps.size()];
/* 41 */     for (int i = 0; i < apps.size(); i++) {
/* 42 */       as[i] = (UIRoomModule)apps.get(i);
/*    */     }
/*    */     
/* 45 */     return as;
/*    */   }
/*    */   
/*    */   static interface ModuleMaker {
/*    */     void make(RoomBlueprint param1RoomBlueprint, LISTE<UIRoomModule> param1LISTE);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\Modules.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */