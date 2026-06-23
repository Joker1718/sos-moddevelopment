/*    */ package settlement.room.law.police;
/*    */ 
/*    */ import settlement.misc.job.SETT_JOB;
/*    */ import settlement.room.main.job.JobPositions;
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
/*    */   extends JobPositions<PoliceInstance>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public Jobs(PoliceInstance ins) {
/* 86 */     super(ins);
/* 87 */     setAlwaysNew();
/* 88 */     randomize();
/*    */   }
/*    */ 
/*    */   
/*    */   protected SETT_JOB get(int tx, int ty) {
/* 93 */     return (((PoliceInstance)this.ins).blueprintI()).work.job(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isAndInit(int tx, int ty) {
/* 98 */     return ((((PoliceInstance)this.ins).blueprintI()).work.job(tx, ty) != null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\police\PoliceInstance$Jobs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */