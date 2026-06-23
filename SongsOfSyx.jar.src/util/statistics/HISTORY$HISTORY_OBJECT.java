/*    */ package util.statistics;
/*    */ 
/*    */ import game.time.TIMECYCLE;
/*    */ import util.data.DOUBLE_O;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface HISTORY_OBJECT<T>
/*    */   extends DOUBLE_O<T>
/*    */ {
/*    */   double getD(T paramT, int paramInt);
/*    */   
/*    */   TIMECYCLE time();
/*    */   
/*    */   int historyRecords();
/*    */   
/*    */   default double getPeriodD(T t, int from, int to) {
/* 34 */     double am = 0.0D;
/* 35 */     int k = from - to;
/* 36 */     for (int i = 0; i < k; i++) {
/* 37 */       am += (i + 1) * getD(t, to + i);
/*    */     }
/* 39 */     double tot = (k * (k + 1)) * 0.5D;
/* 40 */     am /= tot;
/* 41 */     return am;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\statistics\HISTORY$HISTORY_OBJECT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */