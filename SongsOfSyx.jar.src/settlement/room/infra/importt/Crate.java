/*    */ package settlement.room.infra.importt;
/*    */ 
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.main.job.StorageCrate;
/*    */ 
/*    */ final class Crate
/*    */   extends StorageCrate {
/*    */   protected final ROOM_IMPORT b;
/*    */   ImportInstance ins;
/*    */   
/*    */   Crate(ROOM_IMPORT b) {
/* 12 */     this.b = b;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean is(int tx, int ty) {
/* 17 */     if (this.b.is(tx, ty)) {
/* 18 */       this.ins = (ImportInstance)this.b.getter.get(tx, ty);
/* 19 */       if (this.b.constructor.isCrate(tx, ty)) {
/* 20 */         return true;
/*    */       }
/*    */     } 
/* 23 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void count(int delta) {
/* 28 */     this.ins.count(this, delta);
/*    */   }
/*    */ 
/*    */   
/*    */   protected int max(RoomInstance ins) {
/* 33 */     return 600;
/*    */   }
/*    */ 
/*    */   
/*    */   protected double spoilRate(RoomInstance ins) {
/* 38 */     return 1.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isStorage() {
/* 43 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isPrio() {
/* 48 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean storageIsFindable() {
/* 53 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\importt\Crate.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */