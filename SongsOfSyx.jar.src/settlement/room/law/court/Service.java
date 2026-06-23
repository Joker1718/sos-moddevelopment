/*    */ package settlement.room.law.court;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.ROOMA;
/*    */ import settlement.room.main.util.RoomBits;
/*    */ import settlement.room.service.module.RoomService;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ 
/*    */ public final class Service implements FSERVICE {
/* 10 */   private final Coo coo = new Coo();
/*    */   private CourtInstance ins;
/* 12 */   private static final Service self = new Service();
/*    */   
/* 14 */   final RoomBits breservable = new RoomBits((COORDINATE)this.coo, 1)
/*    */     {
/*    */       protected void remove()
/*    */       {
/* 18 */         if (get() == 1) {
/* 19 */           Service.this.ins.service().report(Service.this, (RoomService)(Service.this.ins.blueprintI()).data, -1);
/*    */         }
/*    */       }
/*    */       
/*    */       protected void add() {
/* 24 */         if (get() == 1) {
/* 25 */           Service.this.ins.service().report(Service.this, (RoomService)(Service.this.ins.blueprintI()).data, 1);
/*    */         }
/*    */       }
/*    */     };
/*    */   
/*    */   static Service init(int tx, int ty) {
/* 31 */     CourtInstance ins = (CourtInstance)(SETT.ROOMS()).COURT.get(tx, ty);
/* 32 */     if (ins == null) {
/* 33 */       return null;
/*    */     }
/* 35 */     if ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 3) {
/* 36 */       self.ins = ins;
/* 37 */       self.coo.set(tx, ty);
/* 38 */       return self;
/*    */     } 
/* 40 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   static void initInit(int tx, int ty, CourtInstance ins) {
/* 45 */     Service s = init(tx, ty);
/*    */     
/* 47 */     if (s != null) {
/* 48 */       s.breservable.set((ROOMA)ins, 1);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean findableReservedCanBe() {
/* 55 */     return !findableReservedIs();
/*    */   }
/*    */ 
/*    */   
/*    */   public void findableReserve() {
/* 60 */     this.breservable.set((ROOMA)this.ins, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean findableReservedIs() {
/* 65 */     return (this.breservable.get() == 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void findableReserveCancel() {
/* 70 */     this.breservable.set((ROOMA)this.ins, 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public int x() {
/* 75 */     return this.coo.x();
/*    */   }
/*    */ 
/*    */   
/*    */   public int y() {
/* 80 */     return this.coo.y();
/*    */   }
/*    */ 
/*    */   
/*    */   public void consume() {
/* 85 */     findableReserveCancel();
/*    */   }
/*    */   
/*    */   void activate() {
/* 89 */     findableReserveCancel();
/*    */   }
/*    */   
/*    */   void deactivate() {
/* 93 */     findableReserve();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\court\Service.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */