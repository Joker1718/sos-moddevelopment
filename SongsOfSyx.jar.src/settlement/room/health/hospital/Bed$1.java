/*    */ package settlement.room.health.hospital;
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
/*    */ class null
/*    */   extends RoomBits
/*    */ {
/*    */   null(COORDINATE $anonymous0, int $anonymous1) {
/* 26 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void set(ROOMA r, int t) {
/* 30 */     Bed.this.ins.service().report(Bed.this.service, Bed.this.ins.blueprintI().service(), -1);
/* 31 */     super.set(r, t);
/* 32 */     Bed.this.ins.service().report(Bed.this.service, Bed.this.ins.blueprintI().service(), 1);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\hospital\Bed$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */