/*     */ package settlement.room.service.barber;
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
/*     */ final class Tile {
/*  17 */   private final Coo coo = new Coo();
/*     */   
/*     */   private Instance ins;
/*     */   
/*     */   private final ROOM_BARBER blue;
/*     */   private final int workTime;
/*  23 */   final RoomBits bWorked = new RoomBits((COORDINATE)this.coo, 15);
/*  24 */   final RoomBits bUses = new RoomBits((COORDINATE)this.coo, 112)
/*     */     {
/*     */       protected void remove()
/*     */       {
/*  28 */         Tile.this.ins.service.report(Tile.this.service, (RoomService)(Tile.this.ins.blueprintI()).data, -1);
/*     */       }
/*     */ 
/*     */       
/*     */       protected void add() {
/*  33 */         Tile.this.ins.service.report(Tile.this.service, (RoomService)(Tile.this.ins.blueprintI()).data, 1);
/*     */       }
/*     */     };
/*     */   
/*  37 */   final RoomBits bWReserved = new RoomBits((COORDINATE)this.coo, 256);
/*  38 */   final RoomBits bSReserved = new RoomBits((COORDINATE)this.coo, 512)
/*     */     {
/*     */       protected void remove()
/*     */       {
/*  42 */         Tile.this.ins.service.report(Tile.this.service, (RoomService)(Tile.this.ins.blueprintI()).data, -1);
/*     */       }
/*     */ 
/*     */       
/*     */       protected void add() {
/*  47 */         Tile.this.ins.service.report(Tile.this.service, (RoomService)(Tile.this.ins.blueprintI()).data, 1);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   final SETT_JOB job;
/*     */   
/*     */   private final FSERVICE service;
/*     */ 
/*     */   
/*     */   public SETT_JOB job(int tx, int ty) {
/*  59 */     if (init(tx, ty))
/*  60 */       return this.job; 
/*  61 */     return null;
/*     */   }
/*     */   
/*     */   public FSERVICE service(int tx, int ty) {
/*  65 */     if (init(tx, ty))
/*  66 */       return this.service; 
/*  67 */     return null;
/*     */   }
/*     */   
/*     */   private boolean init(int tx, int ty) {
/*  71 */     this.ins = (Instance)this.blue.getter.get(tx, ty);
/*     */     
/*  73 */     if (this.ins != null && (SETT.ROOMS()).fData.tileData.get(tx, ty) == 1) {
/*  74 */       this.coo.set(tx, ty);
/*  75 */       return true;
/*     */     } 
/*  77 */     return false;
/*     */   }
/*     */   Tile(ROOM_BARBER blue, int workTime) {
/*  80 */     this.job = new SETT_JOB() {
/*     */         private static final String name = "setting table";
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/*  84 */           if (!jobReserveCanBe())
/*  85 */             throw new RuntimeException(); 
/*  86 */           Tile.this.bWReserved.set((ROOMA)Tile.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/*  91 */           return (Tile.this.bWReserved.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/*  96 */           Tile.this.bWReserved.set((ROOMA)Tile.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 101 */           return (Tile.this.bWReserved.get() == 0 && (Tile.this.bUses.get() < Tile.this.bUses.max() || Tile.this.bWorked.get() < Tile.this.bWorked.max()));
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 106 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid skill) {
/* 111 */           return Tile.this.workTime;
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE res, int ram) {
/* 116 */           if (!jobReservedIs(res))
/* 117 */             throw new RuntimeException(); 
/* 118 */           Tile.this.bWReserved.set((ROOMA)Tile.this.ins, 0);
/* 119 */           if (Tile.this.bWorked.get() == Tile.this.bWorked.max()) {
/* 120 */             Tile.this.bUses.inc((ROOMA)Tile.this.ins, 1);
/* 121 */             Tile.this.bWorked.set((ROOMA)Tile.this.ins, 0);
/*     */           } else {
/* 123 */             Tile.this.bWorked.inc((ROOMA)Tile.this.ins, 1);
/*     */           } 
/* 125 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 130 */           return (COORDINATE)Tile.this.coo;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public String jobName() {
/* 137 */           return "setting table";
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean jobUseTool() {
/* 148 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 153 */           return Tile.this.blue.employment().sound();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobUseHands() {
/* 158 */           return true;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 164 */     this.service = new FSERVICE()
/*     */       {
/*     */         public int y()
/*     */         {
/* 168 */           return Tile.this.coo.y();
/*     */         }
/*     */ 
/*     */         
/*     */         public int x() {
/* 173 */           return Tile.this.coo.x();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedIs() {
/* 178 */           return (Tile.this.bSReserved.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean findableReservedCanBe() {
/* 183 */           return (Tile.this.bSReserved.get() == 0 && Tile.this.bUses.get() > 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserveCancel() {
/* 188 */           Tile.this.bSReserved.set((ROOMA)Tile.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public void findableReserve() {
/* 193 */           Tile.this.bSReserved.set((ROOMA)Tile.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void consume() {
/* 198 */           Tile.this.bSReserved.set((ROOMA)Tile.this.ins, 0);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void startUsing() {
/* 207 */           Tile.this.bUses.inc((ROOMA)Tile.this.ins, -1);
/*     */         }
/*     */       };
/*     */     int t = workTime / 16;
/*     */     this.workTime = t;
/*     */     this.blue = blue;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\barber\Tile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */