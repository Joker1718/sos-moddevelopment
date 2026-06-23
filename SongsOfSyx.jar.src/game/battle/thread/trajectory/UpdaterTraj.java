/*     */ package game.battle.thread.trajectory;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivPosition;
/*     */ import game.battle.formation.FormationBody;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.thread.status.BattleStatus;
/*     */ import game.battle.util.Copyable;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.equip.EquipRange;
/*     */ import settlement.thing.projectiles.SProjectiles;
/*     */ import settlement.thing.projectiles.Trajectory;
/*     */ import snake2d.util.datatypes.VECTOR;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LISTE;
/*     */ 
/*     */ final class UpdaterTraj {
/*  18 */   private final DivTrajectory[] all = new DivTrajectory[(Config.battle()).DIVISIONS_PER_BATTLE]; private final BattleOrderTask task; private final Trajectory trajLow; private final VectorImp vec1;
/*     */   UpdaterTraj() {
/*  20 */     for (int i = 0; i < this.all.length; i++) {
/*  21 */       this.all[i] = new DivTrajectory();
/*     */     }
/*     */     
/*  24 */     this.task = new BattleOrderTask();
/*  25 */     this.trajLow = new Trajectory();
/*  26 */     this.vec1 = new VectorImp();
/*  27 */     this.vec2 = new VectorImp();
/*  28 */     this.bodyArcher = new FormationBody();
/*  29 */     this.bodyTarget = new FormationBody();
/*  30 */     this.targets = new ArrayList(16);
/*     */   }
/*     */   private final VectorImp vec2; private final FormationBody bodyArcher; private final FormationBody bodyTarget; private final ArrayList<Div> targets;
/*     */   public DivTrajectory update(Request req, Div div, DivTrajectory old) {
/*  34 */     DivTrajectory traj = this.all[div.index()];
/*  35 */     traj.clear();
/*     */     
/*  37 */     EquipRange ammo = div.settings().ammo();
/*     */     
/*  39 */     if (div.active() && ammo != null) {
/*     */       
/*  41 */       (div.order()).task.get((Copyable)this.task);
/*  42 */       if (this.task.task() == BattleOrderTask.DIVTASK.ATTACK_RANGED) {
/*  43 */         setTrajectory(req, div, this.task.targetDiv(), traj);
/*     */       }
/*  45 */       else if (div.settings().fireAtWill()) {
/*  46 */         this.targets.clear();
/*  47 */         div.status().enemiesClosest((LISTE)this.targets);
/*  48 */         for (Div d : this.targets) {
/*  49 */           if (setTrajectory(req, div, d, traj)) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  57 */     this.all[div.index()] = old;
/*     */     
/*  59 */     return traj;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean setTrajectory(Request req, Div div, Div target, DivTrajectory traj) {
/*  65 */     if (target == null || !target.active()) {
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (!this.bodyTarget.init((DivPosition)target.current())) {
/*  70 */       return false;
/*     */     }
/*  72 */     if (SProjectiles.problem(this.trajLow, div, this.bodyTarget.cX(), this.bodyTarget.cY()) == SProjectiles.¤¤OUT_OF_RANGE) {
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     if (!this.bodyArcher.init((DivPosition)div.current())) {
/*  77 */       return false;
/*     */     }
/*  79 */     EquipRange a = div.settings().ammo();
/*  80 */     if (a == null || a != req.ammo()) {
/*  81 */       return false;
/*     */     }
/*  83 */     traj.potential = true;
/*     */     
/*  85 */     boolean hasCounters = false;
/*     */ 
/*     */     
/*  88 */     for (int ui = 0; ui < div.menNrOf(); ui++) {
/*     */       
/*  90 */       int i = ui;
/*     */       
/*  92 */       if (!req.count(i)) {
/*  93 */         hasCounters = true;
/*     */       }
/*     */       else {
/*     */         
/*  97 */         float ref = req.ref(i);
/*  98 */         if (ref >= 0.0F) {
/*     */ 
/*     */           
/* 101 */           double angle = a.projectile.maxAngle(ref);
/* 102 */           double vel = a.projectile.velocity(ref);
/*     */           
/* 104 */           int startX = req.x(i);
/* 105 */           int startY = req.y(i);
/*     */           
/* 107 */           double ddx = (startX - this.bodyArcher.x1());
/* 108 */           ddx /= this.bodyArcher.width();
/*     */           
/* 110 */           double ddy = (startY - this.bodyArcher.y1());
/* 111 */           ddy /= this.bodyArcher.height();
/*     */           
/* 113 */           int targetX = (int)(this.bodyTarget.x1() + ddx * this.bodyTarget.width());
/* 114 */           int targetY = (int)(this.bodyTarget.y1() + ddy * this.bodyTarget.height());
/*     */           
/* 116 */           this.vec1.set(startX, startY, targetX, targetY);
/*     */           
/* 118 */           this.vec2.set((VECTOR)this.vec1);
/* 119 */           this.vec2.rotate90();
/*     */           
/*     */           int vv1;
/* 122 */           for (vv1 = 0; vv1 > -5; vv1--) {
/*     */             
/* 124 */             int dx = (int)(targetX + this.vec1.nX() * 64.0D);
/* 125 */             int dy = (int)(targetY + this.vec1.nY() * 64.0D);
/* 126 */             if (isEnemy(div, dx, dy) && SProjectiles.problem(div.army(), this.trajLow, startX, startY, dx, dy, angle, vel) == null) {
/* 127 */               traj.set(i, this.trajLow);
/*     */ 
/*     */               
/*     */               break label61;
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 135 */           label61: for (vv1 = 1; vv1 <= 10; vv1++) {
/* 136 */             double v1 = (vv1 / 2 * (((vv1 & 0x1) == 1) ? 1 : -1));
/* 137 */             for (int vv2 = 1; vv2 <= 10; vv2++) {
/* 138 */               double v2 = (vv2 / 2 * (((vv2 & 0x1) == 1) ? 1 : -1));
/*     */               
/* 140 */               int dx = (int)(targetX + (this.vec1.nX() * v1 + this.vec2.nX() * v2) * 64.0D);
/* 141 */               int dy = (int)(targetY + (this.vec1.nY() * v1 + this.vec2.nY() * v2) * 64.0D);
/* 142 */               if (isEnemy(div, dx, dy) && SProjectiles.problem(div.army(), this.trajLow, startX, startY, dx, dy, angle, vel) == null) {
/* 143 */                 traj.set(i, this.trajLow);
/*     */                 
/*     */                 break label61;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 153 */     if (traj.targets > 0 || hasCounters)
/* 154 */       return true; 
/* 155 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isEnemy(Div div, int x, int y) {
/* 162 */     int tx = x >> 6;
/* 163 */     int ty = y >> 6;
/* 164 */     if (SETT.IN_BOUNDS(tx, ty) && 
/* 165 */       (BattleStatus.map()).hasEnemy.is(tx, ty, div.army())) {
/* 166 */       return true;
/*     */     }
/* 168 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\trajectory\UpdaterTraj.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */