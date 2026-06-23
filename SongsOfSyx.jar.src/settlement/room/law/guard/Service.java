/*    */ package settlement.room.law.guard;
/*    */ 
/*    */ import settlement.misc.util.FSERVICE;
/*    */ 
/*    */ final class Service implements FSERVICE {
/*    */   private GuardInstance ins;
/*    */   private int x;
/*    */   private int y;
/*    */   private final ROOM_GUARD b;
/*    */   
/*    */   Service(ROOM_GUARD blue) {
/* 12 */     this.b = blue;
/*    */   }
/*    */   
/*    */   Service get(GuardInstance ins) {
/* 16 */     this.ins = ins;
/* 17 */     this.x = ins.body().cX();
/* 18 */     this.y = ins.body().cY();
/* 19 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean findableReservedCanBe() {
/* 24 */     return this.b.reporter.available(this.ins);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void findableReserve() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean findableReservedIs() {
/* 35 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void findableReserveCancel() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public int x() {
/* 46 */     return this.x;
/*    */   }
/*    */ 
/*    */   
/*    */   public int y() {
/* 51 */     return this.y;
/*    */   }
/*    */   
/*    */   public void consume() {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\guard\Service.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */