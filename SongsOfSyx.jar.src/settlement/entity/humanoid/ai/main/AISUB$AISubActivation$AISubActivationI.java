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
/*    */ class AISubActivationI
/*    */ {
/*    */   public AISUB get() {
/* 65 */     AISUB s = AISUB.AISubActivation.this.sub;
/* 66 */     AISUB.AISubActivation.this.sub = null;
/* 67 */     return s;
/*    */   }
/*    */   
/*    */   public AISTATE state() {
/* 71 */     return AISUB.AISubActivation.this.state;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISUB$AISubActivation$AISubActivationI.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */