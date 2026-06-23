/*     */ package game.debug;
/*     */ 
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ 
/*     */ 
/*     */ public interface Profiler
/*     */ {
/*     */   default void logStart(Object o) {
/*  12 */     logStart(o.getClass());
/*     */   }
/*     */ 
/*     */   
/*     */   default void logEnd(Object o) {
/*  17 */     logEnd(o.getClass());
/*     */   }
/*     */   void logStart(Class<?> paramClass);
/*     */   void logEnd(Class<?> paramClass);
/*     */   
/*  22 */   public static final Profiler DUMMY = new Profiler()
/*     */     {
/*     */       public void logStart(Class<?> cl) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void logEnd(Class<?> cl) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void log() {}
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   public static final Profiler LIVE = new Profiler()
/*     */     {
/*  45 */       private final ArrayList<Prof> entries = new ArrayList(256);
/*     */       
/*     */       private LinkedHashMap<Class<?>, Prof> map;
/*     */       
/*     */       private long ss;
/*     */       
/*     */       private int tab;
/*     */       
/*     */       private boolean cpu;
/*     */       
/*     */       private boolean mem;
/*     */       
/*     */       private boolean keepnops;
/*     */       
/*     */       private boolean outliners;
/*     */       private LinkedHashMap<Class<?>, Out> omap;
/*     */       
/*     */       public void logStart(Class<?> cl) {
/*  63 */         if (this.ss == -1L) {
/*  64 */           this.ss = System.currentTimeMillis();
/*     */         }
/*  66 */         if (!this.map.containsKey(cl)) {
/*  67 */           Prof e = (Prof)this.entries.removeLast();
/*  68 */           e.acc = 0L;
/*  69 */           e.tab = this.tab;
/*  70 */           e.memAcc = 0L;
/*  71 */           this.map.put(cl, e);
/*     */         } 
/*  73 */         ((Prof)this.map.get(cl)).mem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
/*  74 */         ((Prof)this.map.get(cl)).start = System.nanoTime();
/*     */         
/*  76 */         ((Prof)this.map.get(cl)).tab = this.tab;
/*  77 */         this.tab++;
/*     */       }
/*     */ 
/*     */       
/*     */       public void logEnd(Class<?> cl) {
/*  82 */         Prof e = this.map.get(cl);
/*  83 */         long l = System.nanoTime();
/*  84 */         l -= e.start;
/*  85 */         if (l > 16000000L) {
/*  86 */           System.out.println(cl);
/*     */         }
/*     */         
/*  89 */         ((Prof)this.map.get(cl)).memAcc += Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - ((Prof)this.map.get(cl)).mem;
/*  90 */         e.acc += l;
/*  91 */         this.tab--;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void log() {
/*  97 */         if (this.ss == -1L) {
/*     */           return;
/*     */         }
/*     */         
/* 101 */         if (System.currentTimeMillis() - this.ss < 2000L) {
/*     */           return;
/*     */         }
/* 104 */         long tot = 0L;
/* 105 */         for (Map.Entry<Class<?>, Prof> k : this.map.entrySet()) {
/* 106 */           tot += ((Prof)k.getValue()).acc;
/*     */         }
/*     */         
/* 109 */         LOG.ln("CPU");
/* 110 */         for (Map.Entry<Class<?>, Prof> k : this.map.entrySet()) {
/* 111 */           this.entries.add(k.getValue());
/* 112 */           int v = (int)(1000.0D * ((Prof)k.getValue()).acc / tot);
/*     */           
/* 114 */           if (this.outliners) {
/* 115 */             if (!this.omap.containsKey(k.getKey())) {
/* 116 */               this.omap.put(k.getKey(), new Out());
/* 117 */               ((Out)this.omap.get(k.getKey())).old = v;
/*     */             } else {
/* 119 */               Out o = this.omap.get(k.getKey());
/* 120 */               o.nn = v;
/*     */             } 
/*     */           }
/* 123 */           if (this.cpu && (
/* 124 */             this.keepnops || v > 0))
/* 125 */             LOG.ln(LOG.WS(((Prof)k.getValue()).tab * 2) + " " + LOG.WS(((Prof)k.getValue()).tab * 2) + " " + v + " " + String.valueOf(k.getKey())); 
/*     */         } 
/* 127 */         if (this.mem) {
/* 128 */           LOG.ln();
/* 129 */           LOG.ln("MEM");
/* 130 */           for (Map.Entry<Class<?>, Prof> k : this.map.entrySet()) {
/* 131 */             if (((Prof)k.getValue()).memAcc > 0L) {
/* 132 */               LOG.ln(LOG.WS(((Prof)k.getValue()).tab * 2) + " " + LOG.WS(((Prof)k.getValue()).tab * 2) + " " + ((Prof)k.getValue()).memAcc);
/*     */             }
/*     */           } 
/*     */         } 
/* 136 */         if (this.outliners) {
/* 137 */           LOG.ln();
/* 138 */           LOG.ln("CHANGE");
/* 139 */           for (Map.Entry<Class<?>, Out> k : this.omap.entrySet()) {
/*     */             
/* 141 */             double v = ((Out)k.getValue()).nn / ((Out)k.getValue()).old;
/*     */             
/* 143 */             if (v > 1.5D) {
/* 144 */               LOG.ln("" + ((Out)k.getValue()).nn + " <- " + ((Out)k.getValue()).nn + " " + ((Out)k.getValue()).old);
/*     */             }
/*     */             
/* 147 */             ((Out)k.getValue()).old = ((Out)k.getValue()).nn;
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 153 */         this.map.clear();
/* 154 */         this.tab = 0;
/* 155 */         this.ss = -1L;
/* 156 */         LOG.ln();
/*     */       }
/*     */       
/*     */       class Prof
/*     */       {
/*     */         public long start;
/*     */         public int tab;
/*     */         public long acc;
/*     */         public long mem;
/*     */         public long memAcc;
/*     */       }
/*     */       
/*     */       class Out
/*     */       {
/* 170 */         public double old = 0.0D;
/* 171 */         public double nn = 0.0D;
/*     */       }
/*     */     };
/*     */   
/*     */   void log();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\debug\Profiler.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */