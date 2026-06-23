/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import init.type.BUILDING_PREFS;
/*     */ import init.type.HTYPES;
/*     */ import init.type.WGROUP;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEmploymentSimple;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Swapper
/*     */ {
/* 282 */   private W[] misplaced = new W[(SETT.ROOMS()).employment.ALLS().size()];
/*     */   
/*     */   Swapper() {
/* 285 */     for (RoomEmploymentSimple s : (SETT.ROOMS()).employment.ALLS()) {
/* 286 */       this.misplaced[s.eindex()] = new W(s);
/*     */     }
/*     */   }
/*     */   
/*     */   private void swap(Humanoid h) {
/* 291 */     RoomInstance w = AIModule_Work.work(h);
/*     */     
/* 293 */     WGROUP group = group(h);
/* 294 */     double p = stayPriority(group, w);
/* 295 */     if (p >= 1.0D) {
/*     */       return;
/*     */     }
/* 298 */     W wer = this.misplaced[w.blueprintI().employment().eindex()];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 305 */     RoomInstance w2 = updateBestRoom(wer, group);
/*     */     
/* 307 */     if (w2 != null && w != w2 && stayPriority(group, w2) > p) {
/* 308 */       (STATS.WORK()).EMPLOYED.set(h, w2);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 315 */     Humanoid h2 = wer.get(group);
/* 316 */     if (h2 != null) {
/* 317 */       RoomInstance roomInstance = AIModule_Work.work(h2);
/* 318 */       if (w != roomInstance) {
/*     */         
/* 320 */         double swap = stayPriority(group, roomInstance) + stayPriority(group(h2), w);
/* 321 */         swap -= stayPriority(group, w) + stayPriority(group(h2), roomInstance);
/*     */         
/* 323 */         if (swap > 0.0D) {
/* 324 */           h2.interrupt();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 330 */           (STATS.WORK()).EMPLOYED.set(h2, w);
/* 331 */           (STATS.WORK()).EMPLOYED.set(h, roomInstance);
/* 332 */           wer.set(null, group);
/*     */ 
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 342 */     for (int i = 0; i < WGROUP.all().size(); i++) {
/* 343 */       WGROUP g = (WGROUP)WGROUP.all().get(i);
/* 344 */       if (group != g) {
/*     */         
/* 346 */         Humanoid nn = wer.get(g);
/* 347 */         if (nn == null) {
/* 348 */           wer.set(h, g);
/*     */         } else {
/* 350 */           double p2 = stayPriority(group(nn), AIModule_Work.work(nn));
/* 351 */           if (p < p2) {
/* 352 */             wer.set(h, g);
/* 353 */           } else if (p == p2 && RND.oneIn(w.blueprintI().employment().employed())) {
/* 354 */             wer.set(h, g);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private RoomInstance updateBestRoom(W wer, WGROUP group) {
/* 362 */     if (wer.roomCounts[group.index] >= wer.emp.blueprint().instancesSize()) {
/* 363 */       wer.roomCounts[group.index] = 0;
/*     */     }
/* 365 */     RoomInstance nextBestWork = getEmployableRoom(wer.emp.blueprint(), wer.roomCounts[group.index]);
/* 366 */     wer.roomCounts[group.index] = wer.roomCounts[group.index] + 1;
/*     */     
/* 368 */     RoomInstance currentBestWork = getEmployableRoom(wer.emp.blueprint(), wer.currentRoom[group.index]);
/*     */     
/* 370 */     if (nextBestWork != null)
/*     */     {
/* 372 */       if (currentBestWork == null) {
/* 373 */         wer.currentRoom[group.index] = wer.roomCounts[group.index];
/* 374 */         currentBestWork = nextBestWork;
/*     */       } else {
/* 376 */         double cp = stayPriority(group, currentBestWork);
/* 377 */         double np = stayPriority(group, nextBestWork);
/* 378 */         if (np > cp || (np == cp && nextBestWork.employees().target() - nextBestWork.employees().employed() > currentBestWork.employees().target() - currentBestWork.employees().employed())) {
/* 379 */           wer.currentRoom[group.index] = wer.roomCounts[group.index];
/* 380 */           currentBestWork = nextBestWork;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 385 */     return currentBestWork;
/*     */   }
/*     */   
/*     */   private RoomInstance getEmployableRoom(RoomBlueprintIns<?> current, int ri) {
/* 389 */     if (ri < current.instancesSize()) {
/* 390 */       RoomInstance ins = current.getInstance(ri);
/* 391 */       if (ins.active() && ins.employees().employed() < ins.employees().target()) {
/* 392 */         return ins;
/*     */       }
/*     */     } 
/* 395 */     return null;
/*     */   }
/*     */   
/*     */   public double stayPriority(WGROUP group, RoomInstance work) {
/* 399 */     if (work == null) {
/* 400 */       return 1.0D;
/*     */     }
/* 402 */     if (work.employees().preffered().is(group))
/* 403 */       return 1.0D; 
/* 404 */     return 0.5D * group.race.pref().structure(BUILDING_PREFS.get(work.mX(), work.mY()));
/*     */   }
/*     */ 
/*     */   
/*     */   private static class W
/*     */   {
/*     */     public final RoomEmploymentSimple emp;
/* 411 */     private Humanoid[] as = new Humanoid[WGROUP.all().size()];
/* 412 */     private int[] roomCounts = Alloc.ii(WGROUP.all().size());
/* 413 */     private int[] currentRoom = Alloc.ii(WGROUP.all().size());
/*     */     
/*     */     W(RoomEmploymentSimple emp) {
/* 416 */       this.emp = emp;
/*     */     }
/*     */     
/*     */     public Humanoid get(WGROUP g) {
/* 420 */       Humanoid a = this.as[g.index];
/* 421 */       if (a != null) {
/* 422 */         if (!a.isRemoved() && AIModule_Work.Swapper.group(a) != g) {
/* 423 */           RoomInstance ins = AIModule_Work.work(a);
/* 424 */           if (ins != null && ins.blueprintI().employment() == this.emp)
/* 425 */             return a; 
/*     */         } 
/* 427 */         this.as[g.index] = null;
/*     */       } 
/* 429 */       return null;
/*     */     }
/*     */     
/*     */     private void set(Humanoid h, WGROUP g) {
/* 433 */       this.as[g.index] = h;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static WGROUP group(Humanoid h) {
/* 439 */     return (WGROUP.get(h) == null) ? WGROUP.get(HTYPES.SUBJECT(), h.race()) : WGROUP.get(h);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\AIModule_Work$Swapper.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */