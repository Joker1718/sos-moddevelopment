/*     */ package snake2d;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CoreStats
/*     */ {
/*   7 */   private static int cycleCount = 0;
/*   8 */   private static long timer = System.nanoTime();
/*     */   
/*     */   private static final double referenceValue = 1.6666666E7D;
/*     */   
/*  12 */   public static final Value FPS = new Value("FPS", null);
/*  13 */   public static final Value coreTotal = new Value("Core", null);
/*  14 */   public static final Value corePoll = new Value("Poll", null);
/*  15 */   public static final Value coreFinish = new Value("Finish", null);
/*  16 */   public static final Value coreFlush = new Value("Flush", null);
/*  17 */   public static final Value coreSleep = new Value("Sleep", null);
/*  18 */   public static final Value coreSound = new Value("Sound", null);
/*  19 */   public static final Value smallUpdates = new Value("SmallUp", null);
/*  20 */   public static final Value updatePercentage = new Value("UpPer", null);
/*  21 */   public static final Value renderPercentage = new Value("Render", null);
/*  22 */   public static final Value updateThreadPercentage = new Value("Update Total", null);
/*     */   
/*  24 */   public static final Value swapPercentage = new Value("Swap", null);
/*     */   
/*  26 */   public static final Value totalPercentage = new Value("Tot", null);
/*  27 */   public static final Value droppedTicks = new Value("TicksDropped", null);
/*  28 */   public static final Value heap = new Value("heap size", null);
/*  29 */   public static final Value usedHeap = new Value("used heap", null);
/*  30 */   public static final Value heapGrowth = new Value("heap growth", null);
/*     */   
/*  32 */   private static long oldMemory = 0L;
/*     */   private static long dMemory;
/*  34 */   private static int memoryCount = 0;
/*     */   
/*     */   public static void print2StdOut() {
/*  37 */     Printer.ln("--INFO--");
/*  38 */     Printer.ln(smallUpdates);
/*  39 */     Printer.ln(updatePercentage);
/*  40 */     Printer.ln(smallUpdates);
/*  41 */     Printer.ln(updatePercentage);
/*  42 */     Printer.ln(corePoll);
/*  43 */     Printer.ln(totalPercentage);
/*  44 */     Printer.fin();
/*     */   }
/*     */ 
/*     */   
/*     */   static void endOfLoopCalc() {
/*  49 */     cycleCount++;
/*     */     
/*  51 */     if (System.nanoTime() - timer >= 1000000000L) {
/*  52 */       smallUpdates.calc();
/*  53 */       droppedTicks.calc();
/*  54 */       updatePercentage.calc();
/*  55 */       renderPercentage.calc();
/*  56 */       swapPercentage.calc();
/*  57 */       coreTotal.calc();
/*  58 */       corePoll.calc();
/*  59 */       coreFinish.calc();
/*  60 */       coreFlush.calc();
/*  61 */       coreSleep.calc();
/*  62 */       coreSound.calc();
/*  63 */       totalPercentage.setD(updatePercentage.ave + renderPercentage.ave);
/*  64 */       totalPercentage.calc();
/*  65 */       FPS.setD(cycleCount);
/*  66 */       FPS.calc();
/*  67 */       Runtime r = Runtime.getRuntime();
/*  68 */       long kb = 1024L;
/*  69 */       long newMemory = (r.totalMemory() - r.freeMemory()) / kb;
/*  70 */       dMemory += newMemory - oldMemory;
/*  71 */       oldMemory = newMemory;
/*  72 */       heap.setD((r.totalMemory() / kb));
/*  73 */       heap.calc();
/*  74 */       usedHeap.setD(oldMemory);
/*  75 */       usedHeap.calc();
/*  76 */       memoryCount++;
/*  77 */       if (memoryCount == 5) {
/*  78 */         memoryCount = 0;
/*  79 */         heapGrowth.setD((dMemory / 5L));
/*  80 */         heapGrowth.calc();
/*  81 */         dMemory = 0L;
/*     */       } 
/*     */       
/*  84 */       cycleCount = 0;
/*  85 */       timer += 1000000000L;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class Value
/*     */   {
/*  91 */     volatile double current = 0.0D;
/*  92 */     public volatile double min = 1000.0D;
/*  93 */     public volatile double max = -1.0D;
/*  94 */     public volatile double ave = 0.0D;
/*  95 */     private volatile double acc = 0.0D;
/*  96 */     private volatile int cCount = 0;
/*     */     private final String name;
/*     */     
/*     */     private Value(String name) {
/* 100 */       this.name = name;
/*     */     }
/*     */     
/*     */     void set(long ns) {
/* 104 */       setD(100.0D * ns / 1.6666666E7D);
/*     */     }
/*     */     
/*     */     void setD(double percentage) {
/* 108 */       this.current = percentage;
/* 109 */       if (percentage < this.min) {
/* 110 */         this.min = percentage;
/* 111 */       } else if (percentage > this.max) {
/* 112 */         this.max = percentage;
/* 113 */       }  this.acc += percentage;
/* 114 */       this.cCount++;
/*     */     }
/*     */     
/*     */     private void calc() {
/* 118 */       this.ave = this.acc / this.cCount;
/* 119 */       this.cCount = 0;
/* 120 */       this.acc = 0.0D;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 127 */       int percent = (int)this.ave;
/* 128 */       int frac = (int)((this.ave - percent) * 100.0D);
/*     */       
/* 130 */       return String.valueOf(this.name) + ": " + percent + "," + frac;
/*     */     }
/*     */     
/*     */     public String toStringLong() {
/* 134 */       return String.valueOf(this.name) + ":" + 
/* 135 */         "\n   Current: " + Double.toString(this.current) + 
/* 136 */         "\n   Min: " + Double.toString(this.min) + 
/* 137 */         "\n   Max: " + Double.toString(this.max) + 
/* 138 */         "\n   Ave: " + Double.toString(this.ave);
/*     */     }
/*     */     
/*     */     public String getLabel() {
/* 142 */       return this.name;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\CoreStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */