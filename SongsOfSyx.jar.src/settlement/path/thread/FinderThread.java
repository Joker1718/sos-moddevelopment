/*     */ package settlement.path.thread;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SCOMPONENTS;
/*     */ import settlement.path.path.SPath;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathGame;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ 
/*     */ public final class FinderThread
/*     */ {
/*  14 */   private final ArrayList<ThreadPathJob> queueJob = new ArrayList(1024);
/*  15 */   private final ArrayList<ThreadPath> queueJobPath = new ArrayList(1024);
/*     */   
/*     */   private volatile boolean lock;
/*     */   private volatile boolean stopForUp = false;
/*  19 */   private static final Worker[] works = new Worker[1];
/*  20 */   private final Thread[] threads = new Thread[works.length];
/*     */   public FinderThread(SCOMPONENTS comps) {
/*     */     byte b;
/*     */     int j;
/*     */     Worker[] arrayOfWorker;
/*  25 */     for (j = (arrayOfWorker = works).length, b = 0; b < j; ) { Worker w = arrayOfWorker[b];
/*  26 */       if (w != null) {
/*  27 */         w.working = false;
/*     */       }
/*     */       b++; }
/*     */     
/*  31 */     for (int i = 0; i < this.threads.length; i++) {
/*     */       
/*  33 */       works[i] = new Worker(this, comps);
/*  34 */       Thread t = new Thread(works[i]);
/*  35 */       t.setDaemon(true);
/*  36 */       t.setName("Path offloade #" + i);
/*  37 */       this.threads[i] = t;
/*  38 */       t.start();
/*     */     } 
/*  40 */     this.lock = false;
/*     */   } private synchronized void lock() {
/*     */     do {
/*     */     
/*  44 */     } while (this.lock);
/*     */     
/*  46 */     this.lock = true;
/*     */   }
/*     */   
/*     */   public void setStop() {
/*  50 */     this.stopForUp = true;
/*     */   }
/*     */   
/*     */   public void stop() {
/*  54 */     this.stopForUp = true; do {
/*     */     
/*  56 */     } while (!allAreStopped());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean allAreStopped() {
/*  63 */     for (int i = 0; i < this.threads.length; i++) {
/*  64 */       if (!this.threads[i].isAlive())
/*  65 */         throw new RuntimeException("dead!"); 
/*  66 */       if (!(works[i]).stopped)
/*  67 */         return false; 
/*     */     } 
/*  69 */     return true;
/*     */   }
/*     */   
/*     */   public void start() {
/*  73 */     this.stopForUp = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void prep(SPath p, int sx, int sy, int dx, int dy, boolean full) {
/*  78 */     prep(p, resume, sx, sy, dx, dy, full);
/*     */   }
/*     */   
/*     */   public void prep(SPath p, ThreadPathJob job, int sx, int sy, int dx, int dy, boolean full) {
/*  82 */     ThreadPath t = p.thread;
/*  83 */     if (t.status == 1)
/*     */       return; 
/*  85 */     t.status = 1;
/*  86 */     t.sx = (short)sx;
/*  87 */     t.sy = (short)sy;
/*  88 */     t.dx = (short)dx;
/*  89 */     t.dy = (short)dy;
/*  90 */     t.full = full;
/*  91 */     lock();
/*  92 */     if (this.queueJob.hasRoom()) {
/*  93 */       this.queueJob.add(job);
/*  94 */       this.queueJobPath.add(t);
/*     */     } else {
/*  96 */       t.status = 0;
/*  97 */     }  this.lock = false;
/*     */   }
/*     */   
/*     */   private static class Worker
/*     */     implements Runnable {
/*     */     private final PathUtilOnline pather;
/*     */     private final SPathFinderThread fin;
/*     */     private volatile boolean working = true;
/*     */     private volatile boolean stopped;
/*     */     private FinderThread tt;
/*     */     
/*     */     Worker(FinderThread tt, SCOMPONENTS comps) {
/* 109 */       this.tt = tt;
/* 110 */       this.pather = new PathUtilOnline(SETT.TWIDTH);
/* 111 */       this.fin = new SPathFinderThread(comps, this.pather, 13);
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/* 116 */       while (this.working) {
/* 117 */         if (this.tt.stopForUp) {
/* 118 */           this.stopped = true;
/* 119 */           if (!this.working)
/*     */             break; 
/* 121 */           while (this.tt.stopForUp && 
/* 122 */             this.working)
/*     */           {
/* 124 */             sleep();
/*     */           }
/*     */           
/*     */           continue;
/*     */         } 
/* 129 */         this.stopped = false;
/* 130 */         this.tt.lock();
/* 131 */         if (this.tt.queueJob.isEmpty()) {
/* 132 */           this.tt.lock = false;
/* 133 */           this.tt.stopForUp = true;
/* 134 */           this.stopped = true;
/* 135 */           Thread.yield();
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 140 */         FinderThread.ThreadPath t = (FinderThread.ThreadPath)this.tt.queueJobPath.removeLast();
/* 141 */         FinderThread.ThreadPathJob j = (FinderThread.ThreadPathJob)this.tt.queueJob.removeLast();
/* 142 */         this.tt.lock = false;
/* 143 */         if (j.doJob(this.pather, this.fin, t)) {
/* 144 */           t.status = 3; continue;
/*     */         } 
/* 146 */         t.status = 2;
/*     */       } 
/* 148 */       LOG.ln("Pathworker is dead");
/*     */     }
/*     */     
/*     */     private void sleep() {
/*     */       try {
/* 153 */         Thread.sleep(1L);
/* 154 */       } catch (InterruptedException interruptedException) {}
/*     */     }
/*     */   }
/*     */   
/*     */   static interface ThreadPathJob {
/*     */     boolean doJob(PathUtilOnline param1PathUtilOnline, SPathFinderThread param1SPathFinderThread, FinderThread.ThreadPath param1ThreadPath);
/*     */   }
/*     */   
/*     */   public static class ThreadPath {
/*     */     private volatile byte status;
/* 164 */     public final PathGame.PathFancy path = new PathGame.PathFancy(256); short sx; short sy;
/*     */     short dx;
/*     */     short dy;
/*     */     boolean full;
/*     */     public volatile short destX;
/*     */     public volatile short destY;
/*     */     
/*     */     public boolean isProcessed(int sx, int sy, int dx, int dy) {
/* 172 */       if (this.sx == sx && this.sy == sy && this.dx == dx && this.dy == dy)
/* 173 */         return (this.status > 1); 
/* 174 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isBeingProcessed() {
/* 178 */       return (this.status >= 1);
/*     */     }
/*     */     
/*     */     public boolean isSuccess() {
/* 182 */       return (this.status == 3);
/*     */     }
/*     */     
/*     */     public void debug(int sx, int sy, int dx, int dy) {
/* 186 */       if (this.status > 1) {
/* 187 */         LOG.ln("" + this.status + " " + this.status + " " + this.sx - sx + " " + this.sy - sy + " " + this.dx - dx);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 198 */   private static final ThreadPathJob resume = new ThreadPathJob()
/*     */     {
/*     */       public boolean doJob(PathUtilOnline p, SPathFinderThread fin, FinderThread.ThreadPath t)
/*     */       {
/* 202 */         PathTile tile = fin.find(t.sx, t.sy, t.dx, t.dy, t.full);
/*     */         
/* 204 */         if (tile != null) {
/* 205 */           t.destX = (short)tile.x();
/* 206 */           t.destY = (short)tile.y();
/* 207 */           t.path.set(tile);
/* 208 */           return true;
/*     */         } 
/* 210 */         return false;
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\thread\FinderThread.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */