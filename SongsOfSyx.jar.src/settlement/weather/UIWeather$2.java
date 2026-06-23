/*    */ package settlement.weather;
/*    */ 
/*    */ import util.data.DOUBLE;
/*    */ import util.data.INT;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   implements INT.INTE
/*    */ {
/*    */   public int min() {
/* 37 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max() {
/* 42 */     return 100;
/*    */   }
/*    */ 
/*    */   
/*    */   public int get() {
/* 47 */     return (int)Math.round(t.getD() * 100.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(int ti) {
/* 52 */     t.setD(ti / 100.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\weather\UIWeather$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */