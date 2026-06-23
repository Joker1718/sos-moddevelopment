/*    */ package settlement.room.food.orchard;
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
/*    */ class null
/*    */   extends JobIterator
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   null(RoomInstance $anonymous0) {
/* 46 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected SETT_JOB init(int tx, int ty) {
/* 51 */     OTile t = Instance.this.blueprintI().tile(tx, ty);
/* 52 */     if (t != null)
/* 53 */       return t.job(); 
/* 54 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\orchard\Instance$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */