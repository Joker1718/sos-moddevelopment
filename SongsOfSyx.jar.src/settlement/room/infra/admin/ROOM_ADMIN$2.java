/*    */ package settlement.room.infra.admin;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.industry.module.consumption.ConsumptionJob;
/*    */ import settlement.room.industry.module.consumption.RoomConsumption;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
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
/*    */ class null
/*    */   extends ConsumptionJob
/*    */ {
/*    */   null(RoomBlueprintIns<?> $anonymous0, RoomConsumption $anonymous1, int $anonymous2, BOOLEANCoo $anonymous3) {
/* 54 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*    */   }
/*    */   
/*    */   protected void perform(double time, double skill) {
/* 58 */     ROOM_ADMIN.this.data.perform(time, skill);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DIR jobStandDir() {
/* 64 */     for (DIR d : DIR.ORTHO) {
/* 65 */       if (this.ins.is((COORDINATE)this.coo, d) && (SETT.ROOMS()).fData.tileData.get((COORDINATE)this.coo, d) == 3)
/* 66 */         return d; 
/*    */     } 
/* 68 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean jobUseTool() {
/* 73 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean jobUseHands() {
/* 78 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\admin\ROOM_ADMIN$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */