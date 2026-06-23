/*     */ package settlement.room.infra.janitor;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ final class JM
/*     */   implements JOB_MANAGER {
/*     */   private JanitorInstance ins;
/*     */   private final ROOM_JANITOR b;
/*  20 */   private final Coo coo = new Coo();
/*     */   private final SETT_JOB work;
/*     */   int lx;
/*     */   int ly;
/*     */   final SETT_JOB res;
/*     */   
/*     */   JOB_MANAGER get(JanitorInstance ins) {
/*  27 */     this.ins = ins;
/*  28 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reportResourceFound(RESOURCE res) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean resourceReachable(RESOURCE res) {
/*  40 */     return !this.ins.bits.resMissing(res);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean resourceShouldSearch(RESOURCE res) {
/*  45 */     return (SETT.PATH()).finders.maintenance.mask(this.ins.mX(), this.ins.mY()).has(res);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SETT_JOB getReservableJob(COORDINATE prefered) {
/*  51 */     if (prefered == null) {
/*  52 */       if (!this.ins.bits.resMaskWorker(this.ins).isClear()) {
/*  53 */         this.coo.set(this.ins.rx, this.ins.ry);
/*  54 */         return this.res;
/*     */       } 
/*     */       
/*  57 */       if (!this.ins.searchForJobs) {
/*  58 */         return null;
/*     */       }
/*  60 */       SETT_JOB j = search(this.ins.mX(), this.ins.mY(), 150);
/*     */       
/*  62 */       if (j == null) {
/*  63 */         this.ins.searchForJobs = false;
/*     */       }
/*  65 */       return j;
/*     */     } 
/*     */     
/*  68 */     if (!this.ins.bits.resMaskFetcherMust(this.ins).isClear()) {
/*  69 */       this.coo.set(this.ins.rx, this.ins.ry);
/*  70 */       return this.res;
/*     */     } 
/*     */     
/*  73 */     if (this.ins.is(prefered) && !this.ins.bits.resMaskFetcher(this.ins).isClear()) {
/*  74 */       this.coo.set(this.ins.rx, this.ins.ry);
/*  75 */       return this.res;
/*     */     } 
/*     */     
/*  78 */     int tx = prefered.x();
/*  79 */     int ty = prefered.y();
/*     */     
/*  81 */     this.coo.set(prefered);
/*     */     
/*  83 */     if ((SETT.MAINTENANCE()).reservable.is(tx, ty)) {
/*  84 */       RESOURCE res = (RESOURCE)(SETT.MAINTENANCE()).resource.get(tx, ty);
/*  85 */       if (res == null || this.ins.bits.resAm(res) > 0)
/*  86 */         return this.work; 
/*     */     } 
/*  88 */     if (!this.ins.is(prefered)) {
/*  89 */       SETT_JOB j = search(prefered.x(), prefered.y(), 32);
/*  90 */       if (j != null) {
/*  91 */         return j;
/*     */       }
/*     */     } 
/*  94 */     if (!this.ins.searchForJobs) {
/*  95 */       return null;
/*     */     }
/*  97 */     return search(this.ins.mX(), this.ins.mY(), 150);
/*     */   }
/*     */ 
/*     */   
/*     */   public SETT_JOB reportResourceMissing(RBIT resourceMask, int jx, int jy) {
/* 102 */     this.ins = (JanitorInstance)this.b.get(jx, jy);
/* 103 */     if (this.ins != null) {
/* 104 */       this.ins.bits.resSetMissing(resourceMask);
/* 105 */       this.coo.set(jx, jy);
/* 106 */       SETT_JOB j = getReservableJob((COORDINATE)this.coo);
/* 107 */       return j;
/*     */     } 
/*     */     
/* 110 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SETT_JOB getJob(COORDINATE c) {
/* 117 */     this.coo.set(c);
/*     */     
/* 119 */     if (this.coo.isSameAs(this.ins.rx, this.ins.ry)) {
/* 120 */       return this.res;
/*     */     }
/*     */     
/* 123 */     if ((SETT.MAINTENANCE()).isser.is((COORDINATE)this.coo)) {
/* 124 */       return this.work;
/*     */     }
/*     */     
/* 127 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private SETT_JOB search(int sx, int sy, int distance) {
/* 132 */     COORDINATE c = (SETT.PATH()).finders.maintenance.findWithin((RBIT)this.ins.bits.resHave(), sx, sy, 150, this.ins.mX(), this.ins.mY());
/*     */     
/* 134 */     if (c != null) {
/* 135 */       this.coo.set(c);
/* 136 */       return this.work;
/*     */     } 
/*     */     
/* 139 */     return null;
/*     */   }
/*     */   
/* 142 */   JM(ROOM_JANITOR b) { this.work = new Job();
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
/* 233 */     this.res = new SETT_JOB()
/*     */       {
/*     */         public boolean jobUseTool()
/*     */         {
/* 237 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 247 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 252 */           return (RBIT)JM.this.ins.bits.resMaskFetcher(JM.this.ins);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 257 */           return JM.this.ins.bits.resReserved(r);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 262 */           JM.this.ins.bits.resReserve(JM.this.ins, r, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 267 */           return !JM.this.ins.bits.resMaskFetcher(JM.this.ins).isClear();
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/* 272 */           JM.this.ins.bits.resReserve(JM.this.ins, r, true);
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid skill) {
/* 277 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/* 282 */           JM.this.ins.bits.resReserve(JM.this.ins, r, false);
/* 283 */           JM.this.ins.bits.resInc(JM.this.ins, r, ram);
/*     */           
/* 285 */           boolean view = false;
/*     */ 
/*     */           
/* 288 */           for (int i = 0; i < 8; i++) {
/* 289 */             if ((JM.this.ins.tableRes >> i * 8 & 0xFFL) == (r.index() + 1)) {
/* 290 */               view = true;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/* 295 */           if (!view) {
/* 296 */             JM.this.ins.tableRes <<= 8L;
/* 297 */             JM.this.ins.tableRes |= (r.index() + 1);
/*     */           } 
/*     */ 
/*     */           
/* 301 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 306 */           return (JM.this.b.employment()).verb;
/*     */         }
/*     */         
/*     */         public COORDINATE jobCoo()
/*     */         {
/* 311 */           return (COORDINATE)JM.this.coo;
/*     */         }
/*     */       };
/*     */     this.b = b; }
/*     */ 
/*     */   
/*     */   public void resetResourceSearch() {
/* 318 */     this.ins.bits.update();
/*     */   }
/*     */   
/*     */   private class Job implements SETT_JOB {
/*     */     private int wt = 20;
/*     */     
/*     */     public boolean jobUseTool() {
/*     */       return true;
/*     */     }
/*     */     
/*     */     public void jobStartPerforming() {}
/*     */     
/*     */     public SoundRace jobSound() {
/*     */       return JM.this.b.employment().sound();
/*     */     }
/*     */     
/*     */     public RBIT jobResourceBitToFetch() {
/*     */       return null;
/*     */     }
/*     */     
/*     */     public boolean jobReservedIs(RESOURCE r) {
/*     */       return (SETT.MAINTENANCE()).reserved.is(JM.this.coo.x(), JM.this.coo.y());
/*     */     }
/*     */     
/*     */     public void jobReserveCancel(RESOURCE r) {
/*     */       (SETT.MAINTENANCE()).reserved.set((COORDINATE)JM.this.coo, false);
/*     */       r = (RESOURCE)(SETT.MAINTENANCE()).resource.get((COORDINATE)JM.this.coo);
/*     */       if (r != null && JM.this.ins.bits.resAm(r) > 0) {
/*     */         JM.this.ins.bits.resInc(JM.this.ins, r, 1);
/*     */         FACTIONS.player().res().inc(r, FResources.RTYPE.MAINTENANCE, 1);
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean jobReserveCanBe() {
/*     */       return (SETT.MAINTENANCE()).reservable.is((COORDINATE)JM.this.coo);
/*     */     }
/*     */     
/*     */     public void jobReserve(RESOURCE r) {
/*     */       if (JM.this.coo.isSameAs(JM.this.ins.rx, JM.this.ins.ry))
/*     */         GAME.Notify("FUCKFUCK"); 
/*     */       r = (RESOURCE)(SETT.MAINTENANCE()).resource.get((COORDINATE)JM.this.coo);
/*     */       if (r != null && JM.this.ins.bits.resAm(r) > 0) {
/*     */         JM.this.ins.bits.resInc(JM.this.ins, r, -1);
/*     */         FACTIONS.player().res().inc(r, FResources.RTYPE.MAINTENANCE, -1);
/*     */       } 
/*     */       (SETT.MAINTENANCE()).reserved.set((COORDINATE)JM.this.coo, true);
/*     */     }
/*     */     
/*     */     public double jobPerformTime(Humanoid skill) {
/*     */       if (JM.this.coo.isSameAs(JM.this.lx, JM.this.ly) || (SETT.MAINTENANCE()).resource.get((COORDINATE)JM.this.coo) != null)
/*     */         return 1.0D; 
/*     */       return ((SETT.MAINTENANCE()).pFreeFetch.is((COORDINATE)JM.this.coo) ? true : this.wt);
/*     */     }
/*     */     
/*     */     public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/*     */       (SETT.MAINTENANCE()).reserved.set((COORDINATE)JM.this.coo, false);
/*     */       SETT.MAINTENANCE().maintain(JM.this.coo.x(), JM.this.coo.y());
/*     */       JM.this.lx = JM.this.coo.x();
/*     */       JM.this.ly = JM.this.coo.y();
/*     */       (SETT.MAINTENANCE()).pFreeFetch.set((COORDINATE)JM.this.coo, JM.this.ins.employees().fetchBonusConsume(this.wt + 1));
/*     */       return null;
/*     */     }
/*     */     
/*     */     public CharSequence jobName() {
/*     */       return (JM.this.b.employment()).verb;
/*     */     }
/*     */     
/*     */     public COORDINATE jobCoo() {
/*     */       return (COORDINATE)JM.this.coo;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\janitor\JM.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */