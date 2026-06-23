/*     */ package settlement.room.health.physician;
/*     */ 
/*     */ import game.audio.SoundRace;
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
/*     */ final class Service {
/*  17 */   private final Coo coo = new Coo();
/*     */ 
/*     */   
/*  20 */   private final RoomBits s_worked = new RoomBits((COORDINATE)this.coo, 1);
/*  21 */   private final Bit s_reservable = new Bit((COORDINATE)this.coo, 2);
/*  22 */   private final Bit s_reserved = new Bit((COORDINATE)this.coo, 4);
/*  23 */   private final RoomBits s_worked_amount = new RoomBits((COORDINATE)this.coo, 240);
/*     */   
/*     */   private final ROOM_PHYSICIAN b;
/*     */   
/*     */   private Instance ins;
/*     */   
/*     */   private final FSERVICE service;
/*     */   private final SETT_JOB jo;
/*     */   
/*     */   FSERVICE getS(int tx, int ty) {
/*  33 */     this.ins = (Instance)this.b.get(tx, ty);
/*  34 */     if (this.ins != null && (SETT.ROOMS()).fData.tileData.get(tx, ty) == 3) {
/*  35 */       this.coo.set(tx, ty);
/*  36 */       return this.service;
/*     */     } 
/*  38 */     return null;
/*     */   }
/*     */   
/*     */   void dispose(Instance ins, int tx, int ty) {
/*  42 */     if (getS(tx, ty) != null)
/*  43 */       this.s_worked.set((ROOMA)ins, 0); 
/*     */   }
/*     */   
/*     */   SETT_JOB getJ(int tx, int ty) {
/*  47 */     this.ins = (Instance)this.b.get(tx, ty);
/*  48 */     if (this.ins != null && (SETT.ROOMS()).fData.tileData.get(tx, ty) != 0) {
/*  49 */       this.coo.set(tx, ty);
/*  50 */       return this.jo;
/*     */     } 
/*  52 */     return null;
/*     */   }
/*     */   Service(ROOM_PHYSICIAN b) {
/*  55 */     this.service = new FSERVICE()
/*     */       {
/*     */         public boolean findableReservedCanBe()
/*     */         {
/*  59 */           return (Service.this.s_reservable.get() == 1 && Service.this.s_reserved.get() == 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserve() {
/*  64 */           Service.this.ins.jobs.searchAgain();
/*  65 */           Service.this.s_reserved.set((ROOMA)Service.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedIs() {
/*  70 */           return (Service.this.s_reserved.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserveCancel() {
/*  75 */           Service.this.s_reserved.set((ROOMA)Service.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public int x() {
/*  80 */           return Service.this.coo.x();
/*     */         }
/*     */ 
/*     */         
/*     */         public int y() {
/*  85 */           return Service.this.coo.y();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void startUsing() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public void consume() {
/*  95 */           Service.this.s_worked_amount.inc((ROOMA)Service.this.ins, -1);
/*  96 */           Service.this.s_reservable.set((ROOMA)Service.this.ins, (Service.this.s_worked_amount.get() > 0) ? 1 : 0);
/*  97 */           Service.this.s_reserved.set((ROOMA)Service.this.ins, 0);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 102 */     this.jo = new SETT_JOB()
/*     */       {
/*     */         public boolean jobUseTool()
/*     */         {
/* 106 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobUseHands() {
/* 111 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 121 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 126 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 131 */           return (Service.this.s_worked.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 136 */           Service.this.s_worked.set((ROOMA)Service.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 141 */           return ((Service.this.s_worked_amount.get() < 7 || Service.this.s_reservable.get() == 0 || Service.this.s_reserved.get() == 1) && !jobReservedIs(null));
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/* 146 */           Service.this.s_worked.set((ROOMA)Service.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid a) {
/* 151 */           return 20.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 156 */           Service.this.s_worked.set((ROOMA)Service.this.ins, 0);
/* 157 */           Service.this.s_worked_amount.inc((ROOMA)Service.this.ins, 1);
/* 158 */           Service.this.s_reservable.set((ROOMA)Service.this.ins, 1);
/* 159 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 165 */           return (Service.this.b.employment()).verb;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 170 */           return (COORDINATE)Service.this.coo;
/*     */         }
/*     */       };
/*     */     this.b = b;
/*     */   }
/*     */   
/*     */   private class Bit extends RoomBits { public Bit(COORDINATE coo, int mask) {
/* 177 */       super(coo, mask);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void set(ROOMA r, int t) {
/* 183 */       Service.this.ins.service.report(Service.this.service, (RoomService)(Service.this.ins.blueprintI()).data, -1);
/* 184 */       super.set(r, t);
/* 185 */       Service.this.ins.service.report(Service.this.service, (RoomService)(Service.this.ins.blueprintI()).data, 1);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\physician\Service.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */