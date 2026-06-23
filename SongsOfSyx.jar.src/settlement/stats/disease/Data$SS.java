/*    */ package settlement.stats.disease;
/*    */ 
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.StatsInit;
/*    */ import settlement.stats.stat.STATData;
/*    */ import util.data.INT_O;
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
/*    */ class SS
/*    */   extends STATData
/*    */ {
/*    */   SS(StatsInit init, String key, String dkey, DiseaseStatus status) {
/* 67 */     super(key, key, init, new INT_O.INT_OE<Induvidual>(paramData, status)
/*    */         {
/*    */           public int get(Induvidual t)
/*    */           {
/* 71 */             if (Data.this.get(t) != null && Data.this.status(t) == status)
/* 72 */               return 1; 
/* 73 */             return 0;
/*    */           }
/*    */ 
/*    */           
/*    */           public int min(Induvidual t) {
/* 78 */             return 0;
/*    */           }
/*    */ 
/*    */           
/*    */           public int max(Induvidual t) {
/* 83 */             return 1;
/*    */           }
/*    */           
/*    */           public void set(Induvidual t, int i) {}
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\Data$SS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */