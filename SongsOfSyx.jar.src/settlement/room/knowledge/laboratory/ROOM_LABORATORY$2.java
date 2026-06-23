/*    */ package settlement.room.knowledge.laboratory;
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
/*    */ class null
/*    */   extends ConsumptionJob
/*    */ {
/*    */   null(RoomBlueprintIns<?> $anonymous0, RoomConsumption $anonymous1, int $anonymous2, BOOLEANCoo $anonymous3) {
/* 46 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*    */   }
/*    */   
/*    */   protected void perform(double time, double skill) {
/* 50 */     ROOM_LABORATORY.this.data.perform(time, skill);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public DIR jobStandDir() {
/* 56 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 57 */       if (this.ins.is((COORDINATE)this.coo, (DIR)DIR.ORTHO.get(di)) && (SETT.ROOMS()).fData.sprite.is((COORDINATE)this.coo, (DIR)DIR.ORTHO.get(di), ROOM_LABORATORY.this.constructor.schair))
/* 58 */         return (DIR)DIR.ORTHO.get(di); 
/*    */     } 
/* 60 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean jobUseTool() {
/* 65 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean jobUseHands() {
/* 70 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\laboratory\ROOM_LABORATORY$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */