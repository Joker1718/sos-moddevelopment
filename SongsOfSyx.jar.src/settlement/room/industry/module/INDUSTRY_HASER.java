/*    */ package settlement.room.industry.module;
/*    */ 
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sets.LIST;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ 
/*    */ 
/*    */ public interface INDUSTRY_HASER
/*    */ {
/*    */   LIST<Industry> industries();
/*    */   
/*    */   default double industryFormatProductionRate(GText text, IndustryResource i, RoomInstance ins) {
/* 16 */     double n = IndustryUtil.calcProductionRate(i.rate, ((ROOM_PRODUCER_INSTANCE)ins).industry(), ins);
/* 17 */     n *= ins.employees().employed();
/* 18 */     double nn = i.rate * ins.employees().employed();
/*    */     
/* 20 */     text.add('+');
/* 21 */     GFORMAT.fRel(text, n, nn);
/* 22 */     return n * ins.employees().efficiency();
/*    */   }
/*    */ 
/*    */   
/*    */   default double industryFormatConsumptionRate(GText text, IndustryResource i, RoomInstance ins) {
/* 27 */     ROOM_PRODUCER_INSTANCE pp = (ROOM_PRODUCER_INSTANCE)ins;
/* 28 */     double n = IndustryUtil.calcConsumptionRate(i.rate, ins, pp.industry());
/*    */     
/* 30 */     n *= ins.employees().employed();
/*    */     
/* 32 */     GFORMAT.f0(text, -n);
/* 33 */     return n;
/*    */   }
/*    */   
/*    */   default double industryFormatProductionRateEmpl(GText text, IndustryResource i, RoomInstance ins) {
/* 37 */     double n = IndustryUtil.calcProductionRate(i.rate, ((ROOM_PRODUCER_INSTANCE)ins).industry(), ins);
/* 38 */     GFORMAT.fRel(text, n * ins.employees().totEfficiency(), i.rate);
/* 39 */     return n * ins.employees().efficiency();
/*    */   }
/*    */   
/*    */   default void industryHoverProductionRate(GBox b, IndustryResource i, RoomInstance ins) {
/* 43 */     IndustryUtil.hoverProductionRate((GUI_BOX)b, i.rate, ((ROOM_PRODUCER_INSTANCE)ins).industry(), ins);
/*    */   }
/*    */ 
/*    */   
/*    */   default void industryHoverConsumptionRate(GBox b, IndustryResource i, RoomInstance ins) {
/* 48 */     IndustryUtil.hoverConsumptionRate((GUI_BOX)b, i.rate, ins, ((ROOM_PRODUCER_INSTANCE)ins).industry());
/*    */   }
/*    */   
/*    */   default boolean industryIgnoreUI() {
/* 52 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\INDUSTRY_HASER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */