/*     */ package settlement.room.industry.woodcutter;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import game.time.TIME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.job.RoomResStorage;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import util.GUTIL;
/*     */ 
/*     */ class Job
/*     */ {
/*     */   private final ROOM_WOODCUTTER print;
/*  22 */   private final Coo jobCoo = new Coo();
/*     */   private Instance ins;
/*  24 */   private final RoomBits is = new RoomBits((COORDINATE)this.jobCoo, 1);
/*  25 */   private final RoomBits reserved = new RoomBits((COORDINATE)this.jobCoo, 2);
/*  26 */   private final RoomBits used = new RoomBits((COORDINATE)this.jobCoo, 4)
/*     */     {
/*     */       public void set(ROOMA r, int t)
/*     */       {
/*  30 */         Job.this.ins.workage -= get();
/*  31 */         super.set(r, t);
/*  32 */         Job.this.ins.workage += get();
/*     */       }
/*     */     };
/*     */   
/*  36 */   private final RoomBits chopped = new RoomBits((COORDINATE)this.jobCoo, -16);
/*     */ 
/*     */   
/*  39 */   private final double wv = 60.0D;
/*  40 */   private final int workPerDay = (int)Math.ceil(TIME.workSeconds() / 60.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final RoomResStorage storage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final SETT_JOB work;
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
/*     */   SETT_JOB init(int tx, int ty, Instance ins) {
/*  72 */     if (!ins.is(tx, ty))
/*  73 */       return null; 
/*  74 */     this.jobCoo.set(tx, ty);
/*  75 */     this.ins = ins;
/*  76 */     if (this.is.get() == 0) {
/*  77 */       return null;
/*     */     }
/*  79 */     return this.work;
/*     */   }
/*     */ 
/*     */   
/*     */   void mark(int tx, int ty, Instance ins) {
/*  84 */     this.jobCoo.set(tx, ty);
/*  85 */     this.ins = ins;
/*  86 */     this.is.set((ROOMA)ins, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void update(int tx, int ty, Instance ins) {
/*  92 */     this.jobCoo.set(tx, ty);
/*  93 */     if (this.is.get() == 0)
/*     */       return; 
/*  95 */     if ((SETT.ROOMS()).fData.item.get(tx, ty) != null)
/*     */       return; 
/*  97 */     if ((SETT.ROOMS()).fData.tileData.get((COORDINATE)this.jobCoo) == 1)
/*     */       return; 
/*  99 */     if ((SETT.ROOMS()).fData.tileData.get((COORDINATE)this.jobCoo) == 2)
/*     */       return; 
/* 101 */     if (this.chopped.get() == 0) {
/* 102 */       this.chopped.inc((ROOMA)ins, 1);
/*     */       
/*     */       return;
/*     */     } 
/* 106 */     double d = ins.irri - (GUTIL.ran2().get(tx, ty) % 255) / 255.0D;
/* 107 */     if (d > 0.0D) {
/* 108 */       if ((SETT.TERRAIN()).TREES.isTree(this.jobCoo.x(), this.jobCoo.y())) {
/* 109 */         (SETT.TERRAIN()).TREES.amount.increment(tx, ty, 1);
/* 110 */       } else if ((SETT.TERRAIN()).BUSH.is((COORDINATE)this.jobCoo)) {
/* 111 */         (SETT.TERRAIN()).TREES.SMALL.placeRaw(tx, ty);
/* 112 */         (SETT.TERRAIN()).TREES.amount.set(tx, ty, 1);
/*     */       } else {
/* 114 */         (SETT.TERRAIN()).BUSH.placeFixed(tx, ty);
/*     */       }
/*     */     
/* 117 */     } else if ((SETT.TERRAIN()).TREES.isTree(this.jobCoo.x(), this.jobCoo.y())) {
/* 118 */       (SETT.TERRAIN()).BUSH.placeFixed(tx, ty);
/* 119 */     } else if ((SETT.TERRAIN()).BUSH.is((COORDINATE)this.jobCoo)) {
/* 120 */       (SETT.TERRAIN()).NADA.placeRaw(tx, ty);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isTreeCurrent(int tx, int ty) {
/* 127 */     return !(!(SETT.TERRAIN()).TREES.isTree(tx, ty) && !(SETT.TERRAIN()).BUSH.is(tx, ty));
/*     */   }
/*     */   
/*     */   static boolean working(int data) {
/* 131 */     return ((data & 0x2) != 0);
/*     */   }
/*     */   Job(final ROOM_WOODCUTTER print, int store) {
/* 134 */     this.work = new SETT_JOB()
/*     */       {
/*     */         public boolean jobReserveCanBe()
/*     */         {
/* 138 */           if (jobReservedIs(null))
/* 139 */             return false; 
/* 140 */           if (!Job.this.ins.hasStorage)
/* 141 */             return false; 
/* 142 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 147 */           return (COORDINATE)Job.this.jobCoo;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 152 */           return (Job.this.print.employment()).verb;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobUseTool() {
/* 157 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 162 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid skill) {
/* 167 */           return 60.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/* 172 */           if (jobReservedIs(null))
/* 173 */             throw new RuntimeException(); 
/* 174 */           Job.this.reserved.set((ROOMA)Job.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 179 */           return (Job.this.reserved.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 184 */           Job.this.reserved.set((ROOMA)Job.this.ins, 0);
/* 185 */           Job.this.used.set((ROOMA)Job.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {
/* 190 */           Job.this.used.set((ROOMA)Job.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 195 */           return Job.this.ins.blueprintI().employment().sound();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid s, RESOURCE res, int ram) {
/* 201 */           jobReserveCancel(null);
/*     */           
/* 203 */           Job.this.chopped.inc((ROOMA)Job.this.ins, 1);
/* 204 */           if (Job.this.chopped.get() > Job.this.workPerDay && (SETT.ROOMS()).fData.tileData.get((COORDINATE)Job.this.jobCoo) != 1) {
/* 205 */             (SETT.TERRAIN()).DECOR_WOOD.placeFixed(Job.this.jobCoo.x(), Job.this.jobCoo.y());
/* 206 */             Job.this.chopped.set((ROOMA)Job.this.ins, 0);
/*     */           } 
/*     */           
/* 209 */           int am = ((IndustryResource)Job.this.print.productionData.outs().get(0)).work(s, (ROOM_IDATA_INSTANCE)Job.this.ins, 60.0D);
/*     */           
/* 211 */           if (am == 0) {
/* 212 */             return null;
/*     */           }
/* 214 */           if (!Job.this.ins.hasStorage) {
/* 215 */             return null;
/*     */           }
/* 217 */           int x1 = Job.this.ins.sx;
/* 218 */           int y1 = Job.this.ins.sy;
/* 219 */           RoomResStorage ss = Job.this.storage.get(x1, y1, (ROOMA)Job.this.ins);
/*     */           
/* 221 */           while (ss != null) {
/* 222 */             if (am == 0 && ss.hasRoom())
/* 223 */               return null; 
/* 224 */             if (ss.hasRoom()) {
/* 225 */               ss.deposit();
/* 226 */               am--;
/*     */               
/*     */               continue;
/*     */             } 
/* 230 */             RoomResStorage sss = Job.this.storage.get(ss.x() + 1, ss.y(), (ROOMA)Job.this.ins);
/* 231 */             if (sss == null)
/* 232 */               sss = Job.this.storage.get(x1, ss.y() + 1, (ROOMA)Job.this.ins); 
/* 233 */             ss = sss;
/*     */           } 
/*     */           
/* 236 */           ((IndustryResource)Job.this.print.productionData.outs().get(0)).inc((ROOM_IDATA_INSTANCE)Job.this.ins, -am);
/*     */           
/* 238 */           Job.this.ins.hasStorage = false;
/*     */ 
/*     */           
/* 241 */           return null;
/*     */         }
/*     */       };
/*     */     this.print = print;
/*     */     this.storage = new RoomResStorage(store) {
/*     */         public RESOURCE resource() {
/*     */           return ((IndustryResource)print.productionData.outs().get(0)).resource;
/*     */         }
/*     */         
/*     */         protected boolean is(int tx, int ty) {
/*     */           return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 2);
/*     */         }
/*     */         
/*     */         protected void changed(int tx, int ty) {
/*     */           if (hasRoom()) {
/*     */             Instance m = (Instance)print.get(tx, ty);
/*     */             m.hasStorage = true;
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\woodcutter\Job.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */