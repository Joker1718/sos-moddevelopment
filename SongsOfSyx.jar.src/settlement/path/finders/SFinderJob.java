/*     */ package settlement.path.finders;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.job.Job;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.FindableDataSingle;
/*     */ import settlement.path.components.FindableDatas;
/*     */ import settlement.path.components.SCompNLevel;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.SComponentLevel;
/*     */ import settlement.path.components.finder.SCompFinder;
/*     */ import settlement.path.path.SPath;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ 
/*     */ 
/*     */ public final class SFinderJob
/*     */ {
/*  22 */   public static int DIST_SMALL = 128;
/*  23 */   private final SFinderUpdater updater = new SFinderUpdater();
/*     */ 
/*     */   
/*     */   final RBIT.RBITImp resMask;
/*     */ 
/*     */   
/*     */   final RBIT.RBITImp jobMask;
/*     */ 
/*     */   
/*     */   private Job result;
/*     */ 
/*     */   
/*     */   private final SCompFinder.SCompPatherExister exister;
/*     */ 
/*     */   
/*     */   private SFINDER fin;
/*     */ 
/*     */ 
/*     */   
/*     */   private FindableDatas d() {
/*  43 */     return (SETT.PATH()).comps.data;
/*     */   }
/*     */   SFinderJob() {
/*  46 */     this.resMask = new RBIT.RBITImp();
/*  47 */     this.jobMask = new RBIT.RBITImp();
/*     */ 
/*     */     
/*  50 */     this.exister = new SCompFinder.SCompPatherExister()
/*     */       {
/*     */ 
/*     */         
/*     */         public boolean isInComponent(SComponent c, double distance)
/*     */         {
/*  56 */           if ((SFinderJob.this.d()).job.get(c) > 0)
/*  57 */             return true; 
/*  58 */           if ((SETT.WEATHER()).growthRipe.cropsAreRipe() && (SFinderJob.this.d()).jobHarvest.get(c) > 0)
/*  59 */             return true; 
/*  60 */           SFinderJob.this.jobMask.or((SFinderJob.this.d()).jobs.bits(c));
/*  61 */           SFinderJob.this.resMask.or((SFinderJob.this.d()).resScattered.bits(c));
/*  62 */           SFinderJob.this.resMask.or((SFinderJob.this.d()).resCrate.bits(c));
/*  63 */           SFinderJob.this.resMask.or((SFinderJob.this.d()).resPriority.bits(c));
/*     */           
/*  65 */           return SFinderJob.this.jobMask.has((RBIT)SFinderJob.this.resMask);
/*     */         }
/*     */ 
/*     */         
/*     */         public void init(SComponentLevel l) {
/*  70 */           SFinderJob.this.resMask.clear();
/*  71 */           SFinderJob.this.jobMask.clear();
/*     */         }
/*     */       };
/*     */     
/*  75 */     this.fin = new SFINDER()
/*     */       {
/*     */         public boolean isInComponent(SComponent c, double distance)
/*     */         {
/*  79 */           if ((SFinderJob.this.d()).job.get(c) > 0)
/*  80 */             return true; 
/*  81 */           if (SFinderJob.this.resMask.has((SFinderJob.this.d()).jobs.bits(c)))
/*  82 */             return true; 
/*  83 */           if ((SETT.WEATHER()).growthRipe.cropsAreRipe() && (SFinderJob.this.d()).jobHarvest.get(c) > 0)
/*  84 */             return true; 
/*  85 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isTile(int tx, int ty, int tileNr) {
/*  90 */           SFinderJob.this.result = (Job)(SETT.JOBS()).getter.get(tx, ty);
/*     */           
/*  92 */           if (SFinderJob.this.result == null)
/*  93 */             return false; 
/*  94 */           if (!SFinderJob.this.result.jobReserveCanBe())
/*  95 */             return false; 
/*  96 */           if (SFinderJob.this.result.needsRipe() && !(SETT.WEATHER()).growthRipe.cropsAreRipe())
/*  97 */             return false; 
/*  98 */           if (SFinderJob.this.result.resourceCurrentlyNeeded() == null)
/*  99 */             return true; 
/* 100 */           if ((SFinderJob.this.result.resourceCurrentlyNeeded()).bit.has((RBIT)SFinderJob.this.resMask)) {
/* 101 */             return true;
/*     */           }
/* 103 */           return false;
/*     */         }
/*     */       };
/*     */   }
/*     */   void update(double ds) {
/* 108 */     this.updater.update(ds);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasJobs(int tx, int ty, boolean full) {
/* 113 */     if (full) {
/* 114 */       if (!this.updater.tryDistance(tx, ty)) {
/* 115 */         return false;
/*     */       }
/* 117 */     } else if (!this.updater.tryShort(tx, ty)) {
/* 118 */       return false;
/*     */     } 
/*     */     
/* 121 */     return hasAnyJobs(tx, ty);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasAnyJobs(int tx, int ty) {
/* 127 */     SComponent c = (SComponent)(SETT.PATH()).comps.superComp.get(tx, ty);
/* 128 */     if (c == null) {
/* 129 */       return false;
/*     */     }
/* 131 */     if ((d()).job.has(c))
/* 132 */       return true; 
/* 133 */     if ((d()).jobHarvest.has(c) && (SETT.WEATHER()).growthRipe.cropsAreRipe())
/* 134 */       return true; 
/* 135 */     this.resMask.clearSet((d()).resScattered.bits(c)).or((d()).resCrate.bits(c)).or((d()).resPriority.bits(c));
/* 136 */     return (d()).jobs.has(c, (RBIT)this.resMask);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Job findOnlyJobForced(int sx, int sy, int dist) {
/* 144 */     if (!hasAnyJobs(sx, sy)) {
/* 145 */       return null;
/*     */     }
/* 147 */     if (dist == Integer.MAX_VALUE) {
/* 148 */       this.resMask.clearSet((d()).resScattered.bits(sx, sy)).or((d()).resCrate.bits(sx, sy)).or((d()).resPriority.bits(sx, sy));
/* 149 */       COORDINATE c = (SETT.PATH()).finders.finder().findDest(sx, sy, this.fin, dist);
/* 150 */       if (c != null) {
/* 151 */         return this.result;
/*     */       }
/* 153 */     } else if ((SETT.PATH()).comps.pather.exists(sx, sy, this.exister, dist)) {
/* 154 */       COORDINATE c = (SETT.PATH()).finders.finder().findDest(sx, sy, this.fin, 2147483647);
/* 155 */       if (c != null) {
/* 156 */         return this.result;
/*     */       }
/*     */     } 
/*     */     
/* 160 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Job findOnlyJob(int sx, int sy, boolean full) {
/* 166 */     if (!hasJobs(sx, sy, full)) {
/* 167 */       return null;
/*     */     }
/* 169 */     int dist = DIST_SMALL;
/* 170 */     if (full) {
/* 171 */       dist = this.updater.distance(sx, sy);
/*     */     }
/* 173 */     if (dist == Integer.MAX_VALUE) {
/* 174 */       this.resMask.clearSet((d()).resScattered.bits(sx, sy)).or((d()).resCrate.bits(sx, sy)).or((d()).resPriority.bits(sx, sy));
/* 175 */       COORDINATE c = (SETT.PATH()).finders.finder().findDest(sx, sy, this.fin, dist);
/* 176 */       if (c != null) {
/* 177 */         return this.result;
/*     */       }
/* 179 */     } else if ((SETT.PATH()).comps.pather.exists(sx, sy, this.exister, dist)) {
/* 180 */       COORDINATE c = (SETT.PATH()).finders.finder().findDest(sx, sy, this.fin, 2147483647);
/* 181 */       if (c != null) {
/* 182 */         return this.result;
/*     */       }
/*     */     } 
/*     */     
/* 186 */     if (full) {
/* 187 */       this.updater.distanceFail(sx, sy);
/*     */     } else {
/* 189 */       this.updater.failShort(sx, sy);
/*     */     } 
/*     */     
/* 192 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Job find(int sx, int sy, SPath path, boolean full) {
/* 206 */     Job j = findOnlyJob(sx, sy, full);
/*     */     
/* 208 */     if (j != null) {
/* 209 */       if (j.resourceCurrentlyNeeded() == null && path != null) {
/* 210 */         int jx = j.jobCoo().x();
/* 211 */         int jy = j.jobCoo().y();
/* 212 */         if (path.request(sx, sy, jx, jy, false))
/* 213 */           return (Job)(SETT.JOBS()).getter.get(jx, jy); 
/* 214 */         return null;
/*     */       } 
/* 216 */       return j;
/*     */     } 
/* 218 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void report(Job job, int delta) {
/* 223 */     RESOURCE r = job.resourceCurrentlyNeeded();
/*     */ 
/*     */     
/* 226 */     if (r != null) {
/* 227 */       if (delta == 1) {
/* 228 */         (d()).jobs.reportPresence(job.jobCoo().x(), job.jobCoo().y(), r);
/*     */       }
/* 230 */       else if (delta == -1) {
/* 231 */         (d()).jobs.reportAbsence(job.jobCoo().x(), job.jobCoo().y(), r);
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/* 236 */     FindableDataSingle s = (d()).job;
/* 237 */     if (job.needsRipe()) {
/* 238 */       s = (d()).jobHarvest;
/*     */     }
/* 240 */     if (delta == 1) {
/* 241 */       s.reportPresence(job.jobCoo().x(), job.jobCoo().y());
/* 242 */     } else if (delta == -1) {
/* 243 */       s.reportAbsence(job.jobCoo().x(), job.jobCoo().y());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static final class SFinderUpdater
/*     */   {
/* 250 */     private final Bitmap1D tryShort = new Bitmap1D(32767, false);
/* 251 */     private final Bitmap1D distanceFailed = new Bitmap1D(32767, false);
/* 252 */     private final Bitsmap1D distance = new Bitsmap1D(0, 2, 32767);
/* 253 */     private final Bitsmap1D distanceTimeout = new Bitsmap1D(0, 2, 32767);
/*     */     
/* 255 */     private final double speed = 0.03125D;
/* 256 */     double ci = 0.0D;
/* 257 */     int roundabout = 0;
/*     */     
/* 259 */     private final int[] dists = new int[] {
/* 260 */         150, 
/* 261 */         400, 
/* 262 */         1000, Integer
/* 263 */         .MAX_VALUE
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void update(double ds) {
/* 271 */       int old = (int)this.ci;
/* 272 */       this.ci += ds * ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).componentsMax() * 0.03125D;
/* 273 */       int now = (int)this.ci;
/* 274 */       int delt = old - now;
/*     */       
/* 276 */       if (this.ci >= ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).componentsMax()) {
/* 277 */         this.roundabout++;
/* 278 */         this.ci -= ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).componentsMax();
/*     */       } 
/*     */       
/* 281 */       for (int k = 0; k <= delt; k++) {
/* 282 */         int i = k + old;
/* 283 */         i %= ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).componentsMax();
/* 284 */         this.tryShort.set(i, false);
/*     */         
/* 286 */         if (this.distanceFailed.get(i)) {
/*     */           
/* 288 */           this.distanceFailed.set(i, false);
/* 289 */           this.distance.inc(i, 1);
/* 290 */           this.distanceTimeout.set(i, this.roundabout - 1 & 0x3);
/* 291 */         } else if ((this.roundabout & 0x3) == this.distanceTimeout.get(i)) {
/* 292 */           this.distance.set(i, 0);
/* 293 */           this.distanceTimeout.set(i, 0);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean tryShort(int tx, int ty) {
/* 300 */       SComponent c = ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(tx, ty);
/* 301 */       if (c == null)
/* 302 */         return false; 
/* 303 */       if (this.tryShort.get(c.index()))
/* 304 */         return false; 
/* 305 */       return true;
/*     */     }
/*     */     
/*     */     public void failShort(int tx, int ty) {
/* 309 */       SComponent c = ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(tx, ty);
/* 310 */       if (c == null)
/*     */         return; 
/* 312 */       this.tryShort.set(c.index(), true);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean tryDistance(int tx, int ty) {
/* 317 */       if (STATS.WORK().workforce() - (STATS.WORK()).EMPLOYED.stat().data().get(null) < 80) {
/* 318 */         return true;
/*     */       }
/* 320 */       SComponent c = ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(tx, ty);
/* 321 */       if (c == null)
/* 322 */         return false; 
/* 323 */       return !(this.distanceFailed.get(c.index()) && this.distance.get(c.index()) == this.distance.maxValue());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int distance(int tx, int ty) {
/* 329 */       if (STATS.WORK().workforce() - (STATS.WORK()).EMPLOYED.stat().data().get(null) < 80) {
/* 330 */         return Integer.MAX_VALUE;
/*     */       }
/* 332 */       SComponent c = ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(tx, ty);
/* 333 */       return this.dists[this.distance.get(c.index())];
/*     */     }
/*     */     
/*     */     public void distanceFail(int tx, int ty) {
/* 337 */       SComponent c = ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(tx, ty);
/* 338 */       this.distanceFailed.set(c.index(), true);
/* 339 */       failShort(tx, ty);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderJob.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */