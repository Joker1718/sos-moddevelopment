/*     */ package settlement.room.infra.embassy;
/*     */ 
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.job.JobPositions;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Jobs
/*     */   extends JobPositions<EmbassyInstance>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Jobs(EmbassyInstance ins) {
/*  95 */     super(ins);
/*     */   }
/*     */ 
/*     */   
/*     */   protected SETT_JOB get(int tx, int ty) {
/* 100 */     return (((EmbassyInstance)this.ins).blueprintI()).job.get(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isAndInit(int tx, int ty) {
/* 105 */     return ((((EmbassyInstance)this.ins).blueprintI()).job.get(tx, ty) != null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\embassy\EmbassyInstance$Jobs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */