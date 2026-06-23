/*     */ package settlement.entity.humanoid.ai.types.student;
/*     */ 
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISTATES;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.knowledge.university.ROOM_UNIVERSITY;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.text.D;
/*     */ 
/*     */ final class Plan
/*     */   extends AIPLAN.PLANRES {
/*  23 */   private static CharSequence ¤¤study = "¤studying"; private final AIModule_Student module; final AIPLAN.PLANRES.Resumer walk; final AIPLAN.PLANRES.Resumer walkLast; final AIPLAN.PLANRES.Resumer study;
/*     */   final AIPLAN.PLANRES.Resumer lecture;
/*     */   
/*     */   static {
/*  27 */     D.ts(Plan.class);
/*     */   }
/*     */   
/*     */   Plan(AIModule_Student module) {
/*  31 */     super("student");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     this.walk = new AIPLAN.PLANRES.Resumer(this, ¤¤study)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  75 */           JOBMANAGER_HASER jobs = Plan.this.jobs(a);
/*  76 */           if (jobs == null) {
/*  77 */             return null;
/*     */           }
/*  79 */           SETT_JOB j = jobs.getWork().getReservableJob(a.tc());
/*     */           
/*  81 */           if (j == null)
/*  82 */             return null; 
/*  83 */           j.jobReserve(null);
/*  84 */           d.planTile.set(j.jobCoo());
/*  85 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)d.planTile);
/*  86 */           if (s == null) {
/*  87 */             Plan.this.cancel(a, d);
/*     */           }
/*  89 */           return s;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  94 */           if (!Plan.this.conn(a, d)) {
/*  95 */             Plan.this.cancel(a, d);
/*  96 */             return null;
/*     */           } 
/*  98 */           if (!Plan.this.uni(a).isLecturer((COORDINATE)d.planTile))
/*  99 */             return Plan.this.walkLast.set(a, d); 
/* 100 */           return Plan.this.lecture.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 105 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 114 */     this.walkLast = new AIPLAN.PLANRES.Resumer(this, ¤¤study)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 118 */           DIR dir = Plan.this.uni(a).spotDir((COORDINATE)d.planTile);
/*     */           
/* 120 */           AISTATE s = (AI.STATES()).WALK2.edge(a, d, dir);
/* 121 */           a.speed.setDirCurrent(dir);
/* 122 */           return (AI.SUBS()).DUMMY.activate(a, d, s);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 127 */           if (!Plan.this.conn(a, d)) {
/* 128 */             Plan.this.cancel(a, d);
/* 129 */             return null;
/*     */           } 
/*     */           
/* 132 */           a.speed.magnitudeTargetSet(0.0D);
/* 133 */           a.speed.magnitudeInit(0.0D);
/* 134 */           return Plan.this.study.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 139 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 148 */     this.study = new AIPLAN.PLANRES.Resumer(this, ¤¤study)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 152 */           return res(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 158 */           if (!Plan.this.conn(a, d)) {
/* 159 */             Plan.this.cancel(a, d);
/* 160 */             return null;
/*     */           } 
/*     */           
/* 163 */           ROOM_UNIVERSITY u = Plan.this.uni(a);
/* 164 */           if (!u.isTime.is()) {
/* 165 */             Plan.this.cancel(a, d);
/* 166 */             return null;
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 171 */           DIR dir = u.spotDir((COORDINATE)d.planTile);
/* 172 */           if (RND.oneIn(5)) {
/* 173 */             dir = dir.next(-1 + RND.rInt(3));
/*     */           }
/* 175 */           a.speed.setDirCurrent(dir);
/* 176 */           return (AI.SUBS()).STAND.activateTime(a, d, 5);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 182 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 192 */     this.lecture = new AIPLAN.PLANRES.Resumer(this, ¤¤study)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 196 */           return res(a, d);
/*     */         }
/*     */         
/* 199 */         final AISTATES.Animation[] anima = new AISTATES.Animation[] {
/* 200 */             (AI.STATES()).anima.carry, 
/* 201 */             (AI.STATES()).anima.fist, 
/* 202 */             (AI.STATES()).anima.grab, 
/* 203 */             (AI.STATES()).anima.fistRight, 
/* 204 */             (AI.STATES()).anima.fistRight, 
/* 205 */             (AI.STATES()).anima.fistRight
/*     */           };
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 210 */           if (!Plan.this.conn(a, d)) {
/* 211 */             Plan.this.cancel(a, d);
/* 212 */             return null;
/*     */           } 
/*     */           
/* 215 */           ROOM_UNIVERSITY u = Plan.this.uni(a);
/* 216 */           if (!u.isTime.is()) {
/* 217 */             Plan.this.cancel(a, d);
/* 218 */             return null;
/*     */           } 
/*     */           
/* 221 */           if (RND.oneIn(4)) {
/* 222 */             a.speed.setDirCurrent(a.speed.dir().next(-1 + RND.rInt(3)));
/*     */           }
/*     */           
/* 225 */           if (RND.oneIn(2)) {
/* 226 */             return (AI.SUBS()).single.activate(a, d, this.anima[RND.rInt(this.anima.length)], (2 + RND.rInt(3)));
/*     */           }
/* 228 */           return (AI.SUBS()).STAND.activateTime(a, d, 3 + RND.rInt(4));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 235 */           return true;
/*     */         } public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */     this.module = module;
/*     */   } protected AISUB.AISubActivation init(Humanoid a, AIManager d) { (AI.modules()).work.swapInstance(a);
/*     */     return this.walk.set(a, d); } private final ROOM_UNIVERSITY uni(Humanoid a) {
/*     */     RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a);
/*     */     if (ins == null)
/*     */       return null; 
/*     */     if (ins.blueprintI() instanceof ROOM_UNIVERSITY)
/*     */       return (ROOM_UNIVERSITY)ins.blueprintI(); 
/*     */     return null;
/* 247 */   } protected void cancel(Humanoid a, AIManager d) { SETT_JOB j = job(a, d);
/* 248 */     if (j != null)
/* 249 */       j.jobReserveCancel(null);  }
/*     */   private final JOBMANAGER_HASER jobs(Humanoid a) { RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a); if (ins == null) return null;  if (ins.blueprintI() instanceof ROOM_UNIVERSITY) return (JOBMANAGER_HASER)ins;  return null; }
/*     */   private final SETT_JOB job(Humanoid a, AIManager d) { JOBMANAGER_HASER jj = jobs(a); if (jj == null)
/*     */       return null;  SETT_JOB j = jj.getWork().getJob((COORDINATE)d.planTile); if (j == null || !j.jobReservedIs(null))
/* 253 */       return null;  return j; } private boolean conn(Humanoid a, AIManager d) { return (this.module.moduleCanContinue(a, d) && AIModule_Student.shouldContinue(a, d) && job(a, d) != null); }
/*     */ 
/*     */ 
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 258 */     if (e.type == HPoll.WORKING)
/* 259 */       return 1.0D; 
/* 260 */     return super.poll(a, d, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\student\Plan.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */