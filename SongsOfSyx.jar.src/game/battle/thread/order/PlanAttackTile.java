/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.formation.DivPlacability;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.DataOSimple;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ final class PlanAttackTile
/*     */   extends PlanWalkAbs
/*     */ {
/*     */   private final INT_O.INT_OE<BattleOrderUpdater.PlanData> setI;
/*     */   private final BattleOrderUpdater.Plan.STATE wait;
/*  23 */   private final VectorImp vec = new VectorImp();
/*     */   private BattleOrderUpdater.Plan.STATE attack;
/*     */   
/*     */   public PlanAttackTile(Tools tools, LISTE<BattleOrderUpdater.Plan> all, BattleOrderUpdater.Data data) {
/*  27 */     super(tools, all, data, BattleOrderTask.DIVTASK.ATTACK_BUILDING);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  50 */     this.wait = new BattleOrderUpdater.Plan.STATE(this, "wait")
/*     */       {
/*     */         private int destX;
/*     */         private int destY;
/*     */         
/*     */         void update(int gameMillis) {
/*  56 */           if (PlanWalkAbs.amountOfPaths++ > 10)
/*     */             return; 
/*  58 */           int tx = PlanAttackTile.task.targetTileX();
/*  59 */           int ty = PlanAttackTile.task.targetTileY();
/*     */           
/*  61 */           PlanAttackTile.shouldBreak = true;
/*  62 */           if (!PlanAttackTile.this.breakable(tx, ty) || !setStart()) {
/*  63 */             PlanAttackTile.task.stop(PlanAttackTile.div);
/*  64 */             PlanAttackTile.order.task.set(PlanAttackTile.task);
/*     */ 
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */ 
/*     */           
/*  72 */           PathUtilOnline.Flooder f = PlanAttackTile.this.t.pather.getFlooder();
/*  73 */           f.init(this);
/*  74 */           PathTile best = f.pushSloppy(tx, ty, 0.0D);
/*  75 */           double bestDistance = Double.MAX_VALUE;
/*  76 */           f.setValue2(tx, ty, 0.0D);
/*  77 */           while (f.hasMore()) {
/*  78 */             PathTile t = f.pollSmallest();
/*  79 */             double dist = COORDINATE.tileDistance(t.x(), t.y(), this.destX, this.destY);
/*  80 */             if (dist < bestDistance) {
/*  81 */               best = t;
/*  82 */               bestDistance = dist;
/*     */             } 
/*  84 */             if (dist == 0.0D) {
/*     */               break;
/*     */             }
/*     */             
/*  88 */             boolean solid = (PlanAttackTile.this.availability(t.x(), t.y()) <= 0.0D);
/*     */             
/*  90 */             for (int i = 0; i < DIR.ALL.size(); i++) {
/*  91 */               int j = t.x() + ((DIR)DIR.ALL.get(i)).x();
/*  92 */               int k = t.y() + ((DIR)DIR.ALL.get(i)).y();
/*  93 */               double di = COORDINATE.tileDistance(j, k, this.destX, this.destY);
/*  94 */               if (SETT.IN_BOUNDS(j, k))
/*     */               {
/*  96 */                 if (PlanAttackTile.this.availability(j, k) <= 0.0D) {
/*  97 */                   if (solid && PlanAttackTile.this.breakable(j, k)) {
/*  98 */                     double cost = 200.0D;
/*  99 */                     if (f.pushSmaller(j, k, t.getValue2() + cost + di, t) != null) {
/* 100 */                       f.setValue2(j, k, t.getValue2() + cost);
/*     */                     }
/*     */                   }
/*     */                 
/*     */                 }
/* 105 */                 else if (solid) {
/* 106 */                   if (((DIR)DIR.ALL.get(i)).isOrtho())
/*     */                   {
/* 108 */                     if (f.pushSmaller(j, k, t.getValue2() + di, t) != null)
/* 109 */                       f.setValue2(j, k, t.getValue2()); 
/*     */                   }
/* 111 */                 } else if (DivPlacability.checkStep(t.x(), t.y(), j, k, PlanAttackTile.a)) {
/*     */ 
/*     */                   
/* 114 */                   double cost = ((DIR)DIR.ALL.get(i)).tileDistance();
/*     */                   
/* 116 */                   if (f.pushSmaller(j, k, t.getValue2() + cost + di, t) != null) {
/* 117 */                     f.setValue2(j, k, t.getValue2() + cost);
/*     */                   }
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 127 */           f.done();
/*     */           
/* 129 */           if (PlanAttackTile.this.availability(best.x(), best.y()) <= 0.0D || best.getParent() == null) {
/* 130 */             PlanAttackTile.task.stop(PlanAttackTile.div);
/* 131 */             PlanAttackTile.order.task.set(PlanAttackTile.task);
/*     */             
/*     */             return;
/*     */           } 
/* 135 */           while (best.getParent() != null && PlanAttackTile.this.availability(best.getParent().x(), best.getParent().y()) > 0.0D) {
/* 136 */             best = best.getParent();
/*     */           }
/*     */           
/* 139 */           int dx = best.x() * 64 + 32;
/* 140 */           int dy = best.y() * 64 + 32;
/*     */           
/* 142 */           if (best.getParent() == null) {
/* 143 */             DIR d = DIR.get(PlanAttackTile.prev.centrePixel().x(), PlanAttackTile.prev.centrePixel().y(), dx, dy);
/* 144 */             PlanAttackTile.this.vec.set(d.xN(), d.yN());
/* 145 */             PlanAttackTile.this.vec.rotate90();
/*     */           } else {
/*     */             
/* 148 */             PlanAttackTile.this.vec.set(best.x(), best.y(), best.getParent().x(), best.getParent().y());
/* 149 */             PlanAttackTile.this.vec.rotate90();
/*     */           } 
/*     */           
/* 152 */           int rm = PlanAttackTile.men / 3;
/* 153 */           if (rm % 1 == 0) {
/* 154 */             rm++;
/*     */           }
/*     */ 
/*     */           
/* 158 */           DivFormationImp res = PlanAttackTile.this.t.deployer.deployCentre((DIV_SPEC)PlanAttackTile.div.info, PlanAttackTile.men, (PlanAttackTile.div.settings()).formation, dx, dy, PlanAttackTile.this.vec.nX(), PlanAttackTile.this.vec.nY(), rm, PlanAttackTile.a);
/* 159 */           if (res == null || res.deployed() == 0) {
/* 160 */             PlanAttackTile.task.stop(PlanAttackTile.div);
/* 161 */             PlanAttackTile.order.task.set(PlanAttackTile.task);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 179 */           PlanAttackTile.order.dest.set(res);
/* 180 */           PlanAttackTile.this.setWalkToDest();
/*     */         }
/*     */         
/*     */         boolean setStart() {
/* 184 */           boolean useNext = false;
/*     */           
/* 186 */           if (PlanAttackTile.prev.deployed() > 0) {
/*     */             
/* 188 */             int k = 0;
/*     */             
/* 190 */             for (int m = 0; m < PlanAttackTile.prev.deployed() && m < PlanAttackTile.current.deployed(); m++) {
/* 191 */               if (PlanAttackTile.prev.tile(m).tileDistanceTo(PlanAttackTile.current.tile(m)) <= 3.0D) {
/* 192 */                 k++;
/*     */               }
/*     */             } 
/* 195 */             if (k > (PlanAttackTile.prev.deployed() + 1) / 2) {
/* 196 */               useNext = true;
/*     */             }
/*     */           } 
/* 199 */           if (useNext) {
/* 200 */             this.destX = PlanAttackTile.prev.centreTile().x();
/* 201 */             this.destY = PlanAttackTile.prev.centreTile().y();
/* 202 */             return true;
/*     */           } 
/*     */           
/* 205 */           int xx = 0;
/* 206 */           int yy = 0;
/* 207 */           int am = 0;
/* 208 */           for (int i = 0; i < PlanAttackTile.current.deployed(); i++) {
/* 209 */             xx += PlanAttackTile.current.tile(i).x();
/* 210 */             yy += PlanAttackTile.current.tile(i).y();
/* 211 */             am++;
/*     */           } 
/* 213 */           if (am == 0)
/* 214 */             return false; 
/* 215 */           xx /= am;
/* 216 */           yy /= am;
/*     */           
/* 218 */           double bestD = Double.MAX_VALUE;
/* 219 */           int best = 0;
/* 220 */           for (int j = 0; j < PlanAttackTile.current.deployed(); j++) {
/* 221 */             double d = PlanAttackTile.current.tile(j).tileDistanceTo(xx, yy);
/* 222 */             if (d < bestD) {
/* 223 */               bestD = d;
/* 224 */               best = j;
/*     */             } 
/*     */           } 
/*     */           
/* 228 */           this.destX = PlanAttackTile.current.tile(best).x();
/* 229 */           this.destY = PlanAttackTile.current.tile(best).y();
/* 230 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         boolean setAction() {
/* 237 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 271 */     this.attack = new BattleOrderUpdater.Plan.STATE(this, "attack")
/*     */       {
/*     */         void update(int gameMillis)
/*     */         {
/* 275 */           PlanAttackTile.shouldBreak = true;
/* 276 */           int tx = PlanAttackTile.task.targetTileX();
/* 277 */           int ty = PlanAttackTile.task.targetTileY();
/* 278 */           if (!PlanAttackTile.this.breakable(tx, ty)) {
/* 279 */             DIR d = DIR.get(PlanAttackTile.dest.dx(), PlanAttackTile.dest.dy()).next(-2);
/* 280 */             int dx = tx + d.x();
/* 281 */             int dy = ty + d.y();
/*     */             
/* 283 */             if (PlanAttackTile.this.breakable(dx, dy)) {
/* 284 */               PlanAttackTile.task.attack(dx, dy, PlanAttackTile.div);
/* 285 */               PlanAttackTile.order.task.set(PlanAttackTile.task);
/* 286 */               PlanAttackTile.this.setI.set(PlanAttackTile.m, PlanAttackTile.order.task.setI() & 0xFF);
/*     */             } 
/*     */           } 
/*     */           
/* 290 */           for (int i = 0; i < PlanAttackTile.dest.deployed(); i++) {
/* 291 */             if (PlanAttackTile.this.availability(PlanAttackTile.dest.tile(i).x(), PlanAttackTile.dest.tile(i).y()) < 0.0D && (GAME.ARMIES()).map.attackable.is(PlanAttackTile.dest.tile(i), PlanAttackTile.a)) {
/*     */               return;
/*     */             }
/*     */           } 
/*     */           
/* 296 */           PlanAttackTile.this.wait.set();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         boolean setAction() {
/* 303 */           PlanAttackTile.this.vec.set(PlanAttackTile.dest.dx(), PlanAttackTile.dest.dy());
/* 304 */           PlanAttackTile.this.vec.rotate90().rotate90().rotate90();
/* 305 */           int dx = (int)(PlanAttackTile.this.vec.nX() * 36.0D);
/* 306 */           int dy = (int)(PlanAttackTile.this.vec.nY() * 36.0D);
/* 307 */           PlanAttackTile.dest.copy(PlanAttackTile.this.t.deployer.move((DIV_SPEC)PlanAttackTile.div.info, PlanAttackTile.dest, dx, dy, PlanAttackTile.a));
/* 308 */           PlanAttackTile.order.dest.set(PlanAttackTile.dest);
/* 309 */           PlanAttackTile.nextPos = PlanAttackTile.dest;
/* 310 */           return true;
/*     */         }
/*     */       };
/*     */     data.getClass();
/*     */     this.setI = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataByte(data);
/*     */   } boolean continueWhenFighting() {
/* 316 */     return false;
/*     */   }
/*     */   
/*     */   void init() {
/*     */     this.setI.set(m, order.task.setI() & 0xFF);
/*     */     int tx = task.targetTileX();
/*     */     int ty = task.targetTileY();
/*     */     if (!breakable(tx, ty)) {
/*     */       task.stop(div);
/*     */       order.task.set(task);
/*     */       return;
/*     */     } 
/*     */     this.wait.set();
/*     */   }
/*     */   
/*     */   private double availability(int tx, int ty) {
/*     */     AVAILABILITY av = (SETT.PATH()).availability.get(tx, ty);
/*     */     if (a == GAME.ARMIES().player())
/*     */       return av.player; 
/*     */     return av.enemy;
/*     */   }
/*     */   
/*     */   private boolean breakable(int tx, int ty) {
/*     */     return (GAME.ARMIES()).map.attackable.is(tx, ty, a);
/*     */   }
/*     */   
/*     */   void update(int gamemillis) {
/*     */     if (this.setI.get(m) != (order.task.setI() & 0xFF)) {
/*     */       this.setI.set(m, order.task.setI() & 0xFF);
/*     */       this.wait.set();
/*     */     } 
/*     */     state(m).update(gamemillis);
/*     */   }
/*     */   
/*     */   void finished() {
/*     */     this.attack.set();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PlanAttackTile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */