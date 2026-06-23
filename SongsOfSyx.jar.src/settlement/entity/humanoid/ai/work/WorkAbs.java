/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.ai.util.AIPlanResourceMany;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.JOBMANAGER_HASER;
/*     */ import settlement.misc.job.JOB_MANAGER;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.ShortCoo;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ 
/*     */ class WorkAbs
/*     */   extends PlanBlueprint
/*     */ {
/*  28 */   private static CharSequence ¤¤walk = "¤walking to job";
/*  29 */   private static CharSequence ¤¤storing = "¤storing resource";
/*  30 */   private static CharSequence ¤¤working = "¤working"; private final Works works; static int crashI; private final AIPLAN.PLANRES.Resumer walkToRoom; private final AIPlanResourceMany fetch; private final AIPLAN.PLANRES.Resumer walkToJob; private final AIPLAN.PLANRES.Resumer walkToJobAjacent; final AIPLAN.PLANRES.Resumer storeResource; final AIPLAN.PLANRES.Resumer work; final AIPLAN.PLANRES.Resumer returnResource;
/*     */   
/*     */   static {
/*  33 */     D.ts(WorkAbs.class);
/*     */   }
/*     */ 
/*     */   
/*     */   WorkAbs(AIModule_Work module, RoomBlueprintIns<?> blueprint, PlanBlueprint[] map, Works works)
/*     */   {
/*  39 */     super(module, blueprint, map);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 158 */     this.walkToRoom = new AIPLAN.PLANRES.Resumer(this, ¤¤walk)
/*     */       {
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d)
/*     */         {
/* 162 */           STATS.WORK().proximityEnd(a);
/* 163 */           return WorkAbs.this.init(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 168 */           return (WorkAbs.work(a) != null);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 173 */           STATS.WORK().proximityEnd(a);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 178 */           if (WorkAbs.work(a).blueprintI() == (SETT.ROOMS()).JANITOR) {
/* 179 */             return null;
/*     */           }
/* 181 */           if (WorkAbs.this.isInRoom(a))
/* 182 */             return null; 
/* 183 */           STATS.WORK().proximityStart(a);
/*     */           
/* 185 */           JOB_MANAGER jm = ((JOBMANAGER_HASER)WorkAbs.work(a)).getWork();
/* 186 */           SETT_JOB j = jm.getReservableJob(a.tc());
/* 187 */           if (j != null) {
/* 188 */             AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, j.jobCoo());
/* 189 */             if (s != null) {
/* 190 */               return s;
/*     */             }
/*     */           } 
/* 193 */           if (STATS.WORK().shouldReportForWork(a)) {
/* 194 */             AISUB.AISubActivation s = (AI.SUBS()).walkTo.room(a, d, WorkAbs.work(a));
/* 195 */             if (s != null) {
/* 196 */               return s;
/*     */             }
/*     */           } 
/*     */           
/* 200 */           can(a, d);
/* 201 */           return null;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 218 */     this.fetch = new AIPlanResourceMany(this, 64)
/*     */       {
/*     */         public AISUB.AISubActivation next(Humanoid a, AIManager d)
/*     */         {
/* 222 */           SETT_JOB j = WorkAbs.this.jobGet(a, d);
/* 223 */           if (j == null) {
/* 224 */             d.resourceDrop(a);
/* 225 */             return null;
/*     */           } 
/*     */           
/* 228 */           return WorkAbs.this.walk(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public void cancel(Humanoid a, AIManager d) {
/* 233 */           WorkAbs.this.jobCancel(a, d, resource(a, d));
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 258 */     this.walkToJob = new AIPLAN.PLANRES.Resumer(this, ¤¤walk)
/*     */       {
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d)
/*     */         {
/* 264 */           SETT_JOB j = ((JOBMANAGER_HASER)WorkAbs.work(a)).getWork().getJob((COORDINATE)d.planTile);
/* 265 */           if (WorkAbs.this.resource(d) != null) {
/* 266 */             STATS.WORK().fetchProximityEnd(a);
/* 267 */             int am = CLAMP.i(d.resourceA(), 0, j.jobResourcesNeeded(a));
/* 268 */             j.jobPerform(a, WorkAbs.this.resource(d), am);
/* 269 */             d.resourceAInc(-am);
/* 270 */             d.resourceDrop(a);
/* 271 */             return WorkAbs.this.init(a, d);
/*     */           } 
/* 273 */           if (j.jobPerformTime(a) == 0.0D) {
/* 274 */             return WorkAbs.this.storeResource.set(a, d);
/*     */           }
/* 276 */           return WorkAbs.this.work(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 282 */           return WorkAbs.this.jobIsReservedAndReserve(a, d, WorkAbs.this.resource(d));
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 287 */           WorkAbs.this.jobCancel(a, d, WorkAbs.this.resource(d));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 292 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)d.planTile);
/* 293 */           if (s == null) {
/* 294 */             can(a, d);
/*     */           }
/* 296 */           return s;
/*     */         }
/*     */       };
/*     */     
/* 300 */     this.walkToJobAjacent = new AIPLAN.PLANRES.Resumer(this, ¤¤walk)
/*     */       {
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d)
/*     */         {
/* 304 */           return WorkAbs.this.walkToJob.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 309 */           return WorkAbs.this.jobIsReservedAndReserve(a, d, WorkAbs.this.resource(d));
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 314 */           WorkAbs.this.jobCancel(a, d, WorkAbs.this.resource(d));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 319 */           DIR dir = WorkAbs.this.jobGet(a, d).jobStandDir();
/* 320 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, d.planTile.x() + dir.x(), d.planTile.y() + dir.y());
/* 321 */           if (s == null) {
/* 322 */             can(a, d);
/*     */           }
/* 324 */           return s;
/*     */         }
/*     */       };
/*     */     
/* 328 */     this.storeResource = new AIPLAN.PLANRES.Resumer(this, ¤¤storing)
/*     */       {
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d)
/*     */         {
/* 332 */           return WorkAbs.this.init(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 337 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 347 */           SETT_JOB j = WorkAbs.this.jobGet(a, d);
/* 348 */           RESOURCE res = j.jobPerform(a, null, 0);
/* 349 */           if (res == null)
/*     */           {
/* 351 */             return WorkAbs.this.init(a, d);
/*     */           }
/* 353 */           return (AI.SUBS()).walkTo.deposit(a, d, res);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 361 */     this.work = new AIPLAN.PLANRES.Resumer(this, ¤¤working)
/*     */       {
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d)
/*     */         {
/* 365 */           d.resourceCarriedSet(null);
/* 366 */           SETT_JOB j = WorkAbs.this.jobGet(a, d);
/* 367 */           if (j == null) {
/* 368 */             WorkAbs.this.jobCancel(a, d, WorkAbs.this.resource(d));
/* 369 */             return null;
/*     */           } 
/* 371 */           RESOURCE res = j.jobPerform(a, null, 0);
/* 372 */           if (res != null) {
/* 373 */             WorkAbs.this.returnResource.set(a, d);
/* 374 */             return (AI.SUBS()).walkTo.deposit(a, d, res);
/*     */           } 
/* 376 */           return WorkAbs.this.finishedWork(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 381 */           return WorkAbs.this.jobIsReservedAndReserve(a, d, WorkAbs.this.resource(d));
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 386 */           WorkAbs.this.jobCancel(a, d, WorkAbs.this.resource(d));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 392 */           SETT_JOB j = WorkAbs.this.jobGet(a, d);
/* 393 */           if (j == null) {
/* 394 */             WorkAbs.this.jobCancel(a, d, WorkAbs.this.resource(d));
/* 395 */             return null;
/*     */           } 
/* 397 */           j.jobStartPerforming();
/* 398 */           if (j.jobPerformTime(a) <= 0.0D)
/* 399 */             return res(a, d); 
/* 400 */           if (j.jobUseTool())
/* 401 */             return WorkAbs.this.works.subTool.activate(a, d, j); 
/* 402 */           if (j.jobUseHands()) {
/* 403 */             return WorkAbs.this.works.subHands.activate(a, d, j);
/*     */           }
/* 405 */           return WorkAbs.this.works.subThink.activate(a, d, j);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void name(Humanoid a, AIManager d, Str string) {
/* 410 */           if (WorkAbs.this.jobGet(a, d) != null) {
/* 411 */             string.add(WorkAbs.this.jobGet(a, d).jobName());
/*     */           } else {
/* 413 */             super.name(a, d, string);
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 424 */     this.returnResource = new AIPLAN.PLANRES.Resumer(this, ¤¤storing)
/*     */       {
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d)
/*     */         {
/* 428 */           return WorkAbs.this.init(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 433 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 442 */           return null; } }; this.works = works; } WorkAbs(String key, AIModule_Work module, RoomBlueprintIns<?> blueprint, PlanBlueprint[] map, Works works) { super(key, module, blueprint, map); this.walkToRoom = new AIPLAN.PLANRES.Resumer(this, ¤¤walk) { protected AISUB.AISubActivation res(Humanoid a, AIManager d) { STATS.WORK().proximityEnd(a); return WorkAbs.this.init(a, d); } public boolean con(Humanoid a, AIManager d) { return (WorkAbs.work(a) != null); } public void can(Humanoid a, AIManager d) { STATS.WORK().proximityEnd(a); } protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) { if (WorkAbs.work(a).blueprintI() == (SETT.ROOMS()).JANITOR) return null;  if (WorkAbs.this.isInRoom(a)) return null;  STATS.WORK().proximityStart(a); JOB_MANAGER jm = ((JOBMANAGER_HASER)WorkAbs.work(a)).getWork(); SETT_JOB j = jm.getReservableJob(a.tc()); if (j != null) { AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, j.jobCoo()); if (s != null) return s;  }  if (STATS.WORK().shouldReportForWork(a)) { AISUB.AISubActivation s = (AI.SUBS()).walkTo.room(a, d, WorkAbs.work(a)); if (s != null) return s;  }  can(a, d); return null; } }; this.fetch = new AIPlanResourceMany(this, 64) { public AISUB.AISubActivation next(Humanoid a, AIManager d) { SETT_JOB j = WorkAbs.this.jobGet(a, d); if (j == null) { d.resourceDrop(a); return null; }  return WorkAbs.this.walk(a, d); } public void cancel(Humanoid a, AIManager d) { WorkAbs.this.jobCancel(a, d, resource(a, d)); } }; this.walkToJob = new AIPLAN.PLANRES.Resumer(this, ¤¤walk) { protected AISUB.AISubActivation res(Humanoid a, AIManager d) { SETT_JOB j = ((JOBMANAGER_HASER)WorkAbs.work(a)).getWork().getJob((COORDINATE)d.planTile); if (WorkAbs.this.resource(d) != null) { STATS.WORK().fetchProximityEnd(a); int am = CLAMP.i(d.resourceA(), 0, j.jobResourcesNeeded(a)); j.jobPerform(a, WorkAbs.this.resource(d), am); d.resourceAInc(-am); d.resourceDrop(a); return WorkAbs.this.init(a, d); }  if (j.jobPerformTime(a) == 0.0D) return WorkAbs.this.storeResource.set(a, d);  return WorkAbs.this.work(a, d); } public boolean con(Humanoid a, AIManager d) { return WorkAbs.this.jobIsReservedAndReserve(a, d, WorkAbs.this.resource(d)); } public void can(Humanoid a, AIManager d) { WorkAbs.this.jobCancel(a, d, WorkAbs.this.resource(d)); } protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) { AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)d.planTile); if (s == null) can(a, d);  return s; } }; this.walkToJobAjacent = new AIPLAN.PLANRES.Resumer(this, ¤¤walk) { protected AISUB.AISubActivation res(Humanoid a, AIManager d) { return WorkAbs.this.walkToJob.set(a, d); } public boolean con(Humanoid a, AIManager d) { return WorkAbs.this.jobIsReservedAndReserve(a, d, WorkAbs.this.resource(d)); } public void can(Humanoid a, AIManager d) { WorkAbs.this.jobCancel(a, d, WorkAbs.this.resource(d)); } protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) { return null; } protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) { DIR dir = WorkAbs.this.jobGet(a, d).jobStandDir(); AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, d.planTile.x() + dir.x(), d.planTile.y() + dir.y()); if (s == null) can(a, d);  return s; } }; this.storeResource = new AIPLAN.PLANRES.Resumer(this, ¤¤storing) { protected AISUB.AISubActivation res(Humanoid a, AIManager d) { return WorkAbs.this.init(a, d); } public boolean con(Humanoid a, AIManager d) { return true; } public void can(Humanoid a, AIManager d) {} protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) { SETT_JOB j = WorkAbs.this.jobGet(a, d); RESOURCE res = j.jobPerform(a, null, 0); if (res == null) return WorkAbs.this.init(a, d);  return (AI.SUBS()).walkTo.deposit(a, d, res); } }
/*     */       ; this.work = new AIPLAN.PLANRES.Resumer(this, ¤¤working) { protected AISUB.AISubActivation res(Humanoid a, AIManager d) { d.resourceCarriedSet(null); SETT_JOB j = WorkAbs.this.jobGet(a, d); if (j == null) { WorkAbs.this.jobCancel(a, d, WorkAbs.this.resource(d)); return null; }  RESOURCE res = j.jobPerform(a, null, 0); if (res != null) { WorkAbs.this.returnResource.set(a, d); return (AI.SUBS()).walkTo.deposit(a, d, res); }  return WorkAbs.this.finishedWork(a, d); } public boolean con(Humanoid a, AIManager d) { return WorkAbs.this.jobIsReservedAndReserve(a, d, WorkAbs.this.resource(d)); } public void can(Humanoid a, AIManager d) { WorkAbs.this.jobCancel(a, d, WorkAbs.this.resource(d)); } protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) { SETT_JOB j = WorkAbs.this.jobGet(a, d); if (j == null) { WorkAbs.this.jobCancel(a, d, WorkAbs.this.resource(d)); return null; }  j.jobStartPerforming(); if (j.jobPerformTime(a) <= 0.0D) return res(a, d);  if (j.jobUseTool()) return WorkAbs.this.works.subTool.activate(a, d, j);  if (j.jobUseHands()) return WorkAbs.this.works.subHands.activate(a, d, j);  return WorkAbs.this.works.subThink.activate(a, d, j); } protected void name(Humanoid a, AIManager d, Str string) { if (WorkAbs.this.jobGet(a, d) != null) { string.add(WorkAbs.this.jobGet(a, d).jobName()); } else { super.name(a, d, string); }  } }
/*     */       ; this.returnResource = new AIPLAN.PLANRES.Resumer(this, ¤¤storing) { protected AISUB.AISubActivation res(Humanoid a, AIManager d) { return WorkAbs.this.init(a, d); } public boolean con(Humanoid a, AIManager d) { return true; } public void can(Humanoid a, AIManager d) {} }
/*     */       ; this.works = works; } static class Works {
/*     */     final SubWork.SubWorkTool subTool = new SubWork.SubWorkTool("WORK_TOOL") { protected SETT_JOB getJob(Humanoid a, AIManager d) { if (WorkAbs.work(a) == null) return null;  return ((JOBMANAGER_HASER)WorkAbs.work(a)).getWork().getJob((COORDINATE)d.planTile); } }
/* 447 */     ; final SubWork.SubWorkHands subHands = new SubWork.SubWorkHands("WORK_HANDS") { protected SETT_JOB getJob(Humanoid a, AIManager d) { if (WorkAbs.work(a) == null) return null;  return ((JOBMANAGER_HASER)WorkAbs.work(a)).getWork().getJob((COORDINATE)d.planTile); } }; final SubWork.SubWorkThink subThink = new SubWork.SubWorkThink("WORK_THINK") { protected SETT_JOB getJob(Humanoid a, AIManager d) { if (WorkAbs.work(a) == null) return null;  return ((JOBMANAGER_HASER)WorkAbs.work(a)).getWork().getJob((COORDINATE)d.planTile); } }; } protected AISUB.AISubActivation init(Humanoid a, AIManager d) { if (!this.module.moduleCanContinue(a, d) || !hasEmployment(a, d)) return null;  if ((STATS.WORK()).WORK_TIME.indu().getD(a.indu()) == 1.0D) return null;  AISUB.AISubActivation s = this.walkToRoom.set(a, d); if (s != null) return s;  JOB_MANAGER jm = ((JOBMANAGER_HASER)work(a)).getWork(); COORDINATE cc = null; if (work(a).blueprintI() == (SETT.ROOMS()).JANITOR) { cc = a.physics.tileC(); } else if (work(a).is((COORDINATE)d.planTile) && a.physics.tileC().tileDistanceTo((COORDINATE)d.planTile) == 1.0D) { ShortCoo shortCoo = d.planTile; } else if (work(a).is(a.physics.tileC())) { cc = a.physics.tileC(); }  SETT_JOB j = jm.getReservableJob(cc); if (j == null) return null;  crashI = 0; return initBegin(a, d, j, jm); } protected AISUB.AISubActivation initBegin(Humanoid a, AIManager d, SETT_JOB j, JOB_MANAGER jm) { if (crashI++ > 1000) throw new RuntimeException(String.valueOf(work(a)) + " " + String.valueOf(work(a)) + " " + String.valueOf(j));  d.planTile.set(j.jobCoo()); d.planByte1 = -1; RBIT res = j.jobResourceBitToFetch(); if (res != null && !res.isClear()) { AISUB.AISubActivation s = this.fetch.activate(a, d, res, CLAMP.i(j.jobResourcesNeeded(a), 0, AIModule_Work.MAX_FETCH_AMOUNT), j.longFetch() ? 1000 : AIModule_Work.MAX_FETCH_DISTANCE, true, true); if (s == null) { j = jm.reportResourceMissing(res, d.planTile.x(), d.planTile.y()); if (j == null) return null;  return initBegin(a, d, j, jm); }  STATS.WORK().fetchProximityStart(a); d.planByte1 = (byte)this.fetch.resource(a, d).index(); jm.reportResourceFound(resource(d)); j.jobReserve(resource(d)); return s; }  j.jobReserve(null); return walk(a, d); } private boolean isInRoom(Humanoid a) { if (work(a).is(a.tc())) return true;  for (DIR dd : DIR.ORTHO) { if (work(a).is(a.tc(), dd)) return true;  }  return false; } private AISUB.AISubActivation walk(Humanoid a, AIManager d) { SETT_JOB j = jobGet(a, d); if (j == null) return null;  if (resource(d) == null && (j.jobResourceBitToFetch() == null || j.jobResourceBitToFetch().isClear())) { DIR dir = jobGet(a, d).jobStandDir(); if (dir != null && !a.tc().isSameAs((d.planTile.x() + dir.x()), (d.planTile.y() + dir.y()))) return this.walkToJobAjacent.set(a, d);  if (a.tc().tileDistanceTo((COORDINATE)d.planTile) == 1.0D && DIR.get(a.tc(), (COORDINATE)d.planTile) == a.speed.dir()) return this.work.set(a, d);  }  return this.walkToJob.set(a, d); } protected AISUB.AISubActivation work(Humanoid a, AIManager d) { return this.work.set(a, d); } protected AISUB.AISubActivation finishedWork(Humanoid a, AIManager d) { return init(a, d); } private RESOURCE resource(AIManager d) { if (d.planByte1 == -1)
/* 448 */       return null; 
/* 449 */     return (RESOURCE)RESOURCES.ALL().get(d.planByte1); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String debug(Humanoid a, AIManager d) {
/* 455 */     return super.debug(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkAbs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */