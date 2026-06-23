/*    */ package settlement.room.service.food.eatery;
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
/*    */ class null
/*    */   extends JobIterator
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   null(RoomInstance $anonymous0) {
/* 35 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected SETT_JOB init(int tx, int ty) {
/* 40 */     return (EateryInstance.this.blueprintI()).dist.job(tx, ty);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\eatery\EateryInstance$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */