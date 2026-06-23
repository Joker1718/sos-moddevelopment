/*     */ package settlement.path.thread;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SCOMPONENTS;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathUtilOnline;
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
/*     */ class Worker
/*     */   implements Runnable
/*     */ {
/*     */   private final PathUtilOnline pather;
/*     */   private final SPathFinderThread fin;
/*     */   private volatile boolean working = true;
/*     */   private volatile boolean stopped;
/*     */   private FinderThread tt;
/*     */   
/*     */   Worker(FinderThread tt, SCOMPONENTS comps) {
/* 109 */     this.tt = tt;
/* 110 */     this.pather = new PathUtilOnline(SETT.TWIDTH);
/* 111 */     this.fin = new SPathFinderThread(comps, this.pather, 13);
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/* 116 */     while (this.working) {
/* 117 */       if (this.tt.stopForUp) {
/* 118 */         this.stopped = true;
/* 119 */         if (!this.working)
/*     */           break; 
/* 121 */         while (this.tt.stopForUp && 
/* 122 */           this.working)
/*     */         {
/* 124 */           sleep();
/*     */         }
/*     */         
/*     */         continue;
/*     */       } 
/* 129 */       this.stopped = false;
/* 130 */       this.tt.lock();
/* 131 */       if (this.tt.queueJob.isEmpty()) {
/* 132 */         this.tt.lock = false;
/* 133 */         this.tt.stopForUp = true;
/* 134 */         this.stopped = true;
/* 135 */         Thread.yield();
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 140 */       FinderThread.ThreadPath t = (FinderThread.ThreadPath)this.tt.queueJobPath.removeLast();
/* 141 */       FinderThread.ThreadPathJob j = (FinderThread.ThreadPathJob)this.tt.queueJob.removeLast();
/* 142 */       this.tt.lock = false;
/* 143 */       if (j.doJob(this.pather, this.fin, t)) {
/* 144 */         t.status = 3; continue;
/*     */       } 
/* 146 */       t.status = 2;
/*     */     } 
/* 148 */     LOG.ln("Pathworker is dead");
/*     */   }
/*     */   
/*     */   private void sleep() {
/*     */     try {
/* 153 */       Thread.sleep(1L);
/* 154 */     } catch (InterruptedException interruptedException) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\thread\FinderThread$Worker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */