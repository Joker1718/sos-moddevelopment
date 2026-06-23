/*     */ package settlement.room.service.stage;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ final class Centre {
/*  16 */   private final Bits dused = new Bits(1);
/*  17 */   private final Bits dreserved = new Bits(2);
/*     */   private StageInstance ins;
/*  19 */   private final Coo coo = new Coo();
/*     */   
/*     */   private int data;
/*     */   
/*     */   private final ROOM_STAGE b;
/*     */   private final FSERVICE service;
/*     */   private final SETT_JOB job;
/*     */   
/*     */   public SETT_JOB job(int tx, int ty) {
/*  28 */     this.ins = (StageInstance)this.b.getter.get(tx, ty);
/*  29 */     if (this.ins != null && (SETT.ROOMS()).fData.tileData.get(tx, ty) == 1) {
/*  30 */       this.coo.set(tx, ty);
/*  31 */       this.data = (SETT.ROOMS()).data.get(tx, ty);
/*  32 */       return this.job;
/*     */     } 
/*  34 */     return null;
/*     */   }
/*     */   
/*     */   public FSERVICE service(int tx, int ty) {
/*  38 */     this.ins = (StageInstance)this.b.getter.get(tx, ty);
/*  39 */     if (this.ins != null && this.ins.body().cX() == tx && this.ins.body().cY() == ty) {
/*  40 */       this.coo.set(tx, ty);
/*  41 */       this.data = (SETT.ROOMS()).data.get(tx, ty);
/*  42 */       return this.service;
/*     */     } 
/*  44 */     return null;
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
/*     */   private void save() {
/*  57 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Centre(ROOM_STAGE b) {
/*  63 */     this.service = new FSERVICE()
/*     */       {
/*     */         public void consume() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public int x() {
/*  72 */           return Centre.this.ins.body().cX();
/*     */         }
/*     */ 
/*     */         
/*     */         public int y() {
/*  77 */           return Centre.this.ins.body().cY();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedCanBe() {
/*  82 */           return (Centre.this.ins.services() > 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserve() {
/*  87 */           if (!findableReservedCanBe()) {
/*  88 */             throw new RuntimeException();
/*     */           }
/*  90 */           Centre.this.ins.incServices(-1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedIs() {
/*  95 */           return Centre.this.ins.hasService();
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserveCancel() {
/* 100 */           Centre.this.ins.incServices(1);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 105 */     this.job = new SETT_JOB()
/*     */       {
/*     */         public boolean jobUseTool()
/*     */         {
/* 109 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {
/* 114 */           Centre.this.data = Centre.this.dused.set(Centre.this.data, 1);
/* 115 */           Centre.this.save();
/*     */         }
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 120 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 125 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 130 */           return (Centre.this.dreserved.get(Centre.this.data) == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 135 */           Centre.this.data = Centre.this.dused.set(Centre.this.data, 0);
/* 136 */           Centre.this.data = Centre.this.dreserved.set(Centre.this.data, 0);
/* 137 */           Centre.this.save();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 142 */           return !jobReservedIs(null);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/* 147 */           Centre.this.data = Centre.this.dreserved.set(Centre.this.data, 1);
/* 148 */           Centre.this.save();
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid a) {
/* 153 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 158 */           jobReserveCancel(r);
/* 159 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 164 */           return (Centre.this.b.employment()).verb;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 169 */           return (COORDINATE)Centre.this.coo;
/*     */         }
/*     */       };
/*     */     this.b = b;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\stage\Centre.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */