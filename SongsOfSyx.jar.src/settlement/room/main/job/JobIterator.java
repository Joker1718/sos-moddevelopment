/*     */ package settlement.room.main.job;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import java.io.Serializable;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class JobIterator
/*     */   implements JOB_MANAGER, Serializable
/*     */ {
/*     */   protected final RoomInstance ins;
/*  21 */   private final Coo search = new Coo();
/*     */   private boolean hasSearchedAll;
/*  23 */   private final RBIT.RBITImp resSearch = new RBIT.RBITImp();
/*  24 */   private final RBIT.RBITImp resNotFound = new RBIT.RBITImp();
/*     */   
/*     */   private boolean alwaysNew = false;
/*     */   private boolean randomize = false;
/*     */   private static final long serialVersionUID = -6055758404619685045L;
/*     */   
/*     */   public JobIterator(RoomInstance ins) {
/*  31 */     this.ins = ins;
/*  32 */     this.search.set((
/*  33 */         ins.body().x1() + RND.rInt(ins.body().width())), (
/*  34 */         ins.body().y1() + RND.rInt(ins.body().height())));
/*     */   }
/*     */   
/*     */   public void setAlwaysNewJob() {
/*  38 */     this.alwaysNew = true;
/*     */   }
/*     */   
/*     */   public void randomize() {
/*  42 */     this.randomize = true;
/*     */   }
/*     */   
/*     */   public void randomizeN() {
/*  46 */     this.randomize = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public SETT_JOB reportResourceMissing(RBIT resMask, int jx, int jy) {
/*  51 */     this.resSearch.or(resMask);
/*  52 */     this.resNotFound.or(resMask);
/*  53 */     return getReservableJob();
/*     */   }
/*     */ 
/*     */   
/*     */   public void reportResourceFound(RESOURCE res) {
/*  58 */     this.resSearch.clear(res);
/*  59 */     this.resNotFound.clear(res);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean resourceCheck(SETT_JOB j) {
/*  64 */     if (j.jobResourceBitToFetch() == null) {
/*  65 */       return true;
/*     */     }
/*  67 */     if (!(SETT.PATH()).finders.resource.normal.has(j.jobCoo().x(), j.jobCoo().y(), j.jobResourceBitToFetch())) {
/*  68 */       this.resSearch.or(j.jobResourceBitToFetch());
/*  69 */       this.resNotFound.or(j.jobResourceBitToFetch());
/*  70 */       return false;
/*     */     } 
/*  72 */     return !this.resSearch.hasAll(j.jobResourceBitToFetch());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean resourceReachable(RESOURCE res) {
/*  78 */     return !this.resNotFound.has(res.bit);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean resourceShouldSearch(RESOURCE res) {
/*  83 */     return !this.resSearch.has(res.bit);
/*     */   }
/*     */ 
/*     */   
/*     */   private SETT_JOB getReservableJob() {
/*  88 */     if (this.hasSearchedAll)
/*  89 */       return null; 
/*  90 */     if (this.randomize) {
/*  91 */       this.search.set((
/*  92 */           this.ins.body().x1() + RND.rInt(this.ins.body().width())), (
/*  93 */           this.ins.body().y1() + RND.rInt(this.ins.body().height())));
/*     */     }
/*  95 */     int tiles = ins().area();
/*  96 */     for (int i = 0; i < tiles; i++) {
/*  97 */       if (this.ins.is((COORDINATE)this.search)) {
/*  98 */         SETT_JOB j = reservable(this.search.x(), this.search.y());
/*  99 */         if (j != null && resourceCheck(j)) {
/* 100 */           if (this.alwaysNew)
/* 101 */             incSearch(); 
/* 102 */           return j;
/*     */         } 
/*     */       } 
/* 105 */       incSearch();
/*     */     } 
/* 107 */     this.hasSearchedAll = true;
/* 108 */     return null;
/*     */   }
/*     */   
/*     */   private SETT_JOB reservable(int tx, int ty) {
/* 112 */     if (!this.ins.is(tx, ty))
/* 113 */       return null; 
/* 114 */     SETT_JOB j = init(tx, ty);
/* 115 */     if (j == null)
/* 116 */       return null; 
/* 117 */     if (!j.jobReserveCanBe())
/* 118 */       return null; 
/* 119 */     if (!resourceCheck(j)) {
/* 120 */       return null;
/*     */     }
/* 122 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SETT_JOB getReservableJob(COORDINATE prefered) {
/* 128 */     if (this.alwaysNew || prefered == null)
/* 129 */       return getReservableJob(); 
/* 130 */     int tx = prefered.x();
/* 131 */     int ty = prefered.y();
/*     */     
/* 133 */     SETT_JOB j = reservable(tx, ty);
/* 134 */     if (j == null)
/* 135 */       j = getReservableAdjacentJob(tx, ty); 
/* 136 */     if (j == null)
/* 137 */       return getReservableJob(); 
/* 138 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   private void incSearch() {
/*     */     do {
/* 144 */       this.search.increment(1.0D, 0.0D);
/* 145 */       if (this.search.x() < this.ins.body().x2())
/* 146 */         continue;  this.search.increment(0.0D, 1.0D);
/* 147 */       this.search.xSet(this.ins.body().x1());
/* 148 */       if (this.search.y() < this.ins.body().y2())
/* 149 */         continue;  this.search.ySet(this.ins.body().y1());
/*     */     }
/* 151 */     while (!this.ins.is((COORDINATE)this.search));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasSearchedAll() {
/* 156 */     return this.hasSearchedAll;
/*     */   }
/*     */ 
/*     */   
/*     */   public SETT_JOB getJob(COORDINATE c) {
/* 161 */     if (this.ins.is(c)) {
/* 162 */       return init(c.x(), c.y());
/*     */     }
/* 164 */     return null;
/*     */   }
/*     */   
/*     */   protected abstract SETT_JOB init(int paramInt1, int paramInt2);
/*     */   
/*     */   public void searchAgain() {
/* 170 */     this.resSearch.clear();
/* 171 */     this.hasSearchedAll = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void resetResourceSearch() {
/* 176 */     this.resSearch.clear();
/* 177 */     this.resNotFound.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void searchAgainWithoutResources() {
/* 182 */     this.hasSearchedAll = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private SETT_JOB getReservableAdjacentJob(int tx, int ty) {
/* 188 */     if (this.hasSearchedAll) {
/* 189 */       return null;
/*     */     }
/* 191 */     if (this.alwaysNew) {
/* 192 */       return null;
/*     */     }
/* 194 */     int i = 1;
/* 195 */     while (GUTIL.circle().radius(i) < 5) {
/* 196 */       SETT_JOB j = reservable(tx + GUTIL.circle().get(i).x(), ty + GUTIL.circle().get(i).y());
/* 197 */       if (j != null)
/* 198 */         return j; 
/* 199 */       i++;
/*     */     } 
/* 201 */     return null;
/*     */   }
/*     */   
/*     */   public void dontSearch() {
/* 205 */     this.hasSearchedAll = true;
/*     */   }
/*     */   
/*     */   protected RoomInstance ins() {
/* 209 */     return this.ins;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\job\JobIterator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */