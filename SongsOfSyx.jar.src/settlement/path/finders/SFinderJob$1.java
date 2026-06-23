/*    */ package settlement.path.finders;
/*    */ 
/*    */ import init.resources.RBIT;
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.components.SComponent;
/*    */ import settlement.path.components.SComponentLevel;
/*    */ import settlement.path.components.finder.SCompFinder;
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
/*    */ class null
/*    */   implements SCompFinder.SCompPatherExister
/*    */ {
/*    */   public boolean isInComponent(SComponent c, double distance) {
/* 56 */     if ((SFinderJob.this.d()).job.get(c) > 0)
/* 57 */       return true; 
/* 58 */     if ((SETT.WEATHER()).growthRipe.cropsAreRipe() && (SFinderJob.this.d()).jobHarvest.get(c) > 0)
/* 59 */       return true; 
/* 60 */     SFinderJob.this.jobMask.or((SFinderJob.this.d()).jobs.bits(c));
/* 61 */     SFinderJob.this.resMask.or((SFinderJob.this.d()).resScattered.bits(c));
/* 62 */     SFinderJob.this.resMask.or((SFinderJob.this.d()).resCrate.bits(c));
/* 63 */     SFinderJob.this.resMask.or((SFinderJob.this.d()).resPriority.bits(c));
/*    */     
/* 65 */     return SFinderJob.this.jobMask.has((RBIT)SFinderJob.this.resMask);
/*    */   }
/*    */ 
/*    */   
/*    */   public void init(SComponentLevel l) {
/* 70 */     SFinderJob.this.resMask.clear();
/* 71 */     SFinderJob.this.jobMask.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderJob$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */