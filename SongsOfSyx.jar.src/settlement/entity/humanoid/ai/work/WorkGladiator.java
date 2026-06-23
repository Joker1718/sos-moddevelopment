/*    */ package settlement.entity.humanoid.ai.work;
/*    */ 
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.HPoll;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.entity.humanoid.ai.util.AIPlanGladiator;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import settlement.room.service.arena.RoomArenaWork;
/*    */ import settlement.stats.STATS;
/*    */ 
/*    */ final class WorkGladiator
/*    */   extends PlanBlueprint {
/*    */   private final AIPlanGladiator plan;
/*    */   
/*    */   protected WorkGladiator(final RoomArenaWork g, RoomBlueprintIns<?> blue, AIModule_Work module, PlanBlueprint[] map) {
/* 20 */     super(module, blue, map);
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
/* 60 */     this.res = new AIPLAN.PLANRES.Resumer(this)
/*    */       {
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 64 */           return (AI.SUBS()).STAND.activate(a, d);
/*    */         }
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 69 */           if (WorkGladiator.work(a) != null) {
/* 70 */             if (!WorkGladiator.this.w.gladiatorInArena(a.tc().x(), a.tc().y())) {
/* 71 */               (STATS.NEEDS()).INJURIES.COUNT.indu().set(a.indu(), 0);
/*    */             }
/* 73 */             d.planTile.set(WorkGladiator.this.w.gladiatorGetSpot(WorkGladiator.work(a)));
/* 74 */             return d.resumeOtherPlan(a, (AIPLAN)WorkGladiator.this.plan);
/*    */           } 
/* 76 */           return null;
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 82 */           return true;
/*    */         }
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {}
/*    */ 
/*    */ 
/*    */         
/*    */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 93 */           return WorkGladiator.this.plan.event(a, d, e);
/*    */         }
/*    */ 
/*    */         
/*    */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 98 */           return WorkGladiator.this.plan.poll(a, d, e);
/*    */         }
/*    */       };
/*    */     this.w = g;
/*    */     this.plan = new AIPlanGladiator("Work_" + blue.key, false, (blue.employment()).verb) {
/*    */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/*    */           if (e.type == HPoll.WORKING)
/*    */             return 1.0D; 
/*    */           return super.poll(a, d, e);
/*    */         }
/*    */         
/*    */         protected boolean shouldContinue(Humanoid a, AIManager d) {
/*    */           return WorkGladiator.this.hasEmployment(a, d);
/*    */         }
/*    */         
/*    */         protected void cancel(Humanoid a, AIManager d) {
/*    */           super.cancel(a, d);
/*    */           if (WorkGladiator.work(a) != null && WorkGladiator.work(a).employees().isOverstaffed())
/*    */             (STATS.WORK()).EMPLOYED.set(a, null); 
/*    */         }
/*    */         
/*    */         protected RoomArenaWork w(Humanoid a, AIManager d) {
/*    */           return g;
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   private final RoomArenaWork w;
/*    */   private final AIPLAN.PLANRES.Resumer res;
/*    */   
/*    */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*    */     return this.res.set(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkGladiator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */