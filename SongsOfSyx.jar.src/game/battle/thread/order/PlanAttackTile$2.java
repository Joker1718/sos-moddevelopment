/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 271 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   void update(int gameMillis) {
/* 275 */     PlanAttackTile.shouldBreak = true;
/* 276 */     int tx = PlanAttackTile.task.targetTileX();
/* 277 */     int ty = PlanAttackTile.task.targetTileY();
/* 278 */     if (!PlanAttackTile.this.breakable(tx, ty)) {
/* 279 */       DIR d = DIR.get(PlanAttackTile.dest.dx(), PlanAttackTile.dest.dy()).next(-2);
/* 280 */       int dx = tx + d.x();
/* 281 */       int dy = ty + d.y();
/*     */       
/* 283 */       if (PlanAttackTile.this.breakable(dx, dy)) {
/* 284 */         PlanAttackTile.task.attack(dx, dy, PlanAttackTile.div);
/* 285 */         PlanAttackTile.order.task.set(PlanAttackTile.task);
/* 286 */         PlanAttackTile.this.setI.set(PlanAttackTile.m, PlanAttackTile.order.task.setI() & 0xFF);
/*     */       } 
/*     */     } 
/*     */     
/* 290 */     for (int i = 0; i < PlanAttackTile.dest.deployed(); i++) {
/* 291 */       if (PlanAttackTile.this.availability(PlanAttackTile.dest.tile(i).x(), PlanAttackTile.dest.tile(i).y()) < 0.0D && (GAME.ARMIES()).map.attackable.is(PlanAttackTile.dest.tile(i), PlanAttackTile.a)) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */     
/* 296 */     PlanAttackTile.this.wait.set();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean setAction() {
/* 303 */     PlanAttackTile.this.vec.set(PlanAttackTile.dest.dx(), PlanAttackTile.dest.dy());
/* 304 */     PlanAttackTile.this.vec.rotate90().rotate90().rotate90();
/* 305 */     int dx = (int)(PlanAttackTile.this.vec.nX() * 36.0D);
/* 306 */     int dy = (int)(PlanAttackTile.this.vec.nY() * 36.0D);
/* 307 */     PlanAttackTile.dest.copy(PlanAttackTile.this.t.deployer.move((DIV_SPEC)PlanAttackTile.div.info, PlanAttackTile.dest, dx, dy, PlanAttackTile.a));
/* 308 */     PlanAttackTile.order.dest.set(PlanAttackTile.dest);
/* 309 */     PlanAttackTile.nextPos = PlanAttackTile.dest;
/* 310 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PlanAttackTile$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */