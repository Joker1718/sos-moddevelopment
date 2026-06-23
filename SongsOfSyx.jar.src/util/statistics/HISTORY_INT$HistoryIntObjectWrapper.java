/*     */ package util.statistics;
/*     */ 
/*     */ import game.time.TIMECYCLE;
/*     */ import util.data.GETTER;
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
/*     */ public class HistoryIntObjectWrapper<T>
/*     */   implements HISTORY_INT
/*     */ {
/*     */   private final HISTORY_INT.HISTORY_INT_OBJECT<T> t;
/*     */   private final GETTER<T> g;
/*     */   
/*     */   public HistoryIntObjectWrapper(HISTORY_INT.HISTORY_INT_OBJECT<T> t, GETTER<T> g) {
/*  93 */     this.t = t;
/*  94 */     this.g = g;
/*     */   }
/*     */ 
/*     */   
/*     */   public int get() {
/*  99 */     return this.t.get((T)this.g.get());
/*     */   }
/*     */ 
/*     */   
/*     */   public int min() {
/* 104 */     return this.t.min(this.g.get());
/*     */   }
/*     */ 
/*     */   
/*     */   public int max() {
/* 109 */     return this.t.max(this.g.get());
/*     */   }
/*     */ 
/*     */   
/*     */   public TIMECYCLE time() {
/* 114 */     return this.t.time();
/*     */   }
/*     */ 
/*     */   
/*     */   public int historyRecords() {
/* 119 */     return this.t.historyRecords();
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(int fromZero) {
/* 124 */     return this.t.get((T)this.g.get(), fromZero);
/*     */   }
/*     */ 
/*     */   
/*     */   public INFO info() {
/* 129 */     return this.t.info();
/*     */   }
/*     */ 
/*     */   
/*     */   public double getD(int fromZero) {
/* 134 */     return this.t.getD((T)this.g.get(), fromZero);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\statistics\HISTORY_INT$HistoryIntObjectWrapper.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */