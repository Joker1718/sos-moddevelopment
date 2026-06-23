/*    */ package settlement.room.service.food.tavern;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.resources.RBIT;
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.service.food.eatery.RoomDistribution;
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
/*    */ class null
/*    */   extends RoomDistribution
/*    */ {
/*    */   null(RoomBlueprintIns<? extends RoomDistribution.RoomDistributionIns> $anonymous0, RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER $anonymous1, LIST<RESOURCE> $anonymous2, RBIT.RBITImp $anonymous3, int $anonymous4) {
/* 61 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
/*    */   }
/*    */   
/*    */   protected boolean isPref(RESOURCE r, Race race) {
/* 65 */     return (race.pref()).drinkMask.has(r);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isDeposit(int tx, int ty) {
/* 70 */     return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == Constructor.ITABLE);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isCrate(int tx, int ty) {
/* 75 */     return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == Constructor.ISTORAGE);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\tavern\ROOM_TAVERN$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */