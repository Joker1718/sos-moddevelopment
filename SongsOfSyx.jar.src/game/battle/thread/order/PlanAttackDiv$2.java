/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormation;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.formation.DivPositionCopyable;
/*     */ import game.battle.formation.DivPositionImp;
/*     */ import game.battle.thread.status.BattleStatus;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import init.constant.Config;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   private final byte[] dirs;
/*     */   
/*     */   null(BattleOrderUpdater.Plan paramPlan, String $anonymous0) {
/* 301 */     super($anonymous0);
/*     */     
/* 303 */     this.dirs = Alloc.bb((Config.battle()).MEN_PER_DIVISION);
/*     */   }
/*     */ 
/*     */   
/*     */   void update(int gameMillis) {
/* 308 */     PlanAttackDiv.this.timer.inc(PlanAttackDiv.m, -gameMillis);
/* 309 */     if (PlanAttackDiv.this.timer.get(PlanAttackDiv.m) > 0)
/*     */       return; 
/* 311 */     PlanAttackDiv.this.timer.set(PlanAttackDiv.m, 1000);
/*     */ 
/*     */ 
/*     */     
/* 315 */     DivFormationImp nn = PlanAttackDiv.this.retreatedDest(0);
/* 316 */     if (nn == null) {
/* 317 */       PlanAttackDiv.this.fail.set();
/*     */       
/*     */       return;
/*     */     } 
/* 321 */     PlanAttackDiv.dest.copy(PlanAttackDiv.this.t.mover.getFromMovedIntoTo((DivPositionImp)PlanAttackDiv.current, nn));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 327 */     (PlanAttackDiv.div.order()).dest.set(PlanAttackDiv.dest);
/*     */     
/* 329 */     nn = PlanAttackDiv.dest;
/*     */ 
/*     */     
/* 332 */     PlanAttackDiv.this.res.deployInit(nn.dir(), nn.start().x(), nn.start().y(), nn.dx(), nn.dy(), nn.formation(), nn.width());
/*     */     
/* 334 */     Div target = PlanAttackDiv.task.targetDiv();
/* 335 */     if (target == null) {
/* 336 */       PlanAttackDiv.this.fail.set();
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 341 */     DivPositionCopyable divPositionCopyable = PlanAttackDiv.task.targetDiv().current();
/* 342 */     PathUtilOnline.Flooder f = PlanAttackDiv.this.t.pather.getFlooder();
/* 343 */     f.init(this);
/*     */     
/* 345 */     for (int i = 0; i < target.deployed(); i++) {
/* 346 */       if (target.reporter.reachable(i)) {
/* 347 */         PlanAttackDiv.this.proj.smark(divPositionCopyable.px(i), divPositionCopyable.py(i));
/*     */       }
/*     */     } 
/* 350 */     int cx = PlanAttackDiv.task.targetDiv().centre().cUnitX();
/* 351 */     int cy = PlanAttackDiv.task.targetDiv().centre().cUnitY();
/*     */     
/* 353 */     LIST<Tools.Pos> ll = PlanAttackDiv.this.t.getPosColumnSort((DivFormation)nn);
/* 354 */     for (int pi = 0; pi < ll.size(); pi++) {
/* 355 */       Tools.Pos pos = (Tools.Pos)ll.get(pi);
/* 356 */       double sx = nn.px(pos.pos);
/* 357 */       double sy = nn.py(pos.pos);
/* 358 */       double m = PlanAttackDiv.this.vec.set(sx, sy, cx, cy);
/*     */       
/* 360 */       DIR d = PlanAttackDiv.this.vec.dir();
/*     */       
/* 362 */       PlanAttackDiv.this.vec.set(nn.dx(), nn.dy());
/* 363 */       PlanAttackDiv.this.vec.rotate90().rotate90().rotate90();
/*     */       
/* 365 */       if (deploy(sx, sy, PlanAttackDiv.this.vec.nX(), PlanAttackDiv.this.vec.nY(), m)) {
/* 366 */         this.dirs[pi] = (byte)d.id();
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 372 */         PlanAttackDiv.this.res.deploy((int)sx, (int)sy, (DIV_SPEC)PlanAttackDiv.div.info);
/* 373 */         this.dirs[pi] = (byte)PlanAttackDiv.prev.dir().id();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 379 */     f.done();
/* 380 */     PlanAttackDiv.this.res.deployFinish(PlanAttackDiv.this.t.pather.filler, (DIV_SPEC)PlanAttackDiv.div.info);
/* 381 */     PlanAttackDiv.this.res.coherentSetNot();
/* 382 */     for (int j = 0; j < PlanAttackDiv.this.res.deployed(); j++) {
/* 383 */       PlanAttackDiv.this.res.setDir(j, (DIR)DIR.ALL.get(this.dirs[j]));
/*     */     }
/*     */     
/* 386 */     PlanAttackDiv.nextPos = PlanAttackDiv.this.t.mover.getFromMovedIntoTo((DivPositionImp)PlanAttackDiv.current, PlanAttackDiv.this.res);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean deploy(double sx, double sy, double dx, double dy, double m) {
/* 391 */     for (int dist = 0; dist <= m; PlanAttackDiv.this.proj.getClass(), dist += 32) {
/* 392 */       int x = (int)(sx + dx * dist);
/* 393 */       int y = (int)(sy + dy * dist);
/*     */       
/* 395 */       if (PlanAttackDiv.this.proj.is(x, y) || (BattleStatus.map()).hasEnemy.is(x / 64, y / 64, PlanAttackDiv.a)) {
/*     */         
/* 397 */         PlanAttackDiv.this.res.deploy(x, y, (DIV_SPEC)PlanAttackDiv.div.info);
/* 398 */         PlanAttackDiv.this.proj.getClass(); x = (int)(sx + dx * (dist - 32));
/* 399 */         PlanAttackDiv.this.proj.getClass(); y = (int)(sy + dy * (dist - 32));
/* 400 */         PlanAttackDiv.this.proj.mark(x, y);
/* 401 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 405 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean setAction() {
/* 410 */     PlanAttackDiv.this.timer.set(PlanAttackDiv.m, 0);
/* 411 */     update(0);
/* 412 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PlanAttackDiv$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */