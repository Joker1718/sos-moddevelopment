/*    */ package settlement.room.industry.woodcutter;
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
/* 30 */     Job.this.ins.workage -= get();
/* 31 */     super.set(r, t);
/* 32 */     Job.this.ins.workage += get();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\woodcutter\Job$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */