/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.BUILDING_PREFS;
/*     */ import init.type.HTYPES;
/*     */ import init.type.WGROUP;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.food.farm.ROOM_FARM;
/*     */ import settlement.room.food.fish.ROOM_FISHERY;
/*     */ import settlement.room.food.hunter.ROOM_HUNTER;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEmploymentSimple;
/*     */ import settlement.room.service.arena.grand.ROOM_ARENA;
/*     */ import settlement.room.service.arena.pit.ROOM_FIGHTPIT;
/*     */ import settlement.room.service.pleasure.ROOM_PLEASURE;
/*     */ import settlement.room.spirit.grave.GraveData;
/*     */ import settlement.room.spirit.temple.ROOM_TEMPLE;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AIModule_Work
/*     */   extends AIModule
/*     */ {
/*  38 */   public static int MAX_FETCH_DISTANCE = 250;
/*  39 */   public static int MAX_FETCH_AMOUNT = 6;
/*     */   
/*  41 */   private final PlanBlueprint[] map = new PlanBlueprint[SETT.ROOMS().all().size()];
/*     */   
/*  43 */   private final AIPLAN hangArround = (AIPLAN)new PlanHangArround("workHang");
/*     */   
/*  45 */   final PlanOddjobber oddjobber = new PlanOddjobber("workOdd");
/*  46 */   private final PlanFetchEquip equip = new PlanFetchEquip("workEquip");
/*     */   
/*  48 */   private static CharSequence ¤¤name = "Work";
/*  49 */   private static CharSequence ¤¤desc = "Spend time working"; private final Swapper swapper;
/*     */   static {
/*  51 */     D.ts(AIModule_Work.class);
/*     */   }
/*     */   
/*     */   public AIModule_Work() {
/*  55 */     super((SPRITE)(UI.icons()).s.hammer, ¤¤name, ¤¤desc);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 254 */     this.swapper = new Swapper(); WorkAbs.Works w = new WorkAbs.Works(); for (ROOM_FARM b : (SETT.ROOMS()).FARMS); for (RoomBlueprintIns<?> b : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).MINES); for (RoomBlueprintIns<?> b : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).PASTURES); for (ROOM_FISHERY b : (SETT.ROOMS()).FISHERIES); for (GraveData.GRAVE_DATA_HOLDER h : (SETT.ROOMS()).GRAVES); for (ROOM_HUNTER h : (SETT.ROOMS()).HUNTERS); for (ROOM_PLEASURE h : (SETT.ROOMS()).BROTHELS); for (RoomBlueprintIns<?> p : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).PHYSICIANS); for (RoomBlueprintIns<?> p : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).EATERIES); for (RoomBlueprintIns<?> p : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).CANTEENS); for (RoomBlueprintIns<?> p : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).TAVERNS); for (RoomBlueprintIns<?> p : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).LAVATORIES); for (RoomBlueprintIns<?> p : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).BATHS); for (RoomBlueprintIns<?> p : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).WORKSHOPS); for (RoomBlueprintIns<?> p : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).REFINERS); for (RoomBlueprintIns<?> p : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).LIBRARIES); for (RoomBlueprintIns<?> p : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).LABORATORIES); for (RoomBlueprintIns<?> p : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).ADMINS); for (RoomBlueprintIns<?> p : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).NURSERIES); for (RoomBlueprintIns<?> p : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).SCHOOLS); for (ROOM_TEMPLE p : (SETT.ROOMS()).TEMPLES.ALL); for (RoomBlueprintIns<?> p : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).SPEAKERS) WorkOrator.getSpeaker(this, p, this.map);  for (RoomBlueprintIns<?> p : (Iterable<RoomBlueprintIns<?>>)(SETT.ROOMS()).STAGES) WorkOrator.getDancer(this, p, this.map);  for (ROOM_FIGHTPIT b : (SETT.ROOMS()).FIGHTPITS); for (ROOM_ARENA b : (SETT.ROOMS()).GARENAS); for (RoomBlueprint b : SETT.ROOMS().all()) { if (b instanceof RoomBlueprintIns) { RoomBlueprintIns<?> p = (RoomBlueprintIns)b; if (p.employmentExtra() != null && this.map[p.index()] == null); }  } 
/*     */   }
/* 256 */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) { (AIModules.data()).byte2.set(d, 0); STATS.WORK().slackStart(a); if (!validateEmployment(a, d)) { if (!PlanOddjobber.hasOddjob(a, true)) return null;  if (GAME.ARMIES().enemy().men() > 0) return null;  AIPLAN.AiPlanActivation aiPlanActivation = this.oddjobber.activateOddjobber(a, d); return aiPlanActivation; }  this.swapper.swap(a); PlanBlueprint b = this.map[work(a).blueprint().index()]; if (b == null) throw new RuntimeException(String.valueOf((work(a).blueprintI()).info.name));  AIPLAN.AiPlanActivation p = this.equip.activate(a, d); if (p != null) return p;  p = b.activate(a, d); if (p == null) { if (b.shouldReportWorkFailure(a, d)) (AIModules.data()).byte2.set(d, 1);  if (PlanOddjobber.hasOddjob(a, false) && GAME.ARMIES().enemy().men() == 0) { p = this.oddjobber.activateHelpOut(a, d); if (p != null) return p;  }  if (p == null) return this.hangArround.activate(a, d);  } else { (AIModules.data()).byte2.set(d, 2); }  return p; } public void swapInstance(Humanoid a) { this.swapper.swap(a); } protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int upI) {} private boolean validateEmployment(Humanoid a, AIManager d) { (SETT.ROOMS()).employment.setWork(a);
/*     */ 
/*     */ 
/*     */     
/* 260 */     if (work(a) != null && work(a).acceptsWork() && this.map[work(a).blueprint().index()] != null)
/*     */     {
/* 262 */       return true;
/*     */     }
/* 264 */     return false; }
/*     */   protected void finish(Humanoid a, AIManager d) { int i = (AIModules.data()).byte2.get(d); if (i == 1) { STATS.WORK().slackEnd(a, true); } else if (i == 2) { STATS.WORK().slackEnd(a, false); }  super.finish(a, d); }
/*     */   public int getPriority(Humanoid a, AIManager d) { if (work(a) == null && !(SETT.ROOMS()).employment.hasWork(a)) { if (GAME.ARMIES().enemy().men() > 0) return 0;  if (!PlanOddjobber.hasOddjob(a, true)) return 0;  }  if ((GAME.events()).riot.onStrike(a)) return 0;  if (STATS.WORK().getWorkPriority(a) > 0.0D) return 5;  return 0; }
/*     */   public int getPriority(Humanoid a) { return getPriority(a, (AIManager)a.ai()); }
/* 268 */   private static RoomInstance work(Humanoid a) { return (RoomInstance)(STATS.WORK()).EMPLOYED.get(a.indu()); } public boolean isLawEnforcement(Humanoid a, AIManager d) { return !(a.indu().hType() != HTYPES.RECRUIT() && a.indu().hType() != HTYPES.GUARD()); }
/*     */ 
/*     */   
/*     */   public static double getTransportAmount(Humanoid a) {
/* 272 */     AIManager d = (AIManager)a.ai();
/* 273 */     if (d.plan() instanceof PlanBlueprint) {
/* 274 */       PlanBlueprint t = (PlanBlueprint)d.plan();
/* 275 */       return t.transportAmount(a, d);
/*     */     } 
/* 277 */     return -1.0D;
/*     */   }
/*     */   
/*     */   private static class Swapper
/*     */   {
/* 282 */     private W[] misplaced = new W[(SETT.ROOMS()).employment.ALLS().size()];
/*     */     
/*     */     Swapper() {
/* 285 */       for (RoomEmploymentSimple s : (SETT.ROOMS()).employment.ALLS()) {
/* 286 */         this.misplaced[s.eindex()] = new W(s);
/*     */       }
/*     */     }
/*     */     
/*     */     private void swap(Humanoid h) {
/* 291 */       RoomInstance w = AIModule_Work.work(h);
/*     */       
/* 293 */       WGROUP group = group(h);
/* 294 */       double p = stayPriority(group, w);
/* 295 */       if (p >= 1.0D) {
/*     */         return;
/*     */       }
/* 298 */       W wer = this.misplaced[w.blueprintI().employment().eindex()];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 305 */       RoomInstance w2 = updateBestRoom(wer, group);
/*     */       
/* 307 */       if (w2 != null && w != w2 && stayPriority(group, w2) > p) {
/* 308 */         (STATS.WORK()).EMPLOYED.set(h, w2);
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */ 
/*     */       
/* 315 */       Humanoid h2 = wer.get(group);
/* 316 */       if (h2 != null) {
/* 317 */         RoomInstance roomInstance = AIModule_Work.work(h2);
/* 318 */         if (w != roomInstance) {
/*     */           
/* 320 */           double swap = stayPriority(group, roomInstance) + stayPriority(group(h2), w);
/* 321 */           swap -= stayPriority(group, w) + stayPriority(group(h2), roomInstance);
/*     */           
/* 323 */           if (swap > 0.0D) {
/* 324 */             h2.interrupt();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 330 */             (STATS.WORK()).EMPLOYED.set(h2, w);
/* 331 */             (STATS.WORK()).EMPLOYED.set(h, roomInstance);
/* 332 */             wer.set(null, group);
/*     */ 
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 342 */       for (int i = 0; i < WGROUP.all().size(); i++) {
/* 343 */         WGROUP g = (WGROUP)WGROUP.all().get(i);
/* 344 */         if (group != g) {
/*     */           
/* 346 */           Humanoid nn = wer.get(g);
/* 347 */           if (nn == null) {
/* 348 */             wer.set(h, g);
/*     */           } else {
/* 350 */             double p2 = stayPriority(group(nn), AIModule_Work.work(nn));
/* 351 */             if (p < p2) {
/* 352 */               wer.set(h, g);
/* 353 */             } else if (p == p2 && RND.oneIn(w.blueprintI().employment().employed())) {
/* 354 */               wer.set(h, g);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     private RoomInstance updateBestRoom(W wer, WGROUP group) {
/* 362 */       if (wer.roomCounts[group.index] >= wer.emp.blueprint().instancesSize()) {
/* 363 */         wer.roomCounts[group.index] = 0;
/*     */       }
/* 365 */       RoomInstance nextBestWork = getEmployableRoom(wer.emp.blueprint(), wer.roomCounts[group.index]);
/* 366 */       wer.roomCounts[group.index] = wer.roomCounts[group.index] + 1;
/*     */       
/* 368 */       RoomInstance currentBestWork = getEmployableRoom(wer.emp.blueprint(), wer.currentRoom[group.index]);
/*     */       
/* 370 */       if (nextBestWork != null)
/*     */       {
/* 372 */         if (currentBestWork == null) {
/* 373 */           wer.currentRoom[group.index] = wer.roomCounts[group.index];
/* 374 */           currentBestWork = nextBestWork;
/*     */         } else {
/* 376 */           double cp = stayPriority(group, currentBestWork);
/* 377 */           double np = stayPriority(group, nextBestWork);
/* 378 */           if (np > cp || (np == cp && nextBestWork.employees().target() - nextBestWork.employees().employed() > currentBestWork.employees().target() - currentBestWork.employees().employed())) {
/* 379 */             wer.currentRoom[group.index] = wer.roomCounts[group.index];
/* 380 */             currentBestWork = nextBestWork;
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 385 */       return currentBestWork;
/*     */     }
/*     */     
/*     */     private RoomInstance getEmployableRoom(RoomBlueprintIns<?> current, int ri) {
/* 389 */       if (ri < current.instancesSize()) {
/* 390 */         RoomInstance ins = current.getInstance(ri);
/* 391 */         if (ins.active() && ins.employees().employed() < ins.employees().target()) {
/* 392 */           return ins;
/*     */         }
/*     */       } 
/* 395 */       return null;
/*     */     }
/*     */     
/*     */     public double stayPriority(WGROUP group, RoomInstance work) {
/* 399 */       if (work == null) {
/* 400 */         return 1.0D;
/*     */       }
/* 402 */       if (work.employees().preffered().is(group))
/* 403 */         return 1.0D; 
/* 404 */       return 0.5D * group.race.pref().structure(BUILDING_PREFS.get(work.mX(), work.mY()));
/*     */     }
/*     */ 
/*     */     
/*     */     private static class W
/*     */     {
/*     */       public final RoomEmploymentSimple emp;
/* 411 */       private Humanoid[] as = new Humanoid[WGROUP.all().size()];
/* 412 */       private int[] roomCounts = Alloc.ii(WGROUP.all().size());
/* 413 */       private int[] currentRoom = Alloc.ii(WGROUP.all().size());
/*     */       
/*     */       W(RoomEmploymentSimple emp) {
/* 416 */         this.emp = emp;
/*     */       }
/*     */       
/*     */       public Humanoid get(WGROUP g) {
/* 420 */         Humanoid a = this.as[g.index];
/* 421 */         if (a != null) {
/* 422 */           if (!a.isRemoved() && AIModule_Work.Swapper.group(a) != g) {
/* 423 */             RoomInstance ins = AIModule_Work.work(a);
/* 424 */             if (ins != null && ins.blueprintI().employment() == this.emp)
/* 425 */               return a; 
/*     */           } 
/* 427 */           this.as[g.index] = null;
/*     */         } 
/* 429 */         return null;
/*     */       }
/*     */       
/*     */       private void set(Humanoid h, WGROUP g) {
/* 433 */         this.as[g.index] = h;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     private static WGROUP group(Humanoid h) {
/* 439 */       return (WGROUP.get(h) == null) ? WGROUP.get(HTYPES.SUBJECT(), h.race()) : WGROUP.get(h);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\AIModule_Work.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */