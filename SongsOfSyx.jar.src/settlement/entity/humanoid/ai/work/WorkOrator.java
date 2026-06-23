/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATES;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ final class WorkOrator extends PlanBlueprint {
/*     */   private WorkOrator(AIModule_Work module, RoomBlueprintIns<?> blueprint, PlanBlueprint[] map, AISTATES.Animation[] anima) {
/*  20 */     super(module, blueprint, map);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     this.walkToJob = new AIPLAN.PLANRES.Resumer(this, (this.blueprint.employment()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  97 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)d.planTile);
/*  98 */           if (s == null) {
/*  99 */             WorkOrator.this.cancel(a, d);
/*     */           }
/* 101 */           return s;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 106 */           return WorkOrator.this.work.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 111 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 122 */     this.work = new AIPLAN.PLANRES.Resumer(this, (this.blueprint.employment()).verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 126 */           SETT_JOB j = ((JOBMANAGER_HASER)WorkOrator.work(a)).getWork().getJob((COORDINATE)d.planTile);
/* 127 */           j.jobStartPerforming();
/* 128 */           return res(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 134 */           if ((STATS.WORK()).WORK_TIME.indu().getD(a.indu()) == 1.0D || !(AI.modules()).work.moduleCanContinue(a, d)) {
/* 135 */             SETT_JOB j = ((JOBMANAGER_HASER)WorkOrator.work(a)).getWork().getJob((COORDINATE)d.planTile);
/* 136 */             j.jobPerform(a, null, 0);
/* 137 */             return null;
/*     */           } 
/*     */           
/* 140 */           if (RND.oneIn(4)) {
/* 141 */             a.speed.setDirCurrent(a.speed.dir().next(-1 + RND.rInt(3)));
/*     */           }
/*     */           
/* 144 */           if (RND.oneIn(2)) {
/* 145 */             return (AI.SUBS()).single.activate(a, d, WorkOrator.this.anima[RND.rInt(WorkOrator.this.anima.length)], (2 + RND.rInt(3)));
/*     */           }
/* 147 */           return (AI.SUBS()).STAND.activateTime(a, d, 3 + RND.rInt(4));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 153 */           return true;
/*     */         }
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */     this.anima = anima;
/*     */   }
/*     */   
/*     */   private final AISTATES.Animation[] anima;
/*     */   final AIPLAN.PLANRES.Resumer walkToJob;
/*     */   final AIPLAN.PLANRES.Resumer work;
/*     */   
/*     */   static WorkOrator getSpeaker(AIModule_Work module, RoomBlueprintIns<?> blueprint, PlanBlueprint[] map) {
/*     */     AISTATES.Animation[] anima = { (AI.STATES()).anima.carry, (AI.STATES()).anima.fist, (AI.STATES()).anima.grab, (AI.STATES()).anima.fistRight, (AI.STATES()).anima.fistRight, (AI.STATES()).anima.fistRight };
/*     */     return new WorkOrator(module, blueprint, map, anima);
/*     */   }
/*     */   
/*     */   static WorkOrator getDancer(AIModule_Work module, RoomBlueprintIns<?> blueprint, PlanBlueprint[] map) {
/*     */     AISTATES.Animation[] anima = { 
/*     */         (AI.STATES()).anima.carry, (AI.STATES()).anima.fist, (AI.STATES()).anima.grab, (AI.STATES()).anima.fistRight, (AI.STATES()).anima.fistLeft, (AI.STATES()).anima.dance, (AI.STATES()).anima.dance, (AI.STATES()).anima.dance, (AI.STATES()).anima.danceE, (AI.STATES()).anima.danceE, 
/*     */         (AI.STATES()).anima.danceE };
/*     */     return new WorkOrator(module, blueprint, map, anima);
/*     */   }
/*     */   
/*     */   static WorkOrator getLecture(AIModule_Work module, RoomBlueprintIns<?> blueprint, PlanBlueprint[] map) {
/*     */     AISTATES.Animation[] anima = { (AI.STATES()).anima.box, (AI.STATES()).anima.fist, (AI.STATES()).anima.grab, (AI.STATES()).anima.wave };
/*     */     return new WorkOrator(module, blueprint, map, anima);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     if (!this.module.moduleCanContinue(a, d) || !hasEmployment(a, d))
/*     */       return null; 
/*     */     if ((STATS.WORK()).WORK_TIME.indu().getD(a.indu()) == 1.0D)
/*     */       return null; 
/*     */     JOB_MANAGER jm = ((JOBMANAGER_HASER)work(a)).getWork();
/*     */     SETT_JOB j = jm.getReservableJob(null);
/*     */     if (j == null)
/*     */       return null; 
/*     */     j.jobReserve(null);
/*     */     d.planTile.set(j.jobCoo());
/*     */     return this.walkToJob.set(a, d);
/*     */   }
/*     */   
/*     */   protected boolean shouldContinue(Humanoid a, AIManager d) {
/*     */     return (jobIsReservedAndReserve(a, d, (RESOURCE)null) && super.shouldContinue(a, d));
/*     */   }
/*     */   
/*     */   protected void cancel(Humanoid a, AIManager d) {
/*     */     jobCancel(a, d, (RESOURCE)null);
/*     */     super.cancel(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkOrator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */