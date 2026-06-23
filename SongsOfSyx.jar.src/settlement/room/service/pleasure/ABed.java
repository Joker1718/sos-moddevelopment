/*     */ package settlement.room.service.pleasure;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import game.time.TIME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ABed
/*     */ {
/*     */   private static final int UNAVAILABLE = 0;
/*     */   private static final int AVAILABLE = 1;
/*     */   private static final int RESERVED = 2;
/*  24 */   private final Coo coo = new Coo();
/*  25 */   private final RoomBits state = new RoomBits((COORDINATE)this.coo, 15)
/*     */     {
/*     */       public void set(ROOMA r, int t)
/*     */       {
/*  29 */         if (ABed.this.state.get() == 1) {
/*  30 */           ABed.this.ins.service.report(ABed.this.service, (RoomService)ABed.this.blue.service, -1);
/*     */         }
/*  32 */         super.set(r, t);
/*  33 */         if (ABed.this.state.get() == 1)
/*  34 */           ABed.this.ins.service.report(ABed.this.service, (RoomService)ABed.this.blue.service, 1); 
/*  35 */         ABed.this.wdata.set(r, 0);
/*     */       }
/*     */     };
/*     */   
/*  39 */   private final RoomBits worked = new RoomBits((COORDINATE)this.coo, 16);
/*  40 */   private final RoomBits workedHasBeen = new RoomBits((COORDINATE)this.coo, 32);
/*     */   
/*  42 */   private final RoomBits clientReady = new RoomBits((COORDINATE)this.coo, 256);
/*  43 */   public final RoomBits clientUndressed = new RoomBits((COORDINATE)this.coo, 512);
/*  44 */   private final RoomBits workerReady = new RoomBits((COORDINATE)this.coo, 1024);
/*  45 */   private final RoomBits workerUndressed = new RoomBits((COORDINATE)this.coo, 2048);
/*  46 */   private final RoomBits wdata = new RoomBits((COORDINATE)this.coo, 3840);
/*     */   
/*     */   private PleasureInstance ins;
/*     */   
/*     */   private final ROOM_PLEASURE blue;
/*     */   
/*     */   public final FSERVICE service;
/*     */   
/*     */   final SETT_JOB job;
/*     */   
/*     */   public ABed init(int tx, int ty) {
/*  57 */     if (this.blue.is(tx, ty) && 
/*  58 */       (SETT.ROOMS()).fData.tileData.is(tx, ty, 2)) {
/*  59 */       this.coo.set(tx, ty);
/*  60 */       this.ins = (PleasureInstance)this.blue.get(tx, ty);
/*  61 */       return this;
/*     */     } 
/*     */     
/*  64 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean clientShouldUndress() {
/*  69 */     this.clientReady.set((ROOMA)this.ins, 1);
/*  70 */     if (this.workerUndressed.get() == 1) {
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public void clientUndress() {
/*  77 */     this.clientReady.set((ROOMA)this.ins, 1);
/*  78 */     this.clientUndressed.set((ROOMA)this.ins, 1);
/*     */   }
/*     */   
/*     */   public boolean workerReadyShouldUndress() {
/*  82 */     this.workerReady.set((ROOMA)this.ins, 1);
/*  83 */     if (this.clientReady.get() == 1) {
/*  84 */       this.workerUndressed.set((ROOMA)this.ins, 1);
/*  85 */       return true;
/*     */     } 
/*  87 */     return false;
/*     */   }
/*     */   ABed(ROOM_PLEASURE blue) {
/*  90 */     this.service = new FSERVICE()
/*     */       {
/*     */         public void consume()
/*     */         {
/*  94 */           if (ABed.this.state.get() != 2)
/*  95 */             throw new RuntimeException(); 
/*  96 */           if (ABed.this.worked.get() == 1 || ABed.this.workedHasBeen.get() == 1) {
/*  97 */             ABed.this.state.set((ROOMA)ABed.this.ins, 1);
/*  98 */             ABed.this.workedHasBeen.set((ROOMA)ABed.this.ins, 0);
/*     */           } else {
/* 100 */             ABed.this.state.set((ROOMA)ABed.this.ins, 0);
/*     */           } 
/*     */         }
/*     */         
/*     */         public int x() {
/* 105 */           return ABed.this.coo.x();
/*     */         }
/*     */ 
/*     */         
/*     */         public int y() {
/* 110 */           return ABed.this.coo.y();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedCanBe() {
/* 115 */           return (ABed.this.state.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserve() {
/* 120 */           if (ABed.this.state.get() != 1)
/* 121 */             throw new RuntimeException(); 
/* 122 */           ABed.this.state.set((ROOMA)ABed.this.ins, 2);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean findableReservedIs() {
/* 128 */           return (ABed.this.state.get() == 2);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void startUsing() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public void findableReserveCancel() {
/* 138 */           if (ABed.this.state.get() == 2) {
/* 139 */             ABed.this.state.set((ROOMA)ABed.this.ins, 1);
/*     */           }
/*     */         }
/*     */       };
/* 143 */     this.job = new SETT_JOB()
/*     */       {
/* 145 */         private int ws = (int)(TIME.workSeconds() / 10.0D);
/*     */         
/*     */         public boolean jobUseTool() {
/* 148 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 158 */           return ABed.this.ins.blueprintI().employment().sound();
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 163 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 168 */           return (ABed.this.worked.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 173 */           if (jobReservedIs(r)) {
/* 174 */             ABed.this.worked.set((ROOMA)ABed.this.ins, 0);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 180 */           return !jobReservedIs(null);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/* 185 */           if (!jobReserveCanBe())
/* 186 */             throw new RuntimeException(); 
/* 187 */           ABed.this.worked.set((ROOMA)ABed.this.ins, 1);
/* 188 */           if (ABed.this.state.get() == 0) {
/* 189 */             ABed.this.state.set((ROOMA)ABed.this.ins, 1);
/*     */           }
/*     */         }
/*     */         
/*     */         public double jobPerformTime(Humanoid skill) {
/* 194 */           return this.ws;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 200 */           if (!jobReservedIs(r))
/* 201 */             throw new RuntimeException(); 
/* 202 */           ABed.this.worked.set((ROOMA)ABed.this.ins, 0);
/* 203 */           if (ABed.this.state.get() == 0) {
/* 204 */             ABed.this.state.set((ROOMA)ABed.this.ins, 1);
/*     */           } else {
/* 206 */             ABed.this.workedHasBeen.set((ROOMA)ABed.this.ins, 1);
/* 207 */           }  return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 212 */           return (ABed.this.blue.employment()).verb;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 217 */           return (COORDINATE)ABed.this.coo;
/*     */         }
/*     */       };
/*     */     this.blue = blue;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\pleasure\ABed.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */