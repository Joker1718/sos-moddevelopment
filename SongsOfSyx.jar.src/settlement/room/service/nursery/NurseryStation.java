/*     */ package settlement.room.service.nursery;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import game.time.TIME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ class NurseryStation
/*     */ {
/*  20 */   private final Coo coo = new Coo();
/*     */   
/*     */   private NurseryInstance ins;
/*     */   private final ROOM_NURSERY b;
/*  24 */   private final RoomBits bMark = new RoomBits((COORDINATE)this.coo, new Bits(1));
/*  25 */   private final RoomBits bWorked = new BB((COORDINATE)this.coo, new Bits(14));
/*  26 */   private final RoomBits bWorkReserved = new RoomBits((COORDINATE)this.coo, new Bits(16));
/*  27 */   private final RoomBits bServiceReserved = new BB((COORDINATE)this.coo, new Bits(32));
/*     */ 
/*     */   
/*     */   private final int wt;
/*     */ 
/*     */   
/*     */   private final SETT_JOB job;
/*     */   
/*     */   private final FSERVICE service;
/*     */ 
/*     */   
/*     */   private boolean pinit(int tx, int ty) {
/*  39 */     if (this.b.is(tx, ty)) {
/*  40 */       this.coo.set(tx, ty);
/*  41 */       this.ins = (NurseryInstance)this.b.get(tx, ty);
/*  42 */       if (this.bMark.get() == 1)
/*  43 */         return true; 
/*     */     } 
/*  45 */     return false;
/*     */   }
/*     */   
/*     */   public SETT_JOB job(int tx, int ty) {
/*  49 */     if (pinit(tx, ty))
/*  50 */       return this.job; 
/*  51 */     return null;
/*     */   }
/*     */   
/*     */   public FSERVICE service(int tx, int ty) {
/*  55 */     if (pinit(tx, ty))
/*  56 */       return this.service; 
/*  57 */     return null;
/*     */   }
/*     */   
/*     */   public void init(RoomInstance ins, int tx, int ty) {
/*  61 */     this.coo.set(tx, ty);
/*  62 */     this.bMark.set((ROOMA)ins, 1);
/*     */   }
/*     */   
/*     */   public int stuff(int tx, int ty) {
/*  66 */     if (pinit(tx, ty))
/*  67 */       return 3 - this.bWorked.get(); 
/*  68 */     return 0;
/*     */   }
/*     */   NurseryStation(ROOM_NURSERY b) {
/*  71 */     this.job = new SETT_JOB()
/*     */       {
/*     */ 
/*     */         
/*     */         public boolean jobUseTool()
/*     */         {
/*  77 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/*  87 */           return NurseryStation.this.b.employment().sound();
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/*  92 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/*  97 */           return (NurseryStation.this.bWorkReserved.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 102 */           NurseryStation.this.bWorkReserved.set((ROOMA)NurseryStation.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 107 */           if (NurseryStation.this.bWorkReserved.get() == 1) {
/* 108 */             return false;
/*     */           }
/* 110 */           if (NurseryStation.this.bWorked.get() >= 3)
/* 111 */             return false; 
/* 112 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/* 117 */           NurseryStation.this.bWorkReserved.set((ROOMA)NurseryStation.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid skill) {
/* 122 */           double d = IndustryUtil.calcProductionRate(1.0D, skill, NurseryStation.this.b.rate, NurseryStation.this.ins);
/* 123 */           if (d == 0.0D)
/* 124 */             return (NurseryStation.this.wt * 5); 
/* 125 */           return NurseryStation.this.wt / d;
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int am) {
/* 130 */           NurseryStation.this.bWorkReserved.set((ROOMA)NurseryStation.this.ins, 0);
/* 131 */           NurseryStation.this.bWorked.inc((ROOMA)NurseryStation.this.ins, 1);
/* 132 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 137 */           return (NurseryStation.this.b.employment()).verb;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 142 */           return (COORDINATE)NurseryStation.this.coo;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 148 */     this.service = new FSERVICE()
/*     */       {
/*     */         public int y()
/*     */         {
/* 152 */           return NurseryStation.this.coo.y();
/*     */         }
/*     */ 
/*     */         
/*     */         public int x() {
/* 157 */           return NurseryStation.this.coo.x();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedIs() {
/* 162 */           return (NurseryStation.this.bServiceReserved.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedCanBe() {
/* 167 */           return (NurseryStation.this.bServiceReserved.get() == 0 && NurseryStation.this.bWorked.get() > 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserveCancel() {
/* 172 */           NurseryStation.this.bServiceReserved.set((ROOMA)NurseryStation.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserve() {
/* 177 */           if (findableReservedCanBe()) {
/* 178 */             NurseryStation.this.bServiceReserved.set((ROOMA)NurseryStation.this.ins, 1);
/*     */           }
/*     */         }
/*     */         
/*     */         public void startUsing() {
/* 183 */           NurseryStation.this.bWorked.inc((ROOMA)NurseryStation.this.ins, -1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void consume() {
/* 188 */           NurseryStation.this.bServiceReserved.set((ROOMA)NurseryStation.this.ins, 0);
/*     */           
/* 190 */           NurseryStation.this.ins.getWork().searchAgain(); }
/*     */       };
/*     */     this.b = b;
/*     */     b.getClass();
/*     */     double worksPerDay = 10.0D * TIME.workSeconds() / 120.0D;
/*     */     this.wt = (int)(TIME.workSeconds() / worksPerDay);
/*     */   } private class BB extends RoomBits { public BB(COORDINATE coo, Bits bits) {
/* 197 */       super(coo, bits);
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(int tx, int ty, ROOMA r, int t) {
/* 202 */       NurseryStation.this.ins.service().report(NurseryStation.this.service, NurseryStation.this.ins.blueprintI().service(), -1);
/* 203 */       super.set(tx, ty, r, t);
/* 204 */       NurseryStation.this.ins.service().report(NurseryStation.this.service, NurseryStation.this.ins.blueprintI().service(), 1);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\nursery\NurseryStation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */