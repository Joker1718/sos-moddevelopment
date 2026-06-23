/*    */ package settlement.entity.humanoid.ai.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AiPlanActivation
/*    */ {
/*    */   private AIPLAN plan;
/*    */   private AISUB.AISubActivation sub;
/*    */   
/*    */   AIPLAN plan() {
/* 29 */     AIPLAN p = this.plan;
/* 30 */     this.plan = null;
/* 31 */     return p;
/*    */   }
/*    */   
/*    */   AISUB.AISubActivation sub() {
/* 35 */     AISUB.AISubActivation s = this.sub;
/* 36 */     this.sub = null;
/* 37 */     return s;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIPLAN$AiPlanActivation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */