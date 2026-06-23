/*     */ package game.battle.thread.general.offence;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DIV_FORMATION;
/*     */ import game.battle.thread.general.StrategosUtil;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.thread.status.BattleStatus;
/*     */ import game.battle.util.Copyable;
/*     */ import init.constant.Config;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class StepAttackEnemyNear
/*     */ {
/*     */   private final StrategosUtil util;
/*     */   private final Context context;
/*     */   private int[] attacked;
/*     */   
/*     */   public StepAttackEnemyNear(StrategosUtil context, Context c) {
/*  32 */     this.attacked = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     this.task = new BattleOrderTask();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 146 */     this.counts = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY); this.util = context; this.context = c;
/*     */   } private final BattleOrderTask task; private int[] counts; public boolean attackEnemies() { this.context.map.clear(); boolean has = false; for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) { Div d = (Div)this.util.getArmy().divisions().get(di); if (d.active() && !this.context.deployedToLine.get(di)) { (d.order()).task.get((Copyable)this.task); if (this.task.task() != BattleOrderTask.DIVTASK.CHARGE) if (d.status().engagements() > Math.sqrt(d.menNrOf()) * 0.5D) { react(d); } else { this.context.map.add(d); has = true; }   }  }  if (!has) return false;  PathUtilOnline.Flooder f = this.util.flooder.getFlooder(); f.init(this); Arrays.fill(this.attacked, 0); for (int i = 0; i < (Config.battle()).DIVISIONS_PER_ARMY; i++) { Div d = (Div)this.util.getArmy().enemy().divisions().get(i); if (d.active()) { int tx = d.centre().ctX(); int ty = d.centre().ctY(); if (SETT.IN_BOUNDS(tx, ty)) { f.pushSloppy(tx, ty, 0.0D); f.setValue2(tx, ty, d.indexArmy()); }  }  }  while (f.hasMore()) { PathTile t = f.pollSmallest(); if (!this.context.blob.is((COORDINATE)t)) continue;  Div enemy = (Div)this.util.getArmy().enemy().divisions().get((int)t.getValue2()); if (this.attacked[enemy.indexArmy()] >= enemy.menNrOf() * 4) continue;  if (t.getValue() > 48.0F)
/*     */         break;  for (Div d : this.context.map.get(t.x(), t.y()))
/*     */         attack(enemy, d);  for (int j = 0; j < DIR.ALL.size(); j++) { DIR dir = (DIR)DIR.ALL.get(j); int dx = t.x() + dir.x(); int dy = t.y() + dir.y(); if (SETT.IN_BOUNDS(dx, dy)) { double cost = cost(this.util, dx, dy) * (1 + this.attacked[enemy.indexArmy()] / (1 + enemy.menNrOf())); if (cost > 0.0D) { if (!dir.isOrtho()) { cost = Math.max(cost, cost(this.util, dx, t.y())); cost = Math.max(cost, cost(this.util, t.x(), dy)); }  if (f.pushSmaller(dx, dy, t.getValue() + dir.tileDistance() * cost, t) != null)
/* 150 */               f.setValue2(dx, dy, t.getValue2());  }  }  }  }  f.done(); return false; } private void react(Div d) { Arrays.fill(this.counts, 0);
/*     */     
/* 152 */     Div ee = null;
/* 153 */     int max = 0;
/* 154 */     int tot = 0;
/*     */     
/* 156 */     this.context.deployedToLine.set(d.indexArmy(), true);
/*     */     
/* 158 */     for (int i = 0; i < d.current().deployed(); i++) {
/* 159 */       int tx = d.current().tx(i);
/* 160 */       int ty = d.current().ty(i);
/* 161 */       Div e = BattleStatus.map().getEnemySingle(tx, ty, this.util.getArmy());
/* 162 */       if (e != null) {
/* 163 */         this.counts[e.indexArmy()] = this.counts[e.indexArmy()] + 1;
/* 164 */         max++;
/* 165 */         if (ee == null || this.counts[e.indexArmy()] > max) {
/* 166 */           ee = e;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 172 */     if (ee != null && this.counts[ee.index()] > tot / 2) {
/* 173 */       (d.settings()).guard = false;
/* 174 */       (d.settings()).formation = DIV_FORMATION.TIGHT;
/* 175 */       attack(ee, d);
/*     */     } else {
/* 177 */       (d.settings()).guard = true;
/* 178 */       (d.settings()).formation = DIV_FORMATION.TIGHT;
/* 179 */       this.task.stop(d);
/* 180 */       (d.order()).task.set((Copyable)this.task);
/*     */     }  } public static double cost(StrategosUtil context, int dx, int dy) { AVAILABILITY a = (SETT.PATH()).availability.get(dx, dy);
/*     */     if (a.isSolid(context.getArmy()) || SETT.TERRAIN().get(dx, dy) instanceof settlement.tilemap.terrain.TFortification.Tile)
/*     */       return 3.0D + (GAME.ARMIES()).map.strength.get(dx, dy) / 640.0D; 
/*     */     double res = 1.0D;
/*     */     double s = (SETT.ENV()).map.SPACE.get(dx, dy);
/*     */     if (s < 0.5D)
/*     */       return res + 2.0D + a.movementSpeedI; 
/*     */     return res + a.movementSpeedI; }
/* 189 */   private void attack(Div d, Div mDiv) { if (mDiv.settings().ammo() != null) {
/* 190 */       this.task.attackRanged(d, mDiv);
/*     */     } else {
/* 192 */       this.task.attackMelee(d, mDiv);
/*     */     } 
/* 194 */     (mDiv.order()).task.set((Copyable)this.task);
/* 195 */     this.context.deployedToLine.set(mDiv.indexArmy(), true);
/* 196 */     this.attacked[d.indexArmy()] = this.attacked[d.indexArmy()] + d.menNrOf();
/* 197 */     (mDiv.settings()).formation = (d.settings().ammo() == null) ? DIV_FORMATION.TIGHT : DIV_FORMATION.LOOSE; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\StepAttackEnemyNear.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */