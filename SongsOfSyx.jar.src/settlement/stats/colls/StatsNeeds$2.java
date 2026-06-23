/*    */ package settlement.stats.colls;
/*    */ 
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.STATS;
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
/*    */   extends DataO<Induvidual>.DataByte
/*    */ {
/*    */   null(DataO paramDataO, String $anonymous0, int $anonymous1) {
/* 76 */     super(paramDataO, $anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(Induvidual i, int s) {
/* 81 */     (STATS.FOOD()).STARVATION.indu().set(i, (get(i) >= 48) ? 1 : 0);
/* 82 */     super.set(i, s);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsNeeds$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */