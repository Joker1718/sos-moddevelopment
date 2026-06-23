/*    */ package settlement.room.infra.embassy;
/*    */ 
/*    */ import settlement.room.industry.module.consumption.ConsumptionJob;
/*    */ import settlement.room.industry.module.consumption.RoomConsumption;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import snake2d.util.rnd.RND;
/*    */ import util.data.BOOLEANCoo;
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
/*    */   extends ConsumptionJob
/*    */ {
/*    */   null(RoomBlueprintIns<?> $anonymous0, RoomConsumption $anonymous1, int $anonymous2, BOOLEANCoo $anonymous3) {
/* 57 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*    */   }
/*    */   
/*    */   protected void perform(double time, double skill) {
/* 61 */     ROOM_EMBASSY.this.data.perform(time, skill);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean jobUseTool() {
/* 68 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean jobUseHands() {
/* 73 */     return RND.rBoolean();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\embassy\ROOM_EMBASSY$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */