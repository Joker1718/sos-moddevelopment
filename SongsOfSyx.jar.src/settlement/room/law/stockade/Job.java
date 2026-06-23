/*     */ package settlement.room.law.stockade;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ final class Job {
/*     */   public static final int ISTAND = 1;
/*     */   public static final int IFOOD = 2;
/*     */   public static final int ISHIT = 3;
/*     */   private final ROOM_STOCKADE b;
/*  21 */   private final Coo coo = new Coo();
/*     */   private StockInstance ins;
/*  23 */   private final RoomBits type = new RoomBits((COORDINATE)this.coo, new Bits(7));
/*  24 */   private final RoomBits reserved = new RoomBits((COORDINATE)this.coo, new Bits(8));
/*  25 */   private final RoomBits sreserved = new RoomBits((COORDINATE)this.coo, new Bits(16));
/*  26 */   private final RoomBits data = new RoomBits((COORDINATE)this.coo, new Bits(-32));
/*     */ 
/*     */   
/*     */   private final SETT_JOB job;
/*     */ 
/*     */ 
/*     */   
/*     */   public SETT_JOB job(int tx, int ty) {
/*  34 */     this.ins = (StockInstance)this.b.getter.get(tx, ty);
/*  35 */     if (this.ins != null) {
/*  36 */       this.coo.set(tx, ty);
/*  37 */       if (this.type.get() != 0)
/*  38 */         return this.job; 
/*     */     } 
/*  40 */     return null;
/*     */   }
/*     */   
/*     */   public int food(int tx, int ty) {
/*  44 */     if (job(tx, ty) != null && this.type.get() == 2)
/*  45 */       return this.data.get(); 
/*  46 */     return 0;
/*     */   }
/*     */   
/*     */   public int shit(int tx, int ty) {
/*  50 */     if (job(tx, ty) != null && this.type.get() == 3)
/*  51 */       return this.data.get(); 
/*  52 */     return 0;
/*     */   }
/*     */   
/*     */   public int type(int tx, int ty) {
/*  56 */     if (job(tx, ty) != null)
/*  57 */       return this.type.get(); 
/*  58 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean reserve(int tx, int ty, int type, boolean reserve, boolean use) {
/*  62 */     if (job(tx, ty) == null)
/*  63 */       return false; 
/*  64 */     if (this.type.get() == type) {
/*  65 */       if (type == 2 && this.data.get() <= 0) {
/*  66 */         return false;
/*     */       }
/*  68 */       if (use) {
/*  69 */         if (type == 2) {
/*  70 */           this.data.inc((ROOMA)this.ins, -1);
/*  71 */         } else if (type == 3) {
/*  72 */           this.data.inc((ROOMA)this.ins, 1);
/*     */         } 
/*     */       }
/*  75 */       if (reserve) {
/*  76 */         if (this.sreserved.get() == 0) {
/*  77 */           this.sreserved.set((ROOMA)this.ins, 1);
/*  78 */           return true;
/*     */         } 
/*  80 */         return false;
/*     */       } 
/*  82 */       this.sreserved.set((ROOMA)this.ins, 0);
/*  83 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  88 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   Job(ROOM_STOCKADE b) {
/*  93 */     this.job = new SETT_JOB()
/*     */       {
/*     */         public boolean jobUseTool()
/*     */         {
/*  97 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobUseHands() {
/* 102 */           return (Job.this.type.get() == 3);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 112 */           return Job.this.b.employment().sound();
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 117 */           if (Job.this.type.get() == 2) {
/* 118 */             return (RBIT)Job.this.ins.fetch;
/*     */           }
/* 120 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 125 */           return (Job.this.reserved.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 130 */           Job.this.reserved.set((ROOMA)Job.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 135 */           if (Job.this.type.get() == 2 && Job.this.data.get() > 8)
/* 136 */             return false; 
/* 137 */           return (Job.this.reserved.get() == 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/* 142 */           if (r != null) {
/* 143 */             Job.this.ins.jobs.resetResourceSearch();
/*     */           }
/* 145 */           Job.this.reserved.set((ROOMA)Job.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid a) {
/* 150 */           if (Job.this.type.get() == 1)
/* 151 */             return 60.0D; 
/* 152 */           return 20.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 157 */           if (Job.this.type.get() == 2 && rAm > 0) {
/* 158 */             Job.this.data.inc((ROOMA)Job.this.ins, rAm);
/* 159 */             for (IndustryResource ii : Job.this.b.indu.ins()) {
/* 160 */               if (ii.resource == r)
/* 161 */                 ii.inc((ROOM_IDATA_INSTANCE)Job.this.ins, rAm); 
/*     */             } 
/*     */           } else {
/* 164 */             Job.this.data.set((ROOMA)Job.this.ins, 0);
/* 165 */           }  Job.this.reserved.set((ROOMA)Job.this.ins, 0);
/* 166 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 171 */           return (Job.this.b.employment()).title;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 176 */           return (COORDINATE)Job.this.coo;
/*     */         }
/*     */       };
/*     */     this.b = b;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\stockade\Job.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */