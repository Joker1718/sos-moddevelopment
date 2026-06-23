/*    */ package settlement.entity.humanoid.ai.main;
/*    */ 
/*    */ import util.data.BOOLEANO;
/*    */ import util.data.DataO;
/*    */ 
/*    */ public final class AIData
/*    */   extends DataO<AIManager>
/*    */ {
/*    */   AIData() {
/* 10 */     super("AI_DATA");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected long[] data(AIManager t) {
/* 16 */     return t.longs;
/*    */   }
/*    */   
/*    */   public class AIDataBit
/*    */     extends DataO<AIManager>.DataBit
/*    */     implements BOOLEANO.BOOLEAN_OE<AIManager> {
/*    */     public AIDataBit(String key) {
/* 23 */       super(AIData.this, key + "_BIT");
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean is(AIManager d) {
/* 28 */       return (get(d) == 1);
/*    */     }
/*    */ 
/*    */     
/*    */     public BOOLEANO.BOOLEAN_OE<AIManager> set(AIManager d, boolean s) {
/* 33 */       set(d, s ? 1 : 0);
/* 34 */       return this;
/*    */     }
/*    */   }
/*    */   
/*    */   public final class AIDataSuspender
/*    */     extends DataO<AIManager>.DataCrumb
/*    */   {
/*    */     public AIDataSuspender(String key) {
/* 42 */       super(AIData.this, key + "_sus");
/*    */     }
/*    */     
/*    */     public boolean is(AIManager d) {
/* 46 */       return (get(d) != 0);
/*    */     }
/*    */     
/*    */     public void suspend(AIManager d) {
/* 50 */       set(d, 2);
/*    */     }
/*    */     
/*    */     public void update(AIManager d) {
/* 54 */       if (is(d))
/* 55 */         set(d, get(d) - 1); 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */