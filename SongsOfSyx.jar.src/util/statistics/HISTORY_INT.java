/*     */ package util.statistics;
/*     */ 
/*     */ import game.time.TIMECYCLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ 
/*     */ 
/*     */ public interface HISTORY_INT
/*     */   extends INT, HISTORY
/*     */ {
/*     */   int get(int paramInt);
/*     */   
/*     */   default int get() {
/*  17 */     return get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   default double getD() {
/*  22 */     return getD(0);
/*     */   }
/*     */   
/*     */   default int getPeriod(int from, int to) {
/*  26 */     double am = 0.0D;
/*  27 */     int k = from - to;
/*  28 */     for (int i = 0; i < k; i++) {
/*  29 */       am += ((i + 1) * get(to + i));
/*     */     }
/*  31 */     double tot = (k * (k + 1)) * 0.5D;
/*  32 */     am /= tot;
/*  33 */     return (int)Math.ceil(am);
/*     */   }
/*     */   
/*     */   default int getPeriodSum(int from, int to) {
/*  37 */     int am = 0;
/*  38 */     from = CLAMP.i(from, -historyRecords(), 0);
/*  39 */     to = CLAMP.i(to, from, 0);
/*  40 */     from++;
/*     */     
/*  42 */     while (from <= to) {
/*  43 */       am += get(-from);
/*     */       
/*  45 */       from++;
/*     */     } 
/*  47 */     return am;
/*     */   }
/*     */ 
/*     */   
/*     */   public static interface HISTORY_INTE
/*     */     extends HISTORY_INT, HISTORY.HISTORYE, INT.INTE {}
/*     */ 
/*     */   
/*     */   public static interface HISTORY_INT_OBJECT<T>
/*     */     extends INT_O<T>, HISTORY.HISTORY_OBJECT<T>
/*     */   {
/*     */     default int get(T t) {
/*  59 */       return get(t, 0);
/*     */     }
/*     */     
/*     */     default double getD(T t) {
/*  63 */       return getD(t, 0);
/*     */     }
/*     */     
/*     */     int get(T param1T, int param1Int);
/*     */     
/*     */     default int getPeriod(T t, int from, int to) {
/*  69 */       double am = 0.0D;
/*  70 */       int k = from - to;
/*  71 */       for (int i = 0; i < k; i++) {
/*  72 */         am += ((i + 1) * get(t, to + i));
/*     */       }
/*  74 */       double tot = (k * (k + 1)) * 0.5D;
/*  75 */       am /= tot;
/*  76 */       return (int)Math.ceil(am);
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface HISTORY_INT_OBJECTE<T>
/*     */     extends INT_O.INT_OE<T>, HISTORY.HISTORY_OBJECTE<T>
/*     */   {
/*     */     int get(T param1T, int param1Int);
/*     */   }
/*     */   
/*     */   public static class HistoryIntObjectWrapper<T>
/*     */     implements HISTORY_INT
/*     */   {
/*     */     private final HISTORY_INT.HISTORY_INT_OBJECT<T> t;
/*     */     private final GETTER<T> g;
/*     */     
/*     */     public HistoryIntObjectWrapper(HISTORY_INT.HISTORY_INT_OBJECT<T> t, GETTER<T> g) {
/*  93 */       this.t = t;
/*  94 */       this.g = g;
/*     */     }
/*     */ 
/*     */     
/*     */     public int get() {
/*  99 */       return this.t.get((T)this.g.get());
/*     */     }
/*     */ 
/*     */     
/*     */     public int min() {
/* 104 */       return this.t.min(this.g.get());
/*     */     }
/*     */ 
/*     */     
/*     */     public int max() {
/* 109 */       return this.t.max(this.g.get());
/*     */     }
/*     */ 
/*     */     
/*     */     public TIMECYCLE time() {
/* 114 */       return this.t.time();
/*     */     }
/*     */ 
/*     */     
/*     */     public int historyRecords() {
/* 119 */       return this.t.historyRecords();
/*     */     }
/*     */ 
/*     */     
/*     */     public int get(int fromZero) {
/* 124 */       return this.t.get((T)this.g.get(), fromZero);
/*     */     }
/*     */ 
/*     */     
/*     */     public INFO info() {
/* 129 */       return this.t.info();
/*     */     }
/*     */ 
/*     */     
/*     */     public double getD(int fromZero) {
/* 134 */       return this.t.getD((T)this.g.get(), fromZero);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class HistoryIntWrapper<T>
/*     */   {
/*     */     private HISTORY_INT.HISTORY_INT_OBJECT<T> t;
/*     */     private T g;
/*     */     
/*     */     public HISTORY_INT wrap(HISTORY_INT.HISTORY_INT_OBJECT<T> t, T g) {
/* 145 */       this.t = t;
/* 146 */       this.g = g;
/* 147 */       return this.i;
/*     */     }
/*     */     
/* 150 */     private final HISTORY_INT i = new HISTORY_INT()
/*     */       {
/*     */         public int get()
/*     */         {
/* 154 */           return HISTORY_INT.HistoryIntWrapper.this.t.get(HISTORY_INT.HistoryIntWrapper.this.g);
/*     */         }
/*     */ 
/*     */         
/*     */         public int min() {
/* 159 */           return HISTORY_INT.HistoryIntWrapper.this.t.min(HISTORY_INT.HistoryIntWrapper.this.g);
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 164 */           return HISTORY_INT.HistoryIntWrapper.this.t.max(HISTORY_INT.HistoryIntWrapper.this.g);
/*     */         }
/*     */ 
/*     */         
/*     */         public TIMECYCLE time() {
/* 169 */           return HISTORY_INT.HistoryIntWrapper.this.t.time();
/*     */         }
/*     */ 
/*     */         
/*     */         public int historyRecords() {
/* 174 */           return HISTORY_INT.HistoryIntWrapper.this.t.historyRecords();
/*     */         }
/*     */ 
/*     */         
/*     */         public int get(int fromZero) {
/* 179 */           return HISTORY_INT.HistoryIntWrapper.this.t.get(HISTORY_INT.HistoryIntWrapper.this.g, fromZero);
/*     */         }
/*     */ 
/*     */         
/*     */         public INFO info() {
/* 184 */           return HISTORY_INT.HistoryIntWrapper.this.t.info();
/*     */         }
/*     */ 
/*     */         
/*     */         public double getD(int fromZero) {
/* 189 */           return HISTORY_INT.HistoryIntWrapper.this.t.getD(HISTORY_INT.HistoryIntWrapper.this.g, fromZero);
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\statistics\HISTORY_INT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */