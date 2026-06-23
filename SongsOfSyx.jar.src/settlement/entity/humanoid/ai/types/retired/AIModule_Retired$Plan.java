/*     */ package settlement.entity.humanoid.ai.types.retired;
/*     */ 
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.infra.elderly.ROOM_RESTHOME;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Plan
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   private final AIModule_Retired module;
/*     */   final AIPLAN.PLANRES.Resumer walk;
/*     */   final AIPLAN.PLANRES.Resumer work;
/*     */   
/*     */   Plan(AIModule_Retired module) {
/*  86 */     super("Retired");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     this.walk = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 126 */           JOBMANAGER_HASER jobs = AIModule_Retired.Plan.this.jobs(a);
/* 127 */           if (jobs == null) {
/* 128 */             return null;
/*     */           }
/* 130 */           SETT_JOB j = jobs.getWork().getReservableJob(a.tc());
/* 131 */           if (j == null) {
/* 132 */             return null;
/*     */           }
/* 134 */           j.jobReserve(null);
/* 135 */           d.planTile.set(j.jobCoo());
/* 136 */           AISUB.AISubActivation s = null;
/* 137 */           if ((SETT.PATH()).solidity.is((COORDINATE)d.planTile)) {
/* 138 */             s = (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)d.planTile);
/*     */           } else {
/* 140 */             s = (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)d.planTile);
/* 141 */           }  if (s == null) {
/* 142 */             AIModule_Retired.Plan.this.cancel(a, d);
/*     */           }
/* 144 */           return s;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 149 */           if (!AIModule_Retired.Plan.this.conn(a, d)) {
/* 150 */             AIModule_Retired.Plan.this.cancel(a, d);
/* 151 */             return null;
/*     */           } 
/* 153 */           return AIModule_Retired.Plan.this.work.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 158 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 167 */     this.work = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 171 */           d.planByte2 = (byte)(10 + RND.rInt(20));
/* 172 */           AIModule_Retired.Plan.this.job(a, d).jobStartPerforming();
/* 173 */           return res(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 179 */           if (!AIModule_Retired.Plan.this.conn(a, d)) {
/* 180 */             AIModule_Retired.Plan.this.cancel(a, d);
/* 181 */             return null;
/*     */           } 
/*     */           
/* 184 */           d.planByte2 = (byte)(d.planByte2 - 1);
/* 185 */           if (d.planByte2 <= 0) {
/* 186 */             AIModule_Retired.Plan.this.cancel(a, d);
/* 187 */             return AIModule_Retired.Plan.this.walk.set(a, d);
/*     */           } 
/*     */           
/* 190 */           if (AIModule_Retired.Plan.this.blue(d).cards((COORDINATE)d.planTile)) {
/* 191 */             if (RND.oneIn(8))
/* 192 */               return (AI.SUBS()).DUMMY.activate(a, d, (AI.STATES()).anima.fist.activate(a, d, (1.0F + RND.rFloat() * 2.0F))); 
/* 193 */             return (AI.SUBS()).STAND.activateTime(a, d, 6 + RND.rInt(3));
/* 194 */           }  if (AIModule_Retired.Plan.this.blue(d).dance((COORDINATE)d.planTile)) {
/* 195 */             if (RND.oneIn(5))
/* 196 */               return (AI.SUBS()).STAND.activateRndDir(a, d, 5 + RND.rInt(3)); 
/* 197 */             a.speed.setDirCurrent(a.speed.dir().next(-1 + RND.rInt(3)));
/* 198 */             return (AI.SUBS()).DUMMY.activate(a, d, (AI.STATES()).animaArr.dance().activate(a, d, (1.0F + RND.rFloat() * 10.0F)));
/* 199 */           }  if (AIModule_Retired.Plan.this.blue(d).sitDir((COORDINATE)d.planTile) != null) {
/* 200 */             a.speed.setDirCurrent(AIModule_Retired.Plan.this.blue(d).sitDir((COORDINATE)d.planTile));
/* 201 */             if (RND.oneIn(5)) {
/* 202 */               return (AI.SUBS()).DUMMY.activate(a, d, (AI.STATES()).animaArr.speak().activate(a, d, (2.0F + RND.rFloat() * 5.0F)));
/*     */             }
/*     */             
/* 205 */             return (AI.SUBS()).STAND.activateTime(a, d, 5);
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 210 */           int dx = a.tc().x() + a.speed.dir().x();
/* 211 */           int dy = a.tc().y() + a.speed.dir().y();
/* 212 */           if (SETT.ENTITIES().hasAtTile(dx, dy)) {
/* 213 */             if (RND.rBoolean())
/* 214 */               return (AI.SUBS()).DUMMY.activate(a, d, (AI.STATES()).animaArr.speak().activate(a, d, (2.0F + RND.rFloat() * 5.0F))); 
/* 215 */             return (AI.SUBS()).STAND.activateTime(a, d, 5);
/* 216 */           }  if (RND.rBoolean()) {
/* 217 */             a.speed.setDirCurrent(a.speed.dir().next(-1 + RND.rInt(3)));
/*     */           }
/* 219 */           return (AI.SUBS()).STAND.activateTime(a, d, 5);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 226 */           return true;
/*     */         }
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */     this.module = module;
/*     */   } protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     d.planByte1 = (byte)((ROOM_RESTHOME)((RoomInstance)(STATS.WORK()).EMPLOYED.get(a)).blueprint()).typeIndex();
/*     */     return this.walk.set(a, d);
/*     */   }
/*     */   private ROOM_RESTHOME blue(AIManager d) {
/*     */     return (ROOM_RESTHOME)(SETT.ROOMS()).RESTHOMES.get(d.planByte1);
/*     */   }
/* 238 */   protected void cancel(Humanoid a, AIManager d) { SETT_JOB j = job(a, d);
/* 239 */     if (j != null)
/* 240 */       j.jobReserveCancel(null);  }
/*     */   private final JOBMANAGER_HASER jobs(Humanoid a) { RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a); if (ins == null) return null;  if (ins.blueprintI() instanceof ROOM_RESTHOME) return (JOBMANAGER_HASER)ins;  return null; }
/*     */   private final SETT_JOB job(Humanoid a, AIManager d) { JOBMANAGER_HASER jj = jobs(a); if (jj == null)
/*     */       return null;  SETT_JOB j = jj.getWork().getJob((COORDINATE)d.planTile); if (j == null || !j.jobReservedIs(null))
/* 244 */       return null;  return j; } private boolean conn(Humanoid a, AIManager d) { return (job(a, d) != null && this.module.moduleCanContinue(a, d) && this.module.getPriority(a, d) > 0); }
/*     */ 
/*     */ 
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 249 */     if (e.type == HPoll.WORKING)
/* 250 */       return 1.0D; 
/* 251 */     return super.poll(a, d, e);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void name(Humanoid a, AIManager d, Str string) {
/* 256 */     string.add((blue(d).employment()).verb);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\retired\AIModule_Retired$Plan.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */