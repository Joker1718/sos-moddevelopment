/*    */ package settlement.room.industry.module.consumption;
/*    */ 
/*    */ import settlement.room.industry.module.IndustryResource;
/*    */ import settlement.room.industry.module.RoomBoost;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import util.info.INFO;
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
/*    */   implements RoomBoost
/*    */ {
/*    */   public INFO info() {
/* 59 */     return info;
/*    */   }
/*    */ 
/*    */   
/*    */   public double get(RoomInstance r) {
/* 64 */     double m = 1.0D;
/* 65 */     for (IndustryResource res : RoomConsumption.this.allIns) {
/* 66 */       if (RoomConsumption.this.stored(res).get(r) > 0)
/* 67 */         m += RoomConsumption.this.boost(res); 
/*    */     } 
/* 69 */     return m;
/*    */   }
/*    */ 
/*    */   
/*    */   public double max() {
/* 74 */     return max;
/*    */   }
/*    */ 
/*    */   
/*    */   public double min() {
/* 79 */     return 1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\consumption\RoomConsumption$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */