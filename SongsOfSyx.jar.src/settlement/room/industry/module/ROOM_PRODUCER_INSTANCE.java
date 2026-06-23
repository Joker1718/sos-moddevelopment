/*    */ package settlement.room.industry.module;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.room.main.RoomInstance;
/*    */ 
/*    */ public interface ROOM_PRODUCER_INSTANCE
/*    */   extends ROOM_IDATA_INSTANCE {
/*    */   Industry industry();
/*    */   
/*    */   int industryI();
/*    */   
/*    */   default void setIndustry(int i) {}
/*    */   
/*    */   default void updateIndustryLocks() {
/* 16 */     Industry in = industry();
/* 17 */     if (!in.lockable.passes(FACTIONS.player())) {
/* 18 */       setIndustry(0);
/*    */     }
/*    */   }
/*    */   
/*    */   default double productionRate(RoomInstance ins, Humanoid h, Industry in, IndustryResource oo) {
/* 23 */     return IndustryUtil.calcProductionRate(oo.rate, h, in, ins) * ins.employees().totEfficiency();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\ROOM_PRODUCER_INSTANCE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */