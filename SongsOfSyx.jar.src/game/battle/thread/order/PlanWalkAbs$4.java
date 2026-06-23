/*     */ package game.battle.thread.order;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends BattleOrderUpdater.Plan.STATE
/*     */ {
/*     */   null(BattleOrderUpdater.Plan paramPlan, String $anonymous0) {
/* 303 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   boolean setAction() {
/* 307 */     PlanWalkAbs.path.clear();
/* 308 */     PlanWalkAbs.order.path.set(PlanWalkAbs.path);
/* 309 */     PlanWalkAbs.this.t.mover.rearrangeDest(PlanWalkAbs.prev, PlanWalkAbs.dest);
/* 310 */     PlanWalkAbs.order.dest.set(PlanWalkAbs.dest);
/* 311 */     int di = PlanWalkAbs.order.dest.setI() & 0xF;
/* 312 */     PlanWalkAbs.this.destId.set(PlanWalkAbs.m, di);
/* 313 */     PlanWalkAbs.this.timer.set(PlanWalkAbs.m, 100);
/* 314 */     PlanWalkAbs.this.inPosition.set(PlanWalkAbs.m, PlanWalkAbs.this.t.walk.countPosition());
/* 315 */     update(0);
/* 316 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   void update(int gamemillis) {
/* 321 */     if (PlanWalkAbs.this.checkNextDest()) {
/* 322 */       PlanWalkAbs.this.wait.set();
/*     */       return;
/*     */     } 
/* 325 */     if (wait(PlanWalkAbs.m, gamemillis))
/*     */       return; 
/* 327 */     if (!PlanWalkAbs.this.t.mover.merge(PlanWalkAbs.prev, PlanWalkAbs.dest)) {
/* 328 */       PlanWalkAbs.this.stayInDest.set();
/*     */       
/*     */       return;
/*     */     } 
/* 332 */     PlanWalkAbs.nextPos = PlanWalkAbs.prev;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean wait(BattleOrderUpdater.PlanData m, int gamemillis) {
/* 337 */     PlanWalkAbs.this.timer.inc(m, -gamemillis);
/* 338 */     int in = PlanWalkAbs.this.t.walk.countPosition();
/*     */     
/* 340 */     if (in == 0) {
/* 341 */       return true;
/*     */     }
/* 343 */     if (in < PlanWalkAbs.this.inPosition.get(m)) {
/* 344 */       PlanWalkAbs.this.timer.inc(m, -gamemillis);
/* 345 */       if (PlanWalkAbs.this.timer.get(m) <= 0) {
/* 346 */         PlanWalkAbs.this.inPosition.inc(m, -1);
/* 347 */         PlanWalkAbs.this.timer.set(m, 100);
/*     */       } 
/* 349 */       return true;
/*     */     } 
/* 351 */     PlanWalkAbs.this.inPosition.set(m, in);
/*     */     
/* 353 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PlanWalkAbs$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */