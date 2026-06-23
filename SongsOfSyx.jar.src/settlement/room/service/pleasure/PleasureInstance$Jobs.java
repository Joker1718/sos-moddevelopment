/*     */ package settlement.room.service.pleasure;
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
/*     */ class Jobs
/*     */   extends JobPositions<PleasureInstance>
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public Jobs(PleasureInstance ins) {
/*  86 */     super(ins);
/*     */   }
/*     */ 
/*     */   
/*     */   protected SETT_JOB get(int tx, int ty) {
/*  91 */     ABed b = (((PleasureInstance)this.ins).blueprintI()).bed.init(tx, ty);
/*  92 */     if (b != null)
/*  93 */       return b.job; 
/*  94 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isAndInit(int tx, int ty) {
/* 100 */     return (((PleasureInstance)this.ins).is(tx, ty) && (((PleasureInstance)this.ins).blueprintI()).bed.init(tx, ty) != null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\pleasure\PleasureInstance$Jobs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */