/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.formation.DivPlacability;
/*     */ import game.battle.formation.DivPositionImp;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import settlement.main.SETT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  97 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   void update(int gameMillis) {
/* 102 */     if (PlanCharge.div.status().engagements() > 0) {
/* 103 */       PlanCharge.this.timer.inc(PlanCharge.m, gameMillis);
/* 104 */       if (PlanCharge.this.timer.get(PlanCharge.m) > 2000) {
/* 105 */         PlanCharge.this.stop();
/*     */         return;
/*     */       } 
/*     */     } else {
/* 109 */       PlanCharge.this.timer.set(PlanCharge.m, 0);
/*     */     } 
/*     */     
/* 112 */     PlanCharge.this.timer2.inc(PlanCharge.m, gameMillis);
/*     */     
/* 114 */     if (PlanCharge.this.timer2.get(PlanCharge.m) > 15000 && !PlanCharge.div.army().player()) {
/* 115 */       PlanCharge.this.stop();
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 121 */     if (PlanCharge.this.inPosition() == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     PlanCharge.this.vec.set(PlanCharge.prev.dx(), PlanCharge.prev.dy());
/* 129 */     PlanCharge.this.vec.rotate90().rotate90().rotate90();
/* 130 */     int sx = (int)(PlanCharge.prev.start().x() + PlanCharge.this.vec.nX() * 64.0D);
/* 131 */     int sy = (int)(PlanCharge.prev.start().y() + PlanCharge.this.vec.nY() * 64.0D);
/*     */     
/* 133 */     if (!SETT.PIXEL_IN_BOUNDS(sx, sy) || !SETT.PIXEL_IN_BOUNDS((int)(sx + PlanCharge.prev.dx() * PlanCharge.prev.width()), (int)(sy + PlanCharge.prev.dy() * PlanCharge.prev.width()))) {
/* 134 */       PlanCharge.task.stop(PlanCharge.div);
/* 135 */       PlanCharge.order.task.set(PlanCharge.task);
/*     */       
/*     */       return;
/*     */     } 
/* 139 */     PlanCharge.this.vec.set(PlanCharge.prev.dx(), PlanCharge.prev.dy());
/*     */     
/* 141 */     DivFormationImp f = PlanCharge.this.t.deployer.deploy((DIV_SPEC)PlanCharge.div.info, PlanCharge.men, (PlanCharge.div.settings()).formation, sx, sy, PlanCharge.prev.dx(), PlanCharge.prev.dy(), PlanCharge.prev.width(), PlanCharge.a);
/* 142 */     if (f != null && f.deployed() > 0) {
/*     */       
/* 144 */       PlanCharge.prev.copy(PlanCharge.this.t.mover.getFromMovedIntoTo((DivPositionImp)PlanCharge.prev, f));
/*     */       
/* 146 */       PlanCharge.nextPos = PlanCharge.prev;
/*     */       
/*     */       return;
/*     */     } 
/* 150 */     double largestGap = -1.0D;
/* 151 */     int largestI1 = -1;
/*     */     
/* 153 */     int size = (PlanCharge.div.settings()).formation.size(PlanCharge.div);
/*     */     
/* 155 */     for (int d = 0; d <= PlanCharge.prev.width(); d += size) {
/* 156 */       int x1 = (int)(sx + d * PlanCharge.this.vec.nX()) + size / 2;
/* 157 */       int y1 = (int)(sy + d * PlanCharge.this.vec.nY()) + size / 2;
/*     */       
/* 159 */       if (!DivPlacability.pixelIsBlocked(x1, y1, size, PlanCharge.a)) {
/* 160 */         int am = 1;
/* 161 */         int di = d;
/* 162 */         while (d <= PlanCharge.prev.width()) {
/* 163 */           int x = (int)(sx + d * PlanCharge.this.vec.nX());
/* 164 */           int y = (int)(sy + d * PlanCharge.this.vec.nY());
/* 165 */           if (!DivPlacability.pixelIsBlocked(x, y, size, PlanCharge.a)) {
/* 166 */             am++;
/* 167 */             d += size;
/*     */           } 
/*     */           break;
/*     */         } 
/* 171 */         if (am > largestGap) {
/* 172 */           largestGap = am;
/* 173 */           largestI1 = di;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 179 */     if (largestI1 == -1) {
/* 180 */       PlanCharge.this.stop();
/*     */       return;
/*     */     } 
/* 183 */     int cx = (int)(sx + largestI1 * PlanCharge.this.vec.nX());
/* 184 */     int cy = (int)(sy + largestI1 * PlanCharge.this.vec.nY());
/*     */     
/* 186 */     f = PlanCharge.this.t.deployer.deploy((DIV_SPEC)PlanCharge.div.info, PlanCharge.men, (PlanCharge.div.settings()).formation, cx, cy, PlanCharge.prev.dx(), PlanCharge.prev.dy(), (int)(largestGap * (PlanCharge.div.settings()).formation.size(PlanCharge.div)), PlanCharge.a);
/*     */     
/* 188 */     if (f != null && f.deployed() > 0) {
/* 189 */       PlanCharge.prev.copy(PlanCharge.this.t.mover.getFromMovedIntoTo((DivPositionImp)PlanCharge.prev, f));
/*     */     } else {
/*     */       
/* 192 */       PlanCharge.this.stop();
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   boolean setAction() {
/* 199 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PlanCharge$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */