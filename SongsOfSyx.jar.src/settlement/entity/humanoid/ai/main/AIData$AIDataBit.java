/*    */ package settlement.entity.humanoid.ai.main;
/*    */ 
/*    */ import util.data.BOOLEANO;
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
/*    */ public class AIDataBit
/*    */   extends DataO<AIManager>.DataBit
/*    */   implements BOOLEANO.BOOLEAN_OE<AIManager>
/*    */ {
/*    */   public AIDataBit(String key) {
/* 23 */     super(paramAIData, key + "_BIT");
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(AIManager d) {
/* 28 */     return (get(d) == 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public BOOLEANO.BOOLEAN_OE<AIManager> set(AIManager d, boolean s) {
/* 33 */     set(d, s ? 1 : 0);
/* 34 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIData$AIDataBit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */