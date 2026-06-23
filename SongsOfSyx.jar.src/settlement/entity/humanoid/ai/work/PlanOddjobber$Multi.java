/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.ai.util.AIPlanResourceMany;
/*     */ import settlement.job.Job;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ final class Multi
/*     */ {
/*     */   private final DIR[] dirs;
/*     */   private final AIPlanResourceMany fetch;
/*     */   private final AIPLAN.PLANRES.Resumer walk2Job;
/*     */   private final AIPLAN.PLANRES.Resumer work;
/*     */   
/*     */   private Multi() {
/* 268 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 275 */       .dirs = new DIR[] { DIR.C, DIR.N, DIR.W, DIR.S, DIR.E, DIR.SW, DIR.SE };
/*     */ 
/*     */     
/* 278 */     this.fetch = new AIPlanResourceMany(paramPlanOddjobber, 32)
/*     */       {
/*     */         public AISUB.AISubActivation next(Humanoid a, AIManager d)
/*     */         {
/* 282 */           d.planByte2 = d.resourceCarried().bIndex();
/* 283 */           return PlanOddjobber.Multi.this.walk2Job.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void cancel(Humanoid a, AIManager d) {
/* 288 */           d.planByte2 = resource(a, d).bIndex();
/* 289 */           PlanOddjobber.Multi.this.cancel(a, d, resource(a, d));
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 368 */     this.walk2Job = new AIPLAN.PLANRES.Resumer(paramPlanOddjobber, PlanOddjobber.¤¤working)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*     */           AISUB.AISubActivation s;
/* 373 */           Job j = PlanOddjobber.Multi.this.nextJob(a, d);
/*     */           
/* 375 */           if (j == null) {
/* 376 */             PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d));
/* 377 */             return null;
/*     */           } 
/*     */           
/* 380 */           int dx = j.jobCoo().x();
/* 381 */           int dy = j.jobCoo().y();
/*     */           
/* 383 */           if (d.path.isSuccessful() && d.path.destX() == dx && d.path.destY() == dy && 
/* 384 */             a.physics.tileC().isSameAs((COORDINATE)d.path)) {
/* 385 */             s = (AI.SUBS()).walkTo.path(a, d);
/*     */           } else {
/* 387 */             s = (AI.SUBS()).walkTo.coo(a, d, dx, dy);
/*     */           } 
/*     */           
/* 390 */           if (s == null) {
/* 391 */             PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d));
/* 392 */             return null;
/*     */           } 
/* 394 */           return s;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 401 */           Job j = (Job)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 402 */           if (!PlanOddjobber.Multi.this.canDoJob(a, d, j)) {
/* 403 */             PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d));
/* 404 */             return null;
/*     */           } 
/*     */           
/* 407 */           if (j.jobPerformTime(a) == 0.0D) {
/*     */ 
/*     */ 
/*     */             
/* 411 */             int am = CLAMP.i(d.resourceA(), 0, j.jobResourcesNeeded(a));
/* 412 */             RESOURCE res = j.jobPerform(a, d.resourceCarried(), am);
/* 413 */             d.resourceAInc(-am);
/* 414 */             if (res != null) {
/* 415 */               PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d));
/* 416 */               d.resourceDrop(a);
/* 417 */               d.resourceCarriedSet(res);
/* 418 */               return (PlanOddjobber.Multi.access$0(PlanOddjobber.Multi.this)).dumpResource.set(a, d);
/*     */             } 
/* 420 */             j = (Job)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 421 */             if (PlanOddjobber.Multi.access$0(PlanOddjobber.Multi.this).isClearJob(j, a) && j.jobReserveCanBe())
/*     */             {
/* 423 */               if (j.jobResourceBitToFetch() == null) {
/* 424 */                 j.jobReserve(null);
/* 425 */               } else if (d.resourceCarried() == PlanOddjobber.Multi.this.resource(d) && PlanOddjobber.Multi.this.resource(d) != null && j.jobResourceBitToFetch().has(d.resourceCarried())) {
/* 426 */                 j.jobReserve(d.resourceCarried());
/*     */               } 
/*     */             }
/* 429 */             return setAction(a, d);
/*     */           } 
/*     */           
/* 432 */           AISUB.AISubActivation s = PlanOddjobber.Multi.this.work.set(a, d);
/* 433 */           return s;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 438 */           Job j = (Job)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 439 */           return (j != null);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 444 */           PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d));
/*     */         }
/*     */ 
/*     */         
/*     */         public void name(Humanoid a, AIManager d, Str string) {
/* 449 */           SETT_JOB j = (SETT_JOB)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 450 */           if (j == null || j.jobName() == null) {
/* 451 */             super.name(a, d, string);
/*     */           } else {
/* 453 */             string.add(j.jobName());
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 462 */     this.work = new AIPLAN.PLANRES.Resumer(paramPlanOddjobber, PlanOddjobber.¤¤working)
/*     */       {
/* 464 */         private SubWork.SubWorkTool sub = new SubWork.SubWorkTool("oddjobtool")
/*     */           {
/*     */             public SETT_JOB getJob(Humanoid a, AIManager d)
/*     */             {
/* 468 */               return (SETT_JOB)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/*     */             }
/*     */           };
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 474 */           Job j = (Job)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 475 */           j.jobStartPerforming();
/* 476 */           PlanOddjobber.Multi.access$0(PlanOddjobber.Multi.this).debug(a, d);
/* 477 */           return this.sub.activate(a, d, (SETT_JOB)j);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 482 */           Job j = (Job)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 483 */           RESOURCE produced = null;
/* 484 */           if (j.jobReservedIs(null)) {
/* 485 */             produced = j.jobPerform(a, null, 0);
/* 486 */           } else if (j.jobReservedIs(d.resourceCarried())) {
/* 487 */             int am = CLAMP.i(d.resourceA(), 0, j.jobResourcesNeeded(a));
/* 488 */             produced = j.jobPerform(a, d.resourceCarried(), am);
/* 489 */             d.resourceAInc(-am);
/*     */           } else {
/* 491 */             PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d));
/* 492 */             return null;
/*     */           } 
/*     */           
/* 495 */           j = (Job)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 496 */           if (PlanOddjobber.Multi.access$0(PlanOddjobber.Multi.this).isClearJob(j, a) && j.jobReserveCanBe()) {
/* 497 */             if (j.jobResourceBitToFetch() == null) {
/* 498 */               j.jobReserve(null);
/* 499 */             } else if (d.resourceCarried() != null && j.jobResourceBitToFetch().has(d.resourceCarried())) {
/* 500 */               j.jobReserve(d.resourceCarried());
/*     */             } 
/*     */           }
/*     */           
/* 504 */           if (produced != null) {
/* 505 */             (SETT.THINGS()).resources.create(a.physics.tileC(), produced, 1);
/*     */           }
/*     */           
/* 508 */           return PlanOddjobber.Multi.this.walk2Job.set(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 515 */           return PlanOddjobber.Multi.this.walk2Job.con(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 520 */           PlanOddjobber.Multi.this.cancel(a, d, PlanOddjobber.Multi.this.resource(d));
/*     */         }
/*     */ 
/*     */         
/*     */         public void name(Humanoid a, AIManager d, Str string) {
/* 525 */           SETT_JOB j = (SETT_JOB)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 526 */           if (j == null || j.jobName() == null) {
/* 527 */             super.name(a, d, string);
/*     */           } else {
/* 529 */             string.add(j.jobName());
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d, Job j) {
/*     */     int i;
/*     */     if (!PlanOddjobber.this.isClearJob(j, a))
/*     */       return null; 
/*     */     d.planTile.set(j.jobCoo());
/*     */     RESOURCE res = (j.jobResourcesNeeded(a) > 0) ? j.res() : null;
/*     */     boolean needsNow = true;
/*     */     d.planByte1 = 0;
/*     */     int extraRes = 0;
/*     */     for (int di = 0; di < this.dirs.length; di++) {
/*     */       DIR dir = this.dirs[di];
/*     */       j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile, dir);
/*     */       if (PlanOddjobber.this.isClearJob(j, a) && j.jobReserveCanBe() && j.res() == res) {
/*     */         d.planByte1 = (byte)(d.planByte1 | 1 << di);
/*     */         extraRes += j.jobResourcesNeeded(a);
/*     */         i = needsNow & ((j.jobResourceBitToFetch() != null) ? 1 : 0);
/*     */         j.jobReserve((j.jobResourceBitToFetch() != null) ? j.res() : null);
/*     */         if (extraRes >= WorkAbs.maxCarry)
/*     */           break; 
/*     */       } 
/*     */     } 
/*     */     if (res != null) {
/*     */       AISUB.AISubActivation s = this.fetch.activate(a, d, res.bit, CLAMP.i(extraRes, 0, WorkAbs.maxCarry), (i != 0) ? Integer.MAX_VALUE : 120, true, true);
/*     */       if (s != null)
/*     */         return s; 
/*     */     } 
/*     */     d.planByte2 = (res == null) ? -1 : res.bIndex();
/*     */     if (i != 0) {
/*     */       cancel(a, d, res);
/*     */       return null;
/*     */     } 
/*     */     cancelResourceJobs(a, d);
/*     */     d.planByte2 = -1;
/*     */     return this.walk2Job.set(a, d);
/*     */   }
/*     */   
/*     */   private RESOURCE resource(AIManager d) {
/*     */     return (d.planByte2 >= 0) ? (RESOURCE)RESOURCES.ALL().get(d.planByte2) : null;
/*     */   }
/*     */   
/*     */   private Job nextJob(Humanoid a, AIManager d) {
/*     */     if (d.planByte1 == 0)
/*     */       return null; 
/*     */     for (int di = 0; di < this.dirs.length; di++) {
/*     */       DIR dir = this.dirs[di];
/*     */       if ((d.planByte1 & 1 << di) != 0) {
/*     */         Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile, dir);
/*     */         if (canDoJob(a, d, j))
/*     */           return j; 
/*     */         cancelJob(a, d, j, resource(d));
/*     */         j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile, dir);
/*     */         d.planByte1 = (byte)(d.planByte1 & (1 << di ^ 0xFFFFFFFF));
/*     */       } 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   private Job cancelResourceJobs(Humanoid a, AIManager d) {
/*     */     if (d.planByte1 == 0)
/*     */       return null; 
/*     */     for (int di = 0; di < this.dirs.length; di++) {
/*     */       DIR dir = this.dirs[di];
/*     */       if ((d.planByte1 & 1 << di) != 0) {
/*     */         Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile, dir);
/*     */         if (j != null && j.jobResourceBitToFetch() != null) {
/*     */           cancelJob(a, d, j, resource(d));
/*     */           d.planByte1 = (byte)(d.planByte1 & (1 << di ^ 0xFFFFFFFF));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   private boolean canDoJob(Humanoid a, AIManager d, Job j) {
/*     */     if (j == null)
/*     */       return false; 
/*     */     if (PlanOddjobber.this.isClearJob(j, a)) {
/*     */       if (j.jobReservedIs(resource(d)) && d.resourceCarried() == resource(d))
/*     */         return true; 
/*     */       if (j.jobReservedIs(null))
/*     */         return true; 
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   private void cancelJob(Humanoid a, AIManager d, Job j, RESOURCE res) {
/*     */     if (j == null)
/*     */       return; 
/*     */     if (j.jobReservedIs(res)) {
/*     */       j.jobReserveCancel(res);
/*     */     } else if (j.jobReservedIs(null)) {
/*     */       j.jobReserveCancel(null);
/*     */     } else {
/*     */       j.jobReserveCancel(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void cancel(Humanoid a, AIManager d, RESOURCE res) {
/*     */     Job j = nextJob(a, d);
/*     */     while (j != null) {
/*     */       cancelJob(a, d, j, res);
/*     */       j = nextJob(a, d);
/*     */     } 
/*     */     d.resourceDrop(a);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\PlanOddjobber$Multi.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */