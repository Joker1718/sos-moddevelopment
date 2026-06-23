/*     */ package settlement.room.infra.janitor;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
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
/*     */ class Job
/*     */   implements SETT_JOB
/*     */ {
/* 148 */   private int wt = 20;
/*     */ 
/*     */   
/*     */   public boolean jobUseTool() {
/* 152 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void jobStartPerforming() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public SoundRace jobSound() {
/* 162 */     return JM.this.b.employment().sound();
/*     */   }
/*     */ 
/*     */   
/*     */   public RBIT jobResourceBitToFetch() {
/* 167 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReservedIs(RESOURCE r) {
/* 172 */     return (SETT.MAINTENANCE()).reserved.is(JM.this.coo.x(), JM.this.coo.y());
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserveCancel(RESOURCE r) {
/* 177 */     (SETT.MAINTENANCE()).reserved.set((COORDINATE)JM.this.coo, false);
/* 178 */     r = (RESOURCE)(SETT.MAINTENANCE()).resource.get((COORDINATE)JM.this.coo);
/* 179 */     if (r != null && JM.this.ins.bits.resAm(r) > 0) {
/* 180 */       JM.this.ins.bits.resInc(JM.this.ins, r, 1);
/* 181 */       FACTIONS.player().res().inc(r, FResources.RTYPE.MAINTENANCE, 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean jobReserveCanBe() {
/* 187 */     return (SETT.MAINTENANCE()).reservable.is((COORDINATE)JM.this.coo);
/*     */   }
/*     */ 
/*     */   
/*     */   public void jobReserve(RESOURCE r) {
/* 192 */     if (JM.this.coo.isSameAs(JM.this.ins.rx, JM.this.ins.ry))
/* 193 */       GAME.Notify("FUCKFUCK"); 
/* 194 */     r = (RESOURCE)(SETT.MAINTENANCE()).resource.get((COORDINATE)JM.this.coo);
/* 195 */     if (r != null && JM.this.ins.bits.resAm(r) > 0) {
/* 196 */       JM.this.ins.bits.resInc(JM.this.ins, r, -1);
/* 197 */       FACTIONS.player().res().inc(r, FResources.RTYPE.MAINTENANCE, -1);
/*     */     } 
/* 199 */     (SETT.MAINTENANCE()).reserved.set((COORDINATE)JM.this.coo, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public double jobPerformTime(Humanoid skill) {
/* 204 */     if (JM.this.coo.isSameAs(JM.this.lx, JM.this.ly) || (SETT.MAINTENANCE()).resource.get((COORDINATE)JM.this.coo) != null) {
/* 205 */       return 1.0D;
/*     */     }
/* 207 */     return ((SETT.MAINTENANCE()).pFreeFetch.is((COORDINATE)JM.this.coo) ? true : this.wt);
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE jobPerform(Humanoid skill, RESOURCE r, int ram) {
/* 212 */     (SETT.MAINTENANCE()).reserved.set((COORDINATE)JM.this.coo, false);
/* 213 */     SETT.MAINTENANCE().maintain(JM.this.coo.x(), JM.this.coo.y());
/*     */     
/* 215 */     JM.this.lx = JM.this.coo.x();
/* 216 */     JM.this.ly = JM.this.coo.y();
/* 217 */     (SETT.MAINTENANCE()).pFreeFetch.set((COORDINATE)JM.this.coo, JM.this.ins.employees().fetchBonusConsume(this.wt + 1));
/* 218 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence jobName() {
/* 223 */     return (JM.this.b.employment()).verb;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 228 */     return (COORDINATE)JM.this.coo;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\janitor\JM$Job.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */