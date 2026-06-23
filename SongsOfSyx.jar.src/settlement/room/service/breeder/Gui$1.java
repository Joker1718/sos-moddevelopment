/*    */ package settlement.room.service.breeder;
/*    */ 
/*    */ import settlement.room.industry.module.IndustryRate;
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
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 59 */     double n = IndustryUtil.calcProductionRate(((ROOM_BREEDER)Gui.access$2(Gui.this)).PRODUCTION_SPEED_DAY, (IndustryRate)((ROOM_BREEDER)Gui.access$2(Gui.this)).productionData, (RoomInstance)getter.get());
/* 60 */     GFORMAT.fRel(text, n * ((BreederInstance)getter.get()).employees().totEfficiency(), ((ROOM_BREEDER)Gui.access$2(Gui.this)).PRODUCTION_SPEED_DAY);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 65 */     IndustryUtil.hoverProductionRate((GUI_BOX)b, ((ROOM_BREEDER)Gui.access$2(Gui.this)).PRODUCTION_SPEED_DAY, (IndustryRate)((ROOM_BREEDER)Gui.access$2(Gui.this)).productionData, (RoomInstance)getter.get());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\breeder\Gui$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */