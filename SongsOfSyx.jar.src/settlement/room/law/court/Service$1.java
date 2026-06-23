/*    */ package settlement.room.law.court;
/*    */ 
/*    */ import settlement.room.main.util.RoomBits;
/*    */ import settlement.room.service.module.RoomService;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends RoomBits
/*    */ {
/*    */   null(COORDINATE $anonymous0, int $anonymous1) {
/* 14 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void remove() {
/* 18 */     if (get() == 1) {
/* 19 */       Service.this.ins.service().report(Service.this, (RoomService)(Service.this.ins.blueprintI()).data, -1);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void add() {
/* 24 */     if (get() == 1)
/* 25 */       Service.this.ins.service().report(Service.this, (RoomService)(Service.this.ins.blueprintI()).data, 1); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\court\Service$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */