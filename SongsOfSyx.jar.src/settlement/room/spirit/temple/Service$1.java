/*    */ package settlement.room.spirit.temple;
/*    */ 
/*    */ import settlement.main.SETT;
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
/*    */ class null
/*    */   implements FSERVICE
/*    */ {
/*    */   public int y() {
/* 45 */     return Service.this.y;
/*    */   }
/*    */ 
/*    */   
/*    */   public int x() {
/* 50 */     return Service.this.x;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean findableReservedIs() {
/* 55 */     return ((SETT.ROOMS()).data.get(Service.this.x, Service.this.y) == 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean findableReservedCanBe() {
/* 60 */     return !findableReservedIs();
/*    */   }
/*    */ 
/*    */   
/*    */   public void findableReserveCancel() {
/* 65 */     if (findableReservedIs()) {
/* 66 */       (SETT.ROOMS()).data.set((ROOMA)Service.this.ins, Service.this.x, Service.this.y, 0);
/* 67 */       Service.this.ins.service.report(Service.this.s, Service.this.blue.service, 1);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void findableReserve() {
/* 74 */     if (!findableReservedIs()) {
/* 75 */       Service.this.ins.service.report(Service.this.s, Service.this.blue.service, -1);
/* 76 */       (SETT.ROOMS()).data.set((ROOMA)Service.this.ins, Service.this.x, Service.this.y, 1);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void consume() {
/* 82 */     findableReserveCancel();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\Service$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */