/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.DataOSimple;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ abstract class PlanWalkAbs
/*     */   extends BattleOrderUpdater.Plan
/*     */ {
/*     */   private final INT_O.INT_OE<BattleOrderUpdater.PlanData> inPosition;
/*     */   private final INT_O.INT_OE<BattleOrderUpdater.PlanData> timer;
/*     */   final INT_O.INT_OE<BattleOrderUpdater.PlanData> colTimer;
/*     */   private final INT_O.INT_OE<BattleOrderUpdater.PlanData> tilesDestCheck;
/*     */   private final INT_O.INT_OE<BattleOrderUpdater.PlanData> destId;
/*  19 */   static int amountOfPaths = 0;
/*     */   
/*     */   public PlanWalkAbs(Tools tools, LISTE<BattleOrderUpdater.Plan> all, BattleOrderUpdater.Data data, BattleOrderTask.DIVTASK task) {
/*  22 */     super(tools, all, data, task);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  66 */     this.wait = new BattleOrderUpdater.Plan.STATE(this, "wait")
/*     */       {
/*     */         
/*     */         void update(int gameMillis)
/*     */         {
/*  71 */           if (!PlanWalkAbs.div.active() || PlanWalkAbs.men <= 0) {
/*     */             return;
/*     */           }
/*  74 */           if (PlanWalkAbs.amountOfPaths > 1)
/*     */             return; 
/*  76 */           PlanWalkAbs.amountOfPaths++;
/*  77 */           PlanWalkAbs.this.destId.set(PlanWalkAbs.m, PlanWalkAbs.order.dest.setI() & 0xF);
/*  78 */           PlanWalkAbs.this.setStart.set();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         boolean setAction() {
/*  84 */           return true;
/*     */         }
/*     */       };
/*     */     
/*  88 */     this.setStart = new BattleOrderUpdater.Plan.STATE(this, "setStart")
/*     */       {
/*     */         
/*     */         boolean setAction()
/*     */         {
/*  93 */           if (!PlanWalkAbs.this.t.walk.setStart(90)) {
/*  94 */             return PlanWalkAbs.this.moveIntoDest.set();
/*     */           }
/*     */           
/*  97 */           if (PlanWalkAbs.this.t.div.intersectsSomewhat(PlanWalkAbs.prev, PlanWalkAbs.dest)) {
/*  98 */             return PlanWalkAbs.this.moveIntoDest.set();
/*     */           }
/* 100 */           PlanWalkAbs.this.timer.set(PlanWalkAbs.m, 0);
/* 101 */           PlanWalkAbs.this.inPosition.set(PlanWalkAbs.m, PlanWalkAbs.this.t.walk.countPosition());
/* 102 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         void update(int gamemillis) {
/* 108 */           if (PlanWalkAbs.men == 0) {
/*     */             return;
/*     */           }
/* 111 */           if (PlanWalkAbs.this.checkNextDest()) {
/*     */             
/* 113 */             PlanWalkAbs.this.wait.set();
/*     */             
/*     */             return;
/*     */           } 
/* 117 */           if (PlanWalkAbs.prev.deployed() == 0) {
/* 118 */             PlanWalkAbs.task.stop(PlanWalkAbs.div);
/* 119 */             (PlanWalkAbs.div.order()).task.set(PlanWalkAbs.task);
/*     */             
/*     */             return;
/*     */           } 
/* 123 */           if (PlanWalkAbs.prev.deployed() > 0 && PlanWalkAbs.this.t.div.fixIfNeeded(PlanWalkAbs.prev)) {
/* 124 */             PlanWalkAbs.nextPos = PlanWalkAbs.prev;
/*     */           }
/*     */           
/* 127 */           int pos = PlanWalkAbs.this.t.walk.countPosition();
/* 128 */           if (pos > 0) {
/* 129 */             if (pos == 1) {
/* 130 */               PlanWalkAbs.this.timer.set(PlanWalkAbs.m, 0);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/* 135 */             if (pos >= PlanWalkAbs.men - PlanWalkAbs.unreachable || PlanWalkAbs.this.running()) {
/* 136 */               PlanWalkAbs.this.followPath.set();
/*     */               
/*     */               return;
/*     */             } 
/* 140 */             PlanWalkAbs.this.timer.inc(PlanWalkAbs.m, gamemillis);
/* 141 */             if (pos > PlanWalkAbs.this.inPosition.get(PlanWalkAbs.m)) {
/* 142 */               PlanWalkAbs.this.timer.set(PlanWalkAbs.m, 0);
/*     */             }
/* 144 */             PlanWalkAbs.this.inPosition.set(PlanWalkAbs.m, pos);
/*     */ 
/*     */             
/* 147 */             if (PlanWalkAbs.this.running() || PlanWalkAbs.this.t.div.isCloseToFighting() || PlanWalkAbs.this.timer.get(PlanWalkAbs.m) >= 1500) {
/* 148 */               PlanWalkAbs.this.followPath.set();
/*     */               return;
/*     */             } 
/*     */           } else {
/* 152 */             PlanWalkAbs.this.timer.inc(PlanWalkAbs.m, gamemillis);
/* 153 */             if (PlanWalkAbs.this.timer.get(PlanWalkAbs.m) > 1000) {
/* 154 */               setAction();
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/* 159 */           if (PlanWalkAbs.path.isDest()) {
/*     */             return;
/*     */           }
/*     */           
/* 163 */           if (PlanWalkAbs.path.currentI() < PlanWalkAbs.path.length() - 1) {
/* 164 */             COORDINATE cc = PlanWalkAbs.this.t.div.currentCentre();
/* 165 */             double d1 = cc.tileDistanceTo(PlanWalkAbs.path.x(), PlanWalkAbs.path.y());
/* 166 */             PlanWalkAbs.path.currentIInc(1);
/* 167 */             double d2 = cc.tileDistanceTo(PlanWalkAbs.path.x(), PlanWalkAbs.path.y());
/* 168 */             PlanWalkAbs.path.currentIInc(-1);
/*     */             
/* 170 */             if (d1 <= d2 + 3.0D)
/*     */               return; 
/* 172 */             PlanWalkAbs.this.t.walk.setNextPosition(90, gamemillis);
/* 173 */             PlanWalkAbs.this.timer.set(PlanWalkAbs.m, 0);
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 180 */     this.followPath = new BattleOrderUpdater.Plan.STATE(this, "follow path")
/*     */       {
/*     */         boolean setAction()
/*     */         {
/* 184 */           PlanWalkAbs.this.tilesDestCheck.set(PlanWalkAbs.m, 10);
/* 185 */           PlanWalkAbs.this.inPosition.set(PlanWalkAbs.m, PlanWalkAbs.this.t.walk.countPosition());
/* 186 */           PlanWalkAbs.this.timer.set(PlanWalkAbs.m, 0);
/* 187 */           PlanWalkAbs.this.colTimer.set(PlanWalkAbs.m, 0);
/* 188 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         void update(int gameMillis) {
/* 196 */           double sp = speed(gameMillis);
/*     */           
/* 198 */           if (sp == 0.0D) {
/*     */             return;
/*     */           }
/* 201 */           if (PlanWalkAbs.path.isDest()) {
/* 202 */             resume();
/*     */             return;
/*     */           } 
/* 205 */           PlanWalkAbs.order.path.get(PlanWalkAbs.path);
/* 206 */           PlanWalkAbs.this.tilesDestCheck.inc(PlanWalkAbs.m, -1);
/* 207 */           int pi = PlanWalkAbs.path.currentI();
/* 208 */           if (!PlanWalkAbs.this.t.walk.setNextPosition(80 + PlanWalkAbs.this.tilesDestCheck.get(PlanWalkAbs.m), (int)Math.ceil(gameMillis * sp))) {
/* 209 */             PlanWalkAbs.this.init();
/*     */             return;
/*     */           } 
/* 212 */           if (pi != PlanWalkAbs.path.currentI() && 
/* 213 */             PlanWalkAbs.this.checkNextDest()) {
/* 214 */             PlanWalkAbs.this.wait.set();
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private double speed(int gameMillis) {
/* 235 */           int in = PlanWalkAbs.this.t.walk.countPosition();
/*     */           
/* 237 */           if (in == 0) {
/* 238 */             PlanWalkAbs.this.colTimer.inc(PlanWalkAbs.m, gameMillis);
/* 239 */             if (PlanWalkAbs.this.colTimer.get(PlanWalkAbs.m) > 3000) {
/* 240 */               PlanWalkAbs.this.setStart.set();
/* 241 */             } else if (PlanWalkAbs.path.currentI() < PlanWalkAbs.path.length() - 1) {
/*     */               
/* 243 */               COORDINATE cc = PlanWalkAbs.this.t.div.currentCentre();
/* 244 */               double d1 = cc.tileDistanceTo(PlanWalkAbs.path.x(), PlanWalkAbs.path.y());
/* 245 */               PlanWalkAbs.path.currentIInc(1);
/* 246 */               double d2 = cc.tileDistanceTo(PlanWalkAbs.path.x(), PlanWalkAbs.path.y());
/* 247 */               PlanWalkAbs.path.currentIInc(-1);
/*     */               
/* 249 */               if (d1 > d2 + 3.0D) {
/* 250 */                 if (!PlanWalkAbs.this.t.walk.setNextPosition(80 + PlanWalkAbs.this.tilesDestCheck.get(PlanWalkAbs.m), gameMillis)) {
/*     */                   
/* 252 */                   PlanWalkAbs.this.init();
/* 253 */                   return 0.0D;
/*     */                 } 
/*     */ 
/*     */                 
/* 257 */                 PlanWalkAbs.this.timer.set(PlanWalkAbs.m, 0);
/* 258 */                 PlanWalkAbs.this.colTimer.set(PlanWalkAbs.m, 0);
/* 259 */                 return 0.0D;
/*     */               } 
/*     */             } 
/*     */             
/* 263 */             return 0.0D;
/*     */           } 
/* 265 */           PlanWalkAbs.this.colTimer.set(PlanWalkAbs.m, 0);
/*     */           
/* 267 */           if (PlanWalkAbs.this.running()) {
/* 268 */             return 1.0D;
/*     */           }
/* 270 */           in += PlanWalkAbs.unreachable;
/*     */           
/* 272 */           if (in >= PlanWalkAbs.prev.deployed()) {
/* 273 */             return 1.0D;
/*     */           }
/* 275 */           double d = ((PlanWalkAbs.men - in) / PlanWalkAbs.men);
/* 276 */           return CLAMP.d(0.25D + d, 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         void resume() {
/* 281 */           if (PlanWalkAbs.path.isDest() && PlanWalkAbs.path.isComplete()) {
/* 282 */             PlanWalkAbs.this.moveIntoDest.set();
/*     */             return;
/*     */           } 
/* 285 */           if (!PlanWalkAbs.this.t.walk.setStart(90)) {
/* 286 */             PlanWalkAbs.this.init();
/*     */             return;
/*     */           } 
/* 289 */           if (PlanWalkAbs.this.t.div.intersectsSomewhat(PlanWalkAbs.prev, PlanWalkAbs.dest)) {
/* 290 */             PlanWalkAbs.this.moveIntoDest.set();
/*     */           } else {
/* 292 */             PlanWalkAbs.this.inPosition.set(PlanWalkAbs.m, CLAMP.i(PlanWalkAbs.this.t.walk.countPosition(), 0, PlanWalkAbs.men));
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 303 */     this.moveIntoDest = new BattleOrderUpdater.Plan.STATE(this, "move into dest")
/*     */       {
/*     */         boolean setAction()
/*     */         {
/* 307 */           PlanWalkAbs.path.clear();
/* 308 */           PlanWalkAbs.order.path.set(PlanWalkAbs.path);
/* 309 */           PlanWalkAbs.this.t.mover.rearrangeDest(PlanWalkAbs.prev, PlanWalkAbs.dest);
/* 310 */           PlanWalkAbs.order.dest.set(PlanWalkAbs.dest);
/* 311 */           int di = PlanWalkAbs.order.dest.setI() & 0xF;
/* 312 */           PlanWalkAbs.this.destId.set(PlanWalkAbs.m, di);
/* 313 */           PlanWalkAbs.this.timer.set(PlanWalkAbs.m, 100);
/* 314 */           PlanWalkAbs.this.inPosition.set(PlanWalkAbs.m, PlanWalkAbs.this.t.walk.countPosition());
/* 315 */           update(0);
/* 316 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         void update(int gamemillis) {
/* 321 */           if (PlanWalkAbs.this.checkNextDest()) {
/* 322 */             PlanWalkAbs.this.wait.set();
/*     */             return;
/*     */           } 
/* 325 */           if (wait(PlanWalkAbs.m, gamemillis))
/*     */             return; 
/* 327 */           if (!PlanWalkAbs.this.t.mover.merge(PlanWalkAbs.prev, PlanWalkAbs.dest)) {
/* 328 */             PlanWalkAbs.this.stayInDest.set();
/*     */             
/*     */             return;
/*     */           } 
/* 332 */           PlanWalkAbs.nextPos = PlanWalkAbs.prev;
/*     */         }
/*     */ 
/*     */         
/*     */         private boolean wait(BattleOrderUpdater.PlanData m, int gamemillis) {
/* 337 */           PlanWalkAbs.this.timer.inc(m, -gamemillis);
/* 338 */           int in = PlanWalkAbs.this.t.walk.countPosition();
/*     */           
/* 340 */           if (in == 0) {
/* 341 */             return true;
/*     */           }
/* 343 */           if (in < PlanWalkAbs.this.inPosition.get(m)) {
/* 344 */             PlanWalkAbs.this.timer.inc(m, -gamemillis);
/* 345 */             if (PlanWalkAbs.this.timer.get(m) <= 0) {
/* 346 */               PlanWalkAbs.this.inPosition.inc(m, -1);
/* 347 */               PlanWalkAbs.this.timer.set(m, 100);
/*     */             } 
/* 349 */             return true;
/*     */           } 
/* 351 */           PlanWalkAbs.this.inPosition.set(m, in);
/*     */           
/* 353 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 358 */     this.stayInDest = new BattleOrderUpdater.Plan.STATE(this, "stay in dest")
/*     */       {
/*     */         
/*     */         boolean setAction()
/*     */         {
/* 363 */           PlanWalkAbs.nextPos = PlanWalkAbs.dest;
/*     */           
/* 365 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         void update(int gamemillis) {
/* 371 */           if (PlanWalkAbs.this.checkNextDest()) {
/* 372 */             PlanWalkAbs.this.wait.set();
/*     */             
/*     */             return;
/*     */           } 
/* 376 */           if (!PlanWalkAbs.this.t.walk.hasReachedPrev()) {
/*     */             return;
/*     */           }
/* 379 */           PlanWalkAbs.this.finished();
/*     */         }
/*     */       };
/*     */     data.getClass();
/*     */     this.inPosition = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataByte(data);
/*     */     data.getClass();
/*     */     this.timer = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataInt(data);
/*     */     data.getClass();
/*     */     this.colTimer = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataShort(data);
/*     */     data.getClass();
/*     */     this.tilesDestCheck = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataByte(data);
/*     */     data.getClass();
/*     */     this.destId = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataNibble(data);
/*     */   }
/*     */   
/*     */   private final BattleOrderUpdater.Plan.STATE wait;
/*     */   private final BattleOrderUpdater.Plan.STATE setStart;
/*     */   private final BattleOrderUpdater.Plan.STATE followPath;
/*     */   private final BattleOrderUpdater.Plan.STATE moveIntoDest;
/*     */   private final BattleOrderUpdater.Plan.STATE stayInDest;
/*     */   
/*     */   void setWalkToDest() {
/*     */     path.clear();
/*     */     order.path.set(path);
/*     */     this.wait.set();
/*     */   }
/*     */   
/*     */   private boolean checkNextDest() {
/*     */     int di = order.dest.setI() & 0xF;
/*     */     if (this.destId.get(m) != di) {
/*     */       this.destId.set(m, di);
/*     */       return true;
/*     */     } 
/*     */     if (this.t.div.needsFixing(dest, men, a, (div.settings()).formation)) {
/*     */       int w = dest.width();
/*     */       int destX = dest.start().x();
/*     */       int destY = dest.start().y();
/*     */       if (this.t.deployer.fixFormation((DIV_SPEC)div.info, dest, (div.settings()).formation, men, a)) {
/*     */         order.dest.set(dest);
/*     */         di = order.dest.setI() & 0xF;
/*     */         this.destId.set(m, di);
/*     */         if (!dest.start().isSameAs(destX, destY) || Math.abs(w - dest.width()) > dest.formation().size(div))
/*     */           return true; 
/*     */       } 
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   protected boolean running() {
/*     */     if ((div.settings()).running)
/*     */       return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   abstract void finished();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PlanWalkAbs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */