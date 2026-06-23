/*     */ package settlement.room.knowledge.school;
/*     */ import game.audio.SoundRace;
/*     */ import game.time.TIME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ final class SchoolStation {
/*     */   private SchoolInstance ins;
/*  21 */   private final Work work = new Work(); private final ROOM_SCHOOL b;
/*  22 */   private final Service service = new Service();
/*     */   
/*     */   SchoolStation(ROOM_SCHOOL b) {
/*  25 */     this.b = b;
/*     */   }
/*     */   
/*     */   FSERVICE service(int tx, int ty) {
/*  29 */     if (this.b.is(tx, ty)) {
/*  30 */       int i = (SETT.ROOMS()).fData.tileData.get(tx, ty);
/*  31 */       if (i == 1) {
/*  32 */         this.ins = (SchoolInstance)this.b.get(tx, ty);
/*  33 */         this.service.data = (SETT.ROOMS()).data.get(tx, ty);
/*  34 */         this.service.x = tx;
/*  35 */         this.service.y = ty;
/*  36 */         for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*  37 */           int dx = ((DIR)DIR.ORTHO.get(di)).x() + tx;
/*  38 */           int dy = ((DIR)DIR.ORTHO.get(di)).y() + ty;
/*  39 */           if (this.ins.is(dx, dy) && (SETT.ROOMS()).fData.tileData.get(dx, dy) == 2) {
/*  40 */             this.work.coo.set(dx, dy);
/*  41 */             this.work.data = (SETT.ROOMS()).data.get(dx, dy);
/*  42 */             return this.service;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  48 */     return null;
/*     */   }
/*     */   
/*     */   DIR serviceDir(int tx, int ty) {
/*  52 */     if (this.b.is(tx, ty)) {
/*  53 */       int i = (SETT.ROOMS()).fData.tileData.get(tx, ty);
/*  54 */       if (i == 1) {
/*  55 */         this.ins = (SchoolInstance)this.b.get(tx, ty);
/*  56 */         for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*  57 */           int dx = ((DIR)DIR.ORTHO.get(di)).x() + tx;
/*  58 */           int dy = ((DIR)DIR.ORTHO.get(di)).y() + ty;
/*  59 */           if (this.ins.is(dx, dy) && (SETT.ROOMS()).fData.tileData.get(dx, dy) == 2) {
/*  60 */             return (DIR)DIR.ORTHO.get(di);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  66 */     return null;
/*     */   }
/*     */   
/*     */   SETT_JOB job(int tx, int ty) {
/*  70 */     if (this.b.is(tx, ty)) {
/*  71 */       int i = (SETT.ROOMS()).fData.tileData.get(tx, ty);
/*  72 */       if (i == 2) {
/*  73 */         this.ins = (SchoolInstance)this.b.get(tx, ty);
/*  74 */         this.work.data = (SETT.ROOMS()).data.get(tx, ty);
/*  75 */         this.work.coo.set(tx, ty);
/*  76 */         for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*  77 */           int dx = ((DIR)DIR.ORTHO.get(di)).x() + tx;
/*  78 */           int dy = ((DIR)DIR.ORTHO.get(di)).y() + ty;
/*  79 */           if (this.ins.is(dx, dy) && (SETT.ROOMS()).fData.tileData.get(dx, dy) == 1) {
/*  80 */             this.service.x = dx;
/*  81 */             this.service.y = dy;
/*  82 */             this.service.data = (SETT.ROOMS()).data.get(dx, dy);
/*  83 */             return this.work;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  89 */     return null;
/*     */   }
/*     */   
/*     */   void dispose(int tx, int ty) {
/*  93 */     if (job(tx, ty) == null)
/*     */       return; 
/*  95 */     if (this.service.findableReservedCanBe())
/*  96 */       this.service.findableReserve(); 
/*  97 */     if (this.work.paper.get(this.work.data) > 0)
/*  98 */       (SETT.THINGS()).resources.create(this.work.jobCoo(), ((IndustryResource)this.b.industry.ins().get(0)).resource, this.work.paper.get(this.work.data)); 
/*     */   }
/*     */   
/*     */   final class Work
/*     */     implements SETT_JOB {
/* 103 */     private final Bit reserved = new Bit(1);
/* 104 */     private final Bits dones = new Bits(6);
/* 105 */     private final Bits paper = new Bits(240);
/* 106 */     private final Bits fetchFree = new Bits(256);
/* 107 */     private final Coo coo = new Coo();
/*     */     
/*     */     private int data;
/* 110 */     private int wt = (int)(TIME.workSeconds() / 40.0D);
/*     */ 
/*     */     
/*     */     public void jobReserve(RESOURCE r) {
/* 114 */       if (!jobReserveCanBe())
/* 115 */         throw new RuntimeException(); 
/* 116 */       this.data = this.reserved.set(this.data);
/* 117 */       save();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobReservedIs(RESOURCE r) {
/* 122 */       return this.reserved.is(this.data);
/*     */     }
/*     */ 
/*     */     
/*     */     public void jobReserveCancel(RESOURCE r) {
/* 127 */       this.data = this.reserved.clear(this.data);
/* 128 */       save();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean jobReserveCanBe() {
/* 134 */       if (this.reserved.is(this.data))
/* 135 */         return false; 
/* 136 */       if (this.dones.get(this.data) < 3) {
/* 137 */         return true;
/*     */       }
/* 139 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public RBIT jobResourceBitToFetch() {
/* 144 */       if (this.paper.get(this.data) < 1)
/* 145 */         return ((IndustryResource)SchoolStation.this.b.industry.ins().get(0)).resource.bit; 
/* 146 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public double jobPerformTime(Humanoid skill) {
/* 151 */       if (this.fetchFree.get(this.data) == 1)
/* 152 */         return 0.0D; 
/* 153 */       return this.wt;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/* 163 */       if (r == ((IndustryResource)SchoolStation.this.b.industry.ins().get(0)).resource) {
/* 164 */         this.data = this.paper.inc(this.data, ram);
/*     */       } else {
/* 166 */         this.data = this.dones.inc(this.data, 1);
/* 167 */         this.data = this.fetchFree.set(this.data, 0);
/* 168 */         SchoolStation.this.service.setReserveable();
/*     */       } 
/*     */       
/* 171 */       if (this.fetchFree.get(this.data) == 0 && SchoolStation.this.ins.employees().fetchBonusConsume(this.wt)) {
/* 172 */         this.data = this.fetchFree.set(this.data, 1);
/*     */       }
/*     */       
/* 175 */       jobReserveCancel(r);
/* 176 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public int jobResourcesNeeded(Humanoid skill) {
/* 181 */       return this.paper.mask;
/*     */     }
/*     */ 
/*     */     
/*     */     public COORDINATE jobCoo() {
/* 186 */       return (COORDINATE)this.coo;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence jobName() {
/* 191 */       return (SchoolStation.this.b.employment()).verb;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean jobUseTool() {
/* 196 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public SoundRace jobSound() {
/* 201 */       return SchoolStation.this.b.employment().sound();
/*     */     }
/*     */     
/*     */     private void save() {
/* 205 */       int c = this.data;
/* 206 */       this.data = (SETT.ROOMS()).data.get((COORDINATE)this.coo);
/*     */       
/* 208 */       this.data = c;
/*     */       
/* 210 */       (SETT.ROOMS()).data.set((ROOMA)SchoolStation.this.ins, (COORDINATE)this.coo, this.data);
/*     */     }
/*     */     
/*     */     void consume(boolean day) {
/* 214 */       this.data = this.dones.inc(this.data, -1);
/* 215 */       if (day) {
/* 216 */         int p = ((IndustryResource)SchoolStation.this.b.industry.ins().get(0)).incDay((ROOM_IDATA_INSTANCE)SchoolStation.this.ins);
/* 217 */         if (p > 0) {
/* 218 */           this.data = this.paper.inc(this.data, -p);
/*     */         }
/*     */       } 
/* 221 */       save();
/* 222 */       SchoolStation.this.ins.jobs.searchAgain();
/*     */     }
/*     */   }
/*     */   
/*     */   final class Service
/*     */     implements FSERVICE
/*     */   {
/*     */     int x;
/*     */     int y;
/*     */     int data;
/* 232 */     private final Bit reserved = new Bit(1);
/* 233 */     private final Bit reservable = new Bit(2);
/* 234 */     private final Bit used = new Bit(4);
/*     */     
/*     */     public int y() {
/* 237 */       return this.y;
/*     */     }
/*     */ 
/*     */     
/*     */     public int x() {
/* 242 */       return this.x;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean findableReservedIs() {
/* 247 */       return this.reserved.is(this.data);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean findableReservedCanBe() {
/* 252 */       return (!this.reserved.is(this.data) && this.reservable.is(this.data));
/*     */     }
/*     */ 
/*     */     
/*     */     public void findableReserveCancel() {
/* 257 */       this.data = this.reserved.clear(this.data);
/* 258 */       save();
/*     */     }
/*     */ 
/*     */     
/*     */     public void findableReserve() {
/* 263 */       if (findableReservedCanBe()) {
/* 264 */         this.data = this.reserved.set(this.data);
/* 265 */         save();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void startUsing() {
/* 271 */       if (findableReservedIs()) {
/* 272 */         this.data = this.used.set(this.data);
/* 273 */         save();
/* 274 */         SchoolStation.this.work.consume(false);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void consume() {
/* 280 */       this.data = 0;
/* 281 */       SchoolStation.this.work.consume(true);
/* 282 */       if (SchoolStation.this.work.dones.get(SchoolStation.this.work.data) > 0) {
/* 283 */         this.data = this.reservable.set(this.data);
/*     */       }
/* 285 */       save();
/*     */     }
/*     */     
/*     */     void setReserveable() {
/* 289 */       this.data = this.reservable.set(this.data);
/* 290 */       save();
/*     */     }
/*     */     
/*     */     private void save() {
/* 294 */       int c = this.data;
/* 295 */       this.data = (SETT.ROOMS()).data.get((COORDINATE)this);
/* 296 */       SchoolStation.this.ins.service().report(this, SchoolStation.this.ins.blueprintI().service(), -1);
/* 297 */       this.data = c;
/* 298 */       SchoolStation.this.ins.service().report(this, SchoolStation.this.ins.blueprintI().service(), 1);
/* 299 */       (SETT.ROOMS()).data.set((ROOMA)SchoolStation.this.ins, this.x, this.y, this.data);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\school\SchoolStation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */