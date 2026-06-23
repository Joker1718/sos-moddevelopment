/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ 
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.Humanoid;
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
/* 61 */     super(paramPLANRES, $anonymous0);
/*    */   }
/*    */   
/*    */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 65 */     return D_PlanDrunk.this.walk.activate(a, d);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 71 */     if (RND.rBoolean())
/* 72 */       return setAction(a, d); 
/* 73 */     if (RND.oneIn(4)) {
/* 74 */       return D_PlanDrunk.this.sleep.set(a, d);
/*    */     }
/* 76 */     return D_PlanDrunk.this.drink.set(a, d);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean con(Humanoid a, AIManager d) {
/* 82 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void can(Humanoid a, AIManager d) {
/* 87 */     d.resourceCarriedSet(null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 92 */     if (e.event == HEvent.COLLISION_TILE) {
/* 93 */       return true;
/*    */     }
/* 95 */     return super.event(a, d, e);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\D_PlanDrunk$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */