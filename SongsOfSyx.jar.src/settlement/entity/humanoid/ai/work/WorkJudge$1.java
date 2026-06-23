/*    */ package settlement.entity.humanoid.ai.work;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.room.law.court.CourtStation;
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
/*    */ class null
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 28 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 32 */     AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)d.planTile);
/* 33 */     if (s == null) {
/* 34 */       can(a, d);
/* 35 */       return null;
/*    */     } 
/* 37 */     return s;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 42 */     return WorkJudge.this.init.set(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 47 */     CourtStation s = WorkJudge.this.b.executionSpot((COORDINATE)d.planTile);
/* 48 */     return (WorkJudge.this.hasEmployment(a, d) && s != null && s.workReserved());
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 53 */     CourtStation s = WorkJudge.this.b.executionSpot((COORDINATE)d.planTile);
/* 54 */     if (s != null)
/* 55 */       s.workCancel(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkJudge$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */