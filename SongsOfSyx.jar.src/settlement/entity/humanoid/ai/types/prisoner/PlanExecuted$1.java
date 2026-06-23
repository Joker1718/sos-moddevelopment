/*    */ package settlement.entity.humanoid.ai.types.prisoner;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.room.law.execution.ExecutionStation;
/*    */ import snake2d.util.datatypes.COORDINATE;
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
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 35 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 39 */     AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)d.planTile);
/* 40 */     if (s != null)
/* 41 */       return s; 
/* 42 */     PlanExecuted.access$0(PlanExecuted.this, a, d);
/* 43 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 48 */     return PlanExecuted.this.ready.set(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 53 */     ExecutionStation.Client s = PlanExecuted.this.s(d);
/* 54 */     if (s == null || !s.clientReserved())
/* 55 */       return false; 
/* 56 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 61 */     ExecutionStation.Client s = PlanExecuted.this.s(d);
/* 62 */     if (s != null)
/* 63 */       s.clientCancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\PlanExecuted$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */