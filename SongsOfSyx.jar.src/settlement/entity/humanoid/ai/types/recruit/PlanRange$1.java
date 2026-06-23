/*    */ package settlement.entity.humanoid.ai.types.recruit;
/*    */ 
/*    */ import init.type.HTYPES;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
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
/*    */   extends PlanRange.Res
/*    */ {
/*    */   null(PlanRange paramPlanRange2) {}
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 40 */     if (PlanRange.this.job(a, d) != null)
/* 41 */       PlanRange.this.job(a, d).jobReserveCancel(null); 
/* 42 */     return (AI.SUBS()).STAND.activate(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 47 */     a.HTypeSet(HTYPES.SUBJECT(), null, null);
/* 48 */     return d.resumeOtherPlan(a, (AI.plans()).NOP);
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\recruit\PlanRange$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */