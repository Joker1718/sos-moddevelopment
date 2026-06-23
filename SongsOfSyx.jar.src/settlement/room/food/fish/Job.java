/*     */ package settlement.room.food.fish;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.job.RoomResStorage;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ class Job {
/*  19 */   static final Bit isWork = new Bit(1);
/*  20 */   static final Bit isShip = new Bit(2);
/*  21 */   static final Bit reserved = new Bit(4);
/*  22 */   static final Bit used = new Bit(8);
/*  23 */   static final Bits shipDir = new Bits(240);
/*     */   
/*     */   private final ROOM_FISHERY print;
/*     */   
/*  27 */   private final Work WorkHands = new Work(false);
/*  28 */   final RoomResStorage storage = new RoomResStorage(31)
/*     */     {
/*     */       public RESOURCE resource()
/*     */       {
/*  32 */         return ((IndustryResource)Job.this.print.productionData.outs().get(0)).resource;
/*     */       }
/*     */ 
/*     */       
/*     */       protected boolean is(int tx, int ty) {
/*  37 */         return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 2);
/*     */       }
/*     */ 
/*     */       
/*     */       protected void changed(int tx, int ty) {
/*  42 */         if (hasRoom()) {
/*  43 */           FishInstance m = (FishInstance)Job.this.print.get(tx, ty);
/*  44 */           m.hasStorage = true;
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   Job(ROOM_FISHERY print) {
/*  52 */     this.print = print;
/*     */   }
/*     */ 
/*     */   
/*     */   SETT_JOB init(int tx, int ty, FishInstance ins) {
/*  57 */     if (!ins.is(tx, ty))
/*  58 */       return null; 
/*  59 */     int d = (SETT.ROOMS()).data.get(tx, ty);
/*     */     
/*  61 */     if ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 2) {
/*  62 */       return null;
/*     */     }
/*  64 */     if (isWork.is(d) || (SETT.ROOMS()).fData.tileData.get(tx, ty) == 1) {
/*  65 */       return this.WorkHands.init(tx, ty, ins);
/*     */     }
/*  67 */     return null;
/*     */   }
/*     */   
/*     */   static boolean working(int data) {
/*  71 */     return used.is(data);
/*     */   }
/*     */ 
/*     */   
/*     */   final class Work
/*     */     implements SETT_JOB
/*     */   {
/*     */     private final boolean tools;
/*     */     
/*  80 */     private final Coo coo = new Coo();
/*     */     FishInstance ins;
/*     */     int data;
/*     */     static final String name = "working";
/*  84 */     private final double wv = 60.0D; long now;
/*     */     
/*     */     Work(boolean tools) {
/*  87 */       this.tools = tools;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean jobReserveCanBe() {
/*  94 */       if (jobReservedIs(null))
/*  95 */         return false; 
/*  96 */       if (!this.ins.hasStorage)
/*  97 */         return false; 
/*  98 */       return true;
/*     */     }
/*     */     
/*     */     Work init(int tx, int ty, FishInstance ins) {
/* 102 */       this.data = (SETT.ROOMS()).data.get(tx, ty);
/* 103 */       this.coo.set(tx, ty);
/* 104 */       this.ins = ins;
/* 105 */       return this;
/*     */     }
/*     */     
/*     */     void save() {
/* 109 */       (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/*     */     }
/*     */ 
/*     */     
/*     */     public COORDINATE jobCoo() {
/* 114 */       return (COORDINATE)this.coo;
/*     */     }
/*     */ 
/*     */     
/*     */     public String jobName() {
/* 119 */       return "working";
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobUseTool() {
/* 124 */       return this.tools;
/*     */     }
/*     */ 
/*     */     
/*     */     public RBIT jobResourceBitToFetch() {
/* 129 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public double jobPerformTime(Humanoid skill) {
/* 134 */       return 60.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserve(RESOURCE r) {
/* 139 */       if (jobReservedIs(null))
/* 140 */         throw new RuntimeException(); 
/* 141 */       this.data = Job.reserved.set(this.data);
/* 142 */       save();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobReservedIs(RESOURCE r) {
/* 147 */       return Job.reserved.is(this.data);
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserveCancel(RESOURCE r) {
/* 152 */       this.data = Job.reserved.clear(this.data);
/* 153 */       this.data = Job.used.clear(this.data);
/* 154 */       save();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void jobStartPerforming() {
/* 161 */       this.now = System.currentTimeMillis();
/* 162 */       this.data = Job.used.set(this.data);
/* 163 */       save();
/*     */     }
/*     */ 
/*     */     
/*     */     public SoundRace jobSound() {
/* 168 */       return this.ins.blueprintI().employment().sound();
/*     */     }
/*     */ 
/*     */     
/*     */     public RESOURCE jobPerform(Humanoid s, RESOURCE res, int ram) {
/* 173 */       Job.this.secretPerform(s, 60.0D);
/* 174 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void secretPerform(Humanoid s, double time) {
/* 181 */     this.WorkHands.jobReserveCancel(null);
/*     */     
/* 183 */     int am = ((IndustryResource)this.print.productionData.outs().get(0)).work(s, (ROOM_IDATA_INSTANCE)this.WorkHands.ins, time);
/*     */     
/* 185 */     if (am == 0) {
/*     */       return;
/*     */     }
/* 188 */     if (!this.WorkHands.ins.hasStorage) {
/*     */       return;
/*     */     }
/* 191 */     int x1 = this.WorkHands.ins.sx;
/* 192 */     int y1 = this.WorkHands.ins.sy;
/* 193 */     RoomResStorage ss = this.storage.get(x1, y1, (ROOMA)this.WorkHands.ins);
/*     */     
/* 195 */     while (ss != null) {
/* 196 */       if (am == 0 && ss.hasRoom())
/*     */         return; 
/* 198 */       if (ss.hasRoom()) {
/* 199 */         ss.deposit();
/* 200 */         am--;
/*     */         
/*     */         continue;
/*     */       } 
/* 204 */       RoomResStorage sss = this.storage.get(ss.x() + 1, ss.y(), (ROOMA)this.WorkHands.ins);
/* 205 */       if (sss == null)
/* 206 */         sss = this.storage.get(x1, ss.y() + 1, (ROOMA)this.WorkHands.ins); 
/* 207 */       ss = sss;
/*     */     } 
/* 209 */     ((IndustryResource)this.print.productionData.outs().get(0)).inc((ROOM_IDATA_INSTANCE)this.WorkHands.ins, -am);
/* 210 */     this.WorkHands.ins.hasStorage = false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\fish\Job.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */