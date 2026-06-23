/*    */ package settlement.room.infra.hauler;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.main.job.StorageCrate;
/*    */ 
/*    */ final class Crate
/*    */   extends StorageCrate {
/*    */   static final int size = 80;
/*    */   protected final ROOM_HAULER b;
/*    */   HaulerInstance ins;
/*    */   
/*    */   Crate(ROOM_HAULER b) {
/* 14 */     this.b = b;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean is(int tx, int ty) {
/* 19 */     if (this.b.is(tx, ty)) {
/* 20 */       this.ins = (HaulerInstance)this.b.getter.get(tx, ty);
/* 21 */       if ((SETT.ROOMS()).fData.tileData.is(tx, ty, 1)) {
/* 22 */         return true;
/*    */       }
/*    */     } 
/* 25 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isStorage() {
/* 30 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isPrio() {
/* 35 */     return this.ins.prio();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void count(int delta) {
/* 40 */     this.b.tally.report(this, this.ins, delta);
/* 41 */     this.ins.updateMasks();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isFindable() {
/* 46 */     return !this.ins.storing();
/*    */   }
/*    */ 
/*    */   
/*    */   protected int max(RoomInstance ins) {
/* 51 */     return 80;
/*    */   }
/*    */ 
/*    */   
/*    */   protected double spoilRate(RoomInstance ins) {
/* 56 */     return 1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\hauler\Crate.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */