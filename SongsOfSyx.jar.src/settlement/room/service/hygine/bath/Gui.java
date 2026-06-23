/*    */ package settlement.room.service.hygine.bath;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sets.Stack;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GGrid;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import view.sett.ui.room.UIRoomModule;
/*    */ 
/*    */ class Gui extends UIRoomModule.UIRoomModuleImp<BathInstance, ROOM_BATH> {
/*    */   Gui(ROOM_BATH s) {
/* 17 */     super(s);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void problem(BathInstance i, Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings) {
/* 22 */     if (i.getHeat() < 1.0D) {
/* 23 */       errors.add(((ROOM_BATH)this.blueprint).sHeatingProblem);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 30 */     super.problem(i, free, errors, warnings);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<BathInstance> getter, int x1, int y1) {
/* 37 */     grid.add((RENDEROBJ)(new GStat()
/*    */         {
/*    */           public void update(GText text) {
/* 40 */             GFORMAT.perc(text, ((BathInstance)getter.get()).getHeat());
/*    */           }
/* 42 */         }).hh(((ROOM_BATH)this.blueprint).sHeating).hoverInfoSet(((ROOM_BATH)this.blueprint).sHeatingDesc));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\bath\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */