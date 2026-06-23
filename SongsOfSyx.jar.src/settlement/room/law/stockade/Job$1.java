/*     */ package settlement.room.law.stockade;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.ROOMA;
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
/*     */ class null
/*     */   implements SETT_JOB
/*     */ {
/*     */   public boolean jobUseTool() {
/*  97 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseHands() {
/* 102 */     return (Job.this.type.get() == 3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 112 */     return Job.this.b.employment().sound();
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/* 117 */     if (Job.this.type.get() == 2) {
/* 118 */       return (RBIT)Job.this.ins.fetch;
/*     */     }
/* 120 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/* 125 */     return (Job.this.reserved.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/* 130 */     Job.this.reserved.set((ROOMA)Job.this.ins, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/* 135 */     if (Job.this.type.get() == 2 && Job.this.data.get() > 8)
/* 136 */       return false; 
/* 137 */     return (Job.this.reserved.get() == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/* 142 */     if (r != null) {
/* 143 */       Job.this.ins.jobs.resetResourceSearch();
/*     */     }
/* 145 */     Job.this.reserved.set((ROOMA)Job.this.ins, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid a) {
/* 150 */     if (Job.this.type.get() == 1)
/* 151 */       return 60.0D; 
/* 152 */     return 20.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 157 */     if (Job.this.type.get() == 2 && rAm > 0) {
/* 158 */       Job.this.data.inc((ROOMA)Job.this.ins, rAm);
/* 159 */       for (IndustryResource ii : Job.this.b.indu.ins()) {
/* 160 */         if (ii.resource == r)
/* 161 */           ii.inc((ROOM_IDATA_INSTANCE)Job.this.ins, rAm); 
/*     */       } 
/*     */     } else {
/* 164 */       Job.this.data.set((ROOMA)Job.this.ins, 0);
/* 165 */     }  Job.this.reserved.set((ROOMA)Job.this.ins, 0);
/* 166 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 171 */     return (Job.this.b.employment()).title;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 176 */     return (COORDINATE)Job.this.coo;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\stockade\Job$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */