/*    */ package settlement.entity.humanoid.ai.main;
/*    */ 
/*    */ import util.data.DataO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class AIDataSuspender
/*    */   extends DataO<AIManager>.DataCrumb
/*    */ {
/*    */   public AIDataSuspender(String key) {
/* 42 */     super(paramAIData, key + "_sus");
/*    */   }
/*    */   
/*    */   public boolean is(AIManager d) {
/* 46 */     return (get(d) != 0);
/*    */   }
/*    */   
/*    */   public void suspend(AIManager d) {
/* 50 */     set(d, 2);
/*    */   }
/*    */   
/*    */   public void update(AIManager d) {
/* 54 */     if (is(d))
/* 55 */       set(d, get(d) - 1); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIData$AIDataSuspender.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */