/*    */ package settlement.entity.humanoid.ai.battle;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import settlement.stats.STATS;
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
/* 46 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 50 */     AISUB.AISubActivation s = (AI.SUBS()).walkTo.serviceInclude(a, d, (SFinderFindable)(SETT.PATH()).finders.manning(a.indu().army()), 100);
/* 51 */     if (s != null) {
/* 52 */       ManPlan.this.walk.set(a, d);
/* 53 */       return s;
/*    */     } 
/* 55 */     return (AI.SUBS()).STAND.activateTime(a, d, 5);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 60 */     AISUB.AISubActivation s = (AI.SUBS()).walkTo.serviceInclude(a, d, (SFinderFindable)(SETT.PATH()).finders.manning(a.indu().army()), 2147483647);
/* 61 */     if (s != null) {
/* 62 */       ManPlan.this.walk.set(a, d);
/* 63 */       return s;
/*    */     } 
/* 65 */     if (!a.indu().player())
/* 66 */       (STATS.BATTLE()).ROUTING.indu().set(a.indu(), 1); 
/* 67 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 72 */     return true;
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\ManPlan$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */