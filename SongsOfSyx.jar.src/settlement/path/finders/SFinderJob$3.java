/*    */ package settlement.path.finders;
/*    */ 
/*    */ import settlement.job.Job;
/*    */ import settlement.path.path.SPath;
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
/*    */   extends TestPath
/*    */ {
/*    */   null(CharSequence $anonymous0, SFINDER $anonymous1) {
/* 27 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   protected void place(int sx, int sy, SPath p) {
/* 30 */     Job j = SFinderJob.this.find(sx, sy, p, true);
/* 31 */     if (j != null && j.resourceCurrentlyNeeded() != null)
/* 32 */       p.request(sx, sy, j.jobCoo()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderJob$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */