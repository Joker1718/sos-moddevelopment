/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import init.resources.RBIT;
/*    */ import init.resources.RESOURCES;
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
/*    */ class null
/*    */   extends AIPLAN.PLANRES.Resumer
/*    */ {
/*    */   final RBIT.RBITImp bits;
/*    */   
/*    */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 36 */     super(paramPLANRES, $anonymous0);
/*    */     
/* 38 */     this.bits = new RBIT.RBITImp();
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 42 */     this.bits.clearSet((RESOURCES.EDI()).mask);
/* 43 */     if ((STATS.FOOD()).STARVATION.indu().get(a.indu()) <= 0) {
/* 44 */       this.bits.and(STATS.FOOD().fetchMask(a));
/*    */     }
/* 46 */     return (AI.SUBS()).walkTo.resource(a, d, (RBIT)this.bits, 2147483647);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 51 */     STATS.FOOD().eat(a, 1, 0.0D);
/* 52 */     return F_PlanEat.this.eat.set(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 57 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 62 */     d.resourceCarriedSet(null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\F_PlanEat$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */