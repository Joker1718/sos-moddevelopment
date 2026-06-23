/*    */ package settlement.room.service.nursery;
/*    */ 
/*    */ import settlement.room.industry.module.IndustryUtil;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
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
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 31 */     ((ROOM_NURSERY)Gui.access$0(Gui.this)).getClass(); GFORMAT.f0(text, IndustryUtil.calcProductionRate(10.0D, ((ROOM_NURSERY)Gui.access$0(Gui.this)).rate, ((ROOM_NURSERY)Gui.access$0(Gui.this)).bonus(), (RoomInstance)getter.get()));
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 36 */     b.title((((ROOM_NURSERY)Gui.access$0(Gui.this)).bonus()).name);
/* 37 */     b.text((((ROOM_NURSERY)Gui.access$0(Gui.this)).bonus()).desc);
/* 38 */     b.NL();
/* 39 */     ((ROOM_NURSERY)Gui.access$0(Gui.this)).getClass(); IndustryUtil.hoverProductionRate((GUI_BOX)b, 10.0D, ((ROOM_NURSERY)Gui.access$0(Gui.this)).rate, ((ROOM_NURSERY)Gui.access$0(Gui.this)).bonus(), (RoomInstance)getter.get());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\nursery\Gui$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */