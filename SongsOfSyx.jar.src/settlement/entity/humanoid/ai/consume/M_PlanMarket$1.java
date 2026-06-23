/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import snake2d.util.rnd.RND;
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
/* 27 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 32 */     M_PlanMarket.this.get(a, d).findableReserveCancel();
/* 33 */     d.planByte1 = (byte)(5 + RND.rInt(5));
/* 34 */     return (AI.SUBS()).STAND.activateRndDir(a, d, 5);
/*    */   }
/*    */ 
/*    */   
/*    */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 39 */     return M_PlanMarket.this.shop.set(a, d);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\M_PlanMarket$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */