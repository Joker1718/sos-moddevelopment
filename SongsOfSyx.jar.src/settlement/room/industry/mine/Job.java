/*     */ package settlement.room.industry.mine;
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
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ class Job {
/*  18 */   static final Bit isWork = new Bit(1);
/*  19 */   private static final Bit reserved = new Bit(2);
/*  20 */   private static final Bit used = new Bit(4);
/*     */   
/*     */   private final ROOM_MINE print;
/*  23 */   private final Work WorkHands = new Work(false);
/*  24 */   private final Work WorkTools = new Work(true);
/*     */   final RoomResStorage storage;
/*     */   
/*     */   Job(final ROOM_MINE print, int stor) {
/*  28 */     this.print = print;
/*  29 */     this.storage = new RoomResStorage(stor)
/*     */       {
/*     */         public RESOURCE resource()
/*     */         {
/*  33 */           return print.minable.resource;
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean is(int tx, int ty) {
/*  38 */           return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 2);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void changed(int tx, int ty) {
/*  43 */           if (hasRoom()) {
/*  44 */             MineInstance m = (MineInstance)print.get(tx, ty);
/*  45 */             m.hasStorage = true;
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SETT_JOB init(int tx, int ty, MineInstance ins) {
/*  55 */     if (!ins.is(tx, ty))
/*  56 */       return null; 
/*  57 */     int d = (SETT.ROOMS()).data.get(tx, ty);
/*  58 */     if (isWork.is(d) && (SETT.MINERALS()).getter.is(tx, ty, this.print.minable))
/*  59 */       return this.WorkTools.init(tx, ty, ins); 
/*  60 */     if ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 1) {
/*  61 */       return this.WorkHands.init(tx, ty, ins);
/*     */     }
/*  63 */     return null;
/*     */   }
/*     */   
/*     */   static boolean working(int data) {
/*  67 */     return used.is(data);
/*     */   }
/*     */ 
/*     */   
/*     */   final class Work
/*     */     implements SETT_JOB
/*     */   {
/*     */     private final boolean tools;
/*     */     
/*  76 */     private final Coo coo = new Coo();
/*     */     MineInstance ins;
/*     */     int data;
/*     */     static final String name = "working";
/*  80 */     private final double wv = 45.0D;
/*     */     
/*     */     Work(boolean tools) {
/*  83 */       this.tools = tools;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean jobReserveCanBe() {
/*  90 */       if (jobReservedIs(null))
/*  91 */         return false; 
/*  92 */       if (!this.ins.hasStorage)
/*  93 */         return false; 
/*  94 */       return true;
/*     */     }
/*     */     
/*     */     Work init(int tx, int ty, MineInstance ins) {
/*  98 */       this.data = (SETT.ROOMS()).data.get(tx, ty);
/*  99 */       this.coo.set(tx, ty);
/* 100 */       this.ins = ins;
/* 101 */       return this;
/*     */     }
/*     */     
/*     */     void save() {
/* 105 */       int d = (SETT.ROOMS()).data.get((COORDINATE)this.coo);
/* 106 */       if (Job.used.is(d)) {
/* 107 */         this.ins.workage--;
/*     */       }
/* 109 */       (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, this.data);
/* 110 */       if (Job.used.is(this.data)) {
/* 111 */         this.ins.workage++;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public COORDINATE jobCoo() {
/* 117 */       return (COORDINATE)this.coo;
/*     */     }
/*     */ 
/*     */     
/*     */     public String jobName() {
/* 122 */       return "working";
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobUseTool() {
/* 127 */       return this.tools;
/*     */     }
/*     */ 
/*     */     
/*     */     public RBIT jobResourceBitToFetch() {
/* 132 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public double jobPerformTime(Humanoid skill) {
/* 137 */       return 45.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserve(RESOURCE r) {
/* 142 */       if (jobReservedIs(null))
/* 143 */         throw new RuntimeException(); 
/* 144 */       this.data = Job.reserved.set(this.data);
/* 145 */       save();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobReservedIs(RESOURCE r) {
/* 150 */       return Job.reserved.is(this.data);
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserveCancel(RESOURCE r) {
/* 155 */       this.data = Job.reserved.clear(this.data);
/* 156 */       this.data = Job.used.clear(this.data);
/* 157 */       save();
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobStartPerforming() {
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
/*     */     
/*     */     public RESOURCE jobPerform(Humanoid s, RESOURCE res, int ram) {
/* 174 */       jobReserveCancel(null);
/* 175 */       if (!this.ins.hasStorage)
/* 176 */         return null; 
/* 177 */       int am = ((IndustryResource)Job.this.print.productionData.outs().get(0)).work(s, (ROOM_IDATA_INSTANCE)this.ins, 45.0D);
/*     */       
/* 179 */       if (am == 0) {
/* 180 */         return null;
/*     */       }
/*     */ 
/*     */       
/* 184 */       int x1 = this.ins.sx;
/* 185 */       int y1 = this.ins.sy;
/* 186 */       RoomResStorage ss = Job.this.storage.get(x1, y1, (ROOMA)this.ins);
/*     */       
/* 188 */       while (ss != null) {
/* 189 */         if (am == 0 && ss.hasRoom())
/* 190 */           return null; 
/* 191 */         if (ss.hasRoom()) {
/* 192 */           ss.deposit();
/* 193 */           am--;
/*     */           
/*     */           continue;
/*     */         } 
/* 197 */         RoomResStorage sss = Job.this.storage.get(ss.x() + 1, ss.y(), (ROOMA)this.ins);
/* 198 */         if (sss == null)
/* 199 */           sss = Job.this.storage.get(x1, ss.y() + 1, (ROOMA)this.ins); 
/* 200 */         ss = sss;
/*     */       } 
/* 202 */       ((IndustryResource)Job.this.print.productionData.outs().get(0)).inc((ROOM_IDATA_INSTANCE)this.ins, -am);
/* 203 */       this.ins.hasStorage = false;
/*     */ 
/*     */       
/* 206 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\mine\Job.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */