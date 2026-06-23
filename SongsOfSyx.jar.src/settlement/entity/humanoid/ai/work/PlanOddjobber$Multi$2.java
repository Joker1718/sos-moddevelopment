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
/*     */ class null
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*     */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 368 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*     */     AISUB.AISubActivation s;
/* 373 */     Job j = PlanOddjobber.Multi.this.nextJob(a, d);
/*     */     
/* 375 */     if (j == null) {
/* 376 */       PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d));
/* 377 */       return null;
/*     */     } 
/*     */     
/* 380 */     int dx = j.jobCoo().x();
/* 381 */     int dy = j.jobCoo().y();
/*     */     
/* 383 */     if (d.path.isSuccessful() && d.path.destX() == dx && d.path.destY() == dy && 
/* 384 */       a.physics.tileC().isSameAs((COORDINATE)d.path)) {
/* 385 */       s = (AI.SUBS()).walkTo.path(a, d);
/*     */     } else {
/* 387 */       s = (AI.SUBS()).walkTo.coo(a, d, dx, dy);
/*     */     } 
/*     */     
/* 390 */     if (s == null) {
/* 391 */       PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d));
/* 392 */       return null;
/*     */     } 
/* 394 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 401 */     Job j = (Job)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 402 */     if (!PlanOddjobber.Multi.this.canDoJob(a, d, j)) {
/* 403 */       PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d));
/* 404 */       return null;
/*     */     } 
/*     */     
/* 407 */     if (j.jobPerformTime(a) == 0.0D) {
/*     */ 
/*     */ 
/*     */       
/* 411 */       int am = CLAMP.i(d.resourceA(), 0, j.jobResourcesNeeded(a));
/* 412 */       RESOURCE res = j.jobPerform(a, d.resourceCarried(), am);
/* 413 */       d.resourceAInc(-am);
/* 414 */       if (res != null) {
/* 415 */         PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d));
/* 416 */         d.resourceDrop(a);
/* 417 */         d.resourceCarriedSet(res);
/* 418 */         return (PlanOddjobber.Multi.access$0(PlanOddjobber.Multi.this)).dumpResource.set(a, d);
/*     */       } 
/* 420 */       j = (Job)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 421 */       if (PlanOddjobber.Multi.access$0(PlanOddjobber.Multi.this).isClearJob(j, a) && j.jobReserveCanBe())
/*     */       {
/* 423 */         if (j.jobResourceBitToFetch() == null) {
/* 424 */           j.jobReserve(null);
/* 425 */         } else if (d.resourceCarried() == PlanOddjobber.Multi.this.resource(d) && PlanOddjobber.Multi.this.resource(d) != null && j.jobResourceBitToFetch().has(d.resourceCarried())) {
/* 426 */           j.jobReserve(d.resourceCarried());
/*     */         } 
/*     */       }
/* 429 */       return setAction(a, d);
/*     */     } 
/*     */     
/* 432 */     AISUB.AISubActivation s = PlanOddjobber.Multi.this.work.set(a, d);
/* 433 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 438 */     Job j = (Job)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 439 */     return (j != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 444 */     PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d));
/*     */   }
/*     */ 
/*     */   
/*     */   public void name(Humanoid a, AIManager d, Str string) {
/* 449 */     SETT_JOB j = (SETT_JOB)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 450 */     if (j == null || j.jobName() == null) {
/* 451 */       super.name(a, d, string);
/*     */     } else {
/* 453 */       string.add(j.jobName());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\PlanOddjobber$Multi$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */