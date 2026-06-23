/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.util.DIV_SPEC;
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
/*     */ class null
/*     */   extends BattleOrderUpdater.Plan.STATE
/*     */ {
/*     */   null(BattleOrderUpdater.Plan paramPlan, String $anonymous0) {
/* 163 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void update(int gameMillis) {
/* 170 */     PlanStop.shouldBreak = true;
/* 171 */     PlanStop.this.timer.inc(PlanStop.m, gameMillis);
/* 172 */     PlanStop.this.timer2.inc(PlanStop.m, gameMillis);
/* 173 */     if (PlanStop.this.timer.get(PlanStop.m) < 1000)
/*     */       return; 
/* 175 */     PlanStop.this.timer.set(PlanStop.m, 0);
/* 176 */     PlanStop.nextPos = PlanStop.prev;
/*     */     
/* 178 */     if (PlanStop.this.t.div.fixIfNeeded(PlanStop.dest)) {
/* 179 */       PlanStop.order.dest.set(PlanStop.dest);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 185 */     int ddx = PlanStop.prev.start().x() - PlanStop.dest.start().x();
/* 186 */     int ddy = PlanStop.prev.start().y() - PlanStop.dest.start().y();
/* 187 */     double engagement = PlanStop.this.engagement(PlanStop.dest, ddx, ddy);
/*     */ 
/*     */     
/* 190 */     if (engagement > 0.0D) {
/*     */       
/* 192 */       PlanStop.this.timer2.set(PlanStop.m, 0);
/*     */       
/* 194 */       PlanStop.this.unfuckPrev();
/*     */ 
/*     */ 
/*     */       
/* 198 */       if (!(PlanStop.div.settings()).guard) {
/* 199 */         if (engagement > 1.25D) {
/* 200 */           tryStep(PlanStop.this.stepBack(engagement));
/* 201 */         } else if (engagement < 0.2D) {
/* 202 */           tryStep(PlanStop.this.stepForward(engagement));
/* 203 */         }  PlanStop.this.advanceColumn(2.0D);
/* 204 */       } else if (engagement > 1.25D) {
/* 205 */         if (engagement > 1.25D) {
/* 206 */           tryStep(PlanStop.this.stepBack(engagement));
/* 207 */           PlanStop.this.advanceColumn(1.0D);
/* 208 */         } else if (engagement < 0.2D) {
/* 209 */           tryStep(PlanStop.this.stepForward(engagement));
/* 210 */         }  PlanStop.this.advanceColumn(1.0D);
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 219 */       if (ddx != 0 || ddy != 0) {
/* 220 */         PlanStop.this.timer2.set(PlanStop.m, 0);
/*     */         
/* 222 */         PlanStop.this.unfuckPrev();
/*     */ 
/*     */ 
/*     */         
/* 226 */         double m = PlanStop.this.vec.set(ddx, ddy);
/*     */         
/* 228 */         m = CLAMP.d(m, 0.0D, 64.0D);
/* 229 */         PlanStop.nextPos = PlanStop.this.t.deployer.move((DIV_SPEC)PlanStop.div.info, PlanStop.prev, -((int)Math.round(PlanStop.this.vec.nX() * m)), -((int)Math.round(PlanStop.this.vec.nY() * m)), PlanStop.a);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 234 */       PlanStop.nextPos = PlanStop.dest;
/*     */       
/* 236 */       if (!(PlanStop.div.settings()).guard) {
/* 237 */         PlanStop.this.advanceColumn(2.0D);
/* 238 */       } else if (!PlanStop.this.t.walk.hasReachedPrev() && PlanStop.this.timer.get(PlanStop.m) > 5000) {
/* 239 */         PlanStop.task.move(PlanStop.div);
/* 240 */         (PlanStop.div.order()).task.set(PlanStop.task);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void tryStep(DivFormationImp n) {
/* 251 */     if (n == null)
/*     */       return; 
/* 253 */     PlanStop.dest.copy(n);
/* 254 */     PlanStop.nextPos = PlanStop.dest;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean setAction() {
/* 259 */     PlanStop.this.timer.set(PlanStop.m, 0);
/* 260 */     PlanStop.this.timer2.set(PlanStop.m, 0);
/* 261 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PlanStop$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */