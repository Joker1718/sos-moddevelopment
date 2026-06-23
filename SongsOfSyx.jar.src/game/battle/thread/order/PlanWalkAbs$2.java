/*     */ package game.battle.thread.order;
/*     */ 
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
/*     */ class null
/*     */   extends BattleOrderUpdater.Plan.STATE
/*     */ {
/*     */   null(BattleOrderUpdater.Plan paramPlan, String $anonymous0) {
/*  88 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean setAction() {
/*  93 */     if (!PlanWalkAbs.this.t.walk.setStart(90)) {
/*  94 */       return PlanWalkAbs.this.moveIntoDest.set();
/*     */     }
/*     */     
/*  97 */     if (PlanWalkAbs.this.t.div.intersectsSomewhat(PlanWalkAbs.prev, PlanWalkAbs.dest)) {
/*  98 */       return PlanWalkAbs.this.moveIntoDest.set();
/*     */     }
/* 100 */     PlanWalkAbs.this.timer.set(PlanWalkAbs.m, 0);
/* 101 */     PlanWalkAbs.this.inPosition.set(PlanWalkAbs.m, PlanWalkAbs.this.t.walk.countPosition());
/* 102 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void update(int gamemillis) {
/* 108 */     if (PlanWalkAbs.men == 0) {
/*     */       return;
/*     */     }
/* 111 */     if (PlanWalkAbs.this.checkNextDest()) {
/*     */       
/* 113 */       PlanWalkAbs.this.wait.set();
/*     */       
/*     */       return;
/*     */     } 
/* 117 */     if (PlanWalkAbs.prev.deployed() == 0) {
/* 118 */       PlanWalkAbs.task.stop(PlanWalkAbs.div);
/* 119 */       (PlanWalkAbs.div.order()).task.set(PlanWalkAbs.task);
/*     */       
/*     */       return;
/*     */     } 
/* 123 */     if (PlanWalkAbs.prev.deployed() > 0 && PlanWalkAbs.this.t.div.fixIfNeeded(PlanWalkAbs.prev)) {
/* 124 */       PlanWalkAbs.nextPos = PlanWalkAbs.prev;
/*     */     }
/*     */     
/* 127 */     int pos = PlanWalkAbs.this.t.walk.countPosition();
/* 128 */     if (pos > 0) {
/* 129 */       if (pos == 1) {
/* 130 */         PlanWalkAbs.this.timer.set(PlanWalkAbs.m, 0);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 135 */       if (pos >= PlanWalkAbs.men - PlanWalkAbs.unreachable || PlanWalkAbs.this.running()) {
/* 136 */         PlanWalkAbs.this.followPath.set();
/*     */         
/*     */         return;
/*     */       } 
/* 140 */       PlanWalkAbs.this.timer.inc(PlanWalkAbs.m, gamemillis);
/* 141 */       if (pos > PlanWalkAbs.this.inPosition.get(PlanWalkAbs.m)) {
/* 142 */         PlanWalkAbs.this.timer.set(PlanWalkAbs.m, 0);
/*     */       }
/* 144 */       PlanWalkAbs.this.inPosition.set(PlanWalkAbs.m, pos);
/*     */ 
/*     */       
/* 147 */       if (PlanWalkAbs.this.running() || PlanWalkAbs.this.t.div.isCloseToFighting() || PlanWalkAbs.this.timer.get(PlanWalkAbs.m) >= 1500) {
/* 148 */         PlanWalkAbs.this.followPath.set();
/*     */         return;
/*     */       } 
/*     */     } else {
/* 152 */       PlanWalkAbs.this.timer.inc(PlanWalkAbs.m, gamemillis);
/* 153 */       if (PlanWalkAbs.this.timer.get(PlanWalkAbs.m) > 1000) {
/* 154 */         setAction();
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 159 */     if (PlanWalkAbs.path.isDest()) {
/*     */       return;
/*     */     }
/*     */     
/* 163 */     if (PlanWalkAbs.path.currentI() < PlanWalkAbs.path.length() - 1) {
/* 164 */       COORDINATE cc = PlanWalkAbs.this.t.div.currentCentre();
/* 165 */       double d1 = cc.tileDistanceTo(PlanWalkAbs.path.x(), PlanWalkAbs.path.y());
/* 166 */       PlanWalkAbs.path.currentIInc(1);
/* 167 */       double d2 = cc.tileDistanceTo(PlanWalkAbs.path.x(), PlanWalkAbs.path.y());
/* 168 */       PlanWalkAbs.path.currentIInc(-1);
/*     */       
/* 170 */       if (d1 <= d2 + 3.0D)
/*     */         return; 
/* 172 */       PlanWalkAbs.this.t.walk.setNextPosition(90, gamemillis);
/* 173 */       PlanWalkAbs.this.timer.set(PlanWalkAbs.m, 0);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PlanWalkAbs$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */