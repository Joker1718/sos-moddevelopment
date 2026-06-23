/*     */ package settlement.room.service.barber;
/*     */ 
/*     */ import game.audio.SoundRace;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
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
/*     */ class null
/*     */   implements SETT_JOB
/*     */ {
/*     */   private static final String name = "setting table";
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/*  84 */     if (!jobReserveCanBe())
/*  85 */       throw new RuntimeException(); 
/*  86 */     Tile.this.bWReserved.set((ROOMA)Tile.this.ins, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/*  91 */     return (Tile.this.bWReserved.get() == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/*  96 */     Tile.this.bWReserved.set((ROOMA)Tile.this.ins, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/* 101 */     return (Tile.this.bWReserved.get() == 0 && (Tile.this.bUses.get() < Tile.this.bUses.max() || Tile.this.bWorked.get() < Tile.this.bWorked.max()));
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/* 106 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/* 111 */     return Tile.this.workTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE res, int ram) {
/* 116 */     if (!jobReservedIs(res))
/* 117 */       throw new RuntimeException(); 
/* 118 */     Tile.this.bWReserved.set((ROOMA)Tile.this.ins, 0);
/* 119 */     if (Tile.this.bWorked.get() == Tile.this.bWorked.max()) {
/* 120 */       Tile.this.bUses.inc((ROOMA)Tile.this.ins, 1);
/* 121 */       Tile.this.bWorked.set((ROOMA)Tile.this.ins, 0);
/*     */     } else {
/* 123 */       Tile.this.bWorked.inc((ROOMA)Tile.this.ins, 1);
/*     */     } 
/* 125 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 130 */     return (COORDINATE)Tile.this.coo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String jobName() {
/* 137 */     return "setting table";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 148 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 153 */     return Tile.this.blue.employment().sound();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobUseHands() {
/* 158 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\barber\Tile$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */