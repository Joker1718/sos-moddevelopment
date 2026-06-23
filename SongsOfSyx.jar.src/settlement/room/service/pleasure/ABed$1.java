/*    */ package settlement.room.service.pleasure;
/*    */ 
/*    */ import settlement.room.main.ROOMA;
/*    */ import settlement.room.main.util.RoomBits;
/*    */ import settlement.room.service.module.RoomService;
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
/*    */ class null
/*    */   extends RoomBits
/*    */ {
/*    */   null(COORDINATE $anonymous0, int $anonymous1) {
/* 25 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void set(ROOMA r, int t) {
/* 29 */     if (ABed.this.state.get() == 1) {
/* 30 */       ABed.this.ins.service.report(ABed.this.service, (RoomService)ABed.this.blue.service, -1);
/*    */     }
/* 32 */     super.set(r, t);
/* 33 */     if (ABed.this.state.get() == 1)
/* 34 */       ABed.this.ins.service.report(ABed.this.service, (RoomService)ABed.this.blue.service, 1); 
/* 35 */     ABed.this.wdata.set(r, 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\pleasure\ABed$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */