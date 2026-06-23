/*    */ package settlement.stats.stat;
/*    */ 
/*    */ import settlement.stats.Induvidual;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends STATFakeRace.II<Induvidual>
/*    */ {
/*    */   public int get(Induvidual t) {
/* 57 */     return STATFakeRace.this.history.get(t.race());
/*    */   }
/*    */ 
/*    */   
/*    */   public double getD(Induvidual t) {
/* 62 */     return STATFakeRace.this.history.getD(t.race());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\stat\STATFakeRace$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */