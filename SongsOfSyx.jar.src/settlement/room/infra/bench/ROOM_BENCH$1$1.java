/*    */ package settlement.room.infra.bench;
/*    */ 
/*    */ import settlement.main.SETT;
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
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements FSERVICE
/*    */ {
/*    */   public int y() {
/* 56 */     return ROOM_BENCH.null.this.y;
/*    */   }
/*    */ 
/*    */   
/*    */   public int x() {
/* 61 */     return ROOM_BENCH.null.this.x;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean findableReservedIs() {
/* 66 */     return ((SETT.ROOMS()).fData.spriteData2.get(ROOM_BENCH.null.this.x, ROOM_BENCH.null.this.y) == 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean findableReservedCanBe() {
/* 71 */     return ((SETT.ROOMS()).fData.spriteData2.get(ROOM_BENCH.null.this.x, ROOM_BENCH.null.this.y) == 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void findableReserveCancel() {
/* 76 */     if (findableReservedIs()) {
/* 77 */       (ROOM_BENCH.null.access$1(ROOM_BENCH.null.this)).finder.report(ROOM_BENCH.null.this.x, ROOM_BENCH.null.this.y, 1);
/*    */     }
/* 79 */     (SETT.ROOMS()).fData.spriteData2.set(ROOM_BENCH.null.this.x, ROOM_BENCH.null.this.y, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void findableReserve() {
/* 84 */     if (!findableReservedIs()) {
/* 85 */       (ROOM_BENCH.null.access$1(ROOM_BENCH.null.this)).finder.report(ROOM_BENCH.null.this.x, ROOM_BENCH.null.this.y, -1);
/*    */     }
/* 87 */     (SETT.ROOMS()).fData.spriteData2.set(ROOM_BENCH.null.this.x, ROOM_BENCH.null.this.y, 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void consume() {
/* 92 */     findableReserveCancel();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\bench\ROOM_BENCH$1$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */