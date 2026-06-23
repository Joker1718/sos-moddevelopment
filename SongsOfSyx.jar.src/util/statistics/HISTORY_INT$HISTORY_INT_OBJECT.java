/*    */ package util.statistics;
/*    */ 
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
/*    */ public interface HISTORY_INT_OBJECT<T>
/*    */   extends INT_O<T>, HISTORY.HISTORY_OBJECT<T>
/*    */ {
/*    */   default int get(T t) {
/* 59 */     return get(t, 0);
/*    */   }
/*    */   
/*    */   default double getD(T t) {
/* 63 */     return getD(t, 0);
/*    */   }
/*    */   
/*    */   int get(T paramT, int paramInt);
/*    */   
/*    */   default int getPeriod(T t, int from, int to) {
/* 69 */     double am = 0.0D;
/* 70 */     int k = from - to;
/* 71 */     for (int i = 0; i < k; i++) {
/* 72 */       am += ((i + 1) * get(t, to + i));
/*    */     }
/* 74 */     double tot = (k * (k + 1)) * 0.5D;
/* 75 */     am /= tot;
/* 76 */     return (int)Math.ceil(am);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\statistics\HISTORY_INT$HISTORY_INT_OBJECT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */