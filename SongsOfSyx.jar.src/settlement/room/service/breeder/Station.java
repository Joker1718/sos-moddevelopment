/*     */ package settlement.room.service.breeder;
/*     */ import game.audio.SoundRace;
/*     */ import game.time.TIME;
/*     */ import init.resources.RESOURCE;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ class Station {
/*  24 */   final Coo coo = new Coo();
/*  25 */   final Coo masterCoo = new Coo();
/*     */   
/*     */   BreederInstance ins;
/*     */   final ROOM_BREEDER b;
/*  29 */   private final RoomBits masterRes = new RoomBits((COORDINATE)this.masterCoo, new Bits(4095));
/*  30 */   private final RoomBits masterActivity = new RoomBits((COORDINATE)this.masterCoo, new Bits(126976));
/*  31 */   private final RoomBits masterActivityCount = new RoomBits((COORDINATE)this.masterCoo, new Bits(65536));
/*  32 */   private final RoomBits masterWorkPlaces = new RoomBits((COORDINATE)this.masterCoo, new Bits(267386880));
/*     */ 
/*     */   
/*  35 */   private final RoomBits reserved = new RoomBits((COORDINATE)this.coo, new Bits(15));
/*     */ 
/*     */   
/*     */   final SETT_JOB job;
/*     */ 
/*     */   
/*     */   SETT_JOB get(int tx, int ty) {
/*  42 */     if (ini(tx, ty) && (SETT.ROOMS()).fData.tileData.get(tx, ty) == 1) {
/*  43 */       this.coo.set(tx, ty);
/*  44 */       return this.job;
/*     */     } 
/*  46 */     return null;
/*     */   }
/*     */   
/*     */   private boolean ini(int tx, int ty) {
/*  50 */     if (this.b.is(tx, ty) && (SETT.ROOMS()).fData.item.is(tx, ty)) {
/*  51 */       (SETT.ROOMS()).fData.itemX1Y1(tx, ty, this.masterCoo);
/*  52 */       this.ins = (BreederInstance)this.b.get(tx, ty);
/*  53 */       return true;
/*     */     } 
/*  55 */     return false;
/*     */   }
/*     */   
/*     */   boolean init(int tx, int ty) {
/*  59 */     SETT_JOB j = get(tx, ty);
/*  60 */     if (j != null)
/*  61 */       this.masterWorkPlaces.inc((ROOMA)this.ins, 1); 
/*  62 */     return (j != null);
/*     */   }
/*     */   
/*     */   public void dispose(int x, int y) {
/*  66 */     if (!ini(x, y))
/*     */       return; 
/*  68 */     int am = this.masterRes.get();
/*  69 */     this.masterRes.set((ROOMA)this.ins, 0);
/*  70 */     if (am > 0) {
/*  71 */       (SETT.THINGS()).resources.create(x, y, ((IndustryResource)((Industry)this.b.indus.get(0)).ins().get(0)).resource, am);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int resources(int tx, int ty, int ran) {
/*  77 */     if (!ini(tx, ty)) {
/*  78 */       return 0;
/*     */     }
/*  80 */     double rr = this.masterRes.get() / this.masterWorkPlaces.get();
/*  81 */     rr = (int)rr + (ran & 0xF) / 15.0D * rr;
/*     */     
/*  83 */     return CLAMP.i((int)rr, 0, 8);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean worm(int tx, int ty, int ran) {
/*  88 */     if (!ini(tx, ty)) {
/*  89 */       return false;
/*     */     }
/*  91 */     double a = this.masterActivity.getD() * 2.0D;
/*     */     
/*  93 */     return (a > (ran & 0xF) / 15.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public double aSpeed(int tx, int ty) {
/*  98 */     if (!ini(tx, ty)) {
/*  99 */       return 0.0D;
/*     */     }
/* 101 */     double a = this.masterActivity.getD() * 2.0D;
/* 102 */     return CLAMP.d(a, 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(int tx, int ty) {
/* 108 */     if (get(tx, ty) != null) {
/* 109 */       this.masterActivity.inc((ROOMA)this.ins, -1);
/*     */     }
/*     */   }
/*     */   
/*     */   private int resources() {
/* 114 */     return this.masterRes.get() / this.masterWorkPlaces.get();
/*     */   }
/*     */   Station(ROOM_BREEDER b) {
/* 117 */     this.job = new SETT_JOB()
/*     */       {
/* 119 */         private final int wt = 30;
/*     */ 
/*     */         
/*     */         public boolean jobUseTool() {
/* 123 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/* 133 */           return Station.this.b.employment().sound();
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/* 138 */           if (Station.this.resources() < 1)
/* 139 */             return ((IndustryResource)((Industry)Station.this.b.indus.get(0)).ins().get(0)).resource.bit; 
/* 140 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/* 145 */           return (Station.this.reserved.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/* 150 */           Station.this.reserved.set((ROOMA)Station.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/* 155 */           if (Station.this.reserved.get() == 1)
/* 156 */             return false; 
/* 157 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/* 162 */           Station.this.reserved.set((ROOMA)Station.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid skill) {
/* 167 */           return 30.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE res, int am) {
/* 172 */           jobReserveCancel(res);
/* 173 */           if (res != null) {
/* 174 */             am = (SETT.ROOMS()).resourceUnderflow.deposit(res, am);
/* 175 */             if (am > 0) {
/* 176 */               Station.this.masterRes.inc((ROOMA)Station.this.ins, am);
/*     */             }
/* 178 */             return null;
/*     */           } 
/*     */           
/* 181 */           if (Station.this.masterActivityCount.get() == 0) {
/* 182 */             Station.this.masterActivity.inc((ROOMA)Station.this.ins, 1);
/*     */           }
/* 184 */           int t = Station.this.ins.employees().fetchBonus(30);
/*     */           
/* 186 */           for (IndustryResource r : Station.this.ins.industry().ins()) {
/* 187 */             int a = r.work(skill, (ROOM_IDATA_INSTANCE)Station.this.ins, t);
/* 188 */             if (a > 0) {
/* 189 */               int max = Station.this.masterRes.get();
/* 190 */               a = (SETT.ROOMS()).resourceUnderflow.withdraw(r.resource, a, max);
/* 191 */               Station.this.masterRes.inc((ROOMA)Station.this.ins, -a);
/*     */             } 
/*     */           } 
/*     */           
/* 195 */           double w = IndustryUtil.calcProductionRate(t * Station.this.b.PRODUCTION_SPEED_DAY / TIME.workSeconds(), skill, (IndustryRate)Station.this.b.productionData, Station.this.ins);
/* 196 */           Station.this.ins.kidsProduction += w;
/*     */           
/* 198 */           while (Station.this.ins.kidsProduction > 1.0D) {
/* 199 */             Station.this.ins.kidsProduction--;
/* 200 */             HTYPE ty = HTYPES.CHILD();
/* 201 */             if (Station.this.b.prosecute) {
/* 202 */               ty = HTYPES.CHILD_SLAVE();
/*     */             }
/* 204 */             Humanoid h = SETT.HUMANOIDS().create(Station.this.b.race, skill.tc().x(), skill.tc().y(), ty, CAUSE_ARRIVES.BORN());
/* 205 */             if (h != null) {
/* 206 */               (STATS.POP()).age.DAYS.set(h.indu(), 0);
/* 207 */               (STATS.POP()).TYPE.NATIVE.set(h.indu());
/* 208 */               STATS.REL().setParent(h.indu(), skill.indu());
/*     */             } 
/*     */           } 
/*     */           
/* 212 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/* 217 */           return (Station.this.b.employment()).verb;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 222 */           return (COORDINATE)Station.this.coo;
/*     */         }
/*     */       };
/*     */     this.b = b;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\breeder\Station.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */