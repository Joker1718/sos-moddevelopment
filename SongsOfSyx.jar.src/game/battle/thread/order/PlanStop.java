/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.formation.DivFormation;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.formation.DivPlacability;
/*     */ import game.battle.formation.DivPositionCopyable;
/*     */ import game.battle.formation.DivPositionImp;
/*     */ import game.battle.thread.status.BattleStatus;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.DataOSimple;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class PlanStop
/*     */   extends BattleOrderUpdater.Plan
/*     */ {
/*  24 */   private final VectorImp vec = new VectorImp();
/*     */   private final INT_O.INT_OE<BattleOrderUpdater.PlanData> timer; private final INT_O.INT_OE<BattleOrderUpdater.PlanData> timer2; private BattleOrderUpdater.Plan.STATE wait; private final DivFormationImp ff; void init() { this.wait.set(); order.path.set(path); if (current.deployed() == 0) return;  if (!div.active()) return;  DivFormationImp form = null; if (BattleOrderUpdater.Plan.prev.deployed() == men && prev.isCoherent() && this.t.deployer.isValid((DIV_SPEC)div.info, BattleOrderUpdater.Plan.prev, a) && this.t.div.inPosition(current, prev, 96.0D) > men / 2) { form = prev; } else if (BattleOrderUpdater.Plan.dest.deployed() == men && this.t.deployer.isValid((DIV_SPEC)div.info, BattleOrderUpdater.Plan.dest, a) && this.t.div.inPosition(current, dest, 96.0D) > men / 2) { form = dest; } else { DivPositionCopyable divPositionCopyable = current; int cx = 0; int cy = 0; int ci = 0; int i; for (i = 0; i < divPositionCopyable.deployed(); i++) { if (!DivPlacability.pixelIsBlocked(divPositionCopyable.px(i), divPositionCopyable.px(i), 64, a) && div.reporter.reachable(i)) { cx += divPositionCopyable.px(i); cy += divPositionCopyable.py(i); ci++; }  }  if (ci == 0) for (i = 0; i < divPositionCopyable.deployed(); i++) { if (!DivPlacability.pixelIsBlocked(divPositionCopyable.px(i), divPositionCopyable.px(i), 64, a)) { cx += divPositionCopyable.px(i); cy += divPositionCopyable.py(i); ci++; }  }   if (ci == 0) return;  cx /= ci; cy /= ci; double dist = Double.MAX_VALUE; int bi = -1; for (int j = 0; j < divPositionCopyable.deployed(); j++) { if (!DivPlacability.pixelIsBlocked(divPositionCopyable.px(j), divPositionCopyable.px(j), 64, a)) { double d = COORDINATE.tileDistance(cx, cy, divPositionCopyable.px(j), divPositionCopyable.py(j)); if (!div.reporter.reachable(j))
/*     */             d += 100000.0D;  if (d < dist) { dist = d; bi = j; }  }  }  if (bi == -1)
/*     */         return;  int size = (div.settings()).formation.size(div); int width = (int)Math.sqrt(BattleOrderUpdater.Plan.men) * size; if (prev.width() / size > 0 && men / prev.width() / size > 2)
/*     */         width = prev.width();  double dx = prev.dx(); double dy = prev.dy(); if (dx == 0.0D && dy == 0.0D)
/*     */         dx = 1.0D;  form = this.t.deployer.deployArroundCentre((DIV_SPEC)div.info, men, prev.formation(), cx, cy, dx, dy, width, a); if (form == null)
/*  30 */         LOG.err("nay1 " + cx / 64 + " " + cy / 64 + " " + current.deployed());  }  if (form != null) { form = this.t.mover.getFromMovedIntoTo((DivPositionImp)current, form); dest.copy(form); order.dest.set(dest); nextPos = dest; }  } public PlanStop(Tools tools, LISTE<BattleOrderUpdater.Plan> all, BattleOrderUpdater.Data data) { super(tools, all, data, BattleOrderTask.DIVTASK.STOP);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     this.wait = new BattleOrderUpdater.Plan.STATE(this, "wait")
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*     */         void update(int gameMillis)
/*     */         {
/* 170 */           PlanStop.shouldBreak = true;
/* 171 */           PlanStop.this.timer.inc(PlanStop.m, gameMillis);
/* 172 */           PlanStop.this.timer2.inc(PlanStop.m, gameMillis);
/* 173 */           if (PlanStop.this.timer.get(PlanStop.m) < 1000)
/*     */             return; 
/* 175 */           PlanStop.this.timer.set(PlanStop.m, 0);
/* 176 */           PlanStop.nextPos = PlanStop.prev;
/*     */           
/* 178 */           if (PlanStop.this.t.div.fixIfNeeded(PlanStop.dest)) {
/* 179 */             PlanStop.order.dest.set(PlanStop.dest);
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/* 185 */           int ddx = PlanStop.prev.start().x() - PlanStop.dest.start().x();
/* 186 */           int ddy = PlanStop.prev.start().y() - PlanStop.dest.start().y();
/* 187 */           double engagement = PlanStop.this.engagement(PlanStop.dest, ddx, ddy);
/*     */ 
/*     */           
/* 190 */           if (engagement > 0.0D) {
/*     */             
/* 192 */             PlanStop.this.timer2.set(PlanStop.m, 0);
/*     */             
/* 194 */             PlanStop.this.unfuckPrev();
/*     */ 
/*     */ 
/*     */             
/* 198 */             if (!(PlanStop.div.settings()).guard) {
/* 199 */               if (engagement > 1.25D) {
/* 200 */                 tryStep(PlanStop.this.stepBack(engagement));
/* 201 */               } else if (engagement < 0.2D) {
/* 202 */                 tryStep(PlanStop.this.stepForward(engagement));
/* 203 */               }  PlanStop.this.advanceColumn(2.0D);
/* 204 */             } else if (engagement > 1.25D) {
/* 205 */               if (engagement > 1.25D) {
/* 206 */                 tryStep(PlanStop.this.stepBack(engagement));
/* 207 */                 PlanStop.this.advanceColumn(1.0D);
/* 208 */               } else if (engagement < 0.2D) {
/* 209 */                 tryStep(PlanStop.this.stepForward(engagement));
/* 210 */               }  PlanStop.this.advanceColumn(1.0D);
/*     */             
/*     */             }
/*     */ 
/*     */           
/*     */           }
/*     */           else {
/*     */ 
/*     */             
/* 219 */             if (ddx != 0 || ddy != 0) {
/* 220 */               PlanStop.this.timer2.set(PlanStop.m, 0);
/*     */               
/* 222 */               PlanStop.this.unfuckPrev();
/*     */ 
/*     */ 
/*     */               
/* 226 */               double m = PlanStop.this.vec.set(ddx, ddy);
/*     */               
/* 228 */               m = CLAMP.d(m, 0.0D, 64.0D);
/* 229 */               PlanStop.nextPos = PlanStop.this.t.deployer.move((DIV_SPEC)PlanStop.div.info, PlanStop.prev, -((int)Math.round(PlanStop.this.vec.nX() * m)), -((int)Math.round(PlanStop.this.vec.nY() * m)), PlanStop.a);
/*     */               
/*     */               return;
/*     */             } 
/*     */             
/* 234 */             PlanStop.nextPos = PlanStop.dest;
/*     */             
/* 236 */             if (!(PlanStop.div.settings()).guard) {
/* 237 */               PlanStop.this.advanceColumn(2.0D);
/* 238 */             } else if (!PlanStop.this.t.walk.hasReachedPrev() && PlanStop.this.timer.get(PlanStop.m) > 5000) {
/* 239 */               PlanStop.task.move(PlanStop.div);
/* 240 */               (PlanStop.div.order()).task.set(PlanStop.task);
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private void tryStep(DivFormationImp n) {
/* 251 */           if (n == null)
/*     */             return; 
/* 253 */           PlanStop.dest.copy(n);
/* 254 */           PlanStop.nextPos = PlanStop.dest;
/*     */         }
/*     */ 
/*     */         
/*     */         boolean setAction() {
/* 259 */           PlanStop.this.timer.set(PlanStop.m, 0);
/* 260 */           PlanStop.this.timer2.set(PlanStop.m, 0);
/* 261 */           return true;
/*     */         }
/*     */       };
/*     */     
/* 265 */     this.ff = new DivFormationImp();
/*     */     data.getClass();
/*     */     this.timer = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataInt(data);
/*     */     data.getClass();
/* 269 */     this.timer2 = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataShort(data); } private DivFormationImp unfuckPrev() { if (prev.deployed() == 0) {
/* 270 */       prev.copy(dest);
/* 271 */       return prev;
/*     */     } 
/*     */ 
/*     */     
/* 275 */     int ddx = prev.start().x() - dest.start().x();
/* 276 */     int ddy = prev.start().y() - dest.start().y();
/*     */     
/* 278 */     for (int i = 0; i < dest.deployed(); i++) {
/* 279 */       prev.set(i, dest.px(i) + ddx, dest.py(i) + ddy);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 285 */     return prev; }
/*     */    boolean continueWhenFighting() {
/*     */     return true;
/*     */   } void update(int gamemillis) {
/*     */     state(m).update(gamemillis);
/*     */   }
/*     */   private DivFormation advanceColumn(double am) {
/* 292 */     this.ff.deployInit(dest.dir(), dest.start().x(), dest.start().y(), dest.dx(), dest.dy(), dest.formation(), dest.width());
/* 293 */     this.vec.set(dest.dx(), dest.dy());
/* 294 */     this.vec.rotate90().rotate90().rotate90();
/*     */ 
/*     */     
/* 297 */     LIST<Tools.Pos> ll = this.t.getPosColumnSort((DivFormation)dest);
/* 298 */     for (int pi = 0; pi < ll.size(); pi++) {
/* 299 */       Tools.Pos start = (Tools.Pos)ll.get(pi);
/*     */       
/* 301 */       int ddx = 0;
/* 302 */       int ddy = 0;
/*     */       
/* 304 */       int size = this.ff.formation().size(div);
/*     */       
/* 306 */       for (double a = 0.25D; a < am; a += 0.25D) {
/* 307 */         int px = dest.px(start.pos);
/* 308 */         int py = dest.py(start.pos);
/* 309 */         int dx = (int)(size * a * this.vec.nX());
/* 310 */         int dy = (int)(size * a * this.vec.nY());
/*     */         
/* 312 */         px += dx;
/* 313 */         py += dy;
/* 314 */         if (!DivPlacability.pixelIsBlocked(px, py, size, BattleOrderUpdater.Plan.a) && (BattleStatus.map()).hasEnemy.is(px / 64, py / 64, BattleOrderUpdater.Plan.a)) {
/* 315 */           ddx = dx;
/* 316 */           ddy = dy;
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 324 */       while (pi < ll.size() && ((Tools.Pos)ll.get(pi)).columnI == start.columnI) {
/* 325 */         int px = dest.px(((Tools.Pos)ll.get(pi)).pos) + ddx;
/* 326 */         int py = dest.py(((Tools.Pos)ll.get(pi)).pos) + ddy;
/* 327 */         this.ff.deploy(px, py, ((Tools.Pos)ll.get(pi)).pos, (DIV_SPEC)div.info);
/* 328 */         pi++;
/*     */       } 
/* 330 */       pi--;
/*     */     } 
/*     */ 
/*     */     
/* 334 */     this.ff.deployFinish(this.t.pather.filler, (DIV_SPEC)div.info);
/*     */     
/* 336 */     nextPos = this.ff;
/* 337 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DivFormationImp stepForward(double currentEngagement) {
/* 344 */     this.vec.set(dest.dx(), dest.dy());
/* 345 */     this.vec.rotate90();
/* 346 */     this.vec.rotate90();
/* 347 */     this.vec.rotate90();
/* 348 */     for (int i = 1; i < 8; i++) {
/*     */       
/* 350 */       int dx = (int)(this.vec.nX() * 8.0D * i);
/* 351 */       int dy = (int)(this.vec.nY() * 8.0D * i);
/* 352 */       if (!this.t.deployer.canDeploy(dest.start().x() + dx, dest.start().y() + dy, dest.dx(), dest.dy(), dest.width(), dest.formation().size(div), a, div.race()))
/*     */         break; 
/* 354 */       if (engagement(dest, dx, dy) > currentEngagement) {
/* 355 */         nextPos = this.t.deployer.move((DIV_SPEC)div.info, dest, dx, dy, a);
/* 356 */         return nextPos;
/*     */       } 
/*     */     } 
/*     */     
/* 360 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private DivFormationImp stepBack(double currentEngagement) {
/* 366 */     this.vec.set(dest.dx(), dest.dy());
/* 367 */     this.vec.rotate90();
/*     */     
/* 369 */     for (int i = 1; i < 8; i++) {
/*     */       
/* 371 */       int dx = (int)(this.vec.nX() * 8.0D * i);
/* 372 */       int dy = (int)(this.vec.nY() * 8.0D * i);
/* 373 */       if (!this.t.deployer.canDeploy(prev.start().x() + dx, prev.start().y() + dy, dest.dx(), dest.dy(), dest.width(), dest.formation().size(div), a, div.race()))
/*     */         break; 
/* 375 */       if (engagement(prev, dx, dy) < currentEngagement) {
/* 376 */         nextPos = this.t.deployer.move((DIV_SPEC)div.info, prev, dx, dy, a);
/*     */         
/* 378 */         return nextPos;
/*     */       } 
/*     */     } 
/*     */     
/* 382 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   double engagement(DivFormationImp f, double dx, double dy) {
/* 389 */     double enemies = 0.0D;
/*     */     
/* 391 */     if (f.deployed() == 0) {
/* 392 */       return 0.0D;
/*     */     }
/* 394 */     for (int i = 0; i < f.deployed(); i++) {
/* 395 */       int x = (int)(f.px(i) + dx);
/* 396 */       int y = (int)(f.py(i) + dy);
/* 397 */       enemies += BattleStatus.map().soldiers(BattleOrderUpdater.Plan.div.armyEnemy()).get(x >> 6, y >> 6);
/*     */     } 
/*     */     
/* 400 */     return enemies / (f.width() / f.formation().size(BattleOrderUpdater.Plan.div));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PlanStop.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */