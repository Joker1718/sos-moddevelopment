/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.formation.DivPlacability;
/*     */ import game.battle.formation.DivPositionImp;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.DataOSimple;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ class PlanCharge
/*     */   extends BattleOrderUpdater.Plan
/*     */ {
/*  17 */   private final VectorImp vec = new VectorImp(); private final INT_O.INT_OE<BattleOrderUpdater.PlanData> timer; private final INT_O.INT_OE<BattleOrderUpdater.PlanData> timer2;
/*     */   private BattleOrderUpdater.Plan.STATE wait;
/*     */   private BattleOrderUpdater.Plan.STATE charge;
/*     */   
/*  21 */   public PlanCharge(Tools tools, LISTE<BattleOrderUpdater.Plan> all, BattleOrderUpdater.Data data) { super(tools, all, data, BattleOrderTask.DIVTASK.CHARGE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  34 */     this.wait = new BattleOrderUpdater.Plan.STATE(this, "wait")
/*     */       {
/*     */         void update(int gameMillis)
/*     */         {
/*  38 */           if (PlanCharge.this.t.div.fixIfNeeded(PlanCharge.prev)) {
/*  39 */             PlanCharge.nextPos = PlanCharge.prev;
/*     */           }
/*  41 */           PlanCharge.this.timer2.set(PlanCharge.m, 0);
/*  42 */           PlanCharge.this.timer.set(PlanCharge.m, 0);
/*  43 */           if (PlanCharge.this.inPosition() < (PlanCharge.prev.deployed() - PlanCharge.unreachable) / 2) {
/*     */             return;
/*     */           }
/*  46 */           PlanCharge.this.charge.set();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         boolean setAction() {
/*  54 */           if (PlanCharge.prev.deployed() > 0) {
/*  55 */             PlanCharge.dest.copy(PlanCharge.prev);
/*  56 */             PlanCharge.order.dest.set(PlanCharge.dest);
/*  57 */           } else if (PlanCharge.current.deployed() > 0) {
/*  58 */             int xx = 0;
/*  59 */             int yy = 0;
/*  60 */             for (int i = 0; i < PlanCharge.current.deployed(); i++) {
/*  61 */               xx += PlanCharge.current.tile(i).x();
/*  62 */               yy += PlanCharge.current.tile(i).y();
/*     */             } 
/*     */             
/*  65 */             xx /= PlanCharge.current.deployed();
/*  66 */             yy /= PlanCharge.current.deployed();
/*  67 */             int min = Integer.MAX_VALUE;
/*  68 */             int f = -1;
/*  69 */             for (int j = 0; j < PlanCharge.current.deployed(); j++) {
/*  70 */               int k = Math.abs(PlanCharge.current.tile(j).x() - xx) + Math.abs(PlanCharge.current.tile(j).y() - yy);
/*  71 */               if (k < min) {
/*  72 */                 min = k;
/*  73 */                 f = j;
/*     */               } 
/*     */             } 
/*     */             
/*  77 */             if (f == -1) {
/*  78 */               PlanCharge.task.stop(PlanCharge.div);
/*  79 */               PlanCharge.order.task.set(PlanCharge.task);
/*  80 */               return false;
/*     */             } 
/*     */ 
/*     */             
/*  84 */             DivFormationImp d = PlanCharge.this.t.deployer.deployCentre((DIV_SPEC)PlanCharge.div.info, PlanCharge.current.deployed(), (PlanCharge.div.settings()).formation, PlanCharge.current.pixel(f).x(), PlanCharge.current.pixel(f).y(), 1.0D, 0.0D, 5, PlanCharge.a);
/*  85 */             if (d == null) {
/*  86 */               PlanCharge.task.stop(PlanCharge.div);
/*  87 */               PlanCharge.order.task.set(PlanCharge.task);
/*  88 */               return false;
/*     */             } 
/*  90 */             PlanCharge.dest.copy(d);
/*     */           } 
/*     */           
/*  93 */           return false;
/*     */         }
/*     */       };
/*     */     
/*  97 */     this.charge = new BattleOrderUpdater.Plan.STATE(this, "charge")
/*     */       {
/*     */         
/*     */         void update(int gameMillis)
/*     */         {
/* 102 */           if (PlanCharge.div.status().engagements() > 0) {
/* 103 */             PlanCharge.this.timer.inc(PlanCharge.m, gameMillis);
/* 104 */             if (PlanCharge.this.timer.get(PlanCharge.m) > 2000) {
/* 105 */               PlanCharge.this.stop();
/*     */               return;
/*     */             } 
/*     */           } else {
/* 109 */             PlanCharge.this.timer.set(PlanCharge.m, 0);
/*     */           } 
/*     */           
/* 112 */           PlanCharge.this.timer2.inc(PlanCharge.m, gameMillis);
/*     */           
/* 114 */           if (PlanCharge.this.timer2.get(PlanCharge.m) > 15000 && !PlanCharge.div.army().player()) {
/* 115 */             PlanCharge.this.stop();
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/* 121 */           if (PlanCharge.this.inPosition() == 0) {
/*     */             return;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 128 */           PlanCharge.this.vec.set(PlanCharge.prev.dx(), PlanCharge.prev.dy());
/* 129 */           PlanCharge.this.vec.rotate90().rotate90().rotate90();
/* 130 */           int sx = (int)(PlanCharge.prev.start().x() + PlanCharge.this.vec.nX() * 64.0D);
/* 131 */           int sy = (int)(PlanCharge.prev.start().y() + PlanCharge.this.vec.nY() * 64.0D);
/*     */           
/* 133 */           if (!SETT.PIXEL_IN_BOUNDS(sx, sy) || !SETT.PIXEL_IN_BOUNDS((int)(sx + PlanCharge.prev.dx() * PlanCharge.prev.width()), (int)(sy + PlanCharge.prev.dy() * PlanCharge.prev.width()))) {
/* 134 */             PlanCharge.task.stop(PlanCharge.div);
/* 135 */             PlanCharge.order.task.set(PlanCharge.task);
/*     */             
/*     */             return;
/*     */           } 
/* 139 */           PlanCharge.this.vec.set(PlanCharge.prev.dx(), PlanCharge.prev.dy());
/*     */           
/* 141 */           DivFormationImp f = PlanCharge.this.t.deployer.deploy((DIV_SPEC)PlanCharge.div.info, PlanCharge.men, (PlanCharge.div.settings()).formation, sx, sy, PlanCharge.prev.dx(), PlanCharge.prev.dy(), PlanCharge.prev.width(), PlanCharge.a);
/* 142 */           if (f != null && f.deployed() > 0) {
/*     */             
/* 144 */             PlanCharge.prev.copy(PlanCharge.this.t.mover.getFromMovedIntoTo((DivPositionImp)PlanCharge.prev, f));
/*     */             
/* 146 */             PlanCharge.nextPos = PlanCharge.prev;
/*     */             
/*     */             return;
/*     */           } 
/* 150 */           double largestGap = -1.0D;
/* 151 */           int largestI1 = -1;
/*     */           
/* 153 */           int size = (PlanCharge.div.settings()).formation.size(PlanCharge.div);
/*     */           
/* 155 */           for (int d = 0; d <= PlanCharge.prev.width(); d += size) {
/* 156 */             int x1 = (int)(sx + d * PlanCharge.this.vec.nX()) + size / 2;
/* 157 */             int y1 = (int)(sy + d * PlanCharge.this.vec.nY()) + size / 2;
/*     */             
/* 159 */             if (!DivPlacability.pixelIsBlocked(x1, y1, size, PlanCharge.a)) {
/* 160 */               int am = 1;
/* 161 */               int di = d;
/* 162 */               while (d <= PlanCharge.prev.width()) {
/* 163 */                 int x = (int)(sx + d * PlanCharge.this.vec.nX());
/* 164 */                 int y = (int)(sy + d * PlanCharge.this.vec.nY());
/* 165 */                 if (!DivPlacability.pixelIsBlocked(x, y, size, PlanCharge.a)) {
/* 166 */                   am++;
/* 167 */                   d += size;
/*     */                 } 
/*     */                 break;
/*     */               } 
/* 171 */               if (am > largestGap) {
/* 172 */                 largestGap = am;
/* 173 */                 largestI1 = di;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 179 */           if (largestI1 == -1) {
/* 180 */             PlanCharge.this.stop();
/*     */             return;
/*     */           } 
/* 183 */           int cx = (int)(sx + largestI1 * PlanCharge.this.vec.nX());
/* 184 */           int cy = (int)(sy + largestI1 * PlanCharge.this.vec.nY());
/*     */           
/* 186 */           f = PlanCharge.this.t.deployer.deploy((DIV_SPEC)PlanCharge.div.info, PlanCharge.men, (PlanCharge.div.settings()).formation, cx, cy, PlanCharge.prev.dx(), PlanCharge.prev.dy(), (int)(largestGap * (PlanCharge.div.settings()).formation.size(PlanCharge.div)), PlanCharge.a);
/*     */           
/* 188 */           if (f != null && f.deployed() > 0) {
/* 189 */             PlanCharge.prev.copy(PlanCharge.this.t.mover.getFromMovedIntoTo((DivPositionImp)PlanCharge.prev, f));
/*     */           } else {
/*     */             
/* 192 */             PlanCharge.this.stop();
/*     */             return;
/*     */           } 
/*     */         }
/*     */         
/*     */         boolean setAction()
/*     */         {
/* 199 */           return false; }
/*     */       };
/*     */     data.getClass();
/*     */     this.timer = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataInt(data);
/*     */     data.getClass();
/*     */     this.timer2 = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataInt(data); }
/*     */    private void stop() {
/* 206 */     task.stop(div);
/* 207 */     order.task.set(task);
/*     */   } void init() {
/*     */     this.wait.set();
/*     */   } private int inPosition() {
/* 211 */     int am = 0;
/* 212 */     for (int i = 0; i < current.deployed() && i < prev.deployed(); i++) {
/*     */       
/* 214 */       if (current.pixel(i).tileDistanceTo(prev.pixel(i)) < 192.0D) {
/* 215 */         am++;
/*     */       }
/*     */     } 
/* 218 */     return am;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void update(int gamemillis) {
/* 225 */     charging = true;
/* 226 */     state(m).update(gamemillis);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean continueWhenFighting() {
/* 233 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PlanCharge.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */