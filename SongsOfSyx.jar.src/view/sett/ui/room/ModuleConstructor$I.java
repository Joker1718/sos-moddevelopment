/*    */ package view.sett.ui.room;
/*    */ 
/*    */ import settlement.environment.SettEnvMap;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.main.furnisher.Furnisher;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.table.GTableSorter;
/*    */ import util.text.Dic;
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
/*    */ final class I
/*    */   extends UIRoomModule
/*    */ {
/*    */   public void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*    */   
/*    */   public void hover(GBox box, Room room, int rx, int ry) {
/* 50 */     Furnisher f = room.constructor();
/* 51 */     if (f != null) {
/* 52 */       boolean has = false;
/* 53 */       for (SettEnvMap.SettEnv e : (SETT.ENV()).map.all()) {
/* 54 */         if (f.envValue(e)) {
/* 55 */           if (!has) {
/* 56 */             box.NL(8);
/* 57 */             box.textL(Dic.¤¤Emits);
/* 58 */             box.NL();
/*    */           } 
/* 60 */           box.text(e.info.name);
/*    */         } 
/*    */       } 
/* 63 */       if (has)
/* 64 */         box.NL(8); 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void appendPanel(GuiSection section, GETTER<RoomInstance> get, int x1, int y1) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleConstructor$I.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */