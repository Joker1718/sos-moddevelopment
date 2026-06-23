/*    */ package settlement.entity.humanoid.ai.main;
/*    */ 
/*    */ import init.type.CAUSE_LEAVES;
/*    */ import settlement.entity.humanoid.Humanoid;
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
/*    */ class null
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 66 */     return (AI.SUBS()).walkTo.path(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 71 */     if ((SETT.TERRAIN()).WATER.DEEP.is(a.tc()))
/* 72 */       return AIPlans.null.this.drowning.set(a, d); 
/* 73 */     if (!(SETT.PATH()).connectivity.is(a.physics.tileC()))
/* 74 */       AIManager.dead = CAUSE_LEAVES.DROWNED(); 
/* 75 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 80 */     return true;
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIPlans$1$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */