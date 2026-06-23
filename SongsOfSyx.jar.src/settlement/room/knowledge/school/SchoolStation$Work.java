/*     */ package settlement.room.knowledge.school;
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
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
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
/*     */ final class Work
/*     */   implements SETT_JOB
/*     */ {
/* 103 */   private final Bit reserved = new Bit(1);
/* 104 */   private final Bits dones = new Bits(6);
/* 105 */   private final Bits paper = new Bits(240);
/* 106 */   private final Bits fetchFree = new Bits(256);
/* 107 */   private final Coo coo = new Coo();
/*     */   
/*     */   private int data;
/* 110 */   private int wt = (int)(TIME.workSeconds() / 40.0D);
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/* 114 */     if (!jobReserveCanBe())
/* 115 */       throw new RuntimeException(); 
/* 116 */     this.data = this.reserved.set(this.data);
/* 117 */     save();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/* 122 */     return this.reserved.is(this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/* 127 */     this.data = this.reserved.clear(this.data);
/* 128 */     save();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/* 134 */     if (this.reserved.is(this.data))
/* 135 */       return false; 
/* 136 */     if (this.dones.get(this.data) < 3) {
/* 137 */       return true;
/*     */     }
/* 139 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/* 144 */     if (this.paper.get(this.data) < 1)
/* 145 */       return ((IndustryResource)SchoolStation.this.b.industry.ins().get(0)).resource.bit; 
/* 146 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/* 151 */     if (this.fetchFree.get(this.data) == 1)
/* 152 */       return 0.0D; 
/* 153 */     return this.wt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/* 163 */     if (r == ((IndustryResource)SchoolStation.this.b.industry.ins().get(0)).resource) {
/* 164 */       this.data = this.paper.inc(this.data, ram);
/*     */     } else {
/* 166 */       this.data = this.dones.inc(this.data, 1);
/* 167 */       this.data = this.fetchFree.set(this.data, 0);
/* 168 */       SchoolStation.this.service.setReserveable();
/*     */     } 
/*     */     
/* 171 */     if (this.fetchFree.get(this.data) == 0 && SchoolStation.this.ins.employees().fetchBonusConsume(this.wt)) {
/* 172 */       this.data = this.fetchFree.set(this.data, 1);
/*     */     }
/*     */     
/* 175 */     jobReserveCancel(r);
/* 176 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int jobResourcesNeeded(Humanoid skill) {
/* 181 */     return this.paper.mask;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 186 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 191 */     return (SchoolStation.this.b.employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 196 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 201 */     return SchoolStation.this.b.employment().sound();
/*     */   }
/*     */   
/*     */   private void save() {
/* 205 */     int c = this.data;
/* 206 */     this.data = (SETT.ROOMS()).data.get((COORDINATE)this.coo);
/*     */     
/* 208 */     this.data = c;
/*     */     
/* 210 */     (SETT.ROOMS()).data.set((ROOMA)SchoolStation.this.ins, (COORDINATE)this.coo, this.data);
/*     */   }
/*     */   
/*     */   void consume(boolean day) {
/* 214 */     this.data = this.dones.inc(this.data, -1);
/* 215 */     if (day) {
/* 216 */       int p = ((IndustryResource)SchoolStation.this.b.industry.ins().get(0)).incDay((ROOM_IDATA_INSTANCE)SchoolStation.this.ins);
/* 217 */       if (p > 0) {
/* 218 */         this.data = this.paper.inc(this.data, -p);
/*     */       }
/*     */     } 
/* 221 */     save();
/* 222 */     SchoolStation.this.ins.jobs.searchAgain();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\school\SchoolStation$Work.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */