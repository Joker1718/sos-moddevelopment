/*     */ package settlement.room.main.job;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import java.io.Serializable;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ 
/*     */ 
/*     */ public abstract class JobPositions<T extends RoomInstance>
/*     */   implements JOB_MANAGER, Serializable
/*     */ {
/*     */   protected final T ins;
/*     */   private boolean hasSearchedAll;
/*     */   private final ArrayCooShort coos;
/*  20 */   private int searchI = 0;
/*  21 */   public final RBIT.RBITImp resNotFound = new RBIT.RBITImp();
/*  22 */   private final RBIT.RBITImp resSearchmask = new RBIT.RBITImp();
/*     */   private boolean alwaysNew;
/*     */   private static final long serialVersionUID = 2358456270243399328L;
/*     */   
/*     */   public JobPositions(T ins) {
/*  27 */     this.ins = ins;
/*     */     
/*  29 */     int amount = 0;
/*     */     
/*  31 */     for (COORDINATE c : ins.body()) {
/*  32 */       if (ins.is(c) && isAndInit(c.x(), c.y())) {
/*  33 */         amount++;
/*     */       }
/*     */     } 
/*  36 */     this.coos = new ArrayCooShort(amount);
/*  37 */     int i = 0;
/*     */     
/*  39 */     for (COORDINATE c : ins.body()) {
/*  40 */       if (ins.is(c) && initIs(c.x(), c.y())) {
/*  41 */         this.coos.set(i).set(c);
/*  42 */         i++;
/*     */       } 
/*     */     } 
/*     */     
/*  46 */     if (i != amount) {
/*  47 */       throw new RuntimeException("" + i + " " + i);
/*     */     }
/*     */   }
/*     */   
/*     */   protected abstract boolean isAndInit(int paramInt1, int paramInt2);
/*     */   
/*     */   protected boolean initIs(int tx, int ty) {
/*  54 */     return (get(tx, ty) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract SETT_JOB get(int paramInt1, int paramInt2);
/*     */   
/*     */   public SETT_JOB reportResourceMissing(RBIT resMask, int jx, int jy) {
/*  61 */     this.resNotFound.or(resMask);
/*  62 */     this.resSearchmask.or(resMask);
/*  63 */     return getReservableJob();
/*     */   }
/*     */ 
/*     */   
/*     */   public void reportResourceFound(RESOURCE res) {
/*  68 */     this.resNotFound.clear(res);
/*  69 */     this.resSearchmask.clear(res);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean resourceShouldSearch(RESOURCE res) {
/*  74 */     return !this.resSearchmask.has(res);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean resourceReachable(RESOURCE res) {
/*  79 */     return !this.resNotFound.has(res);
/*     */   }
/*     */   
/*     */   private boolean resourceCheck(SETT_JOB j) {
/*  83 */     RBIT f = j.jobResourceBitToFetch();
/*  84 */     if (f == null) {
/*  85 */       return true;
/*     */     }
/*     */ 
/*     */     
/*  89 */     return !this.resSearchmask.hasAll(f);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private SETT_JOB getReservableJob() {
/*  95 */     if (this.hasSearchedAll) {
/*  96 */       return null;
/*     */     }
/*  98 */     if (this.alwaysNew) {
/*  99 */       this.searchI++;
/*     */     }
/* 101 */     for (int i = 0; i < this.coos.size(); i++) {
/* 102 */       if (this.searchI >= this.coos.size())
/* 103 */         this.searchI = 0; 
/* 104 */       this.coos.set(this.searchI);
/*     */       
/* 106 */       SETT_JOB j = reservable(this.coos.get().x(), this.coos.get().y());
/* 107 */       if (j != null && resourceCheck(j)) {
/* 108 */         return j;
/*     */       }
/* 110 */       this.searchI++;
/*     */     } 
/*     */     
/* 113 */     this.hasSearchedAll = true;
/* 114 */     return null;
/*     */   }
/*     */   
/*     */   private SETT_JOB reservable(int tx, int ty) {
/* 118 */     if (!this.ins.is(tx, ty))
/* 119 */       return null; 
/* 120 */     SETT_JOB j = get(tx, ty);
/* 121 */     if (j == null)
/* 122 */       return null; 
/* 123 */     if (!j.jobReserveCanBe())
/* 124 */       return null; 
/* 125 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SETT_JOB getReservableJob(COORDINATE pref) {
/* 131 */     if (pref == null || this.alwaysNew) {
/* 132 */       return getReservableJob();
/*     */     }
/* 134 */     SETT_JOB j = reservable(pref.x(), pref.y());
/*     */     
/* 136 */     if (j == null) {
/* 137 */       return getReservableJob();
/*     */     }
/* 139 */     if (!resourceCheck(j)) {
/* 140 */       return getReservableJob();
/*     */     }
/* 142 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public SETT_JOB getJob(COORDINATE c) {
/* 147 */     if (this.ins.is(c)) {
/* 148 */       return get(c.x(), c.y());
/*     */     }
/* 150 */     return null;
/*     */   }
/*     */   
/*     */   public void searchAgain() {
/* 154 */     this.resSearchmask.clear();
/* 155 */     this.hasSearchedAll = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void resetResourceSearch() {
/* 160 */     this.resSearchmask.clear();
/* 161 */     this.resNotFound.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void searchAgainButDontReset() {
/* 166 */     this.hasSearchedAll = false;
/*     */   }
/*     */   
/*     */   public void stopSearching() {
/* 170 */     this.hasSearchedAll = true;
/*     */   }
/*     */   
/*     */   public boolean isSearching() {
/* 174 */     return !this.hasSearchedAll;
/*     */   }
/*     */   
/*     */   public int size() {
/* 178 */     return this.coos.size();
/*     */   }
/*     */   
/*     */   public COORDINATE get(int i) {
/* 182 */     return (COORDINATE)this.coos.set(i);
/*     */   }
/*     */   
/*     */   public void setAlwaysNew() {
/* 186 */     this.alwaysNew = true;
/*     */   }
/*     */   
/*     */   public void randomize() {
/* 190 */     for (int i = 0; i < this.coos.size(); i++) {
/* 191 */       this.coos.set(i);
/* 192 */       int x = this.coos.get().x();
/* 193 */       int y = this.coos.get().y();
/* 194 */       int d = RND.rInt(this.coos.size());
/* 195 */       this.coos.set(d);
/* 196 */       int x2 = this.coos.get().x();
/* 197 */       int y2 = this.coos.get().y();
/*     */       
/* 199 */       this.coos.set(i);
/* 200 */       this.coos.get().set(x2, y2);
/*     */       
/* 202 */       this.coos.set(d);
/* 203 */       this.coos.get().set(x, y);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\job\JobPositions.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */