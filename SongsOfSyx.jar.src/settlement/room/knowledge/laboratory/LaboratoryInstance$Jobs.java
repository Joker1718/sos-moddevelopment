/*     */ package settlement.room.knowledge.laboratory;
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
/*     */ class Jobs
/*     */   extends JobPositions<LaboratoryInstance>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Jobs(LaboratoryInstance ins) {
/*  94 */     super(ins);
/*     */   }
/*     */ 
/*     */   
/*     */   protected SETT_JOB get(int tx, int ty) {
/*  99 */     return (((LaboratoryInstance)this.ins).blueprintI()).job.get(tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isAndInit(int tx, int ty) {
/* 104 */     return ((((LaboratoryInstance)this.ins).blueprintI()).job.get(tx, ty) != null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\laboratory\LaboratoryInstance$Jobs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */