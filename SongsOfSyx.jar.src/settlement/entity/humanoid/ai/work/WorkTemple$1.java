/*    */ package settlement.entity.humanoid.ai.work;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.entity.humanoid.ai.util.AIPlanResourceMany;
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
/*    */   extends AIPlanResourceMany
/*    */ {
/*    */   null(AIPLAN.PLANRES $anonymous0, int $anonymous1) {
/* 63 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public AISUB.AISubActivation next(Humanoid a, AIManager d) {
/* 67 */     return WorkTemple.this.walkToJob.set(a, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void cancel(Humanoid a, AIManager d) {
/* 72 */     WorkTemple.this.unreserve(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkTemple$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */