/*    */ package util.statistics;
/*    */ 
/*    */ import game.time.TIMECYCLE;
/*    */ import util.data.DOUBLE;
/*    */ import util.data.DOUBLE_O;
/*    */ import util.info.INFO;
/*    */ 
/*    */ 
/*    */ public interface HISTORY
/*    */   extends DOUBLE
/*    */ {
/*    */   TIMECYCLE time();
/*    */   
/*    */   int historyRecords();
/*    */   
/*    */   double getD(int paramInt);
/*    */   
/*    */   default double getD() {
/* 19 */     return getD(0);
/*    */   }
/*    */   
/*    */   public static interface HISTORY_OBJECTE<T>
/*    */     extends HISTORY_OBJECT<T>, DOUBLE_O.DOUBLE_OE<T> {}
/*    */   
/*    */   public static interface HISTORY_OBJECT<T>
/*    */     extends DOUBLE_O<T> {
/*    */     double getD(T param1T, int param1Int);
/*    */     
/*    */     TIMECYCLE time();
/*    */     
/*    */     int historyRecords();
/*    */     
/*    */     default double getPeriodD(T t, int from, int to) {
/* 34 */       double am = 0.0D;
/* 35 */       int k = from - to;
/* 36 */       for (int i = 0; i < k; i++) {
/* 37 */         am += (i + 1) * getD(t, to + i);
/*    */       }
/* 39 */       double tot = (k * (k + 1)) * 0.5D;
/* 40 */       am /= tot;
/* 41 */       return am;
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static abstract class HISTORYImp
/*    */     implements HISTORY
/*    */   {
/*    */     private final TIMECYCLE time;
/*    */ 
/*    */     
/*    */     private final int rec;
/*    */ 
/*    */     
/*    */     private final INFO info;
/*    */ 
/*    */ 
/*    */     
/*    */     public HISTORYImp(TIMECYCLE time, int rec) {
/* 61 */       this(null, null, time, rec);
/*    */     }
/*    */     
/*    */     public HISTORYImp(CharSequence name, CharSequence desc, TIMECYCLE time, int rec) {
/* 65 */       if (name == null) {
/* 66 */         this.info = null;
/*    */       } else {
/* 68 */         this.info = new INFO(name, desc);
/* 69 */       }  this.rec = rec;
/* 70 */       this.time = time;
/*    */     }
/*    */ 
/*    */     
/*    */     public TIMECYCLE time() {
/* 75 */       return this.time;
/*    */     }
/*    */ 
/*    */     
/*    */     public int historyRecords() {
/* 80 */       return this.rec;
/*    */     }
/*    */ 
/*    */     
/*    */     public INFO info() {
/* 85 */       return this.info;
/*    */     }
/*    */   }
/*    */   
/*    */   public static interface HISTORYE extends HISTORY, DOUBLE.DOUBLE_MUTABLE {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\statistics\HISTORY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */