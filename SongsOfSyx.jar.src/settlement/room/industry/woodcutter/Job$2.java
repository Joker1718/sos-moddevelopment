/*     */ package settlement.room.industry.woodcutter;
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
/*     */   public boolean jobReserveCanBe() {
/* 138 */     if (jobReservedIs(null))
/* 139 */       return false; 
/* 140 */     if (!Job.this.ins.hasStorage)
/* 141 */       return false; 
/* 142 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 147 */     return (COORDINATE)Job.this.jobCoo;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 152 */     return (Job.this.print.employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 157 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/* 162 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/* 167 */     return 60.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/* 172 */     if (jobReservedIs(null))
/* 173 */       throw new RuntimeException(); 
/* 174 */     Job.this.reserved.set((ROOMA)Job.this.ins, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/* 179 */     return (Job.this.reserved.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/* 184 */     Job.this.reserved.set((ROOMA)Job.this.ins, 0);
/* 185 */     Job.this.used.set((ROOMA)Job.this.ins, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {
/* 190 */     Job.this.used.set((ROOMA)Job.this.ins, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 195 */     return Job.this.ins.blueprintI().employment().sound();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid s, RESOURCE res, int ram) {
/* 201 */     jobReserveCancel(null);
/*     */     
/* 203 */     Job.this.chopped.inc((ROOMA)Job.this.ins, 1);
/* 204 */     if (Job.this.chopped.get() > Job.this.workPerDay && (SETT.ROOMS()).fData.tileData.get((COORDINATE)Job.this.jobCoo) != 1) {
/* 205 */       (SETT.TERRAIN()).DECOR_WOOD.placeFixed(Job.this.jobCoo.x(), Job.this.jobCoo.y());
/* 206 */       Job.this.chopped.set((ROOMA)Job.this.ins, 0);
/*     */     } 
/*     */     
/* 209 */     int am = ((IndustryResource)Job.this.print.productionData.outs().get(0)).work(s, (ROOM_IDATA_INSTANCE)Job.this.ins, 60.0D);
/*     */     
/* 211 */     if (am == 0) {
/* 212 */       return null;
/*     */     }
/* 214 */     if (!Job.this.ins.hasStorage) {
/* 215 */       return null;
/*     */     }
/* 217 */     int x1 = Job.this.ins.sx;
/* 218 */     int y1 = Job.this.ins.sy;
/* 219 */     RoomResStorage ss = Job.this.storage.get(x1, y1, (ROOMA)Job.this.ins);
/*     */     
/* 221 */     while (ss != null) {
/* 222 */       if (am == 0 && ss.hasRoom())
/* 223 */         return null; 
/* 224 */       if (ss.hasRoom()) {
/* 225 */         ss.deposit();
/* 226 */         am--;
/*     */         
/*     */         continue;
/*     */       } 
/* 230 */       RoomResStorage sss = Job.this.storage.get(ss.x() + 1, ss.y(), (ROOMA)Job.this.ins);
/* 231 */       if (sss == null)
/* 232 */         sss = Job.this.storage.get(x1, ss.y() + 1, (ROOMA)Job.this.ins); 
/* 233 */       ss = sss;
/*     */     } 
/*     */     
/* 236 */     ((IndustryResource)Job.this.print.productionData.outs().get(0)).inc((ROOM_IDATA_INSTANCE)Job.this.ins, -am);
/*     */     
/* 238 */     Job.this.ins.hasStorage = false;
/*     */ 
/*     */     
/* 241 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\woodcutter\Job$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */