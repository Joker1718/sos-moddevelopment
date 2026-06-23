/*     */ package settlement.room.service.speaker;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements JOB_MANAGER
/*     */ {
/*     */   public boolean resourceReachable(RESOURCE res) {
/* 161 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public SETT_JOB reportResourceMissing(RBIT resourceMask, int jx, int jy) {
/* 166 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SETT_JOB getReservableJob(COORDINATE c) {
/* 171 */     return Centre.this.job(Centre.this.ins.body().cX(), Centre.this.ins.body().cY());
/*     */   }
/*     */ 
/*     */   
/*     */   public SETT_JOB getJob(COORDINATE c) {
/* 176 */     return Centre.this.job(Centre.this.ins.body().cX(), Centre.this.ins.body().cY());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reportResourceFound(RESOURCE res) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetResourceSearch() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean resourceShouldSearch(RESOURCE res) {
/* 193 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\speaker\Centre$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */