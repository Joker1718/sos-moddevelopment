/*    */ package settlement.room.knowledge.library;
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
/*    */ class null
/*    */   extends ConsumptionJob
/*    */ {
/*    */   null(RoomBlueprintIns<?> $anonymous0, RoomConsumption $anonymous1, int $anonymous2, BOOLEANCoo $anonymous3) {
/* 50 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*    */   }
/*    */   
/*    */   protected void perform(double time, double skill) {
/* 54 */     ROOM_LIBRARY.this.data.perform(time, skill);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DIR jobStandDir() {
/* 60 */     for (DIR d : DIR.ORTHO) {
/* 61 */       if ((SETT.ROOMS()).fData.sprite.get((COORDINATE)this.coo, d) == ROOM_LIBRARY.this.constructor.sStool)
/* 62 */         return d; 
/*    */     } 
/* 64 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean jobUseTool() {
/* 69 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean jobUseHands() {
/* 74 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\library\ROOM_LIBRARY$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */