/*    */ package settlement.entity.humanoid.ai.types.guard;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
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
/* 51 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 56 */     ExecutionStation.Guard g = (SETT.ROOMS()).GUARD.reporter.pollExecution(PlanExecute.work(a));
/* 57 */     if (g == null) {
/* 58 */       return null;
/*    */     }
/* 60 */     d.planTile.set(g.coo());
/*    */     
/* 62 */     AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)d.planTile);
/*    */     
/* 64 */     if (s == null) {
/* 65 */       (SETT.ROOMS()).GUARD.reporter.reportExecution(g.coo().x(), g.coo().y());
/* 66 */       return null;
/*    */     } 
/* 68 */     return s;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 73 */     return PlanExecute.this.wait.set(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 78 */     ExecutionStation.Guard s = PlanExecute.this.s(d);
/* 79 */     if (s == null || !s.active())
/* 80 */       return false; 
/* 81 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 86 */     ExecutionStation.Guard s = PlanExecute.this.s(d);
/* 87 */     if (s != null && s.active())
/* 88 */       (SETT.ROOMS()).GUARD.reporter.reportExecution(s.coo().x(), s.coo().y()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\guard\PlanExecute$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */