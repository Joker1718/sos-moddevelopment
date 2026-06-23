/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.thread.trajectory.BattleTrajectories;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.DataOSimple;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ final class PlanFireDiv
/*     */   extends PlanWalkAbs
/*     */ {
/*     */   private final INT_O.INT_OE<BattleOrderUpdater.PlanData> pathI;
/*     */   private final INT_O.INT_OE<BattleOrderUpdater.PlanData> pathd;
/*     */   private final INT_O.INT_OE<BattleOrderUpdater.PlanData> timer;
/*  20 */   private final VectorImp vec = new VectorImp();
/*     */   
/*     */   public PlanFireDiv(Tools tools, LISTE<BattleOrderUpdater.Plan> all, BattleOrderUpdater.Data data) {
/*  23 */     super(tools, all, data, BattleOrderTask.DIVTASK.ATTACK_RANGED);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 162 */     this.wait = new BattleOrderUpdater.Plan.STATE(this, "wait")
/*     */       {
/*     */         void update(int gameMillis) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         boolean setAction() {
/* 171 */           PlanFireDiv.this.timer.set(PlanFireDiv.m, 0);
/* 172 */           return true;
/*     */         }
/*     */       };
/*     */     
/* 176 */     this.fail = new BattleOrderUpdater.Plan.STATE(this, "fail")
/*     */       {
/*     */         void update(int gameMillis) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         boolean setAction() {
/* 185 */           PlanFireDiv.task.stop(PlanFireDiv.div);
/* 186 */           PlanFireDiv.order.task.set(PlanFireDiv.task);
/* 187 */           return true;
/*     */         }
/*     */       };
/*     */     data.getClass();
/*     */     this.pathI = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataShort(data);
/*     */     data.getClass();
/*     */     this.timer = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataShort(data);
/*     */     data.getClass();
/*     */     this.pathd = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataBit(data);
/*     */   }
/*     */   
/*     */   private final BattleOrderUpdater.Plan.STATE wait;
/*     */   private final BattleOrderUpdater.Plan.STATE fail;
/*     */   
/*     */   void init() {
/*     */     if (checkTarget()) {
/*     */       if (!(div.settings()).shouldNotMoveToFire || BattleTrajectories.trajectories(div) > 0) {
/*     */         this.wait.set();
/*     */       } else {
/*     */         setDest();
/*     */         setWalkToDest();
/*     */       } 
/*     */     } else {
/*     */       this.fail.set();
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean checkTarget() {
/*     */     if (div.settings().ammo() == null)
/*     */       return false; 
/*     */     Div target = task.targetDiv();
/*     */     if (target == null || !target.active()) {
/*     */       this.fail.set();
/*     */       return false;
/*     */     } 
/*     */     return true;
/*     */   }
/*     */   
/*     */   private void setDest() {
/*     */     Div target = task.targetDiv();
/*     */     int sx = div.centre().cUnitX();
/*     */     int sy = div.centre().cUnitY();
/*     */     int dx = target.centre().cUnitX();
/*     */     int dy = target.centre().cUnitY();
/*     */     double nx = 1.0D;
/*     */     double ny = 0.0D;
/*     */     if (sx != dx || sy != dy) {
/*     */       this.vec.set(sx, sy, dx, dy);
/*     */       this.vec.rotate90();
/*     */       nx = this.vec.nX();
/*     */       ny = this.vec.nY();
/*     */     } 
/*     */     int w = (int)Math.sqrt((men * 2));
/*     */     DivFormationImp f = this.t.deployer.deployCentre((DIV_SPEC)div.info, men, (div.settings()).formation, dx, dy, nx, ny, w, a);
/*     */     if (f == null) {
/*     */       this.fail.set();
/*     */       return;
/*     */     } 
/*     */     dest.copy(f);
/*     */     setWalkToDest();
/*     */     this.pathd.set(m, path.currentI() & 0x1);
/*     */   }
/*     */   
/*     */   void update(int gamemillis) {
/*     */     if (!checkTarget()) {
/*     */       this.fail.set();
/*     */       return;
/*     */     } 
/*     */     if (state(m) == this.wait) {
/*     */       if (!(div.settings()).shouldNotMoveToFire)
/*     */         return; 
/*     */       if (BattleTrajectories.trajectories(div) > 0)
/*     */         return; 
/*     */       this.timer.inc(m, gamemillis);
/*     */       if (!BattleTrajectories.hasPotential(div) && this.timer.get(m) > 1000) {
/*     */         setDest();
/*     */         setWalkToDest();
/*     */       } 
/*     */       if (this.timer.get(m) > 5000) {
/*     */         setDest();
/*     */         setWalkToDest();
/*     */       } 
/*     */       return;
/*     */     } 
/*     */     if (div.status().engagements() > 0)
/*     */       return; 
/*     */     if ((path.currentI() & 0x1) != this.pathd.get(m)) {
/*     */       this.pathd.set(m, path.currentI() & 0x1);
/*     */       this.pathI.inc(m, 1);
/*     */       if (this.pathI.get(m) > 5 && BattleTrajectories.hasPotential(div)) {
/*     */         dest.copy(prev);
/*     */         path.clear();
/*     */         order.dest.set(dest);
/*     */         order.path.set(path);
/*     */         this.wait.set();
/*     */         return;
/*     */       } 
/*     */       int tres = 50;
/*     */       if (path.isComplete())
/*     */         tres = CLAMP.i(path.length() - path.currentI(), 1, 50); 
/*     */       if (this.pathI.get(m) > tres)
/*     */         setDest(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   void finished() {
/*     */     this.fail.set();
/*     */   }
/*     */   
/*     */   boolean continueWhenFighting() {
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PlanFireDiv.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */