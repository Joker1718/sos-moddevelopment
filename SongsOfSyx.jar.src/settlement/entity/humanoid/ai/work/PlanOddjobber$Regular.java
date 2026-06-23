/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import game.GAME;
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
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
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
/*     */ final class Regular
/*     */ {
/*     */   private final AIPlanResourceMany fetch;
/*     */   
/*     */   private Regular() {
/* 567 */     this.fetch = new AIPlanResourceMany(paramPlanOddjobber, 32)
/*     */       {
/*     */         public AISUB.AISubActivation next(Humanoid a, AIManager d)
/*     */         {
/* 571 */           return PlanOddjobber.Regular.this.walk2Job.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void cancel(Humanoid a, AIManager d) {
/* 576 */           d.planByte1 = resource(a, d).bIndex();
/* 577 */           PlanOddjobber.Regular.this.cancel(a, d, resource(a, d));
/*     */         }
/*     */       };
/*     */     
/* 581 */     this.walk2Job = new AIPLAN.PLANRES.Resumer(paramPlanOddjobber, PlanOddjobber.¤¤working)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*     */           AISUB.AISubActivation s;
/* 586 */           Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile);
/*     */           
/* 588 */           if (j == null) {
/* 589 */             PlanOddjobber.Regular.this.cancel(a, d, PlanOddjobber.Regular.this.resource(d));
/* 590 */             return null;
/*     */           } 
/*     */           
/* 593 */           int dx = j.jobCoo().x();
/* 594 */           int dy = j.jobCoo().y();
/*     */           
/* 596 */           if (d.path.isSuccessful() && d.path.destX() == dx && d.path.destY() == dy && 
/* 597 */             a.physics.tileC().isSameAs((COORDINATE)d.path)) {
/* 598 */             s = (AI.SUBS()).walkTo.path(a, d);
/*     */           } else {
/* 600 */             s = (AI.SUBS()).walkTo.coo(a, d, dx, dy);
/*     */           } 
/*     */           
/* 603 */           if (s == null) {
/* 604 */             PlanOddjobber.Regular.this.cancel(a, d, PlanOddjobber.Regular.this.resource(d));
/* 605 */             return null;
/*     */           } 
/* 607 */           return s;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 614 */           Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile);
/*     */           
/* 616 */           if (PlanOddjobber.Regular.access$0(PlanOddjobber.Regular.this).isDumpJob(a, d, j)) {
/* 617 */             if (PlanOddjobber.Regular.access$0(PlanOddjobber.Regular.this).handleDumpJob(a, d, j)) {
/* 618 */               return (PlanOddjobber.Regular.access$0(PlanOddjobber.Regular.this)).dumpResource.set(a, d);
/*     */             }
/*     */             
/* 621 */             return null;
/*     */           } 
/*     */           
/* 624 */           if (j.jobPerformTime(a) == 0.0D) {
/*     */ 
/*     */             
/* 627 */             int am = CLAMP.i(d.resourceA(), 0, j.jobResourcesNeeded(a));
/* 628 */             RESOURCE res = j.jobPerform(a, d.resourceCarried(), am);
/* 629 */             d.resourceAInc(-am);
/* 630 */             if (res != null) {
/* 631 */               d.resourceDrop(a);
/* 632 */               d.resourceCarriedSet(res);
/* 633 */               return (PlanOddjobber.Regular.access$0(PlanOddjobber.Regular.this)).dumpResource.set(a, d);
/*     */             } 
/* 635 */             return null;
/*     */           } 
/* 637 */           return PlanOddjobber.Regular.this.work.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 642 */           Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile);
/* 643 */           if (j == null)
/* 644 */             return false; 
/* 645 */           if (!j.jobReservedIs(PlanOddjobber.Regular.this.resource(d))) {
/*     */             
/* 647 */             if (j.jobReserveCanBe()) {
/*     */               
/* 649 */               if (j.jobResourceBitToFetch() == null) {
/* 650 */                 j.jobReserve(null);
/* 651 */                 d.resourceDrop(a);
/* 652 */                 d.planByte1 = -1;
/* 653 */                 return true;
/* 654 */               }  if (d.resourceCarried() != null && j.jobResourceBitToFetch().has(d.resourceCarried())) {
/* 655 */                 d.planByte1 = d.resourceCarried().bIndex();
/* 656 */                 j.jobReserve(d.resourceCarried());
/* 657 */                 return true;
/*     */               } 
/*     */             } 
/* 660 */             return false;
/*     */           } 
/* 662 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 667 */           PlanOddjobber.Regular.this.cancel(a, d, PlanOddjobber.Regular.this.resource(d));
/*     */         }
/*     */ 
/*     */         
/*     */         public void name(Humanoid a, AIManager d, Str string) {
/* 672 */           SETT_JOB j = (SETT_JOB)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 673 */           if (j == null || j.jobName() == null) {
/* 674 */             super.name(a, d, string);
/*     */           } else {
/* 676 */             string.add(j.jobName());
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 683 */     this.work = new AIPLAN.PLANRES.Resumer(paramPlanOddjobber, PlanOddjobber.¤¤working)
/*     */       {
/* 685 */         private SubWork.SubWorkTool sub = new SubWork.SubWorkTool("regularOddjobtool")
/*     */           {
/*     */             public SETT_JOB getJob(Humanoid a, AIManager d)
/*     */             {
/* 689 */               return (SETT_JOB)(SETT.JOBS()).getter.get((COORDINATE)d.planTile);
/*     */             }
/*     */           };
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 695 */           SETT_JOB j = (SETT_JOB)(SETT.JOBS()).getter.get((COORDINATE)d.planTile);
/* 696 */           j.jobStartPerforming();
/* 697 */           return this.sub.activate(a, d, j);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 702 */           Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile);
/* 703 */           RESOURCE produced = null;
/* 704 */           if (j.jobReservedIs(null)) {
/* 705 */             produced = j.jobPerform(a, null, 0);
/* 706 */           } else if (j.jobReservedIs(d.resourceCarried())) {
/* 707 */             int am = CLAMP.i(d.resourceA(), 0, j.jobResourcesNeeded(a));
/* 708 */             produced = j.jobPerform(a, d.resourceCarried(), am);
/* 709 */             d.resourceAInc(-am);
/*     */           } else {
/* 711 */             PlanOddjobber.Regular.this.cancel(a, d, PlanOddjobber.Regular.this.resource(d));
/* 712 */             return null;
/*     */           } 
/* 714 */           if (produced != null) {
/* 715 */             (SETT.THINGS()).resources.create(a.physics.tileC(), produced, 1);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 720 */           if ((AI.modules()).work.moduleCanContinue(a, d)) {
/* 721 */             j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile);
/* 722 */             if (j != null && j.jobReserveCanBe()) {
/* 723 */               if (j.jobResourcesNeeded(a) == 0) {
/* 724 */                 j.jobReserve(null);
/* 725 */               } else if (d.resourceCarried() != null && (d.resourceCarried()).bit.has(j.jobResourceBitToFetch())) {
/* 726 */                 j.jobReserve(d.resourceCarried());
/*     */               } else {
/* 728 */                 return null;
/* 729 */               }  return PlanOddjobber.Regular.this.walk2Job.set(a, d);
/*     */             } 
/*     */           } 
/* 732 */           j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile);
/* 733 */           if (j != null && j.jobReserveCanBe()) {
/* 734 */             (SETT.ROOMS()).BUILDER.reset((RoomInstance)(STATS.WORK()).EMPLOYED.get(a));
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 740 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 747 */           return PlanOddjobber.Regular.this.walk2Job.con(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 752 */           PlanOddjobber.Regular.this.cancel(a, d, PlanOddjobber.Regular.this.resource(d));
/*     */         }
/*     */         
/*     */         public void name(Humanoid a, AIManager d, Str string)
/*     */         {
/* 757 */           SETT_JOB j = (SETT_JOB)(SETT.JOBS()).getter.get(d.path.destX(), d.path.destY());
/* 758 */           if (j == null || j.jobName() == null) {
/* 759 */             super.name(a, d, string);
/*     */           } else {
/* 761 */             string.add(j.jobName());
/*     */           } 
/*     */         }
/*     */       };
/*     */   } private final AIPLAN.PLANRES.Resumer walk2Job; private final AIPLAN.PLANRES.Resumer work;
/*     */   private void cancel(Humanoid a, AIManager d, RESOURCE res) {
/* 767 */     Job j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile);
/*     */     
/* 769 */     if (j != null) {
/* 770 */       if (j.jobReservedIs(res))
/* 771 */         j.jobReserveCancel(res); 
/* 772 */       if (j.jobReservedIs(null)) {
/* 773 */         j.jobReserveCancel(null);
/*     */       }
/*     */     } 
/* 776 */     d.resourceDrop(a);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d, Job j) {
/*     */     d.planTile.set(j.jobCoo());
/*     */     d.planByte1 = -1;
/*     */     d.resourceDrop(a);
/*     */     if (j.jobResourceBitToFetch() != null) {
/*     */       AISUB.AISubActivation s = this.fetch.activate(a, d, j.jobResourceBitToFetch(), CLAMP.i(j.jobResourcesNeeded(a), 0, WorkAbs.maxCarry), 2147483647, true, true);
/*     */       if (s != null) {
/*     */         j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile);
/*     */         j.jobReserve(this.fetch.resource(a, d));
/*     */         return s;
/*     */       } 
/*     */       return null;
/*     */     } 
/*     */     Job oj = j;
/*     */     j = (Job)(SETT.JOBS()).getter.get((COORDINATE)d.planTile);
/*     */     if (j == null)
/*     */       GAME.Notify(String.valueOf(oj) + " " + String.valueOf(oj)); 
/*     */     j.jobReserve(null);
/*     */     return this.walk2Job.set(a, d);
/*     */   }
/*     */   
/*     */   private RESOURCE resource(AIManager d) {
/*     */     return (d.planByte1 >= 0) ? (RESOURCE)RESOURCES.ALL().get(d.planByte1) : null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\PlanOddjobber$Regular.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */