/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormation;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.formation.DivPlacability;
/*     */ import game.battle.formation.DivPosition;
/*     */ import game.battle.formation.DivPositionCopyable;
/*     */ import game.battle.formation.DivPositionImp;
/*     */ import game.battle.thread.status.BattleStatus;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import init.constant.Config;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.DataOSimple;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ class PlanAttackDiv
/*     */   extends PlanWalkAbs
/*     */ {
/*     */   private final INT_O.INT_OE<BattleOrderUpdater.PlanData> pathI;
/*     */   protected final INT_O.INT_OE<BattleOrderUpdater.PlanData> pathd;
/*     */   protected final INT_O.INT_OE<BattleOrderUpdater.PlanData> width;
/*     */   protected final INT_O.INT_OE<BattleOrderUpdater.PlanData> timer;
/*     */   protected final INT_O.INT_OE<BattleOrderUpdater.PlanData> targetID;
/*  32 */   private final VectorImp vec = new VectorImp();
/*  33 */   private final Projector proj = new Projector(); protected final BattleOrderUpdater.Plan.STATE fail; DivFormationImp res;
/*     */   protected final BattleOrderUpdater.Plan.STATE fight;
/*     */   protected final BattleOrderUpdater.Plan.STATE fightGuard;
/*     */   
/*  37 */   public PlanAttackDiv(Tools tools, LISTE<BattleOrderUpdater.Plan> all, BattleOrderUpdater.Data data) { super(tools, all, data, BattleOrderTask.DIVTASK.ATTACK_MELEE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 284 */     this.fail = new BattleOrderUpdater.Plan.STATE(this, "fail")
/*     */       {
/*     */         void update(int gameMillis) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         boolean setAction() {
/* 293 */           PlanAttackDiv.task.stop(PlanAttackDiv.div);
/* 294 */           PlanAttackDiv.order.task.set(PlanAttackDiv.task);
/* 295 */           return true;
/*     */         }
/*     */       };
/*     */     
/* 299 */     this.res = new DivFormationImp();
/*     */     
/* 301 */     this.fight = new BattleOrderUpdater.Plan.STATE(this, "fight")
/*     */       {
/* 303 */         private final byte[] dirs = Alloc.bb((Config.battle()).MEN_PER_DIVISION);
/*     */ 
/*     */ 
/*     */         
/*     */         void update(int gameMillis) {
/* 308 */           PlanAttackDiv.this.timer.inc(PlanAttackDiv.m, -gameMillis);
/* 309 */           if (PlanAttackDiv.this.timer.get(PlanAttackDiv.m) > 0)
/*     */             return; 
/* 311 */           PlanAttackDiv.this.timer.set(PlanAttackDiv.m, 1000);
/*     */ 
/*     */ 
/*     */           
/* 315 */           DivFormationImp nn = PlanAttackDiv.this.retreatedDest(0);
/* 316 */           if (nn == null) {
/* 317 */             PlanAttackDiv.this.fail.set();
/*     */             
/*     */             return;
/*     */           } 
/* 321 */           PlanAttackDiv.dest.copy(PlanAttackDiv.this.t.mover.getFromMovedIntoTo((DivPositionImp)PlanAttackDiv.current, nn));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 327 */           (PlanAttackDiv.div.order()).dest.set(PlanAttackDiv.dest);
/*     */           
/* 329 */           nn = PlanAttackDiv.dest;
/*     */ 
/*     */           
/* 332 */           PlanAttackDiv.this.res.deployInit(nn.dir(), nn.start().x(), nn.start().y(), nn.dx(), nn.dy(), nn.formation(), nn.width());
/*     */           
/* 334 */           Div target = PlanAttackDiv.task.targetDiv();
/* 335 */           if (target == null) {
/* 336 */             PlanAttackDiv.this.fail.set();
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/* 341 */           DivPositionCopyable divPositionCopyable = PlanAttackDiv.task.targetDiv().current();
/* 342 */           PathUtilOnline.Flooder f = PlanAttackDiv.this.t.pather.getFlooder();
/* 343 */           f.init(this);
/*     */           
/* 345 */           for (int i = 0; i < target.deployed(); i++) {
/* 346 */             if (target.reporter.reachable(i)) {
/* 347 */               PlanAttackDiv.this.proj.smark(divPositionCopyable.px(i), divPositionCopyable.py(i));
/*     */             }
/*     */           } 
/* 350 */           int cx = PlanAttackDiv.task.targetDiv().centre().cUnitX();
/* 351 */           int cy = PlanAttackDiv.task.targetDiv().centre().cUnitY();
/*     */           
/* 353 */           LIST<Tools.Pos> ll = PlanAttackDiv.this.t.getPosColumnSort((DivFormation)nn);
/* 354 */           for (int pi = 0; pi < ll.size(); pi++) {
/* 355 */             Tools.Pos pos = (Tools.Pos)ll.get(pi);
/* 356 */             double sx = nn.px(pos.pos);
/* 357 */             double sy = nn.py(pos.pos);
/* 358 */             double m = PlanAttackDiv.this.vec.set(sx, sy, cx, cy);
/*     */             
/* 360 */             DIR d = PlanAttackDiv.this.vec.dir();
/*     */             
/* 362 */             PlanAttackDiv.this.vec.set(nn.dx(), nn.dy());
/* 363 */             PlanAttackDiv.this.vec.rotate90().rotate90().rotate90();
/*     */             
/* 365 */             if (deploy(sx, sy, PlanAttackDiv.this.vec.nX(), PlanAttackDiv.this.vec.nY(), m)) {
/* 366 */               this.dirs[pi] = (byte)d.id();
/*     */             
/*     */             }
/*     */             else {
/*     */ 
/*     */               
/* 372 */               PlanAttackDiv.this.res.deploy((int)sx, (int)sy, (DIV_SPEC)PlanAttackDiv.div.info);
/* 373 */               this.dirs[pi] = (byte)PlanAttackDiv.prev.dir().id();
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 379 */           f.done();
/* 380 */           PlanAttackDiv.this.res.deployFinish(PlanAttackDiv.this.t.pather.filler, (DIV_SPEC)PlanAttackDiv.div.info);
/* 381 */           PlanAttackDiv.this.res.coherentSetNot();
/* 382 */           for (int j = 0; j < PlanAttackDiv.this.res.deployed(); j++) {
/* 383 */             PlanAttackDiv.this.res.setDir(j, (DIR)DIR.ALL.get(this.dirs[j]));
/*     */           }
/*     */           
/* 386 */           PlanAttackDiv.nextPos = PlanAttackDiv.this.t.mover.getFromMovedIntoTo((DivPositionImp)PlanAttackDiv.current, PlanAttackDiv.this.res);
/*     */         }
/*     */ 
/*     */         
/*     */         private boolean deploy(double sx, double sy, double dx, double dy, double m) {
/* 391 */           for (int dist = 0; dist <= m; PlanAttackDiv.this.proj.getClass(), dist += 32) {
/* 392 */             int x = (int)(sx + dx * dist);
/* 393 */             int y = (int)(sy + dy * dist);
/*     */             
/* 395 */             if (PlanAttackDiv.this.proj.is(x, y) || (BattleStatus.map()).hasEnemy.is(x / 64, y / 64, PlanAttackDiv.a)) {
/*     */               
/* 397 */               PlanAttackDiv.this.res.deploy(x, y, (DIV_SPEC)PlanAttackDiv.div.info);
/* 398 */               PlanAttackDiv.this.proj.getClass(); x = (int)(sx + dx * (dist - 32));
/* 399 */               PlanAttackDiv.this.proj.getClass(); y = (int)(sy + dy * (dist - 32));
/* 400 */               PlanAttackDiv.this.proj.mark(x, y);
/* 401 */               return true;
/*     */             } 
/*     */           } 
/*     */           
/* 405 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         boolean setAction() {
/* 410 */           PlanAttackDiv.this.timer.set(PlanAttackDiv.m, 0);
/* 411 */           update(0);
/* 412 */           return true;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 417 */     this.fightGuard = new BattleOrderUpdater.Plan.STATE(this, "fight")
/*     */       {
/*     */         
/*     */         void update(int gameMillis)
/*     */         {
/* 422 */           PlanAttackDiv.this.timer.inc(PlanAttackDiv.m, -gameMillis);
/*     */           
/* 424 */           if (PlanAttackDiv.this.timer.get(PlanAttackDiv.m) > 0) {
/*     */             return;
/*     */           }
/*     */           
/* 428 */           PlanAttackDiv.this.timer.set(PlanAttackDiv.m, 1000);
/*     */           
/* 430 */           DivFormationImp nn = PlanAttackDiv.this.getGuardDest();
/*     */           
/* 432 */           if (nn == null) {
/* 433 */             PlanAttackDiv.this.fail.set();
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/* 438 */           PlanAttackDiv.order.dest.set(nn);
/*     */           
/* 440 */           PlanAttackDiv.nextPos = nn;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         boolean setAction() {
/* 446 */           PlanAttackDiv.this.timer.set(PlanAttackDiv.m, 0);
/* 447 */           update(0);
/* 448 */           PlanAttackDiv.this.timer.set(PlanAttackDiv.m, 1000);
/* 449 */           return true;
/*     */         }
/*     */       }; data.getClass(); this.timer = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataShort(data); data.getClass(); this.pathI = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataShort(data); data.getClass(); this.pathd = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataBit(data); data.getClass(); this.width = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataInt(data); data.getClass();
/*     */     this.targetID = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataShort(data); } void init() { this.width.set(m, prev.width());
/*     */     if (!checkTarget())
/*     */       return; 
/*     */     blobDest(); } protected boolean checkTarget() { Div target = task.targetDiv();
/*     */     if (target == null || !target.active()) {
/*     */       this.fail.set();
/*     */       return false;
/*     */     } 
/* 460 */     return true; } private DivFormationImp getGuardDest() { DivFormation divFormation = task.targetDiv().position();
/*     */ 
/*     */     
/* 463 */     DivFormationImp nn = retreatedDest(0);
/*     */ 
/*     */     
/* 466 */     if (nn == null) {
/* 467 */       return prev;
/*     */     }
/*     */     
/* 470 */     PathUtilOnline.Flooder f = this.t.pather.getFlooder();
/* 471 */     f.init(this);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 476 */     DivPositionCopyable divPositionCopyable = task.targetDiv().current();
/* 477 */     for (int i = 0; i < divPositionCopyable.deployed(); i++) {
/* 478 */       this.proj.mark(divPositionCopyable.px(i), divPositionCopyable.py(i));
/*     */     }
/*     */     
/* 481 */     double engagement = engagement(prev, 0.0D, 0.0D);
/*     */     
/* 483 */     if (prev.isCoherent() && engagement > 0.1D && engagement < 0.4D && !this.t.div.needsFixing(prev, men, a, (div.settings()).formation)) {
/* 484 */       f.done();
/* 485 */       return prev;
/*     */     } 
/*     */     
/* 488 */     engagement = engagement(nn, 0.0D, 0.0D);
/*     */     
/* 490 */     double bestI = 0.0D;
/* 491 */     double best = engagement;
/* 492 */     double ideal = 0.25D;
/* 493 */     this.vec.set(nn.dx(), nn.dy());
/* 494 */     this.vec.rotate90();
/* 495 */     this.vec.rotate90();
/* 496 */     this.vec.rotate90();
/*     */ 
/*     */ 
/*     */     
/* 500 */     if (engagement > 0.4D) {
/* 501 */       for (double d = 0.25D; d < 8.0D; d += 0.25D) {
/* 502 */         double dx = -this.vec.nX() * d * 64.0D;
/* 503 */         double dy = -this.vec.nY() * d * 64.0D;
/* 504 */         if (!this.t.deployer.canMove((DIV_SPEC)div.info, nn, dx, dy, a)) {
/*     */           break;
/*     */         }
/*     */         
/* 508 */         double e = engagement(nn, dx, dy);
/* 509 */         if (e <= 0.0D)
/*     */           break; 
/* 511 */         if (e < best && e >= 0.25D) {
/* 512 */           best = e;
/* 513 */           bestI = -d;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 517 */       for (double d = 0.25D; d < 8.0D; d += 0.25D) {
/* 518 */         double dx = this.vec.nX() * d * 64.0D;
/* 519 */         double dy = this.vec.nY() * d * 64.0D;
/*     */         
/* 521 */         if (!this.t.deployer.canMove((DIV_SPEC)div.info, nn, dx, dy, a)) {
/*     */           break;
/*     */         }
/*     */         
/* 525 */         double e = engagement(nn, dx, dy);
/* 526 */         if (e > best && e <= 0.25D) {
/*     */           
/* 528 */           bestI = d;
/* 529 */           best = e;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 534 */     f.done();
/*     */     
/* 536 */     nn = this.t.mover.getFromMovedIntoTo((DivPositionImp)current, nn);
/*     */     
/* 538 */     nn = this.t.deployer.move((DIV_SPEC)div.info, nn, (int)(this.vec.nX() * bestI * 64.0D), (int)(this.vec.nY() * bestI * 64.0D), a);
/*     */     
/* 540 */     return nn; }
/*     */   private void blobDest() { Div target = task.targetDiv(); if (target == null) this.fail.set();  this.targetID.set(m, target.indexArmy()); DivFormationImp f = (div.settings()).guard ? getGuardDest() : getOverlappedDest(); blobDest(f); }
/*     */   private void blobDest(DivFormationImp f) { if (f == null) { this.fail.set(); return; }  order.dest.set(f); dest.copy(f); setWalkToDest(); this.pathd.set(m, path.currentI() & 0x1); this.pathI.set(m, 0); }
/*     */   private DivFormationImp getOverlappedDest() { if (!checkTarget()) { this.fail.set(); return null; }  Div target = task.targetDiv(); int sx = div.centre().cX(); int sy = div.centre().cY(); boolean useDest = false; if (this.t.div.inPosition(current, dest, 32.0D) + div.reporter.unreachable() > men / 2) { sx = (int)(dest.start().x() + dest.dx() * dest.width() / 2.0D); sy = (int)(dest.start().y() + dest.dy() * dest.width() / 2.0D); useDest = true; }  this.vec.set(dest.dx(), dest.dy()); this.vec.rotate90(); sx = (int)(sx + 256.0D * this.vec.nX()); sy = (int)(sy + 256.0D * this.vec.nY()); int dx = target.centre().cUnitX(); int dy = target.centre().cUnitY(); double nx = 1.0D; double ny = 0.0D; double dist = 0.0D; if (sx != dx || sy != dy) { dist = this.vec.set(sx, sy, dx, dy); this.vec.rotate90(); nx = this.vec.nX(); ny = this.vec.nY(); }  if (useDest && dest.dx() * nx + dest.dy() * ny > 0.8D) { this.vec.set(dest.dx(), dest.dy()); this.vec.rotate90(); this.vec.rotate90(); this.vec.rotate90(); int x = (int)(sx + this.vec.nX() * dist); int y = (int)(sy + this.vec.nY() * dist); if (COORDINATE.tileDistance(x, y, dx, dy) < 128.0D) { dx = x; dy = y; nx = dest.dx(); ny = dest.dy(); }  }  int w = this.width.get(m) / (div.settings()).formation.size(div); if (w < 3) w = 3;  if (w > men / 3) w = men / 3;  return this.t.deployer.deployCentre((DIV_SPEC)div.info, men, (div.settings()).formation, dx, dy, nx, ny, w, a); }
/*     */   void update(int gamemillis) { Div target = task.targetDiv(); if (target == null) { this.fail.set(); return; }  if (this.targetID.get(m) != target.indexArmy()) { blobDest(); return; }  boolean engaged = isEngaged(); if (!engaged) this.timer.set(m, 0);  if (engaged && state(m) != this.fightGuard && (div.settings()).guard) { this.timer.set(m, 0); this.fightGuard.set(); } else if (engaged && !(div.settings()).guard && state(m) != this.fight) { this.timer.inc(m, gamemillis); if (state(m) == this.fightGuard || this.timer.get(m) > 4000) this.fight.set();  } else if (!engaged && (state(m) == this.fight || state(m) == this.fightGuard)) { setWalkToDest(); } else if (charging()) { BattleOrderUpdater.Plan.chargeSpeed = true; }  state(m).update(gamemillis); if (state(m) != this.fightGuard && state(m) != this.fight && (path.currentI() & 0x1) != this.pathd.get(m)) { this.pathd.set(m, path.currentI() & 0x1); this.pathI.inc(m, 1); int length = path.length(); if (!path.isComplete()) length = 128;  int check = 4 + length / 10; if (this.pathI.get(m) > check) { DivFormationImp f = (div.settings()).guard ? getGuardDest() : getOverlappedDest(); COORDINATE dest = this.t.div.getSafeCentrePixel(BattleOrderUpdater.Plan.dest); if (dest.tileDistanceTo(path.finalTDest()) < 2.0D) return;  blobDest(f); }  }  }
/* 545 */   protected boolean running() { return super.running() | charging(); } private boolean charging() { if ((div.settings()).guard) return false;  return !(path.length() != 0 && (!path.isComplete() || path.length() - path.currentI() >= 32 || !this.t.walk.canMoveAllTheWayToDest())); } void finished() { if (checkTarget()) { init(); } else { this.fail.set(); }  } private boolean isEngaged() { if (div.status().engagements() > 0) for (int i = 0; i < current.deployed(); i++) { Div target = task.targetDiv(); if ((BattleStatus.map()).isser.is(current.tx(i), current.ty(i), target)) return true;  }   return false; } boolean continueWhenFighting() { return !(div.status().engagements() >= men / 8 && !isEngaged()); } public double engagement(DivFormationImp f, double dx, double dy) { double enemies = 0.0D;
/*     */     
/* 547 */     for (int i = 0; i < f.deployed(); i++) {
/* 548 */       int x = (int)(f.px(i) + dx);
/* 549 */       int y = (int)(f.py(i) + dy);
/* 550 */       if (this.proj.is(x, y)) {
/* 551 */         enemies++;
/*     */       }
/*     */     } 
/* 554 */     return enemies / (f.width() / f.formation().size(BattleOrderUpdater.Plan.div)); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DivFormationImp retreatedDest(int distance) {
/* 561 */     DivFormationImp f = getOverlappedDest();
/* 562 */     if (f == null) {
/* 563 */       return null;
/*     */     }
/*     */     
/* 566 */     Div target = task.targetDiv();
/* 567 */     dest.copy(f);
/* 568 */     f = retreatedDest(dest, (DivPosition)target.current(), distance);
/*     */     
/* 570 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   DivFormationImp retreatedDest(DivFormationImp result, DivPosition target, int distance) {
/* 576 */     this.vec.set(result.dx(), result.dy());
/* 577 */     this.vec.rotate90();
/*     */     
/* 579 */     PathUtilOnline.Flooder f = this.t.pather.getFlooder();
/* 580 */     f.init(this);
/* 581 */     for (int i = 0; i < target.deployed(); i++) {
/* 582 */       f.close(target.tx(i), target.ty(i), 0.0D);
/*     */     }
/*     */     
/* 585 */     double dist = 0.0D;
/*     */ 
/*     */     
/*     */     while (true) {
/* 589 */       double dx = this.vec.nX() * (dist + 1.0D);
/* 590 */       double dy = this.vec.nY() * (dist + 1.0D);
/*     */       
/* 592 */       boolean enemies = false;
/*     */       
/* 594 */       for (int j = 0; j < result.deployed(); j++) {
/* 595 */         int tx = (int)(result.tx(j) + dx);
/* 596 */         int ty = (int)(result.ty(j) + dy);
/* 597 */         if (!SETT.IN_BOUNDS(tx, ty) || !DivPlacability.tileIsOK(tx, ty, a)) {
/*     */           
/* 599 */           f.done();
/* 600 */           return this.t.deployer.move((DIV_SPEC)div.info, result, (int)(this.vec.nX() * dist * 64.0D), (int)(this.vec.nY() * dist * 64.0D), a);
/*     */         } 
/*     */         
/* 603 */         enemies |= f.hasBeenPushed(tx, ty);
/*     */       } 
/*     */       
/* 606 */       dist++;
/*     */ 
/*     */       
/* 609 */       distance--;
/* 610 */       if (!enemies && distance <= 0) {
/* 611 */         f.done();
/* 612 */         return this.t.deployer.move((DIV_SPEC)div.info, result, (int)(dx * 64.0D), (int)(dy * 64.0D), a);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class Projector
/*     */   {
/* 625 */     final int size = 32;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void smark(int px, int py) {
/* 632 */       mark(px, py);
/* 633 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 634 */         mark(px + ((DIR)DIR.ALL.get(di)).x() * 32, py + ((DIR)DIR.ALL.get(di)).y() * 32);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void mark(int px, int py) {
/* 641 */       px = t(px, SETT.TWIDTH);
/* 642 */       py = t(py, SETT.THEIGHT);
/*     */ 
/*     */       
/* 645 */       if (!SETT.IN_BOUNDS(px, py)) {
/*     */         return;
/*     */       }
/* 648 */       PlanAttackDiv.this.t.pather.getFlooder().close(px, py, 0.0D);
/* 649 */       PlanAttackDiv.this.t.pather.getFlooder().setValue2(px, py, 0.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     private int t(int p, int max) {
/* 654 */       p = p * 2 / 64;
/* 655 */       while (p < 0) {
/* 656 */         p += max;
/*     */       }
/* 658 */       while (p >= max) {
/* 659 */         p -= max;
/*     */       }
/* 661 */       return p;
/*     */     }
/*     */     
/*     */     boolean is(int px, int py) {
/* 665 */       px = t(px, SETT.TWIDTH);
/* 666 */       py = t(py, SETT.THEIGHT);
/*     */       
/* 668 */       if (!SETT.IN_BOUNDS(px, py)) {
/* 669 */         return true;
/*     */       }
/* 671 */       return PlanAttackDiv.this.t.pather.getFlooder().hasBeenPushed(px, py);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PlanAttackDiv.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */