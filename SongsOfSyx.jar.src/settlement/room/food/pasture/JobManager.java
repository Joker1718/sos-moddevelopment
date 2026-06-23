/*     */ package settlement.room.food.pasture;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.CircleCooIterator;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ 
/*     */ final class JobManager
/*     */   implements JOB_MANAGER
/*     */ {
/*     */   private PastureInstance ins;
/*  24 */   private static final JobManager i = new JobManager();
/*  25 */   private final Job job = new Job();
/*  26 */   private final JobBaby jobBaby = new JobBaby();
/*     */   static final int workTime = 20;
/*  28 */   private final Bit reserved = new Bit(2);
/*  29 */   private final Bit is = new Bit(4);
/*     */   
/*     */   static JobManager init(PastureInstance ins) {
/*  32 */     i.ins = ins;
/*  33 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SETT_JOB getReservableJob() {
/*  40 */     if (this.ins.needsWork()) {
/*  41 */       if (findAvailable()) {
/*  42 */         return this.job;
/*     */       }
/*  44 */       return null;
/*     */     } 
/*     */     
/*  47 */     if (this.ins.hasLivestockFetch() && this.ins.searchForLivestock) {
/*  48 */       if (findAvailable()) {
/*  49 */         return this.jobBaby.init(this.job.coo.x(), this.job.coo.y());
/*     */       }
/*  51 */       return null;
/*     */     } 
/*  53 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean findAvailable() {
/*  58 */     int tx = this.ins.body().x1() + 1 + RND.rInt(this.ins.body().width() - 2);
/*  59 */     int ty = this.ins.body().y1() + 1 + RND.rInt(this.ins.body().height() - 2);
/*     */     
/*  61 */     int a = this.ins.body().width() * this.ins.body().height();
/*  62 */     for (int i = 0; i < a; i++) {
/*  63 */       if (isAvailable(tx, ty)) {
/*  64 */         return true;
/*     */       }
/*  66 */       tx++;
/*  67 */       if (tx >= this.ins.body().x2()) {
/*  68 */         tx = this.ins.body().x1() + 1;
/*  69 */         ty++;
/*  70 */         if (ty >= this.ins.body().y2()) {
/*  71 */           ty = this.ins.body().y1() + 1;
/*     */         }
/*     */       } 
/*     */     } 
/*  75 */     GAME.Notify("" + tx + " " + tx);
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isAvailable(int tx, int ty) {
/*  80 */     if (!this.ins.is(tx, ty))
/*  81 */       return false; 
/*  82 */     if (((SETT.PATH()).availability.get(tx, ty)).player < 0.0D)
/*  83 */       return false; 
/*  84 */     SETT_JOB j = this.job.init(tx, ty);
/*  85 */     return (j != null && j.jobReserveCanBe());
/*     */   }
/*     */ 
/*     */   
/*     */   public SETT_JOB reportResourceMissing(RBIT resourceMask, int jx, int jy) {
/*  90 */     this.ins.missingLivestock = true;
/*  91 */     this.ins.searchForLivestock = false;
/*  92 */     return getReservableJob();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reportResourceFound(RESOURCE res) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean resourceReachable(RESOURCE res) {
/* 103 */     if (res == RESOURCES.LIVESTOCK())
/* 104 */       return !this.ins.missingLivestock; 
/* 105 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SETT_JOB getReservableJob(COORDINATE prefered) {
/* 111 */     if (prefered == null) {
/* 112 */       return getReservableJob();
/*     */     }
/* 114 */     return getReservableAdjacentJob(prefered);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SETT_JOB getJob(COORDINATE c) {
/* 121 */     int tx = c.x();
/* 122 */     int ty = c.y();
/* 123 */     if (!this.ins.is(tx, ty))
/* 124 */       return null; 
/* 125 */     if (((SETT.PATH()).availability.get(tx, ty)).player < 0.0D)
/* 126 */       return null; 
/* 127 */     this.job.init(tx, ty);
/* 128 */     if (this.is.is(this.job.data))
/* 129 */       return this.jobBaby.init(tx, ty); 
/* 130 */     return this.job;
/*     */   }
/*     */   
/*     */   public SETT_JOB getJob(int tx, int ty) {
/* 134 */     if (!this.ins.is(tx, ty))
/* 135 */       return null; 
/* 136 */     if (((SETT.PATH()).availability.get(tx, ty)).player < 0.0D)
/* 137 */       return null; 
/* 138 */     this.job.init(tx, ty);
/* 139 */     if (this.is.is(this.job.data))
/* 140 */       return this.jobBaby.init(tx, ty); 
/* 141 */     return this.job;
/*     */   }
/*     */   
/*     */   private SETT_JOB getReservableAdjacentJob(COORDINATE c) {
/* 145 */     if (!this.ins.needsWork())
/* 146 */       return getReservableJob(); 
/* 147 */     CircleCooIterator it = GUTIL.circle();
/* 148 */     int i = RND.rInt(10);
/* 149 */     while (it.radius(i++) < 5) {
/* 150 */       if (RND.oneIn(4) && 
/* 151 */         isAvailable(c.x() + it.get(i).x(), c.y() + it.get(i).y())) {
/* 152 */         return this.job;
/*     */       }
/*     */     } 
/* 155 */     return null;
/*     */   }
/*     */   
/*     */   private class JobBaby
/*     */     implements SETT_JOB
/*     */   {
/* 161 */     private int data = 0;
/* 162 */     private Coo coo = new Coo();
/*     */     
/*     */     JobBaby init(int tx, int ty) {
/* 165 */       this.coo.set(tx, ty);
/* 166 */       this.data = (SETT.ROOMS()).data.get(tx, ty);
/* 167 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserve(RESOURCE r) {
/* 172 */       if (jobReservedIs(r) || r != RESOURCES.LIVESTOCK())
/* 173 */         throw new RuntimeException(); 
/* 174 */       JobManager.this.ins.consumeALivestockFetch();
/* 175 */       this.data = JobManager.this.reserved.set(this.data);
/* 176 */       this.data = JobManager.this.is.set(this.data);
/* 177 */       (SETT.ROOMS()).data.set((ROOMA)JobManager.this.ins, (COORDINATE)this.coo, this.data);
/* 178 */       JobManager.this.ins.missingLivestock = false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobReservedIs(RESOURCE r) {
/* 183 */       return JobManager.this.reserved.is(this.data);
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserveCancel(RESOURCE r) {
/* 188 */       this.data = JobManager.this.reserved.clear(this.data);
/* 189 */       this.data = JobManager.this.is.clear(this.data);
/* 190 */       (SETT.ROOMS()).data.set((ROOMA)JobManager.this.ins, (COORDINATE)this.coo, this.data);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobReserveCanBe() {
/* 195 */       return !jobReservedIs(RESOURCES.LIVESTOCK());
/*     */     }
/*     */ 
/*     */     
/*     */     public RBIT jobResourceBitToFetch() {
/* 200 */       return (RESOURCES.LIVESTOCK()).bit;
/*     */     }
/*     */ 
/*     */     
/*     */     public double jobPerformTime(Humanoid skill) {
/* 205 */       return 0.0D;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 215 */       jobReserveCancel(null);
/* 216 */       JobManager.this.ins.work(skill, r, (COORDINATE)this.coo);
/* 217 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public int jobResourcesNeeded(Humanoid skill) {
/* 222 */       return 1;
/*     */     }
/*     */ 
/*     */     
/*     */     public COORDINATE jobCoo() {
/* 227 */       return (COORDINATE)this.coo;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence jobName() {
/* 232 */       return (JobManager.this.ins.blueprintI().employment()).verb;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobUseTool() {
/* 237 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public SoundRace jobSound() {
/* 242 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean longFetch() {
/* 247 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class Job
/*     */     implements SETT_JOB
/*     */   {
/* 256 */     private int data = 0;
/* 257 */     private Coo coo = new Coo();
/*     */     
/*     */     Job init(int tx, int ty) {
/* 260 */       this.coo.set(tx, ty);
/* 261 */       this.data = (SETT.ROOMS()).data.get(tx, ty);
/* 262 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserve(RESOURCE r) {
/* 267 */       if (jobReservedIs(r))
/* 268 */         throw new RuntimeException(); 
/* 269 */       this.data = JobManager.this.reserved.set(this.data);
/* 270 */       this.data = JobManager.this.is.clear(this.data);
/* 271 */       (SETT.ROOMS()).data.set((ROOMA)JobManager.this.ins, (COORDINATE)this.coo, this.data);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobReservedIs(RESOURCE r) {
/* 276 */       return JobManager.this.reserved.is(this.data);
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserveCancel(RESOURCE r) {
/* 281 */       this.data = JobManager.this.reserved.clear(this.data);
/* 282 */       (SETT.ROOMS()).data.set((ROOMA)JobManager.this.ins, (COORDINATE)this.coo, this.data);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobReserveCanBe() {
/* 287 */       return !jobReservedIs(null);
/*     */     }
/*     */ 
/*     */     
/*     */     public RBIT jobResourceBitToFetch() {
/* 292 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public double jobPerformTime(Humanoid skill) {
/* 297 */       return 20.0D;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/* 307 */       jobReserveCancel(r);
/* 308 */       JobManager.this.ins.work(skill, r, (COORDINATE)this.coo);
/* 309 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public int jobResourcesNeeded(Humanoid skill) {
/* 314 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public COORDINATE jobCoo() {
/* 319 */       return (COORDINATE)this.coo;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence jobName() {
/* 324 */       return (JobManager.this.ins.blueprintI().employment()).verb;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobUseTool() {
/* 329 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public SoundRace jobSound() {
/* 334 */       return JobManager.this.ins.blueprintI().employment().sound();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void resetResourceSearch() {
/* 341 */     this.ins.missingLivestock = false;
/* 342 */     this.ins.searchForLivestock = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean resourceShouldSearch(RESOURCE res) {
/* 348 */     return this.ins.searchForLivestock;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\pasture\JobManager.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */