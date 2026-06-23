/*    */ package settlement.room.service.arena.pit;
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.room.main.ROOMA;
/*    */ import settlement.room.main.util.RoomBits;
/*    */ import settlement.room.service.module.RoomService;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ 
/*    */ final class Service implements FSERVICE {
/* 10 */   private final Coo coo = new Coo();
/* 11 */   private final RoomBits bAvailable = new RoomBits((COORDINATE)this.coo, 1);
/*    */   private ArenaInstance ins;
/*    */   private final ROOM_FIGHTPIT b;
/*    */   
/*    */   Service(ROOM_FIGHTPIT b) {
/* 16 */     this.b = b;
/*    */   }
/*    */   
/*    */   public FSERVICE get(int tx, int ty) {
/* 20 */     if (init(tx, ty))
/* 21 */       return this; 
/* 22 */     return null;
/*    */   }
/*    */   
/*    */   public boolean init(int tx, int ty) {
/* 26 */     this.ins = (ArenaInstance)this.b.getter.get(tx, ty);
/* 27 */     if (this.ins != null && (SETT.ROOMS()).fData.tileData.get(tx, ty) == 1) {
/* 28 */       this.coo.set(tx, ty);
/* 29 */       return true;
/*    */     } 
/* 31 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void consume() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public int x() {
/* 41 */     return this.coo.x();
/*    */   }
/*    */ 
/*    */   
/*    */   public int y() {
/* 46 */     return this.coo.y();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean findableReservedCanBe() {
/* 51 */     return (this.bAvailable.get() == 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void findableReserve() {
/* 56 */     if (!findableReservedCanBe()) {
/* 57 */       throw new RuntimeException();
/*    */     }
/* 59 */     this.ins.service.report(this, (RoomService)(this.ins.blueprintI()).data, -1);
/* 60 */     this.bAvailable.set((ROOMA)this.ins, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean findableReservedIs() {
/* 65 */     return (this.bAvailable.get() == 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void findableReserveCancel() {
/* 70 */     if (findableReservedCanBe())
/*    */       return; 
/* 72 */     this.bAvailable.set((ROOMA)this.ins, 1);
/* 73 */     this.ins.service.report(this, (RoomService)(this.ins.blueprintI()).data, 1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\pit\Service.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */