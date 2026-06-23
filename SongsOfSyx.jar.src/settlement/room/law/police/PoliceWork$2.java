/*     */ package settlement.room.law.police;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import game.time.TIME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public void jobReserve(RESOURCE r) {
/* 203 */     PoliceWork.this.reserved.set((ROOMA)PoliceWork.this.ins, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/* 208 */     return (PoliceWork.this.reserved.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/* 213 */     PoliceWork.this.used.set((ROOMA)PoliceWork.this.ins, 0);
/* 214 */     PoliceWork.this.reserved.set((ROOMA)PoliceWork.this.ins, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/* 219 */     return (PoliceWork.this.reserved.get() == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/* 224 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid a) {
/* 229 */     return 45.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {
/* 234 */     PoliceWork.this.used.set((ROOMA)PoliceWork.this.ins, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int rAm) {
/* 239 */     jobReserveCancel(r);
/* 240 */     if (PoliceWork.this.clientTime.get() == 0) {
/*     */       
/* 242 */       ENTITY e = SETT.ENTITIES().getAtTileSingle(PoliceWork.this.coo.x(), PoliceWork.this.coo.y());
/* 243 */       if (e != null && e instanceof Humanoid) {
/* 244 */         Humanoid h = (Humanoid)e;
/* 245 */         h.interrupt();
/*     */       } 
/*     */     } 
/* 248 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 253 */     return (COORDINATE)PoliceWork.this.coo;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 258 */     return (PoliceWork.this.ins.blueprintI().employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 263 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseHands() {
/* 268 */     return ((PoliceWork.this.coo.x() + PoliceWork.this.coo.y() * SETT.TWIDTH + TIME.hours().bitsSinceStart() & 0x1) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 273 */     return PoliceWork.this.ins.blueprintI().employment().sound();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\police\PoliceWork$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */