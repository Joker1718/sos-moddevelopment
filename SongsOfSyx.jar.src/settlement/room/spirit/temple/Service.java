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
/*    */ final class Service
/*    */ {
/*    */   private TempleInstance ins;
/*    */   private int x;
/*    */   private int y;
/*    */   private final ROOM_TEMPLE blue;
/*    */   private final FSERVICE s;
/*    */   
/*    */   Service(ROOM_TEMPLE blue) {
/* 41 */     this.s = new FSERVICE()
/*    */       {
/*    */         public int y()
/*    */         {
/* 45 */           return Service.this.y;
/*    */         }
/*    */ 
/*    */         
/*    */         public int x() {
/* 50 */           return Service.this.x;
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean findableReservedIs() {
/* 55 */           return ((SETT.ROOMS()).data.get(Service.this.x, Service.this.y) == 1);
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean findableReservedCanBe() {
/* 60 */           return !findableReservedIs();
/*    */         }
/*    */ 
/*    */         
/*    */         public void findableReserveCancel() {
/* 65 */           if (findableReservedIs()) {
/* 66 */             (SETT.ROOMS()).data.set((ROOMA)Service.this.ins, Service.this.x, Service.this.y, 0);
/* 67 */             Service.this.ins.service.report(Service.this.s, Service.this.blue.service, 1);
/*    */           } 
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public void findableReserve() {
/* 74 */           if (!findableReservedIs()) {
/* 75 */             Service.this.ins.service.report(Service.this.s, Service.this.blue.service, -1);
/* 76 */             (SETT.ROOMS()).data.set((ROOMA)Service.this.ins, Service.this.x, Service.this.y, 1);
/*    */           } 
/*    */         }
/*    */ 
/*    */         
/*    */         public void consume() {
/* 82 */           findableReserveCancel();
/*    */         }
/*    */       };
/*    */     this.blue = blue;
/*    */   }
/*    */   
/*    */   public FSERVICE get(int tx, int ty) {
/*    */     this.ins = (TempleInstance)this.blue.get(tx, ty);
/*    */     if (this.ins != null && this.blue.constructor.wo == (SETT.ROOMS()).fData.tile.get(tx, ty)) {
/*    */       this.x = tx;
/*    */       this.y = ty;
/*    */       return this.s;
/*    */     } 
/*    */     return null;
/*    */   }
/*    */   
/*    */   public void init(int tx, int ty) {
/*    */     if (get(tx, ty) != null) {
/*    */       (SETT.ROOMS()).data.set((ROOMA)this.ins, this.x, this.y, 1);
/*    */       this.s.findableReserveCancel();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void dispose(int tx, int ty) {
/*    */     if (get(tx, ty) != null)
/*    */       this.s.findableReserve(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\Service.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */