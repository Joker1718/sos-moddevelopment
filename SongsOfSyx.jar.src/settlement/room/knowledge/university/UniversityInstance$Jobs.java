/*    */ package settlement.room.knowledge.university;
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
/*    */ class Jobs
/*    */   extends JobPositions<UniversityInstance>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public Jobs(UniversityInstance ins) {
/* 79 */     super(ins);
/*    */   }
/*    */ 
/*    */   
/*    */   protected SETT_JOB get(int tx, int ty) {
/* 84 */     return (((UniversityInstance)this.ins).blueprintI()).job.get(tx, ty);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isAndInit(int tx, int ty) {
/* 89 */     return ((((UniversityInstance)this.ins).blueprintI()).job.get(tx, ty) != null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledg\\university\UniversityInstance$Jobs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */