/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.stats.STATS;
/*     */ 
/*     */ final class WorkEmissary
/*     */   extends WorkAbs {
/*     */   protected WorkEmissary(AIModule_Work module, PlanBlueprint[] map, WorkAbs.Works works) {
/*  18 */     super(module, (RoomBlueprintIns<?>)(SETT.ROOMS()).EMBASSY, map, works);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  38 */     this.goOnMission = new AIPLAN.PLANRES.Resumer(this, ((SETT.ROOMS()).EMBASSY.employment()).verb)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  42 */           if ((SETT.PATH()).finders.entryPoints.find(a.tc().x(), a.tc().y(), d.path, 2147483647)) {
/*  43 */             return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */           }
/*  45 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  50 */           return WorkEmissary.this.beOnMission.set(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  60 */           return true;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  65 */     this.beOnMission = new AIPLAN.PLANRES.Resumer(this, ((SETT.ROOMS()).EMBASSY.employment()).verb)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  69 */           SETT.ENTITIES().moveIntoTheTheUnknown((ENTITY)a);
/*  70 */           a.speed.magnitudeInit(0.0D);
/*  71 */           return (AI.SUBS()).STAND.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  76 */           if ((STATS.WORK()).WORK_TIME.indu().getD(a.indu()) > 0.9D) {
/*  77 */             can(a, d);
/*  78 */             return null;
/*     */           } 
/*  80 */           if (AIModules.nextPrio(d) > 7) {
/*  81 */             can(a, d);
/*  82 */             return null;
/*     */           } 
/*  84 */           return (AI.SUBS()).STAND.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/*  89 */           SETT.ENTITIES().returnFromTheTheUnknown((ENTITY)a);
/*     */         }
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d)
/*     */         {
/*  94 */           return true;
/*     */         }
/*     */       };
/*     */   }
/*     */   final AIPLAN.PLANRES.Resumer goOnMission;
/*     */   final AIPLAN.PLANRES.Resumer beOnMission;
/*     */   
/*     */   protected boolean shouldContinue(Humanoid a, AIManager d) {
/* 102 */     if (!super.shouldContinue(a, d)) {
/* 103 */       return false;
/*     */     }
/* 105 */     return true;
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation finishedWork(Humanoid a, AIManager d) {
/*     */     if ((TIME.days().bitsSinceStart() + STATS.RAN().get(a.indu(), 0) & 0x1) == 0)
/*     */       return super.finishedWork(a, d); 
/*     */     if ((STATS.WORK()).WORK_TIME.indu().getD(a.indu()) > 0.5D)
/*     */       return super.finishedWork(a, d); 
/*     */     if (AIModules.nextPrio(d) > 7)
/*     */       return super.finishedWork(a, d); 
/*     */     return this.goOnMission.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkEmissary.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */