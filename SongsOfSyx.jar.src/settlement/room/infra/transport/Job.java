/*     */ package settlement.room.infra.transport;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ final class Job {
/*     */   private TransportInstance ins;
/*  20 */   private final Coo coo = new Coo();
/*     */   
/*  22 */   public final RoomBits breserved = new RoomBits((COORDINATE)this.coo, new Bits(1));
/*  23 */   public final RoomBits bamount = new RoomBits((COORDINATE)this.coo, new Bits(65520));
/*  24 */   public final RoomBits bamountr = new RoomBits((COORDINATE)this.coo, new Bits(2031616));
/*     */   public final TILE_STORAGE storage;
/*     */   public final SETT_JOB load;
/*     */   public final SETT_JOB prep;
/*     */   
/*     */   void remove(TransportInstance ins) {
/*  30 */     this.ins = ins;
/*  31 */     for (COORDINATE c : ins.body()) {
/*  32 */       if (ins.is(c) && (SETT.ROOMS()).fData.tile.get(c) == (b()).constructor.ww) {
/*  33 */         this.coo.set(c);
/*  34 */         int am = this.bamount.get();
/*  35 */         remove();
/*  36 */         this.bamount.set((ROOMA)ins, 0);
/*  37 */         this.breserved.set((ROOMA)ins, 0);
/*  38 */         if (ins.data.resource() != null && am > 0) {
/*  39 */           (SETT.THINGS()).resources.create(c, ins.data.resource(), am);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   void add(TransportInstance ins) {
/*  46 */     this.ins = ins;
/*  47 */     for (COORDINATE c : ins.body()) {
/*  48 */       if (ins.is(c) && (SETT.ROOMS()).fData.tile.get(c) == (b()).constructor.ww && this.storage.storageReservable() > 0) {
/*  49 */         this.coo.set(c);
/*  50 */         add();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static ROOM_TRANSPORT b() {
/*  56 */     return (SETT.ROOMS()).TRANSPORT;
/*     */   }
/*     */   
/*     */   public SETT_JOB job(int tx, int ty) {
/*  60 */     this.ins = (TransportInstance)b().get(tx, ty);
/*  61 */     if (this.ins == null)
/*  62 */       return null; 
/*  63 */     if ((SETT.ROOMS()).fData.tile.get(tx, ty) == (b()).constructor.ww) {
/*  64 */       this.coo.set(tx, ty);
/*  65 */       if ((this.ins.destSpaceMask().isClear() && this.ins.data.prepD() < 2.0D) || this.ins.data.needsPrep())
/*  66 */         return this.prep; 
/*  67 */       return this.load;
/*     */     } 
/*  69 */     return null;
/*     */   }
/*     */   
/*     */   public TILE_STORAGE storage(int tx, int ty) {
/*  73 */     this.ins = (TransportInstance)b().get(tx, ty);
/*  74 */     if (this.ins == null)
/*  75 */       return null; 
/*  76 */     if ((SETT.ROOMS()).fData.tile.get(tx, ty) == (b()).constructor.ww) {
/*  77 */       this.coo.set(tx, ty);
/*  78 */       return this.storage;
/*     */     } 
/*  80 */     return null;
/*     */   }
/*     */   Job(ROOM_TRANSPORT blue) {
/*  83 */     this.storage = new TILE_STORAGE()
/*     */       {
/*     */         public int y()
/*     */         {
/*  87 */           return Job.this.coo.y();
/*     */         }
/*     */ 
/*     */         
/*     */         public int x() {
/*  92 */           return Job.this.coo.x();
/*     */         }
/*     */ 
/*     */         
/*     */         public void storageUnreserve(int amount) {
/*  97 */           Job.this.remove();
/*  98 */           Job.this.bamountr.inc((ROOMA)Job.this.ins, -amount);
/*  99 */           Job.this.add();
/*     */         }
/*     */ 
/*     */         
/*     */         public int storageReserved() {
/* 104 */           return Job.this.bamountr.get();
/*     */         }
/*     */ 
/*     */         
/*     */         public void storageReserve(int amount) {
/* 109 */           Job.this.remove();
/* 110 */           Job.this.bamountr.inc((ROOMA)Job.this.ins, amount);
/* 111 */           Job.this.add();
/*     */         }
/*     */ 
/*     */         
/*     */         public int storageReservable() {
/* 116 */           if (Job.this.ins.data.resource() != null)
/* 117 */             return Job.this.bamountr.max() - Job.this.bamount.get() - Job.this.bamountr.get(); 
/* 118 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public void storageDeposit(int amount) {
/* 123 */           Job.this.remove();
/* 124 */           Job.this.bamountr.inc((ROOMA)Job.this.ins, -amount);
/* 125 */           Job.this.add();
/* 126 */           Job.this.ins.data.needsPrep();
/* 127 */           if (Job.this.ins.data.stored() < 400) {
/* 128 */             int am = amount;
/* 129 */             am = CLAMP.i(am, 0, 400 - Job.this.ins.data.stored());
/* 130 */             Job.this.ins.data.store(am);
/* 131 */             amount -= am;
/*     */           } 
/*     */ 
/*     */           
/* 135 */           if (amount > 0) {
/* 136 */             Job.this.remove();
/* 137 */             Job.this.bamount.inc((ROOMA)Job.this.ins, amount);
/*     */             
/* 139 */             Job.this.add();
/*     */           } 
/* 141 */           Job.this.ins.go();
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE resource() {
/* 146 */           return Job.this.ins.resource();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean storageIsFindable() {
/* 151 */           return false;
/*     */         }
/*     */       };
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     this.load = new SETT_JOB()
/*     */       {
/* 175 */         private int time = 1;
/*     */ 
/*     */         
/*     */         public boolean jobUseTool() {
/* 179 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 189 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 194 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 199 */           return (Job.this.breserved.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 204 */           Job.this.breserved.set((ROOMA)Job.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 209 */           return (Job.this.breserved.get() == 0 && Job.this.bamount.get() > 0 && Job.this.ins.data.stored() < 400);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/* 214 */           Job.this.breserved.set((ROOMA)Job.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid skill) {
/* 219 */           return this.time;
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ri) {
/* 224 */           jobReserveCancel(r);
/* 225 */           if (Job.this.bamount.get() > 0 && Job.this.ins.data.stored() < 400) {
/* 226 */             int am = Job.this.bamount.get();
/* 227 */             am = CLAMP.i(am, 0, 400 - Job.this.ins.data.stored());
/* 228 */             Job.this.ins.data.store(am);
/* 229 */             Job.this.remove();
/* 230 */             Job.this.bamount.inc((ROOMA)Job.this.ins, -am);
/* 231 */             Job.this.add();
/*     */           } 
/*     */ 
/*     */           
/* 235 */           Job.this.ins.go();
/* 236 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 241 */           return Gui.¤¤organise;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 246 */           return (COORDINATE)Job.this.coo;
/*     */         }
/*     */       };
/*     */     
/* 250 */     this.prep = new SETT_JOB()
/*     */       {
/* 252 */         private int time = 16;
/*     */ 
/*     */         
/*     */         public boolean jobUseTool() {
/* 256 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 266 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 271 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 276 */           return (Job.this.breserved.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 281 */           Job.this.breserved.set((ROOMA)Job.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 286 */           return (Job.this.breserved.get() == 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/* 291 */           Job.this.breserved.set((ROOMA)Job.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid skill) {
/* 296 */           return this.time;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ri) {
/* 303 */           jobReserveCancel(r);
/* 304 */           double am = (SETT.ROOMS()).STOCKPILE.bonus().get((BOOSTABLE_O)skill.indu()) / ((SETT.ROOMS()).STOCKPILE.bonus()).baseValue * Job.this.ins.efficiency() * this.time;
/* 305 */           Job.this.ins.data.prep(am);
/* 306 */           Job.this.ins.go();
/* 307 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 312 */           return Gui.¤¤preparing;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 317 */           return (COORDINATE)Job.this.coo;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   void remove() {
/*     */     this.ins.data.unloadedInc(-this.bamount.get());
/*     */     if (this.storage.storageReservable() > 0) {
/*     */       (SETT.PATH()).finders.storage.reportAbsence(this.storage);
/*     */       if (this.bamount.get() == 0 && this.bamountr.get() == 0)
/*     */         this.ins.data.unloadedSpotsInc(-1); 
/*     */     } 
/*     */   }
/*     */   
/*     */   void add() {
/*     */     this.ins.data.unloadedInc(this.bamount.get());
/*     */     if (this.storage.storageReservable() > 0) {
/*     */       (SETT.PATH()).finders.storage.reportPresence(this.storage);
/*     */       if (this.bamount.get() == 0 && this.bamountr.get() == 0)
/*     */         this.ins.data.unloadedSpotsInc(1); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\transport\Job.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */