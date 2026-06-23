/*    */ package settlement.room.food.farm;
/*    */ 
/*    */ import settlement.misc.job.SETT_JOB;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import settlement.room.main.job.JobIterator;
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
/*    */   extends JobIterator
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   null(RoomInstance $anonymous0) {
/* 51 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected SETT_JOB init(int tx, int ty) {
/* 56 */     return FarmInstance.this.blueprintI().tile(tx, ty).job();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\farm\FarmInstance$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */