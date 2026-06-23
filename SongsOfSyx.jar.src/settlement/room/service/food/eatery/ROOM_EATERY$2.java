/*    */ package settlement.room.service.food.eatery;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.resources.RBIT;
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.service.module.RoomServiceAccess;
/*    */ import snake2d.util.sets.LIST;
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
/*    */   extends RoomDistribution
/*    */ {
/*    */   null(RoomBlueprintIns<? extends RoomDistribution.RoomDistributionIns> $anonymous0, RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER $anonymous1, LIST<RESOURCE> $anonymous2, RBIT.RBITImp $anonymous3, int $anonymous4) {
/* 62 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
/*    */   }
/*    */   
/*    */   protected boolean isPref(RESOURCE r, Race race) {
/* 66 */     return (race.pref()).foodMask.has(r);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isDeposit(int tx, int ty) {
/* 71 */     return ROOM_EATERY.this.constructor.isDeposit(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isCrate(int tx, int ty) {
/* 76 */     return ROOM_EATERY.this.constructor.isCrate(tx, ty);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\eatery\ROOM_EATERY$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */