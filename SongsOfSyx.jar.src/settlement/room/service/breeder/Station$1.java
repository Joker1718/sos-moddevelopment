/*     */ package settlement.room.service.breeder;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import game.time.TIME;
/*     */ import init.resources.RBIT;
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
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
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
/*     */ class null
/*     */   implements SETT_JOB
/*     */ {
/* 119 */   private final int wt = 30;
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 123 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 133 */     return Station.this.b.employment().sound();
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/* 138 */     if (Station.this.resources() < 1)
/* 139 */       return ((IndustryResource)((Industry)Station.this.b.indus.get(0)).ins().get(0)).resource.bit; 
/* 140 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/* 145 */     return (Station.this.reserved.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/* 150 */     Station.this.reserved.set((ROOMA)Station.this.ins, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/* 155 */     if (Station.this.reserved.get() == 1)
/* 156 */       return false; 
/* 157 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/* 162 */     Station.this.reserved.set((ROOMA)Station.this.ins, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/* 167 */     return 30.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE res, int am) {
/* 172 */     jobReserveCancel(res);
/* 173 */     if (res != null) {
/* 174 */       am = (SETT.ROOMS()).resourceUnderflow.deposit(res, am);
/* 175 */       if (am > 0) {
/* 176 */         Station.this.masterRes.inc((ROOMA)Station.this.ins, am);
/*     */       }
/* 178 */       return null;
/*     */     } 
/*     */     
/* 181 */     if (Station.this.masterActivityCount.get() == 0) {
/* 182 */       Station.this.masterActivity.inc((ROOMA)Station.this.ins, 1);
/*     */     }
/* 184 */     int t = Station.this.ins.employees().fetchBonus(30);
/*     */     
/* 186 */     for (IndustryResource r : Station.this.ins.industry().ins()) {
/* 187 */       int a = r.work(skill, (ROOM_IDATA_INSTANCE)Station.this.ins, t);
/* 188 */       if (a > 0) {
/* 189 */         int max = Station.this.masterRes.get();
/* 190 */         a = (SETT.ROOMS()).resourceUnderflow.withdraw(r.resource, a, max);
/* 191 */         Station.this.masterRes.inc((ROOMA)Station.this.ins, -a);
/*     */       } 
/*     */     } 
/*     */     
/* 195 */     double w = IndustryUtil.calcProductionRate(t * Station.this.b.PRODUCTION_SPEED_DAY / TIME.workSeconds(), skill, (IndustryRate)Station.this.b.productionData, Station.this.ins);
/* 196 */     Station.this.ins.kidsProduction += w;
/*     */     
/* 198 */     while (Station.this.ins.kidsProduction > 1.0D) {
/* 199 */       Station.this.ins.kidsProduction--;
/* 200 */       HTYPE ty = HTYPES.CHILD();
/* 201 */       if (Station.this.b.prosecute) {
/* 202 */         ty = HTYPES.CHILD_SLAVE();
/*     */       }
/* 204 */       Humanoid h = SETT.HUMANOIDS().create(Station.this.b.race, skill.tc().x(), skill.tc().y(), ty, CAUSE_ARRIVES.BORN());
/* 205 */       if (h != null) {
/* 206 */         (STATS.POP()).age.DAYS.set(h.indu(), 0);
/* 207 */         (STATS.POP()).TYPE.NATIVE.set(h.indu());
/* 208 */         STATS.REL().setParent(h.indu(), skill.indu());
/*     */       } 
/*     */     } 
/*     */     
/* 212 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 217 */     return (Station.this.b.employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 222 */     return (COORDINATE)Station.this.coo;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\breeder\Station$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */