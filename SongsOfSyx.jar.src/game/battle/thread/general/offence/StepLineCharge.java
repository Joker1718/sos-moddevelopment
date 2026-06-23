/*     */ package game.battle.thread.general.offence;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormation;
/*     */ import game.battle.formation.DivPlacability;
/*     */ import game.battle.thread.general.StrategosUtil;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.thread.status.BattleStatus;
/*     */ import game.battle.thread.trajectory.BattleTrajectories;
/*     */ import game.battle.util.Copyable;
/*     */ import init.constant.Config;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ 
/*     */ 
/*     */ class StepLineCharge
/*     */ {
/*     */   private final Context context;
/*     */   private final StrategosUtil util;
/*     */   private final Bitmap2D blob;
/*     */   private final Bitmap2D block;
/*     */   private final DOUBLE.DOUBLE_MUTABLE chargeReady;
/*     */   private final INT.INTE divI;
/*  31 */   private final BattleOrderTask task = new BattleOrderTask();
/*  32 */   private final VectorImp vec = new VectorImp();
/*     */   
/*     */   public StepLineCharge(StrategosUtil context, Context c) {
/*  35 */     this.util = context;
/*     */     
/*  37 */     this.blob = c.blob;
/*  38 */     this.context = c;
/*  39 */     this.block = c.block;
/*  40 */     this.chargeReady = (DOUBLE.DOUBLE_MUTABLE)c.value;
/*  41 */     this.divI = (INT.INTE)c.checkI;
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/*  46 */     this.divI.set(0);
/*  47 */     increaseBlob();
/*  48 */     markFighting();
/*     */     
/*  50 */     double tot = 0.0D;
/*  51 */     double ready = 0.0D;
/*  52 */     for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/*  53 */       Div d = (Div)this.util.getArmy().divisions().get(di);
/*  54 */       if (this.context.deployedToLine.get(di)) {
/*  55 */         if (d.settings().ammo() == null || BattleTrajectories.trajectories(d) <= d.men() / 2) {
/*     */           
/*  57 */           tot++;
/*  58 */           (d.order()).task.get((Copyable)this.task);
/*  59 */           if (valid(d))
/*  60 */             ready++; 
/*     */         } 
/*     */       } else {
/*  63 */         (d.order()).task.get((Copyable)this.task);
/*     */         
/*  65 */         if (this.task.task() == BattleOrderTask.DIVTASK.CHARGE) {
/*  66 */           this.context.deployedToLine.set(di, true);
/*     */         }
/*     */       } 
/*     */     } 
/*  70 */     if (tot > 0.0D) {
/*  71 */       ready /= tot;
/*     */     }
/*  73 */     this.chargeReady.setD(ready);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean charge() {
/*  78 */     if (this.chargeReady.getD() == 0.0D)
/*  79 */       return false; 
/*  80 */     while (this.divI.get() < (Config.battle()).DIVISIONS_PER_ARMY) {
/*  81 */       Div d = (Div)this.util.getArmy().divisions().get(this.divI.get());
/*  82 */       this.divI.inc(1);
/*  83 */       if (!v(d)) {
/*     */         continue;
/*     */       }
/*  86 */       if (isCharger(d)) {
/*     */         
/*  88 */         if (!canCharge(d)) {
/*  89 */           this.task.stop(d);
/*  90 */           this.context.deployedToLine.set(d.indexArmy(), false);
/*  91 */           (d.order()).task.set((Copyable)this.task);
/*     */         } else {
/*  93 */           this.context.deployedToLine.set(d.indexArmy(), true);
/*     */         } 
/*  95 */         return true;
/*  96 */       }  if (this.chargeReady.getD() > 0.75D || this.block.is(d.centre().ctX(), d.centre().ctY())) {
/*  97 */         if (canCharge(d)) {
/*  98 */           this.context.deployedToLine.set(d.indexArmy(), true);
/*  99 */           this.task.charge(d);
/* 100 */           (d.order()).task.set((Copyable)this.task);
/*     */         } 
/* 102 */         return true;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 107 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void increaseBlob() {
/* 113 */     PathUtilOnline.Flooder f = this.util.flooder.getFlooder();
/* 114 */     f.init(this);
/* 115 */     for (int ty = 0; ty < SETT.THEIGHT; ty++) {
/* 116 */       for (int tx = 0; tx < SETT.TWIDTH; tx++) {
/* 117 */         if (this.blob.is(tx, ty)) {
/* 118 */           f.pushSloppy(tx, ty, 0.0D);
/*     */         }
/*     */       } 
/*     */     } 
/* 122 */     while (f.hasMore()) {
/* 123 */       PathTile t = f.pollSmallest();
/* 124 */       if (t.getValue() >= 5.0F) {
/*     */         break;
/*     */       }
/* 127 */       this.blob.set((COORDINATE)t, true);
/*     */       
/* 129 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 130 */         DIR d = (DIR)DIR.ALL.get(di);
/* 131 */         int dx = t.x() + d.x();
/* 132 */         int dy = t.y() + d.y();
/* 133 */         if (SETT.IN_BOUNDS(dx, dy))
/*     */         {
/* 135 */           f.pushSmaller(dx, dy, d.tileDistance() + t.getValue(), t);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 140 */     f.done();
/*     */   }
/*     */   
/*     */   private void markFighting() {
/* 144 */     this.block.clear();
/* 145 */     PathUtilOnline.Flooder f = this.util.flooder.getFlooder();
/* 146 */     f.init(this);
/* 147 */     for (int ty = 0; ty < SETT.THEIGHT; ty++) {
/* 148 */       for (int tx = 0; tx < SETT.TWIDTH; tx++) {
/* 149 */         if (this.blob.is(tx, ty) && (BattleStatus.map()).hasAlly.is(tx, ty, this.util.getArmy()) && (BattleStatus.map()).hasEnemy.is(tx, ty, this.util.getArmy())) {
/* 150 */           f.pushSloppy(tx, ty, 0.0D);
/*     */         }
/*     */       } 
/*     */     } 
/* 154 */     while (f.hasMore()) {
/* 155 */       PathTile t = f.pollSmallest();
/* 156 */       if (t.getValue() >= 64.0F) {
/*     */         break;
/*     */       }
/* 159 */       this.block.set((COORDINATE)t, true);
/*     */       
/* 161 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 162 */         DIR d = (DIR)DIR.ALL.get(di);
/* 163 */         int dx = t.x() + d.x();
/* 164 */         int dy = t.y() + d.y();
/* 165 */         if (SETT.IN_BOUNDS(dx, dy))
/*     */         {
/* 167 */           f.pushSmaller(dx, dy, d.tileDistance() + t.getValue(), t);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 172 */     f.done();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean v(Div d) {
/* 177 */     if (!d.active()) {
/* 178 */       return false;
/*     */     }
/* 180 */     if (d.status().engagements() > d.menNrOf() / 20) {
/* 181 */       return false;
/*     */     }
/* 183 */     if ((d.settings()).fireAtWill && d.settings().ammo() != null && BattleTrajectories.trajectories(d) > d.men() / 2) {
/* 184 */       return false;
/*     */     }
/* 186 */     DivFormation f = d.position();
/*     */     
/* 188 */     int cx = (int)(f.start().x() + f.dx() * f.width() / 2.0D) / 64;
/* 189 */     int cy = (int)(f.start().y() + f.dy() * f.width() / 2.0D) / 64;
/*     */     
/* 191 */     if (!this.blob.is(cx, cy)) {
/* 192 */       return false;
/*     */     }
/* 194 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean valid(Div d) {
/* 200 */     if (!v(d))
/* 201 */       return false; 
/* 202 */     (d.order()).task.get((Copyable)this.task);
/*     */     
/* 204 */     if (this.task.task() != BattleOrderTask.DIVTASK.STOP) {
/* 205 */       return false;
/*     */     }
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isCharger(Div d) {
/* 213 */     if (!v(d)) {
/* 214 */       return false;
/*     */     }
/* 216 */     (d.order()).task.get((Copyable)this.task);
/*     */     
/* 218 */     if (this.task.task() != BattleOrderTask.DIVTASK.CHARGE) {
/* 219 */       return false;
/*     */     }
/* 221 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean canCharge(Div div) {
/* 228 */     DivFormation f = div.position();
/* 229 */     double l = f.width();
/* 230 */     double rx = f.dx();
/* 231 */     double ry = f.dy();
/*     */     
/* 233 */     int sx1 = f.start().x();
/* 234 */     int sy1 = f.start().y();
/*     */     
/* 236 */     int friends = 0;
/* 237 */     int enemies = 0;
/*     */     
/* 239 */     this.vec.set(rx, ry);
/* 240 */     this.vec.rotate90().rotate90().rotate90();
/*     */     
/* 242 */     for (int w = 0; w <= l; w += 64) {
/* 243 */       int sx = (int)(sx1 + rx * w);
/* 244 */       int sy = (int)(sy1 + ry * w);
/* 245 */       for (int i = 64; i < 2048; i++) {
/*     */ 
/*     */ 
/*     */         
/* 249 */         int x = (int)(sx + this.vec.nX() * i) / 64;
/* 250 */         int y = (int)(sy + this.vec.nY() * i) / 64;
/*     */         
/* 252 */         if (!DivPlacability.tileIsOK(x, y, this.util.getArmy())) {
/* 253 */           return false;
/*     */         }
/* 255 */         friends += BattleStatus.map().soldiers(this.util.getArmy()).get(x, y);
/* 256 */         if ((BattleStatus.map()).hasEnemy.is(x, y, this.util.getArmy())) {
/* 257 */           enemies++;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 263 */     int rows = (int)(l / 64.0D);
/* 264 */     if (rows == 0)
/* 265 */       return (enemies > 0); 
/* 266 */     return (enemies > rows / 2 && friends / rows < 5);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\StepLineCharge.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */