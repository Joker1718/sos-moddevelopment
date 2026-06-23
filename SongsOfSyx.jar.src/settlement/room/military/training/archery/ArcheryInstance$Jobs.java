/*    */ package settlement.room.military.training.archery;
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
/*    */ class Jobs
/*    */   extends JobIterator
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public Jobs(RoomInstance ins) {
/* 41 */     super(ins);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected SETT_JOB init(int tx, int ty) {
/* 49 */     return ((ROOM_ARCHERY)ins().blueprintI()).thing.init(tx, ty);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\training\archery\ArcheryInstance$Jobs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */