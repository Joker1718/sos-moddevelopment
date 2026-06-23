/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.job.Job;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*     */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 581 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*     */     AISUB.AISubActivation s;
/* 586 */     Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile);
/*     */     
/* 588 */     if (j == null) {
/* 589 */       PlanOddjobber.Regular.this.cancel(a, d, PlanOddjobber.Regular.this.resource(d));
/* 590 */       return null;
/*     */     } 
/*     */     
/* 593 */     int dx = j.jobCoo().x();
/* 594 */     int dy = j.jobCoo().y();
/*     */     
/* 596 */     if (d.path.isSuccessful() && d.path.destX() == dx && d.path.destY() == dy && 
/* 597 */       a.physics.tileC().isSameAs((COORDINATE)d.path)) {
/* 598 */       s = (AI.SUBS()).walkTo.path(a, d);
/*     */     } else {
/* 600 */       s = (AI.SUBS()).walkTo.coo(a, d, dx, dy);
/*     */     } 
/*     */     
/* 603 */     if (s == null) {
/* 604 */       PlanOddjobber.Regular.this.cancel(a, d, PlanOddjobber.Regular.this.resource(d));
/* 605 */       return null;
/*     */     } 
/* 607 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 614 */     Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile);
/*     */     
/* 616 */     if (PlanOddjobber.Regular.access$0(PlanOddjobber.Regular.this).isDumpJob(a, d, j)) {
/* 617 */       if (PlanOddjobber.Regular.access$0(PlanOddjobber.Regular.this).handleDumpJob(a, d, j)) {
/* 618 */         return (PlanOddjobber.Regular.access$0(PlanOddjobber.Regular.this)).dumpResource.set(a, d);
/*     */       }
/*     */       
/* 621 */       return null;
/*     */     } 
/*     */     
/* 624 */     if (j.jobPerformTime(a) == 0.0D) {
/*     */ 
/*     */       
/* 627 */       int am = CLAMP.i(d.resourceA(), 0, j.jobResourcesNeeded(a));
/* 628 */       RESOURCE res = j.jobPerform(a, d.resourceCarried(), am);
/* 629 */       d.resourceAInc(-am);
/* 630 */       if (res != null) {
/* 631 */         d.resourceDrop(a);
/* 632 */         d.resourceCarriedSet(res);
/* 633 */         return (PlanOddjobber.Regular.access$0(PlanOddjobber.Regular.this)).dumpResource.set(a, d);
/*     */       } 
/* 635 */       return null;
/*     */     } 
/* 637 */     return PlanOddjobber.Regular.this.work.set(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 642 */     Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile);
/* 643 */     if (j == null)
/* 644 */       return false; 
/* 645 */     if (!j.jobReservedIs(PlanOddjobber.Regular.this.resource(d))) {
/*     */       
/* 647 */       if (j.jobReserveCanBe()) {
/*     */         
/* 649 */         if (j.jobResourceBitToFetch() == null) {
/* 650 */           j.jobReserve(null);
/* 651 */           d.resourceDrop(a);
/* 652 */           d.planByte1 = -1;
/* 653 */           return true;
/* 654 */         }  if (d.resourceCarried() != null && j.jobResourceBitToFetch().has(d.resourceCarried())) {
/* 655 */           d.planByte1 = d.resourceCarried().bIndex();
/* 656 */           j.jobReserve(d.resourceCarried());
/* 657 */           return true;
/*     */         } 
/*     */       } 
/* 660 */       return false;
/*     */     } 
/* 662 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 667 */     PlanOddjobber.Regular.this.cancel(a, d, PlanOddjobber.Regular.this.resource(d));
/*     */   }
/*     */ 
/*     */   
/*     */   public void name(Humanoid a, AIManager d, Str string) {
/* 672 */     SETT_JOB j = (SETT_JOB)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 673 */     if (j == null || j.jobName() == null) {
/* 674 */       super.name(a, d, string);
/*     */     } else {
/* 676 */       string.add(j.jobName());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\PlanOddjobber$Regular$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */