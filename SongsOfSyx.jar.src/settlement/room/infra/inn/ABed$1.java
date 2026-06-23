/*    */ package settlement.room.infra.inn;
/*    */ 
/*    */ import settlement.room.main.ROOMA;
/*    */ import settlement.room.main.util.RoomBits;
/*    */ import snake2d.util.datatypes.COORDINATE;
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
/*    */   extends RoomBits
/*    */ {
/*    */   null(COORDINATE $anonymous0, int $anonymous1) {
/* 28 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void set(ROOMA r, int t) {
/* 32 */     if (ABed.this.state.get() == 1) {
/* 33 */       ABed.this.ins.service.report(ABed.this.service, ABed.this.blue.service, -1);
/*    */     }
/* 35 */     super.set(r, t);
/* 36 */     if (ABed.this.state.get() == 1)
/* 37 */       ABed.this.ins.service.report(ABed.this.service, ABed.this.blue.service, 1); 
/* 38 */     ABed.this.claimed.set((ROOMA)ABed.this.ins, 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\inn\ABed$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */