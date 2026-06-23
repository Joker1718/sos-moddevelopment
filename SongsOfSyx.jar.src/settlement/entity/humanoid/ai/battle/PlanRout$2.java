/*    */ package settlement.entity.humanoid.ai.battle;
/*    */ 
/*    */ import init.type.CAUSE_LEAVES;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
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
/* 78 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 82 */     if ((SETT.PATH()).finders.entity.findExitNoEnemies(a, a.physics.tileC().x(), a.physics.tileC().y(), d.path, 2147483647)) {
/* 83 */       return (AI.SUBS()).walkTo.pathRun(a, d);
/*    */     }
/* 85 */     return PlanRout.this.run.set(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 90 */     AIManager.dead = CAUSE_LEAVES.DESERTED();
/* 91 */     return (AI.SUBS()).STAND.activate(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 96 */     return true;
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\PlanRout$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */