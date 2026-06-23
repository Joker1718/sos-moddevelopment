/*     */ package util.statistics;
/*     */ 
/*     */ import game.time.TIMECYCLE;
/*     */ import util.info.INFO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HistoryIntWrapper<T>
/*     */ {
/*     */   private HISTORY_INT.HISTORY_INT_OBJECT<T> t;
/*     */   private T g;
/*     */   
/*     */   public HISTORY_INT wrap(HISTORY_INT.HISTORY_INT_OBJECT<T> t, T g) {
/* 145 */     this.t = t;
/* 146 */     this.g = g;
/* 147 */     return this.i;
/*     */   }
/*     */   
/* 150 */   private final HISTORY_INT i = new HISTORY_INT()
/*     */     {
/*     */       public int get()
/*     */       {
/* 154 */         return HISTORY_INT.HistoryIntWrapper.this.t.get(HISTORY_INT.HistoryIntWrapper.this.g);
/*     */       }
/*     */ 
/*     */       
/*     */       public int min() {
/* 159 */         return HISTORY_INT.HistoryIntWrapper.this.t.min(HISTORY_INT.HistoryIntWrapper.this.g);
/*     */       }
/*     */ 
/*     */       
/*     */       public int max() {
/* 164 */         return HISTORY_INT.HistoryIntWrapper.this.t.max(HISTORY_INT.HistoryIntWrapper.this.g);
/*     */       }
/*     */ 
/*     */       
/*     */       public TIMECYCLE time() {
/* 169 */         return HISTORY_INT.HistoryIntWrapper.this.t.time();
/*     */       }
/*     */ 
/*     */       
/*     */       public int historyRecords() {
/* 174 */         return HISTORY_INT.HistoryIntWrapper.this.t.historyRecords();
/*     */       }
/*     */ 
/*     */       
/*     */       public int get(int fromZero) {
/* 179 */         return HISTORY_INT.HistoryIntWrapper.this.t.get(HISTORY_INT.HistoryIntWrapper.this.g, fromZero);
/*     */       }
/*     */ 
/*     */       
/*     */       public INFO info() {
/* 184 */         return HISTORY_INT.HistoryIntWrapper.this.t.info();
/*     */       }
/*     */ 
/*     */       
/*     */       public double getD(int fromZero) {
/* 189 */         return HISTORY_INT.HistoryIntWrapper.this.t.getD(HISTORY_INT.HistoryIntWrapper.this.g, fromZero);
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\statistics\HISTORY_INT$HistoryIntWrapper.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */