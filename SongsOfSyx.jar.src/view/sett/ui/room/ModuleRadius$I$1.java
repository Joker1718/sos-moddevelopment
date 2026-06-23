/*    */ package view.sett.ui.room;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.main.job.ROOM_RADIUS;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import util.data.GETTER;
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
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 73 */     text.title((ModuleRadius.I.access$0(ModuleRadius.I.this)).¤¤NAME);
/* 74 */     text.text((ModuleRadius.I.access$0(ModuleRadius.I.this)).¤¤DESC);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 79 */     (ModuleRadius.I.access$0(ModuleRadius.I.this)).i = (RoomInstance)get.get();
/* 80 */     SETT.OVERLAY().roomRadius((RoomInstance)get.get(), ((ROOM_RADIUS.ROOM_RADIUS_INSTANCE)get.get()).radius());
/* 81 */     super.render(r, ds);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleRadius$I$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */