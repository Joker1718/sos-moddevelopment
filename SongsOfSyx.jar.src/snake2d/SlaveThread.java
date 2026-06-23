/*     */ package snake2d;
/*     */ 
/*     */ import snake2d.util.misc.ACTION;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SlaveThread
/*     */   extends CORE_RESOURCE
/*     */ {
/*     */   private final Thread thread;
/*     */   private final long time;
/*     */   public final double ds;
/*     */   private volatile ACTION job;
/*     */   private volatile boolean working = false;
/*     */   private volatile boolean shouldWork = false;
/*     */   private volatile boolean shouldDie = false;
/*     */   private volatile boolean doOnce = false;
/*     */   public final String name;
/*     */   private volatile long sleepTime;
/*  20 */   private volatile double utilization = 0.0D;
/*  21 */   private long sleepDigTimer = System.currentTimeMillis();
/*  22 */   private volatile long lastResponseTime = 0L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private volatile boolean hasWarnedOfSlowResponse = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Runnable runner;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean working() {
/*  48 */     return (this.shouldWork && !this.shouldDie);
/*     */   }
/*     */   
/*     */   public void start(ACTION job) {
/*  52 */     if (this.shouldWork)
/*  53 */       throw new RuntimeException(String.valueOf(this.thread.getName()) + " is already started"); 
/*  54 */     this.job = job;
/*  55 */     if (this.shouldDie)
/*  56 */       throw new RuntimeException("thread is dead"); 
/*  57 */     this.lastResponseTime = System.currentTimeMillis();
/*  58 */     this.shouldWork = true;
/*     */   }
/*     */   
/*     */   public void doOnce(ACTION job) {
/*  62 */     if (this.shouldWork || this.doOnce)
/*  63 */       throw new RuntimeException("already started"); 
/*  64 */     this.job = job;
/*  65 */     this.lastResponseTime = System.currentTimeMillis();
/*  66 */     this.doOnce = true;
/*     */   }
/*     */   
/*     */   public void setStopFlag() {
/*  70 */     this.shouldWork = false;
/*  71 */     this.lastResponseTime = System.currentTimeMillis();
/*     */   }
/*     */   
/*     */   public void waitUntilStopped() {
/*  75 */     if (Thread.currentThread() == this.thread) {
/*  76 */       throw new RuntimeException("can't stop yourself");
/*     */     }
/*  78 */     this.shouldWork = false;
/*  79 */     while (this.working || this.doOnce) {
/*  80 */       checkForUnresponsiveness();
/*  81 */       sleep(1L);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void kill() {
/*  86 */     this.shouldDie = true;
/*  87 */     if (this.thread != Thread.currentThread()) {
/*  88 */       this.thread.interrupt();
/*  89 */       long now = System.currentTimeMillis();
/*  90 */       while (this.thread.isAlive()) {
/*  91 */         if (System.currentTimeMillis() - now > 10000L) {
/*  92 */           Printer.err(String.valueOf(this.thread.getName()) + " refuses to die");
/*  93 */           StackTraceElement[] ee = this.thread.getStackTrace(); byte b; int i; StackTraceElement[] arrayOfStackTraceElement1;
/*  94 */           for (i = (arrayOfStackTraceElement1 = ee).length, b = 0; b < i; ) { StackTraceElement e = arrayOfStackTraceElement1[b];
/*  95 */             System.err.println(e); b++; }
/*     */            return;
/*     */         } 
/*  98 */         sleep(0L);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isDead() {
/* 104 */     return this.thread.isAlive();
/*     */   }
/*     */   
/*     */   public double getUtilization() {
/* 108 */     return this.utilization;
/*     */   }
/*     */   
/*     */   private void sleep(long milis) {
/* 112 */     if (milis < 0L)
/* 113 */       milis = 0L; 
/*     */     try {
/* 115 */       Thread.sleep(milis);
/* 116 */     } catch (InterruptedException interruptedException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkForUnresponsiveness() {
/* 122 */     if (this.shouldDie && !this.thread.isAlive())
/*     */       return; 
/* 124 */     long now = System.currentTimeMillis();
/* 125 */     long tmp = now - this.lastResponseTime;
/* 126 */     if (tmp > this.time * 1000L) {
/* 127 */       if (this.hasWarnedOfSlowResponse) {
/* 128 */         throw new RuntimeException(String.valueOf(this.thread.getName()) + " is stuck and will now die!");
/*     */       }
/* 130 */       Printer.err(String.valueOf(this.thread.getName()) + " is stuck!");
/* 131 */       StackTraceElement[] ee = this.thread.getStackTrace(); byte b; int i; StackTraceElement[] arrayOfStackTraceElement1;
/* 132 */       for (i = (arrayOfStackTraceElement1 = ee).length, b = 0; b < i; ) { StackTraceElement e = arrayOfStackTraceElement1[b];
/* 133 */         System.err.println(e); b++; }
/* 134 */        this.lastResponseTime = now;
/* 135 */       this.hasWarnedOfSlowResponse = true;
/* 136 */       this.thread.interrupt();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void dis() {
/* 144 */     kill();
/*     */   }
/*     */   public SlaveThread(String name, double interval) {
/* 147 */     this.runner = new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 151 */           while (!SlaveThread.this.shouldDie) {
/* 152 */             SlaveThread.this.lastResponseTime = System.currentTimeMillis();
/* 153 */             SlaveThread.this.hasWarnedOfSlowResponse = false;
/* 154 */             if (SlaveThread.this.doOnce) {
/* 155 */               SlaveThread.this.job.exe();
/* 156 */               SlaveThread.this.job = null;
/* 157 */               SlaveThread.this.doOnce = false;
/* 158 */               SlaveThread.this.shouldWork = false;
/*     */             } 
/*     */             
/* 161 */             if (SlaveThread.this.shouldWork) {
/* 162 */               SlaveThread.this.working = true;
/* 163 */               long now = System.currentTimeMillis();
/* 164 */               SlaveThread.this.job.exe();
/*     */ 
/*     */               
/* 167 */               long workTime = now;
/* 168 */               now = System.currentTimeMillis();
/* 169 */               workTime = now - workTime;
/*     */               
/* 171 */               if (workTime > SlaveThread.this.time) {
/*     */                 continue;
/*     */               }
/*     */               
/* 175 */               if (System.currentTimeMillis() - SlaveThread.this.sleepDigTimer > 1000L) {
/* 176 */                 long d = now - SlaveThread.this.sleepDigTimer;
/* 177 */                 SlaveThread.this.utilization = (d <= 0L) ? 0.0D : (100.0D * (1.0D - SlaveThread.this.sleepTime / d));
/* 178 */                 SlaveThread.this.sleepTime = 0L;
/* 179 */                 SlaveThread.this.sleepDigTimer = now;
/*     */               } 
/* 181 */               long st = SlaveThread.this.time - workTime;
/* 182 */               SlaveThread.this.sleepTime = SlaveThread.this.sleepTime + st;
/* 183 */               SlaveThread.this.working = false;
/* 184 */               SlaveThread.this.sleep(st - 1L); continue;
/*     */             } 
/* 186 */             SlaveThread.this.working = false;
/* 187 */             SlaveThread.this.sleep(1L);
/*     */           } 
/*     */           
/* 190 */           Printer.ln(String.valueOf(SlaveThread.this.thread.getName()) + " is dead.");
/*     */         }
/*     */       };
/*     */     this.ds = interval;
/*     */     this.name = name;
/*     */     this.thread = new Thread(this.runner, name);
/*     */     this.thread.setDaemon(true);
/*     */     this.time = (long)(1000.0D * interval);
/*     */     this.thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
/*     */           public void uncaughtException(Thread t, Throwable e) {
/*     */             SlaveThread.this.working = false;
/*     */             SlaveThread.this.shouldWork = false;
/*     */             SlaveThread.this.shouldDie = true;
/*     */             e.printStackTrace();
/*     */             CORE.annihilate(e);
/*     */           }
/*     */         });
/*     */     CORE.addDisposable(this);
/*     */     this.thread.start();
/*     */     this.lastResponseTime = System.currentTimeMillis();
/*     */     this.hasWarnedOfSlowResponse = false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\SlaveThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */