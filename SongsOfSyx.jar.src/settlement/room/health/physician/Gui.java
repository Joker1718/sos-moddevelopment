/*    */ package settlement.room.health.physician;
/*    */ 
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GGrid;
/*    */ import util.gui.table.GTableSorter;
/*    */ import view.sett.ui.room.UIRoomBulkApplier;
/*    */ import view.sett.ui.room.UIRoomModule;
/*    */ 
/*    */ 
/*    */ class Gui
/*    */   extends UIRoomModule.UIRoomModuleImp<Instance, ROOM_PHYSICIAN>
/*    */ {
/*    */   Gui(ROOM_PHYSICIAN s) {
/* 18 */     super(s);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void hover(GBox box, Instance i) {
/* 25 */     super.hover(box, i);
/*    */   }
/*    */   
/*    */   protected void appendPanel(GuiSection section, GGrid grid, GETTER<Instance> getter, int x1, int y1) {}
/*    */   
/*    */   protected void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\physician\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */