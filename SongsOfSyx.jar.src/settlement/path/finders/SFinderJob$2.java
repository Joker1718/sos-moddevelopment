/*     */ package settlement.path.finders;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import settlement.job.Job;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComponent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements SFINDER
/*     */ {
/*     */   public boolean isInComponent(SComponent c, double distance) {
/*  79 */     if ((SFinderJob.this.d()).job.get(c) > 0)
/*  80 */       return true; 
/*  81 */     if (SFinderJob.this.resMask.has((SFinderJob.this.d()).jobs.bits(c)))
/*  82 */       return true; 
/*  83 */     if ((SETT.WEATHER()).growthRipe.cropsAreRipe() && (SFinderJob.this.d()).jobHarvest.get(c) > 0)
/*  84 */       return true; 
/*  85 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTile(int tx, int ty, int tileNr) {
/*  90 */     SFinderJob.this.result = (Job)(SETT.JOBS()).getter.get(tx, ty);
/*     */     
/*  92 */     if (SFinderJob.this.result == null)
/*  93 */       return false; 
/*  94 */     if (!SFinderJob.this.result.jobReserveCanBe())
/*  95 */       return false; 
/*  96 */     if (SFinderJob.this.result.needsRipe() && !(SETT.WEATHER()).growthRipe.cropsAreRipe())
/*  97 */       return false; 
/*  98 */     if (SFinderJob.this.result.resourceCurrentlyNeeded() == null)
/*  99 */       return true; 
/* 100 */     if ((SFinderJob.this.result.resourceCurrentlyNeeded()).bit.has((RBIT)SFinderJob.this.resMask)) {
/* 101 */       return true;
/*     */     }
/* 103 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderJob$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */