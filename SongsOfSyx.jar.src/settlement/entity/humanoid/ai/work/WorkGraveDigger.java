/*    */ package settlement.entity.humanoid.ai.work;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.room.spirit.grave.GraveData;
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ final class WorkGraveDigger
/*    */   extends PlanBlueprint {
/*    */   private final AIPLAN.PLANRES.Resumer workNormal;
/*    */   
/*    */   WorkGraveDigger(AIModule_Work module, PlanBlueprint[] map, GraveData.GRAVE_DATA_HOLDER pl) {
/* 16 */     super(module, pl.graveData().blueprint(), map);
/*    */     
/* 18 */     this.workNormal = new AIPLAN.PLANRES.Resumer(this, (pl.graveData().blueprint().employment()).verb)
/*    */       {
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 22 */           d.planByte1 = (byte)(1 + RND.rInt(8));
/* 23 */           return (AI.SUBS()).walkTo.room(a, d, WorkGraveDigger.work(a));
/*    */         }
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 28 */           d.planByte1 = (byte)(d.planByte1 - 1); if (d.planByte1 < 0) {
/* 29 */             return d.resumeOtherPlan(a, (AIPLAN)(AI.modules()).subject.corpse);
/*    */           }
/* 31 */           return (AI.SUBS()).WORK_HANDS.activate(a, d, 20.0D);
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 36 */           return true;
/*    */         }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {}
/*    */       };
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/* 52 */     return this.workNormal.set(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkGraveDigger.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */