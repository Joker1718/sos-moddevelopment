/*     */ package settlement.room.infra.elderly;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ final class Job {
/*  15 */   private final Bit is = new Bit(1);
/*  16 */   private final Bit reserved = new Bit(2);
/*  17 */   private final Bit using = new Bit(4);
/*     */   private final ROOM_RESTHOME b;
/*     */   private int data;
/*  20 */   private final Coo coo = new Coo();
/*     */   
/*     */   private ResthomeInstance ins;
/*     */   
/*     */   private final SETT_JOB job;
/*     */ 
/*     */   
/*     */   SETT_JOB get(int tx, int ty) {
/*  28 */     this.ins = (ResthomeInstance)this.b.get(tx, ty);
/*  29 */     if (this.ins != null && 
/*  30 */       this.is.is((SETT.ROOMS()).data.get(tx, ty))) {
/*  31 */       this.data = (SETT.ROOMS()).data.get(tx, ty);
/*  32 */       this.coo.set(tx, ty);
/*  33 */       return this.job;
/*     */     } 
/*     */     
/*  36 */     return null;
/*     */   }
/*     */   
/*     */   public boolean used(int tx, int ty) {
/*  40 */     if (get(tx, ty) != null)
/*  41 */       return this.using.is(this.data); 
/*  42 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(ResthomeInstance ins, int tx, int ty) {
/*  47 */     (SETT.ROOMS()).data.set((ROOMA)ins, tx, ty, this.is.set(0));
/*     */   }
/*     */   
/*     */   Job(ROOM_RESTHOME b) {
/*  51 */     this.job = new SETT_JOB()
/*     */       {
/*     */ 
/*     */         
/*     */         public boolean jobUseTool()
/*     */         {
/*  57 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {
/*  62 */           Job.this.data = Job.this.using.set(Job.this.data);
/*  63 */           (SETT.ROOMS()).data.set((ROOMA)Job.this.ins, (COORDINATE)Job.this.coo, Job.this.data);
/*     */         }
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/*  68 */           return Job.this.b.employment().sound();
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/*  73 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/*  78 */           return Job.this.reserved.is(Job.this.data);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/*  83 */           Job.this.data = Job.this.reserved.clear(Job.this.data);
/*  84 */           Job.this.data = Job.this.using.clear(Job.this.data);
/*  85 */           (SETT.ROOMS()).data.set((ROOMA)Job.this.ins, (COORDINATE)Job.this.coo, Job.this.data);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/*  90 */           return !Job.this.reserved.is(Job.this.data);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/*  95 */           Job.this.data = Job.this.reserved.set(Job.this.data);
/*  96 */           Job.this.data = Job.this.using.clear(Job.this.data);
/*  97 */           (SETT.ROOMS()).data.set((ROOMA)Job.this.ins, (COORDINATE)Job.this.coo, Job.this.data);
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid skill) {
/* 102 */           return 45.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/* 107 */           jobReserveCancel(r);
/* 108 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 113 */           return (Job.this.b.employment()).verb;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 118 */           return (COORDINATE)Job.this.coo;
/*     */         }
/*     */       };
/*     */     this.b = b;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\elderly\Job.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */