/*     */ package settlement.room.infra.station;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.util.RoomBits;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ final class Job {
/*     */   private StationInstance ins;
/*  18 */   private final Coo coo = new Coo();
/*     */   
/*  20 */   public final RoomBits breserved = new RoomBits((COORDINATE)this.coo, new Bits(1));
/*     */ 
/*     */   
/*     */   private final ROOM_STATION b;
/*     */   
/*     */   public final SETT_JOB job;
/*     */ 
/*     */   
/*     */   public SETT_JOB get(int tx, int ty) {
/*  29 */     this.ins = (StationInstance)this.b.get(tx, ty);
/*  30 */     if (this.ins == null)
/*  31 */       return null; 
/*  32 */     if (((SETT.ROOMS()).fData.tileData.get(tx, ty) & 0x1) != 0) {
/*  33 */       this.coo.set(tx, ty);
/*  34 */       return this.job;
/*     */     } 
/*  36 */     return null;
/*     */   }
/*     */   Job(ROOM_STATION blue) {
/*  39 */     this.job = new SETT_JOB()
/*     */       {
/*  41 */         private int time = 48;
/*     */ 
/*     */         
/*     */         public boolean jobUseTool() {
/*  45 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public SoundRace jobSound() {
/*  55 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public RBIT jobResourceBitToFetch() {
/*  60 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReservedIs(RESOURCE r) {
/*  65 */           return (Job.this.breserved.get() == 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserveCancel(RESOURCE r) {
/*  70 */           Job.this.breserved.set((ROOMA)Job.this.ins, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean jobReserveCanBe() {
/*  75 */           return (Job.this.breserved.get() == 0 && Job.this.ins.prepared < Job.this.ins.maxPrep());
/*     */         }
/*     */ 
/*     */         
/*     */         public void jobReserve(RESOURCE r) {
/*  80 */           Job.this.breserved.set((ROOMA)Job.this.ins, 1);
/*     */         }
/*     */ 
/*     */         
/*     */         public double jobPerformTime(Humanoid skill) {
/*  85 */           return this.time;
/*     */         }
/*     */ 
/*     */         
/*     */         public RESOURCE jobPerform(Humanoid skill, RESOURCE res, int ram) {
/*  90 */           jobReserveCancel(res);
/*  91 */           double am = (SETT.ROOMS()).STOCKPILE.bonus().get((BOOSTABLE_O)skill.indu()) / ((SETT.ROOMS()).STOCKPILE.bonus()).baseValue * Job.this.ins.efficiency() * this.time;
/*  92 */           Job.this.ins.setPrepared(Job.this.ins.prepared + am);
/*  93 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence jobName() {
/*  98 */           return (Job.this.b.employment()).verb;
/*     */         }
/*     */ 
/*     */         
/*     */         public COORDINATE jobCoo() {
/* 103 */           return (COORDINATE)Job.this.coo;
/*     */         }
/*     */       };
/*     */     this.b = blue;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\station\Job.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */