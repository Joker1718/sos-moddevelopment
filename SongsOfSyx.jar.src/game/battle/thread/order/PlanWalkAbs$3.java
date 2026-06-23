/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 180 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   boolean setAction() {
/* 184 */     PlanWalkAbs.this.tilesDestCheck.set(PlanWalkAbs.m, 10);
/* 185 */     PlanWalkAbs.this.inPosition.set(PlanWalkAbs.m, PlanWalkAbs.this.t.walk.countPosition());
/* 186 */     PlanWalkAbs.this.timer.set(PlanWalkAbs.m, 0);
/* 187 */     PlanWalkAbs.this.colTimer.set(PlanWalkAbs.m, 0);
/* 188 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void update(int gameMillis) {
/* 196 */     double sp = speed(gameMillis);
/*     */     
/* 198 */     if (sp == 0.0D) {
/*     */       return;
/*     */     }
/* 201 */     if (PlanWalkAbs.path.isDest()) {
/* 202 */       resume();
/*     */       return;
/*     */     } 
/* 205 */     PlanWalkAbs.order.path.get(PlanWalkAbs.path);
/* 206 */     PlanWalkAbs.this.tilesDestCheck.inc(PlanWalkAbs.m, -1);
/* 207 */     int pi = PlanWalkAbs.path.currentI();
/* 208 */     if (!PlanWalkAbs.this.t.walk.setNextPosition(80 + PlanWalkAbs.this.tilesDestCheck.get(PlanWalkAbs.m), (int)Math.ceil(gameMillis * sp))) {
/* 209 */       PlanWalkAbs.this.init();
/*     */       return;
/*     */     } 
/* 212 */     if (pi != PlanWalkAbs.path.currentI() && 
/* 213 */       PlanWalkAbs.this.checkNextDest()) {
/* 214 */       PlanWalkAbs.this.wait.set();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double speed(int gameMillis) {
/* 235 */     int in = PlanWalkAbs.this.t.walk.countPosition();
/*     */     
/* 237 */     if (in == 0) {
/* 238 */       PlanWalkAbs.this.colTimer.inc(PlanWalkAbs.m, gameMillis);
/* 239 */       if (PlanWalkAbs.this.colTimer.get(PlanWalkAbs.m) > 3000) {
/* 240 */         PlanWalkAbs.this.setStart.set();
/* 241 */       } else if (PlanWalkAbs.path.currentI() < PlanWalkAbs.path.length() - 1) {
/*     */         
/* 243 */         COORDINATE cc = PlanWalkAbs.this.t.div.currentCentre();
/* 244 */         double d1 = cc.tileDistanceTo(PlanWalkAbs.path.x(), PlanWalkAbs.path.y());
/* 245 */         PlanWalkAbs.path.currentIInc(1);
/* 246 */         double d2 = cc.tileDistanceTo(PlanWalkAbs.path.x(), PlanWalkAbs.path.y());
/* 247 */         PlanWalkAbs.path.currentIInc(-1);
/*     */         
/* 249 */         if (d1 > d2 + 3.0D) {
/* 250 */           if (!PlanWalkAbs.this.t.walk.setNextPosition(80 + PlanWalkAbs.this.tilesDestCheck.get(PlanWalkAbs.m), gameMillis)) {
/*     */             
/* 252 */             PlanWalkAbs.this.init();
/* 253 */             return 0.0D;
/*     */           } 
/*     */ 
/*     */           
/* 257 */           PlanWalkAbs.this.timer.set(PlanWalkAbs.m, 0);
/* 258 */           PlanWalkAbs.this.colTimer.set(PlanWalkAbs.m, 0);
/* 259 */           return 0.0D;
/*     */         } 
/*     */       } 
/*     */       
/* 263 */       return 0.0D;
/*     */     } 
/* 265 */     PlanWalkAbs.this.colTimer.set(PlanWalkAbs.m, 0);
/*     */     
/* 267 */     if (PlanWalkAbs.this.running()) {
/* 268 */       return 1.0D;
/*     */     }
/* 270 */     in += PlanWalkAbs.unreachable;
/*     */     
/* 272 */     if (in >= PlanWalkAbs.prev.deployed()) {
/* 273 */       return 1.0D;
/*     */     }
/* 275 */     double d = ((PlanWalkAbs.men - in) / PlanWalkAbs.men);
/* 276 */     return CLAMP.d(0.25D + d, 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   void resume() {
/* 281 */     if (PlanWalkAbs.path.isDest() && PlanWalkAbs.path.isComplete()) {
/* 282 */       PlanWalkAbs.this.moveIntoDest.set();
/*     */       return;
/*     */     } 
/* 285 */     if (!PlanWalkAbs.this.t.walk.setStart(90)) {
/* 286 */       PlanWalkAbs.this.init();
/*     */       return;
/*     */     } 
/* 289 */     if (PlanWalkAbs.this.t.div.intersectsSomewhat(PlanWalkAbs.prev, PlanWalkAbs.dest)) {
/* 290 */       PlanWalkAbs.this.moveIntoDest.set();
/*     */     } else {
/* 292 */       PlanWalkAbs.this.inPosition.set(PlanWalkAbs.m, CLAMP.i(PlanWalkAbs.this.t.walk.countPosition(), 0, PlanWalkAbs.men));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PlanWalkAbs$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */