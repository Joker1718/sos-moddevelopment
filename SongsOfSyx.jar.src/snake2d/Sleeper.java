/*    */ package snake2d;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class Sleeper
/*    */ {
/*    */   private static long variableYieldTime;
/*    */   private static long lastTime;
/*    */   
/*    */   static void sync(int fps) {
/* 19 */     if (fps <= 0)
/*    */       return; 
/* 21 */     long sleepTime = (1000000000 / fps);
/*    */     
/* 23 */     long yieldTime = Math.min(sleepTime, variableYieldTime + sleepTime % 1000000L);
/* 24 */     long overSleep = 0L;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/*    */       while (true) {
/*    */         return;
/*    */       }
/*    */     } finally {
/* 43 */       lastTime = System.nanoTime() - Math.min(overSleep, sleepTime);
/*    */ 
/*    */       
/* 46 */       if (overSleep > variableYieldTime) {
/*    */         
/* 48 */         variableYieldTime = Math.min(variableYieldTime + 200000L, sleepTime);
/*    */       }
/* 50 */       else if (overSleep < variableYieldTime - 200000L) {
/*    */         
/* 52 */         variableYieldTime = Math.max(variableYieldTime - 2000L, 0L);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\Sleeper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */