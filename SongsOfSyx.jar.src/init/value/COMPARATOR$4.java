/*    */ package init.value;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends COMPARATOR
/*    */ {
/*    */   null(String $anonymous0, String $anonymous1) {
/* 53 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public boolean passes(double a, double b) {
/* 57 */     return (a == b);
/*    */   }
/*    */ 
/*    */   
/*    */   public double progress(double a, double b) {
/* 62 */     return 1.0D - Math.abs(a - b);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\COMPARATOR$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */