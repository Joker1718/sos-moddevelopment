/*    */ package settlement.room.service.speaker;
/*    */ 
/*    */ import settlement.misc.util.FSERVICE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   public void consume() {}
/*    */   
/*    */   public int x() {
/* 55 */     return Centre.this.ins.body().cX();
/*    */   }
/*    */ 
/*    */   
/*    */   public int y() {
/* 60 */     return Centre.this.ins.body().cY();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean findableReservedCanBe() {
/* 65 */     return (Centre.this.ins.services() > 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void findableReserve() {
/* 70 */     if (!findableReservedCanBe()) {
/* 71 */       throw new RuntimeException();
/*    */     }
/* 73 */     Centre.this.ins.incServices(-1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean findableReservedIs() {
/* 78 */     return Centre.this.ins.hasService();
/*    */   }
/*    */ 
/*    */   
/*    */   public void findableReserveCancel() {
/* 83 */     Centre.this.ins.incServices(1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\speaker\Centre$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */