/*    */ package settlement.room.health.physician;
/*    */ 
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.room.main.ROOMA;
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
/*    */ 
/*    */ class null
/*    */   implements FSERVICE
/*    */ {
/*    */   public boolean findableReservedCanBe() {
/* 59 */     return (Service.this.s_reservable.get() == 1 && Service.this.s_reserved.get() == 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void findableReserve() {
/* 64 */     Service.this.ins.jobs.searchAgain();
/* 65 */     Service.this.s_reserved.set((ROOMA)Service.this.ins, 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean findableReservedIs() {
/* 70 */     return (Service.this.s_reserved.get() == 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void findableReserveCancel() {
/* 75 */     Service.this.s_reserved.set((ROOMA)Service.this.ins, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public int x() {
/* 80 */     return Service.this.coo.x();
/*    */   }
/*    */ 
/*    */   
/*    */   public int y() {
/* 85 */     return Service.this.coo.y();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void startUsing() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void consume() {
/* 95 */     Service.this.s_worked_amount.inc((ROOMA)Service.this.ins, -1);
/* 96 */     Service.this.s_reservable.set((ROOMA)Service.this.ins, (Service.this.s_worked_amount.get() > 0) ? 1 : 0);
/* 97 */     Service.this.s_reserved.set((ROOMA)Service.this.ins, 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\physician\Service$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */