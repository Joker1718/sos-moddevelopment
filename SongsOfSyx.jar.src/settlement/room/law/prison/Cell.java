/*    */ package settlement.room.law.prison;
/*    */ 
/*    */ import game.audio.SoundRace;
/*    */ import init.resources.RBIT;
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.job.SETT_JOB;
/*    */ import settlement.room.main.ROOMA;
/*    */ import snake2d.util.bit.Bit;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ 
/*    */ final class Cell implements SETT_JOB {
/* 15 */   private static final Bit reserved = new Bit(16);
/* 16 */   private Coo coo = new Coo();
/*    */ 
/*    */ 
/*    */   
/*    */   private PrisonInstance ins;
/*    */ 
/*    */   
/* 23 */   static final Cell self = new Cell();
/*    */   
/*    */   static Cell init(int tx, int ty) {
/* 26 */     self.ins = (PrisonInstance)(SETT.ROOMS()).PRISON.get(tx, ty);
/* 27 */     if (self.ins == null || (SETT.ROOMS()).fData.tileData.get(tx, ty) != 1)
/* 28 */       return null; 
/* 29 */     self.coo.set(tx, ty);
/* 30 */     return self;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SoundRace jobSound() {
/* 36 */     return this.ins.blueprintI().employment().sound();
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence jobName() {
/* 41 */     return ((SETT.ROOMS()).PRISON.employment()).verb;
/*    */   }
/*    */ 
/*    */   
/*    */   public void jobReserve(RESOURCE r) {
/* 46 */     int d = reserved.set((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/* 47 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean jobReservedIs(RESOURCE r) {
/* 52 */     return reserved.is((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/*    */   }
/*    */ 
/*    */   
/*    */   public void jobReserveCancel(RESOURCE r) {
/* 57 */     int d = reserved.clear((SETT.ROOMS()).data.get((COORDINATE)this.coo));
/* 58 */     (SETT.ROOMS()).data.set((ROOMA)this.ins, (COORDINATE)this.coo, d);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean jobReserveCanBe() {
/* 63 */     return !jobReservedIs(null);
/*    */   }
/*    */ 
/*    */   
/*    */   public RBIT jobResourceBitToFetch() {
/* 68 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public double jobPerformTime(Humanoid skill) {
/* 73 */     return 45.0D;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void jobStartPerforming() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/* 83 */     jobReserveCancel(null);
/* 84 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public COORDINATE jobCoo() {
/* 89 */     return (COORDINATE)this.coo;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean jobUseTool() {
/* 94 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\prison\Cell.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */