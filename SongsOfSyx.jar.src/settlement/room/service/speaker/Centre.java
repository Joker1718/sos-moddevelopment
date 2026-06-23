/*     */ package settlement.room.service.speaker;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ final class Centre
/*     */ {
/*     */   private SpeakerInstance ins;
/*  16 */   private final Coo coo = new Coo();
/*     */   
/*     */   private final ROOM_SPEAKER b;
/*     */   private final FSERVICE service;
/*     */   private final SETT_JOB job;
/*     */   private final JOB_MANAGER manager;
/*     */   
/*     */   public SETT_JOB job(int tx, int ty) {
/*  24 */     if (init(tx, ty))
/*  25 */       return this.job; 
/*  26 */     return null;
/*     */   }
/*     */   
/*     */   public FSERVICE service(int tx, int ty) {
/*  30 */     if (init(tx, ty))
/*  31 */       return this.service; 
/*  32 */     return null;
/*     */   }
/*     */   
/*     */   private boolean init(int tx, int ty) {
/*  36 */     this.ins = (SpeakerInstance)this.b.getter.get(tx, ty);
/*  37 */     if (this.ins != null && tx == this.ins.body().cX() && ty == this.ins.body().cY()) {
/*  38 */       this.coo.set(tx, ty);
/*  39 */       return true;
/*     */     } 
/*  41 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   Centre(ROOM_SPEAKER b) {
/*  46 */     this.service = new FSERVICE()
/*     */       {
/*     */         public void consume() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public int x() {
/*  55 */           return Centre.this.ins.body().cX();
/*     */         }
/*     */ 
/*     */         
/*     */         public int y() {
/*  60 */           return Centre.this.ins.body().cY();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedCanBe() {
/*  65 */           return (Centre.this.ins.services() > 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserve() {
/*  70 */           if (!findableReservedCanBe()) {
/*  71 */             throw new RuntimeException();
/*     */           }
/*  73 */           Centre.this.ins.incServices(-1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedIs() {
/*  78 */           return Centre.this.ins.hasService();
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserveCancel() {
/*  83 */           Centre.this.ins.incServices(1);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  88 */     this.job = new SETT_JOB()
/*     */       {
/*     */         public boolean jobUseTool()
/*     */         {
/*  92 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 102 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 107 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 112 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 122 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid a) {
/* 132 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 137 */           jobReserveCancel(r);
/* 138 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 143 */           return (Centre.this.b.employment()).verb;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 148 */           return (COORDINATE)Centre.this.coo;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 157 */     this.manager = new JOB_MANAGER()
/*     */       {
/*     */         public boolean resourceReachable(RESOURCE res)
/*     */         {
/* 161 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public SETT_JOB reportResourceMissing(RBIT resourceMask, int jx, int jy) {
/* 166 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public SETT_JOB getReservableJob(COORDINATE c) {
/* 171 */           return Centre.this.job(Centre.this.ins.body().cX(), Centre.this.ins.body().cY());
/*     */         }
/*     */ 
/*     */         
/*     */         public SETT_JOB getJob(COORDINATE c) {
/* 176 */           return Centre.this.job(Centre.this.ins.body().cX(), Centre.this.ins.body().cY());
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void reportResourceFound(RESOURCE res) {}
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void resetResourceSearch() {}
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean resourceShouldSearch(RESOURCE res) {
/* 193 */           return true;
/*     */         }
/*     */       };
/*     */     this.b = b;
/*     */   }
/*     */   
/*     */   public JOB_MANAGER manager(SpeakerInstance ins) {
/*     */     this.ins = ins;
/*     */     return this.manager;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\speaker\Centre.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */