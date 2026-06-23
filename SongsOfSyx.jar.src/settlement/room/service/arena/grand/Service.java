/*    */ package settlement.room.service.arena.grand;
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.room.main.ROOMA;
/*    */ import settlement.room.main.util.RoomBits;
/*    */ import settlement.room.service.module.RoomService;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ 
/*    */ final class Service implements FSERVICE {
/*  9 */   private final Coo coo = new Coo();
/* 10 */   private final RoomBits bAvailable = new RoomBits((COORDINATE)this.coo, 256);
/*    */   private ArenaInstance ins;
/*    */   private final ROOM_ARENA b;
/*    */   
/*    */   Service(ROOM_ARENA b) {
/* 15 */     this.b = b;
/*    */   }
/*    */   
/*    */   public FSERVICE get(int tx, int ty) {
/* 19 */     if (init(tx, ty))
/* 20 */       return this; 
/* 21 */     return null;
/*    */   }
/*    */   
/*    */   public boolean init(int tx, int ty) {
/* 25 */     this.ins = (ArenaInstance)this.b.getter.get(tx, ty);
/* 26 */     if (this.ins != null && this.b.constructor.util.service(tx, ty)) {
/* 27 */       this.coo.set(tx, ty);
/* 28 */       return true;
/*    */     } 
/* 30 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void consume() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public int x() {
/* 40 */     return this.coo.x();
/*    */   }
/*    */ 
/*    */   
/*    */   public int y() {
/* 45 */     return this.coo.y();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean findableReservedCanBe() {
/* 50 */     return (this.bAvailable.get() == 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void findableReserve() {
/* 55 */     if (!findableReservedCanBe()) {
/* 56 */       throw new RuntimeException();
/*    */     }
/* 58 */     this.ins.service.report(this, (RoomService)(this.ins.blueprintI()).data, -1);
/* 59 */     this.bAvailable.set((ROOMA)this.ins, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean findableReservedIs() {
/* 64 */     return (this.bAvailable.get() == 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void findableReserveCancel() {
/* 69 */     if (findableReservedCanBe())
/*    */       return; 
/* 71 */     this.bAvailable.set((ROOMA)this.ins, 1);
/* 72 */     this.ins.service.report(this, (RoomService)(this.ins.blueprintI()).data, 1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\grand\Service.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */