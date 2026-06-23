/*     */ package settlement.room.service.nursery;
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
/*     */   extends JobPositions<NurseryInstance>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Jobs(NurseryInstance ins) {
/* 122 */     super(ins);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isAndInit(int tx, int ty) {
/* 127 */     if (((NurseryInstance)this.ins).is(tx, ty))
/* 128 */       return ((((NurseryInstance)this.ins).blueprintI()).ss.job(tx, ty) != null); 
/* 129 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SETT_JOB get(int tx, int ty) {
/* 134 */     if (((NurseryInstance)this.ins).is(tx, ty))
/* 135 */       return (((NurseryInstance)this.ins).blueprintI()).ss.job(tx, ty); 
/* 136 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\nursery\NurseryInstance$Jobs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */