/*    */ package settlement.room.service.nursery;
/*    */ import settlement.room.industry.module.IndustryUtil;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import view.sett.ui.room.UIRoomModule;
/*    */ 
/*    */ class Gui extends UIRoomModule.UIRoomModuleImp<NurseryInstance, ROOM_NURSERY> {
/*    */   Gui(ROOM_NURSERY s) {
/* 19 */     super(s);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<NurseryInstance> getter, int x1, int y1) {
/* 25 */     GuiSection s = new GuiSection();
/*    */     
/* 27 */     s.add((RENDEROBJ)(new GStat()
/*    */         {
/*    */           public void update(GText text)
/*    */           {
/* 31 */             ((ROOM_NURSERY)Gui.this.blueprint).getClass(); GFORMAT.f0(text, IndustryUtil.calcProductionRate(10.0D, ((ROOM_NURSERY)Gui.this.blueprint).rate, ((ROOM_NURSERY)Gui.this.blueprint).bonus(), (RoomInstance)getter.get()));
/*    */           }
/*    */ 
/*    */           
/*    */           public void hoverInfoGet(GBox b) {
/* 36 */             b.title((((ROOM_NURSERY)Gui.this.blueprint).bonus()).name);
/* 37 */             b.text((((ROOM_NURSERY)Gui.this.blueprint).bonus()).desc);
/* 38 */             b.NL();
/* 39 */             ((ROOM_NURSERY)Gui.this.blueprint).getClass(); IndustryUtil.hoverProductionRate((GUI_BOX)b, 10.0D, ((ROOM_NURSERY)Gui.this.blueprint).rate, ((ROOM_NURSERY)Gui.this.blueprint).bonus(), (RoomInstance)getter.get());
/*    */           }
/* 42 */         }).hh((SPRITE)(((ROOM_NURSERY)this.blueprint).bonus()).icon));
/*    */     
/* 44 */     section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\nursery\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */