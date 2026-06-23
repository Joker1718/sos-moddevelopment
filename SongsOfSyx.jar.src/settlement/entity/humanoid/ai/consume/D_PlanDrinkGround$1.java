/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.faction.FResources;
/*    */ import init.resources.RBIT;
/*    */ import init.resources.RESOURCES;
/*    */ import init.type.NEEDS;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
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
/*    */ class null
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 45 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 49 */     D_PlanDrinkGround.bi.clearSet((RESOURCES.DRINKS()).mask).and(STATS.FOOD().fetchMask(a));
/* 50 */     return (AI.SUBS()).walkTo.resource(a, d, (RBIT)D_PlanDrinkGround.bi);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 57 */     GAME.player().res().inc(d.resourceCarried(), FResources.RTYPE.CONSUMED, -1);
/* 58 */     (NEEDS.TYPES()).THIRST.stat().fix(a.indu());
/*    */     
/* 60 */     (STATS.FOOD()).DRINK.indu().set(a.indu(), 1);
/*    */     
/* 62 */     return D_PlanDrinkGround.this.drink.set(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 67 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 72 */     d.resourceCarriedSet(null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\D_PlanDrinkGround$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */