/*     */ package snake2d;
/*     */ 
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Updater
/*     */   extends Thread
/*     */ {
/*     */   private static final long nanoMax = 31250000L;
/*     */   private static final long nanoMin = 976562L;
/*     */   private float secondsRender;
/*     */   private long maxAmount;
/*     */   private long minAmount;
/*     */   private long nanoAccumilator;
/*     */   private long nowTemp;
/*     */   private long lastUpdate;
/*     */   private long lastRender;
/*     */   private final CORE_STATE.Constructor constructor;
/*     */   private CORE_STATE current;
/*     */   private volatile boolean hasTheRightToLive = true;
/*  24 */   private final CoreTime info = new CoreTime();
/*     */   
/*  26 */   private double slowDown = 1.0D;
/*     */   
/*     */   Updater(CORE_STATE.Constructor current) {
/*  29 */     this.constructor = current;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*  36 */     Thread.currentThread().setName("updater");
/*     */ 
/*     */     
/*  39 */     this.current = this.constructor.getState();
/*     */     
/*  41 */     this.constructor.doAfterSet();
/*  42 */     System.gc();
/*     */ 
/*     */     
/*  45 */     this.nanoAccumilator = 0L;
/*  46 */     this.lastUpdate = System.nanoTime();
/*  47 */     this.lastRender = this.lastUpdate;
/*     */     
/*  49 */     while (CORE.isRunning() && this.hasTheRightToLive) {
/*     */       
/*  51 */       long now = System.nanoTime();
/*     */       
/*  53 */       if (this.hasTheRightToLive)
/*  54 */         update(); 
/*  55 */       if (this.hasTheRightToLive)
/*  56 */         CORE.getInput().poll(this.current); 
/*  57 */       if (this.hasTheRightToLive) {
/*  58 */         render();
/*     */       }
/*     */       
/*  61 */       now = System.nanoTime() - now;
/*  62 */       double d = now / 1.0E9D;
/*  63 */       double f = 0.025D;
/*     */       
/*  65 */       this.slowDown = d / f;
/*  66 */       this.slowDown = CLAMP.d(this.slowDown, 0.0D, this.slowDown);
/*     */       
/*  68 */       if (this.hasTheRightToLive) {
/*     */         
/*  70 */         CORE.swapAndPoll();
/*  71 */         CoreStats.endOfLoopCalc();
/*     */       } 
/*     */     } 
/*     */     
/*  75 */     this.current.exit();
/*     */   }
/*     */ 
/*     */   
/*     */   private void render() {
/*  80 */     this.nowTemp = System.nanoTime();
/*  81 */     this.secondsRender = (float)(this.nowTemp - this.lastRender) / 1.0E9F;
/*  82 */     this.lastRender = this.nowTemp;
/*  83 */     this.current.render(CORE.renderer(), this.secondsRender);
/*  84 */     CoreStats.renderPercentage.set(System.nanoTime() - this.nowTemp);
/*     */   }
/*     */ 
/*     */   
/*     */   private void update() {
/*  89 */     this.nanoAccumilator += System.nanoTime() - this.lastUpdate;
/*  90 */     this.lastUpdate = System.nanoTime();
/*  91 */     this.maxAmount = this.nanoAccumilator / 31250000L;
/*  92 */     if (this.maxAmount > 0L) {
/*  93 */       this.nanoAccumilator = 0L;
/*     */     } else {
/*  95 */       this.minAmount = this.nanoAccumilator / 976562L;
/*  96 */       this.nanoAccumilator -= this.minAmount * 976562L;
/*     */     } 
/*     */     
/*  99 */     this.nowTemp = System.nanoTime();
/* 100 */     float total = 0.03125F * (float)this.maxAmount + 9.765625E-4F * (float)this.minAmount;
/* 101 */     this.info.update(total, this.nowTemp / 1000000L, this.nowTemp);
/*     */     
/* 103 */     this.nowTemp = System.nanoTime();
/* 104 */     if (this.maxAmount > 0L) {
/* 105 */       this.maxAmount--;
/* 106 */       this.current.update(0.03125F, this.slowDown);
/*     */     } else {
/* 108 */       this.current.update(9.765625E-4F * (float)this.minAmount, this.slowDown);
/*     */     } 
/* 110 */     CoreStats.droppedTicks.set(this.maxAmount);
/* 111 */     CoreStats.smallUpdates.set(this.minAmount);
/*     */     
/* 113 */     CoreStats.updatePercentage.set(System.nanoTime() - this.nowTemp);
/*     */   }
/*     */ 
/*     */   
/*     */   void dieHard() {
/* 118 */     this.hasTheRightToLive = false;
/*     */   }
/*     */   
/*     */   CoreTime getCoreInfo() {
/* 122 */     return this.info;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\Updater.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */