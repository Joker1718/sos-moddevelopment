/*    */ package settlement.room.infra.stockpile;
/*    */ 
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.main.job.StorageCrate;
/*    */ 
/*    */ final class Crate
/*    */   extends StorageCrate {
/*    */   protected final ROOM_STOCKPILE b;
/*    */   StockpileInstance ins;
/*    */   
/*    */   Crate(ROOM_STOCKPILE b) {
/* 12 */     this.b = b;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean is(int tx, int ty) {
/* 17 */     if (this.b.is(tx, ty)) {
/* 18 */       this.ins = (StockpileInstance)this.b.getter.get(tx, ty);
/* 19 */       if (this.b.constructor.isCrate(tx, ty)) {
/* 20 */         return true;
/*    */       }
/*    */     } 
/* 23 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void count(int delta) {
/* 28 */     this.b.tally().report(this, this.ins, delta);
/* 29 */     this.ins.updateMasks(resource());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isPrio() {
/* 34 */     return this.ins.prioritizing();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isStorage() {
/* 39 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isFindable() {
/* 44 */     return !this.ins.storing();
/*    */   }
/*    */ 
/*    */   
/*    */   protected int max(RoomInstance ins) {
/* 49 */     return ((StockpileInstance)ins).crateSize(resource());
/*    */   }
/*    */ 
/*    */   
/*    */   protected double spoilRate(RoomInstance ins) {
/* 54 */     return 0.5D + 0.5D * ins.getDegrade();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\Crate.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */